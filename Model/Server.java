package Model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable{
    private final BlockingQueue<Client> clients;
    private final AtomicInteger waitingPeriod;
    private final int numberServer;
    public Server(int numberServer, int maxClientsPerServer) {
        this.clients = new ArrayBlockingQueue<Client>(maxClientsPerServer);
        this.waitingPeriod = new AtomicInteger(0);
        this.numberServer = numberServer;
    }
    public void addTask(Client newClient)
    {
        clients.add(newClient);
        waitingPeriod.addAndGet(newClient.getServiceTime());
    }

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }

    public int getNumberServer() {
        return numberServer;
    }
    public void run() {
        while(true){
            while(clients.peek()!= null)
            {
                Client t = clients.peek();
                int serviceTime = t.getServiceTime();
                try {
                    if(serviceTime >= 0) {
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                serviceTime--;
                t.setServiceTime(serviceTime);
                if(serviceTime == 0){
                    clients.remove(t);
                }
                else{
                    waitingPeriod.set(waitingPeriod.intValue()-1);
                }
            }
        }
    }
    public String toString()
    {
        String result = "\n Queue " + getNumberServer()+ ": ";
        if(getWaitingPeriod().equals(0) || clients.peek() == null )
        {
            result += "closed";
        }
        else
        {
            result += clients.toString();
        }
        return result;
    }

}

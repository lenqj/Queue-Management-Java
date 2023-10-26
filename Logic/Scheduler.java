package Logic;

import Model.Client;
import Model.Server;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private final List<Server> servers;
    private Strategy strategy;
    public Scheduler(int maxNoServers, int maxTasksPerServer) {
        this.servers = new ArrayList<Server>(maxNoServers);
        ArrayList<Thread> threads = new ArrayList<Thread>(maxNoServers);
        for (int i = 0; i < maxNoServers; i++) {
            servers.add(new Server(i+1, maxTasksPerServer));
            threads.add(new Thread(servers.get(i)));
            threads.get(i).start();
        }
    }
    public  void changeStrategy(SelectionPolicy policy){
        if(policy == SelectionPolicy.SHORTEST_QUEUE){
            strategy = new StrategyQueue();
        }
        if(policy == SelectionPolicy.SHORTEST_TIME){
            strategy = new StrategyTime();
        }
    }

    public void dispatchTask(Client t){
        strategy.addTask(servers, t);
    }
    public String toString()
    {
        String result = "";
        for(Server s: servers)
            result += s.toString();
        return result;
    }

}

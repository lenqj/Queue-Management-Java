package Logic;

import GUI.View;
import Model.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class SimulationManager  implements Runnable {
    public static int numberOfClients;
    public static int numberOfServers;
    public static int timeLimit;
    public static int minArrivalTime;
    public static int maxArrivalTime;
    public static int minServiceTime;
    public static int maxServiceTime;
    private static Scheduler scheduler;
    public static List<Client> clients;
    public File file;
    public FileWriter writer;
    public SimulationManager(int numberOfClients, int numberOfServers, int timeLimit, int minArrivalTime, int maxArrivalTime, int minServiceTime, int maxServiceTime){
        SimulationManager.numberOfClients = numberOfClients;
        SimulationManager.numberOfServers = numberOfServers;
        SimulationManager.timeLimit = timeLimit;
        SimulationManager.minArrivalTime = minArrivalTime;
        SimulationManager.maxArrivalTime = maxArrivalTime;
        SimulationManager.minServiceTime = minServiceTime;
        SimulationManager.maxServiceTime = maxServiceTime;
        SimulationManager.scheduler = new Scheduler(numberOfServers, numberOfClients);
        generateClients(minArrivalTime, maxArrivalTime, minServiceTime, maxServiceTime);
        createFile();
    }
    public static int generateRandomNumbers(int low, int high) {
        return ((int)(Math.random()*(high-low+1))+low);
    }
    public static void generateClients(int minArrivalTime, int maxArrivalTime, int minServiceTime, int maxServiceTime) {
        clients = new ArrayList<>(numberOfClients);
        for (int i = 0; i < numberOfClients; i++) {
            Client t = new Client(i+1, generateRandomNumbers(minArrivalTime, maxArrivalTime), generateRandomNumbers(minServiceTime, maxServiceTime));
            clients.add(t);
        }
        Collections.sort(clients);
    }
    public void run() {
        int currentTime = 0;
        try {
            writer = new FileWriter(file.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (currentTime <= timeLimit ) {
            while (!clients.isEmpty() && clients.get(0).getArrivalTime() == currentTime) {
                scheduler.dispatchTask(clients.get(0));
                clients.remove(clients.get(0));
            }
            String result = "\n" + toString(currentTime);
            System.out.print(result);
            View.mainPanel.setResultTextArea(result);
            try {
                if (writer != null) {
                    writer.write(result);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            currentTime++;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        closeFile();
    }
    public void createFile(){
        file = new File("output.txt");
        try {
            file.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void closeFile(){
        try {
            this.writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void setStrategy(SelectionPolicy policy)
    {
        scheduler.changeStrategy(policy);
    }
    public String toString(int currentTime)
    {
        String result ="Time: "+ currentTime + "\n";
        result = result + "Waiting clients: ";
        for (Client t : clients) {
            result = result+t.toString();
        }
        result = result + scheduler.toString();
        return result;
    }
    public static void main(String[] args)
    {
        View view = new View();
        view.setVisible(true);
    }
}
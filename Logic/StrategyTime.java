package Logic;

import Model.Client;
import Model.Server;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class StrategyTime implements Strategy {
    public void addTask(List<Server> servers, Client t) {
        AtomicInteger minTime = new AtomicInteger(9999999);
        int saveIndex = 0;
        for(Server s: servers)
        {
            if(s.getWaitingPeriod().get() < minTime.get()){
                minTime = s.getWaitingPeriod();
                saveIndex = s.getNumberServer();
            }
        }
        for(Server s: servers){
            if(s.getNumberServer() == saveIndex) {
                s.addTask(t);
            }
        }
    }
}

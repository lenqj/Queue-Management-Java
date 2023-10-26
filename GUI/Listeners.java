package GUI;
import Logic.SelectionPolicy;
import Logic.SimulationManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listeners {
    static SimulationManager sim;
    static Thread t;
    public static class StartButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            View.checkPanel.setVisibleCheckPanel(true);
            View.checkPanel.setTitle("Select Strategy");
            int numberOfClients = View.mainPanel.getNumberOfClientsTextField();
            int numberOfServers = View.mainPanel.getNumberOfServersTextField();
            int timeLimit = View.mainPanel.getSimulationTimeTextField();
            int minArrivalTime = View.mainPanel.getMinArrivalTimeTextField();
            int maxArrivalTime = View.mainPanel.getMaxArrivalTimeTextField();
            int minServiceTime = View.mainPanel.getMinServiceTimeTextField();
            int maxServiceTime = View.mainPanel.getMaxServiceTimeTextField();
            sim = new SimulationManager(numberOfClients, numberOfServers, timeLimit, minArrivalTime, maxArrivalTime, minServiceTime, maxServiceTime);
            t = new Thread(sim);
        }
    }
    static class StopButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            t.stop();
        }
    }
    public static class FirstStrategyCheckBoxListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            View.checkPanel.setVisibleCheckPanel(false);
            View.checkPanel.clearFirstStrategyCheckBox();
            View.mainPanel.clearResultTextArea();
            sim.setStrategy(SelectionPolicy.SHORTEST_TIME);
            t.start();
        }
    }
    public static class SecondStrategyCheckBoxListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            View.checkPanel.setVisibleCheckPanel(false);
            View.checkPanel.clearSecondStrategyCheckBox();
            sim.setStrategy(SelectionPolicy.SHORTEST_QUEUE);
            t.start();
        }
    }
}

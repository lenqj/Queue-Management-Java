package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MainPanel extends JPanel {
    JTextField numberOfClientsTextField;
    JTextField numberOfServersTextField;
    JTextField simulationTimeTextField;
    JTextField minArrivalTimeTextField;
    JTextField maxArrivalTimeTextField;
    JTextField minServiceTimeTextField;
    JTextField maxServiceTimeTextField;

    JButton start;
    JButton stop;

    JTextArea resultTextArea;

    public MainPanel() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
        contentPanel.setBorder(new EmptyBorder(20, 0, 20, 0));
        contentPanel.add(topPanel());
        contentPanel.add(new JPanel());
        contentPanel.add(new JPanel());
        add(contentPanel);
    }
    public JPanel topPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));

        JPanel leftPanel = new JPanel(new GridLayout(0, 1));

        JLabel numberOfClientsLabel = new JLabel("Number Of Clients: ");
        JLabel numberOfServersLabel = new JLabel("Number Of Servers: ");
        JLabel simulationTimeLabel = new JLabel("Simulation Time: ");
        JLabel minArrivalTimeLabel = new JLabel("Minimum Arrival Time: ");
        JLabel maxArrivalTimeLabel = new JLabel("Maximum Arrival Time: ");
        JLabel minServiceTimeLabel = new JLabel("Minimum Service Time: ");
        JLabel maxServiceTimeLabel = new JLabel("Maximum Service Time: ");

        leftPanel.add(numberOfClientsLabel);
        leftPanel.add(numberOfServersLabel);
        leftPanel.add(simulationTimeLabel);
        leftPanel.add(minArrivalTimeLabel);
        leftPanel.add(maxArrivalTimeLabel);
        leftPanel.add(minServiceTimeLabel);
        leftPanel.add(maxServiceTimeLabel);

        JPanel rightPanel = new JPanel(new GridLayout(0, 1));

        numberOfClientsTextField = new JTextField(15);
        numberOfServersTextField = new JTextField(15);
        simulationTimeTextField = new JTextField(15);
        minArrivalTimeTextField = new JTextField(15);
        maxArrivalTimeTextField = new JTextField(15);
        minServiceTimeTextField = new JTextField(15);
        maxServiceTimeTextField = new JTextField(15);

        rightPanel.add(numberOfClientsTextField);
        rightPanel.add(numberOfServersTextField);
        rightPanel.add(simulationTimeTextField);
        rightPanel.add(minArrivalTimeTextField);
        rightPanel.add(maxArrivalTimeTextField);
        rightPanel.add(minServiceTimeTextField);
        rightPanel.add(maxServiceTimeTextField);

        topPanel.add(leftPanel);
        topPanel.add(rightPanel);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

        resultTextArea = new JTextArea( 15, 15);
        JScrollPane resultPanel = new JScrollPane(resultTextArea);
        JPanel buttonPanel = new JPanel();
        start = new JButton("start");
        stop = new JButton("stop");


        buttonPanel.add(start);
        buttonPanel.add(stop);
        bottomPanel.add(buttonPanel);
        bottomPanel.add(resultPanel);
        panel.add(topPanel);
        panel.add(bottomPanel);

        return panel;
    }
    public int getNumberOfClientsTextField() {
        if(!numberOfClientsTextField.getText().equals("")) {
            return Integer.parseInt(numberOfClientsTextField.getText());
        }else{
            return -1;
        }
    }
    public int getNumberOfServersTextField() {
        if(!numberOfServersTextField.getText().equals("")) {
            return Integer.parseInt(numberOfServersTextField.getText());
        }else{
            return -1;
        }
    }
    public int getSimulationTimeTextField() {
        if(!simulationTimeTextField.getText().equals("")) {
            return Integer.parseInt(simulationTimeTextField.getText());
        }else{
            return -1;
        }
    }
    public int getMinArrivalTimeTextField() {
        if(!minArrivalTimeTextField.getText().equals("")) {
            return Integer.parseInt(minArrivalTimeTextField.getText());
        }else{
            return -1;
        }
    }
    public int getMaxArrivalTimeTextField() {
        if(!maxArrivalTimeTextField.getText().equals("")) {
            return Integer.parseInt(maxArrivalTimeTextField.getText());
        }else{
            return -1;
        }
    }
    public int getMinServiceTimeTextField() {
        if(!minServiceTimeTextField.getText().equals("")) {
            return Integer.parseInt(minServiceTimeTextField.getText());
        }else{
            return -1;
        }
    }
    public int getMaxServiceTimeTextField() {
        if(!maxServiceTimeTextField.getText().equals("")) {
            return Integer.parseInt(maxServiceTimeTextField.getText());
        }else{
            return -1;
        }
    }
    public void setResultTextArea(String resultTextArea) {
        this.resultTextArea.append(resultTextArea);
    }
    public void addStartButtonListener(ActionListener lis){
        start.addActionListener(lis);
    }
    public void addStopButtonListener(ActionListener lis){
        stop.addActionListener(lis);
    }
    public void clearResultTextArea(){
        this.resultTextArea.setText("");
    }
}

package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    public static MainPanel mainPanel;
    public TitlePanel titlePanel;
    public static CheckPanel checkPanel;
    public JPanel contentPanel;
    public View() {
        setSize(800, 648);
        setTitle("Polynomial Calculator");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new MainPanel();
        titlePanel = new TitlePanel();
        checkPanel = new CheckPanel(this);

        contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(BorderLayout.NORTH, titlePanel);
        contentPanel.add(BorderLayout.CENTER, mainPanel);

        addButtonsListeners();
        setContentPane(contentPanel);
    }
    public static void addButtonsListeners(){
        mainPanel.addStartButtonListener(new Listeners.StartButtonListener());
        mainPanel.addStopButtonListener(new Listeners.StopButtonListener());
        checkPanel.addFirstStrategyCheckBoxListener(new Listeners.FirstStrategyCheckBoxListener());
        checkPanel.addSecondStrategyCheckBoxListener(new Listeners.SecondStrategyCheckBoxListener());
    }

}


package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TitlePanel extends JPanel {

    private final JPanel contentPanel;
    public TitlePanel() {
        contentPanel = new JPanel();
        contentPanel.add(titlePanel());
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        add(contentPanel);
    }
    public JPanel titlePanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("QUEUES MANAGEMENT APPLICATION USING THREADS");
        JLabel title2 = new JLabel(" AND SYNCHRONIZATION MECHANISMS");
        title.setFont(new Font("", 1, 20));
        title2.setFont(new Font("", 1, 20));
        panel.add(title);
        panel.add(title2);
        return panel;
    }




}

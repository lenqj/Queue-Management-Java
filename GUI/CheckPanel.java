package GUI;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
public class CheckPanel extends JDialog{
    int flag;
    JCheckBox firstStrategyCheckBox;
    JCheckBox secondStrategyCheckBox;
    CheckPanel(JFrame frame){
        super(frame);
        flag = 0;
        setSize(200, 150);
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
        contentPanel.setBorder(new EmptyBorder(20, 0, 20, 0));
        contentPanel.add(checkPanel());
        setContentPane(contentPanel);
    }
    public void setTitle(String title){
        super.setTitle(title);
    }
    public void setFlag(int value){
        this.flag = value;
    }
    public JPanel checkPanel(){
        JPanel panel = new JPanel();

        JLabel firstStrategyLabel = new JLabel("Time Strategy: ");
        JLabel secondStrategyLabel = new JLabel("Queue Strategy: ");

        firstStrategyCheckBox = new JCheckBox();
        secondStrategyCheckBox = new JCheckBox();

        panel.add(firstStrategyLabel);
        panel.add(firstStrategyCheckBox);
        panel.add(secondStrategyLabel);
        panel.add(secondStrategyCheckBox);
        return panel;
    }
    public void setVisibleCheckPanel(boolean var){
        this.setVisible(var);
    }
    public void clearFirstStrategyCheckBox(){
        firstStrategyCheckBox.setSelected(false);
    }
    public void clearSecondStrategyCheckBox(){
        secondStrategyCheckBox.setSelected(false);
    }
    public void addFirstStrategyCheckBoxListener(ActionListener lis){
        firstStrategyCheckBox.addActionListener(lis);
    }
    public void addSecondStrategyCheckBoxListener(ActionListener lis){
        secondStrategyCheckBox.addActionListener(lis);
    }
}

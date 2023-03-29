import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main extends JFrame implements ActionListener {

    
    private Vis mainPanel;
    public static final String SHERYL = "Sheryl";
    public static final String TAKEYOSHI = "Takeyoshi";
    public static final String JOE = "Joe";
    public static final String BRANDON = "Brandon";

    private JMenuBar createMenu() {
        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenuItem sheryl = new JMenuItem(SHERYL);
        sheryl.addActionListener(this);
        sheryl.setActionCommand(SHERYL);
        JMenuItem takeyoshi = new JMenuItem(TAKEYOSHI);
        takeyoshi.addActionListener(this);
        takeyoshi.setActionCommand(TAKEYOSHI);
        JMenuItem joe = new JMenuItem(JOE);
        joe.addActionListener(this);
        joe.setActionCommand(JOE);
        JMenuItem brandon = new JMenuItem(BRANDON);
        brandon.addActionListener(this);
        brandon.setActionCommand(BRANDON);
        file.add(sheryl);
        file.add(takeyoshi);
        edit.add(joe);
        edit.add(brandon);
        mb.add(file);
        mb.add(edit);
        return mb;
    }

    public Main() {

        //add a menu bar and (time permitting) a toolbar
        JMenuBar tyla = createMenu();
        setJMenuBar(tyla);

        mainPanel = new Vis();

        setContentPane(mainPanel);
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Java Treemap");
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("a menu was clicked");
        String cmd = e.getActionCommand();
        switch (cmd) {
            case SHERYL:
                mainPanel.setCircleColor(Color.RED);
                break;
            case TAKEYOSHI:
                mainPanel.setCircleColor(Color.BLUE);   
                break;
            case JOE:
                mainPanel.setCircleColor(Color.CYAN);
                break;
            case BRANDON:
            default:
                mainPanel.setCircleColor(Color.GREEN);
                break;
        }
    }
}

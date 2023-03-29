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
    public static final String CHOOSE_FOLDER = "Choose Folder";
    public static final String CHOOSE_COLORS = "Choose Color Scheme";


    /* function to create a menu */
    private JMenuBar createMenu() {

        //set up initial menu
        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");

        //set up items in the menu
        JMenuItem chooseFolder = new JMenuItem(CHOOSE_FOLDER);
        chooseFolder.addActionListener(this);
        chooseFolder.setActionCommand(CHOOSE_FOLDER);

        JMenuItem chooseColors = new JMenuItem(CHOOSE_COLORS);
        chooseColors.addActionListener(this);
        chooseColors.setActionCommand(CHOOSE_COLORS);

        //add the menu items to the menu
        file.add(chooseFolder);
        file.add(chooseColors);

        mb.add(file);

        //return the created menu
        return mb;
    }

    public Main() {

        //add a menu bar and (time permitting) a toolbar
        JMenuBar mBar = createMenu();
        setJMenuBar(mBar);

        //set the panel 
        mainPanel = new Vis();

        //panel settings
        setContentPane(mainPanel);
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Java Treemap");
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    /* method to handle when user clicks on the menu */
    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("a menu was clicked");
        String cmd = e.getActionCommand();

        switch (cmd) {
            case CHOOSE_FOLDER:
                mainPanel.setCircleColor(Color.RED);
                break;
            case CHOOSE_COLORS:
                mainPanel.setCircleColor(Color.BLUE);   
                break;
            default:
                mainPanel.setCircleColor(Color.GREEN);
                break;
        }
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Main extends JFrame implements ActionListener {

    private Vis mainPanel;
    public static final String CHOOSE_FOLDER = "Choose Folder";
    public static final String RANDOM_COLORS = "Random Colors";
    public static final String FILE_TYPE_COLORS = "File Type";
    public static final String FILE_AGE_COLORS = "File Age";
    public static final String NO_COLORS = "None";
    public String currentColorScheme = "Random Colors";


    /* function to create a menu */
    private JMenuBar createMenu() {

        //set up initial menu
        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu colors = new JMenu("Colors");

        //set up items in the menu
        JMenuItem chooseFolder = new JMenuItem(CHOOSE_FOLDER);
        chooseFolder.addActionListener(this);
        chooseFolder.setActionCommand(CHOOSE_FOLDER);

        JMenuItem randomColors = new JMenuItem(RANDOM_COLORS);
        randomColors.addActionListener(this);
        randomColors.setActionCommand(RANDOM_COLORS);

        JMenuItem fileTypeColors = new JMenuItem(FILE_TYPE_COLORS);
        fileTypeColors.addActionListener(this);
        fileTypeColors.setActionCommand(FILE_TYPE_COLORS);

        JMenuItem fileAgeColors = new JMenuItem(FILE_AGE_COLORS);
        fileAgeColors.addActionListener(this);
        fileAgeColors.setActionCommand(FILE_AGE_COLORS);

        JMenuItem noColors = new JMenuItem(NO_COLORS);
        noColors.addActionListener(this);
        noColors.setActionCommand(NO_COLORS);

        //add the menu items to the menu
        file.add(chooseFolder);
        colors.add(randomColors);
        colors.add(fileTypeColors);
        colors.add(fileAgeColors);
        colors.add(noColors);

        mb.add(file);
        mb.add(colors);

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
        //get the button that was pressed
        String cmd = e.getActionCommand();

        switch (cmd) {
            case CHOOSE_FOLDER:
                //pop up a window where user can select a folder
                JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                jfc.setDialogTitle("Choose a folder");

                //set it to only allow folders to be selected, not files
                jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                //debugging, what directory was returned
                int returnValue = jfc.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    if (jfc.getSelectedFile().isDirectory()) {
                        System.out.println("You selected the directory: " + jfc.getSelectedFile());
                    }
                }

                //call the main panel to create the tree map with the selected directory
                mainPanel.setRootNode(jfc.getSelectedFile());
                break;

            case RANDOM_COLORS:
                //set the color scheme to random colors
                mainPanel.root.setTreeColorScheme(RANDOM_COLORS);
                repaint();
                break;

            case FILE_TYPE_COLORS:
                //set the color scheme to file type based colors
                mainPanel.root.setTreeColorScheme(FILE_TYPE_COLORS);
                repaint();
                break;

            case FILE_AGE_COLORS:
                //set the color scheme to file age based colors
                mainPanel.root.setTreeColorScheme(FILE_AGE_COLORS);
                repaint();
                break;

            case NO_COLORS:
                //set the color scheme to no colors
                mainPanel.root.setTreeColorScheme(NO_COLORS);
                repaint();
                break;

            default:
                //random colors
                break;
        }
    }
}

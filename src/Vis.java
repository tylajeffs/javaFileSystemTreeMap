import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.Random;


public class Vis extends JPanel implements MouseListener, MouseMotionListener {

    //base node
    private Node root;

    //initial orientation
    public static final String INITIAL_ORIENTATION = "HORIZONTAL";

    //colors for each file type
    private Color documents = new Color(245,85,137);
    private Color spreadsheet = new Color(243,131,91);
    private Color slideshow = new Color(5,184,167);
    private Color plainText = new Color(0,213,211);
    private Color executable = new Color(214,218,2);
    private Color sourceCode = new Color(159,194,31);
    private Color objectCode = new Color(23,143,193);
    private Color image = new Color(182,151,214);
    private Color audio = new Color(172,228,220);
    private Color otherFileType = new Color(102,143,30);


    public Vis() {
        super();
        root = new Node(new File("/Users/tylajeffs/FinalProject"));

        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void paintComponent(Graphics g1) {

        //typecast Graphics to Graphics2D
        Graphics2D g = (Graphics2D)g1;

        //get width and height
        int w = getWidth();
        int h = getHeight();

        //set one root node to start drawing        
        root.draw(0,0,w,h,g,INITIAL_ORIENTATION);
    }

    /* method to set the root node */
    public void setRootNode(File f) {
        root = new Node(f);
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
     
    }   

}



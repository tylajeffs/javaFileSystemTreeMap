import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Vis extends JPanel implements MouseListener, MouseMotionListener {

    //initial orientation
    public static final String HORIZONTAL = "Horizontal";

    //current color
    private Color currentColor;

    //colors for each type of file
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
        currentColor = Color.MAGENTA;
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void paintComponent(Graphics g1) {

        //typecast Graphics to Graphics2D
        Graphics2D g = (Graphics2D)g1;

        //get the width and height of the screen
        int w = getWidth();
        int h = getHeight();

        //draw some simple shapes
        g.setColor(currentColor);
        g.fillOval(100, 100, 100, 100);
    }

    /* method to set the current color */
    public void setCircleColor(Color c) {
        currentColor = c;
        repaint();
    }

    /* function to generate a random color */
    public Color generateRandomColor() {

        //initialize the randomness
        Random rand = new Random();

	    //generate 3 different values for the rgb of the color
	    float red = rand.nextFloat();
	    float green = rand.nextFloat();
	    float blue = rand.nextFloat();

        //create the color
	    Color randomColor = new Color(red, green, blue);
        return randomColor;
    }

    /* method to create the actual tree map */
    public void createTreeMap(File currentFolder) {

        //get the folders in the current folder

        //start with horizontal
        HORIZONTAL;

        //divide the screen into how many there are

        //pick a color

        //make a recursive call


        repaint();

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



import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.Random;


public class Vis extends JPanel implements MouseListener, MouseMotionListener {

    //base node
    public Node root;
    Node currentNode;
    //initial orientation
    public static final String INITIAL_ORIENTATION = "HORIZONTAL";


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
        repaint();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        //get the x and y of the mouse
        int mouseX = e.getX();
        int mouseY = e.getY();

        //get the node the user clicked on
        currentNode = root.getNodeAt(mouseX,mouseY);

        //call the function to open the file
        openNodeFile(currentNode);

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
        
        //get the x and y of the mouse
        int mouseX = e.getX();
        int mouseY = e.getY();

        //get the node the user is hovering on
        currentNode = root.getNodeAt(mouseX,mouseY);

        //display the file path and the size of the node
        setToolTipText("File Path: " + currentNode.filePath + "\nFile Size: " + currentNode.size);
    }   

    /* function to open the file when a user clicks on it */
    public void openNodeFile(Node n) {

        try  
        {  
            //create the file to open using the filepath from the node
            File fileToOpen = new File(n.filePath);   
            if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not  
            {  
                System.out.println("not supported");  
                return;  
            }  
            
            Desktop desktop = Desktop.getDesktop(); 
            //check if file exists or not   
            if(fileToOpen.exists())  
                //open the specified file        
                desktop.open(fileToOpen);               
            }  

        catch(Exception e)  
        {  
            e.printStackTrace();  
        }  

    }

}



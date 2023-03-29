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
import java.util.ArrayList;
import java.util.List;

public class Vis extends JPanel implements MouseListener, MouseMotionListener {

    private Color milly;


    public Vis() {
        super();
        milly = Color.MAGENTA;
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void setCircleColor(Color c) {
        milly = c;
        repaint();
    }


    @Override
    public void paintComponent(Graphics g1) {
        //typecast Graphics to Graphics2D
        Graphics2D g = (Graphics2D)g1;

        //get the width and height of the screen
        int w = getWidth();
        int h = getHeight();

        //draw some simple shapes
        g.setColor(milly);
        g.fillOval(100, 100, 100, 100);

      
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



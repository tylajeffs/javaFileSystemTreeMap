import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class Node {
    long size;
    ArrayList<Node> children;

    public Node(File f) {

        //check if the node is a file or a folder
        if (f.isFile()) {
            //get the size in bytes of the file 
            size = f.length();
        } else {
            //it's a folder
            //go through each of the children in the folder
            for (File child: f.listFiles()) {
                //recursion for each child 
                Node kid = new Node(child);

                //add the size of the kids to the folder size
                size += child.length();

                //add the kid to the children arraylist
                children.add(kid);
            }
        }

    }

    /* method to draw the treemap */
    public void draw(int left, int top, int w, int h, Graphics2D g, String orientation) {

        //check if node is a file or folder
        if(this.children.isEmpty()) {
            //this is a file, set the color and draw the rectangle
            g.setColor(generateRandomColor());
            g.fillRect(left,top,w,h);
        } else {
            //this is a folder

            //check orientation
            if(orientation.equals("HORIZONTAL")) {
                //get the ratio of how many pixels per byte
                long pixelsPerByte = w/this.size;

                for (Node kid: this.children) {
                    //figure out how many pixels each child gets
                    long pixelsForChild = kid.size * pixelsPerByte;

                    //draw the child node using the pixels as the width
                    kid.draw(left, top, (int)pixelsForChild, h, g, "VERTICAL");

                    //move the left so the next rectange is immediately to the right
                    left += pixelsForChild;
                }

            } else {
                //vertical
                long pixelsPerByte = h/size;

                for (Node kid: this.children) {
                    //figure out how many pixels each child gets
                    long pixelsForChild = kid.size * pixelsPerByte;

                    //draw the child node using the pixels as the height
                    kid.draw(left, top, w, (int)pixelsForChild, g, "HORIZONTAL");

                    //move down so the next rectange is immediately below
                    top += pixelsForChild;
                }
            }
        }
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

}
 


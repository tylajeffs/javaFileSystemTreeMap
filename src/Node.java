import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Date.*;



public class Node {
    long size = 0;
    ArrayList<Node> children = new ArrayList<>();
    String filePath;
    String fileType = "";
    String currentColorScheme = "Random Colors";
    SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy hh:mm a");
    String ageString = "";
    Date lastModified = new Date();
    



    /* constructor, initial setup */
    public Node(File f) {

        //get the file path
        filePath = f.getPath();

        //check if the node is a file or a folder
        if (f.isFile()) {
            //get the size in bytes of the file 
            size = f.length();

            //get the file type
            int i = filePath.lastIndexOf('.');
            if (i > 0) {
                fileType = filePath.substring(i+1);
            }

            //get the file age (from last modification) in milliseconds
            long numAge = f.lastModified();
            //convert the milliseconds age into the date format and store in string
            ageString = sdf.format(numAge);
            //parse the string into a date object
            try {
                lastModified = sdf.parse(ageString);
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }

            System.out.println("File Age: " + lastModified.toString());
            


        } else {
            //it's a folder
            //go through each of the children in the folder
            for (File child: f.listFiles()) {

                //add the size of the kids to the folder size
                size += child.length();

                //recursion for each child 
                Node kid = new Node(child);

                //add the kid to the children arraylist
                children.add(kid);
            }

        }

    }

    /* method to draw the treemap */
    public void draw(int left, int top, int w, int h, Graphics2D g, String orientation) {

        //check if node is a file or folder
        if(this.children.isEmpty()) {

            //this is a file, set the color and draw the rectangle (with a black border)
            g.setColor(generateColor());
            g.fillRect(left,top,w,h);  
            g.setColor(Color.BLACK);
            g.drawRect(left,top,w,h);

        } else {
            //this is a folder
            //check orientation
            if(orientation.equals("HORIZONTAL")) {

                //get the ratio of how many pixels per byte
                double pixelsPerByte = ((double)w/(double)this.size);

                //loop through all the kids
                for (Node kid: this.children) {
                    //figure out how many pixels each child gets
                    double pixelsForChild = kid.size * pixelsPerByte;

                    //draw the child node using the pixels as the width
                    kid.draw(left, top, (int)pixelsForChild, h, g, "VERTICAL");

                    //move the left so the next rectange is immediately to the right
                    left += pixelsForChild;
                }

            } else {
                //vertical
                double pixelsPerByte = ((double)h/(double)this.size);

                for (Node kid: this.children) {
                    //figure out how many pixels each child gets
                    double pixelsForChild = kid.size * pixelsPerByte;

                    //draw the child node using the pixels as the height
                    kid.draw(left, top, w, (int)pixelsForChild, g, "HORIZONTAL");

                    //move down so the next rectange is immediately below
                    top += pixelsForChild;
                }
            }
        }

    }

    /* function to set the color scheme for each of the nodes in the tree */
    public void setTreeColorScheme(String s) {
        //set color scheme
        currentColorScheme = s;

        //go through all the kids and set the color scheme
        for (Node kid: this.children) {
            kid.setTreeColorScheme(s);
        }

    }


    /* function to genereate the correct color for the rectangles */
    public Color generateColor() {

        Color toReturn = Color.gray;

        switch (currentColorScheme) {
            case "Random Colors":
                toReturn = generateRandomColor();
          
                break;

            case "File Type":
                //check what type the file is
                switch (fileType) {
                    //images
                    case "jpg":
                    case "png": 
                    case "jpeg":
                    case "gif":
                        toReturn = new Color(3, 252, 86); //bright green
                        break;
                    //spreadsheets
                    case "dat":
                    case "csv":
                    case "tsv":
                    case "xls":
                    case "xlsx":
                    case "ods":
                        toReturn = new Color(210, 3, 252); //bright purple
                        break;
                    //documents
                    case "doc":
                    case "docx":
                    case "pdf": 
                        toReturn = new Color(252, 248, 3); //bright yellow
                        break;
                    //slideshows
                    case "ppt":
                    case "pptx":
                        toReturn = new Color(3, 186, 252); //sky blue
                        break;
                    //plain text
                    case "txt":
                        toReturn = new Color(252, 161, 3); //orange
                        break;
                    //audio video
                    case "mp3":
                    case "wav":
                    case "aac":
                    case "mp4":
                    case "mov":
                        toReturn = new Color(252, 3, 3); //red
                        break;
                    //executables
                    case "exe":
                    case "":
                        toReturn = new Color(252, 161, 3); //orange
                        break;
                    //source code
                    case "c":
                    case "java":
                    case "py":
                    case "cs":
                    case "php":
                    case "vb":
                    case "class":
                    case "css":
                    case "html":
                    case "js":
                    case "jsx":
                        toReturn = new Color(250, 137, 242); //pink
                        break;
                    //object code
                    case "o":
                    case "obj":
                        toReturn = new Color(42, 8, 156); //dark blue
                        break;
                    //any other type of file
                    default:
                    toReturn = new Color(186, 146, 214); //light purple
                }
                break;

            case "File Age":

         
                break;

            case "None":
                toReturn = Color.WHITE;
                break;

            default:
                //random colors
                toReturn = generateRandomColor();
                System.out.println("Just picked default (random) colors");
    
                break;
        }

        //System.out.println("COLOR: " + toReturn.toString());
        return toReturn;

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
 


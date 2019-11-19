/*************************************************************************
 *  Compilation:  javac Sierpinski.java
 *  Execution:    java Sierpinski
 *
 *  @author: Cyrus Majd         EMAIL: cm1355@scarletmail.rutgers.edu           NETID: cm1355
 *
 *************************************************************************/

public class Sierpinski {

    // position arrays of the x and y positions. necessary for fill in method.
    public static double[] xPositionArray = new double[3];
    public static double[] yPositionArray = new double[3];

    // Height of an equilateral triangle whose sides are of the specified length. 
    public static double height(double length) {

        double bigHeight = (Math.sqrt(3)/2)*length;
        return bigHeight;

    }

    // Draws a filled equilateral triangle whose bottom vertex is (x, y) 
    // of the specified side length. 
    public static void filledTriangle(double x, double y, double length) {

            StdDraw.setPenRadius(0.001);
            StdDraw.setPenColor(StdDraw.BLACK);


            xPositionArray[0] = x - (length)/2;     yPositionArray[0] = y + height(length); // top left
            xPositionArray[1] = x + (length)/2;     yPositionArray[1] = y + height(length); // top right
            xPositionArray[2] = x;                  yPositionArray[2] = y;                  // bottom


            StdDraw.filledPolygon(xPositionArray, yPositionArray);
            

	// WRITE YOUR CODE HERE
    }

    // Draws a Sierpinski triangle of order n, such that the largest filled 
    // triangle has bottom vertex (x, y) and sides of the specified length. 
    public static void sierpinski(int n, double x, double y, double length) {

        //x is x + length/2. y is y + height (length)
        //make three calls to seirpinski here. the first is the x, y of the midpoint of the left leg, then for right, then for top. top y is y+height(L)

        //pos array 0 is top left corner

        filledTriangle(x, y, length);

        if (n == 1) {
        }
        else {

            filledTriangle( x, y, length);

            n = n-1;


            sierpinski(n, x + (length)/2, y, length/2); // recursive call for bottom right thing.
            sierpinski(n, x, y + height(length), length/2); // recursive call for top thing.
            sierpinski(n, x - (length)/2, y, length/2); // recursive call for bottom left thing.

        }
    }

    // Takes an integer command-line argument n; 
    // draws the outline of an equilateral triangle (pointed upwards) of length 1; 
    // whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and 
    // draws a Sierpinski triangle of order n that fits snugly inside the outline. 
    public static void main(String[] args) {

        double length = 1.0;
        double height = 2*height(length);
        int n = Integer.parseInt(args[0]);

        //while (!StdIn.isEmpty()) {
        //    n = (int) StdIn.readDouble();
        //}

        StdDraw.setScale(0, 2);
        StdDraw.setPenRadius(0.001);
        StdDraw.setPenColor(StdDraw.GRAY);

        StdDraw.line(0.0, 0.0, 2.0, 0.0);
        StdDraw.line(2.0, 0.0, 1.0, height);
        StdDraw.line(0.0, 0.0, 1.0, height);

        //n = n-1;

        sierpinski(n, 1, 0, length);

	// WRITE YOUR CODE HERE 
    }
}

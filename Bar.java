// we added the import statements for you
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 *
 * NOTE: we have provided the public interface for this class. Do not change
 * the public interface. You can add private instance variables, constants,
 * and private methods to the class. You will also be completing the
 * implementation of the methods given.
 * 
 */
public class Bar {
    private int bar_bottom;  //private instance viables for different festures of the bar
    private int bar_left;
    private int bar_width;
    private int bar_numUnits;
    private double bar_unitsPerPixel;
    private Color bar_color;
    private String bar_label; 
    private int height;
   
   /**
      Creates a labeled bar.  You give the height of the bar in application
      units (e.g., population of a particular state), and then a scale for how
      tall to display it on the screen (parameter unitsPerPixel). 
  
      @param bottom  location of the bottom of the label
      @param left  location of the left side of the bar
      @param width  width of the bar
      @param numUnits  height of the bar in application units
      @param unitsPerPixel  how many application units per pixel for height
      @param color  the color of the bar
      @param label  the label at the bottom of the bar
   */
   public Bar(int bottom, int left, int width, int numUnits, 
              double unitsPerPixel, Color color, String label) {
         bar_bottom=bottom;
         bar_left=left;
         bar_width=width;
         bar_numUnits=numUnits;
         bar_unitsPerPixel=unitsPerPixel;
         bar_color=color;
         bar_label=label; 
   }
   /**
      Draw the labeled bar. 
      @param g2  the graphics context
   */
   public void draw(Graphics2D g2) {
   /**
   determine label size and context;
   */
       Font font=g2.getFont();
       FontRenderContext context=g2.getFontRenderContext();
       Rectangle2D labelBounds=font.getStringBounds(bar_label,context);
       int widthOfLabel=(int)labelBounds.getWidth();
       int heightOfLabel=(int)labelBounds.getHeight();
   /**
   draw the bar
   bar height pixel = numUnits/unitPerPixel
   */
       Rectangle rect=new Rectangle(bar_left,bar_bottom,bar_width,(int)(bar_numUnits/bar_unitsPerPixel)-40);
       g2.setColor(bar_color);
       g2.fill(rect);
   /**
   draw the string
   */  
       g2.setColor(Color.BLACK);
       g2.drawString(bar_label,bar_left-widthOfLabel/2+20,bar_bottom+(int)(bar_numUnits/bar_unitsPerPixel)-40+heightOfLabel);
   }
}


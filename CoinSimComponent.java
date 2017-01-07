import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Scanner;

import javax.swing.JComponent;
import java.awt.Color;
/*
 * draw three bars to represent the results
 */
public class CoinSimComponent extends JComponent
{
	private int num;
	private int heightInPixel;
	private int widthInPixel;
	private int numTrials;
	private int twoHeads;
	private int twoTails;
	private int headTails;
	private int twoHeadsRates;
	private int twoTailsRates;
	private int headTailsRates;
	private double unitsPerPixel;
	private static final int DISTANCE_TO_TOP=10;
	private static final int BAR_WIDTH=40;
  	
 /*
   simulate the coin toss process 
   output the coin toss result
 */
   public void startSim(int num){
    CoinTossSimulator simulate=new CoinTossSimulator();
	simulate.run(num);
	numTrials=simulate.getNumTrials();
	twoHeads=simulate.getTwoHeads();
	headTails=simulate.getHeadTails();
    twoTails=simulate.getTwoTails();
   }
	
 /*
  * paint three bars to represent the simulate result
  */
   public void paintComponent(Graphics g){
     heightInPixel=getHeight();
     widthInPixel=getWidth();
     twoHeadsRates=(int)Math.round(twoHeads*1.0/numTrials*100);
     twoTailsRates=(int)Math.round(twoTails*1.0/numTrials*100);
     headTailsRates=100-twoHeadsRates-twoTailsRates;
     unitsPerPixel=100.0/heightInPixel;
    
     Graphics2D g2=(Graphics2D)g;
     Bar bar1=new Bar(heightInPixel-(int)(twoHeadsRates/unitsPerPixel)+DISTANCE_TO_TOP,1*widthInPixel/4-BAR_WIDTH/2,BAR_WIDTH,twoHeadsRates,unitsPerPixel,Color.RED,"Two Heads: "+twoHeads+"("+twoHeadsRates+"%"+")");
     Bar bar2=new Bar(heightInPixel-(int)(headTailsRates/unitsPerPixel)+DISTANCE_TO_TOP,2*widthInPixel/4-BAR_WIDTH/2,BAR_WIDTH,headTailsRates,unitsPerPixel,Color.GREEN,"A Head and a Tail: "+headTails+"("+headTailsRates+"%"+")");
     Bar bar3=new Bar(heightInPixel-(int)(twoTailsRates/unitsPerPixel)+DISTANCE_TO_TOP,3*widthInPixel/4-BAR_WIDTH/2,BAR_WIDTH,twoTailsRates,unitsPerPixel,Color.BLUE,"Two Tails: "+twoTails+"("+twoTailsRates+"%"+")");
     bar1.draw(g2);
     bar2.draw(g2);
     bar3.draw(g2);
   }
}
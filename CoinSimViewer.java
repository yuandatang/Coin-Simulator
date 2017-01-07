import java.util.Scanner;
import javax.swing.JFrame;
/**
 * simulator the coin toss process
 * draw three bars to represent the results
 * 
 * @author Administrator
 * Yuanda Tang
 * 2016-9-12
 */
public class CoinSimViewer{ 
	public static void main(String[] args){
    System.out.print("Enter number of trials: ");
   	Scanner in= new Scanner(System.in);
   	 int num=in.nextInt();
        while(num<=0){
          System.out.print("ERROR: Number entered must be greater than 0.");	  
          System.out.print("Enter number of trials: ");
          num=in.nextInt();
	    } 
    JFrame frame=new JFrame();
    frame.setSize(800,500);
    frame.setTitle("CoinToss");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    CoinSimComponent component=new CoinSimComponent();
    component.startSim(num);
    frame.add(component);
    frame.setVisible(true);
    }
}

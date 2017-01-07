import java.util.Random;
/**
 * class CoinTossSimulator
 * 
 * Simulates trials of tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
public class CoinTossSimulator {
    private int two_heads=0;
    private int head_tail =0;
    private int two_tails=0;
    private int num_trials=0;
    Random random=new Random();
    /**
       Creates a coin toss simulator with no trials done yet.
    */
    public CoinTossSimulator() {

    }
/**
   Runs the simulation for numTrials more trials. Multiple calls to this
   without a reset() between them add these trials to the simulation
   already completed. 
   @param numTrials  number of trials to for simulation; must be >= 0
*/
    public void run(int numTrials) {       
       int head=0;// record heads and tails for every trail
       int tail=0;
       if(numTrials<=0)
	   System.out.println("Number entered must be greater than 0.");
       else{
         for(int i=0;i<numTrials;i++){
           for(int j=0;j<2;j++){
	         if(random.nextDouble()<0.5){
	           head++;
	         }
	         else{ 
		       tail++;
	         }
	       }           
	   if(head==1){
	     head_tail++;
	   }
	   else if(head==2){
	     two_heads++;
	   }
	   else{
	     two_tails++;
	   }
       head=0;  // Reset the value
	   tail=0;
	   }
       }
   }
    
    /**
    Get number of trials performed since last reset.
    */
    public int getNumTrials() {
      this.num_trials=this.two_heads+this.head_tail+this.two_tails; //RETURN TRIALS NUMBER
      return this.num_trials;
    }
    
    /**
    Get number of trials that came up two heads since last reset.
    */
    public int getTwoHeads() {
      return two_heads;}
    
   /**
      Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return this.two_tails;
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return this.head_tail;
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
       two_heads=0;
       head_tail=0;
       two_tails=0;
       num_trials=0;
   }

}

/**
 * Test the class CoinTossSimulator
 * @author Administrator
 * Yuanda Tang
 * 2016-9-12
 */

public class CoinTossSimulatorTester{
    /**
       Output the result
    */
    public void printRes(CoinTossSimulator test,int times){
      System.out.println("After run"+"("+times+")");
      System.out.println("Number of trials: "+test.getNumTrials());
      System.out.println("Two_head tosses: "+test.getTwoHeads());
      System.out.println("Two_tail tosses: "+test.getTwoTails());
      System.out.println("One-head one_tail tosses: "+test.getHeadTails());
      Boolean trueOrFalse=(test.getNumTrials()==test.getTwoHeads()+test.getTwoTails()+test.getHeadTails());
      System.out.println("Tosses add up correctly? "+trueOrFalse);
      System.out.println();
    }
    /**
       Test for run 1,10,100,1000 times
     */
    public static void main(String[] args){
      CoinTossSimulator test=new CoinTossSimulator();
      CoinTossSimulatorTester test2=new CoinTossSimulatorTester();
      System.out.println("After constructor:");
      test.run(0);
      test2.printRes(test,0);
      test.run(1);
      test2.printRes(test,1);
      test.run(100);
      test2.printRes(test,100);
      test.run(1000);
      test2.printRes(test,1000);
      test.run(10000);
      test2.printRes(test,10000);
      test.reset();
      
      
      System.out.println("After reset:");
      test.run(1);
      test2.printRes(test,1);
      test.reset();
      test.run(10);
      test2.printRes(test,10);
      test.reset();
      test.run(100);
      test2.printRes(test,100);
      test.reset();
      test.run(1000);
      test2.printRes(test,1000);
    }
}


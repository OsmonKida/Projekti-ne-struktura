import java.util.Timer;
import java.util.TimerTask;

public class TimerCount {
   private TimerApp a;
   private TimerInput i;
   private Thread t1;
   private char c;
   private boolean b = false;
   private boolean hasStarted = false;
   private String[] options = {"countUp","countDown"};
   private String s = "Zgjedh mes countUp ose countDown";
   private int Option;
   
   public TimerCount(TimerApp a, TimerInput i) {
      this.a = a;
      this.i = i;
      Option = i.showOption(options, s);
   }

//------------------------------------------------------------------------------

   public void countUp() { // metoda  per countup
      Timer timer = new Timer();
      TimerTask task = 
         new TimerTask() {
            public void run() {
              // System.out.println(a.getMinutes() + " " + a.getSeconds());
               hasStarted = true;
               a.increment();
               if(b) {
                  timer.cancel();
                  b = false;
                  hasStarted = false;
               }
            }
         };
      timer.scheduleAtFixedRate(task, 1000, 1000);
   } 

//----------------------------------------------------------------------------------------------------

   public  void countDown() {  //metoda per countdown
      Timer timer = new Timer();
      TimerTask task = 
         new TimerTask() {
            public void run() {
               //System.out.println(Integer.toString(a.getMinutes()) + ":"+Integer.toString(a.getSeconds()));
               hasStarted = true; 
               a.decrement();
               if ( a.getSeconds() == 0 && a.getMinutes() == 0){ 
                  timer.cancel(); 
                  hasStarted = false;                                
               } 
               else if(b) {
                  timer.cancel();
                  b = false;
                  hasStarted = false;
               }
            } 
         };
      timer.scheduleAtFixedRate(task, 1000, 1000);
   }
  
//--------------------------------------------------------------------------------------------------------
   
   public void command() { 
     //metoda per kontrollimin e komandave
      t1 = new Thread(
         ()-> {
            while(true) {
               c = i.readCommand("Commands \n"
                                  + "   S - Stop \n"
                                  + "   P - Play \n"
                                  + "   R - Reset Timer \n"
                                  + "   O - Rechoose options \n"
                                  + "   Q - Quit "
                                );
               if (c == 'S') { //e ndal timerin
                  b = true;
               }
               if(c == 'P') { // e leshon timerin
                  if(hasStarted) { }
                  else{            
                     startTheTimer();
                  }    
               } 
               if(c == 'Q') {  // e nderpren programin
                  System.exit(0); 
               }
               
               if(c == 'R') { // e reseton timerin
                  b = true;
                  resetTheTimer();
                  b = false;
               }
               
               if(c == 'O') {
                  b = true;
                  Option = i.showOption(options, s);
                  resetTheTimer();
                  b = false;
               }
            }
         }
         );
      t1.start();
   }
   
//--------------------------------------------------------------------------
         
   private void resetTheTimer() { // e reseton Timerin
      if(Option == 0) {
         a.setMinutes(0);
         a.setSeconds(0);  
      } 
                  
      if(Option == 1) {
         i.insert();
                     
      }
   }

//----------------------------------------------------------------------------------
   
   private void startTheTimer() { //e starton timerin.
      if(Option == 0) {
         if(a.getSeconds() == 0 && a.getMinutes() == 0){   
            countUp();
         }   
      }      
      if(Option == 1) {
         if(a.getSeconds() == 0 && a.getMinutes() == 0) {
            
         }
         else {
            countDown();
         }
      }
   }  
  
//------------------------------------------------------------------------------------ 
   
   public int getOption() {
      return Option;
   } 
}
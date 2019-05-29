

public class TimerApp {
   private int Minutes;
   private int Seconds;
   /** decrement i dekrementon sekondat,
      nese sekondat jane 0 atehere,
      i decrementon minutat dhe sekondat i ben 60.
    */
   public void decrement() { 
      if(Seconds == 0) {
         Minutes -=1;
         Seconds = 60;
      }
      
      if(Seconds > 60) {
         int a = Seconds/60;
         Minutes +=a;
         Seconds =Seconds - a*60 ;   
      } 
      Seconds--; 
   }
   /** increment i incrementon sekondat,
      nese sekondat jane 60 atehere i incrementon minutat
      dhe sekondat i ben 0
     */
   public void increment() {             // i incrementon sekondat per 1
      if(Seconds == 60) {
         Minutes++;
         Seconds = 0;
      }
      Seconds++;
   }
   /** getString kthen minutat dhe sekondat ne nje string. 
    */ 
   public String getString() {
      String s1 = Integer.toString(Minutes);
      String s2 = Integer.toString(Seconds);
      if(s1.length() == 1){
         s1 = "0" + s1;
      }
      if(s2.length() == 1){
         s2 = "0" + s2;     
      }
      if(Seconds == -1) {
         s1 = "error";
         s2 = "";
      }
         
      return s1 + " : " + s2;
     
  
   }
   
   public void setMinutes(int m) {
      Minutes = m;
   }
   public void setSeconds(int s) {
      Seconds = s;
   }
   public int getMinutes() {
      return Minutes;
   }
   public int getSeconds() {
      return Seconds;
   }
}
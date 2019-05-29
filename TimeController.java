public class TimeController {
   public void start() {
      
      TimerApp a = new TimerApp();
      TimerInput i = new TimerInput(a);
      TimerCount c = new TimerCount(a, i);
      new TimerOutput(a, 300);
      if(c.getOption() == 0) {
         c.countUp();
      }
      else{
         i.insert();
         c.countDown();
      }     
      c.command();
   }
}
// input-view class
import javax.swing.*;
  
public class TimerInput {
   private String input;
   private TimerApp a;
   private int Minutes;
   private int Seconds;
   
   public TimerInput(TimerApp a) {
      this.a = a;
   }
   
   /*insert ia cakton minutat dhe sekondat tw klases TimerApp 
    */
   public void insert() {
      try {
         Minutes = Integer.parseInt(JOptionPane.showInputDialog("Insert Minutes").trim());
         Seconds = Integer.parseInt(JOptionPane.showInputDialog("Insert Seconds").trim()); 
      }
      catch(Exception e) {}  
   
      if (Minutes < 0 || Seconds < 0) {
         insert();
      }
      else {
         a.setMinutes(Minutes);
         a.setSeconds(Seconds);
      }
      
  
   }
   /**showOption shfaq nje dritare me opsione
     */
   public int showOption(String[] opsionet, String s) {
      String[] options = opsionet;
      int a = JOptionPane.showOptionDialog(null, s, "Option", JOptionPane.DEFAULT_OPTION, 
    		  JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
      return a;
   }
   
   
   /**readCommand lexon komandat
     */
   public char readCommand(String message) {
      input = JOptionPane.showInputDialog(message);
      input = input.trim();
      input = input.toUpperCase();
      char c = input.charAt(0);
      return c;//
   }
  
}  
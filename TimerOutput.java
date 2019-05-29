import javax.swing.*;
import java.awt.*;

public class TimerOutput extends JPanel {
   private TimerApp a;
   private int width;
   
   public TimerOutput(TimerApp a, int width) {
      this.a = a;
      this.width = width;
      JFrame frame = new JFrame();
      frame.setSize(width, width);
      frame.setVisible(true);
      frame.getContentPane().add(this);
      frame.setTitle("Timer");
   }
   
   public void paintComponent(Graphics g) {
      g.setColor(Color.blue);
      g.fillRect(0 , 0, width, width);
      paintTimer(g, width/10, (width/2)-20);
      this.repaint();
   }
   
   public void paintTimer(Graphics g, int x, int y) {
      g.setColor(Color.black);
      String Time = "Timer >>>    " + a.getString() ; 
      g.setFont(new Font("TimesRoman", Font.PLAIN, width/10)); 
      g.drawString(Time, x, y);
      this.repaint();
   }
}
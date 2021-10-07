package views;
import javax.swing.border.Border;
import java.awt.*;

public class RoundedBorder implements Border {

    private int radio;  

    public RoundedBorder(int radius) {
        this.radio = radius;
    }  

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radio+1, this.radio+1, this.radio+2, this.radio);
    }  

    public boolean isBorderOpaque() {
        return true;
    }  

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radio, radio);
    }

  }

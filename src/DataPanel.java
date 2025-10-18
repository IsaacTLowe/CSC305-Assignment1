import javax.swing.JPanel;
import java.awt.*;

public class DataPanel extends JPanel{
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawString("Complexity", 100, 50);
        g.drawString("Size", 300, 50);
        g.drawString("Overall", 600, 50);

        g.drawRect(100, 100, 150, 400);
        g.fillRect(100, 100, 150, 400);
        g.drawRect(300, 100, 150, 400);
        g.fillRect(300, 100, 150, 400);

        g.drawOval(600, 100, 100, 100);
        g.fillOval(600, 100, 100, 100);
    }
}
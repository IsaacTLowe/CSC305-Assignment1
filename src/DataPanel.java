import javax.swing.*;
import java.awt.*;

public class DataPanel extends JPanel {
    private Blackboard blackboard;

    public DataPanel(Blackboard blackboard) {
        this.blackboard = blackboard;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("SansSerif", Font.PLAIN, 16));
        g.setColor(Color.BLACK);
        g.drawString("Complexity", 100, 50);
        g.drawString("Size", 300, 50);
        g.drawString("Overall", 600, 50);

        drawBars(g);
        drawFace(g);
    }

    private void drawBars(Graphics g) {
        int complexity = blackboard.getComplexity();
        int size = blackboard.getSize();

        g.setColor(Color.PINK);
        g.fillRect(100, 300 - complexity * 10, 50, complexity * 10);

        g.setColor(new Color(255, 180, 255));
        g.fillRect(300, 300 - size / 5, 50, size / 5);
    }

    private void drawFace(Graphics g) {
        boolean happy = blackboard.isHappy();
        g.setColor(Color.GREEN);
        if(happy) {
            g.setColor(Color.GREEN);
        } else {
            g.setColor(Color.RED);
        }
        g.fillOval(580, 100, 100, 100);
        g.setColor(Color.BLACK);
        g.drawOval(580, 100, 100, 100);
        g.fillOval(600, 130, 10, 10);
        g.fillOval(650, 130, 10, 10);
        if (happy) {
            g.drawArc(600, 150, 50, 20, 180, 180);
        }else {
            g.drawArc(600, 160, 50, 20, 0, 180);
        }
    }
}

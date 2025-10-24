import javax.swing.*;
import java.awt.*;

/**
 * Displays analysis results visually using bars and a face indicator.
 * Shows file complexity, size, and overall status based on the Blackboard data.
 *
 * @author Emily Harris
 * @author Isaac Lowe
 * @version 1.0
 */

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
        g.drawString("Complexity: " + blackboard.getComplexity(), 100, 50);
        g.drawString("Size:" + blackboard.getSize(), 300, 50);
        g.drawString("Overall", 600, 50);

        drawBars(g);
        drawFace(g);
    }

    private void drawBars(Graphics g) {
        int complexity = blackboard.getComplexity();
        int size = blackboard.getSize();
        int maxVal = 250;

        double complexityScale = 500.0 / maxVal;
        double sizeScale = 250.0 / maxVal;

        int complexityHeight = (int) (complexity * complexityScale);
        g.setColor(Color.BLUE);
        g.fillRect(100, 300 - complexityHeight, 50, complexityHeight);

        int sizeHeight = (int) (size * sizeScale);
        g.setColor(Color.GREEN);
        g.fillRect(300, 300 - sizeHeight, 50, sizeHeight);
    }

    private void drawFace(Graphics g) {
        boolean happy = blackboard.isHappy();

        g.setColor(Color.BLACK);
        g.drawOval(580, 100, 100, 100);

        if (happy) {
            g.setColor(Color.GREEN);
            g.fillOval(580, 100, 100, 100);
        } else if (!happy) {
            g.setColor(Color.RED);
            g.fillOval(580, 100, 100, 100);
        }

        g.setColor(Color.BLACK);
        g.fillOval(600, 130, 10, 10);
        g.fillOval(650, 130, 10, 10);

        if (happy) {
            g.drawArc(600, 150, 50, 20, 180, 180);
        } else {
            g.drawArc(600, 160, 50, 20, 0, 180);
        }
    }
}
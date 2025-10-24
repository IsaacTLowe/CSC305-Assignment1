/**
 * Stores data shared between program components,
 * including file size, complexity, and overall status.
 *
 * @author Emily Harris
 * @author Isaac Lowe
 * @version 1.0
 */

public class Blackboard {
    private int size;
    private int complexity;
    private boolean happy;

    public int getSize() { return size; }

    public int getComplexity() {
        return complexity;
    }

    public boolean isHappy() {
        return happy;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public void setHappy(boolean happy) {
        this.happy = happy;
    }
}
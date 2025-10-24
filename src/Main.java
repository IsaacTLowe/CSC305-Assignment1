import javax.swing.*;
import java.awt.*;

/**
 * The main class that starts the application.
 * It creates the main window and sets up the menu bar,
 * panels, and status bar for the user interface.
 *
 * @author Emily Harris
 * @author Isaac Lowe
 * @version 1.0
 */

public class Main extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }

    public Main() {
        Blackboard blackboard = new Blackboard();
        DataPanel dataPanel = new DataPanel(blackboard);
        FileListPanel fileListPanel = new FileListPanel();
        JLabel statusBar = new JLabel("status");
        setTitle("Title");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JMenuBar menuBar = new MenuBarController(this, fileListPanel, dataPanel, blackboard, statusBar).createMenuBar();
        setJMenuBar(menuBar);

        add(fileListPanel, BorderLayout.WEST);
        add(dataPanel, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);

        setVisible(true);
    }
}
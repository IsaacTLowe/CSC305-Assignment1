import javax.swing.*;
import java.awt.*;

/**
 * The main entry point for the Code Analyzer application.
 * <p>
 * This class creates the main window, initializes all panels,
 * and sets up the menu bar controller to handle user actions.
 * </p>
 *
 * @author Emmy Harris and Isaac Lowe
 * @version 1.0
 * @since 2025-10-20
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

        JMenuBar menuBar = new MenuBarController().createMenuBar(this, fileListPanel, dataPanel, blackboard, statusBar);
        setJMenuBar(menuBar);

        add(fileListPanel, BorderLayout.WEST);
        add(dataPanel, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);

        setVisible(true);
    }
}

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    private Blackboard blackboard = new Blackboard();
    private DataPanel dataPanel = new DataPanel(blackboard);
    private FileListPanel fileListPanel = new FileListPanel();
    private JLabel statusBar = new JLabel("status");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }

    public Main() {
        setTitle("Window Title");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Menus
        JMenuBar menuBar = new MenuBarController(this, fileListPanel, dataPanel, blackboard, statusBar).createMenuBar();
        setJMenuBar(menuBar);

        // Layout regions
        add(fileListPanel, BorderLayout.WEST);
        add(dataPanel, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);

        setVisible(true);
    }
}

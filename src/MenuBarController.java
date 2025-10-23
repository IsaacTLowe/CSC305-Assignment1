import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class MenuBarController {
    private JFrame parent;
    private FileListPanel fileListPanel;
    private DataPanel dataPanel;
    private Blackboard blackboard;
    private JLabel statusBar;
    private File currentFolder;

    public MenuBarController(JFrame parent, FileListPanel fileListPanel, DataPanel dataPanel,
                             Blackboard blackboard, JLabel statusBar) {
        this.parent = parent;
        this.fileListPanel = fileListPanel;
        this.dataPanel = dataPanel;
        this.blackboard = blackboard;
        this.statusBar = statusBar;
    }

    public JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open Folder");
        JMenuItem exitItem = new JMenuItem("Exit");

        JMenu actionMenu = new JMenu("Action");
        JMenuItem runItem = new JMenuItem("Run");

        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");

        openItem.addActionListener(e -> openFolder());
        exitItem.addActionListener(e -> System.exit(0));

        runItem.addActionListener(e -> runAnalysis());

        aboutItem.addActionListener(e ->
                JOptionPane.showMessageDialog(parent, "Code Analyzer\nCreated by: Your Name"));

        fileMenu.add(openItem);
        fileMenu.add(exitItem);
        actionMenu.add(runItem);
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(actionMenu);
        menuBar.add(helpMenu);

        return menuBar;
    }

    private void openFolder() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = chooser.showOpenDialog(parent);
        if (result == JFileChooser.APPROVE_OPTION) {
            currentFolder = chooser.getSelectedFile();
            fileListPanel.loadJavaFiles(currentFolder);
            statusBar.setText("Opened: " + currentFolder.getName());
        }
    }

    private void runAnalysis() {
        String selectedFile = fileListPanel.getSelectedFileName();
        if (selectedFile == null || currentFolder == null) {
            JOptionPane.showMessageDialog(parent, "Please select a file first.");
            return;
        }

        File file = new File(currentFolder, selectedFile);
        FileAnalyzer.analyze(file, blackboard);
        dataPanel.repaint();
        statusBar.setText("Analyzed: " + selectedFile);
    }
}

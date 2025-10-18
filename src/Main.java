import javax.swing.*;
import java.awt.*;


public class Main extends JFrame{

    public static void main(){
        Main frame = new Main();
        frame.setTitle("Title");
        frame.setSize(1000, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public Main(){
        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("Menu File");
        JMenu menuAction = new JMenu("Menu Action");
        JMenu menuHelp = new JMenu("Menu Help");

        JMenuItem open = new JMenuItem("Open");
        JMenuItem exit = new JMenuItem("Exit");

        JMenuItem run = new JMenuItem("Run");

        JMenuItem about = new JMenuItem("About");

        menuFile.add(open);
        menuFile.add(exit);

        menuAction.add(run);

        menuHelp.add(about);

        menuBar.add(menuFile);
        menuBar.add(menuAction);
        menuBar.add(menuHelp);

        add(menuBar, BorderLayout.NORTH);

        DataPanel data = new DataPanel();

        add(data, BorderLayout.CENTER);

        GridLayout fileGrid = new GridLayout(11, 1);
        JPanel filePanel = new JPanel(fileGrid);

        for(int i = 0; i < 11; i++){
            JTextField file = new JTextField("File " + (i + 1));
            filePanel.add(file);
        }
        add(filePanel, BorderLayout.WEST);


        JLabel status = new JLabel("status");
        add(status, BorderLayout.SOUTH);


    }


}

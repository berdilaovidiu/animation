package home.oberdila.animation;

import net.miginfocom.swing.MigLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import java.awt.Container;
import java.awt.Dimension;

/**
 * Created with IntelliJ IDEA.
 * User: ovidiu
 * Date: 10/8/13
 * Time: 7:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class ExpandAnimation {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                showUI();
            }
        });
    }

    private static void showUI() {
        JFrame applicationFrame = new JFrame();
        Container contentPane = getContentPane();
        applicationFrame.setContentPane(contentPane);
        applicationFrame.setSize(new Dimension(800, 600));
        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationFrame.setVisible(true);
    }

    private static Container getContentPane() {
        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("wrap 1"));
        panel.add(new CustomPanel(100, 500));
        panel.add(new CustomPanel(100, 500));
        panel.add(new CustomPanel(100, 500));
        panel.add(new CustomPanel(100, 500));
        panel.add(new CustomPanel(100, 500));
        panel.add(new CustomPanel(100, 500));
        panel.add(new CustomPanel(100, 500));
        panel.add(new CustomPanel(100, 500));
        panel.add(new CustomPanel(100, 500));

        return new JScrollPane(panel);
    }
}

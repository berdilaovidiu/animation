package home.oberdila.animation;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: ovidiu
 * Date: 10/8/13
 * Time: 7:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomPanel extends JPanel {
    private int minHeight;
    private int maxHeight;
    private boolean expanded;

    private JButton button;

    public CustomPanel(int minHeight, int maxHeight) {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.button = new JButton("Click");
        this.setBorder(new LineBorder(Color.RED, 2));
        this.setSize(500, minHeight);
        this.setMinimumSize(new Dimension(this.getWidth(), minHeight));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isExpanded()) {
                    collapse();
                } else {
                    expand();
                }
            }
        });

        this.add(button);
    }

    private void expand() {
        expanded = true;
        this.setSize(this.getWidth(), maxHeight);
    }

    private void collapse() {
        expanded = false;
        this.setSize(this.getWidth(), minHeight);
    }

    public boolean isExpanded() {
        return expanded;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}

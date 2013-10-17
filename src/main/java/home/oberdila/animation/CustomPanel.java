package home.oberdila.animation;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: ovidiu
 * Date: 10/8/13
 * Time: 7:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomPanel extends JPanel {
    private int minHeight;
    private int maxHeight;
    private boolean expanded;

    private JButton buttonSize;
    private JButton buttonColor;

    private Animator animator = new Animator();

    public CustomPanel(int minHeight, int maxHeight) {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.buttonSize = new JButton("Vertical Size");
        this.buttonColor = new JButton("Color");
        this.setBorder(new LineBorder(Color.RED, 2));
        this.setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension(700, minHeight));

        buttonSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isExpanded()) {
                    collapse();
                } else {
                    expand();
                }
                CustomPanel.this.revalidate();
            }
        });

        buttonColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animator.run(CustomPanel.this, new Animation<Color>(1000, Animation.Property.COLOR, new DiscreteColor(CustomPanel.this.getBackground(), Color.WHITE)));
            }
        });

        this.setLayout(new MigLayout());
        this.add(buttonSize);
        this.add(buttonColor);
    }

    private void expand() {
        animator.run(this, new Animation<Integer>(300, Animation.Property.HEIGHT, new DiscreteInteger(minHeight, maxHeight)));
        expanded = true;
    }

    private void collapse() {
        expanded = false;
        animator.run(this, new Animation<Integer>(300, Animation.Property.HEIGHT, new DiscreteInteger(maxHeight, minHeight)));
    }

    public boolean isExpanded() {
        return expanded;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private class DiscreteInteger extends DiscreteValue<Integer> {

        private DiscreteInteger(Integer initialValue, Integer finalValue) {
            super(initialValue, finalValue);
        }

        @Override
        public java.lang.Integer getValue(double ratio) {
            return (int) (initialValue + (finalValue - initialValue) * ratio);
        }
    }

    private class DiscreteColor extends DiscreteValue<Color> {

        private DiscreteColor(Color initialValue, Color finalValue) {
            super(initialValue, finalValue);
        }

        @Override
        public Color getValue(double ratio) {
            int red = (int) (initialValue.getRed() + (finalValue.getRed() - initialValue.getRed()) * ratio);
            int green = (int) (initialValue.getGreen() + (finalValue.getGreen() - initialValue.getGreen()) * ratio);
            int blue = (int) (initialValue.getBlue() + (finalValue.getBlue() - initialValue.getBlue()) * ratio);
            return new Color(red, green, blue);
        }
    }
}

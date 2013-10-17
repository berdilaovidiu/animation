package home.oberdila.animation;

import home.oberdila.animation.core.Animation;
import home.oberdila.animation.value.DiscreteColor;
import home.oberdila.animation.value.DiscreteInteger;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: ovidiu
 * Date: 10/8/13
 * Time: 7:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomPanel extends JPanel {
    public static final int ROUNDNESS = 4;
    private int minHeight;
    private int maxHeight;
    private boolean expanded;

    private JButton buttonSize;
    private JButton buttonColor;

    private Animator animator = new Animator();

    public CustomPanel(int minHeight, int maxHeight) {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;

        initComponents(minHeight);
        initLayout();
        initActions();
    }

    private void initComponents(int minHeight) {
        this.setOpaque(false);
        this.buttonSize = new JButton("Vertical Size");
        this.buttonColor = new JButton("Color");

        this.setBackground(Color.LIGHT_GRAY);
        this.setPreferredSize(new Dimension(700, minHeight));
    }

    private void initLayout() {
        this.setLayout(new MigLayout());
        this.add(buttonSize);
        this.add(buttonColor);
    }

    private void initActions() {
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
    }

    private void expand() {
        animator.run(this, new Animation<Integer>(700, Animation.Property.HEIGHT, Animation.Movement.NONLINEAR, new DiscreteInteger(minHeight, maxHeight)));
        expanded = true;
    }

    private void collapse() {
        expanded = false;
        animator.run(this, new Animation<Integer>(700, Animation.Property.HEIGHT, new DiscreteInteger(maxHeight, minHeight)));
    }

    public boolean isExpanded() {
        return expanded;
    }

    @Override
    protected void paintComponent(Graphics g) {
        int strokeWidth = 2;
        int temp = strokeWidth / 2;
        Graphics2D graphics2D = (Graphics2D) g.create();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setColor(getBackground());
        graphics2D.fillRoundRect(temp, temp, this.getWidth() - temp, this.getHeight() - temp, ROUNDNESS, ROUNDNESS);
        graphics2D.setColor(Color.BLACK);
        graphics2D.setStroke(new BasicStroke(strokeWidth));
        graphics2D.drawRoundRect(temp, temp, this.getWidth() - strokeWidth - 1, this.getHeight() - strokeWidth - 1, ROUNDNESS, ROUNDNESS);

        graphics2D.dispose();
    }

}

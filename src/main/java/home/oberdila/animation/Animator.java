package home.oberdila.animation;

import home.oberdila.animation.core.Animation;

import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: ovidiu
 * Date: 10/16/13
 * Time: 9:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Animator {

    public static final int DELAY = 33;

    public void run(final Container container, final Animation animation) {
        container.getHeight();

        final Timer timer;
        timer = new Timer(DELAY, new ActionListener() {
            int timeElapsed = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                timeElapsed += DELAY;
                int duration = animation.getDuration();
                double progress = 0;
                switch (animation.getMovement()) {
                    case LINEAR:
                        progress = timeElapsed / (double) duration;
                        break;
                    case NONLINEAR:
                        progress = getSinusFunction(timeElapsed / (double) duration);
                        break;
                }
                if (timeElapsed <= duration) {
                    switch (animation.getProperty()) {
                        case HEIGHT:
                            container.setPreferredSize(new Dimension(container.getWidth(), (Integer) animation.getDiscreteValue().getValue(progress)));
                            break;
                        case COLOR:
                            container.setBackground((Color) animation.getDiscreteValue().getValue(progress));
                            break;
                    }
                    container.revalidate();
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();

    }

    private float getSinusFunction(double progress) {
        return (float) Math.sin(progress * (float) Math.PI / 2);
    }

}

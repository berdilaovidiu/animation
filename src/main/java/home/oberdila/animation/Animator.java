package home.oberdila.animation;

import javax.swing.Timer;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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
                double progress = timeElapsed  / (double) duration;
                if (timeElapsed <= duration) {
                    switch (animation.getProperty()){
                        case HEIGHT:
                            container.setPreferredSize(new Dimension(container.getWidth(), (Integer)animation.getDiscreteValue().getValue(progress)));
                            break;
                        case COLOR:
                            container.setBackground((Color)animation.getDiscreteValue().getValue(progress));
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

}

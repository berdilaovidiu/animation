package home.oberdila.animation.value;

import java.awt.*;

/**
 * @author oberdila
 * @since 10/17/13
 */
public class DiscreteColor extends DiscreteValue<Color> {

    public DiscreteColor(Color initialValue, Color finalValue) {
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
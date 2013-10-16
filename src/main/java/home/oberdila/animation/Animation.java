package home.oberdila.animation;

/**
 * User: ovidiu
 * Date: 10/16/13
 * Time: 9:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Animation<T> {

    public enum Property {
        HEIGHT,
        WIDTH,
        COLOR,
        TRANSLUCENCY
    }

    private int duration;
    private Property property;
    private DiscreteValue<T> discreteValue;


    public Animation(int duration, Property property, DiscreteValue<T> discreteValue) {
        this.duration = duration;
        this.property = property;

        this.discreteValue = discreteValue;
    }

    public int getDuration() {
        return duration;
    }

    public Property getProperty() {
        return property;
    }

    public DiscreteValue<T> getDiscreteValue() {
        return discreteValue;
    }
}

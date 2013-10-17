package home.oberdila.animation.core;

import home.oberdila.animation.value.DiscreteValue;

/**
 * User: ovidiu
 * Date: 10/16/13
 * Time: 9:43 PM
 */
public class Animation<T> {

    public enum Property {
        HEIGHT,
        WIDTH,
        COLOR,
        TRANSLUCENCY
    }

    public enum Movement{
        LINEAR,
        NONLINEAR
    }

    private int duration;
    private Property property;
    private Movement movement;
    private DiscreteValue<T> discreteValue;


    public Animation(int duration, Property property, DiscreteValue<T> discreteValue) {
        this(duration, property, Movement.LINEAR, discreteValue);
    }

    public Animation(int duration, Property property, Movement movement, DiscreteValue<T> discreteValue) {
        this.duration = duration;
        this.property = property;
        this.movement = movement;

        this.discreteValue = discreteValue;
    }

    public int getDuration() {
        return duration;
    }

    public Property getProperty() {
        return property;
    }

    public Movement getMovement() {
        return movement;
    }

    public DiscreteValue<T> getDiscreteValue() {
        return discreteValue;
    }
}

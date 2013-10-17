package home.oberdila.animation.value;

/**
 * Created with IntelliJ IDEA.
 * User: ovidiu
 * Date: 10/16/13
 * Time: 11:05 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class DiscreteValue<T> {
    protected T initialValue;
    protected T finalValue;

    protected DiscreteValue(T initialValue, T finalValue) {
        this.initialValue = initialValue;
        this.finalValue = finalValue;
    }

    public abstract T getValue(double ratio);
}

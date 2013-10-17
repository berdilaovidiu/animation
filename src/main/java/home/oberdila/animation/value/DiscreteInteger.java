package home.oberdila.animation.value;


public class DiscreteInteger extends DiscreteValue<Integer> {

    public DiscreteInteger(Integer initialValue, Integer finalValue) {
        super(initialValue, finalValue);
    }

    @Override
    public Integer getValue(double ratio) {
        return (int) (initialValue + (finalValue - initialValue) * ratio);
    }
}

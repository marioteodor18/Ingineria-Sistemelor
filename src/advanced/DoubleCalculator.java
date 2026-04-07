package advanced;

public class DoubleCalculator extends ACalculator {

    public DoubleCalculator divide(double value) {
        if (value == 0.0) {
            throw new ArithmeticException("Cannot divide by 0");
        }

        this.state = (Double) this.state / value;
        return this;
    }
    @Override
    public void init(Object state) {
        this.state = (Double) state;
    }

    public DoubleCalculator add(double value) {
        this.state = (Double) this.state + value;
        return this;
    }

    public DoubleCalculator subtract(double value) {
        this.state = (Double) this.state - value;
        return this;
    }

    public DoubleCalculator multiply(double value) {
        this.state = (Double) this.state * value;
        return this;
    }
}
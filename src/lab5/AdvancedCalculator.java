package lab5;

public class AdvancedCalculator extends IntCaclulator {

public AdvancedCalculator(int state) {
    super(state);
}
public AdvancedCalculator divide (int state) {
    this.state /= state;
    return this;

}
public AdvancedCalculator power (int state) {
    this.state=(int)Math.pow(this.state,state);
    return this;

}
public AdvancedCalculator root (int state) {
    this.state=(int)Math.pow(this.state,1.0/state);
    return this;

}

}

package lab5;

public class IntCaclulator {
    protected int state;



    public IntCaclulator(int state ) {
this.state=state;
    }
public IntCaclulator add( int state) {
        this.state+=state;
        return this;
}
public IntCaclulator subtract(int state){
        this.state-=state;
        return this;

}
public IntCaclulator multiply(int state) {
        this.state*=state;
        return this;

}
public int result() {
        return this.state;
}



}

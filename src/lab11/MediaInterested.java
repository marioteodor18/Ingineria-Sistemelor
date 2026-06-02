package lab11;

public class MediaInterested implements Observer {
    private String name;

//11.3.1
    public MediaInterested(String name) {

        this.name = name;
    }

    public void update(String message) {

        System.out.println("["+name + "] received update: " + message);
    }
}
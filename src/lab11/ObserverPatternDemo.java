package lab11;
//11.3.1
public class ObserverPatternDemo {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel("Tech Explained");

        MediaInterested media1 = new MediaInterested("CNN");
        MediaInterested media2 = new MediaInterested("FoxNews");

        channel.addObserver(media1);
        channel.addObserver(media2);
        channel.uploadVideo("Observer pattern in java");

        channel.removeObserver(media2);
        channel.uploadVideo("Singleton pattern in java");



        String message1 = "Observer Pattern in Java";
        channel.uploadVideo(message1);
        media1.update(message1);
        media2.update(message1);

        String message2 = "Singleton Pattern in Java";
        channel.uploadVideo(message2);
        media1.update(message2);
    }
}

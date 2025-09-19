import java.util.*;

// Subject
class Channel {
    private List<Subscriber> subscribers = new ArrayList<>();
    
    void subscribe(Subscriber s) { subscribers.add(s); }
    void unsubscribe(Subscriber s) { subscribers.remove(s); }
    
    void uploadVideo(String title) {
        System.out.println("Channel uploaded: " + title);
        notifyAllSubscribers(title);
    }
    
    private void notifyAllSubscribers(String title) {
        for (Subscriber s : subscribers) {
            s.update(title);
        }
    }
}

// Observer
interface Subscriber {
    void update(String videoTitle);
}

// Concrete Observer
class User implements Subscriber {
    private String name;
    User(String name) { this.name = name; }
    public void update(String videoTitle) {
        System.out.println(name + " notified of new video: " + videoTitle);
    }
}

// Usage
public class ObervablePattern {
    public static void main(String[] args) {
        Channel channel = new Channel();
        
        User u1 = new User("Chirag");
        User u2 = new User("Rahul");
        
        channel.subscribe(u1);
        channel.subscribe(u2);
        
        channel.uploadVideo("Observer Pattern in Java");

        channel.unsubscribe(u2);

        channel.uploadVideo("Observer Pattern in Java 2");
        // Both Chirag & Rahul get notified
    }
}

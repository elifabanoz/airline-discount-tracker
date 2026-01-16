import java.util.ArrayList;
import java.util.List;

// ConcreteObserver - User
public class User implements Observer {
    private String name;
    private UserType userType;
    private List<String> notifications;

    public User(String name, UserType userType) {
        this.name = name;
        this.userType = userType;
        this.notifications = new ArrayList<>();
    }

    @Override
    public void update(String airlineName, String discount) {
        String notification = "[" + userType + "] " + name + " received: " + airlineName + " - " + discount;
        notifications.add(notification);
        System.out.println(notification);
    }

    public String getName() {
        return name;
    }

    public UserType getUserType() {
        return userType;
    }

    public List<String> getNotifications() {
        return notifications;
    }
}
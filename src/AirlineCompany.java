import java.util.ArrayList;
import java.util.List;

// ConcreteSubject - Airline Company
public class AirlineCompany implements Subject {
    private String name;
    private List<Observer> observers;
    private String currentDiscount;

    public AirlineCompany(String name) {
        this.name = name;
        this.observers = new ArrayList<>();
    }

    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("A user subscribed to " + name);
        }
    }

    @Override
    public void detach(Observer observer) {
        if (observers.remove(observer)) {
            System.out.println("A user unsubscribed from " + name);
        }
    }

    @Override
    public void notifyObservers() {
        System.out.println("\n" + name + " notifying " + observers.size() + " subscribers about: " + currentDiscount);
        for (Observer observer : observers) {
            observer.update(name, currentDiscount);
        }
    }

    public void setDiscount(String discount) {
        this.currentDiscount = discount;
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    public String getCurrentDiscount() {
        return currentDiscount;
    }
}
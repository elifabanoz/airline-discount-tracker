// Client - Main class demonstrating Observer Pattern
public class Client {
    public static void main(String[] args) {
        // Create airline companies (ConcreteSubjects)
        AirlineCompany thy = new AirlineCompany("THY");
        AirlineCompany lufthansa = new AirlineCompany("Lufthansa");
        AirlineCompany sunexpress = new AirlineCompany("Sunexpress");

        // Create users with different types (ConcreteObservers)
        User regularUser = new User("Eylül", UserType.REGULAR);
        User vipUser = new User("Elif", UserType.VIP);
        User goldUser = new User("İlke", UserType.GOLD);

        System.out.println("--- Subscribing users to airlines ---");
        // Users subscribe to different airlines
        thy.attach(regularUser);
        thy.attach(vipUser);
        thy.attach(goldUser);

        lufthansa.attach(vipUser);
        lufthansa.attach(goldUser);

        sunexpress.attach(goldUser);

        // Airlines announce discounts
        System.out.println("\n--- Airlines announcing discounts ---");
        thy.setDiscount("20% off on domestic flights!");
        lufthansa.setDiscount("30% off on European routes!");
        sunexpress.setDiscount("15% off on holiday packages!");

        // A user unsubscribes
        System.out.println("\n--- Elif unsubscribes from THY ---");
        thy.detach(regularUser);

        // THY announces new discount
        thy.setDiscount("50% Black Friday Special!");

        // Display gold user's notification history
        System.out.println("\n--- Gold user (İlke) notification history ---");
        for (String notification : goldUser.getNotifications()) {
            System.out.println("  " + notification);
        }

        System.out.println("\n END OF DEMONSTRATION ");
    }
}

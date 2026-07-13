public class PushNotification implements Notification{

    @Override
    public void send(String mssg) {
        IO.println("Notification : " + mssg);
    }
}


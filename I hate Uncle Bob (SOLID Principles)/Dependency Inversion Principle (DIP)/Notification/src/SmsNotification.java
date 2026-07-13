public class SmsNotification implements Notification{

    @Override
    public void send(String mssg) {
        IO.println("SMS : " + mssg);
    }
}

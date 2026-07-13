public class EmailNotification implements Notification{
    @Override
    public void send(String mssg) {
        IO.println("Email : " + mssg);
    }
}

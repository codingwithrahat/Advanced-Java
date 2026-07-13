void main(){
    Notification e = new EmailNotification();
    Notification s = new SmsNotification();
    Notification p = new PushNotification();


    NotificationService ne = new NotificationService(e, "Hi");
    NotificationService ns = new NotificationService(s, "Hlw");
    NotificationService np = new NotificationService(p, "Hi");

    ne.sendMssg();
    ns.sendMssg();
    np.sendMssg();



}
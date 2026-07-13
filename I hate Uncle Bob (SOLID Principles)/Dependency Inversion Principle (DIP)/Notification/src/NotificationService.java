public class NotificationService {
    Notification n;
    String mssg;

    NotificationService(Notification n, String mssg){
        this.n = n;
        this.mssg = mssg;
    }

    void sendMssg(){
        n.send(mssg);
    }
}

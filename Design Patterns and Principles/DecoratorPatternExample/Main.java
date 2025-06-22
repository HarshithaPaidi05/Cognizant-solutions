
interface Notifier {
    void send(String message);
}


class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}


abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send(String message) {
        notifier.send(message); 
    }
}


class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message); 
        System.out.println("Sending SMS: " + message); 
    }
}


class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message); 
        System.out.println("Sending Slack Message: " + message); 
    }
}


public class Main {
    public static void main(String[] args) {
        
        Notifier emailNotifier = new EmailNotifier();

       
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

        
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        System.out.println("---- Notification Chain ----");
        slackNotifier.send("Meeting at 5 PM");
    }
}

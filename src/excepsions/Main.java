package excepsions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

enum Status {
    NEW,
    SENT,
    RESENDING
}


public class Main {
    public static void main(String[] args) throws NoNetworkException {
        EmailSender emailSender = new EmailSender();
        emailSender.sendEmail(emails());
    }

    static List<Email> emails(){
        return new ArrayList<>()
        {
            {
                add(new Email("Gavejas1@gmail.com", "code", "java"));
                add(new Email("Gavejas2@gmail.com", "code", "C#"));
                add(new Email("Gavejas3@gmail.com", "code", "c++"));
                add(new Email("Gavejas4@gmail.com", "code", "ruby"));
            }
        };
    }
}


class Email {

    private String to;
    private String subject;
    private String body;
    private Status status;

    Email(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.status = Status.NEW;
    }


    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}

class EmailSender {

    public void sendEmail(List<Email> emails) throws NoNetworkException {

        ArrayList<Email> resendingEmails = new ArrayList<>();
        while(!emails.isEmpty()) {
            for (Email email : emails) {
                try {
                    if (email.getStatus().equals(Status.RESENDING)) {
                        System.out.println(String.format("RESENDING email to: %s", email.getTo()));
                    }
                    else {
                        System.out.println(String.format("SENDING email to: %s", email.getTo()));
                    }
                    NetworkConnector.send(email);
                    email.setStatus(Status.SENT);
                    System.out.println(String.format("SUCCESSFULLY sent email to: %s", email.getTo()));
                } catch (NoNetworkException e) {
                    email.setStatus(Status.RESENDING);
                    resendingEmails.add(email);
                    System.out.println(String.format("FAILED to send email to: %s", email.getTo()));
                }
            }
            emails = resendingEmails;
            resendingEmails = new ArrayList<>();
            System.out.println();
            if (!emails.isEmpty()){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ignore){

                }
            }
        }
    }
}

class NetworkConnector {

    public static void send(Object o) throws NoNetworkException {

        Random rand = new Random();
        int n = rand.nextInt(10);
        try {
            int i = 1 / n;
        } catch (ArithmeticException e) {
            throw new NoNetworkException();
        }
    }
}

class NoNetworkException extends Exception {
    public NoNetworkException() {

    }
}


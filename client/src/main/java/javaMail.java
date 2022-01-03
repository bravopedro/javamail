
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

    public class javaMail{
        public static void sendMail(String recepient) throws MessagingException {
            System.out.println("Preparing to send");
            Properties properties = new Properties();

            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host","smtp.gmail.com");
            properties.put("mail.smtp.port", "587");

            final String myAccountEmail = "bravostockpicker@gmail.com";
            final String password = "qdAp?KGvYyrjfC82gSsX";

            Session session = Session.getInstance(properties, new Authenticator(){
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(myAccountEmail,password);
                }
            });
            Message message = prepareMessage(session, myAccountEmail, recepient);

            Transport.send(message);
            System.out.println("Stock picks have sucessfully been sent");
        }

        private static Message prepareMessage(Session session,String myAccountEmail, String recipient){
            Message message = new MimeMessage(session);
            try {
                System.out.println("Sending...");
                message.setFrom(new InternetAddress(myAccountEmail));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
                message.setSubject("Daily Stock Picks");
                message.setText(" This Email Should be sending the top 10 stocks of the day");
                return message;
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            return null;
        }

    }


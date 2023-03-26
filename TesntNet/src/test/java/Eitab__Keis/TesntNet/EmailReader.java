package Eitab__Keis.TesntNet;

import java.util.Properties;
import javax.mail.*;


public class EmailReader {
    
    public static void main(String[] args) throws Exception {
    	//the email that we want to read
		String subject="OMG! Something big just landed at SHEIN CLUB!";

        // set up the properties for the mail session
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        props.setProperty("mail.imap.host", "your.imap.host");
        props.setProperty("mail.imap.port", "993");
        props.setProperty("mail.imap.ssl.enable", "true");

        // create a session with the IMAP server using the username and password
        Session session = Session.getDefaultInstance(props, null);
        Store store = session.getStore("imaps");
        store.connect("imap.gmail.com","itab.keis@gmail.com","jbjrrejrnpffluky");
        
        // get the inbox folder
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);
        
        // retrieve the messages from the inbox
        Message[] messages = inbox.getMessages();
        
       
        // print out the subject and body of each message
  
        for (int i = messages.length-1  ; i >=0 ; i--) {
        	Message message = messages[i];

            if (message.getSubject().contains(subject)){
        		System.out.println("Subject: " + message.getSubject());
        		System.out.println("From: " + message.getFrom()[0]);
                break;
            }
            
        }
       
        // close the inbox folder and store connection
        inbox.close(false);
        store.close();
    }
}
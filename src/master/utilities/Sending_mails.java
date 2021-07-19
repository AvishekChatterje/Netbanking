package master.utilities;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Sending_mails 
{
	public void sendEmail(String to,String pass) 
	{
		String from="avichat50@gmail.com";
		String sub="Password ";
		String msg="The Password is "+pass;
		String host="smtp.gmail.com";
		Properties pr=System.getProperties();
		pr.put("mail.smtp.host", host);
		pr.put("mail.smtp.port","465" );
		pr.put("mail.smtp.ssl.enable","true");
		pr.put("mail.smtp.auth", "true");
		 Session s=Session.getInstance(pr, new Authenticator() 
		 {
			 @Override
			protected PasswordAuthentication getPasswordAuthentication() 
			{
				return new PasswordAuthentication("avichat50@gmail.com","31012001avishek");
			}
		});
		 try
		 {
			 MimeMessage mm=new MimeMessage(s);
			 mm.setFrom(new InternetAddress(from));
			 mm.addRecipient(Message.RecipientType.TO ,new InternetAddress(to));
			 mm.setSubject(sub);
			 mm.setText(msg);
			 Transport.send(mm);
			 System.out.println("Email set successfully");
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	}

}

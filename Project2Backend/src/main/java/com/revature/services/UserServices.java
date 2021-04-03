package com.revature.services;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.revature.model.User;
import com.revature.repository.UserDao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
public class UserServices {
	
	private UserDao userDao;

	public User findByEmailAndPass(String email, String password) {
		User user = this.userDao.findByEmailAndPassword(email, password);
		if (user == null) {
			return null;
		}
		return user;
	}

	public List<User> getAll() {
		return this.userDao.findAll();

	}

	public User getUserById(int userId) {
		User user = this.userDao.findUserByUserId(userId);
		if (user == null) {
			return null;
		}
		return user;
	}
	
	public User getUserByEmail(String email) {
		User user = userDao.findUserByEmail(email);
		if (user == null) {
			return null;
		}
		return user;
	}

	public User insertUser(User user) {
		return this.userDao.save(user);
	}

	public void deleteUser(User user) {
		this.userDao.delete(user);
	}
	
	public void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
        	message.setFrom(new InternetAddress(from));
			InternetAddress[] toAddress = new InternetAddress[to.length];

		
			for( int i = 0; i < to.length; i++ ) {
				toAddress[i] = new InternetAddress(to[i]);
			}

			for( int i = 0; i < toAddress.length; i++) {
				message.addRecipient(Message.RecipientType.TO, toAddress[i]);
			}
            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }

}

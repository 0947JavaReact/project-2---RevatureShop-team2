package com.revature.services;

import java.util.List;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import com.revature.dao.UserDao;
import com.revature.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class UserServices {
	
	@Autowired
	private UserDao userDao;

	public User findByEmailAndPass(String email, String password) {
		 User user = userDao.findByEmailAndPassword(email, password);
		 return user;
	}

	public List<User> getAll() {
		return userDao.findAll();
	}

	public User getUserById(int id) {
		User user = userDao.findUserById(id);
		if (user == null) {
			return null;
		}
		return user;
	}
	/*
	* Get the email from the current user
	*/
	public User getUserByEmail(String email) {
		User user = userDao.findUserByEmail(email);
		if (user == null) {
			return null;
		}
		return user;
	}

	public User insertUser(User user) {
		return userDao.save(user);
	}

	public void deleteUser(User user) {
		userDao.delete(user);
	}
	/*
	* Send email from gmail using the Revatureshop email I created
	*/
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


package com.his.admin.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.his.admin.dtos.UserDTO;

@Component
public class EmailUtils {
		
	private JavaMailSender mailSender;

	public EmailUtils(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public Boolean sendUnlockAccountMail(UserDTO userDTO) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
		
		boolean isSent = false;
		try {
			messageHelper.setTo(userDTO.getEmail());
			messageHelper.setSubject("Unlock Your Account");
			messageHelper.setText(mailBody(userDTO),true);
			mailSender.send(mimeMessage);
			isSent = true;
		} catch (MessagingException | IOException e) {
			e.printStackTrace();
		}
		return isSent;
	}

	private String mailBody(UserDTO userDTO) throws IOException {
		File file = new ClassPathResource("UNLOCK-ACCT-EMAIL-BODY-TEMPLATE.txt").getFile();
		return Files.lines(file.toPath())
					.map(strBody -> {
						strBody = strBody.replace("{FNAME}", userDTO.getFirstName());
						strBody = strBody.replace("{LNAME}", userDTO.getLastName());
						strBody = strBody.replace("{TEMP-PWD}", userDTO.getPazzword());
						strBody = strBody.replace("{EMAIL}", userDTO.getEmail());
						return strBody;
					})
					.collect(Collectors.joining());
	}
}
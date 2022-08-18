package common.mailServer.mail.sender.service.process.multipart;

import common.mailServer.mail.sender.dto.MailProcessDto;
import common.mailServer.mail.sender.service.process.abstractProcess.CreateMessage;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.Date;

@Component
public class DefaultCreateMessage implements CreateMessage<MailProcessDto> {
	@Override
	public MimeMessage createMessage(MailProcessDto mailProcessDto) throws MessagingException {
		MimeMessage message = new MimeMessage(mailProcessDto.getPropertiesEnum().getSession());
		message.setFrom(new InternetAddress(mailProcessDto.getPropertiesEnum().getUser()));
		InternetAddress[] recipients = Arrays.stream(mailProcessDto.getRecipients()).map(recipient -> {
			try {
				return new InternetAddress(recipient);
			} catch (AddressException e) {
				e.printStackTrace();
			}
			return null;
		}).toArray(InternetAddress[]::new);
		message.addRecipients(Message.RecipientType.TO, recipients);
		message.setSubject(mailProcessDto.getSubject());
		message.setSentDate(new Date());
		return message;
	}

}

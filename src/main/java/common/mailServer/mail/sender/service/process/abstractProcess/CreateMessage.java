package common.mailServer.mail.sender.service.process.abstractProcess;

import common.mailServer.mail.sender.dto.MailProcessDto;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public interface CreateMessage<T extends MailProcessDto> {
	MimeMessage createMessage(T mailProcessDto) throws MessagingException;
}

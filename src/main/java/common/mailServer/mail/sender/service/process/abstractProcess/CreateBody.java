package common.mailServer.mail.sender.service.process.abstractProcess;

import common.mailServer.mail.sender.dto.MailProcessDto;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import java.io.IOException;

public interface CreateBody<T extends MailProcessDto> {
	Multipart createBody(T mailProcessDto) throws IOException, MessagingException;
}

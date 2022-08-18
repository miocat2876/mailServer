package common.mailServer.mail.sender.service.template.defaultTemplate;

import common.mailServer.mail.sender.dto.MailDto;
import common.mailServer.mail.sender.dto.MailProcessDto;
import common.mailServer.mail.sender.service.process.abstractProcess.CreateBody;
import common.mailServer.mail.sender.service.process.abstractProcess.CreateLog;
import common.mailServer.mail.sender.service.process.abstractProcess.CreateMessage;
import common.mailServer.mail.sender.service.template.MailMultipartTemplate;
import lombok.RequiredArgsConstructor;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@RequiredArgsConstructor
public abstract class MailMultipartDefault extends MailMultipartTemplate<MailDto> {

	private final CreateMessage<MailProcessDto> defaultCreateMessage;
	private final CreateBody<MailProcessDto> defaultCreateBody;
	private final CreateLog<MailProcessDto> defaultCreateLog;

	@Override
	protected MimeMessage createMessage(MailProcessDto mailProcessDto) throws MessagingException {
		return defaultCreateMessage.createMessage(mailProcessDto);
	}
	@Override
	protected Multipart createBody(MailProcessDto mailProcessDto) throws MessagingException, IOException {
		return defaultCreateBody.createBody(mailProcessDto);
	}
	@Override
	protected boolean createLog(MailProcessDto mailProcessDto) {
		return defaultCreateLog.createLog(mailProcessDto);
	}
}

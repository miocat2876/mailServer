package common.mailServer.mail.sender.service.template.defaultTemplate;

import common.mailServer.mail.sender.config.MailPropertiesType;
import common.mailServer.mail.sender.dto.MailProcessDto;
import common.mailServer.mail.sender.service.process.abstractProcess.CreateBody;
import common.mailServer.mail.sender.service.process.abstractProcess.CreateLog;
import common.mailServer.mail.sender.service.process.abstractProcess.CreateMessage;
import org.springframework.stereotype.Service;

@Service
public class MailMultipartDefaultDaum extends MailMultipartDefault {

	public MailMultipartDefaultDaum(CreateMessage<MailProcessDto> defaultCreateMessage, CreateBody<MailProcessDto> defaultCreateBody, CreateLog<MailProcessDto> defaultCreateLog) {
		super(defaultCreateMessage, defaultCreateBody, defaultCreateLog);
	}

	@Override
	protected MailPropertiesType getMailPropertiesEnum() {
		return MailPropertiesType.daum;
	}
}

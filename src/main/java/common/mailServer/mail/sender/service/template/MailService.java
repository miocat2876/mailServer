package common.mailServer.mail.sender.service.template;

import common.mailServer.mail.sender.dto.MailDto;
import common.mailServer.mail.sender.dto.MailStateDto;

import javax.mail.MessagingException;

public interface MailService<T extends MailDto> {

	MailStateDto<String> sender(T dto) throws Exception;
}

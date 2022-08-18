package common.mailServer.mail.sender.service.process.abstractProcess;

import common.mailServer.mail.sender.dto.MailProcessDto;

public interface CreateLog<T extends MailProcessDto> {
	boolean createLog(T mailProcessDto);
}

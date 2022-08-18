package common.mailServer.mail.sender.service.process.multipart;

import common.mailServer.mail.sender.dao.MailDao;
import common.mailServer.mail.sender.dto.MailProcessDto;
import common.mailServer.mail.sender.service.process.abstractProcess.CreateLog;
import common.mailServer.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class DefaultCreateLog implements CreateLog<MailProcessDto> {
	private final MailDao mailDao;
	@Override
	public boolean createLog(MailProcessDto mailProcessDto) {
		log.info(DateUtil.dateNowFull() + " 메일 발송" + mailProcessDto.getMailStatusCodeType().getStatusMessage());
		mailDao.mailSenderLogInsert(mailProcessDto);
		return true;
	}
}

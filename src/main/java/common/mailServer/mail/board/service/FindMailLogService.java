package common.mailServer.mail.board.service;

import common.mailServer.mail.board.dao.MailDetailLogDao;
import common.mailServer.mail.board.dao.MailSenderLogDao;
import common.mailServer.mail.board.dto.MailLogDto;
import common.mailServer.mail.board.dto.MailLogPagingDto;
import common.mailServer.mail.board.mapper.MailDetailLogMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
@Service
public class FindMailLogService {
	private final MailSenderLogDao mailSenderLogDao;
	private final MailDetailLogDao mailDetailLogDao;

	public Map<String,Object> findBySenderLog(MailLogPagingDto mailLogPagingDto){
		return mailSenderLogDao.findBySenderLog(mailLogPagingDto);
	}

	public Map<String,Object> findByDetailLog(String id){
		return mailDetailLogDao.findByLogs(id);
	}
}

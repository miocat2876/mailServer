package common.mailServer.mail.board.mapper;

import common.mailServer.mail.board.dto.MailLogDto;
import common.mailServer.mail.board.dto.MailLogPagingDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MailSenderLogMapper<T extends MailLogPagingDto> {
	List<MailLogDto> findBySenderLog(T mailSenderLogDto);
	int findBySenderLogCount(T mailSenderLogDto);
}

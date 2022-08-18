package common.mailServer.mail.board.mapper;

import common.mailServer.mail.board.dto.MailLogDto;
import common.mailServer.mail.board.dto.MailLogFileDto;
import common.mailServer.mail.board.dto.MailLogRecipientDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MailDetailLogMapper {
	List<MailLogRecipientDto> findByRecipienstLog(String mailLogDto);
	List<MailLogFileDto> findByFilesLog(String id);
}

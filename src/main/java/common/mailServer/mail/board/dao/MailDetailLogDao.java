package common.mailServer.mail.board.dao;

import common.mailServer.mail.board.dto.MailLogDto;
import common.mailServer.mail.board.dto.MailLogPagingDto;
import common.mailServer.mail.board.mapper.MailDetailLogMapper;
import common.mailServer.mail.board.mapper.MailSenderLogMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
@Repository
public class MailDetailLogDao {
	public final List<MailLogPagingDto> nullReplace = new ArrayList<>();

	private final MailDetailLogMapper mailDetailLogMapper;

	public Map<String,Object> findByLogs(String id){
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("recipients",mailDetailLogMapper.findByRecipienstLog(id));
		resultMap.put("files",mailDetailLogMapper.findByFilesLog(id));
		return resultMap;
	}
}

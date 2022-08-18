package common.mailServer.mail.board.dao;

import common.mailServer.mail.board.dto.MailLogDto;
import common.mailServer.mail.board.dto.MailLogPagingDto;
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
public class MailSenderLogDao {
	public final List<MailLogPagingDto> nullReplace = new ArrayList<>();

	private final MailSenderLogMapper<MailLogPagingDto> mailSenderLogMapper;

	public Map<String,Object> findBySenderLog(MailLogPagingDto mailLogPagingDto){
		Map<String,Object> resultMap = new HashMap<>();
		int totalCount = mailLogPagingDto.getTotalRowCount() > 0 ? mailLogPagingDto.getTotalRowCount() : mailSenderLogMapper.findBySenderLogCount(mailLogPagingDto);
		resultMap.put("totalCount",totalCount);
		if(totalCount > 0){
			resultMap.put("list",mailSenderLogMapper.findBySenderLog(mailLogPagingDto));
		}else{
			resultMap.put("list",nullReplace);
		}
		resultMap.put("viewRow",mailLogPagingDto.getViewRow());
		return resultMap;
	}
}

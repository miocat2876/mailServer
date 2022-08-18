package common.mailServer.mail.sender.dao;

import common.mailServer.mail.sender.dto.MailProcessDto;
import common.mailServer.mail.sender.mapper.MailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Repository
@RequiredArgsConstructor
public class MailDao {
	private final MailMapper mailMapper;

	@Transactional
	public <T extends MailProcessDto> void mailSenderLogInsert(T mailProcessDto){
		mailMapper.senderLogInsert(mailProcessDto);
		int result = mailMapper.findByMaxNum();
		HashMap<String, Object> map = new HashMap<>();
		map.put("maxNum",result);
		map.put("recipients",mailProcessDto.getRecipients());
		mailMapper.recipientsLogInsert(map);
		if(mailProcessDto.getMailProcessType().name().equals("FILE")){
			map.put("files",mailProcessDto.getFiles());
			mailMapper.fileLogInsert(map);
		}
	}
}

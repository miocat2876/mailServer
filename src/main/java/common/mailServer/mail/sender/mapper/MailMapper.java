package common.mailServer.mail.sender.mapper;

import common.mailServer.mail.sender.dto.MailDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface MailMapper {
	int senderLogInsert(MailDto mailDto);
	int findByMaxNum();
	int recipientsLogInsert(Map<String,Object> map);
	int fileLogInsert(Map<String,Object> map);

}

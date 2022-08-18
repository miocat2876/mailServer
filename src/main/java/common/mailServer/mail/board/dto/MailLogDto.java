package common.mailServer.mail.board.dto;

import common.mailServer.mail.sender.dto.MailDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailLogDto extends MailDto {
	private String num;
	private String date;
	private String sender;
	private String status;
	private String recipient;
}


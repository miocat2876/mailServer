package common.mailServer.mail.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailLogFileDto extends MailLogDto {
	private String fileName;
	private String extension;
}

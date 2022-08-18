package common.mailServer.mail.sender.config;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum MailStatusCodeType {

	SUCCESS(HttpStatus.OK.value(),"성공"), FAIL(HttpStatus.INTERNAL_SERVER_ERROR.value(),"실패");

	private final int statusCode;
	private final String statusMessage;

	MailStatusCodeType(int statusCode, String statusMessage){
		this.statusCode    = statusCode;
		this.statusMessage = statusMessage;
	}
}

package common.mailServer.mail.sender.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel("전송결과에 대한 반환 객체")
public class MailStateDto<T> {
	@ApiModelProperty(value = "반환메세지", required = true, example = "성공", dataType = "String", name = "message", notes = "반환메세지 성공/실패/예외...")
	private String message;
	@ApiModelProperty(value = "상태코드", required = true, example = "200", dataType = "int", name = "status", notes = "200/400/500...")
	private int status;
	@ApiModelProperty(value = "반환값", required = true, example = "dto...", dataType = "T", name = "data", notes = "반환 값, dto...")
	private T data;
	public MailStateDto(String message, int status, T data){
		this.message = message;
		this.status = status;
		this.data = data;
	}
}

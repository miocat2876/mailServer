package common.mailServer.mail.sender.dto;

import common.mailServer.mail.sender.config.options.MailOptionType;
import common.mailServer.mail.sender.config.template.MailTemplateType;
import common.mailServer.mail.sender.config.type.MailType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ApiModel("전송을 위한 파라미터 객체")
public class MailDto {
	@ApiModelProperty(value = "프로젝트명", required = true, example = "ExampleProject", dataType = "String", name = "projectName", notes = "")
	@NotBlank(message = "프로젝트명[String projectName]은 필수 입니다")
	private String projectName;
	@ApiModelProperty(value = "수신자", required = true, example = "example@example.com", dataType = "String[]", name = "recipients", notes = "수신자값을 배열로")
	@NotNull(message = "수신자[String[] recipients]는 필수 입니다")
	private String[] recipients;
	@ApiModelProperty(value = "제목", required = true, example = "안녕하세요.", dataType = "String", name = "subject", notes = "")
	@NotBlank(message = "제목[String subject]은 필수 입니다")
	private String subject;
	@ApiModelProperty(value = "내용", required = true, example = "내용입니다.", dataType = "String", name = "text", notes = "text/html 타입으로 내용 전송")
	@NotBlank(message = "내용[String text]은 필수 입니다")
	private String text;
	@ApiModelProperty(value = "파일", required = false, dataType = "String", name = "files", notes = "파일값을 배열로")
	private MultipartFileCustomDto[] files;
	@ApiModelProperty(value = "DEFAULT/CUSTOM/TEMPLATE", required = false, example = "커스텀일 경우 {0} {1} 구분자를 통한 값을 주입함", dataType = "String", name = "type", notes = "메일 생성 기능 옵션")
	private MailType mailType = MailType.DEFAULT;
	@ApiModelProperty(value = "RANDOM_KEY", required = false, example = "RANDOM_KEY", dataType = "String", name = "option", notes = "옵션 생성 기능 옵션")
	private MailOptionType mailOption;
	@ApiModelProperty(value = "DEFAULT", required = false, example = "DEFAULT", dataType = "String", name = "template", notes = "템플릿 생성 기능 옵션")
	private MailTemplateType mailTemplate;
}

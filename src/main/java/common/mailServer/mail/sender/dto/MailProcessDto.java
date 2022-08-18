package common.mailServer.mail.sender.dto;

import common.mailServer.mail.sender.config.MailProcessType;
import common.mailServer.mail.sender.config.MailPropertiesType;
import common.mailServer.mail.sender.config.MailStatusCodeType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailProcessDto extends MailDto{
	private MailProcessType mailProcessType = MailProcessType.MESSAGE;
	private String sender;
	private String user;
	private String status;
	public String getSender() {
		return propertiesEnum.getUser();
	}
	public String getUser() {
		return propertiesEnum.getUser();
	}
	public String getStatus() {
		return mailStatusCodeType.getStatusMessage();
	}
	private MailPropertiesType propertiesEnum;
	private MailStatusCodeType mailStatusCodeType;
}

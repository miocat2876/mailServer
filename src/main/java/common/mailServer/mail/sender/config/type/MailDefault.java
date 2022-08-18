package common.mailServer.mail.sender.config.type;

import common.mailServer.mail.sender.dto.MailDto;

public enum MailDefault implements Types {

	DEFAULT();

	@Override
	public String getValue(MailDto mailDto) {
		return mailDto.getText();
	}
}

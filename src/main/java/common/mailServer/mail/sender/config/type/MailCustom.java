package common.mailServer.mail.sender.config.type;

import common.mailServer.mail.sender.dto.MailDto;
import common.mailServer.util.DataUtil;

public enum MailCustom implements Types {

	CUSTOM();

	@Override
	public String getValue(MailDto mailDto) {
		if(mailDto.getMailOption() == null) throw new RuntimeException("옵션타입이 존재 하지 않습니다");
		String optionValue = mailDto.getMailOption().getFunction().apply(mailDto);
		return DataUtil.customReplace(mailDto.getText(),optionValue);
	}
}

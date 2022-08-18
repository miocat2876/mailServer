package common.mailServer.mail.sender.config.type;

import common.mailServer.mail.sender.config.template.TemplateType;
import common.mailServer.mail.sender.dto.MailDto;
import common.mailServer.util.DataUtil;

public enum MailTemplate implements Types {

	TEMPLATE();

	@Override
	public String getValue(MailDto mailDto) {
		if(mailDto.getMailOption() == null) throw new RuntimeException("옵션타입이 존재 하지 않습니다");
		if(mailDto.getMailTemplate() == null) throw new RuntimeException("템플릿타입이 존재 하지 않습니다");
		String optionValue   = mailDto.getMailOption().getFunction().apply(mailDto);
		if(!DataUtil.isNotNull(optionValue)) throw new RuntimeException("옵션값이 존재 하지 않습니다");
		TemplateType template = mailDto.getMailTemplate().getTemplate(mailDto.getMailOption());
		return DataUtil.customReplace(template.createTemplate(),optionValue);
	}
}

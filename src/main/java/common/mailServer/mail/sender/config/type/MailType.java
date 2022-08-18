package common.mailServer.mail.sender.config.type;

import common.mailServer.mail.sender.dto.MailDto;
import lombok.Getter;

import java.util.function.Function;

@Getter
public enum MailType {

	DEFAULT(MailDefault.DEFAULT::getValue),
	CUSTOM(MailCustom.CUSTOM::getValue),
	TEMPLATE(MailTemplate.TEMPLATE::getValue);

	private final Function<MailDto,String> function;
	MailType(Function<MailDto, String> function) {
		this.function = function;
	}

	public Function<MailDto, String> getFunction() {
		return function;
	}
}

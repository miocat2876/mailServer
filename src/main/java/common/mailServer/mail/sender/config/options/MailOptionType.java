package common.mailServer.mail.sender.config.options;

import common.mailServer.mail.sender.dto.MailDto;
import lombok.Getter;
import java.util.function.Function;

@Getter
public enum MailOptionType {

	RANDOM_KEY((mailDto)->{return RandomKeyOption.createOption();});
	private final Function<MailDto,String> function;
	MailOptionType(Function<MailDto,String> function){
		this.function = function;
	}
}

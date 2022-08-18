package common.mailServer.mail.sender.config.template;

import common.mailServer.mail.sender.config.options.MailOptionType;

public interface TemplateType {
	String createTemplate();
	MailOptionType getOption();
}

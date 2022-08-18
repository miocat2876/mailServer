package common.mailServer.mail.sender.config.template;

import common.mailServer.mail.sender.config.options.MailOptionType;
import lombok.Getter;

import java.util.Arrays;

public enum MailTemplateType {

	DEFAULT(new TemplateType[] {RandomKeyTemplateType.DEFAULT});

	private final TemplateType[] templates;
	MailTemplateType(TemplateType[] templates){
		this.templates = templates;
	}

	public TemplateType getTemplate(MailOptionType option){
		return Arrays.stream(templates)
				.filter(templateType -> templateType.getOption() == option)
				.findAny()
				.orElse(null);
	}
}

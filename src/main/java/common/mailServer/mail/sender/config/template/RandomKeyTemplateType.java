package common.mailServer.mail.sender.config.template;

import common.mailServer.mail.sender.config.options.MailOptionType;

public enum RandomKeyTemplateType implements TemplateType {

	DEFAULT("<div class=\"wrapper\" style=\"width: 100%;\">\n" +
			"    <div style=\"margin: 0 auto; border: 1px solid black; width: 200px; padding: 2rem 1rem; display: flex; align-items: center; flex-direction: column;\">\n" +
			"        <div class=\"subject\" style=\"margin-bottom: 1rem;\">안녕하세요.</div>\n" +
			"        <div class=\"content\">코드 : {0} 입니다</div>\n" +
			"    </div>\n" +
			"</div>");

	private final String template;

	RandomKeyTemplateType(String template) {
		this.template = template;
	}

	@Override
	public String createTemplate() {
		return template;
	}

	@Override
	public MailOptionType getOption() {
		return MailOptionType.RANDOM_KEY;
	}
}


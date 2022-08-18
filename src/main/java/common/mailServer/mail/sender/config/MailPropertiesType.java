package common.mailServer.mail.sender.config;

import lombok.Getter;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

@Getter
public enum MailPropertiesType {

	daum("","",""),
	my("","","");
	private final String user;
	private final String password;
	private final String host;

	MailPropertiesType(String user, String password, String host) {
		this.user     = user;
		this.password = password;
		this.host     = host;
	}
	public Session getSession(){
		return Session.getInstance(PropertiesEnum.PROPERTIES.getProperties(host), new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
	}
	private enum PropertiesEnum{
		PROPERTIES(new Properties());
		private final Properties prop;
		PropertiesEnum(Properties properties) {
			properties.put("mail.smtp.port", 465);
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.ssl.enable", "true");
			properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
			this.prop = properties;
		}
		public Properties getProperties(String host) {
			prop.put("mail.smtp.host", host);
			prop.put("mail.smtp.ssl.trust", host);
			return prop;
		}
	}
}
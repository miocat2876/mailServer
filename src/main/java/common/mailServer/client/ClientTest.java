package common.mailServer.client;

import org.springframework.http.ResponseEntity;

public class ClientTest {

	public static void main(String[] args) throws Exception {
		ResponseEntity<String> responseEntity = new MailServerClient()
				.setProjectName("테스트프로젝트")
				.setRecipient("kkm1640@naver.com")
				.setSubject("테스트메일")
				.setText("내용")
				.setFile("C:\\Users\\kim\\Downloads\\IMG_0036.png")
				.setMailType(MailServerClient.MailType.DEFAULT)
				.setMailOption(MailServerClient.MailOptionType.RANDOM_KEY)
				.setMailTemplate(MailServerClient.MailTemplateType.DEFAULT)
				.call();
	}
}

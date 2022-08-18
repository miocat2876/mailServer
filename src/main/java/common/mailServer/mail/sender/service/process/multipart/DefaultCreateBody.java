package common.mailServer.mail.sender.service.process.multipart;

import common.mailServer.mail.sender.dto.MailProcessDto;
import common.mailServer.mail.sender.dto.MultipartFileCustomDto;
import common.mailServer.mail.sender.service.process.abstractProcess.CreateBody;
import common.mailServer.util.FileUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;

@Log4j2
@Component
public class DefaultCreateBody implements CreateBody<MailProcessDto> {
	@Override
	public Multipart createBody(MailProcessDto mailProcessDto) throws MessagingException {
		Multipart multipart       = new MimeMultipart();
		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setContent(mailProcessDto.getMailType()
				.getFunction()
				.apply(mailProcessDto),"text/html; charset=UTF-8");
		multipart.addBodyPart(mimeBodyPart);
		if(mailProcessDto.getMailProcessType().name().equals("FILE")){
			for (MultipartFileCustomDto multipartFileCustomDto : mailProcessDto.getFiles()){
				DataSource fileDataSource = new DefaultDataSource(multipartFileCustomDto);
				DataHandler dataHandler   = new DataHandler(fileDataSource);
				MimeBodyPart fileBodyPart = new MimeBodyPart();
				fileBodyPart.setDataHandler(dataHandler);
				fileBodyPart.setFileName(multipartFileCustomDto.getFileName());
				multipart.addBodyPart(fileBodyPart);
			}
		}
		return multipart;
	}
}

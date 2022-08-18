package common.mailServer.mail.sender.service.template;

import common.mailServer.mail.sender.config.MailProcessType;
import common.mailServer.mail.sender.config.MailPropertiesType;
import common.mailServer.mail.sender.config.MailStatusCodeType;
import common.mailServer.mail.sender.dto.MailDto;
import common.mailServer.mail.sender.dto.MailProcessDto;
import common.mailServer.mail.sender.dto.MailStateDto;
import common.mailServer.util.DataUtil;
import common.mailServer.util.FileUtil;
import common.mailServer.util.config.FileFilterType;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class MailMultipartTemplate<T extends MailDto> implements MailService<T> {

	public MailStateDto<String> sender(T dto) throws MessagingException {
		MailProcessDto mailProcessDto = DataUtil.dtoCopy(dto, new MailProcessDto());
		if (mailProcessDto.getFiles() != null && mailProcessDto.getFiles().length > 0){
			mailProcessDto.setMailProcessType(MailProcessType.FILE);
			List<FileFilterType> FileFilter = new ArrayList<>();
			FileFilter.add(FileFilterType.IS_REAL_FILES);
			FileFilter.add(FileFilterType.HAS_PERMIT_EXTENSION);
			if(FileUtil.isNotAvailableFiles(FileFilter, mailProcessDto.getFiles())) throw new MessagingException("파일이 없거나 허용하지 않은 확장자 입니다.");
		}
		mailProcessDto.setMailStatusCodeType(MailStatusCodeType.SUCCESS);
		try {
		mailProcessDto.setPropertiesEnum(getMailPropertiesEnum());//프로퍼티생성
		MimeMessage message = createMessage(mailProcessDto);//메시지생성
		Multipart multipart = createBody(mailProcessDto);//내용생성
		message.setContent(multipart);
		Transport.send(message);
		} catch (MessagingException | IOException e) {
			mailProcessDto.setMailStatusCodeType(MailStatusCodeType.FAIL);
		}
		createLog(mailProcessDto);//로그생성
		return MailStateDto.<String>builder()
				.status(mailProcessDto.getMailStatusCodeType().getStatusCode())
				.message(mailProcessDto.getMailStatusCodeType().getStatusMessage())
				.data(dto.toString()).build();
	}

    protected abstract MailPropertiesType getMailPropertiesEnum();
	protected abstract MimeMessage createMessage(MailProcessDto mailProcessDto) throws MessagingException;
	protected abstract Multipart createBody(MailProcessDto mailProcessDto) throws MessagingException, IOException;
	protected abstract boolean createLog(MailProcessDto mailProcessDto);

}

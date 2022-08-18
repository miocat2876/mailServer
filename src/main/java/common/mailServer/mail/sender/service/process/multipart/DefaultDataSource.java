package common.mailServer.mail.sender.service.process.multipart;

import common.mailServer.mail.sender.dto.MultipartFileCustomDto;
import common.mailServer.util.FileUtil;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.DataSource;
import java.io.*;

public class DefaultDataSource implements DataSource {

	private final MultipartFileCustomDto multipartFileCustomDto;
	private final MultipartFile multipartFile;

	public DefaultDataSource(MultipartFileCustomDto multipartFileCustomDto) {
		this.multipartFileCustomDto = multipartFileCustomDto;
		this.multipartFile = multipartFileCustomDto.getMultipartFile();
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return multipartFile.getInputStream();
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		File file = FileUtil.multipartFileToFile(multipartFileCustomDto);
		return new FileOutputStream(file);
	}

	@Override
	public String getContentType() {
		return multipartFile.getContentType();
	}

	@Override
	public String getName() {
		return multipartFile.getName();
	}
}

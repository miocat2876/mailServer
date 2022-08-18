package common.mailServer.mail.sender.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
public class MultipartFileCustomDto {
	private String fileName;
	private String saveFileName;
	private String extension;
	private String baseDir;
	private MultipartFile multipartFile;
}

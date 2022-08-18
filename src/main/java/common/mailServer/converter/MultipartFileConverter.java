package common.mailServer.converter;

import common.mailServer.mail.sender.dto.MultipartFileCustomDto;
import common.mailServer.util.DataUtil;
import common.mailServer.util.PropertyUtil;
import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

public class MultipartFileConverter implements Converter<MultipartFile, MultipartFileCustomDto> {

	@SneakyThrows
	@Override
	public MultipartFileCustomDto convert(MultipartFile source) {
		return MultipartFileCustomDto
				.builder()
				.fileName(source.getOriginalFilename())
				.saveFileName(DataUtil.getUuid())
				.extension(Objects.requireNonNull(source.getOriginalFilename()).replaceAll(".*\\.",""))
				.multipartFile(source)
				.baseDir(PropertyUtil.getProperty("upload.baseDir"))
				.build();
	}
}

package common.mailServer.util;

import common.mailServer.mail.sender.dto.MultipartFileCustomDto;
import common.mailServer.util.config.FileFilterType;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@Log4j2
public class FileUtil {
	public static File multipartFileToFile(MultipartFileCustomDto multipartFileCustomDto) throws IOException {
		if(multipartFileCustomDto == null) throw new NullPointerException("파일이 없습니다.");
		File file = new File(multipartFileCustomDto.getBaseDir() + multipartFileCustomDto.getSaveFileName());
		multipartFileCustomDto.getMultipartFile().transferTo(file);
		return file;
	}

	public static boolean isNotAvailableFiles(List<FileFilterType> FileFilterTypes, MultipartFileCustomDto[] multipartFileCustomDtos){
		return !Arrays.stream(multipartFileCustomDtos)
				.allMatch((dto) -> FileFilterTypes.stream()
						.allMatch((fileFilterType) -> fileFilterType.getFunction().apply(dto)));
	}

	public static boolean hasPermitExtensions(MultipartFileCustomDto[] multipartFileCustomDtos){
		return Arrays.stream(multipartFileCustomDtos)
				.allMatch(FileFilterType.HAS_PERMIT_EXTENSION.getFunction()::apply);
	}
}

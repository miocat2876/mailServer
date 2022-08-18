package common.mailServer.util.config;

import common.mailServer.mail.sender.config.MailExtensionType;
import common.mailServer.mail.sender.dto.MultipartFileCustomDto;
import lombok.Getter;
import java.util.Arrays;
import java.util.function.Function;

public enum FileFilterType{
	HAS_PERMIT_EXTENSION(FileFilterType::isRealFiles),
	IS_REAL_FILES(FileFilterType::hasPermitExtension);

	@Getter
	private final Function<MultipartFileCustomDto,Boolean> function;

	FileFilterType(Function<MultipartFileCustomDto, Boolean> function) {
		this.function = function;
	}

	private static boolean hasPermitExtension(MultipartFileCustomDto multipartFileCustomDto){
		return Arrays.stream(MailExtensionType.IMAGE.getValues()).anyMatch((permitExtension)->
				permitExtension.getName().equals(multipartFileCustomDto.getExtension()));
	}
	private static boolean isRealFiles(MultipartFileCustomDto multipartFileCustomDto){
		return multipartFileCustomDto.getMultipartFile() != null;
	}
}
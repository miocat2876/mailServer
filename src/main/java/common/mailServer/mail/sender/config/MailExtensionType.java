package common.mailServer.mail.sender.config;

import common.mailServer.mail.sender.config.extension.ExtensionType;
import common.mailServer.mail.sender.config.extension.ImageType;
import lombok.Getter;

@Getter
public enum MailExtensionType {
    IMAGE(ImageType.getTypes());
    private final ExtensionType<? extends Enum<?>>[] values;
    MailExtensionType(ExtensionType<? extends Enum<?>>[] values) {
        this.values = values;
    }
}

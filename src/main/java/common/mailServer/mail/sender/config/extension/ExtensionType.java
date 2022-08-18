package common.mailServer.mail.sender.config.extension;

public interface ExtensionType<T extends Enum<T>> {
    String getName();
}

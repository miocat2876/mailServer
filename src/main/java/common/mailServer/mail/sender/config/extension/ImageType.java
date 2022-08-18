package common.mailServer.mail.sender.config.extension;

public enum ImageType implements ExtensionType<ImageType> {

    jpg, jpeg, png, gif;

    public static ImageType[] getTypes() {
        return values();
    }
    @Override
    public String getName() {
        return name();
    }
}

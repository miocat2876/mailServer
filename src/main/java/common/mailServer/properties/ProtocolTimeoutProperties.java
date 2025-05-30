package common.mailServer.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "protocol.timeout")
public class ProtocolTimeoutProperties {
    private final Protocol smtp;
    private final Protocol imap;
    private final Protocol pop3;

    @Getter
    @RequiredArgsConstructor
    public static final class Protocol {
        private final int connect;
        private final int read;
    }
}


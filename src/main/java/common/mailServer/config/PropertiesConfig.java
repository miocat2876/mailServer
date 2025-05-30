package common.mailServer.config;

import common.mailServer.properties.FileProperties;
import common.mailServer.properties.ProtocolTimeoutProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {
        FileProperties.class,
        ProtocolTimeoutProperties.class
})
public class PropertiesConfig {
}

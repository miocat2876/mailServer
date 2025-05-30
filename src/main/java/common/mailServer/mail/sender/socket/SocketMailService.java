package common.mailServer.mail.sender.socket;

import common.mailServer.properties.ProtocolTimeoutProperties;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SignatureException;

/**
 * 소켓을 이용하여 메일을 전송하기 위한 서비스.
 * DKIM 서명과 SPF 검사를 수행한 뒤 메일을 전송한다.
 */
public class SocketMailService {
    private final SimpleSmtpSocketClient smtpClient;

    public SocketMailService(String host, int port, ProtocolTimeoutProperties.Protocol timeout) {
        this.smtpClient = new SimpleSmtpSocketClient(host, port, timeout.getConnect(), timeout.getRead());
    }

    public void send(String from, String to, String data, PrivateKey dkimKey)
            throws IOException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        // DKIM 서명 생성 (샘플)
        String signature = DkimUtil.sign(data, dkimKey);
        StringBuilder builder = new StringBuilder();
        builder.append("DKIM-Signature: ").append(signature).append("\r\n");
        builder.append(data);

        // SPF 확인 (실제 구현 필요)
        SpfUtil.checkSpf(from.substring(from.indexOf('@') + 1), "0.0.0.0");

        smtpClient.send(from, to, builder.toString());
    }
}


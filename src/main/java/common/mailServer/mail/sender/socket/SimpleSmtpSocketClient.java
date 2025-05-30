package common.mailServer.mail.sender.socket;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * SMTP 서버와 소켓 통신을 통해 메일을 전송하는 간단한 클라이언트.
 * 프로토콜별 소켓 타임아웃 설정을 위해 생성자에서 timeout 값을 전달받아 사용한다.
 */
public class SimpleSmtpSocketClient {
    private final String host;
    private final int port;
    private final int connectTimeout;
    private final int readTimeout;

    public SimpleSmtpSocketClient(String host, int port, int connectTimeout, int readTimeout) {
        this.host = host;
        this.port = port;
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
    }

    /**
     * 기본적인 SMTP 통신 과정을 통해 메일을 전송한다.
     * 실제 환경에서는 인증 과정과 TLS 처리가 필요하다.
     */
    public void send(String from, String to, String data) throws IOException {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), connectTimeout);
            socket.setSoTimeout(readTimeout);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // 연결 확인
            reader.readLine();
            writer.write("HELO " + host + "\r\n");
            writer.flush();
            reader.readLine();

            writer.write("MAIL FROM:<" + from + ">\r\n");
            writer.flush();
            reader.readLine();

            writer.write("RCPT TO:<" + to + ">\r\n");
            writer.flush();
            reader.readLine();

            writer.write("DATA\r\n");
            writer.flush();
            reader.readLine();

            writer.write(data);
            writer.write("\r\n.\r\n");
            writer.flush();
            reader.readLine();

            writer.write("QUIT\r\n");
            writer.flush();
        }
    }
}


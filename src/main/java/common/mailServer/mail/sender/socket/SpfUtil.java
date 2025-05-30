package common.mailServer.mail.sender.socket;

/**
 * SPF 검사 유틸리티의 간단한 골격.
 * DNS 조회가 필요한 부분은 실제 구현에서 추가해야 한다.
 */
public class SpfUtil {
    public static boolean checkSpf(String domain, String ipAddress) {
        // TODO: DNS SPF 레코드 조회 후 IP 확인 로직 구현
        return true;
    }
}


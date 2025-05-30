package common.mailServer.mail.sender.socket;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

/**
 * 간단한 DKIM 서명 유틸리티.
 * 실제 DKIM 스펙을 완벽히 구현하지는 않으며 샘플용으로 사용한다.
 */
public class DkimUtil {
    public static String sign(String data, PrivateKey key) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature sig = Signature.getInstance("SHA256withRSA");
        sig.initSign(key);
        sig.update(data.getBytes(StandardCharsets.UTF_8));
        byte[] signed = sig.sign();
        return Base64.getEncoder().encodeToString(signed);
    }
}


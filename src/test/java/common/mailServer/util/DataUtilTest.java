package common.mailServer.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DataUtilTest {

    @Test
    void customReplaceReplacesIndexedPlaceholders() {
        String original = "value {0} and {1}";
        String result = DataUtil.customReplace(original, "first", "second");
        assertEquals("value first and second", result);
    }
}

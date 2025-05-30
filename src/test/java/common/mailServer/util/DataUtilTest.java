package common.mailServer.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataUtilTest {

    @Test
    void customReplace_replacesPlaceholders() {
        String original = "{0} and {1}";
        String result = DataUtil.customReplace(original, "first", "second");
        assertEquals("first and second", result);
    }
}

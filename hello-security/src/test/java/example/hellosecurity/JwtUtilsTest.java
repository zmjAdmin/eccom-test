package example.hellosecurity;

import example.hellosecurity.common.util.JwtUtil;
import org.junit.jupiter.api.Test;

public class JwtUtilsTest {

    @Test
    public void createJwtTest() {
        System.out.println(JwtUtil.createJWT("12345"));
    }

}

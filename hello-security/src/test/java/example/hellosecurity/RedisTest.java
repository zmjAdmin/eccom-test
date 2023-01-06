package example.hellosecurity;

import example.hellosecurity.common.util.RedisCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisCache redisCache;

    @Test
    public void testRedis() {
        redisCache.setCacheObject("name", "zmj");
    }

}

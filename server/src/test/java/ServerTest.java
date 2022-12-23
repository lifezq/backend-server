import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Package PACKAGE_NAME
 * @ClassName ServerTest
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/23
 */
@SpringBootTest(classes = {ServerTest.class})
public class ServerTest {

    @Test
    public void testPassword() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println("123456 after encode:" + bCryptPasswordEncoder.encode("123456"));

    }
}

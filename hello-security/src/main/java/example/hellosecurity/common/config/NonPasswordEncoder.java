package example.hellosecurity.common.config;

import org.springframework.security.crypto.password.PasswordEncoder;

public class NonPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (encodedPassword == null) {
            return false;
        }
        return encodedPassword.equals(rawPassword.toString());
    }

}

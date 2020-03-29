package ltxrest.ltx.configration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordConfiguration {
    public BCryptPasswordEncoder passwordEncoderProvider(){
        return new BCryptPasswordEncoder();
    }
}

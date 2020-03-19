package ltxrest.ltx.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoder {
    public BCryptPasswordEncoder passwordEncoderProvider(){
        return new BCryptPasswordEncoder();
    }
}

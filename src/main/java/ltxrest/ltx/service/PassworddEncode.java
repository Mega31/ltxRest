package ltxrest.ltx.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PassworddEncode {
    public BCryptPasswordEncoder passworddEncode(){
        return new BCryptPasswordEncoder();
    }
}

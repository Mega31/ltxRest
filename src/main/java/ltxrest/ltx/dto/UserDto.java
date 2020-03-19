package ltxrest.ltx.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserDto {
    private long id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String confirmPassword;
    private String role;
    private String gender;

}

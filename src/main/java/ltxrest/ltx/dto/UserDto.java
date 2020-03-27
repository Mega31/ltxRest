package ltxrest.ltx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserDto {
    private String first_name;
    private String last_name;
    private String email;
    @JsonProperty( value = "password", access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @JsonProperty( value = "confirmPassword", access = JsonProperty.Access.WRITE_ONLY)
    private String confirmPassword;
    private String gender;
    private RoleDto roleIds;
}

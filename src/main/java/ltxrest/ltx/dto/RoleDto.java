package ltxrest.ltx.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class RoleDto {
    private int id;
    private String role;

}

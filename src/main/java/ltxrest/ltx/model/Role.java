package ltxrest.ltx.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_role",schema = "userdata")
@Data

public class Role {
    @Id
    private int id;
    private String role;
    @OneToMany
     @JoinTable(joinColumns = @JoinColumn(name = "role_user",referencedColumnName = "id"))
    private List<MyUser> user;
}

package ltxrest.ltx.model;

import lombok.Data;
import lombok.ToString;


import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Entity
@Table(name = "user_role",schema = "userdata")
@Data
@ToString(onlyExplicitlyIncluded = true)
public class Role {
    @Id
    private int id;
    private String role;
    @OneToMany(fetch =FetchType.LAZY)
    @JoinTable(joinColumns = @JoinColumn(name = "role_user",referencedColumnName = "id"))
    private List<MyUser> user;
}

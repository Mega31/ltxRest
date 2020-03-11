package ltxrest.ltx.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_details",schema = "userdata")
@Data
public class UserModel {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String gender;
}

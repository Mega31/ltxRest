package ltxrest.ltx.model;


import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Arrays;
import java.util.Collection;


@Entity
@Data
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "user_details",schema = "userdata")
public class MyUser implements UserDetails {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Lob
    private byte[] profile_pic;
    private String first_name;
    private String last_name;
    @Column(name = "email",unique = true)
    private String username;
    private String password;
    private String gender;
    @ManyToOne
    @JoinColumn(name = "role_user", referencedColumnName = "id")

    private Role role;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(role.getRole()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

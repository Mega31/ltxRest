package ltxrest.ltx.repo;

import ltxrest.ltx.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<MyUser,Long> {
    public MyUser findByUsername(String username);
}

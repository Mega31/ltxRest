package ltxrest.ltx.repo;

import ltxrest.ltx.model.MyUser;
import ltxrest.ltx.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserModel,Long> {
    public MyUser findByEmail(String email);

}

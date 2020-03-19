package ltxrest.ltx.repo;

import ltxrest.ltx.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<MyUser,Long> {
    MyUser findByUsername(String username);

}

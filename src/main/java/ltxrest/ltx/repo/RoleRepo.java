package ltxrest.ltx.repo;

import ltxrest.ltx.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Integer> {
    Role findByRole(String role);
}

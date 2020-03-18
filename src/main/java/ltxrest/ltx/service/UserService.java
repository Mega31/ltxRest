package ltxrest.ltx.service;

import ltxrest.ltx.model.MyUser;
import ltxrest.ltx.model.Role;
import ltxrest.ltx.repo.RoleRepo;
import ltxrest.ltx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PassworddEncode encode;
    @Autowired
    private RoleRepo roleRepo;
    public boolean passwordChecker(MyUser user){
        if (user.getPassword().equals(user.getConfirmPassword())){
            return true;
        }
        return false;
    }
    public void save(MyUser user){

        user.setPassword(encode.passworddEncode().encode(user.getPassword()));
        user.setRole((roleRepo.findByRole("ROLE_USER")));
        userRepo.save(user);
    }
}

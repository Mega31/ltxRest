package ltxrest.ltx.core;

import ltxrest.ltx.configration.PasswordConfiguration;
import ltxrest.ltx.model.MyUser;
import ltxrest.ltx.repo.RoleRepo;
import ltxrest.ltx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordConfiguration encode;
    @Autowired
    private RoleRepo roleRepo;

    public boolean passwordChecker(String userpass,String confirmpass){
        if (userpass.equals(confirmpass)){
            return true;
        }
        return false;
    }
    public void save(MyUser user){
        user.setPassword(encode.passwordEncoderProvider().encode(user.getPassword()));
        user.setRole((roleRepo.findById(1)));
        userRepo.save(user);
    }
}

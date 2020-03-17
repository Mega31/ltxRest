package ltxrest.ltx.service;

import ltxrest.ltx.model.MyUser;
import ltxrest.ltx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    @Autowired
    UserRepo userRepo;
    public boolean passwordChecker(MyUser user){
        if (user.getPassword().equals(user.getConfirmPassword())){
            return true;
        }
        return false;
    }
    public void save(MyUser user){
        user.setFirst_name(user.getFirst_name());
        user.setLast_name(user.getLast_name());
        user.setUsername(user.getUsername());
        user.setGender(user.getGender());
        user.setPassword(user.getPassword());
        user.setRole(user.getRole());
        userRepo.save(user);
    }
}

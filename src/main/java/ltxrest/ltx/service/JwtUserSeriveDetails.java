package ltxrest.ltx.service;

import ltxrest.ltx.model.MyUser;
import ltxrest.ltx.model.UserModel;
import ltxrest.ltx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserSeriveDetails implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;




    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException  {
      MyUser user = userRepo.findByEmail(email);
        if (user!=null){
            return user;
        }
        throw new UsernameNotFoundException("User '" + email + "' not found");

    }

}

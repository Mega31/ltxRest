package ltxrest.ltx.service;

import lombok.AllArgsConstructor;
import ltxrest.ltx.model.MyUser;
import ltxrest.ltx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException  {
      MyUser user = userRepo.findByUsername(email);
        if (user!=null){
            return user;
        }
        throw new UsernameNotFoundException("User '" + email + "' not found");
    }


}

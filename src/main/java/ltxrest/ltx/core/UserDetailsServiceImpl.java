package ltxrest.ltx.core;

import ltxrest.ltx.dto.RegDto;
import ltxrest.ltx.mapper.UserDtoMapper;
import ltxrest.ltx.model.MyUser;
import ltxrest.ltx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserDtoMapper userDtoMapper;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException  {
      MyUser user = userRepo.findByUsername(email);
        if (user!=null){
            return user;
        }
        throw new UsernameNotFoundException("User '" + email + "' not found");
    }
    public RegDto loadByEmail(String email) throws UsernameNotFoundException{
        RegDto regDto = userDtoMapper.toRegDto(userRepo.findByUsername(email));

        if (regDto !=null){
            return regDto;
        }
        throw new UsernameNotFoundException("User '" + email + "' not found");
    }

}

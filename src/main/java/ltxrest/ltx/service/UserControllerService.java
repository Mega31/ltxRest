package ltxrest.ltx.service;

import ltxrest.ltx.core.UserDetailsServiceImpl;
import ltxrest.ltx.dto.RegDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserControllerService {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    public RegDto loadUserProfile(String currentUser){
        return userDetailsService.loadByEmail(currentUser);
    }
}

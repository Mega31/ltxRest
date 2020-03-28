package ltxrest.ltx.controller;

import ltxrest.ltx.dto.UserDto;
import ltxrest.ltx.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping(path="/profile")
    public UserDto loadUserProfile(Authentication auth){
    return userDetailsService.loadByEmail(auth.getName());
    }
}

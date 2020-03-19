package ltxrest.ltx.controller;

import lombok.AllArgsConstructor;
import ltxrest.ltx.model.MyUser;
import ltxrest.ltx.repo.RoleRepo;
import ltxrest.ltx.repo.UserRepo;
import ltxrest.ltx.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user/admin/panel")
public class AdminController {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo role;
    @GetMapping(path = "/{username}")
    public UserDetails fetchUser(@PathVariable("username") String username) throws UsernameNotFoundException {
        return  userDetailsService.loadUserByUsername(username);
    }
}

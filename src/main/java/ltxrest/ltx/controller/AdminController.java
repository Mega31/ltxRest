package ltxrest.ltx.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import ltxrest.ltx.dto.UserDto;
import ltxrest.ltx.mapper.UserDtoMapper;
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
    @Autowired
    private UserDtoMapper userDtoMapper;
    @GetMapping(path = "/{username}")
    public UserDto fetchUser(@PathVariable("username") String username) throws UsernameNotFoundException {

        UserDto userDto = userDetailsService.loadByEmail(username);

        return userDto;
    }
}

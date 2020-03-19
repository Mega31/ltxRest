package ltxrest.ltx.controller;

import lombok.AllArgsConstructor;
import ltxrest.ltx.model.MyUser;
import ltxrest.ltx.repo.UserRepo;
import ltxrest.ltx.service.UserDetailsServiceImpl;
import ltxrest.ltx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/Rest/sign-up")
public class RegController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;
    @PostMapping
    public String signUp(@RequestBody MyUser user){
        if ((userRepo.findByUsername(user.getUsername())!= null)){
            return "user alredy exists";
        }
        if (userService.passwordChecker(user)){
            userService.save(user);
            return "you can go back and login";
        }

        return "password did not match";
    }
}

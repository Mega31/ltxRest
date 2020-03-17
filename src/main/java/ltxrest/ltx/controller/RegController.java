package ltxrest.ltx.controller;

import ltxrest.ltx.model.MyUser;
import ltxrest.ltx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Rest/sign-up")
public class RegController {
    @Autowired
    private UserService userService;
    @PostMapping
    public boolean signUp(@RequestBody MyUser user){
        if (userService.passwordChecker(user)){
            userService.save(user);
        }
        return false;
    }
}

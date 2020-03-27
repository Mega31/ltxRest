package ltxrest.ltx.controller;

import lombok.AllArgsConstructor;
import ltxrest.ltx.dto.UserDto;
import ltxrest.ltx.mapper.UserDtoMapper;
import ltxrest.ltx.model.MyUser;
import ltxrest.ltx.repo.UserRepo;
import ltxrest.ltx.service.UserDetailsServiceImpl;
import ltxrest.ltx.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Rest/sign-up")
public class RegController {
    private Logger logger = LoggerFactory.getLogger(RegController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private  UserDtoMapper userDtoMapper;
    @PostMapping
    public String signUp(@RequestBody UserDto userDto){
        if ((userRepo.findByUsername(userDto.getEmail())!= null)){
            logger.debug("User alredy exists.user email:"+userDto.getEmail());
            return "user alredy exists";
        }
        if (userService.passwordChecker(userDto.getPassword(),userDto.getConfirmPassword())){
            userService.save(userDtoMapper.toUser(userDto));
            logger.debug("creating user:"+userDto.getEmail());
            return "you can go back and login";
        }
        logger.debug("password did not match");
        return "password did not match";
    }
}

package ltxrest.ltx.controller;

import ltxrest.ltx.dto.RegDto;
import ltxrest.ltx.mapper.UserDtoMapper;
import ltxrest.ltx.repo.UserRepo;
import ltxrest.ltx.core.UserService;
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
    public String signUp(@RequestBody RegDto regDto){
        if ((userRepo.findByUsername(regDto.getEmail())!= null)){
            logger.debug("User alredy exists.user email:"+ regDto.getEmail());
            return "user alredy exists";
        }
        if (userService.passwordChecker(regDto.getPassword(), regDto.getConfirmPassword())){
            userService.save(userDtoMapper.toRegDto(regDto));
            logger.debug("creating user:"+ regDto.getEmail());
            return "you can go back and login";
        }
        logger.debug("password did not match");
        return "password did not match";
    }
}

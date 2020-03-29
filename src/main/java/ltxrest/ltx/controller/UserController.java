package ltxrest.ltx.controller;

import ltxrest.ltx.dto.RegDto;
import ltxrest.ltx.service.UserControllerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserControllerService userControllerService;
    @GetMapping(path="/profile")
    public RegDto fetchProfile(Authentication auth){
        return userControllerService.loadUserProfile(auth.getName());
    }
    @PutMapping(path = "/uploadProfile")
    public String uploadProfilePic(@RequestParam("file")MultipartFile file){

        return "uploading failed";
    };
}

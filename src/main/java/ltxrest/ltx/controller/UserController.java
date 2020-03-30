package ltxrest.ltx.controller;

import ltxrest.ltx.dto.RegDto;
import ltxrest.ltx.service.UserLandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserLandService userLandService;
    @GetMapping(path="/profile")
    public RegDto fetchProfile(Authentication auth){
        return userLandService.loadUserProfile(auth.getName());
    }
    @PutMapping(path = "/uploadProfile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadProfilePic(@RequestParam("file")MultipartFile file,Authentication auth){
        userLandService.updatePic(file,auth.getName());
        return "uploading success";
    };
}

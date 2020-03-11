package ltxrest.ltx.controller;

import ltxrest.ltx.model.UserModel;
import ltxrest.ltx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class testRest {


    @RequestMapping("/test")
    public String hello(){
        return "hello";
    }
}

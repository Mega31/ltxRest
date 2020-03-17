package ltxrest.ltx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testRest {
    @RequestMapping("/test")
    public String hello(){
        return "hello";
    }
}

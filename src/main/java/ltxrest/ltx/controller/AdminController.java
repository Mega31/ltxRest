package ltxrest.ltx.controller;

import ltxrest.ltx.dto.UserDto;
import ltxrest.ltx.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/api/user/admin/panel")
public class AdminController {
    private final Logger logger = LoggerFactory.getLogger(AdminService.class);

    @Autowired
    private AdminService adminService;
    @GetMapping(path = "/{email}")
    public UserDto fetchUser(@PathVariable("email") String email, Authentication auth) throws UsernameNotFoundException {
        logger.info("Getting user with email:"+email+" for admin:"+auth.getName());
        return adminService.getUser(email);
    }
    @PutMapping(path = "/{email}/{role}")
    public String updateUserRole(@PathVariable("email")String email, @PathVariable String role
            , Authentication auth){
        logger.info("Updating user:"+email+" to role:"+role+" by ADMIN:"+auth.getName());
        adminService.updateUserRole(email,role);
        return "Successful";
    }

}

package ltxrest.ltx.service;

import ltxrest.ltx.core.UserDetailsServiceImpl;
import ltxrest.ltx.dto.RegDto;
import ltxrest.ltx.mapper.UserDtoMapper;
import ltxrest.ltx.model.MyUser;
import ltxrest.ltx.repo.RoleRepo;
import ltxrest.ltx.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private Logger logger = LoggerFactory.getLogger(AdminService.class);
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private UserDtoMapper userDtoMapper;
    public RegDto getUser(String email){
        logger.info("Loading UserByEmail");
        RegDto regDto = userDetailsService.loadByEmail(email);
        return regDto;
    }
    public void updateUserRole(String email,String role){
    logger.info("Updating UserRole");
        MyUser myUser = userRepo.findByUsername(email);
        myUser.setRole(roleRepo.findById(Integer.parseInt(role)));
        userRepo.save(myUser);
    }
}

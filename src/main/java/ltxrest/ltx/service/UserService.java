package ltxrest.ltx.service;

import lombok.AllArgsConstructor;
import ltxrest.ltx.dto.UserDto;
import ltxrest.ltx.mapper.UserDtoMapper;
import ltxrest.ltx.model.MyUser;
import ltxrest.ltx.repo.RoleRepo;
import ltxrest.ltx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder encode;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private UserDtoMapper userDtoMapper;

    public boolean passwordChecker(UserDto userDto){
        if (userDto.getPassword().equals(userDto.getConfirmPassword())){
            return true;
        }
        return false;
    }
    public void save(MyUser user){

        user.setPassword(encode.passwordEncoderProvider().encode(user.getPassword()));
        user.setRole((roleRepo.findByRole("ROLE_USER")));
        userRepo.save(user);
    }
}

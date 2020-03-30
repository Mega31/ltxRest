package ltxrest.ltx.service;

import ltxrest.ltx.core.UserDetailsServiceImpl;
import ltxrest.ltx.dto.RegDto;
import ltxrest.ltx.exception.FileStorageException;
import ltxrest.ltx.mapper.UserDtoMapper;
import ltxrest.ltx.model.MyUser;
import ltxrest.ltx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.DataSource;
import java.io.IOException;

@Service
public class UserLandService {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserDtoMapper userDtoMapper;

    public RegDto loadUserProfile(String currentUser) {
        return userDetailsService.loadByEmail(currentUser);
    }

    public void updatePic(MultipartFile file, String currentUser) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            MyUser user = userRepo.findByUsername(currentUser);
            user.setProfile_pic(file.getBytes());
            userRepo.save(user);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
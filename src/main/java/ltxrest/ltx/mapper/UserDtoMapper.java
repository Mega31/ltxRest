package ltxrest.ltx.mapper;

import ltxrest.ltx.dto.RoleDto;
import ltxrest.ltx.dto.UserDto;
import ltxrest.ltx.model.MyUser;
import ltxrest.ltx.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserDtoMapper {
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "role",ignore = true)
    @Mapping(target = "authorities",ignore = true)
    @Mapping(target = "username",source = "email")
    MyUser toUser(UserDto userDto);
    @Mapping(target = "email",source = "username")
    @Mapping(target = "confirmPassword",ignore = true)
    @Mapping(target = "roleIds" ,source = "role")
    UserDto toUserDto(MyUser myUser);
    RoleDto toDomain(Role role);

}

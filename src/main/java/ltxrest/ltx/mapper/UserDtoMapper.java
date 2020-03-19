package ltxrest.ltx.mapper;

import ltxrest.ltx.dto.UserDto;
import ltxrest.ltx.model.MyUser;
import ltxrest.ltx.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserDtoMapper {

    @Mapping(target = "username",source = "email")
    @Mapping(target = "role",source = "role")
    @Mapping(target = "authorities",ignore = true)
    MyUser map(UserDto userDto);

    Role map(String role);
}

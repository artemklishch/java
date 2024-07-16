package mate.academy.webintro.mapper;

import mate.academy.webintro.config.MapperConfig;
import mate.academy.webintro.dto.CreateUserRequestDto;
import mate.academy.webintro.dto.UserDto;
import mate.academy.webintro.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserDto toDto(User employee);

    User toModel(CreateUserRequestDto requestDto);
}

package mate.academy.webintro.mapper;

import mate.academy.webintro.config.MapperConfig;
import mate.academy.webintro.dto.CreatePhoneRequestDto;
import mate.academy.webintro.dto.PhoneDto;
import mate.academy.webintro.model.Phone;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface PhoneMapper {
    PhoneDto toDto(Phone employee);

    Phone toModel(CreatePhoneRequestDto requestDto);
}

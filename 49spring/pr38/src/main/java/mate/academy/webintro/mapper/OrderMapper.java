package mate.academy.webintro.mapper;

import mate.academy.webintro.config.MapperConfig;
import mate.academy.webintro.dto.order.OrderDto;
import mate.academy.webintro.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class, uses = UserMapper.class)
public interface OrderMapper {
    @Mapping(source = "user.id", target = "userId")
    OrderDto toDto(Order order);
}

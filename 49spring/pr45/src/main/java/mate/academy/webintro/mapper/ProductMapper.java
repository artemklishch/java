package mate.academy.webintro.mapper;

import mate.academy.webintro.config.MapperConfig;
import mate.academy.webintro.dto.product.CreateProductRequestDto;
import mate.academy.webintro.dto.product.ProductDto;
import mate.academy.webintro.model.Product;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface ProductMapper {
    ProductDto toDto(Product product);

    Product toModel(CreateProductRequestDto requestDto);
}

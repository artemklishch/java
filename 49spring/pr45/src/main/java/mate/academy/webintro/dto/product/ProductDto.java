package mate.academy.webintro.dto.product;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class ProductDto {
    private Long id;
    private String title;
    private BigDecimal price;
}

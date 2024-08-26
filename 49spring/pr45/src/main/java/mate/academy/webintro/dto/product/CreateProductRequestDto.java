package mate.academy.webintro.dto.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class CreateProductRequestDto {
    @NotNull
    private String title;
    @NotNull
    @Min(0)
    private BigDecimal price;
}

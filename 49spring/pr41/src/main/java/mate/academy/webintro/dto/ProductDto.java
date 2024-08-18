package mate.academy.webintro.dto;

import java.math.BigDecimal;

public record ProductDto(Long id, String title, BigDecimal price) {
}

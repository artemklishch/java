package mate.academy.pr301.dto;

import lombok.Data;

@Data
public class CarDto {
    private Long id;
    private String model;

    public CarDto() {}

    public CarDto(Long id, String model) {
        this.id = id;
        this.model = model;
    }
}

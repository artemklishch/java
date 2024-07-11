package mate.academy.webintro.dto;

import lombok.Data;

@Data
public class PhoneDto {
    private Long id;
    private String model;
    private String color;
    private String countryManufactured;
}

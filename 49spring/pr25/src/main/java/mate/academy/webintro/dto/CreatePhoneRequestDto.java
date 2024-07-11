package mate.academy.webintro.dto;

import lombok.Data;

@Data
public class CreatePhoneRequestDto {
    private String model;
    private String color;
    private String countryManufactured;
}

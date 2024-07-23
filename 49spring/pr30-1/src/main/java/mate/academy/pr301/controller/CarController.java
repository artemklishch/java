package mate.academy.pr301.controller;

import mate.academy.pr301.dto.CarDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @GetMapping
    public List<CarDto> getAll(){
        return List.of(new CarDto(1L, "Audi"), new CarDto(2L, "BMW"));
    }

    @GetMapping("/{id}")
    public CarDto getById(@PathVariable Long id){
        return new CarDto(id, "Audi");
    }
}


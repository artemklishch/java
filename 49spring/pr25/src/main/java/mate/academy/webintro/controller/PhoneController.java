package mate.academy.webintro.controller;

import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.CreatePhoneRequestDto;
import mate.academy.webintro.dto.PhoneDto;
import mate.academy.webintro.service.PhoneService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/phones")
public class PhoneController {

    private final PhoneService phoneService;

    @GetMapping
    public List<PhoneDto> findAll() {
        return phoneService.findAll();
    }


    @GetMapping("/{id}")
    public PhoneDto findById(@PathVariable Long id) {
        return phoneService.findById(id);
    }

    @PostMapping
    public PhoneDto create(@RequestBody CreatePhoneRequestDto requestDto) {
        return phoneService.save(requestDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        phoneService.deleteById(id);
    }
}
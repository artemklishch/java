package mate.academy.webintro.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.CreateProductRequestDto;
import mate.academy.webintro.dto.ProductDto;
import mate.academy.webintro.service.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Product management", description = "Endpoints for managing products")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;

//    @GetMapping
//    public List<ProductDto> findAll(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "5") int size
//    ) {
//        return productService.findAll();
//    }

    @GetMapping
    @Operation(summary = "Get all products", description = "Get a list of all products")
    public List<ProductDto> findAll(Pageable pageable) {
        return productService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new product", description = "Create a new product")
    public ProductDto create(@RequestBody @Valid CreateProductRequestDto requestDto) {
        return productService.save(requestDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
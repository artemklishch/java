package mate.academy.pr32.controller;

import mate.academy.pr32.dto.internal.CurrencyConversionDto;
import mate.academy.pr32.service.CurrenciesClient;
import mate.academy.pr32.service.RatesCalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@RestController
@RequestMapping("/currencies")
public class CurrenciesController {
//    private final CurrenciesClient client;
//
//    public CurrenciesController(CurrenciesClient client) {
//        this.client = client;
//    }

//    @GetMapping("/test")
//    public String testClient(){
//        client.getCurrenciesRates("UAH", List.of("USD", "EUR"));
//        return "Hello World!";
//    }

    private final RatesCalculatorService ratesCalculatorService;

    public CurrenciesController(RatesCalculatorService ratesCalculatorService) {
        this.ratesCalculatorService = ratesCalculatorService;
    }

    @GetMapping("/convert")
    public List<CurrencyConversionDto> getConversions(
            @RequestParam(defaultValue = "100") BigDecimal amount,
            @RequestParam(defaultValue = "EUR") String baseCurrency,
            @RequestParam(defaultValue = "USD") List<String> currencies
    ) {
        return ratesCalculatorService.getConversions(amount, baseCurrency, currencies);
    }
}

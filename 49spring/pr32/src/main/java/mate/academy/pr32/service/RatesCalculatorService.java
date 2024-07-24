package mate.academy.pr32.service;

import mate.academy.pr32.dto.external.CurrencyRateDto;
import mate.academy.pr32.dto.internal.CurrencyConversionDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RatesCalculatorService {
    private final CurrenciesClient client;

    public RatesCalculatorService(CurrenciesClient currenciesClient) {
        this.client = currenciesClient;
    }

    public List<CurrencyConversionDto> getConversions(
            BigDecimal amount,
            String baseCurrency,
            List<String> currencies
    ) {
        List<CurrencyRateDto> currenciesRates = client.getCurrenciesRates(baseCurrency, currencies);
        return currenciesRates.stream()
                .map(rate -> new CurrencyConversionDto(
                        baseCurrency,
                        rate.code(),
                        amount,
                        rate.value(),
                        rate.value().multiply(amount)
                ))
                .toList();
    }
}

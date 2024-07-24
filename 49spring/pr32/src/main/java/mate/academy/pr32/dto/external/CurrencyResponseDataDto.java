package mate.academy.pr32.dto.external;

import java.util.Map;

import lombok.Data;

@Data
public class CurrencyResponseDataDto {
    //    private CurrencyMetadataDto meta; // if we dont't want to use this data - we can not include it here
    private Map<String, CurrencyRateDto> data;
}

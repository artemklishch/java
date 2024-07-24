package mate.academy.pr32.dto.external;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CurrencyMetadataDto {
    @JsonProperty("last_updated_at") // the name of the field of the incoming JSON
    private LocalDateTime lastUpdatedAt;
}

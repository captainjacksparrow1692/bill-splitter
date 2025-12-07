package dto;

import lombok.*;
import java.math.BigDecimal;

@Data
public class CommissionDTO {
    private Long eventId;
    private BigDecimal percent;
    private BigDecimal fixed;
}

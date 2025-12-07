package dto;

import java.util.List;
import lombok.*;
@Data
public class ItemConsumersDTO {
    private Long itemId;
    private Long personId;

    private boolean isSharedEqually;
    private Integer quantity;
}

package dto;

import lombok.*;
import java.util.List;
@Data
public class ItemDTO {
    private Long id;
    private Long eventId;
    private String name;
    private Long price;

    private List<ItemConsumersDTO> consumers;
}

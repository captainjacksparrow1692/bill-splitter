package dto;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class EventDTO {
        private Long id;
        private String name;
        private Long createdById;

        private LocalDateTime createdAt;

        private List<Long> memberIds;

        private List<ItemDTO> items;
        private CommissionDTO commission;
}

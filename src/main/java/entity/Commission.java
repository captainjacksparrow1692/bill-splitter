package entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "commission")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Commission {

    @Id
    private Long eventId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "event_id")
    private Event event;

    private BigDecimal percent;
    private BigDecimal fixed;
}

package entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private Person createdBy;
    private LocalDateTime createdAt;

    private List<Person> members;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Item> items;

    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL)
    private Commission commission;
}

package entity;

import jakarta.persistence.*;
import lombok.*;
import entity.ItemConsumersId;


@Entity
@Table(name = "item_consumers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemConsumers {

    @EmbeddedId
    private ItemConsumersId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("personId")
    @JoinColumn(name = "person_id")
    private Person person;

    private boolean isSharedEqually;

    private Integer quantity;
}

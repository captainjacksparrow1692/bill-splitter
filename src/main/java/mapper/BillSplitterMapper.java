package mapper;

import dto.*;
import entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BillSplitterMapper {

    // Person
    PersonDTO toDto(Person person);
    Person toEntity(PersonDTO dto);

    // Event
    @Mapping(source = "createdBy.id", target = "createdById")
    @Mapping(source = "members", target = "memberIds")
    EventDTO toDto(Event event);

    @Mapping(source = "createdById", target = "createdBy.id")
    @Mapping(source = "memberIds", target = "members")
    Event toEntity(EventDTO dto);

    // Helper methods for mapping List<Person> <-> List<Long>
    default List<Long> mapMembersToIds(List<Person> members) {
        if (members == null) return null;
        return members.stream().map(Person::getId).toList();
    }

    default List<Person> mapIdsToMembers(List<Long> ids) {
        if (ids == null) return null;
        return ids.stream().map(id -> {
            Person p = new Person();
            p.setId(id);
            return p;
        }).toList();
    }

    // Item
    @Mapping(source = "event.id", target = "eventId")
    ItemDTO toDto(Item item);

    @Mapping(source = "eventId", target = "event.id")
    Item toEntity(ItemDTO dto);

    // ItemConsumers
    @Mapping(source = "id.itemId", target = "itemId")
    @Mapping(source = "id.personId", target = "personId")
    ItemConsumersDTO toDto(ItemConsumers itemConsumers);

    @Mapping(source = "itemId", target = "id.itemId")
    @Mapping(source = "personId", target = "id.personId")
    ItemConsumers toEntity(ItemConsumersDTO dto);

    // Commission
    CommissionDTO toDto(Commission commission);
    Commission toEntity(CommissionDTO dto);

    // Lists
    List<PersonDTO> toPersonDtoList(List<Person> persons);
    List<EventDTO> toEventDtoList(List<Event> events);
    List<ItemDTO> toItemDtoList(List<Item> items);
    List<ItemConsumersDTO> toItemConsumersDtoList(List<ItemConsumers> itemConsumers);
    List<CommissionDTO> toCommissionDtoList(List<Commission> commissions);
}

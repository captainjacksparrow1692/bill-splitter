package mapper;

import dto.PersonDTO;
import entity.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDTO toDto(Person person);
    Person toEntity(PersonDTO dto);
}



package uzumtech.bill_splitter.Mapper;

import dto.PersonDTO;
import entity.Person;
import mapper.BillSplitterMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class BillSplitterMapperTest {

    private BillSplitterMapper mapper = Mappers.getMapper(BillSplitterMapper.class);

    @Test
    void testPersonMapping() {
        // Создаем исходный объект Person
        Person person = new Person();
        person.setId(1L);
        person.setName("John Doe");

        // Преобразуем в DTO
        PersonDTO dto = mapper.toDto(person);
        assertEquals(person.getId(), dto.getId());
        assertEquals(person.getName(), dto.getName());

        // Преобразуем обратно в сущность
        Person entity = mapper.toEntity(dto);
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getName(), entity.getName());
    }
}

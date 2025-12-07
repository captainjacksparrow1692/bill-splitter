package uzumtech.bill_splitter.ServiceTest;

import dto.PersonDTO;
import entity.Person;
import exception.NotFoundException;
import mapper.BillSplitterMapper;
import repository.PersonRepository;
import service.implementation.PersonServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private BillSplitterMapper mapper;

    @InjectMocks
    private PersonServiceImpl service;

    private Person person;
    private PersonDTO personDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);


        personDTO = new PersonDTO();
        personDTO.setId(1L);
        personDTO.setName("John Doe");
        personDTO.setEmail("john@example.com");
    }

    @Test
    void testCreate() {
        when(mapper.toEntity(personDTO)).thenReturn(person);
        when(personRepository.save(person)).thenReturn(person);
        when(mapper.toDto(person)).thenReturn(personDTO);

        PersonDTO result = service.createPerson(personDTO);

        assertNotNull(result);
        assertEquals("John Doe", result.getName());
    }

    @Test
    void testGetByIdFound() {
        when(personRepository.findById(1L)).thenReturn(Optional.of(person));
        when(mapper.toDto(person)).thenReturn(personDTO);

        PersonDTO result = service.getPersonById(1L);

        assertEquals(personDTO.getId(), result.getId());
    }

    @Test
    void testGetByIdNotFound() {
        when(personRepository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> service.getPersonById(2L));
    }

    @Test
    void testGetAll() {
        when(personRepository.findAll()).thenReturn(List.of(person));
        when(mapper.toDto(person)).thenReturn(personDTO);

        List<PersonDTO> list = service.getAllPersons();
        assertEquals(1, list.size());
    }

    @Test
    void testUpdate() {
        when(personRepository.findById(1L)).thenReturn(Optional.of(person));
        when(personRepository.save(any(Person.class))).thenReturn(person);
        when(mapper.toDto(person)).thenReturn(personDTO);

        PersonDTO updated = service.updatePerson(1L, personDTO);
        assertEquals(personDTO.getName(), updated.getName());
    }

    @Test
    void testDelete() {
        doNothing().when(personRepository).deleteById(1L);
        service.deletePerson(1L);
        verify(personRepository, times(1)).deleteById(1L);
    }
}

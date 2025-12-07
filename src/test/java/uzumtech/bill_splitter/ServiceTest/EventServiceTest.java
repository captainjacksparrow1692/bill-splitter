package uzumtech.bill_splitter.ServiceTest;

import dto.EventDTO;
import entity.Event;
import entity.Person;
import mapper.BillSplitterMapper;
import repository.EventRepository;
import repository.PersonRepository;
import service.implementation.EventServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EventServiceTest {

    @Mock
    private EventRepository eventRepository;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private BillSplitterMapper mapper;

    @InjectMocks
    private EventServiceImpl service;

    private Event event;
    private EventDTO dto;
    private Person creator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        creator = new Person();
        creator.setId(1L);
        creator.setName("John");

        event = Event.builder()
                .id(1L)
                .name("Birthday Party")
                .createdBy(creator)
                .createdAt(LocalDateTime.now())
                .build();

        dto = new EventDTO();
        dto.setId(1L);
        dto.setName("Birthday Party");
        dto.setCreatedById(1L);
    }

    @Test
    void testCreate() {
        when(personRepository.findById(1L)).thenReturn(Optional.of(creator));
        when(eventRepository.save(any(Event.class))).thenReturn(event);
        when(mapper.toDto(event)).thenReturn(dto);

        EventDTO result = service.create(dto);
        assertEquals("Birthday Party", result.getName());
    }

    @Test
    void testGetAll() {
        when(eventRepository.findAll()).thenReturn(List.of(event));
        when(mapper.toDto(event)).thenReturn(dto);

        List<EventDTO> list = service.getAll();
        assertEquals(1, list.size());
    }

    @Test
    void testUpdate() {
        when(eventRepository.findById(1L)).thenReturn(Optional.of(event));
        when(eventRepository.save(any(Event.class))).thenReturn(event);
        when(mapper.toDto(event)).thenReturn(dto);

        EventDTO updated = service.update(1L, dto);
        assertEquals(dto.getName(), updated.getName());
    }

    @Test
    void testDelete() {
        doNothing().when(eventRepository).deleteById(1L);
        service.delete(1L);
        verify(eventRepository, times(1)).deleteById(1L);
    }
}
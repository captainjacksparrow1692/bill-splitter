package service.implementation;

import dto.EventDTO;
import entity.Event;
import repository.EventRepository;
import service.EventService;
import mapper.BillSplitterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final BillSplitterMapper mapper;

    @Override
    public EventDTO create(EventDTO dto) {
        Event event = mapper.toEntity(dto);
        eventRepository.save(event);
        return mapper.toDto(event);
    }

    @Override
    public EventDTO getEventById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        return mapper.toDto(event);
    }

    @Override
    public List<EventDTO> getAll() {
        return eventRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EventDTO update(Long id, EventDTO eventDTO) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        event.setName(eventDTO.getName());
        eventRepository.save(event);
        return mapper.toDto(event);
    }

    @Override
    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}

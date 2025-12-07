package service;

import dto.EventDTO;
import java.util.List;

public interface EventService {
    EventDTO getEventById(Long id);
    EventDTO create(EventDTO dto);
    EventDTO update(Long id, EventDTO dto);
    List<EventDTO> getAll();

    void delete(Long id);
}
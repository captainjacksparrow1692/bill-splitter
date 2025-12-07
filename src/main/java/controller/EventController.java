package controller;

import dto.EventDTO;
import service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    @PostMapping
    public EventDTO create(@RequestBody EventDTO dto) {
        return eventService.create(dto);
    }

    @GetMapping("/{id}")
    public EventDTO getById(@PathVariable Long id) {
        return eventService.getEventById(id); // changed to match interface
    }

    @GetMapping
    public List<EventDTO> getAll() {
        return eventService.getAll();
    }

    @PutMapping("/{id}")
    public EventDTO update(@PathVariable Long id, @RequestBody EventDTO dto) {
        return eventService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        eventService.delete(id);
    }
}

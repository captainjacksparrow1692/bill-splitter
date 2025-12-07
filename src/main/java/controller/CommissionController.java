package controller;

import dto.CommissionDTO;
import service.CommissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/commission")
public class CommissionController {

    private final CommissionService commissionService;

    @PostMapping("/{eventId}")
    public CommissionDTO set(@PathVariable Long eventId, @RequestBody CommissionDTO dto) {
        return commissionService.setCommission(eventId, dto);
    }

    @GetMapping("/{eventId}")
    public CommissionDTO get(@PathVariable Long eventId) {
        return commissionService.getCommission(eventId);
    }

    @DeleteMapping("/{eventId}")
    public void delete(@PathVariable Long eventId) {
        commissionService.deleteCommission(eventId);
    }
}
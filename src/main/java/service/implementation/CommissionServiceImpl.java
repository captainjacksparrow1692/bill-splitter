package service.implementation;

import dto.CommissionDTO;
import service.CommissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CommissionServiceImpl implements CommissionService {

    @Override
    public BigDecimal calculateCommission(CommissionDTO commissionDTO, BigDecimal amount) {
        BigDecimal percentPart = amount
                .multiply(commissionDTO
                        .getPercent()
                        .divide(BigDecimal.valueOf(100)));
        BigDecimal fixedPart = commissionDTO
                .getFixed() != null ? commissionDTO
                .getFixed() : BigDecimal.ZERO;
        return percentPart.add(fixedPart);
    }

    @Override
    public CommissionDTO setCommission(Long eventId, CommissionDTO dto) {
        // TODO: implement logic
        return dto;
    }

    @Override
    public CommissionDTO getCommission(Long eventId) {
        // TODO: implement logic
        return null;
    }

    @Override
    public void deleteCommission(Long eventId) {
        // TODO: implement logic
    }
}

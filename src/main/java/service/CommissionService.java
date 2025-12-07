package service;

import dto.CommissionDTO;
import java.math.BigDecimal;

public interface CommissionService {
    BigDecimal calculateCommission(CommissionDTO commissionDTO, BigDecimal amount);
    CommissionDTO setCommission(Long eventId, CommissionDTO dto);
    CommissionDTO getCommission(Long eventId);
    void deleteCommission(Long eventId);
}
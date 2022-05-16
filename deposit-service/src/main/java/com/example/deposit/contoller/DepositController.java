package com.example.deposit.contoller;

import com.example.deposit.contoller.dto.DepositRequestDTO;
import com.example.deposit.contoller.dto.DepositResponseDTO;
import com.example.deposit.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepositController {

    private final DepositService depositService;

    @Autowired
    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @PostMapping("/deposits")
    public DepositResponseDTO deposit(@RequestBody DepositRequestDTO depositRequestDTO) {
        return depositService.deposit(depositRequestDTO.getAccountId(), depositRequestDTO.getBillId(), depositRequestDTO.getAmount());
    }
}

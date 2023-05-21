package org.sid.bankaccountservice.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bankaccountservice.Enums.AccountType;

import java.util.Date;


@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountResponseDTO {
    private String id;
    private Date createdAT;
    private Double balance;
    private String currency;
    private AccountType type;
}

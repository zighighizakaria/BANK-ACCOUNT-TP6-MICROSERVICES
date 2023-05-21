package org.sid.bankaccountservice.services;

import org.sid.bankaccountservice.Enums.AccountType;
import org.sid.bankaccountservice.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice.entities.BankAccount;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}

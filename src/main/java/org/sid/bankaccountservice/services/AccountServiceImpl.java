package org.sid.bankaccountservice.services;

import org.sid.bankaccountservice.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.mappers.AccountMapper;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;


@Service
@Transactional

public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;
    
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount =BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAT(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();

        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);

        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);
        /*BankAccountResponseDTO bankAccountResponseDTO =BankAccountResponseDTO.builder()
                .id(savedBankAccount.getId())
                .type(savedBankAccount.getType())
                .createdAT(savedBankAccount.getCreatedAT())
                .balance(savedBankAccount.getBalance())
                .currency(savedBankAccount.getCurrency())

                .build();*/




        return bankAccountResponseDTO;
    }
}

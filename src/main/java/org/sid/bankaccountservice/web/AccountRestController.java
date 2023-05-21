package org.sid.bankaccountservice.web;

import org.sid.bankaccountservice.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.mappers.AccountMapper;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.sid.bankaccountservice.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AccountRestController {


    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;


    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }


    ////////////////////////////SOLUTION ANCIANCE///////////////////////////////

    //findall
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts() {
        return bankAccountRepository.findAll();
    }

    //findbyid
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account not found", id)));
    }

    ;


/*
    //AJOUTER
    @PostMapping("/bankAccounts")
    public BankAccount save( @RequestBody BankAccount bankAccount){
        if(bankAccount.getId()==null) bankAccount.setId(UUID.randomUUID().toString());
        return bankAccountRepository.save(bankAccount);
    }
   //UPDATE
    @PutMapping("/bankAccounts/{id}")
    public BankAccount update( @PathVariable String id, @RequestBody BankAccount bankAccount){
        BankAccount account =bankAccountRepository.findById(id).orElseThrow();
        if(bankAccount.getBalance()!=null) account.setBalance(bankAccount.getBalance());
        if(bankAccount.getCreatedAT()!=null) account.setCreatedAT(new Date());
        if(bankAccount.getType()!=null) account.setType(bankAccount.getType());
        if(bankAccount.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(account);
    }

    //DELETE
    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount( @PathVariable String id){
         bankAccountRepository.deleteById(id);
    };
*/
    ///////////////////////////Maperrs///////////////////////////////

    //AJOUTER
    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO) {
        return accountService.addAccount(requestDTO);


    };
}

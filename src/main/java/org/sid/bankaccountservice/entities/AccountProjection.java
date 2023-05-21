package org.sid.bankaccountservice.entities;

import org.sid.bankaccountservice.Enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class, name="p1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
}

package com.example.patterns_banking.factory;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AccountFactoryProvider {//este es el orquestado de los factory para utilizar inyección de dependencias
    private final CheckingAccountFactory checkingAccountFactory;
    private final SavingsAccountFactory savingsAccountFactory;
    private final LowAmountAccountFactory lowAmountAccountFactory;//principio abierto/cerrado

    public AccountFactoryProvider(CheckingAccountFactory checkingAccountFactory, SavingsAccountFactory savingsAccountFactory, LowAmountAccountFactory lowAmountAccountFactory) {
        this.checkingAccountFactory = checkingAccountFactory;
        this.savingsAccountFactory = savingsAccountFactory;
        this.lowAmountAccountFactory = lowAmountAccountFactory;
    }

    public AccountFactory getFactory(AccountType type) {//se puede usar if o swjt
        Map<AccountType, AccountFactory> factories = Map.of(
                AccountType.CHECKING, checkingAccountFactory,
                AccountType.SAVINGS, savingsAccountFactory,
                AccountType.LOWAMOUNT, lowAmountAccountFactory);

        return factories.get(type);
    }

    public enum AccountType {
        CHECKING,
        SAVINGS,
        LOWAMOUNT
    }
}

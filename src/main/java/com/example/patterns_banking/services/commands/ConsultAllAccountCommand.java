package com.example.patterns_banking.services.commands;

import com.example.patterns_banking.models.Account;
import com.example.patterns_banking.repositories.IAccountRepository;

import java.util.List;

public class ConsultAllAccountCommand implements ICommand<List<Account>> {

    private IAccountRepository accountRepository;

    public ConsultAllAccountCommand( IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> execute() {
        List<Account> accountList = accountRepository.findAll();
        return accountList;
    }

}

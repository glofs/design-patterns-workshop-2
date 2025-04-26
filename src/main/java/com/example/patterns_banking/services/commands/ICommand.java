package com.example.patterns_banking.services.commands;

import java.util.List;

public interface ICommand<T> {
    T execute();
}

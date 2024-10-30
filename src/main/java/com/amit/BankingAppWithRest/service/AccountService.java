package com.amit.BankingAppWithRest.service;

import com.amit.BankingAppWithRest.dto.AccountDto;

import java.util.List;


public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto withdraw(Long id, double amount);

    AccountDto deposit(Long id, double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccount(Long id);
}

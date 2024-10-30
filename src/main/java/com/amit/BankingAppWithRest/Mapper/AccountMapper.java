package com.amit.BankingAppWithRest.Mapper;

import com.amit.BankingAppWithRest.dto.AccountDto;
import com.amit.BankingAppWithRest.entity.Account;

//This class is for converting Account dto into jpa entity and jpa entity into AccountDto
public class AccountMapper {

    //for converting Account dto into Account jpa entity
    public static Account mapToAccount(AccountDto accountDto)
    {
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
        return account;
    }


    //for converting Account jpa entity into AccountDto
    public static AccountDto mapToAccountDto(Account account)
    {
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountDto;
    }
}

package com.amit.BankingAppWithRest.repository;

import com.amit.BankingAppWithRest.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

//Creating jpa repository for Account
//takes two parameters, first one is entity name and second one is type of primary key
public interface AccountRepository extends JpaRepository<Account,Long> {
    //After extending jpaRepository, AccountRepository will get CRUD database
    //methods to perform CRUD database operations on this "Account" jpa entity that is passed.

}

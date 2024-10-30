package com.amit.BankingAppWithRest.controller;

import com.amit.BankingAppWithRest.dto.AccountDto;
import com.amit.BankingAppWithRest.service.AccountService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController // this will make this class as a spring mvc rest controller class
@RequestMapping("/api/accounts") //Base url for all rest api's that are defined in this class
public class AccountController {

    private AccountService accountService;

    @Autowired  //no need of autowired becoz this class has only one constructor, so spring will auto inject dependency
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Making createAccount REST API

    //making this method as REST API by using spring annotations
    @PostMapping  //This method have to handle http post request
    // @RequestBody annotation will map the request body to java object (That is accountDto as argument) (Auto convert java obj into JSON)
    public ResponseEntity<AccountDto> addAccount( @RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //making getAccount REST API

    @GetMapping("/{id}") //({id} is template path variable)    // this annotation will map incoming http get req with this method
    //@PathVariable is used to bind value of template path variable to this method argument
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id)
    {
        AccountDto accountDto = accountService.getAccountById(id);
        return  ResponseEntity.ok(accountDto);
    }

    //Making Withdraw REST API

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,@RequestBody Map<String, Double> request){
        double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }

    // Making deposit REST API

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String,Double> request){

        Double amount = request.get("amount");
        AccountDto accountDto = accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    //Making getAllAccount REST API

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    // deleteAccount REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id)
    {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account is deleted.....");
    }

}

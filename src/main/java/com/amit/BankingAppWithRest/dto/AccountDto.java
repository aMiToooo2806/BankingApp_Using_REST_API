package com.amit.BankingAppWithRest.dto;

import lombok.*;

//To automatically generate getters and setters
@Data
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private String accountHolderName;
    private double balance;


}

package com.Bankingapp.Bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Bankingapp.Bankingapp.entity.Account;
import com.Bankingapp.Bankingapp.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/{accountNumber}/createaccount")
	public ResponseEntity<String> createAccount(@PathVariable String accountNumber) {
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		account.setBalance(0.0); // Assuming initial balance is 0.0
		accountService.createAccount(account);
		return ResponseEntity.ok("Account created successfully");
	}

	@GetMapping("/{accountNumber}/checkbalance")
	public ResponseEntity<Double> checkBalance(@PathVariable String accountNumber) {
		Account account = accountService.findByAccountNumber(accountNumber);
		if (account != null) {
			return ResponseEntity.ok(account.getBalance());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PutMapping("/{accountNumber}/deposit")
	public ResponseEntity<String> deposit(@PathVariable String accountNumber, @RequestParam double amount) {
		Account account = accountService.deposit(accountNumber, amount);
		if (account != null) {
			return ResponseEntity.ok("Deposit successful");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
		}
	}

	@PutMapping("/{accountNumber}/withdraw")
	public ResponseEntity<String> withdraw(@PathVariable String accountNumber, @RequestParam double amount) {
		Account account = accountService.withdraw(accountNumber, amount);
		if (account != null) {
			return ResponseEntity.ok("Withdrawal successful");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found or insufficient balance");
		}
	}
}

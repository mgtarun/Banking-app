package com.Bankingapp.Bankingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bankingapp.Bankingapp.entity.Account;
import com.Bankingapp.Bankingapp.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;

	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}

	public Account findByAccountNumber(String accountNumber) {
		return accountRepository.findByAccountNumber(accountNumber);
	}

	public Account deposit(String accountNumber, double amount) {
		Account account = accountRepository.findByAccountNumber(accountNumber);
		if (account != null) {
			account.setBalance(account.getBalance() + amount);
			return accountRepository.save(account);
		}
		return null;
	}

	public Account withdraw(String accountNumber, double amount) {
		Account account = accountRepository.findByAccountNumber(accountNumber);
		if (account != null && account.getBalance() >= amount) {
			account.setBalance(account.getBalance() - amount);
			return accountRepository.save(account);
		}
		return null;
	}
}

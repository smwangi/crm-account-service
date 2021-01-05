
package com.samtec.crm.accountservice.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountMapper mapper;

    @Override
    public AccountDto save(AccountDto accountDto) {
        return mapper.toAccountDto(accountRepository.save(mapper.toAccount(accountDto)));
    }

    @Override
    public Optional<AccountDto> findById(long id) {
        return accountRepository.findById(id)
                .stream()
                .map(mapper::toAccountDto)
        .findFirst();
    }

    @Override
    public List<AccountDto> fetchAll() {
        return accountRepository.findAll()
                .stream()
                .map(mapper::toAccountDto)
                .collect(Collectors.toList());
    }

    //@Override
    public AccountDto update(AccountDto accountDto) {
        return mapper.toAccountDto(accountRepository.save(mapper.toAccount(accountDto)));
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}

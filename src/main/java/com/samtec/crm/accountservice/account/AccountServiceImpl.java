
package com.samtec.crm.accountservice.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
        return Optional.of(mapper.toAccountDto(accountRepository.findById(id).get()));
    }

    @Override
    public List<AccountDto> fetchAll() {
        return mapper.accountDtoList(accountRepository.findAll());
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

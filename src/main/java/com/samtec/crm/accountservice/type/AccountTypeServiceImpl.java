
package com.samtec.crm.accountservice.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AccountTypeServiceImpl implements AccountTypeService {

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Autowired
    private AccountTypeMapper mapper;

    @Override
    public AccountTypeDto save(AccountTypeDto accountTypeDto) {
        return null;
    }

    @Override
    public Optional<AccountTypeDto> findById(long id) {
        Optional<AccountType> accountType = accountTypeRepository.findById(id);
        return accountTypeRepository.findById(id)
                .stream()
                .map(mapper::toAccountTypeDto)
                .findFirst();
    }

    @Override
    public List<AccountTypeDto> fetchAll() {
        return accountTypeRepository.findAll()
                .stream()
                .map(mapper::toAccountTypeDto)
                .collect(Collectors.toList());
    }

    //@Override
    public AccountTypeDto update(AccountTypeDto accountTypeDto) {
        AccountType accountType = accountTypeRepository.save(mapper.toAccountType(accountTypeDto));
        return mapper.toAccountTypeDto(accountType);
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}

package com.samtec.crm.accountservice.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
        return Optional.of(mapper.toAccountTypeDto(accountType.get()));
    }

    @Override
    public List<AccountTypeDto> fetchAll() {
        List<AccountType> accountTypeList = accountTypeRepository.findAll();
        return mapper.toAccountTypeDtoList(accountTypeList);
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

package com.samtec.crm.accountservice.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AccountUpdateServiceImpl implements AccountUpdateService {

    @Autowired
    private AccountUpdateRepository accountUpdateRepository;

    @Autowired
    private AccountUpdateMapper mapper;

    @Override
    public AccountUpdateDto save(AccountUpdateDto accountUpdateDto) {
        return mapper.toAccountUpdateDto(accountUpdateRepository.save(mapper.toAccountUpdate(accountUpdateDto)));
    }

    @Override
    public Optional<AccountUpdateDto> findById(long id) {
        return accountUpdateRepository.findById(id)
                .stream()
                .map(mapper::toAccountUpdateDto)
                .findFirst();
    }

    @Override
    public List<AccountUpdateDto> fetchAll() {
        return accountUpdateRepository.findAll()
                .stream()
                .map(mapper::toAccountUpdateDto)
                .collect(Collectors.toList());
    }

    //@Override
    public AccountUpdateDto update(AccountUpdateDto accountUpdateDto) {
        return mapper.toAccountUpdateDto(accountUpdateRepository.save(mapper.toAccountUpdate(accountUpdateDto)));
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}

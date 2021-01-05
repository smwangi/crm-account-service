package com.samtec.crm.accountservice.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
        return Optional.of(mapper.toAccountUpdateDto(accountUpdateRepository.getOne(id)));
    }

    @Override
    public List<AccountUpdateDto> fetchAll() {
        return mapper.toAccountUpdateDtoList(accountUpdateRepository.findAll());
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

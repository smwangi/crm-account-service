package com.samtec.crm.accountservice.update;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountUpdateRepository extends JpaRepository<AccountUpdate,Long> {
}

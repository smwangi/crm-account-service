
package com.samtec.crm.accountservice.common;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {
    T save(T t);
    Optional<T> findById(long id);
    List<T> fetchAll();
    //T update(T t);
    boolean delete(long id);
}

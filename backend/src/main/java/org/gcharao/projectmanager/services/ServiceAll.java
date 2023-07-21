package org.gcharao.projectmanager.services;

import java.util.List;
import java.util.Optional;


public interface ServiceAll<T> {
    List<T> findAll();
    Optional<T> findById(Long id);
    T save(T t);
    void delete(Long id);

}

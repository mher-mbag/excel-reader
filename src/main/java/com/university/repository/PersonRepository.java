package com.university.repository;

import com.university.entity.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Mher on 12/22/2015.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
}

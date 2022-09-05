package com.todoapp.backend.repository;

import com.todoapp.backend.entity.Liste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<Liste, Long> {

}

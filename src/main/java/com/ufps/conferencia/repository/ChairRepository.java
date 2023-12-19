package com.ufps.conferencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufps.conferencia.entity.Chair;

@Repository
public interface ChairRepository extends JpaRepository<Chair,Long>{
    
}
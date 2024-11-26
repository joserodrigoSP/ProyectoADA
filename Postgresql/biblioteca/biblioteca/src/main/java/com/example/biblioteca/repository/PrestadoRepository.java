package com.example.biblioteca.repository;

import com.example.biblioteca.entity.PrestadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestadoRepository extends JpaRepository<PrestadoEntity, Long> {
}

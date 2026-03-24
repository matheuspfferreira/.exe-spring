package com.example.project.repository;

import com.example.project.entity.ProjetoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<ProjetoEntity, Long> {
}

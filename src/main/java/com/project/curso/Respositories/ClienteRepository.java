package com.project.curso.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.curso.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}

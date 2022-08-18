package com.project.curso.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.curso.Respositories.CategoriaRepository;
import com.project.curso.domain.Categoria;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria buscar(Integer id) {

		Optional<Categoria> obj = repository.findById(id);

		return obj.orElse(null);
	}
}

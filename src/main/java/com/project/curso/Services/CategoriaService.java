package com.project.curso.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.project.curso.Respositories.CategoriaRepository;
import com.project.curso.Services.Exceptions.DataIntegrityException;
import com.project.curso.Services.Exceptions.ObjectNotFoundException;
import com.project.curso.domain.Categoria;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria find(Integer id) {

		Optional<Categoria> obj = repository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + " Tipo: " + Categoria.class.getName()));
	}

	public Categoria insert(Categoria obj) {

		obj.setId(null);

		return repository.save(obj);

	}

	public Categoria update(Categoria obj) {

		this.find(obj.getId());

		return repository.save(obj);
	}

	public void delete(Integer id) {

		find(id);

		try {

			repository.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos!");
		}

	}
}

package com.project.curso.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.project.curso.Respositories.CategoriaRepository;
import com.project.curso.Services.Exceptions.DataIntegrityException;
import com.project.curso.Services.Exceptions.ObjectNotFoundException;
import com.project.curso.domain.Categoria;
import com.project.curso.dto.CategoriaDTO;

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

	public List<CategoriaDTO> findAll() {

		List<Categoria> list = repository.findAll();

		List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());

		return listDto;
	}
}

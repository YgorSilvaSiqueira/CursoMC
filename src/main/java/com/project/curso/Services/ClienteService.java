package com.project.curso.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.curso.Respositories.ClienteRepository;
import com.project.curso.Services.Exceptions.ObjectNotFoundException;
import com.project.curso.domain.Cliente;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) {
		Cliente obj = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Cliente não encontrado! Id: " + id + " Tipo: " + Cliente.class.getName()));

		return obj;
	}

}

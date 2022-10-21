package com.project.curso.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.curso.Respositories.PedidoRepository;
import com.project.curso.Services.Exceptions.ObjectNotFoundException;
import com.project.curso.domain.Pedido;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	public Pedido buscar(Integer id) {

		Optional<Pedido> obj = repository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + " Tipo: " + Pedido.class.getName()));
	}
}

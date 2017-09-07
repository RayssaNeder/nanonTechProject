package br.com.nanonTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nanonTech.model.Usuario;

@Repository
public interface Usuarios extends JpaRepository<Usuario, Long>{

}

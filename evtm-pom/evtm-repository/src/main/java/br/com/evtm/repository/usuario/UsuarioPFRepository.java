package br.com.evtm.repository.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.evtm.model.cliente.UsuarioPF;

@Repository
public interface UsuarioPFRepository extends JpaRepository<UsuarioPF, Integer>{
	
	@Transactional(readOnly=true)
	public UsuarioPF findByEmail(String email);

}

package br.com.evtm.model.usuario;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.evtm.model.usuario.enums.Perfil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UsuarioPF implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private LocalDate dataNascimento;
	
	private String Profissao;
	
	private String genero;
	
	@Column(unique=true)
	private String email;
	
	private String celular;
	
	private String senha;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="perfis")
	private Set<Integer> perfis = new HashSet<>();
	
	public UsuarioPF() {
		addPerfil(Perfil.CLIENTE);
	}

	public UsuarioPF(Integer id, String nome, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		addPerfil(Perfil.CLIENTE);
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}

}

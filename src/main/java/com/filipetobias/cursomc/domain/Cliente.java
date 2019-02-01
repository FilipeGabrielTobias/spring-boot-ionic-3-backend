package com.filipetobias.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.filipetobias.cursomc.domain.enums.Perfil;
import com.filipetobias.cursomc.domain.enums.TipoCliente;
import lombok.Data;

@Data
@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	@Column(unique=true)
	private String email;

	@JsonIgnore
	private String password;

	private String cpfOuCnpj;

	private Integer tipo;

	@OneToMany(mappedBy="cliente", cascade = CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name="TELEFONE")
	private Set<String> telefones = new HashSet<>();// não permite que sejam adicionados valores iguais

	// Eager utilizado para garatir que sejam buscados juntos
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PERFIS")
	private Set<Integer> perfis = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos = new ArrayList<>();

	public Cliente() {
		addPerfil(Perfil.CLIENTE);
	}

	public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipo, String password) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = (tipo == null) ? null : tipo.getCod();
		addPerfil(Perfil.CLIENTE);
	}

	public Set<Perfil> getPerfis(){
		// retorna o perfil dos clientes
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil){
		perfis.add(perfil.getCod());
	}
}

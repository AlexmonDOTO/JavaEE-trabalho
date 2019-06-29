package locadora.filme.dal.entidade;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.*;

@Entity
public class NomeFilme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short idNomeFilme;
	
	@NotNull(message = "Campo descrição é obrigatório")
	@Size(max = 50, message = "O campo descrição pode ter no máximo 50 caracteres")
	private String descricao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idDiretor")
	@NotNull(message = "A diretor é obrigatória")
	private Diretor diretor;
	
	@OneToMany(mappedBy = "nomeFilmes")
	private List<Filme> filmes;

	public Short getIdNomeFilme() {
		return idNomeFilme;
	}

	public void setIdNomeFilme(Short idNomeFilme) {
		this.idNomeFilme = idNomeFilme;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Diretor getDiretor() {
		return diretor;
	}

	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idNomeFilme == null) ? 0 : idNomeFilme.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NomeFilme other = (NomeFilme) obj;
		if (idNomeFilme == null) {
			if (other.idNomeFilme != null)
				return false;
		} else if (!idNomeFilme.equals(other.idNomeFilme))
			return false;
		return true;
	}
	
}

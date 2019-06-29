package locadora.filme.dal.entidade;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sinopse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short idSinopse;
	
	private String descricao;
	
	@OneToMany(mappedBy = "sinopse")
	private List<Filme> filmes;

	public Short getIdSinopse() {
		return idSinopse;
	}

	public void setIdSinopse(Short idSinopse) {
		this.idSinopse = idSinopse;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		result = prime * result + ((idSinopse == null) ? 0 : idSinopse.hashCode());
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
		Sinopse other = (Sinopse) obj;
		if (idSinopse == null) {
			if (other.idSinopse != null)
				return false;
		} else if (!idSinopse.equals(other.idSinopse))
			return false;
		return true;
	}
	
	
}

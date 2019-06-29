package locadora.filme.dal.entidade;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@Entity
@Table(name = "diretor") //Opcional
@NamedQuery(name="diretor.count",
	query = "select count(m) from Diretor as m")
public class Diretor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short idDiretor;
	
	@Column(name = "descricao") //Opcional
	@NotNull(message = "Campo descrição é obrigatório")
	@Size(max = 50, message = "O campo descrição pode ter no máximo 50 caracteres")
	private String descricao;
	
	@OneToMany(mappedBy = "diretor", fetch = FetchType.LAZY)
	private List<NomeFilme> nomeFilmess;
	
	public Short getIdDiretor() {
		return idDiretor;
	}
	public void setIdDiretor(Short idDiretor) {
		this.idDiretor = idDiretor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<NomeFilme> getNomeFilmes() {
		return nomeFilmess;
	}
	public void setNomeFilmes(List<NomeFilme> nomeFilmess) {
		this.nomeFilmess = nomeFilmess;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDiretor == null) ? 0 : idDiretor.hashCode());
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
		Diretor other = (Diretor) obj;
		if (idDiretor == null) {
			if (other.idDiretor != null)
				return false;
		} else if (!idDiretor.equals(other.idDiretor))
			return false;
		return true;
	}
	
	

}

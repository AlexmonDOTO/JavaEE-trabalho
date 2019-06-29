package locadora.filme.dal.entidade;

import javax.persistence.*;

@Embeddable
public class LocacaoFilmePk {

	private Integer idLocacao;
	private Integer idFilme;
	
	public Integer getIdLocacao() {
		return idLocacao;
	}
	public void setIdLocacao(Integer idLocacao) {
		this.idLocacao = idLocacao;
	}
	public Integer getIdFilme() {
		return idFilme;
	}
	public void setIdFilme(Integer idFilme) {
		this.idFilme = idFilme;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFilme == null) ? 0 : idFilme.hashCode());
		result = prime * result + ((idLocacao == null) ? 0 : idLocacao.hashCode());
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
		LocacaoFilmePk other = (LocacaoFilmePk) obj;
		if (idFilme == null) {
			if (other.idFilme != null)
				return false;
		} else if (!idFilme.equals(other.idFilme))
			return false;
		if (idLocacao == null) {
			if (other.idLocacao != null)
				return false;
		} else if (!idLocacao.equals(other.idLocacao))
			return false;
		return true;
	}
	
	
	
}

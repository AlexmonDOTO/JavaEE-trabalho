package locadora.diurno.dal.entidade;

import javax.persistence.*;

@Entity
public class LocacaoFilme {

	@EmbeddedId
	private LocacaoFilmePk id;
	
	private Double valor;
	
	@ManyToOne
	@JoinColumn(name = "idFilme")
	@MapsId("idFilme")
	private Filme filme;
	
	@ManyToOne
	@JoinColumn(name = "idLocacao")
	@MapsId("idLocacao")
	private Locacao locacao;

	public LocacaoFilmePk getId() {
		return id;
	}

	public void setId(LocacaoFilmePk id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		LocacaoFilme other = (LocacaoFilme) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}

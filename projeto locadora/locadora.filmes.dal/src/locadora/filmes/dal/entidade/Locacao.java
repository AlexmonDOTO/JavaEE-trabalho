package locadora.filme.dal.entidade;

import javax.persistence.*;

import java.util.*;

@Entity
public class Locacao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idLocacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@ManyToOne
	@JoinColumn(name="idPessoa")
	private Pessoa pessoa;
	
	@OneToMany(mappedBy = "locacao")
	private List<LocacaoFilme> locacaoFilmes;


	public List<LocacaoFilme> getLocacaoFilmes() {
		return locacaoFilmes;
	}

	public void setLocacaoFilmes(List<LocacaoFilme> locacaoFilmes) {
		this.locacaoFilmes = locacaoFilmes;
	}

	public Integer getIdLocacao() {
		return idLocacao;
	}

	public void setIdLocacao(Integer idLocacao) {
		this.idLocacao = idLocacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Locacao other = (Locacao) obj;
		if (idLocacao == null) {
			if (other.idLocacao != null)
				return false;
		} else if (!idLocacao.equals(other.idLocacao))
			return false;
		return true;
	}
	
	
}

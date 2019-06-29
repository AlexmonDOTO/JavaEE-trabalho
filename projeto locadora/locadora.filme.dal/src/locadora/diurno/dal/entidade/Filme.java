package locadora.diurno.dal.entidade;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import java.util.*;

@Entity
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFilme;
	
	@NotNull(message = "Informe o ano")
	private Integer ano;
	
	@NotNull(message = "Informe o valor")
	private Double valor;
	
	@NotNull(message = "Informe a qtd. de portas")
	@Min(value = 1, message = "Quantidade de portas inválida.")
	private Short quantidadePortas;
	
	@ManyToOne
	@JoinColumn(name = "idCor")
	@NotNull(message = "Informe a cor")
	private Cor cor;
	
	@ManyToOne
	@JoinColumn(name = "idModelo")
	@NotNull(message = "Informe o modelo")
	private Modelo modelo;
	
	@ManyToOne
	@JoinColumn(name = "idCombustivel")
	@NotNull(message = "Informe a combustivel")
	private Combustivel combustivel;
	

	@ManyToMany
	@JoinTable(name = "FilmeOpcional",
			joinColumns = @JoinColumn(name = "idFilme"),
			inverseJoinColumns = @JoinColumn(name = "idOpcional"))
	
	
	@OneToMany(mappedBy = "filme")
	private List<LocacaoFilme> locacaoFilmes;

	
	public List<LocacaoFilme> getLocacaoFilmes() {
		return locacaoFilmes;
	}


	public void setLocacaoFilmes(List<LocacaoFilme> locacaoFilmes) {
		this.locacaoFilmes = locacaoFilmes;
	}


	public Integer getIdFilme() {
		return idFilme;
	}


	public void setIdFilme(Integer idFilme) {
		this.idFilme = idFilme;
	}


	public Integer getAno() {
		return ano;
	}


	public void setAno(Integer ano) {
		this.ano = ano;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public Short getQuantidadePortas() {
		return quantidadePortas;
	}


	public void setQuantidadePortas(Short quantidadePortas) {
		this.quantidadePortas = quantidadePortas;
	}


	public Cor getCor() {
		return cor;
	}


	public void setCor(Cor cor) {
		this.cor = cor;
	}


	public Modelo getModelo() {
		return modelo;
	}


	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}


	public Combustivel getCombustivel() {
		return combustivel;
	}


	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFilme == null) ? 0 : idFilme.hashCode());
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
		Filme other = (Filme) obj;
		if (idFilme == null) {
			if (other.idFilme != null)
				return false;
		} else if (!idFilme.equals(other.idFilme))
			return false;
		return true;
	}
	
		
	
	
}

package application;

public class Lancamento {
	
	private Double lanLatitude;
	private Double lanLongitude;
	
	private String lanAreaContribuicao;
	private String lanImpermeabilizacao;
	private String lanVazaoMaxima;
	
	public Lancamento () {
		
		
	}
	
	public Lancamento (Double lanLatitude, Double lanLongitude,String lanAreaContribuicao,String lanImpermeabilizacao,String lanVazaoMaxima) {
		
		this.lanLatitude = lanLatitude;
		this.lanLongitude = lanLongitude;
		this.lanAreaContribuicao = lanAreaContribuicao;
		this.lanImpermeabilizacao = lanImpermeabilizacao;
		this.lanVazaoMaxima = lanVazaoMaxima;
		
	}


	public Double getLanLatitude() {
		return lanLatitude;
	}


	public void setLanLatitude(Double lanLatitude) {
		this.lanLatitude = lanLatitude;
	}


	public Double getLanLongitude() {
		return lanLongitude;
	}


	public void setLanLongitude(Double lanLongitude) {
		this.lanLongitude = lanLongitude;
	}


	public String getLanAreaContribuicao() {
		return lanAreaContribuicao;
	}


	public void setLanAreaContribuicao(String lanAreaContribuicao) {
		this.lanAreaContribuicao = lanAreaContribuicao;
	}


	public String getLanImpermeabilizacao() {
		return lanImpermeabilizacao;
	}


	public void setLanImpermeabilizacao(String lanImpermeabilizacao) {
		this.lanImpermeabilizacao = lanImpermeabilizacao;
	}


	public String getLanVazaoMaxima() {
		return lanVazaoMaxima;
	}


	public void setLanVazaoMaxima(String lanVazaoMaxima) {
		this.lanVazaoMaxima = lanVazaoMaxima;
	}
	
	
	

}

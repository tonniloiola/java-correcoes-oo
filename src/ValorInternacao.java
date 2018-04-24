public enum ValorInternacao {

	// Quando tiver banco de dados, extrair esses dados do banco
	BASICA_APARTAMENTO(100.00), BASICA_ENFERMARIA(40.00),
	MEDIA_APARTAMENTO(90.00), MEDIA_ENFERMARIA(35.00),
	GRAVE_APARTAMENTO(80.00), GRAVE_ENFERMARIA(30.00);

	private double preco;

	ValorInternacao(double preco) {
		this.preco = preco;
	}

	public double getPreco() {
		return this.preco;
	}
}

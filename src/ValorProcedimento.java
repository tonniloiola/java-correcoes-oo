public enum ValorProcedimento {

	// Quando tiver banco de dados, extrair esses dados do banco
	BASICO(50.00), COMUM(150.00), AVANCADO(500.00);

	private double preco;

	ValorProcedimento(double preco) {
		this.preco = preco;
	}

	public double getPreco() {
		return this.preco;
	}
}

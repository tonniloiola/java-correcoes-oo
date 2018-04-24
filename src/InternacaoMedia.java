
public class InternacaoMedia implements RegraDeDiarias {


	@Override
	public float calcula(Internacao internacao) {
		float valorDiarias = 0;

		if (internacao != null) {
			switch (internacao.getTipoLeito()) {
			case ENFERMARIA:
				valorDiarias += ValorInternacao.MEDIA_ENFERMARIA.getPreco() * internacao.getQtdeDias(); // Internação Média
				break;
			case APARTAMENTO:
				valorDiarias += ValorInternacao.MEDIA_APARTAMENTO.getPreco() * internacao.getQtdeDias(); // Internação Média
				break;
			}
		}

		return valorDiarias;
	}

}

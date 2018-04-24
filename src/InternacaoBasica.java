
public class InternacaoBasica implements RegraDeDiarias {

	@Override
	public float calcula(Internacao internacao) {
		float valorDiarias = 0;

		if (internacao != null) {
			switch (internacao.getTipoLeito()) {
			case ENFERMARIA:
				valorDiarias += ValorInternacao.BASICA_ENFERMARIA.getPreco() * internacao.getQtdeDias();  // Internação Básica
				break;
			case APARTAMENTO:
				valorDiarias += ValorInternacao.BASICA_APARTAMENTO.getPreco() * internacao.getQtdeDias(); // Internação Básica
				break;
			}
		}

		return valorDiarias;
	}

}

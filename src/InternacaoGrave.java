
public class InternacaoGrave implements RegraDeDiarias {

	@Override
	public float calcula(Internacao internacao) {
		float valorDiarias = 0;

		if (internacao != null) {
			switch (internacao.getTipoLeito()) {
			case ENFERMARIA:
				valorDiarias += ValorInternacao.GRAVE_ENFERMARIA.getPreco() * internacao.getQtdeDias(); // Internação Grave
				break;
			case APARTAMENTO:
				valorDiarias += ValorInternacao.GRAVE_APARTAMENTO.getPreco() * internacao.getQtdeDias(); // Internação Grave
				break;
			}
		}

		return valorDiarias;
	}

}

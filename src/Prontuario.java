import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Set;

public class Prontuario {

	private String nomePaciente;
	private Internacao internacao;
	private Set<Procedimento> procedimentos = new HashSet<Procedimento>();
	private float valorTotalProcedimentos;

	public Prontuario(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public void setInternacao(Internacao internacao) {
		this.internacao = internacao;
	}

	public void addProcedimento(Procedimento procedimento) {
		this.procedimentos.add(procedimento);
	}

	public double valorDiarias() {
		return internacao.calcula();
	}

	public double valorProcedimentos() {
		return valorTotalProcedimentos;
	}

	public String imprimaConta() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();

		String conta = "----------------------------------------------------------------------------------------------";

		float valorDiarias = 0.0f;

		if (this.internacao != null) {
			valorDiarias = this.internacao.calcula();
		}

		conta += "\n\nConforme os detalhes abaixo:";

		//
		if (this.internacao != null) {
			conta += "\n\nValor Total Diárias:\t\t\t" + formatter.format(valorDiarias);
			conta += "\n\t\t\t\t\t" + this.internacao.getQtdeDias() + " diária"
					+ (this.internacao.getQtdeDias() > 1 ? "s" : "") + " em "
					+ (this.internacao.getTipoLeito() == TipoLeito.APARTAMENTO ? "apartamento" : "enfermaria");
		}

		conta += this.contabilizaProcedimentos();

		conta += "\nA conta do(a) paciente " + nomePaciente + " tem valor total de __ "
				+ formatter.format(valorDiarias + valorTotalProcedimentos) + " __";

		conta += "\n\nVolte sempre, a casa é sua!";
		conta += "\n----------------------------------------------------------------------------------------------";

		return conta;
	}

	public float calculaProcedimentos() {
		
		valorTotalProcedimentos = 0.00f;
		
		this.procedimentos.forEach(p -> {
			switch (p.getTipoProcedimento()) {
			case BASICO:
				valorTotalProcedimentos += ValorProcedimento.BASICO.getPreco();
				break;
			case COMUM:
				valorTotalProcedimentos += ValorProcedimento.COMUM.getPreco();
				break;
			case AVANCADO:
				valorTotalProcedimentos += ValorProcedimento.AVANCADO.getPreco();
				break;
			}
		});
		return valorTotalProcedimentos;
	}

	private String contabilizaProcedimentos() {

		NumberFormat formatter = NumberFormat.getCurrencyInstance();

		String conta = "";

		int qtdeProcedimentosBasicos = 0;
		int qtdeProcedimentosComuns = 0;
		int qtdeProcedimentosAvancados = 0;

		// Contabiliza os procedimentos
		for (Procedimento procedimento : procedimentos) {
			switch (procedimento.getTipoProcedimento()) {
			case BASICO:
				qtdeProcedimentosBasicos++;
				break;
			case COMUM:
				qtdeProcedimentosComuns++;
				break;
			case AVANCADO:
				qtdeProcedimentosAvancados++;
				break;
			}
		}
		this.calculaProcedimentos();

		if (procedimentos.size() > 0) {
			conta += "\n\nValor Total Procedimentos:\t\t" + formatter.format(valorTotalProcedimentos);

			if (qtdeProcedimentosBasicos > 0) {
				conta += "\n\t\t\t\t\t" + qtdeProcedimentosBasicos + " procedimento"
						+ (qtdeProcedimentosBasicos > 1 ? "s" : "") + " básico"
						+ (qtdeProcedimentosBasicos > 1 ? "s" : "");
			}

			if (qtdeProcedimentosComuns > 0) {
				conta += "\n\t\t\t\t\t" + qtdeProcedimentosComuns + " procedimento"
						+ (qtdeProcedimentosComuns > 1 ? "s" : "") + " comu"
						+ (qtdeProcedimentosComuns > 1 ? "ns" : "m");
			}

			if (qtdeProcedimentosAvancados > 0) {
				conta += "\n\t\t\t\t\t" + qtdeProcedimentosAvancados + " procedimento"
						+ (qtdeProcedimentosBasicos > 1 ? "s" : "") + " avançado"
						+ (qtdeProcedimentosAvancados > 1 ? "s" : "");
			}
		}

		return conta;
	}

	public void calcula() {
		if (this.internacao != null) {
			this.internacao.calcula();
		}
		this.calculaProcedimentos();
	}

}

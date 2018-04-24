public class Internacao {

	private TipoLeito tipoLeito;
	private int qtdeDias;
	private RegraDeDiarias tipoInternacao;

	public Internacao(TipoLeito tipoLeito, int qtdeDias) {
		this.tipoLeito = tipoLeito;
		this.qtdeDias = qtdeDias;
		tipoInternacao = getTipoInternacao(qtdeDias);
	}

	TipoLeito getTipoLeito() {
		return this.tipoLeito;
	}

	int getQtdeDias() {
		return this.qtdeDias;
	}

	float calcula() {
		return tipoInternacao.calcula(this);
	}

	private RegraDeDiarias getTipoInternacao(int qtdeDias) {
		RegraDeDiarias diarias;
		if (this.getQtdeDias() <= 3) {
			diarias = new InternacaoBasica();
		} else if (this.getQtdeDias() <= 8) {
			diarias = new InternacaoMedia();
		} else {
			diarias = new InternacaoGrave();
		}
		return diarias;
	}
}

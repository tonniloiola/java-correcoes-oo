import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class ProntuarioTest {
	
	@Test 
	public void internacaoBasicaLeitoEnfermariaZeroProcedimento() {
		Prontuario p = new Prontuario("teste");
		Internacao internacao = new Internacao(TipoLeito.ENFERMARIA, 1);
		p.setInternacao(internacao);
		p.calcula();
		assertEquals(p.valorDiarias(), ValorInternacao.BASICA_ENFERMARIA.getPreco());
	}

	@Test 
	public void internacaoMediaLeitoEnfermariaZeroProcedimento() {
		Prontuario p = new Prontuario("teste");
		Internacao internacao = new Internacao(TipoLeito.ENFERMARIA, 4);
		p.setInternacao(internacao);
		p.calcula();
		assertEquals(p.valorDiarias(), ValorInternacao.MEDIA_ENFERMARIA.getPreco() * 4);
	}

	@Test 
	public void internacaoGraveLeitoEnfermariaZeroProcedimento() {
		Prontuario p = new Prontuario("teste");
		Internacao internacao = new Internacao(TipoLeito.ENFERMARIA, 9);
		p.setInternacao(internacao);
		p.calcula();
		assertEquals(p.valorDiarias(), ValorInternacao.GRAVE_ENFERMARIA.getPreco() * 9);
	}
	
	@Test 
	public void internacaoBasicaLeitoApartamentoZeroProcedimento() {
		Prontuario p = new Prontuario("teste");
		Internacao internacao = new Internacao(TipoLeito.APARTAMENTO, 1);
		p.setInternacao(internacao);
		p.calcula();
		assertEquals(p.valorDiarias(), ValorInternacao.BASICA_APARTAMENTO.getPreco());
	}
	

	@Test 
	public void internacaoMediaLeitoApartamentoZeroProcedimento() {
		Prontuario p = new Prontuario("teste");
		Internacao internacao = new Internacao(TipoLeito.APARTAMENTO, 4);
		p.setInternacao(internacao);
		p.calcula();
		assertEquals(p.valorDiarias(), ValorInternacao.MEDIA_APARTAMENTO.getPreco() * 4);
	}

	@Test 
	public void internacaoGraveLeitoApartamentoZeroProcedimento() {
		Prontuario p = new Prontuario("teste");
		Internacao internacao = new Internacao(TipoLeito.APARTAMENTO, 9);
		p.setInternacao(internacao);
		p.calcula();
		assertEquals(p.valorDiarias(), ValorInternacao.GRAVE_APARTAMENTO.getPreco() * 9);
	}

	@Test 
	public void semInternacaoComUmProcedimentoComum() {
		Prontuario p = new Prontuario("teste");
		p.addProcedimento(new Procedimento(TipoProcedimento.COMUM));
		p.calcula();
		assertEquals(p.valorProcedimentos(), ValorProcedimento.COMUM.getPreco());
	}

	@Test 
	public void semInternacaoComUmProcedimentoBasico() {
		Prontuario p = new Prontuario("teste");
		p.addProcedimento(new Procedimento(TipoProcedimento.BASICO));
		p.calcula();
		assertEquals(p.valorProcedimentos(), ValorProcedimento.BASICO.getPreco());
	}

	@Test 
	public void semInternacaoComUmProcedimentoAvancado() {
		Prontuario p = new Prontuario("teste");
		p.addProcedimento(new Procedimento(TipoProcedimento.AVANCADO));
		p.calcula();
		assertEquals(p.valorProcedimentos(), ValorProcedimento.AVANCADO.getPreco());
	}
	
//	@Test 
	public void testeImprimindoConta() {
		Prontuario p = new Prontuario("teste");
		Internacao internacao = new Internacao(TipoLeito.APARTAMENTO, 1);
		p.setInternacao(internacao);
		p.addProcedimento(new Procedimento(TipoProcedimento.AVANCADO));
		p.calcula();
		System.out.println(p.imprimaConta());
	}
}

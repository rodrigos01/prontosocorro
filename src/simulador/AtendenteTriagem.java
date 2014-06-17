package simulador;

import java.util.Random;

public class AtendenteTriagem extends Atendente<Priorizavel> {
	
	private static final Random gerador = new Random();

	@Override
	public Priorizavel getClienteAtual() {
		return clienteAtual;
	}

	@Override
	public Priorizavel dispensarClienteAtual() {
		this.getClienteAtual().setPrioridade(gerador.nextBoolean());
		this.getClienteAtual().setTempoAtendimento(5,30);
		return super.dispensarClienteAtual();
	}

}

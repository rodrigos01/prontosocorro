package simulador;

import java.util.Random;

public class AtendenteTriagem extends Atendente {
	
	private static final Random gerador = new Random();

	@Override
	public Priorizavel getClienteAtual() {
		// TODO Auto-generated method stub
		return (ClientePriorizavel) super.getClienteAtual();
	}

	@Override
	public Priorizavel dispensarClienteAtual() {
		this.getClienteAtual().setPrioridade(gerador.nextBoolean());;
		return (ClientePriorizavel) super.dispensarClienteAtual();
	}

}

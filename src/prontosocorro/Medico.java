package prontosocorro;

import java.util.Random;

import simulador.Atendente;
import simulador.Cliente;
import simulador.QueueLinked;
import simulador.QueueTAD;

public class Medico extends Atendente {
	
	private static final Random gerador = new Random();

	public Medico(QueueTAD<Paciente> fila) {
		super(fila);
		// TODO Auto-generated constructor stub
	}
	
	public Medico() {
		this(new QueueLinked<Paciente>());	
	}


	@Override
	public Cliente dispensarClienteAtual() {
		this.getClienteAtual();
		return super.dispensarClienteAtual();
	}

}

package prontosocorro;

import simulador.Atendente;
import simulador.AtendenteTriagem;
import simulador.GeradorClientes;
import simulador.Priorizavel;
import simulador.QueuePriorized;
import simulador.Simulacao;

public class SimuladorProntoSocorro {

	public static void main(String[] args) {
		
		AtendenteTriagem triagem = new AtendenteTriagem();
		QueuePriorized<Priorizavel> filaAtendimento = new QueuePriorized<Priorizavel>();
		triagem.setFilaOut(filaAtendimento);
		Atendente<Priorizavel> medico = new Atendente<Priorizavel>(filaAtendimento);

		Simulacao sim = new Simulacao(triagem, new GeradorClientes(triagem.getFilaIn(), 0.1));
		
		sim.addCaixa(medico);
		
        sim.simular();
        sim.imprimirResultados();
	}

}

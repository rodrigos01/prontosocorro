package simulador;

public interface Atendivel {
	
	public int getNumero();
	
	public int getInstanteChegada();
	
	public void decrementarTempoAtendimento();
	
	public int getTempoAtendimento();
}

package simulador;

import java.util.Random;

public class Cliente implements Atendivel
{
	private int numero; //numero do cliente
	private int instanteChegada;
	private int tempoAtendimento; //quantidade de tempo que resta para o cliente no caixa
	private static final Random gerador = new Random();

	public Cliente(int n, int c)
	{
	    numero = n;
	    instanteChegada = c;
	    setTempoAtendimento(5,10);
	}
	
	public int getNumero()
	{
	    return numero;
	}
	
	public int getInstanteChegada()
	{
	    return instanteChegada;
	}
	
	public void decrementarTempoAtendimento()
	{
	    tempoAtendimento--;
	}
	
	public int getTempoAtendimento()
	{
	    return tempoAtendimento;
	}
	
	public void setTempoAtendimento(int tempo) {
		tempoAtendimento = tempo;
	}

	public void setTempoAtendimento(int tempoMinAtendimento, int tempoMaxAtendimento) {
		setTempoAtendimento(gerador.nextInt(tempoMaxAtendimento-tempoMinAtendimento+1)+tempoMinAtendimento); //gera valores entre 5 e 20
	}
}

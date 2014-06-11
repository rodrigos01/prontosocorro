package simulador;


public class Atendente
{
	private Cliente clienteAtual; //cliente sendo atendido no caixa
	private QueueTAD<Cliente> filaIn;
	private QueueTAD<Cliente> filaOut;
	public static int numeroAtendidos;
	public static Acumulador statTemposEsperaFila;

	public Atendente(QueueTAD<Cliente> fila)
	{
	    clienteAtual = null;
	    numeroAtendidos = 0;
	    this.filaIn = fila;
	    statTemposEsperaFila = new Acumulador();
	}
	
	public Atendente()
	{
		this(new QueueLinked<Cliente>());	
	}
	
	public void trabalhar() {
		//verificar se o caixa esta vazio
        if(this.estaVazio())
        {
            //se o caixa esta vazio, atender o primeiro cliente da fila se ele existir
            if(!filaIn.isEmpty())
            {
                //tirar o cliente do inicio da fila e atender no caixa
                atenderNovoCliente();
                statTemposEsperaFila.adicionar(Timer.tempo - getClienteAtual().getInstanteChegada());
                System.out.println(Timer.tempo+": cliente " + getClienteAtual().getNumero() + " chega ao caixa.");
            }
        }
        else
        {
            //se o caixa ja esta ocupado, diminuir de um em um o tempo de atendimento ate chegar a zero
            if(clienteAtual.getTempoAtendimento() == 0)
            {    
                System.out.println(Timer.tempo+": cliente " + getClienteAtual().getNumero() + " deixa o caixa.");
                dispensarClienteAtual();
            }
            else
            {
                getClienteAtual().decrementarTempoAtendimento();
            }
        }
	}

	public void atenderNovoCliente()
	{
	    clienteAtual = filaIn.remove();
	}
	
	public Atendivel dispensarClienteAtual()
	{
	    Cliente c = clienteAtual;
	    clienteAtual = null;
	    numeroAtendidos++;
	    if(filaOut != null) {
	    	filaOut.add(c);
	    }
	    return c;
	}
	
	public boolean estaVazio()
	{
	    return (clienteAtual == null);
	}
	
	public Atendivel getClienteAtual()
	{
	    return clienteAtual;
	}
	
	public static int getNumeroAtendidos()
	{
	    return numeroAtendidos;
	}

	public QueueTAD<Cliente> getFilaIn() {
		return filaIn;
	}

	public void setFilaIn(QueueTAD<Cliente> filaIn) {
		this.filaIn = filaIn;
	}

	public QueueTAD<Cliente> getFilaOut() {
		return filaOut;
	}

	public void setFilaOut(QueueTAD<Cliente> filaOut) {
		this.filaOut = filaOut;
	}
	
	
	
	
}

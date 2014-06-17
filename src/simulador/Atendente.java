package simulador;


public class Atendente <E extends Atendivel>
{
	protected E clienteAtual; //cliente sendo atendido no caixa
	private QueueTAD<E> filaIn;
	private QueueTAD<E> filaOut;
	private int numero;
	public static int numeroAtendidos;
	public static Acumulador statTemposEsperaFila;
	protected static int counter = 1;

	public Atendente(QueueTAD<E> fila)
	{
	    clienteAtual = null;
	    numeroAtendidos = 0;
	    this.filaIn = fila;
	    statTemposEsperaFila = new Acumulador();
	    numero = counter++;
	}
	
	public Atendente()
	{
		this(new QueueLinked<E>());	
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
                System.out.println(Timer.tempo+": cliente " + getClienteAtual().getNumero() + " chega ao atendente "+getNumero());
            }
        }
        else
        {
            //se o caixa ja esta ocupado, diminuir de um em um o tempo de atendimento ate chegar a zero
            if(clienteAtual.getTempoAtendimento() == 0)
            {    
                System.out.println(Timer.tempo+": cliente " + getClienteAtual().getNumero() + " deixa o atendente "+getNumero());
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
	
	public E dispensarClienteAtual()
	{
	    E c = clienteAtual;
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
	
	public E getClienteAtual()
	{
	    return clienteAtual;
	}
	
	public static int getNumeroAtendidos()
	{
	    return numeroAtendidos;
	}

	public QueueTAD<E> getFilaIn() {
		return filaIn;
	}

	public void setFilaIn(QueueTAD<E> filaIn) {
		this.filaIn = filaIn;
	}

	public QueueTAD<E> getFilaOut() {
		return filaOut;
	}

	public void setFilaOut(QueueTAD<E> filaOut) {
		this.filaOut = filaOut;
	}

	public int getNumero() {
		return numero;
	}
	
}

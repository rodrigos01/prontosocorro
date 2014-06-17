package simulador;

import java.util.Random;

/*
 * Esta classe indica se um cliente sera gerado de acordo com a probabilidade indicada no construtor
 */
public class GeradorClientes
{
	 
	protected QueueTAD<Atendivel> fila;
    protected double probabilidade;
    protected int quantidadeGerada;
    protected static final Random gerador = new Random(); //gerador de numeros aleatorios de Java
    
    public GeradorClientes(QueueTAD<? extends Atendivel> filaSaida, double p)
    {
        probabilidade = p;
        fila = (QueueTAD<Atendivel>) filaSaida;
        quantidadeGerada = 0;
    }
    
    public GeradorClientes() {
    	this(new QueueLinked<Atendivel>(), 0.1);
    }
    
    //verificar se um cliente chegou,se cliente chegou, criar um cliente e inserir na fila do caixa
    
    public void gerar()
    {
    	
       if(gerador.nextDouble() < probabilidade) {
        	
            quantidadeGerada++;
            
            Atendivel c = criar();
            fila.add(c);
            PrintLog.log(Timer.tempo+": Cliente "+c.getNumero()+" foi adicionado à fila. Recebe o número: "+fila.getCount());
        }
		
    }
    
    protected Atendivel criar() {
    	return new Cliente(quantidadeGerada,Timer.tempo); 
    }
    
    public int getQuantidadeGerada()
    {
        return quantidadeGerada;
    }

	public QueueTAD<Atendivel> getFila() {
		return fila;
	}

	public void setFila(QueueTAD<Atendivel> fila) {
		this.fila = fila;
	}

	public double getProbabilidade() {
		return probabilidade;
	}

	public void setProbabilidade(double probabilidade) {
		this.probabilidade = probabilidade;
	}
    
    
}

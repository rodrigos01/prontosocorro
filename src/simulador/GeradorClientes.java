package simulador;

import java.util.Random;

/*
 * Esta classe indica se um cliente sera gerado de acordo com a probabilidade indicada no construtor
 */
public class GeradorClientes
{
	 
	private QueueTAD<Atendivel> fila;
    private double probabilidade;
    private int quantidadeGerada;
    private static final Random gerador = new Random(); //gerador de numeros aleatorios de Java
    
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
            
            Atendivel c = new Cliente(quantidadeGerada,Timer.tempo); 
            
            fila.add(c);
        }
		
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

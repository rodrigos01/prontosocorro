package simulador;

import java.util.ArrayList;
import java.util.Random;

/*
 * Esta classe indica se um cliente sera gerado de acordo com a probabilidade indicada no construtor
 */
public class GeradorClientes
{
	 
	private QueueTAD<Cliente> fila;
	 private ArrayList<Atendente> caixas;
    private double probabilidade;
    private int quantidadeGerada;
    private static final Random gerador = new Random(); //gerador de numeros aleatorios de Java
    
    public GeradorClientes(double p)
    {
        probabilidade = p;
        quantidadeGerada = 0;
    }
    
    //verificar se um cliente chegou,se cliente chegou, criar um cliente e inserir na fila do caixa
    
    public  Cliente gerarClientes()
    {
    	boolean gerado = false;
           if(gerador.nextDouble() < probabilidade)
           {
        	
            quantidadeGerada++;
            gerado = true;
            
            Cliente c = new Cliente(quantidadeGerada,Timer.tempo);
            fila.add(c);
            return c;
            }
           Timer.tempo++;
           for(Atendente caixaTemp: caixas) {
           	caixaTemp.trabalhar();
           }
		return null;
		
        }
    
       
    
    public int getQuantidadeGerada()
    {
        return quantidadeGerada;
    }
}

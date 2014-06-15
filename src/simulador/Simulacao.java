package simulador;

import java.util.ArrayList;

/*
 * Classe com a logica da simulacao passo-a-passo
 */
public class Simulacao
{
    private static final int duracao = 200;
    private static final double probabilidadeChegada = 0.1;
    private QueueTAD<Atendivel> fila;
    private ArrayList<Atendente> caixas;
    private GeradorClientes geradorClientes;
    private boolean trace; //valor indica se a simulacao ira imprimir passo-a-passo os resultados
    
    public Simulacao(Atendente caixa, GeradorClientes fonte)
    {
    	caixas = new ArrayList<Atendente>();
        caixas.add(caixa);
        fila = caixa.getFilaIn(); //remover depois
        geradorClientes = fonte;
    }
    
    public Simulacao(boolean t) {
    	this(new Atendente(), new GeradorClientes(probabilidadeChegada));
    	trace = t;
    }
    
    public void addCaixa(Atendente caixa) {
    	caixas.add(caixa);
    }
    
    public void simular()
    {
        //realizar a simulacao por um certo numero de passos de duracao
        while(Timer.tempo<duracao)
        {
            //verificar se um cliente chegou
            if(geradorClientes.gerar())
            {
                //se cliente chegou, criar um cliente e inserir na fila do caixa
                Cliente c = new Cliente(geradorClientes.getQuantidadeGerada(),Timer.tempo);
                fila.add(c);
            }
            Timer.tempo++;
            for(Atendente caixaTemp: caixas) {
            	caixaTemp.trabalhar();
            }
        }
    }
    
    public void imprimirResultados()
    {
        System.out.println();
        System.out.println("Resultados da Simulacao");
        System.out.println("Duracao:" + duracao);
        System.out.println("Probabilidade de chegada de clientes:" + probabilidadeChegada);
        System.out.println("Tempo de atendimento minimo:" + Cliente.tempoMinAtendimento);
        System.out.println("Tempo de atendimento maximo:" + Cliente.tempoMaxAtendimento);
        System.out.println("Cliente atendidos:" + Atendente.getNumeroAtendidos());
        System.out.println("Clientes ainda na fila:" + fila.size());
        int clientesRestantes = 0;
        for(Atendente caixaTemp: caixas) {
        	if(caixaTemp.getClienteAtual() != null) {
        		clientesRestantes++;
        	}
        }
        System.out.println("Clientes ainda nos caixas: " + clientesRestantes);
        System.out.println("Total de clientes gerados:" + geradorClientes.getQuantidadeGerada());
        System.out.println("Tempo medio de espera:" + Atendente.statTemposEsperaFila.getMedia());
        System.out.println("Comprimento medio da fila:" + QueueTAD.statComprimentosFila.getMedia());
    }
}

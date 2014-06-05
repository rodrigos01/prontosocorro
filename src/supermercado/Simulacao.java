package supermercado;

/*
 * Classe com a logica da simulacao passo-a-passo
 */
public class Simulacao
{
    private static final int duracao = 200;
    private static final double probabilidadeChegada = 0.1;
    private QueueTAD<Cliente> fila;
    private Caixa caixa;
    private GeradorClientes geradorClientes;
    private boolean trace; //valor indica se a simulacao ira imprimir passo-a-passo os resultados
    
    public Simulacao(boolean t)
    {
        fila = new QueueLinked<Cliente>();
        caixa = new Caixa();
        geradorClientes = new GeradorClientes(probabilidadeChegada);
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
                if(trace)
                    System.out.println(Timer.tempo + ": cliente " + c.getNumero() + " ("+c.getTempoAtendimento()+" min) entra na fila - " + fila.size() + " pessoa(s)");
            }
            Timer.tempo++;
        }
    }
    
    public void limpar()
    {
        fila = new QueueLinked<Cliente>();
        caixa = new Caixa();
        geradorClientes = new GeradorClientes(probabilidadeChegada);
        Timer.tempo = 0;
    }
    
    public void imprimirResultados()
    {
        System.out.println();
        System.out.println("Resultados da Simulacao");
        System.out.println("Duracao:" + duracao);
        System.out.println("Probabilidade de chegada de clientes:" + probabilidadeChegada);
        System.out.println("Tempo de atendimento minimo:" + Cliente.tempoMinAtendimento);
        System.out.println("Tempo de atendimento maximo:" + Cliente.tempoMaxAtendimento);
        System.out.println("Cliente atendidos:" + caixa.getNumeroAtendidos());
        System.out.println("Clientes ainda na fila:" + fila.size());
        System.out.println("Cliente ainda no caixa:" + (caixa.getClienteAtual() != null));
        System.out.println("Total de clientes gerados:" + geradorClientes.getQuantidadeGerada());
        System.out.println("Tempo medio de espera:" + Caixa.statTemposEsperaFila.getMedia());
        System.out.println("Comprimento medio da fila:" + QueueTAD.statComprimentosFila.getMedia());
    }
}

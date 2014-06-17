package simulador;

public class GeradorClientesPriorizaveis extends GeradorClientes {

	
	
	public GeradorClientesPriorizaveis() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GeradorClientesPriorizaveis(QueueTAD<? extends Atendivel> filaSaida,
			double p) {
		super(filaSaida, p);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Atendivel criar() {
		return new ClientePriorizavel(quantidadeGerada,Timer.tempo);
	}
	
}

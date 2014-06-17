package simulador;


public class ClientePriorizavel extends Cliente implements Priorizavel {
	
	private boolean prioritario;

	public ClientePriorizavel(int n, int c) {
		super(n, c);
		// TODO Auto-generated constructor stub
	}

	public boolean isPrioritario() {
		return prioritario;
	}

	public void setPrioridade(boolean prioritario) {
		this.prioritario = prioritario;
	}

	public static ClientePriorizavel convertAtendivel(Atendivel at) {
		// TODO Auto-generated method stub
		ClientePriorizavel cp = new ClientePriorizavel(at.getNumero(), at.getInstanteChegada());
		return new ClientePriorizavel(at.getNumero(), at.getInstanteChegada());
		
	}
	
	

}

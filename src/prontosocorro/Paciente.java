package prontosocorro;

import simulador.Cliente;

public class Paciente extends Cliente {
	
	private boolean morrendo;

	public Paciente(int n, int c) {
		super(n, c);
		// TODO Auto-generated constructor stub
	}

	public boolean isMorrendo() {
		return morrendo;
	}

	public void setMorrendo(boolean morrendo) {
		this.morrendo = morrendo;
	}
	
	

}

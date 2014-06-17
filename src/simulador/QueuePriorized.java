package simulador;

public class QueuePriorized<E extends Priorizavel> extends QueueLinked<E> implements QueueTAD<E> {

	@Override
	public void add(E element) {
		Node<E> adicionado = new Node<E>(element);
		int number = 1;
		if(element.isPrioritario() && this.count > 0) {
			Node<E> anterior = head;
			adicionado.next = anterior;
			while(!anterior.element.isPrioritario() && anterior.next != null) {
				adicionado.next = anterior.next;
				anterior.next = adicionado;
				anterior = adicionado.next;
			}
			if(adicionado.next ==  null) {
				tail = adicionado;
			}
			if(adicionado.next == head) {
				head = adicionado;
			}
		} else {
			super.add(element);
			number = count;
		}
		
		PrintLog.log(Timer.tempo+": Elemento "+element.getNumero()+" foi adicionado à fila priorizada. Recebe o número: "+number);
		
	}
	
}

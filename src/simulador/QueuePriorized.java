package simulador;

public class QueuePriorized<E extends Priorizavel> extends QueueLinked<E> implements QueueTAD<E> {

	@Override
	public void add(E element) {
		Node<E> adicionado = new Node<E>(element);
		int number = 1;
		if(element.isPrioritario()) {
			Node<E> proximo = head;
			Node<E> anterior = head;
			while(!proximo.element.isPrioritario()) {
				anterior = proximo;
				proximo = proximo.next;
				number++;
			}
			anterior.next = adicionado;
			adicionado.next = proximo;
		} else {
			super.add(element);
			number = count;
		}
		
		PrintLog.log("Um elemento foi adicionado à fila priorizada. Recebe o número: "+number);
		
	}
	
}

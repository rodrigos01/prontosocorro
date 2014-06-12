package simulador;

public class QueuePriorized<E extends Priorizavel> extends QueueLinked<E> {

	@Override
	public void add(E element) {
		Node<E> adicionado = new Node<E>(element);
		if(element.isPrioritario()) {
			Node<E> proximo = head;
			Node<E> anterior = head;
			while(!proximo.element.isPrioritario()) {
				anterior = proximo;
				proximo = proximo.next;
			}
			anterior.next = adicionado;
			adicionado.next = proximo;
		} else {
			super.add(element);
		}
	}
	
}

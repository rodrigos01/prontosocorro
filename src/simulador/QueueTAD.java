package simulador;


public interface QueueTAD<E>
{
    public static Acumulador statComprimentosFila = new Acumulador();
    void add(E element);
    E remove();
    int size();
    boolean isEmpty();
    void clear();
    E element();
    int getCount();
}

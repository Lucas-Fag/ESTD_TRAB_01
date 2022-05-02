package Pilha;

public class PilhaEstatica {
    private Object vetor[];
    private int topo;

    public PilhaEstatica(int tamanho) {
        this.vetor = new Object[tamanho];
        this.topo = 0;
    }

    public boolean isEmpty() {
        return this.topo == 0;
    }
    
    public boolean isFull() {
        return this.topo == this.vetor.length;
    }

    public void push(Object valor) throws PilhaCheiaException {
        if (this.isFull()) {
            throw new PilhaCheiaException();
        }
        this.vetor[this.topo] = valor;
        this.topo++;
    }

    public Object pop() throws PilhaVaziaException{
        if (this.isEmpty()) {
            throw new PilhaVaziaException();
        }
        
        this.topo--;
        Object valor = this.vetor[this.topo];
        this.vetor[this.topo] = null;

        return valor;
    }
    

}
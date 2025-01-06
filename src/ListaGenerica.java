
public class ListaGenerica<T> {

    /* Refer�ncia para primeiro elemento */
    protected Elo prim;
    protected int tamanho;


    protected class Elo {
        protected T dado;
        protected Elo prox;

        public Elo() {
            prox = null;
        }

        public Elo(T elem) {
            dado = elem;
            prox = null;
        }

        public Elo(T elem, Elo proxElem) {
            dado = elem;
            prox = proxElem;
        }
    }


    public ListaGenerica()  //O(1)
    {
        prim = null;
        tamanho = 0;
    }

    /* Testa se a lista est� vazia. */
    public boolean vazia()    //O(1)
    {
        return prim == null;
    }

    public void insere(T novo)    // O(1)
    {
        Elo p = new Elo(novo);
        p.prox = prim;
        prim = p;
        tamanho++;
    }

    public boolean remove(T elem)    // O(n)
    {
        Elo p;
        Elo ant = null;

        for (p = prim; ((p != null) && (!p.dado.equals(elem))); p = p.prox)    // O(n)
            ant = p;

        if (p == null)    // O(1)
            return false;

        if (p == prim)    // O(1)
            prim = prim.prox;
        else
            ant.prox = p.prox;

        p = null;
        tamanho--;

        return true;
    }

    /*EXERICIO 1. LISTA 4. */
    public int tamanho()    // O(1)
    {
        return tamanho;
    }

    private void inverterListaRecursivo(Elo ant, Elo p)    // O(1)
    {
        if (p == null)    // O(1)
        {
            ant.prox = prim;
            prim = ant;
            return;
        } else {
            if (ant == prim)    // O(1)
            {
                ant.prox = null;
                inverterListaRecursivo(p, p.prox);
            } else {
                ant.prox = prim;
                prim = ant;
                inverterListaRecursivo(p, p.prox);
            }

        }
    }

    public void inverterListaRecursivo()    // O(1)
    {
        if (prim == null || prim.prox == null) return;    // O(1)

        Elo ant = prim, p = prim.prox;

        inverterListaRecursivo(prim, prim.prox);    // O(1)

        ant = null;
    }


    /*EXERCICIO 4 E 5. LISTA 4. */
    public String concatena() // O(n) * O(1) = O(n)
    {
        String s = "";
        Elo p;

        inverterListaRecursivo();    // O(1)

        for (p = prim; p != null; p = p.prox)    // O(n)
        {
            String dado = p.dado.toString();

            if (dado.matches("^\\W"))    // O(1)
                s += dado;
            else
                s += " " + dado;
        }

        return s;
    }

    @Override
    public String toString() {
        String string = "";

        for (Elo p = prim; p != null; p = p.prox)
            string += p.dado.toString() + " ";

        return string;
    }

    public String toString(String separador) {
        String string = "";

        for (Elo p = prim; p != null; p = p.prox)
            string += p.dado.toString() + separador;

        return string;
    }

}
import java.util.ArrayList;

public class publicacion implements Sujeto{

    private ArrayList<Observador> observadores;

    public publicacion(){
        observadores = new ArrayList<>();
    }

    public void agregar_publicacion(){
        notificar();
    }

    public void enlazarObservador(Observador o){observadores.add(o);}
    @Override
    public void notificar() {
        for(Observador o:observadores){
            o.update();
        }
    }
}


public class Curso implements Observador {

    @Override
    public void update() {
        //accion que realiza luego de enterarse
        System.out.println("Agregar publicacion a curso");
    }
}

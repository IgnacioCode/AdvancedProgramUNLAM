import java.util.List;
import java.util.LinkedList;

public class Main{

    Personaje[] vecPersonaje = new Personaje[5];
    Objeto[] vecObjeto = new Objeto[4];
    double[] vecCoheficientes = new double[vecPersonaje.lenght];

    for(int i=0;i<vecPersonaje.lenght;i++){
        vecCoheficientes[i] = vecPersonaje[i].getAltura() * vecPersonaje[i].getFuerza();
    }

    List<Double> listaCoheficientes = new LinkedList<Double>(vecCoheficientes);

    listaObjeto.sort();

    

}
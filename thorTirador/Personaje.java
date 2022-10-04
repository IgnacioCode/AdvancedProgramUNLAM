public class Personaje{

    private double altura;
    private double fuerza;
    public Personaje(double a,double f){
        altura=a;
        fuerza=f;
        coheficiente=a*f;
    }

    public double getAltura(){
        return altura;
    }

    public double getFuerza(){
        return fuerza;
    }
    
    
}

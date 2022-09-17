package mundo;

public class Vanilla extends Raza {

    public Vanilla(int x) {
        this.posicion = x;
        this.saludMaxima = 100;
        this.saludActual = 100;
        this.danioBasico = 10;
        this.danioActual = 10;
        this.rangoMinimo = 0;
        this.rangoMaximo = 100;
    }

    @Override
    public void atacar(Raza enemigo) {
        enemigo.recibirAtaque(danioActual);
    }

    @Override
    public void recibirAtaque(int dmg) {
        this.saludActual -= dmg;
    }

    @Override
    public void descansar() {
        this.saludActual = saludMaxima;
    }
}
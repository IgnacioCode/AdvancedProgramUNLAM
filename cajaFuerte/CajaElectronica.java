public class CajaElectronica{
    int x,y,z;
    boolean abierto;
    public CajaElectronica(int cx,int cy,int cz){
        abierto = false;
        x=cx;
        y=cy;
        z=cz;
    }

    public void ingresaClave(int ex,int ey, int ez)(){
        if(ex == x && ey == y && ez == z)
            abierto = true;
    }

    public boolean OK(){
        return abierto;
    }

}


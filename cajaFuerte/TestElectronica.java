public class TestElectronica{
    @Test
    public void prueba_correcta(){
        CajaElectronica miCaja = new CajaElectronica(2,1,5);
        miCaja.ingresaClave(2,1,5);
        System.out.prinln(miCaja.OK());

    }   

    @Test
    public void prueba_incorrecta(){
        CajaElectronica miCaja = new CajaElectronica(2,1,5);
        miCaja.ingresaClave(1,1,1);
        System.out.println(miCaja.OK());
    } 
}
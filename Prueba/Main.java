public class Main{
    public static void main(){
        int[] vec = {2,5,3,2,6,8,6,0};
        List<Integer> lista = new LinkedList<Integer>(new Stream(vec));

        lista.sort(null);
        int posMenor = 0;
        int posMayor = lista.size();
        
        while(posMenor != posMayor){
            int actual = lista.get(posMenor);
            int buscado = 8-actual;

            for(int i = actual+1;i<posMayor;i++){
                if(lista.get(i)==buscado){
                    posMayor = i-1;
                    elimina
                    break;
                }
                
            }

        }

    }
}
package sincroPro;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer 
{

    private static Integer valorCompartido = null;

    public static void main(String[] args) 
    {
        
        Lock lock = new ReentrantLock();
        Condition condicion = lock.newCondition();
        int limit = Integer.parseInt(args[0]);
        
        Thread productor = new Thread(() -> {
            for (int i = 0; i < limit; i++) 
            {
                
                int valor = i % 100;

                
                lock.lock();
                try 
                {
                    valorCompartido = valor;
                    System.out.println("Productor produjo el valor " + valor);
                   
                    condicion.signal();
                } finally 
                {
                    lock.unlock();
                }

                
                try 
                {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
            }
        });

        // Creamos el hilo consumidor
        Thread consumidor = new Thread(() -> {
            for (int i = 0; i < limit; i++) 
            {
                
                lock.lock();
                try 
                {
                    
                    while (valorCompartido == null) 
                    {
                        condicion.await();
                    }
                    
                    int valor = valorCompartido;
                    valorCompartido = null;
                    System.out.println("Consumidor consumió el valor " + valor);
                } catch (InterruptedException e) 
                {
                    e.printStackTrace();
                } finally 
                {
                    lock.unlock();
                }
            }
        });

        // Iniciamos ambos hilos
        productor.start();
        consumidor.start();
    }
}

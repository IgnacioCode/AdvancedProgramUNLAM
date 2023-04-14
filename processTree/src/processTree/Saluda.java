package processTree;

import java.util.concurrent.TimeUnit;

public class Saluda {

	public static void main(String[] args) throws InterruptedException {
		
		ProcessHandle process = ProcessHandle.current();
		long pid = process.pid();
		long ppid = process.parent().get().pid();
		System.out.println("Soy el proceso: "+pid+", Mi papa es: "+ppid);
		
		TimeUnit.SECONDS.sleep(5);	
		
	}

}

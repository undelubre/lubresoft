package singletonConEnumEConcurrencia;

import java.util.concurrent.atomic.AtomicBoolean;





public enum SingletonEnum {

	INSTANCE;

	
	private Integer entero;
	private String string;
	
	private SingletonEnum(){
		
		System.out.println("inicializando variables...");
		
		entero = 0;
		string="";
	}
	
	
	public Integer getEntero() {
		return entero;
	}
	public void setEntero(Integer entero) {
		this.entero = entero;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}

	
	public String toString(){
		return "[entero= "+entero+", string= "+string+"]";
	}
	
	
	
	
	public static void main(String args[]){
		System.out.println("["+Thread.currentThread().getId()+"] Inicio Thread principal: "+INSTANCE.toString());
		
		final AtomicBoolean sair = new AtomicBoolean(false);
		
		final Object monitor = new Object();
		
		Thread fio = new Thread(new Runnable() {
			
			public void run() {
				System.out.println("["+Thread.currentThread().getId()+"] Inicio Thread secundario: "+INSTANCE.toString());

				INSTANCE.setEntero(20);
				INSTANCE.setString("ASDFSDAF");
				System.out.println("["+Thread.currentThread().getId()+"] Thread secundario - modificanse as variables: "+INSTANCE.toString());
				
				try {
					synchronized (monitor) {
						monitor.wait();
						sair.set(true);
						System.out.println("["+Thread.currentThread().getId()+"] Thread secundario despois de monitor.wait() as variables foron modificadas no Thread principal "+INSTANCE.toString());
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				INSTANCE.setEntero(30);
				INSTANCE.setString("pppppppppp");
				System.out.println("["+Thread.currentThread().getId()+"] Fin Thread secundario - modificanse variables: "+INSTANCE.toString());
			}
		});
		
		INSTANCE.setEntero(10);
		INSTANCE.setString("poiu");
		
		System.out.println("["+Thread.currentThread().getId()+"] Thread principal - modificanse variables:  "+INSTANCE.toString());
		
		fio.start();

		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		INSTANCE.setEntero(70);
		
		System.out.println("["+Thread.currentThread().getId()+"] Fin Thread principal - modificase o enteiro:  "+INSTANCE.toString());
		
		
		while(!sair.get()){
			
			synchronized (monitor) {
				monitor.notifyAll();
			}
		}
		System.out.println("rematando....");
	}
}

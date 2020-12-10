package ProbasBasicas;

public class AsignacionesObjetos {
	
	Integer globalI;
	
	final private Cuadrado finalC;
	
	AsignacionesObjetos(Integer lado){
		finalC = new Cuadrado(lado);		
	}
	
	public void metodo9(){
		Integer localI;
//		System.out.println("localI= "+localI);
		System.out.println("globalI= "+globalI);
	}

	
	
	public static void main(String args[]){
		Cuadrado c0 = new Cuadrado(7);
		Integer i = c0.getLado();
		
		System.out.println("c0= "+c0.toString());
		System.out.println("i= "+i);
		
		c0.setLado(2);
		
		System.out.println("c0= "+c0.toString());
		System.out.println("i= "+i);
		
		i = 3;
		
		System.out.println("c0= "+c0.toString());
		System.out.println("i= "+i);
		
		Cuadrado c1 = c0;
		
		c1.setLado(5);
		
		System.out.println("c0= "+c0.toString());
		System.out.println("c1= "+c1.toString());
		
		Cuadrado cNew = new Cuadrado(c0);
		
		c0.setLado(9);
		
		System.out.println("c0= "+c0.toString());
		System.out.println("c1= "+c1.toString());
		System.out.println("cNew= "+cNew.toString());
		
		
		AsignacionesObjetos asign = new AsignacionesObjetos(17);
		
		System.out.println("finalC= "+asign.finalC.toString());
		//Error Compilacion non se pode asignar a unha variable final
//		asign.finalC = new Cuadrado(9);		
		System.out.println("finalC= "+asign.finalC.toString());
		
		//Facendo un set ==> permitese modificacion
		asign.finalC.setLado(99);
		
		System.out.println("finalC= "+asign.finalC.toString());
		
		
		
		
		Integer a = 7;
		
		if(a == 7){
			System.out.println("a == 7");
		}else{
			System.out.println("a != 7");
		}
		
		if(a.equals(7)){
			System.out.println("a.equals(7)");
		}else{
			System.out.println("a.equals(7) FALSE");
		}
		
		AsignacionesObjetos asign2 = new AsignacionesObjetos(0);
		
		asign2.metodo9();
		
		
		
		String s = null ;
		if ( s instanceof String ){
			System.out.println("null instanceof String");
		}else{
			System.out.println("null not instanceof String");
		}
		

	}
}

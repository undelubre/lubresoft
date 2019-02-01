package claseEstaticaPrivada;

import claseEstaticaPrivada.ExemploClaseNestedStatic.InnerClass;


public class Executable {


	public static void main(String args[]){
		
		ExemploClaseNestedStatic clase = new ExemploClaseNestedStatic();
		
		/* ******************************************************* */
		
		clase.metodoProba();
		ExemploClaseNestedStatic.metodoProba2();
		
		/*Necesitase un obxeto para instanciar a inner class*/
		InnerClass innerClass = clase.new InnerClass();
		
		innerClass.setInnerEnteiro(10);
		innerClass.setInnerString("asdfasdf");
		innerClass.metodoProba();
		
		System.out.println("innerClass= "+innerClass.toString());
		
		System.out.println();

		
		/* ******************************************************* */
		
		/*Para instanciar unha nested static class non se necesita dun obxeto, e ademais ten acceso a variable estaticas da outer class*/
		
		ExemploClaseNestedStatic.NestedClassEstatica claseInternaEstatica1 = new ExemploClaseNestedStatic.NestedClassEstatica();
		ExemploClaseNestedStatic.NestedClassEstatica claseInternaEstatica2 = new ExemploClaseNestedStatic.NestedClassEstatica();
		
		System.out.println("claseInternaEstatica1= "+claseInternaEstatica1.toString());
		System.out.println("claseInternaEstatica2= "+claseInternaEstatica2.toString());

		claseInternaEstatica1.setNestedEnteiro(1);
		claseInternaEstatica2.setNestedEnteiro(2);
		claseInternaEstatica1.metodoProba();
		
		System.out.println("claseInternaEstatica1= "+claseInternaEstatica1.toString());
		System.out.println("claseInternaEstatica2= "+claseInternaEstatica2.toString()); 
		
		claseInternaEstatica1.setNestedString("aaaaaaa");
		claseInternaEstatica2.setNestedString("bbbbbbb");
		
		System.out.println("claseInternaEstatica1= "+claseInternaEstatica1.toString());
		System.out.println("claseInternaEstatica2= "+claseInternaEstatica2.toString());
		

		
		
		
	}
}


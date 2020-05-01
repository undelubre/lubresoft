package exceptions;

import java.awt.List;

public class ProbasExceptions {

    public void metodoLanzaExcetion(final int option, final List lista) throws ExceptionProba {
        if (option == 1) {
            throw new ExceptionProba("exceptions.ProbasExceptions.ExceptionProba");
        }

        System.out.println("Esto puede producir un nullpointer --> lista.size()= " + lista.size());
    }

    public void metodoEmpregaMetodoThrowsException(final int option, final List lista)
            throws Exception {
        this.metodoLanzaExcetion(option, lista);
    }

    public void metodoEmpregaMetodoThrowsExceptionProba(final int option, final List lista)
            throws ExceptionProba {
        this.metodoLanzaExcetion(option, lista);
    }

    public static void main(final String args[]) {
        final ProbasExceptions p = new ProbasExceptions();

        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Executase: producese ExceptionProba executando metodo que throws Exception catcheado con Exection");
        try {
            p.metodoEmpregaMetodoThrowsException(1, null);
        } catch (final Exception e) {
            // TODO Auto-generated catch block
            System.out.println("metodo1EmpregaMetodoThrowsException: -Excecutando proba para lanzar ExceptionProba - " + e);
            e.printStackTrace();
        } finally {
            System.out.println("Continuase co seguinte metodo");
        }
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Executase: producese ExceptionProba executando metodo que throws ExceptionProba catcheado con Exection");

        try {
            p.metodoEmpregaMetodoThrowsExceptionProba(1, null);
        } catch (final Exception e) {
            // TODO Auto-generated catch block
            System.out.println("metodo2EmpregaMetodoThrowsExceptionProba:Excecutando proba para lanzar ExceptionProba - " + e);
            e.printStackTrace();
        } finally {
            System.out.println("Continuase co seguinte metodo");
        }
        System.out.println();

        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Executase: producese nullpointer executando metodo que throws Exception catcheado con Exection");
        try {
            p.metodoEmpregaMetodoThrowsException(2, null);
        } catch (final Exception e) {
            // TODO Auto-generated catch block
            System.out.println("metodo1EmpregaMetodoThrowsException: Excecutando proba para producir nullpointer - "+ e);
            e.printStackTrace();
        } finally {
            System.out.println("Continuase co seguinte metodo");
        }

        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Executase: producese nullpointer executando metodo que throws ExceptionProba catcheado con Exection");
        try {
            p.metodoEmpregaMetodoThrowsExceptionProba(2, null);
        } catch (final Exception e) {
            // TODO Auto-generated catch block
            System.out.println("metodo2EmpregaMetodoThrowsExceptionProba: Excecutando proba para producir nullpointer - " + e);
            e.printStackTrace();
        } finally {
            System.out.println("Continuase co seguinte metodo");
        }

        
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Executase: producese nullpointer executando metodo que throws ExceptionProba catcheado con ExectionProba");
        System.out.println("Como pode verse corta a execucion, non se pinta o do bloque finally nin o fin do programa");
        try {
            p.metodoEmpregaMetodoThrowsExceptionProba(2, null);
        } catch (final ExceptionProba e) {
            // TODO Auto-generated catch block
            System.out.println("metodo2EmpregaMetodoThrowsExceptionProba: Excecutando proba para producir nullpointer - " + e);
            e.printStackTrace();
        } finally {
            System.out.println("Continuase co seguinte metodo");
        }

        
        
        
        
        System.out.println("FIN EXECUCION");
    }

    class ExceptionProba extends Exception {
        public ExceptionProba(final String message) {
            super(message);
        }

    }
}

package obserbador;

import java.util.Observable;
import java.util.Observer;


public class ExampleObserver{

	public static void main(final String[] args) {
        System.out.println("Introducir Texto >");
        final FuenteEvento fuenteEvento = new FuenteEvento();

        /*Se añade obserbasor 1*/
        fuenteEvento.addObserver( new Observer() {

            // @Override
			public void update(final Observable o, final Object arg) {
				System.out.println("Observable1 - arg= "+arg);
			}
		});

        /*Se añade obserbasor 2*/
        fuenteEvento.addObserver( new Observer() {

            // @Override
        	public void update(final Observable o, final Object arg) {
        		System.out.println("Observable2 - arg= "+arg);
        	}
        });

        new Thread(fuenteEvento).start();
    }
}

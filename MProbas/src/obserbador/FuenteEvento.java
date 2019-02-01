package obserbador;

import java.util.*;

class FuenteEvento extends Observable implements Runnable {
    public void run() {
        while (true) {
            String respuesta = new Scanner(System.in).next();
            setChanged();
            notifyObservers(respuesta);
        }
    }
}
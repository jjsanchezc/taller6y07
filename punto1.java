import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class punto1 {
    protected String[] abejas = new String[2];
    protected boolean siEsta = false;
    public void leerArchivoTXT(String nombre_del_fichero) throws FileNotFoundException {
        int i = 0;

        nombre_del_fichero = (nombre_del_fichero.endsWith(".txt") ? nombre_del_fichero : nombre_del_fichero + ".txt");
        Scanner sc = new Scanner(new File(nombre_del_fichero));

        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            Scanner val = new Scanner(linea);
            String coordenadas = val.next();
            addAbejas(coordenadas, i);
            i++;
            val.close();
        }
        borrarAbejas(0);
        sc.close();
        ajustarArr();
    }

    // este metodo agregara una abeja en la coordenadas deseada y correra todas a la
    // derecha
    public int addAbejas(String coordenadas, int poscion) {
        if (abejas[abejas.length - 1] == null) {
            for (int i = abejas.length - 1; i > poscion; i--) {
                abejas[i] = abejas[i - 1];
            }
            abejas[poscion] = coordenadas;
            return 0;
        }

        return agrandarArr(abejas, coordenadas, poscion);
    }

    // este metodo sirve para agrnadar el array de Abjeas en 5 espacios mas
    private int agrandarArr(String ab[], String coordenadas, int poscion) {
        String[] array2 = new String[abejas.length + 5];
        for (int i = 0; i < abejas.length; i++) {
            array2[i] = abejas[i];
        }
        abejas = array2;
        return addAbejas(coordenadas, poscion);
    }

    // este metodo borrará la abeja en la coordenadas deseada
    public void replaceAbejas(String coordenadas, int poscion) {
        abejas[poscion] = coordenadas;
    }

    // este metodo borrará la abeja en la coordenadas deseada y correrá todo a la
    // izquierda
    public void borrarAbejas(int posicion) {

        for (int i = posicion; i < abejas.length - 1; i++) {
            abejas[i] = abejas[i + 1];
        }
    }

    // en caso que hayan 5 espacios vacios en el arreglo se reducirá el tamaño de
    // este
    public void ajustarArr() {
        int n = 0;
        for (int i = 1; i < abejas.length; i++) {
            if (abejas[n] != null) {
                n += 1;
            }
        }
        String[] ajustar = new String[n];
        for (int i = 0; i < ajustar.length; i++) {
            ajustar[i] = abejas[i];
        }
        abejas = ajustar;
    }

    //Este metodo funciona para buscar alguna coordenada, este devolverá la posicion en la que se encuentra
    public void buscar(String coordenadas) {
        for (int i = 0; i < abejas.length - 1; i++) {
            if (abejas[i].equals(coordenadas)) {
                siEsta = true;
                System.out.println("Está en la pos " + i);
                return;
            }
        }
        if(siEsta==false){
        System.out.println("No se pudo encontrar la abeja en la posición deseada");}
    }
}
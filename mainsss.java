import java.io.FileNotFoundException;

public class mainsss {
    public static void main(String[] args) {

        punto1 b1=new punto1();
        try {
            b1.leerArchivoTXT("algo");
            long i=System.currentTimeMillis();
            b1.buscar("-75.5850233848,6.327,1508.25");
            System.out.println(System.currentTimeMillis()-1);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
}

package Tema1;

import java.io.BufferedWriter;
import java.io.IOException;


public class WritterInFile {

    /**
     *  Metoda care imi scrie in fisier o lista de carti
     */
    public void ex1(Book[] rezultat, BufferedWriter writer) throws IOException {
        if(rezultat == null) {
            writer.write("Nu au fost gasite carti");
            writer.close();
            return ;
        }
            for (int i = 0; i < rezultat.length; i++){
                String str = (rezultat[i].publish()+"\n");
                //In caz ca vrem sa printam in terminal decomentam aceasta linie
                //System.out.println(rezultat[i].publish());
                writer.write(str);
            }
        writer.write("Numarul cartilor : "+rezultat.length);
        writer.close();
    }

    /**
     *  Metoda care imi scrie in fisier limbile
     */
    public void ex2(Language[] rezultat1, BufferedWriter writer) throws IOException{
        if(rezultat1 == null) {
            writer.write("Nu au fost gasite limbi");
            writer.close();
            return ;
        }
            for (int j=0; j<rezultat1.length; j++){
                String str = (rezultat1[j].getName()+" "+rezultat1[j].getCode()+"\n");
                //In caz ca vrem sa printam in terminal decomentam aceasta linie
                //System.out.println(rezultat1[j].getName()+" "+rezultat1[j].getCode());
                writer.write(str);
            }
        writer.close();
    }

    /**
     *  Metoda care imi scrie in fisier tarile
     */
    public void ex3(Country[] rezultat2, BufferedWriter writer) throws IOException{
        if(rezultat2 == null) {
            writer.write("Nu au fost gasite Tari");
            writer.close();
            return ;
        }
            for(int s=0; s<rezultat2.length; s++){
                String str = (rezultat2[s].getCountryCode()+"\n");
                //In caz ca vrem sa printam in terminal decomentam aceasta linie
                //System.out.println(rezultat2[s].getCountryCode());
                writer.write(str);
            }
        writer.close();
    }
}

package players;

import cards.*;
import java.util.ArrayList;

/**
 *
 * @author HİLAL
 */
public abstract class Oyuncu {
    
    private int oyuncuID = 999;
    private String oyuncuAdi;
    private int oyuncuSkor;
    private ArrayList<Sporcu> cardsList = new ArrayList<>();
    
    public Oyuncu(int oyuncuID, String oyuncuAdi, int oyuncuSkor) {
        this.oyuncuID = oyuncuID;
        this.oyuncuAdi = oyuncuAdi;
        this.oyuncuSkor = oyuncuSkor;
    }
    
    public Oyuncu(){
    
    }
    
    public int skorGoster(){
        return 0;
    }
    
    public abstract Sporcu kartSec();
    
    public int getOyuncuID() {
        return oyuncuID;
    }

    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }

    public int getOyuncuSkor() {
        return oyuncuSkor;
    }

    public void setOyuncuSkor(int oyuncuSkor) {
        this.oyuncuSkor += oyuncuSkor;
    }
    
    public void resetSkor(){
        this.oyuncuSkor = 0;
    }

    
    public void listeyeKartEkle(Sporcu a) {
    cardsList.add(a);
    }
    
    public void listedenKartCikar(int a) {
    cardsList.remove(a);
    }
    
    public ArrayList<Sporcu> kartListesi() {
        return cardsList;
    }
    
}

 package players;

import cards.Sporcu;
import java.util.Random;

/**
 *
 * @author HİLAL
 */
public class Bilgisayar extends Oyuncu{
    
    public int hamle=0;
    public Bilgisayar(int oyuncuID, String oyuncuAdi, int oyuncuSkor) {
        super(1, oyuncuAdi, 0);
    }

    public Bilgisayar() {
    }

    @Override
    public Sporcu kartSec() {
        
        Random r = new Random();
        int n = 0;

        if(hamle%2==0 && hamle<8){
            n=r.nextInt(4);
            while(super.kartListesi().get(n).isKartKullanildiMi() == true)
                n = r.nextInt(4);
            hamle++;
        }
        else if(hamle%2!=0 && hamle<8){
            n=4+r.nextInt(4);
            while(super.kartListesi().get(n).isKartKullanildiMi() == true)
                n = 4+r.nextInt(4);
            hamle++; 
        }
        else if(hamle>=8){
            n=r.nextInt(8);
            while(super.kartListesi().get(n).isKartKullanildiMi() == true)
                n = r.nextInt(8);
            
        }
        
        return super.kartListesi().get(n);
    }

    @Override
    public int skorGoster() {
        return super.skorGoster(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

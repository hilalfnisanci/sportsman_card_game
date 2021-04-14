package players;

import cards.Sporcu;

/**
 *
 * @author HİLAL
 */
public class Kullanici extends Oyuncu{

    public Kullanici(int oyuncuID, String oyuncuAdi, int oyuncuSkor) {
        super(0, oyuncuAdi, 0);
    }

    public Kullanici() {
    }
    
    @Override
    public Sporcu kartSec() {
        return super.kartListesi().get(8);
    }

    @Override
    public int skorGoster() {
        return super.skorGoster(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

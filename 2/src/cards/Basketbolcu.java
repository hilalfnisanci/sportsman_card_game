package cards;

/**
 *
 * @author HİLAL
 */
public class Basketbolcu extends Sporcu {
    
    private int ikilik;
    private int ucluk;
    private int serbestAtis;
    private boolean kartKullanildiMi=false;

    
    public Basketbolcu(int ikilik, int ucluk, int serbestAtis, String sporcuIsim, String sporcuTakim, int sporcuId,String image) {
        super(sporcuIsim, sporcuTakim,sporcuId, image);
        this.ikilik = ikilik;
        this.ucluk = ucluk;
        this.serbestAtis = serbestAtis;
    }
    
    public Basketbolcu() {
        
    }
    
    @Override
    public void setKartKullanildiMi(boolean kartKullanildiMi) {
        this.kartKullanildiMi = kartKullanildiMi;
    }

    @Override
    public boolean isKartKullanildiMi() {
        return kartKullanildiMi; 
    }

    @Override
    public int sporcuPuaniGoster(int a) {
        switch(a){
            case 0 -> {
                return ikilik;
            }
            case 1 -> {
                return ucluk;
            }
            case 2 -> {
                return serbestAtis;
            }
            default -> {
            }
        }
        return 0;

    }

}

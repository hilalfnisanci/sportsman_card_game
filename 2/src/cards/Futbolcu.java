package cards;

/**
 *
 * @author HİLAL
 */
public class Futbolcu extends Sporcu {
    private int penalti;
    private int asist;
    private int serbestVurus;
    private boolean kartKullanildiMi=false;

    
    
    public Futbolcu(int penalti, int asist, int serbestVurus,String sporcuIsim, String sporcuTakim, int sporcuId,String image) {
        super(sporcuIsim, sporcuTakim,sporcuId,image);
        this.penalti = penalti;
        this.asist = asist;
        this.serbestVurus = serbestVurus;
    }

    public Futbolcu() {
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
                return penalti;
            }
            case 1 -> {
                return asist;
            }
            case 2 -> {
                return serbestVurus;
            }
            default -> {
            }
        }
        return 0;
    }
    
}

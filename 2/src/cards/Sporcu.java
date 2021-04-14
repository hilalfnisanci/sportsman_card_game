package cards;
/**
 *
 * @author HİLAL
 */
public abstract class Sporcu {
    
    private String sporcuIsim;
    private String sporcuTakim;
    private int sporcuId;
    private boolean kartKullanildiMi;
    private String image;
    
    public Sporcu(String sporcuIsim, String sporcuTakim, int sporcuId,String image) {
        this.sporcuIsim = sporcuIsim;
        this.sporcuTakim = sporcuTakim;
        this.sporcuId = sporcuId;
        this.image = image;
    }

    public Sporcu() {
    }

    public int getSporcuId() {
        return sporcuId;
    }

    public void setSporcuId(int sporcuId) {
        this.sporcuId = sporcuId;
    }
    
    
    public String isImage() {
	return image;
    }
    
    public boolean isKartKullanildiMi() {
        return false;
    }

    public void setKartKullanildiMi(boolean kartKullanildiMi) {
        this.kartKullanildiMi = kartKullanildiMi;
    }
    
    public abstract int sporcuPuaniGoster(int a);
    
    
    public String getSporcuIsim() {
        return sporcuIsim;
    }

    public void setSporcuIsim(String sporcuIsim) {
        this.sporcuIsim = sporcuIsim;
    }

    public String getSporcuTakim() {
        return sporcuTakim;
    }

    public void setSporcuTakim(String sporcuTakim) {
        this.sporcuTakim = sporcuTakim;
    }
    
    @Override
    public String toString(){
        return "\nSporcu--> Isim: "+sporcuIsim+", Takım: "+sporcuTakim+"\n";
    }

    
}

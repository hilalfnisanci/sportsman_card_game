package build;

import cards.*;
import players.*;
import java.util.ArrayList;
import java.util.Collections;


public class CreaterClass {

    private ArrayList<Sporcu> cardListBasketball = new ArrayList<>();
    private ArrayList<Sporcu> cardListFootball = new ArrayList<>();
    private ArrayList<Sporcu> kullaniciList = new ArrayList<>();
    private ArrayList<Sporcu> bilgisayarList = new ArrayList<>();
    private Kullanici kullanici = new Kullanici();
    Bilgisayar bilgisayar = new Bilgisayar();
    
    public void cards(){
        
        Basketbolcu kobeBryant = new Basketbolcu(21,12,23,"Kobe Bryant","Los Angeles Lakers",0,"/images/basketciler/kobebryant.png");
        Basketbolcu stephenCurry = new Basketbolcu(12,13,15,"Stephen Curry","Golden State Warriors",1,"/images/basketciler/stephencurry.png");
        Basketbolcu cediOsman = new Basketbolcu(8,6,7,"Cedi Osman","Cleveland Cavaliers",2,"/images/basketciler/cediosman.png");
        Basketbolcu lucaDoncic = new Basketbolcu(11,8,18,"Luca Dončić","Dallas Mavericks",3,"/images/basketciler/lukadoncic.png");
        Basketbolcu kevinDurant = new Basketbolcu(17,7,24,"Kevin Durant","Brooklyn Nets",4,"/images/basketciler/kevındurant.png");
        Basketbolcu kevinLove = new Basketbolcu(13,8,19,"Kevin Love","Cleveland Cavaliers",5,"/images/basketciler/kevınlove.png");
        Basketbolcu lebronJames = new Basketbolcu(21,8,24,"LeBron James","Los Angeles Lakers",6,"/images/basketciler/lebronjames.png");
        Basketbolcu jamesHarden = new Basketbolcu(14,10,24,"James Harden","Houston Rockets",7,"/images/basketciler/jamesharden.png");
        
        cardListBasketball.add(kobeBryant);
        cardListBasketball.add(stephenCurry);
        cardListBasketball.add(cediOsman);
        cardListBasketball.add(lucaDoncic);
        cardListBasketball.add(kevinDurant);
        cardListBasketball.add(kevinLove);
        cardListBasketball.add(lebronJames);
        cardListBasketball.add(jamesHarden);
       
        // Kartlar rastgele sıralanır.
        Collections.shuffle(cardListBasketball);
        
        Futbolcu lionelMessi = new Futbolcu(97,282,47,"Lionel Messi","FC Barcelona",8,"/images/futbolcular/lionelmessi.png");
        Futbolcu cristianoRonaldo = new Futbolcu(129,223,46,"Cristiano Ronaldo","Juventus",9,"/images/futbolcular/ronaldo.png");
        Futbolcu lautaroMartinez = new Futbolcu(4,16,0,"Lautaro Martinez","Inter",10,"/images/futbolcular/lautaromartinez.png");
        Futbolcu mesutOzil = new Futbolcu(8,216,4,"Mesut Özil","Arsenal",11,"/images/futbolcular/mesutozil.png");
        Futbolcu neymar = new Futbolcu(53,156,14,"Neymar","Paris Saint-Germain",12,"/images/futbolcular/neymar.png");
        Futbolcu cenkTosun = new Futbolcu(24,43,2,"Cenk Tosun","Everton",13,"/images/futbolcular/cenktosun.png");
        Futbolcu hakanCalhanoglu = new Futbolcu(16,93,24,"Hakan Çalhanoğlu","Milan",14,"/images/futbolcular/hakancalhanoglu.png");
        Futbolcu ardaTuran = new Futbolcu(1,126,0,"Arda Turan","FC Barcelona",15,"/images/futbolcular/ardaturan.png");
        
        cardListFootball.add(lionelMessi);
        cardListFootball.add(cristianoRonaldo);
        cardListFootball.add(lautaroMartinez);
        cardListFootball.add(mesutOzil);
        cardListFootball.add(neymar);
        cardListFootball.add(cenkTosun);
        cardListFootball.add(hakanCalhanoglu);
        cardListFootball.add(ardaTuran);
        
        // Kartlar rastgele sıralanır.
        Collections.shuffle(cardListFootball);
        kartlariDagit();
        
    }
    
    public void kartlariDagit() {
        for(int i=0; i<4; i++){
            kullanici.listeyeKartEkle(cardListBasketball.get(i));
            bilgisayar.listeyeKartEkle(cardListFootball.get(i));
        }
    
        for(int i=4; i<8; i++) {
            kullanici.listeyeKartEkle(cardListFootball.get(i));
            bilgisayar.listeyeKartEkle(cardListBasketball.get(i));
        }
    }
    
    public void restart() {
        cardListBasketball.removeAll(cardListBasketball);
        cardListFootball.removeAll(cardListFootball);
        kullaniciList.removeAll(kullaniciList);
        bilgisayarList.removeAll(bilgisayarList);
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public Bilgisayar getBilgisayar() {
        return bilgisayar;
    }

    
}

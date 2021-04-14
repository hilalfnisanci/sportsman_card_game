package build;

import cards.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.JButton;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author HİLAL
 */
public class Test extends javax.swing.JFrame {
    
    public int sira = 0;
    public int hamle=0;
    public ArrayList<Sporcu> secilenKart = new ArrayList<>();
    CreaterClass oyunOzellikleri = new CreaterClass();
    public int kart1puan = 0;
    public int kart2puan = 0;
    public int a, n=0;
    int kartNoPc;
    int kartNoPlyr;
    
    
    public Test() {
        initComponents();
        button1.setVisible(false);
        oyunEkrani.setVisible(false);
        geriAl.setVisible(false);
        jLabel2.setVisible(false);
    }
    
    public void skorTahtasi() {
        player1name.setText(oyunOzellikleri.getKullanici().getOyuncuAdi());
        player1score.setText(Integer.toString(oyunOzellikleri.getKullanici().getOyuncuSkor()));
        System.out.println("Yeni Oyun Başlıyor.\nOyuncu Adı: " + oyunOzellikleri.getKullanici().getOyuncuAdi());
        
        player2name.setText("Bilgisayar");
        player2score.setText(Integer.toString(oyunOzellikleri.getBilgisayar().getOyuncuSkor()));
        
        oyunOzellikleri.cards();
    }
    
    public void raundScore() {
        
        player1score.setText(Integer.toString(oyunOzellikleri.getKullanici().getOyuncuSkor()));
        player2score.setText(Integer.toString(oyunOzellikleri.getBilgisayar().getOyuncuSkor()));
        
    }
    public void kartlariDagit(){

        bilgisayarCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fback.png"))); 
        bilgisayarCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fback.png"))); 
        bilgisayarCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fback.png"))); 
        bilgisayarCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fback.png"))); 
        bilgisayarCard5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bback.png"))); 
        bilgisayarCard6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bback.png"))); 
        bilgisayarCard7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bback.png")));
        bilgisayarCard8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bback.png"))); 
        
        kullaniciCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource(oyunOzellikleri.getKullanici().kartListesi().get(0).isImage())));
        kullaniciCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource(oyunOzellikleri.getKullanici().kartListesi().get(1).isImage())));
        kullaniciCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource(oyunOzellikleri.getKullanici().kartListesi().get(2).isImage())));
        kullaniciCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource(oyunOzellikleri.getKullanici().kartListesi().get(3).isImage())));
        kullaniciCard5.setIcon(new javax.swing.ImageIcon(getClass().getResource(oyunOzellikleri.getKullanici().kartListesi().get(4).isImage())));
        kullaniciCard6.setIcon(new javax.swing.ImageIcon(getClass().getResource(oyunOzellikleri.getKullanici().kartListesi().get(5).isImage())));
        kullaniciCard7.setIcon(new javax.swing.ImageIcon(getClass().getResource(oyunOzellikleri.getKullanici().kartListesi().get(6).isImage())));
        kullaniciCard8.setIcon(new javax.swing.ImageIcon(getClass().getResource(oyunOzellikleri.getKullanici().kartListesi().get(7).isImage())));
         
        System.out.println("Kartlar Dağıtıldı\n");
    }
    
    
    public void oyun(Sporcu kart) {
        
        if(sira==0){
            Random rnd = new Random();
            a=rnd.nextInt(3);
            ozellik.setText(a+1+". Özellik");
            jLabel2.setVisible(true);
            secilenKart.add(kart);
            
            kartNoPlyr = 999;
            for(int i=0; i<oyunOzellikleri.getBilgisayar().kartListesi().size(); i++){
                if(kart.getSporcuIsim().equals(oyunOzellikleri.getKullanici().kartListesi().get(i).getSporcuIsim())){
                    kartNoPlyr = i;
                }
            }
            card1.setIcon(new javax.swing.ImageIcon(getClass().getResource(kart.isImage())));
            card1.setVisible(true);
            kart1puan = kart.sporcuPuaniGoster(a);
            sira=1;
            
            oyun(oyunOzellikleri.bilgisayar.kartSec());
        }
        
        else if(sira==1){
            secilenKart.add(kart);
            
            kartNoPc = 999;
            for(int i=0; i<oyunOzellikleri.getBilgisayar().kartListesi().size(); i++){
                if(kart.getSporcuIsim().equals(oyunOzellikleri.getBilgisayar().kartListesi().get(i).getSporcuIsim())){
                    kartNoPc = i;
                }
            }
            
            card2.setIcon(new javax.swing.ImageIcon(getClass().getResource(kart.isImage())));
            card2.setVisible(true);
            kart2puan = kart.sporcuPuaniGoster(a);
            
            switch (kartNoPc) {
                    case 0 -> bilgisayarCard1.setVisible(false);
                    case 1 -> bilgisayarCard2.setVisible(false);
                    case 2 -> bilgisayarCard3.setVisible(false);
                    case 3 -> bilgisayarCard4.setVisible(false);
                    case 4 -> bilgisayarCard5.setVisible(false);
                    case 5 -> bilgisayarCard6.setVisible(false);
                    case 6 -> bilgisayarCard7.setVisible(false);
                    case 7 -> bilgisayarCard8.setVisible(false);
                    default -> {
                }
            }
            if(kart1puan!=kart2puan){
                secilenKart.get(0).setKartKullanildiMi(true);
                secilenKart.get(1).setKartKullanildiMi(true);   
            }else {
                secilenKart.get(0).setKartKullanildiMi(false);
                secilenKart.get(1).setKartKullanildiMi(false);
            }
            
            System.out.println("[Player]\nKart:=>" + secilenKart.get(0).getSporcuIsim() + "\nPuan=>" + kart1puan + "\nKart Kullanıldı mı?=>" + secilenKart.get(0).isKartKullanildiMi() + "\n");
            System.out.println("[Bilgisayar]\nKart:=>" + secilenKart.get(1).getSporcuIsim() + "\nPuan=>" + kart2puan + "\nKart Kullanıldı mı?=>" + secilenKart.get(1).isKartKullanildiMi() + "\n");
            System.out.println("---------RAUND SONU---------");
            
            if(kart1puan>kart2puan){
                System.out.println("Raundu kazanan: "+oyunOzellikleri.getKullanici().getOyuncuAdi()+"\n");
                hamle++;
            } 
            else if(kart1puan<kart2puan){
                System.out.println("Raundu kazanan: Bilgisayar"+"\n");
                hamle++;
            }  
            else{
                System.out.println("Kazanan Yok!"+"\n");
                hamle++;
            }
            sira=2;   
            
            Timer saat = new Timer();
            TimerTask gorev = new TimerTask(){
                @Override
                public void run() {
                    sira = 0;

                    saat.cancel();
                    
                    if(kart1puan>kart2puan){
                        oyunOzellikleri.getKullanici().setOyuncuSkor(10);
                        raundKazanan.setText(oyunOzellikleri.getKullanici().getOyuncuAdi());
                        showMessageDialog(null, "Raundu Kazanan: " + oyunOzellikleri.getKullanici().getOyuncuAdi());
                    }
                    else if(kart1puan<kart2puan){
                        oyunOzellikleri.getBilgisayar().setOyuncuSkor(10);
                        raundKazanan.setText("Bilgisayar");
                        showMessageDialog(null, "Raundu Kazanan: Bilgisayar");
                    }
                    else if(kart1puan==kart2puan){
                        raundKazanan.setText("Kazanan Yok");
                        geriAl.setVisible(true);
                        
                        for(int i=0; i<3; i++){
                            if(secilenKart.get(0).sporcuPuaniGoster(i) == secilenKart.get(1).sporcuPuaniGoster(i))
                                n++;
                        }       
                    }
                    secilenKart.removeAll(secilenKart);
                    raundScore();
                    oyunSonu();
                    n=0;
                }

            };
            int sure = 1000;
            saat.schedule(gorev, sure);
        }
    }
    
    public void oyunSonu(){
        int sayac=0;
        
        for(int i=0; i<8; i++){
            if(oyunOzellikleri.getKullanici().kartListesi().get(i).isKartKullanildiMi()==true)
                sayac++;
        }
        if(sayac==8 || n==3){
            System.out.println("------OYUN BİTTİ------");
            showMessageDialog(null, "---"+ "OYUN BİTTİ---");
            if(oyunOzellikleri.getKullanici().getOyuncuSkor() > oyunOzellikleri.getBilgisayar().getOyuncuSkor()){
                System.out.println("Kazanan: "+oyunOzellikleri.getKullanici().getOyuncuAdi());
                showMessageDialog(null, "Kazanan: "+oyunOzellikleri.getKullanici().getOyuncuAdi()+" = "+oyunOzellikleri.getKullanici().getOyuncuSkor());
            }
                
            else if(oyunOzellikleri.getKullanici().getOyuncuSkor() < oyunOzellikleri.getBilgisayar().getOyuncuSkor()){
                System.out.println("Kazanan: Bilgisayar");
                showMessageDialog(null, "Kazanan: Bilgisayar"+" = "+oyunOzellikleri.getBilgisayar().getOyuncuSkor());
            }   
            else{
                System.out.println("Kazanan Yok! Oyun berabere bitti.");
                showMessageDialog(null, "Oyun berabere\nOyuncuların skorları: "+oyunOzellikleri.getBilgisayar().getOyuncuSkor());
            }

            System.out.println(oyunOzellikleri.getKullanici().getOyuncuAdi()+": "+oyunOzellikleri.getKullanici().getOyuncuSkor());
            System.out.println("Bilgisayar: " + oyunOzellikleri.getBilgisayar().getOyuncuSkor());
            card1.setVisible(false);
            card2.setVisible(false);
        }
        
           
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        giris = new javax.swing.JPanel();
        text1 = new javax.swing.JTextField();
        button1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        oyunEkrani = new javax.swing.JPanel();
        kullaniciCard1 = new javax.swing.JButton();
        kullaniciCard2 = new javax.swing.JButton();
        kullaniciCard3 = new javax.swing.JButton();
        kullaniciCard4 = new javax.swing.JButton();
        kullaniciCard5 = new javax.swing.JButton();
        kullaniciCard6 = new javax.swing.JButton();
        kullaniciCard7 = new javax.swing.JButton();
        kullaniciCard8 = new javax.swing.JButton();
        bilgisayarCard1 = new javax.swing.JButton();
        bilgisayarCard2 = new javax.swing.JButton();
        bilgisayarCard3 = new javax.swing.JButton();
        bilgisayarCard4 = new javax.swing.JButton();
        bilgisayarCard5 = new javax.swing.JButton();
        bilgisayarCard6 = new javax.swing.JButton();
        bilgisayarCard7 = new javax.swing.JButton();
        bilgisayarCard8 = new javax.swing.JButton();
        player1name = new javax.swing.JLabel();
        player2name = new javax.swing.JLabel();
        player1score = new javax.swing.JLabel();
        player2score = new javax.swing.JLabel();
        geriAl = new javax.swing.JButton();
        card1 = new javax.swing.JLabel();
        card2 = new javax.swing.JLabel();
        raundDurumu = new javax.swing.JLabel();
        raundKazanan = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ozellik = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sporcu Kart Oyunu");
        setBackground(new java.awt.Color(51, 51, 51));
        setMinimumSize(new java.awt.Dimension(1213, 739));
        setResizable(false);
        getContentPane().setLayout(null);

        giris.setMinimumSize(new java.awt.Dimension(1200, 700));
        giris.setLayout(null);

        text1.setBackground(new java.awt.Color(102, 0, 0));
        text1.setForeground(new java.awt.Color(255, 255, 255));
        text1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text1.setText("isminizi giriniz");
        text1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text1ActionPerformed(evt);
            }
        });
        giris.add(text1);
        text1.setBounds(580, 460, 110, 40);

        button1.setBackground(new java.awt.Color(102, 0, 0));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("START");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        giris.add(button1);
        button1.setBounds(580, 530, 110, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/giris.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setDoubleBuffered(true);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        giris.add(jLabel1);
        jLabel1.setBounds(0, 0, 1200, 700);
        jLabel1.getAccessibleContext().setAccessibleName("giris");

        getContentPane().add(giris);
        giris.setBounds(0, 0, 1200, 700);
        giris.getAccessibleContext().setAccessibleName("");

        oyunEkrani.setLayout(null);

        kullaniciCard1.setBackground(new java.awt.Color(51, 51, 51));
        kullaniciCard1.setActionCommand("kullaniciCard1");
        kullaniciCard1.setAlignmentY(0.0F);
        kullaniciCard1.setBorder(null);
        kullaniciCard1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kullaniciCard1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        kullaniciCard1.setOpaque(false);
        kullaniciCard1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kullaniciCard1ActionPerformed(evt);
            }
        });
        oyunEkrani.add(kullaniciCard1);
        kullaniciCard1.setBounds(50, 480, 130, 200);

        kullaniciCard2.setBackground(new java.awt.Color(51, 51, 51));
        kullaniciCard2.setActionCommand("kullaniciCard2");
        kullaniciCard2.setBorder(null);
        kullaniciCard2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kullaniciCard2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        kullaniciCard2.setOpaque(false);
        kullaniciCard2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kullaniciCard2ActionPerformed(evt);
            }
        });
        oyunEkrani.add(kullaniciCard2);
        kullaniciCard2.setBounds(190, 480, 130, 200);

        kullaniciCard3.setBackground(new java.awt.Color(51, 51, 51));
        kullaniciCard3.setActionCommand("kullaniciCard3");
        kullaniciCard3.setAlignmentY(0.0F);
        kullaniciCard3.setBorder(null);
        kullaniciCard3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kullaniciCard3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        kullaniciCard3.setOpaque(false);
        kullaniciCard3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kullaniciCard3ActionPerformed(evt);
            }
        });
        oyunEkrani.add(kullaniciCard3);
        kullaniciCard3.setBounds(330, 480, 130, 200);

        kullaniciCard4.setBackground(new java.awt.Color(51, 51, 51));
        kullaniciCard4.setActionCommand("kullaniciCard4");
        kullaniciCard4.setBorder(null);
        kullaniciCard4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kullaniciCard4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        kullaniciCard4.setOpaque(false);
        kullaniciCard4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kullaniciCard4ActionPerformed(evt);
            }
        });
        oyunEkrani.add(kullaniciCard4);
        kullaniciCard4.setBounds(470, 480, 130, 200);

        kullaniciCard5.setBackground(new java.awt.Color(51, 51, 51));
        kullaniciCard5.setActionCommand("kullaniciCard5");
        kullaniciCard5.setBorder(null);
        kullaniciCard5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kullaniciCard5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        kullaniciCard5.setOpaque(false);
        kullaniciCard5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kullaniciCard5ActionPerformed(evt);
            }
        });
        oyunEkrani.add(kullaniciCard5);
        kullaniciCard5.setBounds(610, 480, 130, 200);

        kullaniciCard6.setBackground(new java.awt.Color(51, 51, 51));
        kullaniciCard6.setActionCommand("kullaniciCard6");
        kullaniciCard6.setBorder(null);
        kullaniciCard6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kullaniciCard6.setOpaque(false);
        kullaniciCard6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kullaniciCard6ActionPerformed(evt);
            }
        });
        oyunEkrani.add(kullaniciCard6);
        kullaniciCard6.setBounds(750, 480, 130, 200);

        kullaniciCard7.setBackground(new java.awt.Color(51, 51, 51));
        kullaniciCard7.setActionCommand("kullaniciCard7");
        kullaniciCard7.setBorder(null);
        kullaniciCard7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kullaniciCard7.setOpaque(false);
        kullaniciCard7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kullaniciCard7ActionPerformed(evt);
            }
        });
        oyunEkrani.add(kullaniciCard7);
        kullaniciCard7.setBounds(890, 480, 130, 200);

        kullaniciCard8.setBackground(new java.awt.Color(51, 51, 51));
        kullaniciCard8.setActionCommand("kullaniciCard8");
        kullaniciCard8.setBorder(null);
        kullaniciCard8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kullaniciCard8.setOpaque(false);
        kullaniciCard8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kullaniciCard8ActionPerformed(evt);
            }
        });
        oyunEkrani.add(kullaniciCard8);
        kullaniciCard8.setBounds(1030, 480, 130, 200);

        bilgisayarCard1.setActionCommand("bilgisayarCard1");
        bilgisayarCard1.setBorder(null);
        bilgisayarCard1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bilgisayarCard1.setOpaque(false);
        bilgisayarCard1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bilgisayarCard1ActionPerformed(evt);
            }
        });
        oyunEkrani.add(bilgisayarCard1);
        bilgisayarCard1.setBounds(50, 10, 130, 200);

        bilgisayarCard2.setActionCommand("bilgisayarCard2");
        bilgisayarCard2.setBorder(null);
        bilgisayarCard2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bilgisayarCard2.setOpaque(false);
        bilgisayarCard2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bilgisayarCard2ActionPerformed(evt);
            }
        });
        oyunEkrani.add(bilgisayarCard2);
        bilgisayarCard2.setBounds(190, 10, 130, 200);

        bilgisayarCard3.setActionCommand("bilgisayarCard3");
        bilgisayarCard3.setBorder(null);
        bilgisayarCard3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bilgisayarCard3.setOpaque(false);
        bilgisayarCard3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bilgisayarCard3ActionPerformed(evt);
            }
        });
        oyunEkrani.add(bilgisayarCard3);
        bilgisayarCard3.setBounds(330, 10, 130, 200);

        bilgisayarCard4.setActionCommand("bilgisayarCard4");
        bilgisayarCard4.setBorder(null);
        bilgisayarCard4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bilgisayarCard4.setOpaque(false);
        bilgisayarCard4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bilgisayarCard4ActionPerformed(evt);
            }
        });
        oyunEkrani.add(bilgisayarCard4);
        bilgisayarCard4.setBounds(470, 10, 130, 200);

        bilgisayarCard5.setActionCommand("bilgisayarCard5");
        bilgisayarCard5.setBorder(null);
        bilgisayarCard5.setOpaque(false);
        bilgisayarCard5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bilgisayarCard5ActionPerformed(evt);
            }
        });
        oyunEkrani.add(bilgisayarCard5);
        bilgisayarCard5.setBounds(610, 10, 130, 200);

        bilgisayarCard6.setActionCommand("bilgisayarCard6");
        bilgisayarCard6.setBorder(null);
        bilgisayarCard6.setOpaque(false);
        bilgisayarCard6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bilgisayarCard6ActionPerformed(evt);
            }
        });
        oyunEkrani.add(bilgisayarCard6);
        bilgisayarCard6.setBounds(750, 10, 130, 200);

        bilgisayarCard7.setActionCommand("bilgisayarCard7");
        bilgisayarCard7.setBorder(null);
        bilgisayarCard7.setOpaque(false);
        bilgisayarCard7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bilgisayarCard7ActionPerformed(evt);
            }
        });
        oyunEkrani.add(bilgisayarCard7);
        bilgisayarCard7.setBounds(890, 10, 130, 200);

        bilgisayarCard8.setActionCommand("bilgisayarCard8");
        bilgisayarCard8.setBorder(null);
        bilgisayarCard8.setOpaque(false);
        bilgisayarCard8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bilgisayarCard8ActionPerformed(evt);
            }
        });
        oyunEkrani.add(bilgisayarCard8);
        bilgisayarCard8.setBounds(1030, 10, 130, 200);

        player1name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        player1name.setForeground(new java.awt.Color(255, 255, 255));
        player1name.setText("Oyuncu");
        oyunEkrani.add(player1name);
        player1name.setBounds(20, 300, 110, 30);

        player2name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        player2name.setForeground(new java.awt.Color(255, 255, 255));
        player2name.setText("Bilgisayar");
        oyunEkrani.add(player2name);
        player2name.setBounds(20, 350, 120, 30);

        player1score.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        player1score.setForeground(new java.awt.Color(255, 255, 255));
        player1score.setText("0");
        oyunEkrani.add(player1score);
        player1score.setBounds(150, 300, 80, 30);

        player2score.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        player2score.setForeground(new java.awt.Color(255, 255, 255));
        player2score.setText("0");
        oyunEkrani.add(player2score);
        player2score.setBounds(150, 350, 90, 30);

        geriAl.setBackground(new java.awt.Color(102, 0, 0));
        geriAl.setForeground(new java.awt.Color(255, 255, 255));
        geriAl.setText("Raund berabere. Kartı geri al.");
        geriAl.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        geriAl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        geriAl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        geriAl.setOpaque(false);
        geriAl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geriAlActionPerformed(evt);
            }
        });
        oyunEkrani.add(geriAl);
        geriAl.setBounds(540, 290, 210, 100);

        card1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oyunEkrani.add(card1);
        card1.setBounds(490, 240, 130, 200);

        card2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oyunEkrani.add(card2);
        card2.setBounds(670, 240, 130, 200);

        raundDurumu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        raundDurumu.setForeground(new java.awt.Color(0, 0, 0));
        raundDurumu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        raundDurumu.setText("Son Raund Kazanan");
        oyunEkrani.add(raundDurumu);
        raundDurumu.setBounds(970, 280, 210, 60);

        raundKazanan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        raundKazanan.setForeground(new java.awt.Color(0, 0, 0));
        raundKazanan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oyunEkrani.add(raundKazanan);
        raundKazanan.setBounds(1000, 320, 140, 60);

        jLabel2.setBackground(new java.awt.Color(80, 80, 80));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Karşılaştırılıyor");
        oyunEkrani.add(jLabel2);
        jLabel2.setBounds(1000, 430, 150, 40);

        ozellik.setBackground(new java.awt.Color(80, 80, 80));
        ozellik.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ozellik.setForeground(new java.awt.Color(0, 0, 0));
        ozellik.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oyunEkrani.add(ozellik);
        ozellik.setBounds(1010, 400, 130, 40);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arkaplanson.png"))); // NOI18N
        oyunEkrani.add(background);
        background.setBounds(0, 0, 1200, 700);

        getContentPane().add(oyunEkrani);
        oyunEkrani.setBounds(0, 0, 1200, 700);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public Test(JLabel background, JButton bilgisayarCard1, JButton bilgisayarCard2, JButton bilgisayarCard3, JButton bilgisayarCard4, JButton bilgisayarCard5, JButton bilgisayarCard6, JButton bilgisayarCard7, JButton bilgisayarCard8, JButton button1, JLabel card1, JLabel card2, JPanel giris, JLabel jLabel1, JButton kullaniciCard1, JButton kullaniciCard2, JButton kullaniciCard3, JButton kullaniciCard4, JButton kullaniciCard5, JButton kullaniciCard6, JButton kullaniciCard7, JButton kullaniciCard8, JPanel oyunEkrani, JLabel player1name, JLabel player1score, JLabel player2name, JLabel player2score, JLabel raundDurumu, JLabel raundKazananPlayer, JTextField text1) {
        this.background = background;
        this.bilgisayarCard1 = bilgisayarCard1;
        this.bilgisayarCard2 = bilgisayarCard2;
        this.bilgisayarCard3 = bilgisayarCard3;
        this.bilgisayarCard4 = bilgisayarCard4;
        this.bilgisayarCard5 = bilgisayarCard5;
        this.bilgisayarCard6 = bilgisayarCard6;
        this.bilgisayarCard7 = bilgisayarCard7;
        this.bilgisayarCard8 = bilgisayarCard8;
        this.button1 = button1;
        this.card1 = card1;
        this.card2 = card2;
        this.giris = giris;
        this.jLabel1 = jLabel1;
        this.kullaniciCard1 = kullaniciCard1;
        this.kullaniciCard2 = kullaniciCard2;
        this.kullaniciCard3 = kullaniciCard3;
        this.kullaniciCard4 = kullaniciCard4;
        this.kullaniciCard5 = kullaniciCard5;
        this.kullaniciCard6 = kullaniciCard6;
        this.kullaniciCard7 = kullaniciCard7;
        this.kullaniciCard8 = kullaniciCard8;
        this.oyunEkrani = oyunEkrani;
        this.player1name = player1name;
        this.player1score = player1score;
        this.player2name = player2name;
        this.player2score = player2score;
        this.raundDurumu = raundDurumu;
        this.raundKazanan = raundKazananPlayer;
        this.text1 = text1;
    }
    
    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        
        giris.setVisible(false);
        oyunEkrani.setVisible(true);
        oyunOzellikleri.getKullanici().setOyuncuAdi(text1.getText());
        skorTahtasi();
        kartlariDagit();
        
    }//GEN-LAST:event_button1ActionPerformed

    private void text1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text1ActionPerformed
        button1.setVisible(true);
    }//GEN-LAST:event_text1ActionPerformed

    private void kullaniciCard2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kullaniciCard2ActionPerformed

        if(hamle%2!=0 && hamle<8){
            if(sira==0){
                oyun(oyunOzellikleri.getKullanici().kartListesi().get(1));
                kullaniciCard2.setVisible(false);  
                
            }
        }
        else if(hamle>=8){
            if(sira==0){
                oyun(oyunOzellikleri.getKullanici().kartListesi().get(1));
                kullaniciCard2.setVisible(false);
            }
        }
        else{
            showMessageDialog(null, "Bu kartı seçemezsiniz");
        }
        
    }//GEN-LAST:event_kullaniciCard2ActionPerformed

    private void kullaniciCard4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kullaniciCard4ActionPerformed
        if(hamle%2!=0 && hamle<8){
                if(sira>=0){
                    oyun(oyunOzellikleri.getKullanici().kartListesi().get(3));
                    kullaniciCard4.setVisible(false);  
                    
                   
                }
            }
        else if(hamle>=8){
            if(sira>=0){
                    oyun(oyunOzellikleri.getKullanici().kartListesi().get(3));
                    kullaniciCard4.setVisible(false);  
                    
                   
                }
        }
        else{
            showMessageDialog(null, "Bu kartı seçemezsiniz");
        }
        
        
    }//GEN-LAST:event_kullaniciCard4ActionPerformed

    private void kullaniciCard5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kullaniciCard5ActionPerformed
        if(hamle%2==0 && hamle<8){
                if(sira==0){
                    oyun(oyunOzellikleri.getKullanici().kartListesi().get(4));
                    kullaniciCard5.setVisible(false);
                    
                 
                }
            }
        else if(hamle>=8){
            if(sira==0){
                    oyun(oyunOzellikleri.getKullanici().kartListesi().get(4));
                    kullaniciCard5.setVisible(false);
                    
                }
        }
        else{
                showMessageDialog(null, "Bu kartı seçemezsiniz");
            }
    }//GEN-LAST:event_kullaniciCard5ActionPerformed

    private void bilgisayarCard2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bilgisayarCard2ActionPerformed
        // TODO add your handling code here:
 
    }//GEN-LAST:event_bilgisayarCard2ActionPerformed

    private void kullaniciCard8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kullaniciCard8ActionPerformed
        if(hamle%2==0 && hamle<8){
                if(sira==0){
                    oyun(oyunOzellikleri.getKullanici().kartListesi().get(7));
                    kullaniciCard8.setVisible(false); 
                }    
            }
        else if(hamle>=8){
            if(sira==0){
                    oyun(oyunOzellikleri.getKullanici().kartListesi().get(7));
                    kullaniciCard8.setVisible(false); 
                }
        }
            else{
                showMessageDialog(null, "Bu kartı seçemezsiniz");
            } 
  
    }//GEN-LAST:event_kullaniciCard8ActionPerformed

    private void kullaniciCard1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kullaniciCard1ActionPerformed

            if(hamle%2!=0 && hamle<8){
                if(sira==0){
                    oyun(oyunOzellikleri.getKullanici().kartListesi().get(0));
                    kullaniciCard1.setVisible(false);
                }   
            }
            else if(hamle>=8){
                if(sira==0){
                    oyun(oyunOzellikleri.getKullanici().kartListesi().get(0));
                    kullaniciCard1.setVisible(false);
                }
            }
            else{
                showMessageDialog(null, "Bu kartı seçemezsiniz");
            }
        
        
    }//GEN-LAST:event_kullaniciCard1ActionPerformed

    private void kullaniciCard3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kullaniciCard3ActionPerformed
        
            if(hamle%2!=0 && hamle<8){
                if(sira==0){
                    oyun(oyunOzellikleri.getKullanici().kartListesi().get(2));
                    kullaniciCard3.setVisible(false); 
                }
            }
            else if(hamle>=8){
                if(sira==0){
                    oyun(oyunOzellikleri.getKullanici().kartListesi().get(2));
                    kullaniciCard3.setVisible(false); 
                }
            }
            else{
                showMessageDialog(null, "Bu kartı seçemezsiniz");
            } 
 
    }//GEN-LAST:event_kullaniciCard3ActionPerformed

    private void kullaniciCard6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kullaniciCard6ActionPerformed
        if(hamle%2==0 && hamle<8){
                if(sira==0){
                    oyun(oyunOzellikleri.getKullanici().kartListesi().get(5));
                    kullaniciCard6.setVisible(false);
                }
            }
        else if(hamle>=8){
            if(sira==0){
                    oyun(oyunOzellikleri.getKullanici().kartListesi().get(5));
                    kullaniciCard6.setVisible(false); 
            }
        }
            else{
                showMessageDialog(null, "Bu kartı seçemezsiniz");
            }
    }//GEN-LAST:event_kullaniciCard6ActionPerformed

    private void kullaniciCard7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kullaniciCard7ActionPerformed
        if(hamle%2==0 && hamle<8){
            if(sira==0){
                oyun(oyunOzellikleri.getKullanici().kartListesi().get(6));
                kullaniciCard7.setVisible(false);
            }
        }
        else if(hamle>=8){
            if(sira==0){
                oyun(oyunOzellikleri.getKullanici().kartListesi().get(6));
                kullaniciCard7.setVisible(false);
            }
        }
        else{
            showMessageDialog(null, "Bu kartı seçemezsiniz");
        } 
    }//GEN-LAST:event_kullaniciCard7ActionPerformed

    private void bilgisayarCard1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bilgisayarCard1ActionPerformed
        
    }//GEN-LAST:event_bilgisayarCard1ActionPerformed

    private void bilgisayarCard3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bilgisayarCard3ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_bilgisayarCard3ActionPerformed

    private void bilgisayarCard4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bilgisayarCard4ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_bilgisayarCard4ActionPerformed

    private void bilgisayarCard5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bilgisayarCard5ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_bilgisayarCard5ActionPerformed

    private void bilgisayarCard6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bilgisayarCard6ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_bilgisayarCard6ActionPerformed

    private void bilgisayarCard7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bilgisayarCard7ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_bilgisayarCard7ActionPerformed

    private void bilgisayarCard8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bilgisayarCard8ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_bilgisayarCard8ActionPerformed

    private void geriAlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geriAlActionPerformed
        // TODO add your handling code here:
        geriAl.setVisible(false);
        card1.setVisible(false);
        card2.setVisible(false);
        switch(kartNoPc){
            case 0 -> bilgisayarCard1.setVisible(true);
            case 1 -> bilgisayarCard2.setVisible(true);
            case 2 -> bilgisayarCard3.setVisible(true);
            case 3 -> bilgisayarCard4.setVisible(true);
            case 4 -> bilgisayarCard5.setVisible(true);
            case 5 -> bilgisayarCard6.setVisible(true);
            case 6 -> bilgisayarCard7.setVisible(true);
            case 7 -> bilgisayarCard8.setVisible(true);
            default -> {
            }
        }
        switch(kartNoPlyr){
            case 0 -> kullaniciCard1.setVisible(true);
            case 1 -> kullaniciCard2.setVisible(true);
            case 2 -> kullaniciCard3.setVisible(true);
            case 3 -> kullaniciCard4.setVisible(true);
            case 4 -> kullaniciCard5.setVisible(true);
            case 5 -> kullaniciCard6.setVisible(true);
            case 6 -> kullaniciCard7.setVisible(true);
            case 7 -> kullaniciCard8.setVisible(true);
            default -> {
            }
        }
        
    }//GEN-LAST:event_geriAlActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Test().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton bilgisayarCard1;
    private javax.swing.JButton bilgisayarCard2;
    private javax.swing.JButton bilgisayarCard3;
    private javax.swing.JButton bilgisayarCard4;
    private javax.swing.JButton bilgisayarCard5;
    private javax.swing.JButton bilgisayarCard6;
    private javax.swing.JButton bilgisayarCard7;
    private javax.swing.JButton bilgisayarCard8;
    private javax.swing.JButton button1;
    private javax.swing.JLabel card1;
    private javax.swing.JLabel card2;
    private javax.swing.JButton geriAl;
    private javax.swing.JPanel giris;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton kullaniciCard1;
    private javax.swing.JButton kullaniciCard2;
    private javax.swing.JButton kullaniciCard3;
    private javax.swing.JButton kullaniciCard4;
    private javax.swing.JButton kullaniciCard5;
    private javax.swing.JButton kullaniciCard6;
    private javax.swing.JButton kullaniciCard7;
    private javax.swing.JButton kullaniciCard8;
    private javax.swing.JPanel oyunEkrani;
    private javax.swing.JLabel ozellik;
    private javax.swing.JLabel player1name;
    private javax.swing.JLabel player1score;
    private javax.swing.JLabel player2name;
    private javax.swing.JLabel player2score;
    private javax.swing.JLabel raundDurumu;
    private javax.swing.JLabel raundKazanan;
    private javax.swing.JTextField text1;
    // End of variables declaration//GEN-END:variables
}

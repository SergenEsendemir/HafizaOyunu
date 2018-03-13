package HafizaOyunPackage;

import javax.swing.*;
import java.awt.*; //frame
import java.awt.event.*; //action listener
import java.util.Calendar;

public class HafizaArayuz extends Frame implements ActionListener {
	
	HucreIslemleri hucreIslemleri = new HucreIslemleri();
	Hafiza hafiza = new Hafiza();
	JFrame FrmFrame = new JFrame("  HAFIZA OYUNU  ");
	JMenuBar MnUstMenum = new JMenuBar(); 
    JMenu MnIslem = new JMenu(" ��lemler ");
    JMenuItem MYeniOyun = new JMenuItem("Yeniden Ba�lat");
    JMenuItem MNIOyunuCoz = new JMenuItem("Oyunu ��z");
    JMenuItem MOyunuKapat = new JMenuItem("Oyunu Kapat");
    JMenu MnDurum = new JMenu(" Durum ");
    JMenuItem MNIGecenSure = new JMenuItem("Ge�en S�re");
    JMenuItem MNIBasariDurumu = new JMenuItem("Ba�ar� Durumunuz");
    JMenu MnDestek = new JMenu(" Destek ");
    JMenuItem MNIOyunOynanisi = new JMenuItem("Oynama �ekli");
    int BasariDurumunuAktiflestir = 1;
	
    HafizaArayuz(){
    	
    	FrmFrame.setSize(550, 560);
    	FrmFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	FrmFrame.setResizable(false);
    	FrmFrame.setVisible(true);
        FrmFrame.setLocationRelativeTo(null);
        FrmFrame.setJMenuBar(MnUstMenum);
        MnUstMenum.add(MnIslem);
        MnUstMenum.add(MnDurum);
        MnUstMenum.add(MnDestek);
        MnIslem.add(MYeniOyun);
        MnIslem.add(MNIOyunuCoz);
        MnIslem.add(MOyunuKapat);
        MnDurum.add(MNIGecenSure);
        MnDurum.add(MNIBasariDurumu);
        MnDestek.add(MNIOyunOynanisi);
        FrmFrame.add(hucreIslemleri.PanelHucreler);
        MNIOyunuCoz.addActionListener(this);
        MYeniOyun.addActionListener(this);
        MOyunuKapat.addActionListener(this);
        MNIGecenSure.addActionListener(this);
        MNIBasariDurumu.addActionListener(this);
        MNIOyunOynanisi.addActionListener(this);
    }
    
    private void YeniOyun() {
    	for (int i = 0; i < 16; i++) {
    		hucreIslemleri.ButtonHucre[i].setIcon(hucreIslemleri.BtnHucreilkResim);
    		hucreIslemleri.ButtonHucre[i].setEnabled(true);
    		hucreIslemleri.ButtonHucre[i].setName("00");
    	}   	
        hucreIslemleri.RandomHucreResmi1 = new int[8];
		hucreIslemleri.RandomHucreResmi2 = new int[8];
	    hucreIslemleri.RandomHucreResmiHepsi = new int[16];
	    hucreIslemleri.Sayilar=new int[16];
    	hucreIslemleri.HucreResimleriniRastgeleDagit();
    	hucreIslemleri.HucreSayaci = 0;
    	hucreIslemleri.AcikHucrelerinSayisi = 0;
    	hucreIslemleri.SonTiklananButon[0]=22;
        hucreIslemleri.SonTiklananButon[1]=22;
        hucreIslemleri.CozulmusHucrelerinSayisi = 0;
        BasariDurumunuAktiflestir = 1;       
    }
    
    public void HucreleriCoz() {
        for (int i = 0; i < 16; i++) {
            hucreIslemleri.ButtonHucre[i].setIcon(hucreIslemleri.BtnHucreResimleri[i]);
            hucreIslemleri.ButtonHucre[i].setName(String.valueOf(hucreIslemleri.RandomHucreResmiHepsi[i]));
            hucreIslemleri.ButtonHucre[i].setDisabledIcon(hucreIslemleri.BtnHucreResimleri[i]);
            hucreIslemleri.ButtonHucre[i].setEnabled(false);
        }
        BasariDurumunuAktiflestir = 0;
    }
    
    public void actionPerformed(ActionEvent e) {
    	hucreIslemleri.calendar = Calendar.getInstance();
    	 if (e.getSource() == MOyunuKapat) 
    	 {
    		 System.exit(0);
    	 } 
    	 if (e.getSource() == MYeniOyun) 
    	 {
    		 YeniOyun();		
    	 }
    	 if (e.getSource() == MNIOyunuCoz)
    	 {
             HucreleriCoz();
    	 }
    	 if (e.getSource() == MNIGecenSure) 
    	 {
             JOptionPane.showMessageDialog(FrmFrame, "Ge�en S�re:" + (int) (hucreIslemleri.calendar.getTimeInMillis() - hucreIslemleri.OyununBaslangicZamani) / 1000 + " Saniye", "Oyun Devam Ediyor", 1);
         }
    	 if (e.getSource() == MNIBasariDurumu) 
    	 {
             String BasariSonucu = hafiza.BasariDurumu(BasariDurumunuAktiflestir, hucreIslemleri.CozulmusHucrelerinSayisi, (int) (hucreIslemleri.calendar.getTimeInMillis() - hucreIslemleri.OyununBaslangicZamani) / 1000);
             if (BasariDurumunuAktiflestir == 1) 
             {
                 JOptionPane.showMessageDialog(FrmFrame, "Ba�ar� Durumunuz: " + BasariSonucu, "Oyun Devam Ediyor", 1);
             } 
             else 
             {
                 JOptionPane.showMessageDialog(FrmFrame, BasariSonucu, "Oyun Zaten ��z�lm��", 1);
             }
         }
    	 if (e.getSource() == MNIOyunOynanisi) 
    	 {
             JOptionPane.showMessageDialog(FrmFrame, "En K�sa S�rede H�crelerin E�lerini Bulmaya �al��mal�s�n�z.A�t���n�z H�cre Say�s� Ge�en S�reye B�l�n�p Ba�ar�n�z �l��lecek.");
         }
    }
    
    public static void main(String[] args) {
		HafizaArayuz hafizaAray�z=new HafizaArayuz();	
	}
}

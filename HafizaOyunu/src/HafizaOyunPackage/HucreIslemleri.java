package HafizaOyunPackage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Calendar;

public class HucreIslemleri extends Frame implements ActionListener {
	
	Hafiza hafiza2 = new Hafiza();
	JPanel PanelHucreler=new JPanel();
	JButton OyununBitisiniKontrlEt = new JButton();
	JButton OyunuBaslat = new JButton();
	JButton[] ButtonHucre = new JButton[16];
	int[] RandomHucreResmi1 = new int[8];
	int[] RandomHucreResmi2 = new int[8];
	int[] RandomHucreResmiHepsi = new int[16];
	int HucreSayaci;
	ImageIcon[] BtnHucreResimleri = new ImageIcon[16];
	ImageIcon BtnHucreilkResim = new ImageIcon(getClass().getResource("ilkResim.png"));
	boolean FonksiyonuCagirma = true;
	int AcikHucrelerinSayisi = 0, CozulmusHucrelerinSayisi = 0;
	long OyununBaslangicZamani;
	int[] SonTiklananButon = new int[2];
	Calendar calendar;
	
	public HucreIslemleri() {
		OyunuBaslat.addActionListener(this);
		OyununBitisiniKontrlEt.addActionListener(this);
		PanelHucreler.setLayout(new GridLayout(4, 4));
		PanelHucreler.setBackground(Color.WHITE);
		for (int i = 0; i < 16; i++) {
			ButtonHucre[i] = new JButton();
			ButtonHucre[i].setBackground(Color.WHITE);
			ButtonHucre[i].setEnabled(true);
			ButtonHucre[i].setName("00");
			ButtonHucre[i].setIcon(BtnHucreilkResim);
			ButtonHucre[i].addActionListener(this);
            PanelHucreler.add(ButtonHucre[i]);
        }
		RandomHucreResmi1 = new int[8];
		RandomHucreResmi2 = new int[8];
		RandomHucreResmiHepsi = new int[16];
		Sayilar=new int[16];
		HucreResimleriniRastgeleDagit();
	}
	int [] Sayilar=new int[16];
	public void HucreResimleriniRastgeleDagit()
	{
		for (int i = 0; i < 8; i++) {
			RandomHucreResmi1[i] = (int) (Math.random() * 52) + 1;
			for (int j = 0; j < i; j++) {
				if (RandomHucreResmi1[i] == RandomHucreResmi1[j] && i != j && i != 0) {
                    --i;
				}
			}
		}	
			
		for(int m=0;m<8;m++) {
			RandomHucreResmi2[m]=RandomHucreResmi1[m];
		}
			
		int k=0;
		for(int l=0;l<16;l++)
		{
			if(l<8)
				RandomHucreResmiHepsi[l]=RandomHucreResmi1[l];
			if(l>7)
			{
				RandomHucreResmiHepsi[l]=RandomHucreResmi2[k];
				k++;
			}
		}
				
		int randomYer=0;
		Sayilar[0]=0;
		for (int i = 1; i < 16; i++) {
			randomYer= (int) (Math.random() * 16);
			for (int j = 1; j <= i; j++) {
				if (Sayilar[j] == randomYer) {
					randomYer = (int) (Math.random() * 16);
						j=0; 
						}
					}
					Sayilar[i] = randomYer;
			}
		for(int i=0;i<16;i++)
		{
			int temp=Sayilar[i];
			BtnHucreResimleri[i] = new ImageIcon(getClass().getResource(RandomHucreResmiHepsi[temp] + 1 + ".png"));
		}
        OyunuBaslat.doClick();
	}
	
	void ikiSaniyeBeklet() {
        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2000);
                    for (int i = 0; i < 16; i++) {
                        if (ButtonHucre[i].isEnabled() == true) {
                            ButtonHucre[i].setIcon(BtnHucreilkResim);
                            ButtonHucre[i].setName("00");
                            HucreSayaci = 0;
                            SonTiklananButon[0] = 21;
                            SonTiklananButon[1] = 22;
                        }
                    }
                } catch (InterruptedException ex) {
                    System.out.println("Sorun olustu..Hata:" + ex);
                }
            }
        };
        SwingUtilities.invokeLater(runnable);
    }
	
	public void AcikHucrelerinSayisi() {
		for (int i = 0; i < 16; i++) {
            if (ButtonHucre[i].isEnabled() == true) {
                AcikHucrelerinSayisi++;
            }
        }
		CozulmusHucrelerinSayisi = (16 - AcikHucrelerinSayisi) / 2;
        if (!(AcikHucrelerinSayisi == 0)) {
            AcikHucrelerinSayisi = 0;
        } else {
            OyununBitisiniKontrlEt.doClick();
        }
	}
	
	public void actionPerformed(ActionEvent e) {
		calendar = Calendar.getInstance();
		if (e.getSource() == OyununBitisiniKontrlEt) 
		{
			String BasariSonucu = hafiza2.BasariDurumu(2, CozulmusHucrelerinSayisi, (int) (calendar.getTimeInMillis() - OyununBaslangicZamani) / 1000);
            JOptionPane.showMessageDialog(PanelHucreler, "Oyun Tamamlandý.Basari Durumunuz:" + BasariSonucu, "Oyun Tamamlandý", 1);
            System.exit(0);
		}
		if (e.getSource() == OyunuBaslat) {
			OyununBaslangicZamani = calendar.getTimeInMillis();
		}else {
            FonksiyonuCagirma = true;
            if ((HucreSayaci == 0) || (HucreSayaci == 1)) {
            	for (int i = 0; i < 16; i++) {
                    {
                        if (e.getSource() == ButtonHucre[i]) {
                        	SonTiklananButon[HucreSayaci] = i;
                        	if ((HucreSayaci == 0) || (SonTiklananButon[0] != SonTiklananButon[1])) {
                        		ButtonHucre[i].setIcon(BtnHucreResimleri[i]);
                                ButtonHucre[i].setName(String.valueOf(RandomHucreResmiHepsi[Sayilar[i]]));
                                HucreSayaci++;
                                for (int j = 0; j < 16; j++) {
                                	if (e.getSource() == ButtonHucre[i] && i != j && ButtonHucre[i].getName().equals(ButtonHucre[j].getName())) {
                                		ButtonHucre[i].setDisabledIcon(BtnHucreResimleri[i]);
                                        ButtonHucre[j].setDisabledIcon(BtnHucreResimleri[j]);
                                        ButtonHucre[j].setEnabled(false);
                                        ButtonHucre[i].setEnabled(false);
                                        FonksiyonuCagirma = false;
                                	}
                                }
                        	}
                        }
                    }
            	}
            }
            if (HucreSayaci == 2 && FonksiyonuCagirma) {
                ikiSaniyeBeklet();
            }if (!FonksiyonuCagirma) {
            	HucreSayaci = 0;
                SonTiklananButon[0] = 21;
                SonTiklananButon[1] = 22;
            }
		AcikHucrelerinSayisi();
	 }
   } 
}

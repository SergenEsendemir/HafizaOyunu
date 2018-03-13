package HafizaOyunPackage;

public class Hafiza {
	 public String BasariDurumu(int Cagri, int CozulenHucreSayisi, int GecenSure) {
	        if (Cagri == 2) { 
	            int oran = GecenSure / CozulenHucreSayisi;
	            if (oran <= 8) {
	                return " Super " + GecenSure + " Saniyede Tamamladýnýz.";
	            } else if (8.5 < oran && oran <= 11.5) {
	                return " Normal  " + GecenSure + " Saniyede Tamamladýnýz.";
	            } else {
	                return " Kötü  " + GecenSure + " Saniyede Tamamladýnýz.";
	            }
	        } else if (Cagri == 1) { 
	            if (!(CozulenHucreSayisi == 0)) { 
	                double oran = GecenSure / CozulenHucreSayisi;
	                if (oran <= 8.5) {
	                    return " Super " + GecenSure + " Saniyede " + 2 * CozulenHucreSayisi + " Hücre Eþleþtirdiniz.";
	                } else if (8.5 < oran && oran <= 11.5) {
	                    return " Normal " + GecenSure + " Saniyede " + 2 * CozulenHucreSayisi + " Hücre Eþleþtirdiniz.";
	                } else {
	                    return " Kötü " + GecenSure + " Saniyede " + 2 * CozulenHucreSayisi + " Hücre Eþleþtirdiniz.";
	                }
	            } else { 
	                return "Hesaplanmadý.Çünkü Açýlan Hücre Yok";
	            }
	        } else { 
	            return "Hesaplanmadý.Çünkü Oyunu Bilgisayar Çözdü";
	        }
	    }
}

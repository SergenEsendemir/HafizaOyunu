package HafizaOyunPackage;

public class Hafiza {
	 public String BasariDurumu(int Cagri, int CozulenHucreSayisi, int GecenSure) {
	        if (Cagri == 2) { 
	            int oran = GecenSure / CozulenHucreSayisi;
	            if (oran <= 8) {
	                return " Super " + GecenSure + " Saniyede Tamamlad�n�z.";
	            } else if (8.5 < oran && oran <= 11.5) {
	                return " Normal  " + GecenSure + " Saniyede Tamamlad�n�z.";
	            } else {
	                return " K�t�  " + GecenSure + " Saniyede Tamamlad�n�z.";
	            }
	        } else if (Cagri == 1) { 
	            if (!(CozulenHucreSayisi == 0)) { 
	                double oran = GecenSure / CozulenHucreSayisi;
	                if (oran <= 8.5) {
	                    return " Super " + GecenSure + " Saniyede " + 2 * CozulenHucreSayisi + " H�cre E�le�tirdiniz.";
	                } else if (8.5 < oran && oran <= 11.5) {
	                    return " Normal " + GecenSure + " Saniyede " + 2 * CozulenHucreSayisi + " H�cre E�le�tirdiniz.";
	                } else {
	                    return " K�t� " + GecenSure + " Saniyede " + 2 * CozulenHucreSayisi + " H�cre E�le�tirdiniz.";
	                }
	            } else { 
	                return "Hesaplanmad�.��nk� A��lan H�cre Yok";
	            }
	        } else { 
	            return "Hesaplanmad�.��nk� Oyunu Bilgisayar ��zd�";
	        }
	    }
}

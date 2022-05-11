package mypckg;
import api.Service;
import ui.Yazici;

/**
 * Eyleyici sınıf aynı zamanda Dependency Inversion un uygulandığı yerdir service classını alır
 */
public class Eyleyici implements IEyleyici // Eyleyici sınıfı
{
    private final Service service;
    private final Yazici p;

    public Eyleyici(Service service, Yazici p) {
        this.service = service;
        this.p = p;
    }

    @Override
    public void sogutucuAc() {
        boolean open = service.sogutucuDurumu();
        if (open)
            p.EkranaYaz("Cihaz Acilmad�! \nCihaz zaten acik");
        else {
            service.sogutucuGuncelle(true);
            p.EkranaYaz("Cihaz Acildi�.");
        }
    }

    @Override
    public void sogutucuKapat() {
        boolean open =service.sogutucuDurumu();
        if(!open)
            p.EkranaYaz("Cihaz Kapanmadı! \nCihaz zaten kapalı");
        else
        {
            service.sogutucuGuncelle(false);
            p.EkranaYaz("Cihaz Kapandı.");
        }
    }
}

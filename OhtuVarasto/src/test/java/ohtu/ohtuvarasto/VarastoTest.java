package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        
        
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void uudellaVarastollaOikeaSaldo(){
        assertEquals(0.0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void ottaaLiikaa(){
        varasto.lisaaVarastoon(2);
        assertEquals(2, varasto.otaVarastosta(3), vertailuTarkkuus);
    }
    
    @Test
    public void laittaaLiikaa(){
        varasto.lisaaVarastoon(11);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void toStringToimii(){
        varasto.lisaaVarastoon(8);
        assertEquals(varasto.toString(),"saldo = 8.0, vielä tilaa 2.0");
    }
    
    @Test
    public void uudenVarastonAlustus(){
        Varasto kaappi = new Varasto(10, 7);
        assertEquals(kaappi.toString(),"saldo = 7.0, vielä tilaa 3.0");
    }
    
    @Test
    public void getteriSaldoToimii(){
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void getteriTilavuusToimii(){
        assertEquals(10.0, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void getteriPaljonkoMahtuuToimii(){
        varasto.lisaaVarastoon(3);
        assertEquals(7.0, varasto.paljonkoMahtuu() , vertailuTarkkuus);
    }
    
    @Test
    public void ottaaTyhjastaPalauttaaOikein(){
        assertEquals(0.0, varasto.otaVarastosta(2), vertailuTarkkuus);
    }
    
    @Test
    public void lisaaminenLiikaaRajoittuuTilavuuteen(){
        varasto.lisaaVarastoon(11);
        assertEquals(10.0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void lisaaminenKasvattaaSaldoa(){
        varasto.lisaaVarastoon(2);
        assertEquals(2.0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void ottaminenPienentaaSaldoa(){
        varasto.lisaaVarastoon(5);
        varasto.otaVarastosta(3);
        assertEquals(2.0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void eiVoiLaittaaNegatiivista(){
        varasto.lisaaVarastoon(-8);
        assertEquals(0.0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void eiVoiOttaaNegatiivista(){
        varasto.lisaaVarastoon(3);
        varasto.otaVarastosta(-2);
       assertEquals(3.0, varasto.getSaldo(), vertailuTarkkuus);
    }
    

    @Test
    public void konstr() {
        varasto = new Varasto(-1);
        varasto = new Varasto(0);
        varasto = new Varasto(1,1);
        varasto = new Varasto(1,2);
        varasto = new Varasto(-1,2);
        varasto = new Varasto(-1,-1);
        varasto.toString();
    }
}
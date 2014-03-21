
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class StatisticsTest {
     Statistics stats;
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void topScoresPalauttaaOikein() {
        int points = stats.topScorers(0).get(0).getPoints();
        assertEquals(readerStub.getPlayers().get(4).getPoints(),points);
    }
    
    @Test
    public void searchPalauttaaOikein(){
        String verrattava = stats.search("Semenko").getName();
        assertEquals(verrattava,"Semenko");
    }
    
    @Test
    public void teamLoytaaOikeat(){
        List<Player> lista = stats.team("EDM");
        assertEquals(lista.size(),3);
    }
    
    @Test
    public void searchPalauttaaNull(){
        assertEquals(stats.search("Timo"), null);
    }
    
}

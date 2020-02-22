import Players.Healer.Cleric;
import Players.MeleeFighter.Knight;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    Game game;
//    Knight knight;
//    Cleric cleric;

    @Before
    public void before(){
        game = new Game();
//        knight = new Knight("Jeff");
//        cleric = new Cleric("Steve");
    }

    @Test
    public void canAddPlayersToGame(){
        game.addPlayer("Jeff", "Knight");
        game.addPlayer("Steve", "Cleric");
        assertEquals(2, game.playerCount());
    }
}

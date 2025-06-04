import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void createGame() {
        assertNotNull(game);
    }

    private void assertillegalArgument(String guessNumber) {
        try {
            game.guess(guessNumber);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void throwIllegalArgumentExceptionInvalidInput() {
        assertillegalArgument(null);
        assertillegalArgument("12");
        assertillegalArgument("1234");
        assertillegalArgument("12s");
        assertillegalArgument("121");
    }



}
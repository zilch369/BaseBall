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

    @Test
    void throwExceptionWhenInputIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            game.guess(null);
        });
    }

    @Test
    void throwExceptionWhenInputLengthInUnmtched() {
        assertillegalArgument();
    }

    private void assertillegalArgument() {
        try {
            String guessNumber = "12";
            game.guess(guessNumber);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

}
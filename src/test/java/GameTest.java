import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void createGame() {
        Game game = new Game();
        assertNotNull(game);
    }

    @Test
    void throwExceptionWhenGameIsNull() {
        assertThrows(NullPointerException.class, () -> {
            Game game = new Game();
            game.guess(null);
        });
    }

}
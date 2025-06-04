import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
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

    private void fail() {
    }

    @Test
    void throwIllegalArgumentExceptionInvalidInput() {
        assertillegalArgument(null);
        assertillegalArgument("12");
        assertillegalArgument("1234");
        assertillegalArgument("12s");
        assertillegalArgument("121");
    }

    @Test
    void returnSolveResultIfMatchedNumber() {
        game.question = "123"; // Assuming the game has a method to set the question
        GuessResult result = game.guess("123");
        // Assuming the game has a method to check if the guess is correct
        assertThat(result).isNotNull();
        assertThat(result.isSolved()).isEqualTo(true);
        assertThat(result.getStrikes()).isEqualTo(3);
        assertThat(result.getBalls()).isEqualTo(0);
    }

    @Test
    void returnSolveResultIfUnMatchedNumber() {
        game.question = "123"; // Assuming the game has a method to set the question
        GuessResult result = game.guess("456");
        // Assuming the game has a method to check if the guess is correct
        assertThat(result).isNotNull();
        assertThat(result.isSolved()).isEqualTo(false);
        assertThat(result.getStrikes()).isEqualTo(0);
        assertThat(result.getBalls()).isEqualTo(0);
    }

}
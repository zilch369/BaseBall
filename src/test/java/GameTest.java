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
        generateQuestion("123");
        assertMacthedNumber(game.guess("123"), true, 3, 0);
    }

    private void generateQuestion(String questionNumber) {
        game.question = questionNumber; // Assuming the game has a method to set the question
    }

    @Test
    void returnSolveResultIfUnMatchedNumber() {
        generateQuestion("123");
        assertMacthedNumber(game.guess("456"), false, 0, 0);
    }

    private static void assertMacthedNumber(GuessResult result, boolean solved, int strikes, int balls) {
        assertThat(result).isNotNull();
        assertThat(result.isSolved()).isEqualTo(solved);
        assertThat(result.getStrikes()).isEqualTo(strikes);
        assertThat(result.getBalls()).isEqualTo(balls);
    }

}
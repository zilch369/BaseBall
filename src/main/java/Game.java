public class Game {

    public String question;
    private int strikes;
    private int balls;


    public GuessResult guess(String guessNumber) {
        assertIllegalArgument(guessNumber);
        if (guessNumber.equals(question)) {
            return new GuessResult(true, 3, 0);
        }
        if (is2S0B(guessNumber)) {
            return new GuessResult(false,2,0);
        }
        if (is1S2B(guessNumber)) {
            return new GuessResult(false, 1, 2);
        }
        return new GuessResult(false, 0,0);

    }

    private boolean is2S0B(String questionNumber) {
        countSB(questionNumber);
        return strikes == 2 && balls == 0;
    }

    private boolean is1S2B(String questionNumber) {
        countSB(questionNumber);
        return strikes == 1 && balls == 2;
    }

    private void countSB(String questionNumber) {
        strikes = 0;
        balls = 0;
        for (int i = 0; i < questionNumber.length(); i++) {
            char guessChar = questionNumber.charAt(i);
            if (guessChar == question.charAt(i)) {
                strikes++;
            } else if (question.indexOf(guessChar) != -1) {
                balls++;
            }
        }
    }

    private static void assertIllegalArgument(String guessNumber) {
        if (guessNumber == null) {
            throw new IllegalArgumentException();
        }

        if (guessNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (char number : guessNumber.toCharArray()) {
            if (number < '0' || number > '9') {
                throw new IllegalArgumentException();
            }
        }

        if (isDuplicateNumber(guessNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isDuplicateNumber(String guessNumber) {
        return guessNumber.charAt(0) == guessNumber.charAt(1) ||
                guessNumber.charAt(0) == guessNumber.charAt(2) ||
                guessNumber.charAt(1) == guessNumber.charAt(2);
    }
}
package _8_cleanCode.exercise.refactoring;

public class TennisGame {

    public static String getScore(String player1Name, String player2Name, int score1, int score2) {
        String score = "";
        int tempScore= 0;

        boolean equal = score1 == score2;
        if (equal) {
            score = equalRatio(score1);
        }
        else {
            if (score1 >= 4 || score2 >= 4) {
                int minusResult = score1-score2;
                if(minusResult == 1) {
                    score ="Advantage player1";
                }
                else if(minusResult == -1) {
                    score ="Advantage player2";
                }
                else if(minusResult >= 2) {
                    score = "Win for player1";
                }
                else {
                    score ="Win for player2";
                }
            }
            else {
                for (int i=1; i<3; i++)
                {
                    if (i == 1) {
                        tempScore = score1;
                    }
                    else {
                        score +="-";
                        tempScore = score2;
                    }
                    switch(tempScore) {
                        case 0:
                            score += "Love";
                            break;
                        case 1:
                            score += "Fifteen";
                            break;
                        case 2:
                            score += "Thirty";
                            break;
                        case 3:
                            score += "Forty";
                            break;
                    }
                }
            }
        }
        return score;
    }

    private static String equalRatio(int score) {
        String result;
        switch (score) {
            case 0:
                result = "Love-50All";
                break;
            case 1:
                result = "Fifteen-All";
                break;
            case 2:
                result = "Thirty-All";
                break;
            case 3:
                result = "Forty-All";
                break;
            default:
                result = "Deuce";
                break;
        }
        return result;
    }
}

package edu.elsmancs.bowlinggame.domain;

public class GameCard {
    private final String scores;
    private int totalScore = 0;
    
    GameCard(String scores) {
        this.scores = scores;
    }
    
    private String getScores() {
        return this.scores;
    }
    
    public int totalScore() { 
        for (int i = 0; i < getScores().length() ; i++) {
            char character = getScores().charAt(i);
            int value = Character.getNumericValue(character);
            totalScore = totalScore + value;
        }
        return totalScore;    
    }
}

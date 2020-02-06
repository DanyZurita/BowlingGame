package edu.elsmancs.bowlinggame.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameCardTest {
    
    @Test
    public void emptyCard() {
        GameCard game = new GameCard("");
        assertEquals(game.totalScore(), 0, 0);
        System.out.println("- Test emptyCard score:");
        System.out.println(game.getTotalScore());
    }
    
    @Test
    public void normalCard() {
        GameCard game = new GameCard("12345123451234512345");
        assertEquals(game.totalScore(), 60, 0);
        System.out.println("- Test normalCard score:");
        System.out.println(game.getTotalScore());
    }
    
    @Test
    public void all9Card() {
        GameCard game = new GameCard("9-9-9-9-9-9-9-9-9-9-");
        assertEquals(game.totalScore(), 90, 0);
        System.out.println("- Test normalCard score:");
        System.out.println(game.getTotalScore());
    }
    
}

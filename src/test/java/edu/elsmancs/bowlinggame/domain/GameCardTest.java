package edu.elsmancs.bowlinggame.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameCardTest {
    
    @Test
    public void emptyCard() {
        GameCard game = new GameCard("");
        assertEquals(game.totalScore(), 0, 0);
        System.out.println("- Test emptyCard score:");
        System.out.println(game.getTotal());
    }
    
    @Test
    public void normalCard() {
        GameCard game = new GameCard("12345123451234512345");
        assertEquals(game.totalScore(), 60, 0);
        System.out.println("- Test normalCard score:");
        System.out.println(game.getTotal());
    }
}

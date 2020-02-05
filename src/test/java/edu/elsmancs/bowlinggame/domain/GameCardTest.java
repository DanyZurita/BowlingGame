package edu.elsmancs.bowlinggame.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameCardTest {
    
    @Test
    public void NormalCard() {
        GameCard game1 = new GameCard("12345123451234512345");
        assertEquals(game1.totalScore(), 60, 0);
    }
}

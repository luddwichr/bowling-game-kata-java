package bowling;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class BowlingGameTest {
	 
	private final BowlingGame game = new BowlingGame();

	@Test
	public void initialScoreIsZero() {
		assertThat(game.score()).isZero();
	}

	@Test
	public void scoreIncreasesWithPinsHitByFirstRoll() {
		game.roll(1);
		
		assertThat(game.score()).isEqualTo(1);
	}
	
	@Test
	public void scoreIncreasesWithPinsHitBySecondRoll() {
		game.roll(1);
		game.roll(1);
		
		assertThat(game.score()).isEqualTo(2);
	}
	
	@Test
	public void pinsHitAfterSpareCountAsBonus() {
		game.roll(9);
		game.roll(1);
		
		game.roll(5);
		
		assertThat(game.score()).isEqualTo(20);
	}
}

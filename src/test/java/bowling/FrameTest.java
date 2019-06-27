package bowling;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FrameTest {
	
	private final Frame frame = new Frame();

	@Test
	public void initialScoreIsZero() {
		assertThat(frame.score()).isZero();
	}
	
	@Test
	public void firstRollIsAddedToScore() {
		frame.roll(1);
		assertThat(frame.score()).isEqualTo(1);
	}
	
	@Test
	public void secondRollIsAddedToScore() {
		frame.roll(1);
		frame.roll(1);
		assertThat(frame.score()).isEqualTo(2);
	}
	
	@Test
	public void notSpareIfNotRolledYet() {
		assertThat(frame.isSpare()).isFalse();
	}
	
	@Test
	public void notSpareIfNotRolledTwice() {
		frame.roll(10);
		assertThat(frame.isSpare()).isFalse();
	}
	
	@Test
	public void spareIfRolledLessThanTenInTwoRolls() {
		frame.roll(9);
		frame.roll(0);
		assertThat(frame.isSpare()).isFalse();
	}
	
	@Test
	public void spareIfRolledTenInTwoRolls() {
		frame.roll(1);
		frame.roll(9);
		assertThat(frame.isSpare()).isTrue();
	}
	
	@Test
	public void scoreIncreasedByBonus() {
		frame.addBonus(5);
		assertThat(frame.score()).isEqualTo(5);
	}
	
	@Test
	public void notCompleteIfNotRolledYet() {
		assertThat(frame.isNotComplete()).isTrue();
	}
	
	@Test
	public void notCompleteIfRolledLessThanTenInFirstRoll() {
		frame.roll(9);
		assertThat(frame.isNotComplete()).isTrue();
	}
	
	@Test
	public void completeIfRolledTenInFirstRoll() {
		frame.roll(10);
		assertThat(frame.isNotComplete()).isFalse();
	}
	
	@Test
	public void completeIfRolledTwoTimes() {
		frame.roll(1);
		frame.roll(1);
		assertThat(frame.isNotComplete()).isFalse();
	}
}

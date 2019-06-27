package bowling;

import java.util.Optional;

public class Frame {

	private Optional<Integer> firstRoll = Optional.empty();
	private Optional<Integer> secondRoll = Optional.empty();
	private int bonus;

	public Frame() {
	}

	public int score() {
		return firstRoll.orElse(0) + secondRoll.orElse(0) + bonus;
	}

	public void roll(int pinsHit) {
		if (firstRoll.isPresent()) {
			secondRoll = Optional.of(pinsHit);

		} else {
			firstRoll = Optional.of(pinsHit);
		}
	}

	public boolean isSpare() {
		if (firstRoll.isPresent() && secondRoll.isPresent()) {
			return firstRoll.get() + secondRoll.get() == 10;
		}
		return false;
	}

	public void addBonus(int bonus) {
		this.bonus += bonus;
	}

	public boolean isNotComplete() {
		return firstRoll.orElse(0) < 10 && !secondRoll.isPresent();
	}

}

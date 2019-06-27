package bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BowlingGame {

	private List<Frame> frames = new ArrayList<>();

	public int score() {
		int score = 0;

		for (Frame frame : frames) {
			score += frame.score();
		}

		return score;
	}

	public void roll(int pinsHit) {
		Optional<Frame> lastFrame = lastFrame();
		if (lastFrame.isPresent()) {
			Frame frame = lastFrame.get();
			if (frame.isSpare()) {
				frame.addBonus(pinsHit);
			} else if (frame.isNotComplete()) {
				frame.roll(pinsHit);
			}
		} else {
			Frame frame = new Frame();
			frame.roll(pinsHit);
			frames.add(frame);
		}

	}

	private Optional<Frame> lastFrame() {
		if (frames.isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(frames.get(frames.size() - 1));
	}

}

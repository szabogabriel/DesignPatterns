package patterns.structural.flyweight.stringinterning;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlayingWithStrings3_OneMillionObjectsWithGenerated1KBLongString extends PlayingWithStringsAbstract {
	
	private static final int LOG_EVERY_XTH_STEP = 10000;
	
	public void run() {
		logFreeMem(0, LOG_EVERY_XTH_STEP);
		List<PlayingWithStringsDto> items = new ArrayList<>();
		for (int i = 1; i <= 1000000; i++) {
			// Generate (always the same) 1024 characters long text
			PlayingWithStringsDto item = new PlayingWithStringsDto(getVeryLongString());
			items.add(item);
			logFreeMem(i, LOG_EVERY_XTH_STEP);
		}
		logFreeMem(-1, LOG_EVERY_XTH_STEP);
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		PlayingWithStrings3_OneMillionObjectsWithGenerated1KBLongString example = new PlayingWithStrings3_OneMillionObjectsWithGenerated1KBLongString();
		example.run();
	}
}

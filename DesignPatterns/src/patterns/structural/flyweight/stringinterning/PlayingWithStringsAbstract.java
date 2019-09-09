package patterns.structural.flyweight.stringinterning;

import java.util.Random;

public abstract class PlayingWithStringsAbstract {
	
	/**
	 * Runs the Garbage Collector 10-times and each time waits 1 second.
	 */
	protected void runGc() {
		for (int i = 0; i < 10; i++) {
			System.gc();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Informs about the free/occupied memory.
	 * 
	 * @param step - 0: beginning; X: x-th step; -1: end
	 */
	protected void logFreeMem(int step) {
		logFreeMem(step, 0);
	}

	/**
	 * Informs about the free/occupied memory.
	 * 
	 * @param step - 0: beginning; X: x-th step; -1: end
	 * @param logEveryXthStep - if other than 0, only 0, -1 and every logEveryXthStep-th step would be logged
	 */
	protected void logFreeMem(int step, int logEveryXthStep) {
		
		if (step != 0 && step != -1 && logEveryXthStep != 0 && step % logEveryXthStep != 0) {
			return;
		}
		
		if (step == -1) {
			System.out.println("Call gc and wait 10 seconds!");
			runGc();
		}
		
		long freeMem = Runtime.getRuntime().freeMemory();
		long totalMem = Runtime.getRuntime().totalMemory();
		long occMem = totalMem - freeMem;
		long occMemMb = occMem / 1024 / 1024;
		
		System.out.println(
			String.format("#%d: free = %d, total = %d, occupied = %d, occupied MB = %d", step, freeMem,	totalMem, occMem, occMemMb));
	}

	/**
	 * This methods returns always the same 1024 long text: "01234567890123456789..01234567890123".
	 * However, the method is written in a very obscure way and the compiler is not able to predict it.
	 * 
	 * @return always the same 1024 long text: "01234567890123456789..01234567890123"
	 */
	protected String getVeryLongString() {
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 1024; i++) {
			sb.append(String.valueOf(i%10));
			if (r.nextInt() == 23) {
				sb.append("x");
			}
		}
		return sb.toString().replace("x", "");
	}
}

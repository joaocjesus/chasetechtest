package test.java.utils;

public class Times {
    public static final long HALF_SECOND = 500;
    public static final long ONE_SECOND = 1000;
    public static final long FIVE_SECONDS = 5000;
    public static final long TEN_SECONDS = 10000;
    public static final long THIRTY_SECONDS = 30000;
    
	public static final long DEFAULT_TIMEOUT = FIVE_SECONDS;
	public static final long LONG_TIMEOUT = TEN_SECONDS;

    public static void waitFor(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}

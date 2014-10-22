package waittest;

class WaitTest {

	public static void main(String[] args) {
		ThreadThingy t = new ThreadThingy();
		t.start();

		synchronized(t) {
			try {
				System.out.println("Waiting for b to complete...");
				t.wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Total is: " + t.total);
		}
	}
}

class ThreadThingy extends Thread {

	public int total;

	public void run() {
		synchronized(this) {
			for(int i = 0; i < 2000000000; i++) {
				total += i;
			}
			notifyAll();
		}
	}
}
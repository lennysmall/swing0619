package tread;

public class SampleThread2 {
	public int getSum(int n1, int n2){
		int sum=0;
		for(int i=n1; i<=n2; i++){
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		int cores = Runtime.getRuntime().availableProcessors();
		System.out.println(cores);
		long startTime =  System.currentTimeMillis();
		SampleThread2 sample = new SampleThread2();
		for(int i=0; i<=1000; i++){
			sample.getSum(1, 2_000_000);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("걸린시간 : "+(endTime - startTime));
		
		MyThread th1 = sample.new MyThread();
		MyThread th2 = sample.new MyThread();
		
		startTime =  System.currentTimeMillis();
		th1.start();
		th2.start();
		
		try {
			//조인이 빠지면 메인쓰레드로 그냥실행. 하나만됨
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		endTime = System.currentTimeMillis();
		System.out.println("걸린시간 : "+(endTime - startTime));
		
	}
	class MyThread extends Thread{
		@Override
		public void run() {
			for(int i=0; i<=1000; i++){
				getSum(1, 2_000_000);
			}
			System.out.println("end of Tread");
		}
		public int getSum(int n1, int n2){
			int sum=0;
			for(int i=n1; i<=n2; i++){
				sum += i;
			}
			return sum;
		}
	}
	
	
}

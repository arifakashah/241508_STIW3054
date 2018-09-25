public class MyThread extends Thread {
	
	private Thread t;
	private String threadName;
	   
	
	MyThread(String name) {
	      threadName = name;
	      System.out.println("Creating " +  threadName );
	   }

    public void run() {
        System.out.println("running...");
        System.out.println("Running " +  threadName);
        try {
           for(int i = 1; i > 0; i--) {
              System.out.println("Thread: " + threadName + ", " + i);
              // Let the thread sleep for a while.
              Thread.sleep(50);
           }
        } catch (InterruptedException e) {
           System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }
    
    public void start () {
        System.out.println("Starting " +  threadName);
        if (t == null) {
           t = new Thread (this, threadName);
           t.start ();
        }
    }

    public static void main(String args[]) {
    	MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");
        System.out.println("Name of t1:" + t1.getName());
        System.out.println("Name of t2:" + t2.getName());
        System.out.println("id of t1:" + t1.getId());
        System.out.println("id of t2:" + t2.getId());

        t1.start();
        t2.start();

        t1.setName("STIW3054");
        t2.setName("REAL-TIME PROGRAMMING");
        System.out.println("After changing name of t1:" + t1.getName());
        System.out.println("After changing name of t2:" + t2.getName());
    }
}
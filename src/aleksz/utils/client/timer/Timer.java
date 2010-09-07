package aleksz.utils.client.timer;


public interface Timer {

  void schedule(Runnable task, long delayMillis);
}
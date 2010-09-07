package aleksz.utils.client.timer;


public class TimerWidget extends com.google.gwt.user.client.Timer
    implements Timer {

  private Runnable task;

  @Override
  public void run() {
    task.run();
  }

  @Override
  public void schedule(Runnable task, long delayMillis) {
    this.task = task;
    schedule((int) delayMillis);
  }
}
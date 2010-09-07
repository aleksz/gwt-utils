package aleksz.utils.client.timer;

import java.util.ArrayList;
import java.util.List;



public class MockTimer implements Timer {

  private List<Pair> scheduledTasks = new ArrayList<Pair>();

  @Override
  public void schedule(Runnable task, long delayMillis) {
    scheduledTasks.add(new Pair(task, delayMillis));
  }

  public void runAllTasks() {
    for (int i = 0; i < scheduledTasks.size(); i++) {
      runTask(i);
    }
  }

  public void runTask(int index) {
    scheduledTasks.get(index).task.run();
  }

  public Long getDelayMillis(int index) {
    return scheduledTasks.get(index).delayMillis;
  }

  public int getScheduledTasksLength() {
    return scheduledTasks.size();
  }

  private class Pair {
    Runnable task;
    long delayMillis;

    Pair(Runnable task, long delayMillis) {
      this.task = task;
      this.delayMillis = delayMillis;
    }
  }
}
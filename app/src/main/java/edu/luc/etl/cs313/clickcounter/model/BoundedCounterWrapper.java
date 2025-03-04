package edu.luc.etl.cs313.clickcounter.model;

import edu.luc.etl.cs313.clickcounter.android.ClickCounterModel;
import edu.luc.etl.cs313.clickcounter.cli.BoundedCounter;

/** Adapter for using the CLI bounded counter as the Android click counter model. */
public class BoundedCounterWrapper implements ClickCounterModel {

  private static final long serialVersionUID = -5346273748286172976L;

  private final BoundedCounter counter;

  public BoundedCounterWrapper(final BoundedCounter counter) {
    this.counter = counter;
  }

  @Override
  public void increment() {
    counter.increment();
  }

  @Override
  public void decrement() {
    counter.decrement();
  }

  @Override
  public void reset() {
    while (!counter.isEmpty()) {
      counter.decrement();
    }
  }

  @Override
  public int get() {
    return counter.get();
  }

  @Override
  public boolean isFull() {
    return counter.isFull();
  }

  @Override
  public boolean isEmpty() {
    return counter.isEmpty();
  }
}

package edu.luc.etl.cs313.misc.boundedcounter.cli;

/** A bounded counter abstraction. */
// begin-interface-BoundedCounter
public interface BoundedCounter {

  /**
   * Increments the counter.
   *
   * @pre the counter is not full
   * @post the counter is not empty
   * @throws AssertionError if the precondition is violated.
   */
  void increment();

  /**
   * Decrements the counter.
   *
   * @pre the counter is not empty
   * @post the counter is not full
   * @throws AssertionError if the precondition is violated.
   */
  void decrement();

  /**
   * Returns the current counter value.
   *
   * @return the current counter
   */
  int get();

  /**
   * Indicates whether the counter is full, i.e., at its maximum value.
   *
   * @return whether the counter is full
   */
  boolean isFull();

  /**
   * Indicates whether the counter is full, i.e., at its minimum value.
   *
   * @return whether the counter is empty
   */
  boolean isEmpty();
}
// end-interface-BoundedCounter

package edu.luc.etl.cs313.clickcounter.model;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import org.junit.Test;

public class Java8Test {

  @Test
  public void testLambda() {
    final Comparator<Integer> c = (x, y) -> x - y;
    assertEquals(0, c.compare(3, 3));
  }
}

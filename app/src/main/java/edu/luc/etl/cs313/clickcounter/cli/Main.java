package edu.luc.etl.cs313.clickcounter.cli;

import edu.luc.etl.cs313.clickcounter.model.SimpleBoundedCounter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  private static final int DEFAULT_MIN = 0;

  private static final int DEFAULT_MAX = 5;

  /**
   * Command-line interface to bounded counter.
   *
   * @param args lower and upper bounds for counter
   */
  public static void main(final String[] args) throws Throwable {
    var min = DEFAULT_MIN;
    var max = DEFAULT_MAX;
    switch (args.length) {
      case 0:
        break;
      case 2:
        min = Integer.parseInt(args[0]);
        max = Integer.parseInt(args[1]);
        break;
      default:
        System.out.println("usage: Main [min max]");
        System.exit(1);
    }
    new Cli(min, max).run();
  }

  private static class Cli {

    private final int min, max;

    private final BoundedCounter model;

    public Cli(final int min, final int max) {
      this.min = min;
      this.max = max;
      model = new SimpleBoundedCounter(min, max);
    }

    public void run() throws Throwable {
      final var in = new BufferedReader(new InputStreamReader(System.in));
      String line;

      prompt();
      while ((line = in.readLine()) != null) {
        // remove unnecessary spaces
        line = line.trim();

        if (!model.isFull() && "+".equals(line)) {
          model.increment();
        } else if (!model.isEmpty() && "-".equals(line)) {
          model.decrement();
        } else if ("quit".startsWith(line)) {
          return;
        }

        prompt();
      }
    }

    private void prompt() {
      final var sb = new StringBuilder();
      sb.append("value=");
      sb.append(model.get());
      sb.append(" [");
      sb.append(model.isEmpty() ? "" : "not ");
      sb.append("empty, ");
      sb.append(model.isFull() ? "" : "not ");
      sb.append("full");
      sb.append(", min=");
      sb.append(min);
      sb.append(", max=");
      sb.append(max);
      sb.append("], command: ");
      if (!model.isFull()) {
        sb.append("+ | ");
      }
      if (!model.isEmpty()) {
        sb.append("- | ");
      }
      sb.append("q[uit] > ");
      System.out.print(sb.toString());
    }
  }
}

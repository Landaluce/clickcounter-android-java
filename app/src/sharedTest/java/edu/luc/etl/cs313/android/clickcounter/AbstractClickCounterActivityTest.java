package edu.luc.etl.cs313.android.clickcounter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.content.pm.ActivityInfo;
import android.support.test.annotation.UiThreadTest;
import android.widget.Button;
import android.widget.TextView;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Abstract GUI-level test superclass for several essential click-counter scenarios.
 *
 * @author laufer
 */
@Ignore
public abstract class AbstractClickCounterActivityTest {

  /** Verifies that the activity under test can be launched. */
  @Test
  @UiThreadTest
  public void testActivityTestCaseSetUpProperly() {
    assertNotNull("activity should be launched successfully", getActivity());
  }

  // begin-method-testActivityScenarioIncReset
  @Test
  @UiThreadTest
  public void testActivityScenarioIncReset() {
    assertTrue(getResetButton().performClick());
    assertEquals(0, getDisplayedValue());
    assertTrue(getIncButton().isEnabled());
    assertFalse(getDecButton().isEnabled());
    assertTrue(getResetButton().isEnabled());
    assertTrue(getIncButton().performClick());
    assertEquals(1, getDisplayedValue());
    assertTrue(getIncButton().isEnabled());
    assertTrue(getDecButton().isEnabled());
    assertTrue(getResetButton().isEnabled());
    assertTrue(getResetButton().performClick());
    assertEquals(0, getDisplayedValue());
    assertTrue(getIncButton().isEnabled());
    assertFalse(getDecButton().isEnabled());
    assertTrue(getResetButton().isEnabled());
    assertTrue(getResetButton().performClick());
  }
  // end-method-testActivityScenarioIncReset

  @Test
  @UiThreadTest
  public void testActivityScenarioIncUntilFull() {
    assertTrue(getResetButton().performClick());
    assertEquals(0, getDisplayedValue());
    assertTrue(getIncButton().isEnabled());
    assertFalse(getDecButton().isEnabled());
    assertTrue(getResetButton().isEnabled());
    while (getIncButton().isEnabled()) {
      final var v = getDisplayedValue();
      assertTrue(getIncButton().performClick());
      assertEquals(v + 1, getDisplayedValue());
    }
    assertFalse(getIncButton().isEnabled());
    assertTrue(getDecButton().isEnabled());
    assertTrue(getResetButton().isEnabled());
    assertTrue(getResetButton().performClick());
  }

  // begin-method-testActivityScenarioRotation
  @Test
  @UiThreadTest
  public void testActivityScenarioRotation() {
    assertTrue(getResetButton().performClick());
    assertEquals(0, getDisplayedValue());
    assertTrue(getIncButton().performClick());
    assertTrue(getIncButton().performClick());
    assertTrue(getIncButton().performClick());
    assertEquals(3, getDisplayedValue());
    getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    assertEquals(3, getDisplayedValue());
    getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    assertEquals(3, getDisplayedValue());
    assertTrue(getResetButton().performClick());
  }
  // end-method-testActivityScenarioRotation

  // auxiliary methods for easy access to UI widgets

  protected abstract ClickCounterActivity getActivity();

  protected int getDisplayedValue() {
    final TextView t = getActivity().findViewById(R.id.textview_value);
    return Integer.parseInt(t.getText().toString().trim());
  }

  protected Button getIncButton() {
    return getActivity().findViewById(R.id.button_increment);
  }

  protected Button getDecButton() {
    return getActivity().findViewById(R.id.button_decrement);
  }

  protected Button getResetButton() {
    return getActivity().findViewById(R.id.button_reset);
  }
}

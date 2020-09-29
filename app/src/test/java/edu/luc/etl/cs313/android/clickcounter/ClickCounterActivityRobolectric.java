package edu.luc.etl.cs313.android.clickcounter;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Concrete Robolectric test subclass.
 *
 * @author laufer
 * @see http://pivotal.github.com/robolectric
 */
@RunWith(RobolectricTestRunner.class)
@Config(sdk = 23)
public class ClickCounterActivityRobolectric extends AbstractClickCounterActivityTest {

  private static String TAG = "clickcounter-android-activity-robolectric";

  private ClickCounterActivity activity;

  @Before
  public void setUp() {
    activity = Robolectric.buildActivity(ClickCounterActivity.class).create().start().get();
  }

  @Override
  protected ClickCounterActivity getActivity() {
    return activity;
  }
}

package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.util.HashMap;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Filter.Result;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LifeCycle;
import org.apache.logging.log4j.core.LifeCycle.State;
import org.apache.logging.log4j.core.appender.DefaultErrorHandler;
import org.apache.logging.log4j.core.filter.ThreadContextMapFilter;
import org.apache.logging.log4j.core.layout.GelfLayout;
import org.apache.logging.log4j.core.layout.GelfLayout.CompressionType;
import org.apache.logging.log4j.core.util.KeyValuePair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DebugLogAppenderDiffblueTest {
  /**
   * Test {@link DebugLogAppender#DebugLogAppender(String, Filter, Layout, boolean)}.
   * <p>
   * Method under test: {@link DebugLogAppender#DebugLogAppender(String, Filter, Layout, boolean)}
   */
  @Test
  @DisplayName("Test new DebugLogAppender(String, Filter, Layout, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DebugLogAppender.<init>(String, Filter, Layout, boolean)"})
  void testNewDebugLogAppender() {
    // Arrange
    ThreadContextMapFilter filter = new ThreadContextMapFilter(new HashMap<>(), true, Result.ACCEPT, Result.ACCEPT);

    KeyValuePair buildResult = KeyValuePair.newBuilder().setKey("A Key").setValue("42").build();
    GelfLayout layout = new GelfLayout("localhost", new KeyValuePair[]{buildResult}, CompressionType.GZIP, 1, true);

    // Act
    DebugLogAppender actualDebugLogAppender = new DebugLogAppender("Name", filter, layout, true);

    // Assert
    assertTrue(actualDebugLogAppender.getHandler() instanceof DefaultErrorHandler);
    Filter filter2 = actualDebugLogAppender.getFilter();
    assertTrue(filter2 instanceof ThreadContextMapFilter);
    Layout<? extends Serializable> layout2 = actualDebugLogAppender.getLayout();
    assertTrue(layout2 instanceof GelfLayout);
    assertEquals("Name", actualDebugLogAppender.getName());
    assertEquals("Name", actualDebugLogAppender.toString());
    assertEquals(0, actualDebugLogAppender.getPropertyArray().length);
    assertEquals(State.INITIALIZED, actualDebugLogAppender.getState());
    assertFalse(actualDebugLogAppender.isStarted());
    assertFalse(actualDebugLogAppender.isStarting());
    assertFalse(actualDebugLogAppender.isStopped());
    assertFalse(actualDebugLogAppender.isStopping());
    assertTrue(actualDebugLogAppender.isInitialized());
    assertTrue(actualDebugLogAppender.ignoreExceptions());
    assertTrue(actualDebugLogAppender.hasFilter());
    assertSame(filter, filter2);
    assertSame(layout, layout2);
  }

  /**
   * Test {@link DebugLogAppender#createAppender(String, Filter, Layout, boolean)}.
   * <p>
   * Method under test: {@link DebugLogAppender#createAppender(String, Filter, Layout, boolean)}
   */
  @Test
  @DisplayName("Test createAppender(String, Filter, Layout, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DebugLogAppender DebugLogAppender.createAppender(String, Filter, Layout, boolean)"})
  void testCreateAppender() {
    // Arrange
    ThreadContextMapFilter filter = new ThreadContextMapFilter(new HashMap<>(), true, Result.ACCEPT, Result.ACCEPT);

    KeyValuePair buildResult = KeyValuePair.newBuilder().setKey("A Key").setValue("42").build();
    GelfLayout layout = new GelfLayout("localhost", new KeyValuePair[]{buildResult}, CompressionType.GZIP, 1, true);

    // Act
    DebugLogAppender actualCreateAppenderResult = DebugLogAppender.createAppender("Name", filter, layout, true);

    // Assert
    assertTrue(actualCreateAppenderResult.getHandler() instanceof DefaultErrorHandler);
    Filter filter2 = actualCreateAppenderResult.getFilter();
    assertTrue(filter2 instanceof ThreadContextMapFilter);
    Layout<? extends Serializable> layout2 = actualCreateAppenderResult.getLayout();
    assertTrue(layout2 instanceof GelfLayout);
    assertEquals("Name", actualCreateAppenderResult.getName());
    assertEquals("Name", actualCreateAppenderResult.toString());
    assertEquals(0, actualCreateAppenderResult.getPropertyArray().length);
    assertEquals(State.INITIALIZED, actualCreateAppenderResult.getState());
    assertFalse(actualCreateAppenderResult.isStarted());
    assertFalse(actualCreateAppenderResult.isStarting());
    assertFalse(actualCreateAppenderResult.isStopped());
    assertFalse(actualCreateAppenderResult.isStopping());
    assertTrue(actualCreateAppenderResult.isInitialized());
    assertTrue(actualCreateAppenderResult.ignoreExceptions());
    assertTrue(actualCreateAppenderResult.hasFilter());
    assertSame(filter, filter2);
    assertSame(layout, layout2);
  }
}

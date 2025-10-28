package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import org.apache.logging.log4j.core.ErrorHandler;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LifeCycle;
import org.apache.logging.log4j.core.appender.DefaultErrorHandler;
import org.apache.logging.log4j.core.filter.ThreadContextMapFilter;
import org.apache.logging.log4j.core.layout.GelfLayout;
import org.apache.logging.log4j.core.util.KeyValuePair;
import org.junit.jupiter.api.Test;

class DebugLogAppenderDiffblueTest {
  /**
   * Method under test:
   * {@link DebugLogAppender#createAppender(String, Filter, Layout, boolean)}
   */
  @Test
  void testCreateAppender() {
    // Arrange
    ThreadContextMapFilter filter = new ThreadContextMapFilter(new HashMap<>(), true, Filter.Result.ACCEPT,
        Filter.Result.ACCEPT);

    GelfLayout layout = new GelfLayout("localhost", new KeyValuePair[]{new KeyValuePair("Key", "42")},
        GelfLayout.CompressionType.GZIP, 1, true);

    // Act
    DebugLogAppender actualCreateAppenderResult = DebugLogAppender.createAppender("Name", filter, layout, true);

    // Assert
    ErrorHandler handler = actualCreateAppenderResult.getHandler();
    assertTrue(handler instanceof DefaultErrorHandler);
    assertEquals("Name", actualCreateAppenderResult.getName());
    assertEquals("Name", actualCreateAppenderResult.toString());
    assertEquals(0, actualCreateAppenderResult.getPropertyArray().length);
    assertEquals(LifeCycle.State.INITIALIZED, actualCreateAppenderResult.getState());
    assertFalse(actualCreateAppenderResult.isStarted());
    assertFalse(actualCreateAppenderResult.isStarting());
    assertFalse(actualCreateAppenderResult.isStopped());
    assertFalse(actualCreateAppenderResult.isStopping());
    assertTrue(actualCreateAppenderResult.isInitialized());
    assertTrue(actualCreateAppenderResult.ignoreExceptions());
    assertTrue(actualCreateAppenderResult.hasFilter());
    assertSame(filter, actualCreateAppenderResult.getFilter());
    assertSame(layout, actualCreateAppenderResult.getLayout());
    assertSame(actualCreateAppenderResult, ((DefaultErrorHandler) handler).getAppender());
  }

  /**
   * Method under test:
   * {@link DebugLogAppender#createAppender(String, Filter, Layout, boolean)}
   */
  @Test
  void testCreateAppender2() {
    // Arrange
    HashMap<String, List<String>> pairs = new HashMap<>();
    pairs.computeIfPresent("appender", mock(BiFunction.class));
    ThreadContextMapFilter filter = new ThreadContextMapFilter(pairs, true, Filter.Result.ACCEPT, Filter.Result.ACCEPT);

    GelfLayout layout = new GelfLayout("localhost", new KeyValuePair[]{new KeyValuePair("Key", "42")},
        GelfLayout.CompressionType.GZIP, 1, true);

    // Act
    DebugLogAppender actualCreateAppenderResult = DebugLogAppender.createAppender("Name", filter, layout, true);

    // Assert
    ErrorHandler handler = actualCreateAppenderResult.getHandler();
    assertTrue(handler instanceof DefaultErrorHandler);
    assertEquals("Name", actualCreateAppenderResult.getName());
    assertEquals("Name", actualCreateAppenderResult.toString());
    assertEquals(0, actualCreateAppenderResult.getPropertyArray().length);
    assertEquals(LifeCycle.State.INITIALIZED, actualCreateAppenderResult.getState());
    assertFalse(actualCreateAppenderResult.isStarted());
    assertFalse(actualCreateAppenderResult.isStarting());
    assertFalse(actualCreateAppenderResult.isStopped());
    assertFalse(actualCreateAppenderResult.isStopping());
    assertTrue(actualCreateAppenderResult.isInitialized());
    assertTrue(actualCreateAppenderResult.ignoreExceptions());
    assertTrue(actualCreateAppenderResult.hasFilter());
    assertSame(filter, actualCreateAppenderResult.getFilter());
    assertSame(layout, actualCreateAppenderResult.getLayout());
    assertSame(actualCreateAppenderResult, ((DefaultErrorHandler) handler).getAppender());
  }

  /**
   * Method under test:
   * {@link DebugLogAppender#DebugLogAppender(String, Filter, Layout, boolean)}
   */
  @Test
  void testNewDebugLogAppender() {
    // Arrange
    ThreadContextMapFilter filter = new ThreadContextMapFilter(new HashMap<>(), true, Filter.Result.ACCEPT,
        Filter.Result.ACCEPT);

    GelfLayout layout = new GelfLayout("localhost", new KeyValuePair[]{new KeyValuePair("Key", "42")},
        GelfLayout.CompressionType.GZIP, 1, true);

    // Act
    DebugLogAppender actualDebugLogAppender = new DebugLogAppender("Name", filter, layout, true);

    // Assert
    ErrorHandler handler = actualDebugLogAppender.getHandler();
    assertTrue(handler instanceof DefaultErrorHandler);
    assertEquals("Name", actualDebugLogAppender.getName());
    assertEquals("Name", actualDebugLogAppender.toString());
    assertEquals(0, actualDebugLogAppender.getPropertyArray().length);
    assertEquals(LifeCycle.State.INITIALIZED, actualDebugLogAppender.getState());
    assertFalse(actualDebugLogAppender.isStarted());
    assertFalse(actualDebugLogAppender.isStarting());
    assertFalse(actualDebugLogAppender.isStopped());
    assertFalse(actualDebugLogAppender.isStopping());
    assertTrue(actualDebugLogAppender.isInitialized());
    assertTrue(actualDebugLogAppender.ignoreExceptions());
    assertTrue(actualDebugLogAppender.hasFilter());
    assertSame(filter, actualDebugLogAppender.getFilter());
    assertSame(layout, actualDebugLogAppender.getLayout());
    assertSame(actualDebugLogAppender, ((DefaultErrorHandler) handler).getAppender());
  }

  /**
   * Method under test:
   * {@link DebugLogAppender#DebugLogAppender(String, Filter, Layout, boolean)}
   */
  @Test
  void testNewDebugLogAppender2() {
    // Arrange
    HashMap<String, List<String>> pairs = new HashMap<>();
    pairs.computeIfPresent("appender", mock(BiFunction.class));
    ThreadContextMapFilter filter = new ThreadContextMapFilter(pairs, true, Filter.Result.ACCEPT, Filter.Result.ACCEPT);

    GelfLayout layout = new GelfLayout("localhost", new KeyValuePair[]{new KeyValuePair("Key", "42")},
        GelfLayout.CompressionType.GZIP, 1, true);

    // Act
    DebugLogAppender actualDebugLogAppender = new DebugLogAppender("Name", filter, layout, true);

    // Assert
    ErrorHandler handler = actualDebugLogAppender.getHandler();
    assertTrue(handler instanceof DefaultErrorHandler);
    assertEquals("Name", actualDebugLogAppender.getName());
    assertEquals("Name", actualDebugLogAppender.toString());
    assertEquals(0, actualDebugLogAppender.getPropertyArray().length);
    assertEquals(LifeCycle.State.INITIALIZED, actualDebugLogAppender.getState());
    assertFalse(actualDebugLogAppender.isStarted());
    assertFalse(actualDebugLogAppender.isStarting());
    assertFalse(actualDebugLogAppender.isStopped());
    assertFalse(actualDebugLogAppender.isStopping());
    assertTrue(actualDebugLogAppender.isInitialized());
    assertTrue(actualDebugLogAppender.ignoreExceptions());
    assertTrue(actualDebugLogAppender.hasFilter());
    assertSame(filter, actualDebugLogAppender.getFilter());
    assertSame(layout, actualDebugLogAppender.getLayout());
    assertSame(actualDebugLogAppender, ((DefaultErrorHandler) handler).getAppender());
  }
}

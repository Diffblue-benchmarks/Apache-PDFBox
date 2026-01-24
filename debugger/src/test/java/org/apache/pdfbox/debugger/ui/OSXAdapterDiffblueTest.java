package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.Method;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OSXAdapterDiffblueTest {
  /**
   * Test {@link OSXAdapter#OSXAdapter(String, Object, Method)}.
   *
   * <p>Method under test: {@link OSXAdapter#OSXAdapter(String, Object, Method)}
   */
  @Test
  @DisplayName("Test new OSXAdapter(String, Object, Method)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OSXAdapter.<init>(String, Object, Method)"})
  void testNewOSXAdapter() {
    // Arrange and Act
    OSXAdapter actualOsxAdapter = new OSXAdapter("Proxy Signature", "Target", null);

    // Assert
    assertEquals("Proxy Signature", actualOsxAdapter.proxySignature);
    assertEquals("Target", actualOsxAdapter.targetObject);
    assertNull(actualOsxAdapter.targetMethod);
  }

  /**
   * Test {@link OSXAdapter#invoke(Object, Method, Object[])}.
   *
   * <p>Method under test: {@link OSXAdapter#invoke(Object, Method, Object[])}
   */
  @Test
  @DisplayName("Test invoke(Object, Method, Object[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object OSXAdapter.invoke(Object, Method, Object[])"})
  void testInvoke() throws Throwable {
    // Arrange
    OSXAdapter osxAdapter = new OSXAdapter("Proxy Signature", "Target", null);

    // Act and Assert
    assertNull(osxAdapter.invoke("Proxy", null, new Object[] {"Args"}));
  }

  /**
   * Test {@link OSXAdapter#isCorrectMethod(Method, Object[])}.
   *
   * <p>Method under test: {@link OSXAdapter#isCorrectMethod(Method, Object[])}
   */
  @Test
  @DisplayName("Test isCorrectMethod(Method, Object[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OSXAdapter.isCorrectMethod(Method, Object[])"})
  void testIsCorrectMethod() {
    // Arrange
    OSXAdapter osxAdapter = new OSXAdapter("Proxy Signature", "Target", null);

    // Act and Assert
    assertFalse(osxAdapter.isCorrectMethod(null, new Object[] {"Args"}));
  }

  /**
   * Test {@link OSXAdapter#setApplicationEventHandled(Object, boolean)}.
   *
   * <ul>
   *   <li>When {@code Event}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OSXAdapter#setApplicationEventHandled(Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test setApplicationEventHandled(Object, boolean); when 'Event'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OSXAdapter.setApplicationEventHandled(Object, boolean)"})
  void testSetApplicationEventHandled_whenEvent_thenThrowRuntimeException() {
    // Arrange
    OSXAdapter osxAdapter = new OSXAdapter("Proxy Signature", "Target", null);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> osxAdapter.setApplicationEventHandled("Event", true));
  }

  /**
   * Test {@link OSXAdapter#setApplicationEventHandled(Object, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link OSXAdapter#setApplicationEventHandled(Object, boolean)}
   */
  @Test
  @DisplayName("Test setApplicationEventHandled(Object, boolean); when 'null'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OSXAdapter.setApplicationEventHandled(Object, boolean)"})
  void testSetApplicationEventHandled_whenNull_thenDoesNotThrow() {
    // Arrange
    OSXAdapter osxAdapter = new OSXAdapter("Proxy Signature", "Target", null);

    // Act and Assert
    assertDoesNotThrow(() -> osxAdapter.setApplicationEventHandled(null, true));
  }
}

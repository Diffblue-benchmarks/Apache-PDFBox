package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.Method;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OSXAdapterDiffblueTest {
  /**
   * Test {@link OSXAdapter#OSXAdapter(String, Object, Method)}.
   * <p>
   * Method under test: {@link OSXAdapter#OSXAdapter(String, Object, Method)}
   */
  @Test
  @DisplayName("Test new OSXAdapter(String, Object, Method)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link OSXAdapter#invoke(Object, Method, Object[])}
   */
  @Test
  @DisplayName("Test invoke(Object, Method, Object[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object OSXAdapter.invoke(Object, Method, Object[])"})
  void testInvoke() throws Throwable {
    // Arrange, Act and Assert
    assertNull((new OSXAdapter("Proxy Signature", "Target", null)).invoke("Proxy", null, new Object[]{"Args"}));
  }

  /**
   * Test {@link OSXAdapter#isCorrectMethod(Method, Object[])}.
   * <p>
   * Method under test: {@link OSXAdapter#isCorrectMethod(Method, Object[])}
   */
  @Test
  @DisplayName("Test isCorrectMethod(Method, Object[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OSXAdapter.isCorrectMethod(Method, Object[])"})
  void testIsCorrectMethod() {
    // Arrange, Act and Assert
    assertFalse((new OSXAdapter("Proxy Signature", "Target", null)).isCorrectMethod(null, new Object[]{"Args"}));
  }

  /**
   * Test {@link OSXAdapter#setApplicationEventHandled(Object, boolean)}.
   * <ul>
   *   <li>When {@code Event}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OSXAdapter#setApplicationEventHandled(Object, boolean)}
   */
  @Test
  @DisplayName("Test setApplicationEventHandled(Object, boolean); when 'Event'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OSXAdapter.setApplicationEventHandled(Object, boolean)"})
  void testSetApplicationEventHandled_whenEvent_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new OSXAdapter("Proxy Signature", "Target", null)).setApplicationEventHandled("Event", true));
  }
}

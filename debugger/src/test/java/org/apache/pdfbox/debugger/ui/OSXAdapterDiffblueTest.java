package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

class OSXAdapterDiffblueTest {
  /**
   * Method under test: {@link OSXAdapter#invoke(Object, Method, Object[])}
   */
  @Test
  void testInvoke() throws Throwable {
    // Arrange, Act and Assert
    assertNull((new OSXAdapter("Proxy Signature", "Target", null)).invoke("Proxy", null, new Object[]{"Args"}));
  }

  /**
   * Method under test: {@link OSXAdapter#isCorrectMethod(Method, Object[])}
   */
  @Test
  void testIsCorrectMethod() {
    // Arrange, Act and Assert
    assertFalse((new OSXAdapter("Proxy Signature", "Target", null)).isCorrectMethod(null, new Object[]{"Args"}));
  }

  /**
   * Method under test:
   * {@link OSXAdapter#setApplicationEventHandled(Object, boolean)}
   */
  @Test
  void testSetApplicationEventHandled() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new OSXAdapter("Proxy Signature", "Target", null)).setApplicationEventHandled("Event", true));
  }

  /**
   * Method under test: {@link OSXAdapter#OSXAdapter(String, Object, Method)}
   */
  @Test
  void testNewOSXAdapter() {
    // Arrange and Act
    OSXAdapter actualOsxAdapter = new OSXAdapter("Proxy Signature", "Target", null);

    // Assert
    assertEquals("Proxy Signature", actualOsxAdapter.proxySignature);
    assertEquals("Target", actualOsxAdapter.targetObject);
    assertNull(actualOsxAdapter.targetMethod);
  }
}

package org.apache.pdfbox.debugger.streampane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import javax.swing.text.AttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleContext;
import javax.swing.text.StyleContext.NamedStyle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperatorMarkerDiffblueTest {
  /**
   * Test {@link OperatorMarker#getStyle(String)}.
   * <ul>
   *   <li>When {@code ID}.</li>
   *   <li>Then ResolveParent return {@link NamedStyle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperatorMarker#getStyle(String)}
   */
  @Test
  @DisplayName("Test getStyle(String); when 'ID'; then ResolveParent return NamedStyle")
  void testGetStyle_whenId_thenResolveParentReturnNamedStyle() {
    // Arrange and Act
    Style actualStyle = OperatorMarker.getStyle("ID");

    // Assert
    AttributeSet resolveParent = actualStyle.getResolveParent();
    assertTrue(resolveParent instanceof StyleContext.NamedStyle);
    assertTrue(actualStyle instanceof StyleContext.NamedStyle);
    assertEquals("ID", actualStyle.getName());
    assertEquals("common", ((StyleContext.NamedStyle) resolveParent).getName());
    assertNull(resolveParent.getResolveParent());
    assertEquals(0, ((StyleContext.NamedStyle) resolveParent).getChangeListeners().length);
    assertEquals(0, ((StyleContext.NamedStyle) actualStyle).getChangeListeners().length);
    assertEquals(2, resolveParent.getAttributeCount());
    assertEquals(3, actualStyle.getAttributeCount());
  }

  /**
   * Test {@link OperatorMarker#getStyle(String)}.
   * <ul>
   *   <li>When {@code Operator}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperatorMarker#getStyle(String)}
   */
  @Test
  @DisplayName("Test getStyle(String); when 'Operator'; then return 'null'")
  void testGetStyle_whenOperator_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(OperatorMarker.getStyle("Operator"));
  }
}

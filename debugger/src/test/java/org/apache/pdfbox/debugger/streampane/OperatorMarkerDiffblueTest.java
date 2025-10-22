package org.apache.pdfbox.debugger.streampane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.swing.text.AttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleContext;
import javax.swing.text.StyleContext.NamedStyle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Style OperatorMarker.getStyle(String)"})
  void testGetStyle_whenId_thenResolveParentReturnNamedStyle() {
    // Arrange and Act
    Style actualStyle = OperatorMarker.getStyle("ID");

    // Assert
    AttributeSet resolveParent = actualStyle.getResolveParent();
    assertTrue(resolveParent instanceof NamedStyle);
    assertTrue(actualStyle instanceof NamedStyle);
    assertEquals("ID", actualStyle.getName());
    assertEquals("common", ((NamedStyle) resolveParent).getName());
    assertNull(resolveParent.getResolveParent());
    assertEquals(0, ((NamedStyle) resolveParent).getChangeListeners().length);
    assertEquals(0, ((NamedStyle) actualStyle).getChangeListeners().length);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Style OperatorMarker.getStyle(String)"})
  void testGetStyle_whenOperator_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(OperatorMarker.getStyle("Operator"));
  }
}

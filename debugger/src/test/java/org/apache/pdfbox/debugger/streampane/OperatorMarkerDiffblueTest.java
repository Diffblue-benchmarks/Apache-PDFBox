package org.apache.pdfbox.debugger.streampane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import javax.swing.text.AttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleContext;
import org.junit.jupiter.api.Test;

class OperatorMarkerDiffblueTest {
  /**
   * Method under test: {@link OperatorMarker#getStyle(String)}
   */
  @Test
  void testGetStyle() {
    // Arrange, Act and Assert
    assertNull(OperatorMarker.getStyle("Operator"));
  }

  /**
   * Method under test: {@link OperatorMarker#getStyle(String)}
   */
  @Test
  void testGetStyle2() {
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
}

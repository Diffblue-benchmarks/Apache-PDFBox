package org.apache.pdfbox.debugger.streampane.tooltip;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.awt.Color;
import org.junit.jupiter.api.Test;

class ColorToolTipDiffblueTest {
  /**
   * Method under test: {@link ColorToolTip#colorHexValue(Color)}
   */
  @Test
  void testColorHexValue() throws NumberFormatException {
    // Arrange, Act and Assert
    assertEquals("00002a", ColorToolTip.colorHexValue(Color.decode("42")));
  }

  /**
   * Method under test: {@link ColorToolTip#extractColorValues(String)}
   */
  @Test
  void testExtractColorValues() {
    // Arrange, Act and Assert
    assertEquals(0, (new GToolTip("Row Text")).extractColorValues("Rowtext").length);
  }

  /**
   * Method under test: {@link ColorToolTip#getMarkUp(String)}
   */
  @Test
  void testGetMarkUp() {
    // Arrange, Act and Assert
    assertEquals(
        "<html>\n" + "<body bgcolor=#ffffff>\n"
            + "<div style=\"width:50px;height:20px;border:1px; background-color:#42;\"></div></body>\n" + "</html>",
        (new GToolTip("Row Text")).getMarkUp("42"));
  }

  /**
   * Method under test: {@link ColorToolTip#getToolTipText()}
   */
  @Test
  void testGetToolTipText() {
    // Arrange, Act and Assert
    assertNull((new GToolTip("Row Text")).getToolTipText());
  }
}

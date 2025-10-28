package org.apache.pdfbox.debugger.fontencodingpane;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class FontEncodingPaneControllerDiffblueTest {
  /**
   * Method under test: {@link FontEncodingPaneController#getPane()}
   */
  @Test
  void testGetPane() {
    // Arrange, Act and Assert
    assertNull((new FontEncodingPaneController(null, new COSDictionary())).getPane());
  }

  /**
   * Method under test:
   * {@link FontEncodingPaneController#FontEncodingPaneController(COSName, COSDictionary)}
   */
  @Test
  void testNewFontEncodingPaneController() {
    // Arrange, Act and Assert
    assertNull((new FontEncodingPaneController(null, new COSDictionary())).getPane());
  }
}

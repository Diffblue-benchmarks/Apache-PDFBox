package org.apache.pdfbox.debugger.fontencodingpane;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FontEncodingPaneControllerDiffblueTest {
  /**
   * Test
   * {@link FontEncodingPaneController#FontEncodingPaneController(COSName, COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return Pane is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontEncodingPaneController#FontEncodingPaneController(COSName, COSDictionary)}
   */
  @Test
  @DisplayName("Test new FontEncodingPaneController(COSName, COSDictionary); when COSDictionary(); then return Pane is 'null'")
  void testNewFontEncodingPaneController_whenCOSDictionary_thenReturnPaneIsNull() {
    // Arrange, Act and Assert
    assertNull((new FontEncodingPaneController(null, new COSDictionary())).getPane());
  }

  /**
   * Test
   * {@link FontEncodingPaneController#FontEncodingPaneController(COSName, COSDictionary)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return Pane is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontEncodingPaneController#FontEncodingPaneController(COSName, COSDictionary)}
   */
  @Test
  @DisplayName("Test new FontEncodingPaneController(COSName, COSDictionary); when COSStream(); then return Pane is 'null'")
  void testNewFontEncodingPaneController_whenCOSStream_thenReturnPaneIsNull() {
    // Arrange, Act and Assert
    assertNull((new FontEncodingPaneController(null, new COSStream())).getPane());
  }

  /**
   * Test {@link FontEncodingPaneController#getPane()}.
   * <p>
   * Method under test: {@link FontEncodingPaneController#getPane()}
   */
  @Test
  @DisplayName("Test getPane()")
  void testGetPane() {
    // Arrange, Act and Assert
    assertNull((new FontEncodingPaneController(null, new COSDictionary())).getPane());
  }
}

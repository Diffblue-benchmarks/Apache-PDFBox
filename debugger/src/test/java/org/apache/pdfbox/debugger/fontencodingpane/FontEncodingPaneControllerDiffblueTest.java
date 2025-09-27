package org.apache.pdfbox.debugger.fontencodingpane;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FontEncodingPaneControllerDiffblueTest {
  /**
   * Test {@link FontEncodingPaneController#FontEncodingPaneController(COSName, COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return Pane is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FontEncodingPaneController#FontEncodingPaneController(COSName,
   * COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new FontEncodingPaneController(COSName, COSDictionary); when COSDictionary(); then return Pane is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FontEncodingPaneController.<init>(COSName, COSDictionary)"})
  void testNewFontEncodingPaneController_whenCOSDictionary_thenReturnPaneIsNull() {
    // Arrange
    COSName fontName = mock(COSName.class);

    // Act
    FontEncodingPaneController actualFontEncodingPaneController =
        new FontEncodingPaneController(fontName, new COSDictionary());

    // Assert
    assertNull(actualFontEncodingPaneController.getPane());
  }

  /**
   * Test {@link FontEncodingPaneController#getPane()}.
   *
   * <p>Method under test: {@link FontEncodingPaneController#getPane()}
   */
  @Test
  @DisplayName("Test getPane()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"javax.swing.JPanel FontEncodingPaneController.getPane()"})
  void testGetPane() {
    // Arrange
    COSName fontName = mock(COSName.class);
    FontEncodingPaneController fontEncodingPaneController =
        new FontEncodingPaneController(fontName, new COSDictionary());

    // Act and Assert
    assertNull(fontEncodingPaneController.getPane());
  }
}

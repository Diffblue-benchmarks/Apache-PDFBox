package org.apache.pdfbox.debugger.streampane.tooltip;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FontToolTipDiffblueTest {
  /**
   * Test {@link FontToolTip#FontToolTip(PDResources, String)}.
   *
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link FontToolTip#FontToolTip(PDResources, String)}
   */
  @Test
  @DisplayName(
      "Test new FontToolTip(PDResources, String); given PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FontToolTip.<init>(PDResources, String)"})
  void testNewFontToolTip_givenPDMMType1FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange
    PDResources resources = new PDResources();
    resources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertNull(new FontToolTip(resources, "Row Text").getToolTipText());
  }

  /**
   * Test {@link FontToolTip#FontToolTip(PDResources, String)}.
   *
   * <ul>
   *   <li>When {@link PDResources#PDResources()}.
   *   <li>Then return ToolTipText is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FontToolTip#FontToolTip(PDResources, String)}
   */
  @Test
  @DisplayName(
      "Test new FontToolTip(PDResources, String); when PDResources(); then return ToolTipText is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FontToolTip.<init>(PDResources, String)"})
  void testNewFontToolTip_whenPDResources_thenReturnToolTipTextIsNull() {
    // Arrange, Act and Assert
    assertNull(new FontToolTip(new PDResources(), "Row Text").getToolTipText());
  }

  /**
   * Test {@link FontToolTip#getToolTipText()}.
   *
   * <p>Method under test: {@link FontToolTip#getToolTipText()}
   */
  @Test
  @DisplayName("Test getToolTipText()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FontToolTip.getToolTipText()"})
  void testGetToolTipText() {
    // Arrange, Act and Assert
    assertNull(new FontToolTip(new PDResources(), "Row Text").getToolTipText());
  }
}

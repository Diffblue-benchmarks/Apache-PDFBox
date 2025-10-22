package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.font.encoding.StandardEncoding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDMMType1FontDiffblueTest {
  /**
   * Test {@link PDMMType1Font#PDMMType1Font(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then FontBoxFont return {@link TrueTypeFont}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMMType1Font#PDMMType1Font(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDMMType1Font(COSDictionary); when COSDictionary(); then FontBoxFont return TrueTypeFont")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDMMType1Font.<init>(COSDictionary)"})
  void testNewPDMMType1Font_whenCOSDictionary_thenFontBoxFontReturnTrueTypeFont() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();

    // Act
    PDMMType1Font actualPdmmType1Font = new PDMMType1Font(fontDictionary);

    // Assert
    assertTrue(actualPdmmType1Font.getFontBoxFont() instanceof TrueTypeFont);
    assertTrue(actualPdmmType1Font.getEncoding() instanceof StandardEncoding);
    assertNull(actualPdmmType1Font.getSymbolicFlag());
    assertNull(actualPdmmType1Font.getSubType());
    assertNull(actualPdmmType1Font.getType());
    assertNull(actualPdmmType1Font.getBaseFont());
    assertNull(actualPdmmType1Font.getName());
    assertNull(actualPdmmType1Font.getStandard14AFM());
    assertNull(actualPdmmType1Font.getToUnicodeCMap());
    assertNull(actualPdmmType1Font.getType1Font());
    assertNull(actualPdmmType1Font.getFontDescriptor());
    assertEquals(0.0f, actualPdmmType1Font.getAverageFontWidth());
    assertEquals(250.0f, actualPdmmType1Font.getSpaceWidth());
    assertFalse(actualPdmmType1Font.isVertical());
    assertFalse(actualPdmmType1Font.isDamaged());
    assertFalse(actualPdmmType1Font.isEmbedded());
    assertTrue(actualPdmmType1Font.getWidths().isEmpty());
    assertSame(fontDictionary, actualPdmmType1Font.getCOSObject());
  }
}

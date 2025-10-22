package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.fontbox.afm.FontMetrics;
import org.apache.fontbox.util.BoundingBox;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDType1FontEmbedderDiffblueTest {
  /**
   * Test {@link PDType1FontEmbedder#buildFontDescriptor(FontMetrics)} with {@code metrics}.
   * <ul>
   *   <li>Then return CharSet is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1FontEmbedder#buildFontDescriptor(FontMetrics)}
   */
  @Test
  @DisplayName("Test buildFontDescriptor(FontMetrics) with 'metrics'; then return CharSet is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDFontDescriptor PDType1FontEmbedder.buildFontDescriptor(FontMetrics)"})
  void testBuildFontDescriptorWithMetrics_thenReturnCharSetIsNull() {
    // Arrange
    FontMetrics metrics = new FontMetrics();
    metrics.setFontBBox(new BoundingBox(10.0f, 10.0f, 10.0f, 10.0f));
    metrics.setEncodingScheme("UTF-8");

    // Act
    PDFontDescriptor actualBuildFontDescriptorResult = PDType1FontEmbedder.buildFontDescriptor(metrics);

    // Assert
    assertNull(actualBuildFontDescriptorResult.getCharSet());
    assertNull(actualBuildFontDescriptorResult.getFontFamily());
    assertNull(actualBuildFontDescriptorResult.getFontName());
    assertNull(actualBuildFontDescriptorResult.getFontStretch());
    assertNull(actualBuildFontDescriptorResult.getCIDSet());
    assertNull(actualBuildFontDescriptorResult.getFontFile());
    assertNull(actualBuildFontDescriptorResult.getFontFile2());
    assertNull(actualBuildFontDescriptorResult.getFontFile3());
    assertNull(actualBuildFontDescriptorResult.getPanose());
    assertEquals(0.0f, actualBuildFontDescriptorResult.getAscent());
    assertEquals(0.0f, actualBuildFontDescriptorResult.getAverageWidth());
    assertEquals(0.0f, actualBuildFontDescriptorResult.getCapHeight());
    assertEquals(0.0f, actualBuildFontDescriptorResult.getDescent());
    assertEquals(0.0f, actualBuildFontDescriptorResult.getFontWeight());
    assertEquals(0.0f, actualBuildFontDescriptorResult.getItalicAngle());
    assertEquals(0.0f, actualBuildFontDescriptorResult.getLeading());
    assertEquals(0.0f, actualBuildFontDescriptorResult.getMaxWidth());
    assertEquals(0.0f, actualBuildFontDescriptorResult.getMissingWidth());
    assertEquals(0.0f, actualBuildFontDescriptorResult.getStemH());
    assertEquals(0.0f, actualBuildFontDescriptorResult.getStemV());
    assertEquals(0.0f, actualBuildFontDescriptorResult.getXHeight());
    assertFalse(actualBuildFontDescriptorResult.isAllCap());
    assertFalse(actualBuildFontDescriptorResult.isFixedPitch());
    assertFalse(actualBuildFontDescriptorResult.isForceBold());
    assertFalse(actualBuildFontDescriptorResult.isItalic());
    assertFalse(actualBuildFontDescriptorResult.isScript());
    assertFalse(actualBuildFontDescriptorResult.isSerif());
    assertFalse(actualBuildFontDescriptorResult.isSmallCap());
    assertFalse(actualBuildFontDescriptorResult.isSymbolic());
    assertTrue(actualBuildFontDescriptorResult.isNonSymbolic());
    assertEquals(Integer.SIZE, actualBuildFontDescriptorResult.getFlags());
  }
}

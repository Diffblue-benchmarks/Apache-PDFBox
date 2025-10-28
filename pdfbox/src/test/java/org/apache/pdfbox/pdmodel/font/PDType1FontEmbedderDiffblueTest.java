package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.fontbox.afm.FontMetrics;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.Test;

class PDType1FontEmbedderDiffblueTest {
  /**
   * Method under test:
   * {@link PDType1FontEmbedder#buildFontDescriptor(FontMetrics)}
   */
  @Test
  void testBuildFontDescriptor() {
    // Arrange
    FontMetrics metrics = new FontMetrics();
    metrics.setFontBBox(new BoundingBox(10.0f, 10.0f, 10.0f, 10.0f));
    metrics.setEncodingScheme("UTF-8");

    // Act
    PDFontDescriptor actualBuildFontDescriptorResult = PDType1FontEmbedder.buildFontDescriptor(metrics);

    // Assert
    PDRectangle fontBoundingBox = actualBuildFontDescriptorResult.getFontBoundingBox();
    COSArray cOSArray = fontBoundingBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(actualBuildFontDescriptorResult.getCharSet());
    assertNull(actualBuildFontDescriptorResult.getFontFamily());
    assertNull(actualBuildFontDescriptorResult.getFontName());
    assertNull(actualBuildFontDescriptorResult.getFontStretch());
    COSDictionary cOSObject = actualBuildFontDescriptorResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(cOSObject.getKey());
    assertNull(actualBuildFontDescriptorResult.getCIDSet());
    assertNull(actualBuildFontDescriptorResult.getFontFile());
    assertNull(actualBuildFontDescriptorResult.getFontFile2());
    assertNull(actualBuildFontDescriptorResult.getFontFile3());
    assertNull(actualBuildFontDescriptorResult.getPanose());
    assertEquals(0.0f, fontBoundingBox.getHeight());
    assertEquals(0.0f, fontBoundingBox.getWidth());
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
    assertEquals(10.0f, fontBoundingBox.getLowerLeftX());
    assertEquals(10.0f, fontBoundingBox.getLowerLeftY());
    assertEquals(10.0f, fontBoundingBox.getUpperRightX());
    assertEquals(10.0f, fontBoundingBox.getUpperRightY());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualBuildFontDescriptorResult.isAllCap());
    assertFalse(actualBuildFontDescriptorResult.isFixedPitch());
    assertFalse(actualBuildFontDescriptorResult.isForceBold());
    assertFalse(actualBuildFontDescriptorResult.isItalic());
    assertFalse(actualBuildFontDescriptorResult.isScript());
    assertFalse(actualBuildFontDescriptorResult.isSerif());
    assertFalse(actualBuildFontDescriptorResult.isSmallCap());
    assertFalse(actualBuildFontDescriptorResult.isSymbolic());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualBuildFontDescriptorResult.isNonSymbolic());
    assertEquals(Integer.SIZE, actualBuildFontDescriptorResult.getFlags());
    assertEquals(PDPanoseClassification.LENGTH, cOSObject.getValues().size());
    assertEquals(PDPanoseClassification.LENGTH, cOSObject.size());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
  }
}

package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.pdmodel.common.PDImmutableRectangle;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.Test;

class TextToPDFDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link TextToPDF}
   */
  @Test
  void testNewTextToPDF() {
    // Arrange and Act
    TextToPDF actualTextToPDF = new TextToPDF();

    // Assert
    PDRectangle mediaBox = actualTextToPDF.getMediaBox();
    COSArray cOSArray = mediaBox.getCOSArray();
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
    assertTrue(mediaBox instanceof PDImmutableRectangle);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertNull(actualTextToPDF.getFont());
    assertEquals(0.0f, mediaBox.getLowerLeftX());
    assertEquals(0.0f, mediaBox.getLowerLeftY());
    assertEquals(10, actualTextToPDF.getFontSize());
    assertEquals(612.0f, mediaBox.getUpperRightX());
    assertEquals(612.0f, mediaBox.getWidth());
    assertEquals(792.0f, mediaBox.getHeight());
    assertEquals(792.0f, mediaBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertFalse(actualTextToPDF.isLandscape());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, mediaBox.getCOSObject());
  }
}

package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.Set;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDTilingPattern;
import org.junit.jupiter.api.Test;

class PDPatternContentStreamDiffblueTest {
  /**
   * Method under test:
   * {@link PDPatternContentStream#PDPatternContentStream(PDTilingPattern)}
   */
  @Test
  void testNewPDPatternContentStream() throws IOException {
    // Arrange
    PDTilingPattern pattern = new PDTilingPattern();

    // Act
    PDPatternContentStream actualPdPatternContentStream = new PDPatternContentStream(pattern);

    // Assert
    PDResources pdResources = actualPdPatternContentStream.resources;
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    COSDictionary cOSObject = pattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    COSDictionary cOSObject2 = pdResources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    assertNull(actualPdPatternContentStream.document);
    assertNull(pdResources.getResourceCache());
    assertEquals(0, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdPatternContentStream.inTextMode);
    assertTrue(cOSObject2.getValues().isEmpty());
    assertTrue(actualPdPatternContentStream.fontStack.isEmpty());
    assertTrue(actualPdPatternContentStream.nonStrokingColorSpaceStack.isEmpty());
    assertTrue(actualPdPatternContentStream.strokingColorSpaceStack.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(((COSStream) cOSObject).hasData());
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getPropertiesNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
  }

  /**
   * Method under test:
   * {@link PDPatternContentStream#PDPatternContentStream(PDTilingPattern)}
   */
  @Test
  void testNewPDPatternContentStream2() throws IOException {
    // Arrange
    COSStream dictionary = new COSStream();
    PDTilingPattern pattern = new PDTilingPattern(dictionary);

    // Act
    PDPatternContentStream actualPdPatternContentStream = new PDPatternContentStream(pattern);

    // Assert
    COSDictionary cOSObject = pattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertNull(actualPdPatternContentStream.document);
    assertNull(actualPdPatternContentStream.resources);
    assertFalse(actualPdPatternContentStream.inTextMode);
    assertTrue(actualPdPatternContentStream.fontStack.isEmpty());
    assertTrue(actualPdPatternContentStream.nonStrokingColorSpaceStack.isEmpty());
    assertTrue(actualPdPatternContentStream.strokingColorSpaceStack.isEmpty());
    assertTrue(((COSStream) cOSObject).hasData());
    assertSame(dictionary, cOSObject);
  }
}

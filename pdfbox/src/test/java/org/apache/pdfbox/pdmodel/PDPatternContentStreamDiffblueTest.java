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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDPatternContentStreamDiffblueTest {
  /**
   * Test {@link PDPatternContentStream#PDPatternContentStream(PDTilingPattern)}.
   * <p>
   * Method under test:
   * {@link PDPatternContentStream#PDPatternContentStream(PDTilingPattern)}
   */
  @Test
  @DisplayName("Test new PDPatternContentStream(PDTilingPattern)")
  void testNewPDPatternContentStream() throws IOException {
    // Arrange
    PDTilingPattern pattern = new PDTilingPattern(new COSStream());

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
  }

  /**
   * Test {@link PDPatternContentStream#PDPatternContentStream(PDTilingPattern)}.
   * <ul>
   *   <li>Then {@link PDAbstractContentStream#resources} ColorSpaceNames return
   * {@link Set}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPatternContentStream#PDPatternContentStream(PDTilingPattern)}
   */
  @Test
  @DisplayName("Test new PDPatternContentStream(PDTilingPattern); then resources ColorSpaceNames return Set")
  void testNewPDPatternContentStream_thenResourcesColorSpaceNamesReturnSet() throws IOException {
    // Arrange, Act and Assert
    PDResources pdResources = (new PDPatternContentStream(new PDTilingPattern())).resources;
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(pdResources.getResourceCache());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getPropertiesNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
  }
}

package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class FDFAnnotationSquigglyDiffblueTest {
  /**
   * Method under test:
   * {@link FDFAnnotationSquiggly#FDFAnnotationSquiggly(COSDictionary)}
   */
  @Test
  void testNewFDFAnnotationSquiggly() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new FDFAnnotationSquiggly(a)).getCOSObject());
  }

  /**
   * Method under test: {@link FDFAnnotationSquiggly#FDFAnnotationSquiggly()}
   */
  @Test
  void testNewFDFAnnotationSquiggly2() throws IOException {
    // Arrange and Act
    FDFAnnotationSquiggly actualFdfAnnotationSquiggly = new FDFAnnotationSquiggly();

    // Assert
    assertEquals("", actualFdfAnnotationSquiggly.getRichContents());
    assertNull(actualFdfAnnotationSquiggly.getCoords());
    assertNull(actualFdfAnnotationSquiggly.getColor());
    assertNull(actualFdfAnnotationSquiggly.getPage());
    assertNull(actualFdfAnnotationSquiggly.getContents());
    assertNull(actualFdfAnnotationSquiggly.getDate());
    assertNull(actualFdfAnnotationSquiggly.getIntent());
    assertNull(actualFdfAnnotationSquiggly.getName());
    assertNull(actualFdfAnnotationSquiggly.getSubject());
    assertNull(actualFdfAnnotationSquiggly.getTitle());
    assertNull(actualFdfAnnotationSquiggly.getCreationDate());
    COSDictionary cOSObject = actualFdfAnnotationSquiggly.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfAnnotationSquiggly.getRectangle());
    assertNull(actualFdfAnnotationSquiggly.getBorderEffect());
    assertNull(actualFdfAnnotationSquiggly.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationSquiggly.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualFdfAnnotationSquiggly.isHidden());
    assertFalse(actualFdfAnnotationSquiggly.isInvisible());
    assertFalse(actualFdfAnnotationSquiggly.isLocked());
    assertFalse(actualFdfAnnotationSquiggly.isLockedContents());
    assertFalse(actualFdfAnnotationSquiggly.isNoRotate());
    assertFalse(actualFdfAnnotationSquiggly.isNoView());
    assertFalse(actualFdfAnnotationSquiggly.isNoZoom());
    assertFalse(actualFdfAnnotationSquiggly.isPrinted());
    assertFalse(actualFdfAnnotationSquiggly.isReadOnly());
    assertFalse(actualFdfAnnotationSquiggly.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}

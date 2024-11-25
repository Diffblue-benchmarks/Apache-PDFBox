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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FDFAnnotationStampDiffblueTest {
  /**
   * Test {@link FDFAnnotationStamp#FDFAnnotationStamp(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link FDFAnnotationStamp#FDFAnnotationStamp(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationStamp(COSDictionary)")
  void testNewFDFAnnotationStamp() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new FDFAnnotationStamp(a)).getCOSObject());
  }

  /**
   * Test {@link FDFAnnotationStamp#FDFAnnotationStamp()}.
   * <p>
   * Method under test: {@link FDFAnnotationStamp#FDFAnnotationStamp()}
   */
  @Test
  @DisplayName("Test new FDFAnnotationStamp()")
  void testNewFDFAnnotationStamp2() throws IOException {
    // Arrange and Act
    FDFAnnotationStamp actualFdfAnnotationStamp = new FDFAnnotationStamp();

    // Assert
    assertEquals("", actualFdfAnnotationStamp.getRichContents());
    assertNull(actualFdfAnnotationStamp.getColor());
    assertNull(actualFdfAnnotationStamp.getPage());
    assertNull(actualFdfAnnotationStamp.getContents());
    assertNull(actualFdfAnnotationStamp.getDate());
    assertNull(actualFdfAnnotationStamp.getIntent());
    assertNull(actualFdfAnnotationStamp.getName());
    assertNull(actualFdfAnnotationStamp.getSubject());
    assertNull(actualFdfAnnotationStamp.getTitle());
    assertNull(actualFdfAnnotationStamp.getCreationDate());
    COSDictionary cOSObject = actualFdfAnnotationStamp.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfAnnotationStamp.getRectangle());
    assertNull(actualFdfAnnotationStamp.getBorderEffect());
    assertNull(actualFdfAnnotationStamp.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationStamp.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualFdfAnnotationStamp.isHidden());
    assertFalse(actualFdfAnnotationStamp.isInvisible());
    assertFalse(actualFdfAnnotationStamp.isLocked());
    assertFalse(actualFdfAnnotationStamp.isLockedContents());
    assertFalse(actualFdfAnnotationStamp.isNoRotate());
    assertFalse(actualFdfAnnotationStamp.isNoView());
    assertFalse(actualFdfAnnotationStamp.isNoZoom());
    assertFalse(actualFdfAnnotationStamp.isPrinted());
    assertFalse(actualFdfAnnotationStamp.isReadOnly());
    assertFalse(actualFdfAnnotationStamp.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}

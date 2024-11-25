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

class FDFAnnotationStrikeOutDiffblueTest {
  /**
   * Test {@link FDFAnnotationStrikeOut#FDFAnnotationStrikeOut(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link FDFAnnotationStrikeOut#FDFAnnotationStrikeOut(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationStrikeOut(COSDictionary)")
  void testNewFDFAnnotationStrikeOut() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new FDFAnnotationStrikeOut(a)).getCOSObject());
  }

  /**
   * Test {@link FDFAnnotationStrikeOut#FDFAnnotationStrikeOut()}.
   * <p>
   * Method under test: {@link FDFAnnotationStrikeOut#FDFAnnotationStrikeOut()}
   */
  @Test
  @DisplayName("Test new FDFAnnotationStrikeOut()")
  void testNewFDFAnnotationStrikeOut2() throws IOException {
    // Arrange and Act
    FDFAnnotationStrikeOut actualFdfAnnotationStrikeOut = new FDFAnnotationStrikeOut();

    // Assert
    assertEquals("", actualFdfAnnotationStrikeOut.getRichContents());
    assertNull(actualFdfAnnotationStrikeOut.getCoords());
    assertNull(actualFdfAnnotationStrikeOut.getColor());
    assertNull(actualFdfAnnotationStrikeOut.getPage());
    assertNull(actualFdfAnnotationStrikeOut.getContents());
    assertNull(actualFdfAnnotationStrikeOut.getDate());
    assertNull(actualFdfAnnotationStrikeOut.getIntent());
    assertNull(actualFdfAnnotationStrikeOut.getName());
    assertNull(actualFdfAnnotationStrikeOut.getSubject());
    assertNull(actualFdfAnnotationStrikeOut.getTitle());
    assertNull(actualFdfAnnotationStrikeOut.getCreationDate());
    COSDictionary cOSObject = actualFdfAnnotationStrikeOut.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfAnnotationStrikeOut.getRectangle());
    assertNull(actualFdfAnnotationStrikeOut.getBorderEffect());
    assertNull(actualFdfAnnotationStrikeOut.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationStrikeOut.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualFdfAnnotationStrikeOut.isHidden());
    assertFalse(actualFdfAnnotationStrikeOut.isInvisible());
    assertFalse(actualFdfAnnotationStrikeOut.isLocked());
    assertFalse(actualFdfAnnotationStrikeOut.isLockedContents());
    assertFalse(actualFdfAnnotationStrikeOut.isNoRotate());
    assertFalse(actualFdfAnnotationStrikeOut.isNoView());
    assertFalse(actualFdfAnnotationStrikeOut.isNoZoom());
    assertFalse(actualFdfAnnotationStrikeOut.isPrinted());
    assertFalse(actualFdfAnnotationStrikeOut.isReadOnly());
    assertFalse(actualFdfAnnotationStrikeOut.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}

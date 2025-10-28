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

class FDFAnnotationUnderlineDiffblueTest {
  /**
   * Method under test:
   * {@link FDFAnnotationUnderline#FDFAnnotationUnderline(COSDictionary)}
   */
  @Test
  void testNewFDFAnnotationUnderline() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new FDFAnnotationUnderline(a)).getCOSObject());
  }

  /**
   * Method under test: {@link FDFAnnotationUnderline#FDFAnnotationUnderline()}
   */
  @Test
  void testNewFDFAnnotationUnderline2() throws IOException {
    // Arrange and Act
    FDFAnnotationUnderline actualFdfAnnotationUnderline = new FDFAnnotationUnderline();

    // Assert
    assertEquals("", actualFdfAnnotationUnderline.getRichContents());
    assertNull(actualFdfAnnotationUnderline.getCoords());
    assertNull(actualFdfAnnotationUnderline.getColor());
    assertNull(actualFdfAnnotationUnderline.getPage());
    assertNull(actualFdfAnnotationUnderline.getContents());
    assertNull(actualFdfAnnotationUnderline.getDate());
    assertNull(actualFdfAnnotationUnderline.getIntent());
    assertNull(actualFdfAnnotationUnderline.getName());
    assertNull(actualFdfAnnotationUnderline.getSubject());
    assertNull(actualFdfAnnotationUnderline.getTitle());
    assertNull(actualFdfAnnotationUnderline.getCreationDate());
    COSDictionary cOSObject = actualFdfAnnotationUnderline.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfAnnotationUnderline.getRectangle());
    assertNull(actualFdfAnnotationUnderline.getBorderEffect());
    assertNull(actualFdfAnnotationUnderline.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationUnderline.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualFdfAnnotationUnderline.isHidden());
    assertFalse(actualFdfAnnotationUnderline.isInvisible());
    assertFalse(actualFdfAnnotationUnderline.isLocked());
    assertFalse(actualFdfAnnotationUnderline.isLockedContents());
    assertFalse(actualFdfAnnotationUnderline.isNoRotate());
    assertFalse(actualFdfAnnotationUnderline.isNoView());
    assertFalse(actualFdfAnnotationUnderline.isNoZoom());
    assertFalse(actualFdfAnnotationUnderline.isPrinted());
    assertFalse(actualFdfAnnotationUnderline.isReadOnly());
    assertFalse(actualFdfAnnotationUnderline.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}

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

class FDFAnnotationHighlightDiffblueTest {
  /**
   * Test {@link FDFAnnotationHighlight#FDFAnnotationHighlight(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link FDFAnnotationHighlight#FDFAnnotationHighlight(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationHighlight(COSDictionary)")
  void testNewFDFAnnotationHighlight() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new FDFAnnotationHighlight(a)).getCOSObject());
  }

  /**
   * Test {@link FDFAnnotationHighlight#FDFAnnotationHighlight()}.
   * <p>
   * Method under test: {@link FDFAnnotationHighlight#FDFAnnotationHighlight()}
   */
  @Test
  @DisplayName("Test new FDFAnnotationHighlight()")
  void testNewFDFAnnotationHighlight2() throws IOException {
    // Arrange and Act
    FDFAnnotationHighlight actualFdfAnnotationHighlight = new FDFAnnotationHighlight();

    // Assert
    assertEquals("", actualFdfAnnotationHighlight.getRichContents());
    assertNull(actualFdfAnnotationHighlight.getCoords());
    assertNull(actualFdfAnnotationHighlight.getColor());
    assertNull(actualFdfAnnotationHighlight.getPage());
    assertNull(actualFdfAnnotationHighlight.getContents());
    assertNull(actualFdfAnnotationHighlight.getDate());
    assertNull(actualFdfAnnotationHighlight.getIntent());
    assertNull(actualFdfAnnotationHighlight.getName());
    assertNull(actualFdfAnnotationHighlight.getSubject());
    assertNull(actualFdfAnnotationHighlight.getTitle());
    assertNull(actualFdfAnnotationHighlight.getCreationDate());
    COSDictionary cOSObject = actualFdfAnnotationHighlight.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfAnnotationHighlight.getRectangle());
    assertNull(actualFdfAnnotationHighlight.getBorderEffect());
    assertNull(actualFdfAnnotationHighlight.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationHighlight.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualFdfAnnotationHighlight.isHidden());
    assertFalse(actualFdfAnnotationHighlight.isInvisible());
    assertFalse(actualFdfAnnotationHighlight.isLocked());
    assertFalse(actualFdfAnnotationHighlight.isLockedContents());
    assertFalse(actualFdfAnnotationHighlight.isNoRotate());
    assertFalse(actualFdfAnnotationHighlight.isNoView());
    assertFalse(actualFdfAnnotationHighlight.isNoZoom());
    assertFalse(actualFdfAnnotationHighlight.isPrinted());
    assertFalse(actualFdfAnnotationHighlight.isReadOnly());
    assertFalse(actualFdfAnnotationHighlight.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}

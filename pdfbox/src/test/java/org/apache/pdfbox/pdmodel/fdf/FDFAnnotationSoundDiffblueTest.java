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

class FDFAnnotationSoundDiffblueTest {
  /**
   * Method under test:
   * {@link FDFAnnotationSound#FDFAnnotationSound(COSDictionary)}
   */
  @Test
  void testNewFDFAnnotationSound() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new FDFAnnotationSound(a)).getCOSObject());
  }

  /**
   * Method under test: {@link FDFAnnotationSound#FDFAnnotationSound()}
   */
  @Test
  void testNewFDFAnnotationSound2() throws IOException {
    // Arrange and Act
    FDFAnnotationSound actualFdfAnnotationSound = new FDFAnnotationSound();

    // Assert
    assertEquals("", actualFdfAnnotationSound.getRichContents());
    assertNull(actualFdfAnnotationSound.getColor());
    assertNull(actualFdfAnnotationSound.getPage());
    assertNull(actualFdfAnnotationSound.getContents());
    assertNull(actualFdfAnnotationSound.getDate());
    assertNull(actualFdfAnnotationSound.getIntent());
    assertNull(actualFdfAnnotationSound.getName());
    assertNull(actualFdfAnnotationSound.getSubject());
    assertNull(actualFdfAnnotationSound.getTitle());
    assertNull(actualFdfAnnotationSound.getCreationDate());
    COSDictionary cOSObject = actualFdfAnnotationSound.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfAnnotationSound.getRectangle());
    assertNull(actualFdfAnnotationSound.getBorderEffect());
    assertNull(actualFdfAnnotationSound.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationSound.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualFdfAnnotationSound.isHidden());
    assertFalse(actualFdfAnnotationSound.isInvisible());
    assertFalse(actualFdfAnnotationSound.isLocked());
    assertFalse(actualFdfAnnotationSound.isLockedContents());
    assertFalse(actualFdfAnnotationSound.isNoRotate());
    assertFalse(actualFdfAnnotationSound.isNoView());
    assertFalse(actualFdfAnnotationSound.isNoZoom());
    assertFalse(actualFdfAnnotationSound.isPrinted());
    assertFalse(actualFdfAnnotationSound.isReadOnly());
    assertFalse(actualFdfAnnotationSound.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}

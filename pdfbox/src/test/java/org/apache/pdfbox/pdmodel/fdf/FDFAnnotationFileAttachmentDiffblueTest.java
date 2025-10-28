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

class FDFAnnotationFileAttachmentDiffblueTest {
  /**
   * Method under test:
   * {@link FDFAnnotationFileAttachment#FDFAnnotationFileAttachment(COSDictionary)}
   */
  @Test
  void testNewFDFAnnotationFileAttachment() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new FDFAnnotationFileAttachment(a)).getCOSObject());
  }

  /**
   * Method under test:
   * {@link FDFAnnotationFileAttachment#FDFAnnotationFileAttachment()}
   */
  @Test
  void testNewFDFAnnotationFileAttachment2() throws IOException {
    // Arrange and Act
    FDFAnnotationFileAttachment actualFdfAnnotationFileAttachment = new FDFAnnotationFileAttachment();

    // Assert
    assertEquals("", actualFdfAnnotationFileAttachment.getRichContents());
    assertNull(actualFdfAnnotationFileAttachment.getColor());
    assertNull(actualFdfAnnotationFileAttachment.getPage());
    assertNull(actualFdfAnnotationFileAttachment.getContents());
    assertNull(actualFdfAnnotationFileAttachment.getDate());
    assertNull(actualFdfAnnotationFileAttachment.getIntent());
    assertNull(actualFdfAnnotationFileAttachment.getName());
    assertNull(actualFdfAnnotationFileAttachment.getSubject());
    assertNull(actualFdfAnnotationFileAttachment.getTitle());
    assertNull(actualFdfAnnotationFileAttachment.getCreationDate());
    COSDictionary cOSObject = actualFdfAnnotationFileAttachment.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfAnnotationFileAttachment.getRectangle());
    assertNull(actualFdfAnnotationFileAttachment.getBorderEffect());
    assertNull(actualFdfAnnotationFileAttachment.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationFileAttachment.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualFdfAnnotationFileAttachment.isHidden());
    assertFalse(actualFdfAnnotationFileAttachment.isInvisible());
    assertFalse(actualFdfAnnotationFileAttachment.isLocked());
    assertFalse(actualFdfAnnotationFileAttachment.isLockedContents());
    assertFalse(actualFdfAnnotationFileAttachment.isNoRotate());
    assertFalse(actualFdfAnnotationFileAttachment.isNoView());
    assertFalse(actualFdfAnnotationFileAttachment.isNoZoom());
    assertFalse(actualFdfAnnotationFileAttachment.isPrinted());
    assertFalse(actualFdfAnnotationFileAttachment.isReadOnly());
    assertFalse(actualFdfAnnotationFileAttachment.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}

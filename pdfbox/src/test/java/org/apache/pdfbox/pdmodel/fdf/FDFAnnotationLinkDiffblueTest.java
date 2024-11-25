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

class FDFAnnotationLinkDiffblueTest {
  /**
   * Test {@link FDFAnnotationLink#FDFAnnotationLink(COSDictionary)}.
   * <p>
   * Method under test: {@link FDFAnnotationLink#FDFAnnotationLink(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationLink(COSDictionary)")
  void testNewFDFAnnotationLink() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new FDFAnnotationLink(a)).getCOSObject());
  }

  /**
   * Test {@link FDFAnnotationLink#FDFAnnotationLink()}.
   * <p>
   * Method under test: {@link FDFAnnotationLink#FDFAnnotationLink()}
   */
  @Test
  @DisplayName("Test new FDFAnnotationLink()")
  void testNewFDFAnnotationLink2() throws IOException {
    // Arrange and Act
    FDFAnnotationLink actualFdfAnnotationLink = new FDFAnnotationLink();

    // Assert
    assertEquals("", actualFdfAnnotationLink.getRichContents());
    assertNull(actualFdfAnnotationLink.getColor());
    assertNull(actualFdfAnnotationLink.getPage());
    assertNull(actualFdfAnnotationLink.getContents());
    assertNull(actualFdfAnnotationLink.getDate());
    assertNull(actualFdfAnnotationLink.getIntent());
    assertNull(actualFdfAnnotationLink.getName());
    assertNull(actualFdfAnnotationLink.getSubject());
    assertNull(actualFdfAnnotationLink.getTitle());
    assertNull(actualFdfAnnotationLink.getCreationDate());
    COSDictionary cOSObject = actualFdfAnnotationLink.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfAnnotationLink.getRectangle());
    assertNull(actualFdfAnnotationLink.getBorderEffect());
    assertNull(actualFdfAnnotationLink.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationLink.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualFdfAnnotationLink.isHidden());
    assertFalse(actualFdfAnnotationLink.isInvisible());
    assertFalse(actualFdfAnnotationLink.isLocked());
    assertFalse(actualFdfAnnotationLink.isLockedContents());
    assertFalse(actualFdfAnnotationLink.isNoRotate());
    assertFalse(actualFdfAnnotationLink.isNoView());
    assertFalse(actualFdfAnnotationLink.isNoZoom());
    assertFalse(actualFdfAnnotationLink.isPrinted());
    assertFalse(actualFdfAnnotationLink.isReadOnly());
    assertFalse(actualFdfAnnotationLink.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}

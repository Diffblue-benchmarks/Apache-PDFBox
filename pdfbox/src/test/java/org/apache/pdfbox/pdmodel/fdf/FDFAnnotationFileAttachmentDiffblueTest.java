package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FDFAnnotationFileAttachmentDiffblueTest {
  /**
   * Test {@link FDFAnnotationFileAttachment#FDFAnnotationFileAttachment(COSDictionary)}.
   * <p>
   * Method under test: {@link FDFAnnotationFileAttachment#FDFAnnotationFileAttachment(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationFileAttachment(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFAnnotationFileAttachment.<init>(COSDictionary)"})
  void testNewFDFAnnotationFileAttachment() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new FDFAnnotationFileAttachment(a)).getCOSObject());
  }

  /**
   * Test {@link FDFAnnotationFileAttachment#FDFAnnotationFileAttachment()}.
   * <p>
   * Method under test: {@link FDFAnnotationFileAttachment#FDFAnnotationFileAttachment()}
   */
  @Test
  @DisplayName("Test new FDFAnnotationFileAttachment()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFAnnotationFileAttachment.<init>()"})
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
    assertNull(actualFdfAnnotationFileAttachment.getRectangle());
    assertNull(actualFdfAnnotationFileAttachment.getBorderEffect());
    assertNull(actualFdfAnnotationFileAttachment.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationFileAttachment.getOpacity());
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
  }
}

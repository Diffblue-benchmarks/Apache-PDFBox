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

class FDFAnnotationUnderlineDiffblueTest {
  /**
   * Test {@link FDFAnnotationUnderline#FDFAnnotationUnderline(COSDictionary)}.
   * <p>
   * Method under test: {@link FDFAnnotationUnderline#FDFAnnotationUnderline(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationUnderline(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFAnnotationUnderline.<init>(COSDictionary)"})
  void testNewFDFAnnotationUnderline() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new FDFAnnotationUnderline(a)).getCOSObject());
  }

  /**
   * Test {@link FDFAnnotationUnderline#FDFAnnotationUnderline()}.
   * <p>
   * Method under test: {@link FDFAnnotationUnderline#FDFAnnotationUnderline()}
   */
  @Test
  @DisplayName("Test new FDFAnnotationUnderline()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFAnnotationUnderline.<init>()"})
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
    assertNull(actualFdfAnnotationUnderline.getRectangle());
    assertNull(actualFdfAnnotationUnderline.getBorderEffect());
    assertNull(actualFdfAnnotationUnderline.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationUnderline.getOpacity());
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
  }
}

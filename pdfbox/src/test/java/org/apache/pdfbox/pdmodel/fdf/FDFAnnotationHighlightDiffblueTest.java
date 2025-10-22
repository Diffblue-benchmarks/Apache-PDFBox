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

class FDFAnnotationHighlightDiffblueTest {
  /**
   * Test {@link FDFAnnotationHighlight#FDFAnnotationHighlight(COSDictionary)}.
   * <p>
   * Method under test: {@link FDFAnnotationHighlight#FDFAnnotationHighlight(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationHighlight(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFAnnotationHighlight.<init>(COSDictionary)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFAnnotationHighlight.<init>()"})
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
    assertNull(actualFdfAnnotationHighlight.getRectangle());
    assertNull(actualFdfAnnotationHighlight.getBorderEffect());
    assertNull(actualFdfAnnotationHighlight.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationHighlight.getOpacity());
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
  }
}

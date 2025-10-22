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

class FDFAnnotationLinkDiffblueTest {
  /**
   * Test {@link FDFAnnotationLink#FDFAnnotationLink(COSDictionary)}.
   * <p>
   * Method under test: {@link FDFAnnotationLink#FDFAnnotationLink(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationLink(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFAnnotationLink.<init>(COSDictionary)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFAnnotationLink.<init>()"})
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
    assertNull(actualFdfAnnotationLink.getRectangle());
    assertNull(actualFdfAnnotationLink.getBorderEffect());
    assertNull(actualFdfAnnotationLink.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationLink.getOpacity());
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
  }
}

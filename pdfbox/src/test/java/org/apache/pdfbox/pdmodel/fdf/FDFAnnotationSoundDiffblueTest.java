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

class FDFAnnotationSoundDiffblueTest {
  /**
   * Test {@link FDFAnnotationSound#FDFAnnotationSound(COSDictionary)}.
   * <p>
   * Method under test: {@link FDFAnnotationSound#FDFAnnotationSound(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationSound(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFAnnotationSound.<init>(COSDictionary)"})
  void testNewFDFAnnotationSound() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new FDFAnnotationSound(a)).getCOSObject());
  }

  /**
   * Test {@link FDFAnnotationSound#FDFAnnotationSound()}.
   * <p>
   * Method under test: {@link FDFAnnotationSound#FDFAnnotationSound()}
   */
  @Test
  @DisplayName("Test new FDFAnnotationSound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFAnnotationSound.<init>()"})
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
    assertNull(actualFdfAnnotationSound.getRectangle());
    assertNull(actualFdfAnnotationSound.getBorderEffect());
    assertNull(actualFdfAnnotationSound.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationSound.getOpacity());
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
  }
}

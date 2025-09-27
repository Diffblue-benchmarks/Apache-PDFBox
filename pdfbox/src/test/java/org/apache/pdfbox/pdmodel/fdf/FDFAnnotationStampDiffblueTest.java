package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

class FDFAnnotationStampDiffblueTest {
  /**
   * Test {@link FDFAnnotationStamp#FDFAnnotationStamp()}.
   *
   * <p>Method under test: {@link FDFAnnotationStamp#FDFAnnotationStamp()}
   */
  @Test
  @DisplayName("Test new FDFAnnotationStamp()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationStamp.<init>()"})
  void testNewFDFAnnotationStamp() throws IOException {
    // Arrange and Act
    FDFAnnotationStamp actualFdfAnnotationStamp = new FDFAnnotationStamp();

    // Assert
    assertEquals("", actualFdfAnnotationStamp.getRichContents());
    assertNull(actualFdfAnnotationStamp.getColor());
    assertNull(actualFdfAnnotationStamp.getPage());
    assertNull(actualFdfAnnotationStamp.getContents());
    assertNull(actualFdfAnnotationStamp.getDate());
    assertNull(actualFdfAnnotationStamp.getIntent());
    assertNull(actualFdfAnnotationStamp.getName());
    assertNull(actualFdfAnnotationStamp.getSubject());
    assertNull(actualFdfAnnotationStamp.getTitle());
    assertNull(actualFdfAnnotationStamp.getCreationDate());
    assertNull(actualFdfAnnotationStamp.getRectangle());
    assertNull(actualFdfAnnotationStamp.getBorderEffect());
    assertNull(actualFdfAnnotationStamp.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationStamp.getOpacity());
    assertFalse(actualFdfAnnotationStamp.isHidden());
    assertFalse(actualFdfAnnotationStamp.isInvisible());
    assertFalse(actualFdfAnnotationStamp.isLocked());
    assertFalse(actualFdfAnnotationStamp.isLockedContents());
    assertFalse(actualFdfAnnotationStamp.isNoRotate());
    assertFalse(actualFdfAnnotationStamp.isNoView());
    assertFalse(actualFdfAnnotationStamp.isNoZoom());
    assertFalse(actualFdfAnnotationStamp.isPrinted());
    assertFalse(actualFdfAnnotationStamp.isReadOnly());
    assertFalse(actualFdfAnnotationStamp.isToggleNoView());
  }

  /**
   * Test {@link FDFAnnotationStamp#FDFAnnotationStamp(Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationStamp#FDFAnnotationStamp(Element)}
   */
  @Test
  @DisplayName(
      "Test new FDFAnnotationStamp(Element); when IIOMetadataNode(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationStamp.<init>(Element)"})
  void testNewFDFAnnotationStamp_whenIIOMetadataNode_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new FDFAnnotationStamp(new IIOMetadataNode()));
  }
}

package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

class FDFAnnotationSquigglyDiffblueTest {
  /**
   * Test {@link FDFAnnotationSquiggly#FDFAnnotationSquiggly(COSDictionary)}.
   *
   * <p>Method under test: {@link FDFAnnotationSquiggly#FDFAnnotationSquiggly(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationSquiggly(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationSquiggly.<init>(COSDictionary)"})
  void testNewFDFAnnotationSquiggly() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, new FDFAnnotationSquiggly(a).getCOSObject());
  }

  /**
   * Test {@link FDFAnnotationSquiggly#FDFAnnotationSquiggly()}.
   *
   * <p>Method under test: {@link FDFAnnotationSquiggly#FDFAnnotationSquiggly()}
   */
  @Test
  @DisplayName("Test new FDFAnnotationSquiggly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationSquiggly.<init>()"})
  void testNewFDFAnnotationSquiggly2() throws IOException {
    // Arrange and Act
    FDFAnnotationSquiggly actualFdfAnnotationSquiggly = new FDFAnnotationSquiggly();

    // Assert
    assertEquals("", actualFdfAnnotationSquiggly.getRichContents());
    assertNull(actualFdfAnnotationSquiggly.getCoords());
    assertNull(actualFdfAnnotationSquiggly.getColor());
    assertNull(actualFdfAnnotationSquiggly.getPage());
    assertNull(actualFdfAnnotationSquiggly.getContents());
    assertNull(actualFdfAnnotationSquiggly.getDate());
    assertNull(actualFdfAnnotationSquiggly.getIntent());
    assertNull(actualFdfAnnotationSquiggly.getName());
    assertNull(actualFdfAnnotationSquiggly.getSubject());
    assertNull(actualFdfAnnotationSquiggly.getTitle());
    assertNull(actualFdfAnnotationSquiggly.getCreationDate());
    assertNull(actualFdfAnnotationSquiggly.getRectangle());
    assertNull(actualFdfAnnotationSquiggly.getBorderEffect());
    assertNull(actualFdfAnnotationSquiggly.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationSquiggly.getOpacity());
    assertFalse(actualFdfAnnotationSquiggly.isHidden());
    assertFalse(actualFdfAnnotationSquiggly.isInvisible());
    assertFalse(actualFdfAnnotationSquiggly.isLocked());
    assertFalse(actualFdfAnnotationSquiggly.isLockedContents());
    assertFalse(actualFdfAnnotationSquiggly.isNoRotate());
    assertFalse(actualFdfAnnotationSquiggly.isNoView());
    assertFalse(actualFdfAnnotationSquiggly.isNoZoom());
    assertFalse(actualFdfAnnotationSquiggly.isPrinted());
    assertFalse(actualFdfAnnotationSquiggly.isReadOnly());
    assertFalse(actualFdfAnnotationSquiggly.isToggleNoView());
  }

  /**
   * Test {@link FDFAnnotationSquiggly#FDFAnnotationSquiggly(Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationSquiggly#FDFAnnotationSquiggly(Element)}
   */
  @Test
  @DisplayName(
      "Test new FDFAnnotationSquiggly(Element); when IIOMetadataNode(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationSquiggly.<init>(Element)"})
  void testNewFDFAnnotationSquiggly_whenIIOMetadataNode_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new FDFAnnotationSquiggly(new IIOMetadataNode()));
  }
}

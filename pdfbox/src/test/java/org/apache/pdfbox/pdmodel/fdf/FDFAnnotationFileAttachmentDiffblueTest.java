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

class FDFAnnotationFileAttachmentDiffblueTest {
  /**
   * Test {@link FDFAnnotationFileAttachment#FDFAnnotationFileAttachment(COSDictionary)}.
   *
   * <p>Method under test: {@link
   * FDFAnnotationFileAttachment#FDFAnnotationFileAttachment(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationFileAttachment(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationFileAttachment.<init>(COSDictionary)"})
  void testNewFDFAnnotationFileAttachment() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, new FDFAnnotationFileAttachment(a).getCOSObject());
  }

  /**
   * Test {@link FDFAnnotationFileAttachment#FDFAnnotationFileAttachment()}.
   *
   * <p>Method under test: {@link FDFAnnotationFileAttachment#FDFAnnotationFileAttachment()}
   */
  @Test
  @DisplayName("Test new FDFAnnotationFileAttachment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationFileAttachment.<init>()"})
  void testNewFDFAnnotationFileAttachment2() throws IOException {
    // Arrange and Act
    FDFAnnotationFileAttachment actualFdfAnnotationFileAttachment =
        new FDFAnnotationFileAttachment();

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

  /**
   * Test {@link FDFAnnotationFileAttachment#FDFAnnotationFileAttachment(Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFileAttachment#FDFAnnotationFileAttachment(Element)}
   */
  @Test
  @DisplayName(
      "Test new FDFAnnotationFileAttachment(Element); when IIOMetadataNode(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationFileAttachment.<init>(Element)"})
  void testNewFDFAnnotationFileAttachment_whenIIOMetadataNode_thenThrowIOException()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new FDFAnnotationFileAttachment(new IIOMetadataNode()));
  }
}

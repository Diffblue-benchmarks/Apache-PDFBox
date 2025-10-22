package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDAppearanceStreamDiffblueTest {
  /**
   * Test {@link PDAppearanceStream#PDAppearanceStream(COSStream)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return Resources is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceStream#PDAppearanceStream(COSStream)}
   */
  @Test
  @DisplayName("Test new PDAppearanceStream(COSStream); when COSStream(); then return Resources is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAppearanceStream.<init>(COSStream)"})
  void testNewPDAppearanceStream_whenCOSStream_thenReturnResourcesIsNull() {
    // Arrange
    COSStream stream = new COSStream();

    // Act
    PDAppearanceStream actualPdAppearanceStream = new PDAppearanceStream(stream);

    // Assert
    assertNull(actualPdAppearanceStream.getResources());
    assertNull(actualPdAppearanceStream.getBBox());
    assertNull(actualPdAppearanceStream.getOptionalContent());
    assertNull(actualPdAppearanceStream.getGroup());
    assertEquals(-1, actualPdAppearanceStream.getStructParents());
    assertEquals(1, actualPdAppearanceStream.getFormType());
    assertEquals(3, stream.size());
    assertSame(stream, actualPdAppearanceStream.getCOSObject());
  }

  /**
   * Test {@link PDAppearanceStream#PDAppearanceStream(PDDocument)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return Resources is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceStream#PDAppearanceStream(PDDocument)}
   */
  @Test
  @DisplayName("Test new PDAppearanceStream(PDDocument); when PDDocument(); then return Resources is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAppearanceStream.<init>(PDDocument)"})
  void testNewPDAppearanceStream_whenPDDocument_thenReturnResourcesIsNull() {
    // Arrange and Act
    PDAppearanceStream actualPdAppearanceStream = new PDAppearanceStream(new PDDocument());

    // Assert
    assertNull(actualPdAppearanceStream.getResources());
    assertNull(actualPdAppearanceStream.getBBox());
    assertNull(actualPdAppearanceStream.getOptionalContent());
    assertNull(actualPdAppearanceStream.getGroup());
    assertEquals(-1, actualPdAppearanceStream.getStructParents());
    assertEquals(1, actualPdAppearanceStream.getFormType());
  }
}

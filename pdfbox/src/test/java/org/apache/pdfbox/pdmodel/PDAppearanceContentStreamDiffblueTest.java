package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDAppearanceContentStreamDiffblueTest {
  /**
   * Test {@link PDAppearanceContentStream#PDAppearanceContentStream(PDAppearanceStream, boolean)}.
   *
   * <p>Method under test: {@link
   * PDAppearanceContentStream#PDAppearanceContentStream(PDAppearanceStream, boolean)}
   */
  @Test
  @DisplayName("Test new PDAppearanceContentStream(PDAppearanceStream, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.<init>(PDAppearanceStream, boolean)"})
  void testNewPDAppearanceContentStream() throws IOException {
    // Arrange
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());

    // Act
    new PDAppearanceContentStream(appearance, true);

    // Assert
    COSStream cOSObject = appearance.getCOSObject();
    COSBase filters = cOSObject.getFilters();
    assertTrue(filters instanceof COSName);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    assertNull(filters.getKey());
    List<COSName> filters2 = appearance.getContentStream().getFilters();
    assertEquals(1, filters2.size());
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(((COSName) filters).isEmpty());
    assertTrue(filters.isDirect());
    assertEquals(filters2, appearance.getStream().getFilters());
    assertSame(filters, filters2.get(0));
  }

  /**
   * Test {@link PDAppearanceContentStream#PDAppearanceContentStream(PDAppearanceStream, boolean)}.
   *
   * <p>Method under test: {@link
   * PDAppearanceContentStream#PDAppearanceContentStream(PDAppearanceStream, boolean)}
   */
  @Test
  @DisplayName("Test new PDAppearanceContentStream(PDAppearanceStream, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.<init>(PDAppearanceStream, boolean)"})
  void testNewPDAppearanceContentStream2() throws IOException {
    // Arrange
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());

    // Act
    new PDAppearanceContentStream(appearance, false);

    // Assert that nothing has changed
    COSStream cOSObject = appearance.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAppearanceContentStream#PDAppearanceContentStream(PDAppearanceStream)}.
   *
   * <ul>
   *   <li>Then return {@link PDAbstractContentStream#document} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PDAppearanceContentStream#PDAppearanceContentStream(PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test new PDAppearanceContentStream(PDAppearanceStream); then return document is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.<init>(PDAppearanceStream)"})
  void testNewPDAppearanceContentStream_thenReturnDocumentIsNull() throws IOException {
    // Arrange
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());

    // Act
    PDAppearanceContentStream actualPdAppearanceContentStream =
        new PDAppearanceContentStream(appearance);

    // Assert
    assertNull(actualPdAppearanceContentStream.document);
    assertNull(actualPdAppearanceContentStream.resources);
    assertFalse(actualPdAppearanceContentStream.inTextMode);
    assertTrue(actualPdAppearanceContentStream.fontStack.isEmpty());
    assertTrue(actualPdAppearanceContentStream.nonStrokingColorSpaceStack.isEmpty());
    assertTrue(actualPdAppearanceContentStream.strokingColorSpaceStack.isEmpty());
    assertTrue(appearance.getCOSObject().hasData());
  }
}

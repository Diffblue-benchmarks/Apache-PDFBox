package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.junit.jupiter.api.Test;

class PDAppearanceContentStreamDiffblueTest {
  /**
   * Method under test:
   * {@link PDAppearanceContentStream#PDAppearanceContentStream(PDAppearanceStream)}
   */
  @Test
  void testNewPDAppearanceContentStream() throws IOException {
    // Arrange
    COSStream stream = new COSStream();
    PDAppearanceStream appearance = new PDAppearanceStream(stream);

    // Act
    PDAppearanceContentStream actualPdAppearanceContentStream = new PDAppearanceContentStream(appearance);

    // Assert
    assertNull(actualPdAppearanceContentStream.document);
    assertNull(actualPdAppearanceContentStream.resources);
    assertFalse(actualPdAppearanceContentStream.inTextMode);
    assertTrue(actualPdAppearanceContentStream.fontStack.isEmpty());
    assertTrue(actualPdAppearanceContentStream.nonStrokingColorSpaceStack.isEmpty());
    assertTrue(actualPdAppearanceContentStream.strokingColorSpaceStack.isEmpty());
    COSStream cOSObject = appearance.getCOSObject();
    assertTrue(cOSObject.hasData());
    assertSame(stream, cOSObject);
  }

  /**
   * Method under test:
   * {@link PDAppearanceContentStream#PDAppearanceContentStream(PDAppearanceStream, boolean)}
   */
  @Test
  void testNewPDAppearanceContentStream2() throws IOException {
    // Arrange
    COSStream stream = new COSStream();
    PDAppearanceStream appearance = new PDAppearanceStream(stream);

    // Act
    PDAppearanceContentStream actualPdAppearanceContentStream = new PDAppearanceContentStream(appearance, true);

    // Assert
    assertNull(actualPdAppearanceContentStream.document);
    assertNull(actualPdAppearanceContentStream.resources);
    assertEquals(1, appearance.getStream().getFilters().size());
    assertEquals(1, appearance.getContentStream().getFilters().size());
    assertFalse(actualPdAppearanceContentStream.inTextMode);
    assertTrue(actualPdAppearanceContentStream.fontStack.isEmpty());
    assertTrue(actualPdAppearanceContentStream.nonStrokingColorSpaceStack.isEmpty());
    assertTrue(actualPdAppearanceContentStream.strokingColorSpaceStack.isEmpty());
    assertSame(stream, appearance.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceContentStream#PDAppearanceContentStream(PDAppearanceStream, boolean)}
   */
  @Test
  void testNewPDAppearanceContentStream3() throws IOException {
    // Arrange
    COSStream stream = new COSStream();
    PDAppearanceStream appearance = new PDAppearanceStream(stream);

    // Act
    PDAppearanceContentStream actualPdAppearanceContentStream = new PDAppearanceContentStream(appearance, false);

    // Assert
    assertNull(actualPdAppearanceContentStream.document);
    assertNull(actualPdAppearanceContentStream.resources);
    assertFalse(actualPdAppearanceContentStream.inTextMode);
    assertTrue(actualPdAppearanceContentStream.fontStack.isEmpty());
    assertTrue(actualPdAppearanceContentStream.nonStrokingColorSpaceStack.isEmpty());
    assertTrue(actualPdAppearanceContentStream.strokingColorSpaceStack.isEmpty());
    assertSame(stream, appearance.getCOSObject());
  }
}

package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDFormContentStreamDiffblueTest {
  /**
   * Test {@link PDFormContentStream#PDFormContentStream(PDFormXObject)}.
   * <ul>
   *   <li>Then return {@link PDAbstractContentStream#document} is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFormContentStream#PDFormContentStream(PDFormXObject)}
   */
  @Test
  @DisplayName("Test new PDFormContentStream(PDFormXObject); then return document is 'null'")
  void testNewPDFormContentStream_thenReturnDocumentIsNull() throws IOException {
    // Arrange
    PDFormXObject form = new PDFormXObject(new COSStream());

    // Act
    PDFormContentStream actualPdFormContentStream = new PDFormContentStream(form);

    // Assert
    assertNull(actualPdFormContentStream.document);
    assertNull(actualPdFormContentStream.resources);
    assertFalse(actualPdFormContentStream.inTextMode);
    assertTrue(actualPdFormContentStream.fontStack.isEmpty());
    assertTrue(actualPdFormContentStream.nonStrokingColorSpaceStack.isEmpty());
    assertTrue(actualPdFormContentStream.strokingColorSpaceStack.isEmpty());
    assertTrue(form.getCOSObject().hasData());
  }
}

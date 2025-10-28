package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.junit.jupiter.api.Test;

class PDFormContentStreamDiffblueTest {
  /**
   * Method under test:
   * {@link PDFormContentStream#PDFormContentStream(PDFormXObject)}
   */
  @Test
  void testNewPDFormContentStream() throws IOException {
    // Arrange
    COSStream stream = new COSStream();
    PDFormXObject form = new PDFormXObject(stream);

    // Act
    PDFormContentStream actualPdFormContentStream = new PDFormContentStream(form);

    // Assert
    assertNull(actualPdFormContentStream.document);
    assertNull(actualPdFormContentStream.resources);
    assertFalse(actualPdFormContentStream.inTextMode);
    assertTrue(actualPdFormContentStream.fontStack.isEmpty());
    assertTrue(actualPdFormContentStream.nonStrokingColorSpaceStack.isEmpty());
    assertTrue(actualPdFormContentStream.strokingColorSpaceStack.isEmpty());
    COSStream cOSObject = form.getCOSObject();
    assertTrue(cOSObject.hasData());
    assertSame(stream, cOSObject);
  }
}

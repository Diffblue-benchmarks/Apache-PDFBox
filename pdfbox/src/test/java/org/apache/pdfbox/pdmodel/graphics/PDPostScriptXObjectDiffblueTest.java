package org.apache.pdfbox.pdmodel.graphics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.Test;

class PDPostScriptXObjectDiffblueTest {
  /**
   * Method under test: {@link PDPostScriptXObject#PDPostScriptXObject(COSStream)}
   */
  @Test
  void testNewPDPostScriptXObject() throws IOException {
    // Arrange
    COSStream stream = new COSStream();

    // Act
    PDPostScriptXObject actualPdPostScriptXObject = new PDPostScriptXObject(stream);

    // Assert
    PDStream stream2 = actualPdPostScriptXObject.getStream();
    assertNull(stream2.getDecodeParms());
    assertNull(stream2.getFileDecodeParams());
    assertNull(stream2.getMetadata());
    assertNull(stream2.getFile());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(0, stream2.getLength());
    assertEquals(3, stream.size());
    List<String> fileFilters = stream2.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(stream, stream2.getCOSObject());
    assertSame(stream, actualPdPostScriptXObject.getCOSObject());
    assertSame(fileFilters, stream2.getFilters());
  }
}

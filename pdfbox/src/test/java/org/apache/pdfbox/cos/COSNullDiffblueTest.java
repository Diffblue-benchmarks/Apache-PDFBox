package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class COSNullDiffblueTest {
  /**
   * Method under test: {@link COSNull#accept(ICOSVisitor)}
   */
  @Test
  void testAccept() throws IOException {
    // Arrange
    COSWriter visitor = mock(COSWriter.class);
    doNothing().when(visitor).visitFromNull(Mockito.<COSNull>any());

    // Act
    COSNull.NULL.accept(visitor);

    // Assert that nothing has changed
    verify(visitor).visitFromNull(isA(COSNull.class));
  }

  /**
   * Method under test: {@link COSNull#writePDF(OutputStream)}
   */
  @Test
  void testWritePDF() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSNull.NULL.writePDF(output);

    // Assert that nothing has changed
    byte[] expectedToByteArrayResult = "null".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Method under test: {@link COSNull#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("COSNull{}", COSNull.NULL.toString());
  }
}

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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class COSNullDiffblueTest {
  /**
   * Test {@link COSNull#accept(ICOSVisitor)}.
   * <ul>
   *   <li>When {@link COSWriter} {@link COSWriter#visitFromNull(COSNull)} does
   * nothing.</li>
   *   <li>Then calls {@link COSWriter#visitFromNull(COSNull)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSNull#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName("Test accept(ICOSVisitor); when COSWriter visitFromNull(COSNull) does nothing; then calls visitFromNull(COSNull)")
  void testAccept_whenCOSWriterVisitFromNullDoesNothing_thenCallsVisitFromNull() throws IOException {
    // Arrange
    COSWriter visitor = mock(COSWriter.class);
    doNothing().when(visitor).visitFromNull(Mockito.<COSNull>any());

    // Act
    COSNull.NULL.accept(visitor);

    // Assert that nothing has changed
    verify(visitor).visitFromNull(isA(COSNull.class));
  }

  /**
   * Test {@link COSNull#writePDF(OutputStream)}.
   * <ul>
   *   <li>Then {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with one
   * toByteArray is {@code null} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSNull#writePDF(OutputStream)}
   */
  @Test
  @DisplayName("Test writePDF(OutputStream); then ByteArrayOutputStream(int) with one toByteArray is 'null' Bytes is 'UTF-8'")
  void testWritePDF_thenByteArrayOutputStreamWithOneToByteArrayIsNullBytesIsUtf8() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSNull.NULL.writePDF(output);

    // Assert that nothing has changed
    byte[] expectedToByteArrayResult = "null".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link COSNull#toString()}.
   * <p>
   * Method under test: {@link COSNull#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("COSNull{}", COSNull.NULL.toString());
  }
}

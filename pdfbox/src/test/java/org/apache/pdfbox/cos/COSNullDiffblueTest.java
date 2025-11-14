package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class COSNullDiffblueTest {
  /**
   * Test {@link COSNull#accept(ICOSVisitor)}.
   *
   * <ul>
   *   <li>When {@link COSWriter} {@link COSWriter#visitFromNull(COSNull)} does nothing.
   *   <li>Then calls {@link COSWriter#visitFromNull(COSNull)}.
   * </ul>
   *
   * <p>Method under test: {@link COSNull#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(ICOSVisitor); when COSWriter visitFromNull(COSNull) does nothing; then calls visitFromNull(COSNull)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSNull.accept(ICOSVisitor)"})
  void testAccept_whenCOSWriterVisitFromNullDoesNothing_thenCallsVisitFromNull()
      throws IOException {
    // Arrange
    COSWriter visitor = mock(COSWriter.class);
    doNothing().when(visitor).visitFromNull(Mockito.<COSNull>any());

    // Act
    COSNull.NULL.accept(visitor);

    // Assert
    verify(visitor).visitFromNull(isA(COSNull.class));
  }

  /**
   * Test {@link COSNull#writePDF(OutputStream)}.
   *
   * <ul>
   *   <li>Then {@link ByteArrayOutputStream#ByteArrayOutputStream()} toByteArray is {@code null}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link COSNull#writePDF(OutputStream)}
   */
  @Test
  @DisplayName(
      "Test writePDF(OutputStream); then ByteArrayOutputStream() toByteArray is 'null' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSNull.writePDF(OutputStream)"})
  void testWritePDF_thenByteArrayOutputStreamToByteArrayIsNullBytesIsUtf8() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    COSNull.NULL.writePDF(output);

    // Assert
    byte[] expectedToByteArrayResult = "null".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link COSNull#toString()}.
   *
   * <p>Method under test: {@link COSNull#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String COSNull.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("COSNull{}", COSNull.NULL.toString());
  }
}

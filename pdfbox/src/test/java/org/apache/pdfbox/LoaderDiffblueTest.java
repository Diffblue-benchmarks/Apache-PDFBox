package org.apache.pdfbox;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LoaderDiffblueTest {
  /**
   * Test {@link Loader#loadFDF(InputStream)} with {@code input}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link Loader#loadFDF(InputStream)}
   */
  @Test
  @DisplayName(
      "Test loadFDF(InputStream) with 'input'; given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.fdf.FDFDocument Loader.loadFDF(InputStream)"})
  void testLoadFDFWithInput_givenIOException_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any())).thenThrow(new IOException());
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Loader.loadFDF(input));
    verify(input).read(isA(byte[].class));
    verify(input, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
  }

  /**
   * Test {@link Loader#loadXFDF(InputStream)} with {@code input}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link Loader#loadXFDF(InputStream)}
   */
  @Test
  @DisplayName(
      "Test loadXFDF(InputStream) with 'input'; given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.fdf.FDFDocument Loader.loadXFDF(InputStream)"})
  void testLoadXFDFWithInput_givenIOException_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read()).thenThrow(new IOException());

    // Act and Assert
    assertThrows(IOException.class, () -> Loader.loadXFDF(input));
    verify(input).read();
  }
}

package org.apache.pdfbox.examples.signature;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class CreateSignedTimeStampDiffblueTest {
  /**
   * Test {@link CreateSignedTimeStamp#signDetached(File)} with {@code file}.
   *
   * <ul>
   *   <li>Then throw {@link FileNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link CreateSignedTimeStamp#signDetached(File)}
   */
  @Test
  @DisplayName("Test signDetached(File) with 'file'; then throw FileNotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CreateSignedTimeStamp.signDetached(File)"})
  void testSignDetachedWithFile_thenThrowFileNotFoundException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        FileNotFoundException.class,
        () ->
            new CreateSignedTimeStamp("https://example.org/example")
                .signDetached(Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile()));
  }

  /**
   * Test {@link CreateSignedTimeStamp#signDetached(File, File)} with {@code inFile}, {@code
   * outFile}.
   *
   * <ul>
   *   <li>Then throw {@link FileNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link CreateSignedTimeStamp#signDetached(File, File)}
   */
  @Test
  @DisplayName(
      "Test signDetached(File, File) with 'inFile', 'outFile'; then throw FileNotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CreateSignedTimeStamp.signDetached(File, File)"})
  void testSignDetachedWithInFileOutFile_thenThrowFileNotFoundException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        FileNotFoundException.class,
        () ->
            new CreateSignedTimeStamp("https://example.org/example")
                .signDetached(
                    Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile(),
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
  }

  /**
   * Test {@link CreateSignedTimeStamp#sign(InputStream)}.
   *
   * <ul>
   *   <li>Given {@link CreateSignedTimeStamp#CreateSignedTimeStamp(String)} with {@code Tsa Url}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link CreateSignedTimeStamp#sign(InputStream)}
   */
  @Test
  @DisplayName(
      "Test sign(InputStream); given CreateSignedTimeStamp(String) with 'Tsa Url'; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] CreateSignedTimeStamp.sign(InputStream)"})
  void testSign_givenCreateSignedTimeStampWithTsaUrl_thenReturnEmptyArrayOfByte()
      throws IOException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress.when(InetAddress::getLocalHost).thenReturn(mock(InetAddress.class));
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(mock(InetAddress.class));
      CreateSignedTimeStamp createSignedTimeStamp = new CreateSignedTimeStamp("Tsa Url");

      // Act
      byte[] actualSignResult =
          createSignedTimeStamp.sign(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

      // Assert
      assertArrayEquals(new byte[] {}, actualSignResult);
    }
  }

  /**
   * Test {@link CreateSignedTimeStamp#sign(InputStream)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link CreateSignedTimeStamp#sign(InputStream)}
   */
  @Test
  @DisplayName("Test sign(InputStream); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] CreateSignedTimeStamp.sign(InputStream)"})
  void testSign_thenThrowIllegalStateException() throws IOException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenThrow(new IllegalStateException());
      CreateSignedTimeStamp createSignedTimeStamp =
          new CreateSignedTimeStamp("https://example.org/example");

      // Act and Assert
      assertThrows(
          IllegalStateException.class,
          () -> createSignedTimeStamp.sign(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
    }
  }
}

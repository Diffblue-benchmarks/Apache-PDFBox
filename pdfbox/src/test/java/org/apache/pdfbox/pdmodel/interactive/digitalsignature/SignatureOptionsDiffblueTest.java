package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SignatureOptionsDiffblueTest {
  @Mock private COSDocument cOSDocument;

  @Mock private RandomAccessRead randomAccessRead;

  @InjectMocks private SignatureOptions signatureOptions;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SignatureOptions}
   *   <li>{@link SignatureOptions#setPage(int)}
   *   <li>{@link SignatureOptions#getPage()}
   *   <li>{@link SignatureOptions#getPreferredSignatureSize()}
   *   <li>{@link SignatureOptions#getVisualSignature()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SignatureOptions.<init>()",
    "int SignatureOptions.getPage()",
    "int SignatureOptions.getPreferredSignatureSize()",
    "COSDocument SignatureOptions.getVisualSignature()",
    "void SignatureOptions.setPage(int)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SignatureOptions actualSignatureOptions = new SignatureOptions();
    actualSignatureOptions.setPage(1);
    int actualPage = actualSignatureOptions.getPage();
    int actualPreferredSignatureSize = actualSignatureOptions.getPreferredSignatureSize();

    // Assert
    assertNull(actualSignatureOptions.getVisualSignature());
    assertEquals(0, actualPreferredSignatureSize);
    assertEquals(1, actualPage);
  }

  /**
   * Test {@link SignatureOptions#setPreferredSignatureSize(int)}.
   *
   * <ul>
   *   <li>Then {@link SignatureOptions} (default constructor) PreferredSignatureSize is three.
   * </ul>
   *
   * <p>Method under test: {@link SignatureOptions#setPreferredSignatureSize(int)}
   */
  @Test
  @DisplayName(
      "Test setPreferredSignatureSize(int); then SignatureOptions (default constructor) PreferredSignatureSize is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SignatureOptions.setPreferredSignatureSize(int)"})
  void testSetPreferredSignatureSize_thenSignatureOptionsPreferredSignatureSizeIsThree() {
    // Arrange
    SignatureOptions signatureOptions = new SignatureOptions();

    // Act
    signatureOptions.setPreferredSignatureSize(3);

    // Assert
    assertEquals(3, signatureOptions.getPreferredSignatureSize());
  }

  /**
   * Test {@link SignatureOptions#setPreferredSignatureSize(int)}.
   *
   * <ul>
   *   <li>Then {@link SignatureOptions} (default constructor) PreferredSignatureSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link SignatureOptions#setPreferredSignatureSize(int)}
   */
  @Test
  @DisplayName(
      "Test setPreferredSignatureSize(int); then SignatureOptions (default constructor) PreferredSignatureSize is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SignatureOptions.setPreferredSignatureSize(int)"})
  void testSetPreferredSignatureSize_thenSignatureOptionsPreferredSignatureSizeIsZero() {
    // Arrange
    SignatureOptions signatureOptions = new SignatureOptions();

    // Act
    signatureOptions.setPreferredSignatureSize(0);

    // Assert that nothing has changed
    assertEquals(0, signatureOptions.getPreferredSignatureSize());
  }

  /**
   * Test {@link SignatureOptions#close()}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessRead} {@link RandomAccessRead#close()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link SignatureOptions#close()}
   */
  @Test
  @DisplayName("Test close(); given RandomAccessRead close() does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SignatureOptions.close()"})
  void testClose_givenRandomAccessReadCloseDoesNothing() throws IOException {
    // Arrange
    doNothing().when(randomAccessRead).close();
    doNothing().when(cOSDocument).close();

    // Act
    signatureOptions.close();

    // Assert
    verify(randomAccessRead).close();
    verify(cOSDocument).close();
  }

  /**
   * Test {@link SignatureOptions#close()}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessRead} {@link RandomAccessRead#close()} does nothing.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link SignatureOptions#close()}
   */
  @Test
  @DisplayName("Test close(); given RandomAccessRead close() does nothing; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SignatureOptions.close()"})
  void testClose_givenRandomAccessReadCloseDoesNothing_thenThrowIOException() throws IOException {
    // Arrange
    doNothing().when(randomAccessRead).close();
    doThrow(new IOException()).when(cOSDocument).close();

    // Act and Assert
    assertThrows(IOException.class, () -> signatureOptions.close());
    verify(randomAccessRead).close();
    verify(cOSDocument).close();
  }

  /**
   * Test {@link SignatureOptions#close()}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessRead} {@link RandomAccessRead#close()} throw {@link
   *       IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link SignatureOptions#close()}
   */
  @Test
  @DisplayName(
      "Test close(); given RandomAccessRead close() throw IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SignatureOptions.close()"})
  void testClose_givenRandomAccessReadCloseThrowIOException_thenThrowIOException()
      throws IOException {
    // Arrange
    doThrow(new IOException()).when(randomAccessRead).close();
    doNothing().when(cOSDocument).close();

    // Act and Assert
    assertThrows(IOException.class, () -> signatureOptions.close());
    verify(randomAccessRead).close();
    verify(cOSDocument).close();
  }

  /**
   * Test {@link SignatureOptions#close()}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessRead} {@link RandomAccessRead#close()} throw {@link
   *       IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link SignatureOptions#close()}
   */
  @Test
  @DisplayName(
      "Test close(); given RandomAccessRead close() throw IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SignatureOptions.close()"})
  void testClose_givenRandomAccessReadCloseThrowIOException_thenThrowIOException2()
      throws IOException {
    // Arrange
    doThrow(new IOException()).when(randomAccessRead).close();
    doThrow(new IOException()).when(cOSDocument).close();

    // Act and Assert
    assertThrows(IOException.class, () -> signatureOptions.close());
    verify(randomAccessRead).close();
    verify(cOSDocument).close();
  }
}

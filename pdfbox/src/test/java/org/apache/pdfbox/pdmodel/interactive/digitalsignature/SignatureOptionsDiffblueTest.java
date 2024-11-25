package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SignatureOptionsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  void testGettersAndSetters() {
    // Arrange and Act
    SignatureOptions actualSignatureOptions = new SignatureOptions();
    actualSignatureOptions.setPage(1);
    int actualPage = actualSignatureOptions.getPage();
    int actualPreferredSignatureSize = actualSignatureOptions.getPreferredSignatureSize();
    actualSignatureOptions.getVisualSignature();

    // Assert that nothing has changed
    assertEquals(0, actualPreferredSignatureSize);
    assertEquals(1, actualPage);
  }

  /**
   * Test {@link SignatureOptions#setPreferredSignatureSize(int)}.
   * <ul>
   *   <li>Then {@link SignatureOptions} (default constructor)
   * PreferredSignatureSize is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link SignatureOptions#setPreferredSignatureSize(int)}
   */
  @Test
  @DisplayName("Test setPreferredSignatureSize(int); then SignatureOptions (default constructor) PreferredSignatureSize is three")
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
   * <ul>
   *   <li>Then {@link SignatureOptions} (default constructor)
   * PreferredSignatureSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SignatureOptions#setPreferredSignatureSize(int)}
   */
  @Test
  @DisplayName("Test setPreferredSignatureSize(int); then SignatureOptions (default constructor) PreferredSignatureSize is zero")
  void testSetPreferredSignatureSize_thenSignatureOptionsPreferredSignatureSizeIsZero() {
    // Arrange
    SignatureOptions signatureOptions = new SignatureOptions();

    // Act
    signatureOptions.setPreferredSignatureSize(0);

    // Assert that nothing has changed
    assertEquals(0, signatureOptions.getPreferredSignatureSize());
  }
}

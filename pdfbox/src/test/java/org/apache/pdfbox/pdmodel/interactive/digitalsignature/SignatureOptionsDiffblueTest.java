package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SignatureOptionsDiffblueTest {
  /**
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
   * Method under test: {@link SignatureOptions#setPreferredSignatureSize(int)}
   */
  @Test
  void testSetPreferredSignatureSize() {
    // Arrange
    SignatureOptions signatureOptions = new SignatureOptions();

    // Act
    signatureOptions.setPreferredSignatureSize(3);

    // Assert
    assertEquals(3, signatureOptions.getPreferredSignatureSize());
  }

  /**
   * Method under test: {@link SignatureOptions#setPreferredSignatureSize(int)}
   */
  @Test
  void testSetPreferredSignatureSize2() {
    // Arrange
    SignatureOptions signatureOptions = new SignatureOptions();

    // Act
    signatureOptions.setPreferredSignatureSize(0);

    // Assert that nothing has changed
    assertEquals(0, signatureOptions.getPreferredSignatureSize());
  }
}

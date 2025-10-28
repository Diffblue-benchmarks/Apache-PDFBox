package org.apache.pdfbox.examples.signature.cert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class CertificateVerificationExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link CertificateVerificationException#CertificateVerificationException(String)}
   */
  @Test
  void testNewCertificateVerificationException() {
    // Arrange and Act
    CertificateVerificationException actualCertificateVerificationException = new CertificateVerificationException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualCertificateVerificationException.getMessage());
    assertNull(actualCertificateVerificationException.getCause());
    assertEquals(0, actualCertificateVerificationException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link CertificateVerificationException#CertificateVerificationException(String, Throwable)}
   */
  @Test
  void testNewCertificateVerificationException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    CertificateVerificationException actualCertificateVerificationException = new CertificateVerificationException(
        "An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualCertificateVerificationException.getMessage());
    assertEquals(0, actualCertificateVerificationException.getSuppressed().length);
    assertSame(cause, actualCertificateVerificationException.getCause());
  }
}

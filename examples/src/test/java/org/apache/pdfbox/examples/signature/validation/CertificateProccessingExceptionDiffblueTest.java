package org.apache.pdfbox.examples.signature.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class CertificateProccessingExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link CertificateProccessingException#CertificateProccessingException(Throwable)}
   */
  @Test
  void testNewCertificateProccessingException() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    CertificateProccessingException actualCertificateProccessingException = new CertificateProccessingException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualCertificateProccessingException.getMessage());
    assertEquals(0, actualCertificateProccessingException.getSuppressed().length);
    assertSame(cause, actualCertificateProccessingException.getCause());
  }
}

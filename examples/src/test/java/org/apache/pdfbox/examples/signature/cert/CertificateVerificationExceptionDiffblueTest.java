package org.apache.pdfbox.examples.signature.cert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CertificateVerificationExceptionDiffblueTest {
  /**
   * Test {@link CertificateVerificationException#CertificateVerificationException(String)}.
   *
   * <ul>
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CertificateVerificationException#CertificateVerificationException(String)}
   */
  @Test
  @DisplayName("Test new CertificateVerificationException(String); then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CertificateVerificationException.<init>(String)",
    "void CertificateVerificationException.<init>(String, Throwable)"
  })
  void testNewCertificateVerificationException_thenReturnCauseIsNull() {
    // Arrange and Act
    CertificateVerificationException actualCertificateVerificationException =
        new CertificateVerificationException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualCertificateVerificationException.getMessage());
    assertNull(actualCertificateVerificationException.getCause());
    assertEquals(0, actualCertificateVerificationException.getSuppressed().length);
  }

  /**
   * Test {@link CertificateVerificationException#CertificateVerificationException(String,
   * Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CertificateVerificationException#CertificateVerificationException(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new CertificateVerificationException(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CertificateVerificationException.<init>(String)",
    "void CertificateVerificationException.<init>(String, Throwable)"
  })
  void testNewCertificateVerificationException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    CertificateVerificationException actualCertificateVerificationException =
        new CertificateVerificationException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualCertificateVerificationException.getMessage());
    assertEquals(0, actualCertificateVerificationException.getSuppressed().length);
    assertSame(cause, actualCertificateVerificationException.getCause());
  }
}

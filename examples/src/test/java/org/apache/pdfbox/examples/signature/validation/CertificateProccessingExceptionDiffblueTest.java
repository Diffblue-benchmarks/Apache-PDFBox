package org.apache.pdfbox.examples.signature.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CertificateProccessingExceptionDiffblueTest {
  /**
   * Test {@link CertificateProccessingException#CertificateProccessingException(Throwable)}.
   *
   * <p>Method under test: {@link
   * CertificateProccessingException#CertificateProccessingException(Throwable)}
   */
  @Test
  @DisplayName("Test new CertificateProccessingException(Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CertificateProccessingException.<init>(Throwable)"})
  void testNewCertificateProccessingException() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    CertificateProccessingException actualCertificateProccessingException =
        new CertificateProccessingException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualCertificateProccessingException.getMessage());
    assertEquals(0, actualCertificateProccessingException.getSuppressed().length);
    assertSame(cause, actualCertificateProccessingException.getCause());
  }
}

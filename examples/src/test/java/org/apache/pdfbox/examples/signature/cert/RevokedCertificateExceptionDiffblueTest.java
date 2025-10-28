package org.apache.pdfbox.examples.signature.cert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.jupiter.api.Test;

class RevokedCertificateExceptionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RevokedCertificateException#RevokedCertificateException(String)}
   *   <li>{@link RevokedCertificateException#getRevocationTime()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RevokedCertificateException actualRevokedCertificateException = new RevokedCertificateException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualRevokedCertificateException.getMessage());
    assertNull(actualRevokedCertificateException.getCause());
    assertNull(actualRevokedCertificateException.getRevocationTime());
    assertEquals(0, actualRevokedCertificateException.getSuppressed().length);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RevokedCertificateException#RevokedCertificateException(String, Date)}
   *   <li>{@link RevokedCertificateException#getRevocationTime()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    Date revocationTime = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    RevokedCertificateException actualRevokedCertificateException = new RevokedCertificateException("An error occurred",
        revocationTime);
    Date actualRevocationTime = actualRevokedCertificateException.getRevocationTime();

    // Assert
    assertEquals("An error occurred", actualRevokedCertificateException.getMessage());
    assertNull(actualRevokedCertificateException.getCause());
    assertEquals(0, actualRevokedCertificateException.getSuppressed().length);
    assertSame(revocationTime, actualRevocationTime);
  }
}

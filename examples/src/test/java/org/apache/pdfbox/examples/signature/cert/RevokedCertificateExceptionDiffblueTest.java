package org.apache.pdfbox.examples.signature.cert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RevokedCertificateExceptionDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RevokedCertificateException#RevokedCertificateException(String, Date)}
   *   <li>{@link RevokedCertificateException#getRevocationTime()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RevokedCertificateException.<init>(String)",
      "void RevokedCertificateException.<init>(String, Date)", "Date RevokedCertificateException.getRevocationTime()"})
  void testGettersAndSetters() {
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

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return RevocationTime is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RevokedCertificateException#RevokedCertificateException(String)}
   *   <li>{@link RevokedCertificateException#getRevocationTime()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'An error occurred'; then return RevocationTime is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RevokedCertificateException.<init>(String)",
      "void RevokedCertificateException.<init>(String, Date)", "Date RevokedCertificateException.getRevocationTime()"})
  void testGettersAndSetters_whenAnErrorOccurred_thenReturnRevocationTimeIsNull() {
    // Arrange and Act
    RevokedCertificateException actualRevokedCertificateException = new RevokedCertificateException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualRevokedCertificateException.getMessage());
    assertNull(actualRevokedCertificateException.getCause());
    assertNull(actualRevokedCertificateException.getRevocationTime());
    assertEquals(0, actualRevokedCertificateException.getSuppressed().length);
  }
}

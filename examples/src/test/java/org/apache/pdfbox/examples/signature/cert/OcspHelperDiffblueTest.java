package org.apache.pdfbox.examples.signature.cert;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.cert.ocsp.OCSPException;
import org.bouncycastle.jce.provider.X509CertificateObject;
import org.junit.jupiter.api.Test;

class OcspHelperDiffblueTest {
  /**
   * Method under test: {@link OcspHelper#getResponseOcsp()}
   */
  @Test
  void testGetResponseOcsp()
      throws IOException, URISyntaxException, CertificateEncodingException, RevokedCertificateException, OCSPException {
    // Arrange
    X509CertificateObject issuerCertificate = mock(X509CertificateObject.class);
    when(issuerCertificate.getEncoded()).thenThrow(new CertificateEncodingException("foo"));
    X509CertificateObject checkCertificate = mock(X509CertificateObject.class);
    Date signDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(IOException.class, () -> (new OcspHelper(checkCertificate, signDate, issuerCertificate,
        new HashSet<>(), "https://example.org/example")).getResponseOcsp());
    verify(issuerCertificate).getEncoded();
  }

  /**
   * Method under test:
   * {@link OcspHelper#OcspHelper(X509Certificate, Date, X509Certificate, Set, String)}
   */
  @Test
  void testNewOcspHelper() {
    // Arrange
    X509CertificateObject checkCertificate = mock(X509CertificateObject.class);
    Date signDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    OcspHelper actualOcspHelper = new OcspHelper(checkCertificate, signDate, null, new HashSet<>(),
        "https://example.org/example");

    // Assert
    assertNull(actualOcspHelper.getOcspResponderCertificate());
    assertSame(checkCertificate, actualOcspHelper.getCertificateToCheck());
  }
}

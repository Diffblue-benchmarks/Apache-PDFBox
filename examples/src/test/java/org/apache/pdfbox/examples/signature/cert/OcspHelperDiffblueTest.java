package org.apache.pdfbox.examples.signature.cert;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.cert.CertificateEncodingException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashSet;
import org.bouncycastle.cert.ocsp.OCSPException;
import org.bouncycastle.jce.provider.X509CertificateObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OcspHelperDiffblueTest {
  /**
   * Test {@link OcspHelper#getResponseOcsp()}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OcspHelper#getResponseOcsp()}
   */
  @Test
  @DisplayName("Test getResponseOcsp(); then throw IOException")
  void testGetResponseOcsp_thenThrowIOException()
      throws IOException, URISyntaxException, CertificateEncodingException, RevokedCertificateException, OCSPException {
    // Arrange
    X509CertificateObject issuerCertificate = mock(X509CertificateObject.class);
    when(issuerCertificate.getEncoded()).thenThrow(new CertificateEncodingException("foo"));
    Date signDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(IOException.class,
        () -> (new OcspHelper(null, signDate, issuerCertificate, new HashSet<>(), "https://example.org/example"))
            .getResponseOcsp());
    verify(issuerCertificate).getEncoded();
  }
}

package org.apache.pdfbox.examples.signature.cert;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.jce.provider.X509CertificateObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CertificateVerifierDiffblueTest {
  /**
   * Test
   * {@link CertificateVerifier#verifyCertificate(X509Certificate, Set, boolean, Date)}
   * with {@code cert}, {@code additionalCerts}, {@code verifySelfSignedCert},
   * {@code signDate}.
   * <p>
   * Method under test:
   * {@link CertificateVerifier#verifyCertificate(X509Certificate, Set, boolean, Date)}
   */
  @Test
  @DisplayName("Test verifyCertificate(X509Certificate, Set, boolean, Date) with 'cert', 'additionalCerts', 'verifySelfSignedCert', 'signDate'")
  void testVerifyCertificateWithCertAdditionalCertsVerifySelfSignedCertSignDate()
      throws CertificateVerificationException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getExtensionValue(Mockito.<String>any())).thenReturn(null);
    HashSet<X509Certificate> additionalCerts = new HashSet<>();

    // Act and Assert
    assertThrows(CertificateVerificationException.class, () -> CertificateVerifier.verifyCertificate(cert,
        additionalCerts, true, Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
    verify(cert).getExtensionValue(eq("1.3.6.1.5.5.7.1.1"));
  }

  /**
   * Test
   * {@link CertificateVerifier#verifyCertificate(X509Certificate, Set, boolean, Date)}
   * with {@code cert}, {@code additionalCerts}, {@code verifySelfSignedCert},
   * {@code signDate}.
   * <p>
   * Method under test:
   * {@link CertificateVerifier#verifyCertificate(X509Certificate, Set, boolean, Date)}
   */
  @Test
  @DisplayName("Test verifyCertificate(X509Certificate, Set, boolean, Date) with 'cert', 'additionalCerts', 'verifySelfSignedCert', 'signDate'")
  void testVerifyCertificateWithCertAdditionalCertsVerifySelfSignedCertSignDate2() throws InvalidKeyException,
      NoSuchAlgorithmException, SignatureException, CertificateException, CertificateVerificationException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    doNothing().when(cert).verify(Mockito.<PublicKey>any(), Mockito.<Provider>any());
    when(cert.getPublicKey()).thenReturn(null);
    HashSet<X509Certificate> additionalCerts = new HashSet<>();

    // Act and Assert
    assertThrows(CertificateVerificationException.class, () -> CertificateVerifier.verifyCertificate(cert,
        additionalCerts, false, Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
    verify(cert).getPublicKey();
    verify(cert).verify((PublicKey) isNull(), isA(Provider.class));
  }

  /**
   * Test {@link CertificateVerifier#isSelfSigned(X509Certificate)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CertificateVerifier#isSelfSigned(X509Certificate)}
   */
  @Test
  @DisplayName("Test isSelfSigned(X509Certificate); given 'null'; then return 'true'")
  void testIsSelfSigned_givenNull_thenReturnTrue() throws GeneralSecurityException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    doNothing().when(cert).verify(Mockito.<PublicKey>any(), Mockito.<Provider>any());
    when(cert.getPublicKey()).thenReturn(null);

    // Act
    boolean actualIsSelfSignedResult = CertificateVerifier.isSelfSigned(cert);

    // Assert
    verify(cert).getPublicKey();
    verify(cert).verify((PublicKey) isNull(), isA(Provider.class));
    assertTrue(actualIsSelfSignedResult);
  }
}

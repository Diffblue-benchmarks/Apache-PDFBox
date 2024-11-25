package org.apache.pdfbox.examples.signature.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.bouncycastle.cert.X509CertificateHolder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CertInformationCollectorDiffblueTest {
  /**
   * Test
   * {@link CertInformationCollector#addAllCertsFromHolders(X509CertificateHolder[])}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CertInformationCollector#addAllCertsFromHolders(X509CertificateHolder[])}
   */
  @Test
  @DisplayName("Test addAllCertsFromHolders(X509CertificateHolder[]); given 'AXAXAXAX' Bytes is 'UTF-8'")
  void testAddAllCertsFromHolders_givenAxaxaxaxBytesIsUtf8() throws IOException, CertificateProccessingException {
    // Arrange
    CertInformationCollector certInformationCollector = new CertInformationCollector();
    X509CertificateHolder x509CertificateHolder = mock(X509CertificateHolder.class);
    when(x509CertificateHolder.getEncoded()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    certInformationCollector.addAllCertsFromHolders(new X509CertificateHolder[]{x509CertificateHolder});

    // Assert
    verify(x509CertificateHolder).getEncoded();
  }

  /**
   * Test
   * {@link CertInformationCollector#addAllCertsFromHolders(X509CertificateHolder[])}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CertInformationCollector#addAllCertsFromHolders(X509CertificateHolder[])}
   */
  @Test
  @DisplayName("Test addAllCertsFromHolders(X509CertificateHolder[]); given IOException(String) with 'foo'")
  void testAddAllCertsFromHolders_givenIOExceptionWithFoo() throws IOException, CertificateProccessingException {
    // Arrange
    CertInformationCollector certInformationCollector = new CertInformationCollector();
    X509CertificateHolder x509CertificateHolder = mock(X509CertificateHolder.class);
    when(x509CertificateHolder.getEncoded()).thenThrow(new IOException("foo"));

    // Act
    certInformationCollector.addAllCertsFromHolders(new X509CertificateHolder[]{x509CertificateHolder});

    // Assert
    verify(x509CertificateHolder).getEncoded();
  }

  /**
   * Test CertSignatureInformation getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link CertInformationCollector.CertSignatureInformation}
   *   <li>
   * {@link CertInformationCollector.CertSignatureInformation#setIssuerUrl(String)}
   *   <li>
   * {@link CertInformationCollector.CertSignatureInformation#setOcspUrl(String)}
   *   <li>
   * {@link CertInformationCollector.CertSignatureInformation#getAlternativeCertChain()}
   *   <li>{@link CertInformationCollector.CertSignatureInformation#getCertChain()}
   *   <li>
   * {@link CertInformationCollector.CertSignatureInformation#getCertificate()}
   *   <li>{@link CertInformationCollector.CertSignatureInformation#getCrlUrl()}
   *   <li>
   * {@link CertInformationCollector.CertSignatureInformation#getIssuerCertificate()}
   *   <li>{@link CertInformationCollector.CertSignatureInformation#getOcspUrl()}
   *   <li>
   * {@link CertInformationCollector.CertSignatureInformation#getSignatureHash()}
   *   <li>{@link CertInformationCollector.CertSignatureInformation#getTsaCerts()}
   *   <li>{@link CertInformationCollector.CertSignatureInformation#isSelfSigned()}
   * </ul>
   */
  @Test
  @DisplayName("Test CertSignatureInformation getters and setters")
  void testCertSignatureInformationGettersAndSetters() {
    // Arrange and Act
    CertInformationCollector.CertSignatureInformation actualCertSignatureInformation = new CertInformationCollector.CertSignatureInformation();
    actualCertSignatureInformation.setIssuerUrl("https://example.org/example");
    actualCertSignatureInformation.setOcspUrl("https://example.org/example");
    actualCertSignatureInformation.getAlternativeCertChain();
    actualCertSignatureInformation.getCertChain();
    actualCertSignatureInformation.getCertificate();
    actualCertSignatureInformation.getCrlUrl();
    actualCertSignatureInformation.getIssuerCertificate();
    String actualOcspUrl = actualCertSignatureInformation.getOcspUrl();
    actualCertSignatureInformation.getSignatureHash();
    actualCertSignatureInformation.getTsaCerts();

    // Assert that nothing has changed
    assertEquals("https://example.org/example", actualOcspUrl);
    assertFalse(actualCertSignatureInformation.isSelfSigned());
  }

  /**
   * Test {@link CertInformationCollector#getCertificateSet()}.
   * <p>
   * Method under test: {@link CertInformationCollector#getCertificateSet()}
   */
  @Test
  @DisplayName("Test getCertificateSet()")
  void testGetCertificateSet() {
    // Arrange, Act and Assert
    assertTrue((new CertInformationCollector()).getCertificateSet().isEmpty());
  }

  /**
   * Test new {@link CertInformationCollector} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link CertInformationCollector}
   */
  @Test
  @DisplayName("Test new CertInformationCollector (default constructor)")
  void testNewCertInformationCollector() {
    // Arrange, Act and Assert
    assertTrue((new CertInformationCollector()).getCertificateSet().isEmpty());
  }
}

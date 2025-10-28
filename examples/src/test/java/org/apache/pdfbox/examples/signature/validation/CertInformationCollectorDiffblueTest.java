package org.apache.pdfbox.examples.signature.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class CertInformationCollectorDiffblueTest {
  /**
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
   * Method under test: {@link CertInformationCollector#getCertificateSet()}
   */
  @Test
  void testGetCertificateSet() {
    // Arrange, Act and Assert
    assertTrue((new CertInformationCollector()).getCertificateSet().isEmpty());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link CertInformationCollector}
   */
  @Test
  void testNewCertInformationCollector() {
    // Arrange, Act and Assert
    assertTrue((new CertInformationCollector()).getCertificateSet().isEmpty());
  }
}

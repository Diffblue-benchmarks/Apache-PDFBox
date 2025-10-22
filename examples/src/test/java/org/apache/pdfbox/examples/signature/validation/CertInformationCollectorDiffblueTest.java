package org.apache.pdfbox.examples.signature.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.security.cert.X509Certificate;
import org.apache.pdfbox.examples.signature.validation.CertInformationCollector.CertSignatureInformation;
import org.bouncycastle.cert.X509CertificateHolder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CertInformationCollectorDiffblueTest {
  /**
   * Test {@link CertInformationCollector#addAllCertsFromHolders(X509CertificateHolder[])}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CertInformationCollector#addAllCertsFromHolders(X509CertificateHolder[])}
   */
  @Test
  @DisplayName("Test addAllCertsFromHolders(X509CertificateHolder[]); given 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CertInformationCollector.addAllCertsFromHolders(X509CertificateHolder[])"})
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
   * Test {@link CertInformationCollector#addAllCertsFromHolders(X509CertificateHolder[])}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CertInformationCollector#addAllCertsFromHolders(X509CertificateHolder[])}
   */
  @Test
  @DisplayName("Test addAllCertsFromHolders(X509CertificateHolder[]); given IOException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CertInformationCollector.addAllCertsFromHolders(X509CertificateHolder[])"})
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
   *   <li>default or parameterless constructor of {@link CertSignatureInformation}
   *   <li>{@link CertSignatureInformation#setIssuerUrl(String)}
   *   <li>{@link CertSignatureInformation#setOcspUrl(String)}
   *   <li>{@link CertSignatureInformation#getAlternativeCertChain()}
   *   <li>{@link CertSignatureInformation#getCertChain()}
   *   <li>{@link CertSignatureInformation#getCertificate()}
   *   <li>{@link CertSignatureInformation#getCrlUrl()}
   *   <li>{@link CertSignatureInformation#getIssuerCertificate()}
   *   <li>{@link CertSignatureInformation#getOcspUrl()}
   *   <li>{@link CertSignatureInformation#getSignatureHash()}
   *   <li>{@link CertSignatureInformation#getTsaCerts()}
   *   <li>{@link CertSignatureInformation#isSelfSigned()}
   * </ul>
   */
  @Test
  @DisplayName("Test CertSignatureInformation getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CertSignatureInformation.<init>()",
      "CertSignatureInformation CertSignatureInformation.getAlternativeCertChain()",
      "CertSignatureInformation CertSignatureInformation.getCertChain()",
      "X509Certificate CertSignatureInformation.getCertificate()", "String CertSignatureInformation.getCrlUrl()",
      "X509Certificate CertSignatureInformation.getIssuerCertificate()", "String CertSignatureInformation.getOcspUrl()",
      "String CertSignatureInformation.getSignatureHash()",
      "CertSignatureInformation CertSignatureInformation.getTsaCerts()",
      "boolean CertSignatureInformation.isSelfSigned()", "void CertSignatureInformation.setIssuerUrl(String)",
      "void CertSignatureInformation.setOcspUrl(String)"})
  void testCertSignatureInformationGettersAndSetters() {
    // Arrange and Act
    CertSignatureInformation actualCertSignatureInformation = new CertSignatureInformation();
    actualCertSignatureInformation.setIssuerUrl("https://example.org/example");
    actualCertSignatureInformation.setOcspUrl("https://example.org/example");
    CertSignatureInformation actualAlternativeCertChain = actualCertSignatureInformation.getAlternativeCertChain();
    CertSignatureInformation actualCertChain = actualCertSignatureInformation.getCertChain();
    X509Certificate actualCertificate = actualCertSignatureInformation.getCertificate();
    String actualCrlUrl = actualCertSignatureInformation.getCrlUrl();
    X509Certificate actualIssuerCertificate = actualCertSignatureInformation.getIssuerCertificate();
    String actualOcspUrl = actualCertSignatureInformation.getOcspUrl();
    String actualSignatureHash = actualCertSignatureInformation.getSignatureHash();
    CertSignatureInformation actualTsaCerts = actualCertSignatureInformation.getTsaCerts();

    // Assert
    assertEquals("https://example.org/example", actualOcspUrl);
    assertNull(actualCrlUrl);
    assertNull(actualSignatureHash);
    assertNull(actualCertificate);
    assertNull(actualIssuerCertificate);
    assertNull(actualAlternativeCertChain);
    assertNull(actualCertChain);
    assertNull(actualTsaCerts);
    assertFalse(actualCertSignatureInformation.isSelfSigned());
  }

  /**
   * Test {@link CertInformationCollector#getCertificateSet()}.
   * <p>
   * Method under test: {@link CertInformationCollector#getCertificateSet()}
   */
  @Test
  @DisplayName("Test getCertificateSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set CertInformationCollector.getCertificateSet()"})
  void testGetCertificateSet() {
    // Arrange, Act and Assert
    assertTrue((new CertInformationCollector()).getCertificateSet().isEmpty());
  }

  /**
   * Test new {@link CertInformationCollector} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link CertInformationCollector}
   */
  @Test
  @DisplayName("Test new CertInformationCollector (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CertInformationCollector.<init>()"})
  void testNewCertInformationCollector() {
    // Arrange, Act and Assert
    assertTrue((new CertInformationCollector()).getCertificateSet().isEmpty());
  }
}

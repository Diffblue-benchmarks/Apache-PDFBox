package org.apache.pdfbox.examples.signature;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Hashtable;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.jce.provider.X509CertificateObject;
import org.bouncycastle.tsp.TSPException;
import org.bouncycastle.tsp.TimeStampToken;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SigUtilsDiffblueTest {
  /**
   * Test {@link SigUtils#checkCertificateUsage(X509Certificate)}.
   * <ul>
   *   <li>Given array of {@code boolean} with {@code false} and {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SigUtils#checkCertificateUsage(X509Certificate)}
   */
  @Test
  @DisplayName("Test checkCertificateUsage(X509Certificate); given array of boolean with 'false' and 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SigUtils.checkCertificateUsage(X509Certificate)"})
  void testCheckCertificateUsage_givenArrayOfBooleanWithFalseAndFalse() throws CertificateParsingException {
    // Arrange
    X509CertificateObject x509Certificate = mock(X509CertificateObject.class);
    when(x509Certificate.getKeyUsage()).thenReturn(new boolean[]{false, false, true, false});
    when(x509Certificate.getExtendedKeyUsage()).thenReturn(new ArrayList<>());

    // Act
    SigUtils.checkCertificateUsage(x509Certificate);

    // Assert
    verify(x509Certificate).getExtendedKeyUsage();
    verify(x509Certificate).getKeyUsage();
  }

  /**
   * Test {@link SigUtils#checkCertificateUsage(X509Certificate)}.
   * <ul>
   *   <li>Given array of {@code boolean} with {@code false} and {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SigUtils#checkCertificateUsage(X509Certificate)}
   */
  @Test
  @DisplayName("Test checkCertificateUsage(X509Certificate); given array of boolean with 'false' and 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SigUtils.checkCertificateUsage(X509Certificate)"})
  void testCheckCertificateUsage_givenArrayOfBooleanWithFalseAndTrue() throws CertificateParsingException {
    // Arrange
    X509CertificateObject x509Certificate = mock(X509CertificateObject.class);
    when(x509Certificate.getKeyUsage()).thenReturn(new boolean[]{false, true, true, false});
    when(x509Certificate.getExtendedKeyUsage()).thenReturn(new ArrayList<>());

    // Act
    SigUtils.checkCertificateUsage(x509Certificate);

    // Assert
    verify(x509Certificate).getExtendedKeyUsage();
    verify(x509Certificate).getKeyUsage();
  }

  /**
   * Test {@link SigUtils#checkCertificateUsage(X509Certificate)}.
   * <ul>
   *   <li>Given array of {@code boolean} with {@code true} and {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SigUtils#checkCertificateUsage(X509Certificate)}
   */
  @Test
  @DisplayName("Test checkCertificateUsage(X509Certificate); given array of boolean with 'true' and 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SigUtils.checkCertificateUsage(X509Certificate)"})
  void testCheckCertificateUsage_givenArrayOfBooleanWithTrueAndFalse() throws CertificateParsingException {
    // Arrange
    X509CertificateObject x509Certificate = mock(X509CertificateObject.class);
    when(x509Certificate.getKeyUsage()).thenReturn(new boolean[]{true, false, true, false});
    when(x509Certificate.getExtendedKeyUsage()).thenReturn(new ArrayList<>());

    // Act
    SigUtils.checkCertificateUsage(x509Certificate);

    // Assert
    verify(x509Certificate).getExtendedKeyUsage();
    verify(x509Certificate).getKeyUsage();
  }

  /**
   * Test {@link SigUtils#checkCertificateUsage(X509Certificate)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SigUtils#checkCertificateUsage(X509Certificate)}
   */
  @Test
  @DisplayName("Test checkCertificateUsage(X509Certificate); given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SigUtils.checkCertificateUsage(X509Certificate)"})
  void testCheckCertificateUsage_givenNull() throws CertificateParsingException {
    // Arrange
    X509CertificateObject x509Certificate = mock(X509CertificateObject.class);
    when(x509Certificate.getKeyUsage()).thenReturn(null);
    when(x509Certificate.getExtendedKeyUsage()).thenReturn(new ArrayList<>());

    // Act
    SigUtils.checkCertificateUsage(x509Certificate);

    // Assert
    verify(x509Certificate).getExtendedKeyUsage();
    verify(x509Certificate).getKeyUsage();
  }

  /**
   * Test {@link SigUtils#checkCertificateUsage(X509Certificate)}.
   * <ul>
   *   <li>Then throw {@link CertificateParsingException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SigUtils#checkCertificateUsage(X509Certificate)}
   */
  @Test
  @DisplayName("Test checkCertificateUsage(X509Certificate); then throw CertificateParsingException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SigUtils.checkCertificateUsage(X509Certificate)"})
  void testCheckCertificateUsage_thenThrowCertificateParsingException() throws CertificateParsingException {
    // Arrange
    X509CertificateObject x509Certificate = mock(X509CertificateObject.class);
    when(x509Certificate.getKeyUsage()).thenReturn(new boolean[]{true, false, true, false});
    when(x509Certificate.getExtendedKeyUsage()).thenThrow(new CertificateParsingException("1.2.840.113583.1.1.5"));

    // Act and Assert
    assertThrows(CertificateParsingException.class, () -> SigUtils.checkCertificateUsage(x509Certificate));
    verify(x509Certificate).getExtendedKeyUsage();
    verify(x509Certificate).getKeyUsage();
  }

  /**
   * Test {@link SigUtils#checkTimeStampCertificateUsage(X509Certificate)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link X509CertificateObject#getExtendedKeyUsage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SigUtils#checkTimeStampCertificateUsage(X509Certificate)}
   */
  @Test
  @DisplayName("Test checkTimeStampCertificateUsage(X509Certificate); given ArrayList(); then calls getExtendedKeyUsage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SigUtils.checkTimeStampCertificateUsage(X509Certificate)"})
  void testCheckTimeStampCertificateUsage_givenArrayList_thenCallsGetExtendedKeyUsage()
      throws CertificateParsingException {
    // Arrange
    X509CertificateObject x509Certificate = mock(X509CertificateObject.class);
    when(x509Certificate.getExtendedKeyUsage()).thenReturn(new ArrayList<>());

    // Act
    SigUtils.checkTimeStampCertificateUsage(x509Certificate);

    // Assert
    verify(x509Certificate).getExtendedKeyUsage();
  }

  /**
   * Test {@link SigUtils#checkResponderCertificateUsage(X509Certificate)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link X509CertificateObject#getExtendedKeyUsage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SigUtils#checkResponderCertificateUsage(X509Certificate)}
   */
  @Test
  @DisplayName("Test checkResponderCertificateUsage(X509Certificate); given ArrayList(); then calls getExtendedKeyUsage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SigUtils.checkResponderCertificateUsage(X509Certificate)"})
  void testCheckResponderCertificateUsage_givenArrayList_thenCallsGetExtendedKeyUsage()
      throws CertificateParsingException {
    // Arrange
    X509CertificateObject x509Certificate = mock(X509CertificateObject.class);
    when(x509Certificate.getExtendedKeyUsage()).thenReturn(new ArrayList<>());

    // Act
    SigUtils.checkResponderCertificateUsage(x509Certificate);

    // Assert
    verify(x509Certificate).getExtendedKeyUsage();
  }

  /**
   * Test {@link SigUtils#extractTimeStampTokenFromSignerInformation(SignerInformation)}.
   * <ul>
   *   <li>Given {@link AttributeTable#AttributeTable(Hashtable)} with {@link Hashtable#Hashtable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SigUtils#extractTimeStampTokenFromSignerInformation(SignerInformation)}
   */
  @Test
  @DisplayName("Test extractTimeStampTokenFromSignerInformation(SignerInformation); given AttributeTable(Hashtable) with Hashtable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TimeStampToken SigUtils.extractTimeStampTokenFromSignerInformation(SignerInformation)"})
  void testExtractTimeStampTokenFromSignerInformation_givenAttributeTableWithHashtable()
      throws IOException, CMSException, TSPException {
    // Arrange
    SignerInformation signerInformation = mock(SignerInformation.class);
    when(signerInformation.getUnsignedAttributes()).thenReturn(new AttributeTable(new Hashtable()));

    // Act
    TimeStampToken actualExtractTimeStampTokenFromSignerInformationResult = SigUtils
        .extractTimeStampTokenFromSignerInformation(signerInformation);

    // Assert
    verify(signerInformation, atLeast(1)).getUnsignedAttributes();
    assertNull(actualExtractTimeStampTokenFromSignerInformationResult);
  }

  /**
   * Test {@link SigUtils#extractTimeStampTokenFromSignerInformation(SignerInformation)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SigUtils#extractTimeStampTokenFromSignerInformation(SignerInformation)}
   */
  @Test
  @DisplayName("Test extractTimeStampTokenFromSignerInformation(SignerInformation); given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TimeStampToken SigUtils.extractTimeStampTokenFromSignerInformation(SignerInformation)"})
  void testExtractTimeStampTokenFromSignerInformation_givenNull() throws IOException, CMSException, TSPException {
    // Arrange
    SignerInformation signerInformation = mock(SignerInformation.class);
    when(signerInformation.getUnsignedAttributes()).thenReturn(null);

    // Act
    TimeStampToken actualExtractTimeStampTokenFromSignerInformationResult = SigUtils
        .extractTimeStampTokenFromSignerInformation(signerInformation);

    // Assert
    verify(signerInformation).getUnsignedAttributes();
    assertNull(actualExtractTimeStampTokenFromSignerInformationResult);
  }
}

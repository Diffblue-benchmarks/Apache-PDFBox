package org.apache.pdfbox.examples.signature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Hashtable;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.jce.provider.X509CertificateObject;
import org.bouncycastle.tsp.TSPException;
import org.bouncycastle.tsp.TimeStampToken;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SigUtilsDiffblueTest {
  /**
   * Test {@link SigUtils#getMDPPermission(PDDocument)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>When {@link PDDocument#PDDocument()} addPage
   * {@link PDPage#PDPage()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SigUtils#getMDPPermission(PDDocument)}
   */
  @Test
  @DisplayName("Test getMDPPermission(PDDocument); given PDPage(); when PDDocument() addPage PDPage(); then return zero")
  void testGetMDPPermission_givenPDPage_whenPDDocumentAddPagePDPage_thenReturnZero() {
    // Arrange
    PDDocument doc = new PDDocument();
    doc.addPage(new PDPage());

    // Act and Assert
    assertEquals(0, SigUtils.getMDPPermission(doc));
  }

  /**
   * Test {@link SigUtils#getMDPPermission(PDDocument)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SigUtils#getMDPPermission(PDDocument)}
   */
  @Test
  @DisplayName("Test getMDPPermission(PDDocument); when PDDocument(); then return zero")
  void testGetMDPPermission_whenPDDocument_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, SigUtils.getMDPPermission(new PDDocument()));
  }

  /**
   * Test {@link SigUtils#setMDPPermission(PDDocument, PDSignature, int)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SigUtils#setMDPPermission(PDDocument, PDSignature, int)}
   */
  @Test
  @DisplayName("Test setMDPPermission(PDDocument, PDSignature, int); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  void testSetMDPPermission_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));
    PDSignature sigObject = new PDSignature(dict);

    PDDocument doc = new PDDocument();
    doc.addPage(new PDPage());
    doc.addSignature(sigObject);

    // Act and Assert
    assertThrows(IOException.class, () -> SigUtils.setMDPPermission(doc, new PDSignature(), 1));
  }

  /**
   * Test {@link SigUtils#setMDPPermission(PDDocument, PDSignature, int)}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SigUtils#setMDPPermission(PDDocument, PDSignature, int)}
   */
  @Test
  @DisplayName("Test setMDPPermission(PDDocument, PDSignature, int); given PDSignature(COSDictionary) with dict is COSDictionary()")
  void testSetMDPPermission_givenPDSignatureWithDictIsCOSDictionary() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    doc.addPage(new PDPage());
    doc.addSignature(new PDSignature(new COSDictionary()));

    // Act and Assert
    assertThrows(IOException.class, () -> SigUtils.setMDPPermission(doc, new PDSignature(), 1));
  }

  /**
   * Test {@link SigUtils#setMDPPermission(PDDocument, PDSignature, int)}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>When {@link PDDocument#PDDocument()} addSignature
   * {@link PDSignature#PDSignature()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SigUtils#setMDPPermission(PDDocument, PDSignature, int)}
   */
  @Test
  @DisplayName("Test setMDPPermission(PDDocument, PDSignature, int); given PDSignature(); when PDDocument() addSignature PDSignature()")
  void testSetMDPPermission_givenPDSignature_whenPDDocumentAddSignaturePDSignature() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    doc.addPage(new PDPage());
    doc.addSignature(new PDSignature());

    // Act and Assert
    assertThrows(IOException.class, () -> SigUtils.setMDPPermission(doc, new PDSignature(), 1));
  }

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
   * Method under test:
   * {@link SigUtils#checkTimeStampCertificateUsage(X509Certificate)}
   */
  @Test
  @DisplayName("Test checkTimeStampCertificateUsage(X509Certificate); given ArrayList(); then calls getExtendedKeyUsage()")
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
   * Method under test:
   * {@link SigUtils#checkResponderCertificateUsage(X509Certificate)}
   */
  @Test
  @DisplayName("Test checkResponderCertificateUsage(X509Certificate); given ArrayList(); then calls getExtendedKeyUsage()")
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
   * Test {@link SigUtils#getLastRelevantSignature(PDDocument)}.
   * <p>
   * Method under test: {@link SigUtils#getLastRelevantSignature(PDDocument)}
   */
  @Test
  @DisplayName("Test getLastRelevantSignature(PDDocument)")
  void testGetLastRelevantSignature() throws IOException {
    // Arrange
    COSDictionary dict = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);

    dict.setKey(key);
    PDSignature sigObject = new PDSignature(dict);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addSignature(sigObject);

    // Act and Assert
    assertSame(key, SigUtils.getLastRelevantSignature(document).getCOSObject().getKey());
  }

  /**
   * Test {@link SigUtils#getLastRelevantSignature(PDDocument)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SigUtils#getLastRelevantSignature(PDDocument)}
   */
  @Test
  @DisplayName("Test getLastRelevantSignature(PDDocument); given COSDictionary()")
  void testGetLastRelevantSignature_givenCOSDictionary() {
    // Arrange
    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act and Assert
    assertNull(SigUtils.getLastRelevantSignature(new PDDocument(doc)));
  }

  /**
   * Test {@link SigUtils#getLastRelevantSignature(PDDocument)}.
   * <ul>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SigUtils#getLastRelevantSignature(PDDocument)}
   */
  @Test
  @DisplayName("Test getLastRelevantSignature(PDDocument); then return COSObject is COSDictionary()")
  void testGetLastRelevantSignature_thenReturnCOSObjectIsCOSDictionary() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    COSDictionary dict = new COSDictionary();
    document.addSignature(new PDSignature(dict));

    // Act and Assert
    assertSame(dict, SigUtils.getLastRelevantSignature(document).getCOSObject());
  }

  /**
   * Test {@link SigUtils#getLastRelevantSignature(PDDocument)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SigUtils#getLastRelevantSignature(PDDocument)}
   */
  @Test
  @DisplayName("Test getLastRelevantSignature(PDDocument); when PDDocument(); then return 'null'")
  void testGetLastRelevantSignature_whenPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SigUtils.getLastRelevantSignature(new PDDocument()));
  }

  /**
   * Test
   * {@link SigUtils#extractTimeStampTokenFromSignerInformation(SignerInformation)}.
   * <ul>
   *   <li>Given {@link AttributeTable#AttributeTable(Hashtable)} with
   * {@link Hashtable#Hashtable()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SigUtils#extractTimeStampTokenFromSignerInformation(SignerInformation)}
   */
  @Test
  @DisplayName("Test extractTimeStampTokenFromSignerInformation(SignerInformation); given AttributeTable(Hashtable) with Hashtable()")
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
   * Test
   * {@link SigUtils#extractTimeStampTokenFromSignerInformation(SignerInformation)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SigUtils#extractTimeStampTokenFromSignerInformation(SignerInformation)}
   */
  @Test
  @DisplayName("Test extractTimeStampTokenFromSignerInformation(SignerInformation); given 'null'")
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

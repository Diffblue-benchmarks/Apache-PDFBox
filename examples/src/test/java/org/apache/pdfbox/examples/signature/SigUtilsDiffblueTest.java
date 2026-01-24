package org.apache.pdfbox.examples.signature;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Hashtable;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
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
   * Test {@link SigUtils#getMDPPermission(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@link COSDocument#COSDocument()} Trailer is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link SigUtils#getMDPPermission(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test getMDPPermission(PDDocument); given COSDictionary(); when COSDocument() Trailer is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SigUtils.getMDPPermission(PDDocument)"})
  void testGetMDPPermission_givenCOSDictionary_whenCOSDocumentTrailerIsCOSDictionary() {
    // Arrange
    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act and Assert
    assertEquals(0, SigUtils.getMDPPermission(new PDDocument(doc)));
  }

  /**
   * Test {@link SigUtils#getMDPPermission(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>When {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SigUtils#getMDPPermission(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test getMDPPermission(PDDocument); given PDPage(); when PDDocument() addPage PDPage(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SigUtils.getMDPPermission(PDDocument)"})
  void testGetMDPPermission_givenPDPage_whenPDDocumentAddPagePDPage_thenReturnZero() {
    // Arrange
    PDDocument doc = new PDDocument();
    doc.addPage(new PDPage());

    // Act and Assert
    assertEquals(0, SigUtils.getMDPPermission(doc));
  }

  /**
   * Test {@link SigUtils#getMDPPermission(PDDocument)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SigUtils#getMDPPermission(PDDocument)}
   */
  @Test
  @DisplayName("Test getMDPPermission(PDDocument); when PDDocument(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SigUtils.getMDPPermission(PDDocument)"})
  void testGetMDPPermission_whenPDDocument_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, SigUtils.getMDPPermission(new PDDocument()));
  }

  /**
   * Test {@link SigUtils#setMDPPermission(PDDocument, PDSignature, int)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is {@link COSObjectKey#COSObjectKey(long,
   *       int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link SigUtils#setMDPPermission(PDDocument, PDSignature, int)}
   */
  @Test
  @DisplayName(
      "Test setMDPPermission(PDDocument, PDSignature, int); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SigUtils.setMDPPermission(PDDocument, PDSignature, int)"})
  void testSetMDPPermission_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne()
      throws IOException {
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
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature(COSDictionary)} with dict is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link SigUtils#setMDPPermission(PDDocument, PDSignature, int)}
   */
  @Test
  @DisplayName(
      "Test setMDPPermission(PDDocument, PDSignature, int); given PDSignature(COSDictionary) with dict is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SigUtils.setMDPPermission(PDDocument, PDSignature, int)"})
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
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>When {@link PDDocument#PDDocument()} addSignature {@link PDSignature#PDSignature()}.
   * </ul>
   *
   * <p>Method under test: {@link SigUtils#setMDPPermission(PDDocument, PDSignature, int)}
   */
  @Test
  @DisplayName(
      "Test setMDPPermission(PDDocument, PDSignature, int); given PDSignature(); when PDDocument() addSignature PDSignature()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SigUtils.setMDPPermission(PDDocument, PDSignature, int)"})
  void testSetMDPPermission_givenPDSignature_whenPDDocumentAddSignaturePDSignature()
      throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    doc.addPage(new PDPage());
    doc.addSignature(new PDSignature());

    // Act and Assert
    assertThrows(IOException.class, () -> SigUtils.setMDPPermission(doc, new PDSignature(), 1));
  }

  /**
   * Test {@link SigUtils#checkCertificateUsage(X509Certificate)}.
   *
   * <ul>
   *   <li>Given array of {@code boolean} with {@code false} and {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SigUtils#checkCertificateUsage(X509Certificate)}
   */
  @Test
  @DisplayName(
      "Test checkCertificateUsage(X509Certificate); given array of boolean with 'false' and 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SigUtils.checkCertificateUsage(X509Certificate)"})
  void testCheckCertificateUsage_givenArrayOfBooleanWithFalseAndFalse()
      throws CertificateParsingException {
    // Arrange
    X509CertificateObject x509Certificate = mock(X509CertificateObject.class);
    when(x509Certificate.getKeyUsage()).thenReturn(new boolean[] {false, false, true, false});
    when(x509Certificate.getExtendedKeyUsage()).thenReturn(new ArrayList<>());

    // Act
    SigUtils.checkCertificateUsage(x509Certificate);

    // Assert
    verify(x509Certificate).getExtendedKeyUsage();
    verify(x509Certificate).getKeyUsage();
  }

  /**
   * Test {@link SigUtils#checkCertificateUsage(X509Certificate)}.
   *
   * <ul>
   *   <li>Given array of {@code boolean} with {@code false} and {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SigUtils#checkCertificateUsage(X509Certificate)}
   */
  @Test
  @DisplayName(
      "Test checkCertificateUsage(X509Certificate); given array of boolean with 'false' and 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SigUtils.checkCertificateUsage(X509Certificate)"})
  void testCheckCertificateUsage_givenArrayOfBooleanWithFalseAndTrue()
      throws CertificateParsingException {
    // Arrange
    X509CertificateObject x509Certificate = mock(X509CertificateObject.class);
    when(x509Certificate.getKeyUsage()).thenReturn(new boolean[] {false, true, true, false});
    when(x509Certificate.getExtendedKeyUsage()).thenReturn(new ArrayList<>());

    // Act
    SigUtils.checkCertificateUsage(x509Certificate);

    // Assert
    verify(x509Certificate).getExtendedKeyUsage();
    verify(x509Certificate).getKeyUsage();
  }

  /**
   * Test {@link SigUtils#checkCertificateUsage(X509Certificate)}.
   *
   * <ul>
   *   <li>Given array of {@code boolean} with {@code true} and {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SigUtils#checkCertificateUsage(X509Certificate)}
   */
  @Test
  @DisplayName(
      "Test checkCertificateUsage(X509Certificate); given array of boolean with 'true' and 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SigUtils.checkCertificateUsage(X509Certificate)"})
  void testCheckCertificateUsage_givenArrayOfBooleanWithTrueAndFalse()
      throws CertificateParsingException {
    // Arrange
    X509CertificateObject x509Certificate = mock(X509CertificateObject.class);
    when(x509Certificate.getKeyUsage()).thenReturn(new boolean[] {true, false, true, false});
    when(x509Certificate.getExtendedKeyUsage()).thenReturn(new ArrayList<>());

    // Act
    SigUtils.checkCertificateUsage(x509Certificate);

    // Assert
    verify(x509Certificate).getExtendedKeyUsage();
    verify(x509Certificate).getKeyUsage();
  }

  /**
   * Test {@link SigUtils#checkCertificateUsage(X509Certificate)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SigUtils#checkCertificateUsage(X509Certificate)}
   */
  @Test
  @DisplayName("Test checkCertificateUsage(X509Certificate); given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then throw {@link CertificateParsingException}.
   * </ul>
   *
   * <p>Method under test: {@link SigUtils#checkCertificateUsage(X509Certificate)}
   */
  @Test
  @DisplayName(
      "Test checkCertificateUsage(X509Certificate); then throw CertificateParsingException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SigUtils.checkCertificateUsage(X509Certificate)"})
  void testCheckCertificateUsage_thenThrowCertificateParsingException()
      throws CertificateParsingException {
    // Arrange
    X509CertificateObject x509Certificate = mock(X509CertificateObject.class);
    when(x509Certificate.getKeyUsage()).thenReturn(new boolean[] {true, false, true, false});
    when(x509Certificate.getExtendedKeyUsage()).thenThrow(new CertificateParsingException());

    // Act and Assert
    assertThrows(
        CertificateParsingException.class, () -> SigUtils.checkCertificateUsage(x509Certificate));
    verify(x509Certificate).getExtendedKeyUsage();
    verify(x509Certificate).getKeyUsage();
  }

  /**
   * Test {@link SigUtils#checkTimeStampCertificateUsage(X509Certificate)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link X509CertificateObject#getExtendedKeyUsage()}.
   * </ul>
   *
   * <p>Method under test: {@link SigUtils#checkTimeStampCertificateUsage(X509Certificate)}
   */
  @Test
  @DisplayName(
      "Test checkTimeStampCertificateUsage(X509Certificate); given ArrayList(); then calls getExtendedKeyUsage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link X509CertificateObject#getExtendedKeyUsage()}.
   * </ul>
   *
   * <p>Method under test: {@link SigUtils#checkResponderCertificateUsage(X509Certificate)}
   */
  @Test
  @DisplayName(
      "Test checkResponderCertificateUsage(X509Certificate); given ArrayList(); then calls getExtendedKeyUsage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link SigUtils#getLastRelevantSignature(PDDocument)}.
   *
   * <p>Method under test: {@link SigUtils#getLastRelevantSignature(PDDocument)}
   */
  @Test
  @DisplayName("Test getLastRelevantSignature(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSignature SigUtils.getLastRelevantSignature(PDDocument)"})
  void testGetLastRelevantSignature() throws IOException {
    // Arrange
    COSDictionary dict = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);
    dict.setKey(key);
    PDSignature sigObject = new PDSignature(dict);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addSignature(sigObject);

    // Act
    PDSignature actualLastRelevantSignature = SigUtils.getLastRelevantSignature(document);

    // Assert
    assertSame(key, actualLastRelevantSignature.getCOSObject().getKey());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        actualLastRelevantSignature.getByteRange());
  }

  /**
   * Test {@link SigUtils#getLastRelevantSignature(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link SigUtils#getLastRelevantSignature(PDDocument)}
   */
  @Test
  @DisplayName("Test getLastRelevantSignature(PDDocument); given COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSignature SigUtils.getLastRelevantSignature(PDDocument)"})
  void testGetLastRelevantSignature_givenCOSDictionary() {
    // Arrange
    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act and Assert
    assertNull(SigUtils.getLastRelevantSignature(new PDDocument(doc)));
  }

  /**
   * Test {@link SigUtils#getLastRelevantSignature(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()} Type is {@link COSName}.
   * </ul>
   *
   * <p>Method under test: {@link SigUtils#getLastRelevantSignature(PDDocument)}
   */
  @Test
  @DisplayName("Test getLastRelevantSignature(PDDocument); given PDSignature() Type is COSName")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSignature SigUtils.getLastRelevantSignature(PDDocument)"})
  void testGetLastRelevantSignature_givenPDSignatureTypeIsCOSName() throws IOException {
    // Arrange
    PDSignature sigObject = new PDSignature();
    sigObject.setType(mock(COSName.class));

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addSignature(sigObject);

    // Act and Assert
    assertNull(SigUtils.getLastRelevantSignature(document));
  }

  /**
   * Test {@link SigUtils#getLastRelevantSignature(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>Then return COSObject Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SigUtils#getLastRelevantSignature(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test getLastRelevantSignature(PDDocument); given PDSignature(); then return COSObject Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSignature SigUtils.getLastRelevantSignature(PDDocument)"})
  void testGetLastRelevantSignature_givenPDSignature_thenReturnCOSObjectKeyIsNull()
      throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addSignature(new PDSignature());

    // Act
    PDSignature actualLastRelevantSignature = SigUtils.getLastRelevantSignature(document);

    // Assert
    COSDictionary cOSObject = actualLastRelevantSignature.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        actualLastRelevantSignature.getByteRange());
  }

  /**
   * Test {@link SigUtils#getLastRelevantSignature(PDDocument)}.
   *
   * <ul>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link SigUtils#getLastRelevantSignature(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test getLastRelevantSignature(PDDocument); then return COSObject is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSignature SigUtils.getLastRelevantSignature(PDDocument)"})
  void testGetLastRelevantSignature_thenReturnCOSObjectIsCOSDictionary() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    COSDictionary dict = new COSDictionary();
    document.addSignature(new PDSignature(dict));

    // Act
    PDSignature actualLastRelevantSignature = SigUtils.getLastRelevantSignature(document);

    // Assert
    assertSame(dict, actualLastRelevantSignature.getCOSObject());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        actualLastRelevantSignature.getByteRange());
  }

  /**
   * Test {@link SigUtils#getLastRelevantSignature(PDDocument)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SigUtils#getLastRelevantSignature(PDDocument)}
   */
  @Test
  @DisplayName("Test getLastRelevantSignature(PDDocument); when PDDocument(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSignature SigUtils.getLastRelevantSignature(PDDocument)"})
  void testGetLastRelevantSignature_whenPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SigUtils.getLastRelevantSignature(new PDDocument()));
  }

  /**
   * Test {@link SigUtils#extractTimeStampTokenFromSignerInformation(SignerInformation)}.
   *
   * <p>Method under test: {@link
   * SigUtils#extractTimeStampTokenFromSignerInformation(SignerInformation)}
   */
  @Test
  @DisplayName("Test extractTimeStampTokenFromSignerInformation(SignerInformation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TimeStampToken SigUtils.extractTimeStampTokenFromSignerInformation(SignerInformation)"
  })
  void testExtractTimeStampTokenFromSignerInformation()
      throws IOException, CMSException, TSPException {
    // Arrange
    AttributeTable attributeTable = new AttributeTable(new Hashtable());
    attributeTable.add(
        PKCSObjectIdentifiers.id_aa_signatureTimeStampToken, mock(ASN1Encodable.class));

    SignerInformation signerInformation = mock(SignerInformation.class);
    when(signerInformation.getUnsignedAttributes()).thenReturn(attributeTable);

    // Act
    TimeStampToken actualExtractTimeStampTokenFromSignerInformationResult =
        SigUtils.extractTimeStampTokenFromSignerInformation(signerInformation);

    // Assert
    verify(signerInformation, atLeast(1)).getUnsignedAttributes();
    assertNull(actualExtractTimeStampTokenFromSignerInformationResult);
  }

  /**
   * Test {@link SigUtils#extractTimeStampTokenFromSignerInformation(SignerInformation)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SigUtils#extractTimeStampTokenFromSignerInformation(SignerInformation)}
   */
  @Test
  @DisplayName("Test extractTimeStampTokenFromSignerInformation(SignerInformation); given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TimeStampToken SigUtils.extractTimeStampTokenFromSignerInformation(SignerInformation)"
  })
  void testExtractTimeStampTokenFromSignerInformation_givenNull()
      throws IOException, CMSException, TSPException {
    // Arrange
    SignerInformation signerInformation = mock(SignerInformation.class);
    when(signerInformation.getUnsignedAttributes()).thenReturn(null);

    // Act
    TimeStampToken actualExtractTimeStampTokenFromSignerInformationResult =
        SigUtils.extractTimeStampTokenFromSignerInformation(signerInformation);

    // Assert
    verify(signerInformation).getUnsignedAttributes();
    assertNull(actualExtractTimeStampTokenFromSignerInformationResult);
  }
}

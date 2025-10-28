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
import java.io.IOException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Hashtable;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.jce.provider.X509CertificateObject;
import org.bouncycastle.tsp.TSPException;
import org.bouncycastle.tsp.TimeStampToken;
import org.junit.jupiter.api.Test;

class SigUtilsDiffblueTest {
  /**
   * Method under test: {@link SigUtils#getMDPPermission(PDDocument)}
   */
  @Test
  void testGetMDPPermission() {
    // Arrange, Act and Assert
    assertEquals(0, SigUtils.getMDPPermission(new PDDocument()));
  }

  /**
   * Method under test: {@link SigUtils#getMDPPermission(PDDocument)}
   */
  @Test
  void testGetMDPPermission2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    int actualMDPPermission = SigUtils.getMDPPermission(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualMDPPermission);
  }

  /**
   * Method under test: {@link SigUtils#getMDPPermission(PDDocument)}
   */
  @Test
  void testGetMDPPermission3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.addPage(new PDPage());

    // Act
    int actualMDPPermission = SigUtils.getMDPPermission(doc);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualMDPPermission);
  }

  /**
   * Method under test:
   * {@link SigUtils#setMDPPermission(PDDocument, PDSignature, int)}
   */
  @Test
  void testSetMDPPermission() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.addPage(new PDPage());
    doc.addSignature(new PDSignature());

    // Act and Assert
    assertThrows(IOException.class, () -> SigUtils.setMDPPermission(doc, new PDSignature(), 1));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link SigUtils#setMDPPermission(PDDocument, PDSignature, int)}
   */
  @Test
  void testSetMDPPermission2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.addPage(new PDPage());
    doc.addSignature(new PDSignature(new COSDictionary()));

    // Act and Assert
    assertThrows(IOException.class, () -> SigUtils.setMDPPermission(doc, new PDSignature(), 1));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link SigUtils#setMDPPermission(PDDocument, PDSignature, int)}
   */
  @Test
  void testSetMDPPermission3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));
    PDSignature sigObject = new PDSignature(dict);

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.addPage(new PDPage());
    doc.addSignature(sigObject);

    // Act and Assert
    assertThrows(IOException.class, () -> SigUtils.setMDPPermission(doc, new PDSignature(), 1));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link SigUtils#checkCertificateUsage(X509Certificate)}
   */
  @Test
  void testCheckCertificateUsage() throws CertificateParsingException {
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
   * Method under test: {@link SigUtils#checkCertificateUsage(X509Certificate)}
   */
  @Test
  void testCheckCertificateUsage2() throws CertificateParsingException {
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
   * Method under test: {@link SigUtils#checkCertificateUsage(X509Certificate)}
   */
  @Test
  void testCheckCertificateUsage3() throws CertificateParsingException {
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
   * Method under test: {@link SigUtils#checkCertificateUsage(X509Certificate)}
   */
  @Test
  void testCheckCertificateUsage4() throws CertificateParsingException {
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
   * Method under test: {@link SigUtils#checkCertificateUsage(X509Certificate)}
   */
  @Test
  void testCheckCertificateUsage5() throws CertificateParsingException {
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
   * Method under test:
   * {@link SigUtils#checkTimeStampCertificateUsage(X509Certificate)}
   */
  @Test
  void testCheckTimeStampCertificateUsage() throws CertificateParsingException {
    // Arrange
    X509CertificateObject x509Certificate = mock(X509CertificateObject.class);
    when(x509Certificate.getExtendedKeyUsage()).thenReturn(new ArrayList<>());

    // Act
    SigUtils.checkTimeStampCertificateUsage(x509Certificate);

    // Assert
    verify(x509Certificate).getExtendedKeyUsage();
  }

  /**
   * Method under test:
   * {@link SigUtils#checkResponderCertificateUsage(X509Certificate)}
   */
  @Test
  void testCheckResponderCertificateUsage() throws CertificateParsingException {
    // Arrange
    X509CertificateObject x509Certificate = mock(X509CertificateObject.class);
    when(x509Certificate.getExtendedKeyUsage()).thenReturn(new ArrayList<>());

    // Act
    SigUtils.checkResponderCertificateUsage(x509Certificate);

    // Assert
    verify(x509Certificate).getExtendedKeyUsage();
  }

  /**
   * Method under test: {@link SigUtils#getLastRelevantSignature(PDDocument)}
   */
  @Test
  void testGetLastRelevantSignature() {
    // Arrange, Act and Assert
    assertNull(SigUtils.getLastRelevantSignature(new PDDocument()));
  }

  /**
   * Method under test: {@link SigUtils#getLastRelevantSignature(PDDocument)}
   */
  @Test
  void testGetLastRelevantSignature2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDSignature actualLastRelevantSignature = SigUtils
        .getLastRelevantSignature(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualLastRelevantSignature);
  }

  /**
   * Method under test: {@link SigUtils#getLastRelevantSignature(PDDocument)}
   */
  @Test
  void testGetLastRelevantSignature3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());
    COSDictionary dict = new COSDictionary();
    document.addSignature(new PDSignature(dict));

    // Act
    PDSignature actualLastRelevantSignature = SigUtils.getLastRelevantSignature(document);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualLastRelevantSignature.getContactInfo());
    assertNull(actualLastRelevantSignature.getFilter());
    assertNull(actualLastRelevantSignature.getLocation());
    assertNull(actualLastRelevantSignature.getName());
    assertNull(actualLastRelevantSignature.getReason());
    assertNull(actualLastRelevantSignature.getSubFilter());
    assertNull(actualLastRelevantSignature.getSignDate());
    assertNull(actualLastRelevantSignature.getPropBuild());
    byte[] contents = actualLastRelevantSignature.getContents();
    assertEquals((byte) 0, contents[0]);
    assertEquals((byte) 0, contents[1]);
    assertEquals((byte) 0, contents[10]);
    assertEquals((byte) 0, contents[11]);
    assertEquals((byte) 0, contents[12]);
    assertEquals((byte) 0, contents[13]);
    assertEquals((byte) 0, contents[14]);
    assertEquals((byte) 0, contents[15]);
    assertEquals((byte) 0, contents[17]);
    assertEquals((byte) 0, contents[18]);
    assertEquals((byte) 0, contents[19]);
    assertEquals((byte) 0, contents[2]);
    assertEquals((byte) 0, contents[20]);
    assertEquals((byte) 0, contents[21]);
    assertEquals((byte) 0, contents[22]);
    assertEquals((byte) 0, contents[23]);
    assertEquals((byte) 0, contents[24]);
    assertEquals((byte) 0, contents[3]);
    assertEquals((byte) 0, contents[4]);
    assertEquals((byte) 0, contents[5]);
    assertEquals((byte) 0, contents[6]);
    assertEquals((byte) 0, contents[7]);
    assertEquals((byte) 0, contents[8]);
    assertEquals((byte) 0, contents[9]);
    assertEquals((byte) 0, contents[9447]);
    assertEquals((byte) 0, contents[9448]);
    assertEquals((byte) 0, contents[9449]);
    assertEquals((byte) 0, contents[9450]);
    assertEquals((byte) 0, contents[9451]);
    assertEquals((byte) 0, contents[9452]);
    assertEquals((byte) 0, contents[9453]);
    assertEquals((byte) 0, contents[9454]);
    assertEquals((byte) 0, contents[9455]);
    assertEquals((byte) 0, contents[9456]);
    assertEquals((byte) 0, contents[9457]);
    assertEquals((byte) 0, contents[9458]);
    assertEquals((byte) 0, contents[9459]);
    assertEquals((byte) 0, contents[9460]);
    assertEquals((byte) 0, contents[9461]);
    assertEquals((byte) 0, contents[9462]);
    assertEquals((byte) 0, contents[9463]);
    assertEquals((byte) 0, contents[9464]);
    assertEquals((byte) 0, contents[9465]);
    assertEquals((byte) 0, contents[9466]);
    assertEquals((byte) 0, contents[9467]);
    assertEquals((byte) 0, contents[9468]);
    assertEquals((byte) 0, contents[9469]);
    assertEquals((byte) 0, contents[9470]);
    assertEquals((byte) 0, contents[9471]);
    assertEquals((byte) 0, contents[Short.SIZE]);
    assertEquals(9472, contents.length);
    assertSame(dict, actualLastRelevantSignature.getCOSObject());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, actualLastRelevantSignature.getByteRange());
  }

  /**
   * Method under test: {@link SigUtils#getLastRelevantSignature(PDDocument)}
   */
  @Test
  void testGetLastRelevantSignature4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));
    PDSignature sigObject = new PDSignature(dict);

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());
    document.addSignature(sigObject);

    // Act
    PDSignature actualLastRelevantSignature = SigUtils.getLastRelevantSignature(document);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualLastRelevantSignature.getContactInfo());
    assertNull(actualLastRelevantSignature.getFilter());
    assertNull(actualLastRelevantSignature.getLocation());
    assertNull(actualLastRelevantSignature.getName());
    assertNull(actualLastRelevantSignature.getReason());
    assertNull(actualLastRelevantSignature.getSubFilter());
    assertNull(actualLastRelevantSignature.getSignDate());
    assertNull(actualLastRelevantSignature.getPropBuild());
    byte[] contents = actualLastRelevantSignature.getContents();
    assertEquals((byte) 0, contents[0]);
    assertEquals((byte) 0, contents[1]);
    assertEquals((byte) 0, contents[10]);
    assertEquals((byte) 0, contents[11]);
    assertEquals((byte) 0, contents[12]);
    assertEquals((byte) 0, contents[13]);
    assertEquals((byte) 0, contents[14]);
    assertEquals((byte) 0, contents[15]);
    assertEquals((byte) 0, contents[17]);
    assertEquals((byte) 0, contents[18]);
    assertEquals((byte) 0, contents[19]);
    assertEquals((byte) 0, contents[2]);
    assertEquals((byte) 0, contents[20]);
    assertEquals((byte) 0, contents[21]);
    assertEquals((byte) 0, contents[22]);
    assertEquals((byte) 0, contents[23]);
    assertEquals((byte) 0, contents[24]);
    assertEquals((byte) 0, contents[3]);
    assertEquals((byte) 0, contents[4]);
    assertEquals((byte) 0, contents[5]);
    assertEquals((byte) 0, contents[6]);
    assertEquals((byte) 0, contents[7]);
    assertEquals((byte) 0, contents[8]);
    assertEquals((byte) 0, contents[9]);
    assertEquals((byte) 0, contents[9447]);
    assertEquals((byte) 0, contents[9448]);
    assertEquals((byte) 0, contents[9449]);
    assertEquals((byte) 0, contents[9450]);
    assertEquals((byte) 0, contents[9451]);
    assertEquals((byte) 0, contents[9452]);
    assertEquals((byte) 0, contents[9453]);
    assertEquals((byte) 0, contents[9454]);
    assertEquals((byte) 0, contents[9455]);
    assertEquals((byte) 0, contents[9456]);
    assertEquals((byte) 0, contents[9457]);
    assertEquals((byte) 0, contents[9458]);
    assertEquals((byte) 0, contents[9459]);
    assertEquals((byte) 0, contents[9460]);
    assertEquals((byte) 0, contents[9461]);
    assertEquals((byte) 0, contents[9462]);
    assertEquals((byte) 0, contents[9463]);
    assertEquals((byte) 0, contents[9464]);
    assertEquals((byte) 0, contents[9465]);
    assertEquals((byte) 0, contents[9466]);
    assertEquals((byte) 0, contents[9467]);
    assertEquals((byte) 0, contents[9468]);
    assertEquals((byte) 0, contents[9469]);
    assertEquals((byte) 0, contents[9470]);
    assertEquals((byte) 0, contents[9471]);
    assertEquals((byte) 0, contents[Short.SIZE]);
    assertEquals(9472, contents.length);
    assertSame(dict, actualLastRelevantSignature.getCOSObject());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, actualLastRelevantSignature.getByteRange());
  }

  /**
   * Method under test:
   * {@link SigUtils#extractTimeStampTokenFromSignerInformation(SignerInformation)}
   */
  @Test
  void testExtractTimeStampTokenFromSignerInformation() throws IOException, CMSException, TSPException {
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
   * Method under test:
   * {@link SigUtils#extractTimeStampTokenFromSignerInformation(SignerInformation)}
   */
  @Test
  void testExtractTimeStampTokenFromSignerInformation2() throws IOException, CMSException, TSPException {
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

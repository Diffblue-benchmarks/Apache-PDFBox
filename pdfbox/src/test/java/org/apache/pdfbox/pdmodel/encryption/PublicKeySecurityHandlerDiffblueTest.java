package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PublicKeySecurityHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link PublicKeySecurityHandler#prepareForDecryption(PDEncryption, COSArray, DecryptionMaterial)}
   */
  @Test
  void testPrepareForDecryption() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    PDEncryption encryption = new PDEncryption();
    COSArray documentIDArray = new COSArray();

    // Act and Assert
    assertThrows(IOException.class, () -> publicKeySecurityHandler.prepareForDecryption(encryption, documentIDArray,
        new StandardDecryptionMaterial("Pwd")));
  }

  /**
   * Method under test:
   * {@link PublicKeySecurityHandler#PublicKeySecurityHandler()}
   */
  @Test
  void testNewPublicKeySecurityHandler() {
    // Arrange and Act
    PublicKeySecurityHandler actualPublicKeySecurityHandler = new PublicKeySecurityHandler();

    // Assert
    assertNull(actualPublicKeySecurityHandler.getEncryptionKey());
    assertNull(actualPublicKeySecurityHandler.getCurrentAccessPermission());
    assertNull(actualPublicKeySecurityHandler.getProtectionPolicy());
    assertFalse(actualPublicKeySecurityHandler.hasProtectionPolicy());
    assertFalse(actualPublicKeySecurityHandler.isAES());
    assertFalse(actualPublicKeySecurityHandler.isDecryptMetadata());
    assertEquals(PDEncryption.DEFAULT_LENGTH, actualPublicKeySecurityHandler.getKeyLength());
  }

  /**
   * Method under test:
   * {@link PublicKeySecurityHandler#prepareDocumentForEncryption(PDDocument)}
   */
  @Test
  void testPrepareDocumentForEncryption() throws IOException {
    // Arrange
    PublicKeyProtectionPolicy publicKeyProtectionPolicy = new PublicKeyProtectionPolicy();
    publicKeyProtectionPolicy.setPreferAES(true);

    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setProtectionPolicy(publicKeyProtectionPolicy);
    COSDocument cosDocument = mock(COSDocument.class);
    doNothing().when(cosDocument).setEncryptionDictionary(Mockito.<COSDictionary>any());
    PDDocument doc = mock(PDDocument.class);
    when(doc.getDocument()).thenReturn(cosDocument);
    doNothing().when(doc).setEncryptionDictionary(Mockito.<PDEncryption>any());
    when(doc.getEncryption()).thenReturn(new PDEncryption());

    // Act
    publicKeySecurityHandler.prepareDocumentForEncryption(doc);

    // Assert
    verify(cosDocument).setEncryptionDictionary(isA(COSDictionary.class));
    verify(doc).getDocument();
    verify(doc).getEncryption();
    verify(doc).setEncryptionDictionary(isA(PDEncryption.class));
    assertEquals(5, publicKeySecurityHandler.getEncryptionKey().length);
    assertFalse(publicKeySecurityHandler.isAES());
  }

  /**
   * Method under test:
   * {@link PublicKeySecurityHandler#prepareDocumentForEncryption(PDDocument)}
   */
  @Test
  void testPrepareDocumentForEncryption2() throws IOException {
    // Arrange
    PublicKeyProtectionPolicy publicKeyProtectionPolicy = new PublicKeyProtectionPolicy();
    publicKeyProtectionPolicy.setPreferAES(true);

    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setProtectionPolicy(publicKeyProtectionPolicy);
    PDEncryption pdEncryption = mock(PDEncryption.class);
    when(pdEncryption.getCOSObject()).thenReturn(new COSDictionary());
    doNothing().when(pdEncryption).removeV45filters();
    doNothing().when(pdEncryption).setFilter(Mockito.<String>any());
    doNothing().when(pdEncryption).setLength(anyInt());
    doNothing().when(pdEncryption).setRecipients(Mockito.<byte[][]>any());
    doNothing().when(pdEncryption).setSubFilter(Mockito.<String>any());
    doNothing().when(pdEncryption).setVersion(anyInt());
    COSDocument cosDocument = mock(COSDocument.class);
    doNothing().when(cosDocument).setEncryptionDictionary(Mockito.<COSDictionary>any());
    PDDocument doc = mock(PDDocument.class);
    when(doc.getDocument()).thenReturn(cosDocument);
    doNothing().when(doc).setEncryptionDictionary(Mockito.<PDEncryption>any());
    when(doc.getEncryption()).thenReturn(pdEncryption);

    // Act
    publicKeySecurityHandler.prepareDocumentForEncryption(doc);

    // Assert
    verify(cosDocument).setEncryptionDictionary(isA(COSDictionary.class));
    verify(doc).getDocument();
    verify(doc).getEncryption();
    verify(doc).setEncryptionDictionary(isA(PDEncryption.class));
    verify(pdEncryption).getCOSObject();
    verify(pdEncryption).removeV45filters();
    verify(pdEncryption).setFilter(eq("Adobe.PubSec"));
    verify(pdEncryption).setLength(eq(40));
    verify(pdEncryption).setRecipients(isA(byte[][].class));
    verify(pdEncryption).setSubFilter(eq("adbe.pkcs7.s4"));
    verify(pdEncryption).setVersion(eq(1));
    assertEquals(5, publicKeySecurityHandler.getEncryptionKey().length);
    assertFalse(publicKeySecurityHandler.isAES());
  }

  /**
   * Method under test:
   * {@link PublicKeySecurityHandler#prepareDocumentForEncryption(PDDocument)}
   */
  @Test
  void testPrepareDocumentForEncryption3() throws IOException {
    // Arrange
    PublicKeyProtectionPolicy publicKeyProtectionPolicy = new PublicKeyProtectionPolicy();
    publicKeyProtectionPolicy.setPreferAES(true);

    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setKeyLength(3);
    publicKeySecurityHandler.setProtectionPolicy(publicKeyProtectionPolicy);
    PDEncryption pdEncryption = mock(PDEncryption.class);
    when(pdEncryption.getCOSObject()).thenReturn(new COSDictionary());
    doNothing().when(pdEncryption).removeV45filters();
    doNothing().when(pdEncryption).setFilter(Mockito.<String>any());
    doNothing().when(pdEncryption).setLength(anyInt());
    doNothing().when(pdEncryption).setRecipients(Mockito.<byte[][]>any());
    doNothing().when(pdEncryption).setSubFilter(Mockito.<String>any());
    doNothing().when(pdEncryption).setVersion(anyInt());
    COSDocument cosDocument = mock(COSDocument.class);
    doNothing().when(cosDocument).setEncryptionDictionary(Mockito.<COSDictionary>any());
    PDDocument doc = mock(PDDocument.class);
    when(doc.getDocument()).thenReturn(cosDocument);
    doNothing().when(doc).setEncryptionDictionary(Mockito.<PDEncryption>any());
    when(doc.getEncryption()).thenReturn(pdEncryption);

    // Act
    publicKeySecurityHandler.prepareDocumentForEncryption(doc);

    // Assert
    verify(cosDocument).setEncryptionDictionary(isA(COSDictionary.class));
    verify(doc).getDocument();
    verify(doc).getEncryption();
    verify(doc).setEncryptionDictionary(isA(PDEncryption.class));
    verify(pdEncryption).getCOSObject();
    verify(pdEncryption).removeV45filters();
    verify(pdEncryption).setFilter(eq("Adobe.PubSec"));
    verify(pdEncryption).setLength(eq(3));
    verify(pdEncryption).setRecipients(isA(byte[][].class));
    verify(pdEncryption).setSubFilter(eq("adbe.pkcs7.s4"));
    verify(pdEncryption).setVersion(eq(2));
    assertEquals(0, publicKeySecurityHandler.getEncryptionKey().length);
    assertFalse(publicKeySecurityHandler.isAES());
  }

  /**
   * Method under test:
   * {@link PublicKeySecurityHandler#prepareDocumentForEncryption(PDDocument)}
   */
  @Test
  void testPrepareDocumentForEncryption4() throws IOException {
    // Arrange
    PublicKeyProtectionPolicy publicKeyProtectionPolicy = new PublicKeyProtectionPolicy();
    publicKeyProtectionPolicy.setPreferAES(true);

    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setProtectionPolicy(publicKeyProtectionPolicy);
    PDEncryption pdEncryption = mock(PDEncryption.class);
    doThrow(new RuntimeException(PublicKeySecurityHandler.FILTER)).when(pdEncryption).setFilter(Mockito.<String>any());
    PDDocument doc = mock(PDDocument.class);
    when(doc.getEncryption()).thenReturn(pdEncryption);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> publicKeySecurityHandler.prepareDocumentForEncryption(doc));
    verify(doc).getEncryption();
    verify(pdEncryption).setFilter(eq("Adobe.PubSec"));
  }

  /**
   * Method under test:
   * {@link PublicKeySecurityHandler#prepareDocumentForEncryption(PDDocument)}
   */
  @Test
  void testPrepareDocumentForEncryption5() throws IOException {
    // Arrange
    PublicKeyProtectionPolicy publicKeyProtectionPolicy = new PublicKeyProtectionPolicy();
    publicKeyProtectionPolicy.setPreferAES(true);

    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setKeyLength(128);
    publicKeySecurityHandler.setProtectionPolicy(publicKeyProtectionPolicy);
    PDEncryption pdEncryption = mock(PDEncryption.class);
    doNothing().when(pdEncryption).setDefaultCryptFilterDictionary(Mockito.<PDCryptFilterDictionary>any());
    doNothing().when(pdEncryption).setStreamFilterName(Mockito.<COSName>any());
    doNothing().when(pdEncryption).setStringFilterName(Mockito.<COSName>any());
    when(pdEncryption.getCOSObject()).thenReturn(new COSDictionary());
    doNothing().when(pdEncryption).removeV45filters();
    doNothing().when(pdEncryption).setFilter(Mockito.<String>any());
    doNothing().when(pdEncryption).setLength(anyInt());
    doNothing().when(pdEncryption).setSubFilter(Mockito.<String>any());
    doNothing().when(pdEncryption).setVersion(anyInt());
    COSDocument cosDocument = mock(COSDocument.class);
    doNothing().when(cosDocument).setEncryptionDictionary(Mockito.<COSDictionary>any());
    PDDocument doc = mock(PDDocument.class);
    when(doc.getDocument()).thenReturn(cosDocument);
    doNothing().when(doc).setEncryptionDictionary(Mockito.<PDEncryption>any());
    when(doc.getEncryption()).thenReturn(pdEncryption);

    // Act
    publicKeySecurityHandler.prepareDocumentForEncryption(doc);

    // Assert
    verify(cosDocument).setEncryptionDictionary(isA(COSDictionary.class));
    verify(doc).getDocument();
    verify(doc).getEncryption();
    verify(doc).setEncryptionDictionary(isA(PDEncryption.class));
    verify(pdEncryption).getCOSObject();
    verify(pdEncryption).removeV45filters();
    verify(pdEncryption).setDefaultCryptFilterDictionary(isA(PDCryptFilterDictionary.class));
    verify(pdEncryption).setFilter(eq("Adobe.PubSec"));
    verify(pdEncryption).setLength(eq(128));
    verify(pdEncryption).setStreamFilterName(isA(COSName.class));
    verify(pdEncryption).setStringFilterName(isA(COSName.class));
    verify(pdEncryption).setSubFilter(eq("adbe.pkcs7.s5"));
    verify(pdEncryption).setVersion(eq(4));
    assertTrue(publicKeySecurityHandler.isAES());
    assertEquals(Short.SIZE, publicKeySecurityHandler.getEncryptionKey().length);
  }

  /**
   * Method under test:
   * {@link PublicKeySecurityHandler#prepareDocumentForEncryption(PDDocument)}
   */
  @Test
  void testPrepareDocumentForEncryption6() throws IOException {
    // Arrange
    PublicKeyProtectionPolicy publicKeyProtectionPolicy = new PublicKeyProtectionPolicy();
    publicKeyProtectionPolicy.setPreferAES(false);

    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setKeyLength(128);
    publicKeySecurityHandler.setProtectionPolicy(publicKeyProtectionPolicy);
    PDEncryption pdEncryption = mock(PDEncryption.class);
    when(pdEncryption.getCOSObject()).thenReturn(new COSDictionary());
    doNothing().when(pdEncryption).removeV45filters();
    doNothing().when(pdEncryption).setFilter(Mockito.<String>any());
    doNothing().when(pdEncryption).setLength(anyInt());
    doNothing().when(pdEncryption).setRecipients(Mockito.<byte[][]>any());
    doNothing().when(pdEncryption).setSubFilter(Mockito.<String>any());
    doNothing().when(pdEncryption).setVersion(anyInt());
    COSDocument cosDocument = mock(COSDocument.class);
    doNothing().when(cosDocument).setEncryptionDictionary(Mockito.<COSDictionary>any());
    PDDocument doc = mock(PDDocument.class);
    when(doc.getDocument()).thenReturn(cosDocument);
    doNothing().when(doc).setEncryptionDictionary(Mockito.<PDEncryption>any());
    when(doc.getEncryption()).thenReturn(pdEncryption);

    // Act
    publicKeySecurityHandler.prepareDocumentForEncryption(doc);

    // Assert
    verify(cosDocument).setEncryptionDictionary(isA(COSDictionary.class));
    verify(doc).getDocument();
    verify(doc).getEncryption();
    verify(doc).setEncryptionDictionary(isA(PDEncryption.class));
    verify(pdEncryption).getCOSObject();
    verify(pdEncryption).removeV45filters();
    verify(pdEncryption).setFilter(eq("Adobe.PubSec"));
    verify(pdEncryption).setLength(eq(128));
    verify(pdEncryption).setRecipients(isA(byte[][].class));
    verify(pdEncryption).setSubFilter(eq("adbe.pkcs7.s4"));
    verify(pdEncryption).setVersion(eq(2));
    assertFalse(publicKeySecurityHandler.isAES());
    assertEquals(Short.SIZE, publicKeySecurityHandler.getEncryptionKey().length);
  }

  /**
   * Method under test:
   * {@link PublicKeySecurityHandler#prepareDocumentForEncryption(PDDocument)}
   */
  @Test
  void testPrepareDocumentForEncryption7() throws IOException {
    // Arrange
    PublicKeyProtectionPolicy publicKeyProtectionPolicy = new PublicKeyProtectionPolicy();
    publicKeyProtectionPolicy.setPreferAES(true);

    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setKeyLength(128);
    publicKeySecurityHandler.setProtectionPolicy(publicKeyProtectionPolicy);
    PDEncryption pdEncryption = mock(PDEncryption.class);
    doThrow(new RuntimeException(PublicKeySecurityHandler.FILTER)).when(pdEncryption)
        .setDefaultCryptFilterDictionary(Mockito.<PDCryptFilterDictionary>any());
    doNothing().when(pdEncryption).removeV45filters();
    doNothing().when(pdEncryption).setFilter(Mockito.<String>any());
    doNothing().when(pdEncryption).setLength(anyInt());
    doNothing().when(pdEncryption).setSubFilter(Mockito.<String>any());
    doNothing().when(pdEncryption).setVersion(anyInt());
    PDDocument doc = mock(PDDocument.class);
    when(doc.getEncryption()).thenReturn(pdEncryption);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> publicKeySecurityHandler.prepareDocumentForEncryption(doc));
    verify(doc).getEncryption();
    verify(pdEncryption).removeV45filters();
    verify(pdEncryption).setDefaultCryptFilterDictionary(isA(PDCryptFilterDictionary.class));
    verify(pdEncryption).setFilter(eq("Adobe.PubSec"));
    verify(pdEncryption).setLength(eq(128));
    verify(pdEncryption).setSubFilter(eq("adbe.pkcs7.s5"));
    verify(pdEncryption).setVersion(eq(4));
  }

  /**
   * Method under test:
   * {@link PublicKeySecurityHandler#prepareDocumentForEncryption(PDDocument)}
   */
  @Test
  void testPrepareDocumentForEncryption8() throws IOException {
    // Arrange
    PublicKeyProtectionPolicy publicKeyProtectionPolicy = new PublicKeyProtectionPolicy();
    publicKeyProtectionPolicy.setPreferAES(false);

    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setKeyLength(256);
    publicKeySecurityHandler.setProtectionPolicy(publicKeyProtectionPolicy);
    PDEncryption pdEncryption = mock(PDEncryption.class);
    doNothing().when(pdEncryption).setDefaultCryptFilterDictionary(Mockito.<PDCryptFilterDictionary>any());
    doNothing().when(pdEncryption).setStreamFilterName(Mockito.<COSName>any());
    doNothing().when(pdEncryption).setStringFilterName(Mockito.<COSName>any());
    when(pdEncryption.getCOSObject()).thenReturn(new COSDictionary());
    doNothing().when(pdEncryption).removeV45filters();
    doNothing().when(pdEncryption).setFilter(Mockito.<String>any());
    doNothing().when(pdEncryption).setLength(anyInt());
    doNothing().when(pdEncryption).setSubFilter(Mockito.<String>any());
    doNothing().when(pdEncryption).setVersion(anyInt());
    COSDocument cosDocument = mock(COSDocument.class);
    doNothing().when(cosDocument).setEncryptionDictionary(Mockito.<COSDictionary>any());
    PDDocument doc = mock(PDDocument.class);
    when(doc.getDocument()).thenReturn(cosDocument);
    doNothing().when(doc).setEncryptionDictionary(Mockito.<PDEncryption>any());
    when(doc.getEncryption()).thenReturn(pdEncryption);

    // Act
    publicKeySecurityHandler.prepareDocumentForEncryption(doc);

    // Assert
    verify(cosDocument).setEncryptionDictionary(isA(COSDictionary.class));
    verify(doc).getDocument();
    verify(doc).getEncryption();
    verify(doc).setEncryptionDictionary(isA(PDEncryption.class));
    verify(pdEncryption).getCOSObject();
    verify(pdEncryption).removeV45filters();
    verify(pdEncryption).setDefaultCryptFilterDictionary(isA(PDCryptFilterDictionary.class));
    verify(pdEncryption).setFilter(eq("Adobe.PubSec"));
    verify(pdEncryption).setLength(eq(256));
    verify(pdEncryption).setStreamFilterName(isA(COSName.class));
    verify(pdEncryption).setStringFilterName(isA(COSName.class));
    verify(pdEncryption).setSubFilter(eq("adbe.pkcs7.s5"));
    verify(pdEncryption).setVersion(eq(5));
    assertTrue(publicKeySecurityHandler.isAES());
    assertEquals(Integer.SIZE, publicKeySecurityHandler.getEncryptionKey().length);
  }

  /**
   * Method under test:
   * {@link PublicKeySecurityHandler#prepareDocumentForEncryption(PDDocument)}
   */
  @Test
  void testPrepareDocumentForEncryption9() throws IOException {
    // Arrange
    PublicKeyProtectionPolicy publicKeyProtectionPolicy = new PublicKeyProtectionPolicy();
    publicKeyProtectionPolicy.setPreferAES(true);

    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setKeyLength(256);
    publicKeySecurityHandler.setProtectionPolicy(publicKeyProtectionPolicy);
    PDEncryption pdEncryption = mock(PDEncryption.class);
    doThrow(new RuntimeException(PublicKeySecurityHandler.FILTER)).when(pdEncryption)
        .setDefaultCryptFilterDictionary(Mockito.<PDCryptFilterDictionary>any());
    doNothing().when(pdEncryption).removeV45filters();
    doNothing().when(pdEncryption).setFilter(Mockito.<String>any());
    doNothing().when(pdEncryption).setLength(anyInt());
    doNothing().when(pdEncryption).setSubFilter(Mockito.<String>any());
    doNothing().when(pdEncryption).setVersion(anyInt());
    PDDocument doc = mock(PDDocument.class);
    when(doc.getEncryption()).thenReturn(pdEncryption);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> publicKeySecurityHandler.prepareDocumentForEncryption(doc));
    verify(doc).getEncryption();
    verify(pdEncryption).removeV45filters();
    verify(pdEncryption).setDefaultCryptFilterDictionary(isA(PDCryptFilterDictionary.class));
    verify(pdEncryption).setFilter(eq("Adobe.PubSec"));
    verify(pdEncryption).setLength(eq(256));
    verify(pdEncryption).setSubFilter(eq("adbe.pkcs7.s5"));
    verify(pdEncryption).setVersion(eq(5));
  }

  /**
   * Method under test:
   * {@link PublicKeySecurityHandler#PublicKeySecurityHandler(PublicKeyProtectionPolicy)}
   */
  @Test
  void testNewPublicKeySecurityHandler2() {
    // Arrange
    PublicKeyProtectionPolicy publicKeyProtectionPolicy = new PublicKeyProtectionPolicy();

    // Act
    PublicKeySecurityHandler actualPublicKeySecurityHandler = new PublicKeySecurityHandler(publicKeyProtectionPolicy);

    // Assert
    assertNull(actualPublicKeySecurityHandler.getEncryptionKey());
    assertNull(actualPublicKeySecurityHandler.getCurrentAccessPermission());
    assertFalse(actualPublicKeySecurityHandler.isAES());
    assertFalse(actualPublicKeySecurityHandler.isDecryptMetadata());
    assertTrue(actualPublicKeySecurityHandler.hasProtectionPolicy());
    assertEquals(PDEncryption.DEFAULT_LENGTH, actualPublicKeySecurityHandler.getKeyLength());
    assertSame(publicKeyProtectionPolicy, actualPublicKeySecurityHandler.getProtectionPolicy());
  }
}

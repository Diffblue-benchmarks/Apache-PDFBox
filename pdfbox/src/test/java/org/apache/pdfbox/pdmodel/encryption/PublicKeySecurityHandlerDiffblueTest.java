package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PublicKeySecurityHandlerDiffblueTest {
  /**
   * Test {@link PublicKeySecurityHandler#PublicKeySecurityHandler()}.
   *
   * <p>Method under test: {@link PublicKeySecurityHandler#PublicKeySecurityHandler()}
   */
  @Test
  @DisplayName("Test new PublicKeySecurityHandler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PublicKeySecurityHandler.<init>()"})
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
   * Test {@link PublicKeySecurityHandler#PublicKeySecurityHandler(PublicKeyProtectionPolicy)}.
   *
   * <ul>
   *   <li>Then return EncryptionKey is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PublicKeySecurityHandler#PublicKeySecurityHandler(PublicKeyProtectionPolicy)}
   */
  @Test
  @DisplayName(
      "Test new PublicKeySecurityHandler(PublicKeyProtectionPolicy); then return EncryptionKey is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PublicKeySecurityHandler.<init>(PublicKeyProtectionPolicy)"})
  void testNewPublicKeySecurityHandler_thenReturnEncryptionKeyIsNull() {
    // Arrange
    PublicKeyProtectionPolicy publicKeyProtectionPolicy = new PublicKeyProtectionPolicy();

    // Act
    PublicKeySecurityHandler actualPublicKeySecurityHandler =
        new PublicKeySecurityHandler(publicKeyProtectionPolicy);

    // Assert
    assertNull(actualPublicKeySecurityHandler.getEncryptionKey());
    assertNull(actualPublicKeySecurityHandler.getCurrentAccessPermission());
    assertFalse(actualPublicKeySecurityHandler.isAES());
    assertFalse(actualPublicKeySecurityHandler.isDecryptMetadata());
    assertTrue(actualPublicKeySecurityHandler.hasProtectionPolicy());
    assertEquals(PDEncryption.DEFAULT_LENGTH, actualPublicKeySecurityHandler.getKeyLength());
    assertSame(publicKeyProtectionPolicy, actualPublicKeySecurityHandler.getProtectionPolicy());
  }

  /**
   * Test {@link PublicKeySecurityHandler#prepareForDecryption(PDEncryption, COSArray,
   * DecryptionMaterial)}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PublicKeySecurityHandler#prepareForDecryption(PDEncryption,
   * COSArray, DecryptionMaterial)}
   */
  @Test
  @DisplayName(
      "Test prepareForDecryption(PDEncryption, COSArray, DecryptionMaterial); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PublicKeySecurityHandler.prepareForDecryption(PDEncryption, COSArray, DecryptionMaterial)"
  })
  void testPrepareForDecryption_thenThrowIOException() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    PDEncryption encryption = new PDEncryption();
    COSArray documentIDArray = new COSArray();

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            publicKeySecurityHandler.prepareForDecryption(
                encryption, documentIDArray, new StandardDecryptionMaterial("Pwd")));
  }

  /**
   * Test {@link PublicKeySecurityHandler#prepareDocumentForEncryption(PDDocument)}.
   *
   * <ul>
   *   <li>Then {@link PDDocument#PDDocument()} Encryption SubFilter is {@code adbe.pkcs7.s4}.
   * </ul>
   *
   * <p>Method under test: {@link PublicKeySecurityHandler#prepareDocumentForEncryption(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test prepareDocumentForEncryption(PDDocument); then PDDocument() Encryption SubFilter is 'adbe.pkcs7.s4'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PublicKeySecurityHandler.prepareDocumentForEncryption(PDDocument)"})
  void testPrepareDocumentForEncryption_thenPDDocumentEncryptionSubFilterIsAdbePkcs7S4()
      throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setProtectionPolicy(new PublicKeyProtectionPolicy());
    PDDocument doc = new PDDocument();

    // Act
    publicKeySecurityHandler.prepareDocumentForEncryption(doc);

    // Assert
    PDEncryption encryption = doc.getEncryption();
    assertEquals("adbe.pkcs7.s4", encryption.getSubFilter());
    assertNull(encryption.getOwnerEncryptionKey());
    assertNull(encryption.getOwnerKey());
    assertNull(encryption.getPerms());
    assertNull(encryption.getUserEncryptionKey());
    assertNull(encryption.getUserKey());
    assertNull(encryption.getDefaultCryptFilterDictionary());
    assertNull(encryption.getStdCryptFilterDictionary());
    assertEquals(0, encryption.getPermissions());
    assertEquals(0, encryption.getRecipientsLength());
    assertEquals(0, encryption.getRevision());
    assertEquals(1, encryption.getVersion());
    assertTrue(doc.getDocument().isEncrypted());
    assertTrue(doc.isEncrypted());
    assertTrue(encryption.hasSecurityHandler());
    assertTrue(encryption.isEncryptMetaData());
    assertEquals(PDEncryption.DEFAULT_LENGTH, encryption.getLength());
    assertEquals(PublicKeySecurityHandler.FILTER, encryption.getFilter());
  }
}

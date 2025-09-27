package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StandardSecurityHandlerDiffblueTest {
  /**
   * Test {@link StandardSecurityHandler#StandardSecurityHandler()}.
   *
   * <p>Method under test: {@link StandardSecurityHandler#StandardSecurityHandler()}
   */
  @Test
  @DisplayName("Test new StandardSecurityHandler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardSecurityHandler.<init>()"})
  void testNewStandardSecurityHandler() {
    // Arrange and Act
    StandardSecurityHandler actualStandardSecurityHandler = new StandardSecurityHandler();

    // Assert
    assertNull(actualStandardSecurityHandler.getEncryptionKey());
    assertNull(actualStandardSecurityHandler.getCurrentAccessPermission());
    assertNull(actualStandardSecurityHandler.getProtectionPolicy());
    assertFalse(actualStandardSecurityHandler.hasProtectionPolicy());
    assertFalse(actualStandardSecurityHandler.isAES());
    assertFalse(actualStandardSecurityHandler.isDecryptMetadata());
    assertEquals(PDEncryption.DEFAULT_LENGTH, actualStandardSecurityHandler.getKeyLength());
  }

  /**
   * Test {@link StandardSecurityHandler#StandardSecurityHandler(StandardProtectionPolicy)}.
   *
   * <ul>
   *   <li>Then return EncryptionKey is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StandardSecurityHandler#StandardSecurityHandler(StandardProtectionPolicy)}
   */
  @Test
  @DisplayName(
      "Test new StandardSecurityHandler(StandardProtectionPolicy); then return EncryptionKey is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardSecurityHandler.<init>(StandardProtectionPolicy)"})
  void testNewStandardSecurityHandler_thenReturnEncryptionKeyIsNull() {
    // Arrange
    StandardProtectionPolicy standardProtectionPolicy =
        new StandardProtectionPolicy(
            "iloveyou", "iloveyou", AccessPermission.getOwnerAccessPermission());

    // Act
    StandardSecurityHandler actualStandardSecurityHandler =
        new StandardSecurityHandler(standardProtectionPolicy);

    // Assert
    assertNull(actualStandardSecurityHandler.getEncryptionKey());
    assertNull(actualStandardSecurityHandler.getCurrentAccessPermission());
    assertFalse(actualStandardSecurityHandler.isAES());
    assertFalse(actualStandardSecurityHandler.isDecryptMetadata());
    assertTrue(actualStandardSecurityHandler.hasProtectionPolicy());
    assertEquals(PDEncryption.DEFAULT_LENGTH, actualStandardSecurityHandler.getKeyLength());
    assertSame(standardProtectionPolicy, actualStandardSecurityHandler.getProtectionPolicy());
  }

  /**
   * Test {@link StandardSecurityHandler#prepareForDecryption(PDEncryption, COSArray,
   * DecryptionMaterial)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardSecurityHandler#prepareForDecryption(PDEncryption,
   * COSArray, DecryptionMaterial)}
   */
  @Test
  @DisplayName(
      "Test prepareForDecryption(PDEncryption, COSArray, DecryptionMaterial); when 'null'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StandardSecurityHandler.prepareForDecryption(PDEncryption, COSArray, DecryptionMaterial)"
  })
  void testPrepareForDecryption_whenNull_thenThrowIOException() throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    PDEncryption encryption = new PDEncryption();

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            standardSecurityHandler.prepareForDecryption(
                encryption, null, new StandardDecryptionMaterial("Pwd")));
  }

  /**
   * Test {@link StandardSecurityHandler#prepareForDecryption(PDEncryption, COSArray,
   * DecryptionMaterial)}.
   *
   * <ul>
   *   <li>When {@link PDEncryption#PDEncryption()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardSecurityHandler#prepareForDecryption(PDEncryption,
   * COSArray, DecryptionMaterial)}
   */
  @Test
  @DisplayName(
      "Test prepareForDecryption(PDEncryption, COSArray, DecryptionMaterial); when PDEncryption(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StandardSecurityHandler.prepareForDecryption(PDEncryption, COSArray, DecryptionMaterial)"
  })
  void testPrepareForDecryption_whenPDEncryption_thenThrowIOException() throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    PDEncryption encryption = new PDEncryption();
    COSArray documentIDArray = new COSArray();

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            standardSecurityHandler.prepareForDecryption(
                encryption, documentIDArray, new StandardDecryptionMaterial("Pwd")));
  }

  /**
   * Test {@link StandardSecurityHandler#prepareForDecryption(PDEncryption, COSArray,
   * DecryptionMaterial)}.
   *
   * <ul>
   *   <li>When {@link StandardDecryptionMaterial#StandardDecryptionMaterial(String)} with pwd is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StandardSecurityHandler#prepareForDecryption(PDEncryption,
   * COSArray, DecryptionMaterial)}
   */
  @Test
  @DisplayName(
      "Test prepareForDecryption(PDEncryption, COSArray, DecryptionMaterial); when StandardDecryptionMaterial(String) with pwd is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StandardSecurityHandler.prepareForDecryption(PDEncryption, COSArray, DecryptionMaterial)"
  })
  void testPrepareForDecryption_whenStandardDecryptionMaterialWithPwdIsNull() throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    PDEncryption encryption = new PDEncryption();
    COSArray documentIDArray = new COSArray();

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            standardSecurityHandler.prepareForDecryption(
                encryption, documentIDArray, new StandardDecryptionMaterial(null)));
  }

  /**
   * Test {@link StandardSecurityHandler#prepareDocumentForEncryption(PDDocument)}.
   *
   * <p>Method under test: {@link StandardSecurityHandler#prepareDocumentForEncryption(PDDocument)}
   */
  @Test
  @DisplayName("Test prepareDocumentForEncryption(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardSecurityHandler.prepareDocumentForEncryption(PDDocument)"})
  void testPrepareDocumentForEncryption() throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    StandardProtectionPolicy standardProtectionPolicy =
        new StandardProtectionPolicy(null, "iloveyou", new AccessPermission(4));
    standardSecurityHandler.setProtectionPolicy(standardProtectionPolicy);
    PDDocument document = new PDDocument();

    // Act
    standardSecurityHandler.prepareDocumentForEncryption(document);

    // Assert
    PDEncryption encryption = document.getEncryption();
    assertNull(encryption.getOwnerEncryptionKey());
    assertNull(encryption.getPerms());
    assertNull(encryption.getUserEncryptionKey());
    assertNull(encryption.getSubFilter());
    assertNull(encryption.getDefaultCryptFilterDictionary());
    assertNull(encryption.getStdCryptFilterDictionary());
    assertEquals(4, encryption.getPermissions());
    assertTrue(encryption.hasSecurityHandler());
    assertTrue(encryption.isEncryptMetaData());
    assertEquals(PDEncryption.DEFAULT_LENGTH, encryption.getLength());
    assertArrayEquals(
        new byte[] {
          -69,
          -48,
          -51,
          '\'',
          'm',
          -106,
          -107,
          'm',
          18,
          -22,
          -64,
          -26,
          31,
          '9',
          14,
          -60,
          -115,
          -96,
          -111,
          Byte.MIN_VALUE,
          -35,
          -58,
          '8',
          -107,
          'S',
          -30,
          -55,
          'T',
          '.',
          'W',
          'P',
          '1'
        },
        encryption.getOwnerKey());
  }

  /**
   * Test {@link StandardSecurityHandler#prepareDocumentForEncryption(PDDocument)}.
   *
   * <p>Method under test: {@link StandardSecurityHandler#prepareDocumentForEncryption(PDDocument)}
   */
  @Test
  @DisplayName("Test prepareDocumentForEncryption(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardSecurityHandler.prepareDocumentForEncryption(PDDocument)"})
  void testPrepareDocumentForEncryption2() throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    StandardProtectionPolicy standardProtectionPolicy =
        new StandardProtectionPolicy("iloveyou", null, new AccessPermission(4));
    standardSecurityHandler.setProtectionPolicy(standardProtectionPolicy);
    PDDocument document = new PDDocument();

    // Act
    standardSecurityHandler.prepareDocumentForEncryption(document);

    // Assert
    PDEncryption encryption = document.getEncryption();
    assertNull(encryption.getOwnerEncryptionKey());
    assertNull(encryption.getPerms());
    assertNull(encryption.getUserEncryptionKey());
    assertNull(encryption.getSubFilter());
    assertNull(encryption.getDefaultCryptFilterDictionary());
    assertNull(encryption.getStdCryptFilterDictionary());
    assertEquals(4, encryption.getPermissions());
    assertTrue(encryption.hasSecurityHandler());
    assertTrue(encryption.isEncryptMetaData());
    assertEquals(PDEncryption.DEFAULT_LENGTH, encryption.getLength());
    assertArrayEquals(
        new byte[] {
          -6, 3, -20, 15, 'F', -102, 'p', 'Y', '^', 'U', -64, -18, -82, -74, -123, -115, -57, -114,
          -33, '`', -14, 'T', 7, 29, 'R', -64, '`', 28, -102, 'l', 7, -53
        },
        encryption.getOwnerKey());
  }

  /**
   * Test {@link StandardSecurityHandler#prepareDocumentForEncryption(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link StandardSecurityHandler#prepareDocumentForEncryption(PDDocument)}
   */
  @Test
  @DisplayName("Test prepareDocumentForEncryption(PDDocument); given ByteArrayOutputStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardSecurityHandler.prepareDocumentForEncryption(PDDocument)"})
  void testPrepareDocumentForEncryption_givenByteArrayOutputStream() throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    StandardProtectionPolicy standardProtectionPolicy =
        new StandardProtectionPolicy("iloveyou", "iloveyou", new AccessPermission(4));
    standardSecurityHandler.setProtectionPolicy(standardProtectionPolicy);

    PDDocument document = new PDDocument();
    document.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);

    // Act
    standardSecurityHandler.prepareDocumentForEncryption(document);

    // Assert
    assertArrayEquals(
        new byte[] {
          -69,
          -48,
          -51,
          '\'',
          'm',
          -106,
          -107,
          'm',
          18,
          -22,
          -64,
          -26,
          31,
          '9',
          14,
          -60,
          -115,
          -96,
          -111,
          Byte.MIN_VALUE,
          -35,
          -58,
          '8',
          -107,
          'S',
          -30,
          -55,
          'T',
          '.',
          'W',
          'P',
          '1'
        },
        document.getEncryption().getOwnerKey());
  }

  /**
   * Test {@link StandardSecurityHandler#prepareDocumentForEncryption(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()}.
   * </ul>
   *
   * <p>Method under test: {@link StandardSecurityHandler#prepareDocumentForEncryption(PDDocument)}
   */
  @Test
  @DisplayName("Test prepareDocumentForEncryption(PDDocument); given PDEncryption()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardSecurityHandler.prepareDocumentForEncryption(PDDocument)"})
  void testPrepareDocumentForEncryption_givenPDEncryption() throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    StandardProtectionPolicy standardProtectionPolicy =
        new StandardProtectionPolicy("iloveyou", "iloveyou", new AccessPermission(4));
    standardSecurityHandler.setProtectionPolicy(standardProtectionPolicy);

    PDDocument document = new PDDocument();
    document.setEncryptionDictionary(new PDEncryption());

    // Act
    standardSecurityHandler.prepareDocumentForEncryption(document);

    // Assert
    PDEncryption encryption = document.getEncryption();
    assertNull(encryption.getOwnerEncryptionKey());
    assertNull(encryption.getPerms());
    assertNull(encryption.getUserEncryptionKey());
    assertNull(encryption.getSubFilter());
    assertNull(encryption.getDefaultCryptFilterDictionary());
    assertNull(encryption.getStdCryptFilterDictionary());
    assertTrue(encryption.hasSecurityHandler());
    assertTrue(encryption.isEncryptMetaData());
    assertEquals(PDEncryption.DEFAULT_LENGTH, encryption.getLength());
    assertArrayEquals(
        new byte[] {
          -69,
          -48,
          -51,
          '\'',
          'm',
          -106,
          -107,
          'm',
          18,
          -22,
          -64,
          -26,
          31,
          '9',
          14,
          -60,
          -115,
          -96,
          -111,
          Byte.MIN_VALUE,
          -35,
          -58,
          '8',
          -107,
          'S',
          -30,
          -55,
          'T',
          '.',
          'W',
          'P',
          '1'
        },
        encryption.getOwnerKey());
  }

  /**
   * Test {@link StandardSecurityHandler#prepareDocumentForEncryption(PDDocument)}.
   *
   * <ul>
   *   <li>Then {@link PDDocument#PDDocument()} Encryption Permissions is eleven.
   * </ul>
   *
   * <p>Method under test: {@link StandardSecurityHandler#prepareDocumentForEncryption(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test prepareDocumentForEncryption(PDDocument); then PDDocument() Encryption Permissions is eleven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardSecurityHandler.prepareDocumentForEncryption(PDDocument)"})
  void testPrepareDocumentForEncryption_thenPDDocumentEncryptionPermissionsIsEleven()
      throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    StandardProtectionPolicy standardProtectionPolicy =
        new StandardProtectionPolicy("iloveyou", "iloveyou", new AccessPermission(11));
    standardSecurityHandler.setProtectionPolicy(standardProtectionPolicy);
    PDDocument document = new PDDocument();

    // Act
    standardSecurityHandler.prepareDocumentForEncryption(document);

    // Assert
    PDEncryption encryption = document.getEncryption();
    assertNull(encryption.getOwnerEncryptionKey());
    assertNull(encryption.getPerms());
    assertNull(encryption.getUserEncryptionKey());
    assertNull(encryption.getSubFilter());
    assertNull(encryption.getDefaultCryptFilterDictionary());
    assertNull(encryption.getStdCryptFilterDictionary());
    assertEquals(11, encryption.getPermissions());
    assertTrue(encryption.hasSecurityHandler());
    assertTrue(encryption.isEncryptMetaData());
    assertEquals(PDEncryption.DEFAULT_LENGTH, encryption.getLength());
    assertArrayEquals(
        new byte[] {
          -69,
          -48,
          -51,
          '\'',
          'm',
          -106,
          -107,
          'm',
          18,
          -22,
          -64,
          -26,
          31,
          '9',
          14,
          -60,
          -115,
          -96,
          -111,
          Byte.MIN_VALUE,
          -35,
          -58,
          '8',
          -107,
          'S',
          -30,
          -55,
          'T',
          '.',
          'W',
          'P',
          '1'
        },
        encryption.getOwnerKey());
  }

  /**
   * Test {@link StandardSecurityHandler#prepareDocumentForEncryption(PDDocument)}.
   *
   * <ul>
   *   <li>Then {@link PDDocument#PDDocument()} Encryption Permissions is four.
   * </ul>
   *
   * <p>Method under test: {@link StandardSecurityHandler#prepareDocumentForEncryption(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test prepareDocumentForEncryption(PDDocument); then PDDocument() Encryption Permissions is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardSecurityHandler.prepareDocumentForEncryption(PDDocument)"})
  void testPrepareDocumentForEncryption_thenPDDocumentEncryptionPermissionsIsFour()
      throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    StandardProtectionPolicy standardProtectionPolicy =
        new StandardProtectionPolicy("iloveyou", "iloveyou", new AccessPermission(4));
    standardSecurityHandler.setProtectionPolicy(standardProtectionPolicy);
    PDDocument document = new PDDocument();

    // Act
    standardSecurityHandler.prepareDocumentForEncryption(document);

    // Assert
    PDEncryption encryption = document.getEncryption();
    assertNull(encryption.getOwnerEncryptionKey());
    assertNull(encryption.getPerms());
    assertNull(encryption.getUserEncryptionKey());
    assertNull(encryption.getSubFilter());
    assertNull(encryption.getDefaultCryptFilterDictionary());
    assertNull(encryption.getStdCryptFilterDictionary());
    assertEquals(4, encryption.getPermissions());
    assertTrue(encryption.hasSecurityHandler());
    assertTrue(encryption.isEncryptMetaData());
    assertEquals(PDEncryption.DEFAULT_LENGTH, encryption.getLength());
    assertArrayEquals(
        new byte[] {
          -69,
          -48,
          -51,
          '\'',
          'm',
          -106,
          -107,
          'm',
          18,
          -22,
          -64,
          -26,
          31,
          '9',
          14,
          -60,
          -115,
          -96,
          -111,
          Byte.MIN_VALUE,
          -35,
          -58,
          '8',
          -107,
          'S',
          -30,
          -55,
          'T',
          '.',
          'W',
          'P',
          '1'
        },
        encryption.getOwnerKey());
  }

  /**
   * Test {@link StandardSecurityHandler#prepareDocumentForEncryption(PDDocument)}.
   *
   * <ul>
   *   <li>Then {@link PDDocument#PDDocument()} Encryption Permissions is {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link StandardSecurityHandler#prepareDocumentForEncryption(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test prepareDocumentForEncryption(PDDocument); then PDDocument() Encryption Permissions is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardSecurityHandler.prepareDocumentForEncryption(PDDocument)"})
  void testPrepareDocumentForEncryption_thenPDDocumentEncryptionPermissionsIsMin_value()
      throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    StandardProtectionPolicy standardProtectionPolicy =
        new StandardProtectionPolicy(
            "iloveyou", "iloveyou", new AccessPermission(Integer.MIN_VALUE));
    standardSecurityHandler.setProtectionPolicy(standardProtectionPolicy);
    PDDocument document = new PDDocument();

    // Act
    standardSecurityHandler.prepareDocumentForEncryption(document);

    // Assert
    PDEncryption encryption = document.getEncryption();
    assertNull(encryption.getOwnerEncryptionKey());
    assertNull(encryption.getPerms());
    assertNull(encryption.getUserEncryptionKey());
    assertNull(encryption.getSubFilter());
    assertNull(encryption.getDefaultCryptFilterDictionary());
    assertNull(encryption.getStdCryptFilterDictionary());
    assertTrue(encryption.hasSecurityHandler());
    assertTrue(encryption.isEncryptMetaData());
    assertEquals(Integer.MIN_VALUE, encryption.getPermissions());
    assertEquals(PDEncryption.DEFAULT_LENGTH, encryption.getLength());
    assertArrayEquals(
        new byte[] {
          -69,
          -48,
          -51,
          '\'',
          'm',
          -106,
          -107,
          'm',
          18,
          -22,
          -64,
          -26,
          31,
          '9',
          14,
          -60,
          -115,
          -96,
          -111,
          Byte.MIN_VALUE,
          -35,
          -58,
          '8',
          -107,
          'S',
          -30,
          -55,
          'T',
          '.',
          'W',
          'P',
          '1'
        },
        encryption.getOwnerKey());
  }

  /**
   * Test {@link StandardSecurityHandler#isOwnerPassword(byte[], byte[], byte[], int, byte[], int,
   * int, boolean)} with {@code ownerPassword}, {@code user}, {@code owner}, {@code permissions},
   * {@code id}, {@code encRevision}, {@code keyLengthInBytes}, {@code encryptMetadata}.
   *
   * <p>Method under test: {@link StandardSecurityHandler#isOwnerPassword(byte[], byte[], byte[],
   * int, byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test isOwnerPassword(byte[], byte[], byte[], int, byte[], int, int, boolean) with 'ownerPassword', 'user', 'owner', 'permissions', 'id', 'encRevision', 'keyLengthInBytes', 'encryptMetadata'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StandardSecurityHandler.isOwnerPassword(byte[], byte[], byte[], int, byte[], int, int, boolean)"
  })
  void
      testIsOwnerPasswordWithOwnerPasswordUserOwnerPermissionsIdEncRevisionKeyLengthInBytesEncryptMetadata()
          throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new StandardSecurityHandler()
                .isOwnerPassword(
                    "AXAXAXAX".getBytes("UTF-8"),
                    "AXAXAXAX".getBytes("UTF-8"),
                    "AXAXAXAX".getBytes("UTF-8"),
                    1,
                    "AXAXAXAX".getBytes("UTF-8"),
                    1,
                    3,
                    true));
  }

  /**
   * Test {@link StandardSecurityHandler#isOwnerPassword(byte[], byte[], byte[], int, byte[], int,
   * int, boolean)} with {@code ownerPassword}, {@code user}, {@code owner}, {@code permissions},
   * {@code id}, {@code encRevision}, {@code keyLengthInBytes}, {@code encryptMetadata}.
   *
   * <p>Method under test: {@link StandardSecurityHandler#isOwnerPassword(byte[], byte[], byte[],
   * int, byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test isOwnerPassword(byte[], byte[], byte[], int, byte[], int, int, boolean) with 'ownerPassword', 'user', 'owner', 'permissions', 'id', 'encRevision', 'keyLengthInBytes', 'encryptMetadata'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StandardSecurityHandler.isOwnerPassword(byte[], byte[], byte[], int, byte[], int, int, boolean)"
  })
  void
      testIsOwnerPasswordWithOwnerPasswordUserOwnerPermissionsIdEncRevisionKeyLengthInBytesEncryptMetadata2()
          throws IOException {
    // Arrange, Act and Assert
    assertFalse(
        new StandardSecurityHandler()
            .isOwnerPassword(
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                null,
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                1,
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                2,
                3,
                false));
  }

  /**
   * Test {@link StandardSecurityHandler#isOwnerPassword(byte[], byte[], byte[], int, byte[], int,
   * int, boolean)} with {@code ownerPassword}, {@code user}, {@code owner}, {@code permissions},
   * {@code id}, {@code encRevision}, {@code keyLengthInBytes}, {@code encryptMetadata}.
   *
   * <p>Method under test: {@link StandardSecurityHandler#isOwnerPassword(byte[], byte[], byte[],
   * int, byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test isOwnerPassword(byte[], byte[], byte[], int, byte[], int, int, boolean) with 'ownerPassword', 'user', 'owner', 'permissions', 'id', 'encRevision', 'keyLengthInBytes', 'encryptMetadata'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StandardSecurityHandler.isOwnerPassword(byte[], byte[], byte[], int, byte[], int, int, boolean)"
  })
  void
      testIsOwnerPasswordWithOwnerPasswordUserOwnerPermissionsIdEncRevisionKeyLengthInBytesEncryptMetadata3()
          throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new StandardSecurityHandler()
                .isOwnerPassword(
                    new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                    null,
                    new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                    1,
                    new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                    5,
                    3,
                    false));
  }

  /**
   * Test {@link StandardSecurityHandler#isOwnerPassword(String, byte[], byte[], int, byte[], int,
   * int, boolean)} with {@code password}, {@code user}, {@code owner}, {@code permissions}, {@code
   * id}, {@code encRevision}, {@code keyLengthInBytes}, {@code encryptMetadata}.
   *
   * <p>Method under test: {@link StandardSecurityHandler#isOwnerPassword(String, byte[], byte[],
   * int, byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test isOwnerPassword(String, byte[], byte[], int, byte[], int, int, boolean) with 'password', 'user', 'owner', 'permissions', 'id', 'encRevision', 'keyLengthInBytes', 'encryptMetadata'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StandardSecurityHandler.isOwnerPassword(String, byte[], byte[], int, byte[], int, int, boolean)"
  })
  void
      testIsOwnerPasswordWithPasswordUserOwnerPermissionsIdEncRevisionKeyLengthInBytesEncryptMetadata()
          throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new StandardSecurityHandler()
                .isOwnerPassword(
                    "iloveyou",
                    "AXAXAXAX".getBytes("UTF-8"),
                    "AXAXAXAX".getBytes("UTF-8"),
                    1,
                    "AXAXAXAX".getBytes("UTF-8"),
                    1,
                    3,
                    true));
  }

  /**
   * Test {@link StandardSecurityHandler#isOwnerPassword(String, byte[], byte[], int, byte[], int,
   * int, boolean)} with {@code password}, {@code user}, {@code owner}, {@code permissions}, {@code
   * id}, {@code encRevision}, {@code keyLengthInBytes}, {@code encryptMetadata}.
   *
   * <p>Method under test: {@link StandardSecurityHandler#isOwnerPassword(String, byte[], byte[],
   * int, byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test isOwnerPassword(String, byte[], byte[], int, byte[], int, int, boolean) with 'password', 'user', 'owner', 'permissions', 'id', 'encRevision', 'keyLengthInBytes', 'encryptMetadata'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StandardSecurityHandler.isOwnerPassword(String, byte[], byte[], int, byte[], int, int, boolean)"
  })
  void
      testIsOwnerPasswordWithPasswordUserOwnerPermissionsIdEncRevisionKeyLengthInBytesEncryptMetadata2()
          throws IOException {
    // Arrange, Act and Assert
    assertFalse(
        new StandardSecurityHandler()
            .isOwnerPassword(
                "iloveyou",
                null,
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                1,
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                2,
                3,
                false));
  }

  /**
   * Test {@link StandardSecurityHandler#isOwnerPassword(String, byte[], byte[], int, byte[], int,
   * int, boolean)} with {@code password}, {@code user}, {@code owner}, {@code permissions}, {@code
   * id}, {@code encRevision}, {@code keyLengthInBytes}, {@code encryptMetadata}.
   *
   * <p>Method under test: {@link StandardSecurityHandler#isOwnerPassword(String, byte[], byte[],
   * int, byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test isOwnerPassword(String, byte[], byte[], int, byte[], int, int, boolean) with 'password', 'user', 'owner', 'permissions', 'id', 'encRevision', 'keyLengthInBytes', 'encryptMetadata'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StandardSecurityHandler.isOwnerPassword(String, byte[], byte[], int, byte[], int, int, boolean)"
  })
  void
      testIsOwnerPasswordWithPasswordUserOwnerPermissionsIdEncRevisionKeyLengthInBytesEncryptMetadata3()
          throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new StandardSecurityHandler()
                .isOwnerPassword(
                    "iloveyou",
                    null,
                    new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                    1,
                    new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                    5,
                    3,
                    false));
  }

  /**
   * Test {@link StandardSecurityHandler#getUserPassword(byte[], byte[], int, int)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus sixteen and minus sixty-two.
   * </ul>
   *
   * <p>Method under test: {@link StandardSecurityHandler#getUserPassword(byte[], byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test getUserPassword(byte[], byte[], int, int); then return array of byte with minus sixteen and minus sixty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] StandardSecurityHandler.getUserPassword(byte[], byte[], int, int)"})
  void testGetUserPassword_thenReturnArrayOfByteWithMinusSixteenAndMinusSixtyTwo()
      throws IOException {
    // Arrange and Act
    byte[] actualUserPassword =
        new StandardSecurityHandler()
            .getUserPassword(
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                2,
                3);

    // Assert
    assertArrayEquals(new byte[] {-16, -62, 'a', 'H', 'T', -37, '/', -98}, actualUserPassword);
  }

  /**
   * Test {@link StandardSecurityHandler#getUserPassword(byte[], byte[], int, int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link StandardSecurityHandler#getUserPassword(byte[], byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test getUserPassword(byte[], byte[], int, int); when 'AXAXAXAX' Bytes is 'UTF-8'; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] StandardSecurityHandler.getUserPassword(byte[], byte[], int, int)"})
  void testGetUserPassword_whenAxaxaxaxBytesIsUtf8_thenReturnEmptyArrayOfByte() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {},
        new StandardSecurityHandler()
            .getUserPassword("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Test {@link StandardSecurityHandler#getUserPassword(byte[], byte[], int, int)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link StandardSecurityHandler#getUserPassword(byte[], byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test getUserPassword(byte[], byte[], int, int); when five; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] StandardSecurityHandler.getUserPassword(byte[], byte[], int, int)"})
  void testGetUserPassword_whenFive_thenReturnEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    byte[] actualUserPassword =
        new StandardSecurityHandler()
            .getUserPassword(
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                5,
                3);

    // Assert
    assertArrayEquals(new byte[] {}, actualUserPassword);
  }

  /**
   * Test {@link StandardSecurityHandler#getUserPassword(byte[], byte[], int, int)}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link StandardSecurityHandler#getUserPassword(byte[], byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test getUserPassword(byte[], byte[], int, int); when six; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] StandardSecurityHandler.getUserPassword(byte[], byte[], int, int)"})
  void testGetUserPassword_whenSix_thenReturnEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    byte[] actualUserPassword =
        new StandardSecurityHandler()
            .getUserPassword(
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                6,
                3);

    // Assert
    assertArrayEquals(new byte[] {}, actualUserPassword);
  }

  /**
   * Test {@link StandardSecurityHandler#computeEncryptedKey(byte[], byte[], byte[], byte[], byte[],
   * int, byte[], int, int, boolean, boolean)}.
   *
   * <p>Method under test: {@link StandardSecurityHandler#computeEncryptedKey(byte[], byte[],
   * byte[], byte[], byte[], int, byte[], int, int, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test computeEncryptedKey(byte[], byte[], byte[], byte[], byte[], int, byte[], int, int, boolean, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] StandardSecurityHandler.computeEncryptedKey(byte[], byte[], byte[], byte[], byte[], int, byte[], int, int, boolean, boolean)"
  })
  void testComputeEncryptedKey() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "-w\n".getBytes("UTF-8"),
        new StandardSecurityHandler()
            .computeEncryptedKey(
                "AXAXAXAX".getBytes("UTF-8"),
                "AXAXAXAX".getBytes("UTF-8"),
                "AXAXAXAX".getBytes("UTF-8"),
                "AXAXAXAX".getBytes("UTF-8"),
                "AXAXAXAX".getBytes("UTF-8"),
                1,
                "AXAXAXAX".getBytes("UTF-8"),
                1,
                3,
                true,
                true));
  }

  /**
   * Test {@link StandardSecurityHandler#computeUserPassword(byte[], byte[], int, byte[], int, int,
   * boolean)}.
   *
   * <p>Method under test: {@link StandardSecurityHandler#computeUserPassword(byte[], byte[], int,
   * byte[], int, int, boolean)}
   */
  @Test
  @DisplayName("Test computeUserPassword(byte[], byte[], int, byte[], int, int, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] StandardSecurityHandler.computeUserPassword(byte[], byte[], int, byte[], int, int, boolean)"
  })
  void testComputeUserPassword() throws IOException {
    // Arrange and Act
    byte[] actualComputeUserPasswordResult =
        new StandardSecurityHandler()
            .computeUserPassword(
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                1,
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                2,
                3,
                false);

    // Assert
    assertArrayEquals(
        new byte[] {
          -123, '}', 18, -45, '2', -119, -26, -24, -72, -41, '\t', -48, -7, -32, -81, 'n', -120,
          -113, '[', 22, 'D', -61, 'J', -127, 'F', -42, -108, -56, 'h', ')', -13, -94
        },
        actualComputeUserPasswordResult);
  }

  /**
   * Test {@link StandardSecurityHandler#computeUserPassword(byte[], byte[], int, byte[], int, int,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link StandardSecurityHandler#computeUserPassword(byte[], byte[], int,
   * byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test computeUserPassword(byte[], byte[], int, byte[], int, int, boolean); when 'AXAXAXAX' Bytes is 'UTF-8'; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] StandardSecurityHandler.computeUserPassword(byte[], byte[], int, byte[], int, int, boolean)"
  })
  void testComputeUserPassword_whenAxaxaxaxBytesIsUtf8_thenReturnEmptyArrayOfByte()
      throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {},
        new StandardSecurityHandler()
            .computeUserPassword(
                "AXAXAXAX".getBytes("UTF-8"),
                "AXAXAXAX".getBytes("UTF-8"),
                1,
                "AXAXAXAX".getBytes("UTF-8"),
                1,
                3,
                true));
  }

  /**
   * Test {@link StandardSecurityHandler#computeUserPassword(byte[], byte[], int, byte[], int, int,
   * boolean)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link StandardSecurityHandler#computeUserPassword(byte[], byte[], int,
   * byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test computeUserPassword(byte[], byte[], int, byte[], int, int, boolean); when five; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] StandardSecurityHandler.computeUserPassword(byte[], byte[], int, byte[], int, int, boolean)"
  })
  void testComputeUserPassword_whenFive_thenReturnEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    byte[] actualComputeUserPasswordResult =
        new StandardSecurityHandler()
            .computeUserPassword(
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                1,
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                5,
                3,
                false);

    // Assert
    assertArrayEquals(new byte[] {}, actualComputeUserPasswordResult);
  }

  /**
   * Test {@link StandardSecurityHandler#computeUserPassword(byte[], byte[], int, byte[], int, int,
   * boolean)}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link StandardSecurityHandler#computeUserPassword(byte[], byte[], int,
   * byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test computeUserPassword(byte[], byte[], int, byte[], int, int, boolean); when six; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] StandardSecurityHandler.computeUserPassword(byte[], byte[], int, byte[], int, int, boolean)"
  })
  void testComputeUserPassword_whenSix_thenReturnEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    byte[] actualComputeUserPasswordResult =
        new StandardSecurityHandler()
            .computeUserPassword(
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                1,
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                6,
                3,
                false);

    // Assert
    assertArrayEquals(new byte[] {}, actualComputeUserPasswordResult);
  }

  /**
   * Test {@link StandardSecurityHandler#computeOwnerPassword(byte[], byte[], int, int)}.
   *
   * <p>Method under test: {@link StandardSecurityHandler#computeOwnerPassword(byte[], byte[], int,
   * int)}
   */
  @Test
  @DisplayName("Test computeOwnerPassword(byte[], byte[], int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] StandardSecurityHandler.computeOwnerPassword(byte[], byte[], int, int)"
  })
  void testComputeOwnerPassword() throws IOException {
    // Arrange and Act
    byte[] actualComputeOwnerPasswordResult =
        new StandardSecurityHandler()
            .computeOwnerPassword(
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                2,
                5);

    // Assert
    assertArrayEquals(
        new byte[] {
          -125, -101, -26, 29, '\f', -43, 11, 'u', 'X', '-', 25, 'C', 'S', 30, 31, 'N', 23, 'k',
          -77, -87, ';', 18, 17, -53, -21, -125, -106, 16, 'H', -120, 'T', -18
        },
        actualComputeOwnerPasswordResult);
  }

  /**
   * Test {@link StandardSecurityHandler#computeOwnerPassword(byte[], byte[], int, int)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus sixteen and minus sixty-two.
   * </ul>
   *
   * <p>Method under test: {@link StandardSecurityHandler#computeOwnerPassword(byte[], byte[], int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test computeOwnerPassword(byte[], byte[], int, int); then return array of byte with minus sixteen and minus sixty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] StandardSecurityHandler.computeOwnerPassword(byte[], byte[], int, int)"
  })
  void testComputeOwnerPassword_thenReturnArrayOfByteWithMinusSixteenAndMinusSixtyTwo()
      throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          -16, -62, 'a', 'H', 'T', -37, '/', -98, '?', 'e', -58, 28, -116, -34, 'U', 't', -20, '~',
          'P', '\b', -84, -69, ']', '\n', -43, -86, 11, 'L', '7', -14, -77, -73
        },
        new StandardSecurityHandler()
            .computeOwnerPassword(
                "AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Test {@link StandardSecurityHandler#computeOwnerPassword(byte[], byte[], int, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardSecurityHandler#computeOwnerPassword(byte[], byte[], int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test computeOwnerPassword(byte[], byte[], int, int); when two; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] StandardSecurityHandler.computeOwnerPassword(byte[], byte[], int, int)"
  })
  void testComputeOwnerPassword_whenTwo_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new StandardSecurityHandler()
                .computeOwnerPassword(
                    "AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link StandardSecurityHandler#isUserPassword(byte[], byte[], byte[], int, byte[], int,
   * int, boolean)} with {@code byte[]}, {@code byte[]}, {@code byte[]}, {@code int}, {@code
   * byte[]}, {@code int}, {@code int}, {@code boolean}.
   *
   * <p>Method under test: {@link StandardSecurityHandler#isUserPassword(byte[], byte[], byte[],
   * int, byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test isUserPassword(byte[], byte[], byte[], int, byte[], int, int, boolean) with 'byte[]', 'byte[]', 'byte[]', 'int', 'byte[]', 'int', 'int', 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StandardSecurityHandler.isUserPassword(byte[], byte[], byte[], int, byte[], int, int, boolean)"
  })
  void testIsUserPasswordWithByteByteByteIntByteIntIntBoolean() throws IOException {
    // Arrange and Act
    boolean actualIsUserPasswordResult =
        new StandardSecurityHandler()
            .isUserPassword(
                new byte[] {2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                1,
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                2,
                3,
                false);

    // Assert
    assertFalse(actualIsUserPasswordResult);
  }

  /**
   * Test {@link StandardSecurityHandler#isUserPassword(byte[], byte[], byte[], int, byte[], int,
   * int, boolean)} with {@code byte[]}, {@code byte[]}, {@code byte[]}, {@code int}, {@code
   * byte[]}, {@code int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardSecurityHandler#isUserPassword(byte[], byte[], byte[],
   * int, byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test isUserPassword(byte[], byte[], byte[], int, byte[], int, int, boolean) with 'byte[]', 'byte[]', 'byte[]', 'int', 'byte[]', 'int', 'int', 'boolean'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StandardSecurityHandler.isUserPassword(byte[], byte[], byte[], int, byte[], int, int, boolean)"
  })
  void testIsUserPasswordWithByteByteByteIntByteIntIntBoolean_thenThrowIOException()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new StandardSecurityHandler()
                .isUserPassword(
                    "AXAXAXAX".getBytes("UTF-8"),
                    "AXAXAXAX".getBytes("UTF-8"),
                    "AXAXAXAX".getBytes("UTF-8"),
                    1,
                    "AXAXAXAX".getBytes("UTF-8"),
                    1,
                    3,
                    true));
  }

  /**
   * Test {@link StandardSecurityHandler#isUserPassword(byte[], byte[], byte[], int, byte[], int,
   * int, boolean)} with {@code byte[]}, {@code byte[]}, {@code byte[]}, {@code int}, {@code
   * byte[]}, {@code int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StandardSecurityHandler#isUserPassword(byte[], byte[], byte[],
   * int, byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test isUserPassword(byte[], byte[], byte[], int, byte[], int, int, boolean) with 'byte[]', 'byte[]', 'byte[]', 'int', 'byte[]', 'int', 'int', 'boolean'; when two; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StandardSecurityHandler.isUserPassword(byte[], byte[], byte[], int, byte[], int, int, boolean)"
  })
  void testIsUserPasswordWithByteByteByteIntByteIntIntBoolean_whenTwo_thenReturnFalse()
      throws IOException {
    // Arrange and Act
    boolean actualIsUserPasswordResult =
        new StandardSecurityHandler()
            .isUserPassword(
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                1,
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                2,
                3,
                false);

    // Assert
    assertFalse(actualIsUserPasswordResult);
  }

  /**
   * Test {@link StandardSecurityHandler#isUserPassword(String, byte[], byte[], int, byte[], int,
   * int, boolean)} with {@code String}, {@code byte[]}, {@code byte[]}, {@code int}, {@code
   * byte[]}, {@code int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardSecurityHandler#isUserPassword(String, byte[], byte[],
   * int, byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test isUserPassword(String, byte[], byte[], int, byte[], int, int, boolean) with 'String', 'byte[]', 'byte[]', 'int', 'byte[]', 'int', 'int', 'boolean'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StandardSecurityHandler.isUserPassword(String, byte[], byte[], int, byte[], int, int, boolean)"
  })
  void testIsUserPasswordWithStringByteByteIntByteIntIntBoolean_thenThrowIOException()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new StandardSecurityHandler()
                .isUserPassword(
                    "iloveyou",
                    "AXAXAXAX".getBytes("UTF-8"),
                    "AXAXAXAX".getBytes("UTF-8"),
                    1,
                    "AXAXAXAX".getBytes("UTF-8"),
                    1,
                    3,
                    true));
  }

  /**
   * Test {@link StandardSecurityHandler#isUserPassword(String, byte[], byte[], int, byte[], int,
   * int, boolean)} with {@code String}, {@code byte[]}, {@code byte[]}, {@code int}, {@code
   * byte[]}, {@code int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StandardSecurityHandler#isUserPassword(String, byte[], byte[],
   * int, byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test isUserPassword(String, byte[], byte[], int, byte[], int, int, boolean) with 'String', 'byte[]', 'byte[]', 'int', 'byte[]', 'int', 'int', 'boolean'; when two; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StandardSecurityHandler.isUserPassword(String, byte[], byte[], int, byte[], int, int, boolean)"
  })
  void testIsUserPasswordWithStringByteByteIntByteIntIntBoolean_whenTwo_thenReturnFalse()
      throws IOException {
    // Arrange, Act and Assert
    assertFalse(
        new StandardSecurityHandler()
            .isUserPassword(
                "iloveyou",
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                1,
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                2,
                3,
                false));
  }
}

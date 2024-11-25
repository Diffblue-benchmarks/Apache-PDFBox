package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StandardSecurityHandlerDiffblueTest {
  /**
   * Test {@link StandardSecurityHandler#StandardSecurityHandler()}.
   * <p>
   * Method under test: {@link StandardSecurityHandler#StandardSecurityHandler()}
   */
  @Test
  @DisplayName("Test new StandardSecurityHandler()")
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
   * Test
   * {@link StandardSecurityHandler#StandardSecurityHandler(StandardProtectionPolicy)}.
   * <ul>
   *   <li>Then return EncryptionKey is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#StandardSecurityHandler(StandardProtectionPolicy)}
   */
  @Test
  @DisplayName("Test new StandardSecurityHandler(StandardProtectionPolicy); then return EncryptionKey is 'null'")
  void testNewStandardSecurityHandler_thenReturnEncryptionKeyIsNull() {
    // Arrange
    StandardProtectionPolicy standardProtectionPolicy = new StandardProtectionPolicy("iloveyou", "iloveyou",
        AccessPermission.getOwnerAccessPermission());

    // Act
    StandardSecurityHandler actualStandardSecurityHandler = new StandardSecurityHandler(standardProtectionPolicy);

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
   * Test
   * {@link StandardSecurityHandler#prepareForDecryption(PDEncryption, COSArray, DecryptionMaterial)}.
   * <ul>
   *   <li>When {@link PDEncryption#PDEncryption()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#prepareForDecryption(PDEncryption, COSArray, DecryptionMaterial)}
   */
  @Test
  @DisplayName("Test prepareForDecryption(PDEncryption, COSArray, DecryptionMaterial); when PDEncryption(); then throw IOException")
  void testPrepareForDecryption_whenPDEncryption_thenThrowIOException() throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    PDEncryption encryption = new PDEncryption();
    COSArray documentIDArray = new COSArray();

    // Act and Assert
    assertThrows(IOException.class, () -> standardSecurityHandler.prepareForDecryption(encryption, documentIDArray,
        new StandardDecryptionMaterial("Pwd")));
  }

  /**
   * Test
   * {@link StandardSecurityHandler#prepareForDecryption(PDEncryption, COSArray, DecryptionMaterial)}.
   * <ul>
   *   <li>When {@link PDEncryption#PDEncryption()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#prepareForDecryption(PDEncryption, COSArray, DecryptionMaterial)}
   */
  @Test
  @DisplayName("Test prepareForDecryption(PDEncryption, COSArray, DecryptionMaterial); when PDEncryption(); then throw IOException")
  void testPrepareForDecryption_whenPDEncryption_thenThrowIOException2() throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    PDEncryption encryption = new PDEncryption();

    // Act and Assert
    assertThrows(IOException.class,
        () -> standardSecurityHandler.prepareForDecryption(encryption, null, new StandardDecryptionMaterial("Pwd")));
  }

  /**
   * Test
   * {@link StandardSecurityHandler#prepareDocumentForEncryption(PDDocument)}.
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#prepareDocumentForEncryption(PDDocument)}
   */
  @Test
  @DisplayName("Test prepareDocumentForEncryption(PDDocument)")
  void testPrepareDocumentForEncryption() throws IOException {
    // Arrange
    AccessPermission permissions = mock(AccessPermission.class);
    when(permissions.hasAnyRevision3PermissionSet()).thenReturn(false);
    when(permissions.getPermissionBytes()).thenReturn(Integer.MIN_VALUE);
    StandardProtectionPolicy standardProtectionPolicy = new StandardProtectionPolicy("iloveyou", "iloveyou",
        permissions);

    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    standardSecurityHandler.setProtectionPolicy(standardProtectionPolicy);
    COSDocument cosDocument = mock(COSDocument.class);
    doNothing().when(cosDocument).setEncryptionDictionary(Mockito.<COSDictionary>any());
    when(cosDocument.getDocumentID()).thenReturn(new COSArray());
    doNothing().when(cosDocument).setDocumentID(Mockito.<COSArray>any());
    PDDocument document = mock(PDDocument.class);
    doNothing().when(document).setEncryptionDictionary(Mockito.<PDEncryption>any());
    when(document.getDocument()).thenReturn(cosDocument);
    when(document.getEncryption()).thenReturn(new PDEncryption());

    // Act
    standardSecurityHandler.prepareDocumentForEncryption(document);

    // Assert
    verify(cosDocument).getDocumentID();
    verify(cosDocument).setDocumentID(isA(COSArray.class));
    verify(cosDocument).setEncryptionDictionary(isA(COSDictionary.class));
    verify(document, atLeast(1)).getDocument();
    verify(document).getEncryption();
    verify(document).setEncryptionDictionary(isA(PDEncryption.class));
    verify(permissions).getPermissionBytes();
    verify(permissions).hasAnyRevision3PermissionSet();
    assertEquals(5, standardSecurityHandler.getEncryptionKey().length);
  }

  /**
   * Test
   * {@link StandardSecurityHandler#prepareDocumentForEncryption(PDDocument)}.
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#prepareDocumentForEncryption(PDDocument)}
   */
  @Test
  @DisplayName("Test prepareDocumentForEncryption(PDDocument)")
  void testPrepareDocumentForEncryption2() throws IOException {
    // Arrange
    AccessPermission permissions = mock(AccessPermission.class);
    when(permissions.hasAnyRevision3PermissionSet()).thenReturn(false);
    when(permissions.getPermissionBytes()).thenReturn(1);
    StandardProtectionPolicy standardProtectionPolicy = new StandardProtectionPolicy("iloveyou", "iloveyou",
        permissions);

    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    standardSecurityHandler.setProtectionPolicy(standardProtectionPolicy);
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSString.parseHex("0123456789ABCDEF"));
    when(cosArray.size()).thenReturn(3);
    COSDocument cosDocument = mock(COSDocument.class);
    doNothing().when(cosDocument).setEncryptionDictionary(Mockito.<COSDictionary>any());
    when(cosDocument.getDocumentID()).thenReturn(cosArray);
    PDDocument document = mock(PDDocument.class);
    doNothing().when(document).setEncryptionDictionary(Mockito.<PDEncryption>any());
    when(document.getDocument()).thenReturn(cosDocument);
    when(document.getEncryption()).thenReturn(new PDEncryption());

    // Act
    standardSecurityHandler.prepareDocumentForEncryption(document);

    // Assert
    verify(cosArray).getObject(eq(0));
    verify(cosArray).size();
    verify(cosDocument).getDocumentID();
    verify(cosDocument).setEncryptionDictionary(isA(COSDictionary.class));
    verify(document, atLeast(1)).getDocument();
    verify(document).getEncryption();
    verify(document).setEncryptionDictionary(isA(PDEncryption.class));
    verify(permissions).getPermissionBytes();
    verify(permissions).hasAnyRevision3PermissionSet();
    assertArrayEquals(new byte[]{-33, '9', -33, -50, '3'}, standardSecurityHandler.getEncryptionKey());
  }

  /**
   * Test
   * {@link StandardSecurityHandler#prepareDocumentForEncryption(PDDocument)}.
   * <ul>
   *   <li>Then array length is five.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#prepareDocumentForEncryption(PDDocument)}
   */
  @Test
  @DisplayName("Test prepareDocumentForEncryption(PDDocument); then array length is five")
  void testPrepareDocumentForEncryption_thenArrayLengthIsFive() throws IOException {
    // Arrange
    AccessPermission permissions = mock(AccessPermission.class);
    when(permissions.hasAnyRevision3PermissionSet()).thenReturn(false);
    when(permissions.getPermissionBytes()).thenReturn(1);
    StandardProtectionPolicy standardProtectionPolicy = new StandardProtectionPolicy("iloveyou", "iloveyou",
        permissions);

    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    standardSecurityHandler.setProtectionPolicy(standardProtectionPolicy);
    COSDocument cosDocument = mock(COSDocument.class);
    doNothing().when(cosDocument).setEncryptionDictionary(Mockito.<COSDictionary>any());
    when(cosDocument.getDocumentID()).thenReturn(new COSArray());
    doNothing().when(cosDocument).setDocumentID(Mockito.<COSArray>any());
    PDDocument document = mock(PDDocument.class);
    doNothing().when(document).setEncryptionDictionary(Mockito.<PDEncryption>any());
    when(document.getDocument()).thenReturn(cosDocument);
    when(document.getEncryption()).thenReturn(new PDEncryption());

    // Act
    standardSecurityHandler.prepareDocumentForEncryption(document);

    // Assert
    verify(cosDocument).getDocumentID();
    verify(cosDocument).setDocumentID(isA(COSArray.class));
    verify(cosDocument).setEncryptionDictionary(isA(COSDictionary.class));
    verify(document, atLeast(1)).getDocument();
    verify(document).getEncryption();
    verify(document).setEncryptionDictionary(isA(PDEncryption.class));
    verify(permissions).getPermissionBytes();
    verify(permissions).hasAnyRevision3PermissionSet();
    assertEquals(5, standardSecurityHandler.getEncryptionKey().length);
  }

  /**
   * Test
   * {@link StandardSecurityHandler#prepareDocumentForEncryption(PDDocument)}.
   * <ul>
   *   <li>Then calls {@link PDEncryption#getCOSObject()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#prepareDocumentForEncryption(PDDocument)}
   */
  @Test
  @DisplayName("Test prepareDocumentForEncryption(PDDocument); then calls getCOSObject()")
  void testPrepareDocumentForEncryption_thenCallsGetCOSObject() throws IOException {
    // Arrange
    AccessPermission permissions = mock(AccessPermission.class);
    when(permissions.hasAnyRevision3PermissionSet()).thenReturn(false);
    when(permissions.getPermissionBytes()).thenReturn(1);
    StandardProtectionPolicy standardProtectionPolicy = new StandardProtectionPolicy("iloveyou", "iloveyou",
        permissions);

    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    standardSecurityHandler.setProtectionPolicy(standardProtectionPolicy);
    PDEncryption pdEncryption = mock(PDEncryption.class);
    when(pdEncryption.getCOSObject()).thenReturn(new COSDictionary());
    doNothing().when(pdEncryption).setOwnerKey(Mockito.<byte[]>any());
    doNothing().when(pdEncryption).setUserKey(Mockito.<byte[]>any());
    doNothing().when(pdEncryption).removeV45filters();
    doNothing().when(pdEncryption).setFilter(Mockito.<String>any());
    doNothing().when(pdEncryption).setLength(anyInt());
    doNothing().when(pdEncryption).setPermissions(anyInt());
    doNothing().when(pdEncryption).setRevision(anyInt());
    doNothing().when(pdEncryption).setVersion(anyInt());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSString.parseHex("0123456789ABCDEF"));
    when(cosArray.size()).thenReturn(3);
    COSDocument cosDocument = mock(COSDocument.class);
    doNothing().when(cosDocument).setEncryptionDictionary(Mockito.<COSDictionary>any());
    when(cosDocument.getDocumentID()).thenReturn(cosArray);
    PDDocument document = mock(PDDocument.class);
    doNothing().when(document).setEncryptionDictionary(Mockito.<PDEncryption>any());
    when(document.getDocument()).thenReturn(cosDocument);
    when(document.getEncryption()).thenReturn(pdEncryption);

    // Act
    standardSecurityHandler.prepareDocumentForEncryption(document);

    // Assert
    verify(cosArray).getObject(eq(0));
    verify(cosArray).size();
    verify(cosDocument).getDocumentID();
    verify(cosDocument).setEncryptionDictionary(isA(COSDictionary.class));
    verify(document, atLeast(1)).getDocument();
    verify(document).getEncryption();
    verify(document).setEncryptionDictionary(isA(PDEncryption.class));
    verify(permissions).getPermissionBytes();
    verify(permissions).hasAnyRevision3PermissionSet();
    verify(pdEncryption).getCOSObject();
    verify(pdEncryption).removeV45filters();
    verify(pdEncryption).setFilter(eq("Standard"));
    verify(pdEncryption).setLength(eq(40));
    verify(pdEncryption).setOwnerKey(isA(byte[].class));
    verify(pdEncryption).setPermissions(eq(1));
    verify(pdEncryption).setRevision(eq(2));
    verify(pdEncryption).setUserKey(isA(byte[].class));
    verify(pdEncryption).setVersion(eq(1));
    assertArrayEquals(new byte[]{-33, '9', -33, -50, '3'}, standardSecurityHandler.getEncryptionKey());
  }

  /**
   * Test
   * {@link StandardSecurityHandler#prepareDocumentForEncryption(PDDocument)}.
   * <ul>
   *   <li>Then throw {@link InvalidPasswordException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#prepareDocumentForEncryption(PDDocument)}
   */
  @Test
  @DisplayName("Test prepareDocumentForEncryption(PDDocument); then throw InvalidPasswordException")
  void testPrepareDocumentForEncryption_thenThrowInvalidPasswordException() throws IOException {
    // Arrange
    AccessPermission permissions = mock(AccessPermission.class);
    when(permissions.hasAnyRevision3PermissionSet()).thenReturn(false);
    when(permissions.getPermissionBytes()).thenReturn(1);
    StandardProtectionPolicy standardProtectionPolicy = new StandardProtectionPolicy("iloveyou", "iloveyou",
        permissions);

    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    standardSecurityHandler.setProtectionPolicy(standardProtectionPolicy);
    PDEncryption pdEncryption = mock(PDEncryption.class);
    doThrow(new InvalidPasswordException("An error occurred")).when(pdEncryption).setOwnerKey(Mockito.<byte[]>any());
    doNothing().when(pdEncryption).removeV45filters();
    doNothing().when(pdEncryption).setFilter(Mockito.<String>any());
    doNothing().when(pdEncryption).setLength(anyInt());
    doNothing().when(pdEncryption).setPermissions(anyInt());
    doNothing().when(pdEncryption).setRevision(anyInt());
    doNothing().when(pdEncryption).setVersion(anyInt());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSString.parseHex("0123456789ABCDEF"));
    when(cosArray.size()).thenReturn(3);
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.getDocumentID()).thenReturn(cosArray);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    when(document.getEncryption()).thenReturn(pdEncryption);

    // Act and Assert
    assertThrows(InvalidPasswordException.class, () -> standardSecurityHandler.prepareDocumentForEncryption(document));
    verify(cosArray).getObject(eq(0));
    verify(cosArray).size();
    verify(cosDocument).getDocumentID();
    verify(document).getDocument();
    verify(document).getEncryption();
    verify(permissions).getPermissionBytes();
    verify(permissions).hasAnyRevision3PermissionSet();
    verify(pdEncryption).removeV45filters();
    verify(pdEncryption).setFilter(eq("Standard"));
    verify(pdEncryption).setLength(eq(40));
    verify(pdEncryption).setOwnerKey(isA(byte[].class));
    verify(pdEncryption).setPermissions(eq(1));
    verify(pdEncryption).setRevision(eq(2));
    verify(pdEncryption).setVersion(eq(1));
  }

  /**
   * Test
   * {@link StandardSecurityHandler#isOwnerPassword(byte[], byte[], byte[], int, byte[], int, int, boolean)}
   * with {@code ownerPassword}, {@code user}, {@code owner}, {@code permissions},
   * {@code id}, {@code encRevision}, {@code keyLengthInBytes},
   * {@code encryptMetadata}.
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#isOwnerPassword(byte[], byte[], byte[], int, byte[], int, int, boolean)}
   */
  @Test
  @DisplayName("Test isOwnerPassword(byte[], byte[], byte[], int, byte[], int, int, boolean) with 'ownerPassword', 'user', 'owner', 'permissions', 'id', 'encRevision', 'keyLengthInBytes', 'encryptMetadata'")
  void testIsOwnerPasswordWithOwnerPasswordUserOwnerPermissionsIdEncRevisionKeyLengthInBytesEncryptMetadata()
      throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    byte[] ownerPassword = "AXAXAXAX".getBytes("UTF-8");
    byte[] user = "AXAXAXAX".getBytes("UTF-8");
    byte[] owner = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> standardSecurityHandler.isOwnerPassword(ownerPassword, user, owner, 1,
        "AXAXAXAX".getBytes("UTF-8"), 1, 3, true));
  }

  /**
   * Test
   * {@link StandardSecurityHandler#isOwnerPassword(byte[], byte[], byte[], int, byte[], int, int, boolean)}
   * with {@code ownerPassword}, {@code user}, {@code owner}, {@code permissions},
   * {@code id}, {@code encRevision}, {@code keyLengthInBytes},
   * {@code encryptMetadata}.
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#isOwnerPassword(byte[], byte[], byte[], int, byte[], int, int, boolean)}
   */
  @Test
  @DisplayName("Test isOwnerPassword(byte[], byte[], byte[], int, byte[], int, int, boolean) with 'ownerPassword', 'user', 'owner', 'permissions', 'id', 'encRevision', 'keyLengthInBytes', 'encryptMetadata'")
  void testIsOwnerPasswordWithOwnerPasswordUserOwnerPermissionsIdEncRevisionKeyLengthInBytesEncryptMetadata2()
      throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    byte[] ownerPassword = "AXAXAXAX".getBytes("UTF-8");
    byte[] user = "AXAXAXAX".getBytes("UTF-8");
    byte[] owner = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(standardSecurityHandler.isOwnerPassword(ownerPassword, user, owner, 1, "AXAXAXAX".getBytes("UTF-8"), 2,
        3, true));
  }

  /**
   * Test
   * {@link StandardSecurityHandler#isOwnerPassword(byte[], byte[], byte[], int, byte[], int, int, boolean)}
   * with {@code ownerPassword}, {@code user}, {@code owner}, {@code permissions},
   * {@code id}, {@code encRevision}, {@code keyLengthInBytes},
   * {@code encryptMetadata}.
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#isOwnerPassword(byte[], byte[], byte[], int, byte[], int, int, boolean)}
   */
  @Test
  @DisplayName("Test isOwnerPassword(byte[], byte[], byte[], int, byte[], int, int, boolean) with 'ownerPassword', 'user', 'owner', 'permissions', 'id', 'encRevision', 'keyLengthInBytes', 'encryptMetadata'")
  void testIsOwnerPasswordWithOwnerPasswordUserOwnerPermissionsIdEncRevisionKeyLengthInBytesEncryptMetadata3()
      throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    byte[] ownerPassword = "AXAXAXAX".getBytes("UTF-8");
    byte[] user = "AXAXAXAX".getBytes("UTF-8");
    byte[] owner = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> standardSecurityHandler.isOwnerPassword(ownerPassword, user, owner, 1,
        "AXAXAXAX".getBytes("UTF-8"), 5, 3, true));
  }

  /**
   * Test
   * {@link StandardSecurityHandler#isOwnerPassword(String, byte[], byte[], int, byte[], int, int, boolean)}
   * with {@code password}, {@code user}, {@code owner}, {@code permissions},
   * {@code id}, {@code encRevision}, {@code keyLengthInBytes},
   * {@code encryptMetadata}.
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#isOwnerPassword(String, byte[], byte[], int, byte[], int, int, boolean)}
   */
  @Test
  @DisplayName("Test isOwnerPassword(String, byte[], byte[], int, byte[], int, int, boolean) with 'password', 'user', 'owner', 'permissions', 'id', 'encRevision', 'keyLengthInBytes', 'encryptMetadata'")
  void testIsOwnerPasswordWithPasswordUserOwnerPermissionsIdEncRevisionKeyLengthInBytesEncryptMetadata()
      throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    byte[] user = "AXAXAXAX".getBytes("UTF-8");
    byte[] owner = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> standardSecurityHandler.isOwnerPassword("iloveyou", user, owner, 1,
        "AXAXAXAX".getBytes("UTF-8"), 1, 3, true));
  }

  /**
   * Test
   * {@link StandardSecurityHandler#isOwnerPassword(String, byte[], byte[], int, byte[], int, int, boolean)}
   * with {@code password}, {@code user}, {@code owner}, {@code permissions},
   * {@code id}, {@code encRevision}, {@code keyLengthInBytes},
   * {@code encryptMetadata}.
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#isOwnerPassword(String, byte[], byte[], int, byte[], int, int, boolean)}
   */
  @Test
  @DisplayName("Test isOwnerPassword(String, byte[], byte[], int, byte[], int, int, boolean) with 'password', 'user', 'owner', 'permissions', 'id', 'encRevision', 'keyLengthInBytes', 'encryptMetadata'")
  void testIsOwnerPasswordWithPasswordUserOwnerPermissionsIdEncRevisionKeyLengthInBytesEncryptMetadata2()
      throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    byte[] user = "AXAXAXAX".getBytes("UTF-8");
    byte[] owner = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(
        standardSecurityHandler.isOwnerPassword("iloveyou", user, owner, 1, "AXAXAXAX".getBytes("UTF-8"), 2, 3, true));
  }

  /**
   * Test
   * {@link StandardSecurityHandler#isOwnerPassword(String, byte[], byte[], int, byte[], int, int, boolean)}
   * with {@code password}, {@code user}, {@code owner}, {@code permissions},
   * {@code id}, {@code encRevision}, {@code keyLengthInBytes},
   * {@code encryptMetadata}.
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#isOwnerPassword(String, byte[], byte[], int, byte[], int, int, boolean)}
   */
  @Test
  @DisplayName("Test isOwnerPassword(String, byte[], byte[], int, byte[], int, int, boolean) with 'password', 'user', 'owner', 'permissions', 'id', 'encRevision', 'keyLengthInBytes', 'encryptMetadata'")
  void testIsOwnerPasswordWithPasswordUserOwnerPermissionsIdEncRevisionKeyLengthInBytesEncryptMetadata3()
      throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    byte[] user = "AXAXAXAX".getBytes("UTF-8");
    byte[] owner = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> standardSecurityHandler.isOwnerPassword("iloveyou", user, owner, 1,
        "AXAXAXAX".getBytes("UTF-8"), 5, 3, true));
  }

  /**
   * Test
   * {@link StandardSecurityHandler#getUserPassword(byte[], byte[], int, int)}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus sixteen and minus
   * sixty-two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#getUserPassword(byte[], byte[], int, int)}
   */
  @Test
  @DisplayName("Test getUserPassword(byte[], byte[], int, int); then return array of byte with minus sixteen and minus sixty-two")
  void testGetUserPassword_thenReturnArrayOfByteWithMinusSixteenAndMinusSixtyTwo() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{-16, -62, 'a', 'H', 'T', -37, '/', -98},
        (new StandardSecurityHandler()).getUserPassword(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 3));
  }

  /**
   * Test
   * {@link StandardSecurityHandler#getUserPassword(byte[], byte[], int, int)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#getUserPassword(byte[], byte[], int, int)}
   */
  @Test
  @DisplayName("Test getUserPassword(byte[], byte[], int, int); when 'AXAXAXAX' Bytes is 'UTF-8'; then return array length is zero")
  void testGetUserPassword_whenAxaxaxaxBytesIsUtf8_thenReturnArrayLengthIsZero() throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    byte[] ownerPassword = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, standardSecurityHandler.getUserPassword(ownerPassword, "AXAXAXAX".getBytes("UTF-8"), 1, 3).length);
  }

  /**
   * Test
   * {@link StandardSecurityHandler#getUserPassword(byte[], byte[], int, int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#getUserPassword(byte[], byte[], int, int)}
   */
  @Test
  @DisplayName("Test getUserPassword(byte[], byte[], int, int); when five; then return array length is zero")
  void testGetUserPassword_whenFive_thenReturnArrayLengthIsZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, (new StandardSecurityHandler()).getUserPassword(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 5, 3).length);
  }

  /**
   * Test
   * {@link StandardSecurityHandler#getUserPassword(byte[], byte[], int, int)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#getUserPassword(byte[], byte[], int, int)}
   */
  @Test
  @DisplayName("Test getUserPassword(byte[], byte[], int, int); when six; then return array length is zero")
  void testGetUserPassword_whenSix_thenReturnArrayLengthIsZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, (new StandardSecurityHandler()).getUserPassword(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 6, 3).length);
  }

  /**
   * Test
   * {@link StandardSecurityHandler#computeEncryptedKey(byte[], byte[], byte[], byte[], byte[], int, byte[], int, int, boolean, boolean)}.
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#computeEncryptedKey(byte[], byte[], byte[], byte[], byte[], int, byte[], int, int, boolean, boolean)}
   */
  @Test
  @DisplayName("Test computeEncryptedKey(byte[], byte[], byte[], byte[], byte[], int, byte[], int, int, boolean, boolean)")
  void testComputeEncryptedKey() throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    byte[] password = "AXAXAXAX".getBytes("UTF-8");
    byte[] o = "AXAXAXAX".getBytes("UTF-8");
    byte[] u = "AXAXAXAX".getBytes("UTF-8");
    byte[] oe = "AXAXAXAX".getBytes("UTF-8");
    byte[] ue = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualComputeEncryptedKeyResult = standardSecurityHandler.computeEncryptedKey(password, o, u, oe, ue, 1,
        "AXAXAXAX".getBytes("UTF-8"), 1, 3, true, true);

    // Assert
    assertArrayEquals("-w\n".getBytes("UTF-8"), actualComputeEncryptedKeyResult);
  }

  /**
   * Test
   * {@link StandardSecurityHandler#computeUserPassword(byte[], byte[], int, byte[], int, int, boolean)}.
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#computeUserPassword(byte[], byte[], int, byte[], int, int, boolean)}
   */
  @Test
  @DisplayName("Test computeUserPassword(byte[], byte[], int, byte[], int, int, boolean)")
  void testComputeUserPassword() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{-123, '}', 18, -45, '2', -119, -26, -24, -72, -41, '\t', -48, -7, -32, -81, 'n', -120, -113, '[', 22,
            'D', -61, 'J', -127, 'F', -42, -108, -56, 'h', ')', -13, -94},
        (new StandardSecurityHandler()).computeUserPassword(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 1, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            2, 3, false));
  }

  /**
   * Test
   * {@link StandardSecurityHandler#computeUserPassword(byte[], byte[], int, byte[], int, int, boolean)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#computeUserPassword(byte[], byte[], int, byte[], int, int, boolean)}
   */
  @Test
  @DisplayName("Test computeUserPassword(byte[], byte[], int, byte[], int, int, boolean); when 'AXAXAXAX' Bytes is 'UTF-8'; then return array length is zero")
  void testComputeUserPassword_whenAxaxaxaxBytesIsUtf8_thenReturnArrayLengthIsZero() throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    byte[] password = "AXAXAXAX".getBytes("UTF-8");
    byte[] owner = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, standardSecurityHandler.computeUserPassword(password, owner, 1, "AXAXAXAX".getBytes("UTF-8"), 1, 3,
        true).length);
  }

  /**
   * Test
   * {@link StandardSecurityHandler#computeUserPassword(byte[], byte[], int, byte[], int, int, boolean)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#computeUserPassword(byte[], byte[], int, byte[], int, int, boolean)}
   */
  @Test
  @DisplayName("Test computeUserPassword(byte[], byte[], int, byte[], int, int, boolean); when five; then return array length is zero")
  void testComputeUserPassword_whenFive_thenReturnArrayLengthIsZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0,
        (new StandardSecurityHandler()).computeUserPassword(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 1, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            5, 3, false).length);
  }

  /**
   * Test
   * {@link StandardSecurityHandler#computeUserPassword(byte[], byte[], int, byte[], int, int, boolean)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#computeUserPassword(byte[], byte[], int, byte[], int, int, boolean)}
   */
  @Test
  @DisplayName("Test computeUserPassword(byte[], byte[], int, byte[], int, int, boolean); when six; then return array length is zero")
  void testComputeUserPassword_whenSix_thenReturnArrayLengthIsZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0,
        (new StandardSecurityHandler()).computeUserPassword(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 1, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            6, 3, false).length);
  }

  /**
   * Test
   * {@link StandardSecurityHandler#computeOwnerPassword(byte[], byte[], int, int)}.
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#computeOwnerPassword(byte[], byte[], int, int)}
   */
  @Test
  @DisplayName("Test computeOwnerPassword(byte[], byte[], int, int)")
  void testComputeOwnerPassword() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{-125, -101, -26, 29, '\f', -43, 11, 'u', 'X', '-', 25, 'C', 'S', 30, 31, 'N', 23, 'k', -77, -87, ';',
            18, 17, -53, -21, -125, -106, 16, 'H', -120, 'T', -18},
        (new StandardSecurityHandler()).computeOwnerPassword(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 5));
  }

  /**
   * Test
   * {@link StandardSecurityHandler#computeOwnerPassword(byte[], byte[], int, int)}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus sixteen and minus
   * sixty-two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#computeOwnerPassword(byte[], byte[], int, int)}
   */
  @Test
  @DisplayName("Test computeOwnerPassword(byte[], byte[], int, int); then return array of byte with minus sixteen and minus sixty-two")
  void testComputeOwnerPassword_thenReturnArrayOfByteWithMinusSixteenAndMinusSixtyTwo() throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    byte[] ownerPassword = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[]{-16, -62, 'a', 'H', 'T', -37, '/', -98, '?', 'e', -58, 28, -116, -34, 'U', 't', -20, '~', 'P', '\b',
            -84, -69, ']', '\n', -43, -86, 11, 'L', '7', -14, -77, -73},
        standardSecurityHandler.computeOwnerPassword(ownerPassword, "AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Test
   * {@link StandardSecurityHandler#computeOwnerPassword(byte[], byte[], int, int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#computeOwnerPassword(byte[], byte[], int, int)}
   */
  @Test
  @DisplayName("Test computeOwnerPassword(byte[], byte[], int, int); when two; then throw IOException")
  void testComputeOwnerPassword_whenTwo_thenThrowIOException() throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    byte[] ownerPassword = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class,
        () -> standardSecurityHandler.computeOwnerPassword(ownerPassword, "AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test
   * {@link StandardSecurityHandler#isUserPassword(byte[], byte[], byte[], int, byte[], int, int, boolean)}
   * with {@code byte[]}, {@code byte[]}, {@code byte[]}, {@code int},
   * {@code byte[]}, {@code int}, {@code int}, {@code boolean}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#isUserPassword(byte[], byte[], byte[], int, byte[], int, int, boolean)}
   */
  @Test
  @DisplayName("Test isUserPassword(byte[], byte[], byte[], int, byte[], int, int, boolean) with 'byte[]', 'byte[]', 'byte[]', 'int', 'byte[]', 'int', 'int', 'boolean'; then throw IOException")
  void testIsUserPasswordWithByteByteByteIntByteIntIntBoolean_thenThrowIOException() throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    byte[] password = "AXAXAXAX".getBytes("UTF-8");
    byte[] user = "AXAXAXAX".getBytes("UTF-8");
    byte[] owner = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> standardSecurityHandler.isUserPassword(password, user, owner, 1,
        "AXAXAXAX".getBytes("UTF-8"), 1, 3, true));
  }

  /**
   * Test
   * {@link StandardSecurityHandler#isUserPassword(byte[], byte[], byte[], int, byte[], int, int, boolean)}
   * with {@code byte[]}, {@code byte[]}, {@code byte[]}, {@code int},
   * {@code byte[]}, {@code int}, {@code int}, {@code boolean}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#isUserPassword(byte[], byte[], byte[], int, byte[], int, int, boolean)}
   */
  @Test
  @DisplayName("Test isUserPassword(byte[], byte[], byte[], int, byte[], int, int, boolean) with 'byte[]', 'byte[]', 'byte[]', 'int', 'byte[]', 'int', 'int', 'boolean'; when two; then return 'false'")
  void testIsUserPasswordWithByteByteByteIntByteIntIntBoolean_whenTwo_thenReturnFalse() throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    byte[] password = "AXAXAXAX".getBytes("UTF-8");
    byte[] user = "AXAXAXAX".getBytes("UTF-8");
    byte[] owner = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(
        standardSecurityHandler.isUserPassword(password, user, owner, 1, "AXAXAXAX".getBytes("UTF-8"), 2, 3, true));
  }

  /**
   * Test
   * {@link StandardSecurityHandler#isUserPassword(String, byte[], byte[], int, byte[], int, int, boolean)}
   * with {@code String}, {@code byte[]}, {@code byte[]}, {@code int},
   * {@code byte[]}, {@code int}, {@code int}, {@code boolean}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#isUserPassword(String, byte[], byte[], int, byte[], int, int, boolean)}
   */
  @Test
  @DisplayName("Test isUserPassword(String, byte[], byte[], int, byte[], int, int, boolean) with 'String', 'byte[]', 'byte[]', 'int', 'byte[]', 'int', 'int', 'boolean'; then throw IOException")
  void testIsUserPasswordWithStringByteByteIntByteIntIntBoolean_thenThrowIOException() throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    byte[] user = "AXAXAXAX".getBytes("UTF-8");
    byte[] owner = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> standardSecurityHandler.isUserPassword("iloveyou", user, owner, 1,
        "AXAXAXAX".getBytes("UTF-8"), 1, 3, true));
  }

  /**
   * Test
   * {@link StandardSecurityHandler#isUserPassword(String, byte[], byte[], int, byte[], int, int, boolean)}
   * with {@code String}, {@code byte[]}, {@code byte[]}, {@code int},
   * {@code byte[]}, {@code int}, {@code int}, {@code boolean}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StandardSecurityHandler#isUserPassword(String, byte[], byte[], int, byte[], int, int, boolean)}
   */
  @Test
  @DisplayName("Test isUserPassword(String, byte[], byte[], int, byte[], int, int, boolean) with 'String', 'byte[]', 'byte[]', 'int', 'byte[]', 'int', 'int', 'boolean'; when two; then return 'false'")
  void testIsUserPasswordWithStringByteByteIntByteIntIntBoolean_whenTwo_thenReturnFalse() throws IOException {
    // Arrange
    StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();
    byte[] user = "AXAXAXAX".getBytes("UTF-8");
    byte[] owner = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(
        standardSecurityHandler.isUserPassword("iloveyou", user, owner, 1, "AXAXAXAX".getBytes("UTF-8"), 2, 3, true));
  }
}

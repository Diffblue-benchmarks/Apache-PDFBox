package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.io.ScratchFile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SecurityHandlerDiffblueTest {
  /**
   * Test {@link SecurityHandler#setDecryptMetadata(boolean)}.
   *
   * <p>Method under test: {@link SecurityHandler#setDecryptMetadata(boolean)}
   */
  @Test
  @DisplayName("Test setDecryptMetadata(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.setDecryptMetadata(boolean)"})
  void testSetDecryptMetadata() {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();

    // Act
    publicKeySecurityHandler.setDecryptMetadata(true);

    // Assert
    assertTrue(publicKeySecurityHandler.isDecryptMetadata());
  }

  /**
   * Test {@link SecurityHandler#isDecryptMetadata()}.
   *
   * <ul>
   *   <li>Given {@link PublicKeySecurityHandler#PublicKeySecurityHandler()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#isDecryptMetadata()}
   */
  @Test
  @DisplayName("Test isDecryptMetadata(); given PublicKeySecurityHandler(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SecurityHandler.isDecryptMetadata()"})
  void testIsDecryptMetadata_givenPublicKeySecurityHandler_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PublicKeySecurityHandler().isDecryptMetadata());
  }

  /**
   * Test {@link SecurityHandler#isDecryptMetadata()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#isDecryptMetadata()}
   */
  @Test
  @DisplayName("Test isDecryptMetadata(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SecurityHandler.isDecryptMetadata()"})
  void testIsDecryptMetadata_thenReturnTrue() {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setDecryptMetadata(true);

    // Act and Assert
    assertTrue(publicKeySecurityHandler.isDecryptMetadata());
  }

  /**
   * Test {@link SecurityHandler#encryptDataRC4(byte[], byte[], OutputStream)} with {@code byte[]},
   * {@code byte[]}, {@code OutputStream}.
   *
   * <p>Method under test: {@link SecurityHandler#encryptDataRC4(byte[], byte[], OutputStream)}
   */
  @Test
  @DisplayName(
      "Test encryptDataRC4(byte[], byte[], OutputStream) with 'byte[]', 'byte[]', 'OutputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.encryptDataRC4(byte[], byte[], OutputStream)"})
  void testEncryptDataRC4WithByteByteOutputStream() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    byte[] finalKey = "AXAXAXAX".getBytes("UTF-8");
    byte[] input = "AXAXAXAX".getBytes("UTF-8");
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    publicKeySecurityHandler.encryptDataRC4(finalKey, input, output);

    // Assert
    assertArrayEquals(new byte[] {-41, 5, 'N', -1, -19, -119, -27, 'K'}, output.toByteArray());
  }

  /**
   * Test {@link SecurityHandler#encryptDataRC4(byte[], byte[], OutputStream)} with {@code byte[]},
   * {@code byte[]}, {@code OutputStream}.
   *
   * <p>Method under test: {@link SecurityHandler#encryptDataRC4(byte[], byte[], OutputStream)}
   */
  @Test
  @DisplayName(
      "Test encryptDataRC4(byte[], byte[], OutputStream) with 'byte[]', 'byte[]', 'OutputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.encryptDataRC4(byte[], byte[], OutputStream)"})
  void testEncryptDataRC4WithByteByteOutputStream2() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    publicKeySecurityHandler.encryptDataRC4(
        new byte[] {-1}, new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, output);

    // Assert
    assertArrayEquals(new byte[] {',', '}', 'n', '|', '1', 11, 'Z', -24}, output.toByteArray());
  }

  /**
   * Test {@link SecurityHandler#encryptDataRC4(byte[], InputStream, OutputStream)} with {@code
   * byte[]}, {@code InputStream}, {@code OutputStream}.
   *
   * <p>Method under test: {@link SecurityHandler#encryptDataRC4(byte[], InputStream, OutputStream)}
   */
  @Test
  @DisplayName(
      "Test encryptDataRC4(byte[], InputStream, OutputStream) with 'byte[]', 'InputStream', 'OutputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.encryptDataRC4(byte[], InputStream, OutputStream)"})
  void testEncryptDataRC4WithByteInputStreamOutputStream() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    byte[] finalKey = "AXAXAXAX".getBytes("UTF-8");
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    publicKeySecurityHandler.encryptDataRC4(finalKey, input, output);

    // Assert
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals(new byte[] {-41, 5, 'N', -1, -19, -119, -27, 'K'}, output.toByteArray());
  }

  /**
   * Test {@link SecurityHandler#encryptDataRC4(byte[], InputStream, OutputStream)} with {@code
   * byte[]}, {@code InputStream}, {@code OutputStream}.
   *
   * <p>Method under test: {@link SecurityHandler#encryptDataRC4(byte[], InputStream, OutputStream)}
   */
  @Test
  @DisplayName(
      "Test encryptDataRC4(byte[], InputStream, OutputStream) with 'byte[]', 'InputStream', 'OutputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.encryptDataRC4(byte[], InputStream, OutputStream)"})
  void testEncryptDataRC4WithByteInputStreamOutputStream2() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    publicKeySecurityHandler.encryptDataRC4(new byte[] {-1}, input, output);

    // Assert
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals(new byte[] {',', '}', 'n', '|', '1', 11, 'Z', -24}, output.toByteArray());
  }

  /**
   * Test {@link SecurityHandler#encryptDataRC4(byte[], InputStream, OutputStream)} with {@code
   * byte[]}, {@code InputStream}, {@code OutputStream}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#encryptDataRC4(byte[], InputStream, OutputStream)}
   */
  @Test
  @DisplayName(
      "Test encryptDataRC4(byte[], InputStream, OutputStream) with 'byte[]', 'InputStream', 'OutputStream'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.encryptDataRC4(byte[], InputStream, OutputStream)"})
  void testEncryptDataRC4WithByteInputStreamOutputStream_thenThrowIOException() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    byte[] finalKey = "AXAXAXAX".getBytes("UTF-8");

    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any())).thenThrow(new IOException());

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            publicKeySecurityHandler.encryptDataRC4(finalKey, input, new ByteArrayOutputStream()));
    verify(input).read(isA(byte[].class));
  }

  /**
   * Test {@link SecurityHandler#decrypt(COSBase, long, long)}.
   *
   * <p>Method under test: {@link SecurityHandler#decrypt(COSBase, long, long)}
   */
  @Test
  @DisplayName("Test decrypt(COSBase, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase SecurityHandler.decrypt(COSBase, long, long)"})
  void testDecrypt() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey("AXAXAXAX".getBytes("UTF-8"));
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream obj =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act
    COSBase actualDecryptResult = publicKeySecurityHandler.decrypt(obj, 1L, 1L);

    // Assert
    assertEquals(0L, obj.getLength());
    assertSame(obj, actualDecryptResult);
  }

  /**
   * Test {@link SecurityHandler#decrypt(COSBase, long, long)}.
   *
   * <p>Method under test: {@link SecurityHandler#decrypt(COSBase, long, long)}
   */
  @Test
  @DisplayName("Test decrypt(COSBase, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase SecurityHandler.decrypt(COSBase, long, long)"})
  void testDecrypt2() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey("AXAXAXAX".getBytes("UTF-8"));
    COSStream obj =
        new COSStream(null, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act
    COSBase actualDecryptResult = publicKeySecurityHandler.decrypt(obj, 1L, 1L);

    // Assert
    assertEquals(0L, obj.getLength());
    assertSame(obj, actualDecryptResult);
  }

  /**
   * Test {@link SecurityHandler#decrypt(COSBase, long, long)}.
   *
   * <p>Method under test: {@link SecurityHandler#decrypt(COSBase, long, long)}
   */
  @Test
  @DisplayName("Test decrypt(COSBase, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase SecurityHandler.decrypt(COSBase, long, long)"})
  void testDecrypt3() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey("AXAXAXAX".getBytes("UTF-8"));
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream obj = new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 3L));

    // Act
    COSBase actualDecryptResult = publicKeySecurityHandler.decrypt(obj, 1L, 1L);

    // Assert
    assertEquals(3L, obj.getLength());
    assertSame(obj, actualDecryptResult);
  }

  /**
   * Test {@link SecurityHandler#decrypt(COSBase, long, long)}.
   *
   * <p>Method under test: {@link SecurityHandler#decrypt(COSBase, long, long)}
   */
  @Test
  @DisplayName("Test decrypt(COSBase, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase SecurityHandler.decrypt(COSBase, long, long)"})
  void testDecrypt4() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey("AXAXAXAX".getBytes("UTF-8"));
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream obj =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, Long.MAX_VALUE));

    // Act
    COSBase actualDecryptResult = publicKeySecurityHandler.decrypt(obj, 1L, 1L);

    // Assert
    assertEquals(7L, obj.getLength());
    assertSame(obj, actualDecryptResult);
  }

  /**
   * Test {@link SecurityHandler#decrypt(COSBase, long, long)}.
   *
   * <p>Method under test: {@link SecurityHandler#decrypt(COSBase, long, long)}
   */
  @Test
  @DisplayName("Test decrypt(COSBase, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase SecurityHandler.decrypt(COSBase, long, long)"})
  void testDecrypt5() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setAES(true);
    publicKeySecurityHandler.setEncryptionKey("AXAXAXAX".getBytes("UTF-8"));
    COSStream obj =
        new COSStream(null, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act
    COSBase actualDecryptResult = publicKeySecurityHandler.decrypt(obj, 1L, 1L);

    // Assert
    assertEquals(0L, obj.getLength());
    assertSame(obj, actualDecryptResult);
  }

  /**
   * Test {@link SecurityHandler#decrypt(COSBase, long, long)}.
   *
   * <ul>
   *   <li>Given {@link PublicKeySecurityHandler#PublicKeySecurityHandler()} DecryptMetadata is
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#decrypt(COSBase, long, long)}
   */
  @Test
  @DisplayName(
      "Test decrypt(COSBase, long, long); given PublicKeySecurityHandler() DecryptMetadata is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase SecurityHandler.decrypt(COSBase, long, long)"})
  void testDecrypt_givenPublicKeySecurityHandlerDecryptMetadataIsTrue() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setDecryptMetadata(true);
    publicKeySecurityHandler.setEncryptionKey("AXAXAXAX".getBytes("UTF-8"));
    COSStream obj =
        new COSStream(null, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act
    COSBase actualDecryptResult = publicKeySecurityHandler.decrypt(obj, 1L, 1L);

    // Assert
    assertEquals(0L, obj.getLength());
    assertSame(obj, actualDecryptResult);
  }

  /**
   * Test {@link SecurityHandler#decrypt(COSBase, long, long)}.
   *
   * <ul>
   *   <li>Given {@link PublicKeySecurityHandler#PublicKeySecurityHandler()} StreamFilterName is
   *       {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#decrypt(COSBase, long, long)}
   */
  @Test
  @DisplayName(
      "Test decrypt(COSBase, long, long); given PublicKeySecurityHandler() StreamFilterName is A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase SecurityHandler.decrypt(COSBase, long, long)"})
  void testDecrypt_givenPublicKeySecurityHandlerStreamFilterNameIsA() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setStreamFilterName(COSName.A);
    publicKeySecurityHandler.setEncryptionKey("AXAXAXAX".getBytes("UTF-8"));
    COSStream obj =
        new COSStream(null, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act
    COSBase actualDecryptResult = publicKeySecurityHandler.decrypt(obj, 1L, 1L);

    // Assert
    assertEquals(0L, obj.getLength());
    assertSame(obj, actualDecryptResult);
  }

  /**
   * Test {@link SecurityHandler#decrypt(COSBase, long, long)}.
   *
   * <ul>
   *   <li>Given {@link PublicKeySecurityHandler#PublicKeySecurityHandler()}.
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then return toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#decrypt(COSBase, long, long)}
   */
  @Test
  @DisplayName(
      "Test decrypt(COSBase, long, long); given PublicKeySecurityHandler(); when COSArray(); then return toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase SecurityHandler.decrypt(COSBase, long, long)"})
  void testDecrypt_givenPublicKeySecurityHandler_whenCOSArray_thenReturnToListEmpty()
      throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    COSArray obj = new COSArray();

    // Act
    COSBase actualDecryptResult = publicKeySecurityHandler.decrypt(obj, 1L, 1L);

    // Assert
    assertTrue(actualDecryptResult instanceof COSArray);
    assertTrue(((COSArray) actualDecryptResult).toList().isEmpty());
    assertSame(obj, actualDecryptResult);
  }

  /**
   * Test {@link SecurityHandler#decrypt(COSBase, long, long)}.
   *
   * <ul>
   *   <li>Given {@link PublicKeySecurityHandler#PublicKeySecurityHandler()}.
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then return {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#decrypt(COSBase, long, long)}
   */
  @Test
  @DisplayName(
      "Test decrypt(COSBase, long, long); given PublicKeySecurityHandler(); when FALSE; then return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase SecurityHandler.decrypt(COSBase, long, long)"})
  void testDecrypt_givenPublicKeySecurityHandler_whenFalse_thenReturnFalse() throws IOException {
    // Arrange and Act
    COSBase actualDecryptResult = new PublicKeySecurityHandler().decrypt(COSBoolean.FALSE, 1L, 1L);

    // Assert
    assertSame(((COSBoolean) actualDecryptResult).FALSE, actualDecryptResult);
  }

  /**
   * Test {@link SecurityHandler#decrypt(COSBase, long, long)}.
   *
   * <ul>
   *   <li>Then return parseHex {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#decrypt(COSBase, long, long)}
   */
  @Test
  @DisplayName("Test decrypt(COSBase, long, long); then return parseHex '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase SecurityHandler.decrypt(COSBase, long, long)"})
  void testDecrypt_thenReturnParseHex0123456789abcdef() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setAES(true);
    publicKeySecurityHandler.setEncryptionKey("AXAXAXAX".getBytes("UTF-8"));
    COSString obj = COSString.parseHex("0123456789ABCDEF");

    // Act
    COSBase actualDecryptResult = publicKeySecurityHandler.decrypt(obj, 1L, 1L);

    // Assert
    assertSame(obj, actualDecryptResult);
  }

  /**
   * Test {@link SecurityHandler#decrypt(COSBase, long, long)}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#decrypt(COSBase, long, long)}
   */
  @Test
  @DisplayName("Test decrypt(COSBase, long, long); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase SecurityHandler.decrypt(COSBase, long, long)"})
  void testDecrypt_thenThrowIOException() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setAES(true);
    publicKeySecurityHandler.setEncryptionKey("AXAXAXAX".getBytes("UTF-8"));
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream obj = new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 3L));

    // Act and Assert
    assertThrows(IOException.class, () -> publicKeySecurityHandler.decrypt(obj, 1L, 1L));
  }

  /**
   * Test {@link SecurityHandler#decrypt(COSBase, long, long)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#decrypt(COSBase, long, long)}
   */
  @Test
  @DisplayName(
      "Test decrypt(COSBase, long, long); when COSDictionary(); then return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase SecurityHandler.decrypt(COSBase, long, long)"})
  void testDecrypt_whenCOSDictionary_thenReturnCOSDictionary() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    COSDictionary obj = new COSDictionary();

    // Act
    COSBase actualDecryptResult = publicKeySecurityHandler.decrypt(obj, 1L, 1L);

    // Assert
    assertSame(obj, actualDecryptResult);
  }

  /**
   * Test {@link SecurityHandler#decrypt(COSBase, long, long)}.
   *
   * <ul>
   *   <li>When parseHex {@code 0123456789ABCDEF}.
   *   <li>Then return {@link COSString}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#decrypt(COSBase, long, long)}
   */
  @Test
  @DisplayName(
      "Test decrypt(COSBase, long, long); when parseHex '0123456789ABCDEF'; then return COSString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase SecurityHandler.decrypt(COSBase, long, long)"})
  void testDecrypt_whenParseHex0123456789abcdef_thenReturnCOSString() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey("AXAXAXAX".getBytes("UTF-8"));

    // Act
    COSBase actualDecryptResult =
        publicKeySecurityHandler.decrypt(COSString.parseHex("0123456789ABCDEF"), 1L, 1L);

    // Assert
    assertTrue(actualDecryptResult instanceof COSString);
    assertEquals("8A6C2E2414FA0DF4", ((COSString) actualDecryptResult).toHexString());
    assertEquals("−l.$\u0014ú\rô", ((COSString) actualDecryptResult).getString());
    assertEquals("�l.$\u0014�\r�", ((COSString) actualDecryptResult).getASCII());
    assertArrayEquals(
        new byte[] {-118, 'l', '.', '$', 20, -6, '\r', -12},
        ((COSString) actualDecryptResult).getBytes());
  }

  /**
   * Test {@link SecurityHandler#decryptStream(COSStream, long, long)}.
   *
   * <p>Method under test: {@link SecurityHandler#decryptStream(COSStream, long, long)}
   */
  @Test
  @DisplayName("Test decryptStream(COSStream, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.decryptStream(COSStream, long, long)"})
  void testDecryptStream() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream stream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act
    publicKeySecurityHandler.decryptStream(stream, 1L, 1L);

    // Assert
    assertEquals(0L, stream.getLength());
  }

  /**
   * Test {@link SecurityHandler#decryptStream(COSStream, long, long)}.
   *
   * <p>Method under test: {@link SecurityHandler#decryptStream(COSStream, long, long)}
   */
  @Test
  @DisplayName("Test decryptStream(COSStream, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.decryptStream(COSStream, long, long)"})
  void testDecryptStream2() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    COSStream stream =
        new COSStream(null, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act
    publicKeySecurityHandler.decryptStream(stream, 1L, 1L);

    // Assert
    assertEquals(0L, stream.getLength());
  }

  /**
   * Test {@link SecurityHandler#decryptStream(COSStream, long, long)}.
   *
   * <p>Method under test: {@link SecurityHandler#decryptStream(COSStream, long, long)}
   */
  @Test
  @DisplayName("Test decryptStream(COSStream, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.decryptStream(COSStream, long, long)"})
  void testDecryptStream3() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream stream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 3L));

    // Act
    publicKeySecurityHandler.decryptStream(stream, 1L, 1L);

    // Assert that nothing has changed
    assertEquals(3L, stream.getLength());
  }

  /**
   * Test {@link SecurityHandler#decryptStream(COSStream, long, long)}.
   *
   * <p>Method under test: {@link SecurityHandler#decryptStream(COSStream, long, long)}
   */
  @Test
  @DisplayName("Test decryptStream(COSStream, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.decryptStream(COSStream, long, long)"})
  void testDecryptStream4() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream stream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, Long.MAX_VALUE));

    // Act
    publicKeySecurityHandler.decryptStream(stream, 1L, 1L);

    // Assert
    assertEquals(7L, stream.getLength());
  }

  /**
   * Test {@link SecurityHandler#decryptStream(COSStream, long, long)}.
   *
   * <p>Method under test: {@link SecurityHandler#decryptStream(COSStream, long, long)}
   */
  @Test
  @DisplayName("Test decryptStream(COSStream, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.decryptStream(COSStream, long, long)"})
  void testDecryptStream5() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(0L);
    ScratchFile streamCache = new ScratchFile(memUsageSetting);
    COSStream stream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act
    publicKeySecurityHandler.decryptStream(stream, 1L, 1L);

    // Assert
    assertEquals(0L, stream.getLength());
  }

  /**
   * Test {@link SecurityHandler#decryptStream(COSStream, long, long)}.
   *
   * <p>Method under test: {@link SecurityHandler#decryptStream(COSStream, long, long)}
   */
  @Test
  @DisplayName("Test decryptStream(COSStream, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.decryptStream(COSStream, long, long)"})
  void testDecryptStream6() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(0L);
    ScratchFile streamCache = new ScratchFile(memUsageSetting);
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream stream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 3L));

    // Act
    publicKeySecurityHandler.decryptStream(stream, 1L, 1L);

    // Assert that nothing has changed
    assertEquals(3L, stream.getLength());
  }

  /**
   * Test {@link SecurityHandler#decryptStream(COSStream, long, long)}.
   *
   * <ul>
   *   <li>Given {@link PublicKeySecurityHandler#PublicKeySecurityHandler()} AES is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#decryptStream(COSStream, long, long)}
   */
  @Test
  @DisplayName(
      "Test decryptStream(COSStream, long, long); given PublicKeySecurityHandler() AES is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.decryptStream(COSStream, long, long)"})
  void testDecryptStream_givenPublicKeySecurityHandlerAesIsTrue() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    publicKeySecurityHandler.setAES(true);
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream stream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act
    publicKeySecurityHandler.decryptStream(stream, 1L, 1L);

    // Assert
    assertEquals(0L, stream.getLength());
  }

  /**
   * Test {@link SecurityHandler#decryptStream(COSStream, long, long)}.
   *
   * <ul>
   *   <li>Given {@link PublicKeySecurityHandler#PublicKeySecurityHandler()} AES is {@code true}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#decryptStream(COSStream, long, long)}
   */
  @Test
  @DisplayName(
      "Test decryptStream(COSStream, long, long); given PublicKeySecurityHandler() AES is 'true'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.decryptStream(COSStream, long, long)"})
  void testDecryptStream_givenPublicKeySecurityHandlerAesIsTrue_thenThrowIOException()
      throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    publicKeySecurityHandler.setAES(true);
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream stream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 3L));

    // Act and Assert
    assertThrows(IOException.class, () -> publicKeySecurityHandler.decryptStream(stream, 1L, 1L));
  }

  /**
   * Test {@link SecurityHandler#decryptStream(COSStream, long, long)}.
   *
   * <ul>
   *   <li>Given {@link PublicKeySecurityHandler#PublicKeySecurityHandler()} DecryptMetadata is
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#decryptStream(COSStream, long, long)}
   */
  @Test
  @DisplayName(
      "Test decryptStream(COSStream, long, long); given PublicKeySecurityHandler() DecryptMetadata is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.decryptStream(COSStream, long, long)"})
  void testDecryptStream_givenPublicKeySecurityHandlerDecryptMetadataIsTrue() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setDecryptMetadata(true);
    publicKeySecurityHandler.setEncryptionKey(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream stream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act
    publicKeySecurityHandler.decryptStream(stream, 1L, 1L);

    // Assert
    assertEquals(0L, stream.getLength());
  }

  /**
   * Test {@link SecurityHandler#decryptStream(COSStream, long, long)}.
   *
   * <ul>
   *   <li>Given {@link PublicKeySecurityHandler#PublicKeySecurityHandler()} StreamFilterName is
   *       {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#decryptStream(COSStream, long, long)}
   */
  @Test
  @DisplayName(
      "Test decryptStream(COSStream, long, long); given PublicKeySecurityHandler() StreamFilterName is A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.decryptStream(COSStream, long, long)"})
  void testDecryptStream_givenPublicKeySecurityHandlerStreamFilterNameIsA() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setStreamFilterName(COSName.A);
    publicKeySecurityHandler.setEncryptionKey(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream stream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act
    publicKeySecurityHandler.decryptStream(stream, 1L, 1L);

    // Assert
    assertEquals(0L, stream.getLength());
  }

  /**
   * Test {@link SecurityHandler#encryptStream(COSStream, long, int)}.
   *
   * <p>Method under test: {@link SecurityHandler#encryptStream(COSStream, long, int)}
   */
  @Test
  @DisplayName("Test encryptStream(COSStream, long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.encryptStream(COSStream, long, int)"})
  void testEncryptStream() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream stream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act
    publicKeySecurityHandler.encryptStream(stream, 1L, 10);

    // Assert
    assertEquals(0L, stream.getLength());
  }

  /**
   * Test {@link SecurityHandler#encryptStream(COSStream, long, int)}.
   *
   * <p>Method under test: {@link SecurityHandler#encryptStream(COSStream, long, int)}
   */
  @Test
  @DisplayName("Test encryptStream(COSStream, long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.encryptStream(COSStream, long, int)"})
  void testEncryptStream2() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    COSStream stream =
        new COSStream(null, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act
    publicKeySecurityHandler.encryptStream(stream, 1L, 10);

    // Assert
    assertEquals(0L, stream.getLength());
  }

  /**
   * Test {@link SecurityHandler#encryptStream(COSStream, long, int)}.
   *
   * <p>Method under test: {@link SecurityHandler#encryptStream(COSStream, long, int)}
   */
  @Test
  @DisplayName("Test encryptStream(COSStream, long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.encryptStream(COSStream, long, int)"})
  void testEncryptStream3() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream stream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 3L));

    // Act
    publicKeySecurityHandler.encryptStream(stream, 1L, 10);

    // Assert that nothing has changed
    assertEquals(3L, stream.getLength());
  }

  /**
   * Test {@link SecurityHandler#encryptStream(COSStream, long, int)}.
   *
   * <p>Method under test: {@link SecurityHandler#encryptStream(COSStream, long, int)}
   */
  @Test
  @DisplayName("Test encryptStream(COSStream, long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.encryptStream(COSStream, long, int)"})
  void testEncryptStream4() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream stream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 8L));

    // Act
    publicKeySecurityHandler.encryptStream(stream, 1L, 10);

    // Assert
    assertEquals(7L, stream.getLength());
  }

  /**
   * Test {@link SecurityHandler#encryptStream(COSStream, long, int)}.
   *
   * <p>Method under test: {@link SecurityHandler#encryptStream(COSStream, long, int)}
   */
  @Test
  @DisplayName("Test encryptStream(COSStream, long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.encryptStream(COSStream, long, int)"})
  void testEncryptStream5() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setAES(true);
    publicKeySecurityHandler.setEncryptionKey(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1});
    COSStream stream =
        new COSStream(null, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act
    publicKeySecurityHandler.encryptStream(stream, 1L, 10);

    // Assert
    assertEquals(32L, stream.getLength());
  }

  /**
   * Test {@link SecurityHandler#encryptStream(COSStream, long, int)}.
   *
   * <p>Method under test: {@link SecurityHandler#encryptStream(COSStream, long, int)}
   */
  @Test
  @DisplayName("Test encryptStream(COSStream, long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.encryptStream(COSStream, long, int)"})
  void testEncryptStream6() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setAES(true);
    publicKeySecurityHandler.setEncryptionKey(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1});
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream stream = new COSStream(null, new RandomAccessReadView(randomAccessRead, 1L, 3L));

    // Act
    publicKeySecurityHandler.encryptStream(stream, 1L, 10);

    // Assert
    assertEquals(32L, stream.getLength());
  }

  /**
   * Test {@link SecurityHandler#encryptStream(COSStream, long, int)}.
   *
   * <p>Method under test: {@link SecurityHandler#encryptStream(COSStream, long, int)}
   */
  @Test
  @DisplayName("Test encryptStream(COSStream, long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.encryptStream(COSStream, long, int)"})
  void testEncryptStream7() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(4096L);
    ScratchFile streamCache = new ScratchFile(memUsageSetting);
    COSStream stream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act
    publicKeySecurityHandler.encryptStream(stream, 1L, 10);

    // Assert
    assertEquals(0L, stream.getLength());
  }

  /**
   * Test {@link SecurityHandler#encryptStream(COSStream, long, int)}.
   *
   * <p>Method under test: {@link SecurityHandler#encryptStream(COSStream, long, int)}
   */
  @Test
  @DisplayName("Test encryptStream(COSStream, long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.encryptStream(COSStream, long, int)"})
  void testEncryptStream8() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(4096L);
    ScratchFile streamCache = new ScratchFile(memUsageSetting);
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream stream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 3L));

    // Act
    publicKeySecurityHandler.encryptStream(stream, 1L, 10);

    // Assert that nothing has changed
    assertEquals(3L, stream.getLength());
  }

  /**
   * Test {@link SecurityHandler#encryptStream(COSStream, long, int)}.
   *
   * <ul>
   *   <li>Given {@link PublicKeySecurityHandler#PublicKeySecurityHandler()} AES is {@code true}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#encryptStream(COSStream, long, int)}
   */
  @Test
  @DisplayName(
      "Test encryptStream(COSStream, long, int); given PublicKeySecurityHandler() AES is 'true'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.encryptStream(COSStream, long, int)"})
  void testEncryptStream_givenPublicKeySecurityHandlerAesIsTrue_thenThrowIOException()
      throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setAES(true);
    publicKeySecurityHandler.setEncryptionKey(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    COSStream stream =
        new COSStream(null, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act and Assert
    assertThrows(IOException.class, () -> publicKeySecurityHandler.encryptStream(stream, 1L, 10));
  }

  /**
   * Test {@link SecurityHandler#encryptStream(COSStream, long, int)}.
   *
   * <ul>
   *   <li>Given {@link PublicKeySecurityHandler#PublicKeySecurityHandler()} CustomSecureRandom is
   *       {@link SecureRandom#SecureRandom()}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#encryptStream(COSStream, long, int)}
   */
  @Test
  @DisplayName(
      "Test encryptStream(COSStream, long, int); given PublicKeySecurityHandler() CustomSecureRandom is SecureRandom()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.encryptStream(COSStream, long, int)"})
  void testEncryptStream_givenPublicKeySecurityHandlerCustomSecureRandomIsSecureRandom()
      throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setCustomSecureRandom(new SecureRandom());
    publicKeySecurityHandler.setAES(true);
    publicKeySecurityHandler.setEncryptionKey(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1});
    COSStream stream =
        new COSStream(null, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act
    publicKeySecurityHandler.encryptStream(stream, 1L, 10);

    // Assert
    assertEquals(32L, stream.getLength());
  }

  /**
   * Test {@link SecurityHandler#encryptStream(COSStream, long, int)}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#encryptStream(COSStream, long, int)}
   */
  @Test
  @DisplayName("Test encryptStream(COSStream, long, int); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.encryptStream(COSStream, long, int)"})
  void testEncryptStream_thenThrowIOException() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setAES(true);
    publicKeySecurityHandler.setEncryptionKey(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(4096L);
    ScratchFile streamCache = new ScratchFile(memUsageSetting);
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream stream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 3L));

    // Act and Assert
    assertThrows(IOException.class, () -> publicKeySecurityHandler.encryptStream(stream, 1L, 10));
  }

  /**
   * Test {@link SecurityHandler#encryptStream(COSStream, long, int)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then {@link COSStream#COSStream()} Length is zero.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#encryptStream(COSStream, long, int)}
   */
  @Test
  @DisplayName(
      "Test encryptStream(COSStream, long, int); when COSStream(); then COSStream() Length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.encryptStream(COSStream, long, int)"})
  void testEncryptStream_whenCOSStream_thenCOSStreamLengthIsZero() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    COSStream stream = new COSStream();

    // Act
    publicKeySecurityHandler.encryptStream(stream, 1L, 10);

    // Assert that nothing has changed
    assertEquals(0L, stream.getLength());
  }

  /**
   * Test {@link SecurityHandler#encryptString(COSString, long, int)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When parseHex {@code 0123456789ABCDEF}.
   *   <li>Then return Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#encryptString(COSString, long, int)}
   */
  @Test
  @DisplayName(
      "Test encryptString(COSString, long, int); given 'A'; when parseHex '0123456789ABCDEF'; then return Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase SecurityHandler.encryptString(COSString, long, int)"})
  void testEncryptString_givenA_whenParseHex0123456789abcdef_thenReturnKeyIsNull()
      throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey(
        new byte[] {'A', 5, 'A', 5, 'A', 5, 'A', 5, 'A', 5, 'A', 5, 'A', 5, 'A', 5});
    publicKeySecurityHandler.setAES(true);

    // Act
    COSBase actualEncryptStringResult =
        publicKeySecurityHandler.encryptString(COSString.parseHex("0123456789ABCDEF"), 1L, 10);

    // Assert
    assertTrue(actualEncryptStringResult instanceof COSString);
    assertNull(actualEncryptStringResult.getKey());
    assertFalse(actualEncryptStringResult.isDirect());
    assertFalse(((COSString) actualEncryptStringResult).getForceHexForm());
  }

  /**
   * Test {@link SecurityHandler#encryptString(COSString, long, int)}.
   *
   * <ul>
   *   <li>Given {@link PublicKeySecurityHandler#PublicKeySecurityHandler()} CustomSecureRandom is
   *       {@link SecureRandom#SecureRandom()}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#encryptString(COSString, long, int)}
   */
  @Test
  @DisplayName(
      "Test encryptString(COSString, long, int); given PublicKeySecurityHandler() CustomSecureRandom is SecureRandom()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase SecurityHandler.encryptString(COSString, long, int)"})
  void testEncryptString_givenPublicKeySecurityHandlerCustomSecureRandomIsSecureRandom()
      throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setCustomSecureRandom(new SecureRandom());
    publicKeySecurityHandler.setEncryptionKey(
        new byte[] {'A', 5, 'A', 5, 'A', 5, 'A', 5, 'A', 5, 'A', 5, 'A', 5, 'A', 5});
    publicKeySecurityHandler.setAES(true);

    // Act
    COSBase actualEncryptStringResult =
        publicKeySecurityHandler.encryptString(COSString.parseHex("0123456789ABCDEF"), 1L, 10);

    // Assert
    assertTrue(actualEncryptStringResult instanceof COSString);
    assertNull(actualEncryptStringResult.getKey());
    assertFalse(actualEncryptStringResult.isDirect());
    assertFalse(((COSString) actualEncryptStringResult).getForceHexForm());
  }

  /**
   * Test {@link SecurityHandler#encryptString(COSString, long, int)}.
   *
   * <ul>
   *   <li>Then return toHexString is {@code BCE6CDC99E9C2CC8}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#encryptString(COSString, long, int)}
   */
  @Test
  @DisplayName(
      "Test encryptString(COSString, long, int); then return toHexString is 'BCE6CDC99E9C2CC8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase SecurityHandler.encryptString(COSString, long, int)"})
  void testEncryptString_thenReturnToHexStringIsBce6cdc99e9c2cc8() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey("AXAXAXAX".getBytes("UTF-8"));

    // Act
    COSBase actualEncryptStringResult =
        publicKeySecurityHandler.encryptString(COSString.parseHex("0123456789ABCDEF"), 1L, 10);

    // Assert
    assertTrue(actualEncryptStringResult instanceof COSString);
    assertEquals("BCE6CDC99E9C2CC8", ((COSString) actualEncryptStringResult).toHexString());
    assertEquals("¼æÍÉžœ,È", ((COSString) actualEncryptStringResult).getString());
    assertEquals("������,�", ((COSString) actualEncryptStringResult).getASCII());
    assertArrayEquals(
        new byte[] {-68, -26, -51, -55, -98, -100, ',', -56},
        ((COSString) actualEncryptStringResult).getBytes());
  }

  /**
   * Test {@link SecurityHandler#encryptString(COSString, long, int)}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#encryptString(COSString, long, int)}
   */
  @Test
  @DisplayName("Test encryptString(COSString, long, int); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase SecurityHandler.encryptString(COSString, long, int)"})
  void testEncryptString_thenThrowIOException() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey("AXAXAXAX".getBytes("UTF-8"));
    publicKeySecurityHandler.setAES(true);

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            publicKeySecurityHandler.encryptString(COSString.parseHex("0123456789ABCDEF"), 1L, 10));
  }

  /**
   * Test {@link SecurityHandler#getKeyLength()}.
   *
   * <p>Method under test: {@link SecurityHandler#getKeyLength()}
   */
  @Test
  @DisplayName("Test getKeyLength()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SecurityHandler.getKeyLength()"})
  void testGetKeyLength() {
    // Arrange, Act and Assert
    assertEquals(PDEncryption.DEFAULT_LENGTH, new PublicKeySecurityHandler().getKeyLength());
  }

  /**
   * Test {@link SecurityHandler#setKeyLength(int)}.
   *
   * <p>Method under test: {@link SecurityHandler#setKeyLength(int)}
   */
  @Test
  @DisplayName("Test setKeyLength(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.setKeyLength(int)"})
  void testSetKeyLength() {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();

    // Act
    publicKeySecurityHandler.setKeyLength(3);

    // Assert
    assertEquals(3, publicKeySecurityHandler.getKeyLength());
  }

  /**
   * Test {@link SecurityHandler#setCurrentAccessPermission(AccessPermission)}.
   *
   * <p>Method under test: {@link SecurityHandler#setCurrentAccessPermission(AccessPermission)}
   */
  @Test
  @DisplayName("Test setCurrentAccessPermission(AccessPermission)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.setCurrentAccessPermission(AccessPermission)"})
  void testSetCurrentAccessPermission() {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    AccessPermission currentAccessPermission = AccessPermission.getOwnerAccessPermission();

    // Act
    publicKeySecurityHandler.setCurrentAccessPermission(currentAccessPermission);

    // Assert
    assertSame(currentAccessPermission, publicKeySecurityHandler.getCurrentAccessPermission());
  }

  /**
   * Test {@link SecurityHandler#getCurrentAccessPermission()}.
   *
   * <p>Method under test: {@link SecurityHandler#getCurrentAccessPermission()}
   */
  @Test
  @DisplayName("Test getCurrentAccessPermission()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccessPermission SecurityHandler.getCurrentAccessPermission()"})
  void testGetCurrentAccessPermission() {
    // Arrange, Act and Assert
    assertNull(new PublicKeySecurityHandler().getCurrentAccessPermission());
  }

  /**
   * Test {@link SecurityHandler#isAES()}.
   *
   * <ul>
   *   <li>Given {@link PublicKeySecurityHandler#PublicKeySecurityHandler()} AES is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#isAES()}
   */
  @Test
  @DisplayName("Test isAES(); given PublicKeySecurityHandler() AES is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SecurityHandler.isAES()"})
  void testIsAES_givenPublicKeySecurityHandlerAesIsTrue_thenReturnTrue() {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setAES(true);

    // Act and Assert
    assertTrue(publicKeySecurityHandler.isAES());
  }

  /**
   * Test {@link SecurityHandler#isAES()}.
   *
   * <ul>
   *   <li>Given {@link PublicKeySecurityHandler#PublicKeySecurityHandler()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#isAES()}
   */
  @Test
  @DisplayName("Test isAES(); given PublicKeySecurityHandler(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SecurityHandler.isAES()"})
  void testIsAES_givenPublicKeySecurityHandler_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PublicKeySecurityHandler().isAES());
  }

  /**
   * Test {@link SecurityHandler#setAES(boolean)}.
   *
   * <p>Method under test: {@link SecurityHandler#setAES(boolean)}
   */
  @Test
  @DisplayName("Test setAES(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.setAES(boolean)"})
  void testSetAES() {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();

    // Act
    publicKeySecurityHandler.setAES(true);

    // Assert
    assertTrue(publicKeySecurityHandler.isAES());
  }

  /**
   * Test {@link SecurityHandler#hasProtectionPolicy()}.
   *
   * <ul>
   *   <li>Given {@link PublicKeySecurityHandler#PublicKeySecurityHandler()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#hasProtectionPolicy()}
   */
  @Test
  @DisplayName("Test hasProtectionPolicy(); given PublicKeySecurityHandler(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SecurityHandler.hasProtectionPolicy()"})
  void testHasProtectionPolicy_givenPublicKeySecurityHandler_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PublicKeySecurityHandler().hasProtectionPolicy());
  }

  /**
   * Test {@link SecurityHandler#hasProtectionPolicy()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#hasProtectionPolicy()}
   */
  @Test
  @DisplayName("Test hasProtectionPolicy(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SecurityHandler.hasProtectionPolicy()"})
  void testHasProtectionPolicy_thenReturnTrue() {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setProtectionPolicy(new PublicKeyProtectionPolicy());

    // Act and Assert
    assertTrue(publicKeySecurityHandler.hasProtectionPolicy());
  }

  /**
   * Test {@link SecurityHandler#getProtectionPolicy()}.
   *
   * <p>Method under test: {@link SecurityHandler#getProtectionPolicy()}
   */
  @Test
  @DisplayName("Test getProtectionPolicy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ProtectionPolicy SecurityHandler.getProtectionPolicy()"})
  void testGetProtectionPolicy() {
    // Arrange, Act and Assert
    assertNull(new PublicKeySecurityHandler().getProtectionPolicy());
  }

  /**
   * Test {@link SecurityHandler#setProtectionPolicy(ProtectionPolicy)}.
   *
   * <p>Method under test: {@link SecurityHandler#setProtectionPolicy(ProtectionPolicy)}
   */
  @Test
  @DisplayName("Test setProtectionPolicy(ProtectionPolicy)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.setProtectionPolicy(ProtectionPolicy)"})
  void testSetProtectionPolicy() {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    PublicKeyProtectionPolicy publicKeyProtectionPolicy = new PublicKeyProtectionPolicy();

    // Act
    publicKeySecurityHandler.setProtectionPolicy(publicKeyProtectionPolicy);

    // Assert
    assertTrue(publicKeySecurityHandler.hasProtectionPolicy());
    assertSame(publicKeyProtectionPolicy, publicKeySecurityHandler.getProtectionPolicy());
  }

  /**
   * Test {@link SecurityHandler#getEncryptionKey()}.
   *
   * <p>Method under test: {@link SecurityHandler#getEncryptionKey()}
   */
  @Test
  @DisplayName("Test getEncryptionKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SecurityHandler.getEncryptionKey()"})
  void testGetEncryptionKey() {
    // Arrange, Act and Assert
    assertNull(new PublicKeySecurityHandler().getEncryptionKey());
  }

  /**
   * Test {@link SecurityHandler#setEncryptionKey(byte[])}.
   *
   * <p>Method under test: {@link SecurityHandler#setEncryptionKey(byte[])}
   */
  @Test
  @DisplayName("Test setEncryptionKey(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandler.setEncryptionKey(byte[])"})
  void testSetEncryptionKey() throws UnsupportedEncodingException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    byte[] encryptionKey = "AXAXAXAX".getBytes("UTF-8");

    // Act
    publicKeySecurityHandler.setEncryptionKey(encryptionKey);

    // Assert
    assertSame(encryptionKey, publicKeySecurityHandler.getEncryptionKey());
  }

  /**
   * Test {@link SecurityHandler#computeVersionNumber()}.
   *
   * <ul>
   *   <li>Given {@link PublicKeySecurityHandler#PublicKeySecurityHandler()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#computeVersionNumber()}
   */
  @Test
  @DisplayName("Test computeVersionNumber(); given PublicKeySecurityHandler(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SecurityHandler.computeVersionNumber()"})
  void testComputeVersionNumber_givenPublicKeySecurityHandler_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, new PublicKeySecurityHandler().computeVersionNumber());
  }

  /**
   * Test {@link SecurityHandler#computeVersionNumber()}.
   *
   * <ul>
   *   <li>Then return five.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#computeVersionNumber()}
   */
  @Test
  @DisplayName("Test computeVersionNumber(); then return five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SecurityHandler.computeVersionNumber()"})
  void testComputeVersionNumber_thenReturnFive() {
    // Arrange
    PublicKeyProtectionPolicy publicKeyProtectionPolicy = new PublicKeyProtectionPolicy();
    publicKeyProtectionPolicy.setPreferAES(false);

    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setKeyLength(256);
    publicKeySecurityHandler.setProtectionPolicy(publicKeyProtectionPolicy);

    // Act and Assert
    assertEquals(5, publicKeySecurityHandler.computeVersionNumber());
  }

  /**
   * Test {@link SecurityHandler#computeVersionNumber()}.
   *
   * <ul>
   *   <li>Then return four.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#computeVersionNumber()}
   */
  @Test
  @DisplayName("Test computeVersionNumber(); then return four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SecurityHandler.computeVersionNumber()"})
  void testComputeVersionNumber_thenReturnFour() {
    // Arrange
    PublicKeyProtectionPolicy publicKeyProtectionPolicy = new PublicKeyProtectionPolicy();
    publicKeyProtectionPolicy.setPreferAES(true);

    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setKeyLength(128);
    publicKeySecurityHandler.setProtectionPolicy(publicKeyProtectionPolicy);

    // Act and Assert
    assertEquals(4, publicKeySecurityHandler.computeVersionNumber());
  }

  /**
   * Test {@link SecurityHandler#computeVersionNumber()}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandler#computeVersionNumber()}
   */
  @Test
  @DisplayName("Test computeVersionNumber(); then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SecurityHandler.computeVersionNumber()"})
  void testComputeVersionNumber_thenReturnTwo() {
    // Arrange
    PublicKeyProtectionPolicy publicKeyProtectionPolicy = new PublicKeyProtectionPolicy();
    publicKeyProtectionPolicy.setPreferAES(false);

    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setKeyLength(128);
    publicKeySecurityHandler.setProtectionPolicy(publicKeyProtectionPolicy);

    // Act and Assert
    assertEquals(2, publicKeySecurityHandler.computeVersionNumber());
  }
}

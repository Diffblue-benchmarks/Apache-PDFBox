package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SecurityHandlerDiffblueTest {
  /**
   * Test {@link SecurityHandler#setDecryptMetadata(boolean)}.
   * <p>
   * Method under test: {@link SecurityHandler#setDecryptMetadata(boolean)}
   */
  @Test
  @DisplayName("Test setDecryptMetadata(boolean)")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PublicKeySecurityHandler#PublicKeySecurityHandler()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityHandler#isDecryptMetadata()}
   */
  @Test
  @DisplayName("Test isDecryptMetadata(); given PublicKeySecurityHandler(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SecurityHandler.isDecryptMetadata()"})
  void testIsDecryptMetadata_givenPublicKeySecurityHandler_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PublicKeySecurityHandler()).isDecryptMetadata());
  }

  /**
   * Test {@link SecurityHandler#isDecryptMetadata()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityHandler#isDecryptMetadata()}
   */
  @Test
  @DisplayName("Test isDecryptMetadata(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SecurityHandler.isDecryptMetadata()"})
  void testIsDecryptMetadata_thenReturnTrue() {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setDecryptMetadata(true);

    // Act and Assert
    assertTrue(publicKeySecurityHandler.isDecryptMetadata());
  }

  /**
   * Test {@link SecurityHandler#encryptDataRC4(byte[], byte[], OutputStream)} with {@code byte[]}, {@code byte[]}, {@code OutputStream}.
   * <p>
   * Method under test: {@link SecurityHandler#encryptDataRC4(byte[], byte[], OutputStream)}
   */
  @Test
  @DisplayName("Test encryptDataRC4(byte[], byte[], OutputStream) with 'byte[]', 'byte[]', 'OutputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SecurityHandler.encryptDataRC4(byte[], byte[], OutputStream)"})
  void testEncryptDataRC4WithByteByteOutputStream() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    byte[] finalKey = "AXAXAXAX".getBytes("UTF-8");
    byte[] input = "AXAXAXAX".getBytes("UTF-8");
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    publicKeySecurityHandler.encryptDataRC4(finalKey, input, output);

    // Assert
    assertArrayEquals(new byte[]{-41, 5, 'N', -1, -19, -119, -27, 'K'}, output.toByteArray());
  }

  /**
   * Test {@link SecurityHandler#encryptDataRC4(byte[], byte[], OutputStream)} with {@code byte[]}, {@code byte[]}, {@code OutputStream}.
   * <p>
   * Method under test: {@link SecurityHandler#encryptDataRC4(byte[], byte[], OutputStream)}
   */
  @Test
  @DisplayName("Test encryptDataRC4(byte[], byte[], OutputStream) with 'byte[]', 'byte[]', 'OutputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SecurityHandler.encryptDataRC4(byte[], byte[], OutputStream)"})
  void testEncryptDataRC4WithByteByteOutputStream2() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    publicKeySecurityHandler.encryptDataRC4(new byte[]{-1}, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, output);

    // Assert
    assertArrayEquals(new byte[]{',', '}', 'n', '|', '1', 11, 'Z', -24}, output.toByteArray());
  }

  /**
   * Test {@link SecurityHandler#encryptDataRC4(byte[], InputStream, OutputStream)} with {@code byte[]}, {@code InputStream}, {@code OutputStream}.
   * <p>
   * Method under test: {@link SecurityHandler#encryptDataRC4(byte[], InputStream, OutputStream)}
   */
  @Test
  @DisplayName("Test encryptDataRC4(byte[], InputStream, OutputStream) with 'byte[]', 'InputStream', 'OutputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SecurityHandler.encryptDataRC4(byte[], InputStream, OutputStream)"})
  void testEncryptDataRC4WithByteInputStreamOutputStream() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    byte[] finalKey = "AXAXAXAX".getBytes("UTF-8");
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    publicKeySecurityHandler.encryptDataRC4(finalKey, input, output);

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    assertArrayEquals(new byte[]{-41, 5, 'N', -1, -19, -119, -27, 'K'}, output.toByteArray());
  }

  /**
   * Test {@link SecurityHandler#encryptDataRC4(byte[], InputStream, OutputStream)} with {@code byte[]}, {@code InputStream}, {@code OutputStream}.
   * <p>
   * Method under test: {@link SecurityHandler#encryptDataRC4(byte[], InputStream, OutputStream)}
   */
  @Test
  @DisplayName("Test encryptDataRC4(byte[], InputStream, OutputStream) with 'byte[]', 'InputStream', 'OutputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SecurityHandler.encryptDataRC4(byte[], InputStream, OutputStream)"})
  void testEncryptDataRC4WithByteInputStreamOutputStream2() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    publicKeySecurityHandler.encryptDataRC4(new byte[]{-1}, input, output);

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    assertArrayEquals(new byte[]{',', '}', 'n', '|', '1', 11, 'Z', -24}, output.toByteArray());
  }

  /**
   * Test {@link SecurityHandler#decrypt(COSBase, long, long)}.
   * <p>
   * Method under test: {@link SecurityHandler#decrypt(COSBase, long, long)}
   */
  @Test
  @DisplayName("Test decrypt(COSBase, long, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase SecurityHandler.decrypt(COSBase, long, long)"})
  void testDecrypt() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();

    COSArray obj = new COSArray();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    obj.add((COSBase) object);

    // Act
    COSBase actualDecryptResult = publicKeySecurityHandler.decrypt(obj, 1L, 1L);

    // Assert
    assertTrue(actualDecryptResult instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) actualDecryptResult).toList();
    assertEquals(1, toListResult.size());
    assertSame(object, toListResult.get(0));
  }

  /**
   * Test {@link SecurityHandler#decrypt(COSBase, long, long)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.</li>
   *   <li>When {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.</li>
   *   <li>Then toList first return {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityHandler#decrypt(COSBase, long, long)}
   */
  @Test
  @DisplayName("Test decrypt(COSBase, long, long); given COSArray(); when COSArray() add COSArray(); then toList first return COSArray")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase SecurityHandler.decrypt(COSBase, long, long)"})
  void testDecrypt_givenCOSArray_whenCOSArrayAddCOSArray_thenToListFirstReturnCOSArray() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();

    COSArray obj = new COSArray();
    COSArray object = new COSArray();
    obj.add((COSBase) object);

    // Act
    COSBase actualDecryptResult = publicKeySecurityHandler.decrypt(obj, 1L, 1L);

    // Assert
    List<? extends COSBase> toListResult = ((COSArray) actualDecryptResult).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(actualDecryptResult instanceof COSArray);
    assertTrue(((COSArray) getResult).toList().isEmpty());
    assertSame(object, getResult);
  }

  /**
   * Test {@link SecurityHandler#decrypt(COSBase, long, long)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return toList first is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityHandler#decrypt(COSBase, long, long)}
   */
  @Test
  @DisplayName("Test decrypt(COSBase, long, long); given COSDictionary(); then return toList first is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase SecurityHandler.decrypt(COSBase, long, long)"})
  void testDecrypt_givenCOSDictionary_thenReturnToListFirstIsCOSDictionary() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();

    COSArray obj = new COSArray();
    COSDictionary object = new COSDictionary();
    obj.add((COSBase) object);

    // Act
    COSBase actualDecryptResult = publicKeySecurityHandler.decrypt(obj, 1L, 1L);

    // Assert
    assertTrue(actualDecryptResult instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) actualDecryptResult).toList();
    assertEquals(1, toListResult.size());
    assertSame(object, toListResult.get(0));
  }

  /**
   * Test {@link SecurityHandler#decrypt(COSBase, long, long)}.
   * <ul>
   *   <li>Given {@link PublicKeySecurityHandler#PublicKeySecurityHandler()}.</li>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then return toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityHandler#decrypt(COSBase, long, long)}
   */
  @Test
  @DisplayName("Test decrypt(COSBase, long, long); given PublicKeySecurityHandler(); when COSArray(); then return toList Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase SecurityHandler.decrypt(COSBase, long, long)"})
  void testDecrypt_givenPublicKeySecurityHandler_whenCOSArray_thenReturnToListEmpty() throws IOException {
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
   * <ul>
   *   <li>Given {@link PublicKeySecurityHandler#PublicKeySecurityHandler()}.</li>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then return {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityHandler#decrypt(COSBase, long, long)}
   */
  @Test
  @DisplayName("Test decrypt(COSBase, long, long); given PublicKeySecurityHandler(); when FALSE; then return FALSE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase SecurityHandler.decrypt(COSBase, long, long)"})
  void testDecrypt_givenPublicKeySecurityHandler_whenFalse_thenReturnFalse() throws IOException {
    // Arrange and Act
    COSBase actualDecryptResult = (new PublicKeySecurityHandler()).decrypt(COSBoolean.FALSE, 1L, 1L);

    // Assert
    assertSame(((COSBoolean) actualDecryptResult).FALSE, actualDecryptResult);
  }

  /**
   * Test {@link SecurityHandler#decrypt(COSBase, long, long)}.
   * <ul>
   *   <li>Then return {@link COSString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityHandler#decrypt(COSBase, long, long)}
   */
  @Test
  @DisplayName("Test decrypt(COSBase, long, long); then return COSString")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase SecurityHandler.decrypt(COSBase, long, long)"})
  void testDecrypt_thenReturnCOSString() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey("AXAXAXAX".getBytes("UTF-8"));

    // Act
    COSBase actualDecryptResult = publicKeySecurityHandler.decrypt(COSString.parseHex("0123456789ABCDEF"), 1L, 1L);

    // Assert
    assertTrue(actualDecryptResult instanceof COSString);
    assertEquals("8A6C2E2414FA0DF4", ((COSString) actualDecryptResult).toHexString());
    assertEquals("−l.$\u0014ú\rô", ((COSString) actualDecryptResult).getString());
    assertEquals("�l.$\u0014�\r�", ((COSString) actualDecryptResult).getASCII());
    assertFalse(((COSString) actualDecryptResult).getForceHexForm());
    assertArrayEquals(new byte[]{-118, 'l', '.', '$', 20, -6, '\r', -12}, ((COSString) actualDecryptResult).getBytes());
  }

  /**
   * Test {@link SecurityHandler#decrypt(COSBase, long, long)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityHandler#decrypt(COSBase, long, long)}
   */
  @Test
  @DisplayName("Test decrypt(COSBase, long, long); when COSDictionary(); then return COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase SecurityHandler.decrypt(COSBase, long, long)"})
  void testDecrypt_whenCOSDictionary_thenReturnCOSDictionary() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    COSDictionary obj = new COSDictionary();

    // Act and Assert
    assertSame(obj, publicKeySecurityHandler.decrypt(obj, 1L, 1L));
  }

  /**
   * Test {@link SecurityHandler#decryptStream(COSStream, long, long)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then calls {@link COSStream#createRawOutputStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityHandler#decryptStream(COSStream, long, long)}
   */
  @Test
  @DisplayName("Test decryptStream(COSStream, long, long); given 'A'; then calls createRawOutputStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SecurityHandler.decryptStream(COSStream, long, long)"})
  void testDecryptStream_givenA_thenCallsCreateRawOutputStream() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    COSStream stream = mock(COSStream.class);
    when(stream.createRawInputStream()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(stream.createRawOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getItem(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(stream.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);

    // Act
    publicKeySecurityHandler.decryptStream(stream, 1L, 1L);

    // Assert
    verify(stream).getCOSName(isA(COSName.class));
    verify(stream).getItem(isA(COSName.class));
    verify(stream).createRawInputStream();
    verify(stream).createRawOutputStream();
  }

  /**
   * Test {@link SecurityHandler#decryptStream(COSStream, long, long)}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityHandler#decryptStream(COSStream, long, long)}
   */
  @Test
  @DisplayName("Test decryptStream(COSStream, long, long); given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SecurityHandler.decryptStream(COSStream, long, long)"})
  void testDecryptStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    COSStream stream = mock(COSStream.class);
    when(stream.createRawInputStream()).thenThrow(new IOException("foo"));
    when(stream.getItem(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(stream.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);

    // Act and Assert
    assertThrows(IOException.class, () -> publicKeySecurityHandler.decryptStream(stream, 1L, 1L));
    verify(stream).getCOSName(isA(COSName.class));
    verify(stream).getItem(isA(COSName.class));
    verify(stream).createRawInputStream();
  }

  /**
   * Test {@link SecurityHandler#encryptStream(COSStream, long, int)}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityHandler#encryptStream(COSStream, long, int)}
   */
  @Test
  @DisplayName("Test encryptStream(COSStream, long, int); given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SecurityHandler.encryptStream(COSStream, long, int)"})
  void testEncryptStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    COSStream stream = mock(COSStream.class);
    when(stream.createRawOutputStream()).thenThrow(new IOException("foo"));
    when(stream.createRawInputStream()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(stream.hasData()).thenReturn(true);

    // Act and Assert
    assertThrows(IOException.class, () -> publicKeySecurityHandler.encryptStream(stream, 1L, 10));
    verify(stream).createRawInputStream();
    verify(stream).createRawOutputStream();
    verify(stream).hasData();
  }

  /**
   * Test {@link SecurityHandler#encryptStream(COSStream, long, int)}.
   * <ul>
   *   <li>Then calls {@link FilterInputStream#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityHandler#encryptStream(COSStream, long, int)}
   */
  @Test
  @DisplayName("Test encryptStream(COSStream, long, int); then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SecurityHandler.encryptStream(COSStream, long, int)"})
  void testEncryptStream_thenCallsClose() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey("AXAXAXAX".getBytes("UTF-8"));
    DataInputStream dataInputStream = mock(DataInputStream.class);
    when(dataInputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(dataInputStream).close();
    COSStream stream = mock(COSStream.class);
    when(stream.createRawOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.createRawInputStream()).thenReturn(dataInputStream);
    when(stream.hasData()).thenReturn(true);

    // Act
    publicKeySecurityHandler.encryptStream(stream, 1L, 10);

    // Assert
    verify(dataInputStream).close();
    verify(dataInputStream).readAllBytes();
    verify(stream).createRawInputStream();
    verify(stream).createRawOutputStream();
    verify(stream).hasData();
  }

  /**
   * Test {@link SecurityHandler#encryptString(COSString, long, int)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When parseHex {@code 0123456789ABCDEF}.</li>
   *   <li>Then return Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityHandler#encryptString(COSString, long, int)}
   */
  @Test
  @DisplayName("Test encryptString(COSString, long, int); given 'A'; when parseHex '0123456789ABCDEF'; then return Key is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase SecurityHandler.encryptString(COSString, long, int)"})
  void testEncryptString_givenA_whenParseHex0123456789abcdef_thenReturnKeyIsNull() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler
        .setEncryptionKey(new byte[]{'A', 5, 'A', 5, 'A', 5, 'A', 5, 'A', 5, 'A', 5, 'A', 5, 'A', 5});
    publicKeySecurityHandler.setAES(true);

    // Act
    COSBase actualEncryptStringResult = publicKeySecurityHandler.encryptString(COSString.parseHex("0123456789ABCDEF"),
        1L, 10);

    // Assert
    assertTrue(actualEncryptStringResult instanceof COSString);
    assertNull(actualEncryptStringResult.getKey());
    assertFalse(actualEncryptStringResult.isDirect());
    assertFalse(((COSString) actualEncryptStringResult).getForceHexForm());
  }

  /**
   * Test {@link SecurityHandler#encryptString(COSString, long, int)}.
   * <ul>
   *   <li>Then return toHexString is {@code BCE6CDC99E9C2CC8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityHandler#encryptString(COSString, long, int)}
   */
  @Test
  @DisplayName("Test encryptString(COSString, long, int); then return toHexString is 'BCE6CDC99E9C2CC8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase SecurityHandler.encryptString(COSString, long, int)"})
  void testEncryptString_thenReturnToHexStringIsBce6cdc99e9c2cc8() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey("AXAXAXAX".getBytes("UTF-8"));

    // Act
    COSBase actualEncryptStringResult = publicKeySecurityHandler.encryptString(COSString.parseHex("0123456789ABCDEF"),
        1L, 10);

    // Assert
    assertTrue(actualEncryptStringResult instanceof COSString);
    assertEquals("BCE6CDC99E9C2CC8", ((COSString) actualEncryptStringResult).toHexString());
    assertEquals("¼æÍÉžœ,È", ((COSString) actualEncryptStringResult).getString());
    assertEquals("������,�", ((COSString) actualEncryptStringResult).getASCII());
    assertArrayEquals(new byte[]{-68, -26, -51, -55, -98, -100, ',', -56},
        ((COSString) actualEncryptStringResult).getBytes());
  }

  /**
   * Test {@link SecurityHandler#encryptString(COSString, long, int)}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityHandler#encryptString(COSString, long, int)}
   */
  @Test
  @DisplayName("Test encryptString(COSString, long, int); then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase SecurityHandler.encryptString(COSString, long, int)"})
  void testEncryptString_thenThrowIOException() throws IOException {
    // Arrange
    PublicKeySecurityHandler publicKeySecurityHandler = new PublicKeySecurityHandler();
    publicKeySecurityHandler.setEncryptionKey("AXAXAXAX".getBytes("UTF-8"));
    publicKeySecurityHandler.setAES(true);

    // Act and Assert
    assertThrows(IOException.class,
        () -> publicKeySecurityHandler.encryptString(COSString.parseHex("0123456789ABCDEF"), 1L, 10));
  }

  /**
   * Test {@link SecurityHandler#getKeyLength()}.
   * <p>
   * Method under test: {@link SecurityHandler#getKeyLength()}
   */
  @Test
  @DisplayName("Test getKeyLength()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int SecurityHandler.getKeyLength()"})
  void testGetKeyLength() {
    // Arrange, Act and Assert
    assertEquals(PDEncryption.DEFAULT_LENGTH, (new PublicKeySecurityHandler()).getKeyLength());
  }

  /**
   * Test {@link SecurityHandler#setKeyLength(int)}.
   * <p>
   * Method under test: {@link SecurityHandler#setKeyLength(int)}
   */
  @Test
  @DisplayName("Test setKeyLength(int)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link SecurityHandler#setCurrentAccessPermission(AccessPermission)}
   */
  @Test
  @DisplayName("Test setCurrentAccessPermission(AccessPermission)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link SecurityHandler#getCurrentAccessPermission()}
   */
  @Test
  @DisplayName("Test getCurrentAccessPermission()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AccessPermission SecurityHandler.getCurrentAccessPermission()"})
  void testGetCurrentAccessPermission() {
    // Arrange, Act and Assert
    assertNull((new PublicKeySecurityHandler()).getCurrentAccessPermission());
  }

  /**
   * Test {@link SecurityHandler#isAES()}.
   * <ul>
   *   <li>Given {@link PublicKeySecurityHandler#PublicKeySecurityHandler()} AES is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityHandler#isAES()}
   */
  @Test
  @DisplayName("Test isAES(); given PublicKeySecurityHandler() AES is 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PublicKeySecurityHandler#PublicKeySecurityHandler()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityHandler#isAES()}
   */
  @Test
  @DisplayName("Test isAES(); given PublicKeySecurityHandler(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SecurityHandler.isAES()"})
  void testIsAES_givenPublicKeySecurityHandler_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PublicKeySecurityHandler()).isAES());
  }

  /**
   * Test {@link SecurityHandler#setAES(boolean)}.
   * <p>
   * Method under test: {@link SecurityHandler#setAES(boolean)}
   */
  @Test
  @DisplayName("Test setAES(boolean)")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PublicKeySecurityHandler#PublicKeySecurityHandler()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityHandler#hasProtectionPolicy()}
   */
  @Test
  @DisplayName("Test hasProtectionPolicy(); given PublicKeySecurityHandler(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SecurityHandler.hasProtectionPolicy()"})
  void testHasProtectionPolicy_givenPublicKeySecurityHandler_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PublicKeySecurityHandler()).hasProtectionPolicy());
  }

  /**
   * Test {@link SecurityHandler#hasProtectionPolicy()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityHandler#hasProtectionPolicy()}
   */
  @Test
  @DisplayName("Test hasProtectionPolicy(); then return 'true'")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link SecurityHandler#getProtectionPolicy()}
   */
  @Test
  @DisplayName("Test getProtectionPolicy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtectionPolicy SecurityHandler.getProtectionPolicy()"})
  void testGetProtectionPolicy() {
    // Arrange, Act and Assert
    assertNull((new PublicKeySecurityHandler()).getProtectionPolicy());
  }

  /**
   * Test {@link SecurityHandler#setProtectionPolicy(ProtectionPolicy)}.
   * <p>
   * Method under test: {@link SecurityHandler#setProtectionPolicy(ProtectionPolicy)}
   */
  @Test
  @DisplayName("Test setProtectionPolicy(ProtectionPolicy)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link SecurityHandler#getEncryptionKey()}
   */
  @Test
  @DisplayName("Test getEncryptionKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] SecurityHandler.getEncryptionKey()"})
  void testGetEncryptionKey() {
    // Arrange, Act and Assert
    assertNull((new PublicKeySecurityHandler()).getEncryptionKey());
  }

  /**
   * Test {@link SecurityHandler#setEncryptionKey(byte[])}.
   * <p>
   * Method under test: {@link SecurityHandler#setEncryptionKey(byte[])}
   */
  @Test
  @DisplayName("Test setEncryptionKey(byte[])")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PublicKeySecurityHandler#PublicKeySecurityHandler()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityHandler#computeVersionNumber()}
   */
  @Test
  @DisplayName("Test computeVersionNumber(); given PublicKeySecurityHandler(); then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int SecurityHandler.computeVersionNumber()"})
  void testComputeVersionNumber_givenPublicKeySecurityHandler_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new PublicKeySecurityHandler()).computeVersionNumber());
  }

  /**
   * Test {@link SecurityHandler#computeVersionNumber()}.
   * <ul>
   *   <li>Then return five.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityHandler#computeVersionNumber()}
   */
  @Test
  @DisplayName("Test computeVersionNumber(); then return five")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then return four.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityHandler#computeVersionNumber()}
   */
  @Test
  @DisplayName("Test computeVersionNumber(); then return four")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then return two.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityHandler#computeVersionNumber()}
   */
  @Test
  @DisplayName("Test computeVersionNumber(); then return two")
  @Tag("MaintainedByDiffblue")
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

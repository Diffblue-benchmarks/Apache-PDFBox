package org.apache.pdfbox.pdfwriter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdfparser.xref.FreeXReference;
import org.apache.pdfbox.pdfparser.xref.XReferenceEntry;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class COSWriterDiffblueTest {
  /**
   * Test {@link COSWriter#COSWriter(OutputStream)}.
   * <p>
   * Method under test: {@link COSWriter#COSWriter(OutputStream)}
   */
  @Test
  @DisplayName("Test new COSWriter(OutputStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSWriter.<init>(OutputStream)"})
  void testNewCOSWriter() {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

    // Act
    COSWriter actualCosWriter = new COSWriter(outputStream);

    // Assert
    COSStandardOutputStream standardOutput = actualCosWriter.getStandardOutput();
    assertEquals(0L, standardOutput.getPos());
    assertEquals(0L, actualCosWriter.getStartxref());
    assertFalse(standardOutput.isOnNewLine());
    assertFalse(actualCosWriter.isCompress());
    assertTrue(actualCosWriter.getXRefEntries().isEmpty());
    assertSame(outputStream, actualCosWriter.getOutput());
  }

  /**
   * Test {@link COSWriter#COSWriter(OutputStream, CompressParameters)}.
   * <p>
   * Method under test: {@link COSWriter#COSWriter(OutputStream, CompressParameters)}
   */
  @Test
  @DisplayName("Test new COSWriter(OutputStream, CompressParameters)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSWriter.<init>(OutputStream, CompressParameters)"})
  void testNewCOSWriter2() {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

    // Act
    COSWriter actualCosWriter = new COSWriter(outputStream, CompressParameters.DEFAULT_COMPRESSION);

    // Assert
    COSStandardOutputStream standardOutput = actualCosWriter.getStandardOutput();
    assertEquals(0L, standardOutput.getPos());
    assertEquals(0L, actualCosWriter.getStartxref());
    assertFalse(standardOutput.isOnNewLine());
    assertTrue(actualCosWriter.getXRefEntries().isEmpty());
    assertTrue(actualCosWriter.isCompress());
    assertSame(outputStream, actualCosWriter.getOutput());
  }

  /**
   * Test {@link COSWriter#isCompress()}.
   * <ul>
   *   <li>Given {@link COSWriter#COSWriter(OutputStream)} with outputStream is {@link ByteArrayOutputStream#ByteArrayOutputStream(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriter#isCompress()}
   */
  @Test
  @DisplayName("Test isCompress(); given COSWriter(OutputStream) with outputStream is ByteArrayOutputStream(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSWriter.isCompress()"})
  void testIsCompress_givenCOSWriterWithOutputStreamIsByteArrayOutputStream() {
    // Arrange, Act and Assert
    assertFalse((new COSWriter(new ByteArrayOutputStream(1))).isCompress());
  }

  /**
   * Test {@link COSWriter#addXRefEntry(XReferenceEntry)}.
   * <p>
   * Method under test: {@link COSWriter#addXRefEntry(XReferenceEntry)}
   */
  @Test
  @DisplayName("Test addXRefEntry(XReferenceEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSWriter.addXRefEntry(XReferenceEntry)"})
  void testAddXRefEntry() {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream(1));
    FreeXReference entry = FreeXReference.NULL_ENTRY;

    // Act
    cosWriter.addXRefEntry(entry);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    assertSame(entry.NULL_ENTRY, xRefEntries.get(0));
  }

  /**
   * Test {@link COSWriter#getDataToSign()}.
   * <p>
   * Method under test: {@link COSWriter#getDataToSign()}
   */
  @Test
  @DisplayName("Test getDataToSign()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream COSWriter.getDataToSign()"})
  void testGetDataToSign() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new COSWriter(new ByteArrayOutputStream(1))).getDataToSign());
  }

  /**
   * Test {@link COSWriter#writeExternalSignature(byte[])}.
   * <p>
   * Method under test: {@link COSWriter#writeExternalSignature(byte[])}
   */
  @Test
  @DisplayName("Test writeExternalSignature(byte[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSWriter.writeExternalSignature(byte[])"})
  void testWriteExternalSignature() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream(1));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> cosWriter.writeExternalSignature("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link COSWriter#getXRefRanges(List)}.
   * <ul>
   *   <li>Given {@link FreeXReference#NULL_ENTRY}.</li>
   *   <li>Then return array of {@link Long} with zero and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriter#getXRefRanges(List)}
   */
  @Test
  @DisplayName("Test getXRefRanges(List); given NULL_ENTRY; then return array of Long with zero and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long[] COSWriter.getXRefRanges(List)"})
  void testGetXRefRanges_givenNull_entry_thenReturnArrayOfLongWithZeroAndOne() {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream(1));

    ArrayList<XReferenceEntry> xRefEntriesList = new ArrayList<>();
    xRefEntriesList.add(FreeXReference.NULL_ENTRY);

    // Act and Assert
    assertArrayEquals(new Long[]{0L, 1L}, cosWriter.getXRefRanges(xRefEntriesList));
  }

  /**
   * Test {@link COSWriter#getXRefRanges(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriter#getXRefRanges(List)}
   */
  @Test
  @DisplayName("Test getXRefRanges(List); when ArrayList(); then return array length is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long[] COSWriter.getXRefRanges(List)"})
  void testGetXRefRanges_whenArrayList_thenReturnArrayLengthIsZero() {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream(1));

    // Act and Assert
    assertEquals(0, cosWriter.getXRefRanges(new ArrayList<>()).length);
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSWriter.write(COSDocument)"})
  void testWriteWithCOSDocument_thenThrowIllegalStateException() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream(1));

    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);
    COSDocument doc = mock(COSDocument.class);
    when(doc.getEncryptionDictionary()).thenThrow(new IllegalStateException("Standard"));
    when(doc.isEncrypted()).thenReturn(true);
    when(doc.getHighestXRefObjectNumber()).thenReturn(1L);
    when(doc.getTrailer()).thenReturn(new COSDictionary());
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> cosWriter.write(doc));
    verify(doc).getDocumentState();
    verify(doc).getEncryptionDictionary();
    verify(doc).getHighestXRefObjectNumber();
    verify(doc).getTrailer();
    verify(doc).isEncrypted();
  }

  /**
   * Test {@link COSWriter#writeString(byte[], OutputStream)} with {@code bytes}, {@code output}.
   * <p>
   * Method under test: {@link COSWriter#writeString(byte[], OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(byte[], OutputStream) with 'bytes', 'output'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSWriter.writeString(byte[], OutputStream)"})
  void testWriteStringWithBytesOutput() throws IOException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSWriter.writeString(bytes, output);

    // Assert
    byte[] expectedToByteArrayResult = "(AXAXAXAX)".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link COSWriter#writeString(byte[], OutputStream)} with {@code bytes}, {@code output}.
   * <p>
   * Method under test: {@link COSWriter#writeString(byte[], OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(byte[], OutputStream) with 'bytes', 'output'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSWriter.writeString(byte[], OutputStream)"})
  void testWriteStringWithBytesOutput2() throws IOException {
    // Arrange
    byte[] bytes = "\rXAXAXAX".getBytes("UTF-8");
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSWriter.writeString(bytes, output);

    // Assert
    byte[] expectedToByteArrayResult = "<0D58415841584158>".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link COSWriter#writeString(byte[], OutputStream)} with {@code bytes}, {@code output}.
   * <p>
   * Method under test: {@link COSWriter#writeString(byte[], OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(byte[], OutputStream) with 'bytes', 'output'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSWriter.writeString(byte[], OutputStream)"})
  void testWriteStringWithBytesOutput3() throws IOException {
    // Arrange
    byte[] bytes = "\nXAXAXAX".getBytes("UTF-8");
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSWriter.writeString(bytes, output);

    // Assert
    byte[] expectedToByteArrayResult = "<0A58415841584158>".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link COSWriter#writeString(byte[], OutputStream)} with {@code bytes}, {@code output}.
   * <p>
   * Method under test: {@link COSWriter#writeString(byte[], OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(byte[], OutputStream) with 'bytes', 'output'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSWriter.writeString(byte[], OutputStream)"})
  void testWriteStringWithBytesOutput4() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSWriter.writeString(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, output);

    // Assert
    byte[] expectedToByteArrayResult = "<FF58415841584158>".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link COSWriter#writeString(COSString, OutputStream)} with {@code string}, {@code output}.
   * <p>
   * Method under test: {@link COSWriter#writeString(COSString, OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(COSString, OutputStream) with 'string', 'output'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSWriter.writeString(COSString, OutputStream)"})
  void testWriteStringWithStringOutput() throws IOException {
    // Arrange
    COSString string = COSString.parseHex("0123456789ABCDEF");
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSWriter.writeString(string, output);

    // Assert
    byte[] expectedToByteArrayResult = "<0123456789ABCDEF>".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link COSWriter#writeString(COSString, OutputStream)} with {@code string}, {@code output}.
   * <p>
   * Method under test: {@link COSWriter#writeString(COSString, OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(COSString, OutputStream) with 'string', 'output'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSWriter.writeString(COSString, OutputStream)"})
  void testWriteStringWithStringOutput2() throws IOException {
    // Arrange
    COSString string = COSString.parseHex("42");
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSWriter.writeString(string, output);

    // Assert
    byte[] expectedToByteArrayResult = "(B)".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link COSWriter#writeString(COSString, OutputStream)} with {@code string}, {@code output}.
   * <p>
   * Method under test: {@link COSWriter#writeString(COSString, OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(COSString, OutputStream) with 'string', 'output'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSWriter.writeString(COSString, OutputStream)"})
  void testWriteStringWithStringOutput3() throws IOException {
    // Arrange
    COSString string = new COSString("Text", true);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSWriter.writeString(string, output);

    // Assert
    byte[] expectedToByteArrayResult = "<54657874>".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }
}

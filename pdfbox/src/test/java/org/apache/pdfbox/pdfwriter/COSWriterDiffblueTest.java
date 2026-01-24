package org.apache.pdfbox.pdfwriter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNull;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.ICOSVisitor;
import org.apache.pdfbox.io.NonSeekableRandomAccessReadInputStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdfparser.xref.FreeXReference;
import org.apache.pdfbox.pdfparser.xref.NormalXReference;
import org.apache.pdfbox.pdfparser.xref.ObjectStreamXReference;
import org.apache.pdfbox.pdfparser.xref.XReferenceEntry;
import org.apache.pdfbox.pdfparser.xref.XReferenceType;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.PDEncryption;
import org.apache.pdfbox.pdmodel.encryption.PublicKeyProtectionPolicy;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.pdmodel.fdf.FDFDocument;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureInterface;
import org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDTransition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class COSWriterDiffblueTest {
  /**
   * Test {@link COSWriter#COSWriter(OutputStream)}.
   *
   * <p>Method under test: {@link COSWriter#COSWriter(OutputStream)}
   */
  @Test
  @DisplayName("Test new COSWriter(OutputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.<init>(OutputStream)"})
  void testNewCOSWriter() {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

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
   * Test {@link COSWriter#COSWriter(OutputStream, RandomAccessRead)}.
   *
   * <p>Method under test: {@link COSWriter#COSWriter(OutputStream, RandomAccessRead)}
   */
  @Test
  @DisplayName("Test new COSWriter(OutputStream, RandomAccessRead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.<init>(OutputStream, RandomAccessRead)"})
  void testNewCOSWriter2() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    // Act
    COSWriter actualCosWriter =
        new COSWriter(
            outputStream, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Assert
    assertEquals(0L, actualCosWriter.getStartxref());
    COSStandardOutputStream standardOutput = actualCosWriter.getStandardOutput();
    assertEquals(3L, standardOutput.getPos());
    assertFalse(standardOutput.isOnNewLine());
    assertFalse(actualCosWriter.isCompress());
    assertTrue(actualCosWriter.getXRefEntries().isEmpty());
    assertArrayEquals(
        new byte[] {}, ((ByteArrayOutputStream) actualCosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#COSWriter(OutputStream, RandomAccessRead)}.
   *
   * <p>Method under test: {@link COSWriter#COSWriter(OutputStream, RandomAccessRead)}
   */
  @Test
  @DisplayName("Test new COSWriter(OutputStream, RandomAccessRead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.<init>(OutputStream, RandomAccessRead)"})
  void testNewCOSWriter3() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act
    COSWriter actualCosWriter =
        new COSWriter(outputStream, new RandomAccessReadView(randomAccessRead, 1L, 3L));

    // Assert
    assertEquals(0L, actualCosWriter.getStartxref());
    COSStandardOutputStream standardOutput = actualCosWriter.getStandardOutput();
    assertEquals(3L, standardOutput.getPos());
    assertFalse(standardOutput.isOnNewLine());
    assertFalse(actualCosWriter.isCompress());
    assertTrue(actualCosWriter.getXRefEntries().isEmpty());
    assertArrayEquals(
        new byte[] {}, ((ByteArrayOutputStream) actualCosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#COSWriter(OutputStream, RandomAccessRead)}.
   *
   * <p>Method under test: {@link COSWriter#COSWriter(OutputStream, RandomAccessRead)}
   */
  @Test
  @DisplayName("Test new COSWriter(OutputStream, RandomAccessRead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.<init>(OutputStream, RandomAccessRead)"})
  void testNewCOSWriter4() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    // Act
    COSWriter actualCosWriter =
        new COSWriter(
            outputStream,
            new RandomAccessReadView(
                new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L), 1L, 3L));

    // Assert
    assertEquals(0L, actualCosWriter.getStartxref());
    COSStandardOutputStream standardOutput = actualCosWriter.getStandardOutput();
    assertEquals(3L, standardOutput.getPos());
    assertFalse(standardOutput.isOnNewLine());
    assertFalse(actualCosWriter.isCompress());
    assertTrue(actualCosWriter.getXRefEntries().isEmpty());
    assertArrayEquals(
        new byte[] {}, ((ByteArrayOutputStream) actualCosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#COSWriter(OutputStream, RandomAccessRead, Set)}.
   *
   * <p>Method under test: {@link COSWriter#COSWriter(OutputStream, RandomAccessRead, Set)}
   */
  @Test
  @DisplayName("Test new COSWriter(OutputStream, RandomAccessRead, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.<init>(OutputStream, RandomAccessRead, Set)"})
  void testNewCOSWriter5() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    RandomAccessReadView inputData =
        new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L);

    // Act
    COSWriter actualCosWriter = new COSWriter(outputStream, inputData, new HashSet<>());

    // Assert
    assertEquals(0L, actualCosWriter.getStartxref());
    COSStandardOutputStream standardOutput = actualCosWriter.getStandardOutput();
    assertEquals(3L, standardOutput.getPos());
    assertFalse(standardOutput.isOnNewLine());
    assertFalse(actualCosWriter.isCompress());
    assertTrue(actualCosWriter.getXRefEntries().isEmpty());
    assertArrayEquals(
        new byte[] {}, ((ByteArrayOutputStream) actualCosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#COSWriter(OutputStream, RandomAccessRead, Set)}.
   *
   * <p>Method under test: {@link COSWriter#COSWriter(OutputStream, RandomAccessRead, Set)}
   */
  @Test
  @DisplayName("Test new COSWriter(OutputStream, RandomAccessRead, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.<init>(OutputStream, RandomAccessRead, Set)"})
  void testNewCOSWriter6() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(inputStream);
    RandomAccessReadView inputData = new RandomAccessReadView(randomAccessRead, 1L, 3L);

    // Act
    COSWriter actualCosWriter = new COSWriter(outputStream, inputData, new HashSet<>());

    // Assert
    assertEquals(0L, actualCosWriter.getStartxref());
    COSStandardOutputStream standardOutput = actualCosWriter.getStandardOutput();
    assertEquals(3L, standardOutput.getPos());
    assertFalse(standardOutput.isOnNewLine());
    assertFalse(actualCosWriter.isCompress());
    assertTrue(actualCosWriter.getXRefEntries().isEmpty());
    assertArrayEquals(
        new byte[] {}, ((ByteArrayOutputStream) actualCosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#COSWriter(OutputStream, RandomAccessRead, Set)}.
   *
   * <p>Method under test: {@link COSWriter#COSWriter(OutputStream, RandomAccessRead, Set)}
   */
  @Test
  @DisplayName("Test new COSWriter(OutputStream, RandomAccessRead, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.<init>(OutputStream, RandomAccessRead, Set)"})
  void testNewCOSWriter7() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    RandomAccessReadView inputData =
        new RandomAccessReadView(
            new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L), 1L, 3L);

    // Act
    COSWriter actualCosWriter = new COSWriter(outputStream, inputData, new HashSet<>());

    // Assert
    assertEquals(0L, actualCosWriter.getStartxref());
    COSStandardOutputStream standardOutput = actualCosWriter.getStandardOutput();
    assertEquals(3L, standardOutput.getPos());
    assertFalse(standardOutput.isOnNewLine());
    assertFalse(actualCosWriter.isCompress());
    assertTrue(actualCosWriter.getXRefEntries().isEmpty());
    assertArrayEquals(
        new byte[] {}, ((ByteArrayOutputStream) actualCosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#COSWriter(OutputStream, CompressParameters)}.
   *
   * <p>Method under test: {@link COSWriter#COSWriter(OutputStream, CompressParameters)}
   */
  @Test
  @DisplayName("Test new COSWriter(OutputStream, CompressParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.<init>(OutputStream, CompressParameters)"})
  void testNewCOSWriter8() {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

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
   * Test {@link COSWriter#COSWriter(OutputStream, RandomAccessRead, Set)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@link HashSet#HashSet()} add {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#COSWriter(OutputStream, RandomAccessRead, Set)}
   */
  @Test
  @DisplayName(
      "Test new COSWriter(OutputStream, RandomAccessRead, Set); given COSDictionary(); when HashSet() add COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.<init>(OutputStream, RandomAccessRead, Set)"})
  void testNewCOSWriter_givenCOSDictionary_whenHashSetAddCOSDictionary() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    RandomAccessReadWriteBuffer inputData = new RandomAccessReadWriteBuffer();

    HashSet<COSDictionary> objectsToWrite = new HashSet<>();
    objectsToWrite.add(new COSDictionary());

    // Act
    COSWriter actualCosWriter = new COSWriter(outputStream, inputData, objectsToWrite);

    // Assert
    COSStandardOutputStream standardOutput = actualCosWriter.getStandardOutput();
    assertEquals(0L, standardOutput.getPos());
    assertEquals(0L, actualCosWriter.getStartxref());
    assertFalse(standardOutput.isOnNewLine());
    assertFalse(actualCosWriter.isCompress());
    assertTrue(actualCosWriter.getXRefEntries().isEmpty());
    assertArrayEquals(
        new byte[] {}, ((ByteArrayOutputStream) actualCosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#COSWriter(OutputStream, RandomAccessRead, Set)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@link HashSet#HashSet()} add {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#COSWriter(OutputStream, RandomAccessRead, Set)}
   */
  @Test
  @DisplayName(
      "Test new COSWriter(OutputStream, RandomAccessRead, Set); given COSDictionary(); when HashSet() add COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.<init>(OutputStream, RandomAccessRead, Set)"})
  void testNewCOSWriter_givenCOSDictionary_whenHashSetAddCOSDictionary2() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    RandomAccessReadWriteBuffer inputData = new RandomAccessReadWriteBuffer();

    HashSet<COSDictionary> objectsToWrite = new HashSet<>();
    objectsToWrite.add(new COSDictionary());
    objectsToWrite.add(new COSDictionary());

    // Act
    COSWriter actualCosWriter = new COSWriter(outputStream, inputData, objectsToWrite);

    // Assert
    COSStandardOutputStream standardOutput = actualCosWriter.getStandardOutput();
    assertEquals(0L, standardOutput.getPos());
    assertEquals(0L, actualCosWriter.getStartxref());
    assertFalse(standardOutput.isOnNewLine());
    assertFalse(actualCosWriter.isCompress());
    assertTrue(actualCosWriter.getXRefEntries().isEmpty());
    assertArrayEquals(
        new byte[] {}, ((ByteArrayOutputStream) actualCosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#COSWriter(OutputStream, RandomAccessRead)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return StandardOutput Pos is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#COSWriter(OutputStream, RandomAccessRead)}
   */
  @Test
  @DisplayName(
      "Test new COSWriter(OutputStream, RandomAccessRead); when 'A'; then return StandardOutput Pos is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.<init>(OutputStream, RandomAccessRead)"})
  void testNewCOSWriter_whenA_thenReturnStandardOutputPosIsZero() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    NonSeekableRandomAccessReadInputStream inputData =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act
    COSWriter actualCosWriter = new COSWriter(outputStream, inputData);

    // Assert
    COSStandardOutputStream standardOutput = actualCosWriter.getStandardOutput();
    assertEquals(0L, standardOutput.getPos());
    assertEquals(0L, actualCosWriter.getStartxref());
    assertFalse(standardOutput.isOnNewLine());
    assertFalse(actualCosWriter.isCompress());
    assertTrue(actualCosWriter.getXRefEntries().isEmpty());
    assertArrayEquals(
        new byte[] {}, ((ByteArrayOutputStream) actualCosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#COSWriter(OutputStream, RandomAccessRead, Set)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return StandardOutput Pos is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#COSWriter(OutputStream, RandomAccessRead, Set)}
   */
  @Test
  @DisplayName(
      "Test new COSWriter(OutputStream, RandomAccessRead, Set); when 'A'; then return StandardOutput Pos is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.<init>(OutputStream, RandomAccessRead, Set)"})
  void testNewCOSWriter_whenA_thenReturnStandardOutputPosIsZero2() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    NonSeekableRandomAccessReadInputStream inputData =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act
    COSWriter actualCosWriter = new COSWriter(outputStream, inputData, new HashSet<>());

    // Assert
    COSStandardOutputStream standardOutput = actualCosWriter.getStandardOutput();
    assertEquals(0L, standardOutput.getPos());
    assertEquals(0L, actualCosWriter.getStartxref());
    assertFalse(standardOutput.isOnNewLine());
    assertFalse(actualCosWriter.isCompress());
    assertTrue(actualCosWriter.getXRefEntries().isEmpty());
    assertArrayEquals(
        new byte[] {}, ((ByteArrayOutputStream) actualCosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#COSWriter(OutputStream, RandomAccessRead)}.
   *
   * <ul>
   *   <li>When {@link RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#COSWriter(OutputStream, RandomAccessRead)}
   */
  @Test
  @DisplayName(
      "Test new COSWriter(OutputStream, RandomAccessRead); when RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.<init>(OutputStream, RandomAccessRead)"})
  void testNewCOSWriter_whenRandomAccessReadWriteBuffer() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    // Act
    COSWriter actualCosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    // Assert
    COSStandardOutputStream standardOutput = actualCosWriter.getStandardOutput();
    assertEquals(0L, standardOutput.getPos());
    assertEquals(0L, actualCosWriter.getStartxref());
    assertFalse(standardOutput.isOnNewLine());
    assertFalse(actualCosWriter.isCompress());
    assertTrue(actualCosWriter.getXRefEntries().isEmpty());
    assertArrayEquals(
        new byte[] {}, ((ByteArrayOutputStream) actualCosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#COSWriter(OutputStream, RandomAccessRead, Set)}.
   *
   * <ul>
   *   <li>When {@link RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#COSWriter(OutputStream, RandomAccessRead, Set)}
   */
  @Test
  @DisplayName(
      "Test new COSWriter(OutputStream, RandomAccessRead, Set); when RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.<init>(OutputStream, RandomAccessRead, Set)"})
  void testNewCOSWriter_whenRandomAccessReadWriteBuffer2() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    RandomAccessReadWriteBuffer inputData = new RandomAccessReadWriteBuffer();

    // Act
    COSWriter actualCosWriter = new COSWriter(outputStream, inputData, new HashSet<>());

    // Assert
    COSStandardOutputStream standardOutput = actualCosWriter.getStandardOutput();
    assertEquals(0L, standardOutput.getPos());
    assertEquals(0L, actualCosWriter.getStartxref());
    assertFalse(standardOutput.isOnNewLine());
    assertFalse(actualCosWriter.isCompress());
    assertTrue(actualCosWriter.getXRefEntries().isEmpty());
    assertArrayEquals(
        new byte[] {}, ((ByteArrayOutputStream) actualCosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#isCompress()}.
   *
   * <p>Method under test: {@link COSWriter#isCompress()}
   */
  @Test
  @DisplayName("Test isCompress()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSWriter.isCompress()"})
  void testIsCompress() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    // Act and Assert
    assertFalse(cosWriter.isCompress());
  }

  /**
   * Test {@link COSWriter#isCompress()}.
   *
   * <ul>
   *   <li>Given {@link COSWriter#COSWriter(OutputStream)} with outputStream is {@link
   *       ByteArrayOutputStream#ByteArrayOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#isCompress()}
   */
  @Test
  @DisplayName(
      "Test isCompress(); given COSWriter(OutputStream) with outputStream is ByteArrayOutputStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSWriter.isCompress()"})
  void testIsCompress_givenCOSWriterWithOutputStreamIsByteArrayOutputStream() {
    // Arrange, Act and Assert
    assertFalse(new COSWriter(new ByteArrayOutputStream()).isCompress());
  }

  /**
   * Test {@link COSWriter#isCompress()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#isCompress()}
   */
  @Test
  @DisplayName("Test isCompress(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSWriter.isCompress()"})
  void testIsCompress_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new COSWriter(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION)
            .isCompress());
  }

  /**
   * Test {@link COSWriter#addXRefEntry(XReferenceEntry)}.
   *
   * <p>Method under test: {@link COSWriter#addXRefEntry(XReferenceEntry)}
   */
  @Test
  @DisplayName("Test addXRefEntry(XReferenceEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.addXRefEntry(XReferenceEntry)"})
  void testAddXRefEntry() {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    assertSame(FreeXReference.NULL_ENTRY, xRefEntries.get(0));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link COSWriter#setStartxref(long)}
   *   <li>{@link COSWriter#getOutput()}
   *   <li>{@link COSWriter#getStandardOutput()}
   *   <li>{@link COSWriter#getStartxref()}
   *   <li>{@link COSWriter#getXRefEntries()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OutputStream COSWriter.getOutput()",
    "COSStandardOutputStream COSWriter.getStandardOutput()",
    "long COSWriter.getStartxref()",
    "List COSWriter.getXRefEntries()",
    "void COSWriter.setStartxref(long)"
  })
  void testGettersAndSetters() {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream);

    // Act
    cosWriter.setStartxref(1L);
    OutputStream actualOutput = cosWriter.getOutput();
    COSStandardOutputStream actualStandardOutput = cosWriter.getStandardOutput();
    long actualStartxref = cosWriter.getStartxref();
    List<XReferenceEntry> actualXRefEntries = cosWriter.getXRefEntries();

    // Assert
    assertEquals(0L, actualStandardOutput.getPos());
    assertEquals(1L, actualStartxref);
    assertFalse(actualStandardOutput.isOnNewLine());
    assertTrue(actualXRefEntries.isEmpty());
    assertSame(outputStream, actualOutput);
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosObject);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertSame(cosObject, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\nfalse\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody2() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    COSObject cosObject = new COSObject(COSBoolean.FALSE);
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosObject);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertSame(cosObject, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\nfalse\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody3() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    COSBase object = ((NormalXReference) getResult).getObject();
    assertTrue(object instanceof COSBoolean);
    assertTrue(getResult instanceof NormalXReference);
    assertFalse(((COSBoolean) object).getValue());
    assertFalse(((COSBoolean) object).getValueAsObject());
    byte[] expectedToByteArrayResult = "1 0 obj\nfalse\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody4() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    COSObject cosObject = new COSObject(COSBoolean.TRUE, new COSObjectKey(1L, 1));
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosObject);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertSame(cosObject, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\ntrue\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody5() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    COSObject cosObject = new COSObject(COSFloat.ONE, new COSObjectKey(1L, 1));
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosObject);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    COSBase object = ((NormalXReference) getResult).getObject();
    assertTrue(((COSObject) object).getObject() instanceof COSFloat);
    assertTrue(object instanceof COSObject);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(19L, cosWriter.getStandardOutput().getPos());
    assertSame(cosObject, object);
    byte[] expectedToByteArrayResult = "1 0 obj\n1.0\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody6() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    COSObject cosObject = new COSObject(COSInteger.ONE, new COSObjectKey(1L, 1));
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosObject);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertSame(cosObject, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\n1\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody7() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    COSObject cosObject = new COSObject(COSName.A, new COSObjectKey(1L, 1));
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosObject);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(18L, cosWriter.getStandardOutput().getPos());
    assertSame(cosObject, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\n/A\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody8() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    COSObject cosObject = new COSObject(COSName.ABSOLUTE_COLORIMETRIC, new COSObjectKey(1L, 1));
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosObject);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    COSBase object = ((NormalXReference) getResult).getObject();
    COSBase object2 = ((COSObject) object).getObject();
    assertTrue(object2 instanceof COSName);
    assertTrue(object instanceof COSObject);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals("AbsoluteColorimetric", ((COSName) object2).getName());
    assertEquals(37L, cosWriter.getStandardOutput().getPos());
    assertSame(cosObject, object);
    byte[] expectedToByteArrayResult = "1 0 obj\n/AbsoluteColorimetric\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody9() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosObject);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertSame(cosObject, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\nfalse\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody10() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    COSObject cosObject = new COSObject(null, new COSObjectKey(1L, 1));
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosObject);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert that nothing has changed
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(0L, standardOutput.getPos());
    assertFalse(standardOutput.isOnNewLine());
    assertTrue(cosWriter.getXRefEntries().isEmpty());
    assertArrayEquals(new byte[] {}, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody11() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    COSArray object = new COSArray();
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosObject);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertSame(cosObject, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\n[]\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody12() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    COSStream object = new COSStream();
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosObject);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertSame(cosObject, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult =
        "1 0 obj\n<<\n/Length 0\n>>\nstream\r\n\r\nendstream\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody13() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    COSObject cosObject = new COSObject(COSName.ADBE_PKCS7_DETACHED, new COSObjectKey(1L, 1));
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosObject);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    COSBase object = ((NormalXReference) getResult).getObject();
    COSBase object2 = ((COSObject) object).getObject();
    assertTrue(object2 instanceof COSName);
    assertTrue(object instanceof COSObject);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals("adbe.pkcs7.detached", ((COSName) object2).getName());
    assertEquals(36L, cosWriter.getStandardOutput().getPos());
    assertSame(cosObject, object);
    byte[] expectedToByteArrayResult = "1 0 obj\n/adbe.pkcs7.detached\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody14() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject object = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosObject);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertSame(cosObject, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\nnull\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody15() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream object =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosObject);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertSame(cosObject, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult =
        "1 0 obj\n<<\n/Length 3\n>>\nstream\r\n\r\nendstream\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody16() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    COSDictionary object = new COSDictionary();
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosObject);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertSame(cosObject, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\n<<\n>>\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody17() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    COSObject cosObject = new COSObject(COSName.ADBE_X509_RSA_SHA1, new COSObjectKey(1L, 1));
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosObject);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    COSBase object = ((NormalXReference) getResult).getObject();
    COSBase object2 = ((COSObject) object).getObject();
    assertTrue(object2 instanceof COSName);
    assertTrue(object instanceof COSObject);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals("adbe.x509.rsa_sha1", ((COSName) object2).getName());
    assertEquals(35L, cosWriter.getStandardOutput().getPos());
    assertSame(cosObject, object);
    byte[] expectedToByteArrayResult = "1 0 obj\n/adbe.x509.rsa_sha1\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody18() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSObject object = mock(COSObject.class);
    doNothing().when(object).setKey(Mockito.<COSObjectKey>any());
    doNothing().when(object).accept(Mockito.<ICOSVisitor>any());
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosObject);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(object).setKey(isA(COSObjectKey.class));
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    verify(object).accept(isA(ICOSVisitor.class));
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertSame(cosObject, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody19() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(COSFloat.ONE);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    COSBase object = ((NormalXReference) getResult).getObject();
    assertTrue(object instanceof COSFloat);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(19L, cosWriter.getStandardOutput().getPos());
    assertFalse(object.isDirect());
    byte[] expectedToByteArrayResult = "1 0 obj\n1.0\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody20() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(COSName.A);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    COSBase object = ((NormalXReference) getResult).getObject();
    assertTrue(object instanceof COSName);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals("A", ((COSName) object).getName());
    assertFalse(((COSName) object).isEmpty());
    byte[] expectedToByteArrayResult = "1 0 obj\n/A\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody21() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    COSArray cosArray = new COSArray();
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosArray);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    COSBase object = ((NormalXReference) getResult).getObject();
    assertTrue(object instanceof COSArray);
    assertTrue(getResult instanceof NormalXReference);
    assertTrue(((COSArray) object).toList().isEmpty());
    assertSame(cosArray, object);
    byte[] expectedToByteArrayResult = "1 0 obj\n[]\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody22() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    COSStream cosStream = new COSStream();
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosStream);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertSame(cosStream, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult =
        "1 0 obj\n<<\n/Length 0\n>>\nstream\r\n\r\nendstream\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody23() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    COSDictionary cosDictionary2 = new COSDictionary();
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertSame(cosDictionary2, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\n<<\n>>\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody24() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSObject cosObject = mock(COSObject.class);
    doNothing().when(cosObject).setKey(Mockito.<COSObjectKey>any());
    doNothing().when(cosObject).accept(Mockito.<ICOSVisitor>any());
    when(cosObject.getObject()).thenReturn(COSBoolean.FALSE);
    when(cosObject.getKey()).thenReturn(new COSObjectKey(1L, 1));

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosObject);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(cosObject).getKey();
    verify(cosObject).setKey(isA(COSObjectKey.class));
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    verify(cosObject).accept(isA(ICOSVisitor.class));
    verify(cosObject, atLeast(1)).getObject();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    assertEquals(0L, getResult.getThirdColumnValue());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(cosWriter.getStandardOutput().isOnNewLine());
    byte[] expectedToByteArrayResult = "1 0 obj\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody25() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new COSStandardOutputStream(new ByteArrayOutputStream(), 1L));

    COSObject cosObject = mock(COSObject.class);
    doNothing().when(cosObject).setKey(Mockito.<COSObjectKey>any());

    COSObject cosObject2 = mock(COSObject.class);
    doNothing().when(cosObject2).setKey(Mockito.<COSObjectKey>any());
    doNothing().when(cosObject2).accept(Mockito.<ICOSVisitor>any());
    when(cosObject2.getObject()).thenReturn(cosObject);
    when(cosObject2.getKey()).thenReturn(new COSObjectKey(1L, 1));

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosObject2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(cosObject2).getKey();
    verify(cosObject2).setKey(isA(COSObjectKey.class));
    verify(cosObject).setKey(isA(COSObjectKey.class));
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    verify(cosObject2).accept(isA(ICOSVisitor.class));
    verify(cosObject2, atLeast(1)).getObject();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    OutputStream output = cosWriter.getOutput();
    assertTrue(output instanceof COSStandardOutputStream);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    assertEquals(0L, getResult.getThirdColumnValue());
    assertEquals(16L, ((COSStandardOutputStream) output).getPos());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(cosWriter.getStandardOutput().isOnNewLine());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getItem(COSName)} return {@link
   *       COSObject#COSObject(COSBase)} with object is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName(
      "Test doWriteBody(COSDocument); given COSDictionary getItem(COSName) return COSObject(COSBase) with object is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody_givenCOSDictionaryGetItemReturnCOSObjectWithObjectIsNull()
      throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(new COSObject(null));

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert that nothing has changed
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(0L, standardOutput.getPos());
    assertFalse(standardOutput.isOnNewLine());
    assertTrue(cosWriter.getXRefEntries().isEmpty());
    assertArrayEquals(new byte[] {}, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@link COSDocument} {@link COSDocument#getTrailer()} return {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName(
      "Test doWriteBody(COSDocument); given COSDictionary(); when COSDocument getTrailer() return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody_givenCOSDictionary_whenCOSDocumentGetTrailerReturnCOSDictionary()
      throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(new COSDictionary());

    // Act
    cosWriter.doWriteBody(doc);

    // Assert that nothing has changed
    verify(doc).getTrailer();
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(0L, standardOutput.getPos());
    assertFalse(standardOutput.isOnNewLine());
    assertTrue(cosWriter.getXRefEntries().isEmpty());
    assertArrayEquals(new byte[] {}, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <ul>
   *   <li>Given {@link COSObject} {@link COSObject#getKey()} return {@link COSObjectKey}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteBody(COSDocument); given COSObject getKey() return COSObjectKey")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody_givenCOSObjectGetKeyReturnCOSObjectKey() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSObject cosObject = mock(COSObject.class);
    doNothing().when(cosObject).setKey(Mockito.<COSObjectKey>any());

    COSObject cosObject2 = mock(COSObject.class);
    doNothing().when(cosObject2).setKey(Mockito.<COSObjectKey>any());
    doNothing().when(cosObject2).accept(Mockito.<ICOSVisitor>any());
    when(cosObject2.getObject()).thenReturn(cosObject);
    when(cosObject2.getKey()).thenReturn(mock(COSObjectKey.class));

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosObject2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(cosObject2).getKey();
    verify(cosObject2).setKey(isA(COSObjectKey.class));
    verify(cosObject).setKey(isA(COSObjectKey.class));
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    verify(cosObject2).accept(isA(ICOSVisitor.class));
    verify(cosObject2, atLeast(1)).getObject();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    assertEquals(0L, getResult.getThirdColumnValue());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(cosWriter.getStandardOutput().isOnNewLine());
    byte[] expectedToByteArrayResult = "1 0 obj\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <ul>
   *   <li>Given {@link COSObject} {@link COSObject#getObject()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName(
      "Test doWriteBody(COSDocument); given COSObject getObject() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody_givenCOSObjectGetObjectThrowIllegalStateException() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSObject cosObject = mock(COSObject.class);
    when(cosObject.getObject()).thenThrow(new IllegalStateException());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosObject);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> cosWriter.doWriteBody(doc));
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    verify(cosObject).getObject();
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <ul>
   *   <li>Given {@link COSObject} {@link COSObject#setKey(COSObjectKey)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName(
      "Test doWriteBody(COSDocument); given COSObject setKey(COSObjectKey) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody_givenCOSObjectSetKeyThrowIllegalStateException() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSObject object = mock(COSObject.class);
    doThrow(new IllegalStateException()).when(object).setKey(Mockito.<COSObjectKey>any());
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosObject);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> cosWriter.doWriteBody(doc));
    verify(object).setKey(isA(COSObjectKey.class));
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
  }

  /**
   * Test {@link COSWriter#doWriteBody(COSDocument)}.
   *
   * <ul>
   *   <li>Given {@link COSObject} {@link COSObject#setKey(COSObjectKey)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  @DisplayName(
      "Test doWriteBody(COSDocument); given COSObject setKey(COSObjectKey) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteBody(COSDocument)"})
  void testDoWriteBody_givenCOSObjectSetKeyThrowIllegalStateException2() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSObject cosObject = mock(COSObject.class);
    doThrow(new IllegalStateException()).when(cosObject).setKey(Mockito.<COSObjectKey>any());
    when(cosObject.getObject()).thenReturn(COSBoolean.FALSE);
    when(cosObject.getKey()).thenReturn(new COSObjectKey(1L, 1));

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getItem(Mockito.<COSName>any())).thenReturn(cosObject);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> cosWriter.doWriteBody(doc));
    verify(cosObject).getKey();
    verify(cosObject).setKey(isA(COSObjectKey.class));
    verify(cosDictionary, atLeast(1)).getItem(Mockito.<COSName>any());
    verify(doc).getTrailer();
    verify(cosObject, atLeast(1)).getObject();
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act
    cosWriter.doWriteObject(key, COSBoolean.FALSE);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(1L, getResult.getThirdColumnValue());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(21L, standardOutput.getPos());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(key, getResult.getReferencedKey());
    assertSame(COSBoolean.FALSE, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 1 obj\nfalse\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj2() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act
    cosWriter.doWriteObject(key, COSBoolean.TRUE);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(1L, getResult.getThirdColumnValue());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(20L, standardOutput.getPos());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(key, getResult.getReferencedKey());
    assertSame(COSBoolean.TRUE, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 1 obj\ntrue\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj3() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act
    cosWriter.doWriteObject(key, COSFloat.ONE);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(19L, standardOutput.getPos());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(1L, getResult.getThirdColumnValue());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(key, getResult.getReferencedKey());
    assertSame(COSFloat.ONE, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 1 obj\n1.0\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj4() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act
    cosWriter.doWriteObject(key, COSInteger.ONE);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(17L, standardOutput.getPos());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(1L, getResult.getThirdColumnValue());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(key, getResult.getReferencedKey());
    assertSame(COSInteger.ONE, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 1 obj\n1\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj5() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act
    cosWriter.doWriteObject(key, COSName.A);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(18L, standardOutput.getPos());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(1L, getResult.getThirdColumnValue());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(key, getResult.getReferencedKey());
    assertSame(COSName.A, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 1 obj\n/A\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj6() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject obj = new COSObject(COSBoolean.FALSE, new COSObjectKey(16L, Short.SIZE));

    // Act
    cosWriter.doWriteObject(key, obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(1L, getResult.getThirdColumnValue());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(21L, standardOutput.getPos());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    assertSame(key, getResult.getReferencedKey());
    byte[] expectedToByteArrayResult = "1 1 obj\nfalse\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj7() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSStream obj = new COSStream();

    // Act
    cosWriter.doWriteObject(key, obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(1L, getResult.getThirdColumnValue());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(51L, standardOutput.getPos());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(key, getResult.getReferencedKey());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult =
        "1 1 obj\n<<\n/Length 0\n>>\nstream\r\n\r\nendstream\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj8() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream obj =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 16L, 3L));

    // Act
    cosWriter.doWriteObject(key, obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(1L, getResult.getThirdColumnValue());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(51L, standardOutput.getPos());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(key, getResult.getReferencedKey());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult =
        "1 1 obj\n<<\n/Length 3\n>>\nstream\r\n\r\nendstream\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj9() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSDictionary obj = new COSDictionary();

    // Act
    cosWriter.doWriteObject(key, obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(1L, getResult.getThirdColumnValue());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(21L, standardOutput.getPos());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    assertSame(key, getResult.getReferencedKey());
    byte[] expectedToByteArrayResult = "1 1 obj\n<<\n>>\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj10() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject obj = new COSObject(COSFloat.ONE, new COSObjectKey(16L, Short.SIZE));

    // Act
    cosWriter.doWriteObject(key, obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(19L, standardOutput.getPos());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(1L, getResult.getThirdColumnValue());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    assertSame(key, getResult.getReferencedKey());
    byte[] expectedToByteArrayResult = "1 1 obj\n1.0\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj11() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject obj = new COSObject(COSInteger.ONE, new COSObjectKey(16L, Short.SIZE));

    // Act
    cosWriter.doWriteObject(key, obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(17L, standardOutput.getPos());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(1L, getResult.getThirdColumnValue());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    assertSame(key, getResult.getReferencedKey());
    byte[] expectedToByteArrayResult = "1 1 obj\n1\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj12() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject obj = new COSObject(COSName.A, new COSObjectKey(16L, Short.SIZE));

    // Act
    cosWriter.doWriteObject(key, obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(18L, standardOutput.getPos());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(1L, getResult.getThirdColumnValue());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    assertSame(key, getResult.getReferencedKey());
    byte[] expectedToByteArrayResult = "1 1 obj\n/A\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj13() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(16L, Short.SIZE));
    COSObject obj = new COSObject(object, new COSObjectKey(16L, Short.SIZE));

    // Act
    cosWriter.doWriteObject(key, obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(1L, getResult.getThirdColumnValue());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(21L, standardOutput.getPos());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    assertSame(key, getResult.getReferencedKey());
    byte[] expectedToByteArrayResult = "1 1 obj\nfalse\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj14() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSStream object = new COSStream();
    COSObject obj = new COSObject(object, new COSObjectKey(16L, Short.SIZE));

    // Act
    cosWriter.doWriteObject(key, obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(1L, getResult.getThirdColumnValue());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(51L, standardOutput.getPos());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    assertSame(key, getResult.getReferencedKey());
    byte[] expectedToByteArrayResult =
        "1 1 obj\n<<\n/Length 0\n>>\nstream\r\n\r\nendstream\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj15() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObjectKey key2 = new COSObjectKey(16L, Short.SIZE);
    COSObject object = new COSObject(key2, new COSParser(new RandomAccessReadWriteBuffer()));
    COSObject obj = new COSObject(object, new COSObjectKey(16L, Short.SIZE));

    // Act
    cosWriter.doWriteObject(key, obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(1L, getResult.getThirdColumnValue());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(20L, standardOutput.getPos());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    assertSame(key, getResult.getReferencedKey());
    byte[] expectedToByteArrayResult = "1 1 obj\nnull\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj16() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSArray object = new COSArray();
    COSObject obj = new COSObject(object, new COSObjectKey(16L, Short.SIZE));

    // Act
    cosWriter.doWriteObject(key, obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(18L, standardOutput.getPos());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(1L, getResult.getThirdColumnValue());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    assertSame(key, getResult.getReferencedKey());
    byte[] expectedToByteArrayResult = "1 1 obj\n[]\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj17() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSDictionary object = new COSDictionary();
    COSObject obj = new COSObject(object, new COSObjectKey(16L, Short.SIZE));

    // Act
    cosWriter.doWriteObject(key, obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(1L, getResult.getThirdColumnValue());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(21L, standardOutput.getPos());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    assertSame(key, getResult.getReferencedKey());
    byte[] expectedToByteArrayResult = "1 1 obj\n<<\n>>\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj18() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSStream obj = new COSStream();

    // Act
    cosWriter.doWriteObject(key, obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(1L, getResult.getThirdColumnValue());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(51L, standardOutput.getPos());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(key, getResult.getReferencedKey());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult =
        "1 1 obj\n<<\n/Length 0\n>>\nstream\r\n\r\nendstream\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj19() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act
    cosWriter.doWriteObject(key, COSName.ADBE_PKCS7_DETACHED);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(1L, getResult.getThirdColumnValue());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(36L, standardOutput.getPos());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(key, getResult.getReferencedKey());
    assertSame(COSName.ADBE_PKCS7_DETACHED, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 1 obj\n/adbe.pkcs7.detached\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj20() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act
    cosWriter.doWriteObject(key, COSName.ADBE_X509_RSA_SHA1);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(1L, getResult.getThirdColumnValue());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(35L, standardOutput.getPos());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(key, getResult.getReferencedKey());
    assertSame(COSName.ADBE_X509_RSA_SHA1, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 1 obj\n/adbe.x509.rsa_sha1\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj21() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSFloat obj = new COSFloat(10.0f);

    // Act
    cosWriter.doWriteObject(key, obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(1L, getResult.getThirdColumnValue());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(20L, standardOutput.getPos());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    assertSame(key, getResult.getReferencedKey());
    byte[] expectedToByteArrayResult = "1 1 obj\n10.0\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj22() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream obj =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 16L, 0L));

    // Act
    cosWriter.doWriteObject(key, obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(1L, getResult.getThirdColumnValue());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(51L, standardOutput.getPos());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(key, getResult.getReferencedKey());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult =
        "1 1 obj\n<<\n/Length 0\n>>\nstream\r\n\r\nendstream\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj23() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSArray obj = new COSArray();
    obj.add(COSBoolean.FALSE);

    // Act
    cosWriter.doWriteObject(key, obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(1L, getResult.getThirdColumnValue());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(23L, standardOutput.getPos());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    assertSame(key, getResult.getReferencedKey());
    byte[] expectedToByteArrayResult = "1 1 obj\n[false]\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj24() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray obj = new COSArray();
    obj.add(COSBoolean.FALSE);
    obj.add(object);

    // Act
    cosWriter.doWriteObject(key, obj);

    // Assert
    verify(object).getCOSObject();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(1L, getResult.getThirdColumnValue());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(29L, standardOutput.getPos());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    assertSame(key, getResult.getReferencedKey());
    byte[] expectedToByteArrayResult = "1 1 obj\n[false false]\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <ul>
   *   <li>Then array length is eighty-three.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName(
      "Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'; then array length is eighty-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj_thenArrayLengthIsEightyThree() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSObjectable object2 = mock(COSObjectable.class);
    when(object2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSObjectable object3 = mock(COSObjectable.class);
    when(object3.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSObjectable object4 = mock(COSObjectable.class);
    when(object4.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSObjectable object5 = mock(COSObjectable.class);
    when(object5.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSObjectable object6 = mock(COSObjectable.class);
    when(object6.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSObjectable object7 = mock(COSObjectable.class);
    when(object7.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSObjectable object8 = mock(COSObjectable.class);
    when(object8.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSObjectable object9 = mock(COSObjectable.class);
    when(object9.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSObjectable object10 = mock(COSObjectable.class);
    when(object10.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray obj = new COSArray();
    obj.add(COSBoolean.FALSE);
    obj.add(object10);
    obj.add(object9);
    obj.add(object8);
    obj.add(object7);
    obj.add(object6);
    obj.add(object5);
    obj.add(object4);
    obj.add(object3);
    obj.add(object2);
    obj.add(object);

    // Act
    cosWriter.doWriteObject(key, obj);

    // Assert
    verify(object10).getCOSObject();
    verify(object9).getCOSObject();
    verify(object8).getCOSObject();
    verify(object7).getCOSObject();
    verify(object6).getCOSObject();
    verify(object5).getCOSObject();
    verify(object4).getCOSObject();
    verify(object3).getCOSObject();
    verify(object2).getCOSObject();
    verify(object).getCOSObject();
    assertEquals(83, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(83L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'; when 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj_whenA() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObjectKey key2 = new COSObjectKey(16L, Short.SIZE);
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser parser = new COSParser(source);

    COSObject obj = new COSObject(key2, parser);

    // Act
    cosWriter.doWriteObject(key, obj);

    // Assert that nothing has changed
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(0L, standardOutput.getPos());
    assertFalse(standardOutput.isOnNewLine());
    assertTrue(cosWriter.getXRefEntries().isEmpty());
    assertArrayEquals(new byte[] {}, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'; when COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj_whenCOSArray() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSArray obj = new COSArray();

    // Act
    cosWriter.doWriteObject(key, obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(18L, standardOutput.getPos());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(1L, getResult.getThirdColumnValue());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    assertSame(key, getResult.getReferencedKey());
    byte[] expectedToByteArrayResult = "1 1 obj\n[]\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSObjectKey, ICOSParser)} with key is {@link
   *       COSObjectKey#COSObjectKey(long, int)} and parser is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName(
      "Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'; when COSObject(COSObjectKey, ICOSParser) with key is COSObjectKey(long, int) and parser is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj_whenCOSObjectWithKeyIsCOSObjectKeyAndParserIsNull()
      throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject obj = new COSObject(new COSObjectKey(16L, Short.SIZE), null);

    // Act
    cosWriter.doWriteObject(key, obj);

    // Assert that nothing has changed
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(0L, standardOutput.getPos());
    assertFalse(standardOutput.isOnNewLine());
    assertTrue(cosWriter.getXRefEntries().isEmpty());
    assertArrayEquals(new byte[] {}, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <ul>
   *   <li>When {@link COSParser#COSParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName(
      "Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'; when COSParser(RandomAccessRead) with source is RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj_whenCOSParserWithSourceIsRandomAccessReadWriteBuffer()
      throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObjectKey key2 = new COSObjectKey(16L, Short.SIZE);
    COSObject obj = new COSObject(key2, new COSParser(new RandomAccessReadWriteBuffer()));

    // Act
    cosWriter.doWriteObject(key, obj);

    // Assert that nothing has changed
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(0L, standardOutput.getPos());
    assertFalse(standardOutput.isOnNewLine());
    assertTrue(cosWriter.getXRefEntries().isEmpty());
    assertArrayEquals(new byte[] {}, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSObjectKey, COSBase)} with {@code key}, {@code obj}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSObjectKey, COSBase) with 'key', 'obj'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSObjectKey, COSBase)"})
  void testDoWriteObjectWithKeyObj_whenNull() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.doWriteObject(new COSObjectKey(1L, 1), null);

    // Assert that nothing has changed
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(0L, standardOutput.getPos());
    assertFalse(standardOutput.isOnNewLine());
    assertTrue(cosWriter.getXRefEntries().isEmpty());
    assertArrayEquals(new byte[] {}, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSArray obj = new COSArray(new ArrayList<>());
    obj.setKey(new COSObjectKey(1L, 1));

    // Act
    cosWriter.doWriteObject(obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    COSObjectKey referencedKey = getResult.getReferencedKey();
    assertEquals(-1, referencedKey.getStreamIndex());
    assertEquals(0, referencedKey.getGeneration());
    assertEquals(1L, referencedKey.getNumber());
    assertEquals(65536L, referencedKey.getInternalHash());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\n[]\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj2() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.doWriteObject(COSBoolean.TRUE);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(20L, cosWriter.getStandardOutput().getPos());
    assertSame(COSBoolean.TRUE, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\ntrue\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj3() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.doWriteObject(COSFloat.ONE);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(19L, cosWriter.getStandardOutput().getPos());
    assertSame(COSFloat.ONE, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\n1.0\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj4() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.doWriteObject(COSInteger.ONE);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(17L, cosWriter.getStandardOutput().getPos());
    assertSame(COSInteger.ONE, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\n1\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj5() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.doWriteObject(COSName.A);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(18L, cosWriter.getStandardOutput().getPos());
    assertSame(COSName.A, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\n/A\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj6() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObject obj = new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237));

    // Act
    cosWriter.doWriteObject(obj);

    // Assert
    assertTrue(obj.getObject() instanceof COSBoolean);
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertSame(obj, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\nfalse\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj7() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSStream obj = new COSStream();

    // Act
    cosWriter.doWriteObject(obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(51L, cosWriter.getStandardOutput().getPos());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult =
        "1 0 obj\n<<\n/Length 0\n>>\nstream\r\n\r\nendstream\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj8() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1237L, 1237);
    COSObject obj = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));

    // Act
    cosWriter.doWriteObject(obj);

    // Assert that nothing has changed
    assertEquals(0L, cosWriter.getStandardOutput().getPos());
    assertTrue(cosWriter.getXRefEntries().isEmpty());
    assertArrayEquals(new byte[] {}, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj9() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream obj =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1237L, 3L));

    // Act
    cosWriter.doWriteObject(obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(51L, cosWriter.getStandardOutput().getPos());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult =
        "1 0 obj\n<<\n/Length 3\n>>\nstream\r\n\r\nendstream\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj10() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObject obj = new COSObject(COSFloat.ONE, new COSObjectKey(1237L, 1237));

    // Act
    cosWriter.doWriteObject(obj);

    // Assert
    assertTrue(obj.getObject() instanceof COSFloat);
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertSame(obj, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\n1.0\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj11() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObject obj = new COSObject(COSInteger.ONE, new COSObjectKey(1237L, 1237));

    // Act
    cosWriter.doWriteObject(obj);

    // Assert
    assertTrue(obj.getObject() instanceof COSInteger);
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertSame(obj, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\n1\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj12() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObject obj = new COSObject(COSName.A, new COSObjectKey(1237L, 1237));

    // Act
    cosWriter.doWriteObject(obj);

    // Assert
    assertTrue(obj.getObject() instanceof COSName);
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertSame(obj, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\n/A\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj13() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237));
    COSObject obj = new COSObject(object, new COSObjectKey(1237L, 1237));

    // Act
    cosWriter.doWriteObject(obj);

    // Assert
    COSBase object2 = obj.getObject();
    assertTrue(((COSObject) object2).getObject() instanceof COSBoolean);
    assertTrue(object2 instanceof COSObject);
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertSame(obj, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\nfalse\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj14() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSStream object = new COSStream();
    COSObject obj = new COSObject(object, new COSObjectKey(1237L, 1237));

    // Act
    cosWriter.doWriteObject(obj);

    // Assert
    assertTrue(obj.getObject() instanceof COSStream);
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertSame(obj, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult =
        "1 0 obj\n<<\n/Length 0\n>>\nstream\r\n\r\nendstream\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj15() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1237L, 1237);
    COSObject object = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
    COSObject obj = new COSObject(object, new COSObjectKey(1237L, 1237));

    // Act
    cosWriter.doWriteObject(obj);

    // Assert
    assertTrue(obj.getObject() instanceof COSObject);
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertSame(obj, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\nnull\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj16() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSArray object = new COSArray();
    COSObject obj = new COSObject(object, new COSObjectKey(1237L, 1237));

    // Act
    cosWriter.doWriteObject(obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(18L, cosWriter.getStandardOutput().getPos());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\n[]\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj17() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSDictionary object = new COSDictionary();
    COSObject obj = new COSObject(object, new COSObjectKey(1237L, 1237));

    // Act
    cosWriter.doWriteObject(obj);

    // Assert
    assertTrue(obj.getObject() instanceof COSDictionary);
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertSame(obj, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\n<<\n>>\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj18() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());
    COSStream obj = new COSStream();

    // Act
    cosWriter.doWriteObject(obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(51L, cosWriter.getStandardOutput().getPos());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult =
        "1 0 obj\n<<\n/Length 0\n>>\nstream\r\n\r\nendstream\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj19() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.doWriteObject(COSName.ADBE_PKCS7_DETACHED);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(36L, cosWriter.getStandardOutput().getPos());
    assertSame(COSName.ADBE_PKCS7_DETACHED, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\n/adbe.pkcs7.detached\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj20() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.doWriteObject(COSName.ADBE_X509_RSA_SHA1);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(35L, cosWriter.getStandardOutput().getPos());
    assertSame(COSName.ADBE_X509_RSA_SHA1, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\n/adbe.x509.rsa_sha1\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj21() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSFloat obj = new COSFloat(10.0f);

    // Act
    cosWriter.doWriteObject(obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(20L, cosWriter.getStandardOutput().getPos());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\n10.0\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj22() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream obj =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1237L, -1L));

    // Act
    cosWriter.doWriteObject(obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(52L, cosWriter.getStandardOutput().getPos());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult =
        "1 0 obj\n<<\n/Length -1\n>>\nstream\r\n\r\nendstream\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj23() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSArray object = new COSArray();
    object.add(COSBoolean.FALSE);
    COSObject obj = new COSObject(object, new COSObjectKey(1237L, 1237));

    // Act
    cosWriter.doWriteObject(obj);

    // Assert
    COSBase object2 = obj.getObject();
    assertTrue(object2 instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) object2).toList();
    assertEquals(1, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSBoolean);
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(23L, cosWriter.getStandardOutput().getPos());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\n[false]\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj24() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray object2 = new COSArray();
    object2.add(COSBoolean.FALSE);
    object2.add(object);
    COSObject obj = new COSObject(object2, new COSObjectKey(1237L, 1237));

    // Act
    cosWriter.doWriteObject(obj);

    // Assert
    verify(object).getCOSObject();
    COSBase object3 = obj.getObject();
    assertTrue(object3 instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) object3).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSBoolean);
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(29L, cosWriter.getStandardOutput().getPos());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\n[false false]\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then {@link COSBoolean#FALSE} Key StreamIndex is minus one.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName(
      "Test doWriteObject(COSBase) with 'obj'; given 'null'; then FALSE Key StreamIndex is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj_givenNull_thenFalseKeyStreamIndexIsMinusOne() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSBoolean obj = COSBoolean.FALSE;
    obj.setKey(null);

    // Act
    cosWriter.doWriteObject(obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    COSObjectKey key = obj.getKey();
    assertEquals(-1, key.getStreamIndex());
    assertSame(key, getResult.getReferencedKey());
    assertSame(COSBoolean.FALSE, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\nfalse\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <ul>
   *   <li>Then array length is eighty-three.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'; then array length is eighty-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj_thenArrayLengthIsEightyThree() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSObjectable object2 = mock(COSObjectable.class);
    when(object2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSObjectable object3 = mock(COSObjectable.class);
    when(object3.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSObjectable object4 = mock(COSObjectable.class);
    when(object4.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSObjectable object5 = mock(COSObjectable.class);
    when(object5.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSObjectable object6 = mock(COSObjectable.class);
    when(object6.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSObjectable object7 = mock(COSObjectable.class);
    when(object7.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSObjectable object8 = mock(COSObjectable.class);
    when(object8.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSObjectable object9 = mock(COSObjectable.class);
    when(object9.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSObjectable object10 = mock(COSObjectable.class);
    when(object10.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray object11 = new COSArray();
    object11.add(COSBoolean.FALSE);
    object11.add(object10);
    object11.add(object9);
    object11.add(object8);
    object11.add(object7);
    object11.add(object6);
    object11.add(object5);
    object11.add(object4);
    object11.add(object3);
    object11.add(object2);
    object11.add(object);
    COSObject obj = new COSObject(object11, new COSObjectKey(1237L, 1237));

    // Act
    cosWriter.doWriteObject(obj);

    // Assert
    verify(object10).getCOSObject();
    verify(object9).getCOSObject();
    verify(object8).getCOSObject();
    verify(object7).getCOSObject();
    verify(object6).getCOSObject();
    verify(object5).getCOSObject();
    verify(object4).getCOSObject();
    verify(object3).getCOSObject();
    verify(object2).getCOSObject();
    verify(object).getCOSObject();
    assertEquals(83, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(83L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <ul>
   *   <li>Then {@link COSDictionary#COSDictionary()} Key StreamIndex is minus one.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName(
      "Test doWriteObject(COSBase) with 'obj'; then COSDictionary() Key StreamIndex is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj_thenCOSDictionaryKeyStreamIndexIsMinusOne() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSDictionary obj = new COSDictionary();

    // Act
    cosWriter.doWriteObject(obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    COSObjectKey key = obj.getKey();
    assertEquals(-1, key.getStreamIndex());
    assertSame(obj, ((NormalXReference) getResult).getObject());
    assertSame(key, getResult.getReferencedKey());
    byte[] expectedToByteArrayResult = "1 0 obj\n<<\n>>\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'; when 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj_whenA() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1237L, 1237);
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser parser = new COSParser(source);

    COSObject obj = new COSObject(key, parser);

    // Act
    cosWriter.doWriteObject(obj);

    // Assert that nothing has changed
    assertEquals(0L, cosWriter.getStandardOutput().getPos());
    assertTrue(cosWriter.getXRefEntries().isEmpty());
    assertArrayEquals(new byte[] {}, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSObjectKey, ICOSParser)} with key is {@link
   *       COSObjectKey#COSObjectKey(long, int)} and parser is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName(
      "Test doWriteObject(COSBase) with 'obj'; when COSObject(COSObjectKey, ICOSParser) with key is COSObjectKey(long, int) and parser is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj_whenCOSObjectWithKeyIsCOSObjectKeyAndParserIsNull()
      throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObject obj = new COSObject(new COSObjectKey(1237L, 1237), null);

    // Act
    cosWriter.doWriteObject(obj);

    // Assert that nothing has changed
    assertEquals(0L, cosWriter.getStandardOutput().getPos());
    assertTrue(cosWriter.getXRefEntries().isEmpty());
    assertArrayEquals(new byte[] {}, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName("Test doWriteObject(COSBase) with 'obj'; when FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj_whenFalse() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.doWriteObject(COSBoolean.FALSE);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(21L, cosWriter.getStandardOutput().getPos());
    assertSame(COSBoolean.FALSE, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\nfalse\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteObject(COSBase)} with {@code obj}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE} Key is {@link COSObjectKey#COSObjectKey(long, int)} with
   *       num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#doWriteObject(COSBase)}
   */
  @Test
  @DisplayName(
      "Test doWriteObject(COSBase) with 'obj'; when FALSE Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteObject(COSBase)"})
  void testDoWriteObjectWithObj_whenFalseKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne()
      throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSBoolean obj = COSBoolean.FALSE;
    obj.setKey(new COSObjectKey(1L, 1));

    // Act
    cosWriter.doWriteObject(obj);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(21L, cosWriter.getStandardOutput().getPos());
    assertSame(COSBoolean.FALSE, ((NormalXReference) getResult).getObject());
    byte[] expectedToByteArrayResult = "1 0 obj\nfalse\nendobj\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteHeader(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteHeader(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteHeader(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteHeader(COSDocument)"})
  void testDoWriteHeader() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.doWriteHeader(new COSDocument());

    // Assert
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(15L, standardOutput.getPos());
    assertTrue(standardOutput.isOnNewLine());
    assertArrayEquals(
        new byte[] {'%', 'P', 'D', 'F', '-', '1', '.', '4', '\n', '%', -10, -28, -4, -33, '\n'},
        ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteHeader(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteHeader(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteHeader(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteHeader(COSDocument)"})
  void testDoWriteHeader2() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    // Act
    cosWriter.doWriteHeader(new COSDocument());

    // Assert
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(15L, standardOutput.getPos());
    assertTrue(standardOutput.isOnNewLine());
    assertArrayEquals(
        new byte[] {'%', 'P', 'D', 'F', '-', '1', '.', '4', '\n', '%', -10, -28, -4, -33, '\n'},
        ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteHeader(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteHeader(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteHeader(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteHeader(COSDocument)"})
  void testDoWriteHeader3() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new COSStandardOutputStream(new ByteArrayOutputStream(), 3L));

    // Act
    cosWriter.doWriteHeader(new COSDocument());

    // Assert
    OutputStream output = cosWriter.getOutput();
    assertTrue(output instanceof COSStandardOutputStream);
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(15L, standardOutput.getPos());
    assertEquals(18L, ((COSStandardOutputStream) output).getPos());
    assertTrue(standardOutput.isOnNewLine());
  }

  /**
   * Test {@link COSWriter#doWriteTrailer(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteTrailer(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteTrailer(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteTrailer(COSDocument)"})
  void testDoWriteTrailer() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.doWriteTrailer(doc);

    // Assert
    COSDictionary trailer = doc.getTrailer();
    assertEquals(1, trailer.getValues().size());
    assertEquals(1, trailer.size());
    assertEquals(22L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "trailer\n<<\n/Size 1\n>>\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteTrailer(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteTrailer(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteTrailer(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteTrailer(COSDocument)"})
  void testDoWriteTrailer2() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.doWriteTrailer(doc);

    // Assert
    COSDictionary trailer = doc.getTrailer();
    assertEquals(1, trailer.getValues().size());
    assertEquals(1, trailer.size());
    assertEquals(22L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "trailer\n<<\n/Size 1\n>>\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteTrailer(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteTrailer(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteTrailer(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteTrailer(COSDocument)"})
  void testDoWriteTrailer3() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.doWriteObject(COSBoolean.FALSE);
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.doWriteTrailer(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(2, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(1);
    assertTrue(((NormalXReference) getResult).getObject() instanceof COSBoolean);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(0L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(0L, getResult.getSecondColumnValue());
    assertEquals(0L, getResult.getThirdColumnValue());
    assertEquals(1L, getResult.getFirstColumnValue());
    assertEquals(43L, cosWriter.getStandardOutput().getPos());
    assertEquals(XReferenceType.NORMAL, getResult.getType());
    assertFalse(((NormalXReference) getResult).isObjectStream());
    byte[] expectedToByteArrayResult =
        "1 0 obj\nfalse\nendobj\ntrailer\n<<\n/Size 2\n>>\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteTrailer(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteTrailer(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteTrailer(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteTrailer(COSDocument)"})
  void testDoWriteTrailer4() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(3L, 3);
    ObjectStreamXReference entry =
        new ObjectStreamXReference(1, key, COSBoolean.FALSE, new COSObjectKey(3L, 3));
    cosWriter.addXRefEntry(entry);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.doWriteTrailer(doc);

    // Assert
    COSDictionary trailer = doc.getTrailer();
    assertEquals(1, trailer.getValues().size());
    assertEquals(1, trailer.size());
    assertEquals(22L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "trailer\n<<\n/Size 4\n>>\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteTrailer(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteTrailer(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteTrailer(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteTrailer(COSDocument)"})
  void testDoWriteTrailer5() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.doWriteTrailer(doc);

    // Assert
    COSDictionary trailer = doc.getTrailer();
    assertEquals(1, trailer.getValues().size());
    assertEquals(1, trailer.size());
    assertEquals(22L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "trailer\n<<\n/Size 1\n>>\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteTrailer(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteTrailer(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteTrailer(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteTrailer(COSDocument)"})
  void testDoWriteTrailer6() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSStream());

    // Act
    cosWriter.doWriteTrailer(doc);

    // Assert
    COSDictionary trailer = doc.getTrailer();
    assertTrue(trailer instanceof COSStream);
    assertEquals(2, trailer.getValues().size());
    assertEquals(2, trailer.size());
    assertEquals(52L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult =
        "trailer\n<<\n/Length 0\n/Size 1\n>>\nstream\r\n\r\nendstream\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteTrailer(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteTrailer(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteTrailer(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteTrailer(COSDocument)"})
  void testDoWriteTrailer7() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument doc = new COSDocument();
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream newTrailer =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 3L, 3L));
    doc.setTrailer(newTrailer);

    // Act
    cosWriter.doWriteTrailer(doc);

    // Assert
    COSDictionary trailer = doc.getTrailer();
    assertTrue(trailer instanceof COSStream);
    assertEquals(2, trailer.getValues().size());
    assertEquals(2, trailer.size());
    assertEquals(52L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult =
        "trailer\n<<\n/Length 3\n/Size 1\n>>\nstream\r\n\r\nendstream\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteTrailer(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteTrailer(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteTrailer(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteTrailer(COSDocument)"})
  void testDoWriteTrailer8() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(3L, 3);
    ObjectStreamXReference entry =
        new ObjectStreamXReference(1, key, COSBoolean.FALSE, new COSObjectKey(3L, 3));
    cosWriter.addXRefEntry(entry);
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.doWriteTrailer(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(2, xRefEntries.size());
    assertSame(entry, xRefEntries.get(1));
    byte[] expectedToByteArrayResult = "trailer\n<<\n/Size 4\n>>\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteTrailer(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteTrailer(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteTrailer(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteTrailer(COSDocument)"})
  void testDoWriteTrailer9() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);
    NormalXReference entry = new NormalXReference(3L, new COSObjectKey(3L, 3), COSBoolean.FALSE);
    cosWriter.addXRefEntry(entry);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.doWriteTrailer(doc);

    // Assert
    COSDictionary trailer = doc.getTrailer();
    assertEquals(1, trailer.getValues().size());
    assertEquals(1, trailer.size());
    assertEquals(22L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "trailer\n<<\n/Size 4\n>>\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteTrailer(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteTrailer(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteTrailer(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteTrailer(COSDocument)"})
  void testDoWriteTrailer10() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);
    COSObjectKey key = new COSObjectKey(3L, 3);
    ObjectStreamXReference entry =
        new ObjectStreamXReference(1, key, COSBoolean.FALSE, new COSObjectKey(3L, 3));
    cosWriter.addXRefEntry(entry);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.doWriteTrailer(doc);

    // Assert
    COSDictionary trailer = doc.getTrailer();
    assertEquals(1, trailer.getValues().size());
    assertEquals(1, trailer.size());
    assertEquals(22L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "trailer\n<<\n/Size 4\n>>\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteTrailer(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteTrailer(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteTrailer(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteTrailer(COSDocument)"})
  void testDoWriteTrailer11() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument doc = new COSDocument();
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream newTrailer =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 3L, 3L));
    doc.setTrailer(newTrailer);

    // Act
    cosWriter.doWriteTrailer(doc);

    // Assert
    COSDictionary trailer = doc.getTrailer();
    assertTrue(trailer instanceof COSStream);
    assertEquals(2, trailer.getValues().size());
    assertEquals(2, trailer.size());
    assertEquals(55L, cosWriter.getStandardOutput().getPos());
    assertArrayEquals(
        new byte[] {
          't', 'r', 'a', 'i', 'l', 'e', 'r', '\n', '<', '<', '\n', '/', 'L', 'e', 'n', 'g', 't',
          'h', ' ', '3', '\n', '/', 'S', 'i', 'z', 'e', ' ', '1', '\n', '>', '>', '\n', 's', 't',
          'r', 'e', 'a', 'm', '\r', '\n', 3, 'A', 3, '\r', '\n', 'e', 'n', 'd', 's', 't', 'r', 'e',
          'a', 'm', '\n'
        },
        ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteTrailer(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#doWriteTrailer(COSDocument)}
   */
  @Test
  @DisplayName("Test doWriteTrailer(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteTrailer(COSDocument)"})
  void testDoWriteTrailer12() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument doc = new COSDocument();
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream newTrailer =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 3L, 16L));
    doc.setTrailer(newTrailer);

    // Act
    cosWriter.doWriteTrailer(doc);

    // Assert
    COSDictionary trailer = doc.getTrailer();
    assertTrue(trailer instanceof COSStream);
    assertEquals(2, trailer.getValues().size());
    assertEquals(2, trailer.size());
    assertEquals(58L, cosWriter.getStandardOutput().getPos());
    assertArrayEquals(
        new byte[] {
          't', 'r', 'a', 'i', 'l', 'e', 'r', '\n', '<', '<', '\n', '/', 'L', 'e', 'n', 'g', 't',
          'h', ' ', '1', '6', '\n', '/', 'S', 'i', 'z', 'e', ' ', '1', '\n', '>', '>', '\n', 's',
          't', 'r', 'e', 'a', 'm', '\r', '\n', 3, 'A', 3, 'A', 3, '\r', '\n', 'e', 'n', 'd', 's',
          't', 'r', 'e', 'a', 'm', '\n'
        },
        ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#doWriteTrailer(COSDocument)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDocument#COSDocument()} IsXRefStream is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#doWriteTrailer(COSDocument)}
   */
  @Test
  @DisplayName(
      "Test doWriteTrailer(COSDocument); given 'true'; when COSDocument() IsXRefStream is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.doWriteTrailer(COSDocument)"})
  void testDoWriteTrailer_givenTrue_whenCOSDocumentIsXRefStreamIsTrue() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.doWriteTrailer(doc);

    // Assert
    COSDictionary trailer = doc.getTrailer();
    assertEquals(1, trailer.getValues().size());
    assertEquals(1, trailer.size());
    assertEquals(22L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "trailer\n<<\n/Size 1\n>>\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#getDataToSign()}.
   *
   * <p>Method under test: {@link COSWriter#getDataToSign()}
   */
  @Test
  @DisplayName("Test getDataToSign()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream COSWriter.getDataToSign()"})
  void testGetDataToSign() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new COSWriter(new ByteArrayOutputStream()).getDataToSign());
  }

  /**
   * Test {@link COSWriter#writeExternalSignature(byte[])}.
   *
   * <p>Method under test: {@link COSWriter#writeExternalSignature(byte[])}
   */
  @Test
  @DisplayName("Test writeExternalSignature(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeExternalSignature(byte[])"})
  void testWriteExternalSignature() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            new COSWriter(new ByteArrayOutputStream())
                .writeExternalSignature("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link COSWriter#getXRefRanges(List)}.
   *
   * <ul>
   *   <li>Given {@link FreeXReference#NULL_ENTRY}.
   *   <li>Then return array of {@link Long} with zero and one.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#getXRefRanges(List)}
   */
  @Test
  @DisplayName(
      "Test getXRefRanges(List); given NULL_ENTRY; then return array of Long with zero and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long[] COSWriter.getXRefRanges(List)"})
  void testGetXRefRanges_givenNull_entry_thenReturnArrayOfLongWithZeroAndOne() {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    ArrayList<XReferenceEntry> xRefEntriesList = new ArrayList<>();
    xRefEntriesList.add(FreeXReference.NULL_ENTRY);

    // Act and Assert
    assertArrayEquals(new Long[] {0L, 1L}, cosWriter.getXRefRanges(xRefEntriesList));
  }

  /**
   * Test {@link COSWriter#getXRefRanges(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#getXRefRanges(List)}
   */
  @Test
  @DisplayName("Test getXRefRanges(List); when ArrayList(); then return array length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long[] COSWriter.getXRefRanges(List)"})
  void testGetXRefRanges_whenArrayList_thenReturnArrayLengthIsZero() {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act and Assert
    assertEquals(0, cosWriter.getXRefRanges(new ArrayList<>()).length);
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.visitFromArray(new COSArray());

    // Assert
    assertEquals(0L, cosWriter.getStartxref());
    assertEquals(3L, cosWriter.getStandardOutput().getPos());
    assertTrue(cosWriter.getXRefEntries().isEmpty());
    byte[] expectedToByteArrayResult = "[]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray2() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDictionary object = new COSDictionary(new COSDictionary());
    object.setDirect(false);

    COSArray array = new COSArray(new ArrayList<>());
    array.add((COSBase) object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    List<? extends COSBase> toListResult = array.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSDictionary);
    COSObjectKey key = getResult.getKey();
    assertEquals(-1, key.getStreamIndex());
    assertEquals(0, key.getGeneration());
    assertEquals(1L, key.getNumber());
    assertEquals(65536L, key.getInternalHash());
    byte[] expectedToByteArrayResult = "[1 0 R]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray3() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSBoolean object = COSBoolean.FALSE;
    object.setKey(new COSObjectKey(1L, 1));

    COSArray array = new COSArray(new ArrayList<>());
    array.add(object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    List<? extends COSBase> toListResult = array.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSBoolean);
    COSObjectKey key = getResult.getKey();
    assertEquals(1, key.getGeneration());
    assertEquals(65537L, key.getInternalHash());
    assertEquals(8L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "[false]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray4() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSArray object = new COSArray(new ArrayList<>());
    object.setDirect(false);
    object.setKey(new COSObjectKey(1L, 1));
    object.add(COSBoolean.FALSE);

    COSArray array = new COSArray(new ArrayList<>());
    array.add((COSBase) object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    List<? extends COSBase> toListResult = array.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSObject);
    COSObjectKey key = getResult.getKey();
    assertEquals(0, key.getGeneration());
    assertEquals(65536L, key.getInternalHash());
    assertEquals(8L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "[1 0 R]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray5() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSArray array = new COSArray(new ArrayList<>());
    array.add((COSBase) null);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    assertEquals(0L, cosWriter.getStartxref());
    assertEquals(7L, cosWriter.getStandardOutput().getPos());
    assertTrue(cosWriter.getXRefEntries().isEmpty());
    byte[] expectedToByteArrayResult = "[null]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray6() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSBoolean object = COSBoolean.TRUE;
    object.setDirect(false);

    COSArray array = new COSArray(new ArrayList<>());
    array.add(object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    List<? extends COSBase> toListResult = array.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSBoolean);
    COSObjectKey key = getResult.getKey();
    assertEquals(0, key.getGeneration());
    assertEquals(65536L, key.getInternalHash());
    assertEquals(7L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "[true]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray7() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSInteger object = COSInteger.ONE;
    object.setDirect(false);

    COSArray array = new COSArray(new ArrayList<>());
    array.add(object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    List<? extends COSBase> toListResult = array.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    COSObjectKey key = getResult.getKey();
    assertEquals(0, key.getGeneration());
    assertEquals(4L, cosWriter.getStandardOutput().getPos());
    assertEquals(65536L, key.getInternalHash());
    byte[] expectedToByteArrayResult = "[1]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray8() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSName object = COSName.A;
    object.setDirect(false);

    COSArray array = new COSArray(new ArrayList<>());
    array.add(object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    List<? extends COSBase> toListResult = array.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSName);
    COSObjectKey key = getResult.getKey();
    assertEquals(0, key.getGeneration());
    assertEquals(5L, cosWriter.getStandardOutput().getPos());
    assertEquals(65536L, key.getInternalHash());
    byte[] expectedToByteArrayResult = "[/A]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray9() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    object.setDirect(false);

    COSArray array = new COSArray(new ArrayList<>());
    array.add((COSBase) object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    List<? extends COSBase> toListResult = array.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    COSBase object2 = ((COSObject) getResult).getObject();
    assertTrue(object2 instanceof COSBoolean);
    assertTrue(getResult instanceof COSObject);
    COSObjectKey key = getResult.getKey();
    assertEquals(0, key.getGeneration());
    assertEquals(65536L, key.getInternalHash());
    assertSame(key, object2.getKey());
    byte[] expectedToByteArrayResult = "[1 0 R]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray10() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSFloat object = new COSFloat(10.0f);
    object.setDirect(false);

    COSArray array = new COSArray(new ArrayList<>());
    array.add(object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    assertEquals(0L, cosWriter.getStartxref());
    assertEquals(7L, cosWriter.getStandardOutput().getPos());
    assertTrue(cosWriter.getXRefEntries().isEmpty());
    byte[] expectedToByteArrayResult = "[10.0]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray11() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDictionary object = new COSDictionary(new COSDictionary());
    object.setDirect(true);

    COSArray array = new COSArray(new ArrayList<>());
    array.add((COSBase) object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    assertEquals(0L, cosWriter.getStartxref());
    assertEquals(9L, cosWriter.getStandardOutput().getPos());
    assertTrue(cosWriter.getXRefEntries().isEmpty());
    byte[] expectedToByteArrayResult = "[<<\n>>\n]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray12() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSObject object = new COSObject(COSBoolean.TRUE, new COSObjectKey(1L, 1));
    object.setDirect(false);

    COSArray array = new COSArray(new ArrayList<>());
    array.add((COSBase) object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    List<? extends COSBase> toListResult = array.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    COSBase object2 = ((COSObject) getResult).getObject();
    assertTrue(object2 instanceof COSBoolean);
    assertTrue(getResult instanceof COSObject);
    COSObjectKey key = getResult.getKey();
    assertEquals(0, key.getGeneration());
    assertEquals(65536L, key.getInternalHash());
    assertSame(key, object2.getKey());
    byte[] expectedToByteArrayResult = "[1 0 R]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray13() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSObject object = new COSObject(COSFloat.ONE, new COSObjectKey(1L, 1));
    object.setDirect(false);

    COSArray array = new COSArray(new ArrayList<>());
    array.add((COSBase) object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    List<? extends COSBase> toListResult = array.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    COSBase object2 = ((COSObject) getResult).getObject();
    assertTrue(object2 instanceof COSFloat);
    assertTrue(getResult instanceof COSObject);
    COSObjectKey key = getResult.getKey();
    assertEquals(0, key.getGeneration());
    assertEquals(65536L, key.getInternalHash());
    assertSame(key, object2.getKey());
    byte[] expectedToByteArrayResult = "[1 0 R]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray14() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSObject object = new COSObject(COSInteger.ONE, new COSObjectKey(1L, 1));
    object.setDirect(false);

    COSArray array = new COSArray(new ArrayList<>());
    array.add((COSBase) object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    List<? extends COSBase> toListResult = array.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    COSBase object2 = ((COSObject) getResult).getObject();
    assertTrue(object2 instanceof COSInteger);
    assertTrue(getResult instanceof COSObject);
    COSObjectKey key = getResult.getKey();
    assertEquals(0, key.getGeneration());
    assertEquals(65536L, key.getInternalHash());
    assertSame(key, object2.getKey());
    byte[] expectedToByteArrayResult = "[1 0 R]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray15() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSObject object = new COSObject(COSName.A, new COSObjectKey(1L, 1));
    object.setDirect(false);

    COSArray array = new COSArray(new ArrayList<>());
    array.add((COSBase) object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    List<? extends COSBase> toListResult = array.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    COSBase object2 = ((COSObject) getResult).getObject();
    assertTrue(object2 instanceof COSName);
    assertTrue(getResult instanceof COSObject);
    COSObjectKey key = getResult.getKey();
    assertEquals(0, key.getGeneration());
    assertEquals(65536L, key.getInternalHash());
    assertSame(key, object2.getKey());
    byte[] expectedToByteArrayResult = "[1 0 R]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray16() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSObject object = new COSObject(new COSObjectKey(1L, 1), null);
    object.setDirect(false);

    COSArray array = new COSArray(new ArrayList<>());
    array.add((COSBase) object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    List<? extends COSBase> toListResult = array.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSObject);
    COSObjectKey key = getResult.getKey();
    assertEquals(1, key.getGeneration());
    assertEquals(65537L, key.getInternalHash());
    assertEquals(8L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "[1 1 R]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray17() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSFloat object = new COSFloat(-3.4028235E38f);
    object.setDirect(false);

    COSArray array = new COSArray(new ArrayList<>());
    array.add(object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    assertEquals(0L, cosWriter.getStartxref());
    assertEquals(43L, cosWriter.getStandardOutput().getPos());
    assertTrue(cosWriter.getXRefEntries().isEmpty());
    byte[] expectedToByteArrayResult =
        "[-340282350000000000000000000000000000000]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray18() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    COSDictionary object = new COSDictionary(new COSDictionary());
    object.setDirect(true);

    COSArray array = new COSArray(new ArrayList<>());
    array.add((COSBase) object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    assertEquals(0L, cosWriter.getStartxref());
    assertEquals(9L, cosWriter.getStandardOutput().getPos());
    assertTrue(cosWriter.getXRefEntries().isEmpty());
    byte[] expectedToByteArrayResult = "[<<\n>>\n]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray19() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSArray object = new COSArray();
    object.setDirect(true);

    COSArray array = new COSArray(new ArrayList<>());
    array.add((COSBase) object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    assertEquals(0L, cosWriter.getStartxref());
    assertEquals(6L, cosWriter.getStandardOutput().getPos());
    assertTrue(cosWriter.getXRefEntries().isEmpty());
    byte[] expectedToByteArrayResult = "[[]\n]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray20() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSStream object = new COSStream();
    object.setDirect(true);

    COSArray array = new COSArray(new ArrayList<>());
    array.add((COSBase) object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    assertEquals(0L, cosWriter.getStartxref());
    assertEquals(19L, cosWriter.getStandardOutput().getPos());
    assertTrue(cosWriter.getXRefEntries().isEmpty());
    byte[] expectedToByteArrayResult = "[<<\n/Length 0\n>>\n]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray21() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.doWriteObject(COSBoolean.FALSE);

    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    object.setDirect(false);

    COSArray array = new COSArray(new ArrayList<>());
    array.add((COSBase) object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    assertTrue(xRefEntries.get(0) instanceof NormalXReference);
    assertEquals(29L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "1 0 obj\nfalse\nendobj\n[1 0 R]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray22() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    COSDocument object = new COSDocument();
    object.setTrailer(new COSDictionary());
    object.setDirect(false);

    COSArray array = new COSArray(new ArrayList<>());
    array.add(object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    assertEquals(3L, cosWriter.getStartxref());
    assertEquals(82, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(82L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray23() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.doWriteObject(COSBoolean.FALSE);
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument object = new COSDocument();
    object.setTrailer(new COSDictionary());
    object.setDirect(false);

    COSArray array = new COSArray(new ArrayList<>());
    array.add(object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(3, xRefEntries.size());
    assertTrue(xRefEntries.get(2) instanceof NormalXReference);
    assertEquals(153, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(153L, cosWriter.getStandardOutput().getPos());
    assertEquals(37L, cosWriter.getStartxref());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray24() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDocument object = new COSDocument();
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream newTrailer =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));
    object.setTrailer(newTrailer);
    object.setDirect(false);

    COSArray array = new COSArray(new ArrayList<>());
    array.add(object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    assertEquals(118, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(118L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray); given 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray_givenA() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser parser = new COSParser(source);

    COSObject object = new COSObject(key, parser);
    object.setDirect(false);

    COSArray array = new COSArray(new ArrayList<>());
    array.add((COSBase) object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    List<? extends COSBase> toListResult = array.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSObject);
    COSObjectKey key2 = getResult.getKey();
    assertEquals(1, key2.getGeneration());
    assertEquals(65537L, key2.getInternalHash());
    assertEquals(8L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "[1 1 R]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray(List)} with cosObjectables is {@link
   *       ArrayList#ArrayList()} Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName(
      "Test visitFromArray(COSArray); given COSArray(List) with cosObjectables is ArrayList() Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray_givenCOSArrayWithCosObjectablesIsArrayListKeyIsNull() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSArray object = new COSArray(new ArrayList<>());
    object.setDirect(false);
    object.setKey(null);
    object.add(COSBoolean.FALSE);

    COSArray array = new COSArray(new ArrayList<>());
    array.add((COSBase) object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    assertEquals(0L, cosWriter.getStartxref());
    assertEquals(8L, cosWriter.getStandardOutput().getPos());
    assertTrue(cosWriter.getXRefEntries().isEmpty());
    byte[] expectedToByteArrayResult = "[1 0 R]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray); given COSDocument() Trailer is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray_givenCOSDocumentTrailerIsCOSStream() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDocument object = new COSDocument();
    object.setTrailer(new COSStream());
    object.setDirect(false);

    COSArray array = new COSArray(new ArrayList<>());
    array.add(object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    assertEquals(118, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(118L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSObject#COSObject(COSObjectKey, ICOSParser)} with key is {@code null} and
   *       parser is {@code null} Direct is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName(
      "Test visitFromArray(COSArray); given COSObject(COSObjectKey, ICOSParser) with key is 'null' and parser is 'null' Direct is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray_givenCOSObjectWithKeyIsNullAndParserIsNullDirectIsFalse()
      throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSObject object = new COSObject((COSObjectKey) null, null);
    object.setDirect(false);

    COSArray array = new COSArray(new ArrayList<>());
    array.add((COSBase) object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    assertEquals(0L, cosWriter.getStartxref());
    assertEquals(8L, cosWriter.getStandardOutput().getPos());
    assertTrue(cosWriter.getXRefEntries().isEmpty());
    byte[] expectedToByteArrayResult = "[1 0 R]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSParser#COSParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName(
      "Test visitFromArray(COSArray); given COSParser(RandomAccessRead) with source is RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray_givenCOSParserWithSourceIsRandomAccessReadWriteBuffer()
      throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSObject object = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
    object.setDirect(false);

    COSArray array = new COSArray(new ArrayList<>());
    array.add((COSBase) object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    List<? extends COSBase> toListResult = array.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSObject);
    COSObjectKey key2 = getResult.getKey();
    assertEquals(1, key2.getGeneration());
    assertEquals(65537L, key2.getInternalHash());
    assertEquals(8L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "[1 1 R]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <ul>
   *   <li>Then array length is eighty-eight.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray); then array length is eighty-eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray_thenArrayLengthIsEightyEight() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDocument object = new COSDocument();
    object.setTrailer(new COSDictionary());
    object.setDirect(false);

    COSArray array = new COSArray(new ArrayList<>());
    array.add(object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    assertEquals(88, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(88L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <ul>
   *   <li>Then array length is one hundred thirty-six.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray); then array length is one hundred thirty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray_thenArrayLengthIsOneHundredThirtySix() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument object = new COSDocument();
    object.setTrailer(new COSDictionary());
    object.setDirect(false);

    COSArray array = new COSArray(new ArrayList<>());
    array.add(object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    assertEquals(136, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(136L, cosWriter.getStandardOutput().getPos());
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(3, xRefEntries.size());
    XReferenceEntry expectedGetResult = xRefEntries.get(0);
    assertSame(expectedGetResult, xRefEntries.get(2));
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <ul>
   *   <li>Then array length is one hundred twelve.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName("Test visitFromArray(COSArray); then array length is one hundred twelve")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray_thenArrayLengthIsOneHundredTwelve() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument object = new COSDocument();
    object.setTrailer(new COSDictionary());
    object.setDirect(false);

    COSArray array = new COSArray(new ArrayList<>());
    array.add(object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    assertEquals(112, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(112L, cosWriter.getStandardOutput().getPos());
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(2, xRefEntries.size());
    XReferenceEntry expectedGetResult = xRefEntries.get(0);
    assertSame(expectedGetResult, xRefEntries.get(1));
  }

  /**
   * Test {@link COSWriter#visitFromArray(COSArray)}.
   *
   * <ul>
   *   <li>Then {@link COSArray#COSArray(List)} with cosObjectables is {@link ArrayList#ArrayList()}
   *       toList first {@link COSFloat}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  @DisplayName(
      "Test visitFromArray(COSArray); then COSArray(List) with cosObjectables is ArrayList() toList first COSFloat")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromArray(COSArray)"})
  void testVisitFromArray_thenCOSArrayWithCosObjectablesIsArrayListToListFirstCOSFloat()
      throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSFloat object = COSFloat.ONE;
    object.setDirect(false);

    COSArray array = new COSArray(new ArrayList<>());
    array.add(object);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    List<? extends COSBase> toListResult = array.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSObjectKey key = getResult.getKey();
    assertEquals(0, key.getGeneration());
    assertEquals(65536L, key.getInternalHash());
    assertEquals(6L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "[1.0]\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromBoolean(COSBoolean)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromBoolean(COSBoolean)}
   */
  @Test
  @DisplayName("Test visitFromBoolean(COSBoolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromBoolean(COSBoolean)"})
  void testVisitFromBoolean() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.visitFromBoolean(COSBoolean.FALSE);

    // Assert
    assertEquals(5L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "false".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromBoolean(COSBoolean)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromBoolean(COSBoolean)}
   */
  @Test
  @DisplayName("Test visitFromBoolean(COSBoolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromBoolean(COSBoolean)"})
  void testVisitFromBoolean2() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.visitFromBoolean(COSBoolean.TRUE);

    // Assert
    assertEquals(4L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "true".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromBoolean(COSBoolean)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromBoolean(COSBoolean)}
   */
  @Test
  @DisplayName("Test visitFromBoolean(COSBoolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromBoolean(COSBoolean)"})
  void testVisitFromBoolean3() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new COSStandardOutputStream(new ByteArrayOutputStream(), 1L));

    // Act
    cosWriter.visitFromBoolean(COSBoolean.FALSE);

    // Assert
    OutputStream output = cosWriter.getOutput();
    assertTrue(output instanceof COSStandardOutputStream);
    assertEquals(5L, cosWriter.getStandardOutput().getPos());
    assertEquals(6L, ((COSStandardOutputStream) output).getPos());
  }

  /**
   * Test {@link COSWriter#visitFromDictionary(COSDictionary)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test visitFromDictionary(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDictionary(COSDictionary)"})
  void testVisitFromDictionary() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.visitFromDictionary(new COSDictionary());

    // Assert
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(6L, standardOutput.getPos());
    assertTrue(standardOutput.isOnNewLine());
    byte[] expectedToByteArrayResult = "<<\n>>\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromDictionary(COSDictionary)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test visitFromDictionary(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDictionary(COSDictionary)"})
  void testVisitFromDictionary2() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    // Act
    cosWriter.visitFromDictionary(new COSDictionary());

    // Assert
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(6L, standardOutput.getPos());
    assertTrue(standardOutput.isOnNewLine());
    byte[] expectedToByteArrayResult = "<<\n>>\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromDictionary(COSDictionary)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test visitFromDictionary(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDictionary(COSDictionary)"})
  void testVisitFromDictionary3() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.visitFromDictionary(new COSStream());

    // Assert
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(16L, standardOutput.getPos());
    assertTrue(standardOutput.isOnNewLine());
    byte[] expectedToByteArrayResult = "<<\n/Length 0\n>>\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromDictionary(COSDictionary)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test visitFromDictionary(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDictionary(COSDictionary)"})
  void testVisitFromDictionary4() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new COSStandardOutputStream(new ByteArrayOutputStream(), 3L));

    // Act
    cosWriter.visitFromDictionary(new COSDictionary());

    // Assert
    OutputStream output = cosWriter.getOutput();
    assertTrue(output instanceof COSStandardOutputStream);
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(6L, standardOutput.getPos());
    assertEquals(9L, ((COSStandardOutputStream) output).getPos());
    assertTrue(standardOutput.isOnNewLine());
  }

  /**
   * Test {@link COSWriter#visitFromDictionary(COSDictionary)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test visitFromDictionary(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDictionary(COSDictionary)"})
  void testVisitFromDictionary5() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new COSStandardOutputStream(new ByteArrayOutputStream(), 3L));

    // Act
    cosWriter.visitFromDictionary(new COSStream());

    // Assert
    OutputStream output = cosWriter.getOutput();
    assertTrue(output instanceof COSStandardOutputStream);
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(16L, standardOutput.getPos());
    assertEquals(19L, ((COSStandardOutputStream) output).getPos());
    assertTrue(standardOutput.isOnNewLine());
  }

  /**
   * Test {@link COSWriter#visitFromDocument(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromDocument(COSDocument)}
   */
  @Test
  @DisplayName("Test visitFromDocument(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDocument(COSDocument)"})
  void testVisitFromDocument() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.visitFromDocument(doc);

    // Assert
    assertEquals(85, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(85L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#visitFromDocument(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromDocument(COSDocument)}
   */
  @Test
  @DisplayName("Test visitFromDocument(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDocument(COSDocument)"})
  void testVisitFromDocument2() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.visitFromDocument(doc);

    // Assert
    assertEquals(109, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(109L, cosWriter.getStandardOutput().getPos());
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(2, xRefEntries.size());
    XReferenceEntry expectedGetResult = xRefEntries.get(0);
    assertSame(expectedGetResult, xRefEntries.get(1));
  }

  /**
   * Test {@link COSWriter#visitFromDocument(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromDocument(COSDocument)}
   */
  @Test
  @DisplayName("Test visitFromDocument(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDocument(COSDocument)"})
  void testVisitFromDocument3() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDocument doc = new COSDocument();
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream newTrailer =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 3L, 3L));
    doc.setTrailer(newTrailer);

    // Act
    cosWriter.visitFromDocument(doc);

    // Assert
    assertEquals(115, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(115L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#visitFromDocument(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromDocument(COSDocument)}
   */
  @Test
  @DisplayName("Test visitFromDocument(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDocument(COSDocument)"})
  void testVisitFromDocument4() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    NormalXReference entry = new NormalXReference(3L, new COSObjectKey(3L, 3), COSBoolean.FALSE);
    cosWriter.addXRefEntry(entry);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.visitFromDocument(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(4, xRefEntries.size());
    assertTrue(xRefEntries.get(0) instanceof FreeXReference);
    XReferenceEntry getResult = xRefEntries.get(3);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(145, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(145L, cosWriter.getStandardOutput().getPos());
    assertSame(entry, getResult);
  }

  /**
   * Test {@link COSWriter#visitFromDocument(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromDocument(COSDocument)}
   */
  @Test
  @DisplayName("Test visitFromDocument(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDocument(COSDocument)"})
  void testVisitFromDocument5() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(null);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.visitFromDocument(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(2, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(1);
    assertTrue(getResult instanceof FreeXReference);
    COSObjectKey referencedKey = getResult.getReferencedKey();
    assertEquals(-1, referencedKey.getStreamIndex());
    assertEquals(0L, referencedKey.getNumber());
    assertEquals(0L, getResult.getSecondColumnValue());
    assertEquals(65535, referencedKey.getGeneration());
    assertEquals(65535L, referencedKey.getInternalHash());
    byte[] toByteArrayResult = ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray();
    assertEquals(85, toByteArrayResult.length);
    assertEquals('1', toByteArrayResult[61]);
  }

  /**
   * Test {@link COSWriter#visitFromDocument(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromDocument(COSDocument)}
   */
  @Test
  @DisplayName("Test visitFromDocument(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDocument(COSDocument)"})
  void testVisitFromDocument6() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);
    NormalXReference entry = new NormalXReference(3L, new COSObjectKey(3L, 3), COSBoolean.FALSE);
    cosWriter.addXRefEntry(entry);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.visitFromDocument(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(5, xRefEntries.size());
    assertTrue(xRefEntries.get(3) instanceof FreeXReference);
    XReferenceEntry getResult = xRefEntries.get(4);
    assertTrue(getResult instanceof NormalXReference);
    assertSame(entry, getResult);
  }

  /**
   * Test {@link COSWriter#visitFromDocument(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromDocument(COSDocument)}
   */
  @Test
  @DisplayName("Test visitFromDocument(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDocument(COSDocument)"})
  void testVisitFromDocument7() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSStream());

    // Act
    cosWriter.visitFromDocument(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    assertTrue(xRefEntries.get(0) instanceof NormalXReference);
    assertEquals(158, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(158L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#visitFromDocument(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromDocument(COSDocument)}
   */
  @Test
  @DisplayName("Test visitFromDocument(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDocument(COSDocument)"})
  void testVisitFromDocument8() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer inputData = new RandomAccessReadBuffer(input);

    COSWriter cosWriter = new COSWriter(outputStream, inputData);

    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.visitFromDocument(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(10L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(10L, getResult.getSecondColumnValue());
    byte[] toByteArrayResult = ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray();
    assertEquals(153, toByteArrayResult.length);
    assertEquals(161L, cosWriter.getStandardOutput().getPos());
    assertEquals('%', toByteArrayResult[148]);
    assertEquals('0', toByteArrayResult[145]);
    assertEquals('1', toByteArrayResult[144]);
    assertEquals('E', toByteArrayResult[149]);
    assertEquals('F', toByteArrayResult[151]);
    assertEquals('O', toByteArrayResult[150]);
    assertEquals('\n', toByteArrayResult[152]);
  }

  /**
   * Test {@link COSWriter#visitFromDocument(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromDocument(COSDocument)}
   */
  @Test
  @DisplayName("Test visitFromDocument(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDocument(COSDocument)"})
  void testVisitFromDocument9() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    NormalXReference entry = new NormalXReference(3L, new COSObjectKey(3L, 3), COSBoolean.FALSE);
    cosWriter.addXRefEntry(entry);

    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.visitFromDocument(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(2, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(1);
    assertTrue(((NormalXReference) getResult).getObject() instanceof COSStream);
    assertTrue(getResult instanceof NormalXReference);
    byte[] toByteArrayResult = ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray();
    assertEquals(169, toByteArrayResult.length);
    assertEquals('b', toByteArrayResult[147]);
    assertEquals('d', toByteArrayResult[145]);
    assertEquals('j', toByteArrayResult[148]);
    assertEquals('n', toByteArrayResult[144]);
    assertEquals('o', toByteArrayResult[146]);
  }

  /**
   * Test {@link COSWriter#visitFromDocument(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromDocument(COSDocument)}
   */
  @Test
  @DisplayName("Test visitFromDocument(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDocument(COSDocument)"})
  void testVisitFromDocument10() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(3L, 3);
    ObjectStreamXReference entry =
        new ObjectStreamXReference(1, key, COSBoolean.FALSE, new COSObjectKey(3L, 3));
    cosWriter.addXRefEntry(entry);

    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.visitFromDocument(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(2, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(1);
    assertTrue(((NormalXReference) getResult).getObject() instanceof COSStream);
    assertTrue(getResult instanceof NormalXReference);
    byte[] toByteArrayResult = ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray();
    assertEquals(169, toByteArrayResult.length);
    assertEquals('b', toByteArrayResult[147]);
    assertEquals('d', toByteArrayResult[145]);
    assertEquals('j', toByteArrayResult[148]);
    assertEquals('n', toByteArrayResult[144]);
    assertEquals('o', toByteArrayResult[146]);
  }

  /**
   * Test {@link COSWriter#visitFromDocument(COSDocument)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromDocument(COSDocument)}
   */
  @Test
  @DisplayName("Test visitFromDocument(COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDocument(COSDocument)"})
  void testVisitFromDocument11() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSStream());

    // Act
    cosWriter.visitFromDocument(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    byte[] toByteArrayResult = ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray();
    assertEquals(152, toByteArrayResult.length);
    assertEquals(152L, cosWriter.getStandardOutput().getPos());
    assertEquals(2L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(2L, getResult.getSecondColumnValue());
    assertEquals('%', toByteArrayResult[146]);
    assertEquals('2', toByteArrayResult[144]);
    assertEquals('E', toByteArrayResult[148]);
    assertEquals('F', toByteArrayResult[150]);
    assertEquals('O', toByteArrayResult[149]);
    assertEquals('\n', toByteArrayResult[145]);
    assertEquals('e', toByteArrayResult[Float.MAX_EXPONENT]);
  }

  /**
   * Test {@link COSWriter#visitFromDocument(COSDocument)}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>Then array length is one hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#visitFromDocument(COSDocument)}
   */
  @Test
  @DisplayName(
      "Test visitFromDocument(COSDocument); given COSStream(); then array length is one hundred fifteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDocument(COSDocument)"})
  void testVisitFromDocument_givenCOSStream_thenArrayLengthIsOneHundredFifteen()
      throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSStream());

    // Act
    cosWriter.visitFromDocument(doc);

    // Assert
    assertEquals(115, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(115L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#visitFromDocument(COSDocument)}.
   *
   * <ul>
   *   <li>Then array length is eighty.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#visitFromDocument(COSDocument)}
   */
  @Test
  @DisplayName("Test visitFromDocument(COSDocument); then array length is eighty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDocument(COSDocument)"})
  void testVisitFromDocument_thenArrayLengthIsEighty() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer inputData = new RandomAccessReadBuffer(input);

    COSWriter cosWriter = new COSWriter(outputStream, inputData);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.visitFromDocument(doc);

    // Assert
    byte[] toByteArrayResult = ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray();
    assertEquals(80, toByteArrayResult.length);
    assertEquals(88L, cosWriter.getStandardOutput().getPos());
    assertEquals('%', toByteArrayResult[75]);
    assertEquals('0', toByteArrayResult[72]);
    assertEquals('1', toByteArrayResult[71]);
    assertEquals('E', toByteArrayResult[76]);
    assertEquals('F', toByteArrayResult[78]);
    assertEquals('O', toByteArrayResult[77]);
    assertEquals('\n', toByteArrayResult[73]);
    assertEquals('\n', toByteArrayResult[79]);
  }

  /**
   * Test {@link COSWriter#visitFromDocument(COSDocument)}.
   *
   * <ul>
   *   <li>Then array length is one hundred eighteen.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#visitFromDocument(COSDocument)}
   */
  @Test
  @DisplayName("Test visitFromDocument(COSDocument); then array length is one hundred eighteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDocument(COSDocument)"})
  void testVisitFromDocument_thenArrayLengthIsOneHundredEighteen() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDocument doc = new COSDocument();
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream newTrailer =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 3L, 3L));
    doc.setTrailer(newTrailer);

    // Act
    cosWriter.visitFromDocument(doc);

    // Assert
    assertEquals(118, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(118L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#visitFromDocument(COSDocument)}.
   *
   * <ul>
   *   <li>Then array length is one hundred eighty-nine.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#visitFromDocument(COSDocument)}
   */
  @Test
  @DisplayName("Test visitFromDocument(COSDocument); then array length is one hundred eighty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDocument(COSDocument)"})
  void testVisitFromDocument_thenArrayLengthIsOneHundredEightyNine() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.doWriteObject(COSBoolean.FALSE);
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.visitFromDocument(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(3, xRefEntries.size());
    assertTrue(xRefEntries.get(2) instanceof NormalXReference);
    assertEquals(189, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(189L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#visitFromDocument(COSDocument)}.
   *
   * <ul>
   *   <li>Then array length is one hundred fifty.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#visitFromDocument(COSDocument)}
   */
  @Test
  @DisplayName("Test visitFromDocument(COSDocument); then array length is one hundred fifty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDocument(COSDocument)"})
  void testVisitFromDocument_thenArrayLengthIsOneHundredFifty() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.doWriteObject(COSBoolean.FALSE);
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.visitFromDocument(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(3, xRefEntries.size());
    assertTrue(xRefEntries.get(2) instanceof NormalXReference);
    assertEquals(150, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(150L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#visitFromDocument(COSDocument)}.
   *
   * <ul>
   *   <li>Then array length is one hundred seventy-three.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#visitFromDocument(COSDocument)}
   */
  @Test
  @DisplayName(
      "Test visitFromDocument(COSDocument); then array length is one hundred seventy-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDocument(COSDocument)"})
  void testVisitFromDocument_thenArrayLengthIsOneHundredSeventyThree() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);
    NormalXReference entry = new NormalXReference(3L, new COSObjectKey(3L, 3), COSBoolean.FALSE);
    cosWriter.addXRefEntry(entry);

    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.visitFromDocument(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(3, xRefEntries.size());
    assertTrue(xRefEntries.get(2) instanceof NormalXReference);
    assertEquals(173, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(173L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#visitFromDocument(COSDocument)}.
   *
   * <ul>
   *   <li>Then array length is one hundred seventy-three.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#visitFromDocument(COSDocument)}
   */
  @Test
  @DisplayName(
      "Test visitFromDocument(COSDocument); then array length is one hundred seventy-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDocument(COSDocument)"})
  void testVisitFromDocument_thenArrayLengthIsOneHundredSeventyThree2() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);
    COSObjectKey key = new COSObjectKey(3L, 3);
    ObjectStreamXReference entry =
        new ObjectStreamXReference(1, key, COSBoolean.FALSE, new COSObjectKey(3L, 3));
    cosWriter.addXRefEntry(entry);

    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.visitFromDocument(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(3, xRefEntries.size());
    assertTrue(xRefEntries.get(2) instanceof NormalXReference);
    assertEquals(173, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(173L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#visitFromDocument(COSDocument)}.
   *
   * <ul>
   *   <li>Then array length is one hundred sixty-three.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#visitFromDocument(COSDocument)}
   */
  @Test
  @DisplayName("Test visitFromDocument(COSDocument); then array length is one hundred sixty-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDocument(COSDocument)"})
  void testVisitFromDocument_thenArrayLengthIsOneHundredSixtyThree() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.visitFromDocument(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(2, xRefEntries.size());
    assertTrue(xRefEntries.get(1) instanceof NormalXReference);
    assertEquals(163, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(163L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#visitFromDocument(COSDocument)}.
   *
   * <ul>
   *   <li>Then array length is one hundred sixty-three.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#visitFromDocument(COSDocument)}
   */
  @Test
  @DisplayName("Test visitFromDocument(COSDocument); then array length is one hundred sixty-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDocument(COSDocument)"})
  void testVisitFromDocument_thenArrayLengthIsOneHundredSixtyThree2() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.visitFromDocument(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(3, xRefEntries.size());
    assertTrue(xRefEntries.get(2) instanceof NormalXReference);
    assertEquals(163, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(163L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#visitFromDocument(COSDocument)}.
   *
   * <ul>
   *   <li>Then array length is one hundred thirty-three.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#visitFromDocument(COSDocument)}
   */
  @Test
  @DisplayName("Test visitFromDocument(COSDocument); then array length is one hundred thirty-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDocument(COSDocument)"})
  void testVisitFromDocument_thenArrayLengthIsOneHundredThirtyThree() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.visitFromDocument(doc);

    // Assert
    assertEquals(133, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(133L, cosWriter.getStandardOutput().getPos());
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(3, xRefEntries.size());
    XReferenceEntry expectedGetResult = xRefEntries.get(0);
    assertSame(expectedGetResult, xRefEntries.get(2));
  }

  /**
   * Test {@link COSWriter#visitFromDocument(COSDocument)}.
   *
   * <ul>
   *   <li>Then array length is seventy-nine.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#visitFromDocument(COSDocument)}
   */
  @Test
  @DisplayName("Test visitFromDocument(COSDocument); then array length is seventy-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDocument(COSDocument)"})
  void testVisitFromDocument_thenArrayLengthIsSeventyNine() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.visitFromDocument(doc);

    // Assert
    byte[] toByteArrayResult = ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray();
    assertEquals(79, toByteArrayResult.length);
    assertEquals(79L, cosWriter.getStandardOutput().getPos());
    assertEquals('%', toByteArrayResult[73]);
    assertEquals('2', toByteArrayResult[71]);
    assertEquals('E', toByteArrayResult[75]);
    assertEquals('F', toByteArrayResult[77]);
    assertEquals('O', toByteArrayResult[76]);
    assertEquals('\n', toByteArrayResult[72]);
    assertEquals('e', toByteArrayResult[54]);
  }

  /**
   * Test {@link COSWriter#visitFromDocument(COSDocument)}.
   *
   * <ul>
   *   <li>Then eighty-sixth element is {@code 4}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#visitFromDocument(COSDocument)}
   */
  @Test
  @DisplayName("Test visitFromDocument(COSDocument); then eighty-sixth element is '4'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDocument(COSDocument)"})
  void testVisitFromDocument_thenEightySixthElementIs4() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);
    COSObjectKey key = new COSObjectKey(3L, 3);
    ObjectStreamXReference entry =
        new ObjectStreamXReference(1, key, COSBoolean.FALSE, new COSObjectKey(3L, 3));
    cosWriter.addXRefEntry(entry);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.visitFromDocument(doc);

    // Assert
    byte[] toByteArrayResult = ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray();
    assertEquals(109, toByteArrayResult.length);
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(3, xRefEntries.size());
    assertEquals('4', toByteArrayResult[85]);
    assertSame(entry, xRefEntries.get(2));
  }

  /**
   * Test {@link COSWriter#visitFromDocument(COSDocument)}.
   *
   * <ul>
   *   <li>Then sixty-second element is {@code 4}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#visitFromDocument(COSDocument)}
   */
  @Test
  @DisplayName("Test visitFromDocument(COSDocument); then sixty-second element is '4'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromDocument(COSDocument)"})
  void testVisitFromDocument_thenSixtySecondElementIs4() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(3L, 3);
    ObjectStreamXReference entry =
        new ObjectStreamXReference(1, key, COSBoolean.FALSE, new COSObjectKey(3L, 3));
    cosWriter.addXRefEntry(entry);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.visitFromDocument(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(2, xRefEntries.size());
    byte[] toByteArrayResult = ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray();
    assertEquals(85, toByteArrayResult.length);
    assertEquals('4', toByteArrayResult[61]);
    assertSame(entry, xRefEntries.get(1));
  }

  /**
   * Test {@link COSWriter#visitFromFloat(COSFloat)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromFloat(COSFloat)}
   */
  @Test
  @DisplayName("Test visitFromFloat(COSFloat)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromFloat(COSFloat)"})
  void testVisitFromFloat() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.visitFromFloat(COSFloat.ONE);

    // Assert
    assertEquals(3L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "1.0".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromFloat(COSFloat)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromFloat(COSFloat)}
   */
  @Test
  @DisplayName("Test visitFromFloat(COSFloat)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromFloat(COSFloat)"})
  void testVisitFromFloat2() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.visitFromFloat(new COSFloat(10.0f));

    // Assert
    assertEquals(4L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "10.0".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromFloat(COSFloat)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromFloat(COSFloat)}
   */
  @Test
  @DisplayName("Test visitFromFloat(COSFloat)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromFloat(COSFloat)"})
  void testVisitFromFloat3() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.visitFromFloat(new COSFloat(-3.4028235E38f));

    // Assert
    assertEquals(40L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "-340282350000000000000000000000000000000".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromFloat(COSFloat)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromFloat(COSFloat)}
   */
  @Test
  @DisplayName("Test visitFromFloat(COSFloat)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromFloat(COSFloat)"})
  void testVisitFromFloat4() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new COSStandardOutputStream(new ByteArrayOutputStream(), 1L));

    // Act
    cosWriter.visitFromFloat(COSFloat.ONE);

    // Assert
    OutputStream output = cosWriter.getOutput();
    assertTrue(output instanceof COSStandardOutputStream);
    assertEquals(3L, cosWriter.getStandardOutput().getPos());
    assertEquals(4L, ((COSStandardOutputStream) output).getPos());
  }

  /**
   * Test {@link COSWriter#visitFromInt(COSInteger)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromInt(COSInteger)}
   */
  @Test
  @DisplayName("Test visitFromInt(COSInteger)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromInt(COSInteger)"})
  void testVisitFromInt() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.visitFromInt(COSInteger.ONE);

    // Assert
    assertEquals(1L, cosWriter.getStandardOutput().getPos());
    assertArrayEquals(
        new byte[] {'1'}, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromInt(COSInteger)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromInt(COSInteger)}
   */
  @Test
  @DisplayName("Test visitFromInt(COSInteger)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromInt(COSInteger)"})
  void testVisitFromInt2() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new COSStandardOutputStream(new ByteArrayOutputStream(), 1L));

    // Act
    cosWriter.visitFromInt(COSInteger.ONE);

    // Assert
    OutputStream output = cosWriter.getOutput();
    assertTrue(output instanceof COSStandardOutputStream);
    assertEquals(1L, cosWriter.getStandardOutput().getPos());
    assertEquals(2L, ((COSStandardOutputStream) output).getPos());
  }

  /**
   * Test {@link COSWriter#visitFromName(COSName)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromName(COSName)}
   */
  @Test
  @DisplayName("Test visitFromName(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromName(COSName)"})
  void testVisitFromName() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.visitFromName(COSName.A);

    // Assert
    assertEquals(2L, cosWriter.getStandardOutput().getPos());
    assertArrayEquals(
        new byte[] {'/', 'A'}, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromName(COSName)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromName(COSName)}
   */
  @Test
  @DisplayName("Test visitFromName(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromName(COSName)"})
  void testVisitFromName2() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.visitFromName(COSName.ABSOLUTE_COLORIMETRIC);

    // Assert
    assertEquals(21L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "/AbsoluteColorimetric".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromName(COSName)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromName(COSName)}
   */
  @Test
  @DisplayName("Test visitFromName(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromName(COSName)"})
  void testVisitFromName3() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.visitFromName(COSName.ADBE_PKCS7_DETACHED);

    // Assert
    assertEquals(20L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "/adbe.pkcs7.detached".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromName(COSName)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromName(COSName)}
   */
  @Test
  @DisplayName("Test visitFromName(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromName(COSName)"})
  void testVisitFromName4() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.visitFromName(COSName.ADBE_X509_RSA_SHA1);

    // Assert
    assertEquals(19L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "/adbe.x509.rsa_sha1".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromName(COSName)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromName(COSName)}
   */
  @Test
  @DisplayName("Test visitFromName(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromName(COSName)"})
  void testVisitFromName5() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new COSStandardOutputStream(new ByteArrayOutputStream(), 47L));

    // Act
    cosWriter.visitFromName(COSName.A);

    // Assert
    OutputStream output = cosWriter.getOutput();
    assertTrue(output instanceof COSStandardOutputStream);
    assertEquals(2L, cosWriter.getStandardOutput().getPos());
    assertEquals(49L, ((COSStandardOutputStream) output).getPos());
  }

  /**
   * Test {@link COSWriter#visitFromNull(COSNull)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromNull(COSNull)}
   */
  @Test
  @DisplayName("Test visitFromNull(COSNull)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromNull(COSNull)"})
  void testVisitFromNull() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.visitFromNull(COSNull.NULL);

    // Assert
    assertEquals(4L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "null".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromNull(COSNull)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromNull(COSNull)}
   */
  @Test
  @DisplayName("Test visitFromNull(COSNull)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromNull(COSNull)"})
  void testVisitFromNull2() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new COSStandardOutputStream(new ByteArrayOutputStream(), 1L));

    // Act
    cosWriter.visitFromNull(COSNull.NULL);

    // Assert
    OutputStream output = cosWriter.getOutput();
    assertTrue(output instanceof COSStandardOutputStream);
    assertEquals(4L, cosWriter.getStandardOutput().getPos());
    assertEquals(5L, ((COSStandardOutputStream) output).getPos());
  }

  /**
   * Test {@link COSWriter#writeReference(COSBase)}.
   *
   * <p>Method under test: {@link COSWriter#writeReference(COSBase)}
   */
  @Test
  @DisplayName("Test writeReference(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeReference(COSBase)"})
  void testWriteReference() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSArray obj = new COSArray(new ArrayList<>());
    obj.setKey(new COSObjectKey(1L, 1));

    // Act
    cosWriter.writeReference(obj);

    // Assert
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(5L, standardOutput.getPos());
    assertFalse(standardOutput.isOnNewLine());
    byte[] expectedToByteArrayResult = "1 0 R".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#writeReference(COSBase)}.
   *
   * <p>Method under test: {@link COSWriter#writeReference(COSBase)}
   */
  @Test
  @DisplayName("Test writeReference(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeReference(COSBase)"})
  void testWriteReference2() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObject obj = new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237));

    // Act
    cosWriter.writeReference(obj);

    // Assert
    COSBase object = obj.getObject();
    assertTrue(object instanceof COSBoolean);
    COSObjectKey key = obj.getKey();
    assertEquals(0, key.getGeneration());
    assertEquals(1L, key.getNumber());
    assertEquals(65536L, key.getInternalHash());
    assertSame(key, object.getKey());
    byte[] expectedToByteArrayResult = "1 0 R".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#writeReference(COSBase)}.
   *
   * <p>Method under test: {@link COSWriter#writeReference(COSBase)}
   */
  @Test
  @DisplayName("Test writeReference(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeReference(COSBase)"})
  void testWriteReference3() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1237L, 1237);
    COSObject obj = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));

    // Act
    cosWriter.writeReference(obj);

    // Assert
    assertEquals(11L, cosWriter.getStandardOutput().getPos());
    COSObjectKey key2 = obj.getKey();
    assertEquals(1237, key2.getGeneration());
    assertEquals(81069269L, key2.getInternalHash());
    byte[] expectedToByteArrayResult = "1237 1237 R".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#writeReference(COSBase)}.
   *
   * <p>Method under test: {@link COSWriter#writeReference(COSBase)}
   */
  @Test
  @DisplayName("Test writeReference(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeReference(COSBase)"})
  void testWriteReference4() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.doWriteObject(COSBoolean.FALSE);
    COSBoolean obj = COSBoolean.FALSE;

    // Act
    cosWriter.writeReference(obj);

    // Assert
    COSObjectKey key = obj.getKey();
    assertEquals(0, key.getGeneration());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(26L, standardOutput.getPos());
    assertEquals(65536L, key.getInternalHash());
    assertFalse(standardOutput.isOnNewLine());
    byte[] expectedToByteArrayResult = "1 0 obj\nfalse\nendobj\n1 0 R".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#writeReference(COSBase)}.
   *
   * <p>Method under test: {@link COSWriter#writeReference(COSBase)}
   */
  @Test
  @DisplayName("Test writeReference(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeReference(COSBase)"})
  void testWriteReference5() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObject obj = new COSObject(new COSObjectKey(1237L, 1237), null);

    // Act
    cosWriter.writeReference(obj);

    // Assert
    assertEquals(11L, cosWriter.getStandardOutput().getPos());
    COSObjectKey key = obj.getKey();
    assertEquals(1237, key.getGeneration());
    assertEquals(81069269L, key.getInternalHash());
    byte[] expectedToByteArrayResult = "1237 1237 R".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#writeReference(COSBase)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then {@link COSBoolean#FALSE} Key StreamIndex is minus one.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#writeReference(COSBase)}
   */
  @Test
  @DisplayName(
      "Test writeReference(COSBase); given 'null'; then FALSE Key StreamIndex is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeReference(COSBase)"})
  void testWriteReference_givenNull_thenFalseKeyStreamIndexIsMinusOne() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSBoolean obj = COSBoolean.FALSE;
    obj.setKey(null);

    // Act
    cosWriter.writeReference(obj);

    // Assert
    COSObjectKey key = obj.getKey();
    assertEquals(-1, key.getStreamIndex());
    assertEquals(0, key.getGeneration());
    assertEquals(1L, key.getNumber());
    assertEquals(65536L, key.getInternalHash());
    byte[] expectedToByteArrayResult = "1 0 R".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#writeReference(COSBase)}.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#writeReference(COSBase)}
   */
  @Test
  @DisplayName("Test writeReference(COSBase); when 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeReference(COSBase)"})
  void testWriteReference_whenA() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(1237L, 1237);
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser parser = new COSParser(source);

    COSObject obj = new COSObject(key, parser);

    // Act
    cosWriter.writeReference(obj);

    // Assert
    assertEquals(11L, cosWriter.getStandardOutput().getPos());
    COSObjectKey key2 = obj.getKey();
    assertEquals(1237, key2.getGeneration());
    assertEquals(81069269L, key2.getInternalHash());
    byte[] expectedToByteArrayResult = "1237 1237 R".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#writeReference(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   *   <li>Then {@link COSName#A} Key Generation is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#writeReference(COSBase)}
   */
  @Test
  @DisplayName("Test writeReference(COSBase); when A; then A Key Generation is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeReference(COSBase)"})
  void testWriteReference_whenA_thenAKeyGenerationIsZero() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSName obj = COSName.A;

    // Act
    cosWriter.writeReference(obj);

    // Assert
    COSObjectKey key = obj.getKey();
    assertEquals(0, key.getGeneration());
    assertEquals(5L, cosWriter.getStandardOutput().getPos());
    assertEquals(65536L, key.getInternalHash());
    byte[] expectedToByteArrayResult = "1 0 R".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#writeReference(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSObjectKey, ICOSParser)} with key is {@code null} and
   *       parser is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#writeReference(COSBase)}
   */
  @Test
  @DisplayName(
      "Test writeReference(COSBase); when COSObject(COSObjectKey, ICOSParser) with key is 'null' and parser is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeReference(COSBase)"})
  void testWriteReference_whenCOSObjectWithKeyIsNullAndParserIsNull() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObject obj = new COSObject((COSObjectKey) null, null);

    // Act
    cosWriter.writeReference(obj);

    // Assert
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(5L, standardOutput.getPos());
    assertFalse(standardOutput.isOnNewLine());
    byte[] expectedToByteArrayResult = "1 0 R".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#writeReference(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE} Key is {@link COSObjectKey#COSObjectKey(long, int)} with
   *       num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#writeReference(COSBase)}
   */
  @Test
  @DisplayName(
      "Test writeReference(COSBase); when FALSE Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeReference(COSBase)"})
  void testWriteReference_whenFalseKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSBoolean obj = COSBoolean.FALSE;
    obj.setKey(new COSObjectKey(1L, 1));

    // Act
    cosWriter.writeReference(obj);

    // Assert
    COSObjectKey key = obj.getKey();
    assertEquals(0, key.getGeneration());
    assertEquals(5L, cosWriter.getStandardOutput().getPos());
    assertEquals(65536L, key.getInternalHash());
    byte[] expectedToByteArrayResult = "1 0 R".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#writeReference(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSBoolean#FALSE} Key Generation is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#writeReference(COSBase)}
   */
  @Test
  @DisplayName("Test writeReference(COSBase); when FALSE; then FALSE Key Generation is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeReference(COSBase)"})
  void testWriteReference_whenFalse_thenFalseKeyGenerationIsZero() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSBoolean obj = COSBoolean.FALSE;

    // Act
    cosWriter.writeReference(obj);

    // Assert
    COSObjectKey key = obj.getKey();
    assertEquals(0, key.getGeneration());
    assertEquals(5L, cosWriter.getStandardOutput().getPos());
    assertEquals(65536L, key.getInternalHash());
    byte[] expectedToByteArrayResult = "1 0 R".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#writeReference(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSFloat#ONE}.
   *   <li>Then {@link COSFloat#ONE} Key Generation is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#writeReference(COSBase)}
   */
  @Test
  @DisplayName("Test writeReference(COSBase); when ONE; then ONE Key Generation is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeReference(COSBase)"})
  void testWriteReference_whenOne_thenOneKeyGenerationIsZero() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSFloat obj = COSFloat.ONE;

    // Act
    cosWriter.writeReference(obj);

    // Assert
    COSObjectKey key = obj.getKey();
    assertEquals(0, key.getGeneration());
    assertEquals(5L, cosWriter.getStandardOutput().getPos());
    assertEquals(65536L, key.getInternalHash());
    byte[] expectedToByteArrayResult = "1 0 R".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#writeReference(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSInteger#ONE}.
   *   <li>Then {@link COSInteger#ONE} Key Generation is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#writeReference(COSBase)}
   */
  @Test
  @DisplayName("Test writeReference(COSBase); when ONE; then ONE Key Generation is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeReference(COSBase)"})
  void testWriteReference_whenOne_thenOneKeyGenerationIsZero2() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSInteger obj = COSInteger.ONE;

    // Act
    cosWriter.writeReference(obj);

    // Assert
    COSObjectKey key = obj.getKey();
    assertEquals(0, key.getGeneration());
    assertEquals(5L, cosWriter.getStandardOutput().getPos());
    assertEquals(65536L, key.getInternalHash());
    byte[] expectedToByteArrayResult = "1 0 R".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#writeReference(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#TRUE}.
   *   <li>Then {@link COSBoolean#TRUE} Key Generation is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#writeReference(COSBase)}
   */
  @Test
  @DisplayName("Test writeReference(COSBase); when TRUE; then TRUE Key Generation is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeReference(COSBase)"})
  void testWriteReference_whenTrue_thenTrueKeyGenerationIsZero() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSBoolean obj = COSBoolean.TRUE;

    // Act
    cosWriter.writeReference(obj);

    // Assert
    COSObjectKey key = obj.getKey();
    assertEquals(0, key.getGeneration());
    assertEquals(5L, cosWriter.getStandardOutput().getPos());
    assertEquals(65536L, key.getInternalHash());
    byte[] expectedToByteArrayResult = "1 0 R".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromStream(COSStream)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromStream(COSStream)}
   */
  @Test
  @DisplayName("Test visitFromStream(COSStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromStream(COSStream)"})
  void testVisitFromStream() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.visitFromStream(new COSStream());

    // Assert
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(36L, standardOutput.getPos());
    assertTrue(standardOutput.isOnNewLine());
    byte[] expectedToByteArrayResult =
        "<<\n/Length 0\n>>\nstream\r\n\r\nendstream\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromStream(COSStream)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromStream(COSStream)}
   */
  @Test
  @DisplayName("Test visitFromStream(COSStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromStream(COSStream)"})
  void testVisitFromStream2() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    // Act
    cosWriter.visitFromStream(new COSStream());

    // Assert
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(36L, standardOutput.getPos());
    assertTrue(standardOutput.isOnNewLine());
    byte[] expectedToByteArrayResult =
        "<<\n/Length 0\n>>\nstream\r\n\r\nendstream\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromStream(COSStream)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromStream(COSStream)}
   */
  @Test
  @DisplayName("Test visitFromStream(COSStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromStream(COSStream)"})
  void testVisitFromStream3() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream obj =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 3L, 3L));

    // Act
    cosWriter.visitFromStream(obj);

    // Assert
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(36L, standardOutput.getPos());
    assertTrue(standardOutput.isOnNewLine());
    byte[] expectedToByteArrayResult =
        "<<\n/Length 3\n>>\nstream\r\n\r\nendstream\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromStream(COSStream)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromStream(COSStream)}
   */
  @Test
  @DisplayName("Test visitFromStream(COSStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromStream(COSStream)"})
  void testVisitFromStream4() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream obj = new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 3L, 3L));

    // Act
    cosWriter.visitFromStream(obj);

    // Assert
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(39L, standardOutput.getPos());
    assertTrue(standardOutput.isOnNewLine());
    assertArrayEquals(
        new byte[] {
          '<', '<', '\n', '/', 'L', 'e', 'n', 'g', 't', 'h', ' ', '3', '\n', '>', '>', '\n', 's',
          't', 'r', 'e', 'a', 'm', '\r', '\n', 3, 'A', 3, '\r', '\n', 'e', 'n', 'd', 's', 't', 'r',
          'e', 'a', 'm', '\n'
        },
        ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromStream(COSStream)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromStream(COSStream)}
   */
  @Test
  @DisplayName("Test visitFromStream(COSStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromStream(COSStream)"})
  void testVisitFromStream5() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream obj = new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 6L, 3L));

    // Act
    cosWriter.visitFromStream(obj);

    // Assert
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(38L, standardOutput.getPos());
    assertTrue(standardOutput.isOnNewLine());
    assertArrayEquals(
        new byte[] {
          '<', '<', '\n', '/', 'L', 'e', 'n', 'g', 't', 'h', ' ', '3', '\n', '>', '>', '\n', 's',
          't', 'r', 'e', 'a', 'm', '\r', '\n', 'A', 3, '\r', '\n', 'e', 'n', 'd', 's', 't', 'r',
          'e', 'a', 'm', '\n'
        },
        ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromStream(COSStream)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromStream(COSStream)}
   */
  @Test
  @DisplayName("Test visitFromStream(COSStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromStream(COSStream)"})
  void testVisitFromStream6() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream obj =
        new COSStream(
            streamCache,
            new RandomAccessReadView(
                new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L), 3L, 3L));

    // Act
    cosWriter.visitFromStream(obj);

    // Assert
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(36L, standardOutput.getPos());
    assertTrue(standardOutput.isOnNewLine());
    byte[] expectedToByteArrayResult =
        "<<\n/Length 3\n>>\nstream\r\n\r\nendstream\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromString(COSString)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromString(COSString)}
   */
  @Test
  @DisplayName("Test visitFromString(COSString)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromString(COSString)"})
  void testVisitFromString() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.visitFromString(COSString.parseHex("0123456789ABCDEF"));

    // Assert
    assertEquals(18L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "<0123456789ABCDEF>".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromString(COSString)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromString(COSString)}
   */
  @Test
  @DisplayName("Test visitFromString(COSString)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromString(COSString)"})
  void testVisitFromString2() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.visitFromString(new COSString("Text"));

    // Assert
    assertEquals(6L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "(Text)".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromString(COSString)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromString(COSString)}
   */
  @Test
  @DisplayName("Test visitFromString(COSString)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromString(COSString)"})
  void testVisitFromString3() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.visitFromString(new COSString("Text", true));

    // Assert
    assertEquals(10L, cosWriter.getStandardOutput().getPos());
    byte[] expectedToByteArrayResult = "<54657874>".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray());
  }

  /**
   * Test {@link COSWriter#visitFromString(COSString)}.
   *
   * <p>Method under test: {@link COSWriter#visitFromString(COSString)}
   */
  @Test
  @DisplayName("Test visitFromString(COSString)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.visitFromString(COSString)"})
  void testVisitFromString4() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new COSStandardOutputStream(new ByteArrayOutputStream(), 3L));

    // Act
    cosWriter.visitFromString(COSString.parseHex("0123456789ABCDEF"));

    // Assert
    OutputStream output = cosWriter.getOutput();
    assertTrue(output instanceof COSStandardOutputStream);
    assertEquals(18L, cosWriter.getStandardOutput().getPos());
    assertEquals(21L, ((COSStandardOutputStream) output).getPos());
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(COSDocument)"})
  void testWriteWithCOSDocument() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.write(doc);

    // Assert
    byte[] toByteArrayResult = ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray();
    assertEquals(155, toByteArrayResult.length);
    assertEquals(155L, cosWriter.getStandardOutput().getPos());
    assertEquals('%', toByteArrayResult[149]);
    assertEquals('1', toByteArrayResult[132]);
    assertEquals('2', toByteArrayResult[147]);
    assertEquals('E', toByteArrayResult[151]);
    assertEquals('F', toByteArrayResult[153]);
    assertEquals('O', toByteArrayResult[152]);
    assertEquals('\n', toByteArrayResult[148]);
    assertEquals('e', toByteArrayResult[130]);
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(COSDocument)"})
  void testWriteWithCOSDocument2() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.write(doc);

    // Assert
    assertEquals(15L, cosWriter.getStartxref());
    assertEquals(161, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(161L, cosWriter.getStandardOutput().getPos());
    assertEquals(2, doc.getDocumentID().toList().size());
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(COSDocument)"})
  void testWriteWithCOSDocument3() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.write(doc);

    // Assert
    assertEquals(179, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(179L, cosWriter.getStandardOutput().getPos());
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(2, xRefEntries.size());
    XReferenceEntry expectedGetResult = xRefEntries.get(0);
    assertSame(expectedGetResult, xRefEntries.get(1));
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(COSDocument)"})
  void testWriteWithCOSDocument4() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.write(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(3, xRefEntries.size());
    assertTrue(xRefEntries.get(1) instanceof FreeXReference);
    assertTrue(xRefEntries.get(2) instanceof NormalXReference);
    assertEquals(267, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(267L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(COSDocument)"})
  void testWriteWithCOSDocument5() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    COSDocument doc = new COSDocument();
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream newTrailer =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));
    doc.setTrailer(newTrailer);

    // Act
    cosWriter.write(doc);

    // Assert
    assertEquals(185, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(185L, cosWriter.getStandardOutput().getPos());
    assertEquals(2, doc.getDocumentID().toList().size());
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(COSDocument)"})
  void testWriteWithCOSDocument6() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());
    cosWriter.addXRefEntry(null);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.write(doc);

    // Assert
    List<? extends COSBase> toListResult = doc.getDocumentID().toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSString);
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(2, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(1);
    assertTrue(getResult instanceof FreeXReference);
    COSObjectKey referencedKey = getResult.getReferencedKey();
    assertEquals(0L, referencedKey.getNumber());
    assertEquals(0L, getResult.getSecondColumnValue());
    assertEquals(65535, referencedKey.getGeneration());
    assertEquals(65535L, referencedKey.getInternalHash());
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(COSDocument)"})
  void testWriteWithCOSDocument7() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer inputData = new RandomAccessReadBuffer(input);

    COSWriter cosWriter = new COSWriter(outputStream, inputData);

    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.write(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(10L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(10L, getResult.getSecondColumnValue());
    byte[] toByteArrayResult = ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray();
    assertEquals(229, toByteArrayResult.length);
    assertEquals(237L, cosWriter.getStandardOutput().getPos());
    assertEquals('%', toByteArrayResult[224]);
    assertEquals('0', toByteArrayResult[221]);
    assertEquals('1', toByteArrayResult[220]);
    assertEquals('E', toByteArrayResult[225]);
    assertEquals('F', toByteArrayResult[227]);
    assertEquals('O', toByteArrayResult[226]);
    assertEquals('\n', toByteArrayResult[222]);
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(COSDocument)"})
  void testWriteWithCOSDocument8() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);

    COSDocument doc = new COSDocument();
    doc.setHighestXRefObjectNumber(3L);
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.write(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(5, xRefEntries.size());
    assertTrue(xRefEntries.get(0) instanceof FreeXReference);
    assertTrue(xRefEntries.get(2) instanceof FreeXReference);
    assertTrue(xRefEntries.get(3) instanceof FreeXReference);
    assertTrue(xRefEntries.get(4) instanceof NormalXReference);
    assertEquals(303, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(303L, cosWriter.getStandardOutput().getPos());
    assertEquals(4L, doc.getHighestXRefObjectNumber());
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(COSDocument)"})
  void testWriteWithCOSDocument9() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);

    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.write(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(2, xRefEntries.size());
    assertTrue(xRefEntries.get(0) instanceof NormalXReference);
    assertTrue(xRefEntries.get(1) instanceof NormalXReference);
    assertEquals(301, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(301L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(COSDocument)"})
  void testWriteWithCOSDocument10() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSStream());

    // Act
    cosWriter.write(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(getResult instanceof NormalXReference);
    byte[] toByteArrayResult = ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray();
    assertEquals(228, toByteArrayResult.length);
    assertEquals(228L, cosWriter.getStandardOutput().getPos());
    assertEquals(2L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(2L, getResult.getSecondColumnValue());
    assertEquals('%', toByteArrayResult[222]);
    assertEquals('2', toByteArrayResult[220]);
    assertEquals('E', toByteArrayResult[224]);
    assertEquals('F', toByteArrayResult[226]);
    assertEquals('O', toByteArrayResult[225]);
    assertEquals('\n', toByteArrayResult[221]);
    assertEquals('\n', toByteArrayResult[227]);
    assertEquals('e', toByteArrayResult[203]);
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(COSDocument)"})
  void testWriteWithCOSDocument11() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.write(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(3, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(2);
    COSBase object = ((NormalXReference) getResult).getObject();
    assertTrue(object instanceof COSStream);
    List<? extends COSBase> toListResult = doc.getDocumentID().toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSString);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(12L, ((COSStream) object).getLength());
    COSObjectKey referencedKey = getResult.getReferencedKey();
    assertEquals(1L, referencedKey.getNumber());
    assertEquals(2L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(2L, getResult.getSecondColumnValue());
    assertEquals(65536L, referencedKey.getInternalHash());
    assertSame(referencedKey, object.getKey());
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(COSDocument)"})
  void testWriteWithCOSDocument12() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());
    cosWriter.doWriteObject(COSBoolean.FALSE);
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.write(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(4, xRefEntries.size());
    assertTrue(xRefEntries.get(3) instanceof NormalXReference);
    assertEquals(23L, cosWriter.getStartxref());
    assertEquals(260, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(260L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>Then array length is one hundred eighty-five.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName(
      "Test write(COSDocument) with 'COSDocument'; given COSStream(); then array length is one hundred eighty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(COSDocument)"})
  void testWriteWithCOSDocument_givenCOSStream_thenArrayLengthIsOneHundredEightyFive()
      throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSStream());

    // Act
    cosWriter.write(doc);

    // Assert
    assertEquals(185, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(185L, cosWriter.getStandardOutput().getPos());
    assertEquals(2, doc.getDocumentID().toList().size());
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   *
   * <ul>
   *   <li>Then array length is one hundred eighty-eight.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName(
      "Test write(COSDocument) with 'COSDocument'; then array length is one hundred eighty-eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(COSDocument)"})
  void testWriteWithCOSDocument_thenArrayLengthIsOneHundredEightyEight() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    COSDocument doc = new COSDocument();
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream newTrailer =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 3L));
    doc.setTrailer(newTrailer);

    // Act
    cosWriter.write(doc);

    // Assert
    assertEquals(188, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(188L, cosWriter.getStandardOutput().getPos());
    assertEquals(2, doc.getDocumentID().toList().size());
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   *
   * <ul>
   *   <li>Then array length is one hundred fifty-six.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName(
      "Test write(COSDocument) with 'COSDocument'; then array length is one hundred fifty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(COSDocument)"})
  void testWriteWithCOSDocument_thenArrayLengthIsOneHundredFiftySix() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer inputData = new RandomAccessReadBuffer(input);

    COSWriter cosWriter = new COSWriter(outputStream, inputData);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.write(doc);

    // Assert
    byte[] toByteArrayResult = ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray();
    assertEquals(156, toByteArrayResult.length);
    assertEquals(164L, cosWriter.getStandardOutput().getPos());
    assertEquals('%', toByteArrayResult[151]);
    assertEquals('0', toByteArrayResult[148]);
    assertEquals('1', toByteArrayResult[147]);
    assertEquals('E', toByteArrayResult[152]);
    assertEquals('F', toByteArrayResult[154]);
    assertEquals('O', toByteArrayResult[153]);
    assertEquals('\n', toByteArrayResult[149]);
    assertEquals('\n', toByteArrayResult[155]);
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   *
   * <ul>
   *   <li>Then array length is one hundred seventy-five.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName(
      "Test write(COSDocument) with 'COSDocument'; then array length is one hundred seventy-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(COSDocument)"})
  void testWriteWithCOSDocument_thenArrayLengthIsOneHundredSeventyFive() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());
    cosWriter.addXRefEntry(new FreeXReference(new COSObjectKey(1L, 1), 1L));

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.write(doc);

    // Assert
    byte[] toByteArrayResult = ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray();
    assertEquals(175, toByteArrayResult.length);
    assertEquals(175L, cosWriter.getStandardOutput().getPos());
    assertEquals('%', toByteArrayResult[169]);
    assertEquals('2', toByteArrayResult[167]);
    assertEquals('E', toByteArrayResult[171]);
    assertEquals('F', toByteArrayResult[173]);
    assertEquals('O', toByteArrayResult[172]);
    assertEquals('\n', toByteArrayResult[168]);
    assertEquals('\n', toByteArrayResult[174]);
    assertEquals('e', toByteArrayResult[150]);
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   *
   * <ul>
   *   <li>Then array length is one hundred seventy-six.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName(
      "Test write(COSDocument) with 'COSDocument'; then array length is one hundred seventy-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(COSDocument)"})
  void testWriteWithCOSDocument_thenArrayLengthIsOneHundredSeventySix() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer inputData = new RandomAccessReadBuffer(input);

    COSWriter cosWriter = new COSWriter(outputStream, inputData);
    cosWriter.addXRefEntry(new FreeXReference(new COSObjectKey(1L, 1), 1L));

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.write(doc);

    // Assert
    List<? extends COSBase> toListResult = doc.getDocumentID().toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSString);
    byte[] toByteArrayResult = ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray();
    assertEquals(176, toByteArrayResult.length);
    assertEquals(184L, cosWriter.getStandardOutput().getPos());
    assertEquals('%', toByteArrayResult[171]);
    assertEquals('0', toByteArrayResult[168]);
    assertEquals('1', toByteArrayResult[167]);
    assertEquals('E', toByteArrayResult[172]);
    assertEquals('F', toByteArrayResult[174]);
    assertEquals('O', toByteArrayResult[173]);
    assertEquals('\n', toByteArrayResult[175]);
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   *
   * <ul>
   *   <li>Then array length is three hundred seven.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName(
      "Test write(COSDocument) with 'COSDocument'; then array length is three hundred seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(COSDocument)"})
  void testWriteWithCOSDocument_thenArrayLengthIsThreeHundredSeven() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.write(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(3, xRefEntries.size());
    assertTrue(xRefEntries.get(2) instanceof NormalXReference);
    assertEquals(307, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(307L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   *
   * <ul>
   *   <li>Then array length is two hundred forty-three.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName(
      "Test write(COSDocument) with 'COSDocument'; then array length is two hundred forty-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(COSDocument)"})
  void testWriteWithCOSDocument_thenArrayLengthIsTwoHundredFortyThree() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.write(doc);

    // Assert
    assertEquals(2, doc.getDocumentID().toList().size());
    assertEquals(243, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(243L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   *
   * <ul>
   *   <li>Then array length is two hundred thirty-five.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName(
      "Test write(COSDocument) with 'COSDocument'; then array length is two hundred thirty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(COSDocument)"})
  void testWriteWithCOSDocument_thenArrayLengthIsTwoHundredThirtyFive() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());
    COSObjectKey key = new COSObjectKey(1L, 1);
    ObjectStreamXReference entry =
        new ObjectStreamXReference(1, key, COSBoolean.FALSE, new COSObjectKey(1L, 1));
    cosWriter.addXRefEntry(entry);

    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.write(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(2, xRefEntries.size());
    assertTrue(xRefEntries.get(1) instanceof NormalXReference);
    assertEquals(235, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(235L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   *
   * <ul>
   *   <li>Then array length is two hundred thirty-three.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName(
      "Test write(COSDocument) with 'COSDocument'; then array length is two hundred thirty-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(COSDocument)"})
  void testWriteWithCOSDocument_thenArrayLengthIsTwoHundredThirtyThree() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.write(doc);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(2, xRefEntries.size());
    assertTrue(xRefEntries.get(1) instanceof NormalXReference);
    assertEquals(233, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(233L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   *
   * <ul>
   *   <li>Then one hundred fifty-seventh element is {@code 2}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName(
      "Test write(COSDocument) with 'COSDocument'; then one hundred fifty-seventh element is '2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(COSDocument)"})
  void testWriteWithCOSDocument_thenOneHundredFiftySeventhElementIs2() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);
    COSObjectKey key = new COSObjectKey(1L, 1);
    ObjectStreamXReference entry =
        new ObjectStreamXReference(1, key, COSBoolean.FALSE, new COSObjectKey(1L, 1));
    cosWriter.addXRefEntry(entry);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.write(doc);

    // Assert
    byte[] toByteArrayResult = ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray();
    assertEquals(179, toByteArrayResult.length);
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(3, xRefEntries.size());
    assertEquals('2', toByteArrayResult[156]);
    assertSame(entry, xRefEntries.get(2));
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   *
   * <ul>
   *   <li>Then one hundred thirty-third element is {@code 2}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName(
      "Test write(COSDocument) with 'COSDocument'; then one hundred thirty-third element is '2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(COSDocument)"})
  void testWriteWithCOSDocument_thenOneHundredThirtyThirdElementIs2() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());
    COSObjectKey key = new COSObjectKey(1L, 1);
    ObjectStreamXReference entry =
        new ObjectStreamXReference(1, key, COSBoolean.FALSE, new COSObjectKey(1L, 1));
    cosWriter.addXRefEntry(entry);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.write(doc);

    // Assert
    byte[] toByteArrayResult = ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray();
    assertEquals(155, toByteArrayResult.length);
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(2, xRefEntries.size());
    assertEquals('2', toByteArrayResult[132]);
    assertSame(entry, xRefEntries.get(1));
  }

  /**
   * Test {@link COSWriter#write(FDFDocument)} with {@code FDFDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(FDFDocument)}
   */
  @Test
  @DisplayName("Test write(FDFDocument) with 'FDFDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(FDFDocument)"})
  void testWriteWithFDFDocument() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.write(new FDFDocument());

    // Assert
    assertEquals(138, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(138L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(FDFDocument)} with {@code FDFDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(FDFDocument)}
   */
  @Test
  @DisplayName("Test write(FDFDocument) with 'FDFDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(FDFDocument)"})
  void testWriteWithFDFDocument2() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    // Act
    cosWriter.write(new FDFDocument());

    // Assert
    assertEquals(133, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(133L, cosWriter.getStandardOutput().getPos());
    assertEquals(2, cosWriter.getXRefEntries().size());
    assertEquals(23L, cosWriter.getStartxref());
  }

  /**
   * Test {@link COSWriter#write(FDFDocument)} with {@code FDFDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(FDFDocument)}
   */
  @Test
  @DisplayName("Test write(FDFDocument) with 'FDFDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(FDFDocument)"})
  void testWriteWithFDFDocument3() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    // Act
    cosWriter.write(new FDFDocument());

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(3, xRefEntries.size());
    assertTrue(xRefEntries.get(1) instanceof FreeXReference);
    assertTrue(xRefEntries.get(2) instanceof NormalXReference);
    assertEquals(162, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(162L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(FDFDocument)} with {@code FDFDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(FDFDocument)}
   */
  @Test
  @DisplayName("Test write(FDFDocument) with 'FDFDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(FDFDocument)"})
  void testWriteWithFDFDocument4() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.doWriteObject(COSBoolean.FALSE);
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    // Act
    cosWriter.write(new FDFDocument());

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(4, xRefEntries.size());
    assertTrue(xRefEntries.get(3) instanceof NormalXReference);
    assertEquals(203, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(203L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(FDFDocument)} with {@code FDFDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(FDFDocument)}
   */
  @Test
  @DisplayName("Test write(FDFDocument) with 'FDFDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(FDFDocument)"})
  void testWriteWithFDFDocument5() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer inputData = new RandomAccessReadBuffer(input);

    COSWriter cosWriter = new COSWriter(outputStream, inputData);

    // Act
    cosWriter.write(new FDFDocument());

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(2, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(1);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(10L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(10L, getResult.getSecondColumnValue());
    byte[] toByteArrayResult = ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray();
    assertEquals(133, toByteArrayResult.length);
    assertEquals(141L, cosWriter.getStandardOutput().getPos());
    assertEquals(31L, cosWriter.getStartxref());
    assertEquals('1', toByteArrayResult[125]);
    assertEquals('3', toByteArrayResult[124]);
  }

  /**
   * Test {@link COSWriter#write(FDFDocument)} with {@code FDFDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(FDFDocument)}
   */
  @Test
  @DisplayName("Test write(FDFDocument) with 'FDFDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(FDFDocument)"})
  void testWriteWithFDFDocument6() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    NormalXReference entry = new NormalXReference(3L, new COSObjectKey(3L, 3), COSBoolean.FALSE);
    cosWriter.addXRefEntry(entry);

    // Act
    cosWriter.write(new FDFDocument());

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(4, xRefEntries.size());
    assertTrue(xRefEntries.get(0) instanceof FreeXReference);
    assertEquals(178, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(178L, cosWriter.getStandardOutput().getPos());
    assertSame(entry, xRefEntries.get(3));
  }

  /**
   * Test {@link COSWriter#write(FDFDocument)} with {@code FDFDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(FDFDocument)}
   */
  @Test
  @DisplayName("Test write(FDFDocument) with 'FDFDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(FDFDocument)"})
  void testWriteWithFDFDocument7() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(null);

    // Act
    cosWriter.write(new FDFDocument());

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(3, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(1);
    assertTrue(getResult instanceof FreeXReference);
    COSObjectKey referencedKey = getResult.getReferencedKey();
    assertEquals(-1, referencedKey.getStreamIndex());
    assertEquals(0L, referencedKey.getNumber());
    assertEquals(65535, referencedKey.getGeneration());
    assertEquals(65535L, referencedKey.getInternalHash());
  }

  /**
   * Test {@link COSWriter#write(FDFDocument)} with {@code FDFDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(FDFDocument)}
   */
  @Test
  @DisplayName("Test write(FDFDocument) with 'FDFDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(FDFDocument)"})
  void testWriteWithFDFDocument8() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.doWriteObject(COSBoolean.FALSE);
    COSObjectKey key = new COSObjectKey(3L, 3);
    ObjectStreamXReference entry =
        new ObjectStreamXReference(1, key, COSBoolean.FALSE, new COSObjectKey(3L, 3));
    cosWriter.addXRefEntry(entry);

    // Act
    cosWriter.write(new FDFDocument());

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(4, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(3);
    assertTrue(getResult instanceof ObjectStreamXReference);
    assertEquals(179, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(179L, cosWriter.getStandardOutput().getPos());
    assertSame(entry, getResult);
  }

  /**
   * Test {@link COSWriter#write(FDFDocument)} with {@code FDFDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(FDFDocument)}
   */
  @Test
  @DisplayName("Test write(FDFDocument) with 'FDFDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(FDFDocument)"})
  void testWriteWithFDFDocument9() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    COSDocument doc = new COSDocument();
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream newTrailer =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 3L, 3L));
    doc.setTrailer(newTrailer);
    FDFDocument doc2 = new FDFDocument(doc, new RandomAccessReadWriteBuffer());

    // Act
    cosWriter.write(doc2);

    // Assert
    assertEquals(109, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(109L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(FDFDocument)} with {@code FDFDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(FDFDocument)}
   */
  @Test
  @DisplayName("Test write(FDFDocument) with 'FDFDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(FDFDocument)"})
  void testWriteWithFDFDocument10() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSStream());
    FDFDocument doc2 = new FDFDocument(doc, new RandomAccessReadWriteBuffer());

    // Act
    cosWriter.write(doc2);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    assertTrue(xRefEntries.get(0) instanceof NormalXReference);
    assertEquals(152, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(152L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(FDFDocument)} with {@code FDFDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(FDFDocument)}
   */
  @Test
  @DisplayName("Test write(FDFDocument) with 'FDFDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(FDFDocument)"})
  void testWriteWithFDFDocument11() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSStream());
    FDFDocument doc2 = new FDFDocument(doc, new RandomAccessReadWriteBuffer());

    // Act
    cosWriter.write(doc2);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(((NormalXReference) getResult).getObject() instanceof COSStream);
    assertTrue(getResult instanceof NormalXReference);
    byte[] toByteArrayResult = ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray();
    assertEquals(158, toByteArrayResult.length);
    assertEquals(158L, cosWriter.getStandardOutput().getPos());
    assertEquals(15L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(15L, getResult.getSecondColumnValue());
    assertEquals('%', toByteArrayResult[153]);
    assertEquals('1', toByteArrayResult[149]);
    assertEquals('5', toByteArrayResult[150]);
    assertEquals('E', toByteArrayResult[154]);
    assertEquals('F', toByteArrayResult[156]);
    assertEquals('O', toByteArrayResult[155]);
    assertEquals('\n', toByteArrayResult[157]);
  }

  /**
   * Test {@link COSWriter#write(FDFDocument)} with {@code FDFDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(FDFDocument)}
   */
  @Test
  @DisplayName("Test write(FDFDocument) with 'FDFDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(FDFDocument)"})
  void testWriteWithFDFDocument12() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSStream());
    FDFDocument doc2 = new FDFDocument(doc, new RandomAccessReadWriteBuffer());

    // Act
    cosWriter.write(doc2);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(2, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(1);
    COSBase object = ((NormalXReference) getResult).getObject();
    assertTrue(((COSStream) object).getFilters() instanceof COSName);
    assertTrue(object instanceof COSStream);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(12L, ((COSStream) object).getLength());
    assertEquals(7, ((COSStream) object).getValues().size());
    assertEquals(7, ((COSStream) object).size());
    assertFalse(((COSStream) object).isNeedToBeUpdated());
    assertTrue(((COSStream) object).hasData());
  }

  /**
   * Test {@link COSWriter#write(FDFDocument)} with {@code FDFDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(FDFDocument)}
   */
  @Test
  @DisplayName("Test write(FDFDocument) with 'FDFDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(FDFDocument)"})
  void testWriteWithFDFDocument13() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSStream());
    FDFDocument doc2 = new FDFDocument(doc, new RandomAccessReadWriteBuffer());

    // Act
    cosWriter.write(doc2);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(3, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(2);
    assertTrue(((NormalXReference) getResult).getObject() instanceof COSStream);
    assertTrue(getResult instanceof NormalXReference);
    byte[] toByteArrayResult = ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray();
    assertEquals(157, toByteArrayResult.length);
    assertEquals(157L, cosWriter.getStandardOutput().getPos());
    assertEquals(2L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(2L, getResult.getSecondColumnValue());
    assertEquals('%', toByteArrayResult[151]);
    assertEquals('/', toByteArrayResult[24]);
    assertEquals('1', toByteArrayResult[21]);
    assertEquals('2', toByteArrayResult[149]);
    assertEquals('2', toByteArrayResult[22]);
    assertEquals('E', toByteArrayResult[153]);
    assertEquals('F', toByteArrayResult[155]);
    assertEquals('O', toByteArrayResult[154]);
    assertEquals('\n', toByteArrayResult[150]);
    assertEquals('e', toByteArrayResult[132]);
  }

  /**
   * Test {@link COSWriter#write(FDFDocument)} with {@code FDFDocument}.
   *
   * <ul>
   *   <li>Then array length is eighty-five.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(FDFDocument)}
   */
  @Test
  @DisplayName("Test write(FDFDocument) with 'FDFDocument'; then array length is eighty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(FDFDocument)"})
  void testWriteWithFDFDocument_thenArrayLengthIsEightyFive() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());
    FDFDocument doc2 = new FDFDocument(doc, new RandomAccessReadWriteBuffer());

    // Act
    cosWriter.write(doc2);

    // Assert
    assertEquals(85, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(85L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(FDFDocument)} with {@code FDFDocument}.
   *
   * <ul>
   *   <li>Then array length is one hundred eighty-four.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(FDFDocument)}
   */
  @Test
  @DisplayName(
      "Test write(FDFDocument) with 'FDFDocument'; then array length is one hundred eighty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(FDFDocument)"})
  void testWriteWithFDFDocument_thenArrayLengthIsOneHundredEightyFour() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());
    cosWriter.doWriteObject(COSBoolean.FALSE);
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSStream());
    FDFDocument doc2 = new FDFDocument(doc, new RandomAccessReadWriteBuffer());

    // Act
    cosWriter.write(doc2);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(3, xRefEntries.size());
    assertTrue(xRefEntries.get(2) instanceof NormalXReference);
    assertEquals(184, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(184L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(FDFDocument)} with {@code FDFDocument}.
   *
   * <ul>
   *   <li>Then array length is one hundred nine.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(FDFDocument)}
   */
  @Test
  @DisplayName("Test write(FDFDocument) with 'FDFDocument'; then array length is one hundred nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(FDFDocument)"})
  void testWriteWithFDFDocument_thenArrayLengthIsOneHundredNine() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSStream());
    FDFDocument doc2 = new FDFDocument(doc, new RandomAccessReadWriteBuffer());

    // Act
    cosWriter.write(doc2);

    // Assert
    assertEquals(109, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(109L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(FDFDocument)} with {@code FDFDocument}.
   *
   * <ul>
   *   <li>Then array length is one hundred twelve.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(FDFDocument)}
   */
  @Test
  @DisplayName(
      "Test write(FDFDocument) with 'FDFDocument'; then array length is one hundred twelve")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(FDFDocument)"})
  void testWriteWithFDFDocument_thenArrayLengthIsOneHundredTwelve() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    COSDocument doc = new COSDocument();
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream newTrailer =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 3L, 3L));
    doc.setTrailer(newTrailer);
    FDFDocument doc2 = new FDFDocument(doc, new RandomAccessReadWriteBuffer());

    // Act
    cosWriter.write(doc2);

    // Assert
    assertEquals(112, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(112L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(FDFDocument)} with {@code FDFDocument}.
   *
   * <ul>
   *   <li>Then array length is seventy-nine.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(FDFDocument)}
   */
  @Test
  @DisplayName("Test write(FDFDocument) with 'FDFDocument'; then array length is seventy-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(FDFDocument)"})
  void testWriteWithFDFDocument_thenArrayLengthIsSeventyNine() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());
    FDFDocument doc2 = new FDFDocument(doc, new RandomAccessReadWriteBuffer());

    // Act
    cosWriter.write(doc2);

    // Assert
    assertEquals(79, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(79L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(FDFDocument)} with {@code FDFDocument}.
   *
   * <ul>
   *   <li>Then calls {@link RandomAccessStreamCache.StreamCacheCreateFunction#create()}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(FDFDocument)}
   */
  @Test
  @DisplayName("Test write(FDFDocument) with 'FDFDocument'; then calls create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(FDFDocument)"})
  void testWriteWithFDFDocument_thenCallsCreate() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    COSDocument doc = new COSDocument(streamCacheCreateFunction);
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSDictionary());
    FDFDocument doc2 = new FDFDocument(doc, new RandomAccessReadWriteBuffer());

    // Act
    cosWriter.write(doc2);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(0);
    assertTrue(((NormalXReference) getResult).getObject() instanceof COSStream);
    assertTrue(getResult instanceof NormalXReference);
    byte[] toByteArrayResult = ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray();
    assertEquals(158, toByteArrayResult.length);
    assertEquals(158L, cosWriter.getStandardOutput().getPos());
    assertEquals(15L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(15L, getResult.getSecondColumnValue());
    assertEquals('%', toByteArrayResult[153]);
    assertEquals('1', toByteArrayResult[149]);
    assertEquals('5', toByteArrayResult[150]);
    assertEquals('E', toByteArrayResult[154]);
    assertEquals('F', toByteArrayResult[156]);
    assertEquals('O', toByteArrayResult[155]);
    assertEquals('\n', toByteArrayResult[157]);
  }

  /**
   * Test {@link COSWriter#write(FDFDocument)} with {@code FDFDocument}.
   *
   * <ul>
   *   <li>Then one hundred fifteenth element is {@code 4}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(FDFDocument)}
   */
  @Test
  @DisplayName(
      "Test write(FDFDocument) with 'FDFDocument'; then one hundred fifteenth element is '4'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(FDFDocument)"})
  void testWriteWithFDFDocument_thenOneHundredFifteenthElementIs4() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    COSObjectKey key = new COSObjectKey(3L, 3);
    ObjectStreamXReference entry =
        new ObjectStreamXReference(1, key, COSBoolean.FALSE, new COSObjectKey(3L, 3));
    cosWriter.addXRefEntry(entry);

    // Act
    cosWriter.write(new FDFDocument());

    // Assert
    byte[] toByteArrayResult = ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray();
    assertEquals(138, toByteArrayResult.length);
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(3, xRefEntries.size());
    assertEquals('4', toByteArrayResult[114]);
    assertSame(entry, xRefEntries.get(2));
  }

  /**
   * Test {@link COSWriter#write(FDFDocument)} with {@code FDFDocument}.
   *
   * <ul>
   *   <li>Then one hundred thirty-ninth element is {@code 4}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(FDFDocument)}
   */
  @Test
  @DisplayName(
      "Test write(FDFDocument) with 'FDFDocument'; then one hundred thirty-ninth element is '4'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(FDFDocument)"})
  void testWriteWithFDFDocument_thenOneHundredThirtyNinthElementIs4() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    FreeXReference entry = new FreeXReference(new COSObjectKey(3L, 3), 3L);
    cosWriter.addXRefEntry(entry);

    // Act
    cosWriter.write(new FDFDocument());

    // Assert
    byte[] toByteArrayResult = ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray();
    assertEquals(162, toByteArrayResult.length);
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(3, xRefEntries.size());
    assertEquals('4', toByteArrayResult[138]);
    assertSame(entry, xRefEntries.get(2));
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName("Test write(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    // Act
    cosWriter.write(new PDDocument());

    // Assert
    assertEquals(117L, cosWriter.getStartxref());
    assertEquals(324, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(324L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName("Test write(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument2() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);

    // Act
    cosWriter.write(new PDDocument());

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(5, xRefEntries.size());
    assertTrue(xRefEntries.get(3) instanceof FreeXReference);
    assertEquals(226L, cosWriter.getStartxref());
    assertEquals(445, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(445L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName("Test write(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument3() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    // Act
    cosWriter.write(new PDDocument());

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(4, xRefEntries.size());
    assertTrue(xRefEntries.get(1) instanceof FreeXReference);
    assertTrue(xRefEntries.get(2) instanceof NormalXReference);
    assertEquals(353, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(353L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName("Test write(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument4() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    // Act
    cosWriter.write(new PDDocument());

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(5, xRefEntries.size());
    assertTrue(xRefEntries.get(2) instanceof FreeXReference);
    assertEquals(377, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(377L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName("Test write(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument5() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(4, xRefEntries.size());
    assertTrue(xRefEntries.get(3) instanceof NormalXReference);
    assertEquals(428, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(428L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName("Test write(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument6() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(7, xRefEntries.size());
    assertTrue(xRefEntries.get(5) instanceof FreeXReference);
    assertTrue(xRefEntries.get(6) instanceof NormalXReference);
    assertTrue(xRefEntries.get(4) instanceof ObjectStreamXReference);
    assertEquals(276L, cosWriter.getStartxref());
    assertEquals(515, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(515L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName("Test write(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument7() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(4, xRefEntries.size());
    assertTrue(xRefEntries.get(1) instanceof NormalXReference);
    assertTrue(xRefEntries.get(2) instanceof NormalXReference);
    assertEquals(459, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(459L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName("Test write(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument8() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.protect(new PublicKeyProtectionPolicy());
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(314L, cosWriter.getStartxref());
    assertEquals(568, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(568L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName("Test write(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument9() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.setDocumentId(1L);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<? extends COSBase> toListResult = doc.getDocument().getDocumentID().toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    assertEquals("C4CA4238A0B923820DCC509A6F75849B", ((COSString) getResult).toHexString());
    assertEquals("ÄÊB8€¹#‡\rÌPıou—ł", ((COSString) getResult).getString());
    assertEquals("��B8��#�\r�P�ou��", ((COSString) getResult).getASCII());
    assertArrayEquals(
        new byte[] {
          -60, -54, 'B', '8', -96, -71, '#', -126, '\r', -52, 'P', -102, 'o', 'u', -124, -101
        },
        ((COSString) getResult).getBytes());
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName("Test write(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument10() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new BufferedOutputStream(new ByteArrayOutputStream(), 3));

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenThrow(new IOException());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<? extends COSBase> toListResult = doc.getDocument().getDocumentID().toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSString);
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName("Test write(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument11() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    PDPage page = new PDPage();
    page.setTransition(new PDTransition(), 10.0f);

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.addPage(page);

    // Act
    cosWriter.write(doc);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(277L, cosWriter.getStartxref());
    assertEquals(5, cosWriter.getXRefEntries().size());
    assertEquals(516, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(516L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName("Test write(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument12() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new COSStandardOutputStream(new ByteArrayOutputStream(), 1L));

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenThrow(new IOException());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<? extends COSBase> toListResult = doc.getDocument().getDocumentID().toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSString);
    OutputStream output = cosWriter.getOutput();
    assertTrue(output instanceof COSStandardOutputStream);
    assertEquals(434L, ((COSStandardOutputStream) output).getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName("Test write(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument13() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.addPage(new PDPage());
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(9, xRefEntries.size());
    assertTrue(xRefEntries.get(6) instanceof ObjectStreamXReference);
    assertEquals(545, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(545L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName("Test write(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument14() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    doc.addPage(new PDPage());
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(6, xRefEntries.size());
    assertTrue(xRefEntries.get(1) instanceof ObjectStreamXReference);
    assertTrue(xRefEntries.get(3) instanceof ObjectStreamXReference);
    assertEquals(539, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(539L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName("Test write(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument15() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.protect(new PublicKeyProtectionPolicy());
    doc.addPage(new PDPage());
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(10, xRefEntries.size());
    assertTrue(xRefEntries.get(9) instanceof NormalXReference);
    assertEquals(386L, cosWriter.getStartxref());
    assertEquals(680, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(680L, cosWriter.getStandardOutput().getPos());
    assertEquals(6L, doc.getDocument().getHighestXRefObjectNumber());
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName("Test write(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument16() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.setEncryptionDictionary(new PDEncryption());
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(4, xRefEntries.size());
    assertTrue(xRefEntries.get(3) instanceof NormalXReference);
    assertEquals(428, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(428L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName("Test write(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument17() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(4, xRefEntries.size());
    assertTrue(xRefEntries.get(0) instanceof NormalXReference);
    assertTrue(xRefEntries.get(1) instanceof NormalXReference);
    assertEquals(454, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(454L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName("Test write(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument18() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(5, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(4);
    COSBase object = ((NormalXReference) getResult).getObject();
    assertTrue(((COSStream) object).getFilters() instanceof COSName);
    assertTrue(object instanceof COSStream);
    assertTrue(getResult instanceof NormalXReference);
    COSObjectKey referencedKey = getResult.getReferencedKey();
    assertEquals(-1, referencedKey.getStreamIndex());
    assertEquals(0, referencedKey.getGeneration());
    assertEquals(25L, ((COSStream) object).getLength());
    assertEquals(524288L, referencedKey.getInternalHash());
    assertEquals(8, ((COSStream) object).getValues().size());
    assertEquals(8, ((COSStream) object).size());
    assertEquals(8L, referencedKey.getNumber());
    assertTrue(((COSStream) object).hasData());
    assertSame(referencedKey, object.getKey());
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName("Test write(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument19() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    StandardProtectionPolicy policy =
        new StandardProtectionPolicy(
            "iloveyou", "iloveyou", AccessPermission.getOwnerAccessPermission());
    doc.protect(policy);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc);

    // Assert
    verify(streamCacheCreateFunction).create();
    PDEncryption encryption = doc.getEncryption();
    assertEquals("Standard", encryption.getFilter());
    assertEquals(-4, encryption.getPermissions());
    assertEquals(3, encryption.getRevision());
    assertEquals(420L, cosWriter.getStartxref());
    assertEquals(674, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(674L, cosWriter.getStandardOutput().getPos());
    assertArrayEquals(
        new byte[] {
          'm', -115, -105, -20, ' ', -36, 'j', -69, 29, 15, -95, '+', -114, '\r', -89, -100, 'x',
          -37, -98, -44, -78, -124, -61, -86, -52, 'E', -115, -64, -118, -56, -82, -121
        },
        encryption.getOwnerKey());
  }

  /**
   * Test {@link COSWriter#write(PDDocument, SignatureInterface)} with {@code PDDocument}, {@code
   * SignatureInterface}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument, SignatureInterface)}
   */
  @Test
  @DisplayName("Test write(PDDocument, SignatureInterface) with 'PDDocument', 'SignatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument, SignatureInterface)"})
  void testWriteWithPDDocumentSignatureInterface() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.write(new PDDocument(), mock(SignatureInterface.class));

    // Assert
    assertEquals(329, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
  }

  /**
   * Test {@link COSWriter#write(PDDocument, SignatureInterface)} with {@code PDDocument}, {@code
   * SignatureInterface}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument, SignatureInterface)}
   */
  @Test
  @DisplayName("Test write(PDDocument, SignatureInterface) with 'PDDocument', 'SignatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument, SignatureInterface)"})
  void testWriteWithPDDocumentSignatureInterface2() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    // Act
    cosWriter.write(new PDDocument(), mock(SignatureInterface.class));

    // Assert
    assertEquals(117L, cosWriter.getStartxref());
    assertEquals(324, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(324L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument, SignatureInterface)} with {@code PDDocument}, {@code
   * SignatureInterface}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument, SignatureInterface)}
   */
  @Test
  @DisplayName("Test write(PDDocument, SignatureInterface) with 'PDDocument', 'SignatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument, SignatureInterface)"})
  void testWriteWithPDDocumentSignatureInterface3() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);

    // Act
    cosWriter.write(new PDDocument(), mock(SignatureInterface.class));

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(5, xRefEntries.size());
    assertTrue(xRefEntries.get(3) instanceof FreeXReference);
    assertEquals(226L, cosWriter.getStartxref());
    assertEquals(445, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(445L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument, SignatureInterface)} with {@code PDDocument}, {@code
   * SignatureInterface}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument, SignatureInterface)}
   */
  @Test
  @DisplayName("Test write(PDDocument, SignatureInterface) with 'PDDocument', 'SignatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument, SignatureInterface)"})
  void testWriteWithPDDocumentSignatureInterface4() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    // Act
    cosWriter.write(new PDDocument(), mock(SignatureInterface.class));

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(4, xRefEntries.size());
    assertTrue(xRefEntries.get(1) instanceof FreeXReference);
    assertTrue(xRefEntries.get(2) instanceof NormalXReference);
    assertEquals(353, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(353L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument, SignatureInterface)} with {@code PDDocument}, {@code
   * SignatureInterface}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument, SignatureInterface)}
   */
  @Test
  @DisplayName("Test write(PDDocument, SignatureInterface) with 'PDDocument', 'SignatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument, SignatureInterface)"})
  void testWriteWithPDDocumentSignatureInterface5() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    // Act
    cosWriter.write(new PDDocument(), mock(SignatureInterface.class));

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(5, xRefEntries.size());
    assertTrue(xRefEntries.get(2) instanceof FreeXReference);
    assertTrue(xRefEntries.get(4) instanceof NormalXReference);
    assertEquals(377, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(377L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument, SignatureInterface)} with {@code PDDocument}, {@code
   * SignatureInterface}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument, SignatureInterface)}
   */
  @Test
  @DisplayName("Test write(PDDocument, SignatureInterface) with 'PDDocument', 'SignatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument, SignatureInterface)"})
  void testWriteWithPDDocumentSignatureInterface6() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc, mock(SignatureInterface.class));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(433, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(433L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument, SignatureInterface)} with {@code PDDocument}, {@code
   * SignatureInterface}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument, SignatureInterface)}
   */
  @Test
  @DisplayName("Test write(PDDocument, SignatureInterface) with 'PDDocument', 'SignatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument, SignatureInterface)"})
  void testWriteWithPDDocumentSignatureInterface7() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc, mock(SignatureInterface.class));

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(4, xRefEntries.size());
    assertTrue(xRefEntries.get(1) instanceof NormalXReference);
    assertTrue(xRefEntries.get(2) instanceof NormalXReference);
    assertEquals(459, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(459L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument, SignatureInterface)} with {@code PDDocument}, {@code
   * SignatureInterface}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument, SignatureInterface)}
   */
  @Test
  @DisplayName("Test write(PDDocument, SignatureInterface) with 'PDDocument', 'SignatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument, SignatureInterface)"})
  void testWriteWithPDDocumentSignatureInterface8() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.protect(new PublicKeyProtectionPolicy());
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc, mock(SignatureInterface.class));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(314L, cosWriter.getStartxref());
    assertEquals(568, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(568L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument, SignatureInterface)} with {@code PDDocument}, {@code
   * SignatureInterface}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument, SignatureInterface)}
   */
  @Test
  @DisplayName("Test write(PDDocument, SignatureInterface) with 'PDDocument', 'SignatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument, SignatureInterface)"})
  void testWriteWithPDDocumentSignatureInterface9() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.setDocumentId(1L);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc, mock(SignatureInterface.class));

    // Assert
    verify(streamCacheCreateFunction).create();
    List<? extends COSBase> toListResult = doc.getDocument().getDocumentID().toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    assertEquals("C4CA4238A0B923820DCC509A6F75849B", ((COSString) getResult).toHexString());
    assertEquals("ÄÊB8€¹#‡\rÌPıou—ł", ((COSString) getResult).getString());
    assertEquals("��B8��#�\r�P�ou��", ((COSString) getResult).getASCII());
    assertArrayEquals(
        new byte[] {
          -60, -54, 'B', '8', -96, -71, '#', -126, '\r', -52, 'P', -102, 'o', 'u', -124, -101
        },
        ((COSString) getResult).getBytes());
  }

  /**
   * Test {@link COSWriter#write(PDDocument, SignatureInterface)} with {@code PDDocument}, {@code
   * SignatureInterface}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument, SignatureInterface)}
   */
  @Test
  @DisplayName("Test write(PDDocument, SignatureInterface) with 'PDDocument', 'SignatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument, SignatureInterface)"})
  void testWriteWithPDDocumentSignatureInterface10() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new COSStandardOutputStream(new ByteArrayOutputStream(), 1L));

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    // Act
    cosWriter.write(doc, mock(SignatureInterface.class));

    // Assert
    verify(streamCacheCreateFunction).create();
    List<? extends COSBase> toListResult = doc.getDocument().getDocumentID().toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSString);
    OutputStream output = cosWriter.getOutput();
    assertTrue(output instanceof COSStandardOutputStream);
    assertEquals(3, cosWriter.getXRefEntries().size());
    assertEquals(329L, cosWriter.getStandardOutput().getPos());
    assertEquals(330L, ((COSStandardOutputStream) output).getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument, SignatureInterface)} with {@code PDDocument}, {@code
   * SignatureInterface}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument, SignatureInterface)}
   */
  @Test
  @DisplayName("Test write(PDDocument, SignatureInterface) with 'PDDocument', 'SignatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument, SignatureInterface)"})
  void testWriteWithPDDocumentSignatureInterface11() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc, mock(SignatureInterface.class));

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(4, xRefEntries.size());
    assertTrue(xRefEntries.get(3) instanceof NormalXReference);
    assertEquals(428, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(428L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument, SignatureInterface)} with {@code PDDocument}, {@code
   * SignatureInterface}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument, SignatureInterface)}
   */
  @Test
  @DisplayName("Test write(PDDocument, SignatureInterface) with 'PDDocument', 'SignatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument, SignatureInterface)"})
  void testWriteWithPDDocumentSignatureInterface12() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.setDocumentInformation(new PDDocumentInformation());
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc, mock(SignatureInterface.class));

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(9, xRefEntries.size());
    assertTrue(xRefEntries.get(7) instanceof FreeXReference);
    assertTrue(xRefEntries.get(8) instanceof NormalXReference);
    assertTrue(xRefEntries.get(6) instanceof ObjectStreamXReference);
    assertEquals(285L, cosWriter.getStartxref());
    assertEquals(556, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(556L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument, SignatureInterface)} with {@code PDDocument}, {@code
   * SignatureInterface}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument, SignatureInterface)}
   */
  @Test
  @DisplayName("Test write(PDDocument, SignatureInterface) with 'PDDocument', 'SignatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument, SignatureInterface)"})
  void testWriteWithPDDocumentSignatureInterface13() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.setEncryptionDictionary(new PDEncryption());
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc, mock(SignatureInterface.class));

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(4, xRefEntries.size());
    assertTrue(xRefEntries.get(3) instanceof NormalXReference);
    assertEquals(428, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(428L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument, SignatureInterface)} with {@code PDDocument}, {@code
   * SignatureInterface}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument, SignatureInterface)}
   */
  @Test
  @DisplayName("Test write(PDDocument, SignatureInterface) with 'PDDocument', 'SignatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument, SignatureInterface)"})
  void testWriteWithPDDocumentSignatureInterface14() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter cosWriter = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc, mock(SignatureInterface.class));

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(4, xRefEntries.size());
    assertTrue(xRefEntries.get(0) instanceof NormalXReference);
    assertTrue(xRefEntries.get(1) instanceof NormalXReference);
    assertEquals(454, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(454L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument, SignatureInterface)} with {@code PDDocument}, {@code
   * SignatureInterface}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument, SignatureInterface)}
   */
  @Test
  @DisplayName("Test write(PDDocument, SignatureInterface) with 'PDDocument', 'SignatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument, SignatureInterface)"})
  void testWriteWithPDDocumentSignatureInterface15() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc, mock(SignatureInterface.class));

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(5, xRefEntries.size());
    assertTrue(xRefEntries.get(1) instanceof ObjectStreamXReference);
    assertTrue(xRefEntries.get(2) instanceof ObjectStreamXReference);
    assertEquals(526, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(526L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument, SignatureInterface)} with {@code PDDocument}, {@code
   * SignatureInterface}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument, SignatureInterface)}
   */
  @Test
  @DisplayName("Test write(PDDocument, SignatureInterface) with 'PDDocument', 'SignatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument, SignatureInterface)"})
  void testWriteWithPDDocumentSignatureInterface16() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc, mock(SignatureInterface.class));

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(5, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(4);
    COSBase object = ((NormalXReference) getResult).getObject();
    assertTrue(object instanceof COSStream);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(25L, ((COSStream) object).getLength());
    COSObjectKey referencedKey = getResult.getReferencedKey();
    assertEquals(524288L, referencedKey.getInternalHash());
    assertEquals(8L, referencedKey.getNumber());
    assertSame(referencedKey, object.getKey());
  }

  /**
   * Test {@link COSWriter#write(PDDocument, SignatureInterface)} with {@code PDDocument}, {@code
   * SignatureInterface}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument, SignatureInterface)}
   */
  @Test
  @DisplayName("Test write(PDDocument, SignatureInterface) with 'PDDocument', 'SignatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument, SignatureInterface)"})
  void testWriteWithPDDocumentSignatureInterface17() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc, mock(SignatureInterface.class));

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(6, xRefEntries.size());
    XReferenceEntry getResult = xRefEntries.get(5);
    COSBase object = ((NormalXReference) getResult).getObject();
    assertTrue(object instanceof COSStream);
    XReferenceEntry getResult2 = xRefEntries.get(4);
    assertTrue(getResult2 instanceof NormalXReference);
    assertTrue(getResult instanceof NormalXReference);
    assertEquals(135L, ((NormalXReference) getResult2).getByteOffset());
    assertEquals(135L, getResult2.getSecondColumnValue());
    assertEquals(214L, ((NormalXReference) getResult).getByteOffset());
    assertEquals(214L, getResult.getSecondColumnValue());
    assertEquals(25L, ((COSStream) object).getLength());
  }

  /**
   * Test {@link COSWriter#write(PDDocument, SignatureInterface)} with {@code PDDocument}, {@code
   * SignatureInterface}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument, SignatureInterface)}
   */
  @Test
  @DisplayName("Test write(PDDocument, SignatureInterface) with 'PDDocument', 'SignatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument, SignatureInterface)"})
  void testWriteWithPDDocumentSignatureInterface18() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc, mock(SignatureInterface.class));

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(7, xRefEntries.size());
    assertTrue(xRefEntries.get(6) instanceof NormalXReference);
    assertTrue(xRefEntries.get(4) instanceof ObjectStreamXReference);
    assertEquals(532, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(532L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument, SignatureInterface)} with {@code PDDocument}, {@code
   * SignatureInterface}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument, SignatureInterface)}
   */
  @Test
  @DisplayName("Test write(PDDocument, SignatureInterface) with 'PDDocument', 'SignatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument, SignatureInterface)"})
  void testWriteWithPDDocumentSignatureInterface19() throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.protect(new PublicKeyProtectionPolicy());
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc, mock(SignatureInterface.class));

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(8, xRefEntries.size());
    assertTrue(xRefEntries.get(7) instanceof NormalXReference);
    assertEquals(376L, cosWriter.getStartxref());
    assertEquals(650, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(650L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument, SignatureInterface)} with {@code PDDocument}, {@code
   * SignatureInterface}.
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument, SignatureInterface)}
   */
  @Test
  @DisplayName("Test write(PDDocument, SignatureInterface) with 'PDDocument', 'SignatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument, SignatureInterface)"})
  void testWriteWithPDDocumentSignatureInterface20() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    StandardProtectionPolicy policy =
        new StandardProtectionPolicy(
            "iloveyou", "iloveyou", AccessPermission.getOwnerAccessPermission());
    doc.protect(policy);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc, mock(SignatureInterface.class));

    // Assert
    verify(streamCacheCreateFunction).create();
    PDEncryption encryption = doc.getEncryption();
    assertEquals("Standard", encryption.getFilter());
    assertEquals(-4, encryption.getPermissions());
    assertEquals(3, encryption.getRevision());
    assertEquals(420L, cosWriter.getStartxref());
    assertEquals(674, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(674L, cosWriter.getStandardOutput().getPos());
    assertArrayEquals(
        new byte[] {
          'm', -115, -105, -20, ' ', -36, 'j', -69, 29, 15, -95, '+', -114, '\r', -89, -100, 'x',
          -37, -98, -44, -78, -124, -61, -86, -52, 'E', -115, -64, -118, -56, -82, -121
        },
        encryption.getOwnerKey());
  }

  /**
   * Test {@link COSWriter#write(PDDocument, SignatureInterface)} with {@code PDDocument}, {@code
   * SignatureInterface}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument, SignatureInterface)}
   */
  @Test
  @DisplayName(
      "Test write(PDDocument, SignatureInterface) with 'PDDocument', 'SignatureInterface'; given 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument, SignatureInterface)"})
  void testWriteWithPDDocumentSignatureInterface_givenTrue() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.setAllSecurityToBeRemoved(true);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc, mock(SignatureInterface.class));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(433, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(433L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument, SignatureInterface)} with {@code PDDocument}, {@code
   * SignatureInterface}.
   *
   * <ul>
   *   <li>Then array length is five hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument, SignatureInterface)}
   */
  @Test
  @DisplayName(
      "Test write(PDDocument, SignatureInterface) with 'PDDocument', 'SignatureInterface'; then array length is five hundred fifteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument, SignatureInterface)"})
  void testWriteWithPDDocumentSignatureInterface_thenArrayLengthIsFiveHundredFifteen()
      throws IOException {
    // Arrange
    COSWriter cosWriter =
        new COSWriter(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc, mock(SignatureInterface.class));

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(7, xRefEntries.size());
    assertTrue(xRefEntries.get(4) instanceof ObjectStreamXReference);
    assertEquals(515, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(515L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument, SignatureInterface)} with {@code PDDocument}, {@code
   * SignatureInterface}.
   *
   * <ul>
   *   <li>Then array length is four hundred eighty-six.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument, SignatureInterface)}
   */
  @Test
  @DisplayName(
      "Test write(PDDocument, SignatureInterface) with 'PDDocument', 'SignatureInterface'; then array length is four hundred eighty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument, SignatureInterface)"})
  void testWriteWithPDDocumentSignatureInterface_thenArrayLengthIsFourHundredEightySix()
      throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.setDocumentInformation(new PDDocumentInformation());
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc, mock(SignatureInterface.class));

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(5, xRefEntries.size());
    assertTrue(xRefEntries.get(2) instanceof NormalXReference);
    assertEquals(486, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(486L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument, SignatureInterface)} with {@code PDDocument}, {@code
   * SignatureInterface}.
   *
   * <ul>
   *   <li>Then array length is four hundred ninety-two.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument, SignatureInterface)}
   */
  @Test
  @DisplayName(
      "Test write(PDDocument, SignatureInterface) with 'PDDocument', 'SignatureInterface'; then array length is four hundred ninety-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument, SignatureInterface)"})
  void testWriteWithPDDocumentSignatureInterface_thenArrayLengthIsFourHundredNinetyTwo()
      throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.doWriteObject(COSBoolean.FALSE);
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc, mock(SignatureInterface.class));

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(6, xRefEntries.size());
    assertTrue(xRefEntries.get(5) instanceof NormalXReference);
    assertEquals(492, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(492L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName("Test write(PDDocument) with 'PDDocument'; given 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument_givenTrue() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.setAllSecurityToBeRemoved(true);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(433, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then array length is four hundred eighty-six.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test write(PDDocument) with 'PDDocument'; then array length is four hundred eighty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument_thenArrayLengthIsFourHundredEightySix() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.setDocumentInformation(new PDDocumentInformation());
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(5, xRefEntries.size());
    assertTrue(xRefEntries.get(2) instanceof NormalXReference);
    assertEquals(486, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(486L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then array length is four hundred ninety-two.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test write(PDDocument) with 'PDDocument'; then array length is four hundred ninety-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument_thenArrayLengthIsFourHundredNinetyTwo() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.doWriteObject(COSBoolean.FALSE);
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(6, xRefEntries.size());
    assertTrue(xRefEntries.get(5) instanceof NormalXReference);
    assertEquals(492, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(492L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then array length is four hundred sixty-eight.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test write(PDDocument) with 'PDDocument'; then array length is four hundred sixty-eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument_thenArrayLengthIsFourHundredSixtyEight() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(6, xRefEntries.size());
    assertTrue(xRefEntries.get(5) instanceof NormalXReference);
    assertEquals(468, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(468L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then array length is four hundred thirty-three.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test write(PDDocument) with 'PDDocument'; then array length is four hundred thirty-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument_thenArrayLengthIsFourHundredThirtyThree() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(433, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then {@link PDDocument#PDDocument()} Document DocumentID toList size is two.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test write(PDDocument) with 'PDDocument'; then PDDocument() Document DocumentID toList size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument_thenPDDocumentDocumentDocumentIDToListSizeIsTwo()
      throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    PDDocument doc = new PDDocument();
    doc.addPage(new PDPage());

    // Act
    cosWriter.write(doc);

    // Assert
    List<? extends COSBase> toListResult = doc.getDocument().getDocumentID().toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSString);
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(4, xRefEntries.size());
    assertTrue(xRefEntries.get(2) instanceof NormalXReference);
    assertTrue(xRefEntries.get(3) instanceof NormalXReference);
  }

  /**
   * Test {@link COSWriter#write(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then array length is three hundred twenty-nine.
   * </ul>
   *
   * <p>Method under test: {@link COSWriter#write(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test write(PDDocument) with 'PDDocument'; when PDDocument(); then array length is three hundred twenty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.write(PDDocument)"})
  void testWriteWithPDDocument_whenPDDocument_thenArrayLengthIsThreeHundredTwentyNine()
      throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.write(new PDDocument());

    // Assert
    assertEquals(329, ((ByteArrayOutputStream) cosWriter.getOutput()).toByteArray().length);
    assertEquals(329L, cosWriter.getStandardOutput().getPos());
  }

  /**
   * Test {@link COSWriter#writeString(byte[], OutputStream)} with {@code bytes}, {@code output}.
   *
   * <p>Method under test: {@link COSWriter#writeString(byte[], OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(byte[], OutputStream) with 'bytes', 'output'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeString(byte[], OutputStream)"})
  void testWriteStringWithBytesOutput() throws IOException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    COSWriter.writeString(bytes, output);

    // Assert
    byte[] expectedToByteArrayResult = "(AXAXAXAX)".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link COSWriter#writeString(byte[], OutputStream)} with {@code bytes}, {@code output}.
   *
   * <p>Method under test: {@link COSWriter#writeString(byte[], OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(byte[], OutputStream) with 'bytes', 'output'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeString(byte[], OutputStream)"})
  void testWriteStringWithBytesOutput2() throws IOException {
    // Arrange
    byte[] bytes = "\rXAXAXAX".getBytes("UTF-8");
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    COSWriter.writeString(bytes, output);

    // Assert
    byte[] expectedToByteArrayResult = "<0D58415841584158>".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link COSWriter#writeString(byte[], OutputStream)} with {@code bytes}, {@code output}.
   *
   * <p>Method under test: {@link COSWriter#writeString(byte[], OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(byte[], OutputStream) with 'bytes', 'output'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeString(byte[], OutputStream)"})
  void testWriteStringWithBytesOutput3() throws IOException {
    // Arrange
    byte[] bytes = "\nXAXAXAX".getBytes("UTF-8");
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    COSWriter.writeString(bytes, output);

    // Assert
    byte[] expectedToByteArrayResult = "<0A58415841584158>".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link COSWriter#writeString(byte[], OutputStream)} with {@code bytes}, {@code output}.
   *
   * <p>Method under test: {@link COSWriter#writeString(byte[], OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(byte[], OutputStream) with 'bytes', 'output'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeString(byte[], OutputStream)"})
  void testWriteStringWithBytesOutput4() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    COSWriter.writeString(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, output);

    // Assert
    byte[] expectedToByteArrayResult = "<FF58415841584158>".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link COSWriter#writeString(byte[], OutputStream)} with {@code bytes}, {@code output}.
   *
   * <p>Method under test: {@link COSWriter#writeString(byte[], OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(byte[], OutputStream) with 'bytes', 'output'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeString(byte[], OutputStream)"})
  void testWriteStringWithBytesOutput5() throws IOException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    COSStandardOutputStream output = new COSStandardOutputStream(new ByteArrayOutputStream(), 1L);

    // Act
    COSWriter.writeString(bytes, output);

    // Assert
    assertEquals(11L, output.getPos());
  }

  /**
   * Test {@link COSWriter#writeString(byte[], OutputStream)} with {@code bytes}, {@code output}.
   *
   * <p>Method under test: {@link COSWriter#writeString(byte[], OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(byte[], OutputStream) with 'bytes', 'output'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeString(byte[], OutputStream)"})
  void testWriteStringWithBytesOutput6() throws IOException {
    // Arrange
    byte[] bytes = "\rXAXAXAX".getBytes("UTF-8");
    COSStandardOutputStream output = new COSStandardOutputStream(new ByteArrayOutputStream(), 1L);

    // Act
    COSWriter.writeString(bytes, output);

    // Assert
    assertEquals(19L, output.getPos());
  }

  /**
   * Test {@link COSWriter#writeString(byte[], OutputStream)} with {@code bytes}, {@code output}.
   *
   * <p>Method under test: {@link COSWriter#writeString(byte[], OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(byte[], OutputStream) with 'bytes', 'output'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeString(byte[], OutputStream)"})
  void testWriteStringWithBytesOutput7() throws IOException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    COSStandardOutputStream output =
        new COSStandardOutputStream(
            new COSStandardOutputStream(new ByteArrayOutputStream(), 1L), 1L);

    // Act
    COSWriter.writeString(bytes, output);

    // Assert
    assertEquals(11L, output.getPos());
  }

  /**
   * Test {@link COSWriter#writeString(COSString, OutputStream)} with {@code string}, {@code
   * output}.
   *
   * <p>Method under test: {@link COSWriter#writeString(COSString, OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(COSString, OutputStream) with 'string', 'output'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeString(COSString, OutputStream)"})
  void testWriteStringWithStringOutput() throws IOException {
    // Arrange
    COSString string = COSString.parseHex("0123456789ABCDEF");
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    COSWriter.writeString(string, output);

    // Assert
    byte[] expectedToByteArrayResult = "<0123456789ABCDEF>".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link COSWriter#writeString(COSString, OutputStream)} with {@code string}, {@code
   * output}.
   *
   * <p>Method under test: {@link COSWriter#writeString(COSString, OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(COSString, OutputStream) with 'string', 'output'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeString(COSString, OutputStream)"})
  void testWriteStringWithStringOutput2() throws IOException {
    // Arrange
    COSString string = new COSString("Text");
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    COSWriter.writeString(string, output);

    // Assert
    byte[] expectedToByteArrayResult = "(Text)".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link COSWriter#writeString(COSString, OutputStream)} with {@code string}, {@code
   * output}.
   *
   * <p>Method under test: {@link COSWriter#writeString(COSString, OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(COSString, OutputStream) with 'string', 'output'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeString(COSString, OutputStream)"})
  void testWriteStringWithStringOutput3() throws IOException {
    // Arrange
    COSString string = new COSString("Text", true);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    COSWriter.writeString(string, output);

    // Assert
    byte[] expectedToByteArrayResult = "<54657874>".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link COSWriter#writeString(COSString, OutputStream)} with {@code string}, {@code
   * output}.
   *
   * <p>Method under test: {@link COSWriter#writeString(COSString, OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(COSString, OutputStream) with 'string', 'output'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeString(COSString, OutputStream)"})
  void testWriteStringWithStringOutput4() throws IOException {
    // Arrange
    COSString string = COSString.parseHex("0123456789ABCDEF");
    COSStandardOutputStream output = new COSStandardOutputStream(new ByteArrayOutputStream(), 3L);

    // Act
    COSWriter.writeString(string, output);

    // Assert
    assertEquals(21L, output.getPos());
  }

  /**
   * Test {@link COSWriter#writeString(COSString, OutputStream)} with {@code string}, {@code
   * output}.
   *
   * <p>Method under test: {@link COSWriter#writeString(COSString, OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(COSString, OutputStream) with 'string', 'output'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeString(COSString, OutputStream)"})
  void testWriteStringWithStringOutput5() throws IOException {
    // Arrange
    COSString string = new COSString("Text");
    COSStandardOutputStream output = new COSStandardOutputStream(new ByteArrayOutputStream(), 3L);

    // Act
    COSWriter.writeString(string, output);

    // Assert
    assertEquals(9L, output.getPos());
  }

  /**
   * Test {@link COSWriter#writeString(COSString, OutputStream)} with {@code string}, {@code
   * output}.
   *
   * <p>Method under test: {@link COSWriter#writeString(COSString, OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(COSString, OutputStream) with 'string', 'output'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.writeString(COSString, OutputStream)"})
  void testWriteStringWithStringOutput6() throws IOException {
    // Arrange
    COSString string = COSString.parseHex("0123456789ABCDEF");
    COSStandardOutputStream output =
        new COSStandardOutputStream(
            new COSStandardOutputStream(new ByteArrayOutputStream(), 3L), 3L);

    // Act
    COSWriter.writeString(string, output);

    // Assert
    assertEquals(21L, output.getPos());
  }
}

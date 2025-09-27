package org.apache.pdfbox.pdfwriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import org.apache.pdfbox.pdfparser.xref.FreeXReference;
import org.apache.pdfbox.pdfparser.xref.XReferenceEntry;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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
   * Test {@link COSWriter#COSWriter(OutputStream, CompressParameters)}.
   *
   * <p>Method under test: {@link COSWriter#COSWriter(OutputStream, CompressParameters)}
   */
  @Test
  @DisplayName("Test new COSWriter(OutputStream, CompressParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.<init>(OutputStream, CompressParameters)"})
  void testNewCOSWriter2() {
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
   * Test {@link COSWriter#COSWriter(OutputStream)}.
   *
   * <p>Method under test: {@link COSWriter#COSWriter(OutputStream)}
   */
  @Test
  @DisplayName("Test new COSWriter(OutputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.<init>(OutputStream)"})
  void testNewCOSWriter3() {
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
   * Test {@link COSWriter#COSWriter(OutputStream, CompressParameters)}.
   *
   * <p>Method under test: {@link COSWriter#COSWriter(OutputStream, CompressParameters)}
   */
  @Test
  @DisplayName("Test new COSWriter(OutputStream, CompressParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.<init>(OutputStream, CompressParameters)"})
  void testNewCOSWriter4() {
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
   * Test {@link COSWriter#addXRefEntry(XReferenceEntry)}.
   *
   * <p>Method under test: {@link COSWriter#addXRefEntry(XReferenceEntry)}
   */
  @Test
  @DisplayName("Test addXRefEntry(XReferenceEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriter.addXRefEntry(XReferenceEntry)"})
  void testAddXRefEntry2() {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream());

    // Act
    cosWriter.addXRefEntry(FreeXReference.NULL_ENTRY);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    assertSame(FreeXReference.NULL_ENTRY, xRefEntries.get(0));
  }
}

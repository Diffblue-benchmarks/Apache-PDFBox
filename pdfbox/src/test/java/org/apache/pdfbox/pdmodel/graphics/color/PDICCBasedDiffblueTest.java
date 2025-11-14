package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.common.PDRange;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDICCBasedDiffblueTest {
  /**
   * Test {@link PDICCBased#PDICCBased(PDDocument)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then COSObject return {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link PDICCBased#PDICCBased(PDDocument)}
   */
  @Test
  @DisplayName("Test new PDICCBased(PDDocument); when PDDocument(); then COSObject return COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDICCBased.<init>(PDDocument)"})
  void testNewPDICCBased_whenPDDocument_thenCOSObjectReturnCOSArray() throws IOException {
    // Arrange and Act
    PDICCBased actualPdiccBased = new PDICCBased(new PDDocument());

    // Assert
    COSBase cOSObject = actualPdiccBased.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    assertEquals("ICCBased", actualPdiccBased.getName());
    PDStream pDStream = actualPdiccBased.getPDStream();
    assertNull(pDStream.getDecodeParms());
    assertNull(pDStream.getFileDecodeParams());
    assertNull(actualPdiccBased.getMetadata());
    assertNull(pDStream.getMetadata());
    assertNull(pDStream.getFile());
    assertNull(actualPdiccBased.getInitialColor());
    assertEquals(-1, pDStream.getDecodedStreamLength());
    assertEquals(-1, actualPdiccBased.getNumberOfComponents());
    assertEquals(0, pDStream.getLength());
    assertEquals(2, ((COSArray) cOSObject).toList().size());
    assertFalse(actualPdiccBased.isSRGB());
    List<String> fileFilters = pDStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(fileFilters, pDStream.getFilters());
  }

  /**
   * Test {@link PDICCBased#create(COSArray, PDResources)} with {@code iccArray}, {@code resources}.
   *
   * <ul>
   *   <li>Then calls {@link COSObjectable#getCOSObject()}.
   * </ul>
   *
   * <p>Method under test: {@link PDICCBased#create(COSArray, PDResources)}
   */
  @Test
  @DisplayName(
      "Test create(COSArray, PDResources) with 'iccArray', 'resources'; then calls getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDICCBased PDICCBased.create(COSArray, PDResources)"})
  void testCreateWithIccArrayResources_thenCallsGetCOSObject() throws IOException {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    ArrayList<COSObjectable> cosObjectables = new ArrayList<>();
    cosObjectables.add(cosObjectable);

    COSArray iccArray = new COSArray(cosObjectables);
    iccArray.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(IOException.class, () -> PDICCBased.create(iccArray, new PDResources()));
    verify(cosObjectable).getCOSObject();
  }

  /**
   * Test {@link PDICCBased#create(COSArray, PDResources)} with {@code iccArray}, {@code resources}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDICCBased#create(COSArray, PDResources)}
   */
  @Test
  @DisplayName("Test create(COSArray, PDResources) with 'iccArray', 'resources'; when COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDICCBased PDICCBased.create(COSArray, PDResources)"})
  void testCreateWithIccArrayResources_whenCOSArray() throws IOException {
    // Arrange
    COSArray iccArray = new COSArray();

    // Act and Assert
    assertThrows(IOException.class, () -> PDICCBased.create(iccArray, new PDResources()));
  }

  /**
   * Test {@link PDICCBased#getName()}.
   *
   * <ul>
   *   <li>Given {@link PDICCBased#PDICCBased(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()}.
   *   <li>Then return {@code ICCBased}.
   * </ul>
   *
   * <p>Method under test: {@link PDICCBased#getName()}
   */
  @Test
  @DisplayName(
      "Test getName(); given PDICCBased(PDDocument) with doc is PDDocument(); then return 'ICCBased'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDICCBased.getName()"})
  void testGetName_givenPDICCBasedWithDocIsPDDocument_thenReturnICCBased() {
    // Arrange, Act and Assert
    assertEquals("ICCBased", new PDICCBased(new PDDocument()).getName());
  }

  /**
   * Test {@link PDICCBased#getNumberOfComponents()}.
   *
   * <ul>
   *   <li>Given {@link PDICCBased#PDICCBased(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDICCBased#getNumberOfComponents()}
   */
  @Test
  @DisplayName(
      "Test getNumberOfComponents(); given PDICCBased(PDDocument) with doc is PDDocument(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDICCBased.getNumberOfComponents()"})
  void testGetNumberOfComponents_givenPDICCBasedWithDocIsPDDocument_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDICCBased(new PDDocument()).getNumberOfComponents());
  }

  /**
   * Test {@link PDICCBased#getAlternateColorSpace()}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDICCBased#getAlternateColorSpace()}
   */
  @Test
  @DisplayName("Test getAlternateColorSpace(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace PDICCBased.getAlternateColorSpace()"
  })
  void testGetAlternateColorSpace_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class, () -> new PDICCBased(new PDDocument()).getAlternateColorSpace());
  }

  /**
   * Test {@link PDICCBased#getMetadata()}.
   *
   * <ul>
   *   <li>Given {@link PDICCBased#PDICCBased(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDICCBased#getMetadata()}
   */
  @Test
  @DisplayName(
      "Test getMetadata(); given PDICCBased(PDDocument) with doc is PDDocument(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream PDICCBased.getMetadata()"})
  void testGetMetadata_givenPDICCBasedWithDocIsPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDICCBased(new PDDocument()).getMetadata());
  }

  /**
   * Test {@link PDICCBased#setRangeForComponent(PDRange, int)}.
   *
   * <p>Method under test: {@link PDICCBased#setRangeForComponent(PDRange, int)}
   */
  @Test
  @DisplayName("Test setRangeForComponent(PDRange, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDICCBased.setRangeForComponent(PDRange, int)"})
  void testSetRangeForComponent() {
    // Arrange
    PDICCBased pdiccBased = new PDICCBased(new PDDocument());

    // Act
    pdiccBased.setRangeForComponent(new PDRange(), 1);

    // Assert
    COSStream cOSObject = pdiccBased.getPDStream().getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDICCBased#setMetadata(COSStream)}.
   *
   * <p>Method under test: {@link PDICCBased#setMetadata(COSStream)}
   */
  @Test
  @DisplayName("Test setMetadata(COSStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDICCBased.setMetadata(COSStream)"})
  void testSetMetadata() {
    // Arrange
    PDICCBased pdiccBased = new PDICCBased(new PDDocument());

    // Act
    pdiccBased.setMetadata(null);

    // Assert that nothing has changed
    COSStream cOSObject = pdiccBased.getPDStream().getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDICCBased#setMetadata(COSStream)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDICCBased#setMetadata(COSStream)}
   */
  @Test
  @DisplayName(
      "Test setMetadata(COSStream); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDICCBased.setMetadata(COSStream)"})
  void testSetMetadata_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    PDICCBased pdiccBased = new PDICCBased(new PDDocument());

    COSStream metadata = new COSStream();
    metadata.setKey(new COSObjectKey(1L, 1));

    // Act
    pdiccBased.setMetadata(metadata);

    // Assert
    PDStream pDStream = pdiccBased.getPDStream();
    PDMetadata metadata2 = pDStream.getMetadata();
    assertNull(metadata2.getDecodeParms());
    assertNull(metadata2.getFileDecodeParams());
    assertNull(metadata2.getMetadata());
    assertNull(metadata2.getFile());
    assertEquals(-1, metadata2.getDecodedStreamLength());
    assertEquals(0, metadata2.getLength());
    COSStream cOSObject = pDStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(metadata, metadata2.getCOSObject());
    assertSame(metadata, pdiccBased.getMetadata());
  }

  /**
   * Test {@link PDICCBased#setMetadata(COSStream)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSStream#COSStream()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDICCBased#setMetadata(COSStream)}
   */
  @Test
  @DisplayName("Test setMetadata(COSStream); given 'true'; when COSStream() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDICCBased.setMetadata(COSStream)"})
  void testSetMetadata_givenTrue_whenCOSStreamDirectIsTrue() throws IOException {
    // Arrange
    PDICCBased pdiccBased = new PDICCBased(new PDDocument());

    COSStream metadata = new COSStream();
    metadata.setDirect(true);

    // Act
    pdiccBased.setMetadata(metadata);

    // Assert
    PDStream pDStream = pdiccBased.getPDStream();
    PDMetadata metadata2 = pDStream.getMetadata();
    assertNull(metadata2.getDecodeParms());
    assertNull(metadata2.getFileDecodeParams());
    assertNull(metadata2.getMetadata());
    assertNull(metadata2.getFile());
    assertEquals(-1, metadata2.getDecodedStreamLength());
    assertEquals(0, metadata2.getLength());
    COSStream cOSObject = pDStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(metadata, metadata2.getCOSObject());
    assertSame(metadata, pdiccBased.getMetadata());
  }

  /**
   * Test {@link PDICCBased#setMetadata(COSStream)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDICCBased#setMetadata(COSStream)}
   */
  @Test
  @DisplayName("Test setMetadata(COSStream); when COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDICCBased.setMetadata(COSStream)"})
  void testSetMetadata_whenCOSStream() throws IOException {
    // Arrange
    PDICCBased pdiccBased = new PDICCBased(new PDDocument());
    COSStream metadata = new COSStream();

    // Act
    pdiccBased.setMetadata(metadata);

    // Assert
    PDStream pDStream = pdiccBased.getPDStream();
    PDMetadata metadata2 = pDStream.getMetadata();
    assertNull(metadata2.getDecodeParms());
    assertNull(metadata2.getFileDecodeParams());
    assertNull(metadata2.getMetadata());
    assertNull(metadata2.getFile());
    assertEquals(-1, metadata2.getDecodedStreamLength());
    assertEquals(0, metadata2.getLength());
    COSStream cOSObject = pDStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(metadata, metadata2.getCOSObject());
    assertSame(metadata, pdiccBased.getMetadata());
  }
}

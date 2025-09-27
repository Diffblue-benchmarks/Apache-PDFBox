package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.filter.DecodeOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class COSStreamDiffblueTest {
  /**
   * Test {@link COSStream#COSStream()}.
   *
   * <p>Method under test: {@link COSStream#COSStream()}
   */
  @Test
  @DisplayName("Test new COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSStream.<init>()"})
  void testNewCOSStream() {
    // Arrange and Act
    COSStream actualCosStream = new COSStream();

    // Assert
    assertNull(actualCosStream.getFilters());
    COSUpdateState updateState = actualCosStream.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCosStream.getKey());
    assertEquals(0L, actualCosStream.getLength());
    assertEquals(1, actualCosStream.getValues().size());
    assertEquals(1, actualCosStream.items.size());
    assertEquals(1, actualCosStream.size());
    COSIncrement toIncrementResult = actualCosStream.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCosStream.isDirect());
    assertFalse(actualCosStream.hasData());
    assertFalse(actualCosStream.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link COSStream#createRawInputStream()}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link COSStream#createRawInputStream()}
   */
  @Test
  @DisplayName("Test createRawInputStream(); given COSStream(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream COSStream.createRawInputStream()"})
  void testCreateRawInputStream_givenCOSStream_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new COSStream().createRawInputStream());
  }

  /**
   * Test {@link COSStream#createInputStream(DecodeOptions)} with {@code DecodeOptions}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link COSStream#createInputStream(DecodeOptions)}
   */
  @Test
  @DisplayName(
      "Test createInputStream(DecodeOptions) with 'DecodeOptions'; given COSStream(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.cos.COSInputStream COSStream.createInputStream(DecodeOptions)"
  })
  void testCreateInputStreamWithDecodeOptions_givenCOSStream_thenThrowIOException()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new COSStream().createInputStream(DecodeOptions.DEFAULT));
  }

  /**
   * Test {@link COSStream#createInputStream()}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link COSStream#createInputStream()}
   */
  @Test
  @DisplayName("Test createInputStream(); given COSStream(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSInputStream COSStream.createInputStream()"})
  void testCreateInputStream_givenCOSStream_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new COSStream().createInputStream());
  }

  /**
   * Test {@link COSStream#createView()}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link COSStream#createView()}
   */
  @Test
  @DisplayName("Test createView(); given COSStream(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.io.RandomAccessRead COSStream.createView()"})
  void testCreateView_givenCOSStream_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new COSStream().createView());
  }

  /**
   * Test {@link COSStream#createOutputStream()}.
   *
   * <p>Method under test: {@link COSStream#createOutputStream()}
   */
  @Test
  @DisplayName("Test createOutputStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.OutputStream COSStream.createOutputStream()"})
  void testCreateOutputStream() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();

    // Act
    cosStream.createOutputStream();

    // Assert
    assertTrue(cosStream.hasData());
  }

  /**
   * Test {@link COSStream#createOutputStream(COSBase)} with {@code COSBase}.
   *
   * <p>Method under test: {@link COSStream#createOutputStream(COSBase)}
   */
  @Test
  @DisplayName("Test createOutputStream(COSBase) with 'COSBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.OutputStream COSStream.createOutputStream(COSBase)"})
  void testCreateOutputStreamWithCOSBase() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();
    COSObject filters = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    cosStream.createOutputStream(filters);

    // Assert
    assertEquals(2, cosStream.getValues().size());
    assertEquals(2, cosStream.items.size());
    assertEquals(2, cosStream.size());
  }

  /**
   * Test {@link COSStream#createOutputStream(COSBase)} with {@code COSBase}.
   *
   * <ul>
   *   <li>Then {@link COSStream#COSStream()} Filters is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSStream#createOutputStream(COSBase)}
   */
  @Test
  @DisplayName(
      "Test createOutputStream(COSBase) with 'COSBase'; then COSStream() Filters is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.OutputStream COSStream.createOutputStream(COSBase)"})
  void testCreateOutputStreamWithCOSBase_thenCOSStreamFiltersIsCOSDictionary() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();
    COSDictionary filters = new COSDictionary();

    // Act
    cosStream.createOutputStream(filters);

    // Assert
    assertEquals(2, cosStream.getValues().size());
    assertEquals(2, cosStream.items.size());
    assertEquals(2, cosStream.size());
    assertSame(filters, cosStream.getFilters());
  }

  /**
   * Test {@link COSStream#createOutputStream(COSBase)} with {@code COSBase}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link COSStream#createOutputStream(COSBase)}
   */
  @Test
  @DisplayName("Test createOutputStream(COSBase) with 'COSBase'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.OutputStream COSStream.createOutputStream(COSBase)"})
  void testCreateOutputStreamWithCOSBase_thenThrowIOException() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();
    COSArray filters = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act and Assert
    assertThrows(IOException.class, () -> cosStream.createOutputStream(filters));
  }

  /**
   * Test {@link COSStream#createOutputStream(COSBase)} with {@code COSBase}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then {@link COSStream#COSStream()} Filters is {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link COSStream#createOutputStream(COSBase)}
   */
  @Test
  @DisplayName(
      "Test createOutputStream(COSBase) with 'COSBase'; when COSArray(); then COSStream() Filters is COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.OutputStream COSStream.createOutputStream(COSBase)"})
  void testCreateOutputStreamWithCOSBase_whenCOSArray_thenCOSStreamFiltersIsCOSArray()
      throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();
    COSArray filters = new COSArray();

    // Act
    cosStream.createOutputStream(filters);

    // Assert
    assertEquals(2, cosStream.getValues().size());
    assertEquals(2, cosStream.items.size());
    assertEquals(2, cosStream.size());
    assertSame(filters, cosStream.getFilters());
  }

  /**
   * Test {@link COSStream#createOutputStream(COSBase)} with {@code COSBase}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSStream#COSStream()} Filters is {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link COSStream#createOutputStream(COSBase)}
   */
  @Test
  @DisplayName(
      "Test createOutputStream(COSBase) with 'COSBase'; when FALSE; then COSStream() Filters is FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.OutputStream COSStream.createOutputStream(COSBase)"})
  void testCreateOutputStreamWithCOSBase_whenFalse_thenCOSStreamFiltersIsFalse()
      throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();

    // Act
    cosStream.createOutputStream(COSBoolean.FALSE);

    // Assert
    assertEquals(2, cosStream.getValues().size());
    assertEquals(2, cosStream.items.size());
    assertEquals(2, cosStream.size());
    assertSame(COSBoolean.FALSE, cosStream.getFilters());
  }

  /**
   * Test {@link COSStream#createOutputStream(COSBase)} with {@code COSBase}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link COSStream#COSStream()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSStream#createOutputStream(COSBase)}
   */
  @Test
  @DisplayName(
      "Test createOutputStream(COSBase) with 'COSBase'; when 'null'; then COSStream() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.OutputStream COSStream.createOutputStream(COSBase)"})
  void testCreateOutputStreamWithCOSBase_whenNull_thenCOSStreamValuesSizeIsOne()
      throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();

    // Act
    cosStream.createOutputStream(null);

    // Assert that nothing has changed
    assertEquals(1, cosStream.getValues().size());
    assertEquals(1, cosStream.items.size());
    assertEquals(1, cosStream.size());
  }

  /**
   * Test {@link COSStream#createRawOutputStream()}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>Then {@link COSStream#COSStream()} hasData.
   * </ul>
   *
   * <p>Method under test: {@link COSStream#createRawOutputStream()}
   */
  @Test
  @DisplayName("Test createRawOutputStream(); given COSStream(); then COSStream() hasData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.OutputStream COSStream.createRawOutputStream()"})
  void testCreateRawOutputStream_givenCOSStream_thenCOSStreamHasData() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();

    // Act
    cosStream.createRawOutputStream();

    // Assert
    assertTrue(cosStream.hasData());
  }

  /**
   * Test {@link COSStream#getLength()}.
   *
   * <p>Method under test: {@link COSStream#getLength()}
   */
  @Test
  @DisplayName("Test getLength()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long COSStream.getLength()"})
  void testGetLength() {
    // Arrange, Act and Assert
    assertEquals(0L, new COSStream().getLength());
  }

  /**
   * Test {@link COSStream#getFilters()}.
   *
   * <p>Method under test: {@link COSStream#getFilters()}
   */
  @Test
  @DisplayName("Test getFilters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSStream.getFilters()"})
  void testGetFilters() {
    // Arrange, Act and Assert
    assertNull(new COSStream().getFilters());
  }

  /**
   * Test {@link COSStream#toTextString()}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link COSStream#toTextString()}
   */
  @Test
  @DisplayName("Test toTextString(); given COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String COSStream.toTextString()"})
  void testToTextString_givenCOSStream() {
    // Arrange, Act and Assert
    assertEquals("", new COSStream().toTextString());
  }

  /**
   * Test {@link COSStream#close()}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>Then not {@link COSStream#COSStream()} hasData.
   * </ul>
   *
   * <p>Method under test: {@link COSStream#close()}
   */
  @Test
  @DisplayName("Test close(); given COSStream(); then not COSStream() hasData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSStream.close()"})
  void testClose_givenCOSStream_thenNotCOSStreamHasData() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();

    // Act
    cosStream.close();

    // Assert that nothing has changed
    assertFalse(cosStream.hasData());
  }

  /**
   * Test {@link COSStream#hasData()}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link COSStream#hasData()}
   */
  @Test
  @DisplayName("Test hasData(); given COSStream(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSStream.hasData()"})
  void testHasData_givenCOSStream_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new COSStream().hasData());
  }
}

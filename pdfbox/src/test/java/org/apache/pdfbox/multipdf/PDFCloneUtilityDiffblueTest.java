package org.apache.pdfbox.multipdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.io.ScratchFile;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFCloneUtilityDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDFCloneUtility#PDFCloneUtility(PDDocument)}
   *   <li>{@link PDFCloneUtility#getDestination()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDFCloneUtility.<init>(PDDocument)",
    "PDDocument PDFCloneUtility.getDestination()"
  })
  void testGettersAndSetters() {
    // Arrange
    PDDocument dest = new PDDocument();

    // Act and Assert
    assertSame(dest, new PDFCloneUtility(dest).getDestination());
  }

  /**
   * Test {@link PDFCloneUtility#cloneForNewDocument(COSBase)}.
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  @DisplayName("Test cloneForNewDocument(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFCloneUtility.cloneForNewDocument(COSBase)"})
  void testCloneForNewDocument() throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237));

    // Act
    COSBase actualCloneForNewDocumentResult = pdfCloneUtility.cloneForNewDocument(cosObject);

    // Assert
    COSBoolean cosBoolean = ((COSBoolean) actualCloneForNewDocumentResult).FALSE;
    assertSame(cosBoolean, cosObject.getObject());
    assertSame(cosBoolean, actualCloneForNewDocumentResult);
  }

  /**
   * Test {@link PDFCloneUtility#cloneForNewDocument(COSBase)}.
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  @DisplayName("Test cloneForNewDocument(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFCloneUtility.cloneForNewDocument(COSBase)"})
  void testCloneForNewDocument2() throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());
    COSObjectKey key = new COSObjectKey(1237L, 1237);
    COSObject cosObject = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));

    // Act
    COSBase actualCloneForNewDocumentResult = pdfCloneUtility.cloneForNewDocument(cosObject);

    // Assert
    assertNull(cosObject.getObject());
    assertNull(actualCloneForNewDocumentResult);
  }

  /**
   * Test {@link PDFCloneUtility#cloneForNewDocument(COSBase)}.
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  @DisplayName("Test cloneForNewDocument(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFCloneUtility.cloneForNewDocument(COSBase)"})
  void testCloneForNewDocument3() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-100L);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(memUsageSetting));
    PDDocument dest = new PDDocument(streamCacheCreateFunction);
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(dest);
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream cosStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1237L, 3L));

    // Act
    COSBase actualCloneForNewDocumentResult = pdfCloneUtility.cloneForNewDocument(cosStream);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualCloneForNewDocumentResult instanceof COSStream);
    assertNull(((COSStream) actualCloneForNewDocumentResult).getFilters());
    assertEquals(1, ((COSStream) actualCloneForNewDocumentResult).getValues().size());
    assertEquals(1, ((COSStream) actualCloneForNewDocumentResult).size());
    assertEquals(3L, ((COSStream) actualCloneForNewDocumentResult).getLength());
    assertTrue(((COSStream) actualCloneForNewDocumentResult).hasData());
  }

  /**
   * Test {@link PDFCloneUtility#cloneForNewDocument(COSBase)}.
   *
   * <ul>
   *   <li>Then return Length is minus one hundred.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  @DisplayName("Test cloneForNewDocument(COSBase); then return Length is minus one hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFCloneUtility.cloneForNewDocument(COSBase)"})
  void testCloneForNewDocument_thenReturnLengthIsMinusOneHundred() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument dest = new PDDocument(streamCacheCreateFunction);
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(dest);
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream cosStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1237L, -100L));

    // Act
    COSBase actualCloneForNewDocumentResult = pdfCloneUtility.cloneForNewDocument(cosStream);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualCloneForNewDocumentResult instanceof COSStream);
    assertNull(((COSStream) actualCloneForNewDocumentResult).getFilters());
    assertEquals(-100L, ((COSStream) actualCloneForNewDocumentResult).getLength());
    assertEquals(1, ((COSStream) actualCloneForNewDocumentResult).getValues().size());
    assertEquals(1, ((COSStream) actualCloneForNewDocumentResult).size());
    assertTrue(((COSStream) actualCloneForNewDocumentResult).hasData());
  }

  /**
   * Test {@link PDFCloneUtility#cloneForNewDocument(COSBase)}.
   *
   * <ul>
   *   <li>Then return Length is three.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  @DisplayName("Test cloneForNewDocument(COSBase); then return Length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFCloneUtility.cloneForNewDocument(COSBase)"})
  void testCloneForNewDocument_thenReturnLengthIsThree() throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream cosStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1237L, 3L));

    // Act
    COSBase actualCloneForNewDocumentResult = pdfCloneUtility.cloneForNewDocument(cosStream);

    // Assert
    assertTrue(actualCloneForNewDocumentResult instanceof COSStream);
    assertNull(((COSStream) actualCloneForNewDocumentResult).getFilters());
    assertEquals(1, ((COSStream) actualCloneForNewDocumentResult).getValues().size());
    assertEquals(1, ((COSStream) actualCloneForNewDocumentResult).size());
    assertEquals(3L, ((COSStream) actualCloneForNewDocumentResult).getLength());
    assertTrue(((COSStream) actualCloneForNewDocumentResult).hasData());
  }

  /**
   * Test {@link PDFCloneUtility#cloneForNewDocument(COSBase)}.
   *
   * <ul>
   *   <li>Then return Length is three.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  @DisplayName("Test cloneForNewDocument(COSBase); then return Length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFCloneUtility.cloneForNewDocument(COSBase)"})
  void testCloneForNewDocument_thenReturnLengthIsThree2() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument dest = new PDDocument(streamCacheCreateFunction);
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(dest);
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream cosStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1237L, 3L));

    // Act
    COSBase actualCloneForNewDocumentResult = pdfCloneUtility.cloneForNewDocument(cosStream);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualCloneForNewDocumentResult instanceof COSStream);
    assertNull(((COSStream) actualCloneForNewDocumentResult).getFilters());
    assertEquals(1, ((COSStream) actualCloneForNewDocumentResult).getValues().size());
    assertEquals(1, ((COSStream) actualCloneForNewDocumentResult).size());
    assertEquals(3L, ((COSStream) actualCloneForNewDocumentResult).getLength());
    assertTrue(((COSStream) actualCloneForNewDocumentResult).hasData());
  }

  /**
   * Test {@link PDFCloneUtility#cloneForNewDocument(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   *   <li>Then return {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  @DisplayName("Test cloneForNewDocument(COSBase); when A; then return A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFCloneUtility.cloneForNewDocument(COSBase)"})
  void testCloneForNewDocument_whenA_thenReturnA() throws IOException {
    // Arrange and Act
    COSBase actualCloneForNewDocumentResult =
        new PDFCloneUtility(new PDDocument()).cloneForNewDocument(COSName.A);

    // Assert
    assertSame(((COSName) actualCloneForNewDocumentResult).A, actualCloneForNewDocumentResult);
  }

  /**
   * Test {@link PDFCloneUtility#cloneForNewDocument(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then return toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  @DisplayName("Test cloneForNewDocument(COSBase); when COSArray(); then return toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFCloneUtility.cloneForNewDocument(COSBase)"})
  void testCloneForNewDocument_whenCOSArray_thenReturnToListEmpty() throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());

    // Act
    COSBase actualCloneForNewDocumentResult = pdfCloneUtility.cloneForNewDocument(new COSArray());

    // Assert
    assertTrue(actualCloneForNewDocumentResult instanceof COSArray);
    assertTrue(((COSArray) actualCloneForNewDocumentResult).toList().isEmpty());
  }

  /**
   * Test {@link PDFCloneUtility#cloneForNewDocument(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return {@link COSDictionary}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  @DisplayName("Test cloneForNewDocument(COSBase); when COSDictionary(); then return COSDictionary")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFCloneUtility.cloneForNewDocument(COSBase)"})
  void testCloneForNewDocument_whenCOSDictionary_thenReturnCOSDictionary() throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());

    // Act
    COSBase actualCloneForNewDocumentResult =
        pdfCloneUtility.cloneForNewDocument(new COSDictionary());

    // Assert
    assertTrue(actualCloneForNewDocumentResult instanceof COSDictionary);
    COSUpdateState updateState = ((COSDictionary) actualCloneForNewDocumentResult).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertEquals(0, ((COSDictionary) actualCloneForNewDocumentResult).size());
    COSIncrement toIncrementResult =
        ((COSDictionary) actualCloneForNewDocumentResult).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(((COSDictionary) actualCloneForNewDocumentResult).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(((COSDictionary) actualCloneForNewDocumentResult).getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDFCloneUtility#cloneForNewDocument(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then return {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  @DisplayName("Test cloneForNewDocument(COSBase); when FALSE; then return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFCloneUtility.cloneForNewDocument(COSBase)"})
  void testCloneForNewDocument_whenFalse_thenReturnFalse() throws IOException {
    // Arrange and Act
    COSBase actualCloneForNewDocumentResult =
        new PDFCloneUtility(new PDDocument()).cloneForNewDocument(COSBoolean.FALSE);

    // Assert
    assertSame(
        ((COSBoolean) actualCloneForNewDocumentResult).FALSE, actualCloneForNewDocumentResult);
  }

  /**
   * Test {@link PDFCloneUtility#cloneForNewDocument(COSBase)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  @DisplayName("Test cloneForNewDocument(COSBase); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFCloneUtility.cloneForNewDocument(COSBase)"})
  void testCloneForNewDocument_whenNull_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDFCloneUtility(new PDDocument()).cloneForNewDocument(null));
  }

  /**
   * Test {@link PDFCloneUtility#cloneForNewDocument(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSInteger#ONE}.
   *   <li>Then return {@link COSInteger}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  @DisplayName("Test cloneForNewDocument(COSBase); when ONE; then return COSInteger")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFCloneUtility.cloneForNewDocument(COSBase)"})
  void testCloneForNewDocument_whenOne_thenReturnCOSInteger() throws IOException {
    // Arrange and Act
    COSBase actualCloneForNewDocumentResult =
        new PDFCloneUtility(new PDDocument()).cloneForNewDocument(COSInteger.ONE);

    // Assert
    assertTrue(actualCloneForNewDocumentResult instanceof COSInteger);
    assertTrue(((COSInteger) actualCloneForNewDocumentResult).isValid());
    assertSame(((COSInteger) actualCloneForNewDocumentResult).ONE, actualCloneForNewDocumentResult);
  }

  /**
   * Test {@link PDFCloneUtility#cloneForNewDocument(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSFloat#ONE}.
   *   <li>Then return {@link COSFloat#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  @DisplayName("Test cloneForNewDocument(COSBase); when ONE; then return ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFCloneUtility.cloneForNewDocument(COSBase)"})
  void testCloneForNewDocument_whenOne_thenReturnOne() throws IOException {
    // Arrange and Act
    COSBase actualCloneForNewDocumentResult =
        new PDFCloneUtility(new PDDocument()).cloneForNewDocument(COSFloat.ONE);

    // Assert
    assertSame(((COSFloat) actualCloneForNewDocumentResult).ONE, actualCloneForNewDocumentResult);
  }

  /**
   * Test {@link PDFCloneUtility#cloneForNewDocument(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#TRUE}.
   *   <li>Then return {@link COSBoolean#TRUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  @DisplayName("Test cloneForNewDocument(COSBase); when TRUE; then return TRUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFCloneUtility.cloneForNewDocument(COSBase)"})
  void testCloneForNewDocument_whenTrue_thenReturnTrue() throws IOException {
    // Arrange and Act
    COSBase actualCloneForNewDocumentResult =
        new PDFCloneUtility(new PDDocument()).cloneForNewDocument(COSBoolean.TRUE);

    // Assert
    assertSame(
        ((COSBoolean) actualCloneForNewDocumentResult).TRUE, actualCloneForNewDocumentResult);
  }

  /**
   * Test {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}
   */
  @Test
  @DisplayName("Test cloneMerge(COSObjectable, COSObjectable); given 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFCloneUtility.cloneMerge(COSObjectable, COSObjectable)"})
  void testCloneMerge_givenA() throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());

    COSObjectable base = mock(COSObjectable.class);
    COSObjectKey key = new COSObjectKey(1L, 1);
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser parser = new COSParser(source);

    COSObject cosObject = new COSObject(key, parser);
    when(base.getCOSObject()).thenReturn(cosObject);

    COSObjectable target = mock(COSObjectable.class);
    when(target.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdfCloneUtility.cloneMerge(base, target);

    // Assert
    verify(base).getCOSObject();
    verify(target).getCOSObject();
  }

  /**
   * Test {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>When {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test cloneMerge(COSObjectable, COSObjectable); given COSArray() add FALSE; when COSObjectable getCOSObject() return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFCloneUtility.cloneMerge(COSObjectable, COSObjectable)"})
  void testCloneMerge_givenCOSArrayAddFalse_whenCOSObjectableGetCOSObjectReturnCOSArray()
      throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    COSObjectable base = mock(COSObjectable.class);
    when(base.getCOSObject()).thenReturn(cosArray);

    COSObjectable target = mock(COSObjectable.class);
    when(target.getCOSObject()).thenReturn(new COSArray());

    // Act
    pdfCloneUtility.cloneMerge(base, target);

    // Assert
    verify(base).getCOSObject();
    verify(target).getCOSObject();
  }

  /**
   * Test {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test cloneMerge(COSObjectable, COSObjectable); given COSArray(); when COSObjectable getCOSObject() return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFCloneUtility.cloneMerge(COSObjectable, COSObjectable)"})
  void testCloneMerge_givenCOSArray_whenCOSObjectableGetCOSObjectReturnCOSArray()
      throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());

    COSObjectable base = mock(COSObjectable.class);
    when(base.getCOSObject()).thenReturn(new COSArray());

    COSObjectable target = mock(COSObjectable.class);
    when(target.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdfCloneUtility.cloneMerge(base, target);

    // Assert
    verify(base).getCOSObject();
    verify(target).getCOSObject();
  }

  /**
   * Test {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test cloneMerge(COSObjectable, COSObjectable); given COSArray(); when COSObjectable getCOSObject() return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFCloneUtility.cloneMerge(COSObjectable, COSObjectable)"})
  void testCloneMerge_givenCOSArray_whenCOSObjectableGetCOSObjectReturnCOSArray2()
      throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());

    COSObjectable base = mock(COSObjectable.class);
    when(base.getCOSObject()).thenReturn(new COSArray());

    COSObjectable target = mock(COSObjectable.class);
    when(target.getCOSObject()).thenReturn(new COSArray());

    // Act
    pdfCloneUtility.cloneMerge(base, target);

    // Assert
    verify(base).getCOSObject();
    verify(target).getCOSObject();
  }

  /**
   * Test {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}
   */
  @Test
  @DisplayName("Test cloneMerge(COSObjectable, COSObjectable); given COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFCloneUtility.cloneMerge(COSObjectable, COSObjectable)"})
  void testCloneMerge_givenCOSDictionary() throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());

    COSObjectable base = mock(COSObjectable.class);
    when(base.getCOSObject()).thenReturn(new COSDictionary());

    COSObjectable target = mock(COSObjectable.class);
    when(target.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdfCloneUtility.cloneMerge(base, target);

    // Assert
    verify(base).getCOSObject();
    verify(target).getCOSObject();
  }

  /**
   * Test {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}.
   *
   * <ul>
   *   <li>Given {@link COSObject#COSObject(COSObjectKey, ICOSParser)} with key is {@link
   *       COSObjectKey#COSObjectKey(long, int)} and parser is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test cloneMerge(COSObjectable, COSObjectable); given COSObject(COSObjectKey, ICOSParser) with key is COSObjectKey(long, int) and parser is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFCloneUtility.cloneMerge(COSObjectable, COSObjectable)"})
  void testCloneMerge_givenCOSObjectWithKeyIsCOSObjectKeyAndParserIsNull() throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());

    COSObjectable base = mock(COSObjectable.class);
    COSObject cosObject = new COSObject(new COSObjectKey(1L, 1), null);
    when(base.getCOSObject()).thenReturn(cosObject);

    COSObjectable target = mock(COSObjectable.class);
    when(target.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdfCloneUtility.cloneMerge(base, target);

    // Assert
    verify(base).getCOSObject();
    verify(target).getCOSObject();
  }

  /**
   * Test {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}.
   *
   * <ul>
   *   <li>Given {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link
   *       COSBoolean#FALSE} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test cloneMerge(COSObjectable, COSObjectable); given COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFCloneUtility.cloneMerge(COSObjectable, COSObjectable)"})
  void testCloneMerge_givenCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey()
      throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());

    COSObjectable base = mock(COSObjectable.class);
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    when(base.getCOSObject()).thenReturn(cosObject);

    COSObjectable target = mock(COSObjectable.class);
    when(target.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdfCloneUtility.cloneMerge(base, target);

    // Assert
    verify(base).getCOSObject();
    verify(target).getCOSObject();
  }

  /**
   * Test {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}.
   *
   * <ul>
   *   <li>Given {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link
   *       COSBoolean#FALSE} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test cloneMerge(COSObjectable, COSObjectable); given COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFCloneUtility.cloneMerge(COSObjectable, COSObjectable)"})
  void testCloneMerge_givenCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey2()
      throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());

    COSObjectable base = mock(COSObjectable.class);
    when(base.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSObjectable target = mock(COSObjectable.class);
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    when(target.getCOSObject()).thenReturn(cosObject);

    // Act
    pdfCloneUtility.cloneMerge(base, target);

    // Assert
    verify(base).getCOSObject();
    verify(target).getCOSObject();
  }

  /**
   * Test {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test cloneMerge(COSObjectable, COSObjectable); given COSObjectable getCOSObject() return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFCloneUtility.cloneMerge(COSObjectable, COSObjectable)"})
  void testCloneMerge_givenCOSObjectableGetCOSObjectReturnFalse() throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());

    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(object);

    COSObjectable base = mock(COSObjectable.class);
    when(base.getCOSObject()).thenReturn(cosArray);

    COSObjectable target = mock(COSObjectable.class);
    when(target.getCOSObject()).thenReturn(new COSArray());

    // Act
    pdfCloneUtility.cloneMerge(base, target);

    // Assert
    verify(base).getCOSObject();
    verify(object).getCOSObject();
    verify(target).getCOSObject();
  }

  /**
   * Test {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}.
   *
   * <ul>
   *   <li>Given {@link COSParser#COSParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test cloneMerge(COSObjectable, COSObjectable); given COSParser(RandomAccessRead) with source is RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFCloneUtility.cloneMerge(COSObjectable, COSObjectable)"})
  void testCloneMerge_givenCOSParserWithSourceIsRandomAccessReadWriteBuffer() throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());

    COSObjectable base = mock(COSObjectable.class);
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject cosObject = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
    when(base.getCOSObject()).thenReturn(cosObject);

    COSObjectable target = mock(COSObjectable.class);
    when(target.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdfCloneUtility.cloneMerge(base, target);

    // Assert
    verify(base).getCOSObject();
    verify(target).getCOSObject();
  }

  /**
   * Test {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test cloneMerge(COSObjectable, COSObjectable); given FALSE; when COSObjectable getCOSObject() return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFCloneUtility.cloneMerge(COSObjectable, COSObjectable)"})
  void testCloneMerge_givenFalse_whenCOSObjectableGetCOSObjectReturnFalse() throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());

    COSObjectable base = mock(COSObjectable.class);
    when(base.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSObjectable target = mock(COSObjectable.class);
    when(target.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdfCloneUtility.cloneMerge(base, target);

    // Assert
    verify(base).getCOSObject();
    verify(target).getCOSObject();
  }
}

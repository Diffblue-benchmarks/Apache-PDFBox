package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDPropertyList;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDAnnotationDiffblueTest {
  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   * <ul>
   *   <li>Given {@link COSName#A}.</li>
   *   <li>When {@link COSArray#COSArray()} add {@link COSName#A}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); given A; when COSArray() add A; then throw IOException")
  void testCreateAnnotation_givenA_whenCOSArrayAddA_thenThrowIOException() throws IOException {
    // Arrange
    COSArray base = new COSArray();
    base.add(COSName.A);

    // Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(base));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   * <ul>
   *   <li>Given {@link COSName#A}.</li>
   *   <li>When {@link COSArray#COSArray()} add {@link COSName#A}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); given A; when COSArray() add A; then throw IOException")
  void testCreateAnnotation_givenA_whenCOSArrayAddA_thenThrowIOException2() throws IOException {
    // Arrange
    COSArray base = new COSArray();
    base.add(COSBoolean.FALSE);
    base.add(COSName.A);

    // Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(base));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.</li>
   *   <li>When {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); given COSArray(); when COSArray() add COSArray(); then throw IOException")
  void testCreateAnnotation_givenCOSArray_whenCOSArrayAddCOSArray_thenThrowIOException() throws IOException {
    // Arrange
    COSArray base = new COSArray();
    base.add((COSBase) new COSArray());

    // Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(base));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.</li>
   *   <li>When {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); given COSArray(); when COSArray() add COSArray(); then throw IOException")
  void testCreateAnnotation_givenCOSArray_whenCOSArrayAddCOSArray_thenThrowIOException2() throws IOException {
    // Arrange
    COSArray base = new COSArray();
    base.add(COSBoolean.FALSE);
    base.add((COSBase) new COSArray());

    // Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(base));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@link COSArray#COSArray()} add
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); given COSDictionary(); when COSArray() add COSDictionary()")
  void testCreateAnnotation_givenCOSDictionary_whenCOSArrayAddCOSDictionary() throws IOException {
    // Arrange
    COSArray base = new COSArray();
    base.add((COSBase) new COSDictionary());

    // Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(base));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@link COSArray#COSArray()} add
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); given COSDictionary(); when COSArray() add COSDictionary()")
  void testCreateAnnotation_givenCOSDictionary_whenCOSArrayAddCOSDictionary2() throws IOException {
    // Arrange
    COSArray base = new COSArray();
    base.add(COSBoolean.FALSE);
    base.add((COSBase) new COSDictionary());

    // Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(base));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); given COSObjectKey(long, int) with num is one and gen is one")
  void testCreateAnnotation_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    COSArray base = new COSArray();
    base.add((COSBase) new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(base));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@link COSArray#COSArray()} add {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); given COSStream(); when COSArray() add COSStream()")
  void testCreateAnnotation_givenCOSStream_whenCOSArrayAddCOSStream() throws IOException {
    // Arrange
    COSArray base = new COSArray();
    base.add((COSBase) new COSStream());

    // Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(base));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); given FALSE; when COSArray() add FALSE; then throw IOException")
  void testCreateAnnotation_givenFalse_whenCOSArrayAddFalse_thenThrowIOException() throws IOException {
    // Arrange
    COSArray base = new COSArray();
    base.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(base));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); given FALSE; when COSArray() add FALSE; then throw IOException")
  void testCreateAnnotation_givenFalse_whenCOSArrayAddFalse_thenThrowIOException2() throws IOException {
    // Arrange
    COSArray base = new COSArray();
    base.add(COSBoolean.FALSE);
    base.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(base));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.</li>
   *   <li>When {@link COSArray#COSArray()} add {@link COSInteger#ONE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); given ONE; when COSArray() add ONE; then throw IOException")
  void testCreateAnnotation_givenOne_whenCOSArrayAddOne_thenThrowIOException() throws IOException {
    // Arrange
    COSArray base = new COSArray();
    base.add(COSInteger.ONE);

    // Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(base));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.</li>
   *   <li>When {@link COSArray#COSArray()} add {@link COSInteger#ONE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); given ONE; when COSArray() add ONE; then throw IOException")
  void testCreateAnnotation_givenOne_whenCOSArrayAddOne_thenThrowIOException2() throws IOException {
    // Arrange
    COSArray base = new COSArray();
    base.add(COSBoolean.FALSE);
    base.add(COSInteger.ONE);

    // Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(base));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   * <ul>
   *   <li>When {@link COSName#A}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); when A; then throw IOException")
  void testCreateAnnotation_whenA_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(COSName.A));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); when COSArray(); then throw IOException")
  void testCreateAnnotation_whenCOSArray_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(new COSArray()));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); when COSDictionary(); then COSDictionary() size is one")
  void testCreateAnnotation_whenCOSDictionary_thenCOSDictionarySizeIsOne() throws IOException {
    // Arrange
    COSDictionary base = new COSDictionary();

    // Act
    PDAnnotation actualCreateAnnotationResult = PDAnnotation.createAnnotation(base);

    // Assert
    assertTrue(actualCreateAnnotationResult instanceof PDAnnotationUnknown);
    assertEquals(1, base.size());
    List<? extends COSBase> toListResult = actualCreateAnnotationResult.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(base, actualCreateAnnotationResult.getCOSObject());
    assertSame(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); when COSObjectKey(long, int) with num is one and gen is one")
  void testCreateAnnotation_whenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> PDAnnotation.createAnnotation(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1))));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then {@link COSStream#COSStream()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); when COSStream(); then COSStream() size is two")
  void testCreateAnnotation_whenCOSStream_thenCOSStreamSizeIsTwo() throws IOException {
    // Arrange
    COSStream base = new COSStream();

    // Act
    PDAnnotation actualCreateAnnotationResult = PDAnnotation.createAnnotation(base);

    // Assert
    assertTrue(actualCreateAnnotationResult instanceof PDAnnotationUnknown);
    assertEquals(2, base.size());
    List<? extends COSBase> toListResult = actualCreateAnnotationResult.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(base, actualCreateAnnotationResult.getCOSObject());
    assertSame(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); when FALSE; then throw IOException")
  void testCreateAnnotation_whenFalse_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(COSBoolean.FALSE));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   * <ul>
   *   <li>When {@link COSFloat#ONE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); when ONE; then throw IOException")
  void testCreateAnnotation_whenOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(COSFloat.ONE));
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(COSInteger.ONE));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   * <ul>
   *   <li>When parseHex {@code 42}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); when parseHex '42'; then throw IOException")
  void testCreateAnnotation_whenParseHex42_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(COSString.parseHex("42")));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   * <ul>
   *   <li>When parseHex {@code 0123456789ABCDEF}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); when parseHex '0123456789ABCDEF'; then throw IOException")
  void testCreateAnnotation_whenParseHex0123456789abcdef_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(COSString.parseHex("0123456789ABCDEF")));
  }

  /**
   * Test {@link PDAnnotation#equals(Object)}, and
   * {@link PDAnnotation#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDAnnotation#equals(Object)}
   *   <li>{@link PDAnnotation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act and Assert
    assertEquals(pdAnnotationCaret, pdAnnotationCaret);
    int expectedHashCodeResult = pdAnnotationCaret.hashCode();
    assertEquals(expectedHashCodeResult, pdAnnotationCaret.hashCode());
  }

  /**
   * Test {@link PDAnnotation#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act and Assert
    assertNotEquals(pdAnnotationCaret, new PDAnnotationCaret());
  }

  /**
   * Test {@link PDAnnotation#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    PDAnnotationCircle pdAnnotationCircle = mock(PDAnnotationCircle.class);
    when(pdAnnotationCircle.getCOSObject()).thenReturn(new COSDictionary());

    // Act and Assert
    assertNotEquals(pdAnnotationCaret, pdAnnotationCircle);
  }

  /**
   * Test {@link PDAnnotation#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PDAnnotationCaret(), null);
  }

  /**
   * Test {@link PDAnnotation#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PDAnnotationCaret(), "Different type to PDAnnotation");
  }

  /**
   * Test {@link PDAnnotation#setSubtype(String)}.
   * <ul>
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} Subtype is
   * {@code Sub Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setSubtype(String)}
   */
  @Test
  @DisplayName("Test setSubtype(String); given PDAnnotationCaret(); then PDAnnotationCaret() Subtype is 'Sub Type'")
  void testSetSubtype_givenPDAnnotationCaret_thenPDAnnotationCaretSubtypeIsSubType() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setSubtype("Sub Type");

    // Assert
    assertEquals("Sub Type", pdAnnotationCaret.getSubtype());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#setSubtype(String)}.
   * <ul>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret(COSDictionary)} with
   * field is {@link COSDictionary#COSDictionary()} Subtype is
   * {@code Sub Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setSubtype(String)}
   */
  @Test
  @DisplayName("Test setSubtype(String); then PDAnnotationCaret(COSDictionary) with field is COSDictionary() Subtype is 'Sub Type'")
  void testSetSubtype_thenPDAnnotationCaretWithFieldIsCOSDictionarySubtypeIsSubType() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret(new COSDictionary());

    // Act
    pdAnnotationCaret.setSubtype("Sub Type");

    // Assert
    assertEquals("Sub Type", pdAnnotationCaret.getSubtype());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#getSubtype()}.
   * <ul>
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret(COSDictionary)} with
   * field is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#getSubtype()}
   */
  @Test
  @DisplayName("Test getSubtype(); given PDAnnotationCaret(COSDictionary) with field is COSDictionary(); then return 'null'")
  void testGetSubtype_givenPDAnnotationCaretWithFieldIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCaret(new COSDictionary())).getSubtype());
  }

  /**
   * Test {@link PDAnnotation#getSubtype()}.
   * <ul>
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   *   <li>Then return {@link PDAnnotationCaret#SUB_TYPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#getSubtype()}
   */
  @Test
  @DisplayName("Test getSubtype(); given PDAnnotationCaret(); then return SUB_TYPE")
  void testGetSubtype_givenPDAnnotationCaret_thenReturnSub_type() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationCaret.SUB_TYPE, (new PDAnnotationCaret()).getSubtype());
  }

  /**
   * Test {@link PDAnnotation#getRectangle()}.
   * <ul>
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle(); given PDAnnotationCaret(); then return 'null'")
  void testGetRectangle_givenPDAnnotationCaret_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCaret()).getRectangle());
  }

  /**
   * Test {@link PDAnnotation#getRectangle()}.
   * <ul>
   *   <li>Then return COSArray toList third Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle(); then return COSArray toList third Key is 'null'")
  void testGetRectangle_thenReturnCOSArrayToListThirdKeyIsNull() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setRectangle(PDRectangle.A0);

    // Act
    PDRectangle actualRectangle = pdAnnotationCaret.getRectangle();

    // Assert
    List<? extends COSBase> toListResult = actualRectangle.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertEquals(0.0f, actualRectangle.getLowerLeftX());
    assertEquals(0.0f, actualRectangle.getLowerLeftY());
    assertEquals(2383.937f, actualRectangle.getUpperRightX());
    assertEquals(2383.937f, actualRectangle.getWidth());
    assertEquals(3370.3938f, actualRectangle.getHeight());
    assertEquals(3370.3938f, actualRectangle.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
  }

  /**
   * Test {@link PDAnnotation#getRectangle()}.
   * <ul>
   *   <li>Then return Height is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle(); then return Height is zero")
  void testGetRectangle_thenReturnHeightIsZero() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualRectangle = pdAnnotationCaret.getRectangle();

    // Assert
    List<? extends COSBase> toListResult = actualRectangle.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(0.0f, actualRectangle.getHeight());
    assertEquals(0.0f, actualRectangle.getWidth());
    assertEquals(2.14748365E9f, actualRectangle.getLowerLeftX());
    assertEquals(2.14748365E9f, actualRectangle.getLowerLeftY());
    assertEquals(2.14748365E9f, actualRectangle.getUpperRightX());
    assertEquals(2.14748365E9f, actualRectangle.getUpperRightY());
    COSBase getResult3 = toListResult.get(0);
    assertEquals(getResult3, getResult);
    assertEquals(getResult3, getResult2);
  }

  /**
   * Test {@link PDAnnotation#setRectangle(PDRectangle)}.
   * <ul>
   *   <li>When {@link PDRectangle#A0}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} Rectangle LowerLeftX
   * is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setRectangle(PDRectangle)}
   */
  @Test
  @DisplayName("Test setRectangle(PDRectangle); when A0; then PDAnnotationCaret() Rectangle LowerLeftX is zero")
  void testSetRectangle_whenA0_thenPDAnnotationCaretRectangleLowerLeftXIsZero() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setRectangle(PDRectangle.A0);

    // Assert
    PDRectangle rectangle = pdAnnotationCaret.getRectangle();
    assertEquals(0.0f, rectangle.getLowerLeftX());
    assertEquals(0.0f, rectangle.getLowerLeftY());
    assertEquals(2383.937f, rectangle.getUpperRightX());
    assertEquals(2383.937f, rectangle.getWidth());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3370.3938f, rectangle.getHeight());
    assertEquals(3370.3938f, rectangle.getUpperRightY());
    COSArray expectedCOSObject = rectangle.getCOSArray();
    assertSame(expectedCOSObject, rectangle.getCOSObject());
  }

  /**
   * Test {@link PDAnnotation#getAnnotationFlags()}.
   * <p>
   * Method under test: {@link PDAnnotation#getAnnotationFlags()}
   */
  @Test
  @DisplayName("Test getAnnotationFlags()")
  void testGetAnnotationFlags() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDAnnotationCaret()).getAnnotationFlags());
  }

  /**
   * Test {@link PDAnnotation#setAnnotationFlags(int)}.
   * <ul>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is
   * {@code -1810807491}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setAnnotationFlags(int)}
   */
  @Test
  @DisplayName("Test setAnnotationFlags(int); then PDAnnotationCaret() AnnotationFlags is '-1810807491'")
  void testSetAnnotationFlags_thenPDAnnotationCaretAnnotationFlagsIs1810807491() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setAnnotationFlags(-1810807491);

    // Assert
    assertEquals(-1810807491, pdAnnotationCaret.getAnnotationFlags());
    assertTrue(pdAnnotationCaret.isNoRotate());
    assertTrue(pdAnnotationCaret.isNoView());
    assertTrue(pdAnnotationCaret.isNoZoom());
    assertTrue(pdAnnotationCaret.isToggleNoView());
  }

  /**
   * Test {@link PDAnnotation#setAnnotationFlags(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setAnnotationFlags(int)}
   */
  @Test
  @DisplayName("Test setAnnotationFlags(int); when one; then PDAnnotationCaret() AnnotationFlags is one")
  void testSetAnnotationFlags_whenOne_thenPDAnnotationCaretAnnotationFlagsIsOne() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setAnnotationFlags(1);

    // Assert
    assertEquals(1, pdAnnotationCaret.getAnnotationFlags());
    assertFalse(pdAnnotationCaret.isHidden());
    assertFalse(pdAnnotationCaret.isNoRotate());
    assertFalse(pdAnnotationCaret.isNoView());
    assertFalse(pdAnnotationCaret.isNoZoom());
    assertFalse(pdAnnotationCaret.isPrinted());
    assertFalse(pdAnnotationCaret.isToggleNoView());
  }

  /**
   * Test {@link PDAnnotation#setAnnotationFlags(int)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is
   * seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setAnnotationFlags(int)}
   */
  @Test
  @DisplayName("Test setAnnotationFlags(int); when seven; then PDAnnotationCaret() AnnotationFlags is seven")
  void testSetAnnotationFlags_whenSeven_thenPDAnnotationCaretAnnotationFlagsIsSeven() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setAnnotationFlags(7);

    // Assert
    assertEquals(7, pdAnnotationCaret.getAnnotationFlags());
    assertFalse(pdAnnotationCaret.isNoRotate());
    assertFalse(pdAnnotationCaret.isNoView());
    assertFalse(pdAnnotationCaret.isNoZoom());
    assertFalse(pdAnnotationCaret.isToggleNoView());
    assertTrue(pdAnnotationCaret.isHidden());
    assertTrue(pdAnnotationCaret.isPrinted());
  }

  /**
   * Test {@link PDAnnotation#getCOSObject()}.
   * <p>
   * Method under test: {@link PDAnnotation#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDAnnotationCaret()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(2, actualCOSObject.getValues().size());
    assertEquals(2, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDAnnotation#getAppearanceState()}.
   * <p>
   * Method under test: {@link PDAnnotation#getAppearanceState()}
   */
  @Test
  @DisplayName("Test getAppearanceState()")
  void testGetAppearanceState() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCaret()).getAppearanceState());
  }

  /**
   * Test {@link PDAnnotation#setAppearanceState(String)}.
   * <p>
   * Method under test: {@link PDAnnotation#setAppearanceState(String)}
   */
  @Test
  @DisplayName("Test setAppearanceState(String)")
  void testSetAppearanceState() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret(new COSDictionary());

    // Act
    pdAnnotationCaret.setAppearanceState("As");

    // Assert
    COSName appearanceState = pdAnnotationCaret.getAppearanceState();
    assertEquals("As", appearanceState.getName());
    assertNull(appearanceState.getKey());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(appearanceState.isDirect());
    assertFalse(appearanceState.isEmpty());
  }

  /**
   * Test {@link PDAnnotation#setAppearanceState(String)}.
   * <ul>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AppearanceState Name
   * is {@code As}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setAppearanceState(String)}
   */
  @Test
  @DisplayName("Test setAppearanceState(String); then PDAnnotationCaret() AppearanceState Name is 'As'")
  void testSetAppearanceState_thenPDAnnotationCaretAppearanceStateNameIsAs() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setAppearanceState("As");

    // Assert
    COSName appearanceState = pdAnnotationCaret.getAppearanceState();
    assertEquals("As", appearanceState.getName());
    assertNull(appearanceState.getKey());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(appearanceState.isDirect());
    assertFalse(appearanceState.isEmpty());
  }

  /**
   * Test {@link PDAnnotation#getAppearance()}.
   * <p>
   * Method under test: {@link PDAnnotation#getAppearance()}
   */
  @Test
  @DisplayName("Test getAppearance()")
  void testGetAppearance() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setAppearance(new PDAppearanceDictionary());

    // Act
    PDAppearanceDictionary actualAppearance = pdAnnotationCaret.getAppearance();

    // Assert
    PDAppearanceEntry downAppearance = actualAppearance.getDownAppearance();
    COSDictionary cOSObject = downAppearance.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = actualAppearance.getCOSObject();
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(downAppearance.isStream());
    PDAppearanceEntry normalAppearance = actualAppearance.getNormalAppearance();
    assertFalse(normalAppearance.isStream());
    PDAppearanceEntry rolloverAppearance = actualAppearance.getRolloverAppearance();
    assertFalse(rolloverAppearance.isStream());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(downAppearance.getSubDictionary().isEmpty());
    assertTrue(normalAppearance.getSubDictionary().isEmpty());
    assertTrue(rolloverAppearance.getSubDictionary().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(downAppearance.isSubDictionary());
    assertTrue(normalAppearance.isSubDictionary());
    assertTrue(rolloverAppearance.isSubDictionary());
    assertSame(cOSObject, normalAppearance.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
  }

  /**
   * Test {@link PDAnnotation#getAppearance()}.
   * <ul>
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#getAppearance()}
   */
  @Test
  @DisplayName("Test getAppearance(); given PDAnnotationCaret(); then return 'null'")
  void testGetAppearance_givenPDAnnotationCaret_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCaret()).getAppearance());
  }

  /**
   * Test {@link PDAnnotation#getAppearance()}.
   * <ul>
   *   <li>Then return DownAppearance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#getAppearance()}
   */
  @Test
  @DisplayName("Test getAppearance(); then return DownAppearance is 'null'")
  void testGetAppearance_thenReturnDownAppearanceIsNull() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));
    PDAppearanceDictionary appearance = new PDAppearanceDictionary(dictionary);

    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setAppearance(appearance);

    // Act
    PDAppearanceDictionary actualAppearance = pdAnnotationCaret.getAppearance();

    // Assert
    assertNull(actualAppearance.getDownAppearance());
    assertNull(actualAppearance.getNormalAppearance());
    assertNull(actualAppearance.getRolloverAppearance());
    assertSame(dictionary, actualAppearance.getCOSObject());
  }

  /**
   * Test {@link PDAnnotation#setAppearance(PDAppearanceDictionary)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setAppearance(PDAppearanceDictionary)}
   */
  @Test
  @DisplayName("Test setAppearance(PDAppearanceDictionary); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetAppearance_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationCaret.setAppearance(new PDAppearanceDictionary(dictionary));

    // Assert
    PDAppearanceDictionary appearance = pdAnnotationCaret.getAppearance();
    assertNull(appearance.getDownAppearance());
    assertNull(appearance.getNormalAppearance());
    assertNull(appearance.getRolloverAppearance());
    assertSame(dictionary, appearance.getCOSObject());
  }

  /**
   * Test {@link PDAnnotation#setAppearance(PDAppearanceDictionary)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setAppearance(PDAppearanceDictionary)}
   */
  @Test
  @DisplayName("Test setAppearance(PDAppearanceDictionary); given 'true'; when COSDictionary() Direct is 'true'")
  void testSetAppearance_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setDirect(true);

    // Act
    pdAnnotationCaret.setAppearance(new PDAppearanceDictionary(dictionary));

    // Assert
    PDAppearanceDictionary appearance = pdAnnotationCaret.getAppearance();
    assertNull(appearance.getDownAppearance());
    assertNull(appearance.getNormalAppearance());
    assertNull(appearance.getRolloverAppearance());
    assertSame(dictionary, appearance.getCOSObject());
  }

  /**
   * Test {@link PDAnnotation#setAppearance(PDAppearanceDictionary)}.
   * <ul>
   *   <li>Then not {@link PDAnnotationCaret#PDAnnotationCaret()} Appearance
   * DownAppearance Stream.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setAppearance(PDAppearanceDictionary)}
   */
  @Test
  @DisplayName("Test setAppearance(PDAppearanceDictionary); then not PDAnnotationCaret() Appearance DownAppearance Stream")
  void testSetAppearance_thenNotPDAnnotationCaretAppearanceDownAppearanceStream() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setAppearance(new PDAppearanceDictionary());

    // Assert
    PDAppearanceDictionary appearance = pdAnnotationCaret.getAppearance();
    PDAppearanceEntry downAppearance = appearance.getDownAppearance();
    assertFalse(downAppearance.isStream());
    PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
    assertFalse(normalAppearance.isStream());
    PDAppearanceEntry rolloverAppearance = appearance.getRolloverAppearance();
    assertFalse(rolloverAppearance.isStream());
    assertTrue(downAppearance.getSubDictionary().isEmpty());
    assertTrue(normalAppearance.getSubDictionary().isEmpty());
    assertTrue(rolloverAppearance.getSubDictionary().isEmpty());
    assertTrue(downAppearance.isSubDictionary());
    assertTrue(normalAppearance.isSubDictionary());
    assertTrue(rolloverAppearance.isSubDictionary());
  }

  /**
   * Test {@link PDAnnotation#getNormalAppearanceStream()}.
   * <p>
   * Method under test: {@link PDAnnotation#getNormalAppearanceStream()}
   */
  @Test
  @DisplayName("Test getNormalAppearanceStream()")
  void testGetNormalAppearanceStream() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setAppearance(new PDAppearanceDictionary());

    // Act and Assert
    assertNull(pdAnnotationCaret.getNormalAppearanceStream());
  }

  /**
   * Test {@link PDAnnotation#getNormalAppearanceStream()}.
   * <p>
   * Method under test: {@link PDAnnotation#getNormalAppearanceStream()}
   */
  @Test
  @DisplayName("Test getNormalAppearanceStream()")
  void testGetNormalAppearanceStream2() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setAppearance(new PDAppearanceDictionary(new COSDictionary()));

    // Act and Assert
    assertNull(pdAnnotationCaret.getNormalAppearanceStream());
  }

  /**
   * Test {@link PDAnnotation#getNormalAppearanceStream()}.
   * <p>
   * Method under test: {@link PDAnnotation#getNormalAppearanceStream()}
   */
  @Test
  @DisplayName("Test getNormalAppearanceStream()")
  void testGetNormalAppearanceStream3() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));
    PDAppearanceDictionary appearance = new PDAppearanceDictionary(dictionary);

    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setAppearance(appearance);

    // Act and Assert
    assertNull(pdAnnotationCaret.getNormalAppearanceStream());
  }

  /**
   * Test {@link PDAnnotation#getNormalAppearanceStream()}.
   * <ul>
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#getNormalAppearanceStream()}
   */
  @Test
  @DisplayName("Test getNormalAppearanceStream(); given PDAnnotationCaret(); then return 'null'")
  void testGetNormalAppearanceStream_givenPDAnnotationCaret_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCaret()).getNormalAppearanceStream());
  }

  /**
   * Test {@link PDAnnotation#getNormalAppearanceStream()}.
   * <ul>
   *   <li>Then return Stream DecodeParms is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#getNormalAppearanceStream()}
   */
  @Test
  @DisplayName("Test getNormalAppearanceStream(); then return Stream DecodeParms is 'null'")
  void testGetNormalAppearanceStream_thenReturnStreamDecodeParmsIsNull() throws IOException {
    // Arrange
    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    COSStream stream = new COSStream();
    appearance.setNormalAppearance(new PDAppearanceStream(stream));

    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setAppearance(appearance);

    // Act
    PDAppearanceStream actualNormalAppearanceStream = pdAnnotationCaret.getNormalAppearanceStream();

    // Assert
    PDStream stream2 = actualNormalAppearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDStream contentStream = actualNormalAppearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(stream2.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(actualNormalAppearanceStream.getResources());
    assertNull(stream2.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(actualNormalAppearanceStream.getBBox());
    assertNull(stream2.getFile());
    assertNull(contentStream.getFile());
    assertNull(actualNormalAppearanceStream.getOptionalContent());
    assertNull(actualNormalAppearanceStream.getGroup());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, actualNormalAppearanceStream.getStructParents());
    assertEquals(0, stream2.getLength());
    assertEquals(0, contentStream.getLength());
    Matrix matrix = actualNormalAppearanceStream.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(1, actualNormalAppearanceStream.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(stream, stream2.getCOSObject());
    assertSame(stream, contentStream.getCOSObject());
    assertSame(stream, actualNormalAppearanceStream.getCOSObject());
    assertSame(fileFilters, stream2.getFileFilters());
    assertSame(fileFilters, stream2.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAnnotation#isInvisible()}.
   * <p>
   * Method under test: {@link PDAnnotation#isInvisible()}
   */
  @Test
  @DisplayName("Test isInvisible()")
  void testIsInvisible() {
    // Arrange, Act and Assert
    assertFalse((new PDAnnotationCaret()).isInvisible());
  }

  /**
   * Test {@link PDAnnotation#setInvisible(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setInvisible(boolean)}
   */
  @Test
  @DisplayName("Test setInvisible(boolean); when 'false'; then PDAnnotationCaret() AnnotationFlags is zero")
  void testSetInvisible_whenFalse_thenPDAnnotationCaretAnnotationFlagsIsZero() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setInvisible(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isInvisible());
  }

  /**
   * Test {@link PDAnnotation#setInvisible(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setInvisible(boolean)}
   */
  @Test
  @DisplayName("Test setInvisible(boolean); when 'true'; then PDAnnotationCaret() AnnotationFlags is one")
  void testSetInvisible_whenTrue_thenPDAnnotationCaretAnnotationFlagsIsOne() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setInvisible(true);

    // Assert
    assertEquals(1, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationCaret.isInvisible());
  }

  /**
   * Test {@link PDAnnotation#isHidden()}.
   * <p>
   * Method under test: {@link PDAnnotation#isHidden()}
   */
  @Test
  @DisplayName("Test isHidden()")
  void testIsHidden() {
    // Arrange, Act and Assert
    assertFalse((new PDAnnotationCaret()).isHidden());
  }

  /**
   * Test {@link PDAnnotation#setHidden(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setHidden(boolean)}
   */
  @Test
  @DisplayName("Test setHidden(boolean); when 'false'; then PDAnnotationCaret() AnnotationFlags is zero")
  void testSetHidden_whenFalse_thenPDAnnotationCaretAnnotationFlagsIsZero() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setHidden(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isHidden());
  }

  /**
   * Test {@link PDAnnotation#setHidden(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is
   * two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setHidden(boolean)}
   */
  @Test
  @DisplayName("Test setHidden(boolean); when 'true'; then PDAnnotationCaret() AnnotationFlags is two")
  void testSetHidden_whenTrue_thenPDAnnotationCaretAnnotationFlagsIsTwo() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setHidden(true);

    // Assert
    assertEquals(2, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationCaret.isHidden());
  }

  /**
   * Test {@link PDAnnotation#isPrinted()}.
   * <p>
   * Method under test: {@link PDAnnotation#isPrinted()}
   */
  @Test
  @DisplayName("Test isPrinted()")
  void testIsPrinted() {
    // Arrange, Act and Assert
    assertFalse((new PDAnnotationCaret()).isPrinted());
  }

  /**
   * Test {@link PDAnnotation#setPrinted(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setPrinted(boolean)}
   */
  @Test
  @DisplayName("Test setPrinted(boolean); when 'false'; then PDAnnotationCaret() AnnotationFlags is zero")
  void testSetPrinted_whenFalse_thenPDAnnotationCaretAnnotationFlagsIsZero() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setPrinted(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isPrinted());
  }

  /**
   * Test {@link PDAnnotation#setPrinted(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is
   * four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setPrinted(boolean)}
   */
  @Test
  @DisplayName("Test setPrinted(boolean); when 'true'; then PDAnnotationCaret() AnnotationFlags is four")
  void testSetPrinted_whenTrue_thenPDAnnotationCaretAnnotationFlagsIsFour() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setPrinted(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(4, pdAnnotationCaret.getAnnotationFlags());
    assertTrue(pdAnnotationCaret.isPrinted());
  }

  /**
   * Test {@link PDAnnotation#isNoZoom()}.
   * <p>
   * Method under test: {@link PDAnnotation#isNoZoom()}
   */
  @Test
  @DisplayName("Test isNoZoom()")
  void testIsNoZoom() {
    // Arrange, Act and Assert
    assertFalse((new PDAnnotationCaret()).isNoZoom());
  }

  /**
   * Test {@link PDAnnotation#setNoZoom(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setNoZoom(boolean)}
   */
  @Test
  @DisplayName("Test setNoZoom(boolean); when 'false'; then PDAnnotationCaret() AnnotationFlags is zero")
  void testSetNoZoom_whenFalse_thenPDAnnotationCaretAnnotationFlagsIsZero() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setNoZoom(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isNoZoom());
  }

  /**
   * Test {@link PDAnnotation#setNoZoom(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is
   * eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setNoZoom(boolean)}
   */
  @Test
  @DisplayName("Test setNoZoom(boolean); when 'true'; then PDAnnotationCaret() AnnotationFlags is eight")
  void testSetNoZoom_whenTrue_thenPDAnnotationCaretAnnotationFlagsIsEight() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setNoZoom(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(8, pdAnnotationCaret.getAnnotationFlags());
    assertTrue(pdAnnotationCaret.isNoZoom());
  }

  /**
   * Test {@link PDAnnotation#isNoRotate()}.
   * <p>
   * Method under test: {@link PDAnnotation#isNoRotate()}
   */
  @Test
  @DisplayName("Test isNoRotate()")
  void testIsNoRotate() {
    // Arrange, Act and Assert
    assertFalse((new PDAnnotationCaret()).isNoRotate());
  }

  /**
   * Test {@link PDAnnotation#setNoRotate(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setNoRotate(boolean)}
   */
  @Test
  @DisplayName("Test setNoRotate(boolean); when 'false'; then PDAnnotationCaret() AnnotationFlags is zero")
  void testSetNoRotate_whenFalse_thenPDAnnotationCaretAnnotationFlagsIsZero() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setNoRotate(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isNoRotate());
  }

  /**
   * Test {@link PDAnnotation#setNoRotate(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} NoRotate.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setNoRotate(boolean)}
   */
  @Test
  @DisplayName("Test setNoRotate(boolean); when 'true'; then PDAnnotationCaret() NoRotate")
  void testSetNoRotate_whenTrue_thenPDAnnotationCaretNoRotate() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setNoRotate(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationCaret.isNoRotate());
    assertEquals(Short.SIZE, pdAnnotationCaret.getAnnotationFlags());
  }

  /**
   * Test {@link PDAnnotation#isNoView()}.
   * <p>
   * Method under test: {@link PDAnnotation#isNoView()}
   */
  @Test
  @DisplayName("Test isNoView()")
  void testIsNoView() {
    // Arrange, Act and Assert
    assertFalse((new PDAnnotationCaret()).isNoView());
  }

  /**
   * Test {@link PDAnnotation#setNoView(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setNoView(boolean)}
   */
  @Test
  @DisplayName("Test setNoView(boolean); when 'false'; then PDAnnotationCaret() AnnotationFlags is zero")
  void testSetNoView_whenFalse_thenPDAnnotationCaretAnnotationFlagsIsZero() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setNoView(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isNoView());
  }

  /**
   * Test {@link PDAnnotation#setNoView(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} NoView.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setNoView(boolean)}
   */
  @Test
  @DisplayName("Test setNoView(boolean); when 'true'; then PDAnnotationCaret() NoView")
  void testSetNoView_whenTrue_thenPDAnnotationCaretNoView() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setNoView(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationCaret.isNoView());
    assertEquals(Integer.SIZE, pdAnnotationCaret.getAnnotationFlags());
  }

  /**
   * Test {@link PDAnnotation#isReadOnly()}.
   * <p>
   * Method under test: {@link PDAnnotation#isReadOnly()}
   */
  @Test
  @DisplayName("Test isReadOnly()")
  void testIsReadOnly() {
    // Arrange, Act and Assert
    assertFalse((new PDAnnotationCaret()).isReadOnly());
  }

  /**
   * Test {@link PDAnnotation#setReadOnly(boolean)}.
   * <p>
   * Method under test: {@link PDAnnotation#setReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test setReadOnly(boolean)")
  void testSetReadOnly() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret(new COSDictionary());

    // Act
    pdAnnotationCaret.setReadOnly(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdAnnotationCaret.isReadOnly());
    assertEquals(Double.SIZE, pdAnnotationCaret.getAnnotationFlags());
  }

  /**
   * Test {@link PDAnnotation#setReadOnly(boolean)}.
   * <ul>
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} ReadOnly.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test setReadOnly(boolean); given PDAnnotationCaret(); when 'true'; then PDAnnotationCaret() ReadOnly")
  void testSetReadOnly_givenPDAnnotationCaret_whenTrue_thenPDAnnotationCaretReadOnly() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setReadOnly(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationCaret.isReadOnly());
    assertEquals(Double.SIZE, pdAnnotationCaret.getAnnotationFlags());
  }

  /**
   * Test {@link PDAnnotation#setReadOnly(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test setReadOnly(boolean); when 'false'; then PDAnnotationCaret() AnnotationFlags is zero")
  void testSetReadOnly_whenFalse_thenPDAnnotationCaretAnnotationFlagsIsZero() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setReadOnly(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isReadOnly());
  }

  /**
   * Test {@link PDAnnotation#isLocked()}.
   * <p>
   * Method under test: {@link PDAnnotation#isLocked()}
   */
  @Test
  @DisplayName("Test isLocked()")
  void testIsLocked() {
    // Arrange, Act and Assert
    assertFalse((new PDAnnotationCaret()).isLocked());
  }

  /**
   * Test {@link PDAnnotation#setLocked(boolean)}.
   * <p>
   * Method under test: {@link PDAnnotation#setLocked(boolean)}
   */
  @Test
  @DisplayName("Test setLocked(boolean)")
  void testSetLocked() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret(new COSDictionary());

    // Act
    pdAnnotationCaret.setLocked(true);

    // Assert
    assertEquals(128, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdAnnotationCaret.isLocked());
  }

  /**
   * Test {@link PDAnnotation#setLocked(boolean)}.
   * <ul>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is one
   * hundred twenty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setLocked(boolean)}
   */
  @Test
  @DisplayName("Test setLocked(boolean); then PDAnnotationCaret() AnnotationFlags is one hundred twenty-eight")
  void testSetLocked_thenPDAnnotationCaretAnnotationFlagsIsOneHundredTwentyEight() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setLocked(true);

    // Assert
    assertEquals(128, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationCaret.isLocked());
  }

  /**
   * Test {@link PDAnnotation#setLocked(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setLocked(boolean)}
   */
  @Test
  @DisplayName("Test setLocked(boolean); when 'false'; then PDAnnotationCaret() AnnotationFlags is zero")
  void testSetLocked_whenFalse_thenPDAnnotationCaretAnnotationFlagsIsZero() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setLocked(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isLocked());
  }

  /**
   * Test {@link PDAnnotation#isToggleNoView()}.
   * <p>
   * Method under test: {@link PDAnnotation#isToggleNoView()}
   */
  @Test
  @DisplayName("Test isToggleNoView()")
  void testIsToggleNoView() {
    // Arrange, Act and Assert
    assertFalse((new PDAnnotationCaret()).isToggleNoView());
  }

  /**
   * Test {@link PDAnnotation#setToggleNoView(boolean)}.
   * <ul>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is two
   * hundred fifty-six.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setToggleNoView(boolean)}
   */
  @Test
  @DisplayName("Test setToggleNoView(boolean); then PDAnnotationCaret() AnnotationFlags is two hundred fifty-six")
  void testSetToggleNoView_thenPDAnnotationCaretAnnotationFlagsIsTwoHundredFiftySix() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setToggleNoView(true);

    // Assert
    assertEquals(256, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationCaret.isToggleNoView());
  }

  /**
   * Test {@link PDAnnotation#setToggleNoView(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setToggleNoView(boolean)}
   */
  @Test
  @DisplayName("Test setToggleNoView(boolean); when 'false'; then PDAnnotationCaret() AnnotationFlags is zero")
  void testSetToggleNoView_whenFalse_thenPDAnnotationCaretAnnotationFlagsIsZero() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setToggleNoView(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isToggleNoView());
  }

  /**
   * Test {@link PDAnnotation#isLockedContents()}.
   * <p>
   * Method under test: {@link PDAnnotation#isLockedContents()}
   */
  @Test
  @DisplayName("Test isLockedContents()")
  void testIsLockedContents() {
    // Arrange, Act and Assert
    assertFalse((new PDAnnotationCaret()).isLockedContents());
  }

  /**
   * Test {@link PDAnnotation#setLockedContents(boolean)}.
   * <ul>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is
   * five hundred twelve.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setLockedContents(boolean)}
   */
  @Test
  @DisplayName("Test setLockedContents(boolean); then PDAnnotationCaret() AnnotationFlags is five hundred twelve")
  void testSetLockedContents_thenPDAnnotationCaretAnnotationFlagsIsFiveHundredTwelve() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setLockedContents(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(512, pdAnnotationCaret.getAnnotationFlags());
    assertTrue(pdAnnotationCaret.isLockedContents());
  }

  /**
   * Test {@link PDAnnotation#setLockedContents(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setLockedContents(boolean)}
   */
  @Test
  @DisplayName("Test setLockedContents(boolean); when 'false'; then PDAnnotationCaret() AnnotationFlags is zero")
  void testSetLockedContents_whenFalse_thenPDAnnotationCaretAnnotationFlagsIsZero() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setLockedContents(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isLockedContents());
  }

  /**
   * Test {@link PDAnnotation#getContents()}.
   * <ul>
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret()} Contents is
   * {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given PDAnnotationCaret() Contents is '42'; then return '42'")
  void testGetContents_givenPDAnnotationCaretContentsIs42_thenReturn42() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setContents("42");

    // Act and Assert
    assertEquals("42", pdAnnotationCaret.getContents());
  }

  /**
   * Test {@link PDAnnotation#getContents()}.
   * <ul>
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given PDAnnotationCaret(); then return 'null'")
  void testGetContents_givenPDAnnotationCaret_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCaret()).getContents());
  }

  /**
   * Test {@link PDAnnotation#getContents()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); then return empty string")
  void testGetContents_thenReturnEmptyString() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setContents("");

    // Act and Assert
    assertEquals("", pdAnnotationCaret.getContents());
  }

  /**
   * Test {@link PDAnnotation#setContents(String)}.
   * <p>
   * Method under test: {@link PDAnnotation#setContents(String)}
   */
  @Test
  @DisplayName("Test setContents(String)")
  void testSetContents() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setContents("42");

    // Assert
    assertEquals("42", pdAnnotationCaret.getContents());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#getModifiedDate()}.
   * <p>
   * Method under test: {@link PDAnnotation#getModifiedDate()}
   */
  @Test
  @DisplayName("Test getModifiedDate()")
  void testGetModifiedDate() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCaret()).getModifiedDate());
  }

  /**
   * Test {@link PDAnnotation#setModifiedDate(Calendar)} with {@code c}.
   * <p>
   * Method under test: {@link PDAnnotation#setModifiedDate(Calendar)}
   */
  @Test
  @DisplayName("Test setModifiedDate(Calendar) with 'c'")
  void testSetModifiedDateWithC() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret(new COSDictionary());

    // Act
    pdAnnotationCaret.setModifiedDate(new GregorianCalendar(1, 1, 1));

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#setModifiedDate(Calendar)} with {@code c}.
   * <ul>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} COSObject Values size
   * is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setModifiedDate(Calendar)}
   */
  @Test
  @DisplayName("Test setModifiedDate(Calendar) with 'c'; then PDAnnotationCaret() COSObject Values size is three")
  void testSetModifiedDateWithC_thenPDAnnotationCaretCOSObjectValuesSizeIsThree() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setModifiedDate(new GregorianCalendar(1, 1, 1));

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#setModifiedDate(Calendar)} with {@code c}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} ModifiedDate is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setModifiedDate(Calendar)}
   */
  @Test
  @DisplayName("Test setModifiedDate(Calendar) with 'c'; when 'null'; then PDAnnotationCaret() ModifiedDate is 'null'")
  void testSetModifiedDateWithC_whenNull_thenPDAnnotationCaretModifiedDateIsNull() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setModifiedDate((Calendar) null);

    // Assert
    assertNull(pdAnnotationCaret.getModifiedDate());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#setModifiedDate(String)} with {@code m}.
   * <p>
   * Method under test: {@link PDAnnotation#setModifiedDate(String)}
   */
  @Test
  @DisplayName("Test setModifiedDate(String) with 'm'")
  void testSetModifiedDateWithM() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setModifiedDate("foo");

    // Assert
    assertEquals("foo", pdAnnotationCaret.getModifiedDate());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#getAnnotationName()}.
   * <p>
   * Method under test: {@link PDAnnotation#getAnnotationName()}
   */
  @Test
  @DisplayName("Test getAnnotationName()")
  void testGetAnnotationName() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCaret()).getAnnotationName());
  }

  /**
   * Test {@link PDAnnotation#setAnnotationName(String)}.
   * <p>
   * Method under test: {@link PDAnnotation#setAnnotationName(String)}
   */
  @Test
  @DisplayName("Test setAnnotationName(String)")
  void testSetAnnotationName() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setAnnotationName("Nm");

    // Assert
    assertEquals("Nm", pdAnnotationCaret.getAnnotationName());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#getStructParent()}.
   * <p>
   * Method under test: {@link PDAnnotation#getStructParent()}
   */
  @Test
  @DisplayName("Test getStructParent()")
  void testGetStructParent() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDAnnotationCaret()).getStructParent());
  }

  /**
   * Test {@link PDAnnotation#setStructParent(int)}.
   * <ul>
   *   <li>When {@code -1810807491}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} StructParent is
   * {@code -1810807491}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setStructParent(int)}
   */
  @Test
  @DisplayName("Test setStructParent(int); when '-1810807491'; then PDAnnotationCaret() StructParent is '-1810807491'")
  void testSetStructParent_when1810807491_thenPDAnnotationCaretStructParentIs1810807491() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setStructParent(-1810807491);

    // Assert
    assertEquals(-1810807491, pdAnnotationCaret.getStructParent());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#setStructParent(int)}.
   * <ul>
   *   <li>When nine.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} StructParent is
   * nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setStructParent(int)}
   */
  @Test
  @DisplayName("Test setStructParent(int); when nine; then PDAnnotationCaret() StructParent is nine")
  void testSetStructParent_whenNine_thenPDAnnotationCaretStructParentIsNine() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setStructParent(9);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(9, pdAnnotationCaret.getStructParent());
  }

  /**
   * Test {@link PDAnnotation#setStructParent(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} StructParent is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setStructParent(int)}
   */
  @Test
  @DisplayName("Test setStructParent(int); when one; then PDAnnotationCaret() StructParent is one")
  void testSetStructParent_whenOne_thenPDAnnotationCaretStructParentIsOne() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setStructParent(1);

    // Assert
    assertEquals(1, pdAnnotationCaret.getStructParent());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#setOptionalContent(PDPropertyList)}.
   * <p>
   * Method under test: {@link PDAnnotation#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName("Test setOptionalContent(PDPropertyList)")
  void testSetOptionalContent() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    COSDictionary cosDictionary = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);

    cosDictionary.setKey(key);
    PDPropertyList oc = mock(PDPropertyList.class);
    when(oc.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdAnnotationCaret.setOptionalContent(oc);

    // Assert
    verify(oc).getCOSObject();
    assertSame(key, pdAnnotationCaret.getOptionalContent().getCOSObject().getKey());
  }

  /**
   * Test {@link PDAnnotation#setOptionalContent(PDPropertyList)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName("Test setOptionalContent(PDPropertyList); given COSDictionary()")
  void testSetOptionalContent_givenCOSDictionary() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    PDPropertyList oc = mock(PDPropertyList.class);
    COSDictionary cosDictionary = new COSDictionary();
    when(oc.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdAnnotationCaret.setOptionalContent(oc);

    // Assert
    verify(oc).getCOSObject();
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(cosDictionary, pdAnnotationCaret.getOptionalContent().getCOSObject());
  }

  /**
   * Test {@link PDAnnotation#setOptionalContent(PDPropertyList)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName("Test setOptionalContent(PDPropertyList); given COSDictionary() Direct is 'true'")
  void testSetOptionalContent_givenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    COSDictionary cosDictionary = new COSDictionary();
    cosDictionary.setDirect(true);
    PDPropertyList oc = mock(PDPropertyList.class);
    when(oc.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdAnnotationCaret.setOptionalContent(oc);

    // Assert
    verify(oc).getCOSObject();
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(cosDictionary, pdAnnotationCaret.getOptionalContent().getCOSObject());
  }

  /**
   * Test {@link PDAnnotation#setOptionalContent(PDPropertyList)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} COSObject Values size
   * is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName("Test setOptionalContent(PDPropertyList); given 'null'; then PDAnnotationCaret() COSObject Values size is two")
  void testSetOptionalContent_givenNull_thenPDAnnotationCaretCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    PDPropertyList oc = mock(PDPropertyList.class);
    when(oc.getCOSObject()).thenReturn(null);

    // Act
    pdAnnotationCaret.setOptionalContent(oc);

    // Assert
    verify(oc).getCOSObject();
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#getBorder()}.
   * <p>
   * Method under test: {@link PDAnnotation#getBorder()}
   */
  @Test
  @DisplayName("Test getBorder()")
  void testGetBorder() {
    // Arrange, Act and Assert
    List<? extends COSBase> toListResult = (new PDAnnotationCaret()).getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSInteger);
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
    assertTrue(((COSInteger) getResult2).isValid());
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotation#setBorder(COSArray)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setBorder(COSArray)}
   */
  @Test
  @DisplayName("Test setBorder(COSArray); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetBorder_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    COSArray borderArray = new COSArray();
    borderArray.setKey(new COSObjectKey(1L, 1));
    borderArray.setDirect(false);

    // Act
    pdAnnotationCaret.setBorder(borderArray);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    List<? extends COSBase> toListResult = pdAnnotationCaret.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertEquals(3, cOSObject.size());
    assertSame(toListResult.get(0), toListResult.get(2));
  }

  /**
   * Test {@link PDAnnotation#setBorder(COSArray)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link COSArray#COSArray()} Direct is {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setBorder(COSArray)}
   */
  @Test
  @DisplayName("Test setBorder(COSArray); given 'false'; when COSArray() Direct is 'false'")
  void testSetBorder_givenFalse_whenCOSArrayDirectIsFalse() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    COSArray borderArray = new COSArray();
    borderArray.setDirect(false);

    // Act
    pdAnnotationCaret.setBorder(borderArray);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    List<? extends COSBase> toListResult = pdAnnotationCaret.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertEquals(3, cOSObject.size());
    assertSame(toListResult.get(0), toListResult.get(2));
  }

  /**
   * Test {@link PDAnnotation#setBorder(COSArray)}.
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} COSObject Values size
   * is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setBorder(COSArray)}
   */
  @Test
  @DisplayName("Test setBorder(COSArray); when COSArray(); then PDAnnotationCaret() COSObject Values size is three")
  void testSetBorder_whenCOSArray_thenPDAnnotationCaretCOSObjectValuesSizeIsThree() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setBorder(new COSArray());

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    List<? extends COSBase> toListResult = pdAnnotationCaret.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertEquals(3, cOSObject.size());
    assertSame(toListResult.get(0), toListResult.get(2));
  }

  /**
   * Test {@link PDAnnotation#setBorder(COSArray)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} Border toList third
   * {@link COSInteger}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setBorder(COSArray)}
   */
  @Test
  @DisplayName("Test setBorder(COSArray); when 'null'; then PDAnnotationCaret() Border toList third COSInteger")
  void testSetBorder_whenNull_thenPDAnnotationCaretBorderToListThirdCOSInteger() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setBorder(null);

    // Assert
    List<? extends COSBase> toListResult = pdAnnotationCaret.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertTrue(toListResult.get(2) instanceof COSInteger);
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#setColor(PDColor)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setColor(PDColor)}
   */
  @Test
  @DisplayName("Test setColor(PDColor); given FALSE; when COSArray() add FALSE")
  void testSetColor_givenFalse_whenCOSArrayAddFalse() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);

    // Act
    pdAnnotationCaret.setColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    PDColor color = pdAnnotationCaret.getColor();
    assertNull(color.getPatternName());
    assertFalse(color.isPattern());
    assertArrayEquals(new float[]{0.0f}, color.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDAnnotation#setColor(PDColor)}.
   * <ul>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} Color ColorSpace is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setColor(PDColor)}
   */
  @Test
  @DisplayName("Test setColor(PDColor); then PDAnnotationCaret() Color ColorSpace is 'null'")
  void testSetColor_thenPDAnnotationCaretColorColorSpaceIsNull() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setColor(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    PDColor color = pdAnnotationCaret.getColor();
    assertNull(color.getPatternName());
    assertNull(color.getColorSpace());
    assertEquals(0, color.getComponents().length);
    assertFalse(color.isPattern());
  }

  /**
   * Test {@link PDAnnotation#setColor(PDColor)}.
   * <ul>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} Color Pattern.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setColor(PDColor)}
   */
  @Test
  @DisplayName("Test setColor(PDColor); then PDAnnotationCaret() Color Pattern")
  void testSetColor_thenPDAnnotationCaretColorPattern() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setColor(new PDColor(COSName.A, PDDeviceGray.INSTANCE));

    // Assert
    PDColor color = pdAnnotationCaret.getColor();
    assertTrue(color.isPattern());
    assertArrayEquals(new float[]{0.0f}, color.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDAnnotation#getColor()}.
   * <p>
   * Method under test: {@link PDAnnotation#getColor()}
   */
  @Test
  @DisplayName("Test getColor()")
  void testGetColor() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCaret()).getColor());
  }

  /**
   * Test {@link PDAnnotation#getColor(COSName)} with {@code COSName}.
   * <ul>
   *   <li>When {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#getColor(COSName)}
   */
  @Test
  @DisplayName("Test getColor(COSName) with 'COSName'; when A")
  void testGetColorWithCOSName_whenA() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCaret()).getColor(COSName.A));
  }

  /**
   * Test {@link PDAnnotation#getColor(COSName)} with {@code COSName}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#getColor(COSName)}
   */
  @Test
  @DisplayName("Test getColor(COSName) with 'COSName'; when 'null'")
  void testGetColorWithCOSName_whenNull() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCaret()).getColor(null));
  }

  /**
   * Test {@link PDAnnotation#setPage(PDPage)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} Page is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setPage(PDPage)}
   */
  @Test
  @DisplayName("Test setPage(PDPage); when 'null'; then PDAnnotationCaret() Page is 'null'")
  void testSetPage_whenNull_thenPDAnnotationCaretPageIsNull() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setPage(null);

    // Assert
    assertNull(pdAnnotationCaret.getPage());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#setPage(PDPage)}.
   * <ul>
   *   <li>When {@link PDPage#PDPage()}.</li>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} COSObject Values size
   * is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#setPage(PDPage)}
   */
  @Test
  @DisplayName("Test setPage(PDPage); when PDPage(); then PDAnnotationCaret() COSObject Values size is three")
  void testSetPage_whenPDPage_thenPDAnnotationCaretCOSObjectValuesSizeIsThree() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    PDPage page = new PDPage();

    // Act
    pdAnnotationCaret.setPage(page);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(page, pdAnnotationCaret.getPage());
  }

  /**
   * Test {@link PDAnnotation#getPage()}.
   * <p>
   * Method under test: {@link PDAnnotation#getPage()}
   */
  @Test
  @DisplayName("Test getPage()")
  void testGetPage() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCaret()).getPage());
  }

  /**
   * Test {@link PDAnnotation#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotation#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances() throws IOException {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    pdAnnotationCircle.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationCircle.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationCircle.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationCircle.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadBuffer);
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(-0.5f, bBox.getLowerLeftX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(-0.5f, bBox2.getLowerLeftX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(-0.5f, bBox3.getLowerLeftX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(-0.5f, bBox4.getLowerLeftX());
    PDRectangle rectangle = pdAnnotationCircle.getRectangle();
    assertEquals(-0.5f, rectangle.getLowerLeftX());
    assertEquals(-0.5f, bBox.getLowerLeftY());
    assertEquals(-0.5f, bBox2.getLowerLeftY());
    assertEquals(-0.5f, bBox3.getLowerLeftY());
    assertEquals(-0.5f, bBox4.getLowerLeftY());
    assertEquals(-0.5f, rectangle.getLowerLeftY());
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(0.5f, matrix.getTranslateX());
    assertEquals(0.5f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(0.5f, floatArray[0]);
    assertEquals(0.5f, floatArray[1]);
    assertEquals(231, contentsForStreamParsing.available());
    assertEquals(231, contentsForStreamParsing2.available());
    assertEquals(231, contentsForStreamParsing3.available());
    assertEquals(231, contentsForStreamParsing4.available());
    assertEquals(231, contentsForRandomAccess.available());
    assertEquals(231, contentsForRandomAccess2.available());
    assertEquals(231, contentsForRandomAccess3.available());
    assertEquals(231, contentsForRandomAccess4.available());
    assertEquals(231, normalAppearanceStream.getStream().getLength());
    assertEquals(231, appearanceStream.getStream().getLength());
    assertEquals(231, appearanceStream2.getStream().getLength());
    assertEquals(231, appearanceStream3.getStream().getLength());
    assertEquals(231, normalAppearanceStream.getContentStream().getLength());
    assertEquals(231, appearanceStream.getContentStream().getLength());
    assertEquals(231, appearanceStream2.getContentStream().getLength());
    assertEquals(231, appearanceStream3.getContentStream().getLength());
    assertEquals(231L, normalAppearanceStream.getCOSObject().getLength());
    assertEquals(2384.437f, bBox.getUpperRightX());
    assertEquals(2384.437f, bBox2.getUpperRightX());
    assertEquals(2384.437f, bBox3.getUpperRightX());
    assertEquals(2384.437f, bBox4.getUpperRightX());
    assertEquals(2384.437f, rectangle.getUpperRightX());
    assertEquals(2384.937f, bBox.getWidth());
    assertEquals(2384.937f, bBox2.getWidth());
    assertEquals(2384.937f, bBox3.getWidth());
    assertEquals(2384.937f, bBox4.getWidth());
    assertEquals(2384.937f, rectangle.getWidth());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(3370.8938f, bBox.getUpperRightY());
    assertEquals(3370.8938f, bBox2.getUpperRightY());
    assertEquals(3370.8938f, bBox3.getUpperRightY());
    assertEquals(3370.8938f, bBox4.getUpperRightY());
    assertEquals(3370.8938f, rectangle.getUpperRightY());
    assertEquals(3371.3938f, bBox.getHeight());
    assertEquals(3371.3938f, bBox2.getHeight());
    assertEquals(3371.3938f, bBox3.getHeight());
    assertEquals(3371.3938f, bBox4.getHeight());
    assertEquals(3371.3938f, rectangle.getHeight());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertArrayEquals("1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotation#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotation#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances2() throws IOException {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();
    pdAnnotationFileAttachment.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFileAttachment.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFileAttachment.getNormalAppearanceStream();
    PDRectangle bBox = normalAppearanceStream.getBBox();
    COSArray cOSArray = bBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    assertTrue(toListResult.get(2) instanceof COSFloat);
    assertTrue(toListResult.get(3) instanceof COSFloat);
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFileAttachment.getAppearance();
    PDAppearanceEntry downAppearance = appearance.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
    PDAppearanceStream appearanceStream2 = normalAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceEntry rolloverAppearance = appearance.getRolloverAppearance();
    PDAppearanceStream appearanceStream3 = rolloverAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadBuffer);
    assertEquals(18.0f, bBox.getHeight());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(18.0f, bBox2.getHeight());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(18.0f, bBox3.getHeight());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(18.0f, bBox4.getHeight());
    PDRectangle rectangle = pdAnnotationFileAttachment.getRectangle();
    assertEquals(18.0f, rectangle.getHeight());
    assertEquals(18.0f, bBox.getUpperRightX());
    assertEquals(18.0f, bBox2.getUpperRightX());
    assertEquals(18.0f, bBox3.getUpperRightX());
    assertEquals(18.0f, bBox4.getUpperRightX());
    assertEquals(18.0f, rectangle.getUpperRightX());
    assertEquals(18.0f, bBox.getUpperRightY());
    assertEquals(18.0f, bBox2.getUpperRightY());
    assertEquals(18.0f, bBox3.getUpperRightY());
    assertEquals(18.0f, bBox4.getUpperRightY());
    assertEquals(18.0f, bBox.getWidth());
    assertEquals(18.0f, bBox2.getWidth());
    assertEquals(18.0f, bBox3.getWidth());
    assertEquals(18.0f, bBox4.getWidth());
    assertEquals(18.0f, rectangle.getWidth());
    assertEquals(3352.3938f, rectangle.getLowerLeftY());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertEquals(804, contentsForStreamParsing.available());
    assertEquals(804, contentsForStreamParsing2.available());
    assertEquals(804, contentsForStreamParsing3.available());
    assertEquals(804, contentsForStreamParsing4.available());
    assertEquals(804, contentsForRandomAccess.available());
    assertEquals(804, contentsForRandomAccess2.available());
    assertEquals(804, contentsForRandomAccess3.available());
    assertEquals(804, contentsForRandomAccess4.available());
    PDStream stream = normalAppearanceStream.getStream();
    assertEquals(804, stream.getLength());
    PDStream stream2 = appearanceStream.getStream();
    assertEquals(804, stream2.getLength());
    PDStream stream3 = appearanceStream2.getStream();
    assertEquals(804, stream3.getLength());
    PDStream stream4 = appearanceStream3.getStream();
    assertEquals(804, stream4.getLength());
    PDStream contentStream = normalAppearanceStream.getContentStream();
    assertEquals(804, contentStream.getLength());
    PDStream contentStream2 = appearanceStream.getContentStream();
    assertEquals(804, contentStream2.getLength());
    PDStream contentStream3 = appearanceStream2.getContentStream();
    assertEquals(804, contentStream3.getLength());
    PDStream contentStream4 = appearanceStream3.getContentStream();
    assertEquals(804, contentStream4.getLength());
    COSStream cOSObject = normalAppearanceStream.getCOSObject();
    assertEquals(804L, cOSObject.getLength());
    COSArray cOSArray2 = bBox2.getCOSArray();
    assertEquals(toListResult, cOSArray2.toList());
    COSArray cOSArray3 = bBox3.getCOSArray();
    assertEquals(toListResult, cOSArray3.toList());
    COSArray cOSArray4 = bBox4.getCOSArray();
    assertEquals(toListResult, cOSArray4.toList());
    PDResources resources = normalAppearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    PDResources resources2 = appearanceStream.getResources();
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    PDResources resources3 = appearanceStream2.getResources();
    assertSame(colorSpaceNames, resources3.getColorSpaceNames());
    PDResources resources4 = appearanceStream3.getResources();
    assertSame(colorSpaceNames, resources4.getColorSpaceNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources2.getExtGStateNames());
    assertSame(colorSpaceNames, resources3.getExtGStateNames());
    assertSame(colorSpaceNames, resources4.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, resources2.getFontNames());
    assertSame(colorSpaceNames, resources3.getFontNames());
    assertSame(colorSpaceNames, resources4.getFontNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources3.getPatternNames());
    assertSame(colorSpaceNames, resources4.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources3.getPropertiesNames());
    assertSame(colorSpaceNames, resources4.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources3.getShadingNames());
    assertSame(colorSpaceNames, resources4.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(colorSpaceNames, resources3.getXObjectNames());
    assertSame(colorSpaceNames, resources4.getXObjectNames());
    assertSame(cOSArray, bBox.getCOSObject());
    assertSame(cOSArray2, bBox2.getCOSObject());
    assertSame(cOSArray3, bBox3.getCOSObject());
    assertSame(cOSArray4, bBox4.getCOSObject());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, stream2.getCOSObject());
    assertSame(cOSObject, stream3.getCOSObject());
    assertSame(cOSObject, stream4.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, contentStream2.getCOSObject());
    assertSame(cOSObject, contentStream3.getCOSObject());
    assertSame(cOSObject, contentStream4.getCOSObject());
    assertSame(cOSObject, appearanceStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, appearanceStream3.getCOSObject());
    assertSame(cOSObject, downAppearance.getCOSObject());
    assertSame(cOSObject, normalAppearance.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
    assertArrayEquals("13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotation#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotation#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances3() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFreeText.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadWriteBuffer);
    assertEquals(69, normalAppearanceStream.getStream().getLength());
    assertEquals(69, appearanceStream.getStream().getLength());
    assertEquals(69, appearanceStream2.getStream().getLength());
    assertEquals(69, appearanceStream3.getStream().getLength());
    assertEquals(69, normalAppearanceStream.getContentStream().getLength());
    assertEquals(69, appearanceStream.getContentStream().getLength());
    assertEquals(69, appearanceStream2.getContentStream().getLength());
    assertEquals(69, appearanceStream3.getContentStream().getLength());
    assertEquals(69L, normalAppearanceStream.getCOSObject().getLength());
    assertEquals(85, contentsForStreamParsing.available());
    assertEquals(85, contentsForStreamParsing2.available());
    assertEquals(85, contentsForStreamParsing3.available());
    assertEquals(85, contentsForStreamParsing4.available());
    assertEquals(85, contentsForRandomAccess.available());
    assertEquals(85, contentsForRandomAccess2.available());
    assertEquals(85, contentsForRandomAccess3.available());
    assertEquals(85, contentsForRandomAccess4.available());
  }

  /**
   * Test {@link PDAnnotation#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotation#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances4() throws IOException {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    pdAnnotationCircle.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    pdAnnotationCircle.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationCircle.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationCircle.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadBuffer);
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(-2.14748365E9f, matrix.getTranslateX());
    assertEquals(-2.14748365E9f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-2.14748365E9f, floatArray[0]);
    assertEquals(-2.14748365E9f, floatArray[1]);
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(0.0f, bBox.getHeight());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(0.0f, bBox2.getHeight());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(0.0f, bBox3.getHeight());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(0.0f, bBox4.getHeight());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(0.0f, bBox2.getWidth());
    assertEquals(0.0f, bBox3.getWidth());
    assertEquals(0.0f, bBox4.getWidth());
    assertEquals(2.14748365E9f, bBox.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox2.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox3.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox4.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox2.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox3.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox4.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox.getUpperRightX());
    assertEquals(2.14748365E9f, bBox2.getUpperRightX());
    assertEquals(2.14748365E9f, bBox3.getUpperRightX());
    assertEquals(2.14748365E9f, bBox4.getUpperRightX());
    assertEquals(2.14748365E9f, bBox.getUpperRightY());
    assertEquals(2.14748365E9f, bBox2.getUpperRightY());
    assertEquals(2.14748365E9f, bBox3.getUpperRightY());
    assertEquals(2.14748365E9f, bBox4.getUpperRightY());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(300, contentsForStreamParsing.available());
    assertEquals(300, contentsForStreamParsing2.available());
    assertEquals(300, contentsForStreamParsing3.available());
    assertEquals(300, contentsForStreamParsing4.available());
    assertEquals(300, contentsForRandomAccess.available());
    assertEquals(300, contentsForRandomAccess2.available());
    assertEquals(300, contentsForRandomAccess3.available());
    assertEquals(300, contentsForRandomAccess4.available());
    assertEquals(300, normalAppearanceStream.getStream().getLength());
    assertEquals(300, appearanceStream.getStream().getLength());
    assertEquals(300, appearanceStream2.getStream().getLength());
    assertEquals(300, appearanceStream3.getStream().getLength());
    assertEquals(300, normalAppearanceStream.getContentStream().getLength());
    assertEquals(300, appearanceStream.getContentStream().getLength());
    assertEquals(300, appearanceStream2.getContentStream().getLength());
    assertEquals(300, appearanceStream3.getContentStream().getLength());
    assertEquals(300L, normalAppearanceStream.getCOSObject().getLength());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertArrayEquals("2147483648 2147483648 m\n2147483648 2147483648 21474".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("2147483648 2147483648 m\n2147483648 2147483648 21474".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("2147483648 2147483648 m\n2147483648 2147483648 21474".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("2147483648 2147483648 m\n2147483648 2147483648 21474".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotation#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotation#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances5() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(new COSDictionary());
    pdAnnotationLine.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    PDRectangle rectangle = pdAnnotationLine.getRectangle();
    assertEquals(0.0f, rectangle.getLowerLeftY());
    assertEquals(2383.937f, rectangle.getUpperRightX());
    assertEquals(2383.937f, rectangle.getWidth());
    assertEquals(3370.3938f, rectangle.getHeight());
  }

  /**
   * Test {@link PDAnnotation#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotation#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances6() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("42");
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFreeText.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadWriteBuffer);
    assertEquals(128, contentsForStreamParsing.available());
    assertEquals(128, contentsForStreamParsing2.available());
    assertEquals(128, contentsForStreamParsing3.available());
    assertEquals(128, contentsForStreamParsing4.available());
    assertEquals(128, contentsForRandomAccess.available());
    assertEquals(128, contentsForRandomAccess2.available());
    assertEquals(128, contentsForRandomAccess3.available());
    assertEquals(128, contentsForRandomAccess4.available());
  }

  /**
   * Test {@link PDAnnotation#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotation#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances7() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("G");
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFreeText.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadWriteBuffer);
    assertEquals(Float.MAX_EXPONENT, contentsForStreamParsing.available());
    assertEquals(Float.MAX_EXPONENT, contentsForStreamParsing2.available());
    assertEquals(Float.MAX_EXPONENT, contentsForStreamParsing3.available());
    assertEquals(Float.MAX_EXPONENT, contentsForStreamParsing4.available());
    assertEquals(Float.MAX_EXPONENT, contentsForRandomAccess.available());
    assertEquals(Float.MAX_EXPONENT, contentsForRandomAccess2.available());
    assertEquals(Float.MAX_EXPONENT, contentsForRandomAccess3.available());
    assertEquals(Float.MAX_EXPONENT, contentsForRandomAccess4.available());
  }

  /**
   * Test {@link PDAnnotation#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotation#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances8() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("");
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFreeText.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadWriteBuffer);
    assertEquals(100, normalAppearanceStream.getStream().getLength());
    assertEquals(100, appearanceStream.getStream().getLength());
    assertEquals(100, appearanceStream2.getStream().getLength());
    assertEquals(100, appearanceStream3.getStream().getLength());
    assertEquals(100, normalAppearanceStream.getContentStream().getLength());
    assertEquals(100, appearanceStream.getContentStream().getLength());
    assertEquals(100, appearanceStream2.getContentStream().getLength());
    assertEquals(100, appearanceStream3.getContentStream().getLength());
    assertEquals(100L, normalAppearanceStream.getCOSObject().getLength());
    assertEquals(120, contentsForStreamParsing.available());
    assertEquals(120, contentsForStreamParsing2.available());
    assertEquals(120, contentsForStreamParsing3.available());
    assertEquals(120, contentsForStreamParsing4.available());
    assertEquals(120, contentsForRandomAccess.available());
    assertEquals(120, contentsForRandomAccess2.available());
    assertEquals(120, contentsForRandomAccess3.available());
    assertEquals(120, contentsForRandomAccess4.available());
  }

  /**
   * Test {@link PDAnnotation#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotation#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument() throws IOException {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    pdAnnotationCircle.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationCircle.constructAppearances(new PDDocument());

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationCircle.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationCircle.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadBuffer);
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(-0.5f, bBox.getLowerLeftX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(-0.5f, bBox2.getLowerLeftX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(-0.5f, bBox3.getLowerLeftX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(-0.5f, bBox4.getLowerLeftX());
    PDRectangle rectangle = pdAnnotationCircle.getRectangle();
    assertEquals(-0.5f, rectangle.getLowerLeftX());
    assertEquals(-0.5f, bBox.getLowerLeftY());
    assertEquals(-0.5f, bBox2.getLowerLeftY());
    assertEquals(-0.5f, bBox3.getLowerLeftY());
    assertEquals(-0.5f, bBox4.getLowerLeftY());
    assertEquals(-0.5f, rectangle.getLowerLeftY());
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(0.5f, matrix.getTranslateX());
    assertEquals(0.5f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(0.5f, floatArray[0]);
    assertEquals(0.5f, floatArray[1]);
    assertEquals(231, contentsForStreamParsing.available());
    assertEquals(231, contentsForStreamParsing2.available());
    assertEquals(231, contentsForStreamParsing3.available());
    assertEquals(231, contentsForStreamParsing4.available());
    assertEquals(231, contentsForRandomAccess.available());
    assertEquals(231, contentsForRandomAccess2.available());
    assertEquals(231, contentsForRandomAccess3.available());
    assertEquals(231, contentsForRandomAccess4.available());
    assertEquals(231, normalAppearanceStream.getStream().getLength());
    assertEquals(231, appearanceStream.getStream().getLength());
    assertEquals(231, appearanceStream2.getStream().getLength());
    assertEquals(231, appearanceStream3.getStream().getLength());
    assertEquals(231, normalAppearanceStream.getContentStream().getLength());
    assertEquals(231, appearanceStream.getContentStream().getLength());
    assertEquals(231, appearanceStream2.getContentStream().getLength());
    assertEquals(231, appearanceStream3.getContentStream().getLength());
    assertEquals(231L, normalAppearanceStream.getCOSObject().getLength());
    assertEquals(2384.437f, bBox.getUpperRightX());
    assertEquals(2384.437f, bBox2.getUpperRightX());
    assertEquals(2384.437f, bBox3.getUpperRightX());
    assertEquals(2384.437f, bBox4.getUpperRightX());
    assertEquals(2384.437f, rectangle.getUpperRightX());
    assertEquals(2384.937f, bBox.getWidth());
    assertEquals(2384.937f, bBox2.getWidth());
    assertEquals(2384.937f, bBox3.getWidth());
    assertEquals(2384.937f, bBox4.getWidth());
    assertEquals(2384.937f, rectangle.getWidth());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(3370.8938f, bBox.getUpperRightY());
    assertEquals(3370.8938f, bBox2.getUpperRightY());
    assertEquals(3370.8938f, bBox3.getUpperRightY());
    assertEquals(3370.8938f, bBox4.getUpperRightY());
    assertEquals(3370.8938f, rectangle.getUpperRightY());
    assertEquals(3371.3938f, bBox.getHeight());
    assertEquals(3371.3938f, bBox2.getHeight());
    assertEquals(3371.3938f, bBox3.getHeight());
    assertEquals(3371.3938f, bBox4.getHeight());
    assertEquals(3371.3938f, rectangle.getHeight());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertArrayEquals("1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotation#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotation#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument2() throws IOException {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();
    pdAnnotationFileAttachment.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFileAttachment.constructAppearances(new PDDocument());

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFileAttachment.getNormalAppearanceStream();
    PDRectangle bBox = normalAppearanceStream.getBBox();
    COSArray cOSArray = bBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    assertTrue(toListResult.get(2) instanceof COSFloat);
    assertTrue(toListResult.get(3) instanceof COSFloat);
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFileAttachment.getAppearance();
    PDAppearanceEntry downAppearance = appearance.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
    PDAppearanceStream appearanceStream2 = normalAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceEntry rolloverAppearance = appearance.getRolloverAppearance();
    PDAppearanceStream appearanceStream3 = rolloverAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadBuffer);
    assertEquals(18.0f, bBox.getHeight());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(18.0f, bBox2.getHeight());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(18.0f, bBox3.getHeight());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(18.0f, bBox4.getHeight());
    PDRectangle rectangle = pdAnnotationFileAttachment.getRectangle();
    assertEquals(18.0f, rectangle.getHeight());
    assertEquals(18.0f, bBox.getUpperRightX());
    assertEquals(18.0f, bBox2.getUpperRightX());
    assertEquals(18.0f, bBox3.getUpperRightX());
    assertEquals(18.0f, bBox4.getUpperRightX());
    assertEquals(18.0f, rectangle.getUpperRightX());
    assertEquals(18.0f, bBox.getUpperRightY());
    assertEquals(18.0f, bBox2.getUpperRightY());
    assertEquals(18.0f, bBox3.getUpperRightY());
    assertEquals(18.0f, bBox4.getUpperRightY());
    assertEquals(18.0f, bBox.getWidth());
    assertEquals(18.0f, bBox2.getWidth());
    assertEquals(18.0f, bBox3.getWidth());
    assertEquals(18.0f, bBox4.getWidth());
    assertEquals(18.0f, rectangle.getWidth());
    assertEquals(3352.3938f, rectangle.getLowerLeftY());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertEquals(804, contentsForStreamParsing.available());
    assertEquals(804, contentsForStreamParsing2.available());
    assertEquals(804, contentsForStreamParsing3.available());
    assertEquals(804, contentsForStreamParsing4.available());
    assertEquals(804, contentsForRandomAccess.available());
    assertEquals(804, contentsForRandomAccess2.available());
    assertEquals(804, contentsForRandomAccess3.available());
    assertEquals(804, contentsForRandomAccess4.available());
    PDStream stream = normalAppearanceStream.getStream();
    assertEquals(804, stream.getLength());
    PDStream stream2 = appearanceStream.getStream();
    assertEquals(804, stream2.getLength());
    PDStream stream3 = appearanceStream2.getStream();
    assertEquals(804, stream3.getLength());
    PDStream stream4 = appearanceStream3.getStream();
    assertEquals(804, stream4.getLength());
    PDStream contentStream = normalAppearanceStream.getContentStream();
    assertEquals(804, contentStream.getLength());
    PDStream contentStream2 = appearanceStream.getContentStream();
    assertEquals(804, contentStream2.getLength());
    PDStream contentStream3 = appearanceStream2.getContentStream();
    assertEquals(804, contentStream3.getLength());
    PDStream contentStream4 = appearanceStream3.getContentStream();
    assertEquals(804, contentStream4.getLength());
    COSStream cOSObject = normalAppearanceStream.getCOSObject();
    assertEquals(804L, cOSObject.getLength());
    COSArray cOSArray2 = bBox2.getCOSArray();
    assertEquals(toListResult, cOSArray2.toList());
    COSArray cOSArray3 = bBox3.getCOSArray();
    assertEquals(toListResult, cOSArray3.toList());
    COSArray cOSArray4 = bBox4.getCOSArray();
    assertEquals(toListResult, cOSArray4.toList());
    assertSame(cOSArray, bBox.getCOSObject());
    assertSame(cOSArray2, bBox2.getCOSObject());
    assertSame(cOSArray3, bBox3.getCOSObject());
    assertSame(cOSArray4, bBox4.getCOSObject());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, stream2.getCOSObject());
    assertSame(cOSObject, stream3.getCOSObject());
    assertSame(cOSObject, stream4.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, contentStream2.getCOSObject());
    assertSame(cOSObject, contentStream3.getCOSObject());
    assertSame(cOSObject, contentStream4.getCOSObject());
    assertSame(cOSObject, appearanceStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, appearanceStream3.getCOSObject());
    assertSame(cOSObject, downAppearance.getCOSObject());
    assertSame(cOSObject, normalAppearance.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
    assertArrayEquals("13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotation#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotation#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument3() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFreeText.constructAppearances(new PDDocument());

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadWriteBuffer);
    assertEquals(69, normalAppearanceStream.getStream().getLength());
    assertEquals(69, appearanceStream.getStream().getLength());
    assertEquals(69, appearanceStream2.getStream().getLength());
    assertEquals(69, appearanceStream3.getStream().getLength());
    assertEquals(69, normalAppearanceStream.getContentStream().getLength());
    assertEquals(69, appearanceStream.getContentStream().getLength());
    assertEquals(69, appearanceStream2.getContentStream().getLength());
    assertEquals(69, appearanceStream3.getContentStream().getLength());
    assertEquals(69L, normalAppearanceStream.getCOSObject().getLength());
    assertEquals(85, contentsForStreamParsing.available());
    assertEquals(85, contentsForStreamParsing2.available());
    assertEquals(85, contentsForStreamParsing3.available());
    assertEquals(85, contentsForStreamParsing4.available());
    assertEquals(85, contentsForRandomAccess.available());
    assertEquals(85, contentsForRandomAccess2.available());
    assertEquals(85, contentsForRandomAccess3.available());
    assertEquals(85, contentsForRandomAccess4.available());
  }

  /**
   * Test {@link PDAnnotation#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotation#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument4() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();
    pdAnnotationLine.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationLine.constructAppearances(new PDDocument());

    // Assert
    PDRectangle rectangle = pdAnnotationLine.getRectangle();
    assertEquals(0.0f, rectangle.getLowerLeftY());
    assertEquals(2383.937f, rectangle.getUpperRightX());
    assertEquals(2383.937f, rectangle.getWidth());
    assertEquals(3370.3938f, rectangle.getHeight());
  }

  /**
   * Test {@link PDAnnotation#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotation#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument5() throws IOException {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    pdAnnotationCircle.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    pdAnnotationCircle.constructAppearances(new PDDocument());

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationCircle.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationCircle.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadBuffer);
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(-2.14748365E9f, matrix.getTranslateX());
    assertEquals(-2.14748365E9f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-2.14748365E9f, floatArray[0]);
    assertEquals(-2.14748365E9f, floatArray[1]);
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(0.0f, bBox.getHeight());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(0.0f, bBox2.getHeight());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(0.0f, bBox3.getHeight());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(0.0f, bBox4.getHeight());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(0.0f, bBox2.getWidth());
    assertEquals(0.0f, bBox3.getWidth());
    assertEquals(0.0f, bBox4.getWidth());
    assertEquals(2.14748365E9f, bBox.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox2.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox3.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox4.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox2.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox3.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox4.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox.getUpperRightX());
    assertEquals(2.14748365E9f, bBox2.getUpperRightX());
    assertEquals(2.14748365E9f, bBox3.getUpperRightX());
    assertEquals(2.14748365E9f, bBox4.getUpperRightX());
    assertEquals(2.14748365E9f, bBox.getUpperRightY());
    assertEquals(2.14748365E9f, bBox2.getUpperRightY());
    assertEquals(2.14748365E9f, bBox3.getUpperRightY());
    assertEquals(2.14748365E9f, bBox4.getUpperRightY());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(300, contentsForStreamParsing.available());
    assertEquals(300, contentsForStreamParsing2.available());
    assertEquals(300, contentsForStreamParsing3.available());
    assertEquals(300, contentsForStreamParsing4.available());
    assertEquals(300, contentsForRandomAccess.available());
    assertEquals(300, contentsForRandomAccess2.available());
    assertEquals(300, contentsForRandomAccess3.available());
    assertEquals(300, contentsForRandomAccess4.available());
    assertEquals(300, normalAppearanceStream.getStream().getLength());
    assertEquals(300, appearanceStream.getStream().getLength());
    assertEquals(300, appearanceStream2.getStream().getLength());
    assertEquals(300, appearanceStream3.getStream().getLength());
    assertEquals(300, normalAppearanceStream.getContentStream().getLength());
    assertEquals(300, appearanceStream.getContentStream().getLength());
    assertEquals(300, appearanceStream2.getContentStream().getLength());
    assertEquals(300, appearanceStream3.getContentStream().getLength());
    assertEquals(300L, normalAppearanceStream.getCOSObject().getLength());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertArrayEquals("2147483648 2147483648 m\n2147483648 2147483648 21474".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("2147483648 2147483648 m\n2147483648 2147483648 21474".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("2147483648 2147483648 m\n2147483648 2147483648 21474".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("2147483648 2147483648 m\n2147483648 2147483648 21474".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotation#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotation#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument6() throws IOException {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    pdAnnotationCircle.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationCircle.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationCircle.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationCircle.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadBuffer);
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(-0.5f, bBox.getLowerLeftX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(-0.5f, bBox2.getLowerLeftX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(-0.5f, bBox3.getLowerLeftX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(-0.5f, bBox4.getLowerLeftX());
    PDRectangle rectangle = pdAnnotationCircle.getRectangle();
    assertEquals(-0.5f, rectangle.getLowerLeftX());
    assertEquals(-0.5f, bBox.getLowerLeftY());
    assertEquals(-0.5f, bBox2.getLowerLeftY());
    assertEquals(-0.5f, bBox3.getLowerLeftY());
    assertEquals(-0.5f, bBox4.getLowerLeftY());
    assertEquals(-0.5f, rectangle.getLowerLeftY());
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(0.5f, matrix.getTranslateX());
    assertEquals(0.5f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(0.5f, floatArray[0]);
    assertEquals(0.5f, floatArray[1]);
    assertEquals(231, contentsForStreamParsing.available());
    assertEquals(231, contentsForStreamParsing2.available());
    assertEquals(231, contentsForStreamParsing3.available());
    assertEquals(231, contentsForStreamParsing4.available());
    assertEquals(231, contentsForRandomAccess.available());
    assertEquals(231, contentsForRandomAccess2.available());
    assertEquals(231, contentsForRandomAccess3.available());
    assertEquals(231, contentsForRandomAccess4.available());
    assertEquals(231, normalAppearanceStream.getStream().getLength());
    assertEquals(231, appearanceStream.getStream().getLength());
    assertEquals(231, appearanceStream2.getStream().getLength());
    assertEquals(231, appearanceStream3.getStream().getLength());
    assertEquals(231, normalAppearanceStream.getContentStream().getLength());
    assertEquals(231, appearanceStream.getContentStream().getLength());
    assertEquals(231, appearanceStream2.getContentStream().getLength());
    assertEquals(231, appearanceStream3.getContentStream().getLength());
    assertEquals(231L, normalAppearanceStream.getCOSObject().getLength());
    assertEquals(2384.437f, bBox.getUpperRightX());
    assertEquals(2384.437f, bBox2.getUpperRightX());
    assertEquals(2384.437f, bBox3.getUpperRightX());
    assertEquals(2384.437f, bBox4.getUpperRightX());
    assertEquals(2384.437f, rectangle.getUpperRightX());
    assertEquals(2384.937f, bBox.getWidth());
    assertEquals(2384.937f, bBox2.getWidth());
    assertEquals(2384.937f, bBox3.getWidth());
    assertEquals(2384.937f, bBox4.getWidth());
    assertEquals(2384.937f, rectangle.getWidth());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(3370.8938f, bBox.getUpperRightY());
    assertEquals(3370.8938f, bBox2.getUpperRightY());
    assertEquals(3370.8938f, bBox3.getUpperRightY());
    assertEquals(3370.8938f, bBox4.getUpperRightY());
    assertEquals(3370.8938f, rectangle.getUpperRightY());
    assertEquals(3371.3938f, bBox.getHeight());
    assertEquals(3371.3938f, bBox2.getHeight());
    assertEquals(3371.3938f, bBox3.getHeight());
    assertEquals(3371.3938f, bBox4.getHeight());
    assertEquals(3371.3938f, rectangle.getHeight());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertArrayEquals("1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotation#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotation#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument7() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFreeText.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadWriteBuffer);
    assertEquals(69, normalAppearanceStream.getStream().getLength());
    assertEquals(69, appearanceStream.getStream().getLength());
    assertEquals(69, appearanceStream2.getStream().getLength());
    assertEquals(69, appearanceStream3.getStream().getLength());
    assertEquals(69, normalAppearanceStream.getContentStream().getLength());
    assertEquals(69, appearanceStream.getContentStream().getLength());
    assertEquals(69, appearanceStream2.getContentStream().getLength());
    assertEquals(69, appearanceStream3.getContentStream().getLength());
    assertEquals(69L, normalAppearanceStream.getCOSObject().getLength());
    assertEquals(85, contentsForStreamParsing.available());
    assertEquals(85, contentsForStreamParsing2.available());
    assertEquals(85, contentsForStreamParsing3.available());
    assertEquals(85, contentsForStreamParsing4.available());
    assertEquals(85, contentsForRandomAccess.available());
    assertEquals(85, contentsForRandomAccess2.available());
    assertEquals(85, contentsForRandomAccess3.available());
    assertEquals(85, contentsForRandomAccess4.available());
  }

  /**
   * Test {@link PDAnnotation#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotation#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument8() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());

    // Act
    pdAnnotationFreeText.constructAppearances(document);

    // Assert
    List<? extends COSBase> toListResult = pdAnnotationFreeText.getNormalAppearanceStream()
        .getBBox()
        .getCOSArray()
        .toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    List<? extends COSBase> toListResult2 = appearance.getDownAppearance()
        .getAppearanceStream()
        .getBBox()
        .getCOSArray()
        .toList();
    assertEquals(4, toListResult2.size());
    assertTrue(toListResult2.get(0) instanceof COSFloat);
    assertTrue(toListResult2.get(1) instanceof COSFloat);
    List<? extends COSBase> toListResult3 = appearance.getNormalAppearance()
        .getAppearanceStream()
        .getBBox()
        .getCOSArray()
        .toList();
    assertEquals(4, toListResult3.size());
    assertTrue(toListResult3.get(0) instanceof COSFloat);
    assertTrue(toListResult3.get(1) instanceof COSFloat);
    List<? extends COSBase> toListResult4 = appearance.getRolloverAppearance()
        .getAppearanceStream()
        .getBBox()
        .getCOSArray()
        .toList();
    assertEquals(4, toListResult4.size());
    assertTrue(toListResult4.get(0) instanceof COSFloat);
    assertTrue(toListResult4.get(1) instanceof COSFloat);
  }

  /**
   * Test {@link PDAnnotation#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotation#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument9() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("42");
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFreeText.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadWriteBuffer);
    assertEquals(128, contentsForStreamParsing.available());
    assertEquals(128, contentsForStreamParsing2.available());
    assertEquals(128, contentsForStreamParsing3.available());
    assertEquals(128, contentsForStreamParsing4.available());
    assertEquals(128, contentsForRandomAccess.available());
    assertEquals(128, contentsForRandomAccess2.available());
    assertEquals(128, contentsForRandomAccess3.available());
    assertEquals(128, contentsForRandomAccess4.available());
  }

  /**
   * Test {@link PDAnnotation#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotation#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument10() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    pdAnnotationFreeText.constructAppearances(new PDDocument(doc));

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadWriteBuffer);
    assertEquals(69, normalAppearanceStream.getStream().getLength());
    assertEquals(69, appearanceStream.getStream().getLength());
    assertEquals(69, appearanceStream2.getStream().getLength());
    assertEquals(69, appearanceStream3.getStream().getLength());
    assertEquals(69, normalAppearanceStream.getContentStream().getLength());
    assertEquals(69, appearanceStream.getContentStream().getLength());
    assertEquals(69, appearanceStream2.getContentStream().getLength());
    assertEquals(69, appearanceStream3.getContentStream().getLength());
    assertEquals(69L, normalAppearanceStream.getCOSObject().getLength());
    assertEquals(85, contentsForStreamParsing.available());
    assertEquals(85, contentsForStreamParsing2.available());
    assertEquals(85, contentsForStreamParsing3.available());
    assertEquals(85, contentsForStreamParsing4.available());
    assertEquals(85, contentsForRandomAccess.available());
    assertEquals(85, contentsForRandomAccess2.available());
    assertEquals(85, contentsForRandomAccess3.available());
    assertEquals(85, contentsForRandomAccess4.available());
    PDResources resources = normalAppearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertSame(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, appearanceStream.getResources().getFontNames());
    assertSame(colorSpaceNames, appearanceStream2.getResources().getFontNames());
    assertSame(colorSpaceNames, appearanceStream3.getResources().getFontNames());
  }

  /**
   * Test {@link PDAnnotation#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotation#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument11() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("G");
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFreeText.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadWriteBuffer);
    assertEquals(Float.MAX_EXPONENT, contentsForStreamParsing.available());
    assertEquals(Float.MAX_EXPONENT, contentsForStreamParsing2.available());
    assertEquals(Float.MAX_EXPONENT, contentsForStreamParsing3.available());
    assertEquals(Float.MAX_EXPONENT, contentsForStreamParsing4.available());
    assertEquals(Float.MAX_EXPONENT, contentsForRandomAccess.available());
    assertEquals(Float.MAX_EXPONENT, contentsForRandomAccess2.available());
    assertEquals(Float.MAX_EXPONENT, contentsForRandomAccess3.available());
    assertEquals(Float.MAX_EXPONENT, contentsForRandomAccess4.available());
  }

  /**
   * Test {@link PDAnnotation#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotation#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument12() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("");
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFreeText.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadWriteBuffer);
    assertEquals(100, normalAppearanceStream.getStream().getLength());
    assertEquals(100, appearanceStream.getStream().getLength());
    assertEquals(100, appearanceStream2.getStream().getLength());
    assertEquals(100, appearanceStream3.getStream().getLength());
    assertEquals(100, normalAppearanceStream.getContentStream().getLength());
    assertEquals(100, appearanceStream.getContentStream().getLength());
    assertEquals(100, appearanceStream2.getContentStream().getLength());
    assertEquals(100, appearanceStream3.getContentStream().getLength());
    assertEquals(100L, normalAppearanceStream.getCOSObject().getLength());
    assertEquals(120, contentsForStreamParsing.available());
    assertEquals(120, contentsForStreamParsing2.available());
    assertEquals(120, contentsForStreamParsing3.available());
    assertEquals(120, contentsForStreamParsing4.available());
    assertEquals(120, contentsForRandomAccess.available());
    assertEquals(120, contentsForRandomAccess2.available());
    assertEquals(120, contentsForRandomAccess3.available());
    assertEquals(120, contentsForRandomAccess4.available());
  }

  /**
   * Test {@link PDAnnotation#constructAppearances()}.
   * <ul>
   *   <li>Then {@link PDAnnotationLine#PDAnnotationLine()} Rectangle LowerLeftY is
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then PDAnnotationLine() Rectangle LowerLeftY is zero")
  void testConstructAppearances_thenPDAnnotationLineRectangleLowerLeftYIsZero() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();
    pdAnnotationLine.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    PDRectangle rectangle = pdAnnotationLine.getRectangle();
    assertEquals(0.0f, rectangle.getLowerLeftY());
    assertEquals(2383.937f, rectangle.getUpperRightX());
    assertEquals(2383.937f, rectangle.getWidth());
    assertEquals(3370.3938f, rectangle.getHeight());
  }

  /**
   * Test {@link PDAnnotation#constructAppearances()}.
   * <ul>
   *   <li>Then {@link PDAnnotationPolygon#PDAnnotationPolygon()} Rectangle
   * LowerLeftY is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then PDAnnotationPolygon() Rectangle LowerLeftY is zero")
  void testConstructAppearances_thenPDAnnotationPolygonRectangleLowerLeftYIsZero() {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();
    pdAnnotationPolygon.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    PDRectangle rectangle = pdAnnotationPolygon.getRectangle();
    assertEquals(0.0f, rectangle.getLowerLeftY());
    assertEquals(2383.937f, rectangle.getUpperRightX());
    assertEquals(2383.937f, rectangle.getWidth());
    assertEquals(3370.3938f, rectangle.getHeight());
  }

  /**
   * Test {@link PDAnnotation#constructAppearances()}.
   * <ul>
   *   <li>Then {@link PDAnnotationPolyline#PDAnnotationPolyline()} Rectangle
   * LowerLeftY is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotation#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then PDAnnotationPolyline() Rectangle LowerLeftY is zero")
  void testConstructAppearances_thenPDAnnotationPolylineRectangleLowerLeftYIsZero() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    pdAnnotationPolyline.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationPolyline.constructAppearances();

    // Assert
    PDRectangle rectangle = pdAnnotationPolyline.getRectangle();
    assertEquals(0.0f, rectangle.getLowerLeftY());
    assertEquals(2383.937f, rectangle.getUpperRightX());
    assertEquals(2383.937f, rectangle.getWidth());
    assertEquals(3370.3938f, rectangle.getHeight());
  }
}

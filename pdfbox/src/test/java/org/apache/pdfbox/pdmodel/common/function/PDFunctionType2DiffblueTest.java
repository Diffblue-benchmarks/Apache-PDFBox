package org.apache.pdfbox.pdmodel.common.function;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFunctionType2DiffblueTest {
  /**
   * Test {@link PDFunctionType2#PDFunctionType2(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return PDStream is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunctionType2#PDFunctionType2(COSBase)}
   */
  @Test
  @DisplayName(
      "Test new PDFunctionType2(COSBase); when COSDictionary(); then return PDStream is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFunctionType2.<init>(COSBase)"})
  void testNewPDFunctionType2_whenCOSDictionary_thenReturnPDStreamIsNull() {
    // Arrange
    COSDictionary function = new COSDictionary();

    // Act
    PDFunctionType2 actualPdFunctionType2 = new PDFunctionType2(function);

    // Assert
    assertNull(actualPdFunctionType2.getPDStream());
    assertEquals(0, function.size());
    assertSame(function, actualPdFunctionType2.getCOSObject());
  }

  /**
   * Test {@link PDFunctionType2#PDFunctionType2(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then return PDStream DecodeParms is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunctionType2#PDFunctionType2(COSBase)}
   */
  @Test
  @DisplayName(
      "Test new PDFunctionType2(COSBase); when COSStream(); then return PDStream DecodeParms is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFunctionType2.<init>(COSBase)"})
  void testNewPDFunctionType2_whenCOSStream_thenReturnPDStreamDecodeParmsIsNull()
      throws IOException {
    // Arrange
    COSStream function = new COSStream();

    // Act
    PDFunctionType2 actualPdFunctionType2 = new PDFunctionType2(function);

    // Assert
    PDStream pDStream = actualPdFunctionType2.getPDStream();
    assertNull(pDStream.getDecodeParms());
    assertNull(pDStream.getFileDecodeParams());
    assertNull(pDStream.getMetadata());
    assertNull(pDStream.getFile());
    assertEquals(-1, pDStream.getDecodedStreamLength());
    assertEquals(0, pDStream.getLength());
    assertEquals(2, function.size());
    List<String> fileFilters = pDStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(function, pDStream.getCOSObject());
    assertSame(function, actualPdFunctionType2.getCOSObject());
    assertSame(fileFilters, pDStream.getFilters());
  }

  /**
   * Test {@link PDFunctionType2#eval(float[])}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSObject#COSObject(COSBase, COSObjectKey)}
   *       with object is {@link COSBoolean#FALSE} and objectKey is {@link
   *       COSObjectKey#COSObjectKey(long, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunctionType2#eval(float[])}
   */
  @Test
  @DisplayName(
      "Test eval(float[]); given COSArray() add COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDFunctionType2.eval(float[])"})
  void testEval_givenCOSArrayAddCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey()
      throws IOException {
    // Arrange
    COSArray rangeValues = new COSArray();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    rangeValues.add((COSBase) object);

    PDFunctionType2 pdFunctionType2 = new PDFunctionType2(new COSDictionary());
    pdFunctionType2.setRangeValues(rangeValues);

    // Act
    float[] actualEvalResult = pdFunctionType2.eval(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertArrayEquals(new float[] {}, actualEvalResult, 0.0f);
  }

  /**
   * Test {@link PDFunctionType2#eval(float[])}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then return array of {@code float} with zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFunctionType2#eval(float[])}
   */
  @Test
  @DisplayName(
      "Test eval(float[]); given COSArray() add FALSE; then return array of float with zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDFunctionType2.eval(float[])"})
  void testEval_givenCOSArrayAddFalse_thenReturnArrayOfFloatWithZero() throws IOException {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSBoolean.FALSE);
    rangeValues.add(COSBoolean.FALSE);

    PDFunctionType2 pdFunctionType2 = new PDFunctionType2(new COSDictionary());
    pdFunctionType2.setRangeValues(rangeValues);

    // Act
    float[] actualEvalResult = pdFunctionType2.eval(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertArrayEquals(new float[] {0.0f}, actualEvalResult, 0.0f);
  }

  /**
   * Test {@link PDFunctionType2#eval(float[])}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then return empty array of {@code float}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunctionType2#eval(float[])}
   */
  @Test
  @DisplayName("Test eval(float[]); given COSArray() add FALSE; then return empty array of float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDFunctionType2.eval(float[])"})
  void testEval_givenCOSArrayAddFalse_thenReturnEmptyArrayOfFloat() throws IOException {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSBoolean.FALSE);

    PDFunctionType2 pdFunctionType2 = new PDFunctionType2(new COSDictionary());
    pdFunctionType2.setRangeValues(rangeValues);

    // Act
    float[] actualEvalResult = pdFunctionType2.eval(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertArrayEquals(new float[] {}, actualEvalResult, 0.0f);
  }

  /**
   * Test {@link PDFunctionType2#eval(float[])}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSFloat#ONE}.
   *   <li>Then return empty array of {@code float}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunctionType2#eval(float[])}
   */
  @Test
  @DisplayName("Test eval(float[]); given COSArray() add ONE; then return empty array of float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDFunctionType2.eval(float[])"})
  void testEval_givenCOSArrayAddOne_thenReturnEmptyArrayOfFloat() throws IOException {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSFloat.ONE);

    PDFunctionType2 pdFunctionType2 = new PDFunctionType2(new COSDictionary());
    pdFunctionType2.setRangeValues(rangeValues);

    // Act
    float[] actualEvalResult = pdFunctionType2.eval(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertArrayEquals(new float[] {}, actualEvalResult, 0.0f);
  }

  /**
   * Test {@link PDFunctionType2#eval(float[])}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSInteger#ONE}.
   *   <li>Then return empty array of {@code float}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunctionType2#eval(float[])}
   */
  @Test
  @DisplayName("Test eval(float[]); given COSArray() add ONE; then return empty array of float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDFunctionType2.eval(float[])"})
  void testEval_givenCOSArrayAddOne_thenReturnEmptyArrayOfFloat2() throws IOException {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSInteger.ONE);

    PDFunctionType2 pdFunctionType2 = new PDFunctionType2(new COSDictionary());
    pdFunctionType2.setRangeValues(rangeValues);

    // Act
    float[] actualEvalResult = pdFunctionType2.eval(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertArrayEquals(new float[] {}, actualEvalResult, 0.0f);
  }

  /**
   * Test {@link PDFunctionType2#eval(float[])}.
   *
   * <ul>
   *   <li>Given {@link PDFunctionType2#PDFunctionType2(COSBase)} with function is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunctionType2#eval(float[])}
   */
  @Test
  @DisplayName(
      "Test eval(float[]); given PDFunctionType2(COSBase) with function is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDFunctionType2.eval(float[])"})
  void testEval_givenPDFunctionType2WithFunctionIsCOSDictionary() throws IOException {
    // Arrange and Act
    float[] actualEvalResult =
        new PDFunctionType2(new COSDictionary()).eval(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertArrayEquals(new float[] {0.1f}, actualEvalResult, 0.0f);
  }

  /**
   * Test {@link PDFunctionType2#eval(float[])}.
   *
   * <ul>
   *   <li>Given {@link PDFunctionType2#PDFunctionType2(COSBase)} with function is {@link
   *       COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunctionType2#eval(float[])}
   */
  @Test
  @DisplayName("Test eval(float[]); given PDFunctionType2(COSBase) with function is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDFunctionType2.eval(float[])"})
  void testEval_givenPDFunctionType2WithFunctionIsCOSStream() throws IOException {
    // Arrange and Act
    float[] actualEvalResult =
        new PDFunctionType2(new COSStream()).eval(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertArrayEquals(new float[] {0.1f}, actualEvalResult, 0.0f);
  }

  /**
   * Test {@link PDFunctionType2#eval(float[])}.
   *
   * <ul>
   *   <li>Then return array of {@code float} with {@code 0.1}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunctionType2#eval(float[])}
   */
  @Test
  @DisplayName("Test eval(float[]); then return array of float with '0.1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDFunctionType2.eval(float[])"})
  void testEval_thenReturnArrayOfFloatWith01() throws IOException {
    // Arrange
    PDFunctionType2 pdFunctionType2 = new PDFunctionType2(new COSDictionary());
    pdFunctionType2.setRangeValues(new COSArray());

    // Act
    float[] actualEvalResult = pdFunctionType2.eval(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertArrayEquals(new float[] {0.1f}, actualEvalResult, 0.0f);
  }
}

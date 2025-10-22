package org.apache.pdfbox.pdmodel.common.function;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return C1 toList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType2#PDFunctionType2(COSBase)}
   */
  @Test
  @DisplayName("Test new PDFunctionType2(COSBase); when COSDictionary(); then return C1 toList size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFunctionType2.<init>(COSBase)"})
  void testNewPDFunctionType2_whenCOSDictionary_thenReturnC1ToListSizeIsOne() {
    // Arrange
    COSDictionary function = new COSDictionary();

    // Act
    PDFunctionType2 actualPdFunctionType2 = new PDFunctionType2(function);

    // Assert
    List<? extends COSBase> toListResult = actualPdFunctionType2.getC1().toList();
    assertEquals(1, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertNull(actualPdFunctionType2.getPDStream());
    assertEquals(0, function.size());
    assertSame(function, actualPdFunctionType2.getCOSObject());
  }

  /**
   * Test {@link PDFunctionType2#PDFunctionType2(COSBase)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return PDStream DecodeParms is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType2#PDFunctionType2(COSBase)}
   */
  @Test
  @DisplayName("Test new PDFunctionType2(COSBase); when COSStream(); then return PDStream DecodeParms is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFunctionType2.<init>(COSBase)"})
  void testNewPDFunctionType2_whenCOSStream_thenReturnPDStreamDecodeParmsIsNull() throws IOException {
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
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then return array of {@code float} with zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType2#eval(float[])}
   */
  @Test
  @DisplayName("Test eval(float[]); given COSArray() add FALSE; then return array of float with zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float[] PDFunctionType2.eval(float[])"})
  void testEval_givenCOSArrayAddFalse_thenReturnArrayOfFloatWithZero() throws IOException {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSBoolean.FALSE);
    rangeValues.add(COSBoolean.FALSE);

    PDFunctionType2 pdFunctionType2 = new PDFunctionType2(new COSDictionary());
    pdFunctionType2.setRangeValues(rangeValues);

    // Act and Assert
    assertArrayEquals(new float[]{0.0f}, pdFunctionType2.eval(new float[]{10.0f, 0.5f, 10.0f, 0.5f}), 0.0f);
  }

  /**
   * Test {@link PDFunctionType2#eval(float[])}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then return empty array of {@code float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType2#eval(float[])}
   */
  @Test
  @DisplayName("Test eval(float[]); given COSArray() add FALSE; then return empty array of float")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float[] PDFunctionType2.eval(float[])"})
  void testEval_givenCOSArrayAddFalse_thenReturnEmptyArrayOfFloat() throws IOException {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSBoolean.FALSE);

    PDFunctionType2 pdFunctionType2 = new PDFunctionType2(new COSDictionary());
    pdFunctionType2.setRangeValues(rangeValues);

    // Act and Assert
    assertArrayEquals(new float[]{}, pdFunctionType2.eval(new float[]{10.0f, 0.5f, 10.0f, 0.5f}), 0.0f);
  }

  /**
   * Test {@link PDFunctionType2#eval(float[])}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSFloat#ONE}.</li>
   *   <li>Then return array of {@code float} with {@code 0.1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType2#eval(float[])}
   */
  @Test
  @DisplayName("Test eval(float[]); given COSArray() add ONE; then return array of float with '0.1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float[] PDFunctionType2.eval(float[])"})
  void testEval_givenCOSArrayAddOne_thenReturnArrayOfFloatWith01() throws IOException {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSBoolean.FALSE);
    rangeValues.add(COSFloat.ONE);

    PDFunctionType2 pdFunctionType2 = new PDFunctionType2(new COSDictionary());
    pdFunctionType2.setRangeValues(rangeValues);

    // Act and Assert
    assertArrayEquals(new float[]{0.1f}, pdFunctionType2.eval(new float[]{10.0f, 0.5f, 10.0f, 0.5f}), 0.0f);
  }

  /**
   * Test {@link PDFunctionType2#eval(float[])}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSFloat#ONE}.</li>
   *   <li>Then return array of {@code float} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType2#eval(float[])}
   */
  @Test
  @DisplayName("Test eval(float[]); given COSArray() add ONE; then return array of float with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float[] PDFunctionType2.eval(float[])"})
  void testEval_givenCOSArrayAddOne_thenReturnArrayOfFloatWithOne() throws IOException {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSFloat.ONE);
    rangeValues.add(COSBoolean.FALSE);

    PDFunctionType2 pdFunctionType2 = new PDFunctionType2(new COSDictionary());
    pdFunctionType2.setRangeValues(rangeValues);

    // Act and Assert
    assertArrayEquals(new float[]{1.0f}, pdFunctionType2.eval(new float[]{10.0f, 0.5f, 10.0f, 0.5f}), 0.0f);
  }

  /**
   * Test {@link PDFunctionType2#eval(float[])}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSFloat#ONE}.</li>
   *   <li>Then return empty array of {@code float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType2#eval(float[])}
   */
  @Test
  @DisplayName("Test eval(float[]); given COSArray() add ONE; then return empty array of float")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float[] PDFunctionType2.eval(float[])"})
  void testEval_givenCOSArrayAddOne_thenReturnEmptyArrayOfFloat() throws IOException {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSFloat.ONE);

    PDFunctionType2 pdFunctionType2 = new PDFunctionType2(new COSDictionary());
    pdFunctionType2.setRangeValues(rangeValues);

    // Act and Assert
    assertArrayEquals(new float[]{}, pdFunctionType2.eval(new float[]{10.0f, 0.5f, 10.0f, 0.5f}), 0.0f);
  }

  /**
   * Test {@link PDFunctionType2#eval(float[])}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSInteger#ONE}.</li>
   *   <li>Then return empty array of {@code float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType2#eval(float[])}
   */
  @Test
  @DisplayName("Test eval(float[]); given COSArray() add ONE; then return empty array of float")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float[] PDFunctionType2.eval(float[])"})
  void testEval_givenCOSArrayAddOne_thenReturnEmptyArrayOfFloat2() throws IOException {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSInteger.ONE);

    PDFunctionType2 pdFunctionType2 = new PDFunctionType2(new COSDictionary());
    pdFunctionType2.setRangeValues(rangeValues);

    // Act and Assert
    assertArrayEquals(new float[]{}, pdFunctionType2.eval(new float[]{10.0f, 0.5f, 10.0f, 0.5f}), 0.0f);
  }

  /**
   * Test {@link PDFunctionType2#eval(float[])}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   *   <li>Then return empty array of {@code float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType2#eval(float[])}
   */
  @Test
  @DisplayName("Test eval(float[]); given COSObjectKey(long, int) with num is one and gen is one; then return empty array of float")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float[] PDFunctionType2.eval(float[])"})
  void testEval_givenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnEmptyArrayOfFloat() throws IOException {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add((COSBase) new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    PDFunctionType2 pdFunctionType2 = new PDFunctionType2(new COSDictionary());
    pdFunctionType2.setRangeValues(rangeValues);

    // Act and Assert
    assertArrayEquals(new float[]{}, pdFunctionType2.eval(new float[]{10.0f, 0.5f, 10.0f, 0.5f}), 0.0f);
  }

  /**
   * Test {@link PDFunctionType2#eval(float[])}.
   * <ul>
   *   <li>Given {@link PDFunctionType2#PDFunctionType2(COSBase)} with function is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType2#eval(float[])}
   */
  @Test
  @DisplayName("Test eval(float[]); given PDFunctionType2(COSBase) with function is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float[] PDFunctionType2.eval(float[])"})
  void testEval_givenPDFunctionType2WithFunctionIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.1f},
        (new PDFunctionType2(new COSDictionary())).eval(new float[]{10.0f, 0.5f, 10.0f, 0.5f}), 0.0f);
  }

  /**
   * Test {@link PDFunctionType2#eval(float[])}.
   * <ul>
   *   <li>Given {@link PDFunctionType2#PDFunctionType2(COSBase)} with function is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType2#eval(float[])}
   */
  @Test
  @DisplayName("Test eval(float[]); given PDFunctionType2(COSBase) with function is COSStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float[] PDFunctionType2.eval(float[])"})
  void testEval_givenPDFunctionType2WithFunctionIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.1f},
        (new PDFunctionType2(new COSStream())).eval(new float[]{10.0f, 0.5f, 10.0f, 0.5f}), 0.0f);
  }

  /**
   * Test {@link PDFunctionType2#eval(float[])}.
   * <ul>
   *   <li>Then return array of {@code float} with {@code 0.1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType2#eval(float[])}
   */
  @Test
  @DisplayName("Test eval(float[]); then return array of float with '0.1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float[] PDFunctionType2.eval(float[])"})
  void testEval_thenReturnArrayOfFloatWith01() throws IOException {
    // Arrange
    PDFunctionType2 pdFunctionType2 = new PDFunctionType2(new COSDictionary());
    pdFunctionType2.setRangeValues(new COSArray());

    // Act and Assert
    assertArrayEquals(new float[]{0.1f}, pdFunctionType2.eval(new float[]{10.0f, 0.5f, 10.0f, 0.5f}), 0.0f);
  }
}

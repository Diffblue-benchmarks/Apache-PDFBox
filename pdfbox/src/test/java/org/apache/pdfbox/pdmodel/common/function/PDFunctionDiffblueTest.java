package org.apache.pdfbox.pdmodel.common.function;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.common.PDRange;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.Test;

class PDFunctionDiffblueTest {
  /**
   * Method under test: {@link PDFunction#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange, Act and Assert
    assertNull((new PDFunctionType0(COSBoolean.FALSE)).getCOSObject());
  }

  /**
   * Method under test: {@link PDFunction#getCOSObject()}
   */
  @Test
  void testGetCOSObject2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSDictionary actualCOSObject = (new PDFunctionType0(new COSDocument(streamCacheCreateFunction))).getCOSObject();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualCOSObject);
  }

  /**
   * Method under test: {@link PDFunction#getCOSObject()}
   */
  @Test
  void testGetCOSObject3() {
    // Arrange
    COSStream function = new COSStream();

    // Act and Assert
    assertSame(function, (new PDFunctionType0(function)).getCOSObject());
  }

  /**
   * Method under test: {@link PDFunction#getPDStream()}
   */
  @Test
  void testGetPDStream() {
    // Arrange, Act and Assert
    assertNull((new PDFunctionType0(COSBoolean.FALSE)).getPDStream());
  }

  /**
   * Method under test: {@link PDFunction#getPDStream()}
   */
  @Test
  void testGetPDStream2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDStream actualPDStream = (new PDFunctionType0(new COSDocument(streamCacheCreateFunction))).getPDStream();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPDStream);
  }

  /**
   * Method under test: {@link PDFunction#create(COSBase)}
   */
  @Test
  void testCreate() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDFunction.create(COSBoolean.FALSE));
    assertThrows(IOException.class, () -> PDFunction.create(null));
    assertThrows(IOException.class, () -> PDFunction.create(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1))));
    assertThrows(IOException.class, () -> PDFunction.create(new COSDictionary()));
  }

  /**
   * Method under test: {@link PDFunction#create(COSBase)}
   */
  @Test
  void testCreate2() throws IOException {
    // Arrange and Act
    PDFunction actualCreateResult = PDFunction.create(COSName.IDENTITY);

    // Assert
    assertTrue(actualCreateResult instanceof PDFunctionTypeIdentity);
    assertNull(actualCreateResult.getRangeValues());
    assertNull(actualCreateResult.getCOSObject());
    assertNull(actualCreateResult.getPDStream());
    assertEquals(0, actualCreateResult.getNumberOfOutputParameters());
  }

  /**
   * Method under test: {@link PDFunction#getNumberOfOutputParameters()}
   */
  @Test
  void testGetNumberOfOutputParameters() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDFunctionType0(new COSDictionary())).getNumberOfOutputParameters());
    assertEquals(0, (new PDFunctionType0(new COSStream())).getNumberOfOutputParameters());
  }

  /**
   * Method under test: {@link PDFunction#getNumberOfOutputParameters()}
   */
  @Test
  void testGetNumberOfOutputParameters2() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSStream());
    pdFunctionType0.setRangeValues(new COSArray());

    // Act and Assert
    assertEquals(0, pdFunctionType0.getNumberOfOutputParameters());
  }

  /**
   * Method under test: {@link PDFunction#getRangeForOutput(int)}
   */
  @Test
  void testGetRangeForOutput() {
    // Arrange and Act
    PDRange actualRangeForOutput = (new PDFunctionType0(new COSDictionary())).getRangeForOutput(1);

    // Assert
    assertNull(actualRangeForOutput.getCOSArray());
    assertNull(actualRangeForOutput.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunction#getRangeForOutput(int)}
   */
  @Test
  void testGetRangeForOutput2() {
    // Arrange and Act
    PDRange actualRangeForOutput = (new PDFunctionType0(new COSStream())).getRangeForOutput(1);

    // Assert
    assertNull(actualRangeForOutput.getCOSArray());
    assertNull(actualRangeForOutput.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunction#getRangeForOutput(int)}
   */
  @Test
  void testGetRangeForOutput3() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSStream());
    COSArray rangeValues = new COSArray();
    pdFunctionType0.setRangeValues(rangeValues);

    // Act
    PDRange actualRangeForOutput = pdFunctionType0.getRangeForOutput(1);

    // Assert
    COSArray cOSArray = actualRangeForOutput.getCOSArray();
    assertTrue(cOSArray.toList().isEmpty());
    assertSame(rangeValues, cOSArray);
    assertSame(rangeValues, actualRangeForOutput.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunction#setRangeValues(COSArray)}
   */
  @Test
  void testSetRangeValues() {
    // Arrange
    COSDictionary function = new COSDictionary();
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(function);
    COSArray rangeValues = new COSArray();

    // Act
    pdFunctionType0.setRangeValues(rangeValues);

    // Assert
    assertSame(rangeValues, pdFunctionType0.getRangeValues());
    assertSame(function, pdFunctionType0.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunction#setRangeValues(COSArray)}
   */
  @Test
  void testSetRangeValues2() {
    // Arrange
    COSStream function = new COSStream();
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(function);
    COSArray rangeValues = new COSArray();

    // Act
    pdFunctionType0.setRangeValues(rangeValues);

    // Assert
    assertSame(rangeValues, pdFunctionType0.getRangeValues());
    assertSame(function, pdFunctionType0.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunction#setRangeValues(COSArray)}
   */
  @Test
  void testSetRangeValues3() {
    // Arrange
    COSStream function = new COSStream();
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(function);

    // Act
    pdFunctionType0.setRangeValues(null);

    // Assert
    assertNull(pdFunctionType0.getRangeValues());
    assertSame(function, pdFunctionType0.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunction#getNumberOfInputParameters()}
   */
  @Test
  void testGetNumberOfInputParameters() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSStream());
    pdFunctionType0.setDomainValues(new COSArray());

    // Act and Assert
    assertEquals(0, pdFunctionType0.getNumberOfInputParameters());
  }

  /**
   * Method under test: {@link PDFunction#getDomainForInput(int)}
   */
  @Test
  void testGetDomainForInput() {
    // Arrange and Act
    PDRange actualDomainForInput = (new PDFunctionType0(new COSDictionary())).getDomainForInput(1);

    // Assert
    assertNull(actualDomainForInput.getCOSArray());
    assertNull(actualDomainForInput.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunction#getDomainForInput(int)}
   */
  @Test
  void testGetDomainForInput2() {
    // Arrange and Act
    PDRange actualDomainForInput = (new PDFunctionType0(new COSStream())).getDomainForInput(1);

    // Assert
    assertNull(actualDomainForInput.getCOSArray());
    assertNull(actualDomainForInput.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunction#getDomainForInput(int)}
   */
  @Test
  void testGetDomainForInput3() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSStream());
    COSArray domainValues = new COSArray();
    pdFunctionType0.setDomainValues(domainValues);

    // Act
    PDRange actualDomainForInput = pdFunctionType0.getDomainForInput(1);

    // Assert
    COSArray cOSArray = actualDomainForInput.getCOSArray();
    assertTrue(cOSArray.toList().isEmpty());
    assertSame(domainValues, cOSArray);
    assertSame(domainValues, actualDomainForInput.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunction#setDomainValues(COSArray)}
   */
  @Test
  void testSetDomainValues() {
    // Arrange
    COSDictionary function = new COSDictionary();
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(function);

    // Act
    pdFunctionType0.setDomainValues(new COSArray());

    // Assert
    assertEquals(0, pdFunctionType0.getNumberOfInputParameters());
    assertSame(function, pdFunctionType0.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunction#setDomainValues(COSArray)}
   */
  @Test
  void testSetDomainValues2() {
    // Arrange
    COSStream function = new COSStream();
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(function);

    // Act
    pdFunctionType0.setDomainValues(new COSArray());

    // Assert
    assertEquals(0, pdFunctionType0.getNumberOfInputParameters());
    assertSame(function, pdFunctionType0.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunction#setDomainValues(COSArray)}
   */
  @Test
  void testSetDomainValues3() {
    // Arrange
    COSStream function = new COSStream();
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(function);

    // Act
    pdFunctionType0.setDomainValues(null);

    // Assert
    assertSame(function, pdFunctionType0.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunction#getRangeValues()}
   */
  @Test
  void testGetRangeValues() {
    // Arrange, Act and Assert
    assertNull((new PDFunctionType0(new COSDictionary())).getRangeValues());
    assertNull((new PDFunctionType0(new COSStream())).getRangeValues());
  }

  /**
   * Method under test: {@link PDFunction#getRangeValues()}
   */
  @Test
  void testGetRangeValues2() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSStream());
    COSArray rangeValues = new COSArray();
    pdFunctionType0.setRangeValues(rangeValues);

    // Act
    COSArray actualRangeValues = pdFunctionType0.getRangeValues();

    // Assert
    assertTrue(actualRangeValues.toList().isEmpty());
    assertSame(rangeValues, actualRangeValues);
  }

  /**
   * Method under test: {@link PDFunction#clipToRange(float, float, float)}
   */
  @Test
  void testClipToRange() {
    // Arrange, Act and Assert
    assertEquals(10.0f, (new PDFunctionType0(COSBoolean.FALSE)).clipToRange(10.0f, 10.0f, 10.0f));
  }

  /**
   * Method under test: {@link PDFunction#clipToRange(float, float, float)}
   */
  @Test
  void testClipToRange2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    float actualClipToRangeResult = (new PDFunctionType0(new COSDocument(streamCacheCreateFunction))).clipToRange(10.0f,
        10.0f, 10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(10.0f, actualClipToRangeResult);
  }

  /**
   * Method under test: {@link PDFunction#clipToRange(float, float, float)}
   */
  @Test
  void testClipToRange3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    float actualClipToRangeResult = (new PDFunctionType0(new COSDocument(streamCacheCreateFunction))).clipToRange(0.5f,
        10.0f, 10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(10.0f, actualClipToRangeResult);
  }

  /**
   * Method under test: {@link PDFunction#clipToRange(float, float, float)}
   */
  @Test
  void testClipToRange4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    float actualClipToRangeResult = (new PDFunctionType0(new COSDocument(streamCacheCreateFunction))).clipToRange(-0.5f,
        10.0f, 10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(10.0f, actualClipToRangeResult);
  }

  /**
   * Method under test: {@link PDFunction#clipToRange(float, float, float)}
   */
  @Test
  void testClipToRange5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    float actualClipToRangeResult = (new PDFunctionType0(new COSDocument(streamCacheCreateFunction)))
        .clipToRange(Float.NaN, 10.0f, 10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(Float.NaN, actualClipToRangeResult);
  }

  /**
   * Method under test: {@link PDFunction#clipToRange(float, float, float)}
   */
  @Test
  void testClipToRange6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    float actualClipToRangeResult = (new PDFunctionType0(new COSDocument(streamCacheCreateFunction))).clipToRange(10.0f,
        10.0f, 0.5f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.5f, actualClipToRangeResult);
  }

  /**
   * Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  void testClipToRange7() {
    // Arrange
    float[] inputValues = new float[]{10.0f, 0.5f, 10.0f, 0.5f};

    // Act and Assert
    assertSame(inputValues, (new PDFunctionType0(new COSDictionary())).clipToRange(inputValues));
  }

  /**
   * Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  void testClipToRange8() {
    // Arrange
    float[] inputValues = new float[]{10.0f, 0.5f, 10.0f, 0.5f};

    // Act and Assert
    assertSame(inputValues, (new PDFunctionType0(new COSStream())).clipToRange(inputValues));
  }

  /**
   * Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  void testClipToRange9() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSStream());
    pdFunctionType0.setRangeValues(new COSArray());
    float[] inputValues = new float[]{10.0f, 0.5f, 10.0f, 0.5f};

    // Act and Assert
    assertSame(inputValues, pdFunctionType0.clipToRange(inputValues));
  }

  /**
   * Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  void testClipToRange10() {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSBoolean.FALSE);

    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSStream());
    pdFunctionType0.setRangeValues(rangeValues);

    // Act and Assert
    assertEquals(0, pdFunctionType0.clipToRange(new float[]{10.0f, 0.5f, 10.0f, 0.5f}).length);
  }

  /**
   * Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  void testClipToRange11() {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSBoolean.FALSE);
    rangeValues.add(COSBoolean.FALSE);

    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSStream());
    pdFunctionType0.setRangeValues(rangeValues);

    // Act and Assert
    assertArrayEquals(new float[]{0.0f}, pdFunctionType0.clipToRange(new float[]{10.0f, 0.5f, 10.0f, 0.5f}), 0.0f);
  }

  /**
   * Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  void testClipToRange12() {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSFloat.ONE);

    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSStream());
    pdFunctionType0.setRangeValues(rangeValues);

    // Act and Assert
    assertEquals(0, pdFunctionType0.clipToRange(new float[]{10.0f, 0.5f, 10.0f, 0.5f}).length);
  }

  /**
   * Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  void testClipToRange13() {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSInteger.ONE);

    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSStream());
    pdFunctionType0.setRangeValues(rangeValues);

    // Act and Assert
    assertEquals(0, pdFunctionType0.clipToRange(new float[]{10.0f, 0.5f, 10.0f, 0.5f}).length);
  }

  /**
   * Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  void testClipToRange14() {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add((COSBase) new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSStream());
    pdFunctionType0.setRangeValues(rangeValues);

    // Act and Assert
    assertEquals(0, pdFunctionType0.clipToRange(new float[]{10.0f, 0.5f, 10.0f, 0.5f}).length);
  }

  /**
   * Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  void testClipToRange15() {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSInteger.get(42L));
    rangeValues.add(COSBoolean.FALSE);

    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSStream());
    pdFunctionType0.setRangeValues(rangeValues);

    // Act and Assert
    assertArrayEquals(new float[]{42.0f}, pdFunctionType0.clipToRange(new float[]{10.0f, 0.5f, 10.0f, 0.5f}), 0.0f);
  }

  /**
   * Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  void testClipToRange16() {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSBoolean.FALSE);
    rangeValues.add(new COSFloat(10.0f));

    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSStream());
    pdFunctionType0.setRangeValues(rangeValues);

    // Act and Assert
    assertArrayEquals(new float[]{10.0f}, pdFunctionType0.clipToRange(new float[]{10.0f, 0.5f, 10.0f, 0.5f}), 0.0f);
  }

  /**
   * Method under test:
   * {@link PDFunction#interpolate(float, float, float, float, float)}
   */
  @Test
  void testInterpolate() {
    // Arrange, Act and Assert
    assertEquals(10.0f, (new PDFunctionType0(COSBoolean.FALSE)).interpolate(10.0f, 10.0f, 10.0f, 10.0f, 10.0f));
  }

  /**
   * Method under test:
   * {@link PDFunction#interpolate(float, float, float, float, float)}
   */
  @Test
  void testInterpolate2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    float actualInterpolateResult = (new PDFunctionType0(new COSDocument(streamCacheCreateFunction))).interpolate(10.0f,
        10.0f, 10.0f, 10.0f, 10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(10.0f, actualInterpolateResult);
  }

  /**
   * Method under test:
   * {@link PDFunction#interpolate(float, float, float, float, float)}
   */
  @Test
  void testInterpolate3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    float actualInterpolateResult = (new PDFunctionType0(new COSDocument(streamCacheCreateFunction))).interpolate(0.5f,
        10.0f, 10.0f, 10.0f, 10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(10.0f, actualInterpolateResult);
  }

  /**
   * Method under test:
   * {@link PDFunction#interpolate(float, float, float, float, float)}
   */
  @Test
  void testInterpolate4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    float actualInterpolateResult = (new PDFunctionType0(new COSDocument(streamCacheCreateFunction))).interpolate(-0.5f,
        10.0f, 10.0f, 10.0f, 10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(10.0f, actualInterpolateResult);
  }

  /**
   * Method under test:
   * {@link PDFunction#interpolate(float, float, float, float, float)}
   */
  @Test
  void testInterpolate5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    float actualInterpolateResult = (new PDFunctionType0(new COSDocument(streamCacheCreateFunction)))
        .interpolate(Float.NaN, 10.0f, 10.0f, 10.0f, 10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(10.0f, actualInterpolateResult);
  }

  /**
   * Method under test:
   * {@link PDFunction#interpolate(float, float, float, float, float)}
   */
  @Test
  void testInterpolate6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    float actualInterpolateResult = (new PDFunctionType0(new COSDocument(streamCacheCreateFunction))).interpolate(10.0f,
        0.5f, 10.0f, 10.0f, 10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(10.0f, actualInterpolateResult);
  }

  /**
   * Method under test: {@link PDFunction#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("FunctionType0", (new PDFunctionType0(COSBoolean.FALSE)).toString());
  }

  /**
   * Method under test: {@link PDFunction#toString()}
   */
  @Test
  void testToString2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualToStringResult = (new PDFunctionType0(new COSDocument(streamCacheCreateFunction))).toString();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("FunctionType0", actualToStringResult);
  }
}

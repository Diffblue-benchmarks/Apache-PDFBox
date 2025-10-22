package org.apache.pdfbox.pdmodel.common.function;

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
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.PDRange;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFunctionType0DiffblueTest {
  /**
   * Test {@link PDFunctionType0#PDFunctionType0(COSBase)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return RangeValues is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType0#PDFunctionType0(COSBase)}
   */
  @Test
  @DisplayName("Test new PDFunctionType0(COSBase); when COSDictionary(); then return RangeValues is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFunctionType0.<init>(COSBase)"})
  void testNewPDFunctionType0_whenCOSDictionary_thenReturnRangeValuesIsNull() {
    // Arrange
    COSDictionary function = new COSDictionary();

    // Act
    PDFunctionType0 actualPdFunctionType0 = new PDFunctionType0(function);

    // Assert
    assertNull(actualPdFunctionType0.getRangeValues());
    assertNull(actualPdFunctionType0.getSize());
    assertEquals(-1, actualPdFunctionType0.getBitsPerSample());
    assertEquals(0, actualPdFunctionType0.getNumberOfOutputParameters());
    assertEquals(1, actualPdFunctionType0.getOrder());
    assertSame(function, actualPdFunctionType0.getCOSObject());
  }

  /**
   * Test {@link PDFunctionType0#PDFunctionType0(COSBase)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return PDStream DecodeParms is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType0#PDFunctionType0(COSBase)}
   */
  @Test
  @DisplayName("Test new PDFunctionType0(COSBase); when COSStream(); then return PDStream DecodeParms is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFunctionType0.<init>(COSBase)"})
  void testNewPDFunctionType0_whenCOSStream_thenReturnPDStreamDecodeParmsIsNull() throws IOException {
    // Arrange
    COSStream function = new COSStream();

    // Act
    PDFunctionType0 actualPdFunctionType0 = new PDFunctionType0(function);

    // Assert
    PDStream pDStream = actualPdFunctionType0.getPDStream();
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
    assertSame(function, actualPdFunctionType0.getCOSObject());
    assertSame(fileFilters, pDStream.getFilters());
  }

  /**
   * Test {@link PDFunctionType0#PDFunctionType0(COSBase)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then return COSObject is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType0#PDFunctionType0(COSBase)}
   */
  @Test
  @DisplayName("Test new PDFunctionType0(COSBase); when FALSE; then return COSObject is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFunctionType0.<init>(COSBase)"})
  void testNewPDFunctionType0_whenFalse_thenReturnCOSObjectIsNull() {
    // Arrange and Act
    PDFunctionType0 actualPdFunctionType0 = new PDFunctionType0(COSBoolean.FALSE);

    // Assert
    assertNull(actualPdFunctionType0.getCOSObject());
    assertNull(actualPdFunctionType0.getPDStream());
    assertEquals(0, actualPdFunctionType0.getFunctionType());
  }

  /**
   * Test {@link PDFunctionType0#getFunctionType()}.
   * <p>
   * Method under test: {@link PDFunctionType0#getFunctionType()}
   */
  @Test
  @DisplayName("Test getFunctionType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDFunctionType0.getFunctionType()"})
  void testGetFunctionType() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDFunctionType0(COSBoolean.FALSE)).getFunctionType());
  }

  /**
   * Test {@link PDFunctionType0#getSize()}.
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType0#getSize()}
   */
  @Test
  @DisplayName("Test getSize(); given PDFunctionType0(COSBase) with function is COSDictionary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSArray PDFunctionType0.getSize()"})
  void testGetSize_givenPDFunctionType0WithFunctionIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDFunctionType0(new COSDictionary())).getSize());
  }

  /**
   * Test {@link PDFunctionType0#getSize()}.
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType0#getSize()}
   */
  @Test
  @DisplayName("Test getSize(); given PDFunctionType0(COSBase) with function is COSStream(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSArray PDFunctionType0.getSize()"})
  void testGetSize_givenPDFunctionType0WithFunctionIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDFunctionType0(new COSStream())).getSize());
  }

  /**
   * Test {@link PDFunctionType0#getBitsPerSample()}.
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType0#getBitsPerSample()}
   */
  @Test
  @DisplayName("Test getBitsPerSample(); given PDFunctionType0(COSBase) with function is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDFunctionType0.getBitsPerSample()"})
  void testGetBitsPerSample_givenPDFunctionType0WithFunctionIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDFunctionType0(new COSDictionary())).getBitsPerSample());
  }

  /**
   * Test {@link PDFunctionType0#getBitsPerSample()}.
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType0#getBitsPerSample()}
   */
  @Test
  @DisplayName("Test getBitsPerSample(); given PDFunctionType0(COSBase) with function is COSStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDFunctionType0.getBitsPerSample()"})
  void testGetBitsPerSample_givenPDFunctionType0WithFunctionIsCOSStream() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDFunctionType0(new COSStream())).getBitsPerSample());
  }

  /**
   * Test {@link PDFunctionType0#getOrder()}.
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType0#getOrder()}
   */
  @Test
  @DisplayName("Test getOrder(); given PDFunctionType0(COSBase) with function is COSDictionary(); then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDFunctionType0.getOrder()"})
  void testGetOrder_givenPDFunctionType0WithFunctionIsCOSDictionary_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new PDFunctionType0(new COSDictionary())).getOrder());
  }

  /**
   * Test {@link PDFunctionType0#getOrder()}.
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is {@link COSStream#COSStream()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType0#getOrder()}
   */
  @Test
  @DisplayName("Test getOrder(); given PDFunctionType0(COSBase) with function is COSStream(); then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDFunctionType0.getOrder()"})
  void testGetOrder_givenPDFunctionType0WithFunctionIsCOSStream_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new PDFunctionType0(new COSStream())).getOrder());
  }

  /**
   * Test {@link PDFunctionType0#setBitsPerSample(int)}.
   * <p>
   * Method under test: {@link PDFunctionType0#setBitsPerSample(int)}
   */
  @Test
  @DisplayName("Test setBitsPerSample(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFunctionType0.setBitsPerSample(int)"})
  void testSetBitsPerSample() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());

    // Act
    pdFunctionType0.setBitsPerSample(1);

    // Assert
    COSDictionary cOSObject = pdFunctionType0.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdFunctionType0.getBitsPerSample());
  }

  /**
   * Test {@link PDFunctionType0#setBitsPerSample(int)}.
   * <p>
   * Method under test: {@link PDFunctionType0#setBitsPerSample(int)}
   */
  @Test
  @DisplayName("Test setBitsPerSample(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFunctionType0.setBitsPerSample(int)"})
  void testSetBitsPerSample2() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSStream());

    // Act
    pdFunctionType0.setBitsPerSample(1);

    // Assert
    COSDictionary cOSObject = pdFunctionType0.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(1, pdFunctionType0.getBitsPerSample());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDFunctionType0#setBitsPerSample(int)}.
   * <p>
   * Method under test: {@link PDFunctionType0#setBitsPerSample(int)}
   */
  @Test
  @DisplayName("Test setBitsPerSample(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFunctionType0.setBitsPerSample(int)"})
  void testSetBitsPerSample3() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());

    // Act
    pdFunctionType0.setBitsPerSample(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdFunctionType0.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdFunctionType0.getBitsPerSample());
  }

  /**
   * Test {@link PDFunctionType0#getEncodeForParameter(int)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType0#getEncodeForParameter(int)}
   */
  @Test
  @DisplayName("Test getEncodeForParameter(int); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRange PDFunctionType0.getEncodeForParameter(int)"})
  void testGetEncodeForParameter_thenReturnNull() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setEncodeValues(new COSArray());

    // Act and Assert
    assertNull(pdFunctionType0.getEncodeForParameter(10));
  }

  /**
   * Test {@link PDFunctionType0#getEncodeForParameter(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return COSArray toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType0#getEncodeForParameter(int)}
   */
  @Test
  @DisplayName("Test getEncodeForParameter(int); when minus one; then return COSArray toList Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRange PDFunctionType0.getEncodeForParameter(int)"})
  void testGetEncodeForParameter_whenMinusOne_thenReturnCOSArrayToListEmpty() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    COSArray encodeValues = new COSArray();
    pdFunctionType0.setEncodeValues(encodeValues);

    // Act
    PDRange actualEncodeForParameter = pdFunctionType0.getEncodeForParameter(-1);

    // Assert
    COSArray cOSArray = actualEncodeForParameter.getCOSArray();
    assertTrue(cOSArray.toList().isEmpty());
    assertSame(encodeValues, cOSArray);
    assertSame(encodeValues, actualEncodeForParameter.getCOSObject());
  }

  /**
   * Test {@link PDFunctionType0#setEncodeValues(COSArray)}.
   * <p>
   * Method under test: {@link PDFunctionType0#setEncodeValues(COSArray)}
   */
  @Test
  @DisplayName("Test setEncodeValues(COSArray)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFunctionType0.setEncodeValues(COSArray)"})
  void testSetEncodeValues() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());

    // Act
    pdFunctionType0.setEncodeValues(new COSArray());

    // Assert
    COSDictionary cOSObject = pdFunctionType0.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDFunctionType0#setEncodeValues(COSArray)}.
   * <p>
   * Method under test: {@link PDFunctionType0#setEncodeValues(COSArray)}
   */
  @Test
  @DisplayName("Test setEncodeValues(COSArray)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFunctionType0.setEncodeValues(COSArray)"})
  void testSetEncodeValues2() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());

    // Act
    pdFunctionType0.setEncodeValues(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdFunctionType0.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDFunctionType0#setEncodeValues(COSArray)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType0#setEncodeValues(COSArray)}
   */
  @Test
  @DisplayName("Test setEncodeValues(COSArray); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFunctionType0.setEncodeValues(COSArray)"})
  void testSetEncodeValues_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());

    COSArray encodeValues = new COSArray();
    encodeValues.setDirect(false);
    encodeValues.setKey(new COSObjectKey(1L, 1));

    // Act
    pdFunctionType0.setEncodeValues(encodeValues);

    // Assert
    COSDictionary cOSObject = pdFunctionType0.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDFunctionType0#setEncodeValues(COSArray)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link COSArray#COSArray()} Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType0#setEncodeValues(COSArray)}
   */
  @Test
  @DisplayName("Test setEncodeValues(COSArray); given 'null'; when COSArray() Key is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFunctionType0.setEncodeValues(COSArray)"})
  void testSetEncodeValues_givenNull_whenCOSArrayKeyIsNull() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());

    COSArray encodeValues = new COSArray();
    encodeValues.setDirect(false);
    encodeValues.setKey(null);

    // Act
    pdFunctionType0.setEncodeValues(encodeValues);

    // Assert
    COSDictionary cOSObject = pdFunctionType0.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDFunctionType0#setEncodeValues(COSArray)}.
   * <ul>
   *   <li>Then {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is {@link COSStream#COSStream()} COSObject {@link COSStream}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType0#setEncodeValues(COSArray)}
   */
  @Test
  @DisplayName("Test setEncodeValues(COSArray); then PDFunctionType0(COSBase) with function is COSStream() COSObject COSStream")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFunctionType0.setEncodeValues(COSArray)"})
  void testSetEncodeValues_thenPDFunctionType0WithFunctionIsCOSStreamCOSObjectCOSStream() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSStream());

    // Act
    pdFunctionType0.setEncodeValues(new COSArray());

    // Assert
    COSDictionary cOSObject = pdFunctionType0.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDFunctionType0#getDecodeForParameter(int)}.
   * <p>
   * Method under test: {@link PDFunctionType0#getDecodeForParameter(int)}
   */
  @Test
  @DisplayName("Test getDecodeForParameter(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRange PDFunctionType0.getDecodeForParameter(int)"})
  void testGetDecodeForParameter() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setDecodeValues(new COSArray());

    // Act and Assert
    assertNull(pdFunctionType0.getDecodeForParameter(10));
  }

  /**
   * Test {@link PDFunctionType0#getDecodeForParameter(int)}.
   * <p>
   * Method under test: {@link PDFunctionType0#getDecodeForParameter(int)}
   */
  @Test
  @DisplayName("Test getDecodeForParameter(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRange PDFunctionType0.getDecodeForParameter(int)"})
  void testGetDecodeForParameter2() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setRangeValues(new COSArray());

    // Act and Assert
    assertNull(pdFunctionType0.getDecodeForParameter(10));
  }

  /**
   * Test {@link PDFunctionType0#getDecodeForParameter(int)}.
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType0#getDecodeForParameter(int)}
   */
  @Test
  @DisplayName("Test getDecodeForParameter(int); given PDFunctionType0(COSBase) with function is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRange PDFunctionType0.getDecodeForParameter(int)"})
  void testGetDecodeForParameter_givenPDFunctionType0WithFunctionIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDFunctionType0(new COSDictionary())).getDecodeForParameter(10));
  }

  /**
   * Test {@link PDFunctionType0#getDecodeForParameter(int)}.
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType0#getDecodeForParameter(int)}
   */
  @Test
  @DisplayName("Test getDecodeForParameter(int); given PDFunctionType0(COSBase) with function is COSStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRange PDFunctionType0.getDecodeForParameter(int)"})
  void testGetDecodeForParameter_givenPDFunctionType0WithFunctionIsCOSStream() {
    // Arrange, Act and Assert
    assertNull((new PDFunctionType0(new COSStream())).getDecodeForParameter(10));
  }

  /**
   * Test {@link PDFunctionType0#getDecodeForParameter(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return COSArray toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType0#getDecodeForParameter(int)}
   */
  @Test
  @DisplayName("Test getDecodeForParameter(int); when minus one; then return COSArray toList Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRange PDFunctionType0.getDecodeForParameter(int)"})
  void testGetDecodeForParameter_whenMinusOne_thenReturnCOSArrayToListEmpty() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    COSArray decodeValues = new COSArray();
    pdFunctionType0.setDecodeValues(decodeValues);

    // Act
    PDRange actualDecodeForParameter = pdFunctionType0.getDecodeForParameter(-1);

    // Assert
    COSArray cOSArray = actualDecodeForParameter.getCOSArray();
    assertTrue(cOSArray.toList().isEmpty());
    assertSame(decodeValues, cOSArray);
    assertSame(decodeValues, actualDecodeForParameter.getCOSObject());
  }

  /**
   * Test {@link PDFunctionType0#setDecodeValues(COSArray)}.
   * <p>
   * Method under test: {@link PDFunctionType0#setDecodeValues(COSArray)}
   */
  @Test
  @DisplayName("Test setDecodeValues(COSArray)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFunctionType0.setDecodeValues(COSArray)"})
  void testSetDecodeValues() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());

    // Act
    pdFunctionType0.setDecodeValues(new COSArray());

    // Assert
    COSDictionary cOSObject = pdFunctionType0.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDFunctionType0#setDecodeValues(COSArray)}.
   * <p>
   * Method under test: {@link PDFunctionType0#setDecodeValues(COSArray)}
   */
  @Test
  @DisplayName("Test setDecodeValues(COSArray)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFunctionType0.setDecodeValues(COSArray)"})
  void testSetDecodeValues2() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());

    // Act
    pdFunctionType0.setDecodeValues(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdFunctionType0.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDFunctionType0#setDecodeValues(COSArray)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType0#setDecodeValues(COSArray)}
   */
  @Test
  @DisplayName("Test setDecodeValues(COSArray); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFunctionType0.setDecodeValues(COSArray)"})
  void testSetDecodeValues_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());

    COSArray decodeValues = new COSArray();
    decodeValues.setDirect(false);
    decodeValues.setKey(new COSObjectKey(1L, 1));

    // Act
    pdFunctionType0.setDecodeValues(decodeValues);

    // Assert
    COSDictionary cOSObject = pdFunctionType0.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDFunctionType0#setDecodeValues(COSArray)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link COSArray#COSArray()} Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType0#setDecodeValues(COSArray)}
   */
  @Test
  @DisplayName("Test setDecodeValues(COSArray); given 'null'; when COSArray() Key is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFunctionType0.setDecodeValues(COSArray)"})
  void testSetDecodeValues_givenNull_whenCOSArrayKeyIsNull() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());

    COSArray decodeValues = new COSArray();
    decodeValues.setDirect(false);
    decodeValues.setKey(null);

    // Act
    pdFunctionType0.setDecodeValues(decodeValues);

    // Assert
    COSDictionary cOSObject = pdFunctionType0.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDFunctionType0#setDecodeValues(COSArray)}.
   * <ul>
   *   <li>Then {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is {@link COSStream#COSStream()} COSObject {@link COSStream}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType0#setDecodeValues(COSArray)}
   */
  @Test
  @DisplayName("Test setDecodeValues(COSArray); then PDFunctionType0(COSBase) with function is COSStream() COSObject COSStream")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFunctionType0.setDecodeValues(COSArray)"})
  void testSetDecodeValues_thenPDFunctionType0WithFunctionIsCOSStreamCOSObjectCOSStream() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSStream());

    // Act
    pdFunctionType0.setDecodeValues(new COSArray());

    // Assert
    COSDictionary cOSObject = pdFunctionType0.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }
}

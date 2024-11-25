package org.apache.pdfbox.pdmodel.common.function;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.ICOSParser;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdmodel.common.PDRange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDFunctionDiffblueTest {
  /**
   * Test {@link PDFunction#getCOSObject()}.
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is
   * {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject(); given PDFunctionType0(COSBase) with function is COSStream(); then return COSStream()")
  void testGetCOSObject_givenPDFunctionType0WithFunctionIsCOSStream_thenReturnCOSStream() {
    // Arrange
    COSStream function = new COSStream();

    // Act and Assert
    assertSame(function, (new PDFunctionType0(function)).getCOSObject());
  }

  /**
   * Test {@link PDFunction#getCOSObject()}.
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is
   * {@link COSBoolean#FALSE}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject(); given PDFunctionType0(COSBase) with function is FALSE; then return 'null'")
  void testGetCOSObject_givenPDFunctionType0WithFunctionIsFalse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDFunctionType0(COSBoolean.FALSE)).getCOSObject());
  }

  /**
   * Test {@link PDFunction#getPDStream()}.
   * <p>
   * Method under test: {@link PDFunction#getPDStream()}
   */
  @Test
  @DisplayName("Test getPDStream()")
  void testGetPDStream() {
    // Arrange, Act and Assert
    assertNull((new PDFunctionType0(COSBoolean.FALSE)).getPDStream());
  }

  /**
   * Test {@link PDFunction#create(COSBase)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase); given COSObjectKey(long, int) with num is one and gen is one")
  void testCreate_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    COSObject function = new COSObject((COSBase) null,
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
    function.setKey(new COSObjectKey(1L, 1));

    // Act and Assert
    assertThrows(IOException.class, () -> PDFunction.create(function));
  }

  /**
   * Test {@link PDFunction#create(COSBase)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase); when COSDictionary(); then throw IOException")
  void testCreate_whenCOSDictionary_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDFunction.create(new COSDictionary()));
  }

  /**
   * Test {@link PDFunction#create(COSBase)}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen
   * is one.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase); when COSObjectKey(long, int) with num is one and gen is one; then throw IOException")
  void testCreate_whenCOSObjectKeyWithNumIsOneAndGenIsOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDFunction.create(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1))));
  }

  /**
   * Test {@link PDFunction#create(COSBase)}.
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, ICOSParser)} with object is
   * {@code null} and parser is {@code null}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase); when COSObject(COSBase, ICOSParser) with object is 'null' and parser is 'null'; then throw IOException")
  void testCreate_whenCOSObjectWithObjectIsNullAndParserIsNull_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDFunction.create(new COSObject((COSBase) null, (ICOSParser) null)));
  }

  /**
   * Test {@link PDFunction#create(COSBase)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase); when COSStream(); then throw IOException")
  void testCreate_whenCOSStream_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDFunction.create(new COSStream()));
  }

  /**
   * Test {@link PDFunction#create(COSBase)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase); when FALSE; then throw IOException")
  void testCreate_whenFalse_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDFunction.create(COSBoolean.FALSE));
  }

  /**
   * Test {@link PDFunction#create(COSBase)}.
   * <ul>
   *   <li>When {@link COSName#IDENTITY}.</li>
   *   <li>Then return {@link PDFunctionTypeIdentity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase); when IDENTITY; then return PDFunctionTypeIdentity")
  void testCreate_whenIdentity_thenReturnPDFunctionTypeIdentity() throws IOException {
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
   * Test {@link PDFunction#create(COSBase)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase); when 'null'; then throw IOException")
  void testCreate_whenNull_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDFunction.create(null));
  }

  /**
   * Test {@link PDFunction#getNumberOfOutputParameters()}.
   * <p>
   * Method under test: {@link PDFunction#getNumberOfOutputParameters()}
   */
  @Test
  @DisplayName("Test getNumberOfOutputParameters()")
  void testGetNumberOfOutputParameters() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setRangeValues(new COSArray());

    // Act and Assert
    assertEquals(0, pdFunctionType0.getNumberOfOutputParameters());
  }

  /**
   * Test {@link PDFunction#getNumberOfOutputParameters()}.
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#getNumberOfOutputParameters()}
   */
  @Test
  @DisplayName("Test getNumberOfOutputParameters(); given PDFunctionType0(COSBase) with function is COSDictionary()")
  void testGetNumberOfOutputParameters_givenPDFunctionType0WithFunctionIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDFunctionType0(new COSDictionary())).getNumberOfOutputParameters());
  }

  /**
   * Test {@link PDFunction#getNumberOfOutputParameters()}.
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#getNumberOfOutputParameters()}
   */
  @Test
  @DisplayName("Test getNumberOfOutputParameters(); given PDFunctionType0(COSBase) with function is COSStream()")
  void testGetNumberOfOutputParameters_givenPDFunctionType0WithFunctionIsCOSStream() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDFunctionType0(new COSStream())).getNumberOfOutputParameters());
  }

  /**
   * Test {@link PDFunction#getRangeForOutput(int)}.
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#getRangeForOutput(int)}
   */
  @Test
  @DisplayName("Test getRangeForOutput(int); given PDFunctionType0(COSBase) with function is COSDictionary()")
  void testGetRangeForOutput_givenPDFunctionType0WithFunctionIsCOSDictionary() {
    // Arrange and Act
    PDRange actualRangeForOutput = (new PDFunctionType0(new COSDictionary())).getRangeForOutput(1);

    // Assert
    assertNull(actualRangeForOutput.getCOSArray());
    assertNull(actualRangeForOutput.getCOSObject());
  }

  /**
   * Test {@link PDFunction#getRangeForOutput(int)}.
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#getRangeForOutput(int)}
   */
  @Test
  @DisplayName("Test getRangeForOutput(int); given PDFunctionType0(COSBase) with function is COSStream()")
  void testGetRangeForOutput_givenPDFunctionType0WithFunctionIsCOSStream() {
    // Arrange and Act
    PDRange actualRangeForOutput = (new PDFunctionType0(new COSStream())).getRangeForOutput(1);

    // Assert
    assertNull(actualRangeForOutput.getCOSArray());
    assertNull(actualRangeForOutput.getCOSObject());
  }

  /**
   * Test {@link PDFunction#getRangeForOutput(int)}.
   * <ul>
   *   <li>Then return COSArray toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#getRangeForOutput(int)}
   */
  @Test
  @DisplayName("Test getRangeForOutput(int); then return COSArray toList Empty")
  void testGetRangeForOutput_thenReturnCOSArrayToListEmpty() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
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
   * Test {@link PDFunction#setRangeValues(COSArray)}.
   * <p>
   * Method under test: {@link PDFunction#setRangeValues(COSArray)}
   */
  @Test
  @DisplayName("Test setRangeValues(COSArray)")
  void testSetRangeValues() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    COSArray rangeValues = new COSArray();

    // Act
    pdFunctionType0.setRangeValues(rangeValues);

    // Assert
    COSDictionary cOSObject = pdFunctionType0.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(rangeValues, pdFunctionType0.getRangeValues());
  }

  /**
   * Test {@link PDFunction#setRangeValues(COSArray)}.
   * <p>
   * Method under test: {@link PDFunction#setRangeValues(COSArray)}
   */
  @Test
  @DisplayName("Test setRangeValues(COSArray)")
  void testSetRangeValues2() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());

    // Act
    pdFunctionType0.setRangeValues(null);

    // Assert
    assertNull(pdFunctionType0.getRangeValues());
    COSDictionary cOSObject = pdFunctionType0.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDFunction#setRangeValues(COSArray)}.
   * <ul>
   *   <li>Then {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is
   * {@link COSStream#COSStream()} COSObject {@link COSStream}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#setRangeValues(COSArray)}
   */
  @Test
  @DisplayName("Test setRangeValues(COSArray); then PDFunctionType0(COSBase) with function is COSStream() COSObject COSStream")
  void testSetRangeValues_thenPDFunctionType0WithFunctionIsCOSStreamCOSObjectCOSStream() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSStream());
    COSArray rangeValues = new COSArray();

    // Act
    pdFunctionType0.setRangeValues(rangeValues);

    // Assert
    COSDictionary cOSObject = pdFunctionType0.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(rangeValues, pdFunctionType0.getRangeValues());
  }

  /**
   * Test {@link PDFunction#getNumberOfInputParameters()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#getNumberOfInputParameters()}
   */
  @Test
  @DisplayName("Test getNumberOfInputParameters(); then return zero")
  void testGetNumberOfInputParameters_thenReturnZero() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setDomainValues(new COSArray());

    // Act and Assert
    assertEquals(0, pdFunctionType0.getNumberOfInputParameters());
  }

  /**
   * Test {@link PDFunction#getDomainForInput(int)}.
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#getDomainForInput(int)}
   */
  @Test
  @DisplayName("Test getDomainForInput(int); given PDFunctionType0(COSBase) with function is COSDictionary()")
  void testGetDomainForInput_givenPDFunctionType0WithFunctionIsCOSDictionary() {
    // Arrange and Act
    PDRange actualDomainForInput = (new PDFunctionType0(new COSDictionary())).getDomainForInput(1);

    // Assert
    assertNull(actualDomainForInput.getCOSArray());
    assertNull(actualDomainForInput.getCOSObject());
  }

  /**
   * Test {@link PDFunction#getDomainForInput(int)}.
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#getDomainForInput(int)}
   */
  @Test
  @DisplayName("Test getDomainForInput(int); given PDFunctionType0(COSBase) with function is COSStream()")
  void testGetDomainForInput_givenPDFunctionType0WithFunctionIsCOSStream() {
    // Arrange and Act
    PDRange actualDomainForInput = (new PDFunctionType0(new COSStream())).getDomainForInput(1);

    // Assert
    assertNull(actualDomainForInput.getCOSArray());
    assertNull(actualDomainForInput.getCOSObject());
  }

  /**
   * Test {@link PDFunction#getDomainForInput(int)}.
   * <ul>
   *   <li>Then return COSArray toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#getDomainForInput(int)}
   */
  @Test
  @DisplayName("Test getDomainForInput(int); then return COSArray toList Empty")
  void testGetDomainForInput_thenReturnCOSArrayToListEmpty() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
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
   * Test {@link PDFunction#setDomainValues(COSArray)}.
   * <p>
   * Method under test: {@link PDFunction#setDomainValues(COSArray)}
   */
  @Test
  @DisplayName("Test setDomainValues(COSArray)")
  void testSetDomainValues() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());

    // Act
    pdFunctionType0.setDomainValues(new COSArray());

    // Assert
    assertEquals(0, pdFunctionType0.getNumberOfInputParameters());
    COSDictionary cOSObject = pdFunctionType0.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDFunction#setDomainValues(COSArray)}.
   * <p>
   * Method under test: {@link PDFunction#setDomainValues(COSArray)}
   */
  @Test
  @DisplayName("Test setDomainValues(COSArray)")
  void testSetDomainValues2() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());

    // Act
    pdFunctionType0.setDomainValues(null);

    // Assert
    COSDictionary cOSObject = pdFunctionType0.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDFunction#setDomainValues(COSArray)}.
   * <ul>
   *   <li>Then {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is
   * {@link COSStream#COSStream()} COSObject {@link COSStream}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#setDomainValues(COSArray)}
   */
  @Test
  @DisplayName("Test setDomainValues(COSArray); then PDFunctionType0(COSBase) with function is COSStream() COSObject COSStream")
  void testSetDomainValues_thenPDFunctionType0WithFunctionIsCOSStreamCOSObjectCOSStream() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSStream());

    // Act
    pdFunctionType0.setDomainValues(new COSArray());

    // Assert
    COSDictionary cOSObject = pdFunctionType0.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(0, pdFunctionType0.getNumberOfInputParameters());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDFunction#getRangeValues()}.
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#getRangeValues()}
   */
  @Test
  @DisplayName("Test getRangeValues(); given PDFunctionType0(COSBase) with function is COSDictionary()")
  void testGetRangeValues_givenPDFunctionType0WithFunctionIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDFunctionType0(new COSDictionary())).getRangeValues());
  }

  /**
   * Test {@link PDFunction#getRangeValues()}.
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is
   * {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#getRangeValues()}
   */
  @Test
  @DisplayName("Test getRangeValues(); given PDFunctionType0(COSBase) with function is COSStream(); then return 'null'")
  void testGetRangeValues_givenPDFunctionType0WithFunctionIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDFunctionType0(new COSStream())).getRangeValues());
  }

  /**
   * Test {@link PDFunction#getRangeValues()}.
   * <ul>
   *   <li>Then return toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#getRangeValues()}
   */
  @Test
  @DisplayName("Test getRangeValues(); then return toList Empty")
  void testGetRangeValues_thenReturnToListEmpty() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    COSArray rangeValues = new COSArray();
    pdFunctionType0.setRangeValues(rangeValues);

    // Act
    COSArray actualRangeValues = pdFunctionType0.getRangeValues();

    // Assert
    assertTrue(actualRangeValues.toList().isEmpty());
    assertSame(rangeValues, actualRangeValues);
  }

  /**
   * Test {@link PDFunction#clipToRange(float[])} with {@code inputValues}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  @DisplayName("Test clipToRange(float[]) with 'inputValues'; given COSArray() add FALSE; then return array length is zero")
  void testClipToRangeWithInputValues_givenCOSArrayAddFalse_thenReturnArrayLengthIsZero() {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSBoolean.FALSE);

    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setRangeValues(rangeValues);

    // Act and Assert
    assertEquals(0, pdFunctionType0.clipToRange(new float[]{10.0f, 0.5f, 10.0f, 0.5f}).length);
  }

  /**
   * Test {@link PDFunction#clipToRange(float[])} with {@code inputValues}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSFloat#ONE}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  @DisplayName("Test clipToRange(float[]) with 'inputValues'; given COSArray() add ONE; then return array length is zero")
  void testClipToRangeWithInputValues_givenCOSArrayAddOne_thenReturnArrayLengthIsZero() {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSFloat.ONE);

    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setRangeValues(rangeValues);

    // Act and Assert
    assertEquals(0, pdFunctionType0.clipToRange(new float[]{10.0f, 0.5f, 10.0f, 0.5f}).length);
  }

  /**
   * Test {@link PDFunction#clipToRange(float[])} with {@code inputValues}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSInteger#ONE}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  @DisplayName("Test clipToRange(float[]) with 'inputValues'; given COSArray() add ONE; then return array length is zero")
  void testClipToRangeWithInputValues_givenCOSArrayAddOne_thenReturnArrayLengthIsZero2() {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSInteger.ONE);

    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setRangeValues(rangeValues);

    // Act and Assert
    assertEquals(0, pdFunctionType0.clipToRange(new float[]{10.0f, 0.5f, 10.0f, 0.5f}).length);
  }

  /**
   * Test {@link PDFunction#clipToRange(float[])} with {@code inputValues}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  @DisplayName("Test clipToRange(float[]) with 'inputValues'; given COSObjectKey(long, int) with num is one and gen is one")
  void testClipToRangeWithInputValues_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add((COSBase) new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setRangeValues(rangeValues);

    // Act and Assert
    assertEquals(0, pdFunctionType0.clipToRange(new float[]{10.0f, 0.5f, 10.0f, 0.5f}).length);
  }

  /**
   * Test {@link PDFunction#clipToRange(float[])} with {@code inputValues}.
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  @DisplayName("Test clipToRange(float[]) with 'inputValues'; given PDFunctionType0(COSBase) with function is COSDictionary()")
  void testClipToRangeWithInputValues_givenPDFunctionType0WithFunctionIsCOSDictionary() {
    // Arrange
    float[] inputValues = new float[]{10.0f, 0.5f, 10.0f, 0.5f};

    // Act and Assert
    assertSame(inputValues, (new PDFunctionType0(new COSDictionary())).clipToRange(inputValues));
  }

  /**
   * Test {@link PDFunction#clipToRange(float[])} with {@code inputValues}.
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  @DisplayName("Test clipToRange(float[]) with 'inputValues'; given PDFunctionType0(COSBase) with function is COSStream()")
  void testClipToRangeWithInputValues_givenPDFunctionType0WithFunctionIsCOSStream() {
    // Arrange
    float[] inputValues = new float[]{10.0f, 0.5f, 10.0f, 0.5f};

    // Act and Assert
    assertSame(inputValues, (new PDFunctionType0(new COSStream())).clipToRange(inputValues));
  }

  /**
   * Test {@link PDFunction#clipToRange(float[])} with {@code inputValues}.
   * <ul>
   *   <li>Then return array of {@code float} with forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  @DisplayName("Test clipToRange(float[]) with 'inputValues'; then return array of float with forty-two")
  void testClipToRangeWithInputValues_thenReturnArrayOfFloatWithFortyTwo() {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSInteger.get(42L));
    rangeValues.add(COSBoolean.FALSE);

    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setRangeValues(rangeValues);

    // Act and Assert
    assertArrayEquals(new float[]{42.0f}, pdFunctionType0.clipToRange(new float[]{10.0f, 0.5f, 10.0f, 0.5f}), 0.0f);
  }

  /**
   * Test {@link PDFunction#clipToRange(float[])} with {@code inputValues}.
   * <ul>
   *   <li>Then return array of {@code float} with ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  @DisplayName("Test clipToRange(float[]) with 'inputValues'; then return array of float with ten")
  void testClipToRangeWithInputValues_thenReturnArrayOfFloatWithTen() {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSBoolean.FALSE);
    rangeValues.add(new COSFloat(10.0f));

    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setRangeValues(rangeValues);

    // Act and Assert
    assertArrayEquals(new float[]{10.0f}, pdFunctionType0.clipToRange(new float[]{10.0f, 0.5f, 10.0f, 0.5f}), 0.0f);
  }

  /**
   * Test {@link PDFunction#clipToRange(float[])} with {@code inputValues}.
   * <ul>
   *   <li>Then return array of {@code float} with ten and {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  @DisplayName("Test clipToRange(float[]) with 'inputValues'; then return array of float with ten and '0.5'")
  void testClipToRangeWithInputValues_thenReturnArrayOfFloatWithTenAnd05() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setRangeValues(new COSArray());
    float[] inputValues = new float[]{10.0f, 0.5f, 10.0f, 0.5f};

    // Act and Assert
    assertSame(inputValues, pdFunctionType0.clipToRange(inputValues));
  }

  /**
   * Test {@link PDFunction#clipToRange(float[])} with {@code inputValues}.
   * <ul>
   *   <li>Then return array of {@code float} with zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  @DisplayName("Test clipToRange(float[]) with 'inputValues'; then return array of float with zero")
  void testClipToRangeWithInputValues_thenReturnArrayOfFloatWithZero() {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSBoolean.FALSE);
    rangeValues.add(COSBoolean.FALSE);

    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setRangeValues(rangeValues);

    // Act and Assert
    assertArrayEquals(new float[]{0.0f}, pdFunctionType0.clipToRange(new float[]{10.0f, 0.5f, 10.0f, 0.5f}), 0.0f);
  }

  /**
   * Test {@link PDFunction#clipToRange(float, float, float)} with {@code x},
   * {@code rangeMin}, {@code rangeMax}.
   * <ul>
   *   <li>When {@code 0.5}.</li>
   *   <li>Then return {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#clipToRange(float, float, float)}
   */
  @Test
  @DisplayName("Test clipToRange(float, float, float) with 'x', 'rangeMin', 'rangeMax'; when '0.5'; then return '0.5'")
  void testClipToRangeWithXRangeMinRangeMax_when05_thenReturn05() {
    // Arrange, Act and Assert
    assertEquals(0.5f, (new PDFunctionType0(COSBoolean.FALSE)).clipToRange(10.0f, 10.0f, 0.5f));
  }

  /**
   * Test {@link PDFunction#clipToRange(float, float, float)} with {@code x},
   * {@code rangeMin}, {@code rangeMax}.
   * <ul>
   *   <li>When {@code 0.5}.</li>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#clipToRange(float, float, float)}
   */
  @Test
  @DisplayName("Test clipToRange(float, float, float) with 'x', 'rangeMin', 'rangeMax'; when '0.5'; then return ten")
  void testClipToRangeWithXRangeMinRangeMax_when05_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10.0f, (new PDFunctionType0(COSBoolean.FALSE)).clipToRange(0.5f, 10.0f, 10.0f));
    assertEquals(10.0f, (new PDFunctionType0(COSBoolean.FALSE)).clipToRange(-0.5f, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDFunction#clipToRange(float, float, float)} with {@code x},
   * {@code rangeMin}, {@code rangeMax}.
   * <ul>
   *   <li>When {@link Float#NaN}.</li>
   *   <li>Then return {@link Float#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#clipToRange(float, float, float)}
   */
  @Test
  @DisplayName("Test clipToRange(float, float, float) with 'x', 'rangeMin', 'rangeMax'; when NaN; then return NaN")
  void testClipToRangeWithXRangeMinRangeMax_whenNaN_thenReturnNaN() {
    // Arrange, Act and Assert
    assertEquals(Float.NaN, (new PDFunctionType0(COSBoolean.FALSE)).clipToRange(Float.NaN, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDFunction#clipToRange(float, float, float)} with {@code x},
   * {@code rangeMin}, {@code rangeMax}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunction#clipToRange(float, float, float)}
   */
  @Test
  @DisplayName("Test clipToRange(float, float, float) with 'x', 'rangeMin', 'rangeMax'; when ten; then return ten")
  void testClipToRangeWithXRangeMinRangeMax_whenTen_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10.0f, (new PDFunctionType0(COSBoolean.FALSE)).clipToRange(10.0f, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDFunction#interpolate(float, float, float, float, float)}.
   * <ul>
   *   <li>When {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFunction#interpolate(float, float, float, float, float)}
   */
  @Test
  @DisplayName("Test interpolate(float, float, float, float, float); when '0.5'")
  void testInterpolate_when05() {
    // Arrange, Act and Assert
    assertEquals(10.0f, (new PDFunctionType0(COSBoolean.FALSE)).interpolate(0.5f, 10.0f, 10.0f, 10.0f, 10.0f));
    assertEquals(10.0f, (new PDFunctionType0(COSBoolean.FALSE)).interpolate(-0.5f, 10.0f, 10.0f, 10.0f, 10.0f));
    assertEquals(10.0f, (new PDFunctionType0(COSBoolean.FALSE)).interpolate(10.0f, 0.5f, 10.0f, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDFunction#interpolate(float, float, float, float, float)}.
   * <ul>
   *   <li>When {@link Float#NaN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFunction#interpolate(float, float, float, float, float)}
   */
  @Test
  @DisplayName("Test interpolate(float, float, float, float, float); when NaN")
  void testInterpolate_whenNaN() {
    // Arrange, Act and Assert
    assertEquals(10.0f, (new PDFunctionType0(COSBoolean.FALSE)).interpolate(Float.NaN, 10.0f, 10.0f, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDFunction#interpolate(float, float, float, float, float)}.
   * <ul>
   *   <li>When ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFunction#interpolate(float, float, float, float, float)}
   */
  @Test
  @DisplayName("Test interpolate(float, float, float, float, float); when ten")
  void testInterpolate_whenTen() {
    // Arrange, Act and Assert
    assertEquals(10.0f, (new PDFunctionType0(COSBoolean.FALSE)).interpolate(10.0f, 10.0f, 10.0f, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDFunction#toString()}.
   * <p>
   * Method under test: {@link PDFunction#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("FunctionType0", (new PDFunctionType0(COSBoolean.FALSE)).toString());
  }
}

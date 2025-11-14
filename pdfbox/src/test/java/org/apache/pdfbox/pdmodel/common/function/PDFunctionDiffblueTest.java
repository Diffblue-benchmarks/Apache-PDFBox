package org.apache.pdfbox.pdmodel.common.function;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
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
import org.apache.pdfbox.io.NonSeekableRandomAccessReadInputStream;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdmodel.common.PDRange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFunctionDiffblueTest {
  /**
   * Test {@link PDFunction#getCOSObject()}.
   *
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is {@link
   *       COSStream#COSStream()}.
   *   <li>Then return {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#getCOSObject()}
   */
  @Test
  @DisplayName(
      "Test getCOSObject(); given PDFunctionType0(COSBase) with function is COSStream(); then return COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDFunction.getCOSObject()"})
  void testGetCOSObject_givenPDFunctionType0WithFunctionIsCOSStream_thenReturnCOSStream() {
    // Arrange
    COSStream function = new COSStream();

    // Act and Assert
    assertSame(function, new PDFunctionType0(function).getCOSObject());
  }

  /**
   * Test {@link PDFunction#getCOSObject()}.
   *
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is {@link
   *       COSBoolean#FALSE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#getCOSObject()}
   */
  @Test
  @DisplayName(
      "Test getCOSObject(); given PDFunctionType0(COSBase) with function is FALSE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDFunction.getCOSObject()"})
  void testGetCOSObject_givenPDFunctionType0WithFunctionIsFalse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDFunctionType0(COSBoolean.FALSE).getCOSObject());
  }

  /**
   * Test {@link PDFunction#getPDStream()}.
   *
   * <p>Method under test: {@link PDFunction#getPDStream()}
   */
  @Test
  @DisplayName("Test getPDStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.common.PDStream PDFunction.getPDStream()"})
  void testGetPDStream() {
    // Arrange, Act and Assert
    assertNull(new PDFunctionType0(COSBoolean.FALSE).getPDStream());
  }

  /**
   * Test {@link PDFunction#create(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int, int)} with num is one and gen is one and
   *       index is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#create(COSBase)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase); when COSObjectKey(long, int, int) with num is one and gen is one and index is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFunction PDFunction.create(COSBase)"})
  void testCreate_whenCOSObjectKeyWithNumIsOneAndGenIsOneAndIndexIsOne() throws IOException {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1, 1);
    NonSeekableRandomAccessReadInputStream source =
        new NonSeekableRandomAccessReadInputStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    COSParser parser = new COSParser(source);

    COSObject function = new COSObject(key, parser);

    // Act and Assert
    assertThrows(IOException.class, () -> PDFunction.create(function));
  }

  /**
   * Test {@link PDFunction#create(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSObjectKey, ICOSParser)} with key is {@link
   *       COSObjectKey#COSObjectKey(long, int)} and parser is {@link
   *       COSParser#COSParser(RandomAccessRead)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#create(COSBase)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase); when COSObject(COSObjectKey, ICOSParser) with key is COSObjectKey(long, int) and parser is COSParser(RandomAccessRead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFunction PDFunction.create(COSBase)"})
  void testCreate_whenCOSObjectWithKeyIsCOSObjectKeyAndParserIsCOSParser() throws IOException {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject function = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));

    // Act and Assert
    assertThrows(IOException.class, () -> PDFunction.create(function));
  }

  /**
   * Test {@link PDFunction#create(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSObjectKey, ICOSParser)} with key is {@link
   *       COSObjectKey#COSObjectKey(long, int)} and parser is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#create(COSBase)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase); when COSObject(COSObjectKey, ICOSParser) with key is COSObjectKey(long, int) and parser is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFunction PDFunction.create(COSBase)"})
  void testCreate_whenCOSObjectWithKeyIsCOSObjectKeyAndParserIsNull() throws IOException {
    // Arrange
    COSObject function = new COSObject(new COSObjectKey(1L, 1), null);

    // Act and Assert
    assertThrows(IOException.class, () -> PDFunction.create(function));
  }

  /**
   * Test {@link PDFunction#create(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link
   *       COSDictionary#COSDictionary()} and objectKey is {@link COSObjectKey#COSObjectKey(long,
   *       int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#create(COSBase)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase); when COSObject(COSBase, COSObjectKey) with object is COSDictionary() and objectKey is COSObjectKey(long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFunction PDFunction.create(COSBase)"})
  void testCreate_whenCOSObjectWithObjectIsCOSDictionaryAndObjectKeyIsCOSObjectKey()
      throws IOException {
    // Arrange
    COSDictionary object = new COSDictionary();
    COSObject function = new COSObject(object, new COSObjectKey(1L, 1));

    // Act and Assert
    assertThrows(IOException.class, () -> PDFunction.create(function));
  }

  /**
   * Test {@link PDFunction#create(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link
   *       COSStream#COSStream()} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#create(COSBase)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase); when COSObject(COSBase, COSObjectKey) with object is COSStream() and objectKey is COSObjectKey(long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFunction PDFunction.create(COSBase)"})
  void testCreate_whenCOSObjectWithObjectIsCOSStreamAndObjectKeyIsCOSObjectKey()
      throws IOException {
    // Arrange
    COSStream object = new COSStream();
    COSObject function = new COSObject(object, new COSObjectKey(1L, 1));

    // Act and Assert
    assertThrows(IOException.class, () -> PDFunction.create(function));
  }

  /**
   * Test {@link PDFunction#create(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link
   *       COSBoolean#FALSE} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#create(COSBase)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase); when COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFunction PDFunction.create(COSBase)"})
  void testCreate_whenCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey() throws IOException {
    // Arrange
    COSObject function = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act and Assert
    assertThrows(IOException.class, () -> PDFunction.create(function));
  }

  /**
   * Test {@link PDFunction#create(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase); when FALSE; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFunction PDFunction.create(COSBase)"})
  void testCreate_whenFalse_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDFunction.create(COSBoolean.FALSE));
  }

  /**
   * Test {@link PDFunction#create(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSName#IDENTITY}.
   *   <li>Then return {@link PDFunctionTypeIdentity}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase); when IDENTITY; then return PDFunctionTypeIdentity")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFunction PDFunction.create(COSBase)"})
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
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase); when 'null'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFunction PDFunction.create(COSBase)"})
  void testCreate_whenNull_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDFunction.create(null));
  }

  /**
   * Test {@link PDFunction#getNumberOfOutputParameters()}.
   *
   * <p>Method under test: {@link PDFunction#getNumberOfOutputParameters()}
   */
  @Test
  @DisplayName("Test getNumberOfOutputParameters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFunction.getNumberOfOutputParameters()"})
  void testGetNumberOfOutputParameters() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setEncodeValues(new COSArray());

    // Act and Assert
    assertEquals(0, pdFunctionType0.getNumberOfOutputParameters());
  }

  /**
   * Test {@link PDFunction#getNumberOfOutputParameters()}.
   *
   * <p>Method under test: {@link PDFunction#getNumberOfOutputParameters()}
   */
  @Test
  @DisplayName("Test getNumberOfOutputParameters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFunction.getNumberOfOutputParameters()"})
  void testGetNumberOfOutputParameters2() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setRangeValues(new COSArray());

    // Act and Assert
    assertEquals(0, pdFunctionType0.getNumberOfOutputParameters());
  }

  /**
   * Test {@link PDFunction#getNumberOfOutputParameters()}.
   *
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#getNumberOfOutputParameters()}
   */
  @Test
  @DisplayName(
      "Test getNumberOfOutputParameters(); given PDFunctionType0(COSBase) with function is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFunction.getNumberOfOutputParameters()"})
  void testGetNumberOfOutputParameters_givenPDFunctionType0WithFunctionIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(0, new PDFunctionType0(new COSDictionary()).getNumberOfOutputParameters());
  }

  /**
   * Test {@link PDFunction#getNumberOfOutputParameters()}.
   *
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is {@link
   *       COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#getNumberOfOutputParameters()}
   */
  @Test
  @DisplayName(
      "Test getNumberOfOutputParameters(); given PDFunctionType0(COSBase) with function is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFunction.getNumberOfOutputParameters()"})
  void testGetNumberOfOutputParameters_givenPDFunctionType0WithFunctionIsCOSStream() {
    // Arrange, Act and Assert
    assertEquals(0, new PDFunctionType0(new COSStream()).getNumberOfOutputParameters());
  }

  /**
   * Test {@link PDFunction#getRangeForOutput(int)}.
   *
   * <p>Method under test: {@link PDFunction#getRangeForOutput(int)}
   */
  @Test
  @DisplayName("Test getRangeForOutput(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRange PDFunction.getRangeForOutput(int)"})
  void testGetRangeForOutput() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setEncodeValues(new COSArray());

    // Act
    PDRange actualRangeForOutput = pdFunctionType0.getRangeForOutput(1);

    // Assert
    assertNull(actualRangeForOutput.getCOSArray());
    assertNull(actualRangeForOutput.getCOSObject());
  }

  /**
   * Test {@link PDFunction#getRangeForOutput(int)}.
   *
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#getRangeForOutput(int)}
   */
  @Test
  @DisplayName(
      "Test getRangeForOutput(int); given PDFunctionType0(COSBase) with function is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRange PDFunction.getRangeForOutput(int)"})
  void testGetRangeForOutput_givenPDFunctionType0WithFunctionIsCOSDictionary() {
    // Arrange and Act
    PDRange actualRangeForOutput = new PDFunctionType0(new COSDictionary()).getRangeForOutput(1);

    // Assert
    assertNull(actualRangeForOutput.getCOSArray());
    assertNull(actualRangeForOutput.getCOSObject());
  }

  /**
   * Test {@link PDFunction#getRangeForOutput(int)}.
   *
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is {@link
   *       COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#getRangeForOutput(int)}
   */
  @Test
  @DisplayName(
      "Test getRangeForOutput(int); given PDFunctionType0(COSBase) with function is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRange PDFunction.getRangeForOutput(int)"})
  void testGetRangeForOutput_givenPDFunctionType0WithFunctionIsCOSStream() {
    // Arrange and Act
    PDRange actualRangeForOutput = new PDFunctionType0(new COSStream()).getRangeForOutput(1);

    // Assert
    assertNull(actualRangeForOutput.getCOSArray());
    assertNull(actualRangeForOutput.getCOSObject());
  }

  /**
   * Test {@link PDFunction#getRangeForOutput(int)}.
   *
   * <ul>
   *   <li>Then return COSArray toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#getRangeForOutput(int)}
   */
  @Test
  @DisplayName("Test getRangeForOutput(int); then return COSArray toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRange PDFunction.getRangeForOutput(int)"})
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
   *
   * <p>Method under test: {@link PDFunction#setRangeValues(COSArray)}
   */
  @Test
  @DisplayName("Test setRangeValues(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFunction.setRangeValues(COSArray)"})
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
   *
   * <p>Method under test: {@link PDFunction#setRangeValues(COSArray)}
   */
  @Test
  @DisplayName("Test setRangeValues(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFunction.setRangeValues(COSArray)"})
  void testSetRangeValues2() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());

    // Act
    pdFunctionType0.setRangeValues(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdFunctionType0.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDFunction#setRangeValues(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#setRangeValues(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setRangeValues(COSArray); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFunction.setRangeValues(COSArray)"})
  void testSetRangeValues_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());

    COSArray rangeValues = new COSArray(new ArrayList<>());
    rangeValues.setDirect(false);
    rangeValues.setKey(new COSObjectKey(1L, 1));

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
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link COSArray#COSArray(List)} with cosObjectables is {@link ArrayList#ArrayList()}
   *       Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#setRangeValues(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setRangeValues(COSArray); given 'null'; when COSArray(List) with cosObjectables is ArrayList() Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFunction.setRangeValues(COSArray)"})
  void testSetRangeValues_givenNull_whenCOSArrayWithCosObjectablesIsArrayListKeyIsNull() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());

    COSArray rangeValues = new COSArray(new ArrayList<>());
    rangeValues.setDirect(false);
    rangeValues.setKey(null);

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
   *
   * <ul>
   *   <li>Then {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is {@link
   *       COSStream#COSStream()} COSObject {@link COSStream}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#setRangeValues(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setRangeValues(COSArray); then PDFunctionType0(COSBase) with function is COSStream() COSObject COSStream")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFunction.setRangeValues(COSArray)"})
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
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#getNumberOfInputParameters()}
   */
  @Test
  @DisplayName("Test getNumberOfInputParameters(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFunction.getNumberOfInputParameters()"})
  void testGetNumberOfInputParameters_thenReturnZero() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setDomainValues(new COSArray());

    // Act and Assert
    assertEquals(0, pdFunctionType0.getNumberOfInputParameters());
  }

  /**
   * Test {@link PDFunction#getDomainForInput(int)}.
   *
   * <p>Method under test: {@link PDFunction#getDomainForInput(int)}
   */
  @Test
  @DisplayName("Test getDomainForInput(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRange PDFunction.getDomainForInput(int)"})
  void testGetDomainForInput() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setEncodeValues(new COSArray());

    // Act
    PDRange actualDomainForInput = pdFunctionType0.getDomainForInput(1);

    // Assert
    assertNull(actualDomainForInput.getCOSArray());
    assertNull(actualDomainForInput.getCOSObject());
  }

  /**
   * Test {@link PDFunction#getDomainForInput(int)}.
   *
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#getDomainForInput(int)}
   */
  @Test
  @DisplayName(
      "Test getDomainForInput(int); given PDFunctionType0(COSBase) with function is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRange PDFunction.getDomainForInput(int)"})
  void testGetDomainForInput_givenPDFunctionType0WithFunctionIsCOSDictionary() {
    // Arrange and Act
    PDRange actualDomainForInput = new PDFunctionType0(new COSDictionary()).getDomainForInput(1);

    // Assert
    assertNull(actualDomainForInput.getCOSArray());
    assertNull(actualDomainForInput.getCOSObject());
  }

  /**
   * Test {@link PDFunction#getDomainForInput(int)}.
   *
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is {@link
   *       COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#getDomainForInput(int)}
   */
  @Test
  @DisplayName(
      "Test getDomainForInput(int); given PDFunctionType0(COSBase) with function is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRange PDFunction.getDomainForInput(int)"})
  void testGetDomainForInput_givenPDFunctionType0WithFunctionIsCOSStream() {
    // Arrange and Act
    PDRange actualDomainForInput = new PDFunctionType0(new COSStream()).getDomainForInput(1);

    // Assert
    assertNull(actualDomainForInput.getCOSArray());
    assertNull(actualDomainForInput.getCOSObject());
  }

  /**
   * Test {@link PDFunction#getDomainForInput(int)}.
   *
   * <ul>
   *   <li>Then return COSArray toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#getDomainForInput(int)}
   */
  @Test
  @DisplayName("Test getDomainForInput(int); then return COSArray toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRange PDFunction.getDomainForInput(int)"})
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
   *
   * <p>Method under test: {@link PDFunction#setDomainValues(COSArray)}
   */
  @Test
  @DisplayName("Test setDomainValues(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFunction.setDomainValues(COSArray)"})
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
   *
   * <p>Method under test: {@link PDFunction#setDomainValues(COSArray)}
   */
  @Test
  @DisplayName("Test setDomainValues(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFunction.setDomainValues(COSArray)"})
  void testSetDomainValues2() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());

    // Act
    pdFunctionType0.setDomainValues(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdFunctionType0.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDFunction#setDomainValues(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#setDomainValues(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setDomainValues(COSArray); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFunction.setDomainValues(COSArray)"})
  void testSetDomainValues_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());

    COSArray domainValues = new COSArray(new ArrayList<>());
    domainValues.setDirect(false);
    domainValues.setKey(new COSObjectKey(1L, 1));

    // Act
    pdFunctionType0.setDomainValues(domainValues);

    // Assert
    assertEquals(0, pdFunctionType0.getNumberOfInputParameters());
    COSDictionary cOSObject = pdFunctionType0.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDFunction#setDomainValues(COSArray)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link COSArray#COSArray(List)} with cosObjectables is {@link ArrayList#ArrayList()}
   *       Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#setDomainValues(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setDomainValues(COSArray); given 'null'; when COSArray(List) with cosObjectables is ArrayList() Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFunction.setDomainValues(COSArray)"})
  void testSetDomainValues_givenNull_whenCOSArrayWithCosObjectablesIsArrayListKeyIsNull() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());

    COSArray domainValues = new COSArray(new ArrayList<>());
    domainValues.setDirect(false);
    domainValues.setKey(null);

    // Act
    pdFunctionType0.setDomainValues(domainValues);

    // Assert
    assertEquals(0, pdFunctionType0.getNumberOfInputParameters());
    COSDictionary cOSObject = pdFunctionType0.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDFunction#setDomainValues(COSArray)}.
   *
   * <ul>
   *   <li>Then {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is {@link
   *       COSStream#COSStream()} COSObject {@link COSStream}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#setDomainValues(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setDomainValues(COSArray); then PDFunctionType0(COSBase) with function is COSStream() COSObject COSStream")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFunction.setDomainValues(COSArray)"})
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
   *
   * <p>Method under test: {@link PDFunction#getRangeValues()}
   */
  @Test
  @DisplayName("Test getRangeValues()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray PDFunction.getRangeValues()"})
  void testGetRangeValues() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setEncodeValues(new COSArray());

    // Act and Assert
    assertNull(pdFunctionType0.getRangeValues());
  }

  /**
   * Test {@link PDFunction#getRangeValues()}.
   *
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#getRangeValues()}
   */
  @Test
  @DisplayName(
      "Test getRangeValues(); given PDFunctionType0(COSBase) with function is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray PDFunction.getRangeValues()"})
  void testGetRangeValues_givenPDFunctionType0WithFunctionIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new PDFunctionType0(new COSDictionary()).getRangeValues());
  }

  /**
   * Test {@link PDFunction#getRangeValues()}.
   *
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is {@link
   *       COSStream#COSStream()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#getRangeValues()}
   */
  @Test
  @DisplayName(
      "Test getRangeValues(); given PDFunctionType0(COSBase) with function is COSStream(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray PDFunction.getRangeValues()"})
  void testGetRangeValues_givenPDFunctionType0WithFunctionIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDFunctionType0(new COSStream()).getRangeValues());
  }

  /**
   * Test {@link PDFunction#getRangeValues()}.
   *
   * <ul>
   *   <li>Then return toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#getRangeValues()}
   */
  @Test
  @DisplayName("Test getRangeValues(); then return toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray PDFunction.getRangeValues()"})
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
   *
   * <p>Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  @DisplayName("Test clipToRange(float[]) with 'inputValues'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDFunction.clipToRange(float[])"})
  void testClipToRangeWithInputValues() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setEncodeValues(new COSArray());

    // Act
    float[] actualClipToRangeResult =
        pdFunctionType0.clipToRange(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualClipToRangeResult, 0.0f);
  }

  /**
   * Test {@link PDFunction#clipToRange(float[])} with {@code inputValues}.
   *
   * <p>Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  @DisplayName("Test clipToRange(float[]) with 'inputValues'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDFunction.clipToRange(float[])"})
  void testClipToRangeWithInputValues2() {
    // Arrange
    COSArray rangeValues = new COSArray();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    rangeValues.add((COSBase) object);

    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setRangeValues(rangeValues);

    // Act
    float[] actualClipToRangeResult =
        pdFunctionType0.clipToRange(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertArrayEquals(new float[] {}, actualClipToRangeResult, 0.0f);
  }

  /**
   * Test {@link PDFunction#clipToRange(float[])} with {@code inputValues}.
   *
   * <p>Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  @DisplayName("Test clipToRange(float[]) with 'inputValues'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDFunction.clipToRange(float[])"})
  void testClipToRangeWithInputValues3() throws IOException {
    // Arrange
    COSArray rangeValues = new COSArray();
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject object = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
    rangeValues.add((COSBase) object);

    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setRangeValues(rangeValues);

    // Act
    float[] actualClipToRangeResult =
        pdFunctionType0.clipToRange(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertArrayEquals(new float[] {}, actualClipToRangeResult, 0.0f);
  }

  /**
   * Test {@link PDFunction#clipToRange(float[])} with {@code inputValues}.
   *
   * <p>Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  @DisplayName("Test clipToRange(float[]) with 'inputValues'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDFunction.clipToRange(float[])"})
  void testClipToRangeWithInputValues4() {
    // Arrange
    COSArray rangeValues = new COSArray();
    COSObject object = new COSObject(new COSObjectKey(1L, 1), null);
    rangeValues.add((COSBase) object);

    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setRangeValues(rangeValues);

    // Act
    float[] actualClipToRangeResult =
        pdFunctionType0.clipToRange(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertArrayEquals(new float[] {}, actualClipToRangeResult, 0.0f);
  }

  /**
   * Test {@link PDFunction#clipToRange(float[])} with {@code inputValues}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then return empty array of {@code float}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  @DisplayName(
      "Test clipToRange(float[]) with 'inputValues'; given COSArray() add FALSE; then return empty array of float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDFunction.clipToRange(float[])"})
  void testClipToRangeWithInputValues_givenCOSArrayAddFalse_thenReturnEmptyArrayOfFloat() {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSBoolean.FALSE);

    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setRangeValues(rangeValues);

    // Act
    float[] actualClipToRangeResult =
        pdFunctionType0.clipToRange(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertArrayEquals(new float[] {}, actualClipToRangeResult, 0.0f);
  }

  /**
   * Test {@link PDFunction#clipToRange(float[])} with {@code inputValues}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSFloat#ONE}.
   *   <li>Then return empty array of {@code float}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  @DisplayName(
      "Test clipToRange(float[]) with 'inputValues'; given COSArray() add ONE; then return empty array of float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDFunction.clipToRange(float[])"})
  void testClipToRangeWithInputValues_givenCOSArrayAddOne_thenReturnEmptyArrayOfFloat() {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSFloat.ONE);

    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setRangeValues(rangeValues);

    // Act
    float[] actualClipToRangeResult =
        pdFunctionType0.clipToRange(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertArrayEquals(new float[] {}, actualClipToRangeResult, 0.0f);
  }

  /**
   * Test {@link PDFunction#clipToRange(float[])} with {@code inputValues}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSInteger#ONE}.
   *   <li>Then return empty array of {@code float}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  @DisplayName(
      "Test clipToRange(float[]) with 'inputValues'; given COSArray() add ONE; then return empty array of float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDFunction.clipToRange(float[])"})
  void testClipToRangeWithInputValues_givenCOSArrayAddOne_thenReturnEmptyArrayOfFloat2() {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSInteger.ONE);

    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setRangeValues(rangeValues);

    // Act
    float[] actualClipToRangeResult =
        pdFunctionType0.clipToRange(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertArrayEquals(new float[] {}, actualClipToRangeResult, 0.0f);
  }

  /**
   * Test {@link PDFunction#clipToRange(float[])} with {@code inputValues}.
   *
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  @DisplayName(
      "Test clipToRange(float[]) with 'inputValues'; given PDFunctionType0(COSBase) with function is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDFunction.clipToRange(float[])"})
  void testClipToRangeWithInputValues_givenPDFunctionType0WithFunctionIsCOSDictionary() {
    // Arrange and Act
    float[] actualClipToRangeResult =
        new PDFunctionType0(new COSDictionary())
            .clipToRange(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualClipToRangeResult, 0.0f);
  }

  /**
   * Test {@link PDFunction#clipToRange(float[])} with {@code inputValues}.
   *
   * <ul>
   *   <li>Given {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is {@link
   *       COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  @DisplayName(
      "Test clipToRange(float[]) with 'inputValues'; given PDFunctionType0(COSBase) with function is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDFunction.clipToRange(float[])"})
  void testClipToRangeWithInputValues_givenPDFunctionType0WithFunctionIsCOSStream() {
    // Arrange and Act
    float[] actualClipToRangeResult =
        new PDFunctionType0(new COSStream()).clipToRange(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualClipToRangeResult, 0.0f);
  }

  /**
   * Test {@link PDFunction#clipToRange(float[])} with {@code inputValues}.
   *
   * <ul>
   *   <li>Then return array of {@code float} with forty-two.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  @DisplayName(
      "Test clipToRange(float[]) with 'inputValues'; then return array of float with forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDFunction.clipToRange(float[])"})
  void testClipToRangeWithInputValues_thenReturnArrayOfFloatWithFortyTwo() {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSInteger.get(42L));
    rangeValues.add(COSBoolean.FALSE);

    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setRangeValues(rangeValues);

    // Act
    float[] actualClipToRangeResult =
        pdFunctionType0.clipToRange(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertArrayEquals(new float[] {42.0f}, actualClipToRangeResult, 0.0f);
  }

  /**
   * Test {@link PDFunction#clipToRange(float[])} with {@code inputValues}.
   *
   * <ul>
   *   <li>Then return array of {@code float} with ten.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  @DisplayName("Test clipToRange(float[]) with 'inputValues'; then return array of float with ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDFunction.clipToRange(float[])"})
  void testClipToRangeWithInputValues_thenReturnArrayOfFloatWithTen() {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSBoolean.FALSE);
    rangeValues.add(COSInteger.get(42L));
    rangeValues.add(COSBoolean.FALSE);

    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setRangeValues(rangeValues);

    // Act
    float[] actualClipToRangeResult =
        pdFunctionType0.clipToRange(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertArrayEquals(new float[] {10.0f}, actualClipToRangeResult, 0.0f);
  }

  /**
   * Test {@link PDFunction#clipToRange(float[])} with {@code inputValues}.
   *
   * <ul>
   *   <li>Then return array of {@code float} with ten and {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  @DisplayName(
      "Test clipToRange(float[]) with 'inputValues'; then return array of float with ten and '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDFunction.clipToRange(float[])"})
  void testClipToRangeWithInputValues_thenReturnArrayOfFloatWithTenAnd05() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setRangeValues(new COSArray());

    // Act
    float[] actualClipToRangeResult =
        pdFunctionType0.clipToRange(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualClipToRangeResult, 0.0f);
  }

  /**
   * Test {@link PDFunction#clipToRange(float[])} with {@code inputValues}.
   *
   * <ul>
   *   <li>Then return array of {@code float} with zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#clipToRange(float[])}
   */
  @Test
  @DisplayName("Test clipToRange(float[]) with 'inputValues'; then return array of float with zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDFunction.clipToRange(float[])"})
  void testClipToRangeWithInputValues_thenReturnArrayOfFloatWithZero() {
    // Arrange
    COSArray rangeValues = new COSArray();
    rangeValues.add(COSBoolean.FALSE);
    rangeValues.add(COSBoolean.FALSE);

    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSDictionary());
    pdFunctionType0.setRangeValues(rangeValues);

    // Act
    float[] actualClipToRangeResult =
        pdFunctionType0.clipToRange(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertArrayEquals(new float[] {0.0f}, actualClipToRangeResult, 0.0f);
  }

  /**
   * Test {@link PDFunction#clipToRange(float, float, float)} with {@code x}, {@code rangeMin},
   * {@code rangeMax}.
   *
   * <ul>
   *   <li>When {@code 0.5}.
   *   <li>Then return {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#clipToRange(float, float, float)}
   */
  @Test
  @DisplayName(
      "Test clipToRange(float, float, float) with 'x', 'rangeMin', 'rangeMax'; when '0.5'; then return '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFunction.clipToRange(float, float, float)"})
  void testClipToRangeWithXRangeMinRangeMax_when05_thenReturn05() {
    // Arrange, Act and Assert
    assertEquals(0.5f, new PDFunctionType0(COSBoolean.FALSE).clipToRange(10.0f, 10.0f, 0.5f));
  }

  /**
   * Test {@link PDFunction#clipToRange(float, float, float)} with {@code x}, {@code rangeMin},
   * {@code rangeMax}.
   *
   * <ul>
   *   <li>When {@code 0.5}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#clipToRange(float, float, float)}
   */
  @Test
  @DisplayName(
      "Test clipToRange(float, float, float) with 'x', 'rangeMin', 'rangeMax'; when '0.5'; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFunction.clipToRange(float, float, float)"})
  void testClipToRangeWithXRangeMinRangeMax_when05_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10.0f, new PDFunctionType0(COSBoolean.FALSE).clipToRange(0.5f, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDFunction#clipToRange(float, float, float)} with {@code x}, {@code rangeMin},
   * {@code rangeMax}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#clipToRange(float, float, float)}
   */
  @Test
  @DisplayName(
      "Test clipToRange(float, float, float) with 'x', 'rangeMin', 'rangeMax'; when '-0.5'; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFunction.clipToRange(float, float, float)"})
  void testClipToRangeWithXRangeMinRangeMax_when05_thenReturnTen2() {
    // Arrange, Act and Assert
    assertEquals(10.0f, new PDFunctionType0(COSBoolean.FALSE).clipToRange(-0.5f, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDFunction#clipToRange(float, float, float)} with {@code x}, {@code rangeMin},
   * {@code rangeMax}.
   *
   * <ul>
   *   <li>When {@link Float#NaN}.
   *   <li>Then return {@link Float#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#clipToRange(float, float, float)}
   */
  @Test
  @DisplayName(
      "Test clipToRange(float, float, float) with 'x', 'rangeMin', 'rangeMax'; when NaN; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFunction.clipToRange(float, float, float)"})
  void testClipToRangeWithXRangeMinRangeMax_whenNaN_thenReturnNaN() {
    // Arrange, Act and Assert
    assertEquals(
        Float.NaN, new PDFunctionType0(COSBoolean.FALSE).clipToRange(Float.NaN, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDFunction#clipToRange(float, float, float)} with {@code x}, {@code rangeMin},
   * {@code rangeMax}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#clipToRange(float, float, float)}
   */
  @Test
  @DisplayName(
      "Test clipToRange(float, float, float) with 'x', 'rangeMin', 'rangeMax'; when ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFunction.clipToRange(float, float, float)"})
  void testClipToRangeWithXRangeMinRangeMax_whenTen_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10.0f, new PDFunctionType0(COSBoolean.FALSE).clipToRange(10.0f, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDFunction#interpolate(float, float, float, float, float)}.
   *
   * <ul>
   *   <li>When {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#interpolate(float, float, float, float, float)}
   */
  @Test
  @DisplayName("Test interpolate(float, float, float, float, float); when '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFunction.interpolate(float, float, float, float, float)"})
  void testInterpolate_when05() {
    // Arrange, Act and Assert
    assertEquals(
        10.0f, new PDFunctionType0(COSBoolean.FALSE).interpolate(0.5f, 10.0f, 10.0f, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDFunction#interpolate(float, float, float, float, float)}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#interpolate(float, float, float, float, float)}
   */
  @Test
  @DisplayName("Test interpolate(float, float, float, float, float); when '-0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFunction.interpolate(float, float, float, float, float)"})
  void testInterpolate_when052() {
    // Arrange, Act and Assert
    assertEquals(
        10.0f,
        new PDFunctionType0(COSBoolean.FALSE).interpolate(-0.5f, 10.0f, 10.0f, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDFunction#interpolate(float, float, float, float, float)}.
   *
   * <ul>
   *   <li>When {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#interpolate(float, float, float, float, float)}
   */
  @Test
  @DisplayName("Test interpolate(float, float, float, float, float); when '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFunction.interpolate(float, float, float, float, float)"})
  void testInterpolate_when053() {
    // Arrange, Act and Assert
    assertEquals(
        10.0f, new PDFunctionType0(COSBoolean.FALSE).interpolate(10.0f, 0.5f, 10.0f, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDFunction#interpolate(float, float, float, float, float)}.
   *
   * <ul>
   *   <li>When {@link Float#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#interpolate(float, float, float, float, float)}
   */
  @Test
  @DisplayName("Test interpolate(float, float, float, float, float); when NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFunction.interpolate(float, float, float, float, float)"})
  void testInterpolate_whenNaN() {
    // Arrange, Act and Assert
    assertEquals(
        10.0f,
        new PDFunctionType0(COSBoolean.FALSE).interpolate(Float.NaN, 10.0f, 10.0f, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDFunction#interpolate(float, float, float, float, float)}.
   *
   * <ul>
   *   <li>When ten.
   * </ul>
   *
   * <p>Method under test: {@link PDFunction#interpolate(float, float, float, float, float)}
   */
  @Test
  @DisplayName("Test interpolate(float, float, float, float, float); when ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFunction.interpolate(float, float, float, float, float)"})
  void testInterpolate_whenTen() {
    // Arrange, Act and Assert
    assertEquals(
        10.0f,
        new PDFunctionType0(COSBoolean.FALSE).interpolate(10.0f, 10.0f, 10.0f, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDFunction#toString()}.
   *
   * <p>Method under test: {@link PDFunction#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDFunction.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("FunctionType0", new PDFunctionType0(COSBoolean.FALSE).toString());
  }
}

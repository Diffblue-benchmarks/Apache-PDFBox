package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.common.filespecification.PDComplexFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDSimpleFileSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDActionSubmitFormDiffblueTest {
  /**
   * Test {@link PDActionSubmitForm#PDActionSubmitForm(COSDictionary)}.
   * <p>
   * Method under test: {@link PDActionSubmitForm#PDActionSubmitForm(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDActionSubmitForm(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionSubmitForm.<init>(COSDictionary)"})
  void testNewPDActionSubmitForm() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDActionSubmitForm(a)).getCOSObject());
  }

  /**
   * Test {@link PDActionSubmitForm#PDActionSubmitForm()}.
   * <p>
   * Method under test: {@link PDActionSubmitForm#PDActionSubmitForm()}
   */
  @Test
  @DisplayName("Test new PDActionSubmitForm()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionSubmitForm.<init>()"})
  void testNewPDActionSubmitForm2() throws IOException {
    // Arrange and Act
    PDActionSubmitForm actualPdActionSubmitForm = new PDActionSubmitForm();

    // Assert
    assertNull(actualPdActionSubmitForm.getNext());
    assertNull(actualPdActionSubmitForm.getFields());
    COSDictionary cOSObject = actualPdActionSubmitForm.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(actualPdActionSubmitForm.getFile());
    assertEquals(0, actualPdActionSubmitForm.getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualPdActionSubmitForm.getType());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualPdActionSubmitForm.getSubType());
  }

  /**
   * Test {@link PDActionSubmitForm#getFile()}.
   * <ul>
   *   <li>Given {@link PDActionSubmitForm#PDActionSubmitForm()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSubmitForm#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); given PDActionSubmitForm(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDFileSpecification PDActionSubmitForm.getFile()"})
  void testGetFile_givenPDActionSubmitForm_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDActionSubmitForm()).getFile());
  }

  /**
   * Test {@link PDActionSubmitForm#getFile()}.
   * <ul>
   *   <li>Then COSObject return {@link COSString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSubmitForm#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); then COSObject return COSString")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDFileSpecification PDActionSubmitForm.getFile()"})
  void testGetFile_thenCOSObjectReturnCOSString() throws IOException {
    // Arrange
    PDActionSubmitForm pdActionSubmitForm = new PDActionSubmitForm();
    pdActionSubmitForm.setFile(new PDSimpleFileSpecification());

    // Act
    PDFileSpecification actualFile = pdActionSubmitForm.getFile();

    // Assert
    COSBase cOSObject = actualFile.getCOSObject();
    assertTrue(cOSObject instanceof COSString);
    assertTrue(actualFile instanceof PDSimpleFileSpecification);
    assertEquals("", ((COSString) cOSObject).getASCII());
    assertEquals("", ((COSString) cOSObject).getString());
    assertEquals("", ((COSString) cOSObject).toHexString());
    assertEquals("", actualFile.getFile());
    assertNull(cOSObject.getKey());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSString) cOSObject).getForceHexForm());
    assertArrayEquals(new byte[]{}, ((COSString) cOSObject).getBytes());
  }

  /**
   * Test {@link PDActionSubmitForm#getFile()}.
   * <ul>
   *   <li>Then return {@link PDComplexFileSpecification}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSubmitForm#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); then return PDComplexFileSpecification")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDFileSpecification PDActionSubmitForm.getFile()"})
  void testGetFile_thenReturnPDComplexFileSpecification() throws IOException {
    // Arrange
    PDActionSubmitForm pdActionSubmitForm = new PDActionSubmitForm();
    pdActionSubmitForm.setFile(new PDComplexFileSpecification());

    // Act
    PDFileSpecification actualFile = pdActionSubmitForm.getFile();

    // Assert
    assertTrue(actualFile instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) actualFile).getFileDescription());
    assertNull(((PDComplexFileSpecification) actualFile).getFileDos());
    assertNull(((PDComplexFileSpecification) actualFile).getFileMac());
    assertNull(((PDComplexFileSpecification) actualFile).getFileUnicode());
    assertNull(((PDComplexFileSpecification) actualFile).getFileUnix());
    assertNull(((PDComplexFileSpecification) actualFile).getFilename());
    assertNull(actualFile.getFile());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileUnix());
    assertFalse(((PDComplexFileSpecification) actualFile).isVolatile());
  }

  /**
   * Test {@link PDActionSubmitForm#setFile(PDFileSpecification)}.
   * <ul>
   *   <li>Then {@link PDActionSubmitForm#PDActionSubmitForm()} File {@link PDComplexFileSpecification}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSubmitForm#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFile(PDFileSpecification); then PDActionSubmitForm() File PDComplexFileSpecification")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionSubmitForm.setFile(PDFileSpecification)"})
  void testSetFile_thenPDActionSubmitFormFilePDComplexFileSpecification() throws IOException {
    // Arrange
    PDActionSubmitForm pdActionSubmitForm = new PDActionSubmitForm();

    // Act
    pdActionSubmitForm.setFile(new PDComplexFileSpecification());

    // Assert
    PDFileSpecification file = pdActionSubmitForm.getFile();
    assertTrue(file instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) file).getFileDescription());
    assertNull(((PDComplexFileSpecification) file).getFileDos());
    assertNull(((PDComplexFileSpecification) file).getFileMac());
    assertNull(((PDComplexFileSpecification) file).getFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getFileUnix());
    assertNull(((PDComplexFileSpecification) file).getFilename());
    assertNull(file.getFile());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnix());
    assertFalse(((PDComplexFileSpecification) file).isVolatile());
  }

  /**
   * Test {@link PDActionSubmitForm#setFile(PDFileSpecification)}.
   * <ul>
   *   <li>Then {@link PDActionSubmitForm#PDActionSubmitForm()} File {@link PDSimpleFileSpecification}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSubmitForm#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFile(PDFileSpecification); then PDActionSubmitForm() File PDSimpleFileSpecification")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionSubmitForm.setFile(PDFileSpecification)"})
  void testSetFile_thenPDActionSubmitFormFilePDSimpleFileSpecification() throws IOException {
    // Arrange
    PDActionSubmitForm pdActionSubmitForm = new PDActionSubmitForm();

    // Act
    pdActionSubmitForm.setFile(new PDSimpleFileSpecification());

    // Assert
    PDFileSpecification file = pdActionSubmitForm.getFile();
    assertTrue(file instanceof PDSimpleFileSpecification);
    assertEquals("", file.getFile());
    COSDictionary cOSObject = pdActionSubmitForm.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionSubmitForm#setFile(PDFileSpecification)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDActionSubmitForm#PDActionSubmitForm()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSubmitForm#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFile(PDFileSpecification); when 'null'; then PDActionSubmitForm() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionSubmitForm.setFile(PDFileSpecification)"})
  void testSetFile_whenNull_thenPDActionSubmitFormCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionSubmitForm pdActionSubmitForm = new PDActionSubmitForm();

    // Act
    pdActionSubmitForm.setFile(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionSubmitForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionSubmitForm#getFields()}.
   * <ul>
   *   <li>Given {@link PDActionSubmitForm#PDActionSubmitForm()} Fields is {@link COSArray#COSArray()}.</li>
   *   <li>Then return toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSubmitForm#getFields()}
   */
  @Test
  @DisplayName("Test getFields(); given PDActionSubmitForm() Fields is COSArray(); then return toList Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSArray PDActionSubmitForm.getFields()"})
  void testGetFields_givenPDActionSubmitFormFieldsIsCOSArray_thenReturnToListEmpty() {
    // Arrange
    PDActionSubmitForm pdActionSubmitForm = new PDActionSubmitForm();
    COSArray array = new COSArray();
    pdActionSubmitForm.setFields(array);

    // Act
    COSArray actualFields = pdActionSubmitForm.getFields();

    // Assert
    assertTrue(actualFields.toList().isEmpty());
    assertSame(array, actualFields);
  }

  /**
   * Test {@link PDActionSubmitForm#getFields()}.
   * <ul>
   *   <li>Given {@link PDActionSubmitForm#PDActionSubmitForm()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSubmitForm#getFields()}
   */
  @Test
  @DisplayName("Test getFields(); given PDActionSubmitForm(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSArray PDActionSubmitForm.getFields()"})
  void testGetFields_givenPDActionSubmitForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDActionSubmitForm()).getFields());
  }

  /**
   * Test {@link PDActionSubmitForm#setFields(COSArray)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSubmitForm#setFields(COSArray)}
   */
  @Test
  @DisplayName("Test setFields(COSArray); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionSubmitForm.setFields(COSArray)"})
  void testSetFields_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDActionSubmitForm pdActionSubmitForm = new PDActionSubmitForm();

    COSArray array = new COSArray();
    array.setKey(new COSObjectKey(1L, 1));
    array.setDirect(false);

    // Act
    pdActionSubmitForm.setFields(array);

    // Assert
    COSDictionary cOSObject = pdActionSubmitForm.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(array, pdActionSubmitForm.getFields());
  }

  /**
   * Test {@link PDActionSubmitForm#setFields(COSArray)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link COSArray#COSArray()} Direct is {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSubmitForm#setFields(COSArray)}
   */
  @Test
  @DisplayName("Test setFields(COSArray); given 'false'; when COSArray() Direct is 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionSubmitForm.setFields(COSArray)"})
  void testSetFields_givenFalse_whenCOSArrayDirectIsFalse() {
    // Arrange
    PDActionSubmitForm pdActionSubmitForm = new PDActionSubmitForm();

    COSArray array = new COSArray();
    array.setDirect(false);

    // Act
    pdActionSubmitForm.setFields(array);

    // Assert
    COSDictionary cOSObject = pdActionSubmitForm.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(array, pdActionSubmitForm.getFields());
  }

  /**
   * Test {@link PDActionSubmitForm#setFields(COSArray)}.
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then {@link PDActionSubmitForm#PDActionSubmitForm()} COSObject Values size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSubmitForm#setFields(COSArray)}
   */
  @Test
  @DisplayName("Test setFields(COSArray); when COSArray(); then PDActionSubmitForm() COSObject Values size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionSubmitForm.setFields(COSArray)"})
  void testSetFields_whenCOSArray_thenPDActionSubmitFormCOSObjectValuesSizeIsThree() {
    // Arrange
    PDActionSubmitForm pdActionSubmitForm = new PDActionSubmitForm();
    COSArray array = new COSArray();

    // Act
    pdActionSubmitForm.setFields(array);

    // Assert
    COSDictionary cOSObject = pdActionSubmitForm.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(array, pdActionSubmitForm.getFields());
  }

  /**
   * Test {@link PDActionSubmitForm#setFields(COSArray)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDActionSubmitForm#PDActionSubmitForm()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSubmitForm#setFields(COSArray)}
   */
  @Test
  @DisplayName("Test setFields(COSArray); when 'null'; then PDActionSubmitForm() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionSubmitForm.setFields(COSArray)"})
  void testSetFields_whenNull_thenPDActionSubmitFormCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionSubmitForm pdActionSubmitForm = new PDActionSubmitForm();

    // Act
    pdActionSubmitForm.setFields(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionSubmitForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionSubmitForm#getFlags()}.
   * <ul>
   *   <li>Given {@link PDActionSubmitForm#PDActionSubmitForm()} Flags is one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSubmitForm#getFlags()}
   */
  @Test
  @DisplayName("Test getFlags(); given PDActionSubmitForm() Flags is one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDActionSubmitForm.getFlags()"})
  void testGetFlags_givenPDActionSubmitFormFlagsIsOne_thenReturnOne() {
    // Arrange
    PDActionSubmitForm pdActionSubmitForm = new PDActionSubmitForm();
    pdActionSubmitForm.setFlags(1);

    // Act and Assert
    assertEquals(1, pdActionSubmitForm.getFlags());
  }

  /**
   * Test {@link PDActionSubmitForm#getFlags()}.
   * <ul>
   *   <li>Given {@link PDActionSubmitForm#PDActionSubmitForm()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSubmitForm#getFlags()}
   */
  @Test
  @DisplayName("Test getFlags(); given PDActionSubmitForm(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDActionSubmitForm.getFlags()"})
  void testGetFlags_givenPDActionSubmitForm_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDActionSubmitForm()).getFlags());
  }

  /**
   * Test {@link PDActionSubmitForm#setFlags(int)}.
   * <ul>
   *   <li>Given {@link PDActionSubmitForm#PDActionSubmitForm()}.</li>
   *   <li>When one.</li>
   *   <li>Then {@link PDActionSubmitForm#PDActionSubmitForm()} Flags is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSubmitForm#setFlags(int)}
   */
  @Test
  @DisplayName("Test setFlags(int); given PDActionSubmitForm(); when one; then PDActionSubmitForm() Flags is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionSubmitForm.setFlags(int)"})
  void testSetFlags_givenPDActionSubmitForm_whenOne_thenPDActionSubmitFormFlagsIsOne() {
    // Arrange
    PDActionSubmitForm pdActionSubmitForm = new PDActionSubmitForm();

    // Act
    pdActionSubmitForm.setFlags(1);

    // Assert
    assertEquals(1, pdActionSubmitForm.getFlags());
    COSDictionary cOSObject = pdActionSubmitForm.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionSubmitForm#setFlags(int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then {@link PDActionSubmitForm#PDActionSubmitForm()} Flags is {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSubmitForm#setFlags(int)}
   */
  @Test
  @DisplayName("Test setFlags(int); when MIN_VALUE; then PDActionSubmitForm() Flags is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionSubmitForm.setFlags(int)"})
  void testSetFlags_whenMin_value_thenPDActionSubmitFormFlagsIsMin_value() {
    // Arrange
    PDActionSubmitForm pdActionSubmitForm = new PDActionSubmitForm();

    // Act
    pdActionSubmitForm.setFlags(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdActionSubmitForm.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdActionSubmitForm.getFlags());
  }
}

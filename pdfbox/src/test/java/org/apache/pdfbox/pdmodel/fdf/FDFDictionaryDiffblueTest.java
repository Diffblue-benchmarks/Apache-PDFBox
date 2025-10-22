package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.github.jaiimageio.impl.plugins.tiff.TIFFFieldNode;
import com.github.jaiimageio.plugins.tiff.TIFFField;
import com.github.jaiimageio.plugins.tiff.TIFFTag;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.filespecification.PDComplexFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDSimpleFileSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

class FDFDictionaryDiffblueTest {
  /**
   * Test {@link FDFDictionary#FDFDictionary(COSDictionary)}.
   * <p>
   * Method under test: {@link FDFDictionary#FDFDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFDictionary(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.<init>(COSDictionary)"})
  void testNewFDFDictionary() {
    // Arrange
    COSDictionary fdfDictionary = new COSDictionary();

    // Act and Assert
    assertSame(fdfDictionary, (new FDFDictionary(fdfDictionary)).getCOSObject());
  }

  /**
   * Test {@link FDFDictionary#FDFDictionary()}.
   * <p>
   * Method under test: {@link FDFDictionary#FDFDictionary()}
   */
  @Test
  @DisplayName("Test new FDFDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.<init>()"})
  void testNewFDFDictionary2() throws IOException {
    // Arrange and Act
    FDFDictionary actualFdfDictionary = new FDFDictionary();

    // Assert
    assertEquals("PDFDocEncoding", actualFdfDictionary.getEncoding());
    assertNull(actualFdfDictionary.getStatus());
    assertNull(actualFdfDictionary.getTarget());
    assertNull(actualFdfDictionary.getEmbeddedFDFs());
    assertNull(actualFdfDictionary.getAnnotations());
    assertNull(actualFdfDictionary.getFields());
    assertNull(actualFdfDictionary.getPages());
    assertNull(actualFdfDictionary.getID());
    assertNull(actualFdfDictionary.getDifferences());
    assertNull(actualFdfDictionary.getFile());
    assertNull(actualFdfDictionary.getJavaScript());
  }

  /**
   * Test {@link FDFDictionary#FDFDictionary(Element)}.
   * <p>
   * Method under test: {@link FDFDictionary#FDFDictionary(Element)}
   */
  @Test
  @DisplayName("Test new FDFDictionary(Element)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.<init>(Element)"})
  void testNewFDFDictionary3() throws IOException {
    // Arrange and Act
    FDFDictionary actualFdfDictionary = new FDFDictionary(
        new TIFFFieldNode(new TIFFField(new TIFFTag("Name", TIFFTag.TIFF_SRATIONAL, 1), 42)));

    // Assert
    assertEquals("PDFDocEncoding", actualFdfDictionary.getEncoding());
    assertNull(actualFdfDictionary.getStatus());
    assertNull(actualFdfDictionary.getTarget());
    assertNull(actualFdfDictionary.getEmbeddedFDFs());
    assertNull(actualFdfDictionary.getAnnotations());
    assertNull(actualFdfDictionary.getFields());
    assertNull(actualFdfDictionary.getPages());
    assertNull(actualFdfDictionary.getID());
    assertNull(actualFdfDictionary.getDifferences());
    assertNull(actualFdfDictionary.getFile());
    assertNull(actualFdfDictionary.getJavaScript());
  }

  /**
   * Test {@link FDFDictionary#FDFDictionary(Element)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#FDFDictionary(Element)}
   */
  @Test
  @DisplayName("Test new FDFDictionary(Element); given IIOMetadataNode(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.<init>(Element)"})
  void testNewFDFDictionary_givenIIOMetadataNodeWithFoo() throws IOException {
    // Arrange
    IIOMetadataNode fdfXML = new IIOMetadataNode("foo");
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    fdfXML.insertBefore(iioMetadataNode, new IIOMetadataNode("foo"));

    // Act
    FDFDictionary actualFdfDictionary = new FDFDictionary(fdfXML);

    // Assert
    assertEquals("PDFDocEncoding", actualFdfDictionary.getEncoding());
    assertNull(actualFdfDictionary.getStatus());
    assertNull(actualFdfDictionary.getTarget());
    assertNull(actualFdfDictionary.getEmbeddedFDFs());
    assertNull(actualFdfDictionary.getAnnotations());
    assertNull(actualFdfDictionary.getFields());
    assertNull(actualFdfDictionary.getPages());
    assertNull(actualFdfDictionary.getID());
    assertNull(actualFdfDictionary.getDifferences());
    assertNull(actualFdfDictionary.getFile());
    assertNull(actualFdfDictionary.getJavaScript());
  }

  /**
   * Test {@link FDFDictionary#FDFDictionary(Element)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#FDFDictionary(Element)}
   */
  @Test
  @DisplayName("Test new FDFDictionary(Element); when IIOMetadataNode(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.<init>(Element)"})
  void testNewFDFDictionary_whenIIOMetadataNodeWithFoo() throws IOException {
    // Arrange and Act
    FDFDictionary actualFdfDictionary = new FDFDictionary(new IIOMetadataNode("foo"));

    // Assert
    assertEquals("PDFDocEncoding", actualFdfDictionary.getEncoding());
    assertNull(actualFdfDictionary.getStatus());
    assertNull(actualFdfDictionary.getTarget());
    assertNull(actualFdfDictionary.getEmbeddedFDFs());
    assertNull(actualFdfDictionary.getAnnotations());
    assertNull(actualFdfDictionary.getFields());
    assertNull(actualFdfDictionary.getPages());
    assertNull(actualFdfDictionary.getID());
    assertNull(actualFdfDictionary.getDifferences());
    assertNull(actualFdfDictionary.getFile());
    assertNull(actualFdfDictionary.getJavaScript());
  }

  /**
   * Test {@link FDFDictionary#writeXML(Writer)}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()} Fields is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); given FDFDictionary() Fields is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.writeXML(Writer)"})
  void testWriteXML_givenFDFDictionaryFieldsIsArrayList() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setFields(new ArrayList<>());
    StringWriter output = new StringWriter();

    // Act
    fdfDictionary.writeXML(output);

    // Assert that nothing has changed
    assertEquals("", output.toString());
  }

  /**
   * Test {@link FDFDictionary#writeXML(Writer)}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()}.</li>
   *   <li>Then {@link StringWriter#StringWriter()} toString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); given FDFDictionary(); then StringWriter() toString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.writeXML(Writer)"})
  void testWriteXML_givenFDFDictionary_thenStringWriterToStringIsEmptyString() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    StringWriter output = new StringWriter();

    // Act
    fdfDictionary.writeXML(output);

    // Assert that nothing has changed
    assertEquals("", output.toString());
  }

  /**
   * Test {@link FDFDictionary#writeXML(Writer)}.
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code <f href="" />}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); then StringWriter() toString is '<f href=\"\" />'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.writeXML(Writer)"})
  void testWriteXML_thenStringWriterToStringIsFHref() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setFile(new PDSimpleFileSpecification());
    StringWriter output = new StringWriter();

    // Act
    fdfDictionary.writeXML(output);

    // Assert
    assertEquals("<f href=\"\" />\n", output.toString());
  }

  /**
   * Test {@link FDFDictionary#writeXML(Writer)}.
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code <f href="null" />}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); then StringWriter() toString is '<f href=\"null\" />'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.writeXML(Writer)"})
  void testWriteXML_thenStringWriterToStringIsFHrefNull() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setFile(new PDComplexFileSpecification());
    StringWriter output = new StringWriter();

    // Act
    fdfDictionary.writeXML(output);

    // Assert
    assertEquals("<f href=\"null\" />\n", output.toString());
  }

  /**
   * Test {@link FDFDictionary#getCOSObject()}.
   * <p>
   * Method under test: {@link FDFDictionary#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDictionary FDFDictionary.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new FDFDictionary()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(0, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualCOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFDictionary#getFile()}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); given FDFDictionary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDFileSpecification FDFDictionary.getFile()"})
  void testGetFile_givenFDFDictionary_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFDictionary()).getFile());
  }

  /**
   * Test {@link FDFDictionary#getFile()}.
   * <ul>
   *   <li>Then COSObject return {@link COSString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); then COSObject return COSString")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDFileSpecification FDFDictionary.getFile()"})
  void testGetFile_thenCOSObjectReturnCOSString() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setFile(new PDSimpleFileSpecification());

    // Act
    PDFileSpecification actualFile = fdfDictionary.getFile();

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
   * Test {@link FDFDictionary#getFile()}.
   * <ul>
   *   <li>Then return {@link PDComplexFileSpecification}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); then return PDComplexFileSpecification")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDFileSpecification FDFDictionary.getFile()"})
  void testGetFile_thenReturnPDComplexFileSpecification() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setFile(new PDComplexFileSpecification());

    // Act
    PDFileSpecification actualFile = fdfDictionary.getFile();

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
   * Test {@link FDFDictionary#setFile(PDFileSpecification)}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} COSObject size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFile(PDFileSpecification); given FDFDictionary(); when 'null'; then FDFDictionary() COSObject size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setFile(PDFileSpecification)"})
  void testSetFile_givenFDFDictionary_whenNull_thenFDFDictionaryCOSObjectSizeIsZero() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    // Act
    fdfDictionary.setFile(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link FDFDictionary#setFile(PDFileSpecification)}.
   * <ul>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} File {@link PDComplexFileSpecification}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFile(PDFileSpecification); then FDFDictionary() File PDComplexFileSpecification")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setFile(PDFileSpecification)"})
  void testSetFile_thenFDFDictionaryFilePDComplexFileSpecification() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    // Act
    fdfDictionary.setFile(new PDComplexFileSpecification());

    // Assert
    PDFileSpecification file = fdfDictionary.getFile();
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
   * Test {@link FDFDictionary#setFile(PDFileSpecification)}.
   * <ul>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} File {@link PDSimpleFileSpecification}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFile(PDFileSpecification); then FDFDictionary() File PDSimpleFileSpecification")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setFile(PDFileSpecification)"})
  void testSetFile_thenFDFDictionaryFilePDSimpleFileSpecification() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    // Act
    fdfDictionary.setFile(new PDSimpleFileSpecification());

    // Assert
    PDFileSpecification file = fdfDictionary.getFile();
    assertTrue(file instanceof PDSimpleFileSpecification);
    assertEquals("", file.getFile());
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFDictionary#getID()}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()} ID is {@link COSArray#COSArray()}.</li>
   *   <li>Then return toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getID()}
   */
  @Test
  @DisplayName("Test getID(); given FDFDictionary() ID is COSArray(); then return toList Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSArray FDFDictionary.getID()"})
  void testGetID_givenFDFDictionaryIdIsCOSArray_thenReturnToListEmpty() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    COSArray id = new COSArray();
    fdfDictionary.setID(id);

    // Act
    COSArray actualID = fdfDictionary.getID();

    // Assert
    assertTrue(actualID.toList().isEmpty());
    assertSame(id, actualID);
  }

  /**
   * Test {@link FDFDictionary#getID()}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getID()}
   */
  @Test
  @DisplayName("Test getID(); given FDFDictionary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSArray FDFDictionary.getID()"})
  void testGetID_givenFDFDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFDictionary()).getID());
  }

  /**
   * Test {@link FDFDictionary#setID(COSArray)}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()}.</li>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setID(COSArray)}
   */
  @Test
  @DisplayName("Test setID(COSArray); given FDFDictionary(); then FDFDictionary() COSObject Values size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setID(COSArray)"})
  void testSetID_givenFDFDictionary_thenFDFDictionaryCOSObjectValuesSizeIsOne() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    COSArray id = new COSArray();

    // Act
    fdfDictionary.setID(id);

    // Assert
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(id, fdfDictionary.getID());
  }

  /**
   * Test {@link FDFDictionary#setID(COSArray)}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} COSObject size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setID(COSArray)}
   */
  @Test
  @DisplayName("Test setID(COSArray); given FDFDictionary(); when 'null'; then FDFDictionary() COSObject size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setID(COSArray)"})
  void testSetID_givenFDFDictionary_whenNull_thenFDFDictionaryCOSObjectSizeIsZero() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    // Act
    fdfDictionary.setID(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link FDFDictionary#getFields()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FDFField#FDFField()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getFields()}
   */
  @Test
  @DisplayName("Test getFields(); given ArrayList() add FDFField(); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getFields()"})
  void testGetFields_givenArrayListAddFDFField_thenReturnSizeIsOne() throws IOException {
    // Arrange
    ArrayList<FDFField> fields = new ArrayList<>();
    fields.add(new FDFField());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setFields(fields);

    // Act
    List<FDFField> actualFields = fdfDictionary.getFields();

    // Assert
    assertEquals(1, actualFields.size());
    FDFField getResult = actualFields.get(0);
    assertNull(getResult.getClearFieldFlags());
    assertNull(getResult.getClearWidgetFieldFlags());
    assertNull(getResult.getFieldFlags());
    assertNull(getResult.getSetFieldFlags());
    assertNull(getResult.getSetWidgetFieldFlags());
    assertNull(getResult.getWidgetFieldFlags());
    assertNull(getResult.getValue());
    assertNull(getResult.getPartialFieldName());
    assertNull(getResult.getRichText());
    assertNull(getResult.getOptions());
    assertNull(getResult.getKids());
    assertNull(getResult.getCOSValue());
    assertNull(getResult.getIconFit());
    assertNull(getResult.getAppearanceStreamReference());
    assertNull(getResult.getAction());
    assertNull(getResult.getAdditionalActions());
    assertNull(getResult.getAppearanceDictionary());
  }

  /**
   * Test {@link FDFDictionary#getFields()}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()} Fields is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getFields()}
   */
  @Test
  @DisplayName("Test getFields(); given FDFDictionary() Fields is ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getFields()"})
  void testGetFields_givenFDFDictionaryFieldsIsArrayList_thenReturnEmpty() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setFields(new ArrayList<>());

    // Act and Assert
    assertTrue(fdfDictionary.getFields().isEmpty());
  }

  /**
   * Test {@link FDFDictionary#getFields()}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getFields()}
   */
  @Test
  @DisplayName("Test getFields(); given FDFDictionary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getFields()"})
  void testGetFields_givenFDFDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFDictionary()).getFields());
  }

  /**
   * Test {@link FDFDictionary#setFields(List)}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} Fields Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setFields(List)}
   */
  @Test
  @DisplayName("Test setFields(List); given FDFDictionary(); when ArrayList(); then FDFDictionary() Fields Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setFields(List)"})
  void testSetFields_givenFDFDictionary_whenArrayList_thenFDFDictionaryFieldsEmpty() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    // Act
    fdfDictionary.setFields(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(fdfDictionary.getFields().isEmpty());
  }

  /**
   * Test {@link FDFDictionary#setFields(List)}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} Fields first ClearFieldFlags is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setFields(List)}
   */
  @Test
  @DisplayName("Test setFields(List); given FDFField(); then FDFDictionary() Fields first ClearFieldFlags is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setFields(List)"})
  void testSetFields_givenFDFField_thenFDFDictionaryFieldsFirstClearFieldFlagsIsNull() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    ArrayList<FDFField> fields = new ArrayList<>();
    fields.add(new FDFField());

    // Act
    fdfDictionary.setFields(fields);

    // Assert
    List<FDFField> fields2 = fdfDictionary.getFields();
    assertEquals(1, fields2.size());
    FDFField getResult = fields2.get(0);
    assertNull(getResult.getClearFieldFlags());
    assertNull(getResult.getClearWidgetFieldFlags());
    assertNull(getResult.getFieldFlags());
    assertNull(getResult.getSetFieldFlags());
    assertNull(getResult.getSetWidgetFieldFlags());
    assertNull(getResult.getWidgetFieldFlags());
    assertNull(getResult.getValue());
    assertNull(getResult.getPartialFieldName());
    assertNull(getResult.getRichText());
    assertNull(getResult.getOptions());
    assertNull(getResult.getKids());
    assertNull(getResult.getCOSValue());
    assertNull(getResult.getIconFit());
    assertNull(getResult.getAppearanceStreamReference());
    assertNull(getResult.getAction());
    assertNull(getResult.getAdditionalActions());
    assertNull(getResult.getAppearanceDictionary());
  }

  /**
   * Test {@link FDFDictionary#setFields(List)}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} Fields size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setFields(List)}
   */
  @Test
  @DisplayName("Test setFields(List); given FDFField(); then FDFDictionary() Fields size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setFields(List)"})
  void testSetFields_givenFDFField_thenFDFDictionaryFieldsSizeIsTwo() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    ArrayList<FDFField> fields = new ArrayList<>();
    fields.add(new FDFField());
    fields.add(new FDFField());

    // Act
    fdfDictionary.setFields(fields);

    // Assert
    List<FDFField> fields2 = fdfDictionary.getFields();
    assertEquals(2, fields2.size());
    FDFField getResult = fields2.get(1);
    assertNull(getResult.getClearFieldFlags());
    assertNull(getResult.getClearWidgetFieldFlags());
    assertNull(getResult.getFieldFlags());
    assertNull(getResult.getSetFieldFlags());
    assertNull(getResult.getSetWidgetFieldFlags());
    assertNull(getResult.getWidgetFieldFlags());
    assertNull(getResult.getValue());
    assertNull(getResult.getPartialFieldName());
    assertNull(getResult.getRichText());
    assertNull(getResult.getOptions());
    assertNull(getResult.getKids());
    assertNull(getResult.getCOSValue());
    assertNull(getResult.getIconFit());
    assertNull(getResult.getAppearanceStreamReference());
    assertNull(getResult.getAction());
    assertNull(getResult.getAdditionalActions());
    assertNull(getResult.getAppearanceDictionary());
  }

  /**
   * Test {@link FDFDictionary#setFields(List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} Fields first COSObject is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setFields(List)}
   */
  @Test
  @DisplayName("Test setFields(List); given 'null'; then FDFDictionary() Fields first COSObject is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setFields(List)"})
  void testSetFields_givenNull_thenFDFDictionaryFieldsFirstCOSObjectIsNull() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    ArrayList<FDFField> fields = new ArrayList<>();
    fields.add(null);

    // Act
    fdfDictionary.setFields(fields);

    // Assert
    List<FDFField> fields2 = fdfDictionary.getFields();
    assertEquals(1, fields2.size());
    assertNull(fields2.get(0).getCOSObject());
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFDictionary#getStatus()}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()} Status is empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getStatus()}
   */
  @Test
  @DisplayName("Test getStatus(); given FDFDictionary() Status is empty string; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FDFDictionary.getStatus()"})
  void testGetStatus_givenFDFDictionaryStatusIsEmptyString_thenReturnEmptyString() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setStatus("");

    // Act and Assert
    assertEquals("", fdfDictionary.getStatus());
  }

  /**
   * Test {@link FDFDictionary#getStatus()}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()} Status is {@code Status}.</li>
   *   <li>Then return {@code Status}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getStatus()}
   */
  @Test
  @DisplayName("Test getStatus(); given FDFDictionary() Status is 'Status'; then return 'Status'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FDFDictionary.getStatus()"})
  void testGetStatus_givenFDFDictionaryStatusIsStatus_thenReturnStatus() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setStatus("Status");

    // Act and Assert
    assertEquals("Status", fdfDictionary.getStatus());
  }

  /**
   * Test {@link FDFDictionary#getStatus()}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getStatus()}
   */
  @Test
  @DisplayName("Test getStatus(); given FDFDictionary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FDFDictionary.getStatus()"})
  void testGetStatus_givenFDFDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFDictionary()).getStatus());
  }

  /**
   * Test {@link FDFDictionary#setStatus(String)}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()}.</li>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} Status is {@code Status}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setStatus(String)}
   */
  @Test
  @DisplayName("Test setStatus(String); given FDFDictionary(); then FDFDictionary() Status is 'Status'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setStatus(String)"})
  void testSetStatus_givenFDFDictionary_thenFDFDictionaryStatusIsStatus() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    // Act
    fdfDictionary.setStatus("Status");

    // Assert
    assertEquals("Status", fdfDictionary.getStatus());
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFDictionary#getPages()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FDFPage#FDFPage()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getPages()}
   */
  @Test
  @DisplayName("Test getPages(); given ArrayList() add FDFPage(); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getPages()"})
  void testGetPages_givenArrayListAddFDFPage_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<FDFPage> pages = new ArrayList<>();
    pages.add(new FDFPage());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setPages(pages);

    // Act
    List<FDFPage> actualPages = fdfDictionary.getPages();

    // Assert
    assertEquals(1, actualPages.size());
    FDFPage getResult = actualPages.get(0);
    assertNull(getResult.getTemplates());
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getPageInfo());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFDictionary#getPages()}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()} Pages is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getPages()}
   */
  @Test
  @DisplayName("Test getPages(); given FDFDictionary() Pages is ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getPages()"})
  void testGetPages_givenFDFDictionaryPagesIsArrayList_thenReturnEmpty() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setPages(new ArrayList<>());

    // Act and Assert
    assertTrue(fdfDictionary.getPages().isEmpty());
  }

  /**
   * Test {@link FDFDictionary#getPages()}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getPages()}
   */
  @Test
  @DisplayName("Test getPages(); given FDFDictionary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getPages()"})
  void testGetPages_givenFDFDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFDictionary()).getPages());
  }

  /**
   * Test {@link FDFDictionary#setPages(List)}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} Pages Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setPages(List)}
   */
  @Test
  @DisplayName("Test setPages(List); given FDFDictionary(); when ArrayList(); then FDFDictionary() Pages Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setPages(List)"})
  void testSetPages_givenFDFDictionary_whenArrayList_thenFDFDictionaryPagesEmpty() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    // Act
    fdfDictionary.setPages(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(fdfDictionary.getPages().isEmpty());
  }

  /**
   * Test {@link FDFDictionary#setPages(List)}.
   * <ul>
   *   <li>Given {@link FDFPage#FDFPage()}.</li>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} Pages first Templates is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setPages(List)}
   */
  @Test
  @DisplayName("Test setPages(List); given FDFPage(); then FDFDictionary() Pages first Templates is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setPages(List)"})
  void testSetPages_givenFDFPage_thenFDFDictionaryPagesFirstTemplatesIsNull() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    ArrayList<FDFPage> pages = new ArrayList<>();
    pages.add(new FDFPage());

    // Act
    fdfDictionary.setPages(pages);

    // Assert
    List<FDFPage> pages2 = fdfDictionary.getPages();
    assertEquals(1, pages2.size());
    FDFPage getResult = pages2.get(0);
    assertNull(getResult.getTemplates());
    assertNull(getResult.getPageInfo());
  }

  /**
   * Test {@link FDFDictionary#setPages(List)}.
   * <ul>
   *   <li>Given {@link FDFPage#FDFPage()}.</li>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} Pages size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setPages(List)}
   */
  @Test
  @DisplayName("Test setPages(List); given FDFPage(); then FDFDictionary() Pages size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setPages(List)"})
  void testSetPages_givenFDFPage_thenFDFDictionaryPagesSizeIsTwo() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    ArrayList<FDFPage> pages = new ArrayList<>();
    pages.add(new FDFPage());
    pages.add(new FDFPage());

    // Act
    fdfDictionary.setPages(pages);

    // Assert
    List<FDFPage> pages2 = fdfDictionary.getPages();
    assertEquals(2, pages2.size());
    FDFPage getResult = pages2.get(1);
    assertNull(getResult.getTemplates());
    assertNull(getResult.getPageInfo());
  }

  /**
   * Test {@link FDFDictionary#setPages(List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} Pages first COSObject is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setPages(List)}
   */
  @Test
  @DisplayName("Test setPages(List); given 'null'; then FDFDictionary() Pages first COSObject is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setPages(List)"})
  void testSetPages_givenNull_thenFDFDictionaryPagesFirstCOSObjectIsNull() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    ArrayList<FDFPage> pages = new ArrayList<>();
    pages.add(null);

    // Act
    fdfDictionary.setPages(pages);

    // Assert
    List<FDFPage> pages2 = fdfDictionary.getPages();
    assertEquals(1, pages2.size());
    assertNull(pages2.get(0).getCOSObject());
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFDictionary#getEncoding()}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()} Encoding is {@code UTF-8}.</li>
   *   <li>Then return {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getEncoding()}
   */
  @Test
  @DisplayName("Test getEncoding(); given FDFDictionary() Encoding is 'UTF-8'; then return 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FDFDictionary.getEncoding()"})
  void testGetEncoding_givenFDFDictionaryEncodingIsUtf8_thenReturnUtf8() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setEncoding("UTF-8");

    // Act and Assert
    assertEquals("UTF-8", fdfDictionary.getEncoding());
  }

  /**
   * Test {@link FDFDictionary#getEncoding()}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()}.</li>
   *   <li>Then return {@code PDFDocEncoding}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getEncoding()}
   */
  @Test
  @DisplayName("Test getEncoding(); given FDFDictionary(); then return 'PDFDocEncoding'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FDFDictionary.getEncoding()"})
  void testGetEncoding_givenFDFDictionary_thenReturnPDFDocEncoding() {
    // Arrange, Act and Assert
    assertEquals("PDFDocEncoding", (new FDFDictionary()).getEncoding());
  }

  /**
   * Test {@link FDFDictionary#setEncoding(String)}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()}.</li>
   *   <li>When {@code annots}.</li>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} Encoding is {@code annots}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setEncoding(String)}
   */
  @Test
  @DisplayName("Test setEncoding(String); given FDFDictionary(); when 'annots'; then FDFDictionary() Encoding is 'annots'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setEncoding(String)"})
  void testSetEncoding_givenFDFDictionary_whenAnnots_thenFDFDictionaryEncodingIsAnnots() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    // Act
    fdfDictionary.setEncoding("annots");

    // Assert
    assertEquals("annots", fdfDictionary.getEncoding());
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFDictionary#setEncoding(String)}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()}.</li>
   *   <li>When {@code UTF-8}.</li>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} Encoding is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setEncoding(String)}
   */
  @Test
  @DisplayName("Test setEncoding(String); given FDFDictionary(); when 'UTF-8'; then FDFDictionary() Encoding is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setEncoding(String)"})
  void testSetEncoding_givenFDFDictionary_whenUtf8_thenFDFDictionaryEncodingIsUtf8() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    // Act
    fdfDictionary.setEncoding("UTF-8");

    // Assert
    assertEquals("UTF-8", fdfDictionary.getEncoding());
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFDictionary#getAnnotations()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FDFAnnotationCaret#FDFAnnotationCaret(COSDictionary)} with a is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); given ArrayList() add FDFAnnotationCaret(COSDictionary) with a is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getAnnotations()"})
  void testGetAnnotations_givenArrayListAddFDFAnnotationCaretWithAIsCOSDictionary() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationCaret(new COSDictionary()));

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    assertNull(actualAnnotations.get(0));
  }

  /**
   * Test {@link FDFDictionary#getAnnotations()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return first is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); given ArrayList() add 'null'; then return first is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getAnnotations()"})
  void testGetAnnotations_givenArrayListAddNull_thenReturnFirstIsNull() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(null);

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    assertNull(actualAnnotations.get(0));
  }

  /**
   * Test {@link FDFDictionary#getAnnotations()}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()} Annotations is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); given FDFDictionary() Annotations is ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getAnnotations()"})
  void testGetAnnotations_givenFDFDictionaryAnnotationsIsArrayList_thenReturnEmpty() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(new ArrayList<>());

    // Act and Assert
    assertTrue(fdfDictionary.getAnnotations().isEmpty());
  }

  /**
   * Test {@link FDFDictionary#getAnnotations()}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); given FDFDictionary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getAnnotations()"})
  void testGetAnnotations_givenFDFDictionary_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFDictionary()).getAnnotations());
  }

  /**
   * Test {@link FDFDictionary#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link FDFAnnotationCaret}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return FDFAnnotationCaret")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getAnnotations()"})
  void testGetAnnotations_thenFirstReturnFDFAnnotationCaret() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationCaret());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    assertTrue(actualAnnotations.get(0) instanceof FDFAnnotationCaret);
  }

  /**
   * Test {@link FDFDictionary#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link FDFAnnotationCircle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return FDFAnnotationCircle")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getAnnotations()"})
  void testGetAnnotations_thenFirstReturnFDFAnnotationCircle() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationCircle());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    assertTrue(actualAnnotations.get(0) instanceof FDFAnnotationCircle);
  }

  /**
   * Test {@link FDFDictionary#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link FDFAnnotationFileAttachment}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return FDFAnnotationFileAttachment")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getAnnotations()"})
  void testGetAnnotations_thenFirstReturnFDFAnnotationFileAttachment() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationFileAttachment());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    assertTrue(actualAnnotations.get(0) instanceof FDFAnnotationFileAttachment);
  }

  /**
   * Test {@link FDFDictionary#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link FDFAnnotationFreeText}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return FDFAnnotationFreeText")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getAnnotations()"})
  void testGetAnnotations_thenFirstReturnFDFAnnotationFreeText() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationFreeText());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    FDFAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof FDFAnnotationFreeText);
    assertEquals("0", ((FDFAnnotationFreeText) getResult).getJustification());
    assertNull(((FDFAnnotationFreeText) getResult).getCallout());
    assertNull(((FDFAnnotationFreeText) getResult).getDefaultAppearance());
    assertNull(((FDFAnnotationFreeText) getResult).getDefaultStyle());
    assertNull(((FDFAnnotationFreeText) getResult).getLineEndingStyle());
    assertNull(((FDFAnnotationFreeText) getResult).getRotation());
    assertNull(((FDFAnnotationFreeText) getResult).getFringe());
  }

  /**
   * Test {@link FDFDictionary#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link FDFAnnotationHighlight}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return FDFAnnotationHighlight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getAnnotations()"})
  void testGetAnnotations_thenFirstReturnFDFAnnotationHighlight() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationHighlight());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    assertTrue(actualAnnotations.get(0) instanceof FDFAnnotationHighlight);
  }

  /**
   * Test {@link FDFDictionary#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link FDFAnnotationInk}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return FDFAnnotationInk")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getAnnotations()"})
  void testGetAnnotations_thenFirstReturnFDFAnnotationInk() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationInk());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    assertTrue(actualAnnotations.get(0) instanceof FDFAnnotationInk);
  }

  /**
   * Test {@link FDFDictionary#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link FDFAnnotationLine}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return FDFAnnotationLine")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getAnnotations()"})
  void testGetAnnotations_thenFirstReturnFDFAnnotationLine() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationLine());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    FDFAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof FDFAnnotationLine);
    assertEquals("None", ((FDFAnnotationLine) getResult).getEndPointEndingStyle());
    assertEquals("None", ((FDFAnnotationLine) getResult).getStartPointEndingStyle());
    assertNull(((FDFAnnotationLine) getResult).getLine());
    assertNull(((FDFAnnotationLine) getResult).getInteriorColor());
    assertNull(((FDFAnnotationLine) getResult).getCaptionStyle());
    assertEquals(-1.0f, ((FDFAnnotationLine) getResult).getLeaderExtend());
    assertEquals(-1.0f, ((FDFAnnotationLine) getResult).getLeaderLength());
    assertEquals(-1.0f, ((FDFAnnotationLine) getResult).getLeaderOffset());
    assertEquals(0.0f, ((FDFAnnotationLine) getResult).getCaptionHorizontalOffset());
    assertEquals(0.0f, ((FDFAnnotationLine) getResult).getCaptionVerticalOffset());
    assertFalse(((FDFAnnotationLine) getResult).getCaption());
  }

  /**
   * Test {@link FDFDictionary#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link FDFAnnotationLink}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return FDFAnnotationLink")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getAnnotations()"})
  void testGetAnnotations_thenFirstReturnFDFAnnotationLink() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationLink());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    assertTrue(actualAnnotations.get(0) instanceof FDFAnnotationLink);
  }

  /**
   * Test {@link FDFDictionary#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link FDFAnnotationPolygon}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return FDFAnnotationPolygon")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getAnnotations()"})
  void testGetAnnotations_thenFirstReturnFDFAnnotationPolygon() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationPolygon());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    assertTrue(actualAnnotations.get(0) instanceof FDFAnnotationPolygon);
  }

  /**
   * Test {@link FDFDictionary#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link FDFAnnotationPolyline}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return FDFAnnotationPolyline")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getAnnotations()"})
  void testGetAnnotations_thenFirstReturnFDFAnnotationPolyline() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationPolyline());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    FDFAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof FDFAnnotationPolyline);
    assertEquals("None", ((FDFAnnotationPolyline) getResult).getEndPointEndingStyle());
    assertEquals("None", ((FDFAnnotationPolyline) getResult).getStartPointEndingStyle());
    assertNull(((FDFAnnotationPolyline) getResult).getVertices());
    assertNull(((FDFAnnotationPolyline) getResult).getInteriorColor());
  }

  /**
   * Test {@link FDFDictionary#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link FDFAnnotationSound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return FDFAnnotationSound")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getAnnotations()"})
  void testGetAnnotations_thenFirstReturnFDFAnnotationSound() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationSound());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    assertTrue(actualAnnotations.get(0) instanceof FDFAnnotationSound);
  }

  /**
   * Test {@link FDFDictionary#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link FDFAnnotationSquare}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return FDFAnnotationSquare")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getAnnotations()"})
  void testGetAnnotations_thenFirstReturnFDFAnnotationSquare() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationSquare());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    assertTrue(actualAnnotations.get(0) instanceof FDFAnnotationSquare);
  }

  /**
   * Test {@link FDFDictionary#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link FDFAnnotationSquiggly}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return FDFAnnotationSquiggly")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getAnnotations()"})
  void testGetAnnotations_thenFirstReturnFDFAnnotationSquiggly() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationSquiggly());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    assertTrue(actualAnnotations.get(0) instanceof FDFAnnotationSquiggly);
  }

  /**
   * Test {@link FDFDictionary#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link FDFAnnotationStamp}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return FDFAnnotationStamp")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getAnnotations()"})
  void testGetAnnotations_thenFirstReturnFDFAnnotationStamp() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationStamp());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    assertTrue(actualAnnotations.get(0) instanceof FDFAnnotationStamp);
  }

  /**
   * Test {@link FDFDictionary#setAnnotations(List)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} Annotations is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setAnnotations(List)}
   */
  @Test
  @DisplayName("Test setAnnotations(List); given ArrayList(); then FDFDictionary() Annotations is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setAnnotations(List)"})
  void testSetAnnotations_givenArrayList_thenFDFDictionaryAnnotationsIsArrayList() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.addAll(new ArrayList<>());
    annots.add(null);

    // Act
    fdfDictionary.setAnnotations(annots);

    // Assert
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(annots, fdfDictionary.getAnnotations());
  }

  /**
   * Test {@link FDFDictionary#setAnnotations(List)}.
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.</li>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} Annotations size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setAnnotations(List)}
   */
  @Test
  @DisplayName("Test setAnnotations(List); given FDFAnnotationCaret(); then FDFDictionary() Annotations size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setAnnotations(List)"})
  void testSetAnnotations_givenFDFAnnotationCaret_thenFDFDictionaryAnnotationsSizeIsOne() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationCaret());

    // Act
    fdfDictionary.setAnnotations(annots);

    // Assert
    List<FDFAnnotation> annotations = fdfDictionary.getAnnotations();
    assertEquals(1, annotations.size());
    assertTrue(annotations.get(0) instanceof FDFAnnotationCaret);
  }

  /**
   * Test {@link FDFDictionary#setAnnotations(List)}.
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.</li>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} Annotations size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setAnnotations(List)}
   */
  @Test
  @DisplayName("Test setAnnotations(List); given FDFAnnotationCaret(); then FDFDictionary() Annotations size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setAnnotations(List)"})
  void testSetAnnotations_givenFDFAnnotationCaret_thenFDFDictionaryAnnotationsSizeIsTwo() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationCaret());
    annots.add(new FDFAnnotationCaret());

    // Act
    fdfDictionary.setAnnotations(annots);

    // Assert
    List<FDFAnnotation> annotations = fdfDictionary.getAnnotations();
    assertEquals(2, annotations.size());
    assertTrue(annotations.get(1) instanceof FDFAnnotationCaret);
  }

  /**
   * Test {@link FDFDictionary#setAnnotations(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} Annotations Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setAnnotations(List)}
   */
  @Test
  @DisplayName("Test setAnnotations(List); when ArrayList(); then FDFDictionary() Annotations Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setAnnotations(List)"})
  void testSetAnnotations_whenArrayList_thenFDFDictionaryAnnotationsEmpty() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    // Act
    fdfDictionary.setAnnotations(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(fdfDictionary.getAnnotations().isEmpty());
  }

  /**
   * Test {@link FDFDictionary#getDifferences()}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()} Differences is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getDifferences()}
   */
  @Test
  @DisplayName("Test getDifferences(); given FDFDictionary() Differences is COSStream(); then return COSStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSStream FDFDictionary.getDifferences()"})
  void testGetDifferences_givenFDFDictionaryDifferencesIsCOSStream_thenReturnCOSStream() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    COSStream diff = new COSStream();
    fdfDictionary.setDifferences(diff);

    // Act and Assert
    assertSame(diff, fdfDictionary.getDifferences());
  }

  /**
   * Test {@link FDFDictionary#getDifferences()}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getDifferences()}
   */
  @Test
  @DisplayName("Test getDifferences(); given FDFDictionary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSStream FDFDictionary.getDifferences()"})
  void testGetDifferences_givenFDFDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFDictionary()).getDifferences());
  }

  /**
   * Test {@link FDFDictionary#getDifferences()}.
   * <ul>
   *   <li>Then return Key is {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getDifferences()}
   */
  @Test
  @DisplayName("Test getDifferences(); then return Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSStream FDFDictionary.getDifferences()"})
  void testGetDifferences_thenReturnKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSStream diff = new COSStream();
    COSObjectKey key = new COSObjectKey(1L, 1);

    diff.setKey(key);

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setDifferences(diff);

    // Act and Assert
    assertSame(key, fdfDictionary.getDifferences().getKey());
  }

  /**
   * Test {@link FDFDictionary#setDifferences(COSStream)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setDifferences(COSStream)}
   */
  @Test
  @DisplayName("Test setDifferences(COSStream); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setDifferences(COSStream)"})
  void testSetDifferences_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    COSStream diff = new COSStream();
    diff.setKey(new COSObjectKey(1L, 1));

    // Act
    fdfDictionary.setDifferences(diff);

    // Assert
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(diff, fdfDictionary.getDifferences());
  }

  /**
   * Test {@link FDFDictionary#setDifferences(COSStream)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSStream#COSStream()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setDifferences(COSStream)}
   */
  @Test
  @DisplayName("Test setDifferences(COSStream); given 'true'; when COSStream() Direct is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setDifferences(COSStream)"})
  void testSetDifferences_givenTrue_whenCOSStreamDirectIsTrue() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    COSStream diff = new COSStream();
    diff.setDirect(true);

    // Act
    fdfDictionary.setDifferences(diff);

    // Assert
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(diff, fdfDictionary.getDifferences());
  }

  /**
   * Test {@link FDFDictionary#setDifferences(COSStream)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setDifferences(COSStream)}
   */
  @Test
  @DisplayName("Test setDifferences(COSStream); when COSStream(); then FDFDictionary() COSObject Values size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setDifferences(COSStream)"})
  void testSetDifferences_whenCOSStream_thenFDFDictionaryCOSObjectValuesSizeIsOne() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    COSStream diff = new COSStream();

    // Act
    fdfDictionary.setDifferences(diff);

    // Assert
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(diff, fdfDictionary.getDifferences());
  }

  /**
   * Test {@link FDFDictionary#setDifferences(COSStream)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} COSObject size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setDifferences(COSStream)}
   */
  @Test
  @DisplayName("Test setDifferences(COSStream); when 'null'; then FDFDictionary() COSObject size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setDifferences(COSStream)"})
  void testSetDifferences_whenNull_thenFDFDictionaryCOSObjectSizeIsZero() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    // Act
    fdfDictionary.setDifferences(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link FDFDictionary#getTarget()}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()} Target is empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getTarget()}
   */
  @Test
  @DisplayName("Test getTarget(); given FDFDictionary() Target is empty string; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FDFDictionary.getTarget()"})
  void testGetTarget_givenFDFDictionaryTargetIsEmptyString_thenReturnEmptyString() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setTarget("");

    // Act and Assert
    assertEquals("", fdfDictionary.getTarget());
  }

  /**
   * Test {@link FDFDictionary#getTarget()}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()} Target is {@code Target}.</li>
   *   <li>Then return {@code Target}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getTarget()}
   */
  @Test
  @DisplayName("Test getTarget(); given FDFDictionary() Target is 'Target'; then return 'Target'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FDFDictionary.getTarget()"})
  void testGetTarget_givenFDFDictionaryTargetIsTarget_thenReturnTarget() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setTarget("Target");

    // Act and Assert
    assertEquals("Target", fdfDictionary.getTarget());
  }

  /**
   * Test {@link FDFDictionary#getTarget()}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getTarget()}
   */
  @Test
  @DisplayName("Test getTarget(); given FDFDictionary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FDFDictionary.getTarget()"})
  void testGetTarget_givenFDFDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFDictionary()).getTarget());
  }

  /**
   * Test {@link FDFDictionary#setTarget(String)}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()}.</li>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} Target is {@code Target}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setTarget(String)}
   */
  @Test
  @DisplayName("Test setTarget(String); given FDFDictionary(); then FDFDictionary() Target is 'Target'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setTarget(String)"})
  void testSetTarget_givenFDFDictionary_thenFDFDictionaryTargetIsTarget() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    // Act
    fdfDictionary.setTarget("Target");

    // Assert
    assertEquals("Target", fdfDictionary.getTarget());
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFDictionary#getEmbeddedFDFs()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return first is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getEmbeddedFDFs()}
   */
  @Test
  @DisplayName("Test getEmbeddedFDFs(); given ArrayList() add 'null'; then return first is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getEmbeddedFDFs()"})
  void testGetEmbeddedFDFs_givenArrayListAddNull_thenReturnFirstIsNull() throws IOException {
    // Arrange
    ArrayList<PDFileSpecification> embedded = new ArrayList<>();
    embedded.add(null);

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setEmbeddedFDFs(embedded);

    // Act
    List<PDFileSpecification> actualEmbeddedFDFs = fdfDictionary.getEmbeddedFDFs();

    // Assert
    assertEquals(1, actualEmbeddedFDFs.size());
    assertNull(actualEmbeddedFDFs.get(0));
  }

  /**
   * Test {@link FDFDictionary#getEmbeddedFDFs()}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()} EmbeddedFDFs is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getEmbeddedFDFs()}
   */
  @Test
  @DisplayName("Test getEmbeddedFDFs(); given FDFDictionary() EmbeddedFDFs is ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getEmbeddedFDFs()"})
  void testGetEmbeddedFDFs_givenFDFDictionaryEmbeddedFDFsIsArrayList_thenReturnEmpty() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setEmbeddedFDFs(new ArrayList<>());

    // Act and Assert
    assertTrue(fdfDictionary.getEmbeddedFDFs().isEmpty());
  }

  /**
   * Test {@link FDFDictionary#getEmbeddedFDFs()}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getEmbeddedFDFs()}
   */
  @Test
  @DisplayName("Test getEmbeddedFDFs(); given FDFDictionary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getEmbeddedFDFs()"})
  void testGetEmbeddedFDFs_givenFDFDictionary_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFDictionary()).getEmbeddedFDFs());
  }

  /**
   * Test {@link FDFDictionary#getEmbeddedFDFs()}.
   * <ul>
   *   <li>Then first COSObject return {@link COSString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getEmbeddedFDFs()}
   */
  @Test
  @DisplayName("Test getEmbeddedFDFs(); then first COSObject return COSString")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getEmbeddedFDFs()"})
  void testGetEmbeddedFDFs_thenFirstCOSObjectReturnCOSString() throws IOException {
    // Arrange
    ArrayList<PDFileSpecification> embedded = new ArrayList<>();
    embedded.add(new PDSimpleFileSpecification());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setEmbeddedFDFs(embedded);

    // Act
    List<PDFileSpecification> actualEmbeddedFDFs = fdfDictionary.getEmbeddedFDFs();

    // Assert
    assertEquals(1, actualEmbeddedFDFs.size());
    PDFileSpecification getResult = actualEmbeddedFDFs.get(0);
    COSBase cOSObject = getResult.getCOSObject();
    assertTrue(cOSObject instanceof COSString);
    assertTrue(getResult instanceof PDSimpleFileSpecification);
    assertEquals("", ((COSString) cOSObject).getASCII());
    assertEquals("", ((COSString) cOSObject).getString());
    assertEquals("", ((COSString) cOSObject).toHexString());
    assertEquals("", getResult.getFile());
    assertNull(cOSObject.getKey());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSString) cOSObject).getForceHexForm());
    assertArrayEquals(new byte[]{}, ((COSString) cOSObject).getBytes());
  }

  /**
   * Test {@link FDFDictionary#getEmbeddedFDFs()}.
   * <ul>
   *   <li>Then first return {@link PDComplexFileSpecification}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getEmbeddedFDFs()}
   */
  @Test
  @DisplayName("Test getEmbeddedFDFs(); then first return PDComplexFileSpecification")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FDFDictionary.getEmbeddedFDFs()"})
  void testGetEmbeddedFDFs_thenFirstReturnPDComplexFileSpecification() throws IOException {
    // Arrange
    ArrayList<PDFileSpecification> embedded = new ArrayList<>();
    embedded.add(new PDComplexFileSpecification());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setEmbeddedFDFs(embedded);

    // Act
    List<PDFileSpecification> actualEmbeddedFDFs = fdfDictionary.getEmbeddedFDFs();

    // Assert
    assertEquals(1, actualEmbeddedFDFs.size());
    PDFileSpecification getResult = actualEmbeddedFDFs.get(0);
    assertTrue(getResult instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) getResult).getFileDescription());
    assertNull(((PDComplexFileSpecification) getResult).getFileDos());
    assertNull(((PDComplexFileSpecification) getResult).getFileMac());
    assertNull(((PDComplexFileSpecification) getResult).getFileUnicode());
    assertNull(((PDComplexFileSpecification) getResult).getFileUnix());
    assertNull(((PDComplexFileSpecification) getResult).getFilename());
    assertNull(getResult.getFile());
    assertNull(((PDComplexFileSpecification) getResult).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) getResult).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) getResult).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) getResult).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) getResult).getEmbeddedFileUnix());
    assertFalse(((PDComplexFileSpecification) getResult).isVolatile());
  }

  /**
   * Test {@link FDFDictionary#setEmbeddedFDFs(List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} EmbeddedFDFs is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setEmbeddedFDFs(List)}
   */
  @Test
  @DisplayName("Test setEmbeddedFDFs(List); given 'null'; then FDFDictionary() EmbeddedFDFs is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setEmbeddedFDFs(List)"})
  void testSetEmbeddedFDFs_givenNull_thenFDFDictionaryEmbeddedFDFsIsArrayList() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    ArrayList<PDFileSpecification> embedded = new ArrayList<>();
    embedded.add(null);

    // Act
    fdfDictionary.setEmbeddedFDFs(embedded);

    // Assert
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(embedded, fdfDictionary.getEmbeddedFDFs());
  }

  /**
   * Test {@link FDFDictionary#setEmbeddedFDFs(List)}.
   * <ul>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} EmbeddedFDFs first {@link PDComplexFileSpecification}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setEmbeddedFDFs(List)}
   */
  @Test
  @DisplayName("Test setEmbeddedFDFs(List); then FDFDictionary() EmbeddedFDFs first PDComplexFileSpecification")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setEmbeddedFDFs(List)"})
  void testSetEmbeddedFDFs_thenFDFDictionaryEmbeddedFDFsFirstPDComplexFileSpecification() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    ArrayList<PDFileSpecification> embedded = new ArrayList<>();
    embedded.add(new PDComplexFileSpecification());

    // Act
    fdfDictionary.setEmbeddedFDFs(embedded);

    // Assert
    List<PDFileSpecification> embeddedFDFs = fdfDictionary.getEmbeddedFDFs();
    assertEquals(1, embeddedFDFs.size());
    PDFileSpecification getResult = embeddedFDFs.get(0);
    assertTrue(getResult instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) getResult).getFileDescription());
    assertNull(((PDComplexFileSpecification) getResult).getFileDos());
    assertNull(((PDComplexFileSpecification) getResult).getFileMac());
    assertNull(((PDComplexFileSpecification) getResult).getFileUnicode());
    assertNull(((PDComplexFileSpecification) getResult).getFileUnix());
    assertNull(((PDComplexFileSpecification) getResult).getFilename());
    assertNull(getResult.getFile());
    assertNull(((PDComplexFileSpecification) getResult).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) getResult).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) getResult).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) getResult).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) getResult).getEmbeddedFileUnix());
    assertFalse(((PDComplexFileSpecification) getResult).isVolatile());
  }

  /**
   * Test {@link FDFDictionary#setEmbeddedFDFs(List)}.
   * <ul>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} EmbeddedFDFs first {@link PDSimpleFileSpecification}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setEmbeddedFDFs(List)}
   */
  @Test
  @DisplayName("Test setEmbeddedFDFs(List); then FDFDictionary() EmbeddedFDFs first PDSimpleFileSpecification")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setEmbeddedFDFs(List)"})
  void testSetEmbeddedFDFs_thenFDFDictionaryEmbeddedFDFsFirstPDSimpleFileSpecification() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    ArrayList<PDFileSpecification> embedded = new ArrayList<>();
    embedded.add(new PDSimpleFileSpecification());

    // Act
    fdfDictionary.setEmbeddedFDFs(embedded);

    // Assert
    List<PDFileSpecification> embeddedFDFs = fdfDictionary.getEmbeddedFDFs();
    assertEquals(1, embeddedFDFs.size());
    PDFileSpecification getResult = embeddedFDFs.get(0);
    assertTrue(getResult instanceof PDSimpleFileSpecification);
    assertEquals("", getResult.getFile());
  }

  /**
   * Test {@link FDFDictionary#setEmbeddedFDFs(List)}.
   * <ul>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} EmbeddedFDFs size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setEmbeddedFDFs(List)}
   */
  @Test
  @DisplayName("Test setEmbeddedFDFs(List); then FDFDictionary() EmbeddedFDFs size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setEmbeddedFDFs(List)"})
  void testSetEmbeddedFDFs_thenFDFDictionaryEmbeddedFDFsSizeIsTwo() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    ArrayList<PDFileSpecification> embedded = new ArrayList<>();
    embedded.add(new PDComplexFileSpecification());
    embedded.add(new PDComplexFileSpecification());

    // Act
    fdfDictionary.setEmbeddedFDFs(embedded);

    // Assert
    List<PDFileSpecification> embeddedFDFs = fdfDictionary.getEmbeddedFDFs();
    assertEquals(2, embeddedFDFs.size());
    PDFileSpecification getResult = embeddedFDFs.get(1);
    assertTrue(getResult instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) getResult).getFileDescription());
    assertNull(((PDComplexFileSpecification) getResult).getFileDos());
    assertNull(((PDComplexFileSpecification) getResult).getFileMac());
    assertNull(((PDComplexFileSpecification) getResult).getFileUnicode());
    assertNull(((PDComplexFileSpecification) getResult).getFileUnix());
    assertNull(((PDComplexFileSpecification) getResult).getFilename());
    assertNull(getResult.getFile());
    assertNull(((PDComplexFileSpecification) getResult).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) getResult).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) getResult).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) getResult).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) getResult).getEmbeddedFileUnix());
    assertFalse(((PDComplexFileSpecification) getResult).isVolatile());
  }

  /**
   * Test {@link FDFDictionary#setEmbeddedFDFs(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} EmbeddedFDFs Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setEmbeddedFDFs(List)}
   */
  @Test
  @DisplayName("Test setEmbeddedFDFs(List); when ArrayList(); then FDFDictionary() EmbeddedFDFs Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setEmbeddedFDFs(List)"})
  void testSetEmbeddedFDFs_whenArrayList_thenFDFDictionaryEmbeddedFDFsEmpty() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    // Act
    fdfDictionary.setEmbeddedFDFs(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(fdfDictionary.getEmbeddedFDFs().isEmpty());
  }

  /**
   * Test {@link FDFDictionary#getJavaScript()}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getJavaScript()}
   */
  @Test
  @DisplayName("Test getJavaScript(); given FDFDictionary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FDFJavaScript FDFDictionary.getJavaScript()"})
  void testGetJavaScript_givenFDFDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFDictionary()).getJavaScript());
  }

  /**
   * Test {@link FDFDictionary#getJavaScript()}.
   * <ul>
   *   <li>Then return After is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#getJavaScript()}
   */
  @Test
  @DisplayName("Test getJavaScript(); then return After is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FDFJavaScript FDFDictionary.getJavaScript()"})
  void testGetJavaScript_thenReturnAfterIsNull() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setJavaScript(new FDFJavaScript());

    // Act
    FDFJavaScript actualJavaScript = fdfDictionary.getJavaScript();

    // Assert
    assertNull(actualJavaScript.getAfter());
    assertNull(actualJavaScript.getBefore());
    assertNull(actualJavaScript.getDoc());
    COSDictionary cOSObject = actualJavaScript.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFDictionary#setJavaScript(FDFJavaScript)}.
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()}.</li>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} JavaScript After is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setJavaScript(FDFJavaScript)}
   */
  @Test
  @DisplayName("Test setJavaScript(FDFJavaScript); given FDFDictionary(); then FDFDictionary() JavaScript After is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setJavaScript(FDFJavaScript)"})
  void testSetJavaScript_givenFDFDictionary_thenFDFDictionaryJavaScriptAfterIsNull() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    // Act
    fdfDictionary.setJavaScript(new FDFJavaScript());

    // Assert
    FDFJavaScript javaScript = fdfDictionary.getJavaScript();
    assertNull(javaScript.getAfter());
    assertNull(javaScript.getBefore());
    assertNull(javaScript.getDoc());
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFDictionary#setJavaScript(FDFJavaScript)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link FDFDictionary#FDFDictionary()} COSObject size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDictionary#setJavaScript(FDFJavaScript)}
   */
  @Test
  @DisplayName("Test setJavaScript(FDFJavaScript); when 'null'; then FDFDictionary() COSObject size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDictionary.setJavaScript(FDFJavaScript)"})
  void testSetJavaScript_whenNull_thenFDFDictionaryCOSObjectSizeIsZero() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    // Act
    fdfDictionary.setJavaScript(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }
}

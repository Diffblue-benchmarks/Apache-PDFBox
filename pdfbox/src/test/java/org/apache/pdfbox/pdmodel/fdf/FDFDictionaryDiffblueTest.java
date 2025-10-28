package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.filespecification.PDComplexFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDSimpleFileSpecification;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

class FDFDictionaryDiffblueTest {
  /**
   * Method under test: {@link FDFDictionary#writeXML(Writer)}
   */
  @Test
  void testWriteXML() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    StringWriter output = new StringWriter();

    // Act
    fdfDictionary.writeXML(output);

    // Assert that nothing has changed
    assertEquals("", output.toString());
  }

  /**
   * Method under test: {@link FDFDictionary#writeXML(Writer)}
   */
  @Test
  void testWriteXML2() throws IOException {
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
   * Method under test: {@link FDFDictionary#writeXML(Writer)}
   */
  @Test
  void testWriteXML3() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setFields(new ArrayList<>());
    StringWriter output = new StringWriter();

    // Act
    fdfDictionary.writeXML(output);

    // Assert
    assertEquals("", output.toString());
  }

  /**
   * Method under test: {@link FDFDictionary#writeXML(Writer)}
   */
  @Test
  void testWriteXML4() throws IOException {
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
   * Method under test: {@link FDFDictionary#getCOSObject()}
   */
  @Test
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
   * Method under test: {@link FDFDictionary#getCOSObject()}
   */
  @Test
  void testGetCOSObject2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray id = new COSArray();
    id.add(object);

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setID(id);

    // Act
    COSDictionary actualCOSObject = fdfDictionary.getCOSObject();

    // Assert
    verify(object).getCOSObject();
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(1, actualCOSObject.getValues().size());
    assertEquals(1, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#getFile()}
   */
  @Test
  void testGetFile() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFDictionary()).getFile());
  }

  /**
   * Method under test: {@link FDFDictionary#getFile()}
   */
  @Test
  void testGetFile2() throws IOException {
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
    COSBase cOSObject = actualFile.getCOSObject();
    COSUpdateState updateState = ((COSDictionary) cOSObject).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileUnix());
    assertEquals(1, ((COSDictionary) cOSObject).getValues().size());
    assertEquals(1, ((COSDictionary) cOSObject).size());
    COSIncrement toIncrementResult = ((COSDictionary) cOSObject).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSDictionary) cOSObject).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDComplexFileSpecification) actualFile).isVolatile());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#getFile()}
   */
  @Test
  void testGetFile3() throws IOException {
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
    assertEquals(0, ((COSString) cOSObject).getBytes().length);
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSString) cOSObject).getForceHexForm());
  }

  /**
   * Method under test: {@link FDFDictionary#getFile()}
   */
  @Test
  void testGetFile4() throws IOException {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray id = new COSArray();
    id.add(object);

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setID(id);

    // Act
    PDFileSpecification actualFile = fdfDictionary.getFile();

    // Assert
    verify(object).getCOSObject();
    assertNull(actualFile);
  }

  /**
   * Method under test: {@link FDFDictionary#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile() throws IOException {
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
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(((PDComplexFileSpecification) file).isVolatile());
  }

  /**
   * Method under test: {@link FDFDictionary#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile2() throws IOException {
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
   * Method under test: {@link FDFDictionary#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile3() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    // Act
    fdfDictionary.setFile(null);

    // Assert
    assertNull(fdfDictionary.getFile());
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile4() throws IOException {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray id = new COSArray();
    id.add(object);

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setID(id);

    // Act
    fdfDictionary.setFile(new PDComplexFileSpecification());

    // Assert
    verify(object).getCOSObject();
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
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(((PDComplexFileSpecification) file).isVolatile());
  }

  /**
   * Method under test: {@link FDFDictionary#getID()}
   */
  @Test
  void testGetID() {
    // Arrange, Act and Assert
    assertNull((new FDFDictionary()).getID());
  }

  /**
   * Method under test: {@link FDFDictionary#getID()}
   */
  @Test
  void testGetID2() {
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
   * Method under test: {@link FDFDictionary#getID()}
   */
  @Test
  void testGetID3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray id = new COSArray();
    id.add(object);

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setID(id);

    // Act
    COSArray actualID = fdfDictionary.getID();

    // Assert
    verify(object).getCOSObject();
    assertSame(id, actualID);
  }

  /**
   * Method under test: {@link FDFDictionary#setID(COSArray)}
   */
  @Test
  void testSetID() {
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
   * Method under test: {@link FDFDictionary#setID(COSArray)}
   */
  @Test
  void testSetID2() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    // Act
    fdfDictionary.setID(null);

    // Assert
    assertNull(fdfDictionary.getID());
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#setID(COSArray)}
   */
  @Test
  void testSetID3() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray id = new COSArray();
    id.add(object);

    // Act
    fdfDictionary.setID(id);

    // Assert
    verify(object).getCOSObject();
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(id, fdfDictionary.getID());
  }

  /**
   * Method under test: {@link FDFDictionary#getFields()}
   */
  @Test
  void testGetFields() {
    // Arrange, Act and Assert
    assertNull((new FDFDictionary()).getFields());
  }

  /**
   * Method under test: {@link FDFDictionary#getFields()}
   */
  @Test
  void testGetFields2() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setFields(new ArrayList<>());

    // Act and Assert
    assertTrue(fdfDictionary.getFields().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#getFields()}
   */
  @Test
  void testGetFields3() throws IOException {
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
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getIconFit());
    assertNull(getResult.getAppearanceStreamReference());
    assertNull(getResult.getAction());
    assertNull(getResult.getAdditionalActions());
    assertNull(getResult.getAppearanceDictionary());
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
   * Method under test: {@link FDFDictionary#getFields()}
   */
  @Test
  void testGetFields4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray id = new COSArray();
    id.add(object);

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setID(id);

    // Act
    List<FDFField> actualFields = fdfDictionary.getFields();

    // Assert
    verify(object).getCOSObject();
    assertNull(actualFields);
  }

  /**
   * Method under test: {@link FDFDictionary#setFields(List)}
   */
  @Test
  void testSetFields() {
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
   * Method under test: {@link FDFDictionary#setFields(List)}
   */
  @Test
  void testSetFields2() throws IOException {
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
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFDictionary#setFields(List)}
   */
  @Test
  void testSetFields3() throws IOException {
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
    FDFField getResult = fields2.get(0);
    assertNull(getResult.getClearFieldFlags());
    FDFField getResult2 = fields2.get(1);
    assertNull(getResult2.getClearFieldFlags());
    assertNull(getResult.getClearWidgetFieldFlags());
    assertNull(getResult2.getClearWidgetFieldFlags());
    assertNull(getResult.getFieldFlags());
    assertNull(getResult2.getFieldFlags());
    assertNull(getResult.getSetFieldFlags());
    assertNull(getResult2.getSetFieldFlags());
    assertNull(getResult.getSetWidgetFieldFlags());
    assertNull(getResult2.getSetWidgetFieldFlags());
    assertNull(getResult.getWidgetFieldFlags());
    assertNull(getResult2.getWidgetFieldFlags());
    assertNull(getResult.getValue());
    assertNull(getResult2.getValue());
    assertNull(getResult.getPartialFieldName());
    assertNull(getResult2.getPartialFieldName());
    assertNull(getResult.getRichText());
    assertNull(getResult2.getRichText());
    assertNull(getResult.getOptions());
    assertNull(getResult2.getOptions());
    assertNull(getResult.getKids());
    assertNull(getResult2.getKids());
    assertNull(getResult.getCOSValue());
    assertNull(getResult2.getCOSValue());
    assertNull(getResult.getIconFit());
    assertNull(getResult2.getIconFit());
    assertNull(getResult.getAppearanceStreamReference());
    assertNull(getResult2.getAppearanceStreamReference());
    assertNull(getResult.getAction());
    assertNull(getResult2.getAction());
    assertNull(getResult.getAdditionalActions());
    assertNull(getResult2.getAdditionalActions());
    assertNull(getResult.getAppearanceDictionary());
    assertNull(getResult2.getAppearanceDictionary());
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFDictionary#setFields(List)}
   */
  @Test
  void testSetFields4() {
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
   * Method under test: {@link FDFDictionary#setFields(List)}
   */
  @Test
  void testSetFields5() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray id = new COSArray();
    id.add(object);

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setID(id);

    // Act
    fdfDictionary.setFields(new ArrayList<>());

    // Assert
    verify(object).getCOSObject();
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(fdfDictionary.getFields().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#getStatus()}
   */
  @Test
  void testGetStatus() {
    // Arrange, Act and Assert
    assertNull((new FDFDictionary()).getStatus());
  }

  /**
   * Method under test: {@link FDFDictionary#getStatus()}
   */
  @Test
  void testGetStatus2() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setStatus("Status");

    // Act and Assert
    assertEquals("Status", fdfDictionary.getStatus());
  }

  /**
   * Method under test: {@link FDFDictionary#getStatus()}
   */
  @Test
  void testGetStatus3() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setStatus("");

    // Act and Assert
    assertEquals("", fdfDictionary.getStatus());
  }

  /**
   * Method under test: {@link FDFDictionary#getStatus()}
   */
  @Test
  void testGetStatus4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray id = new COSArray();
    id.add(object);

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setID(id);

    // Act
    String actualStatus = fdfDictionary.getStatus();

    // Assert
    verify(object).getCOSObject();
    assertNull(actualStatus);
  }

  /**
   * Method under test: {@link FDFDictionary#setStatus(String)}
   */
  @Test
  void testSetStatus() {
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
   * Method under test: {@link FDFDictionary#setStatus(String)}
   */
  @Test
  void testSetStatus2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray id = new COSArray();
    id.add(object);

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setID(id);

    // Act
    fdfDictionary.setStatus("Status");

    // Assert
    verify(object).getCOSObject();
    assertEquals("Status", fdfDictionary.getStatus());
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFDictionary#getPages()}
   */
  @Test
  void testGetPages() {
    // Arrange, Act and Assert
    assertNull((new FDFDictionary()).getPages());
  }

  /**
   * Method under test: {@link FDFDictionary#getPages()}
   */
  @Test
  void testGetPages2() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setPages(new ArrayList<>());

    // Act and Assert
    assertTrue(fdfDictionary.getPages().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#getPages()}
   */
  @Test
  void testGetPages3() {
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
   * Method under test: {@link FDFDictionary#getPages()}
   */
  @Test
  void testGetPages4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray id = new COSArray();
    id.add(object);

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setID(id);

    // Act
    List<FDFPage> actualPages = fdfDictionary.getPages();

    // Assert
    verify(object).getCOSObject();
    assertNull(actualPages);
  }

  /**
   * Method under test: {@link FDFDictionary#setPages(List)}
   */
  @Test
  void testSetPages() {
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
   * Method under test: {@link FDFDictionary#setPages(List)}
   */
  @Test
  void testSetPages2() {
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
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFDictionary#setPages(List)}
   */
  @Test
  void testSetPages3() {
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
    FDFPage getResult = pages2.get(0);
    assertNull(getResult.getTemplates());
    FDFPage getResult2 = pages2.get(1);
    assertNull(getResult2.getTemplates());
    assertNull(getResult.getPageInfo());
    assertNull(getResult2.getPageInfo());
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFDictionary#setPages(List)}
   */
  @Test
  void testSetPages4() {
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
   * Method under test: {@link FDFDictionary#setPages(List)}
   */
  @Test
  void testSetPages5() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray id = new COSArray();
    id.add(object);

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setID(id);

    // Act
    fdfDictionary.setPages(new ArrayList<>());

    // Assert
    verify(object).getCOSObject();
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(fdfDictionary.getPages().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#getEncoding()}
   */
  @Test
  void testGetEncoding() {
    // Arrange, Act and Assert
    assertEquals("PDFDocEncoding", (new FDFDictionary()).getEncoding());
  }

  /**
   * Method under test: {@link FDFDictionary#getEncoding()}
   */
  @Test
  void testGetEncoding2() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setEncoding("UTF-8");

    // Act and Assert
    assertEquals("UTF-8", fdfDictionary.getEncoding());
  }

  /**
   * Method under test: {@link FDFDictionary#getEncoding()}
   */
  @Test
  void testGetEncoding3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray id = new COSArray();
    id.add(object);

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setID(id);

    // Act
    String actualEncoding = fdfDictionary.getEncoding();

    // Assert
    verify(object).getCOSObject();
    assertEquals("PDFDocEncoding", actualEncoding);
  }

  /**
   * Method under test: {@link FDFDictionary#setEncoding(String)}
   */
  @Test
  void testSetEncoding() {
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
   * Method under test: {@link FDFDictionary#setEncoding(String)}
   */
  @Test
  void testSetEncoding2() {
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
   * Method under test: {@link FDFDictionary#setEncoding(String)}
   */
  @Test
  void testSetEncoding3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray id = new COSArray();
    id.add(object);

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setID(id);

    // Act
    fdfDictionary.setEncoding("UTF-8");

    // Assert
    verify(object).getCOSObject();
    assertEquals("UTF-8", fdfDictionary.getEncoding());
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  void testGetAnnotations() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFDictionary()).getAnnotations());
  }

  /**
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  void testGetAnnotations2() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(new ArrayList<>());

    // Act and Assert
    assertTrue(fdfDictionary.getAnnotations().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  void testGetAnnotations3() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationCaret());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    FDFAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof FDFAnnotationCaret);
    assertEquals("", getResult.getRichContents());
    assertNull(getResult.getColor());
    assertNull(getResult.getPage());
    assertNull(getResult.getContents());
    assertNull(getResult.getDate());
    assertNull(getResult.getIntent());
    assertNull(getResult.getName());
    assertNull(getResult.getSubject());
    assertNull(getResult.getTitle());
    assertNull(((FDFAnnotationCaret) getResult).getSymbol());
    assertNull(getResult.getCreationDate());
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getRectangle());
    assertNull(((FDFAnnotationCaret) getResult).getFringe());
    assertNull(getResult.getBorderEffect());
    assertNull(getResult.getBorderStyle());
    assertEquals(1.0f, getResult.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(getResult.isHidden());
    assertFalse(getResult.isInvisible());
    assertFalse(getResult.isLocked());
    assertFalse(getResult.isLockedContents());
    assertFalse(getResult.isNoRotate());
    assertFalse(getResult.isNoView());
    assertFalse(getResult.isNoZoom());
    assertFalse(getResult.isPrinted());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  void testGetAnnotations4() throws IOException {
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
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  void testGetAnnotations5() throws IOException {
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
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  void testGetAnnotations6() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationCircle());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    FDFAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof FDFAnnotationCircle);
    assertEquals("", getResult.getRichContents());
    assertNull(getResult.getColor());
    assertNull(((FDFAnnotationCircle) getResult).getInteriorColor());
    assertNull(getResult.getPage());
    assertNull(getResult.getContents());
    assertNull(getResult.getDate());
    assertNull(getResult.getIntent());
    assertNull(getResult.getName());
    assertNull(getResult.getSubject());
    assertNull(getResult.getTitle());
    assertNull(getResult.getCreationDate());
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getRectangle());
    assertNull(((FDFAnnotationCircle) getResult).getFringe());
    assertNull(getResult.getBorderEffect());
    assertNull(getResult.getBorderStyle());
    assertEquals(1.0f, getResult.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(getResult.isHidden());
    assertFalse(getResult.isInvisible());
    assertFalse(getResult.isLocked());
    assertFalse(getResult.isLockedContents());
    assertFalse(getResult.isNoRotate());
    assertFalse(getResult.isNoView());
    assertFalse(getResult.isNoZoom());
    assertFalse(getResult.isPrinted());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  void testGetAnnotations7() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationFileAttachment());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    FDFAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof FDFAnnotationFileAttachment);
    assertEquals("", getResult.getRichContents());
    assertNull(getResult.getColor());
    assertNull(getResult.getPage());
    assertNull(getResult.getContents());
    assertNull(getResult.getDate());
    assertNull(getResult.getIntent());
    assertNull(getResult.getName());
    assertNull(getResult.getSubject());
    assertNull(getResult.getTitle());
    assertNull(getResult.getCreationDate());
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getRectangle());
    assertNull(getResult.getBorderEffect());
    assertNull(getResult.getBorderStyle());
    assertEquals(1.0f, getResult.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(getResult.isHidden());
    assertFalse(getResult.isInvisible());
    assertFalse(getResult.isLocked());
    assertFalse(getResult.isLockedContents());
    assertFalse(getResult.isNoRotate());
    assertFalse(getResult.isNoView());
    assertFalse(getResult.isNoZoom());
    assertFalse(getResult.isPrinted());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  void testGetAnnotations8() throws IOException {
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
    assertEquals("", getResult.getRichContents());
    assertEquals("0", ((FDFAnnotationFreeText) getResult).getJustification());
    assertNull(((FDFAnnotationFreeText) getResult).getCallout());
    assertNull(getResult.getColor());
    assertNull(getResult.getPage());
    assertNull(getResult.getContents());
    assertNull(getResult.getDate());
    assertNull(getResult.getIntent());
    assertNull(getResult.getName());
    assertNull(getResult.getSubject());
    assertNull(getResult.getTitle());
    assertNull(((FDFAnnotationFreeText) getResult).getDefaultAppearance());
    assertNull(((FDFAnnotationFreeText) getResult).getDefaultStyle());
    assertNull(((FDFAnnotationFreeText) getResult).getLineEndingStyle());
    assertNull(((FDFAnnotationFreeText) getResult).getRotation());
    assertNull(getResult.getCreationDate());
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getRectangle());
    assertNull(((FDFAnnotationFreeText) getResult).getFringe());
    assertNull(getResult.getBorderEffect());
    assertNull(getResult.getBorderStyle());
    assertEquals(1.0f, getResult.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(getResult.isHidden());
    assertFalse(getResult.isInvisible());
    assertFalse(getResult.isLocked());
    assertFalse(getResult.isLockedContents());
    assertFalse(getResult.isNoRotate());
    assertFalse(getResult.isNoView());
    assertFalse(getResult.isNoZoom());
    assertFalse(getResult.isPrinted());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  void testGetAnnotations9() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationHighlight());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    FDFAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof FDFAnnotationHighlight);
    assertEquals("", getResult.getRichContents());
    assertNull(((FDFAnnotationHighlight) getResult).getCoords());
    assertNull(getResult.getColor());
    assertNull(getResult.getPage());
    assertNull(getResult.getContents());
    assertNull(getResult.getDate());
    assertNull(getResult.getIntent());
    assertNull(getResult.getName());
    assertNull(getResult.getSubject());
    assertNull(getResult.getTitle());
    assertNull(getResult.getCreationDate());
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getRectangle());
    assertNull(getResult.getBorderEffect());
    assertNull(getResult.getBorderStyle());
    assertEquals(1.0f, getResult.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(getResult.isHidden());
    assertFalse(getResult.isInvisible());
    assertFalse(getResult.isLocked());
    assertFalse(getResult.isLockedContents());
    assertFalse(getResult.isNoRotate());
    assertFalse(getResult.isNoView());
    assertFalse(getResult.isNoZoom());
    assertFalse(getResult.isPrinted());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  void testGetAnnotations10() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationInk());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    FDFAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof FDFAnnotationInk);
    assertEquals("", getResult.getRichContents());
    assertNull(getResult.getColor());
    assertNull(getResult.getPage());
    assertNull(getResult.getContents());
    assertNull(getResult.getDate());
    assertNull(getResult.getIntent());
    assertNull(getResult.getName());
    assertNull(getResult.getSubject());
    assertNull(getResult.getTitle());
    assertNull(getResult.getCreationDate());
    assertNull(((FDFAnnotationInk) getResult).getInkList());
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getRectangle());
    assertNull(getResult.getBorderEffect());
    assertNull(getResult.getBorderStyle());
    assertEquals(1.0f, getResult.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(getResult.isHidden());
    assertFalse(getResult.isInvisible());
    assertFalse(getResult.isLocked());
    assertFalse(getResult.isLockedContents());
    assertFalse(getResult.isNoRotate());
    assertFalse(getResult.isNoView());
    assertFalse(getResult.isNoZoom());
    assertFalse(getResult.isPrinted());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  void testGetAnnotations11() throws IOException {
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
    assertEquals("", getResult.getRichContents());
    assertEquals("None", ((FDFAnnotationLine) getResult).getEndPointEndingStyle());
    assertEquals("None", ((FDFAnnotationLine) getResult).getStartPointEndingStyle());
    assertNull(((FDFAnnotationLine) getResult).getLine());
    assertNull(getResult.getColor());
    assertNull(((FDFAnnotationLine) getResult).getInteriorColor());
    assertNull(getResult.getPage());
    assertNull(getResult.getContents());
    assertNull(getResult.getDate());
    assertNull(getResult.getIntent());
    assertNull(getResult.getName());
    assertNull(getResult.getSubject());
    assertNull(getResult.getTitle());
    assertNull(((FDFAnnotationLine) getResult).getCaptionStyle());
    assertNull(getResult.getCreationDate());
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getRectangle());
    assertNull(getResult.getBorderEffect());
    assertNull(getResult.getBorderStyle());
    assertEquals(-1.0f, ((FDFAnnotationLine) getResult).getLeaderExtend());
    assertEquals(-1.0f, ((FDFAnnotationLine) getResult).getLeaderLength());
    assertEquals(-1.0f, ((FDFAnnotationLine) getResult).getLeaderOffset());
    assertEquals(0.0f, ((FDFAnnotationLine) getResult).getCaptionHorizontalOffset());
    assertEquals(0.0f, ((FDFAnnotationLine) getResult).getCaptionVerticalOffset());
    assertEquals(1.0f, getResult.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(getResult.isHidden());
    assertFalse(getResult.isInvisible());
    assertFalse(getResult.isLocked());
    assertFalse(getResult.isLockedContents());
    assertFalse(getResult.isNoRotate());
    assertFalse(getResult.isNoView());
    assertFalse(getResult.isNoZoom());
    assertFalse(getResult.isPrinted());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult.isToggleNoView());
    assertFalse(((FDFAnnotationLine) getResult).getCaption());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  void testGetAnnotations12() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationLink());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    FDFAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof FDFAnnotationLink);
    assertEquals("", getResult.getRichContents());
    assertNull(getResult.getColor());
    assertNull(getResult.getPage());
    assertNull(getResult.getContents());
    assertNull(getResult.getDate());
    assertNull(getResult.getIntent());
    assertNull(getResult.getName());
    assertNull(getResult.getSubject());
    assertNull(getResult.getTitle());
    assertNull(getResult.getCreationDate());
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getRectangle());
    assertNull(getResult.getBorderEffect());
    assertNull(getResult.getBorderStyle());
    assertEquals(1.0f, getResult.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(getResult.isHidden());
    assertFalse(getResult.isInvisible());
    assertFalse(getResult.isLocked());
    assertFalse(getResult.isLockedContents());
    assertFalse(getResult.isNoRotate());
    assertFalse(getResult.isNoView());
    assertFalse(getResult.isNoZoom());
    assertFalse(getResult.isPrinted());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  void testGetAnnotations13() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationPolygon());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    FDFAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof FDFAnnotationPolygon);
    assertEquals("", getResult.getRichContents());
    assertNull(((FDFAnnotationPolygon) getResult).getVertices());
    assertNull(getResult.getColor());
    assertNull(((FDFAnnotationPolygon) getResult).getInteriorColor());
    assertNull(getResult.getPage());
    assertNull(getResult.getContents());
    assertNull(getResult.getDate());
    assertNull(getResult.getIntent());
    assertNull(getResult.getName());
    assertNull(getResult.getSubject());
    assertNull(getResult.getTitle());
    assertNull(getResult.getCreationDate());
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getRectangle());
    assertNull(getResult.getBorderEffect());
    assertNull(getResult.getBorderStyle());
    assertEquals(1.0f, getResult.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(getResult.isHidden());
    assertFalse(getResult.isInvisible());
    assertFalse(getResult.isLocked());
    assertFalse(getResult.isLockedContents());
    assertFalse(getResult.isNoRotate());
    assertFalse(getResult.isNoView());
    assertFalse(getResult.isNoZoom());
    assertFalse(getResult.isPrinted());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  void testGetAnnotations14() throws IOException {
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
    assertEquals("", getResult.getRichContents());
    assertEquals("None", ((FDFAnnotationPolyline) getResult).getEndPointEndingStyle());
    assertEquals("None", ((FDFAnnotationPolyline) getResult).getStartPointEndingStyle());
    assertNull(((FDFAnnotationPolyline) getResult).getVertices());
    assertNull(getResult.getColor());
    assertNull(((FDFAnnotationPolyline) getResult).getInteriorColor());
    assertNull(getResult.getPage());
    assertNull(getResult.getContents());
    assertNull(getResult.getDate());
    assertNull(getResult.getIntent());
    assertNull(getResult.getName());
    assertNull(getResult.getSubject());
    assertNull(getResult.getTitle());
    assertNull(getResult.getCreationDate());
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getRectangle());
    assertNull(getResult.getBorderEffect());
    assertNull(getResult.getBorderStyle());
    assertEquals(1.0f, getResult.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(getResult.isHidden());
    assertFalse(getResult.isInvisible());
    assertFalse(getResult.isLocked());
    assertFalse(getResult.isLockedContents());
    assertFalse(getResult.isNoRotate());
    assertFalse(getResult.isNoView());
    assertFalse(getResult.isNoZoom());
    assertFalse(getResult.isPrinted());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  void testGetAnnotations15() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationSound());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    FDFAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof FDFAnnotationSound);
    assertEquals("", getResult.getRichContents());
    assertNull(getResult.getColor());
    assertNull(getResult.getPage());
    assertNull(getResult.getContents());
    assertNull(getResult.getDate());
    assertNull(getResult.getIntent());
    assertNull(getResult.getName());
    assertNull(getResult.getSubject());
    assertNull(getResult.getTitle());
    assertNull(getResult.getCreationDate());
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getRectangle());
    assertNull(getResult.getBorderEffect());
    assertNull(getResult.getBorderStyle());
    assertEquals(1.0f, getResult.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(getResult.isHidden());
    assertFalse(getResult.isInvisible());
    assertFalse(getResult.isLocked());
    assertFalse(getResult.isLockedContents());
    assertFalse(getResult.isNoRotate());
    assertFalse(getResult.isNoView());
    assertFalse(getResult.isNoZoom());
    assertFalse(getResult.isPrinted());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  void testGetAnnotations16() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationSquare());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    FDFAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof FDFAnnotationSquare);
    assertEquals("", getResult.getRichContents());
    assertNull(getResult.getColor());
    assertNull(((FDFAnnotationSquare) getResult).getInteriorColor());
    assertNull(getResult.getPage());
    assertNull(getResult.getContents());
    assertNull(getResult.getDate());
    assertNull(getResult.getIntent());
    assertNull(getResult.getName());
    assertNull(getResult.getSubject());
    assertNull(getResult.getTitle());
    assertNull(getResult.getCreationDate());
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getRectangle());
    assertNull(((FDFAnnotationSquare) getResult).getFringe());
    assertNull(getResult.getBorderEffect());
    assertNull(getResult.getBorderStyle());
    assertEquals(1.0f, getResult.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(getResult.isHidden());
    assertFalse(getResult.isInvisible());
    assertFalse(getResult.isLocked());
    assertFalse(getResult.isLockedContents());
    assertFalse(getResult.isNoRotate());
    assertFalse(getResult.isNoView());
    assertFalse(getResult.isNoZoom());
    assertFalse(getResult.isPrinted());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  void testGetAnnotations17() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationSquiggly());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    FDFAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof FDFAnnotationSquiggly);
    assertEquals("", getResult.getRichContents());
    assertNull(((FDFAnnotationSquiggly) getResult).getCoords());
    assertNull(getResult.getColor());
    assertNull(getResult.getPage());
    assertNull(getResult.getContents());
    assertNull(getResult.getDate());
    assertNull(getResult.getIntent());
    assertNull(getResult.getName());
    assertNull(getResult.getSubject());
    assertNull(getResult.getTitle());
    assertNull(getResult.getCreationDate());
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getRectangle());
    assertNull(getResult.getBorderEffect());
    assertNull(getResult.getBorderStyle());
    assertEquals(1.0f, getResult.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(getResult.isHidden());
    assertFalse(getResult.isInvisible());
    assertFalse(getResult.isLocked());
    assertFalse(getResult.isLockedContents());
    assertFalse(getResult.isNoRotate());
    assertFalse(getResult.isNoView());
    assertFalse(getResult.isNoZoom());
    assertFalse(getResult.isPrinted());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  void testGetAnnotations18() throws IOException {
    // Arrange
    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationStamp());

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setAnnotations(annots);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    FDFAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof FDFAnnotationStamp);
    assertEquals("", getResult.getRichContents());
    assertNull(getResult.getColor());
    assertNull(getResult.getPage());
    assertNull(getResult.getContents());
    assertNull(getResult.getDate());
    assertNull(getResult.getIntent());
    assertNull(getResult.getName());
    assertNull(getResult.getSubject());
    assertNull(getResult.getTitle());
    assertNull(getResult.getCreationDate());
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getRectangle());
    assertNull(getResult.getBorderEffect());
    assertNull(getResult.getBorderStyle());
    assertEquals(1.0f, getResult.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(getResult.isHidden());
    assertFalse(getResult.isInvisible());
    assertFalse(getResult.isLocked());
    assertFalse(getResult.isLockedContents());
    assertFalse(getResult.isNoRotate());
    assertFalse(getResult.isNoView());
    assertFalse(getResult.isNoZoom());
    assertFalse(getResult.isPrinted());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#getAnnotations()}
   */
  @Test
  void testGetAnnotations19() throws IOException {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray id = new COSArray();
    id.add(object);

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setID(id);

    // Act
    List<FDFAnnotation> actualAnnotations = fdfDictionary.getAnnotations();

    // Assert
    verify(object).getCOSObject();
    assertNull(actualAnnotations);
  }

  /**
   * Method under test: {@link FDFDictionary#setAnnotations(List)}
   */
  @Test
  void testSetAnnotations() throws IOException {
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
   * Method under test: {@link FDFDictionary#setAnnotations(List)}
   */
  @Test
  void testSetAnnotations2() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.add(new FDFAnnotationCaret());

    // Act
    fdfDictionary.setAnnotations(annots);

    // Assert
    List<FDFAnnotation> annotations = fdfDictionary.getAnnotations();
    assertEquals(1, annotations.size());
    FDFAnnotation getResult = annotations.get(0);
    assertTrue(getResult instanceof FDFAnnotationCaret);
    assertEquals("", getResult.getRichContents());
    assertNull(getResult.getColor());
    assertNull(getResult.getPage());
    assertNull(getResult.getContents());
    assertNull(getResult.getDate());
    assertNull(getResult.getIntent());
    assertNull(getResult.getName());
    assertNull(getResult.getSubject());
    assertNull(getResult.getTitle());
    assertNull(((FDFAnnotationCaret) getResult).getSymbol());
    assertNull(getResult.getCreationDate());
    assertNull(getResult.getRectangle());
    assertNull(((FDFAnnotationCaret) getResult).getFringe());
    assertNull(getResult.getBorderEffect());
    assertNull(getResult.getBorderStyle());
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1.0f, getResult.getOpacity());
    assertFalse(getResult.isHidden());
    assertFalse(getResult.isInvisible());
    assertFalse(getResult.isLocked());
    assertFalse(getResult.isLockedContents());
    assertFalse(getResult.isNoRotate());
    assertFalse(getResult.isNoView());
    assertFalse(getResult.isNoZoom());
    assertFalse(getResult.isPrinted());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult.isToggleNoView());
  }

  /**
   * Method under test: {@link FDFDictionary#setAnnotations(List)}
   */
  @Test
  void testSetAnnotations3() throws IOException {
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
    FDFAnnotation getResult = annotations.get(0);
    assertTrue(getResult instanceof FDFAnnotationCaret);
    FDFAnnotation getResult2 = annotations.get(1);
    assertTrue(getResult2 instanceof FDFAnnotationCaret);
    assertEquals("", getResult.getRichContents());
    assertEquals("", getResult2.getRichContents());
    assertNull(getResult.getColor());
    assertNull(getResult2.getColor());
    assertNull(getResult.getPage());
    assertNull(getResult2.getPage());
    assertNull(getResult.getContents());
    assertNull(getResult2.getContents());
    assertNull(getResult.getDate());
    assertNull(getResult2.getDate());
    assertNull(getResult.getIntent());
    assertNull(getResult2.getIntent());
    assertNull(getResult.getName());
    assertNull(getResult2.getName());
    assertNull(getResult.getSubject());
    assertNull(getResult2.getSubject());
    assertNull(getResult.getTitle());
    assertNull(getResult2.getTitle());
    assertNull(((FDFAnnotationCaret) getResult).getSymbol());
    assertNull(((FDFAnnotationCaret) getResult2).getSymbol());
    assertNull(getResult.getCreationDate());
    assertNull(getResult2.getCreationDate());
    assertNull(getResult.getRectangle());
    assertNull(getResult2.getRectangle());
    assertNull(((FDFAnnotationCaret) getResult).getFringe());
    assertNull(((FDFAnnotationCaret) getResult2).getFringe());
    assertNull(getResult.getBorderEffect());
    assertNull(getResult2.getBorderEffect());
    assertNull(getResult.getBorderStyle());
    assertNull(getResult2.getBorderStyle());
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1.0f, getResult.getOpacity());
    assertEquals(1.0f, getResult2.getOpacity());
    assertFalse(getResult.isHidden());
    assertFalse(getResult2.isHidden());
    assertFalse(getResult.isInvisible());
    assertFalse(getResult2.isInvisible());
    assertFalse(getResult.isLocked());
    assertFalse(getResult2.isLocked());
    assertFalse(getResult.isLockedContents());
    assertFalse(getResult2.isLockedContents());
    assertFalse(getResult.isNoRotate());
    assertFalse(getResult2.isNoRotate());
    assertFalse(getResult.isNoView());
    assertFalse(getResult2.isNoView());
    assertFalse(getResult.isNoZoom());
    assertFalse(getResult2.isNoZoom());
    assertFalse(getResult.isPrinted());
    assertFalse(getResult2.isPrinted());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult2.isReadOnly());
    assertFalse(getResult.isToggleNoView());
    assertFalse(getResult2.isToggleNoView());
  }

  /**
   * Method under test: {@link FDFDictionary#setAnnotations(List)}
   */
  @Test
  void testSetAnnotations4() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    ArrayList<FDFAnnotation> annots = new ArrayList<>();
    annots.addAll(new ArrayList<>());
    annots.add(null);

    // Act
    fdfDictionary.setAnnotations(annots);

    // Assert
    List<FDFAnnotation> annotations = fdfDictionary.getAnnotations();
    assertEquals(1, annotations.size());
    assertNull(annotations.get(0));
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFDictionary#setAnnotations(List)}
   */
  @Test
  void testSetAnnotations5() throws IOException {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray id = new COSArray();
    id.add(object);

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setID(id);

    // Act
    fdfDictionary.setAnnotations(new ArrayList<>());

    // Assert
    verify(object).getCOSObject();
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(fdfDictionary.getAnnotations().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#getDifferences()}
   */
  @Test
  void testGetDifferences() {
    // Arrange, Act and Assert
    assertNull((new FDFDictionary()).getDifferences());
  }

  /**
   * Method under test: {@link FDFDictionary#getDifferences()}
   */
  @Test
  void testGetDifferences2() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    COSStream diff = new COSStream();
    fdfDictionary.setDifferences(diff);

    // Act and Assert
    assertSame(diff, fdfDictionary.getDifferences());
  }

  /**
   * Method under test: {@link FDFDictionary#getDifferences()}
   */
  @Test
  void testGetDifferences3() {
    // Arrange
    COSStream diff = new COSStream();
    diff.setKey(new COSObjectKey(1L, 1));

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setDifferences(diff);

    // Act and Assert
    assertSame(diff, fdfDictionary.getDifferences());
  }

  /**
   * Method under test: {@link FDFDictionary#getDifferences()}
   */
  @Test
  void testGetDifferences4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray id = new COSArray();
    id.add(object);

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setID(id);

    // Act
    COSStream actualDifferences = fdfDictionary.getDifferences();

    // Assert
    verify(object).getCOSObject();
    assertNull(actualDifferences);
  }

  /**
   * Method under test: {@link FDFDictionary#setDifferences(COSStream)}
   */
  @Test
  void testSetDifferences() {
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
   * Method under test: {@link FDFDictionary#setDifferences(COSStream)}
   */
  @Test
  void testSetDifferences2() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    // Act
    fdfDictionary.setDifferences(null);

    // Assert
    assertNull(fdfDictionary.getDifferences());
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#setDifferences(COSStream)}
   */
  @Test
  void testSetDifferences3() {
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
   * Method under test: {@link FDFDictionary#setDifferences(COSStream)}
   */
  @Test
  void testSetDifferences4() {
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
   * Method under test: {@link FDFDictionary#getTarget()}
   */
  @Test
  void testGetTarget() {
    // Arrange, Act and Assert
    assertNull((new FDFDictionary()).getTarget());
  }

  /**
   * Method under test: {@link FDFDictionary#getTarget()}
   */
  @Test
  void testGetTarget2() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setTarget("Target");

    // Act and Assert
    assertEquals("Target", fdfDictionary.getTarget());
  }

  /**
   * Method under test: {@link FDFDictionary#getTarget()}
   */
  @Test
  void testGetTarget3() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setTarget("");

    // Act and Assert
    assertEquals("", fdfDictionary.getTarget());
  }

  /**
   * Method under test: {@link FDFDictionary#getTarget()}
   */
  @Test
  void testGetTarget4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray id = new COSArray();
    id.add(object);

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setID(id);

    // Act
    String actualTarget = fdfDictionary.getTarget();

    // Assert
    verify(object).getCOSObject();
    assertNull(actualTarget);
  }

  /**
   * Method under test: {@link FDFDictionary#setTarget(String)}
   */
  @Test
  void testSetTarget() {
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
   * Method under test: {@link FDFDictionary#setTarget(String)}
   */
  @Test
  void testSetTarget2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray id = new COSArray();
    id.add(object);

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setID(id);

    // Act
    fdfDictionary.setTarget("Target");

    // Assert
    verify(object).getCOSObject();
    assertEquals("Target", fdfDictionary.getTarget());
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFDictionary#getEmbeddedFDFs()}
   */
  @Test
  void testGetEmbeddedFDFs() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFDictionary()).getEmbeddedFDFs());
  }

  /**
   * Method under test: {@link FDFDictionary#getEmbeddedFDFs()}
   */
  @Test
  void testGetEmbeddedFDFs2() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setEmbeddedFDFs(new ArrayList<>());

    // Act and Assert
    assertTrue(fdfDictionary.getEmbeddedFDFs().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#getEmbeddedFDFs()}
   */
  @Test
  void testGetEmbeddedFDFs3() throws IOException {
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
    COSBase cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = ((COSDictionary) cOSObject).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDComplexFileSpecification) getResult).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) getResult).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) getResult).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) getResult).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) getResult).getEmbeddedFileUnix());
    assertEquals(1, ((COSDictionary) cOSObject).getValues().size());
    assertEquals(1, ((COSDictionary) cOSObject).size());
    COSIncrement toIncrementResult = ((COSDictionary) cOSObject).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSDictionary) cOSObject).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDComplexFileSpecification) getResult).isVolatile());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#getEmbeddedFDFs()}
   */
  @Test
  void testGetEmbeddedFDFs4() throws IOException {
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
   * Method under test: {@link FDFDictionary#getEmbeddedFDFs()}
   */
  @Test
  void testGetEmbeddedFDFs5() throws IOException {
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
    assertEquals(0, ((COSString) cOSObject).getBytes().length);
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSString) cOSObject).getForceHexForm());
  }

  /**
   * Method under test: {@link FDFDictionary#getEmbeddedFDFs()}
   */
  @Test
  void testGetEmbeddedFDFs6() throws IOException {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray id = new COSArray();
    id.add(object);

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setID(id);

    // Act
    List<PDFileSpecification> actualEmbeddedFDFs = fdfDictionary.getEmbeddedFDFs();

    // Assert
    verify(object).getCOSObject();
    assertNull(actualEmbeddedFDFs);
  }

  /**
   * Method under test: {@link FDFDictionary#setEmbeddedFDFs(List)}
   */
  @Test
  void testSetEmbeddedFDFs() throws IOException {
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
   * Method under test: {@link FDFDictionary#setEmbeddedFDFs(List)}
   */
  @Test
  void testSetEmbeddedFDFs2() throws IOException {
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
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(((PDComplexFileSpecification) getResult).isVolatile());
  }

  /**
   * Method under test: {@link FDFDictionary#setEmbeddedFDFs(List)}
   */
  @Test
  void testSetEmbeddedFDFs3() throws IOException {
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
    PDFileSpecification getResult = embeddedFDFs.get(0);
    assertTrue(getResult instanceof PDComplexFileSpecification);
    PDFileSpecification getResult2 = embeddedFDFs.get(1);
    assertTrue(getResult2 instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) getResult).getFileDescription());
    assertNull(((PDComplexFileSpecification) getResult2).getFileDescription());
    assertNull(((PDComplexFileSpecification) getResult).getFileDos());
    assertNull(((PDComplexFileSpecification) getResult2).getFileDos());
    assertNull(((PDComplexFileSpecification) getResult).getFileMac());
    assertNull(((PDComplexFileSpecification) getResult2).getFileMac());
    assertNull(((PDComplexFileSpecification) getResult).getFileUnicode());
    assertNull(((PDComplexFileSpecification) getResult2).getFileUnicode());
    assertNull(((PDComplexFileSpecification) getResult).getFileUnix());
    assertNull(((PDComplexFileSpecification) getResult2).getFileUnix());
    assertNull(((PDComplexFileSpecification) getResult).getFilename());
    assertNull(((PDComplexFileSpecification) getResult2).getFilename());
    assertNull(getResult.getFile());
    assertNull(getResult2.getFile());
    assertNull(((PDComplexFileSpecification) getResult).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) getResult2).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) getResult).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) getResult2).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) getResult).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) getResult2).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) getResult).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) getResult2).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) getResult).getEmbeddedFileUnix());
    assertNull(((PDComplexFileSpecification) getResult2).getEmbeddedFileUnix());
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(((PDComplexFileSpecification) getResult).isVolatile());
    assertFalse(((PDComplexFileSpecification) getResult2).isVolatile());
  }

  /**
   * Method under test: {@link FDFDictionary#setEmbeddedFDFs(List)}
   */
  @Test
  void testSetEmbeddedFDFs4() throws IOException {
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
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFDictionary#setEmbeddedFDFs(List)}
   */
  @Test
  void testSetEmbeddedFDFs5() throws IOException {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    ArrayList<PDFileSpecification> embedded = new ArrayList<>();
    embedded.add(null);

    // Act
    fdfDictionary.setEmbeddedFDFs(embedded);

    // Assert
    List<PDFileSpecification> embeddedFDFs = fdfDictionary.getEmbeddedFDFs();
    assertEquals(1, embeddedFDFs.size());
    assertNull(embeddedFDFs.get(0));
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFDictionary#setEmbeddedFDFs(List)}
   */
  @Test
  void testSetEmbeddedFDFs6() throws IOException {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray id = new COSArray();
    id.add(object);

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setID(id);

    // Act
    fdfDictionary.setEmbeddedFDFs(new ArrayList<>());

    // Assert
    verify(object).getCOSObject();
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(fdfDictionary.getEmbeddedFDFs().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#getJavaScript()}
   */
  @Test
  void testGetJavaScript() {
    // Arrange, Act and Assert
    assertNull((new FDFDictionary()).getJavaScript());
  }

  /**
   * Method under test: {@link FDFDictionary#getJavaScript()}
   */
  @Test
  void testGetJavaScript2() {
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
   * Method under test: {@link FDFDictionary#getJavaScript()}
   */
  @Test
  void testGetJavaScript3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray id = new COSArray();
    id.add(object);

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setID(id);

    // Act
    FDFJavaScript actualJavaScript = fdfDictionary.getJavaScript();

    // Assert
    verify(object).getCOSObject();
    assertNull(actualJavaScript);
  }

  /**
   * Method under test: {@link FDFDictionary#setJavaScript(FDFJavaScript)}
   */
  @Test
  void testSetJavaScript() {
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
   * Method under test: {@link FDFDictionary#setJavaScript(FDFJavaScript)}
   */
  @Test
  void testSetJavaScript2() {
    // Arrange
    FDFDictionary fdfDictionary = new FDFDictionary();

    // Act
    fdfDictionary.setJavaScript(null);

    // Assert
    assertNull(fdfDictionary.getJavaScript());
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Method under test: {@link FDFDictionary#setJavaScript(FDFJavaScript)}
   */
  @Test
  void testSetJavaScript3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray id = new COSArray();
    id.add(object);

    FDFDictionary fdfDictionary = new FDFDictionary();
    fdfDictionary.setID(id);

    // Act
    fdfDictionary.setJavaScript(new FDFJavaScript());

    // Assert
    verify(object).getCOSObject();
    FDFJavaScript javaScript = fdfDictionary.getJavaScript();
    assertNull(javaScript.getAfter());
    assertNull(javaScript.getBefore());
    assertNull(javaScript.getDoc());
    COSDictionary cOSObject = fdfDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFDictionary#FDFDictionary(COSDictionary)}
   */
  @Test
  void testNewFDFDictionary() {
    // Arrange
    COSDictionary fdfDictionary = new COSDictionary();

    // Act and Assert
    assertSame(fdfDictionary, (new FDFDictionary(fdfDictionary)).getCOSObject());
  }

  /**
   * Method under test: {@link FDFDictionary#FDFDictionary()}
   */
  @Test
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
    COSDictionary cOSObject = actualFdfDictionary.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfDictionary.getDifferences());
    assertNull(actualFdfDictionary.getFile());
    assertNull(actualFdfDictionary.getJavaScript());
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
   * Method under test: {@link FDFDictionary#FDFDictionary(Element)}
   */
  @Test
  void testNewFDFDictionary3() throws IOException {
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
    COSDictionary cOSObject = actualFdfDictionary.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfDictionary.getDifferences());
    assertNull(actualFdfDictionary.getFile());
    assertNull(actualFdfDictionary.getJavaScript());
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
   * Method under test: {@link FDFDictionary#FDFDictionary(Element)}
   */
  @Test
  void testNewFDFDictionary4() throws IOException {
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
    COSDictionary cOSObject = actualFdfDictionary.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfDictionary.getDifferences());
    assertNull(actualFdfDictionary.getFile());
    assertNull(actualFdfDictionary.getJavaScript());
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
   * Method under test: {@link FDFDictionary#FDFDictionary(Element)}
   */
  @Test
  void testNewFDFDictionary5() throws IOException {
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
    COSDictionary cOSObject = actualFdfDictionary.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfDictionary.getDifferences());
    assertNull(actualFdfDictionary.getFile());
    assertNull(actualFdfDictionary.getJavaScript());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}

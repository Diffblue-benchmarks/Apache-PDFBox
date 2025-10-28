package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.filespecification.PDComplexFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDSimpleFileSpecification;
import org.junit.jupiter.api.Test;

class PDActionSubmitFormDiffblueTest {
  /**
   * Method under test: {@link PDActionSubmitForm#getFile()}
   */
  @Test
  void testGetFile() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDActionSubmitForm()).getFile());
  }

  /**
   * Method under test: {@link PDActionSubmitForm#getFile()}
   */
  @Test
  void testGetFile2() throws IOException {
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
   * Method under test: {@link PDActionSubmitForm#getFile()}
   */
  @Test
  void testGetFile3() throws IOException {
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
    assertEquals(0, ((COSString) cOSObject).getBytes().length);
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSString) cOSObject).getForceHexForm());
  }

  /**
   * Method under test: {@link PDActionSubmitForm#getFile()}
   */
  @Test
  void testGetFile4() throws IOException {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);

    PDActionSubmitForm pdActionSubmitForm = new PDActionSubmitForm();
    pdActionSubmitForm.setFields(array);

    // Act
    PDFileSpecification actualFile = pdActionSubmitForm.getFile();

    // Assert
    verify(object).getCOSObject();
    assertNull(actualFile);
  }

  /**
   * Method under test: {@link PDActionSubmitForm#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile() throws IOException {
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
    COSDictionary cOSObject = pdActionSubmitForm.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(((PDComplexFileSpecification) file).isVolatile());
  }

  /**
   * Method under test: {@link PDActionSubmitForm#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile2() throws IOException {
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
   * Method under test: {@link PDActionSubmitForm#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile3() throws IOException {
    // Arrange
    PDActionSubmitForm pdActionSubmitForm = new PDActionSubmitForm();

    // Act
    pdActionSubmitForm.setFile(null);

    // Assert
    assertNull(pdActionSubmitForm.getFile());
    COSDictionary cOSObject = pdActionSubmitForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionSubmitForm#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile4() throws IOException {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);

    PDActionSubmitForm pdActionSubmitForm = new PDActionSubmitForm();
    pdActionSubmitForm.setFields(array);

    // Act
    pdActionSubmitForm.setFile(new PDComplexFileSpecification());

    // Assert
    verify(object).getCOSObject();
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
    COSDictionary cOSObject = pdActionSubmitForm.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(((PDComplexFileSpecification) file).isVolatile());
  }

  /**
   * Method under test: {@link PDActionSubmitForm#getFields()}
   */
  @Test
  void testGetFields() {
    // Arrange, Act and Assert
    assertNull((new PDActionSubmitForm()).getFields());
  }

  /**
   * Method under test: {@link PDActionSubmitForm#getFields()}
   */
  @Test
  void testGetFields2() {
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
   * Method under test: {@link PDActionSubmitForm#getFields()}
   */
  @Test
  void testGetFields3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);

    PDActionSubmitForm pdActionSubmitForm = new PDActionSubmitForm();
    pdActionSubmitForm.setFields(array);

    // Act
    COSArray actualFields = pdActionSubmitForm.getFields();

    // Assert
    verify(object).getCOSObject();
    assertSame(array, actualFields);
  }

  /**
   * Method under test: {@link PDActionSubmitForm#setFields(COSArray)}
   */
  @Test
  void testSetFields() {
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
   * Method under test: {@link PDActionSubmitForm#setFields(COSArray)}
   */
  @Test
  void testSetFields2() {
    // Arrange
    PDActionSubmitForm pdActionSubmitForm = new PDActionSubmitForm();

    // Act
    pdActionSubmitForm.setFields(null);

    // Assert
    assertNull(pdActionSubmitForm.getFields());
    COSDictionary cOSObject = pdActionSubmitForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionSubmitForm#setFields(COSArray)}
   */
  @Test
  void testSetFields3() {
    // Arrange
    PDActionSubmitForm pdActionSubmitForm = new PDActionSubmitForm();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);

    // Act
    pdActionSubmitForm.setFields(array);

    // Assert
    verify(object).getCOSObject();
    COSDictionary cOSObject = pdActionSubmitForm.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(array, pdActionSubmitForm.getFields());
  }

  /**
   * Method under test: {@link PDActionSubmitForm#getFlags()}
   */
  @Test
  void testGetFlags() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDActionSubmitForm()).getFlags());
  }

  /**
   * Method under test: {@link PDActionSubmitForm#getFlags()}
   */
  @Test
  void testGetFlags2() {
    // Arrange
    PDActionSubmitForm pdActionSubmitForm = new PDActionSubmitForm();
    pdActionSubmitForm.setFlags(1);

    // Act and Assert
    assertEquals(1, pdActionSubmitForm.getFlags());
  }

  /**
   * Method under test: {@link PDActionSubmitForm#getFlags()}
   */
  @Test
  void testGetFlags3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);

    PDActionSubmitForm pdActionSubmitForm = new PDActionSubmitForm();
    pdActionSubmitForm.setFields(array);

    // Act
    int actualFlags = pdActionSubmitForm.getFlags();

    // Assert
    verify(object).getCOSObject();
    assertEquals(0, actualFlags);
  }

  /**
   * Method under test: {@link PDActionSubmitForm#setFlags(int)}
   */
  @Test
  void testSetFlags() {
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
   * Method under test: {@link PDActionSubmitForm#setFlags(int)}
   */
  @Test
  void testSetFlags2() {
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

  /**
   * Method under test: {@link PDActionSubmitForm#setFlags(int)}
   */
  @Test
  void testSetFlags3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);

    PDActionSubmitForm pdActionSubmitForm = new PDActionSubmitForm();
    pdActionSubmitForm.setFields(array);

    // Act
    pdActionSubmitForm.setFlags(1);

    // Assert
    verify(object).getCOSObject();
    assertEquals(1, pdActionSubmitForm.getFlags());
    COSDictionary cOSObject = pdActionSubmitForm.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDActionSubmitForm#PDActionSubmitForm(COSDictionary)}
   */
  @Test
  void testNewPDActionSubmitForm() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDActionSubmitForm(a)).getCOSObject());
  }

  /**
   * Method under test: {@link PDActionSubmitForm#PDActionSubmitForm()}
   */
  @Test
  void testNewPDActionSubmitForm2() throws IOException {
    // Arrange and Act
    PDActionSubmitForm actualPdActionSubmitForm = new PDActionSubmitForm();

    // Assert
    assertNull(actualPdActionSubmitForm.getNext());
    assertNull(actualPdActionSubmitForm.getFields());
    COSDictionary cOSObject = actualPdActionSubmitForm.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdActionSubmitForm.getFile());
    assertEquals(0, actualPdActionSubmitForm.getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPdActionSubmitForm.getType());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualPdActionSubmitForm.getSubType());
  }
}

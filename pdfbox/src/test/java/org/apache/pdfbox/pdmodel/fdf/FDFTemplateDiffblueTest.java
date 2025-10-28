package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.junit.jupiter.api.Test;

class FDFTemplateDiffblueTest {
  /**
   * Method under test: {@link FDFTemplate#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new FDFTemplate()).getCOSObject();

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
   * Method under test: {@link FDFTemplate#getTemplateReference()}
   */
  @Test
  void testGetTemplateReference() {
    // Arrange, Act and Assert
    assertNull((new FDFTemplate()).getTemplateReference());
  }

  /**
   * Method under test: {@link FDFTemplate#getTemplateReference()}
   */
  @Test
  void testGetTemplateReference2() throws IOException {
    // Arrange
    FDFTemplate fdfTemplate = new FDFTemplate();
    fdfTemplate.setTemplateReference(new FDFNamedPageReference());

    // Act
    FDFNamedPageReference actualTemplateReference = fdfTemplate.getTemplateReference();

    // Assert
    assertNull(actualTemplateReference.getName());
    COSDictionary cOSObject = actualTemplateReference.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualTemplateReference.getFileSpecification());
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
   * Method under test: {@link FDFTemplate#getTemplateReference()}
   */
  @Test
  void testGetTemplateReference3() throws IOException {
    // Arrange
    COSDictionary r = new COSDictionary();
    r.setKey(new COSObjectKey(1L, 1));
    FDFNamedPageReference tRef = new FDFNamedPageReference(r);

    FDFTemplate fdfTemplate = new FDFTemplate();
    fdfTemplate.setTemplateReference(tRef);

    // Act
    FDFNamedPageReference actualTemplateReference = fdfTemplate.getTemplateReference();

    // Assert
    assertNull(actualTemplateReference.getName());
    assertNull(actualTemplateReference.getFileSpecification());
    assertSame(r, actualTemplateReference.getCOSObject());
  }

  /**
   * Method under test:
   * {@link FDFTemplate#setTemplateReference(FDFNamedPageReference)}
   */
  @Test
  void testSetTemplateReference() throws IOException {
    // Arrange
    FDFTemplate fdfTemplate = new FDFTemplate();

    // Act
    fdfTemplate.setTemplateReference(new FDFNamedPageReference());

    // Assert
    FDFNamedPageReference templateReference = fdfTemplate.getTemplateReference();
    assertNull(templateReference.getName());
    assertNull(templateReference.getFileSpecification());
    COSDictionary cOSObject = fdfTemplate.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link FDFTemplate#setTemplateReference(FDFNamedPageReference)}
   */
  @Test
  void testSetTemplateReference2() {
    // Arrange
    FDFTemplate fdfTemplate = new FDFTemplate();

    // Act
    fdfTemplate.setTemplateReference(null);

    // Assert
    assertNull(fdfTemplate.getTemplateReference());
    COSDictionary cOSObject = fdfTemplate.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Method under test:
   * {@link FDFTemplate#setTemplateReference(FDFNamedPageReference)}
   */
  @Test
  void testSetTemplateReference3() throws IOException {
    // Arrange
    FDFTemplate fdfTemplate = new FDFTemplate();

    COSDictionary r = new COSDictionary();
    r.setDirect(true);

    // Act
    fdfTemplate.setTemplateReference(new FDFNamedPageReference(r));

    // Assert
    FDFNamedPageReference templateReference = fdfTemplate.getTemplateReference();
    assertNull(templateReference.getName());
    assertNull(templateReference.getFileSpecification());
    COSDictionary cOSObject = fdfTemplate.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(r, templateReference.getCOSObject());
  }

  /**
   * Method under test:
   * {@link FDFTemplate#setTemplateReference(FDFNamedPageReference)}
   */
  @Test
  void testSetTemplateReference4() throws IOException {
    // Arrange
    FDFTemplate fdfTemplate = new FDFTemplate();

    COSDictionary r = new COSDictionary();
    r.setKey(new COSObjectKey(1L, 1));

    // Act
    fdfTemplate.setTemplateReference(new FDFNamedPageReference(r));

    // Assert
    FDFNamedPageReference templateReference = fdfTemplate.getTemplateReference();
    assertNull(templateReference.getName());
    assertNull(templateReference.getFileSpecification());
    COSDictionary cOSObject = fdfTemplate.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(r, templateReference.getCOSObject());
  }

  /**
   * Method under test: {@link FDFTemplate#getFields()}
   */
  @Test
  void testGetFields() {
    // Arrange, Act and Assert
    assertNull((new FDFTemplate()).getFields());
  }

  /**
   * Method under test: {@link FDFTemplate#getFields()}
   */
  @Test
  void testGetFields2() {
    // Arrange
    FDFTemplate fdfTemplate = new FDFTemplate();
    fdfTemplate.setFields(new ArrayList<>());

    // Act and Assert
    assertTrue(fdfTemplate.getFields().isEmpty());
  }

  /**
   * Method under test: {@link FDFTemplate#getFields()}
   */
  @Test
  void testGetFields3() throws IOException {
    // Arrange
    ArrayList<FDFField> fields = new ArrayList<>();
    fields.add(new FDFField());

    FDFTemplate fdfTemplate = new FDFTemplate();
    fdfTemplate.setFields(fields);

    // Act
    List<FDFField> actualFields = fdfTemplate.getFields();

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
   * Method under test: {@link FDFTemplate#getFields()}
   */
  @Test
  void testGetFields4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument value = new COSDocument(streamCacheCreateFunction);

    FDFField fdfField = new FDFField();
    fdfField.setValue(value);

    ArrayList<FDFField> fields = new ArrayList<>();
    fields.add(fdfField);

    FDFTemplate fdfTemplate = new FDFTemplate();
    fdfTemplate.setFields(fields);

    // Act
    List<FDFField> actualFields = fdfTemplate.getFields();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualFields.size());
    FDFField getResult = actualFields.get(0);
    assertNull(getResult.getClearFieldFlags());
    assertNull(getResult.getClearWidgetFieldFlags());
    assertNull(getResult.getFieldFlags());
    assertNull(getResult.getSetFieldFlags());
    assertNull(getResult.getSetWidgetFieldFlags());
    assertNull(getResult.getWidgetFieldFlags());
    assertNull(getResult.getPartialFieldName());
    assertNull(getResult.getRichText());
    assertNull(getResult.getOptions());
    assertNull(getResult.getKids());
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getIconFit());
    assertNull(getResult.getAppearanceStreamReference());
    assertNull(getResult.getAction());
    assertNull(getResult.getAdditionalActions());
    assertNull(getResult.getAppearanceDictionary());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link FDFTemplate#setFields(List)}
   */
  @Test
  void testSetFields() {
    // Arrange
    FDFTemplate fdfTemplate = new FDFTemplate();

    // Act
    fdfTemplate.setFields(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = fdfTemplate.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(fdfTemplate.getFields().isEmpty());
  }

  /**
   * Method under test: {@link FDFTemplate#setFields(List)}
   */
  @Test
  void testSetFields2() throws IOException {
    // Arrange
    FDFTemplate fdfTemplate = new FDFTemplate();

    ArrayList<FDFField> fields = new ArrayList<>();
    fields.add(new FDFField());

    // Act
    fdfTemplate.setFields(fields);

    // Assert
    List<FDFField> fields2 = fdfTemplate.getFields();
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
    COSDictionary cOSObject = fdfTemplate.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFTemplate#setFields(List)}
   */
  @Test
  void testSetFields3() throws IOException {
    // Arrange
    FDFTemplate fdfTemplate = new FDFTemplate();

    ArrayList<FDFField> fields = new ArrayList<>();
    fields.add(new FDFField());
    fields.add(new FDFField());

    // Act
    fdfTemplate.setFields(fields);

    // Assert
    List<FDFField> fields2 = fdfTemplate.getFields();
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
    COSDictionary cOSObject = fdfTemplate.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFTemplate#setFields(List)}
   */
  @Test
  void testSetFields4() {
    // Arrange
    FDFTemplate fdfTemplate = new FDFTemplate();

    ArrayList<FDFField> fields = new ArrayList<>();
    fields.add(null);

    // Act
    fdfTemplate.setFields(fields);

    // Assert
    List<FDFField> fields2 = fdfTemplate.getFields();
    assertEquals(1, fields2.size());
    assertNull(fields2.get(0).getCOSObject());
    COSDictionary cOSObject = fdfTemplate.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFTemplate#setFields(List)}
   */
  @Test
  void testSetFields5() throws IOException {
    // Arrange
    FDFTemplate fdfTemplate = new FDFTemplate();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument value = new COSDocument(streamCacheCreateFunction);

    FDFField fdfField = new FDFField();
    fdfField.setValue(value);

    ArrayList<FDFField> fields = new ArrayList<>();
    fields.add(fdfField);

    // Act
    fdfTemplate.setFields(fields);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<FDFField> fields2 = fdfTemplate.getFields();
    assertEquals(1, fields2.size());
    FDFField getResult = fields2.get(0);
    assertNull(getResult.getClearFieldFlags());
    assertNull(getResult.getClearWidgetFieldFlags());
    assertNull(getResult.getFieldFlags());
    assertNull(getResult.getSetFieldFlags());
    assertNull(getResult.getSetWidgetFieldFlags());
    assertNull(getResult.getWidgetFieldFlags());
    assertNull(getResult.getPartialFieldName());
    assertNull(getResult.getRichText());
    assertNull(getResult.getOptions());
    assertNull(getResult.getKids());
    assertNull(getResult.getIconFit());
    assertNull(getResult.getAppearanceStreamReference());
    assertNull(getResult.getAction());
    assertNull(getResult.getAdditionalActions());
    assertNull(getResult.getAppearanceDictionary());
    COSDictionary cOSObject = fdfTemplate.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFTemplate#shouldRename()}
   */
  @Test
  void testShouldRename() {
    // Arrange, Act and Assert
    assertFalse((new FDFTemplate()).shouldRename());
  }

  /**
   * Method under test: {@link FDFTemplate#shouldRename()}
   */
  @Test
  void testShouldRename2() {
    // Arrange
    FDFTemplate fdfTemplate = new FDFTemplate();
    fdfTemplate.setRename(true);

    // Act and Assert
    assertTrue(fdfTemplate.shouldRename());
  }

  /**
   * Method under test: {@link FDFTemplate#shouldRename()}
   */
  @Test
  void testShouldRename3() {
    // Arrange
    FDFTemplate fdfTemplate = new FDFTemplate();
    fdfTemplate.setRename(false);

    // Act and Assert
    assertFalse(fdfTemplate.shouldRename());
  }

  /**
   * Method under test: {@link FDFTemplate#setRename(boolean)}
   */
  @Test
  void testSetRename() {
    // Arrange
    FDFTemplate fdfTemplate = new FDFTemplate();

    // Act
    fdfTemplate.setRename(true);

    // Assert
    COSDictionary cOSObject = fdfTemplate.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFTemplate#setRename(boolean)}
   */
  @Test
  void testSetRename2() {
    // Arrange
    FDFTemplate fdfTemplate = new FDFTemplate();

    // Act
    fdfTemplate.setRename(false);

    // Assert
    COSDictionary cOSObject = fdfTemplate.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFTemplate#FDFTemplate(COSDictionary)}
   */
  @Test
  void testNewFDFTemplate() {
    // Arrange
    COSDictionary t = new COSDictionary();

    // Act and Assert
    assertSame(t, (new FDFTemplate(t)).getCOSObject());
  }

  /**
   * Method under test: {@link FDFTemplate#FDFTemplate()}
   */
  @Test
  void testNewFDFTemplate2() {
    // Arrange and Act
    FDFTemplate actualFdfTemplate = new FDFTemplate();

    // Assert
    assertNull(actualFdfTemplate.getFields());
    COSDictionary cOSObject = actualFdfTemplate.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfTemplate.getTemplateReference());
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

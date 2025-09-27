package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FDFTemplateDiffblueTest {
  /**
   * Test {@link FDFTemplate#FDFTemplate(COSDictionary)}.
   *
   * <p>Method under test: {@link FDFTemplate#FDFTemplate(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFTemplate(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFTemplate.<init>(COSDictionary)"})
  void testNewFDFTemplate() {
    // Arrange
    COSDictionary t = new COSDictionary();

    // Act and Assert
    assertSame(t, new FDFTemplate(t).getCOSObject());
  }

  /**
   * Test {@link FDFTemplate#FDFTemplate()}.
   *
   * <p>Method under test: {@link FDFTemplate#FDFTemplate()}
   */
  @Test
  @DisplayName("Test new FDFTemplate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFTemplate.<init>()"})
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

  /**
   * Test {@link FDFTemplate#getCOSObject()}.
   *
   * <p>Method under test: {@link FDFTemplate#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary FDFTemplate.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new FDFTemplate().getCOSObject();

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
   * Test {@link FDFTemplate#getTemplateReference()}.
   *
   * <ul>
   *   <li>Given {@link FDFTemplate#FDFTemplate()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFTemplate#getTemplateReference()}
   */
  @Test
  @DisplayName("Test getTemplateReference(); given FDFTemplate(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FDFNamedPageReference FDFTemplate.getTemplateReference()"})
  void testGetTemplateReference_givenFDFTemplate_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFTemplate().getTemplateReference());
  }

  /**
   * Test {@link FDFTemplate#getTemplateReference()}.
   *
   * <ul>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link FDFTemplate#getTemplateReference()}
   */
  @Test
  @DisplayName("Test getTemplateReference(); then return COSObject is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FDFNamedPageReference FDFTemplate.getTemplateReference()"})
  void testGetTemplateReference_thenReturnCOSObjectIsCOSDictionary() {
    // Arrange
    COSDictionary r = new COSDictionary();
    r.setKey(new COSObjectKey(1L, 1));
    FDFNamedPageReference tRef = new FDFNamedPageReference(r);

    FDFTemplate fdfTemplate = new FDFTemplate();
    fdfTemplate.setTemplateReference(tRef);

    // Act and Assert
    assertSame(r, fdfTemplate.getTemplateReference().getCOSObject());
  }

  /**
   * Test {@link FDFTemplate#getTemplateReference()}.
   *
   * <ul>
   *   <li>Then return Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFTemplate#getTemplateReference()}
   */
  @Test
  @DisplayName("Test getTemplateReference(); then return Name is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FDFNamedPageReference FDFTemplate.getTemplateReference()"})
  void testGetTemplateReference_thenReturnNameIsNull() throws IOException {
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
   * Test {@link FDFTemplate#setTemplateReference(FDFNamedPageReference)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link FDFTemplate#setTemplateReference(FDFNamedPageReference)}
   */
  @Test
  @DisplayName(
      "Test setTemplateReference(FDFNamedPageReference); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFTemplate.setTemplateReference(FDFNamedPageReference)"})
  void testSetTemplateReference_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
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
   * Test {@link FDFTemplate#setTemplateReference(FDFNamedPageReference)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFTemplate#setTemplateReference(FDFNamedPageReference)}
   */
  @Test
  @DisplayName(
      "Test setTemplateReference(FDFNamedPageReference); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFTemplate.setTemplateReference(FDFNamedPageReference)"})
  void testSetTemplateReference_givenTrue_whenCOSDictionaryDirectIsTrue() throws IOException {
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
   * Test {@link FDFTemplate#setTemplateReference(FDFNamedPageReference)}.
   *
   * <ul>
   *   <li>When {@link FDFNamedPageReference#FDFNamedPageReference()}.
   * </ul>
   *
   * <p>Method under test: {@link FDFTemplate#setTemplateReference(FDFNamedPageReference)}
   */
  @Test
  @DisplayName("Test setTemplateReference(FDFNamedPageReference); when FDFNamedPageReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFTemplate.setTemplateReference(FDFNamedPageReference)"})
  void testSetTemplateReference_whenFDFNamedPageReference() throws IOException {
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
   * Test {@link FDFTemplate#setTemplateReference(FDFNamedPageReference)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FDFTemplate#FDFTemplate()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link FDFTemplate#setTemplateReference(FDFNamedPageReference)}
   */
  @Test
  @DisplayName(
      "Test setTemplateReference(FDFNamedPageReference); when 'null'; then FDFTemplate() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFTemplate.setTemplateReference(FDFNamedPageReference)"})
  void testSetTemplateReference_whenNull_thenFDFTemplateCOSObjectSizeIsZero() {
    // Arrange
    FDFTemplate fdfTemplate = new FDFTemplate();

    // Act
    fdfTemplate.setTemplateReference(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = fdfTemplate.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link FDFTemplate#getFields()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FDFField#FDFField()}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link FDFTemplate#getFields()}
   */
  @Test
  @DisplayName("Test getFields(); given ArrayList() add FDFField(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FDFTemplate.getFields()"})
  void testGetFields_givenArrayListAddFDFField_thenReturnSizeIsOne() throws IOException {
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
    assertNull(getResult.getIconFit());
    assertNull(getResult.getAppearanceStreamReference());
    assertNull(getResult.getAction());
    assertNull(getResult.getAdditionalActions());
    assertNull(getResult.getAppearanceDictionary());
  }

  /**
   * Test {@link FDFTemplate#getFields()}.
   *
   * <ul>
   *   <li>Given {@link FDFTemplate#FDFTemplate()} Fields is {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FDFTemplate#getFields()}
   */
  @Test
  @DisplayName("Test getFields(); given FDFTemplate() Fields is ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FDFTemplate.getFields()"})
  void testGetFields_givenFDFTemplateFieldsIsArrayList_thenReturnEmpty() {
    // Arrange
    FDFTemplate fdfTemplate = new FDFTemplate();
    fdfTemplate.setFields(new ArrayList<>());

    // Act and Assert
    assertTrue(fdfTemplate.getFields().isEmpty());
  }

  /**
   * Test {@link FDFTemplate#getFields()}.
   *
   * <ul>
   *   <li>Given {@link FDFTemplate#FDFTemplate()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFTemplate#getFields()}
   */
  @Test
  @DisplayName("Test getFields(); given FDFTemplate(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FDFTemplate.getFields()"})
  void testGetFields_givenFDFTemplate_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFTemplate().getFields());
  }

  /**
   * Test {@link FDFTemplate#setFields(List)}.
   *
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.
   *   <li>Then {@link FDFTemplate#FDFTemplate()} Fields first ClearFieldFlags is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFTemplate#setFields(List)}
   */
  @Test
  @DisplayName(
      "Test setFields(List); given FDFField(); then FDFTemplate() Fields first ClearFieldFlags is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFTemplate.setFields(List)"})
  void testSetFields_givenFDFField_thenFDFTemplateFieldsFirstClearFieldFlagsIsNull()
      throws IOException {
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
  }

  /**
   * Test {@link FDFTemplate#setFields(List)}.
   *
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.
   *   <li>Then {@link FDFTemplate#FDFTemplate()} Fields size is two.
   * </ul>
   *
   * <p>Method under test: {@link FDFTemplate#setFields(List)}
   */
  @Test
  @DisplayName("Test setFields(List); given FDFField(); then FDFTemplate() Fields size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFTemplate.setFields(List)"})
  void testSetFields_givenFDFField_thenFDFTemplateFieldsSizeIsTwo() throws IOException {
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
   * Test {@link FDFTemplate#setFields(List)}.
   *
   * <ul>
   *   <li>Given {@link FDFTemplate#FDFTemplate()}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link FDFTemplate#FDFTemplate()} Fields Empty.
   * </ul>
   *
   * <p>Method under test: {@link FDFTemplate#setFields(List)}
   */
  @Test
  @DisplayName(
      "Test setFields(List); given FDFTemplate(); when ArrayList(); then FDFTemplate() Fields Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFTemplate.setFields(List)"})
  void testSetFields_givenFDFTemplate_whenArrayList_thenFDFTemplateFieldsEmpty() {
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
   * Test {@link FDFTemplate#setFields(List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then {@link FDFTemplate#FDFTemplate()} Fields first COSObject is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFTemplate#setFields(List)}
   */
  @Test
  @DisplayName(
      "Test setFields(List); given 'null'; then FDFTemplate() Fields first COSObject is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFTemplate.setFields(List)"})
  void testSetFields_givenNull_thenFDFTemplateFieldsFirstCOSObjectIsNull() {
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
   * Test {@link FDFTemplate#shouldRename()}.
   *
   * <ul>
   *   <li>Given {@link FDFTemplate#FDFTemplate()} Rename is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FDFTemplate#shouldRename()}
   */
  @Test
  @DisplayName("Test shouldRename(); given FDFTemplate() Rename is 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFTemplate.shouldRename()"})
  void testShouldRename_givenFDFTemplateRenameIsFalse_thenReturnFalse() {
    // Arrange
    FDFTemplate fdfTemplate = new FDFTemplate();
    fdfTemplate.setRename(false);

    // Act and Assert
    assertFalse(fdfTemplate.shouldRename());
  }

  /**
   * Test {@link FDFTemplate#shouldRename()}.
   *
   * <ul>
   *   <li>Given {@link FDFTemplate#FDFTemplate()} Rename is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFTemplate#shouldRename()}
   */
  @Test
  @DisplayName("Test shouldRename(); given FDFTemplate() Rename is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFTemplate.shouldRename()"})
  void testShouldRename_givenFDFTemplateRenameIsTrue_thenReturnTrue() {
    // Arrange
    FDFTemplate fdfTemplate = new FDFTemplate();
    fdfTemplate.setRename(true);

    // Act and Assert
    assertTrue(fdfTemplate.shouldRename());
  }

  /**
   * Test {@link FDFTemplate#shouldRename()}.
   *
   * <ul>
   *   <li>Given {@link FDFTemplate#FDFTemplate()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FDFTemplate#shouldRename()}
   */
  @Test
  @DisplayName("Test shouldRename(); given FDFTemplate(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFTemplate.shouldRename()"})
  void testShouldRename_givenFDFTemplate_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new FDFTemplate().shouldRename());
  }

  /**
   * Test {@link FDFTemplate#setRename(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFTemplate#FDFTemplate()}.
   *   <li>When {@code false}.
   *   <li>Then {@link FDFTemplate#FDFTemplate()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link FDFTemplate#setRename(boolean)}
   */
  @Test
  @DisplayName(
      "Test setRename(boolean); given FDFTemplate(); when 'false'; then FDFTemplate() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFTemplate.setRename(boolean)"})
  void testSetRename_givenFDFTemplate_whenFalse_thenFDFTemplateCOSObjectValuesSizeIsOne() {
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
   * Test {@link FDFTemplate#setRename(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFTemplate#FDFTemplate()}.
   *   <li>When {@code true}.
   *   <li>Then {@link FDFTemplate#FDFTemplate()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link FDFTemplate#setRename(boolean)}
   */
  @Test
  @DisplayName(
      "Test setRename(boolean); given FDFTemplate(); when 'true'; then FDFTemplate() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFTemplate.setRename(boolean)"})
  void testSetRename_givenFDFTemplate_whenTrue_thenFDFTemplateCOSObjectValuesSizeIsOne() {
    // Arrange
    FDFTemplate fdfTemplate = new FDFTemplate();

    // Act
    fdfTemplate.setRename(true);

    // Assert
    COSDictionary cOSObject = fdfTemplate.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }
}

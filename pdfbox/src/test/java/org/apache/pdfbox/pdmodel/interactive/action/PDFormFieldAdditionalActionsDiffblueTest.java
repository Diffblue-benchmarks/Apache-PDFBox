package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFormFieldAdditionalActionsDiffblueTest {
  /**
   * Test {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions(COSDictionary)}.
   *
   * <p>Method under test: {@link
   * PDFormFieldAdditionalActions#PDFormFieldAdditionalActions(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDFormFieldAdditionalActions(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormFieldAdditionalActions.<init>(COSDictionary)"})
  void testNewPDFormFieldAdditionalActions() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, new PDFormFieldAdditionalActions(a).getCOSObject());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()}.
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()}
   */
  @Test
  @DisplayName("Test new PDFormFieldAdditionalActions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormFieldAdditionalActions.<init>()"})
  void testNewPDFormFieldAdditionalActions2() {
    // Arrange and Act
    PDFormFieldAdditionalActions actualPdFormFieldAdditionalActions =
        new PDFormFieldAdditionalActions();

    // Assert
    COSDictionary cOSObject = actualPdFormFieldAdditionalActions.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdFormFieldAdditionalActions.getC());
    assertNull(actualPdFormFieldAdditionalActions.getF());
    assertNull(actualPdFormFieldAdditionalActions.getK());
    assertNull(actualPdFormFieldAdditionalActions.getV());
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
   * Test {@link PDFormFieldAdditionalActions#getCOSObject()}.
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDFormFieldAdditionalActions.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDFormFieldAdditionalActions().getCOSObject();

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
   * Test {@link PDFormFieldAdditionalActions#getK()}.
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  @DisplayName("Test getK()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getK()"})
  void testGetK() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdFormFieldAdditionalActions.getK());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getK()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is {@link COSObjectKey#COSObjectKey(long,
   *       int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  @DisplayName(
      "Test getK(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getK()"})
  void testGetK_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));
    PDActionEmbeddedGoTo k = new PDActionEmbeddedGoTo(a);

    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(k);

    // Act and Assert
    assertNull(pdFormFieldAdditionalActions.getK());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getK()}.
   *
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()} SubType is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  @DisplayName(
      "Test getK(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary() SubType is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getK()"})
  void testGetK_givenPDActionEmbeddedGoToWithAIsCOSDictionarySubTypeIsFoo() {
    // Arrange
    PDActionEmbeddedGoTo k = new PDActionEmbeddedGoTo(new COSDictionary());
    k.setSubType("foo");

    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(k);

    // Act and Assert
    assertNull(pdFormFieldAdditionalActions.getK());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getK()}.
   *
   * <ul>
   *   <li>Given {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()} K is {@link
   *       PDActionGoTo#PDActionGoTo()}.
   *   <li>Then return {@link PDActionGoTo}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  @DisplayName(
      "Test getK(); given PDFormFieldAdditionalActions() K is PDActionGoTo(); then return PDActionGoTo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getK()"})
  void testGetK_givenPDFormFieldAdditionalActionsKIsPDActionGoTo_thenReturnPDActionGoTo()
      throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionGoTo());

    // Act
    PDAction actualK = pdFormFieldAdditionalActions.getK();

    // Assert
    assertTrue(actualK instanceof PDActionGoTo);
    assertNull(actualK.getNext());
    COSDictionary cOSObject = actualK.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualK).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualK.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getK()}.
   *
   * <ul>
   *   <li>Given {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()} K is {@link
   *       PDActionHide#PDActionHide()}.
   *   <li>Then return {@link PDActionHide}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  @DisplayName(
      "Test getK(); given PDFormFieldAdditionalActions() K is PDActionHide(); then return PDActionHide")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getK()"})
  void testGetK_givenPDFormFieldAdditionalActionsKIsPDActionHide_thenReturnPDActionHide() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionHide());

    // Act
    PDAction actualK = pdFormFieldAdditionalActions.getK();

    // Assert
    assertTrue(actualK instanceof PDActionHide);
    assertNull(((PDActionHide) actualK).getT());
    assertTrue(((PDActionHide) actualK).getH());
    assertEquals(PDActionHide.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getK()}.
   *
   * <ul>
   *   <li>Given {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()} K is {@link
   *       PDActionURI#PDActionURI()}.
   *   <li>Then return {@link PDActionURI}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  @DisplayName(
      "Test getK(); given PDFormFieldAdditionalActions() K is PDActionURI(); then return PDActionURI")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getK()"})
  void testGetK_givenPDFormFieldAdditionalActionsKIsPDActionURI_thenReturnPDActionURI() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionURI());

    // Act
    PDAction actualK = pdFormFieldAdditionalActions.getK();

    // Assert
    assertTrue(actualK instanceof PDActionURI);
    assertNull(((PDActionURI) actualK).getURI());
    assertNull(actualK.getNext());
    COSDictionary cOSObject = actualK.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualK.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getK()}.
   *
   * <ul>
   *   <li>Given {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  @DisplayName("Test getK(); given PDFormFieldAdditionalActions(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getK()"})
  void testGetK_givenPDFormFieldAdditionalActions_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDFormFieldAdditionalActions().getK());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getK()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionEmbeddedGoTo}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  @DisplayName("Test getK(); then return PDActionEmbeddedGoTo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getK()"})
  void testGetK_thenReturnPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualK = pdFormFieldAdditionalActions.getK();

    // Assert
    assertTrue(actualK instanceof PDActionEmbeddedGoTo);
    assertNull(((PDActionEmbeddedGoTo) actualK).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualK).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualK).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualK).getOpenInNewWindow());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getK()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionImportData}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  @DisplayName("Test getK(); then return PDActionImportData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getK()"})
  void testGetK_thenReturnPDActionImportData() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionImportData());

    // Act
    PDAction actualK = pdFormFieldAdditionalActions.getK();

    // Assert
    assertTrue(actualK instanceof PDActionImportData);
    assertNull(actualK.getNext());
    COSDictionary cOSObject = actualK.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualK).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualK.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getK()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionJavaScript}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  @DisplayName("Test getK(); then return PDActionJavaScript")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getK()"})
  void testGetK_thenReturnPDActionJavaScript() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionJavaScript());

    // Act
    PDAction actualK = pdFormFieldAdditionalActions.getK();

    // Assert
    assertTrue(actualK instanceof PDActionJavaScript);
    assertNull(((PDActionJavaScript) actualK).getAction());
    assertNull(actualK.getNext());
    COSDictionary cOSObject = actualK.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualK.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getK()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionLaunch}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  @DisplayName("Test getK(); then return PDActionLaunch")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getK()"})
  void testGetK_thenReturnPDActionLaunch() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionLaunch());

    // Act
    PDAction actualK = pdFormFieldAdditionalActions.getK();

    // Assert
    assertTrue(actualK instanceof PDActionLaunch);
    assertNull(((PDActionLaunch) actualK).getD());
    assertNull(((PDActionLaunch) actualK).getF());
    assertNull(((PDActionLaunch) actualK).getO());
    assertNull(((PDActionLaunch) actualK).getP());
    assertNull(((PDActionLaunch) actualK).getFile());
    assertNull(((PDActionLaunch) actualK).getWinLaunchParams());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualK).getOpenInNewWindow());
    assertEquals(PDActionLaunch.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getK()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionMovie}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  @DisplayName("Test getK(); then return PDActionMovie")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getK()"})
  void testGetK_thenReturnPDActionMovie() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionMovie());

    // Act
    PDAction actualK = pdFormFieldAdditionalActions.getK();

    // Assert
    assertTrue(actualK instanceof PDActionMovie);
    COSDictionary cOSObject = actualK.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDActionMovie.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getK()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionNamed}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  @DisplayName("Test getK(); then return PDActionNamed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getK()"})
  void testGetK_thenReturnPDActionNamed() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionNamed());

    // Act
    PDAction actualK = pdFormFieldAdditionalActions.getK();

    // Assert
    assertTrue(actualK instanceof PDActionNamed);
    assertNull(((PDActionNamed) actualK).getN());
    assertNull(actualK.getNext());
    COSDictionary cOSObject = actualK.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualK.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getK()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionRemoteGoTo}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  @DisplayName("Test getK(); then return PDActionRemoteGoTo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getK()"})
  void testGetK_thenReturnPDActionRemoteGoTo() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionRemoteGoTo());

    // Act
    PDAction actualK = pdFormFieldAdditionalActions.getK();

    // Assert
    assertTrue(actualK instanceof PDActionRemoteGoTo);
    assertNull(((PDActionRemoteGoTo) actualK).getD());
    assertNull(((PDActionRemoteGoTo) actualK).getFile());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualK).getOpenInNewWindow());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getK()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionResetForm}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  @DisplayName("Test getK(); then return PDActionResetForm")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getK()"})
  void testGetK_thenReturnPDActionResetForm() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionResetForm());

    // Act
    PDAction actualK = pdFormFieldAdditionalActions.getK();

    // Assert
    assertTrue(actualK instanceof PDActionResetForm);
    assertNull(((PDActionResetForm) actualK).getFields());
    assertEquals(0, ((PDActionResetForm) actualK).getFlags());
    assertEquals(PDActionResetForm.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getK()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionSound}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  @DisplayName("Test getK(); then return PDActionSound")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getK()"})
  void testGetK_thenReturnPDActionSound() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionSound());

    // Act
    PDAction actualK = pdFormFieldAdditionalActions.getK();

    // Assert
    assertTrue(actualK instanceof PDActionSound);
    assertNull(((PDActionSound) actualK).getSound());
    assertEquals(1.0f, ((PDActionSound) actualK).getVolume());
    assertFalse(((PDActionSound) actualK).getMix());
    assertFalse(((PDActionSound) actualK).getRepeat());
    assertFalse(((PDActionSound) actualK).getSynchronous());
    assertEquals(PDActionSound.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getK()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionSubmitForm}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  @DisplayName("Test getK(); then return PDActionSubmitForm")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getK()"})
  void testGetK_thenReturnPDActionSubmitForm() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionSubmitForm());

    // Act
    PDAction actualK = pdFormFieldAdditionalActions.getK();

    // Assert
    assertTrue(actualK instanceof PDActionSubmitForm);
    assertNull(((PDActionSubmitForm) actualK).getFields());
    assertNull(((PDActionSubmitForm) actualK).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualK).getFlags());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getK()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionThread}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  @DisplayName("Test getK(); then return PDActionThread")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getK()"})
  void testGetK_thenReturnPDActionThread() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionThread());

    // Act
    PDAction actualK = pdFormFieldAdditionalActions.getK();

    // Assert
    assertTrue(actualK instanceof PDActionThread);
    assertNull(((PDActionThread) actualK).getB());
    assertNull(((PDActionThread) actualK).getD());
    assertNull(((PDActionThread) actualK).getFile());
    assertEquals(PDActionThread.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#setK(PDAction)}.
   *
   * <ul>
   *   <li>Then {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()} K {@link
   *       PDActionEmbeddedGoTo}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#setK(PDAction)}
   */
  @Test
  @DisplayName("Test setK(PDAction); then PDFormFieldAdditionalActions() K PDActionEmbeddedGoTo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormFieldAdditionalActions.setK(PDAction)"})
  void testSetK_thenPDFormFieldAdditionalActionsKPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();

    // Act
    pdFormFieldAdditionalActions.setK(new PDActionEmbeddedGoTo());

    // Assert
    PDAction k = pdFormFieldAdditionalActions.getK();
    assertTrue(k instanceof PDActionEmbeddedGoTo);
    assertNull(k.getNext());
    assertNull(((PDActionEmbeddedGoTo) k).getFile());
    assertNull(((PDActionEmbeddedGoTo) k).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) k).getDestination());
    COSDictionary cOSObject = pdFormFieldAdditionalActions.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) k).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, k.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, k.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#setK(PDAction)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()} COSObject size
   *       is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#setK(PDAction)}
   */
  @Test
  @DisplayName(
      "Test setK(PDAction); when 'null'; then PDFormFieldAdditionalActions() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormFieldAdditionalActions.setK(PDAction)"})
  void testSetK_whenNull_thenPDFormFieldAdditionalActionsCOSObjectSizeIsZero() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();

    // Act
    pdFormFieldAdditionalActions.setK(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdFormFieldAdditionalActions.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getF()}.
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getF()"})
  void testGetF() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdFormFieldAdditionalActions.getF());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is {@link COSObjectKey#COSObjectKey(long,
   *       int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  @DisplayName(
      "Test getF(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getF()"})
  void testGetF_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));
    PDActionEmbeddedGoTo f = new PDActionEmbeddedGoTo(a);

    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(f);

    // Act and Assert
    assertNull(pdFormFieldAdditionalActions.getF());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()} SubType is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  @DisplayName(
      "Test getF(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary() SubType is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getF()"})
  void testGetF_givenPDActionEmbeddedGoToWithAIsCOSDictionarySubTypeIsFoo() {
    // Arrange
    PDActionEmbeddedGoTo f = new PDActionEmbeddedGoTo(new COSDictionary());
    f.setSubType("foo");

    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(f);

    // Act and Assert
    assertNull(pdFormFieldAdditionalActions.getF());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Given {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()} F is {@link
   *       PDActionGoTo#PDActionGoTo()}.
   *   <li>Then return {@link PDActionGoTo}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  @DisplayName(
      "Test getF(); given PDFormFieldAdditionalActions() F is PDActionGoTo(); then return PDActionGoTo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getF()"})
  void testGetF_givenPDFormFieldAdditionalActionsFIsPDActionGoTo_thenReturnPDActionGoTo()
      throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionGoTo());

    // Act
    PDAction actualF = pdFormFieldAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionGoTo);
    assertNull(actualF.getNext());
    COSDictionary cOSObject = actualF.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualF).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualF.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Given {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()} F is {@link
   *       PDActionHide#PDActionHide()}.
   *   <li>Then return {@link PDActionHide}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  @DisplayName(
      "Test getF(); given PDFormFieldAdditionalActions() F is PDActionHide(); then return PDActionHide")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getF()"})
  void testGetF_givenPDFormFieldAdditionalActionsFIsPDActionHide_thenReturnPDActionHide() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionHide());

    // Act
    PDAction actualF = pdFormFieldAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionHide);
    assertNull(((PDActionHide) actualF).getT());
    assertTrue(((PDActionHide) actualF).getH());
    assertEquals(PDActionHide.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Given {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()} F is {@link
   *       PDActionURI#PDActionURI()}.
   *   <li>Then return {@link PDActionURI}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  @DisplayName(
      "Test getF(); given PDFormFieldAdditionalActions() F is PDActionURI(); then return PDActionURI")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getF()"})
  void testGetF_givenPDFormFieldAdditionalActionsFIsPDActionURI_thenReturnPDActionURI() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionURI());

    // Act
    PDAction actualF = pdFormFieldAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionURI);
    assertNull(((PDActionURI) actualF).getURI());
    assertNull(actualF.getNext());
    COSDictionary cOSObject = actualF.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualF.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Given {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); given PDFormFieldAdditionalActions(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getF()"})
  void testGetF_givenPDFormFieldAdditionalActions_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDFormFieldAdditionalActions().getF());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionEmbeddedGoTo}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); then return PDActionEmbeddedGoTo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getF()"})
  void testGetF_thenReturnPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualF = pdFormFieldAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionEmbeddedGoTo);
    assertNull(((PDActionEmbeddedGoTo) actualF).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualF).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualF).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualF).getOpenInNewWindow());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionImportData}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); then return PDActionImportData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getF()"})
  void testGetF_thenReturnPDActionImportData() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionImportData());

    // Act
    PDAction actualF = pdFormFieldAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionImportData);
    assertNull(actualF.getNext());
    COSDictionary cOSObject = actualF.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualF).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualF.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionJavaScript}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); then return PDActionJavaScript")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getF()"})
  void testGetF_thenReturnPDActionJavaScript() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionJavaScript());

    // Act
    PDAction actualF = pdFormFieldAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionJavaScript);
    assertNull(((PDActionJavaScript) actualF).getAction());
    assertNull(actualF.getNext());
    COSDictionary cOSObject = actualF.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualF.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionLaunch}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); then return PDActionLaunch")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getF()"})
  void testGetF_thenReturnPDActionLaunch() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionLaunch());

    // Act
    PDAction actualF = pdFormFieldAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionLaunch);
    assertNull(((PDActionLaunch) actualF).getD());
    assertNull(((PDActionLaunch) actualF).getF());
    assertNull(((PDActionLaunch) actualF).getO());
    assertNull(((PDActionLaunch) actualF).getP());
    assertNull(((PDActionLaunch) actualF).getFile());
    assertNull(((PDActionLaunch) actualF).getWinLaunchParams());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualF).getOpenInNewWindow());
    assertEquals(PDActionLaunch.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionMovie}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); then return PDActionMovie")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getF()"})
  void testGetF_thenReturnPDActionMovie() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionMovie());

    // Act
    PDAction actualF = pdFormFieldAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionMovie);
    COSDictionary cOSObject = actualF.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDActionMovie.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionNamed}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); then return PDActionNamed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getF()"})
  void testGetF_thenReturnPDActionNamed() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionNamed());

    // Act
    PDAction actualF = pdFormFieldAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionNamed);
    assertNull(((PDActionNamed) actualF).getN());
    assertNull(actualF.getNext());
    COSDictionary cOSObject = actualF.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualF.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionRemoteGoTo}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); then return PDActionRemoteGoTo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getF()"})
  void testGetF_thenReturnPDActionRemoteGoTo() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionRemoteGoTo());

    // Act
    PDAction actualF = pdFormFieldAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionRemoteGoTo);
    assertNull(((PDActionRemoteGoTo) actualF).getD());
    assertNull(((PDActionRemoteGoTo) actualF).getFile());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualF).getOpenInNewWindow());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionResetForm}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); then return PDActionResetForm")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getF()"})
  void testGetF_thenReturnPDActionResetForm() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionResetForm());

    // Act
    PDAction actualF = pdFormFieldAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionResetForm);
    assertNull(((PDActionResetForm) actualF).getFields());
    assertEquals(0, ((PDActionResetForm) actualF).getFlags());
    assertEquals(PDActionResetForm.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionSound}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); then return PDActionSound")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getF()"})
  void testGetF_thenReturnPDActionSound() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionSound());

    // Act
    PDAction actualF = pdFormFieldAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionSound);
    assertNull(((PDActionSound) actualF).getSound());
    assertEquals(1.0f, ((PDActionSound) actualF).getVolume());
    assertFalse(((PDActionSound) actualF).getMix());
    assertFalse(((PDActionSound) actualF).getRepeat());
    assertFalse(((PDActionSound) actualF).getSynchronous());
    assertEquals(PDActionSound.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionSubmitForm}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); then return PDActionSubmitForm")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getF()"})
  void testGetF_thenReturnPDActionSubmitForm() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionSubmitForm());

    // Act
    PDAction actualF = pdFormFieldAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionSubmitForm);
    assertNull(((PDActionSubmitForm) actualF).getFields());
    assertNull(((PDActionSubmitForm) actualF).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualF).getFlags());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionThread}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); then return PDActionThread")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getF()"})
  void testGetF_thenReturnPDActionThread() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionThread());

    // Act
    PDAction actualF = pdFormFieldAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionThread);
    assertNull(((PDActionThread) actualF).getB());
    assertNull(((PDActionThread) actualF).getD());
    assertNull(((PDActionThread) actualF).getFile());
    assertEquals(PDActionThread.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#setF(PDAction)}.
   *
   * <ul>
   *   <li>Then {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()} F {@link
   *       PDActionEmbeddedGoTo}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#setF(PDAction)}
   */
  @Test
  @DisplayName("Test setF(PDAction); then PDFormFieldAdditionalActions() F PDActionEmbeddedGoTo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormFieldAdditionalActions.setF(PDAction)"})
  void testSetF_thenPDFormFieldAdditionalActionsFPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();

    // Act
    pdFormFieldAdditionalActions.setF(new PDActionEmbeddedGoTo());

    // Assert
    PDAction f = pdFormFieldAdditionalActions.getF();
    assertTrue(f instanceof PDActionEmbeddedGoTo);
    assertNull(f.getNext());
    assertNull(((PDActionEmbeddedGoTo) f).getFile());
    assertNull(((PDActionEmbeddedGoTo) f).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) f).getDestination());
    COSDictionary cOSObject = pdFormFieldAdditionalActions.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) f).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, f.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, f.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#setF(PDAction)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()} COSObject size
   *       is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#setF(PDAction)}
   */
  @Test
  @DisplayName(
      "Test setF(PDAction); when 'null'; then PDFormFieldAdditionalActions() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormFieldAdditionalActions.setF(PDAction)"})
  void testSetF_whenNull_thenPDFormFieldAdditionalActionsCOSObjectSizeIsZero() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();

    // Act
    pdFormFieldAdditionalActions.setF(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdFormFieldAdditionalActions.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getV()}.
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  @DisplayName("Test getV()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getV()"})
  void testGetV() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdFormFieldAdditionalActions.getV());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getV()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is {@link COSObjectKey#COSObjectKey(long,
   *       int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  @DisplayName(
      "Test getV(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getV()"})
  void testGetV_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));
    PDActionEmbeddedGoTo v = new PDActionEmbeddedGoTo(a);

    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(v);

    // Act and Assert
    assertNull(pdFormFieldAdditionalActions.getV());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getV()}.
   *
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()} SubType is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  @DisplayName(
      "Test getV(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary() SubType is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getV()"})
  void testGetV_givenPDActionEmbeddedGoToWithAIsCOSDictionarySubTypeIsFoo() {
    // Arrange
    PDActionEmbeddedGoTo v = new PDActionEmbeddedGoTo(new COSDictionary());
    v.setSubType("foo");

    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(v);

    // Act and Assert
    assertNull(pdFormFieldAdditionalActions.getV());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getV()}.
   *
   * <ul>
   *   <li>Given {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()} V is {@link
   *       PDActionGoTo#PDActionGoTo()}.
   *   <li>Then return {@link PDActionGoTo}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  @DisplayName(
      "Test getV(); given PDFormFieldAdditionalActions() V is PDActionGoTo(); then return PDActionGoTo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getV()"})
  void testGetV_givenPDFormFieldAdditionalActionsVIsPDActionGoTo_thenReturnPDActionGoTo()
      throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionGoTo());

    // Act
    PDAction actualV = pdFormFieldAdditionalActions.getV();

    // Assert
    assertTrue(actualV instanceof PDActionGoTo);
    assertNull(actualV.getNext());
    COSDictionary cOSObject = actualV.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualV).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualV.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getV()}.
   *
   * <ul>
   *   <li>Given {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()} V is {@link
   *       PDActionHide#PDActionHide()}.
   *   <li>Then return {@link PDActionHide}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  @DisplayName(
      "Test getV(); given PDFormFieldAdditionalActions() V is PDActionHide(); then return PDActionHide")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getV()"})
  void testGetV_givenPDFormFieldAdditionalActionsVIsPDActionHide_thenReturnPDActionHide() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionHide());

    // Act
    PDAction actualV = pdFormFieldAdditionalActions.getV();

    // Assert
    assertTrue(actualV instanceof PDActionHide);
    assertNull(((PDActionHide) actualV).getT());
    assertTrue(((PDActionHide) actualV).getH());
    assertEquals(PDActionHide.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getV()}.
   *
   * <ul>
   *   <li>Given {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()} V is {@link
   *       PDActionURI#PDActionURI()}.
   *   <li>Then return {@link PDActionURI}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  @DisplayName(
      "Test getV(); given PDFormFieldAdditionalActions() V is PDActionURI(); then return PDActionURI")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getV()"})
  void testGetV_givenPDFormFieldAdditionalActionsVIsPDActionURI_thenReturnPDActionURI() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionURI());

    // Act
    PDAction actualV = pdFormFieldAdditionalActions.getV();

    // Assert
    assertTrue(actualV instanceof PDActionURI);
    assertNull(((PDActionURI) actualV).getURI());
    assertNull(actualV.getNext());
    COSDictionary cOSObject = actualV.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualV.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getV()}.
   *
   * <ul>
   *   <li>Given {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  @DisplayName("Test getV(); given PDFormFieldAdditionalActions(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getV()"})
  void testGetV_givenPDFormFieldAdditionalActions_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDFormFieldAdditionalActions().getV());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getV()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionEmbeddedGoTo}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  @DisplayName("Test getV(); then return PDActionEmbeddedGoTo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getV()"})
  void testGetV_thenReturnPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualV = pdFormFieldAdditionalActions.getV();

    // Assert
    assertTrue(actualV instanceof PDActionEmbeddedGoTo);
    assertNull(((PDActionEmbeddedGoTo) actualV).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualV).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualV).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualV).getOpenInNewWindow());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getV()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionImportData}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  @DisplayName("Test getV(); then return PDActionImportData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getV()"})
  void testGetV_thenReturnPDActionImportData() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionImportData());

    // Act
    PDAction actualV = pdFormFieldAdditionalActions.getV();

    // Assert
    assertTrue(actualV instanceof PDActionImportData);
    assertNull(actualV.getNext());
    COSDictionary cOSObject = actualV.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualV).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualV.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getV()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionJavaScript}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  @DisplayName("Test getV(); then return PDActionJavaScript")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getV()"})
  void testGetV_thenReturnPDActionJavaScript() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionJavaScript());

    // Act
    PDAction actualV = pdFormFieldAdditionalActions.getV();

    // Assert
    assertTrue(actualV instanceof PDActionJavaScript);
    assertNull(((PDActionJavaScript) actualV).getAction());
    assertNull(actualV.getNext());
    COSDictionary cOSObject = actualV.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualV.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getV()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionLaunch}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  @DisplayName("Test getV(); then return PDActionLaunch")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getV()"})
  void testGetV_thenReturnPDActionLaunch() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionLaunch());

    // Act
    PDAction actualV = pdFormFieldAdditionalActions.getV();

    // Assert
    assertTrue(actualV instanceof PDActionLaunch);
    assertNull(((PDActionLaunch) actualV).getD());
    assertNull(((PDActionLaunch) actualV).getF());
    assertNull(((PDActionLaunch) actualV).getO());
    assertNull(((PDActionLaunch) actualV).getP());
    assertNull(((PDActionLaunch) actualV).getFile());
    assertNull(((PDActionLaunch) actualV).getWinLaunchParams());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualV).getOpenInNewWindow());
    assertEquals(PDActionLaunch.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getV()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionMovie}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  @DisplayName("Test getV(); then return PDActionMovie")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getV()"})
  void testGetV_thenReturnPDActionMovie() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionMovie());

    // Act
    PDAction actualV = pdFormFieldAdditionalActions.getV();

    // Assert
    assertTrue(actualV instanceof PDActionMovie);
    COSDictionary cOSObject = actualV.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDActionMovie.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getV()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionNamed}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  @DisplayName("Test getV(); then return PDActionNamed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getV()"})
  void testGetV_thenReturnPDActionNamed() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionNamed());

    // Act
    PDAction actualV = pdFormFieldAdditionalActions.getV();

    // Assert
    assertTrue(actualV instanceof PDActionNamed);
    assertNull(((PDActionNamed) actualV).getN());
    assertNull(actualV.getNext());
    COSDictionary cOSObject = actualV.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualV.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getV()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionRemoteGoTo}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  @DisplayName("Test getV(); then return PDActionRemoteGoTo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getV()"})
  void testGetV_thenReturnPDActionRemoteGoTo() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionRemoteGoTo());

    // Act
    PDAction actualV = pdFormFieldAdditionalActions.getV();

    // Assert
    assertTrue(actualV instanceof PDActionRemoteGoTo);
    assertNull(((PDActionRemoteGoTo) actualV).getD());
    assertNull(((PDActionRemoteGoTo) actualV).getFile());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualV).getOpenInNewWindow());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getV()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionResetForm}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  @DisplayName("Test getV(); then return PDActionResetForm")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getV()"})
  void testGetV_thenReturnPDActionResetForm() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionResetForm());

    // Act
    PDAction actualV = pdFormFieldAdditionalActions.getV();

    // Assert
    assertTrue(actualV instanceof PDActionResetForm);
    assertNull(((PDActionResetForm) actualV).getFields());
    assertEquals(0, ((PDActionResetForm) actualV).getFlags());
    assertEquals(PDActionResetForm.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getV()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionSound}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  @DisplayName("Test getV(); then return PDActionSound")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getV()"})
  void testGetV_thenReturnPDActionSound() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionSound());

    // Act
    PDAction actualV = pdFormFieldAdditionalActions.getV();

    // Assert
    assertTrue(actualV instanceof PDActionSound);
    assertNull(((PDActionSound) actualV).getSound());
    assertEquals(1.0f, ((PDActionSound) actualV).getVolume());
    assertFalse(((PDActionSound) actualV).getMix());
    assertFalse(((PDActionSound) actualV).getRepeat());
    assertFalse(((PDActionSound) actualV).getSynchronous());
    assertEquals(PDActionSound.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getV()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionSubmitForm}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  @DisplayName("Test getV(); then return PDActionSubmitForm")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getV()"})
  void testGetV_thenReturnPDActionSubmitForm() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionSubmitForm());

    // Act
    PDAction actualV = pdFormFieldAdditionalActions.getV();

    // Assert
    assertTrue(actualV instanceof PDActionSubmitForm);
    assertNull(((PDActionSubmitForm) actualV).getFields());
    assertNull(((PDActionSubmitForm) actualV).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualV).getFlags());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getV()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionThread}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  @DisplayName("Test getV(); then return PDActionThread")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getV()"})
  void testGetV_thenReturnPDActionThread() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionThread());

    // Act
    PDAction actualV = pdFormFieldAdditionalActions.getV();

    // Assert
    assertTrue(actualV instanceof PDActionThread);
    assertNull(((PDActionThread) actualV).getB());
    assertNull(((PDActionThread) actualV).getD());
    assertNull(((PDActionThread) actualV).getFile());
    assertEquals(PDActionThread.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#setV(PDAction)}.
   *
   * <ul>
   *   <li>Then {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()} V {@link
   *       PDActionEmbeddedGoTo}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#setV(PDAction)}
   */
  @Test
  @DisplayName("Test setV(PDAction); then PDFormFieldAdditionalActions() V PDActionEmbeddedGoTo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormFieldAdditionalActions.setV(PDAction)"})
  void testSetV_thenPDFormFieldAdditionalActionsVPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();

    // Act
    pdFormFieldAdditionalActions.setV(new PDActionEmbeddedGoTo());

    // Assert
    PDAction v = pdFormFieldAdditionalActions.getV();
    assertTrue(v instanceof PDActionEmbeddedGoTo);
    assertNull(v.getNext());
    assertNull(((PDActionEmbeddedGoTo) v).getFile());
    assertNull(((PDActionEmbeddedGoTo) v).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) v).getDestination());
    COSDictionary cOSObject = pdFormFieldAdditionalActions.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) v).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, v.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, v.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#setV(PDAction)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()} COSObject size
   *       is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#setV(PDAction)}
   */
  @Test
  @DisplayName(
      "Test setV(PDAction); when 'null'; then PDFormFieldAdditionalActions() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormFieldAdditionalActions.setV(PDAction)"})
  void testSetV_whenNull_thenPDFormFieldAdditionalActionsCOSObjectSizeIsZero() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();

    // Act
    pdFormFieldAdditionalActions.setV(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdFormFieldAdditionalActions.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getC()}.
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getC()"})
  void testGetC() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdFormFieldAdditionalActions.getC());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getC()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is {@link COSObjectKey#COSObjectKey(long,
   *       int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  @DisplayName(
      "Test getC(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getC()"})
  void testGetC_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));
    PDActionEmbeddedGoTo c = new PDActionEmbeddedGoTo(a);

    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(c);

    // Act and Assert
    assertNull(pdFormFieldAdditionalActions.getC());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getC()}.
   *
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()} SubType is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  @DisplayName(
      "Test getC(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary() SubType is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getC()"})
  void testGetC_givenPDActionEmbeddedGoToWithAIsCOSDictionarySubTypeIsFoo() {
    // Arrange
    PDActionEmbeddedGoTo c = new PDActionEmbeddedGoTo(new COSDictionary());
    c.setSubType("foo");

    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(c);

    // Act and Assert
    assertNull(pdFormFieldAdditionalActions.getC());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getC()}.
   *
   * <ul>
   *   <li>Given {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()} C is {@link
   *       PDActionGoTo#PDActionGoTo()}.
   *   <li>Then return {@link PDActionGoTo}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  @DisplayName(
      "Test getC(); given PDFormFieldAdditionalActions() C is PDActionGoTo(); then return PDActionGoTo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getC()"})
  void testGetC_givenPDFormFieldAdditionalActionsCIsPDActionGoTo_thenReturnPDActionGoTo()
      throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionGoTo());

    // Act
    PDAction actualC = pdFormFieldAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionGoTo);
    assertNull(actualC.getNext());
    COSDictionary cOSObject = actualC.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualC).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualC.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getC()}.
   *
   * <ul>
   *   <li>Given {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()} C is {@link
   *       PDActionHide#PDActionHide()}.
   *   <li>Then return {@link PDActionHide}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  @DisplayName(
      "Test getC(); given PDFormFieldAdditionalActions() C is PDActionHide(); then return PDActionHide")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getC()"})
  void testGetC_givenPDFormFieldAdditionalActionsCIsPDActionHide_thenReturnPDActionHide() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionHide());

    // Act
    PDAction actualC = pdFormFieldAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionHide);
    assertNull(((PDActionHide) actualC).getT());
    assertTrue(((PDActionHide) actualC).getH());
    assertEquals(PDActionHide.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getC()}.
   *
   * <ul>
   *   <li>Given {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()} C is {@link
   *       PDActionURI#PDActionURI()}.
   *   <li>Then return {@link PDActionURI}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  @DisplayName(
      "Test getC(); given PDFormFieldAdditionalActions() C is PDActionURI(); then return PDActionURI")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getC()"})
  void testGetC_givenPDFormFieldAdditionalActionsCIsPDActionURI_thenReturnPDActionURI() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionURI());

    // Act
    PDAction actualC = pdFormFieldAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionURI);
    assertNull(((PDActionURI) actualC).getURI());
    assertNull(actualC.getNext());
    COSDictionary cOSObject = actualC.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualC.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getC()}.
   *
   * <ul>
   *   <li>Given {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); given PDFormFieldAdditionalActions(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getC()"})
  void testGetC_givenPDFormFieldAdditionalActions_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDFormFieldAdditionalActions().getC());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getC()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionEmbeddedGoTo}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); then return PDActionEmbeddedGoTo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getC()"})
  void testGetC_thenReturnPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualC = pdFormFieldAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionEmbeddedGoTo);
    assertNull(((PDActionEmbeddedGoTo) actualC).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualC).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualC).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualC).getOpenInNewWindow());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getC()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionImportData}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); then return PDActionImportData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getC()"})
  void testGetC_thenReturnPDActionImportData() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionImportData());

    // Act
    PDAction actualC = pdFormFieldAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionImportData);
    assertNull(actualC.getNext());
    COSDictionary cOSObject = actualC.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualC).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualC.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getC()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionJavaScript}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); then return PDActionJavaScript")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getC()"})
  void testGetC_thenReturnPDActionJavaScript() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionJavaScript());

    // Act
    PDAction actualC = pdFormFieldAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionJavaScript);
    assertNull(((PDActionJavaScript) actualC).getAction());
    assertNull(actualC.getNext());
    COSDictionary cOSObject = actualC.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualC.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getC()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionLaunch}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); then return PDActionLaunch")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getC()"})
  void testGetC_thenReturnPDActionLaunch() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionLaunch());

    // Act
    PDAction actualC = pdFormFieldAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionLaunch);
    assertNull(((PDActionLaunch) actualC).getD());
    assertNull(((PDActionLaunch) actualC).getF());
    assertNull(((PDActionLaunch) actualC).getO());
    assertNull(((PDActionLaunch) actualC).getP());
    assertNull(((PDActionLaunch) actualC).getFile());
    assertNull(((PDActionLaunch) actualC).getWinLaunchParams());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualC).getOpenInNewWindow());
    assertEquals(PDActionLaunch.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getC()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionMovie}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); then return PDActionMovie")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getC()"})
  void testGetC_thenReturnPDActionMovie() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionMovie());

    // Act
    PDAction actualC = pdFormFieldAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionMovie);
    COSDictionary cOSObject = actualC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDActionMovie.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getC()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionNamed}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); then return PDActionNamed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getC()"})
  void testGetC_thenReturnPDActionNamed() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionNamed());

    // Act
    PDAction actualC = pdFormFieldAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionNamed);
    assertNull(((PDActionNamed) actualC).getN());
    assertNull(actualC.getNext());
    COSDictionary cOSObject = actualC.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualC.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getC()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionRemoteGoTo}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); then return PDActionRemoteGoTo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getC()"})
  void testGetC_thenReturnPDActionRemoteGoTo() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionRemoteGoTo());

    // Act
    PDAction actualC = pdFormFieldAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionRemoteGoTo);
    assertNull(((PDActionRemoteGoTo) actualC).getD());
    assertNull(((PDActionRemoteGoTo) actualC).getFile());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualC).getOpenInNewWindow());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getC()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionResetForm}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); then return PDActionResetForm")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getC()"})
  void testGetC_thenReturnPDActionResetForm() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionResetForm());

    // Act
    PDAction actualC = pdFormFieldAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionResetForm);
    assertNull(((PDActionResetForm) actualC).getFields());
    assertEquals(0, ((PDActionResetForm) actualC).getFlags());
    assertEquals(PDActionResetForm.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getC()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionSound}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); then return PDActionSound")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getC()"})
  void testGetC_thenReturnPDActionSound() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionSound());

    // Act
    PDAction actualC = pdFormFieldAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionSound);
    assertNull(((PDActionSound) actualC).getSound());
    assertEquals(1.0f, ((PDActionSound) actualC).getVolume());
    assertFalse(((PDActionSound) actualC).getMix());
    assertFalse(((PDActionSound) actualC).getRepeat());
    assertFalse(((PDActionSound) actualC).getSynchronous());
    assertEquals(PDActionSound.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getC()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionSubmitForm}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); then return PDActionSubmitForm")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getC()"})
  void testGetC_thenReturnPDActionSubmitForm() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionSubmitForm());

    // Act
    PDAction actualC = pdFormFieldAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionSubmitForm);
    assertNull(((PDActionSubmitForm) actualC).getFields());
    assertNull(((PDActionSubmitForm) actualC).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualC).getFlags());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#getC()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionThread}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); then return PDActionThread")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDFormFieldAdditionalActions.getC()"})
  void testGetC_thenReturnPDActionThread() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionThread());

    // Act
    PDAction actualC = pdFormFieldAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionThread);
    assertNull(((PDActionThread) actualC).getB());
    assertNull(((PDActionThread) actualC).getD());
    assertNull(((PDActionThread) actualC).getFile());
    assertEquals(PDActionThread.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#setC(PDAction)}.
   *
   * <ul>
   *   <li>Then {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()} C {@link
   *       PDActionEmbeddedGoTo}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#setC(PDAction)}
   */
  @Test
  @DisplayName("Test setC(PDAction); then PDFormFieldAdditionalActions() C PDActionEmbeddedGoTo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormFieldAdditionalActions.setC(PDAction)"})
  void testSetC_thenPDFormFieldAdditionalActionsCPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();

    // Act
    pdFormFieldAdditionalActions.setC(new PDActionEmbeddedGoTo());

    // Assert
    PDAction c = pdFormFieldAdditionalActions.getC();
    assertTrue(c instanceof PDActionEmbeddedGoTo);
    assertNull(c.getNext());
    assertNull(((PDActionEmbeddedGoTo) c).getFile());
    assertNull(((PDActionEmbeddedGoTo) c).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) c).getDestination());
    COSDictionary cOSObject = pdFormFieldAdditionalActions.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) c).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, c.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, c.getSubType());
  }

  /**
   * Test {@link PDFormFieldAdditionalActions#setC(PDAction)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()} COSObject size
   *       is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFormFieldAdditionalActions#setC(PDAction)}
   */
  @Test
  @DisplayName(
      "Test setC(PDAction); when 'null'; then PDFormFieldAdditionalActions() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormFieldAdditionalActions.setC(PDAction)"})
  void testSetC_whenNull_thenPDFormFieldAdditionalActionsCOSObjectSizeIsZero() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();

    // Act
    pdFormFieldAdditionalActions.setC(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdFormFieldAdditionalActions.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }
}

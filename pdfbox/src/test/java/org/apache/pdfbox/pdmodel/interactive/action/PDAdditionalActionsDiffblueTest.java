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

class PDAdditionalActionsDiffblueTest {
  /**
   * Test {@link PDAdditionalActions#PDAdditionalActions(COSDictionary)}.
   *
   * <p>Method under test: {@link PDAdditionalActions#PDAdditionalActions(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAdditionalActions(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAdditionalActions.<init>(COSDictionary)"})
  void testNewPDAdditionalActions() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, new PDAdditionalActions(a).getCOSObject());
  }

  /**
   * Test {@link PDAdditionalActions#PDAdditionalActions()}.
   *
   * <p>Method under test: {@link PDAdditionalActions#PDAdditionalActions()}
   */
  @Test
  @DisplayName("Test new PDAdditionalActions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAdditionalActions.<init>()"})
  void testNewPDAdditionalActions2() {
    // Arrange and Act
    PDAdditionalActions actualPdAdditionalActions = new PDAdditionalActions();

    // Assert
    COSDictionary cOSObject = actualPdAdditionalActions.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdAdditionalActions.getF());
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
   * Test {@link PDAdditionalActions#getCOSObject()}.
   *
   * <p>Method under test: {@link PDAdditionalActions#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDAdditionalActions.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDAdditionalActions().getCOSObject();

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
   * Test {@link PDAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is {@link COSObjectKey#COSObjectKey(long,
   *       int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName(
      "Test getF(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDAdditionalActions.getF()"})
  void testGetF_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));
    PDActionEmbeddedGoTo action = new PDActionEmbeddedGoTo(a);

    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(action);

    // Act and Assert
    assertNull(pdAdditionalActions.getF());
  }

  /**
   * Test {@link PDAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()} SubType is {@code Sub Type}.
   * </ul>
   *
   * <p>Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName(
      "Test getF(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary() SubType is 'Sub Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDAdditionalActions.getF()"})
  void testGetF_givenPDActionEmbeddedGoToWithAIsCOSDictionarySubTypeIsSubType() {
    // Arrange
    PDActionEmbeddedGoTo action = new PDActionEmbeddedGoTo(new COSDictionary());
    action.setSubType("Sub Type");

    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(action);

    // Act and Assert
    assertNull(pdAdditionalActions.getF());
  }

  /**
   * Test {@link PDAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Given {@link PDAdditionalActions#PDAdditionalActions()} F is {@link
   *       PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName(
      "Test getF(); given PDAdditionalActions() F is PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDAdditionalActions.getF()"})
  void testGetF_givenPDAdditionalActionsFIsPDActionEmbeddedGoToWithAIsCOSDictionary() {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdAdditionalActions.getF());
  }

  /**
   * Test {@link PDAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Given {@link PDAdditionalActions#PDAdditionalActions()} F is {@link
   *       PDActionGoTo#PDActionGoTo()}.
   *   <li>Then return {@link PDActionGoTo}.
   * </ul>
   *
   * <p>Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName(
      "Test getF(); given PDAdditionalActions() F is PDActionGoTo(); then return PDActionGoTo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDAdditionalActions.getF()"})
  void testGetF_givenPDAdditionalActionsFIsPDActionGoTo_thenReturnPDActionGoTo()
      throws IOException {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionGoTo());

    // Act
    PDAction actualF = pdAdditionalActions.getF();

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
   * Test {@link PDAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Given {@link PDAdditionalActions#PDAdditionalActions()} F is {@link
   *       PDActionHide#PDActionHide()}.
   *   <li>Then return {@link PDActionHide}.
   * </ul>
   *
   * <p>Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName(
      "Test getF(); given PDAdditionalActions() F is PDActionHide(); then return PDActionHide")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDAdditionalActions.getF()"})
  void testGetF_givenPDAdditionalActionsFIsPDActionHide_thenReturnPDActionHide() {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionHide());

    // Act
    PDAction actualF = pdAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionHide);
    assertNull(((PDActionHide) actualF).getT());
    assertTrue(((PDActionHide) actualF).getH());
    assertEquals(PDActionHide.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Given {@link PDAdditionalActions#PDAdditionalActions()} F is {@link
   *       PDActionLaunch#PDActionLaunch()}.
   *   <li>Then return {@link PDActionLaunch}.
   * </ul>
   *
   * <p>Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName(
      "Test getF(); given PDAdditionalActions() F is PDActionLaunch(); then return PDActionLaunch")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDAdditionalActions.getF()"})
  void testGetF_givenPDAdditionalActionsFIsPDActionLaunch_thenReturnPDActionLaunch()
      throws IOException {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionLaunch());

    // Act
    PDAction actualF = pdAdditionalActions.getF();

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
   * Test {@link PDAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Given {@link PDAdditionalActions#PDAdditionalActions()} F is {@link
   *       PDActionMovie#PDActionMovie()}.
   *   <li>Then return {@link PDActionMovie}.
   * </ul>
   *
   * <p>Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName(
      "Test getF(); given PDAdditionalActions() F is PDActionMovie(); then return PDActionMovie")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDAdditionalActions.getF()"})
  void testGetF_givenPDAdditionalActionsFIsPDActionMovie_thenReturnPDActionMovie() {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionMovie());

    // Act
    PDAction actualF = pdAdditionalActions.getF();

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
   * Test {@link PDAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Given {@link PDAdditionalActions#PDAdditionalActions()} F is {@link
   *       PDActionNamed#PDActionNamed()}.
   *   <li>Then return {@link PDActionNamed}.
   * </ul>
   *
   * <p>Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName(
      "Test getF(); given PDAdditionalActions() F is PDActionNamed(); then return PDActionNamed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDAdditionalActions.getF()"})
  void testGetF_givenPDAdditionalActionsFIsPDActionNamed_thenReturnPDActionNamed() {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionNamed());

    // Act
    PDAction actualF = pdAdditionalActions.getF();

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
   * Test {@link PDAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Given {@link PDAdditionalActions#PDAdditionalActions()} F is {@link
   *       PDActionSound#PDActionSound()}.
   *   <li>Then return {@link PDActionSound}.
   * </ul>
   *
   * <p>Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName(
      "Test getF(); given PDAdditionalActions() F is PDActionSound(); then return PDActionSound")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDAdditionalActions.getF()"})
  void testGetF_givenPDAdditionalActionsFIsPDActionSound_thenReturnPDActionSound() {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionSound());

    // Act
    PDAction actualF = pdAdditionalActions.getF();

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
   * Test {@link PDAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Given {@link PDAdditionalActions#PDAdditionalActions()} F is {@link
   *       PDActionThread#PDActionThread()}.
   *   <li>Then return {@link PDActionThread}.
   * </ul>
   *
   * <p>Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName(
      "Test getF(); given PDAdditionalActions() F is PDActionThread(); then return PDActionThread")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDAdditionalActions.getF()"})
  void testGetF_givenPDAdditionalActionsFIsPDActionThread_thenReturnPDActionThread()
      throws IOException {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionThread());

    // Act
    PDAction actualF = pdAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionThread);
    assertNull(((PDActionThread) actualF).getB());
    assertNull(((PDActionThread) actualF).getD());
    assertNull(((PDActionThread) actualF).getFile());
    assertEquals(PDActionThread.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Given {@link PDAdditionalActions#PDAdditionalActions()} F is {@link
   *       PDActionURI#PDActionURI()}.
   *   <li>Then return {@link PDActionURI}.
   * </ul>
   *
   * <p>Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName(
      "Test getF(); given PDAdditionalActions() F is PDActionURI(); then return PDActionURI")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDAdditionalActions.getF()"})
  void testGetF_givenPDAdditionalActionsFIsPDActionURI_thenReturnPDActionURI() {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionURI());

    // Act
    PDAction actualF = pdAdditionalActions.getF();

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
   * Test {@link PDAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Given {@link PDAdditionalActions#PDAdditionalActions()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); given PDAdditionalActions(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDAdditionalActions.getF()"})
  void testGetF_givenPDAdditionalActions_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDAdditionalActions().getF());
  }

  /**
   * Test {@link PDAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionEmbeddedGoTo}.
   * </ul>
   *
   * <p>Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); then return PDActionEmbeddedGoTo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDAdditionalActions.getF()"})
  void testGetF_thenReturnPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualF = pdAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionEmbeddedGoTo);
    assertNull(((PDActionEmbeddedGoTo) actualF).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualF).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualF).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualF).getOpenInNewWindow());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionImportData}.
   * </ul>
   *
   * <p>Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); then return PDActionImportData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDAdditionalActions.getF()"})
  void testGetF_thenReturnPDActionImportData() throws IOException {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionImportData());

    // Act
    PDAction actualF = pdAdditionalActions.getF();

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
   * Test {@link PDAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionJavaScript}.
   * </ul>
   *
   * <p>Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); then return PDActionJavaScript")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDAdditionalActions.getF()"})
  void testGetF_thenReturnPDActionJavaScript() {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionJavaScript());

    // Act
    PDAction actualF = pdAdditionalActions.getF();

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
   * Test {@link PDAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionRemoteGoTo}.
   * </ul>
   *
   * <p>Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); then return PDActionRemoteGoTo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDAdditionalActions.getF()"})
  void testGetF_thenReturnPDActionRemoteGoTo() throws IOException {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionRemoteGoTo());

    // Act
    PDAction actualF = pdAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionRemoteGoTo);
    assertNull(((PDActionRemoteGoTo) actualF).getD());
    assertNull(((PDActionRemoteGoTo) actualF).getFile());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualF).getOpenInNewWindow());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionResetForm}.
   * </ul>
   *
   * <p>Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); then return PDActionResetForm")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDAdditionalActions.getF()"})
  void testGetF_thenReturnPDActionResetForm() {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionResetForm());

    // Act
    PDAction actualF = pdAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionResetForm);
    assertNull(((PDActionResetForm) actualF).getFields());
    assertEquals(0, ((PDActionResetForm) actualF).getFlags());
    assertEquals(PDActionResetForm.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDAdditionalActions#getF()}.
   *
   * <ul>
   *   <li>Then return {@link PDActionSubmitForm}.
   * </ul>
   *
   * <p>Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); then return PDActionSubmitForm")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDAdditionalActions.getF()"})
  void testGetF_thenReturnPDActionSubmitForm() throws IOException {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionSubmitForm());

    // Act
    PDAction actualF = pdAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionSubmitForm);
    assertNull(((PDActionSubmitForm) actualF).getFields());
    assertNull(((PDActionSubmitForm) actualF).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualF).getFlags());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDAdditionalActions#setF(PDAction)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAdditionalActions#setF(PDAction)}
   */
  @Test
  @DisplayName("Test setF(PDAction); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAdditionalActions.setF(PDAction)"})
  void testSetF_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();

    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAdditionalActions.setF(new PDActionEmbeddedGoTo(a));

    // Assert
    assertNull(pdAdditionalActions.getF());
    COSDictionary cOSObject = pdAdditionalActions.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAdditionalActions#setF(PDAction)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   *   <li>Then {@link PDAdditionalActions#PDAdditionalActions()} F is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAdditionalActions#setF(PDAction)}
   */
  @Test
  @DisplayName(
      "Test setF(PDAction); given 'true'; when COSDictionary() Direct is 'true'; then PDAdditionalActions() F is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAdditionalActions.setF(PDAction)"})
  void testSetF_givenTrue_whenCOSDictionaryDirectIsTrue_thenPDAdditionalActionsFIsNull() {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();

    COSDictionary a = new COSDictionary();
    a.setDirect(true);

    // Act
    pdAdditionalActions.setF(new PDActionEmbeddedGoTo(a));

    // Assert
    assertNull(pdAdditionalActions.getF());
    COSDictionary cOSObject = pdAdditionalActions.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAdditionalActions#setF(PDAction)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAdditionalActions#PDAdditionalActions()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDAdditionalActions#setF(PDAction)}
   */
  @Test
  @DisplayName(
      "Test setF(PDAction); when 'null'; then PDAdditionalActions() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAdditionalActions.setF(PDAction)"})
  void testSetF_whenNull_thenPDAdditionalActionsCOSObjectSizeIsZero() {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();

    // Act
    pdAdditionalActions.setF(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAdditionalActions.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDAdditionalActions#setF(PDAction)}.
   *
   * <ul>
   *   <li>When {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.
   *   <li>Then {@link PDAdditionalActions#PDAdditionalActions()} F {@link PDActionEmbeddedGoTo}.
   * </ul>
   *
   * <p>Method under test: {@link PDAdditionalActions#setF(PDAction)}
   */
  @Test
  @DisplayName(
      "Test setF(PDAction); when PDActionEmbeddedGoTo(); then PDAdditionalActions() F PDActionEmbeddedGoTo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAdditionalActions.setF(PDAction)"})
  void testSetF_whenPDActionEmbeddedGoTo_thenPDAdditionalActionsFPDActionEmbeddedGoTo()
      throws IOException {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();

    // Act
    pdAdditionalActions.setF(new PDActionEmbeddedGoTo());

    // Assert
    PDAction f = pdAdditionalActions.getF();
    assertTrue(f instanceof PDActionEmbeddedGoTo);
    assertNull(f.getNext());
    assertNull(((PDActionEmbeddedGoTo) f).getFile());
    assertNull(((PDActionEmbeddedGoTo) f).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) f).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) f).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, f.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, f.getSubType());
  }
}

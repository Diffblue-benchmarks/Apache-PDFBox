package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDAdditionalActionsDiffblueTest {
  /**
   * Test {@link PDAdditionalActions#PDAdditionalActions(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDAdditionalActions#PDAdditionalActions(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAdditionalActions(COSDictionary)")
  void testNewPDAdditionalActions() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDAdditionalActions(a)).getCOSObject());
  }

  /**
   * Test {@link PDAdditionalActions#PDAdditionalActions()}.
   * <p>
   * Method under test: {@link PDAdditionalActions#PDAdditionalActions()}
   */
  @Test
  @DisplayName("Test new PDAdditionalActions()")
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
   * <p>
   * Method under test: {@link PDAdditionalActions#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDAdditionalActions()).getCOSObject();

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
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
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
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} SubType is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary() SubType is 'foo'")
  void testGetF_givenPDActionEmbeddedGoToWithAIsCOSDictionarySubTypeIsFoo() {
    // Arrange
    PDActionEmbeddedGoTo action = new PDActionEmbeddedGoTo(new COSDictionary());
    action.setSubType("foo");

    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(action);

    // Act and Assert
    assertNull(pdAdditionalActions.getF());
  }

  /**
   * Test {@link PDAdditionalActions#getF()}.
   * <ul>
   *   <li>Given {@link PDAdditionalActions#PDAdditionalActions()} F is
   * {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)} with a is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); given PDAdditionalActions() F is PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary()")
  void testGetF_givenPDAdditionalActionsFIsPDActionEmbeddedGoToWithAIsCOSDictionary() {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdAdditionalActions.getF());
  }

  /**
   * Test {@link PDAdditionalActions#getF()}.
   * <ul>
   *   <li>Given {@link PDAdditionalActions#PDAdditionalActions()} F is
   * {@link PDActionGoTo#PDActionGoTo()}.</li>
   *   <li>Then return {@link PDActionGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); given PDAdditionalActions() F is PDActionGoTo(); then return PDActionGoTo")
  void testGetF_givenPDAdditionalActionsFIsPDActionGoTo_thenReturnPDActionGoTo() throws IOException {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionGoTo());

    // Act
    PDAction actualF = pdAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionGoTo);
    assertNull(actualF.getNext());
    COSDictionary cOSObject = actualF.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualF).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualF.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDAdditionalActions#getF()}.
   * <ul>
   *   <li>Given {@link PDAdditionalActions#PDAdditionalActions()} F is
   * {@link PDActionHide#PDActionHide()}.</li>
   *   <li>Then return {@link PDActionHide}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); given PDAdditionalActions() F is PDActionHide(); then return PDActionHide")
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
   * <ul>
   *   <li>Given {@link PDAdditionalActions#PDAdditionalActions()} F is
   * {@link PDActionLaunch#PDActionLaunch()}.</li>
   *   <li>Then return {@link PDActionLaunch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); given PDAdditionalActions() F is PDActionLaunch(); then return PDActionLaunch")
  void testGetF_givenPDAdditionalActionsFIsPDActionLaunch_thenReturnPDActionLaunch() throws IOException {
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
   * <ul>
   *   <li>Given {@link PDAdditionalActions#PDAdditionalActions()} F is
   * {@link PDActionMovie#PDActionMovie()}.</li>
   *   <li>Then return {@link PDActionMovie}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); given PDAdditionalActions() F is PDActionMovie(); then return PDActionMovie")
  void testGetF_givenPDAdditionalActionsFIsPDActionMovie_thenReturnPDActionMovie() {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionMovie());

    // Act
    PDAction actualF = pdAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionMovie);
    assertNull(actualF.getNext());
    COSDictionary cOSObject = actualF.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualF.getType());
    assertEquals(PDActionMovie.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDAdditionalActions#getF()}.
   * <ul>
   *   <li>Given {@link PDAdditionalActions#PDAdditionalActions()} F is
   * {@link PDActionNamed#PDActionNamed()}.</li>
   *   <li>Then return {@link PDActionNamed}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); given PDAdditionalActions() F is PDActionNamed(); then return PDActionNamed")
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
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualF.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDAdditionalActions#getF()}.
   * <ul>
   *   <li>Given {@link PDAdditionalActions#PDAdditionalActions()} F is
   * {@link PDActionSound#PDActionSound()}.</li>
   *   <li>Then return {@link PDActionSound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); given PDAdditionalActions() F is PDActionSound(); then return PDActionSound")
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
   * <ul>
   *   <li>Given {@link PDAdditionalActions#PDAdditionalActions()} F is
   * {@link PDActionThread#PDActionThread()}.</li>
   *   <li>Then return {@link PDActionThread}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); given PDAdditionalActions() F is PDActionThread(); then return PDActionThread")
  void testGetF_givenPDAdditionalActionsFIsPDActionThread_thenReturnPDActionThread() throws IOException {
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
   * <ul>
   *   <li>Given {@link PDAdditionalActions#PDAdditionalActions()} F is
   * {@link PDActionURI#PDActionURI()}.</li>
   *   <li>Then return {@link PDActionURI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); given PDAdditionalActions() F is PDActionURI(); then return PDActionURI")
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
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualF.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDAdditionalActions#getF()}.
   * <ul>
   *   <li>Given {@link PDAdditionalActions#PDAdditionalActions()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); given PDAdditionalActions(); then return 'null'")
  void testGetF_givenPDAdditionalActions_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDAdditionalActions()).getF());
  }

  /**
   * Test {@link PDAdditionalActions#getF()}.
   * <ul>
   *   <li>Then return {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); then return PDActionEmbeddedGoTo")
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
   * <ul>
   *   <li>Then return {@link PDActionImportData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); then return PDActionImportData")
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
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualF).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualF.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDAdditionalActions#getF()}.
   * <ul>
   *   <li>Then return {@link PDActionJavaScript}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); then return PDActionJavaScript")
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
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualF.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Test {@link PDAdditionalActions#getF()}.
   * <ul>
   *   <li>Then return {@link PDActionRemoteGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); then return PDActionRemoteGoTo")
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
   * <ul>
   *   <li>Then return {@link PDActionResetForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); then return PDActionResetForm")
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
   * <ul>
   *   <li>Then return {@link PDActionSubmitForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  @DisplayName("Test getF(); then return PDActionSubmitForm")
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
   * <ul>
   *   <li>Given {@link PDAdditionalActions#PDAdditionalActions()}.</li>
   *   <li>Then {@link PDAdditionalActions#PDAdditionalActions()} F
   * {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAdditionalActions#setF(PDAction)}
   */
  @Test
  @DisplayName("Test setF(PDAction); given PDAdditionalActions(); then PDAdditionalActions() F PDActionEmbeddedGoTo")
  void testSetF_givenPDAdditionalActions_thenPDAdditionalActionsFPDActionEmbeddedGoTo() throws IOException {
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
    COSDictionary cOSObject = pdAdditionalActions.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) f).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, f.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, f.getSubType());
  }

  /**
   * Test {@link PDAdditionalActions#setF(PDAction)}.
   * <ul>
   *   <li>Then {@link PDAdditionalActions#PDAdditionalActions(COSDictionary)} with
   * a is {@link COSDictionary#COSDictionary()} F is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAdditionalActions#setF(PDAction)}
   */
  @Test
  @DisplayName("Test setF(PDAction); then PDAdditionalActions(COSDictionary) with a is COSDictionary() F is 'null'")
  void testSetF_thenPDAdditionalActionsWithAIsCOSDictionaryFIsNull() {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions(new COSDictionary());

    // Act
    pdAdditionalActions.setF(null);

    // Assert
    assertNull(pdAdditionalActions.getF());
    COSDictionary cOSObject = pdAdditionalActions.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }
}

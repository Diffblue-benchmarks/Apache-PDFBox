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
import org.junit.jupiter.api.Test;

class PDAdditionalActionsDiffblueTest {
  /**
   * Method under test: {@link PDAdditionalActions#getCOSObject()}
   */
  @Test
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
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  void testGetF() {
    // Arrange, Act and Assert
    assertNull((new PDAdditionalActions()).getF());
  }

  /**
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  void testGetF2() throws IOException {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualF = pdAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionEmbeddedGoTo);
    assertNull(actualF.getNext());
    COSDictionary cOSObject = actualF.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionEmbeddedGoTo) actualF).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualF).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualF).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualF).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualF.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  void testGetF3() {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdAdditionalActions.getF());
  }

  /**
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  void testGetF4() throws IOException {
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
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  void testGetF5() {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionHide());

    // Act
    PDAction actualF = pdAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionHide);
    assertNull(actualF.getNext());
    assertNull(((PDActionHide) actualF).getT());
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
    assertTrue(((PDActionHide) actualF).getH());
    assertEquals(PDAction.TYPE, actualF.getType());
    assertEquals(PDActionHide.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  void testGetF6() throws IOException {
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
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  void testGetF7() {
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
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  void testGetF8() {
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
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  void testGetF9() {
    // Arrange
    PDActionEmbeddedGoTo action = new PDActionEmbeddedGoTo(new COSDictionary());
    action.setSubType("foo");

    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(action);

    // Act and Assert
    assertNull(pdAdditionalActions.getF());
  }

  /**
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  void testGetF10() throws IOException {
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
    assertNull(actualF.getNext());
    COSDictionary cOSObject = actualF.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionLaunch) actualF).getFile());
    assertNull(((PDActionLaunch) actualF).getWinLaunchParams());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualF).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualF.getType());
    assertEquals(PDActionLaunch.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  void testGetF11() {
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
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  void testGetF12() {
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
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  void testGetF13() throws IOException {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionRemoteGoTo());

    // Act
    PDAction actualF = pdAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionRemoteGoTo);
    assertNull(actualF.getNext());
    assertNull(((PDActionRemoteGoTo) actualF).getD());
    COSDictionary cOSObject = actualF.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionRemoteGoTo) actualF).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualF).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualF.getType());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  void testGetF14() {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionResetForm());

    // Act
    PDAction actualF = pdAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionResetForm);
    assertNull(actualF.getNext());
    assertNull(((PDActionResetForm) actualF).getFields());
    COSDictionary cOSObject = actualF.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((PDActionResetForm) actualF).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualF.getType());
    assertEquals(PDActionResetForm.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  void testGetF15() {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionSound());

    // Act
    PDAction actualF = pdAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionSound);
    assertNull(actualF.getNext());
    COSDictionary cOSObject = actualF.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSound) actualF).getSound());
    assertEquals(1.0f, ((PDActionSound) actualF).getVolume());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDActionSound) actualF).getMix());
    assertFalse(((PDActionSound) actualF).getRepeat());
    assertFalse(((PDActionSound) actualF).getSynchronous());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualF.getType());
    assertEquals(PDActionSound.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  void testGetF16() throws IOException {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionSubmitForm());

    // Act
    PDAction actualF = pdAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionSubmitForm);
    assertNull(actualF.getNext());
    assertNull(((PDActionSubmitForm) actualF).getFields());
    COSDictionary cOSObject = actualF.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSubmitForm) actualF).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualF).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualF.getType());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  void testGetF17() throws IOException {
    // Arrange
    PDAdditionalActions pdAdditionalActions = new PDAdditionalActions();
    pdAdditionalActions.setF(new PDActionThread());

    // Act
    PDAction actualF = pdAdditionalActions.getF();

    // Assert
    assertTrue(actualF instanceof PDActionThread);
    assertNull(actualF.getNext());
    assertNull(((PDActionThread) actualF).getB());
    assertNull(((PDActionThread) actualF).getD());
    COSDictionary cOSObject = actualF.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionThread) actualF).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualF.getType());
    assertEquals(PDActionThread.SUB_TYPE, actualF.getSubType());
  }

  /**
   * Method under test: {@link PDAdditionalActions#getF()}
   */
  @Test
  void testGetF18() {
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
   * Method under test: {@link PDAdditionalActions#setF(PDAction)}
   */
  @Test
  void testSetF() throws IOException {
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
   * Method under test:
   * {@link PDAdditionalActions#PDAdditionalActions(COSDictionary)}
   */
  @Test
  void testNewPDAdditionalActions() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDAdditionalActions(a)).getCOSObject());
  }

  /**
   * Method under test: {@link PDAdditionalActions#PDAdditionalActions()}
   */
  @Test
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
}

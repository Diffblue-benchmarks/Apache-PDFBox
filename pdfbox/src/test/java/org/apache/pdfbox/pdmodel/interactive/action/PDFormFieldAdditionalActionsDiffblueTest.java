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

class PDFormFieldAdditionalActionsDiffblueTest {
  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDFormFieldAdditionalActions()).getCOSObject();

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
   * Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  void testGetK() {
    // Arrange, Act and Assert
    assertNull((new PDFormFieldAdditionalActions()).getK());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  void testGetK2() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualK = pdFormFieldAdditionalActions.getK();

    // Assert
    assertTrue(actualK instanceof PDActionEmbeddedGoTo);
    assertNull(actualK.getNext());
    COSDictionary cOSObject = actualK.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionEmbeddedGoTo) actualK).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualK).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualK).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualK).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualK.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  void testGetK3() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdFormFieldAdditionalActions.getK());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  void testGetK4() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionGoTo());

    // Act
    PDAction actualK = pdFormFieldAdditionalActions.getK();

    // Assert
    assertTrue(actualK instanceof PDActionGoTo);
    assertNull(actualK.getNext());
    COSDictionary cOSObject = actualK.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualK).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualK.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  void testGetK5() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionHide());

    // Act
    PDAction actualK = pdFormFieldAdditionalActions.getK();

    // Assert
    assertTrue(actualK instanceof PDActionHide);
    assertNull(actualK.getNext());
    assertNull(((PDActionHide) actualK).getT());
    COSDictionary cOSObject = actualK.getCOSObject();
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
    assertTrue(((PDActionHide) actualK).getH());
    assertEquals(PDAction.TYPE, actualK.getType());
    assertEquals(PDActionHide.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  void testGetK6() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionImportData());

    // Act
    PDAction actualK = pdFormFieldAdditionalActions.getK();

    // Assert
    assertTrue(actualK instanceof PDActionImportData);
    assertNull(actualK.getNext());
    COSDictionary cOSObject = actualK.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualK).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualK.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  void testGetK7() {
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
    assertEquals(PDAction.TYPE, actualK.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  void testGetK8() {
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
   * Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  void testGetK9() {
    // Arrange
    PDActionEmbeddedGoTo k = new PDActionEmbeddedGoTo(new COSDictionary());
    k.setSubType("foo");

    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(k);

    // Act and Assert
    assertNull(pdFormFieldAdditionalActions.getK());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  void testGetK10() throws IOException {
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
    assertNull(actualK.getNext());
    COSDictionary cOSObject = actualK.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionLaunch) actualK).getFile());
    assertNull(((PDActionLaunch) actualK).getWinLaunchParams());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualK).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualK.getType());
    assertEquals(PDActionLaunch.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  void testGetK11() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionMovie());

    // Act
    PDAction actualK = pdFormFieldAdditionalActions.getK();

    // Assert
    assertTrue(actualK instanceof PDActionMovie);
    assertNull(actualK.getNext());
    COSDictionary cOSObject = actualK.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualK.getType());
    assertEquals(PDActionMovie.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  void testGetK12() {
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
    assertEquals(PDAction.TYPE, actualK.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  void testGetK13() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionRemoteGoTo());

    // Act
    PDAction actualK = pdFormFieldAdditionalActions.getK();

    // Assert
    assertTrue(actualK instanceof PDActionRemoteGoTo);
    assertNull(actualK.getNext());
    assertNull(((PDActionRemoteGoTo) actualK).getD());
    COSDictionary cOSObject = actualK.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionRemoteGoTo) actualK).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualK).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualK.getType());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  void testGetK14() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionResetForm());

    // Act
    PDAction actualK = pdFormFieldAdditionalActions.getK();

    // Assert
    assertTrue(actualK instanceof PDActionResetForm);
    assertNull(actualK.getNext());
    assertNull(((PDActionResetForm) actualK).getFields());
    COSDictionary cOSObject = actualK.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((PDActionResetForm) actualK).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualK.getType());
    assertEquals(PDActionResetForm.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  void testGetK15() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionSound());

    // Act
    PDAction actualK = pdFormFieldAdditionalActions.getK();

    // Assert
    assertTrue(actualK instanceof PDActionSound);
    assertNull(actualK.getNext());
    COSDictionary cOSObject = actualK.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSound) actualK).getSound());
    assertEquals(1.0f, ((PDActionSound) actualK).getVolume());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDActionSound) actualK).getMix());
    assertFalse(((PDActionSound) actualK).getRepeat());
    assertFalse(((PDActionSound) actualK).getSynchronous());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualK.getType());
    assertEquals(PDActionSound.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  void testGetK16() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionSubmitForm());

    // Act
    PDAction actualK = pdFormFieldAdditionalActions.getK();

    // Assert
    assertTrue(actualK instanceof PDActionSubmitForm);
    assertNull(actualK.getNext());
    assertNull(((PDActionSubmitForm) actualK).getFields());
    COSDictionary cOSObject = actualK.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSubmitForm) actualK).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualK).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualK.getType());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  void testGetK17() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setK(new PDActionThread());

    // Act
    PDAction actualK = pdFormFieldAdditionalActions.getK();

    // Assert
    assertTrue(actualK instanceof PDActionThread);
    assertNull(actualK.getNext());
    assertNull(((PDActionThread) actualK).getB());
    assertNull(((PDActionThread) actualK).getD());
    COSDictionary cOSObject = actualK.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionThread) actualK).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualK.getType());
    assertEquals(PDActionThread.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getK()}
   */
  @Test
  void testGetK18() {
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
    assertEquals(PDAction.TYPE, actualK.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualK.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#setK(PDAction)}
   */
  @Test
  void testSetK() throws IOException {
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
   * Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  void testGetF() {
    // Arrange, Act and Assert
    assertNull((new PDFormFieldAdditionalActions()).getF());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  void testGetF2() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualF = pdFormFieldAdditionalActions.getF();

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
   * Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  void testGetF3() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdFormFieldAdditionalActions.getF());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  void testGetF4() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionGoTo());

    // Act
    PDAction actualF = pdFormFieldAdditionalActions.getF();

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
   * Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  void testGetF5() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionHide());

    // Act
    PDAction actualF = pdFormFieldAdditionalActions.getF();

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
   * Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  void testGetF6() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionImportData());

    // Act
    PDAction actualF = pdFormFieldAdditionalActions.getF();

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
   * Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  void testGetF7() {
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
   * Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  void testGetF8() {
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
   * Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  void testGetF9() {
    // Arrange
    PDActionEmbeddedGoTo f = new PDActionEmbeddedGoTo(new COSDictionary());
    f.setSubType("foo");

    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(f);

    // Act and Assert
    assertNull(pdFormFieldAdditionalActions.getF());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  void testGetF10() throws IOException {
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
   * Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  void testGetF11() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionMovie());

    // Act
    PDAction actualF = pdFormFieldAdditionalActions.getF();

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
   * Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  void testGetF12() {
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
   * Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  void testGetF13() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionRemoteGoTo());

    // Act
    PDAction actualF = pdFormFieldAdditionalActions.getF();

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
   * Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  void testGetF14() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionResetForm());

    // Act
    PDAction actualF = pdFormFieldAdditionalActions.getF();

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
   * Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  void testGetF15() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionSound());

    // Act
    PDAction actualF = pdFormFieldAdditionalActions.getF();

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
   * Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  void testGetF16() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionSubmitForm());

    // Act
    PDAction actualF = pdFormFieldAdditionalActions.getF();

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
   * Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  void testGetF17() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setF(new PDActionThread());

    // Act
    PDAction actualF = pdFormFieldAdditionalActions.getF();

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
   * Method under test: {@link PDFormFieldAdditionalActions#getF()}
   */
  @Test
  void testGetF18() {
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
   * Method under test: {@link PDFormFieldAdditionalActions#setF(PDAction)}
   */
  @Test
  void testSetF() throws IOException {
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
   * Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  void testGetV() {
    // Arrange, Act and Assert
    assertNull((new PDFormFieldAdditionalActions()).getV());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  void testGetV2() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualV = pdFormFieldAdditionalActions.getV();

    // Assert
    assertTrue(actualV instanceof PDActionEmbeddedGoTo);
    assertNull(actualV.getNext());
    COSDictionary cOSObject = actualV.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionEmbeddedGoTo) actualV).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualV).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualV).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualV).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualV.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  void testGetV3() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdFormFieldAdditionalActions.getV());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  void testGetV4() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionGoTo());

    // Act
    PDAction actualV = pdFormFieldAdditionalActions.getV();

    // Assert
    assertTrue(actualV instanceof PDActionGoTo);
    assertNull(actualV.getNext());
    COSDictionary cOSObject = actualV.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualV).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualV.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  void testGetV5() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionHide());

    // Act
    PDAction actualV = pdFormFieldAdditionalActions.getV();

    // Assert
    assertTrue(actualV instanceof PDActionHide);
    assertNull(actualV.getNext());
    assertNull(((PDActionHide) actualV).getT());
    COSDictionary cOSObject = actualV.getCOSObject();
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
    assertTrue(((PDActionHide) actualV).getH());
    assertEquals(PDAction.TYPE, actualV.getType());
    assertEquals(PDActionHide.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  void testGetV6() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionImportData());

    // Act
    PDAction actualV = pdFormFieldAdditionalActions.getV();

    // Assert
    assertTrue(actualV instanceof PDActionImportData);
    assertNull(actualV.getNext());
    COSDictionary cOSObject = actualV.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualV).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualV.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  void testGetV7() {
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
    assertEquals(PDAction.TYPE, actualV.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  void testGetV8() {
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
   * Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  void testGetV9() {
    // Arrange
    PDActionEmbeddedGoTo v = new PDActionEmbeddedGoTo(new COSDictionary());
    v.setSubType("foo");

    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(v);

    // Act and Assert
    assertNull(pdFormFieldAdditionalActions.getV());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  void testGetV10() throws IOException {
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
    assertNull(actualV.getNext());
    COSDictionary cOSObject = actualV.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionLaunch) actualV).getFile());
    assertNull(((PDActionLaunch) actualV).getWinLaunchParams());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualV).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualV.getType());
    assertEquals(PDActionLaunch.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  void testGetV11() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionMovie());

    // Act
    PDAction actualV = pdFormFieldAdditionalActions.getV();

    // Assert
    assertTrue(actualV instanceof PDActionMovie);
    assertNull(actualV.getNext());
    COSDictionary cOSObject = actualV.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualV.getType());
    assertEquals(PDActionMovie.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  void testGetV12() {
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
    assertEquals(PDAction.TYPE, actualV.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  void testGetV13() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionRemoteGoTo());

    // Act
    PDAction actualV = pdFormFieldAdditionalActions.getV();

    // Assert
    assertTrue(actualV instanceof PDActionRemoteGoTo);
    assertNull(actualV.getNext());
    assertNull(((PDActionRemoteGoTo) actualV).getD());
    COSDictionary cOSObject = actualV.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionRemoteGoTo) actualV).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualV).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualV.getType());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  void testGetV14() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionResetForm());

    // Act
    PDAction actualV = pdFormFieldAdditionalActions.getV();

    // Assert
    assertTrue(actualV instanceof PDActionResetForm);
    assertNull(actualV.getNext());
    assertNull(((PDActionResetForm) actualV).getFields());
    COSDictionary cOSObject = actualV.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((PDActionResetForm) actualV).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualV.getType());
    assertEquals(PDActionResetForm.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  void testGetV15() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionSound());

    // Act
    PDAction actualV = pdFormFieldAdditionalActions.getV();

    // Assert
    assertTrue(actualV instanceof PDActionSound);
    assertNull(actualV.getNext());
    COSDictionary cOSObject = actualV.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSound) actualV).getSound());
    assertEquals(1.0f, ((PDActionSound) actualV).getVolume());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDActionSound) actualV).getMix());
    assertFalse(((PDActionSound) actualV).getRepeat());
    assertFalse(((PDActionSound) actualV).getSynchronous());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualV.getType());
    assertEquals(PDActionSound.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  void testGetV16() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionSubmitForm());

    // Act
    PDAction actualV = pdFormFieldAdditionalActions.getV();

    // Assert
    assertTrue(actualV instanceof PDActionSubmitForm);
    assertNull(actualV.getNext());
    assertNull(((PDActionSubmitForm) actualV).getFields());
    COSDictionary cOSObject = actualV.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSubmitForm) actualV).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualV).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualV.getType());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  void testGetV17() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setV(new PDActionThread());

    // Act
    PDAction actualV = pdFormFieldAdditionalActions.getV();

    // Assert
    assertTrue(actualV instanceof PDActionThread);
    assertNull(actualV.getNext());
    assertNull(((PDActionThread) actualV).getB());
    assertNull(((PDActionThread) actualV).getD());
    COSDictionary cOSObject = actualV.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionThread) actualV).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualV.getType());
    assertEquals(PDActionThread.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getV()}
   */
  @Test
  void testGetV18() {
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
    assertEquals(PDAction.TYPE, actualV.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualV.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#setV(PDAction)}
   */
  @Test
  void testSetV() throws IOException {
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
   * Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  void testGetC() {
    // Arrange, Act and Assert
    assertNull((new PDFormFieldAdditionalActions()).getC());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  void testGetC2() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualC = pdFormFieldAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionEmbeddedGoTo);
    assertNull(actualC.getNext());
    COSDictionary cOSObject = actualC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionEmbeddedGoTo) actualC).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualC).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualC).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualC).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualC.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  void testGetC3() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdFormFieldAdditionalActions.getC());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  void testGetC4() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionGoTo());

    // Act
    PDAction actualC = pdFormFieldAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionGoTo);
    assertNull(actualC.getNext());
    COSDictionary cOSObject = actualC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualC).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualC.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  void testGetC5() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionHide());

    // Act
    PDAction actualC = pdFormFieldAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionHide);
    assertNull(actualC.getNext());
    assertNull(((PDActionHide) actualC).getT());
    COSDictionary cOSObject = actualC.getCOSObject();
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
    assertTrue(((PDActionHide) actualC).getH());
    assertEquals(PDAction.TYPE, actualC.getType());
    assertEquals(PDActionHide.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  void testGetC6() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionImportData());

    // Act
    PDAction actualC = pdFormFieldAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionImportData);
    assertNull(actualC.getNext());
    COSDictionary cOSObject = actualC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualC).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualC.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  void testGetC7() {
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
    assertEquals(PDAction.TYPE, actualC.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  void testGetC8() {
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
   * Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  void testGetC9() {
    // Arrange
    PDActionEmbeddedGoTo c = new PDActionEmbeddedGoTo(new COSDictionary());
    c.setSubType("foo");

    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(c);

    // Act and Assert
    assertNull(pdFormFieldAdditionalActions.getC());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  void testGetC10() throws IOException {
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
    assertNull(actualC.getNext());
    COSDictionary cOSObject = actualC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionLaunch) actualC).getFile());
    assertNull(((PDActionLaunch) actualC).getWinLaunchParams());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualC).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualC.getType());
    assertEquals(PDActionLaunch.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  void testGetC11() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionMovie());

    // Act
    PDAction actualC = pdFormFieldAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionMovie);
    assertNull(actualC.getNext());
    COSDictionary cOSObject = actualC.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualC.getType());
    assertEquals(PDActionMovie.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  void testGetC12() {
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
    assertEquals(PDAction.TYPE, actualC.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  void testGetC13() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionRemoteGoTo());

    // Act
    PDAction actualC = pdFormFieldAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionRemoteGoTo);
    assertNull(actualC.getNext());
    assertNull(((PDActionRemoteGoTo) actualC).getD());
    COSDictionary cOSObject = actualC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionRemoteGoTo) actualC).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualC).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualC.getType());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  void testGetC14() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionResetForm());

    // Act
    PDAction actualC = pdFormFieldAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionResetForm);
    assertNull(actualC.getNext());
    assertNull(((PDActionResetForm) actualC).getFields());
    COSDictionary cOSObject = actualC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((PDActionResetForm) actualC).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualC.getType());
    assertEquals(PDActionResetForm.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  void testGetC15() {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionSound());

    // Act
    PDAction actualC = pdFormFieldAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionSound);
    assertNull(actualC.getNext());
    COSDictionary cOSObject = actualC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSound) actualC).getSound());
    assertEquals(1.0f, ((PDActionSound) actualC).getVolume());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDActionSound) actualC).getMix());
    assertFalse(((PDActionSound) actualC).getRepeat());
    assertFalse(((PDActionSound) actualC).getSynchronous());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualC.getType());
    assertEquals(PDActionSound.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  void testGetC16() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionSubmitForm());

    // Act
    PDAction actualC = pdFormFieldAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionSubmitForm);
    assertNull(actualC.getNext());
    assertNull(((PDActionSubmitForm) actualC).getFields());
    COSDictionary cOSObject = actualC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSubmitForm) actualC).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualC).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualC.getType());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  void testGetC17() throws IOException {
    // Arrange
    PDFormFieldAdditionalActions pdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();
    pdFormFieldAdditionalActions.setC(new PDActionThread());

    // Act
    PDAction actualC = pdFormFieldAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionThread);
    assertNull(actualC.getNext());
    assertNull(((PDActionThread) actualC).getB());
    assertNull(((PDActionThread) actualC).getD());
    COSDictionary cOSObject = actualC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionThread) actualC).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualC.getType());
    assertEquals(PDActionThread.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#getC()}
   */
  @Test
  void testGetC18() {
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
    assertEquals(PDAction.TYPE, actualC.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Method under test: {@link PDFormFieldAdditionalActions#setC(PDAction)}
   */
  @Test
  void testSetC() throws IOException {
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
   * Method under test:
   * {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions(COSDictionary)}
   */
  @Test
  void testNewPDFormFieldAdditionalActions() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDFormFieldAdditionalActions(a)).getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDFormFieldAdditionalActions#PDFormFieldAdditionalActions()}
   */
  @Test
  void testNewPDFormFieldAdditionalActions2() {
    // Arrange and Act
    PDFormFieldAdditionalActions actualPdFormFieldAdditionalActions = new PDFormFieldAdditionalActions();

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
}

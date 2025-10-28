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

class PDAnnotationAdditionalActionsDiffblueTest {
  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDAnnotationAdditionalActions()).getCOSObject();

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
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  void testGetE() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationAdditionalActions()).getE());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  void testGetE2() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualE = pdAnnotationAdditionalActions.getE();

    // Assert
    assertTrue(actualE instanceof PDActionEmbeddedGoTo);
    assertNull(actualE.getNext());
    COSDictionary cOSObject = actualE.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionEmbeddedGoTo) actualE).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualE).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualE).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualE).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualE.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualE.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  void testGetE3() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getE());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  void testGetE4() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionGoTo());

    // Act
    PDAction actualE = pdAnnotationAdditionalActions.getE();

    // Assert
    assertTrue(actualE instanceof PDActionGoTo);
    assertNull(actualE.getNext());
    COSDictionary cOSObject = actualE.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualE).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualE.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualE.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  void testGetE5() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionHide());

    // Act
    PDAction actualE = pdAnnotationAdditionalActions.getE();

    // Assert
    assertTrue(actualE instanceof PDActionHide);
    assertNull(actualE.getNext());
    assertNull(((PDActionHide) actualE).getT());
    COSDictionary cOSObject = actualE.getCOSObject();
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
    assertTrue(((PDActionHide) actualE).getH());
    assertEquals(PDAction.TYPE, actualE.getType());
    assertEquals(PDActionHide.SUB_TYPE, actualE.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  void testGetE6() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionImportData());

    // Act
    PDAction actualE = pdAnnotationAdditionalActions.getE();

    // Assert
    assertTrue(actualE instanceof PDActionImportData);
    assertNull(actualE.getNext());
    COSDictionary cOSObject = actualE.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualE).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualE.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualE.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  void testGetE7() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionJavaScript());

    // Act
    PDAction actualE = pdAnnotationAdditionalActions.getE();

    // Assert
    assertTrue(actualE instanceof PDActionJavaScript);
    assertNull(((PDActionJavaScript) actualE).getAction());
    assertNull(actualE.getNext());
    COSDictionary cOSObject = actualE.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualE.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualE.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  void testGetE8() {
    // Arrange
    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));
    PDActionEmbeddedGoTo e = new PDActionEmbeddedGoTo(a);

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(e);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getE());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  void testGetE9() {
    // Arrange
    PDActionEmbeddedGoTo e = new PDActionEmbeddedGoTo(new COSDictionary());
    e.setSubType("foo");

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(e);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getE());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  void testGetE10() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionLaunch());

    // Act
    PDAction actualE = pdAnnotationAdditionalActions.getE();

    // Assert
    assertTrue(actualE instanceof PDActionLaunch);
    assertNull(((PDActionLaunch) actualE).getD());
    assertNull(((PDActionLaunch) actualE).getF());
    assertNull(((PDActionLaunch) actualE).getO());
    assertNull(((PDActionLaunch) actualE).getP());
    assertNull(actualE.getNext());
    COSDictionary cOSObject = actualE.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionLaunch) actualE).getFile());
    assertNull(((PDActionLaunch) actualE).getWinLaunchParams());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualE).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualE.getType());
    assertEquals(PDActionLaunch.SUB_TYPE, actualE.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  void testGetE11() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionMovie());

    // Act
    PDAction actualE = pdAnnotationAdditionalActions.getE();

    // Assert
    assertTrue(actualE instanceof PDActionMovie);
    assertNull(actualE.getNext());
    COSDictionary cOSObject = actualE.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualE.getType());
    assertEquals(PDActionMovie.SUB_TYPE, actualE.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  void testGetE12() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionNamed());

    // Act
    PDAction actualE = pdAnnotationAdditionalActions.getE();

    // Assert
    assertTrue(actualE instanceof PDActionNamed);
    assertNull(((PDActionNamed) actualE).getN());
    assertNull(actualE.getNext());
    COSDictionary cOSObject = actualE.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualE.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualE.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  void testGetE13() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionRemoteGoTo());

    // Act
    PDAction actualE = pdAnnotationAdditionalActions.getE();

    // Assert
    assertTrue(actualE instanceof PDActionRemoteGoTo);
    assertNull(actualE.getNext());
    assertNull(((PDActionRemoteGoTo) actualE).getD());
    COSDictionary cOSObject = actualE.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionRemoteGoTo) actualE).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualE).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualE.getType());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualE.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  void testGetE14() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionResetForm());

    // Act
    PDAction actualE = pdAnnotationAdditionalActions.getE();

    // Assert
    assertTrue(actualE instanceof PDActionResetForm);
    assertNull(actualE.getNext());
    assertNull(((PDActionResetForm) actualE).getFields());
    COSDictionary cOSObject = actualE.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((PDActionResetForm) actualE).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualE.getType());
    assertEquals(PDActionResetForm.SUB_TYPE, actualE.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  void testGetE15() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionSound());

    // Act
    PDAction actualE = pdAnnotationAdditionalActions.getE();

    // Assert
    assertTrue(actualE instanceof PDActionSound);
    assertNull(actualE.getNext());
    COSDictionary cOSObject = actualE.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSound) actualE).getSound());
    assertEquals(1.0f, ((PDActionSound) actualE).getVolume());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDActionSound) actualE).getMix());
    assertFalse(((PDActionSound) actualE).getRepeat());
    assertFalse(((PDActionSound) actualE).getSynchronous());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualE.getType());
    assertEquals(PDActionSound.SUB_TYPE, actualE.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  void testGetE16() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionSubmitForm());

    // Act
    PDAction actualE = pdAnnotationAdditionalActions.getE();

    // Assert
    assertTrue(actualE instanceof PDActionSubmitForm);
    assertNull(actualE.getNext());
    assertNull(((PDActionSubmitForm) actualE).getFields());
    COSDictionary cOSObject = actualE.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSubmitForm) actualE).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualE).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualE.getType());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualE.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  void testGetE17() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionThread());

    // Act
    PDAction actualE = pdAnnotationAdditionalActions.getE();

    // Assert
    assertTrue(actualE instanceof PDActionThread);
    assertNull(actualE.getNext());
    assertNull(((PDActionThread) actualE).getB());
    assertNull(((PDActionThread) actualE).getD());
    COSDictionary cOSObject = actualE.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionThread) actualE).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualE.getType());
    assertEquals(PDActionThread.SUB_TYPE, actualE.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  void testGetE18() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionURI());

    // Act
    PDAction actualE = pdAnnotationAdditionalActions.getE();

    // Assert
    assertTrue(actualE instanceof PDActionURI);
    assertNull(((PDActionURI) actualE).getURI());
    assertNull(actualE.getNext());
    COSDictionary cOSObject = actualE.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualE.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualE.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#setE(PDAction)}
   */
  @Test
  void testSetE() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();

    // Act
    pdAnnotationAdditionalActions.setE(new PDActionEmbeddedGoTo());

    // Assert
    PDAction e = pdAnnotationAdditionalActions.getE();
    assertTrue(e instanceof PDActionEmbeddedGoTo);
    assertNull(e.getNext());
    assertNull(((PDActionEmbeddedGoTo) e).getFile());
    assertNull(((PDActionEmbeddedGoTo) e).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) e).getDestination());
    COSDictionary cOSObject = pdAnnotationAdditionalActions.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) e).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, e.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, e.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  void testGetX() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationAdditionalActions()).getX());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  void testGetX2() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualX = pdAnnotationAdditionalActions.getX();

    // Assert
    assertTrue(actualX instanceof PDActionEmbeddedGoTo);
    assertNull(actualX.getNext());
    COSDictionary cOSObject = actualX.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionEmbeddedGoTo) actualX).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualX).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualX).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualX).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualX.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualX.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  void testGetX3() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getX());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  void testGetX4() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(new PDActionGoTo());

    // Act
    PDAction actualX = pdAnnotationAdditionalActions.getX();

    // Assert
    assertTrue(actualX instanceof PDActionGoTo);
    assertNull(actualX.getNext());
    COSDictionary cOSObject = actualX.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualX).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualX.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualX.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  void testGetX5() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(new PDActionHide());

    // Act
    PDAction actualX = pdAnnotationAdditionalActions.getX();

    // Assert
    assertTrue(actualX instanceof PDActionHide);
    assertNull(actualX.getNext());
    assertNull(((PDActionHide) actualX).getT());
    COSDictionary cOSObject = actualX.getCOSObject();
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
    assertTrue(((PDActionHide) actualX).getH());
    assertEquals(PDAction.TYPE, actualX.getType());
    assertEquals(PDActionHide.SUB_TYPE, actualX.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  void testGetX6() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(new PDActionImportData());

    // Act
    PDAction actualX = pdAnnotationAdditionalActions.getX();

    // Assert
    assertTrue(actualX instanceof PDActionImportData);
    assertNull(actualX.getNext());
    COSDictionary cOSObject = actualX.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualX).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualX.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualX.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  void testGetX7() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(new PDActionJavaScript());

    // Act
    PDAction actualX = pdAnnotationAdditionalActions.getX();

    // Assert
    assertTrue(actualX instanceof PDActionJavaScript);
    assertNull(((PDActionJavaScript) actualX).getAction());
    assertNull(actualX.getNext());
    COSDictionary cOSObject = actualX.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualX.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualX.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  void testGetX8() {
    // Arrange
    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));
    PDActionEmbeddedGoTo x = new PDActionEmbeddedGoTo(a);

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(x);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getX());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  void testGetX9() {
    // Arrange
    PDActionEmbeddedGoTo x = new PDActionEmbeddedGoTo(new COSDictionary());
    x.setSubType("foo");

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(x);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getX());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  void testGetX10() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(new PDActionLaunch());

    // Act
    PDAction actualX = pdAnnotationAdditionalActions.getX();

    // Assert
    assertTrue(actualX instanceof PDActionLaunch);
    assertNull(((PDActionLaunch) actualX).getD());
    assertNull(((PDActionLaunch) actualX).getF());
    assertNull(((PDActionLaunch) actualX).getO());
    assertNull(((PDActionLaunch) actualX).getP());
    assertNull(actualX.getNext());
    COSDictionary cOSObject = actualX.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionLaunch) actualX).getFile());
    assertNull(((PDActionLaunch) actualX).getWinLaunchParams());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualX).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualX.getType());
    assertEquals(PDActionLaunch.SUB_TYPE, actualX.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  void testGetX11() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(new PDActionMovie());

    // Act
    PDAction actualX = pdAnnotationAdditionalActions.getX();

    // Assert
    assertTrue(actualX instanceof PDActionMovie);
    assertNull(actualX.getNext());
    COSDictionary cOSObject = actualX.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualX.getType());
    assertEquals(PDActionMovie.SUB_TYPE, actualX.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  void testGetX12() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(new PDActionNamed());

    // Act
    PDAction actualX = pdAnnotationAdditionalActions.getX();

    // Assert
    assertTrue(actualX instanceof PDActionNamed);
    assertNull(((PDActionNamed) actualX).getN());
    assertNull(actualX.getNext());
    COSDictionary cOSObject = actualX.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualX.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualX.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  void testGetX13() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(new PDActionRemoteGoTo());

    // Act
    PDAction actualX = pdAnnotationAdditionalActions.getX();

    // Assert
    assertTrue(actualX instanceof PDActionRemoteGoTo);
    assertNull(actualX.getNext());
    assertNull(((PDActionRemoteGoTo) actualX).getD());
    COSDictionary cOSObject = actualX.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionRemoteGoTo) actualX).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualX).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualX.getType());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualX.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  void testGetX14() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(new PDActionResetForm());

    // Act
    PDAction actualX = pdAnnotationAdditionalActions.getX();

    // Assert
    assertTrue(actualX instanceof PDActionResetForm);
    assertNull(actualX.getNext());
    assertNull(((PDActionResetForm) actualX).getFields());
    COSDictionary cOSObject = actualX.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((PDActionResetForm) actualX).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualX.getType());
    assertEquals(PDActionResetForm.SUB_TYPE, actualX.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  void testGetX15() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(new PDActionSound());

    // Act
    PDAction actualX = pdAnnotationAdditionalActions.getX();

    // Assert
    assertTrue(actualX instanceof PDActionSound);
    assertNull(actualX.getNext());
    COSDictionary cOSObject = actualX.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSound) actualX).getSound());
    assertEquals(1.0f, ((PDActionSound) actualX).getVolume());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDActionSound) actualX).getMix());
    assertFalse(((PDActionSound) actualX).getRepeat());
    assertFalse(((PDActionSound) actualX).getSynchronous());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualX.getType());
    assertEquals(PDActionSound.SUB_TYPE, actualX.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  void testGetX16() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(new PDActionSubmitForm());

    // Act
    PDAction actualX = pdAnnotationAdditionalActions.getX();

    // Assert
    assertTrue(actualX instanceof PDActionSubmitForm);
    assertNull(actualX.getNext());
    assertNull(((PDActionSubmitForm) actualX).getFields());
    COSDictionary cOSObject = actualX.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSubmitForm) actualX).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualX).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualX.getType());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualX.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  void testGetX17() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(new PDActionThread());

    // Act
    PDAction actualX = pdAnnotationAdditionalActions.getX();

    // Assert
    assertTrue(actualX instanceof PDActionThread);
    assertNull(actualX.getNext());
    assertNull(((PDActionThread) actualX).getB());
    assertNull(((PDActionThread) actualX).getD());
    COSDictionary cOSObject = actualX.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionThread) actualX).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualX.getType());
    assertEquals(PDActionThread.SUB_TYPE, actualX.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  void testGetX18() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(new PDActionURI());

    // Act
    PDAction actualX = pdAnnotationAdditionalActions.getX();

    // Assert
    assertTrue(actualX instanceof PDActionURI);
    assertNull(((PDActionURI) actualX).getURI());
    assertNull(actualX.getNext());
    COSDictionary cOSObject = actualX.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualX.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualX.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#setX(PDAction)}
   */
  @Test
  void testSetX() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();

    // Act
    pdAnnotationAdditionalActions.setX(new PDActionEmbeddedGoTo());

    // Assert
    PDAction x = pdAnnotationAdditionalActions.getX();
    assertTrue(x instanceof PDActionEmbeddedGoTo);
    assertNull(x.getNext());
    assertNull(((PDActionEmbeddedGoTo) x).getFile());
    assertNull(((PDActionEmbeddedGoTo) x).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) x).getDestination());
    COSDictionary cOSObject = pdAnnotationAdditionalActions.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) x).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, x.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, x.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  void testGetD() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationAdditionalActions()).getD());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  void testGetD2() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualD = pdAnnotationAdditionalActions.getD();

    // Assert
    assertTrue(actualD instanceof PDActionEmbeddedGoTo);
    assertNull(actualD.getNext());
    COSDictionary cOSObject = actualD.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionEmbeddedGoTo) actualD).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualD).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualD).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualD).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualD.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualD.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  void testGetD3() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getD());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  void testGetD4() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(new PDActionGoTo());

    // Act
    PDAction actualD = pdAnnotationAdditionalActions.getD();

    // Assert
    assertTrue(actualD instanceof PDActionGoTo);
    assertNull(actualD.getNext());
    COSDictionary cOSObject = actualD.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualD).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualD.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualD.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  void testGetD5() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(new PDActionHide());

    // Act
    PDAction actualD = pdAnnotationAdditionalActions.getD();

    // Assert
    assertTrue(actualD instanceof PDActionHide);
    assertNull(actualD.getNext());
    assertNull(((PDActionHide) actualD).getT());
    COSDictionary cOSObject = actualD.getCOSObject();
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
    assertTrue(((PDActionHide) actualD).getH());
    assertEquals(PDAction.TYPE, actualD.getType());
    assertEquals(PDActionHide.SUB_TYPE, actualD.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  void testGetD6() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(new PDActionImportData());

    // Act
    PDAction actualD = pdAnnotationAdditionalActions.getD();

    // Assert
    assertTrue(actualD instanceof PDActionImportData);
    assertNull(actualD.getNext());
    COSDictionary cOSObject = actualD.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualD).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualD.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualD.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  void testGetD7() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(new PDActionJavaScript());

    // Act
    PDAction actualD = pdAnnotationAdditionalActions.getD();

    // Assert
    assertTrue(actualD instanceof PDActionJavaScript);
    assertNull(((PDActionJavaScript) actualD).getAction());
    assertNull(actualD.getNext());
    COSDictionary cOSObject = actualD.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualD.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualD.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  void testGetD8() {
    // Arrange
    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));
    PDActionEmbeddedGoTo d = new PDActionEmbeddedGoTo(a);

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(d);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getD());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  void testGetD9() {
    // Arrange
    PDActionEmbeddedGoTo d = new PDActionEmbeddedGoTo(new COSDictionary());
    d.setSubType("foo");

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(d);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getD());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  void testGetD10() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(new PDActionLaunch());

    // Act
    PDAction actualD = pdAnnotationAdditionalActions.getD();

    // Assert
    assertTrue(actualD instanceof PDActionLaunch);
    assertNull(((PDActionLaunch) actualD).getD());
    assertNull(((PDActionLaunch) actualD).getF());
    assertNull(((PDActionLaunch) actualD).getO());
    assertNull(((PDActionLaunch) actualD).getP());
    assertNull(actualD.getNext());
    COSDictionary cOSObject = actualD.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionLaunch) actualD).getFile());
    assertNull(((PDActionLaunch) actualD).getWinLaunchParams());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualD).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualD.getType());
    assertEquals(PDActionLaunch.SUB_TYPE, actualD.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  void testGetD11() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(new PDActionMovie());

    // Act
    PDAction actualD = pdAnnotationAdditionalActions.getD();

    // Assert
    assertTrue(actualD instanceof PDActionMovie);
    assertNull(actualD.getNext());
    COSDictionary cOSObject = actualD.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualD.getType());
    assertEquals(PDActionMovie.SUB_TYPE, actualD.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  void testGetD12() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(new PDActionNamed());

    // Act
    PDAction actualD = pdAnnotationAdditionalActions.getD();

    // Assert
    assertTrue(actualD instanceof PDActionNamed);
    assertNull(((PDActionNamed) actualD).getN());
    assertNull(actualD.getNext());
    COSDictionary cOSObject = actualD.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualD.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualD.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  void testGetD13() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(new PDActionRemoteGoTo());

    // Act
    PDAction actualD = pdAnnotationAdditionalActions.getD();

    // Assert
    assertTrue(actualD instanceof PDActionRemoteGoTo);
    assertNull(actualD.getNext());
    assertNull(((PDActionRemoteGoTo) actualD).getD());
    COSDictionary cOSObject = actualD.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionRemoteGoTo) actualD).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualD).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualD.getType());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualD.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  void testGetD14() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(new PDActionResetForm());

    // Act
    PDAction actualD = pdAnnotationAdditionalActions.getD();

    // Assert
    assertTrue(actualD instanceof PDActionResetForm);
    assertNull(actualD.getNext());
    assertNull(((PDActionResetForm) actualD).getFields());
    COSDictionary cOSObject = actualD.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((PDActionResetForm) actualD).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualD.getType());
    assertEquals(PDActionResetForm.SUB_TYPE, actualD.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  void testGetD15() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(new PDActionSound());

    // Act
    PDAction actualD = pdAnnotationAdditionalActions.getD();

    // Assert
    assertTrue(actualD instanceof PDActionSound);
    assertNull(actualD.getNext());
    COSDictionary cOSObject = actualD.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSound) actualD).getSound());
    assertEquals(1.0f, ((PDActionSound) actualD).getVolume());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDActionSound) actualD).getMix());
    assertFalse(((PDActionSound) actualD).getRepeat());
    assertFalse(((PDActionSound) actualD).getSynchronous());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualD.getType());
    assertEquals(PDActionSound.SUB_TYPE, actualD.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  void testGetD16() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(new PDActionSubmitForm());

    // Act
    PDAction actualD = pdAnnotationAdditionalActions.getD();

    // Assert
    assertTrue(actualD instanceof PDActionSubmitForm);
    assertNull(actualD.getNext());
    assertNull(((PDActionSubmitForm) actualD).getFields());
    COSDictionary cOSObject = actualD.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSubmitForm) actualD).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualD).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualD.getType());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualD.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  void testGetD17() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(new PDActionThread());

    // Act
    PDAction actualD = pdAnnotationAdditionalActions.getD();

    // Assert
    assertTrue(actualD instanceof PDActionThread);
    assertNull(actualD.getNext());
    assertNull(((PDActionThread) actualD).getB());
    assertNull(((PDActionThread) actualD).getD());
    COSDictionary cOSObject = actualD.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionThread) actualD).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualD.getType());
    assertEquals(PDActionThread.SUB_TYPE, actualD.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  void testGetD18() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(new PDActionURI());

    // Act
    PDAction actualD = pdAnnotationAdditionalActions.getD();

    // Assert
    assertTrue(actualD instanceof PDActionURI);
    assertNull(((PDActionURI) actualD).getURI());
    assertNull(actualD.getNext());
    COSDictionary cOSObject = actualD.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualD.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualD.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#setD(PDAction)}
   */
  @Test
  void testSetD() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();

    // Act
    pdAnnotationAdditionalActions.setD(new PDActionEmbeddedGoTo());

    // Assert
    PDAction d = pdAnnotationAdditionalActions.getD();
    assertTrue(d instanceof PDActionEmbeddedGoTo);
    assertNull(d.getNext());
    assertNull(((PDActionEmbeddedGoTo) d).getFile());
    assertNull(((PDActionEmbeddedGoTo) d).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) d).getDestination());
    COSDictionary cOSObject = pdAnnotationAdditionalActions.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) d).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, d.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, d.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  void testGetU() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationAdditionalActions()).getU());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  void testGetU2() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualU = pdAnnotationAdditionalActions.getU();

    // Assert
    assertTrue(actualU instanceof PDActionEmbeddedGoTo);
    assertNull(actualU.getNext());
    COSDictionary cOSObject = actualU.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionEmbeddedGoTo) actualU).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualU).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualU).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualU).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualU.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualU.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  void testGetU3() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getU());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  void testGetU4() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(new PDActionGoTo());

    // Act
    PDAction actualU = pdAnnotationAdditionalActions.getU();

    // Assert
    assertTrue(actualU instanceof PDActionGoTo);
    assertNull(actualU.getNext());
    COSDictionary cOSObject = actualU.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualU).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualU.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualU.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  void testGetU5() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(new PDActionHide());

    // Act
    PDAction actualU = pdAnnotationAdditionalActions.getU();

    // Assert
    assertTrue(actualU instanceof PDActionHide);
    assertNull(actualU.getNext());
    assertNull(((PDActionHide) actualU).getT());
    COSDictionary cOSObject = actualU.getCOSObject();
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
    assertTrue(((PDActionHide) actualU).getH());
    assertEquals(PDAction.TYPE, actualU.getType());
    assertEquals(PDActionHide.SUB_TYPE, actualU.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  void testGetU6() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(new PDActionImportData());

    // Act
    PDAction actualU = pdAnnotationAdditionalActions.getU();

    // Assert
    assertTrue(actualU instanceof PDActionImportData);
    assertNull(actualU.getNext());
    COSDictionary cOSObject = actualU.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualU).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualU.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualU.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  void testGetU7() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(new PDActionJavaScript());

    // Act
    PDAction actualU = pdAnnotationAdditionalActions.getU();

    // Assert
    assertTrue(actualU instanceof PDActionJavaScript);
    assertNull(((PDActionJavaScript) actualU).getAction());
    assertNull(actualU.getNext());
    COSDictionary cOSObject = actualU.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualU.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualU.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  void testGetU8() {
    // Arrange
    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));
    PDActionEmbeddedGoTo u = new PDActionEmbeddedGoTo(a);

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(u);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getU());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  void testGetU9() {
    // Arrange
    PDActionEmbeddedGoTo u = new PDActionEmbeddedGoTo(new COSDictionary());
    u.setSubType("foo");

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(u);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getU());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  void testGetU10() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(new PDActionLaunch());

    // Act
    PDAction actualU = pdAnnotationAdditionalActions.getU();

    // Assert
    assertTrue(actualU instanceof PDActionLaunch);
    assertNull(((PDActionLaunch) actualU).getD());
    assertNull(((PDActionLaunch) actualU).getF());
    assertNull(((PDActionLaunch) actualU).getO());
    assertNull(((PDActionLaunch) actualU).getP());
    assertNull(actualU.getNext());
    COSDictionary cOSObject = actualU.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionLaunch) actualU).getFile());
    assertNull(((PDActionLaunch) actualU).getWinLaunchParams());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualU).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualU.getType());
    assertEquals(PDActionLaunch.SUB_TYPE, actualU.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  void testGetU11() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(new PDActionMovie());

    // Act
    PDAction actualU = pdAnnotationAdditionalActions.getU();

    // Assert
    assertTrue(actualU instanceof PDActionMovie);
    assertNull(actualU.getNext());
    COSDictionary cOSObject = actualU.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualU.getType());
    assertEquals(PDActionMovie.SUB_TYPE, actualU.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  void testGetU12() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(new PDActionNamed());

    // Act
    PDAction actualU = pdAnnotationAdditionalActions.getU();

    // Assert
    assertTrue(actualU instanceof PDActionNamed);
    assertNull(((PDActionNamed) actualU).getN());
    assertNull(actualU.getNext());
    COSDictionary cOSObject = actualU.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualU.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualU.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  void testGetU13() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(new PDActionRemoteGoTo());

    // Act
    PDAction actualU = pdAnnotationAdditionalActions.getU();

    // Assert
    assertTrue(actualU instanceof PDActionRemoteGoTo);
    assertNull(actualU.getNext());
    assertNull(((PDActionRemoteGoTo) actualU).getD());
    COSDictionary cOSObject = actualU.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionRemoteGoTo) actualU).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualU).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualU.getType());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualU.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  void testGetU14() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(new PDActionResetForm());

    // Act
    PDAction actualU = pdAnnotationAdditionalActions.getU();

    // Assert
    assertTrue(actualU instanceof PDActionResetForm);
    assertNull(actualU.getNext());
    assertNull(((PDActionResetForm) actualU).getFields());
    COSDictionary cOSObject = actualU.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((PDActionResetForm) actualU).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualU.getType());
    assertEquals(PDActionResetForm.SUB_TYPE, actualU.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  void testGetU15() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(new PDActionSound());

    // Act
    PDAction actualU = pdAnnotationAdditionalActions.getU();

    // Assert
    assertTrue(actualU instanceof PDActionSound);
    assertNull(actualU.getNext());
    COSDictionary cOSObject = actualU.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSound) actualU).getSound());
    assertEquals(1.0f, ((PDActionSound) actualU).getVolume());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDActionSound) actualU).getMix());
    assertFalse(((PDActionSound) actualU).getRepeat());
    assertFalse(((PDActionSound) actualU).getSynchronous());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualU.getType());
    assertEquals(PDActionSound.SUB_TYPE, actualU.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  void testGetU16() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(new PDActionSubmitForm());

    // Act
    PDAction actualU = pdAnnotationAdditionalActions.getU();

    // Assert
    assertTrue(actualU instanceof PDActionSubmitForm);
    assertNull(actualU.getNext());
    assertNull(((PDActionSubmitForm) actualU).getFields());
    COSDictionary cOSObject = actualU.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSubmitForm) actualU).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualU).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualU.getType());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualU.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  void testGetU17() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(new PDActionThread());

    // Act
    PDAction actualU = pdAnnotationAdditionalActions.getU();

    // Assert
    assertTrue(actualU instanceof PDActionThread);
    assertNull(actualU.getNext());
    assertNull(((PDActionThread) actualU).getB());
    assertNull(((PDActionThread) actualU).getD());
    COSDictionary cOSObject = actualU.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionThread) actualU).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualU.getType());
    assertEquals(PDActionThread.SUB_TYPE, actualU.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  void testGetU18() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(new PDActionURI());

    // Act
    PDAction actualU = pdAnnotationAdditionalActions.getU();

    // Assert
    assertTrue(actualU instanceof PDActionURI);
    assertNull(((PDActionURI) actualU).getURI());
    assertNull(actualU.getNext());
    COSDictionary cOSObject = actualU.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualU.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualU.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#setU(PDAction)}
   */
  @Test
  void testSetU() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();

    // Act
    pdAnnotationAdditionalActions.setU(new PDActionEmbeddedGoTo());

    // Assert
    PDAction u = pdAnnotationAdditionalActions.getU();
    assertTrue(u instanceof PDActionEmbeddedGoTo);
    assertNull(u.getNext());
    assertNull(((PDActionEmbeddedGoTo) u).getFile());
    assertNull(((PDActionEmbeddedGoTo) u).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) u).getDestination());
    COSDictionary cOSObject = pdAnnotationAdditionalActions.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) u).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, u.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, u.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  void testGetFo() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationAdditionalActions()).getFo());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  void testGetFo2() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualFo = pdAnnotationAdditionalActions.getFo();

    // Assert
    assertTrue(actualFo instanceof PDActionEmbeddedGoTo);
    assertNull(actualFo.getNext());
    COSDictionary cOSObject = actualFo.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionEmbeddedGoTo) actualFo).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualFo).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualFo).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualFo).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualFo.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualFo.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  void testGetFo3() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getFo());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  void testGetFo4() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(new PDActionGoTo());

    // Act
    PDAction actualFo = pdAnnotationAdditionalActions.getFo();

    // Assert
    assertTrue(actualFo instanceof PDActionGoTo);
    assertNull(actualFo.getNext());
    COSDictionary cOSObject = actualFo.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualFo).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualFo.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualFo.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  void testGetFo5() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(new PDActionHide());

    // Act
    PDAction actualFo = pdAnnotationAdditionalActions.getFo();

    // Assert
    assertTrue(actualFo instanceof PDActionHide);
    assertNull(actualFo.getNext());
    assertNull(((PDActionHide) actualFo).getT());
    COSDictionary cOSObject = actualFo.getCOSObject();
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
    assertTrue(((PDActionHide) actualFo).getH());
    assertEquals(PDAction.TYPE, actualFo.getType());
    assertEquals(PDActionHide.SUB_TYPE, actualFo.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  void testGetFo6() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(new PDActionImportData());

    // Act
    PDAction actualFo = pdAnnotationAdditionalActions.getFo();

    // Assert
    assertTrue(actualFo instanceof PDActionImportData);
    assertNull(actualFo.getNext());
    COSDictionary cOSObject = actualFo.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualFo).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualFo.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualFo.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  void testGetFo7() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(new PDActionJavaScript());

    // Act
    PDAction actualFo = pdAnnotationAdditionalActions.getFo();

    // Assert
    assertTrue(actualFo instanceof PDActionJavaScript);
    assertNull(((PDActionJavaScript) actualFo).getAction());
    assertNull(actualFo.getNext());
    COSDictionary cOSObject = actualFo.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualFo.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualFo.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  void testGetFo8() {
    // Arrange
    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));
    PDActionEmbeddedGoTo fo = new PDActionEmbeddedGoTo(a);

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(fo);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getFo());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  void testGetFo9() {
    // Arrange
    PDActionEmbeddedGoTo fo = new PDActionEmbeddedGoTo(new COSDictionary());
    fo.setSubType("foo");

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(fo);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getFo());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  void testGetFo10() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(new PDActionLaunch());

    // Act
    PDAction actualFo = pdAnnotationAdditionalActions.getFo();

    // Assert
    assertTrue(actualFo instanceof PDActionLaunch);
    assertNull(((PDActionLaunch) actualFo).getD());
    assertNull(((PDActionLaunch) actualFo).getF());
    assertNull(((PDActionLaunch) actualFo).getO());
    assertNull(((PDActionLaunch) actualFo).getP());
    assertNull(actualFo.getNext());
    COSDictionary cOSObject = actualFo.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionLaunch) actualFo).getFile());
    assertNull(((PDActionLaunch) actualFo).getWinLaunchParams());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualFo).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualFo.getType());
    assertEquals(PDActionLaunch.SUB_TYPE, actualFo.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  void testGetFo11() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(new PDActionMovie());

    // Act
    PDAction actualFo = pdAnnotationAdditionalActions.getFo();

    // Assert
    assertTrue(actualFo instanceof PDActionMovie);
    assertNull(actualFo.getNext());
    COSDictionary cOSObject = actualFo.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualFo.getType());
    assertEquals(PDActionMovie.SUB_TYPE, actualFo.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  void testGetFo12() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(new PDActionNamed());

    // Act
    PDAction actualFo = pdAnnotationAdditionalActions.getFo();

    // Assert
    assertTrue(actualFo instanceof PDActionNamed);
    assertNull(((PDActionNamed) actualFo).getN());
    assertNull(actualFo.getNext());
    COSDictionary cOSObject = actualFo.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualFo.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualFo.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  void testGetFo13() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(new PDActionRemoteGoTo());

    // Act
    PDAction actualFo = pdAnnotationAdditionalActions.getFo();

    // Assert
    assertTrue(actualFo instanceof PDActionRemoteGoTo);
    assertNull(actualFo.getNext());
    assertNull(((PDActionRemoteGoTo) actualFo).getD());
    COSDictionary cOSObject = actualFo.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionRemoteGoTo) actualFo).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualFo).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualFo.getType());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualFo.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  void testGetFo14() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(new PDActionResetForm());

    // Act
    PDAction actualFo = pdAnnotationAdditionalActions.getFo();

    // Assert
    assertTrue(actualFo instanceof PDActionResetForm);
    assertNull(actualFo.getNext());
    assertNull(((PDActionResetForm) actualFo).getFields());
    COSDictionary cOSObject = actualFo.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((PDActionResetForm) actualFo).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualFo.getType());
    assertEquals(PDActionResetForm.SUB_TYPE, actualFo.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  void testGetFo15() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(new PDActionSound());

    // Act
    PDAction actualFo = pdAnnotationAdditionalActions.getFo();

    // Assert
    assertTrue(actualFo instanceof PDActionSound);
    assertNull(actualFo.getNext());
    COSDictionary cOSObject = actualFo.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSound) actualFo).getSound());
    assertEquals(1.0f, ((PDActionSound) actualFo).getVolume());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDActionSound) actualFo).getMix());
    assertFalse(((PDActionSound) actualFo).getRepeat());
    assertFalse(((PDActionSound) actualFo).getSynchronous());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualFo.getType());
    assertEquals(PDActionSound.SUB_TYPE, actualFo.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  void testGetFo16() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(new PDActionSubmitForm());

    // Act
    PDAction actualFo = pdAnnotationAdditionalActions.getFo();

    // Assert
    assertTrue(actualFo instanceof PDActionSubmitForm);
    assertNull(actualFo.getNext());
    assertNull(((PDActionSubmitForm) actualFo).getFields());
    COSDictionary cOSObject = actualFo.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSubmitForm) actualFo).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualFo).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualFo.getType());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualFo.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  void testGetFo17() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(new PDActionThread());

    // Act
    PDAction actualFo = pdAnnotationAdditionalActions.getFo();

    // Assert
    assertTrue(actualFo instanceof PDActionThread);
    assertNull(actualFo.getNext());
    assertNull(((PDActionThread) actualFo).getB());
    assertNull(((PDActionThread) actualFo).getD());
    COSDictionary cOSObject = actualFo.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionThread) actualFo).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualFo.getType());
    assertEquals(PDActionThread.SUB_TYPE, actualFo.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  void testGetFo18() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(new PDActionURI());

    // Act
    PDAction actualFo = pdAnnotationAdditionalActions.getFo();

    // Assert
    assertTrue(actualFo instanceof PDActionURI);
    assertNull(((PDActionURI) actualFo).getURI());
    assertNull(actualFo.getNext());
    COSDictionary cOSObject = actualFo.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualFo.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualFo.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#setFo(PDAction)}
   */
  @Test
  void testSetFo() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();

    // Act
    pdAnnotationAdditionalActions.setFo(new PDActionEmbeddedGoTo());

    // Assert
    PDAction fo = pdAnnotationAdditionalActions.getFo();
    assertTrue(fo instanceof PDActionEmbeddedGoTo);
    assertNull(fo.getNext());
    assertNull(((PDActionEmbeddedGoTo) fo).getFile());
    assertNull(((PDActionEmbeddedGoTo) fo).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) fo).getDestination());
    COSDictionary cOSObject = pdAnnotationAdditionalActions.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) fo).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, fo.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, fo.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  void testGetBl() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationAdditionalActions()).getBl());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  void testGetBl2() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualBl = pdAnnotationAdditionalActions.getBl();

    // Assert
    assertTrue(actualBl instanceof PDActionEmbeddedGoTo);
    assertNull(actualBl.getNext());
    COSDictionary cOSObject = actualBl.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionEmbeddedGoTo) actualBl).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualBl).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualBl).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualBl).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualBl.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualBl.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  void testGetBl3() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getBl());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  void testGetBl4() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(new PDActionGoTo());

    // Act
    PDAction actualBl = pdAnnotationAdditionalActions.getBl();

    // Assert
    assertTrue(actualBl instanceof PDActionGoTo);
    assertNull(actualBl.getNext());
    COSDictionary cOSObject = actualBl.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualBl).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualBl.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualBl.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  void testGetBl5() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(new PDActionHide());

    // Act
    PDAction actualBl = pdAnnotationAdditionalActions.getBl();

    // Assert
    assertTrue(actualBl instanceof PDActionHide);
    assertNull(actualBl.getNext());
    assertNull(((PDActionHide) actualBl).getT());
    COSDictionary cOSObject = actualBl.getCOSObject();
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
    assertTrue(((PDActionHide) actualBl).getH());
    assertEquals(PDAction.TYPE, actualBl.getType());
    assertEquals(PDActionHide.SUB_TYPE, actualBl.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  void testGetBl6() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(new PDActionImportData());

    // Act
    PDAction actualBl = pdAnnotationAdditionalActions.getBl();

    // Assert
    assertTrue(actualBl instanceof PDActionImportData);
    assertNull(actualBl.getNext());
    COSDictionary cOSObject = actualBl.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualBl).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualBl.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualBl.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  void testGetBl7() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(new PDActionJavaScript());

    // Act
    PDAction actualBl = pdAnnotationAdditionalActions.getBl();

    // Assert
    assertTrue(actualBl instanceof PDActionJavaScript);
    assertNull(((PDActionJavaScript) actualBl).getAction());
    assertNull(actualBl.getNext());
    COSDictionary cOSObject = actualBl.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualBl.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualBl.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  void testGetBl8() {
    // Arrange
    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));
    PDActionEmbeddedGoTo bl = new PDActionEmbeddedGoTo(a);

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(bl);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getBl());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  void testGetBl9() {
    // Arrange
    PDActionEmbeddedGoTo bl = new PDActionEmbeddedGoTo(new COSDictionary());
    bl.setSubType("foo");

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(bl);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getBl());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  void testGetBl10() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(new PDActionLaunch());

    // Act
    PDAction actualBl = pdAnnotationAdditionalActions.getBl();

    // Assert
    assertTrue(actualBl instanceof PDActionLaunch);
    assertNull(((PDActionLaunch) actualBl).getD());
    assertNull(((PDActionLaunch) actualBl).getF());
    assertNull(((PDActionLaunch) actualBl).getO());
    assertNull(((PDActionLaunch) actualBl).getP());
    assertNull(actualBl.getNext());
    COSDictionary cOSObject = actualBl.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionLaunch) actualBl).getFile());
    assertNull(((PDActionLaunch) actualBl).getWinLaunchParams());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualBl).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualBl.getType());
    assertEquals(PDActionLaunch.SUB_TYPE, actualBl.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  void testGetBl11() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(new PDActionMovie());

    // Act
    PDAction actualBl = pdAnnotationAdditionalActions.getBl();

    // Assert
    assertTrue(actualBl instanceof PDActionMovie);
    assertNull(actualBl.getNext());
    COSDictionary cOSObject = actualBl.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualBl.getType());
    assertEquals(PDActionMovie.SUB_TYPE, actualBl.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  void testGetBl12() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(new PDActionNamed());

    // Act
    PDAction actualBl = pdAnnotationAdditionalActions.getBl();

    // Assert
    assertTrue(actualBl instanceof PDActionNamed);
    assertNull(((PDActionNamed) actualBl).getN());
    assertNull(actualBl.getNext());
    COSDictionary cOSObject = actualBl.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualBl.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualBl.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  void testGetBl13() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(new PDActionRemoteGoTo());

    // Act
    PDAction actualBl = pdAnnotationAdditionalActions.getBl();

    // Assert
    assertTrue(actualBl instanceof PDActionRemoteGoTo);
    assertNull(actualBl.getNext());
    assertNull(((PDActionRemoteGoTo) actualBl).getD());
    COSDictionary cOSObject = actualBl.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionRemoteGoTo) actualBl).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualBl).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualBl.getType());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualBl.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  void testGetBl14() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(new PDActionResetForm());

    // Act
    PDAction actualBl = pdAnnotationAdditionalActions.getBl();

    // Assert
    assertTrue(actualBl instanceof PDActionResetForm);
    assertNull(actualBl.getNext());
    assertNull(((PDActionResetForm) actualBl).getFields());
    COSDictionary cOSObject = actualBl.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((PDActionResetForm) actualBl).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualBl.getType());
    assertEquals(PDActionResetForm.SUB_TYPE, actualBl.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  void testGetBl15() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(new PDActionSound());

    // Act
    PDAction actualBl = pdAnnotationAdditionalActions.getBl();

    // Assert
    assertTrue(actualBl instanceof PDActionSound);
    assertNull(actualBl.getNext());
    COSDictionary cOSObject = actualBl.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSound) actualBl).getSound());
    assertEquals(1.0f, ((PDActionSound) actualBl).getVolume());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDActionSound) actualBl).getMix());
    assertFalse(((PDActionSound) actualBl).getRepeat());
    assertFalse(((PDActionSound) actualBl).getSynchronous());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualBl.getType());
    assertEquals(PDActionSound.SUB_TYPE, actualBl.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  void testGetBl16() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(new PDActionSubmitForm());

    // Act
    PDAction actualBl = pdAnnotationAdditionalActions.getBl();

    // Assert
    assertTrue(actualBl instanceof PDActionSubmitForm);
    assertNull(actualBl.getNext());
    assertNull(((PDActionSubmitForm) actualBl).getFields());
    COSDictionary cOSObject = actualBl.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSubmitForm) actualBl).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualBl).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualBl.getType());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualBl.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  void testGetBl17() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(new PDActionThread());

    // Act
    PDAction actualBl = pdAnnotationAdditionalActions.getBl();

    // Assert
    assertTrue(actualBl instanceof PDActionThread);
    assertNull(actualBl.getNext());
    assertNull(((PDActionThread) actualBl).getB());
    assertNull(((PDActionThread) actualBl).getD());
    COSDictionary cOSObject = actualBl.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionThread) actualBl).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualBl.getType());
    assertEquals(PDActionThread.SUB_TYPE, actualBl.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  void testGetBl18() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(new PDActionURI());

    // Act
    PDAction actualBl = pdAnnotationAdditionalActions.getBl();

    // Assert
    assertTrue(actualBl instanceof PDActionURI);
    assertNull(((PDActionURI) actualBl).getURI());
    assertNull(actualBl.getNext());
    COSDictionary cOSObject = actualBl.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualBl.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualBl.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#setBl(PDAction)}
   */
  @Test
  void testSetBl() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();

    // Act
    pdAnnotationAdditionalActions.setBl(new PDActionEmbeddedGoTo());

    // Assert
    PDAction bl = pdAnnotationAdditionalActions.getBl();
    assertTrue(bl instanceof PDActionEmbeddedGoTo);
    assertNull(bl.getNext());
    assertNull(((PDActionEmbeddedGoTo) bl).getFile());
    assertNull(((PDActionEmbeddedGoTo) bl).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) bl).getDestination());
    COSDictionary cOSObject = pdAnnotationAdditionalActions.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) bl).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, bl.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, bl.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  void testGetPO() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationAdditionalActions()).getPO());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  void testGetPO2() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualPO = pdAnnotationAdditionalActions.getPO();

    // Assert
    assertTrue(actualPO instanceof PDActionEmbeddedGoTo);
    assertNull(actualPO.getNext());
    COSDictionary cOSObject = actualPO.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionEmbeddedGoTo) actualPO).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualPO).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualPO).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualPO).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPO.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualPO.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  void testGetPO3() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getPO());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  void testGetPO4() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(new PDActionGoTo());

    // Act
    PDAction actualPO = pdAnnotationAdditionalActions.getPO();

    // Assert
    assertTrue(actualPO instanceof PDActionGoTo);
    assertNull(actualPO.getNext());
    COSDictionary cOSObject = actualPO.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualPO).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPO.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualPO.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  void testGetPO5() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(new PDActionHide());

    // Act
    PDAction actualPO = pdAnnotationAdditionalActions.getPO();

    // Assert
    assertTrue(actualPO instanceof PDActionHide);
    assertNull(actualPO.getNext());
    assertNull(((PDActionHide) actualPO).getT());
    COSDictionary cOSObject = actualPO.getCOSObject();
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
    assertTrue(((PDActionHide) actualPO).getH());
    assertEquals(PDAction.TYPE, actualPO.getType());
    assertEquals(PDActionHide.SUB_TYPE, actualPO.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  void testGetPO6() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(new PDActionImportData());

    // Act
    PDAction actualPO = pdAnnotationAdditionalActions.getPO();

    // Assert
    assertTrue(actualPO instanceof PDActionImportData);
    assertNull(actualPO.getNext());
    COSDictionary cOSObject = actualPO.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualPO).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPO.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualPO.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  void testGetPO7() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(new PDActionJavaScript());

    // Act
    PDAction actualPO = pdAnnotationAdditionalActions.getPO();

    // Assert
    assertTrue(actualPO instanceof PDActionJavaScript);
    assertNull(((PDActionJavaScript) actualPO).getAction());
    assertNull(actualPO.getNext());
    COSDictionary cOSObject = actualPO.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualPO.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualPO.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  void testGetPO8() {
    // Arrange
    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));
    PDActionEmbeddedGoTo po = new PDActionEmbeddedGoTo(a);

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(po);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getPO());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  void testGetPO9() {
    // Arrange
    PDActionEmbeddedGoTo po = new PDActionEmbeddedGoTo(new COSDictionary());
    po.setSubType("foo");

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(po);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getPO());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  void testGetPO10() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(new PDActionLaunch());

    // Act
    PDAction actualPO = pdAnnotationAdditionalActions.getPO();

    // Assert
    assertTrue(actualPO instanceof PDActionLaunch);
    assertNull(((PDActionLaunch) actualPO).getD());
    assertNull(((PDActionLaunch) actualPO).getF());
    assertNull(((PDActionLaunch) actualPO).getO());
    assertNull(((PDActionLaunch) actualPO).getP());
    assertNull(actualPO.getNext());
    COSDictionary cOSObject = actualPO.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionLaunch) actualPO).getFile());
    assertNull(((PDActionLaunch) actualPO).getWinLaunchParams());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualPO).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPO.getType());
    assertEquals(PDActionLaunch.SUB_TYPE, actualPO.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  void testGetPO11() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(new PDActionMovie());

    // Act
    PDAction actualPO = pdAnnotationAdditionalActions.getPO();

    // Assert
    assertTrue(actualPO instanceof PDActionMovie);
    assertNull(actualPO.getNext());
    COSDictionary cOSObject = actualPO.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualPO.getType());
    assertEquals(PDActionMovie.SUB_TYPE, actualPO.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  void testGetPO12() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(new PDActionNamed());

    // Act
    PDAction actualPO = pdAnnotationAdditionalActions.getPO();

    // Assert
    assertTrue(actualPO instanceof PDActionNamed);
    assertNull(((PDActionNamed) actualPO).getN());
    assertNull(actualPO.getNext());
    COSDictionary cOSObject = actualPO.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualPO.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualPO.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  void testGetPO13() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(new PDActionRemoteGoTo());

    // Act
    PDAction actualPO = pdAnnotationAdditionalActions.getPO();

    // Assert
    assertTrue(actualPO instanceof PDActionRemoteGoTo);
    assertNull(actualPO.getNext());
    assertNull(((PDActionRemoteGoTo) actualPO).getD());
    COSDictionary cOSObject = actualPO.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionRemoteGoTo) actualPO).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualPO).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPO.getType());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualPO.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  void testGetPO14() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(new PDActionResetForm());

    // Act
    PDAction actualPO = pdAnnotationAdditionalActions.getPO();

    // Assert
    assertTrue(actualPO instanceof PDActionResetForm);
    assertNull(actualPO.getNext());
    assertNull(((PDActionResetForm) actualPO).getFields());
    COSDictionary cOSObject = actualPO.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((PDActionResetForm) actualPO).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPO.getType());
    assertEquals(PDActionResetForm.SUB_TYPE, actualPO.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  void testGetPO15() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(new PDActionSound());

    // Act
    PDAction actualPO = pdAnnotationAdditionalActions.getPO();

    // Assert
    assertTrue(actualPO instanceof PDActionSound);
    assertNull(actualPO.getNext());
    COSDictionary cOSObject = actualPO.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSound) actualPO).getSound());
    assertEquals(1.0f, ((PDActionSound) actualPO).getVolume());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDActionSound) actualPO).getMix());
    assertFalse(((PDActionSound) actualPO).getRepeat());
    assertFalse(((PDActionSound) actualPO).getSynchronous());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPO.getType());
    assertEquals(PDActionSound.SUB_TYPE, actualPO.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  void testGetPO16() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(new PDActionSubmitForm());

    // Act
    PDAction actualPO = pdAnnotationAdditionalActions.getPO();

    // Assert
    assertTrue(actualPO instanceof PDActionSubmitForm);
    assertNull(actualPO.getNext());
    assertNull(((PDActionSubmitForm) actualPO).getFields());
    COSDictionary cOSObject = actualPO.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSubmitForm) actualPO).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualPO).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPO.getType());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualPO.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  void testGetPO17() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(new PDActionThread());

    // Act
    PDAction actualPO = pdAnnotationAdditionalActions.getPO();

    // Assert
    assertTrue(actualPO instanceof PDActionThread);
    assertNull(actualPO.getNext());
    assertNull(((PDActionThread) actualPO).getB());
    assertNull(((PDActionThread) actualPO).getD());
    COSDictionary cOSObject = actualPO.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionThread) actualPO).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPO.getType());
    assertEquals(PDActionThread.SUB_TYPE, actualPO.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  void testGetPO18() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(new PDActionURI());

    // Act
    PDAction actualPO = pdAnnotationAdditionalActions.getPO();

    // Assert
    assertTrue(actualPO instanceof PDActionURI);
    assertNull(((PDActionURI) actualPO).getURI());
    assertNull(actualPO.getNext());
    COSDictionary cOSObject = actualPO.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualPO.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualPO.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#setPO(PDAction)}
   */
  @Test
  void testSetPO() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();

    // Act
    pdAnnotationAdditionalActions.setPO(new PDActionEmbeddedGoTo());

    // Assert
    PDAction pO = pdAnnotationAdditionalActions.getPO();
    assertTrue(pO instanceof PDActionEmbeddedGoTo);
    assertNull(pO.getNext());
    assertNull(((PDActionEmbeddedGoTo) pO).getFile());
    assertNull(((PDActionEmbeddedGoTo) pO).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) pO).getDestination());
    COSDictionary cOSObject = pdAnnotationAdditionalActions.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) pO).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, pO.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, pO.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  void testGetPC() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationAdditionalActions()).getPC());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  void testGetPC2() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualPC = pdAnnotationAdditionalActions.getPC();

    // Assert
    assertTrue(actualPC instanceof PDActionEmbeddedGoTo);
    assertNull(actualPC.getNext());
    COSDictionary cOSObject = actualPC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionEmbeddedGoTo) actualPC).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualPC).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualPC).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualPC).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPC.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualPC.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  void testGetPC3() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getPC());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  void testGetPC4() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(new PDActionGoTo());

    // Act
    PDAction actualPC = pdAnnotationAdditionalActions.getPC();

    // Assert
    assertTrue(actualPC instanceof PDActionGoTo);
    assertNull(actualPC.getNext());
    COSDictionary cOSObject = actualPC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualPC).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPC.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualPC.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  void testGetPC5() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(new PDActionHide());

    // Act
    PDAction actualPC = pdAnnotationAdditionalActions.getPC();

    // Assert
    assertTrue(actualPC instanceof PDActionHide);
    assertNull(actualPC.getNext());
    assertNull(((PDActionHide) actualPC).getT());
    COSDictionary cOSObject = actualPC.getCOSObject();
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
    assertTrue(((PDActionHide) actualPC).getH());
    assertEquals(PDAction.TYPE, actualPC.getType());
    assertEquals(PDActionHide.SUB_TYPE, actualPC.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  void testGetPC6() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(new PDActionImportData());

    // Act
    PDAction actualPC = pdAnnotationAdditionalActions.getPC();

    // Assert
    assertTrue(actualPC instanceof PDActionImportData);
    assertNull(actualPC.getNext());
    COSDictionary cOSObject = actualPC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualPC).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPC.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualPC.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  void testGetPC7() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(new PDActionJavaScript());

    // Act
    PDAction actualPC = pdAnnotationAdditionalActions.getPC();

    // Assert
    assertTrue(actualPC instanceof PDActionJavaScript);
    assertNull(((PDActionJavaScript) actualPC).getAction());
    assertNull(actualPC.getNext());
    COSDictionary cOSObject = actualPC.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualPC.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualPC.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  void testGetPC8() {
    // Arrange
    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));
    PDActionEmbeddedGoTo pc = new PDActionEmbeddedGoTo(a);

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(pc);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getPC());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  void testGetPC9() {
    // Arrange
    PDActionEmbeddedGoTo pc = new PDActionEmbeddedGoTo(new COSDictionary());
    pc.setSubType("foo");

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(pc);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getPC());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  void testGetPC10() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(new PDActionLaunch());

    // Act
    PDAction actualPC = pdAnnotationAdditionalActions.getPC();

    // Assert
    assertTrue(actualPC instanceof PDActionLaunch);
    assertNull(((PDActionLaunch) actualPC).getD());
    assertNull(((PDActionLaunch) actualPC).getF());
    assertNull(((PDActionLaunch) actualPC).getO());
    assertNull(((PDActionLaunch) actualPC).getP());
    assertNull(actualPC.getNext());
    COSDictionary cOSObject = actualPC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionLaunch) actualPC).getFile());
    assertNull(((PDActionLaunch) actualPC).getWinLaunchParams());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualPC).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPC.getType());
    assertEquals(PDActionLaunch.SUB_TYPE, actualPC.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  void testGetPC11() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(new PDActionMovie());

    // Act
    PDAction actualPC = pdAnnotationAdditionalActions.getPC();

    // Assert
    assertTrue(actualPC instanceof PDActionMovie);
    assertNull(actualPC.getNext());
    COSDictionary cOSObject = actualPC.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualPC.getType());
    assertEquals(PDActionMovie.SUB_TYPE, actualPC.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  void testGetPC12() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(new PDActionNamed());

    // Act
    PDAction actualPC = pdAnnotationAdditionalActions.getPC();

    // Assert
    assertTrue(actualPC instanceof PDActionNamed);
    assertNull(((PDActionNamed) actualPC).getN());
    assertNull(actualPC.getNext());
    COSDictionary cOSObject = actualPC.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualPC.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualPC.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  void testGetPC13() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(new PDActionRemoteGoTo());

    // Act
    PDAction actualPC = pdAnnotationAdditionalActions.getPC();

    // Assert
    assertTrue(actualPC instanceof PDActionRemoteGoTo);
    assertNull(actualPC.getNext());
    assertNull(((PDActionRemoteGoTo) actualPC).getD());
    COSDictionary cOSObject = actualPC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionRemoteGoTo) actualPC).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualPC).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPC.getType());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualPC.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  void testGetPC14() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(new PDActionResetForm());

    // Act
    PDAction actualPC = pdAnnotationAdditionalActions.getPC();

    // Assert
    assertTrue(actualPC instanceof PDActionResetForm);
    assertNull(actualPC.getNext());
    assertNull(((PDActionResetForm) actualPC).getFields());
    COSDictionary cOSObject = actualPC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((PDActionResetForm) actualPC).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPC.getType());
    assertEquals(PDActionResetForm.SUB_TYPE, actualPC.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  void testGetPC15() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(new PDActionSound());

    // Act
    PDAction actualPC = pdAnnotationAdditionalActions.getPC();

    // Assert
    assertTrue(actualPC instanceof PDActionSound);
    assertNull(actualPC.getNext());
    COSDictionary cOSObject = actualPC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSound) actualPC).getSound());
    assertEquals(1.0f, ((PDActionSound) actualPC).getVolume());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDActionSound) actualPC).getMix());
    assertFalse(((PDActionSound) actualPC).getRepeat());
    assertFalse(((PDActionSound) actualPC).getSynchronous());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPC.getType());
    assertEquals(PDActionSound.SUB_TYPE, actualPC.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  void testGetPC16() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(new PDActionSubmitForm());

    // Act
    PDAction actualPC = pdAnnotationAdditionalActions.getPC();

    // Assert
    assertTrue(actualPC instanceof PDActionSubmitForm);
    assertNull(actualPC.getNext());
    assertNull(((PDActionSubmitForm) actualPC).getFields());
    COSDictionary cOSObject = actualPC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSubmitForm) actualPC).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualPC).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPC.getType());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualPC.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  void testGetPC17() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(new PDActionThread());

    // Act
    PDAction actualPC = pdAnnotationAdditionalActions.getPC();

    // Assert
    assertTrue(actualPC instanceof PDActionThread);
    assertNull(actualPC.getNext());
    assertNull(((PDActionThread) actualPC).getB());
    assertNull(((PDActionThread) actualPC).getD());
    COSDictionary cOSObject = actualPC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionThread) actualPC).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPC.getType());
    assertEquals(PDActionThread.SUB_TYPE, actualPC.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  void testGetPC18() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(new PDActionURI());

    // Act
    PDAction actualPC = pdAnnotationAdditionalActions.getPC();

    // Assert
    assertTrue(actualPC instanceof PDActionURI);
    assertNull(((PDActionURI) actualPC).getURI());
    assertNull(actualPC.getNext());
    COSDictionary cOSObject = actualPC.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualPC.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualPC.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#setPC(PDAction)}
   */
  @Test
  void testSetPC() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();

    // Act
    pdAnnotationAdditionalActions.setPC(new PDActionEmbeddedGoTo());

    // Assert
    PDAction pC = pdAnnotationAdditionalActions.getPC();
    assertTrue(pC instanceof PDActionEmbeddedGoTo);
    assertNull(pC.getNext());
    assertNull(((PDActionEmbeddedGoTo) pC).getFile());
    assertNull(((PDActionEmbeddedGoTo) pC).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) pC).getDestination());
    COSDictionary cOSObject = pdAnnotationAdditionalActions.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) pC).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, pC.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, pC.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  void testGetPV() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationAdditionalActions()).getPV());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  void testGetPV2() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualPV = pdAnnotationAdditionalActions.getPV();

    // Assert
    assertTrue(actualPV instanceof PDActionEmbeddedGoTo);
    assertNull(actualPV.getNext());
    COSDictionary cOSObject = actualPV.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionEmbeddedGoTo) actualPV).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualPV).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualPV).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualPV).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPV.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualPV.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  void testGetPV3() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getPV());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  void testGetPV4() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(new PDActionGoTo());

    // Act
    PDAction actualPV = pdAnnotationAdditionalActions.getPV();

    // Assert
    assertTrue(actualPV instanceof PDActionGoTo);
    assertNull(actualPV.getNext());
    COSDictionary cOSObject = actualPV.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualPV).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPV.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualPV.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  void testGetPV5() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(new PDActionHide());

    // Act
    PDAction actualPV = pdAnnotationAdditionalActions.getPV();

    // Assert
    assertTrue(actualPV instanceof PDActionHide);
    assertNull(actualPV.getNext());
    assertNull(((PDActionHide) actualPV).getT());
    COSDictionary cOSObject = actualPV.getCOSObject();
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
    assertTrue(((PDActionHide) actualPV).getH());
    assertEquals(PDAction.TYPE, actualPV.getType());
    assertEquals(PDActionHide.SUB_TYPE, actualPV.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  void testGetPV6() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(new PDActionImportData());

    // Act
    PDAction actualPV = pdAnnotationAdditionalActions.getPV();

    // Assert
    assertTrue(actualPV instanceof PDActionImportData);
    assertNull(actualPV.getNext());
    COSDictionary cOSObject = actualPV.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualPV).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPV.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualPV.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  void testGetPV7() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(new PDActionJavaScript());

    // Act
    PDAction actualPV = pdAnnotationAdditionalActions.getPV();

    // Assert
    assertTrue(actualPV instanceof PDActionJavaScript);
    assertNull(((PDActionJavaScript) actualPV).getAction());
    assertNull(actualPV.getNext());
    COSDictionary cOSObject = actualPV.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualPV.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualPV.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  void testGetPV8() {
    // Arrange
    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));
    PDActionEmbeddedGoTo pv = new PDActionEmbeddedGoTo(a);

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(pv);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getPV());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  void testGetPV9() {
    // Arrange
    PDActionEmbeddedGoTo pv = new PDActionEmbeddedGoTo(new COSDictionary());
    pv.setSubType("foo");

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(pv);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getPV());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  void testGetPV10() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(new PDActionLaunch());

    // Act
    PDAction actualPV = pdAnnotationAdditionalActions.getPV();

    // Assert
    assertTrue(actualPV instanceof PDActionLaunch);
    assertNull(((PDActionLaunch) actualPV).getD());
    assertNull(((PDActionLaunch) actualPV).getF());
    assertNull(((PDActionLaunch) actualPV).getO());
    assertNull(((PDActionLaunch) actualPV).getP());
    assertNull(actualPV.getNext());
    COSDictionary cOSObject = actualPV.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionLaunch) actualPV).getFile());
    assertNull(((PDActionLaunch) actualPV).getWinLaunchParams());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualPV).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPV.getType());
    assertEquals(PDActionLaunch.SUB_TYPE, actualPV.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  void testGetPV11() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(new PDActionMovie());

    // Act
    PDAction actualPV = pdAnnotationAdditionalActions.getPV();

    // Assert
    assertTrue(actualPV instanceof PDActionMovie);
    assertNull(actualPV.getNext());
    COSDictionary cOSObject = actualPV.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualPV.getType());
    assertEquals(PDActionMovie.SUB_TYPE, actualPV.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  void testGetPV12() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(new PDActionNamed());

    // Act
    PDAction actualPV = pdAnnotationAdditionalActions.getPV();

    // Assert
    assertTrue(actualPV instanceof PDActionNamed);
    assertNull(((PDActionNamed) actualPV).getN());
    assertNull(actualPV.getNext());
    COSDictionary cOSObject = actualPV.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualPV.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualPV.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  void testGetPV13() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(new PDActionRemoteGoTo());

    // Act
    PDAction actualPV = pdAnnotationAdditionalActions.getPV();

    // Assert
    assertTrue(actualPV instanceof PDActionRemoteGoTo);
    assertNull(actualPV.getNext());
    assertNull(((PDActionRemoteGoTo) actualPV).getD());
    COSDictionary cOSObject = actualPV.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionRemoteGoTo) actualPV).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualPV).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPV.getType());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualPV.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  void testGetPV14() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(new PDActionResetForm());

    // Act
    PDAction actualPV = pdAnnotationAdditionalActions.getPV();

    // Assert
    assertTrue(actualPV instanceof PDActionResetForm);
    assertNull(actualPV.getNext());
    assertNull(((PDActionResetForm) actualPV).getFields());
    COSDictionary cOSObject = actualPV.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((PDActionResetForm) actualPV).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPV.getType());
    assertEquals(PDActionResetForm.SUB_TYPE, actualPV.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  void testGetPV15() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(new PDActionSound());

    // Act
    PDAction actualPV = pdAnnotationAdditionalActions.getPV();

    // Assert
    assertTrue(actualPV instanceof PDActionSound);
    assertNull(actualPV.getNext());
    COSDictionary cOSObject = actualPV.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSound) actualPV).getSound());
    assertEquals(1.0f, ((PDActionSound) actualPV).getVolume());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDActionSound) actualPV).getMix());
    assertFalse(((PDActionSound) actualPV).getRepeat());
    assertFalse(((PDActionSound) actualPV).getSynchronous());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPV.getType());
    assertEquals(PDActionSound.SUB_TYPE, actualPV.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  void testGetPV16() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(new PDActionSubmitForm());

    // Act
    PDAction actualPV = pdAnnotationAdditionalActions.getPV();

    // Assert
    assertTrue(actualPV instanceof PDActionSubmitForm);
    assertNull(actualPV.getNext());
    assertNull(((PDActionSubmitForm) actualPV).getFields());
    COSDictionary cOSObject = actualPV.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSubmitForm) actualPV).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualPV).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPV.getType());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualPV.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  void testGetPV17() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(new PDActionThread());

    // Act
    PDAction actualPV = pdAnnotationAdditionalActions.getPV();

    // Assert
    assertTrue(actualPV instanceof PDActionThread);
    assertNull(actualPV.getNext());
    assertNull(((PDActionThread) actualPV).getB());
    assertNull(((PDActionThread) actualPV).getD());
    COSDictionary cOSObject = actualPV.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionThread) actualPV).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPV.getType());
    assertEquals(PDActionThread.SUB_TYPE, actualPV.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  void testGetPV18() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(new PDActionURI());

    // Act
    PDAction actualPV = pdAnnotationAdditionalActions.getPV();

    // Assert
    assertTrue(actualPV instanceof PDActionURI);
    assertNull(((PDActionURI) actualPV).getURI());
    assertNull(actualPV.getNext());
    COSDictionary cOSObject = actualPV.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualPV.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualPV.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#setPV(PDAction)}
   */
  @Test
  void testSetPV() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();

    // Act
    pdAnnotationAdditionalActions.setPV(new PDActionEmbeddedGoTo());

    // Assert
    PDAction pV = pdAnnotationAdditionalActions.getPV();
    assertTrue(pV instanceof PDActionEmbeddedGoTo);
    assertNull(pV.getNext());
    assertNull(((PDActionEmbeddedGoTo) pV).getFile());
    assertNull(((PDActionEmbeddedGoTo) pV).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) pV).getDestination());
    COSDictionary cOSObject = pdAnnotationAdditionalActions.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) pV).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, pV.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, pV.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  void testGetPI() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationAdditionalActions()).getPI());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  void testGetPI2() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualPI = pdAnnotationAdditionalActions.getPI();

    // Assert
    assertTrue(actualPI instanceof PDActionEmbeddedGoTo);
    assertNull(actualPI.getNext());
    COSDictionary cOSObject = actualPI.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionEmbeddedGoTo) actualPI).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualPI).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualPI).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualPI).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPI.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualPI.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  void testGetPI3() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getPI());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  void testGetPI4() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(new PDActionGoTo());

    // Act
    PDAction actualPI = pdAnnotationAdditionalActions.getPI();

    // Assert
    assertTrue(actualPI instanceof PDActionGoTo);
    assertNull(actualPI.getNext());
    COSDictionary cOSObject = actualPI.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualPI).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPI.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualPI.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  void testGetPI5() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(new PDActionHide());

    // Act
    PDAction actualPI = pdAnnotationAdditionalActions.getPI();

    // Assert
    assertTrue(actualPI instanceof PDActionHide);
    assertNull(actualPI.getNext());
    assertNull(((PDActionHide) actualPI).getT());
    COSDictionary cOSObject = actualPI.getCOSObject();
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
    assertTrue(((PDActionHide) actualPI).getH());
    assertEquals(PDAction.TYPE, actualPI.getType());
    assertEquals(PDActionHide.SUB_TYPE, actualPI.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  void testGetPI6() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(new PDActionImportData());

    // Act
    PDAction actualPI = pdAnnotationAdditionalActions.getPI();

    // Assert
    assertTrue(actualPI instanceof PDActionImportData);
    assertNull(actualPI.getNext());
    COSDictionary cOSObject = actualPI.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualPI).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPI.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualPI.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  void testGetPI7() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(new PDActionJavaScript());

    // Act
    PDAction actualPI = pdAnnotationAdditionalActions.getPI();

    // Assert
    assertTrue(actualPI instanceof PDActionJavaScript);
    assertNull(((PDActionJavaScript) actualPI).getAction());
    assertNull(actualPI.getNext());
    COSDictionary cOSObject = actualPI.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualPI.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualPI.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  void testGetPI8() {
    // Arrange
    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));
    PDActionEmbeddedGoTo pi = new PDActionEmbeddedGoTo(a);

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(pi);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getPI());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  void testGetPI9() {
    // Arrange
    PDActionEmbeddedGoTo pi = new PDActionEmbeddedGoTo(new COSDictionary());
    pi.setSubType("foo");

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(pi);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getPI());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  void testGetPI10() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(new PDActionLaunch());

    // Act
    PDAction actualPI = pdAnnotationAdditionalActions.getPI();

    // Assert
    assertTrue(actualPI instanceof PDActionLaunch);
    assertNull(((PDActionLaunch) actualPI).getD());
    assertNull(((PDActionLaunch) actualPI).getF());
    assertNull(((PDActionLaunch) actualPI).getO());
    assertNull(((PDActionLaunch) actualPI).getP());
    assertNull(actualPI.getNext());
    COSDictionary cOSObject = actualPI.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionLaunch) actualPI).getFile());
    assertNull(((PDActionLaunch) actualPI).getWinLaunchParams());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualPI).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPI.getType());
    assertEquals(PDActionLaunch.SUB_TYPE, actualPI.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  void testGetPI11() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(new PDActionMovie());

    // Act
    PDAction actualPI = pdAnnotationAdditionalActions.getPI();

    // Assert
    assertTrue(actualPI instanceof PDActionMovie);
    assertNull(actualPI.getNext());
    COSDictionary cOSObject = actualPI.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualPI.getType());
    assertEquals(PDActionMovie.SUB_TYPE, actualPI.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  void testGetPI12() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(new PDActionNamed());

    // Act
    PDAction actualPI = pdAnnotationAdditionalActions.getPI();

    // Assert
    assertTrue(actualPI instanceof PDActionNamed);
    assertNull(((PDActionNamed) actualPI).getN());
    assertNull(actualPI.getNext());
    COSDictionary cOSObject = actualPI.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualPI.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualPI.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  void testGetPI13() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(new PDActionRemoteGoTo());

    // Act
    PDAction actualPI = pdAnnotationAdditionalActions.getPI();

    // Assert
    assertTrue(actualPI instanceof PDActionRemoteGoTo);
    assertNull(actualPI.getNext());
    assertNull(((PDActionRemoteGoTo) actualPI).getD());
    COSDictionary cOSObject = actualPI.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionRemoteGoTo) actualPI).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualPI).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPI.getType());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualPI.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  void testGetPI14() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(new PDActionResetForm());

    // Act
    PDAction actualPI = pdAnnotationAdditionalActions.getPI();

    // Assert
    assertTrue(actualPI instanceof PDActionResetForm);
    assertNull(actualPI.getNext());
    assertNull(((PDActionResetForm) actualPI).getFields());
    COSDictionary cOSObject = actualPI.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((PDActionResetForm) actualPI).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPI.getType());
    assertEquals(PDActionResetForm.SUB_TYPE, actualPI.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  void testGetPI15() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(new PDActionSound());

    // Act
    PDAction actualPI = pdAnnotationAdditionalActions.getPI();

    // Assert
    assertTrue(actualPI instanceof PDActionSound);
    assertNull(actualPI.getNext());
    COSDictionary cOSObject = actualPI.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSound) actualPI).getSound());
    assertEquals(1.0f, ((PDActionSound) actualPI).getVolume());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDActionSound) actualPI).getMix());
    assertFalse(((PDActionSound) actualPI).getRepeat());
    assertFalse(((PDActionSound) actualPI).getSynchronous());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPI.getType());
    assertEquals(PDActionSound.SUB_TYPE, actualPI.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  void testGetPI16() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(new PDActionSubmitForm());

    // Act
    PDAction actualPI = pdAnnotationAdditionalActions.getPI();

    // Assert
    assertTrue(actualPI instanceof PDActionSubmitForm);
    assertNull(actualPI.getNext());
    assertNull(((PDActionSubmitForm) actualPI).getFields());
    COSDictionary cOSObject = actualPI.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSubmitForm) actualPI).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualPI).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPI.getType());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualPI.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  void testGetPI17() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(new PDActionThread());

    // Act
    PDAction actualPI = pdAnnotationAdditionalActions.getPI();

    // Assert
    assertTrue(actualPI instanceof PDActionThread);
    assertNull(actualPI.getNext());
    assertNull(((PDActionThread) actualPI).getB());
    assertNull(((PDActionThread) actualPI).getD());
    COSDictionary cOSObject = actualPI.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionThread) actualPI).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPI.getType());
    assertEquals(PDActionThread.SUB_TYPE, actualPI.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  void testGetPI18() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(new PDActionURI());

    // Act
    PDAction actualPI = pdAnnotationAdditionalActions.getPI();

    // Assert
    assertTrue(actualPI instanceof PDActionURI);
    assertNull(((PDActionURI) actualPI).getURI());
    assertNull(actualPI.getNext());
    COSDictionary cOSObject = actualPI.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualPI.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualPI.getSubType());
  }

  /**
   * Method under test: {@link PDAnnotationAdditionalActions#setPI(PDAction)}
   */
  @Test
  void testSetPI() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();

    // Act
    pdAnnotationAdditionalActions.setPI(new PDActionEmbeddedGoTo());

    // Assert
    PDAction pI = pdAnnotationAdditionalActions.getPI();
    assertTrue(pI instanceof PDActionEmbeddedGoTo);
    assertNull(pI.getNext());
    assertNull(((PDActionEmbeddedGoTo) pI).getFile());
    assertNull(((PDActionEmbeddedGoTo) pI).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) pI).getDestination());
    COSDictionary cOSObject = pdAnnotationAdditionalActions.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) pI).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, pI.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, pI.getSubType());
  }

  /**
   * Method under test:
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions(COSDictionary)}
   */
  @Test
  void testNewPDAnnotationAdditionalActions() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDAnnotationAdditionalActions(a)).getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()}
   */
  @Test
  void testNewPDAnnotationAdditionalActions2() {
    // Arrange and Act
    PDAnnotationAdditionalActions actualPdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();

    // Assert
    COSDictionary cOSObject = actualPdAnnotationAdditionalActions.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdAnnotationAdditionalActions.getBl());
    assertNull(actualPdAnnotationAdditionalActions.getD());
    assertNull(actualPdAnnotationAdditionalActions.getE());
    assertNull(actualPdAnnotationAdditionalActions.getFo());
    assertNull(actualPdAnnotationAdditionalActions.getPC());
    assertNull(actualPdAnnotationAdditionalActions.getPI());
    assertNull(actualPdAnnotationAdditionalActions.getPO());
    assertNull(actualPdAnnotationAdditionalActions.getPV());
    assertNull(actualPdAnnotationAdditionalActions.getU());
    assertNull(actualPdAnnotationAdditionalActions.getX());
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

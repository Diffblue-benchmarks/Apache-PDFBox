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

class PDDocumentCatalogAdditionalActionsDiffblueTest {
  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDDocumentCatalogAdditionalActions()).getCOSObject();

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
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  void testGetWC() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalogAdditionalActions()).getWC());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  void testGetWC2() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualWC = pdDocumentCatalogAdditionalActions.getWC();

    // Assert
    assertTrue(actualWC instanceof PDActionEmbeddedGoTo);
    assertNull(actualWC.getNext());
    COSDictionary cOSObject = actualWC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionEmbeddedGoTo) actualWC).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualWC).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualWC).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualWC).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWC.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualWC.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  void testGetWC3() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getWC());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  void testGetWC4() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionGoTo());

    // Act
    PDAction actualWC = pdDocumentCatalogAdditionalActions.getWC();

    // Assert
    assertTrue(actualWC instanceof PDActionGoTo);
    assertNull(actualWC.getNext());
    COSDictionary cOSObject = actualWC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualWC).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWC.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualWC.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  void testGetWC5() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionHide());

    // Act
    PDAction actualWC = pdDocumentCatalogAdditionalActions.getWC();

    // Assert
    assertTrue(actualWC instanceof PDActionHide);
    assertNull(actualWC.getNext());
    assertNull(((PDActionHide) actualWC).getT());
    COSDictionary cOSObject = actualWC.getCOSObject();
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
    assertTrue(((PDActionHide) actualWC).getH());
    assertEquals(PDAction.TYPE, actualWC.getType());
    assertEquals(PDActionHide.SUB_TYPE, actualWC.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  void testGetWC6() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionImportData());

    // Act
    PDAction actualWC = pdDocumentCatalogAdditionalActions.getWC();

    // Assert
    assertTrue(actualWC instanceof PDActionImportData);
    assertNull(actualWC.getNext());
    COSDictionary cOSObject = actualWC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualWC).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWC.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualWC.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  void testGetWC7() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionJavaScript());

    // Act
    PDAction actualWC = pdDocumentCatalogAdditionalActions.getWC();

    // Assert
    assertTrue(actualWC instanceof PDActionJavaScript);
    assertNull(((PDActionJavaScript) actualWC).getAction());
    assertNull(actualWC.getNext());
    COSDictionary cOSObject = actualWC.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualWC.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualWC.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  void testGetWC8() {
    // Arrange
    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));
    PDActionEmbeddedGoTo wc = new PDActionEmbeddedGoTo(a);

    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(wc);

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getWC());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  void testGetWC9() {
    // Arrange
    PDActionEmbeddedGoTo wc = new PDActionEmbeddedGoTo(new COSDictionary());
    wc.setSubType("foo");

    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(wc);

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getWC());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  void testGetWC10() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionLaunch());

    // Act
    PDAction actualWC = pdDocumentCatalogAdditionalActions.getWC();

    // Assert
    assertTrue(actualWC instanceof PDActionLaunch);
    assertNull(((PDActionLaunch) actualWC).getD());
    assertNull(((PDActionLaunch) actualWC).getF());
    assertNull(((PDActionLaunch) actualWC).getO());
    assertNull(((PDActionLaunch) actualWC).getP());
    assertNull(actualWC.getNext());
    COSDictionary cOSObject = actualWC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionLaunch) actualWC).getFile());
    assertNull(((PDActionLaunch) actualWC).getWinLaunchParams());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualWC).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWC.getType());
    assertEquals(PDActionLaunch.SUB_TYPE, actualWC.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  void testGetWC11() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionMovie());

    // Act
    PDAction actualWC = pdDocumentCatalogAdditionalActions.getWC();

    // Assert
    assertTrue(actualWC instanceof PDActionMovie);
    assertNull(actualWC.getNext());
    COSDictionary cOSObject = actualWC.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualWC.getType());
    assertEquals(PDActionMovie.SUB_TYPE, actualWC.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  void testGetWC12() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionNamed());

    // Act
    PDAction actualWC = pdDocumentCatalogAdditionalActions.getWC();

    // Assert
    assertTrue(actualWC instanceof PDActionNamed);
    assertNull(((PDActionNamed) actualWC).getN());
    assertNull(actualWC.getNext());
    COSDictionary cOSObject = actualWC.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualWC.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualWC.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  void testGetWC13() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionRemoteGoTo());

    // Act
    PDAction actualWC = pdDocumentCatalogAdditionalActions.getWC();

    // Assert
    assertTrue(actualWC instanceof PDActionRemoteGoTo);
    assertNull(actualWC.getNext());
    assertNull(((PDActionRemoteGoTo) actualWC).getD());
    COSDictionary cOSObject = actualWC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionRemoteGoTo) actualWC).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualWC).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWC.getType());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualWC.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  void testGetWC14() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionResetForm());

    // Act
    PDAction actualWC = pdDocumentCatalogAdditionalActions.getWC();

    // Assert
    assertTrue(actualWC instanceof PDActionResetForm);
    assertNull(actualWC.getNext());
    assertNull(((PDActionResetForm) actualWC).getFields());
    COSDictionary cOSObject = actualWC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((PDActionResetForm) actualWC).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWC.getType());
    assertEquals(PDActionResetForm.SUB_TYPE, actualWC.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  void testGetWC15() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionSound());

    // Act
    PDAction actualWC = pdDocumentCatalogAdditionalActions.getWC();

    // Assert
    assertTrue(actualWC instanceof PDActionSound);
    assertNull(actualWC.getNext());
    COSDictionary cOSObject = actualWC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSound) actualWC).getSound());
    assertEquals(1.0f, ((PDActionSound) actualWC).getVolume());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDActionSound) actualWC).getMix());
    assertFalse(((PDActionSound) actualWC).getRepeat());
    assertFalse(((PDActionSound) actualWC).getSynchronous());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWC.getType());
    assertEquals(PDActionSound.SUB_TYPE, actualWC.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  void testGetWC16() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionSubmitForm());

    // Act
    PDAction actualWC = pdDocumentCatalogAdditionalActions.getWC();

    // Assert
    assertTrue(actualWC instanceof PDActionSubmitForm);
    assertNull(actualWC.getNext());
    assertNull(((PDActionSubmitForm) actualWC).getFields());
    COSDictionary cOSObject = actualWC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSubmitForm) actualWC).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualWC).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWC.getType());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualWC.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  void testGetWC17() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionThread());

    // Act
    PDAction actualWC = pdDocumentCatalogAdditionalActions.getWC();

    // Assert
    assertTrue(actualWC instanceof PDActionThread);
    assertNull(actualWC.getNext());
    assertNull(((PDActionThread) actualWC).getB());
    assertNull(((PDActionThread) actualWC).getD());
    COSDictionary cOSObject = actualWC.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionThread) actualWC).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWC.getType());
    assertEquals(PDActionThread.SUB_TYPE, actualWC.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  void testGetWC18() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionURI());

    // Act
    PDAction actualWC = pdDocumentCatalogAdditionalActions.getWC();

    // Assert
    assertTrue(actualWC instanceof PDActionURI);
    assertNull(((PDActionURI) actualWC).getURI());
    assertNull(actualWC.getNext());
    COSDictionary cOSObject = actualWC.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualWC.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualWC.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#setWC(PDAction)}
   */
  @Test
  void testSetWC() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();

    // Act
    pdDocumentCatalogAdditionalActions.setWC(new PDActionEmbeddedGoTo());

    // Assert
    PDAction wC = pdDocumentCatalogAdditionalActions.getWC();
    assertTrue(wC instanceof PDActionEmbeddedGoTo);
    assertNull(wC.getNext());
    assertNull(((PDActionEmbeddedGoTo) wC).getFile());
    assertNull(((PDActionEmbeddedGoTo) wC).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) wC).getDestination());
    COSDictionary cOSObject = pdDocumentCatalogAdditionalActions.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) wC).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, wC.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, wC.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  void testGetWS() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalogAdditionalActions()).getWS());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  void testGetWS2() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualWS = pdDocumentCatalogAdditionalActions.getWS();

    // Assert
    assertTrue(actualWS instanceof PDActionEmbeddedGoTo);
    assertNull(actualWS.getNext());
    COSDictionary cOSObject = actualWS.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionEmbeddedGoTo) actualWS).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualWS).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualWS).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualWS).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWS.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualWS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  void testGetWS3() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getWS());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  void testGetWS4() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(new PDActionGoTo());

    // Act
    PDAction actualWS = pdDocumentCatalogAdditionalActions.getWS();

    // Assert
    assertTrue(actualWS instanceof PDActionGoTo);
    assertNull(actualWS.getNext());
    COSDictionary cOSObject = actualWS.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualWS).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWS.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualWS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  void testGetWS5() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(new PDActionHide());

    // Act
    PDAction actualWS = pdDocumentCatalogAdditionalActions.getWS();

    // Assert
    assertTrue(actualWS instanceof PDActionHide);
    assertNull(actualWS.getNext());
    assertNull(((PDActionHide) actualWS).getT());
    COSDictionary cOSObject = actualWS.getCOSObject();
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
    assertTrue(((PDActionHide) actualWS).getH());
    assertEquals(PDAction.TYPE, actualWS.getType());
    assertEquals(PDActionHide.SUB_TYPE, actualWS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  void testGetWS6() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(new PDActionImportData());

    // Act
    PDAction actualWS = pdDocumentCatalogAdditionalActions.getWS();

    // Assert
    assertTrue(actualWS instanceof PDActionImportData);
    assertNull(actualWS.getNext());
    COSDictionary cOSObject = actualWS.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualWS).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWS.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualWS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  void testGetWS7() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(new PDActionJavaScript());

    // Act
    PDAction actualWS = pdDocumentCatalogAdditionalActions.getWS();

    // Assert
    assertTrue(actualWS instanceof PDActionJavaScript);
    assertNull(((PDActionJavaScript) actualWS).getAction());
    assertNull(actualWS.getNext());
    COSDictionary cOSObject = actualWS.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualWS.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualWS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  void testGetWS8() {
    // Arrange
    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));
    PDActionEmbeddedGoTo ws = new PDActionEmbeddedGoTo(a);

    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(ws);

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getWS());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  void testGetWS9() {
    // Arrange
    PDActionEmbeddedGoTo ws = new PDActionEmbeddedGoTo(new COSDictionary());
    ws.setSubType("foo");

    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(ws);

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getWS());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  void testGetWS10() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(new PDActionLaunch());

    // Act
    PDAction actualWS = pdDocumentCatalogAdditionalActions.getWS();

    // Assert
    assertTrue(actualWS instanceof PDActionLaunch);
    assertNull(((PDActionLaunch) actualWS).getD());
    assertNull(((PDActionLaunch) actualWS).getF());
    assertNull(((PDActionLaunch) actualWS).getO());
    assertNull(((PDActionLaunch) actualWS).getP());
    assertNull(actualWS.getNext());
    COSDictionary cOSObject = actualWS.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionLaunch) actualWS).getFile());
    assertNull(((PDActionLaunch) actualWS).getWinLaunchParams());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualWS).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWS.getType());
    assertEquals(PDActionLaunch.SUB_TYPE, actualWS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  void testGetWS11() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(new PDActionMovie());

    // Act
    PDAction actualWS = pdDocumentCatalogAdditionalActions.getWS();

    // Assert
    assertTrue(actualWS instanceof PDActionMovie);
    assertNull(actualWS.getNext());
    COSDictionary cOSObject = actualWS.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualWS.getType());
    assertEquals(PDActionMovie.SUB_TYPE, actualWS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  void testGetWS12() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(new PDActionNamed());

    // Act
    PDAction actualWS = pdDocumentCatalogAdditionalActions.getWS();

    // Assert
    assertTrue(actualWS instanceof PDActionNamed);
    assertNull(((PDActionNamed) actualWS).getN());
    assertNull(actualWS.getNext());
    COSDictionary cOSObject = actualWS.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualWS.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualWS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  void testGetWS13() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(new PDActionRemoteGoTo());

    // Act
    PDAction actualWS = pdDocumentCatalogAdditionalActions.getWS();

    // Assert
    assertTrue(actualWS instanceof PDActionRemoteGoTo);
    assertNull(actualWS.getNext());
    assertNull(((PDActionRemoteGoTo) actualWS).getD());
    COSDictionary cOSObject = actualWS.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionRemoteGoTo) actualWS).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualWS).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWS.getType());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualWS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  void testGetWS14() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(new PDActionResetForm());

    // Act
    PDAction actualWS = pdDocumentCatalogAdditionalActions.getWS();

    // Assert
    assertTrue(actualWS instanceof PDActionResetForm);
    assertNull(actualWS.getNext());
    assertNull(((PDActionResetForm) actualWS).getFields());
    COSDictionary cOSObject = actualWS.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((PDActionResetForm) actualWS).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWS.getType());
    assertEquals(PDActionResetForm.SUB_TYPE, actualWS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  void testGetWS15() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(new PDActionSound());

    // Act
    PDAction actualWS = pdDocumentCatalogAdditionalActions.getWS();

    // Assert
    assertTrue(actualWS instanceof PDActionSound);
    assertNull(actualWS.getNext());
    COSDictionary cOSObject = actualWS.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSound) actualWS).getSound());
    assertEquals(1.0f, ((PDActionSound) actualWS).getVolume());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDActionSound) actualWS).getMix());
    assertFalse(((PDActionSound) actualWS).getRepeat());
    assertFalse(((PDActionSound) actualWS).getSynchronous());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWS.getType());
    assertEquals(PDActionSound.SUB_TYPE, actualWS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  void testGetWS16() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(new PDActionSubmitForm());

    // Act
    PDAction actualWS = pdDocumentCatalogAdditionalActions.getWS();

    // Assert
    assertTrue(actualWS instanceof PDActionSubmitForm);
    assertNull(actualWS.getNext());
    assertNull(((PDActionSubmitForm) actualWS).getFields());
    COSDictionary cOSObject = actualWS.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSubmitForm) actualWS).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualWS).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWS.getType());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualWS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  void testGetWS17() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(new PDActionThread());

    // Act
    PDAction actualWS = pdDocumentCatalogAdditionalActions.getWS();

    // Assert
    assertTrue(actualWS instanceof PDActionThread);
    assertNull(actualWS.getNext());
    assertNull(((PDActionThread) actualWS).getB());
    assertNull(((PDActionThread) actualWS).getD());
    COSDictionary cOSObject = actualWS.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionThread) actualWS).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWS.getType());
    assertEquals(PDActionThread.SUB_TYPE, actualWS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  void testGetWS18() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(new PDActionURI());

    // Act
    PDAction actualWS = pdDocumentCatalogAdditionalActions.getWS();

    // Assert
    assertTrue(actualWS instanceof PDActionURI);
    assertNull(((PDActionURI) actualWS).getURI());
    assertNull(actualWS.getNext());
    COSDictionary cOSObject = actualWS.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualWS.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualWS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#setWS(PDAction)}
   */
  @Test
  void testSetWS() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();

    // Act
    pdDocumentCatalogAdditionalActions.setWS(new PDActionEmbeddedGoTo());

    // Assert
    PDAction wS = pdDocumentCatalogAdditionalActions.getWS();
    assertTrue(wS instanceof PDActionEmbeddedGoTo);
    assertNull(wS.getNext());
    assertNull(((PDActionEmbeddedGoTo) wS).getFile());
    assertNull(((PDActionEmbeddedGoTo) wS).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) wS).getDestination());
    COSDictionary cOSObject = pdDocumentCatalogAdditionalActions.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) wS).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, wS.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, wS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  void testGetDS() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalogAdditionalActions()).getDS());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  void testGetDS2() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualDS = pdDocumentCatalogAdditionalActions.getDS();

    // Assert
    assertTrue(actualDS instanceof PDActionEmbeddedGoTo);
    assertNull(actualDS.getNext());
    COSDictionary cOSObject = actualDS.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionEmbeddedGoTo) actualDS).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualDS).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualDS).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualDS).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualDS.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualDS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  void testGetDS3() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getDS());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  void testGetDS4() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(new PDActionGoTo());

    // Act
    PDAction actualDS = pdDocumentCatalogAdditionalActions.getDS();

    // Assert
    assertTrue(actualDS instanceof PDActionGoTo);
    assertNull(actualDS.getNext());
    COSDictionary cOSObject = actualDS.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualDS).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualDS.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualDS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  void testGetDS5() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(new PDActionHide());

    // Act
    PDAction actualDS = pdDocumentCatalogAdditionalActions.getDS();

    // Assert
    assertTrue(actualDS instanceof PDActionHide);
    assertNull(actualDS.getNext());
    assertNull(((PDActionHide) actualDS).getT());
    COSDictionary cOSObject = actualDS.getCOSObject();
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
    assertTrue(((PDActionHide) actualDS).getH());
    assertEquals(PDAction.TYPE, actualDS.getType());
    assertEquals(PDActionHide.SUB_TYPE, actualDS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  void testGetDS6() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(new PDActionImportData());

    // Act
    PDAction actualDS = pdDocumentCatalogAdditionalActions.getDS();

    // Assert
    assertTrue(actualDS instanceof PDActionImportData);
    assertNull(actualDS.getNext());
    COSDictionary cOSObject = actualDS.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualDS).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualDS.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualDS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  void testGetDS7() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(new PDActionJavaScript());

    // Act
    PDAction actualDS = pdDocumentCatalogAdditionalActions.getDS();

    // Assert
    assertTrue(actualDS instanceof PDActionJavaScript);
    assertNull(((PDActionJavaScript) actualDS).getAction());
    assertNull(actualDS.getNext());
    COSDictionary cOSObject = actualDS.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualDS.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualDS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  void testGetDS8() {
    // Arrange
    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));
    PDActionEmbeddedGoTo ds = new PDActionEmbeddedGoTo(a);

    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(ds);

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getDS());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  void testGetDS9() {
    // Arrange
    PDActionEmbeddedGoTo ds = new PDActionEmbeddedGoTo(new COSDictionary());
    ds.setSubType("foo");

    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(ds);

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getDS());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  void testGetDS10() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(new PDActionLaunch());

    // Act
    PDAction actualDS = pdDocumentCatalogAdditionalActions.getDS();

    // Assert
    assertTrue(actualDS instanceof PDActionLaunch);
    assertNull(((PDActionLaunch) actualDS).getD());
    assertNull(((PDActionLaunch) actualDS).getF());
    assertNull(((PDActionLaunch) actualDS).getO());
    assertNull(((PDActionLaunch) actualDS).getP());
    assertNull(actualDS.getNext());
    COSDictionary cOSObject = actualDS.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionLaunch) actualDS).getFile());
    assertNull(((PDActionLaunch) actualDS).getWinLaunchParams());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualDS).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualDS.getType());
    assertEquals(PDActionLaunch.SUB_TYPE, actualDS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  void testGetDS11() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(new PDActionMovie());

    // Act
    PDAction actualDS = pdDocumentCatalogAdditionalActions.getDS();

    // Assert
    assertTrue(actualDS instanceof PDActionMovie);
    assertNull(actualDS.getNext());
    COSDictionary cOSObject = actualDS.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualDS.getType());
    assertEquals(PDActionMovie.SUB_TYPE, actualDS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  void testGetDS12() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(new PDActionNamed());

    // Act
    PDAction actualDS = pdDocumentCatalogAdditionalActions.getDS();

    // Assert
    assertTrue(actualDS instanceof PDActionNamed);
    assertNull(((PDActionNamed) actualDS).getN());
    assertNull(actualDS.getNext());
    COSDictionary cOSObject = actualDS.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualDS.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualDS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  void testGetDS13() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(new PDActionRemoteGoTo());

    // Act
    PDAction actualDS = pdDocumentCatalogAdditionalActions.getDS();

    // Assert
    assertTrue(actualDS instanceof PDActionRemoteGoTo);
    assertNull(actualDS.getNext());
    assertNull(((PDActionRemoteGoTo) actualDS).getD());
    COSDictionary cOSObject = actualDS.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionRemoteGoTo) actualDS).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualDS).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualDS.getType());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualDS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  void testGetDS14() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(new PDActionResetForm());

    // Act
    PDAction actualDS = pdDocumentCatalogAdditionalActions.getDS();

    // Assert
    assertTrue(actualDS instanceof PDActionResetForm);
    assertNull(actualDS.getNext());
    assertNull(((PDActionResetForm) actualDS).getFields());
    COSDictionary cOSObject = actualDS.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((PDActionResetForm) actualDS).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualDS.getType());
    assertEquals(PDActionResetForm.SUB_TYPE, actualDS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  void testGetDS15() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(new PDActionSound());

    // Act
    PDAction actualDS = pdDocumentCatalogAdditionalActions.getDS();

    // Assert
    assertTrue(actualDS instanceof PDActionSound);
    assertNull(actualDS.getNext());
    COSDictionary cOSObject = actualDS.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSound) actualDS).getSound());
    assertEquals(1.0f, ((PDActionSound) actualDS).getVolume());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDActionSound) actualDS).getMix());
    assertFalse(((PDActionSound) actualDS).getRepeat());
    assertFalse(((PDActionSound) actualDS).getSynchronous());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualDS.getType());
    assertEquals(PDActionSound.SUB_TYPE, actualDS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  void testGetDS16() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(new PDActionSubmitForm());

    // Act
    PDAction actualDS = pdDocumentCatalogAdditionalActions.getDS();

    // Assert
    assertTrue(actualDS instanceof PDActionSubmitForm);
    assertNull(actualDS.getNext());
    assertNull(((PDActionSubmitForm) actualDS).getFields());
    COSDictionary cOSObject = actualDS.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSubmitForm) actualDS).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualDS).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualDS.getType());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualDS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  void testGetDS17() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(new PDActionThread());

    // Act
    PDAction actualDS = pdDocumentCatalogAdditionalActions.getDS();

    // Assert
    assertTrue(actualDS instanceof PDActionThread);
    assertNull(actualDS.getNext());
    assertNull(((PDActionThread) actualDS).getB());
    assertNull(((PDActionThread) actualDS).getD());
    COSDictionary cOSObject = actualDS.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionThread) actualDS).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualDS.getType());
    assertEquals(PDActionThread.SUB_TYPE, actualDS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  void testGetDS18() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(new PDActionURI());

    // Act
    PDAction actualDS = pdDocumentCatalogAdditionalActions.getDS();

    // Assert
    assertTrue(actualDS instanceof PDActionURI);
    assertNull(((PDActionURI) actualDS).getURI());
    assertNull(actualDS.getNext());
    COSDictionary cOSObject = actualDS.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualDS.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualDS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#setDS(PDAction)}
   */
  @Test
  void testSetDS() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();

    // Act
    pdDocumentCatalogAdditionalActions.setDS(new PDActionEmbeddedGoTo());

    // Assert
    PDAction dS = pdDocumentCatalogAdditionalActions.getDS();
    assertTrue(dS instanceof PDActionEmbeddedGoTo);
    assertNull(dS.getNext());
    assertNull(((PDActionEmbeddedGoTo) dS).getFile());
    assertNull(((PDActionEmbeddedGoTo) dS).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) dS).getDestination());
    COSDictionary cOSObject = pdDocumentCatalogAdditionalActions.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) dS).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, dS.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, dS.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  void testGetWP() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalogAdditionalActions()).getWP());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  void testGetWP2() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualWP = pdDocumentCatalogAdditionalActions.getWP();

    // Assert
    assertTrue(actualWP instanceof PDActionEmbeddedGoTo);
    assertNull(actualWP.getNext());
    COSDictionary cOSObject = actualWP.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionEmbeddedGoTo) actualWP).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualWP).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualWP).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualWP).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWP.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualWP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  void testGetWP3() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getWP());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  void testGetWP4() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(new PDActionGoTo());

    // Act
    PDAction actualWP = pdDocumentCatalogAdditionalActions.getWP();

    // Assert
    assertTrue(actualWP instanceof PDActionGoTo);
    assertNull(actualWP.getNext());
    COSDictionary cOSObject = actualWP.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualWP).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWP.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualWP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  void testGetWP5() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(new PDActionHide());

    // Act
    PDAction actualWP = pdDocumentCatalogAdditionalActions.getWP();

    // Assert
    assertTrue(actualWP instanceof PDActionHide);
    assertNull(actualWP.getNext());
    assertNull(((PDActionHide) actualWP).getT());
    COSDictionary cOSObject = actualWP.getCOSObject();
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
    assertTrue(((PDActionHide) actualWP).getH());
    assertEquals(PDAction.TYPE, actualWP.getType());
    assertEquals(PDActionHide.SUB_TYPE, actualWP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  void testGetWP6() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(new PDActionImportData());

    // Act
    PDAction actualWP = pdDocumentCatalogAdditionalActions.getWP();

    // Assert
    assertTrue(actualWP instanceof PDActionImportData);
    assertNull(actualWP.getNext());
    COSDictionary cOSObject = actualWP.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualWP).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWP.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualWP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  void testGetWP7() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(new PDActionJavaScript());

    // Act
    PDAction actualWP = pdDocumentCatalogAdditionalActions.getWP();

    // Assert
    assertTrue(actualWP instanceof PDActionJavaScript);
    assertNull(((PDActionJavaScript) actualWP).getAction());
    assertNull(actualWP.getNext());
    COSDictionary cOSObject = actualWP.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualWP.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualWP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  void testGetWP8() {
    // Arrange
    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));
    PDActionEmbeddedGoTo wp = new PDActionEmbeddedGoTo(a);

    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(wp);

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getWP());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  void testGetWP9() {
    // Arrange
    PDActionEmbeddedGoTo wp = new PDActionEmbeddedGoTo(new COSDictionary());
    wp.setSubType("foo");

    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(wp);

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getWP());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  void testGetWP10() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(new PDActionLaunch());

    // Act
    PDAction actualWP = pdDocumentCatalogAdditionalActions.getWP();

    // Assert
    assertTrue(actualWP instanceof PDActionLaunch);
    assertNull(((PDActionLaunch) actualWP).getD());
    assertNull(((PDActionLaunch) actualWP).getF());
    assertNull(((PDActionLaunch) actualWP).getO());
    assertNull(((PDActionLaunch) actualWP).getP());
    assertNull(actualWP.getNext());
    COSDictionary cOSObject = actualWP.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionLaunch) actualWP).getFile());
    assertNull(((PDActionLaunch) actualWP).getWinLaunchParams());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualWP).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWP.getType());
    assertEquals(PDActionLaunch.SUB_TYPE, actualWP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  void testGetWP11() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(new PDActionMovie());

    // Act
    PDAction actualWP = pdDocumentCatalogAdditionalActions.getWP();

    // Assert
    assertTrue(actualWP instanceof PDActionMovie);
    assertNull(actualWP.getNext());
    COSDictionary cOSObject = actualWP.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualWP.getType());
    assertEquals(PDActionMovie.SUB_TYPE, actualWP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  void testGetWP12() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(new PDActionNamed());

    // Act
    PDAction actualWP = pdDocumentCatalogAdditionalActions.getWP();

    // Assert
    assertTrue(actualWP instanceof PDActionNamed);
    assertNull(((PDActionNamed) actualWP).getN());
    assertNull(actualWP.getNext());
    COSDictionary cOSObject = actualWP.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualWP.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualWP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  void testGetWP13() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(new PDActionRemoteGoTo());

    // Act
    PDAction actualWP = pdDocumentCatalogAdditionalActions.getWP();

    // Assert
    assertTrue(actualWP instanceof PDActionRemoteGoTo);
    assertNull(actualWP.getNext());
    assertNull(((PDActionRemoteGoTo) actualWP).getD());
    COSDictionary cOSObject = actualWP.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionRemoteGoTo) actualWP).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualWP).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWP.getType());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualWP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  void testGetWP14() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(new PDActionResetForm());

    // Act
    PDAction actualWP = pdDocumentCatalogAdditionalActions.getWP();

    // Assert
    assertTrue(actualWP instanceof PDActionResetForm);
    assertNull(actualWP.getNext());
    assertNull(((PDActionResetForm) actualWP).getFields());
    COSDictionary cOSObject = actualWP.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((PDActionResetForm) actualWP).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWP.getType());
    assertEquals(PDActionResetForm.SUB_TYPE, actualWP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  void testGetWP15() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(new PDActionSound());

    // Act
    PDAction actualWP = pdDocumentCatalogAdditionalActions.getWP();

    // Assert
    assertTrue(actualWP instanceof PDActionSound);
    assertNull(actualWP.getNext());
    COSDictionary cOSObject = actualWP.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSound) actualWP).getSound());
    assertEquals(1.0f, ((PDActionSound) actualWP).getVolume());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDActionSound) actualWP).getMix());
    assertFalse(((PDActionSound) actualWP).getRepeat());
    assertFalse(((PDActionSound) actualWP).getSynchronous());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWP.getType());
    assertEquals(PDActionSound.SUB_TYPE, actualWP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  void testGetWP16() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(new PDActionSubmitForm());

    // Act
    PDAction actualWP = pdDocumentCatalogAdditionalActions.getWP();

    // Assert
    assertTrue(actualWP instanceof PDActionSubmitForm);
    assertNull(actualWP.getNext());
    assertNull(((PDActionSubmitForm) actualWP).getFields());
    COSDictionary cOSObject = actualWP.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSubmitForm) actualWP).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualWP).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWP.getType());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualWP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  void testGetWP17() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(new PDActionThread());

    // Act
    PDAction actualWP = pdDocumentCatalogAdditionalActions.getWP();

    // Assert
    assertTrue(actualWP instanceof PDActionThread);
    assertNull(actualWP.getNext());
    assertNull(((PDActionThread) actualWP).getB());
    assertNull(((PDActionThread) actualWP).getD());
    COSDictionary cOSObject = actualWP.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionThread) actualWP).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualWP.getType());
    assertEquals(PDActionThread.SUB_TYPE, actualWP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  void testGetWP18() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(new PDActionURI());

    // Act
    PDAction actualWP = pdDocumentCatalogAdditionalActions.getWP();

    // Assert
    assertTrue(actualWP instanceof PDActionURI);
    assertNull(((PDActionURI) actualWP).getURI());
    assertNull(actualWP.getNext());
    COSDictionary cOSObject = actualWP.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualWP.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualWP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#setWP(PDAction)}
   */
  @Test
  void testSetWP() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();

    // Act
    pdDocumentCatalogAdditionalActions.setWP(new PDActionEmbeddedGoTo());

    // Assert
    PDAction wP = pdDocumentCatalogAdditionalActions.getWP();
    assertTrue(wP instanceof PDActionEmbeddedGoTo);
    assertNull(wP.getNext());
    assertNull(((PDActionEmbeddedGoTo) wP).getFile());
    assertNull(((PDActionEmbeddedGoTo) wP).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) wP).getDestination());
    COSDictionary cOSObject = pdDocumentCatalogAdditionalActions.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) wP).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, wP.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, wP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  void testGetDP() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalogAdditionalActions()).getDP());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  void testGetDP2() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualDP = pdDocumentCatalogAdditionalActions.getDP();

    // Assert
    assertTrue(actualDP instanceof PDActionEmbeddedGoTo);
    assertNull(actualDP.getNext());
    COSDictionary cOSObject = actualDP.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionEmbeddedGoTo) actualDP).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualDP).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualDP).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualDP).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualDP.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualDP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  void testGetDP3() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getDP());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  void testGetDP4() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(new PDActionGoTo());

    // Act
    PDAction actualDP = pdDocumentCatalogAdditionalActions.getDP();

    // Assert
    assertTrue(actualDP instanceof PDActionGoTo);
    assertNull(actualDP.getNext());
    COSDictionary cOSObject = actualDP.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualDP).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualDP.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualDP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  void testGetDP5() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(new PDActionHide());

    // Act
    PDAction actualDP = pdDocumentCatalogAdditionalActions.getDP();

    // Assert
    assertTrue(actualDP instanceof PDActionHide);
    assertNull(actualDP.getNext());
    assertNull(((PDActionHide) actualDP).getT());
    COSDictionary cOSObject = actualDP.getCOSObject();
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
    assertTrue(((PDActionHide) actualDP).getH());
    assertEquals(PDAction.TYPE, actualDP.getType());
    assertEquals(PDActionHide.SUB_TYPE, actualDP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  void testGetDP6() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(new PDActionImportData());

    // Act
    PDAction actualDP = pdDocumentCatalogAdditionalActions.getDP();

    // Assert
    assertTrue(actualDP instanceof PDActionImportData);
    assertNull(actualDP.getNext());
    COSDictionary cOSObject = actualDP.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualDP).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualDP.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualDP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  void testGetDP7() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(new PDActionJavaScript());

    // Act
    PDAction actualDP = pdDocumentCatalogAdditionalActions.getDP();

    // Assert
    assertTrue(actualDP instanceof PDActionJavaScript);
    assertNull(((PDActionJavaScript) actualDP).getAction());
    assertNull(actualDP.getNext());
    COSDictionary cOSObject = actualDP.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualDP.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualDP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  void testGetDP8() {
    // Arrange
    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));
    PDActionEmbeddedGoTo dp = new PDActionEmbeddedGoTo(a);

    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(dp);

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getDP());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  void testGetDP9() {
    // Arrange
    PDActionEmbeddedGoTo dp = new PDActionEmbeddedGoTo(new COSDictionary());
    dp.setSubType("foo");

    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(dp);

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getDP());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  void testGetDP10() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(new PDActionLaunch());

    // Act
    PDAction actualDP = pdDocumentCatalogAdditionalActions.getDP();

    // Assert
    assertTrue(actualDP instanceof PDActionLaunch);
    assertNull(((PDActionLaunch) actualDP).getD());
    assertNull(((PDActionLaunch) actualDP).getF());
    assertNull(((PDActionLaunch) actualDP).getO());
    assertNull(((PDActionLaunch) actualDP).getP());
    assertNull(actualDP.getNext());
    COSDictionary cOSObject = actualDP.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionLaunch) actualDP).getFile());
    assertNull(((PDActionLaunch) actualDP).getWinLaunchParams());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualDP).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualDP.getType());
    assertEquals(PDActionLaunch.SUB_TYPE, actualDP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  void testGetDP11() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(new PDActionMovie());

    // Act
    PDAction actualDP = pdDocumentCatalogAdditionalActions.getDP();

    // Assert
    assertTrue(actualDP instanceof PDActionMovie);
    assertNull(actualDP.getNext());
    COSDictionary cOSObject = actualDP.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualDP.getType());
    assertEquals(PDActionMovie.SUB_TYPE, actualDP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  void testGetDP12() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(new PDActionNamed());

    // Act
    PDAction actualDP = pdDocumentCatalogAdditionalActions.getDP();

    // Assert
    assertTrue(actualDP instanceof PDActionNamed);
    assertNull(((PDActionNamed) actualDP).getN());
    assertNull(actualDP.getNext());
    COSDictionary cOSObject = actualDP.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualDP.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualDP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  void testGetDP13() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(new PDActionRemoteGoTo());

    // Act
    PDAction actualDP = pdDocumentCatalogAdditionalActions.getDP();

    // Assert
    assertTrue(actualDP instanceof PDActionRemoteGoTo);
    assertNull(actualDP.getNext());
    assertNull(((PDActionRemoteGoTo) actualDP).getD());
    COSDictionary cOSObject = actualDP.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionRemoteGoTo) actualDP).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualDP).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualDP.getType());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualDP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  void testGetDP14() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(new PDActionResetForm());

    // Act
    PDAction actualDP = pdDocumentCatalogAdditionalActions.getDP();

    // Assert
    assertTrue(actualDP instanceof PDActionResetForm);
    assertNull(actualDP.getNext());
    assertNull(((PDActionResetForm) actualDP).getFields());
    COSDictionary cOSObject = actualDP.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((PDActionResetForm) actualDP).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualDP.getType());
    assertEquals(PDActionResetForm.SUB_TYPE, actualDP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  void testGetDP15() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(new PDActionSound());

    // Act
    PDAction actualDP = pdDocumentCatalogAdditionalActions.getDP();

    // Assert
    assertTrue(actualDP instanceof PDActionSound);
    assertNull(actualDP.getNext());
    COSDictionary cOSObject = actualDP.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSound) actualDP).getSound());
    assertEquals(1.0f, ((PDActionSound) actualDP).getVolume());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDActionSound) actualDP).getMix());
    assertFalse(((PDActionSound) actualDP).getRepeat());
    assertFalse(((PDActionSound) actualDP).getSynchronous());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualDP.getType());
    assertEquals(PDActionSound.SUB_TYPE, actualDP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  void testGetDP16() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(new PDActionSubmitForm());

    // Act
    PDAction actualDP = pdDocumentCatalogAdditionalActions.getDP();

    // Assert
    assertTrue(actualDP instanceof PDActionSubmitForm);
    assertNull(actualDP.getNext());
    assertNull(((PDActionSubmitForm) actualDP).getFields());
    COSDictionary cOSObject = actualDP.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSubmitForm) actualDP).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualDP).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualDP.getType());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualDP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  void testGetDP17() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(new PDActionThread());

    // Act
    PDAction actualDP = pdDocumentCatalogAdditionalActions.getDP();

    // Assert
    assertTrue(actualDP instanceof PDActionThread);
    assertNull(actualDP.getNext());
    assertNull(((PDActionThread) actualDP).getB());
    assertNull(((PDActionThread) actualDP).getD());
    COSDictionary cOSObject = actualDP.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionThread) actualDP).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualDP.getType());
    assertEquals(PDActionThread.SUB_TYPE, actualDP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  void testGetDP18() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(new PDActionURI());

    // Act
    PDAction actualDP = pdDocumentCatalogAdditionalActions.getDP();

    // Assert
    assertTrue(actualDP instanceof PDActionURI);
    assertNull(((PDActionURI) actualDP).getURI());
    assertNull(actualDP.getNext());
    COSDictionary cOSObject = actualDP.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualDP.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualDP.getSubType());
  }

  /**
   * Method under test: {@link PDDocumentCatalogAdditionalActions#setDP(PDAction)}
   */
  @Test
  void testSetDP() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();

    // Act
    pdDocumentCatalogAdditionalActions.setDP(new PDActionEmbeddedGoTo());

    // Assert
    PDAction dP = pdDocumentCatalogAdditionalActions.getDP();
    assertTrue(dP instanceof PDActionEmbeddedGoTo);
    assertNull(dP.getNext());
    assertNull(((PDActionEmbeddedGoTo) dP).getFile());
    assertNull(((PDActionEmbeddedGoTo) dP).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) dP).getDestination());
    COSDictionary cOSObject = pdDocumentCatalogAdditionalActions.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) dP).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, dP.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, dP.getSubType());
  }

  /**
   * Method under test:
   * {@link PDDocumentCatalogAdditionalActions#PDDocumentCatalogAdditionalActions(COSDictionary)}
   */
  @Test
  void testNewPDDocumentCatalogAdditionalActions() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDDocumentCatalogAdditionalActions(a)).getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDDocumentCatalogAdditionalActions#PDDocumentCatalogAdditionalActions()}
   */
  @Test
  void testNewPDDocumentCatalogAdditionalActions2() {
    // Arrange and Act
    PDDocumentCatalogAdditionalActions actualPdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();

    // Assert
    COSDictionary cOSObject = actualPdDocumentCatalogAdditionalActions.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdDocumentCatalogAdditionalActions.getDP());
    assertNull(actualPdDocumentCatalogAdditionalActions.getDS());
    assertNull(actualPdDocumentCatalogAdditionalActions.getWC());
    assertNull(actualPdDocumentCatalogAdditionalActions.getWP());
    assertNull(actualPdDocumentCatalogAdditionalActions.getWS());
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

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

class PDPageAdditionalActionsDiffblueTest {
  /**
   * Method under test: {@link PDPageAdditionalActions#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDPageAdditionalActions()).getCOSObject();

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
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  void testGetO() {
    // Arrange, Act and Assert
    assertNull((new PDPageAdditionalActions()).getO());
  }

  /**
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  void testGetO2() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualO = pdPageAdditionalActions.getO();

    // Assert
    assertTrue(actualO instanceof PDActionEmbeddedGoTo);
    assertNull(actualO.getNext());
    COSDictionary cOSObject = actualO.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionEmbeddedGoTo) actualO).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualO).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualO).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualO).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualO.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  void testGetO3() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdPageAdditionalActions.getO());
  }

  /**
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  void testGetO4() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionGoTo());

    // Act
    PDAction actualO = pdPageAdditionalActions.getO();

    // Assert
    assertTrue(actualO instanceof PDActionGoTo);
    assertNull(actualO.getNext());
    COSDictionary cOSObject = actualO.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualO).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualO.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  void testGetO5() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionHide());

    // Act
    PDAction actualO = pdPageAdditionalActions.getO();

    // Assert
    assertTrue(actualO instanceof PDActionHide);
    assertNull(actualO.getNext());
    assertNull(((PDActionHide) actualO).getT());
    COSDictionary cOSObject = actualO.getCOSObject();
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
    assertTrue(((PDActionHide) actualO).getH());
    assertEquals(PDAction.TYPE, actualO.getType());
    assertEquals(PDActionHide.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  void testGetO6() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionImportData());

    // Act
    PDAction actualO = pdPageAdditionalActions.getO();

    // Assert
    assertTrue(actualO instanceof PDActionImportData);
    assertNull(actualO.getNext());
    COSDictionary cOSObject = actualO.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualO).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualO.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  void testGetO7() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionJavaScript());

    // Act
    PDAction actualO = pdPageAdditionalActions.getO();

    // Assert
    assertTrue(actualO instanceof PDActionJavaScript);
    assertNull(((PDActionJavaScript) actualO).getAction());
    assertNull(actualO.getNext());
    COSDictionary cOSObject = actualO.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualO.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  void testGetO8() {
    // Arrange
    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));
    PDActionEmbeddedGoTo o = new PDActionEmbeddedGoTo(a);

    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(o);

    // Act and Assert
    assertNull(pdPageAdditionalActions.getO());
  }

  /**
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  void testGetO9() {
    // Arrange
    PDActionEmbeddedGoTo o = new PDActionEmbeddedGoTo(new COSDictionary());
    o.setSubType("foo");

    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(o);

    // Act and Assert
    assertNull(pdPageAdditionalActions.getO());
  }

  /**
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  void testGetO10() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionLaunch());

    // Act
    PDAction actualO = pdPageAdditionalActions.getO();

    // Assert
    assertTrue(actualO instanceof PDActionLaunch);
    assertNull(((PDActionLaunch) actualO).getD());
    assertNull(((PDActionLaunch) actualO).getF());
    assertNull(((PDActionLaunch) actualO).getO());
    assertNull(((PDActionLaunch) actualO).getP());
    assertNull(actualO.getNext());
    COSDictionary cOSObject = actualO.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionLaunch) actualO).getFile());
    assertNull(((PDActionLaunch) actualO).getWinLaunchParams());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualO).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualO.getType());
    assertEquals(PDActionLaunch.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  void testGetO11() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionMovie());

    // Act
    PDAction actualO = pdPageAdditionalActions.getO();

    // Assert
    assertTrue(actualO instanceof PDActionMovie);
    assertNull(actualO.getNext());
    COSDictionary cOSObject = actualO.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualO.getType());
    assertEquals(PDActionMovie.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  void testGetO12() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionNamed());

    // Act
    PDAction actualO = pdPageAdditionalActions.getO();

    // Assert
    assertTrue(actualO instanceof PDActionNamed);
    assertNull(((PDActionNamed) actualO).getN());
    assertNull(actualO.getNext());
    COSDictionary cOSObject = actualO.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualO.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  void testGetO13() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionRemoteGoTo());

    // Act
    PDAction actualO = pdPageAdditionalActions.getO();

    // Assert
    assertTrue(actualO instanceof PDActionRemoteGoTo);
    assertNull(actualO.getNext());
    assertNull(((PDActionRemoteGoTo) actualO).getD());
    COSDictionary cOSObject = actualO.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionRemoteGoTo) actualO).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualO).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualO.getType());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  void testGetO14() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionResetForm());

    // Act
    PDAction actualO = pdPageAdditionalActions.getO();

    // Assert
    assertTrue(actualO instanceof PDActionResetForm);
    assertNull(actualO.getNext());
    assertNull(((PDActionResetForm) actualO).getFields());
    COSDictionary cOSObject = actualO.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((PDActionResetForm) actualO).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualO.getType());
    assertEquals(PDActionResetForm.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  void testGetO15() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionSound());

    // Act
    PDAction actualO = pdPageAdditionalActions.getO();

    // Assert
    assertTrue(actualO instanceof PDActionSound);
    assertNull(actualO.getNext());
    COSDictionary cOSObject = actualO.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSound) actualO).getSound());
    assertEquals(1.0f, ((PDActionSound) actualO).getVolume());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDActionSound) actualO).getMix());
    assertFalse(((PDActionSound) actualO).getRepeat());
    assertFalse(((PDActionSound) actualO).getSynchronous());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualO.getType());
    assertEquals(PDActionSound.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  void testGetO16() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionSubmitForm());

    // Act
    PDAction actualO = pdPageAdditionalActions.getO();

    // Assert
    assertTrue(actualO instanceof PDActionSubmitForm);
    assertNull(actualO.getNext());
    assertNull(((PDActionSubmitForm) actualO).getFields());
    COSDictionary cOSObject = actualO.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSubmitForm) actualO).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualO).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualO.getType());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  void testGetO17() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionThread());

    // Act
    PDAction actualO = pdPageAdditionalActions.getO();

    // Assert
    assertTrue(actualO instanceof PDActionThread);
    assertNull(actualO.getNext());
    assertNull(((PDActionThread) actualO).getB());
    assertNull(((PDActionThread) actualO).getD());
    COSDictionary cOSObject = actualO.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionThread) actualO).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualO.getType());
    assertEquals(PDActionThread.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  void testGetO18() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionURI());

    // Act
    PDAction actualO = pdPageAdditionalActions.getO();

    // Assert
    assertTrue(actualO instanceof PDActionURI);
    assertNull(((PDActionURI) actualO).getURI());
    assertNull(actualO.getNext());
    COSDictionary cOSObject = actualO.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualO.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Method under test: {@link PDPageAdditionalActions#setO(PDAction)}
   */
  @Test
  void testSetO() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();

    // Act
    pdPageAdditionalActions.setO(new PDActionEmbeddedGoTo());

    // Assert
    PDAction o = pdPageAdditionalActions.getO();
    assertTrue(o instanceof PDActionEmbeddedGoTo);
    assertNull(o.getNext());
    assertNull(((PDActionEmbeddedGoTo) o).getFile());
    assertNull(((PDActionEmbeddedGoTo) o).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) o).getDestination());
    COSDictionary cOSObject = pdPageAdditionalActions.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) o).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, o.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, o.getSubType());
  }

  /**
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  void testGetC() {
    // Arrange, Act and Assert
    assertNull((new PDPageAdditionalActions()).getC());
  }

  /**
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  void testGetC2() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualC = pdPageAdditionalActions.getC();

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
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  void testGetC3() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdPageAdditionalActions.getC());
  }

  /**
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  void testGetC4() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionGoTo());

    // Act
    PDAction actualC = pdPageAdditionalActions.getC();

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
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  void testGetC5() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionHide());

    // Act
    PDAction actualC = pdPageAdditionalActions.getC();

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
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  void testGetC6() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionImportData());

    // Act
    PDAction actualC = pdPageAdditionalActions.getC();

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
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  void testGetC7() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionJavaScript());

    // Act
    PDAction actualC = pdPageAdditionalActions.getC();

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
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  void testGetC8() {
    // Arrange
    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));
    PDActionEmbeddedGoTo c = new PDActionEmbeddedGoTo(a);

    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(c);

    // Act and Assert
    assertNull(pdPageAdditionalActions.getC());
  }

  /**
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  void testGetC9() {
    // Arrange
    PDActionEmbeddedGoTo c = new PDActionEmbeddedGoTo(new COSDictionary());
    c.setSubType("foo");

    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(c);

    // Act and Assert
    assertNull(pdPageAdditionalActions.getC());
  }

  /**
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  void testGetC10() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionLaunch());

    // Act
    PDAction actualC = pdPageAdditionalActions.getC();

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
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  void testGetC11() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionMovie());

    // Act
    PDAction actualC = pdPageAdditionalActions.getC();

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
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  void testGetC12() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionNamed());

    // Act
    PDAction actualC = pdPageAdditionalActions.getC();

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
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  void testGetC13() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionRemoteGoTo());

    // Act
    PDAction actualC = pdPageAdditionalActions.getC();

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
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  void testGetC14() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionResetForm());

    // Act
    PDAction actualC = pdPageAdditionalActions.getC();

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
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  void testGetC15() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionSound());

    // Act
    PDAction actualC = pdPageAdditionalActions.getC();

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
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  void testGetC16() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionSubmitForm());

    // Act
    PDAction actualC = pdPageAdditionalActions.getC();

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
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  void testGetC17() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionThread());

    // Act
    PDAction actualC = pdPageAdditionalActions.getC();

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
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  void testGetC18() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionURI());

    // Act
    PDAction actualC = pdPageAdditionalActions.getC();

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
   * Method under test: {@link PDPageAdditionalActions#setC(PDAction)}
   */
  @Test
  void testSetC() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();

    // Act
    pdPageAdditionalActions.setC(new PDActionEmbeddedGoTo());

    // Assert
    PDAction c = pdPageAdditionalActions.getC();
    assertTrue(c instanceof PDActionEmbeddedGoTo);
    assertNull(c.getNext());
    assertNull(((PDActionEmbeddedGoTo) c).getFile());
    assertNull(((PDActionEmbeddedGoTo) c).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) c).getDestination());
    COSDictionary cOSObject = pdPageAdditionalActions.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) c).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, c.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, c.getSubType());
  }

  /**
   * Method under test:
   * {@link PDPageAdditionalActions#PDPageAdditionalActions(COSDictionary)}
   */
  @Test
  void testNewPDPageAdditionalActions() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDPageAdditionalActions(a)).getCOSObject());
  }

  /**
   * Method under test: {@link PDPageAdditionalActions#PDPageAdditionalActions()}
   */
  @Test
  void testNewPDPageAdditionalActions2() {
    // Arrange and Act
    PDPageAdditionalActions actualPdPageAdditionalActions = new PDPageAdditionalActions();

    // Assert
    COSDictionary cOSObject = actualPdPageAdditionalActions.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdPageAdditionalActions.getC());
    assertNull(actualPdPageAdditionalActions.getO());
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

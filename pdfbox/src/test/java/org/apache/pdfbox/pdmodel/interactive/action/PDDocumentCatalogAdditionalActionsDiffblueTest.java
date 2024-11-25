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

class PDDocumentCatalogAdditionalActionsDiffblueTest {
  /**
   * Test
   * {@link PDDocumentCatalogAdditionalActions#PDDocumentCatalogAdditionalActions(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDDocumentCatalogAdditionalActions#PDDocumentCatalogAdditionalActions(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDDocumentCatalogAdditionalActions(COSDictionary)")
  void testNewPDDocumentCatalogAdditionalActions() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDDocumentCatalogAdditionalActions(a)).getCOSObject());
  }

  /**
   * Test
   * {@link PDDocumentCatalogAdditionalActions#PDDocumentCatalogAdditionalActions()}.
   * <p>
   * Method under test:
   * {@link PDDocumentCatalogAdditionalActions#PDDocumentCatalogAdditionalActions()}
   */
  @Test
  @DisplayName("Test new PDDocumentCatalogAdditionalActions()")
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

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getCOSObject()}.
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
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
   * Test {@link PDDocumentCatalogAdditionalActions#getWC()}.
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  @DisplayName("Test getWC()")
  void testGetWC() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getWC());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWC()}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  @DisplayName("Test getWC(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  void testGetWC_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getWC()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} SubType is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  @DisplayName("Test getWC(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary() SubType is 'foo'")
  void testGetWC_givenPDActionEmbeddedGoToWithAIsCOSDictionarySubTypeIsFoo() {
    // Arrange
    PDActionEmbeddedGoTo wc = new PDActionEmbeddedGoTo(new COSDictionary());
    wc.setSubType("foo");

    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(wc);

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getWC());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWC()}.
   * <ul>
   *   <li>Given
   * {@link PDDocumentCatalogAdditionalActions#PDDocumentCatalogAdditionalActions()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  @DisplayName("Test getWC(); given PDDocumentCatalogAdditionalActions(); then return 'null'")
  void testGetWC_givenPDDocumentCatalogAdditionalActions_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalogAdditionalActions()).getWC());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWC()}.
   * <ul>
   *   <li>Then return {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  @DisplayName("Test getWC(); then return PDActionEmbeddedGoTo")
  void testGetWC_thenReturnPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualWC = pdDocumentCatalogAdditionalActions.getWC();

    // Assert
    assertTrue(actualWC instanceof PDActionEmbeddedGoTo);
    assertNull(((PDActionEmbeddedGoTo) actualWC).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualWC).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualWC).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualWC).getOpenInNewWindow());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualWC.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWC()}.
   * <ul>
   *   <li>Then return {@link PDActionGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  @DisplayName("Test getWC(); then return PDActionGoTo")
  void testGetWC_thenReturnPDActionGoTo() throws IOException {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getWC()}.
   * <ul>
   *   <li>Then return {@link PDActionHide}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  @DisplayName("Test getWC(); then return PDActionHide")
  void testGetWC_thenReturnPDActionHide() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionHide());

    // Act
    PDAction actualWC = pdDocumentCatalogAdditionalActions.getWC();

    // Assert
    assertTrue(actualWC instanceof PDActionHide);
    assertNull(((PDActionHide) actualWC).getT());
    assertTrue(((PDActionHide) actualWC).getH());
    assertEquals(PDActionHide.SUB_TYPE, actualWC.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWC()}.
   * <ul>
   *   <li>Then return {@link PDActionImportData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  @DisplayName("Test getWC(); then return PDActionImportData")
  void testGetWC_thenReturnPDActionImportData() throws IOException {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getWC()}.
   * <ul>
   *   <li>Then return {@link PDActionJavaScript}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  @DisplayName("Test getWC(); then return PDActionJavaScript")
  void testGetWC_thenReturnPDActionJavaScript() {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getWC()}.
   * <ul>
   *   <li>Then return {@link PDActionLaunch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  @DisplayName("Test getWC(); then return PDActionLaunch")
  void testGetWC_thenReturnPDActionLaunch() throws IOException {
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
    assertNull(((PDActionLaunch) actualWC).getFile());
    assertNull(((PDActionLaunch) actualWC).getWinLaunchParams());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualWC).getOpenInNewWindow());
    assertEquals(PDActionLaunch.SUB_TYPE, actualWC.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWC()}.
   * <ul>
   *   <li>Then return {@link PDActionMovie}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  @DisplayName("Test getWC(); then return PDActionMovie")
  void testGetWC_thenReturnPDActionMovie() {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getWC()}.
   * <ul>
   *   <li>Then return {@link PDActionNamed}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  @DisplayName("Test getWC(); then return PDActionNamed")
  void testGetWC_thenReturnPDActionNamed() {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getWC()}.
   * <ul>
   *   <li>Then return {@link PDActionRemoteGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  @DisplayName("Test getWC(); then return PDActionRemoteGoTo")
  void testGetWC_thenReturnPDActionRemoteGoTo() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionRemoteGoTo());

    // Act
    PDAction actualWC = pdDocumentCatalogAdditionalActions.getWC();

    // Assert
    assertTrue(actualWC instanceof PDActionRemoteGoTo);
    assertNull(((PDActionRemoteGoTo) actualWC).getD());
    assertNull(((PDActionRemoteGoTo) actualWC).getFile());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualWC).getOpenInNewWindow());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualWC.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWC()}.
   * <ul>
   *   <li>Then return {@link PDActionResetForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  @DisplayName("Test getWC(); then return PDActionResetForm")
  void testGetWC_thenReturnPDActionResetForm() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionResetForm());

    // Act
    PDAction actualWC = pdDocumentCatalogAdditionalActions.getWC();

    // Assert
    assertTrue(actualWC instanceof PDActionResetForm);
    assertNull(((PDActionResetForm) actualWC).getFields());
    assertEquals(0, ((PDActionResetForm) actualWC).getFlags());
    assertEquals(PDActionResetForm.SUB_TYPE, actualWC.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWC()}.
   * <ul>
   *   <li>Then return {@link PDActionSound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  @DisplayName("Test getWC(); then return PDActionSound")
  void testGetWC_thenReturnPDActionSound() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionSound());

    // Act
    PDAction actualWC = pdDocumentCatalogAdditionalActions.getWC();

    // Assert
    assertTrue(actualWC instanceof PDActionSound);
    assertNull(((PDActionSound) actualWC).getSound());
    assertEquals(1.0f, ((PDActionSound) actualWC).getVolume());
    assertFalse(((PDActionSound) actualWC).getMix());
    assertFalse(((PDActionSound) actualWC).getRepeat());
    assertFalse(((PDActionSound) actualWC).getSynchronous());
    assertEquals(PDActionSound.SUB_TYPE, actualWC.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWC()}.
   * <ul>
   *   <li>Then return {@link PDActionSubmitForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  @DisplayName("Test getWC(); then return PDActionSubmitForm")
  void testGetWC_thenReturnPDActionSubmitForm() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionSubmitForm());

    // Act
    PDAction actualWC = pdDocumentCatalogAdditionalActions.getWC();

    // Assert
    assertTrue(actualWC instanceof PDActionSubmitForm);
    assertNull(((PDActionSubmitForm) actualWC).getFields());
    assertNull(((PDActionSubmitForm) actualWC).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualWC).getFlags());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualWC.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWC()}.
   * <ul>
   *   <li>Then return {@link PDActionThread}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  @DisplayName("Test getWC(); then return PDActionThread")
  void testGetWC_thenReturnPDActionThread() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionThread());

    // Act
    PDAction actualWC = pdDocumentCatalogAdditionalActions.getWC();

    // Assert
    assertTrue(actualWC instanceof PDActionThread);
    assertNull(((PDActionThread) actualWC).getB());
    assertNull(((PDActionThread) actualWC).getD());
    assertNull(((PDActionThread) actualWC).getFile());
    assertEquals(PDActionThread.SUB_TYPE, actualWC.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWC()}.
   * <ul>
   *   <li>Then return {@link PDActionURI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWC()}
   */
  @Test
  @DisplayName("Test getWC(); then return PDActionURI")
  void testGetWC_thenReturnPDActionURI() {
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
   * Test {@link PDDocumentCatalogAdditionalActions#setWC(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDDocumentCatalogAdditionalActions#PDDocumentCatalogAdditionalActions()}
   * WC {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#setWC(PDAction)}
   */
  @Test
  @DisplayName("Test setWC(PDAction); then PDDocumentCatalogAdditionalActions() WC PDActionEmbeddedGoTo")
  void testSetWC_thenPDDocumentCatalogAdditionalActionsWcPDActionEmbeddedGoTo() throws IOException {
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
   * Test {@link PDDocumentCatalogAdditionalActions#setWC(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDDocumentCatalogAdditionalActions#PDDocumentCatalogAdditionalActions(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} WC is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#setWC(PDAction)}
   */
  @Test
  @DisplayName("Test setWC(PDAction); then PDDocumentCatalogAdditionalActions(COSDictionary) with a is COSDictionary() WC is 'null'")
  void testSetWC_thenPDDocumentCatalogAdditionalActionsWithAIsCOSDictionaryWcIsNull() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions(
        new COSDictionary());

    // Act
    pdDocumentCatalogAdditionalActions.setWC(null);

    // Assert
    assertNull(pdDocumentCatalogAdditionalActions.getWC());
    COSDictionary cOSObject = pdDocumentCatalogAdditionalActions.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWS()}.
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  @DisplayName("Test getWS()")
  void testGetWS() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getWS());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWS()}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  @DisplayName("Test getWS(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  void testGetWS_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getWS()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} SubType is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  @DisplayName("Test getWS(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary() SubType is 'foo'")
  void testGetWS_givenPDActionEmbeddedGoToWithAIsCOSDictionarySubTypeIsFoo() {
    // Arrange
    PDActionEmbeddedGoTo ws = new PDActionEmbeddedGoTo(new COSDictionary());
    ws.setSubType("foo");

    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(ws);

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getWS());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWS()}.
   * <ul>
   *   <li>Given
   * {@link PDDocumentCatalogAdditionalActions#PDDocumentCatalogAdditionalActions()}
   * WC is {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  @DisplayName("Test getWS(); given PDDocumentCatalogAdditionalActions() WC is PDActionEmbeddedGoTo()")
  void testGetWS_givenPDDocumentCatalogAdditionalActionsWcIsPDActionEmbeddedGoTo() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionEmbeddedGoTo());

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getWS());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWS()}.
   * <ul>
   *   <li>Given
   * {@link PDDocumentCatalogAdditionalActions#PDDocumentCatalogAdditionalActions()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  @DisplayName("Test getWS(); given PDDocumentCatalogAdditionalActions(); then return 'null'")
  void testGetWS_givenPDDocumentCatalogAdditionalActions_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalogAdditionalActions()).getWS());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWS()}.
   * <ul>
   *   <li>Then return {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  @DisplayName("Test getWS(); then return PDActionEmbeddedGoTo")
  void testGetWS_thenReturnPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualWS = pdDocumentCatalogAdditionalActions.getWS();

    // Assert
    assertTrue(actualWS instanceof PDActionEmbeddedGoTo);
    assertNull(((PDActionEmbeddedGoTo) actualWS).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualWS).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualWS).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualWS).getOpenInNewWindow());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualWS.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWS()}.
   * <ul>
   *   <li>Then return {@link PDActionGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  @DisplayName("Test getWS(); then return PDActionGoTo")
  void testGetWS_thenReturnPDActionGoTo() throws IOException {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getWS()}.
   * <ul>
   *   <li>Then return {@link PDActionHide}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  @DisplayName("Test getWS(); then return PDActionHide")
  void testGetWS_thenReturnPDActionHide() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(new PDActionHide());

    // Act
    PDAction actualWS = pdDocumentCatalogAdditionalActions.getWS();

    // Assert
    assertTrue(actualWS instanceof PDActionHide);
    assertNull(((PDActionHide) actualWS).getT());
    assertTrue(((PDActionHide) actualWS).getH());
    assertEquals(PDActionHide.SUB_TYPE, actualWS.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWS()}.
   * <ul>
   *   <li>Then return {@link PDActionImportData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  @DisplayName("Test getWS(); then return PDActionImportData")
  void testGetWS_thenReturnPDActionImportData() throws IOException {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getWS()}.
   * <ul>
   *   <li>Then return {@link PDActionJavaScript}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  @DisplayName("Test getWS(); then return PDActionJavaScript")
  void testGetWS_thenReturnPDActionJavaScript() {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getWS()}.
   * <ul>
   *   <li>Then return {@link PDActionLaunch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  @DisplayName("Test getWS(); then return PDActionLaunch")
  void testGetWS_thenReturnPDActionLaunch() throws IOException {
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
    assertNull(((PDActionLaunch) actualWS).getFile());
    assertNull(((PDActionLaunch) actualWS).getWinLaunchParams());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualWS).getOpenInNewWindow());
    assertEquals(PDActionLaunch.SUB_TYPE, actualWS.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWS()}.
   * <ul>
   *   <li>Then return {@link PDActionMovie}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  @DisplayName("Test getWS(); then return PDActionMovie")
  void testGetWS_thenReturnPDActionMovie() {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getWS()}.
   * <ul>
   *   <li>Then return {@link PDActionNamed}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  @DisplayName("Test getWS(); then return PDActionNamed")
  void testGetWS_thenReturnPDActionNamed() {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getWS()}.
   * <ul>
   *   <li>Then return {@link PDActionRemoteGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  @DisplayName("Test getWS(); then return PDActionRemoteGoTo")
  void testGetWS_thenReturnPDActionRemoteGoTo() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(new PDActionRemoteGoTo());

    // Act
    PDAction actualWS = pdDocumentCatalogAdditionalActions.getWS();

    // Assert
    assertTrue(actualWS instanceof PDActionRemoteGoTo);
    assertNull(((PDActionRemoteGoTo) actualWS).getD());
    assertNull(((PDActionRemoteGoTo) actualWS).getFile());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualWS).getOpenInNewWindow());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualWS.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWS()}.
   * <ul>
   *   <li>Then return {@link PDActionResetForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  @DisplayName("Test getWS(); then return PDActionResetForm")
  void testGetWS_thenReturnPDActionResetForm() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(new PDActionResetForm());

    // Act
    PDAction actualWS = pdDocumentCatalogAdditionalActions.getWS();

    // Assert
    assertTrue(actualWS instanceof PDActionResetForm);
    assertNull(((PDActionResetForm) actualWS).getFields());
    assertEquals(0, ((PDActionResetForm) actualWS).getFlags());
    assertEquals(PDActionResetForm.SUB_TYPE, actualWS.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWS()}.
   * <ul>
   *   <li>Then return {@link PDActionSound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  @DisplayName("Test getWS(); then return PDActionSound")
  void testGetWS_thenReturnPDActionSound() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(new PDActionSound());

    // Act
    PDAction actualWS = pdDocumentCatalogAdditionalActions.getWS();

    // Assert
    assertTrue(actualWS instanceof PDActionSound);
    assertNull(((PDActionSound) actualWS).getSound());
    assertEquals(1.0f, ((PDActionSound) actualWS).getVolume());
    assertFalse(((PDActionSound) actualWS).getMix());
    assertFalse(((PDActionSound) actualWS).getRepeat());
    assertFalse(((PDActionSound) actualWS).getSynchronous());
    assertEquals(PDActionSound.SUB_TYPE, actualWS.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWS()}.
   * <ul>
   *   <li>Then return {@link PDActionSubmitForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  @DisplayName("Test getWS(); then return PDActionSubmitForm")
  void testGetWS_thenReturnPDActionSubmitForm() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(new PDActionSubmitForm());

    // Act
    PDAction actualWS = pdDocumentCatalogAdditionalActions.getWS();

    // Assert
    assertTrue(actualWS instanceof PDActionSubmitForm);
    assertNull(((PDActionSubmitForm) actualWS).getFields());
    assertNull(((PDActionSubmitForm) actualWS).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualWS).getFlags());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualWS.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWS()}.
   * <ul>
   *   <li>Then return {@link PDActionThread}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  @DisplayName("Test getWS(); then return PDActionThread")
  void testGetWS_thenReturnPDActionThread() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWS(new PDActionThread());

    // Act
    PDAction actualWS = pdDocumentCatalogAdditionalActions.getWS();

    // Assert
    assertTrue(actualWS instanceof PDActionThread);
    assertNull(((PDActionThread) actualWS).getB());
    assertNull(((PDActionThread) actualWS).getD());
    assertNull(((PDActionThread) actualWS).getFile());
    assertEquals(PDActionThread.SUB_TYPE, actualWS.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWS()}.
   * <ul>
   *   <li>Then return {@link PDActionURI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWS()}
   */
  @Test
  @DisplayName("Test getWS(); then return PDActionURI")
  void testGetWS_thenReturnPDActionURI() {
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
   * Test {@link PDDocumentCatalogAdditionalActions#setWS(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDDocumentCatalogAdditionalActions#PDDocumentCatalogAdditionalActions(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} WS is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#setWS(PDAction)}
   */
  @Test
  @DisplayName("Test setWS(PDAction); then PDDocumentCatalogAdditionalActions(COSDictionary) with a is COSDictionary() WS is 'null'")
  void testSetWS_thenPDDocumentCatalogAdditionalActionsWithAIsCOSDictionaryWsIsNull() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions(
        new COSDictionary());

    // Act
    pdDocumentCatalogAdditionalActions.setWS(null);

    // Assert
    assertNull(pdDocumentCatalogAdditionalActions.getWS());
    COSDictionary cOSObject = pdDocumentCatalogAdditionalActions.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#setWS(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDDocumentCatalogAdditionalActions#PDDocumentCatalogAdditionalActions()}
   * WS {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#setWS(PDAction)}
   */
  @Test
  @DisplayName("Test setWS(PDAction); then PDDocumentCatalogAdditionalActions() WS PDActionEmbeddedGoTo")
  void testSetWS_thenPDDocumentCatalogAdditionalActionsWsPDActionEmbeddedGoTo() throws IOException {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getDS()}.
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  @DisplayName("Test getDS()")
  void testGetDS() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getDS());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getDS()}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  @DisplayName("Test getDS(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  void testGetDS_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getDS()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} SubType is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  @DisplayName("Test getDS(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary() SubType is 'foo'")
  void testGetDS_givenPDActionEmbeddedGoToWithAIsCOSDictionarySubTypeIsFoo() {
    // Arrange
    PDActionEmbeddedGoTo ds = new PDActionEmbeddedGoTo(new COSDictionary());
    ds.setSubType("foo");

    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(ds);

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getDS());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getDS()}.
   * <ul>
   *   <li>Given
   * {@link PDDocumentCatalogAdditionalActions#PDDocumentCatalogAdditionalActions()}
   * WC is {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  @DisplayName("Test getDS(); given PDDocumentCatalogAdditionalActions() WC is PDActionEmbeddedGoTo()")
  void testGetDS_givenPDDocumentCatalogAdditionalActionsWcIsPDActionEmbeddedGoTo() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionEmbeddedGoTo());

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getDS());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getDS()}.
   * <ul>
   *   <li>Given
   * {@link PDDocumentCatalogAdditionalActions#PDDocumentCatalogAdditionalActions()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  @DisplayName("Test getDS(); given PDDocumentCatalogAdditionalActions(); then return 'null'")
  void testGetDS_givenPDDocumentCatalogAdditionalActions_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalogAdditionalActions()).getDS());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getDS()}.
   * <ul>
   *   <li>Then return {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  @DisplayName("Test getDS(); then return PDActionEmbeddedGoTo")
  void testGetDS_thenReturnPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualDS = pdDocumentCatalogAdditionalActions.getDS();

    // Assert
    assertTrue(actualDS instanceof PDActionEmbeddedGoTo);
    assertNull(((PDActionEmbeddedGoTo) actualDS).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualDS).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualDS).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualDS).getOpenInNewWindow());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualDS.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getDS()}.
   * <ul>
   *   <li>Then return {@link PDActionGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  @DisplayName("Test getDS(); then return PDActionGoTo")
  void testGetDS_thenReturnPDActionGoTo() throws IOException {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getDS()}.
   * <ul>
   *   <li>Then return {@link PDActionHide}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  @DisplayName("Test getDS(); then return PDActionHide")
  void testGetDS_thenReturnPDActionHide() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(new PDActionHide());

    // Act
    PDAction actualDS = pdDocumentCatalogAdditionalActions.getDS();

    // Assert
    assertTrue(actualDS instanceof PDActionHide);
    assertNull(((PDActionHide) actualDS).getT());
    assertTrue(((PDActionHide) actualDS).getH());
    assertEquals(PDActionHide.SUB_TYPE, actualDS.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getDS()}.
   * <ul>
   *   <li>Then return {@link PDActionImportData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  @DisplayName("Test getDS(); then return PDActionImportData")
  void testGetDS_thenReturnPDActionImportData() throws IOException {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getDS()}.
   * <ul>
   *   <li>Then return {@link PDActionJavaScript}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  @DisplayName("Test getDS(); then return PDActionJavaScript")
  void testGetDS_thenReturnPDActionJavaScript() {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getDS()}.
   * <ul>
   *   <li>Then return {@link PDActionLaunch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  @DisplayName("Test getDS(); then return PDActionLaunch")
  void testGetDS_thenReturnPDActionLaunch() throws IOException {
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
    assertNull(((PDActionLaunch) actualDS).getFile());
    assertNull(((PDActionLaunch) actualDS).getWinLaunchParams());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualDS).getOpenInNewWindow());
    assertEquals(PDActionLaunch.SUB_TYPE, actualDS.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getDS()}.
   * <ul>
   *   <li>Then return {@link PDActionMovie}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  @DisplayName("Test getDS(); then return PDActionMovie")
  void testGetDS_thenReturnPDActionMovie() {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getDS()}.
   * <ul>
   *   <li>Then return {@link PDActionNamed}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  @DisplayName("Test getDS(); then return PDActionNamed")
  void testGetDS_thenReturnPDActionNamed() {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getDS()}.
   * <ul>
   *   <li>Then return {@link PDActionRemoteGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  @DisplayName("Test getDS(); then return PDActionRemoteGoTo")
  void testGetDS_thenReturnPDActionRemoteGoTo() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(new PDActionRemoteGoTo());

    // Act
    PDAction actualDS = pdDocumentCatalogAdditionalActions.getDS();

    // Assert
    assertTrue(actualDS instanceof PDActionRemoteGoTo);
    assertNull(((PDActionRemoteGoTo) actualDS).getD());
    assertNull(((PDActionRemoteGoTo) actualDS).getFile());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualDS).getOpenInNewWindow());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualDS.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getDS()}.
   * <ul>
   *   <li>Then return {@link PDActionResetForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  @DisplayName("Test getDS(); then return PDActionResetForm")
  void testGetDS_thenReturnPDActionResetForm() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(new PDActionResetForm());

    // Act
    PDAction actualDS = pdDocumentCatalogAdditionalActions.getDS();

    // Assert
    assertTrue(actualDS instanceof PDActionResetForm);
    assertNull(((PDActionResetForm) actualDS).getFields());
    assertEquals(0, ((PDActionResetForm) actualDS).getFlags());
    assertEquals(PDActionResetForm.SUB_TYPE, actualDS.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getDS()}.
   * <ul>
   *   <li>Then return {@link PDActionSound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  @DisplayName("Test getDS(); then return PDActionSound")
  void testGetDS_thenReturnPDActionSound() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(new PDActionSound());

    // Act
    PDAction actualDS = pdDocumentCatalogAdditionalActions.getDS();

    // Assert
    assertTrue(actualDS instanceof PDActionSound);
    assertNull(((PDActionSound) actualDS).getSound());
    assertEquals(1.0f, ((PDActionSound) actualDS).getVolume());
    assertFalse(((PDActionSound) actualDS).getMix());
    assertFalse(((PDActionSound) actualDS).getRepeat());
    assertFalse(((PDActionSound) actualDS).getSynchronous());
    assertEquals(PDActionSound.SUB_TYPE, actualDS.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getDS()}.
   * <ul>
   *   <li>Then return {@link PDActionSubmitForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  @DisplayName("Test getDS(); then return PDActionSubmitForm")
  void testGetDS_thenReturnPDActionSubmitForm() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(new PDActionSubmitForm());

    // Act
    PDAction actualDS = pdDocumentCatalogAdditionalActions.getDS();

    // Assert
    assertTrue(actualDS instanceof PDActionSubmitForm);
    assertNull(((PDActionSubmitForm) actualDS).getFields());
    assertNull(((PDActionSubmitForm) actualDS).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualDS).getFlags());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualDS.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getDS()}.
   * <ul>
   *   <li>Then return {@link PDActionThread}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  @DisplayName("Test getDS(); then return PDActionThread")
  void testGetDS_thenReturnPDActionThread() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDS(new PDActionThread());

    // Act
    PDAction actualDS = pdDocumentCatalogAdditionalActions.getDS();

    // Assert
    assertTrue(actualDS instanceof PDActionThread);
    assertNull(((PDActionThread) actualDS).getB());
    assertNull(((PDActionThread) actualDS).getD());
    assertNull(((PDActionThread) actualDS).getFile());
    assertEquals(PDActionThread.SUB_TYPE, actualDS.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getDS()}.
   * <ul>
   *   <li>Then return {@link PDActionURI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDS()}
   */
  @Test
  @DisplayName("Test getDS(); then return PDActionURI")
  void testGetDS_thenReturnPDActionURI() {
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
   * Test {@link PDDocumentCatalogAdditionalActions#setDS(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDDocumentCatalogAdditionalActions#PDDocumentCatalogAdditionalActions()}
   * DS {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#setDS(PDAction)}
   */
  @Test
  @DisplayName("Test setDS(PDAction); then PDDocumentCatalogAdditionalActions() DS PDActionEmbeddedGoTo")
  void testSetDS_thenPDDocumentCatalogAdditionalActionsDsPDActionEmbeddedGoTo() throws IOException {
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
   * Test {@link PDDocumentCatalogAdditionalActions#setDS(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDDocumentCatalogAdditionalActions#PDDocumentCatalogAdditionalActions(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} DS is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#setDS(PDAction)}
   */
  @Test
  @DisplayName("Test setDS(PDAction); then PDDocumentCatalogAdditionalActions(COSDictionary) with a is COSDictionary() DS is 'null'")
  void testSetDS_thenPDDocumentCatalogAdditionalActionsWithAIsCOSDictionaryDsIsNull() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions(
        new COSDictionary());

    // Act
    pdDocumentCatalogAdditionalActions.setDS(null);

    // Assert
    assertNull(pdDocumentCatalogAdditionalActions.getDS());
    COSDictionary cOSObject = pdDocumentCatalogAdditionalActions.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWP()}.
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  @DisplayName("Test getWP()")
  void testGetWP() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getWP());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWP()}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  @DisplayName("Test getWP(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  void testGetWP_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getWP()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} SubType is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  @DisplayName("Test getWP(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary() SubType is 'foo'")
  void testGetWP_givenPDActionEmbeddedGoToWithAIsCOSDictionarySubTypeIsFoo() {
    // Arrange
    PDActionEmbeddedGoTo wp = new PDActionEmbeddedGoTo(new COSDictionary());
    wp.setSubType("foo");

    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(wp);

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getWP());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWP()}.
   * <ul>
   *   <li>Given
   * {@link PDDocumentCatalogAdditionalActions#PDDocumentCatalogAdditionalActions()}
   * WC is {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  @DisplayName("Test getWP(); given PDDocumentCatalogAdditionalActions() WC is PDActionEmbeddedGoTo()")
  void testGetWP_givenPDDocumentCatalogAdditionalActionsWcIsPDActionEmbeddedGoTo() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionEmbeddedGoTo());

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getWP());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWP()}.
   * <ul>
   *   <li>Given
   * {@link PDDocumentCatalogAdditionalActions#PDDocumentCatalogAdditionalActions()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  @DisplayName("Test getWP(); given PDDocumentCatalogAdditionalActions(); then return 'null'")
  void testGetWP_givenPDDocumentCatalogAdditionalActions_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalogAdditionalActions()).getWP());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWP()}.
   * <ul>
   *   <li>Then return {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  @DisplayName("Test getWP(); then return PDActionEmbeddedGoTo")
  void testGetWP_thenReturnPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualWP = pdDocumentCatalogAdditionalActions.getWP();

    // Assert
    assertTrue(actualWP instanceof PDActionEmbeddedGoTo);
    assertNull(((PDActionEmbeddedGoTo) actualWP).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualWP).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualWP).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualWP).getOpenInNewWindow());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualWP.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWP()}.
   * <ul>
   *   <li>Then return {@link PDActionGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  @DisplayName("Test getWP(); then return PDActionGoTo")
  void testGetWP_thenReturnPDActionGoTo() throws IOException {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getWP()}.
   * <ul>
   *   <li>Then return {@link PDActionHide}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  @DisplayName("Test getWP(); then return PDActionHide")
  void testGetWP_thenReturnPDActionHide() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(new PDActionHide());

    // Act
    PDAction actualWP = pdDocumentCatalogAdditionalActions.getWP();

    // Assert
    assertTrue(actualWP instanceof PDActionHide);
    assertNull(((PDActionHide) actualWP).getT());
    assertTrue(((PDActionHide) actualWP).getH());
    assertEquals(PDActionHide.SUB_TYPE, actualWP.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWP()}.
   * <ul>
   *   <li>Then return {@link PDActionImportData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  @DisplayName("Test getWP(); then return PDActionImportData")
  void testGetWP_thenReturnPDActionImportData() throws IOException {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getWP()}.
   * <ul>
   *   <li>Then return {@link PDActionJavaScript}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  @DisplayName("Test getWP(); then return PDActionJavaScript")
  void testGetWP_thenReturnPDActionJavaScript() {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getWP()}.
   * <ul>
   *   <li>Then return {@link PDActionLaunch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  @DisplayName("Test getWP(); then return PDActionLaunch")
  void testGetWP_thenReturnPDActionLaunch() throws IOException {
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
    assertNull(((PDActionLaunch) actualWP).getFile());
    assertNull(((PDActionLaunch) actualWP).getWinLaunchParams());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualWP).getOpenInNewWindow());
    assertEquals(PDActionLaunch.SUB_TYPE, actualWP.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWP()}.
   * <ul>
   *   <li>Then return {@link PDActionMovie}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  @DisplayName("Test getWP(); then return PDActionMovie")
  void testGetWP_thenReturnPDActionMovie() {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getWP()}.
   * <ul>
   *   <li>Then return {@link PDActionNamed}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  @DisplayName("Test getWP(); then return PDActionNamed")
  void testGetWP_thenReturnPDActionNamed() {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getWP()}.
   * <ul>
   *   <li>Then return {@link PDActionRemoteGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  @DisplayName("Test getWP(); then return PDActionRemoteGoTo")
  void testGetWP_thenReturnPDActionRemoteGoTo() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(new PDActionRemoteGoTo());

    // Act
    PDAction actualWP = pdDocumentCatalogAdditionalActions.getWP();

    // Assert
    assertTrue(actualWP instanceof PDActionRemoteGoTo);
    assertNull(((PDActionRemoteGoTo) actualWP).getD());
    assertNull(((PDActionRemoteGoTo) actualWP).getFile());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualWP).getOpenInNewWindow());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualWP.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWP()}.
   * <ul>
   *   <li>Then return {@link PDActionResetForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  @DisplayName("Test getWP(); then return PDActionResetForm")
  void testGetWP_thenReturnPDActionResetForm() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(new PDActionResetForm());

    // Act
    PDAction actualWP = pdDocumentCatalogAdditionalActions.getWP();

    // Assert
    assertTrue(actualWP instanceof PDActionResetForm);
    assertNull(((PDActionResetForm) actualWP).getFields());
    assertEquals(0, ((PDActionResetForm) actualWP).getFlags());
    assertEquals(PDActionResetForm.SUB_TYPE, actualWP.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWP()}.
   * <ul>
   *   <li>Then return {@link PDActionSound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  @DisplayName("Test getWP(); then return PDActionSound")
  void testGetWP_thenReturnPDActionSound() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(new PDActionSound());

    // Act
    PDAction actualWP = pdDocumentCatalogAdditionalActions.getWP();

    // Assert
    assertTrue(actualWP instanceof PDActionSound);
    assertNull(((PDActionSound) actualWP).getSound());
    assertEquals(1.0f, ((PDActionSound) actualWP).getVolume());
    assertFalse(((PDActionSound) actualWP).getMix());
    assertFalse(((PDActionSound) actualWP).getRepeat());
    assertFalse(((PDActionSound) actualWP).getSynchronous());
    assertEquals(PDActionSound.SUB_TYPE, actualWP.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWP()}.
   * <ul>
   *   <li>Then return {@link PDActionSubmitForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  @DisplayName("Test getWP(); then return PDActionSubmitForm")
  void testGetWP_thenReturnPDActionSubmitForm() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(new PDActionSubmitForm());

    // Act
    PDAction actualWP = pdDocumentCatalogAdditionalActions.getWP();

    // Assert
    assertTrue(actualWP instanceof PDActionSubmitForm);
    assertNull(((PDActionSubmitForm) actualWP).getFields());
    assertNull(((PDActionSubmitForm) actualWP).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualWP).getFlags());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualWP.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWP()}.
   * <ul>
   *   <li>Then return {@link PDActionThread}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  @DisplayName("Test getWP(); then return PDActionThread")
  void testGetWP_thenReturnPDActionThread() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWP(new PDActionThread());

    // Act
    PDAction actualWP = pdDocumentCatalogAdditionalActions.getWP();

    // Assert
    assertTrue(actualWP instanceof PDActionThread);
    assertNull(((PDActionThread) actualWP).getB());
    assertNull(((PDActionThread) actualWP).getD());
    assertNull(((PDActionThread) actualWP).getFile());
    assertEquals(PDActionThread.SUB_TYPE, actualWP.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getWP()}.
   * <ul>
   *   <li>Then return {@link PDActionURI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getWP()}
   */
  @Test
  @DisplayName("Test getWP(); then return PDActionURI")
  void testGetWP_thenReturnPDActionURI() {
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
   * Test {@link PDDocumentCatalogAdditionalActions#setWP(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDDocumentCatalogAdditionalActions#PDDocumentCatalogAdditionalActions(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} WP is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#setWP(PDAction)}
   */
  @Test
  @DisplayName("Test setWP(PDAction); then PDDocumentCatalogAdditionalActions(COSDictionary) with a is COSDictionary() WP is 'null'")
  void testSetWP_thenPDDocumentCatalogAdditionalActionsWithAIsCOSDictionaryWpIsNull() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions(
        new COSDictionary());

    // Act
    pdDocumentCatalogAdditionalActions.setWP(null);

    // Assert
    assertNull(pdDocumentCatalogAdditionalActions.getWP());
    COSDictionary cOSObject = pdDocumentCatalogAdditionalActions.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#setWP(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDDocumentCatalogAdditionalActions#PDDocumentCatalogAdditionalActions()}
   * WP {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#setWP(PDAction)}
   */
  @Test
  @DisplayName("Test setWP(PDAction); then PDDocumentCatalogAdditionalActions() WP PDActionEmbeddedGoTo")
  void testSetWP_thenPDDocumentCatalogAdditionalActionsWpPDActionEmbeddedGoTo() throws IOException {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getDP()}.
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  @DisplayName("Test getDP()")
  void testGetDP() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getDP());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getDP()}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  @DisplayName("Test getDP(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  void testGetDP_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getDP()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} SubType is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  @DisplayName("Test getDP(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary() SubType is 'foo'")
  void testGetDP_givenPDActionEmbeddedGoToWithAIsCOSDictionarySubTypeIsFoo() {
    // Arrange
    PDActionEmbeddedGoTo dp = new PDActionEmbeddedGoTo(new COSDictionary());
    dp.setSubType("foo");

    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(dp);

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getDP());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getDP()}.
   * <ul>
   *   <li>Given
   * {@link PDDocumentCatalogAdditionalActions#PDDocumentCatalogAdditionalActions()}
   * WC is {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  @DisplayName("Test getDP(); given PDDocumentCatalogAdditionalActions() WC is PDActionEmbeddedGoTo()")
  void testGetDP_givenPDDocumentCatalogAdditionalActionsWcIsPDActionEmbeddedGoTo() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setWC(new PDActionEmbeddedGoTo());

    // Act and Assert
    assertNull(pdDocumentCatalogAdditionalActions.getDP());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getDP()}.
   * <ul>
   *   <li>Given
   * {@link PDDocumentCatalogAdditionalActions#PDDocumentCatalogAdditionalActions()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  @DisplayName("Test getDP(); given PDDocumentCatalogAdditionalActions(); then return 'null'")
  void testGetDP_givenPDDocumentCatalogAdditionalActions_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalogAdditionalActions()).getDP());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getDP()}.
   * <ul>
   *   <li>Then return {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  @DisplayName("Test getDP(); then return PDActionEmbeddedGoTo")
  void testGetDP_thenReturnPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualDP = pdDocumentCatalogAdditionalActions.getDP();

    // Assert
    assertTrue(actualDP instanceof PDActionEmbeddedGoTo);
    assertNull(((PDActionEmbeddedGoTo) actualDP).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualDP).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualDP).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualDP).getOpenInNewWindow());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualDP.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getDP()}.
   * <ul>
   *   <li>Then return {@link PDActionGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  @DisplayName("Test getDP(); then return PDActionGoTo")
  void testGetDP_thenReturnPDActionGoTo() throws IOException {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getDP()}.
   * <ul>
   *   <li>Then return {@link PDActionHide}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  @DisplayName("Test getDP(); then return PDActionHide")
  void testGetDP_thenReturnPDActionHide() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(new PDActionHide());

    // Act
    PDAction actualDP = pdDocumentCatalogAdditionalActions.getDP();

    // Assert
    assertTrue(actualDP instanceof PDActionHide);
    assertNull(((PDActionHide) actualDP).getT());
    assertTrue(((PDActionHide) actualDP).getH());
    assertEquals(PDActionHide.SUB_TYPE, actualDP.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getDP()}.
   * <ul>
   *   <li>Then return {@link PDActionImportData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  @DisplayName("Test getDP(); then return PDActionImportData")
  void testGetDP_thenReturnPDActionImportData() throws IOException {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getDP()}.
   * <ul>
   *   <li>Then return {@link PDActionJavaScript}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  @DisplayName("Test getDP(); then return PDActionJavaScript")
  void testGetDP_thenReturnPDActionJavaScript() {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getDP()}.
   * <ul>
   *   <li>Then return {@link PDActionLaunch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  @DisplayName("Test getDP(); then return PDActionLaunch")
  void testGetDP_thenReturnPDActionLaunch() throws IOException {
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
    assertNull(((PDActionLaunch) actualDP).getFile());
    assertNull(((PDActionLaunch) actualDP).getWinLaunchParams());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualDP).getOpenInNewWindow());
    assertEquals(PDActionLaunch.SUB_TYPE, actualDP.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getDP()}.
   * <ul>
   *   <li>Then return {@link PDActionMovie}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  @DisplayName("Test getDP(); then return PDActionMovie")
  void testGetDP_thenReturnPDActionMovie() {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getDP()}.
   * <ul>
   *   <li>Then return {@link PDActionNamed}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  @DisplayName("Test getDP(); then return PDActionNamed")
  void testGetDP_thenReturnPDActionNamed() {
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
   * Test {@link PDDocumentCatalogAdditionalActions#getDP()}.
   * <ul>
   *   <li>Then return {@link PDActionRemoteGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  @DisplayName("Test getDP(); then return PDActionRemoteGoTo")
  void testGetDP_thenReturnPDActionRemoteGoTo() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(new PDActionRemoteGoTo());

    // Act
    PDAction actualDP = pdDocumentCatalogAdditionalActions.getDP();

    // Assert
    assertTrue(actualDP instanceof PDActionRemoteGoTo);
    assertNull(((PDActionRemoteGoTo) actualDP).getD());
    assertNull(((PDActionRemoteGoTo) actualDP).getFile());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualDP).getOpenInNewWindow());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualDP.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getDP()}.
   * <ul>
   *   <li>Then return {@link PDActionResetForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  @DisplayName("Test getDP(); then return PDActionResetForm")
  void testGetDP_thenReturnPDActionResetForm() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(new PDActionResetForm());

    // Act
    PDAction actualDP = pdDocumentCatalogAdditionalActions.getDP();

    // Assert
    assertTrue(actualDP instanceof PDActionResetForm);
    assertNull(((PDActionResetForm) actualDP).getFields());
    assertEquals(0, ((PDActionResetForm) actualDP).getFlags());
    assertEquals(PDActionResetForm.SUB_TYPE, actualDP.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getDP()}.
   * <ul>
   *   <li>Then return {@link PDActionSound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  @DisplayName("Test getDP(); then return PDActionSound")
  void testGetDP_thenReturnPDActionSound() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(new PDActionSound());

    // Act
    PDAction actualDP = pdDocumentCatalogAdditionalActions.getDP();

    // Assert
    assertTrue(actualDP instanceof PDActionSound);
    assertNull(((PDActionSound) actualDP).getSound());
    assertEquals(1.0f, ((PDActionSound) actualDP).getVolume());
    assertFalse(((PDActionSound) actualDP).getMix());
    assertFalse(((PDActionSound) actualDP).getRepeat());
    assertFalse(((PDActionSound) actualDP).getSynchronous());
    assertEquals(PDActionSound.SUB_TYPE, actualDP.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getDP()}.
   * <ul>
   *   <li>Then return {@link PDActionSubmitForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  @DisplayName("Test getDP(); then return PDActionSubmitForm")
  void testGetDP_thenReturnPDActionSubmitForm() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(new PDActionSubmitForm());

    // Act
    PDAction actualDP = pdDocumentCatalogAdditionalActions.getDP();

    // Assert
    assertTrue(actualDP instanceof PDActionSubmitForm);
    assertNull(((PDActionSubmitForm) actualDP).getFields());
    assertNull(((PDActionSubmitForm) actualDP).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualDP).getFlags());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualDP.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getDP()}.
   * <ul>
   *   <li>Then return {@link PDActionThread}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  @DisplayName("Test getDP(); then return PDActionThread")
  void testGetDP_thenReturnPDActionThread() throws IOException {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions();
    pdDocumentCatalogAdditionalActions.setDP(new PDActionThread());

    // Act
    PDAction actualDP = pdDocumentCatalogAdditionalActions.getDP();

    // Assert
    assertTrue(actualDP instanceof PDActionThread);
    assertNull(((PDActionThread) actualDP).getB());
    assertNull(((PDActionThread) actualDP).getD());
    assertNull(((PDActionThread) actualDP).getFile());
    assertEquals(PDActionThread.SUB_TYPE, actualDP.getSubType());
  }

  /**
   * Test {@link PDDocumentCatalogAdditionalActions#getDP()}.
   * <ul>
   *   <li>Then return {@link PDActionURI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#getDP()}
   */
  @Test
  @DisplayName("Test getDP(); then return PDActionURI")
  void testGetDP_thenReturnPDActionURI() {
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
   * Test {@link PDDocumentCatalogAdditionalActions#setDP(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDDocumentCatalogAdditionalActions#PDDocumentCatalogAdditionalActions()}
   * DP {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#setDP(PDAction)}
   */
  @Test
  @DisplayName("Test setDP(PDAction); then PDDocumentCatalogAdditionalActions() DP PDActionEmbeddedGoTo")
  void testSetDP_thenPDDocumentCatalogAdditionalActionsDpPDActionEmbeddedGoTo() throws IOException {
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
   * Test {@link PDDocumentCatalogAdditionalActions#setDP(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDDocumentCatalogAdditionalActions#PDDocumentCatalogAdditionalActions(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} DP is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalogAdditionalActions#setDP(PDAction)}
   */
  @Test
  @DisplayName("Test setDP(PDAction); then PDDocumentCatalogAdditionalActions(COSDictionary) with a is COSDictionary() DP is 'null'")
  void testSetDP_thenPDDocumentCatalogAdditionalActionsWithAIsCOSDictionaryDpIsNull() {
    // Arrange
    PDDocumentCatalogAdditionalActions pdDocumentCatalogAdditionalActions = new PDDocumentCatalogAdditionalActions(
        new COSDictionary());

    // Act
    pdDocumentCatalogAdditionalActions.setDP(null);

    // Assert
    assertNull(pdDocumentCatalogAdditionalActions.getDP());
    COSDictionary cOSObject = pdDocumentCatalogAdditionalActions.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }
}

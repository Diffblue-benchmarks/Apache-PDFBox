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

class PDAnnotationAdditionalActionsDiffblueTest {
  /**
   * Test
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationAdditionalActions(COSDictionary)")
  void testNewPDAnnotationAdditionalActions() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDAnnotationAdditionalActions(a)).getCOSObject());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()}.
   * <p>
   * Method under test:
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()}
   */
  @Test
  @DisplayName("Test new PDAnnotationAdditionalActions()")
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

  /**
   * Test {@link PDAnnotationAdditionalActions#getCOSObject()}.
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
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
   * Test {@link PDAnnotationAdditionalActions#getE()}.
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  @DisplayName("Test getE()")
  void testGetE() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getE());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getE()}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  @DisplayName("Test getE(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  void testGetE_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
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
   * Test {@link PDAnnotationAdditionalActions#getE()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} SubType is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  @DisplayName("Test getE(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary() SubType is 'foo'")
  void testGetE_givenPDActionEmbeddedGoToWithAIsCOSDictionarySubTypeIsFoo() {
    // Arrange
    PDActionEmbeddedGoTo e = new PDActionEmbeddedGoTo(new COSDictionary());
    e.setSubType("foo");

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(e);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getE());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getE()}.
   * <ul>
   *   <li>Given
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()} E is
   * {@link PDActionURI#PDActionURI()}.</li>
   *   <li>Then return {@link PDActionURI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  @DisplayName("Test getE(); given PDAnnotationAdditionalActions() E is PDActionURI(); then return PDActionURI")
  void testGetE_givenPDAnnotationAdditionalActionsEIsPDActionURI_thenReturnPDActionURI() {
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
   * Test {@link PDAnnotationAdditionalActions#getE()}.
   * <ul>
   *   <li>Given
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  @DisplayName("Test getE(); given PDAnnotationAdditionalActions(); then return 'null'")
  void testGetE_givenPDAnnotationAdditionalActions_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationAdditionalActions()).getE());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getE()}.
   * <ul>
   *   <li>Then return {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  @DisplayName("Test getE(); then return PDActionEmbeddedGoTo")
  void testGetE_thenReturnPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualE = pdAnnotationAdditionalActions.getE();

    // Assert
    assertTrue(actualE instanceof PDActionEmbeddedGoTo);
    assertNull(((PDActionEmbeddedGoTo) actualE).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualE).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualE).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualE).getOpenInNewWindow());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualE.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getE()}.
   * <ul>
   *   <li>Then return {@link PDActionGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  @DisplayName("Test getE(); then return PDActionGoTo")
  void testGetE_thenReturnPDActionGoTo() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#getE()}.
   * <ul>
   *   <li>Then return {@link PDActionHide}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  @DisplayName("Test getE(); then return PDActionHide")
  void testGetE_thenReturnPDActionHide() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionHide());

    // Act
    PDAction actualE = pdAnnotationAdditionalActions.getE();

    // Assert
    assertTrue(actualE instanceof PDActionHide);
    assertNull(((PDActionHide) actualE).getT());
    assertTrue(((PDActionHide) actualE).getH());
    assertEquals(PDActionHide.SUB_TYPE, actualE.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getE()}.
   * <ul>
   *   <li>Then return {@link PDActionImportData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  @DisplayName("Test getE(); then return PDActionImportData")
  void testGetE_thenReturnPDActionImportData() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#getE()}.
   * <ul>
   *   <li>Then return {@link PDActionJavaScript}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  @DisplayName("Test getE(); then return PDActionJavaScript")
  void testGetE_thenReturnPDActionJavaScript() {
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
   * Test {@link PDAnnotationAdditionalActions#getE()}.
   * <ul>
   *   <li>Then return {@link PDActionLaunch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  @DisplayName("Test getE(); then return PDActionLaunch")
  void testGetE_thenReturnPDActionLaunch() throws IOException {
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
    assertNull(((PDActionLaunch) actualE).getFile());
    assertNull(((PDActionLaunch) actualE).getWinLaunchParams());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualE).getOpenInNewWindow());
    assertEquals(PDActionLaunch.SUB_TYPE, actualE.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getE()}.
   * <ul>
   *   <li>Then return {@link PDActionMovie}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  @DisplayName("Test getE(); then return PDActionMovie")
  void testGetE_thenReturnPDActionMovie() {
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
   * Test {@link PDAnnotationAdditionalActions#getE()}.
   * <ul>
   *   <li>Then return {@link PDActionNamed}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  @DisplayName("Test getE(); then return PDActionNamed")
  void testGetE_thenReturnPDActionNamed() {
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
   * Test {@link PDAnnotationAdditionalActions#getE()}.
   * <ul>
   *   <li>Then return {@link PDActionRemoteGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  @DisplayName("Test getE(); then return PDActionRemoteGoTo")
  void testGetE_thenReturnPDActionRemoteGoTo() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionRemoteGoTo());

    // Act
    PDAction actualE = pdAnnotationAdditionalActions.getE();

    // Assert
    assertTrue(actualE instanceof PDActionRemoteGoTo);
    assertNull(((PDActionRemoteGoTo) actualE).getD());
    assertNull(((PDActionRemoteGoTo) actualE).getFile());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualE).getOpenInNewWindow());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualE.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getE()}.
   * <ul>
   *   <li>Then return {@link PDActionResetForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  @DisplayName("Test getE(); then return PDActionResetForm")
  void testGetE_thenReturnPDActionResetForm() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionResetForm());

    // Act
    PDAction actualE = pdAnnotationAdditionalActions.getE();

    // Assert
    assertTrue(actualE instanceof PDActionResetForm);
    assertNull(((PDActionResetForm) actualE).getFields());
    assertEquals(0, ((PDActionResetForm) actualE).getFlags());
    assertEquals(PDActionResetForm.SUB_TYPE, actualE.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getE()}.
   * <ul>
   *   <li>Then return {@link PDActionSound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  @DisplayName("Test getE(); then return PDActionSound")
  void testGetE_thenReturnPDActionSound() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionSound());

    // Act
    PDAction actualE = pdAnnotationAdditionalActions.getE();

    // Assert
    assertTrue(actualE instanceof PDActionSound);
    assertNull(((PDActionSound) actualE).getSound());
    assertEquals(1.0f, ((PDActionSound) actualE).getVolume());
    assertFalse(((PDActionSound) actualE).getMix());
    assertFalse(((PDActionSound) actualE).getRepeat());
    assertFalse(((PDActionSound) actualE).getSynchronous());
    assertEquals(PDActionSound.SUB_TYPE, actualE.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getE()}.
   * <ul>
   *   <li>Then return {@link PDActionSubmitForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  @DisplayName("Test getE(); then return PDActionSubmitForm")
  void testGetE_thenReturnPDActionSubmitForm() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionSubmitForm());

    // Act
    PDAction actualE = pdAnnotationAdditionalActions.getE();

    // Assert
    assertTrue(actualE instanceof PDActionSubmitForm);
    assertNull(((PDActionSubmitForm) actualE).getFields());
    assertNull(((PDActionSubmitForm) actualE).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualE).getFlags());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualE.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getE()}.
   * <ul>
   *   <li>Then return {@link PDActionThread}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getE()}
   */
  @Test
  @DisplayName("Test getE(); then return PDActionThread")
  void testGetE_thenReturnPDActionThread() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionThread());

    // Act
    PDAction actualE = pdAnnotationAdditionalActions.getE();

    // Assert
    assertTrue(actualE instanceof PDActionThread);
    assertNull(((PDActionThread) actualE).getB());
    assertNull(((PDActionThread) actualE).getD());
    assertNull(((PDActionThread) actualE).getFile());
    assertEquals(PDActionThread.SUB_TYPE, actualE.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#setE(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()} E
   * {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#setE(PDAction)}
   */
  @Test
  @DisplayName("Test setE(PDAction); then PDAnnotationAdditionalActions() E PDActionEmbeddedGoTo")
  void testSetE_thenPDAnnotationAdditionalActionsEPDActionEmbeddedGoTo() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#setE(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} E is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#setE(PDAction)}
   */
  @Test
  @DisplayName("Test setE(PDAction); then PDAnnotationAdditionalActions(COSDictionary) with a is COSDictionary() E is 'null'")
  void testSetE_thenPDAnnotationAdditionalActionsWithAIsCOSDictionaryEIsNull() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions(
        new COSDictionary());

    // Act
    pdAnnotationAdditionalActions.setE(null);

    // Assert
    assertNull(pdAnnotationAdditionalActions.getE());
    COSDictionary cOSObject = pdAnnotationAdditionalActions.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getX()}.
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  @DisplayName("Test getX()")
  void testGetX() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getX());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getX()}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  @DisplayName("Test getX(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  void testGetX_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
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
   * Test {@link PDAnnotationAdditionalActions#getX()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} SubType is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  @DisplayName("Test getX(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary() SubType is 'foo'")
  void testGetX_givenPDActionEmbeddedGoToWithAIsCOSDictionarySubTypeIsFoo() {
    // Arrange
    PDActionEmbeddedGoTo x = new PDActionEmbeddedGoTo(new COSDictionary());
    x.setSubType("foo");

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(x);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getX());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getX()}.
   * <ul>
   *   <li>Given
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()} E is
   * {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  @DisplayName("Test getX(); given PDAnnotationAdditionalActions() E is PDActionEmbeddedGoTo()")
  void testGetX_givenPDAnnotationAdditionalActionsEIsPDActionEmbeddedGoTo() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionEmbeddedGoTo());

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getX());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getX()}.
   * <ul>
   *   <li>Given
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()} X is
   * {@link PDActionURI#PDActionURI()}.</li>
   *   <li>Then return {@link PDActionURI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  @DisplayName("Test getX(); given PDAnnotationAdditionalActions() X is PDActionURI(); then return PDActionURI")
  void testGetX_givenPDAnnotationAdditionalActionsXIsPDActionURI_thenReturnPDActionURI() {
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
   * Test {@link PDAnnotationAdditionalActions#getX()}.
   * <ul>
   *   <li>Given
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  @DisplayName("Test getX(); given PDAnnotationAdditionalActions(); then return 'null'")
  void testGetX_givenPDAnnotationAdditionalActions_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationAdditionalActions()).getX());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getX()}.
   * <ul>
   *   <li>Then return {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  @DisplayName("Test getX(); then return PDActionEmbeddedGoTo")
  void testGetX_thenReturnPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualX = pdAnnotationAdditionalActions.getX();

    // Assert
    assertTrue(actualX instanceof PDActionEmbeddedGoTo);
    assertNull(((PDActionEmbeddedGoTo) actualX).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualX).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualX).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualX).getOpenInNewWindow());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualX.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getX()}.
   * <ul>
   *   <li>Then return {@link PDActionGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  @DisplayName("Test getX(); then return PDActionGoTo")
  void testGetX_thenReturnPDActionGoTo() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#getX()}.
   * <ul>
   *   <li>Then return {@link PDActionHide}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  @DisplayName("Test getX(); then return PDActionHide")
  void testGetX_thenReturnPDActionHide() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(new PDActionHide());

    // Act
    PDAction actualX = pdAnnotationAdditionalActions.getX();

    // Assert
    assertTrue(actualX instanceof PDActionHide);
    assertNull(((PDActionHide) actualX).getT());
    assertTrue(((PDActionHide) actualX).getH());
    assertEquals(PDActionHide.SUB_TYPE, actualX.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getX()}.
   * <ul>
   *   <li>Then return {@link PDActionImportData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  @DisplayName("Test getX(); then return PDActionImportData")
  void testGetX_thenReturnPDActionImportData() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#getX()}.
   * <ul>
   *   <li>Then return {@link PDActionJavaScript}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  @DisplayName("Test getX(); then return PDActionJavaScript")
  void testGetX_thenReturnPDActionJavaScript() {
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
   * Test {@link PDAnnotationAdditionalActions#getX()}.
   * <ul>
   *   <li>Then return {@link PDActionLaunch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  @DisplayName("Test getX(); then return PDActionLaunch")
  void testGetX_thenReturnPDActionLaunch() throws IOException {
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
    assertNull(((PDActionLaunch) actualX).getFile());
    assertNull(((PDActionLaunch) actualX).getWinLaunchParams());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualX).getOpenInNewWindow());
    assertEquals(PDActionLaunch.SUB_TYPE, actualX.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getX()}.
   * <ul>
   *   <li>Then return {@link PDActionMovie}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  @DisplayName("Test getX(); then return PDActionMovie")
  void testGetX_thenReturnPDActionMovie() {
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
   * Test {@link PDAnnotationAdditionalActions#getX()}.
   * <ul>
   *   <li>Then return {@link PDActionNamed}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  @DisplayName("Test getX(); then return PDActionNamed")
  void testGetX_thenReturnPDActionNamed() {
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
   * Test {@link PDAnnotationAdditionalActions#getX()}.
   * <ul>
   *   <li>Then return {@link PDActionRemoteGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  @DisplayName("Test getX(); then return PDActionRemoteGoTo")
  void testGetX_thenReturnPDActionRemoteGoTo() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(new PDActionRemoteGoTo());

    // Act
    PDAction actualX = pdAnnotationAdditionalActions.getX();

    // Assert
    assertTrue(actualX instanceof PDActionRemoteGoTo);
    assertNull(((PDActionRemoteGoTo) actualX).getD());
    assertNull(((PDActionRemoteGoTo) actualX).getFile());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualX).getOpenInNewWindow());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualX.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getX()}.
   * <ul>
   *   <li>Then return {@link PDActionResetForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  @DisplayName("Test getX(); then return PDActionResetForm")
  void testGetX_thenReturnPDActionResetForm() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(new PDActionResetForm());

    // Act
    PDAction actualX = pdAnnotationAdditionalActions.getX();

    // Assert
    assertTrue(actualX instanceof PDActionResetForm);
    assertNull(((PDActionResetForm) actualX).getFields());
    assertEquals(0, ((PDActionResetForm) actualX).getFlags());
    assertEquals(PDActionResetForm.SUB_TYPE, actualX.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getX()}.
   * <ul>
   *   <li>Then return {@link PDActionSound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  @DisplayName("Test getX(); then return PDActionSound")
  void testGetX_thenReturnPDActionSound() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(new PDActionSound());

    // Act
    PDAction actualX = pdAnnotationAdditionalActions.getX();

    // Assert
    assertTrue(actualX instanceof PDActionSound);
    assertNull(((PDActionSound) actualX).getSound());
    assertEquals(1.0f, ((PDActionSound) actualX).getVolume());
    assertFalse(((PDActionSound) actualX).getMix());
    assertFalse(((PDActionSound) actualX).getRepeat());
    assertFalse(((PDActionSound) actualX).getSynchronous());
    assertEquals(PDActionSound.SUB_TYPE, actualX.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getX()}.
   * <ul>
   *   <li>Then return {@link PDActionSubmitForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  @DisplayName("Test getX(); then return PDActionSubmitForm")
  void testGetX_thenReturnPDActionSubmitForm() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(new PDActionSubmitForm());

    // Act
    PDAction actualX = pdAnnotationAdditionalActions.getX();

    // Assert
    assertTrue(actualX instanceof PDActionSubmitForm);
    assertNull(((PDActionSubmitForm) actualX).getFields());
    assertNull(((PDActionSubmitForm) actualX).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualX).getFlags());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualX.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getX()}.
   * <ul>
   *   <li>Then return {@link PDActionThread}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getX()}
   */
  @Test
  @DisplayName("Test getX(); then return PDActionThread")
  void testGetX_thenReturnPDActionThread() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setX(new PDActionThread());

    // Act
    PDAction actualX = pdAnnotationAdditionalActions.getX();

    // Assert
    assertTrue(actualX instanceof PDActionThread);
    assertNull(((PDActionThread) actualX).getB());
    assertNull(((PDActionThread) actualX).getD());
    assertNull(((PDActionThread) actualX).getFile());
    assertEquals(PDActionThread.SUB_TYPE, actualX.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#setX(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} X is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#setX(PDAction)}
   */
  @Test
  @DisplayName("Test setX(PDAction); then PDAnnotationAdditionalActions(COSDictionary) with a is COSDictionary() X is 'null'")
  void testSetX_thenPDAnnotationAdditionalActionsWithAIsCOSDictionaryXIsNull() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions(
        new COSDictionary());

    // Act
    pdAnnotationAdditionalActions.setX(null);

    // Assert
    assertNull(pdAnnotationAdditionalActions.getX());
    COSDictionary cOSObject = pdAnnotationAdditionalActions.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#setX(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()} X
   * {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#setX(PDAction)}
   */
  @Test
  @DisplayName("Test setX(PDAction); then PDAnnotationAdditionalActions() X PDActionEmbeddedGoTo")
  void testSetX_thenPDAnnotationAdditionalActionsXPDActionEmbeddedGoTo() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#getD()}.
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  @DisplayName("Test getD()")
  void testGetD() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getD());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getD()}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  @DisplayName("Test getD(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  void testGetD_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
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
   * Test {@link PDAnnotationAdditionalActions#getD()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} SubType is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  @DisplayName("Test getD(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary() SubType is 'foo'")
  void testGetD_givenPDActionEmbeddedGoToWithAIsCOSDictionarySubTypeIsFoo() {
    // Arrange
    PDActionEmbeddedGoTo d = new PDActionEmbeddedGoTo(new COSDictionary());
    d.setSubType("foo");

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(d);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getD());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getD()}.
   * <ul>
   *   <li>Given
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()} D is
   * {@link PDActionURI#PDActionURI()}.</li>
   *   <li>Then return {@link PDActionURI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  @DisplayName("Test getD(); given PDAnnotationAdditionalActions() D is PDActionURI(); then return PDActionURI")
  void testGetD_givenPDAnnotationAdditionalActionsDIsPDActionURI_thenReturnPDActionURI() {
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
   * Test {@link PDAnnotationAdditionalActions#getD()}.
   * <ul>
   *   <li>Given
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()} E is
   * {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  @DisplayName("Test getD(); given PDAnnotationAdditionalActions() E is PDActionEmbeddedGoTo()")
  void testGetD_givenPDAnnotationAdditionalActionsEIsPDActionEmbeddedGoTo() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionEmbeddedGoTo());

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getD());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getD()}.
   * <ul>
   *   <li>Given
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  @DisplayName("Test getD(); given PDAnnotationAdditionalActions(); then return 'null'")
  void testGetD_givenPDAnnotationAdditionalActions_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationAdditionalActions()).getD());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getD()}.
   * <ul>
   *   <li>Then return {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  @DisplayName("Test getD(); then return PDActionEmbeddedGoTo")
  void testGetD_thenReturnPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualD = pdAnnotationAdditionalActions.getD();

    // Assert
    assertTrue(actualD instanceof PDActionEmbeddedGoTo);
    assertNull(((PDActionEmbeddedGoTo) actualD).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualD).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualD).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualD).getOpenInNewWindow());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualD.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getD()}.
   * <ul>
   *   <li>Then return {@link PDActionGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  @DisplayName("Test getD(); then return PDActionGoTo")
  void testGetD_thenReturnPDActionGoTo() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#getD()}.
   * <ul>
   *   <li>Then return {@link PDActionHide}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  @DisplayName("Test getD(); then return PDActionHide")
  void testGetD_thenReturnPDActionHide() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(new PDActionHide());

    // Act
    PDAction actualD = pdAnnotationAdditionalActions.getD();

    // Assert
    assertTrue(actualD instanceof PDActionHide);
    assertNull(((PDActionHide) actualD).getT());
    assertTrue(((PDActionHide) actualD).getH());
    assertEquals(PDActionHide.SUB_TYPE, actualD.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getD()}.
   * <ul>
   *   <li>Then return {@link PDActionImportData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  @DisplayName("Test getD(); then return PDActionImportData")
  void testGetD_thenReturnPDActionImportData() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#getD()}.
   * <ul>
   *   <li>Then return {@link PDActionJavaScript}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  @DisplayName("Test getD(); then return PDActionJavaScript")
  void testGetD_thenReturnPDActionJavaScript() {
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
   * Test {@link PDAnnotationAdditionalActions#getD()}.
   * <ul>
   *   <li>Then return {@link PDActionLaunch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  @DisplayName("Test getD(); then return PDActionLaunch")
  void testGetD_thenReturnPDActionLaunch() throws IOException {
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
    assertNull(((PDActionLaunch) actualD).getFile());
    assertNull(((PDActionLaunch) actualD).getWinLaunchParams());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualD).getOpenInNewWindow());
    assertEquals(PDActionLaunch.SUB_TYPE, actualD.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getD()}.
   * <ul>
   *   <li>Then return {@link PDActionMovie}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  @DisplayName("Test getD(); then return PDActionMovie")
  void testGetD_thenReturnPDActionMovie() {
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
   * Test {@link PDAnnotationAdditionalActions#getD()}.
   * <ul>
   *   <li>Then return {@link PDActionNamed}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  @DisplayName("Test getD(); then return PDActionNamed")
  void testGetD_thenReturnPDActionNamed() {
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
   * Test {@link PDAnnotationAdditionalActions#getD()}.
   * <ul>
   *   <li>Then return {@link PDActionRemoteGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  @DisplayName("Test getD(); then return PDActionRemoteGoTo")
  void testGetD_thenReturnPDActionRemoteGoTo() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(new PDActionRemoteGoTo());

    // Act
    PDAction actualD = pdAnnotationAdditionalActions.getD();

    // Assert
    assertTrue(actualD instanceof PDActionRemoteGoTo);
    assertNull(((PDActionRemoteGoTo) actualD).getD());
    assertNull(((PDActionRemoteGoTo) actualD).getFile());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualD).getOpenInNewWindow());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualD.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getD()}.
   * <ul>
   *   <li>Then return {@link PDActionResetForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  @DisplayName("Test getD(); then return PDActionResetForm")
  void testGetD_thenReturnPDActionResetForm() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(new PDActionResetForm());

    // Act
    PDAction actualD = pdAnnotationAdditionalActions.getD();

    // Assert
    assertTrue(actualD instanceof PDActionResetForm);
    assertNull(((PDActionResetForm) actualD).getFields());
    assertEquals(0, ((PDActionResetForm) actualD).getFlags());
    assertEquals(PDActionResetForm.SUB_TYPE, actualD.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getD()}.
   * <ul>
   *   <li>Then return {@link PDActionSound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  @DisplayName("Test getD(); then return PDActionSound")
  void testGetD_thenReturnPDActionSound() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(new PDActionSound());

    // Act
    PDAction actualD = pdAnnotationAdditionalActions.getD();

    // Assert
    assertTrue(actualD instanceof PDActionSound);
    assertNull(((PDActionSound) actualD).getSound());
    assertEquals(1.0f, ((PDActionSound) actualD).getVolume());
    assertFalse(((PDActionSound) actualD).getMix());
    assertFalse(((PDActionSound) actualD).getRepeat());
    assertFalse(((PDActionSound) actualD).getSynchronous());
    assertEquals(PDActionSound.SUB_TYPE, actualD.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getD()}.
   * <ul>
   *   <li>Then return {@link PDActionSubmitForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  @DisplayName("Test getD(); then return PDActionSubmitForm")
  void testGetD_thenReturnPDActionSubmitForm() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(new PDActionSubmitForm());

    // Act
    PDAction actualD = pdAnnotationAdditionalActions.getD();

    // Assert
    assertTrue(actualD instanceof PDActionSubmitForm);
    assertNull(((PDActionSubmitForm) actualD).getFields());
    assertNull(((PDActionSubmitForm) actualD).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualD).getFlags());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualD.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getD()}.
   * <ul>
   *   <li>Then return {@link PDActionThread}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getD()}
   */
  @Test
  @DisplayName("Test getD(); then return PDActionThread")
  void testGetD_thenReturnPDActionThread() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setD(new PDActionThread());

    // Act
    PDAction actualD = pdAnnotationAdditionalActions.getD();

    // Assert
    assertTrue(actualD instanceof PDActionThread);
    assertNull(((PDActionThread) actualD).getB());
    assertNull(((PDActionThread) actualD).getD());
    assertNull(((PDActionThread) actualD).getFile());
    assertEquals(PDActionThread.SUB_TYPE, actualD.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#setD(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()} D
   * {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#setD(PDAction)}
   */
  @Test
  @DisplayName("Test setD(PDAction); then PDAnnotationAdditionalActions() D PDActionEmbeddedGoTo")
  void testSetD_thenPDAnnotationAdditionalActionsDPDActionEmbeddedGoTo() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#setD(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} D is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#setD(PDAction)}
   */
  @Test
  @DisplayName("Test setD(PDAction); then PDAnnotationAdditionalActions(COSDictionary) with a is COSDictionary() D is 'null'")
  void testSetD_thenPDAnnotationAdditionalActionsWithAIsCOSDictionaryDIsNull() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions(
        new COSDictionary());

    // Act
    pdAnnotationAdditionalActions.setD(null);

    // Assert
    assertNull(pdAnnotationAdditionalActions.getD());
    COSDictionary cOSObject = pdAnnotationAdditionalActions.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getU()}.
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  @DisplayName("Test getU()")
  void testGetU() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getU());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getU()}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  @DisplayName("Test getU(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  void testGetU_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
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
   * Test {@link PDAnnotationAdditionalActions#getU()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} SubType is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  @DisplayName("Test getU(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary() SubType is 'foo'")
  void testGetU_givenPDActionEmbeddedGoToWithAIsCOSDictionarySubTypeIsFoo() {
    // Arrange
    PDActionEmbeddedGoTo u = new PDActionEmbeddedGoTo(new COSDictionary());
    u.setSubType("foo");

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(u);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getU());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getU()}.
   * <ul>
   *   <li>Given
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()} E is
   * {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  @DisplayName("Test getU(); given PDAnnotationAdditionalActions() E is PDActionEmbeddedGoTo()")
  void testGetU_givenPDAnnotationAdditionalActionsEIsPDActionEmbeddedGoTo() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionEmbeddedGoTo());

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getU());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getU()}.
   * <ul>
   *   <li>Given
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()} U is
   * {@link PDActionURI#PDActionURI()}.</li>
   *   <li>Then return {@link PDActionURI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  @DisplayName("Test getU(); given PDAnnotationAdditionalActions() U is PDActionURI(); then return PDActionURI")
  void testGetU_givenPDAnnotationAdditionalActionsUIsPDActionURI_thenReturnPDActionURI() {
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
   * Test {@link PDAnnotationAdditionalActions#getU()}.
   * <ul>
   *   <li>Given
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  @DisplayName("Test getU(); given PDAnnotationAdditionalActions(); then return 'null'")
  void testGetU_givenPDAnnotationAdditionalActions_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationAdditionalActions()).getU());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getU()}.
   * <ul>
   *   <li>Then return {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  @DisplayName("Test getU(); then return PDActionEmbeddedGoTo")
  void testGetU_thenReturnPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualU = pdAnnotationAdditionalActions.getU();

    // Assert
    assertTrue(actualU instanceof PDActionEmbeddedGoTo);
    assertNull(((PDActionEmbeddedGoTo) actualU).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualU).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualU).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualU).getOpenInNewWindow());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualU.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getU()}.
   * <ul>
   *   <li>Then return {@link PDActionGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  @DisplayName("Test getU(); then return PDActionGoTo")
  void testGetU_thenReturnPDActionGoTo() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#getU()}.
   * <ul>
   *   <li>Then return {@link PDActionHide}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  @DisplayName("Test getU(); then return PDActionHide")
  void testGetU_thenReturnPDActionHide() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(new PDActionHide());

    // Act
    PDAction actualU = pdAnnotationAdditionalActions.getU();

    // Assert
    assertTrue(actualU instanceof PDActionHide);
    assertNull(((PDActionHide) actualU).getT());
    assertTrue(((PDActionHide) actualU).getH());
    assertEquals(PDActionHide.SUB_TYPE, actualU.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getU()}.
   * <ul>
   *   <li>Then return {@link PDActionImportData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  @DisplayName("Test getU(); then return PDActionImportData")
  void testGetU_thenReturnPDActionImportData() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#getU()}.
   * <ul>
   *   <li>Then return {@link PDActionJavaScript}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  @DisplayName("Test getU(); then return PDActionJavaScript")
  void testGetU_thenReturnPDActionJavaScript() {
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
   * Test {@link PDAnnotationAdditionalActions#getU()}.
   * <ul>
   *   <li>Then return {@link PDActionLaunch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  @DisplayName("Test getU(); then return PDActionLaunch")
  void testGetU_thenReturnPDActionLaunch() throws IOException {
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
    assertNull(((PDActionLaunch) actualU).getFile());
    assertNull(((PDActionLaunch) actualU).getWinLaunchParams());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualU).getOpenInNewWindow());
    assertEquals(PDActionLaunch.SUB_TYPE, actualU.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getU()}.
   * <ul>
   *   <li>Then return {@link PDActionMovie}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  @DisplayName("Test getU(); then return PDActionMovie")
  void testGetU_thenReturnPDActionMovie() {
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
   * Test {@link PDAnnotationAdditionalActions#getU()}.
   * <ul>
   *   <li>Then return {@link PDActionNamed}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  @DisplayName("Test getU(); then return PDActionNamed")
  void testGetU_thenReturnPDActionNamed() {
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
   * Test {@link PDAnnotationAdditionalActions#getU()}.
   * <ul>
   *   <li>Then return {@link PDActionRemoteGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  @DisplayName("Test getU(); then return PDActionRemoteGoTo")
  void testGetU_thenReturnPDActionRemoteGoTo() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(new PDActionRemoteGoTo());

    // Act
    PDAction actualU = pdAnnotationAdditionalActions.getU();

    // Assert
    assertTrue(actualU instanceof PDActionRemoteGoTo);
    assertNull(((PDActionRemoteGoTo) actualU).getD());
    assertNull(((PDActionRemoteGoTo) actualU).getFile());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualU).getOpenInNewWindow());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualU.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getU()}.
   * <ul>
   *   <li>Then return {@link PDActionResetForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  @DisplayName("Test getU(); then return PDActionResetForm")
  void testGetU_thenReturnPDActionResetForm() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(new PDActionResetForm());

    // Act
    PDAction actualU = pdAnnotationAdditionalActions.getU();

    // Assert
    assertTrue(actualU instanceof PDActionResetForm);
    assertNull(((PDActionResetForm) actualU).getFields());
    assertEquals(0, ((PDActionResetForm) actualU).getFlags());
    assertEquals(PDActionResetForm.SUB_TYPE, actualU.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getU()}.
   * <ul>
   *   <li>Then return {@link PDActionSound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  @DisplayName("Test getU(); then return PDActionSound")
  void testGetU_thenReturnPDActionSound() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(new PDActionSound());

    // Act
    PDAction actualU = pdAnnotationAdditionalActions.getU();

    // Assert
    assertTrue(actualU instanceof PDActionSound);
    assertNull(((PDActionSound) actualU).getSound());
    assertEquals(1.0f, ((PDActionSound) actualU).getVolume());
    assertFalse(((PDActionSound) actualU).getMix());
    assertFalse(((PDActionSound) actualU).getRepeat());
    assertFalse(((PDActionSound) actualU).getSynchronous());
    assertEquals(PDActionSound.SUB_TYPE, actualU.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getU()}.
   * <ul>
   *   <li>Then return {@link PDActionSubmitForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  @DisplayName("Test getU(); then return PDActionSubmitForm")
  void testGetU_thenReturnPDActionSubmitForm() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(new PDActionSubmitForm());

    // Act
    PDAction actualU = pdAnnotationAdditionalActions.getU();

    // Assert
    assertTrue(actualU instanceof PDActionSubmitForm);
    assertNull(((PDActionSubmitForm) actualU).getFields());
    assertNull(((PDActionSubmitForm) actualU).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualU).getFlags());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualU.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getU()}.
   * <ul>
   *   <li>Then return {@link PDActionThread}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getU()}
   */
  @Test
  @DisplayName("Test getU(); then return PDActionThread")
  void testGetU_thenReturnPDActionThread() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setU(new PDActionThread());

    // Act
    PDAction actualU = pdAnnotationAdditionalActions.getU();

    // Assert
    assertTrue(actualU instanceof PDActionThread);
    assertNull(((PDActionThread) actualU).getB());
    assertNull(((PDActionThread) actualU).getD());
    assertNull(((PDActionThread) actualU).getFile());
    assertEquals(PDActionThread.SUB_TYPE, actualU.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#setU(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()} U
   * {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#setU(PDAction)}
   */
  @Test
  @DisplayName("Test setU(PDAction); then PDAnnotationAdditionalActions() U PDActionEmbeddedGoTo")
  void testSetU_thenPDAnnotationAdditionalActionsUPDActionEmbeddedGoTo() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#setU(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} U is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#setU(PDAction)}
   */
  @Test
  @DisplayName("Test setU(PDAction); then PDAnnotationAdditionalActions(COSDictionary) with a is COSDictionary() U is 'null'")
  void testSetU_thenPDAnnotationAdditionalActionsWithAIsCOSDictionaryUIsNull() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions(
        new COSDictionary());

    // Act
    pdAnnotationAdditionalActions.setU(null);

    // Assert
    assertNull(pdAnnotationAdditionalActions.getU());
    COSDictionary cOSObject = pdAnnotationAdditionalActions.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getFo()}.
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  @DisplayName("Test getFo()")
  void testGetFo() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getFo());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getFo()}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  @DisplayName("Test getFo(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  void testGetFo_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
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
   * Test {@link PDAnnotationAdditionalActions#getFo()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} SubType is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  @DisplayName("Test getFo(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary() SubType is 'foo'")
  void testGetFo_givenPDActionEmbeddedGoToWithAIsCOSDictionarySubTypeIsFoo() {
    // Arrange
    PDActionEmbeddedGoTo fo = new PDActionEmbeddedGoTo(new COSDictionary());
    fo.setSubType("foo");

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(fo);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getFo());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getFo()}.
   * <ul>
   *   <li>Given
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()} E is
   * {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  @DisplayName("Test getFo(); given PDAnnotationAdditionalActions() E is PDActionEmbeddedGoTo()")
  void testGetFo_givenPDAnnotationAdditionalActionsEIsPDActionEmbeddedGoTo() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionEmbeddedGoTo());

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getFo());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getFo()}.
   * <ul>
   *   <li>Given
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  @DisplayName("Test getFo(); given PDAnnotationAdditionalActions(); then return 'null'")
  void testGetFo_givenPDAnnotationAdditionalActions_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationAdditionalActions()).getFo());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getFo()}.
   * <ul>
   *   <li>Then return {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  @DisplayName("Test getFo(); then return PDActionEmbeddedGoTo")
  void testGetFo_thenReturnPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualFo = pdAnnotationAdditionalActions.getFo();

    // Assert
    assertTrue(actualFo instanceof PDActionEmbeddedGoTo);
    assertNull(((PDActionEmbeddedGoTo) actualFo).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualFo).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualFo).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualFo).getOpenInNewWindow());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualFo.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getFo()}.
   * <ul>
   *   <li>Then return {@link PDActionGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  @DisplayName("Test getFo(); then return PDActionGoTo")
  void testGetFo_thenReturnPDActionGoTo() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#getFo()}.
   * <ul>
   *   <li>Then return {@link PDActionHide}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  @DisplayName("Test getFo(); then return PDActionHide")
  void testGetFo_thenReturnPDActionHide() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(new PDActionHide());

    // Act
    PDAction actualFo = pdAnnotationAdditionalActions.getFo();

    // Assert
    assertTrue(actualFo instanceof PDActionHide);
    assertNull(((PDActionHide) actualFo).getT());
    assertTrue(((PDActionHide) actualFo).getH());
    assertEquals(PDActionHide.SUB_TYPE, actualFo.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getFo()}.
   * <ul>
   *   <li>Then return {@link PDActionImportData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  @DisplayName("Test getFo(); then return PDActionImportData")
  void testGetFo_thenReturnPDActionImportData() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#getFo()}.
   * <ul>
   *   <li>Then return {@link PDActionJavaScript}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  @DisplayName("Test getFo(); then return PDActionJavaScript")
  void testGetFo_thenReturnPDActionJavaScript() {
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
   * Test {@link PDAnnotationAdditionalActions#getFo()}.
   * <ul>
   *   <li>Then return {@link PDActionLaunch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  @DisplayName("Test getFo(); then return PDActionLaunch")
  void testGetFo_thenReturnPDActionLaunch() throws IOException {
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
    assertNull(((PDActionLaunch) actualFo).getFile());
    assertNull(((PDActionLaunch) actualFo).getWinLaunchParams());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualFo).getOpenInNewWindow());
    assertEquals(PDActionLaunch.SUB_TYPE, actualFo.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getFo()}.
   * <ul>
   *   <li>Then return {@link PDActionMovie}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  @DisplayName("Test getFo(); then return PDActionMovie")
  void testGetFo_thenReturnPDActionMovie() {
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
   * Test {@link PDAnnotationAdditionalActions#getFo()}.
   * <ul>
   *   <li>Then return {@link PDActionNamed}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  @DisplayName("Test getFo(); then return PDActionNamed")
  void testGetFo_thenReturnPDActionNamed() {
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
   * Test {@link PDAnnotationAdditionalActions#getFo()}.
   * <ul>
   *   <li>Then return {@link PDActionRemoteGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  @DisplayName("Test getFo(); then return PDActionRemoteGoTo")
  void testGetFo_thenReturnPDActionRemoteGoTo() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(new PDActionRemoteGoTo());

    // Act
    PDAction actualFo = pdAnnotationAdditionalActions.getFo();

    // Assert
    assertTrue(actualFo instanceof PDActionRemoteGoTo);
    assertNull(((PDActionRemoteGoTo) actualFo).getD());
    assertNull(((PDActionRemoteGoTo) actualFo).getFile());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualFo).getOpenInNewWindow());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualFo.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getFo()}.
   * <ul>
   *   <li>Then return {@link PDActionResetForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  @DisplayName("Test getFo(); then return PDActionResetForm")
  void testGetFo_thenReturnPDActionResetForm() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(new PDActionResetForm());

    // Act
    PDAction actualFo = pdAnnotationAdditionalActions.getFo();

    // Assert
    assertTrue(actualFo instanceof PDActionResetForm);
    assertNull(((PDActionResetForm) actualFo).getFields());
    assertEquals(0, ((PDActionResetForm) actualFo).getFlags());
    assertEquals(PDActionResetForm.SUB_TYPE, actualFo.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getFo()}.
   * <ul>
   *   <li>Then return {@link PDActionSound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  @DisplayName("Test getFo(); then return PDActionSound")
  void testGetFo_thenReturnPDActionSound() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(new PDActionSound());

    // Act
    PDAction actualFo = pdAnnotationAdditionalActions.getFo();

    // Assert
    assertTrue(actualFo instanceof PDActionSound);
    assertNull(((PDActionSound) actualFo).getSound());
    assertEquals(1.0f, ((PDActionSound) actualFo).getVolume());
    assertFalse(((PDActionSound) actualFo).getMix());
    assertFalse(((PDActionSound) actualFo).getRepeat());
    assertFalse(((PDActionSound) actualFo).getSynchronous());
    assertEquals(PDActionSound.SUB_TYPE, actualFo.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getFo()}.
   * <ul>
   *   <li>Then return {@link PDActionSubmitForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  @DisplayName("Test getFo(); then return PDActionSubmitForm")
  void testGetFo_thenReturnPDActionSubmitForm() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(new PDActionSubmitForm());

    // Act
    PDAction actualFo = pdAnnotationAdditionalActions.getFo();

    // Assert
    assertTrue(actualFo instanceof PDActionSubmitForm);
    assertNull(((PDActionSubmitForm) actualFo).getFields());
    assertNull(((PDActionSubmitForm) actualFo).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualFo).getFlags());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualFo.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getFo()}.
   * <ul>
   *   <li>Then return {@link PDActionThread}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  @DisplayName("Test getFo(); then return PDActionThread")
  void testGetFo_thenReturnPDActionThread() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setFo(new PDActionThread());

    // Act
    PDAction actualFo = pdAnnotationAdditionalActions.getFo();

    // Assert
    assertTrue(actualFo instanceof PDActionThread);
    assertNull(((PDActionThread) actualFo).getB());
    assertNull(((PDActionThread) actualFo).getD());
    assertNull(((PDActionThread) actualFo).getFile());
    assertEquals(PDActionThread.SUB_TYPE, actualFo.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getFo()}.
   * <ul>
   *   <li>Then return {@link PDActionURI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getFo()}
   */
  @Test
  @DisplayName("Test getFo(); then return PDActionURI")
  void testGetFo_thenReturnPDActionURI() {
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
   * Test {@link PDAnnotationAdditionalActions#setFo(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()} Fo
   * {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#setFo(PDAction)}
   */
  @Test
  @DisplayName("Test setFo(PDAction); then PDAnnotationAdditionalActions() Fo PDActionEmbeddedGoTo")
  void testSetFo_thenPDAnnotationAdditionalActionsFoPDActionEmbeddedGoTo() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#setFo(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} Fo is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#setFo(PDAction)}
   */
  @Test
  @DisplayName("Test setFo(PDAction); then PDAnnotationAdditionalActions(COSDictionary) with a is COSDictionary() Fo is 'null'")
  void testSetFo_thenPDAnnotationAdditionalActionsWithAIsCOSDictionaryFoIsNull() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions(
        new COSDictionary());

    // Act
    pdAnnotationAdditionalActions.setFo(null);

    // Assert
    assertNull(pdAnnotationAdditionalActions.getFo());
    COSDictionary cOSObject = pdAnnotationAdditionalActions.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getBl()}.
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  @DisplayName("Test getBl()")
  void testGetBl() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getBl());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getBl()}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  @DisplayName("Test getBl(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  void testGetBl_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
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
   * Test {@link PDAnnotationAdditionalActions#getBl()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} SubType is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  @DisplayName("Test getBl(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary() SubType is 'foo'")
  void testGetBl_givenPDActionEmbeddedGoToWithAIsCOSDictionarySubTypeIsFoo() {
    // Arrange
    PDActionEmbeddedGoTo bl = new PDActionEmbeddedGoTo(new COSDictionary());
    bl.setSubType("foo");

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(bl);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getBl());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getBl()}.
   * <ul>
   *   <li>Given
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()} E is
   * {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  @DisplayName("Test getBl(); given PDAnnotationAdditionalActions() E is PDActionEmbeddedGoTo()")
  void testGetBl_givenPDAnnotationAdditionalActionsEIsPDActionEmbeddedGoTo() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionEmbeddedGoTo());

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getBl());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getBl()}.
   * <ul>
   *   <li>Given
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  @DisplayName("Test getBl(); given PDAnnotationAdditionalActions(); then return 'null'")
  void testGetBl_givenPDAnnotationAdditionalActions_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationAdditionalActions()).getBl());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getBl()}.
   * <ul>
   *   <li>Then return {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  @DisplayName("Test getBl(); then return PDActionEmbeddedGoTo")
  void testGetBl_thenReturnPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualBl = pdAnnotationAdditionalActions.getBl();

    // Assert
    assertTrue(actualBl instanceof PDActionEmbeddedGoTo);
    assertNull(((PDActionEmbeddedGoTo) actualBl).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualBl).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualBl).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualBl).getOpenInNewWindow());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualBl.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getBl()}.
   * <ul>
   *   <li>Then return {@link PDActionGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  @DisplayName("Test getBl(); then return PDActionGoTo")
  void testGetBl_thenReturnPDActionGoTo() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#getBl()}.
   * <ul>
   *   <li>Then return {@link PDActionHide}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  @DisplayName("Test getBl(); then return PDActionHide")
  void testGetBl_thenReturnPDActionHide() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(new PDActionHide());

    // Act
    PDAction actualBl = pdAnnotationAdditionalActions.getBl();

    // Assert
    assertTrue(actualBl instanceof PDActionHide);
    assertNull(((PDActionHide) actualBl).getT());
    assertTrue(((PDActionHide) actualBl).getH());
    assertEquals(PDActionHide.SUB_TYPE, actualBl.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getBl()}.
   * <ul>
   *   <li>Then return {@link PDActionImportData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  @DisplayName("Test getBl(); then return PDActionImportData")
  void testGetBl_thenReturnPDActionImportData() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#getBl()}.
   * <ul>
   *   <li>Then return {@link PDActionJavaScript}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  @DisplayName("Test getBl(); then return PDActionJavaScript")
  void testGetBl_thenReturnPDActionJavaScript() {
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
   * Test {@link PDAnnotationAdditionalActions#getBl()}.
   * <ul>
   *   <li>Then return {@link PDActionLaunch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  @DisplayName("Test getBl(); then return PDActionLaunch")
  void testGetBl_thenReturnPDActionLaunch() throws IOException {
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
    assertNull(((PDActionLaunch) actualBl).getFile());
    assertNull(((PDActionLaunch) actualBl).getWinLaunchParams());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualBl).getOpenInNewWindow());
    assertEquals(PDActionLaunch.SUB_TYPE, actualBl.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getBl()}.
   * <ul>
   *   <li>Then return {@link PDActionMovie}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  @DisplayName("Test getBl(); then return PDActionMovie")
  void testGetBl_thenReturnPDActionMovie() {
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
   * Test {@link PDAnnotationAdditionalActions#getBl()}.
   * <ul>
   *   <li>Then return {@link PDActionNamed}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  @DisplayName("Test getBl(); then return PDActionNamed")
  void testGetBl_thenReturnPDActionNamed() {
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
   * Test {@link PDAnnotationAdditionalActions#getBl()}.
   * <ul>
   *   <li>Then return {@link PDActionRemoteGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  @DisplayName("Test getBl(); then return PDActionRemoteGoTo")
  void testGetBl_thenReturnPDActionRemoteGoTo() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(new PDActionRemoteGoTo());

    // Act
    PDAction actualBl = pdAnnotationAdditionalActions.getBl();

    // Assert
    assertTrue(actualBl instanceof PDActionRemoteGoTo);
    assertNull(((PDActionRemoteGoTo) actualBl).getD());
    assertNull(((PDActionRemoteGoTo) actualBl).getFile());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualBl).getOpenInNewWindow());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualBl.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getBl()}.
   * <ul>
   *   <li>Then return {@link PDActionResetForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  @DisplayName("Test getBl(); then return PDActionResetForm")
  void testGetBl_thenReturnPDActionResetForm() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(new PDActionResetForm());

    // Act
    PDAction actualBl = pdAnnotationAdditionalActions.getBl();

    // Assert
    assertTrue(actualBl instanceof PDActionResetForm);
    assertNull(((PDActionResetForm) actualBl).getFields());
    assertEquals(0, ((PDActionResetForm) actualBl).getFlags());
    assertEquals(PDActionResetForm.SUB_TYPE, actualBl.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getBl()}.
   * <ul>
   *   <li>Then return {@link PDActionSound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  @DisplayName("Test getBl(); then return PDActionSound")
  void testGetBl_thenReturnPDActionSound() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(new PDActionSound());

    // Act
    PDAction actualBl = pdAnnotationAdditionalActions.getBl();

    // Assert
    assertTrue(actualBl instanceof PDActionSound);
    assertNull(((PDActionSound) actualBl).getSound());
    assertEquals(1.0f, ((PDActionSound) actualBl).getVolume());
    assertFalse(((PDActionSound) actualBl).getMix());
    assertFalse(((PDActionSound) actualBl).getRepeat());
    assertFalse(((PDActionSound) actualBl).getSynchronous());
    assertEquals(PDActionSound.SUB_TYPE, actualBl.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getBl()}.
   * <ul>
   *   <li>Then return {@link PDActionSubmitForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  @DisplayName("Test getBl(); then return PDActionSubmitForm")
  void testGetBl_thenReturnPDActionSubmitForm() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(new PDActionSubmitForm());

    // Act
    PDAction actualBl = pdAnnotationAdditionalActions.getBl();

    // Assert
    assertTrue(actualBl instanceof PDActionSubmitForm);
    assertNull(((PDActionSubmitForm) actualBl).getFields());
    assertNull(((PDActionSubmitForm) actualBl).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualBl).getFlags());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualBl.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getBl()}.
   * <ul>
   *   <li>Then return {@link PDActionThread}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  @DisplayName("Test getBl(); then return PDActionThread")
  void testGetBl_thenReturnPDActionThread() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setBl(new PDActionThread());

    // Act
    PDAction actualBl = pdAnnotationAdditionalActions.getBl();

    // Assert
    assertTrue(actualBl instanceof PDActionThread);
    assertNull(((PDActionThread) actualBl).getB());
    assertNull(((PDActionThread) actualBl).getD());
    assertNull(((PDActionThread) actualBl).getFile());
    assertEquals(PDActionThread.SUB_TYPE, actualBl.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getBl()}.
   * <ul>
   *   <li>Then return {@link PDActionURI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getBl()}
   */
  @Test
  @DisplayName("Test getBl(); then return PDActionURI")
  void testGetBl_thenReturnPDActionURI() {
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
   * Test {@link PDAnnotationAdditionalActions#setBl(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()} Bl
   * {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#setBl(PDAction)}
   */
  @Test
  @DisplayName("Test setBl(PDAction); then PDAnnotationAdditionalActions() Bl PDActionEmbeddedGoTo")
  void testSetBl_thenPDAnnotationAdditionalActionsBlPDActionEmbeddedGoTo() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#setBl(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} Bl is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#setBl(PDAction)}
   */
  @Test
  @DisplayName("Test setBl(PDAction); then PDAnnotationAdditionalActions(COSDictionary) with a is COSDictionary() Bl is 'null'")
  void testSetBl_thenPDAnnotationAdditionalActionsWithAIsCOSDictionaryBlIsNull() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions(
        new COSDictionary());

    // Act
    pdAnnotationAdditionalActions.setBl(null);

    // Assert
    assertNull(pdAnnotationAdditionalActions.getBl());
    COSDictionary cOSObject = pdAnnotationAdditionalActions.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPO()}.
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  @DisplayName("Test getPO()")
  void testGetPO() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getPO());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPO()}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  @DisplayName("Test getPO(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  void testGetPO_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
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
   * Test {@link PDAnnotationAdditionalActions#getPO()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} SubType is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  @DisplayName("Test getPO(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary() SubType is 'foo'")
  void testGetPO_givenPDActionEmbeddedGoToWithAIsCOSDictionarySubTypeIsFoo() {
    // Arrange
    PDActionEmbeddedGoTo po = new PDActionEmbeddedGoTo(new COSDictionary());
    po.setSubType("foo");

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(po);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getPO());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPO()}.
   * <ul>
   *   <li>Given
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()} E is
   * {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  @DisplayName("Test getPO(); given PDAnnotationAdditionalActions() E is PDActionEmbeddedGoTo()")
  void testGetPO_givenPDAnnotationAdditionalActionsEIsPDActionEmbeddedGoTo() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionEmbeddedGoTo());

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getPO());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPO()}.
   * <ul>
   *   <li>Given
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  @DisplayName("Test getPO(); given PDAnnotationAdditionalActions(); then return 'null'")
  void testGetPO_givenPDAnnotationAdditionalActions_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationAdditionalActions()).getPO());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPO()}.
   * <ul>
   *   <li>Then return {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  @DisplayName("Test getPO(); then return PDActionEmbeddedGoTo")
  void testGetPO_thenReturnPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualPO = pdAnnotationAdditionalActions.getPO();

    // Assert
    assertTrue(actualPO instanceof PDActionEmbeddedGoTo);
    assertNull(((PDActionEmbeddedGoTo) actualPO).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualPO).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualPO).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualPO).getOpenInNewWindow());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualPO.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPO()}.
   * <ul>
   *   <li>Then return {@link PDActionGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  @DisplayName("Test getPO(); then return PDActionGoTo")
  void testGetPO_thenReturnPDActionGoTo() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#getPO()}.
   * <ul>
   *   <li>Then return {@link PDActionHide}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  @DisplayName("Test getPO(); then return PDActionHide")
  void testGetPO_thenReturnPDActionHide() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(new PDActionHide());

    // Act
    PDAction actualPO = pdAnnotationAdditionalActions.getPO();

    // Assert
    assertTrue(actualPO instanceof PDActionHide);
    assertNull(((PDActionHide) actualPO).getT());
    assertTrue(((PDActionHide) actualPO).getH());
    assertEquals(PDActionHide.SUB_TYPE, actualPO.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPO()}.
   * <ul>
   *   <li>Then return {@link PDActionImportData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  @DisplayName("Test getPO(); then return PDActionImportData")
  void testGetPO_thenReturnPDActionImportData() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#getPO()}.
   * <ul>
   *   <li>Then return {@link PDActionJavaScript}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  @DisplayName("Test getPO(); then return PDActionJavaScript")
  void testGetPO_thenReturnPDActionJavaScript() {
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
   * Test {@link PDAnnotationAdditionalActions#getPO()}.
   * <ul>
   *   <li>Then return {@link PDActionLaunch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  @DisplayName("Test getPO(); then return PDActionLaunch")
  void testGetPO_thenReturnPDActionLaunch() throws IOException {
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
    assertNull(((PDActionLaunch) actualPO).getFile());
    assertNull(((PDActionLaunch) actualPO).getWinLaunchParams());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualPO).getOpenInNewWindow());
    assertEquals(PDActionLaunch.SUB_TYPE, actualPO.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPO()}.
   * <ul>
   *   <li>Then return {@link PDActionMovie}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  @DisplayName("Test getPO(); then return PDActionMovie")
  void testGetPO_thenReturnPDActionMovie() {
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
   * Test {@link PDAnnotationAdditionalActions#getPO()}.
   * <ul>
   *   <li>Then return {@link PDActionNamed}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  @DisplayName("Test getPO(); then return PDActionNamed")
  void testGetPO_thenReturnPDActionNamed() {
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
   * Test {@link PDAnnotationAdditionalActions#getPO()}.
   * <ul>
   *   <li>Then return {@link PDActionRemoteGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  @DisplayName("Test getPO(); then return PDActionRemoteGoTo")
  void testGetPO_thenReturnPDActionRemoteGoTo() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(new PDActionRemoteGoTo());

    // Act
    PDAction actualPO = pdAnnotationAdditionalActions.getPO();

    // Assert
    assertTrue(actualPO instanceof PDActionRemoteGoTo);
    assertNull(((PDActionRemoteGoTo) actualPO).getD());
    assertNull(((PDActionRemoteGoTo) actualPO).getFile());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualPO).getOpenInNewWindow());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualPO.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPO()}.
   * <ul>
   *   <li>Then return {@link PDActionResetForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  @DisplayName("Test getPO(); then return PDActionResetForm")
  void testGetPO_thenReturnPDActionResetForm() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(new PDActionResetForm());

    // Act
    PDAction actualPO = pdAnnotationAdditionalActions.getPO();

    // Assert
    assertTrue(actualPO instanceof PDActionResetForm);
    assertNull(((PDActionResetForm) actualPO).getFields());
    assertEquals(0, ((PDActionResetForm) actualPO).getFlags());
    assertEquals(PDActionResetForm.SUB_TYPE, actualPO.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPO()}.
   * <ul>
   *   <li>Then return {@link PDActionSound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  @DisplayName("Test getPO(); then return PDActionSound")
  void testGetPO_thenReturnPDActionSound() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(new PDActionSound());

    // Act
    PDAction actualPO = pdAnnotationAdditionalActions.getPO();

    // Assert
    assertTrue(actualPO instanceof PDActionSound);
    assertNull(((PDActionSound) actualPO).getSound());
    assertEquals(1.0f, ((PDActionSound) actualPO).getVolume());
    assertFalse(((PDActionSound) actualPO).getMix());
    assertFalse(((PDActionSound) actualPO).getRepeat());
    assertFalse(((PDActionSound) actualPO).getSynchronous());
    assertEquals(PDActionSound.SUB_TYPE, actualPO.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPO()}.
   * <ul>
   *   <li>Then return {@link PDActionSubmitForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  @DisplayName("Test getPO(); then return PDActionSubmitForm")
  void testGetPO_thenReturnPDActionSubmitForm() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(new PDActionSubmitForm());

    // Act
    PDAction actualPO = pdAnnotationAdditionalActions.getPO();

    // Assert
    assertTrue(actualPO instanceof PDActionSubmitForm);
    assertNull(((PDActionSubmitForm) actualPO).getFields());
    assertNull(((PDActionSubmitForm) actualPO).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualPO).getFlags());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualPO.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPO()}.
   * <ul>
   *   <li>Then return {@link PDActionThread}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  @DisplayName("Test getPO(); then return PDActionThread")
  void testGetPO_thenReturnPDActionThread() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPO(new PDActionThread());

    // Act
    PDAction actualPO = pdAnnotationAdditionalActions.getPO();

    // Assert
    assertTrue(actualPO instanceof PDActionThread);
    assertNull(((PDActionThread) actualPO).getB());
    assertNull(((PDActionThread) actualPO).getD());
    assertNull(((PDActionThread) actualPO).getFile());
    assertEquals(PDActionThread.SUB_TYPE, actualPO.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPO()}.
   * <ul>
   *   <li>Then return {@link PDActionURI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPO()}
   */
  @Test
  @DisplayName("Test getPO(); then return PDActionURI")
  void testGetPO_thenReturnPDActionURI() {
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
   * Test {@link PDAnnotationAdditionalActions#setPO(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()} PO
   * {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#setPO(PDAction)}
   */
  @Test
  @DisplayName("Test setPO(PDAction); then PDAnnotationAdditionalActions() PO PDActionEmbeddedGoTo")
  void testSetPO_thenPDAnnotationAdditionalActionsPoPDActionEmbeddedGoTo() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#setPO(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} PO is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#setPO(PDAction)}
   */
  @Test
  @DisplayName("Test setPO(PDAction); then PDAnnotationAdditionalActions(COSDictionary) with a is COSDictionary() PO is 'null'")
  void testSetPO_thenPDAnnotationAdditionalActionsWithAIsCOSDictionaryPoIsNull() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions(
        new COSDictionary());

    // Act
    pdAnnotationAdditionalActions.setPO(null);

    // Assert
    assertNull(pdAnnotationAdditionalActions.getPO());
    COSDictionary cOSObject = pdAnnotationAdditionalActions.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPC()}.
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  @DisplayName("Test getPC()")
  void testGetPC() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getPC());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPC()}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  @DisplayName("Test getPC(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  void testGetPC_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
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
   * Test {@link PDAnnotationAdditionalActions#getPC()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} SubType is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  @DisplayName("Test getPC(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary() SubType is 'foo'")
  void testGetPC_givenPDActionEmbeddedGoToWithAIsCOSDictionarySubTypeIsFoo() {
    // Arrange
    PDActionEmbeddedGoTo pc = new PDActionEmbeddedGoTo(new COSDictionary());
    pc.setSubType("foo");

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(pc);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getPC());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPC()}.
   * <ul>
   *   <li>Given
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()} E is
   * {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  @DisplayName("Test getPC(); given PDAnnotationAdditionalActions() E is PDActionEmbeddedGoTo()")
  void testGetPC_givenPDAnnotationAdditionalActionsEIsPDActionEmbeddedGoTo() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionEmbeddedGoTo());

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getPC());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPC()}.
   * <ul>
   *   <li>Given
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  @DisplayName("Test getPC(); given PDAnnotationAdditionalActions(); then return 'null'")
  void testGetPC_givenPDAnnotationAdditionalActions_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationAdditionalActions()).getPC());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPC()}.
   * <ul>
   *   <li>Then return {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  @DisplayName("Test getPC(); then return PDActionEmbeddedGoTo")
  void testGetPC_thenReturnPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualPC = pdAnnotationAdditionalActions.getPC();

    // Assert
    assertTrue(actualPC instanceof PDActionEmbeddedGoTo);
    assertNull(((PDActionEmbeddedGoTo) actualPC).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualPC).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualPC).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualPC).getOpenInNewWindow());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualPC.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPC()}.
   * <ul>
   *   <li>Then return {@link PDActionGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  @DisplayName("Test getPC(); then return PDActionGoTo")
  void testGetPC_thenReturnPDActionGoTo() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#getPC()}.
   * <ul>
   *   <li>Then return {@link PDActionHide}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  @DisplayName("Test getPC(); then return PDActionHide")
  void testGetPC_thenReturnPDActionHide() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(new PDActionHide());

    // Act
    PDAction actualPC = pdAnnotationAdditionalActions.getPC();

    // Assert
    assertTrue(actualPC instanceof PDActionHide);
    assertNull(((PDActionHide) actualPC).getT());
    assertTrue(((PDActionHide) actualPC).getH());
    assertEquals(PDActionHide.SUB_TYPE, actualPC.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPC()}.
   * <ul>
   *   <li>Then return {@link PDActionImportData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  @DisplayName("Test getPC(); then return PDActionImportData")
  void testGetPC_thenReturnPDActionImportData() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#getPC()}.
   * <ul>
   *   <li>Then return {@link PDActionJavaScript}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  @DisplayName("Test getPC(); then return PDActionJavaScript")
  void testGetPC_thenReturnPDActionJavaScript() {
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
   * Test {@link PDAnnotationAdditionalActions#getPC()}.
   * <ul>
   *   <li>Then return {@link PDActionLaunch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  @DisplayName("Test getPC(); then return PDActionLaunch")
  void testGetPC_thenReturnPDActionLaunch() throws IOException {
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
    assertNull(((PDActionLaunch) actualPC).getFile());
    assertNull(((PDActionLaunch) actualPC).getWinLaunchParams());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualPC).getOpenInNewWindow());
    assertEquals(PDActionLaunch.SUB_TYPE, actualPC.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPC()}.
   * <ul>
   *   <li>Then return {@link PDActionMovie}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  @DisplayName("Test getPC(); then return PDActionMovie")
  void testGetPC_thenReturnPDActionMovie() {
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
   * Test {@link PDAnnotationAdditionalActions#getPC()}.
   * <ul>
   *   <li>Then return {@link PDActionNamed}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  @DisplayName("Test getPC(); then return PDActionNamed")
  void testGetPC_thenReturnPDActionNamed() {
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
   * Test {@link PDAnnotationAdditionalActions#getPC()}.
   * <ul>
   *   <li>Then return {@link PDActionRemoteGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  @DisplayName("Test getPC(); then return PDActionRemoteGoTo")
  void testGetPC_thenReturnPDActionRemoteGoTo() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(new PDActionRemoteGoTo());

    // Act
    PDAction actualPC = pdAnnotationAdditionalActions.getPC();

    // Assert
    assertTrue(actualPC instanceof PDActionRemoteGoTo);
    assertNull(((PDActionRemoteGoTo) actualPC).getD());
    assertNull(((PDActionRemoteGoTo) actualPC).getFile());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualPC).getOpenInNewWindow());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualPC.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPC()}.
   * <ul>
   *   <li>Then return {@link PDActionResetForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  @DisplayName("Test getPC(); then return PDActionResetForm")
  void testGetPC_thenReturnPDActionResetForm() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(new PDActionResetForm());

    // Act
    PDAction actualPC = pdAnnotationAdditionalActions.getPC();

    // Assert
    assertTrue(actualPC instanceof PDActionResetForm);
    assertNull(((PDActionResetForm) actualPC).getFields());
    assertEquals(0, ((PDActionResetForm) actualPC).getFlags());
    assertEquals(PDActionResetForm.SUB_TYPE, actualPC.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPC()}.
   * <ul>
   *   <li>Then return {@link PDActionSound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  @DisplayName("Test getPC(); then return PDActionSound")
  void testGetPC_thenReturnPDActionSound() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(new PDActionSound());

    // Act
    PDAction actualPC = pdAnnotationAdditionalActions.getPC();

    // Assert
    assertTrue(actualPC instanceof PDActionSound);
    assertNull(((PDActionSound) actualPC).getSound());
    assertEquals(1.0f, ((PDActionSound) actualPC).getVolume());
    assertFalse(((PDActionSound) actualPC).getMix());
    assertFalse(((PDActionSound) actualPC).getRepeat());
    assertFalse(((PDActionSound) actualPC).getSynchronous());
    assertEquals(PDActionSound.SUB_TYPE, actualPC.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPC()}.
   * <ul>
   *   <li>Then return {@link PDActionSubmitForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  @DisplayName("Test getPC(); then return PDActionSubmitForm")
  void testGetPC_thenReturnPDActionSubmitForm() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(new PDActionSubmitForm());

    // Act
    PDAction actualPC = pdAnnotationAdditionalActions.getPC();

    // Assert
    assertTrue(actualPC instanceof PDActionSubmitForm);
    assertNull(((PDActionSubmitForm) actualPC).getFields());
    assertNull(((PDActionSubmitForm) actualPC).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualPC).getFlags());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualPC.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPC()}.
   * <ul>
   *   <li>Then return {@link PDActionThread}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  @DisplayName("Test getPC(); then return PDActionThread")
  void testGetPC_thenReturnPDActionThread() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPC(new PDActionThread());

    // Act
    PDAction actualPC = pdAnnotationAdditionalActions.getPC();

    // Assert
    assertTrue(actualPC instanceof PDActionThread);
    assertNull(((PDActionThread) actualPC).getB());
    assertNull(((PDActionThread) actualPC).getD());
    assertNull(((PDActionThread) actualPC).getFile());
    assertEquals(PDActionThread.SUB_TYPE, actualPC.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPC()}.
   * <ul>
   *   <li>Then return {@link PDActionURI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPC()}
   */
  @Test
  @DisplayName("Test getPC(); then return PDActionURI")
  void testGetPC_thenReturnPDActionURI() {
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
   * Test {@link PDAnnotationAdditionalActions#setPC(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()} PC
   * {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#setPC(PDAction)}
   */
  @Test
  @DisplayName("Test setPC(PDAction); then PDAnnotationAdditionalActions() PC PDActionEmbeddedGoTo")
  void testSetPC_thenPDAnnotationAdditionalActionsPcPDActionEmbeddedGoTo() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#setPC(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} PC is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#setPC(PDAction)}
   */
  @Test
  @DisplayName("Test setPC(PDAction); then PDAnnotationAdditionalActions(COSDictionary) with a is COSDictionary() PC is 'null'")
  void testSetPC_thenPDAnnotationAdditionalActionsWithAIsCOSDictionaryPcIsNull() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions(
        new COSDictionary());

    // Act
    pdAnnotationAdditionalActions.setPC(null);

    // Assert
    assertNull(pdAnnotationAdditionalActions.getPC());
    COSDictionary cOSObject = pdAnnotationAdditionalActions.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPV()}.
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  @DisplayName("Test getPV()")
  void testGetPV() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getPV());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPV()}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  @DisplayName("Test getPV(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  void testGetPV_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
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
   * Test {@link PDAnnotationAdditionalActions#getPV()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} SubType is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  @DisplayName("Test getPV(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary() SubType is 'foo'")
  void testGetPV_givenPDActionEmbeddedGoToWithAIsCOSDictionarySubTypeIsFoo() {
    // Arrange
    PDActionEmbeddedGoTo pv = new PDActionEmbeddedGoTo(new COSDictionary());
    pv.setSubType("foo");

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(pv);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getPV());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPV()}.
   * <ul>
   *   <li>Given
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()} E is
   * {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  @DisplayName("Test getPV(); given PDAnnotationAdditionalActions() E is PDActionEmbeddedGoTo()")
  void testGetPV_givenPDAnnotationAdditionalActionsEIsPDActionEmbeddedGoTo() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionEmbeddedGoTo());

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getPV());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPV()}.
   * <ul>
   *   <li>Given
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  @DisplayName("Test getPV(); given PDAnnotationAdditionalActions(); then return 'null'")
  void testGetPV_givenPDAnnotationAdditionalActions_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationAdditionalActions()).getPV());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPV()}.
   * <ul>
   *   <li>Then return {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  @DisplayName("Test getPV(); then return PDActionEmbeddedGoTo")
  void testGetPV_thenReturnPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualPV = pdAnnotationAdditionalActions.getPV();

    // Assert
    assertTrue(actualPV instanceof PDActionEmbeddedGoTo);
    assertNull(((PDActionEmbeddedGoTo) actualPV).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualPV).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualPV).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualPV).getOpenInNewWindow());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualPV.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPV()}.
   * <ul>
   *   <li>Then return {@link PDActionGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  @DisplayName("Test getPV(); then return PDActionGoTo")
  void testGetPV_thenReturnPDActionGoTo() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#getPV()}.
   * <ul>
   *   <li>Then return {@link PDActionHide}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  @DisplayName("Test getPV(); then return PDActionHide")
  void testGetPV_thenReturnPDActionHide() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(new PDActionHide());

    // Act
    PDAction actualPV = pdAnnotationAdditionalActions.getPV();

    // Assert
    assertTrue(actualPV instanceof PDActionHide);
    assertNull(((PDActionHide) actualPV).getT());
    assertTrue(((PDActionHide) actualPV).getH());
    assertEquals(PDActionHide.SUB_TYPE, actualPV.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPV()}.
   * <ul>
   *   <li>Then return {@link PDActionImportData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  @DisplayName("Test getPV(); then return PDActionImportData")
  void testGetPV_thenReturnPDActionImportData() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#getPV()}.
   * <ul>
   *   <li>Then return {@link PDActionJavaScript}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  @DisplayName("Test getPV(); then return PDActionJavaScript")
  void testGetPV_thenReturnPDActionJavaScript() {
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
   * Test {@link PDAnnotationAdditionalActions#getPV()}.
   * <ul>
   *   <li>Then return {@link PDActionLaunch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  @DisplayName("Test getPV(); then return PDActionLaunch")
  void testGetPV_thenReturnPDActionLaunch() throws IOException {
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
    assertNull(((PDActionLaunch) actualPV).getFile());
    assertNull(((PDActionLaunch) actualPV).getWinLaunchParams());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualPV).getOpenInNewWindow());
    assertEquals(PDActionLaunch.SUB_TYPE, actualPV.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPV()}.
   * <ul>
   *   <li>Then return {@link PDActionMovie}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  @DisplayName("Test getPV(); then return PDActionMovie")
  void testGetPV_thenReturnPDActionMovie() {
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
   * Test {@link PDAnnotationAdditionalActions#getPV()}.
   * <ul>
   *   <li>Then return {@link PDActionNamed}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  @DisplayName("Test getPV(); then return PDActionNamed")
  void testGetPV_thenReturnPDActionNamed() {
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
   * Test {@link PDAnnotationAdditionalActions#getPV()}.
   * <ul>
   *   <li>Then return {@link PDActionRemoteGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  @DisplayName("Test getPV(); then return PDActionRemoteGoTo")
  void testGetPV_thenReturnPDActionRemoteGoTo() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(new PDActionRemoteGoTo());

    // Act
    PDAction actualPV = pdAnnotationAdditionalActions.getPV();

    // Assert
    assertTrue(actualPV instanceof PDActionRemoteGoTo);
    assertNull(((PDActionRemoteGoTo) actualPV).getD());
    assertNull(((PDActionRemoteGoTo) actualPV).getFile());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualPV).getOpenInNewWindow());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualPV.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPV()}.
   * <ul>
   *   <li>Then return {@link PDActionResetForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  @DisplayName("Test getPV(); then return PDActionResetForm")
  void testGetPV_thenReturnPDActionResetForm() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(new PDActionResetForm());

    // Act
    PDAction actualPV = pdAnnotationAdditionalActions.getPV();

    // Assert
    assertTrue(actualPV instanceof PDActionResetForm);
    assertNull(((PDActionResetForm) actualPV).getFields());
    assertEquals(0, ((PDActionResetForm) actualPV).getFlags());
    assertEquals(PDActionResetForm.SUB_TYPE, actualPV.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPV()}.
   * <ul>
   *   <li>Then return {@link PDActionSound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  @DisplayName("Test getPV(); then return PDActionSound")
  void testGetPV_thenReturnPDActionSound() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(new PDActionSound());

    // Act
    PDAction actualPV = pdAnnotationAdditionalActions.getPV();

    // Assert
    assertTrue(actualPV instanceof PDActionSound);
    assertNull(((PDActionSound) actualPV).getSound());
    assertEquals(1.0f, ((PDActionSound) actualPV).getVolume());
    assertFalse(((PDActionSound) actualPV).getMix());
    assertFalse(((PDActionSound) actualPV).getRepeat());
    assertFalse(((PDActionSound) actualPV).getSynchronous());
    assertEquals(PDActionSound.SUB_TYPE, actualPV.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPV()}.
   * <ul>
   *   <li>Then return {@link PDActionSubmitForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  @DisplayName("Test getPV(); then return PDActionSubmitForm")
  void testGetPV_thenReturnPDActionSubmitForm() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(new PDActionSubmitForm());

    // Act
    PDAction actualPV = pdAnnotationAdditionalActions.getPV();

    // Assert
    assertTrue(actualPV instanceof PDActionSubmitForm);
    assertNull(((PDActionSubmitForm) actualPV).getFields());
    assertNull(((PDActionSubmitForm) actualPV).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualPV).getFlags());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualPV.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPV()}.
   * <ul>
   *   <li>Then return {@link PDActionThread}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  @DisplayName("Test getPV(); then return PDActionThread")
  void testGetPV_thenReturnPDActionThread() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPV(new PDActionThread());

    // Act
    PDAction actualPV = pdAnnotationAdditionalActions.getPV();

    // Assert
    assertTrue(actualPV instanceof PDActionThread);
    assertNull(((PDActionThread) actualPV).getB());
    assertNull(((PDActionThread) actualPV).getD());
    assertNull(((PDActionThread) actualPV).getFile());
    assertEquals(PDActionThread.SUB_TYPE, actualPV.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPV()}.
   * <ul>
   *   <li>Then return {@link PDActionURI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPV()}
   */
  @Test
  @DisplayName("Test getPV(); then return PDActionURI")
  void testGetPV_thenReturnPDActionURI() {
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
   * Test {@link PDAnnotationAdditionalActions#setPV(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()} PV
   * {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#setPV(PDAction)}
   */
  @Test
  @DisplayName("Test setPV(PDAction); then PDAnnotationAdditionalActions() PV PDActionEmbeddedGoTo")
  void testSetPV_thenPDAnnotationAdditionalActionsPvPDActionEmbeddedGoTo() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#setPV(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} PV is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#setPV(PDAction)}
   */
  @Test
  @DisplayName("Test setPV(PDAction); then PDAnnotationAdditionalActions(COSDictionary) with a is COSDictionary() PV is 'null'")
  void testSetPV_thenPDAnnotationAdditionalActionsWithAIsCOSDictionaryPvIsNull() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions(
        new COSDictionary());

    // Act
    pdAnnotationAdditionalActions.setPV(null);

    // Assert
    assertNull(pdAnnotationAdditionalActions.getPV());
    COSDictionary cOSObject = pdAnnotationAdditionalActions.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPI()}.
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  @DisplayName("Test getPI()")
  void testGetPI() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getPI());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPI()}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  @DisplayName("Test getPI(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  void testGetPI_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
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
   * Test {@link PDAnnotationAdditionalActions#getPI()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} SubType is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  @DisplayName("Test getPI(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary() SubType is 'foo'")
  void testGetPI_givenPDActionEmbeddedGoToWithAIsCOSDictionarySubTypeIsFoo() {
    // Arrange
    PDActionEmbeddedGoTo pi = new PDActionEmbeddedGoTo(new COSDictionary());
    pi.setSubType("foo");

    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(pi);

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getPI());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPI()}.
   * <ul>
   *   <li>Given
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()} E is
   * {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  @DisplayName("Test getPI(); given PDAnnotationAdditionalActions() E is PDActionEmbeddedGoTo()")
  void testGetPI_givenPDAnnotationAdditionalActionsEIsPDActionEmbeddedGoTo() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setE(new PDActionEmbeddedGoTo());

    // Act and Assert
    assertNull(pdAnnotationAdditionalActions.getPI());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPI()}.
   * <ul>
   *   <li>Given
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  @DisplayName("Test getPI(); given PDAnnotationAdditionalActions(); then return 'null'")
  void testGetPI_givenPDAnnotationAdditionalActions_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationAdditionalActions()).getPI());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPI()}.
   * <ul>
   *   <li>Then return {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  @DisplayName("Test getPI(); then return PDActionEmbeddedGoTo")
  void testGetPI_thenReturnPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualPI = pdAnnotationAdditionalActions.getPI();

    // Assert
    assertTrue(actualPI instanceof PDActionEmbeddedGoTo);
    assertNull(((PDActionEmbeddedGoTo) actualPI).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualPI).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualPI).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualPI).getOpenInNewWindow());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualPI.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPI()}.
   * <ul>
   *   <li>Then return {@link PDActionGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  @DisplayName("Test getPI(); then return PDActionGoTo")
  void testGetPI_thenReturnPDActionGoTo() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#getPI()}.
   * <ul>
   *   <li>Then return {@link PDActionHide}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  @DisplayName("Test getPI(); then return PDActionHide")
  void testGetPI_thenReturnPDActionHide() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(new PDActionHide());

    // Act
    PDAction actualPI = pdAnnotationAdditionalActions.getPI();

    // Assert
    assertTrue(actualPI instanceof PDActionHide);
    assertNull(((PDActionHide) actualPI).getT());
    assertTrue(((PDActionHide) actualPI).getH());
    assertEquals(PDActionHide.SUB_TYPE, actualPI.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPI()}.
   * <ul>
   *   <li>Then return {@link PDActionImportData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  @DisplayName("Test getPI(); then return PDActionImportData")
  void testGetPI_thenReturnPDActionImportData() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#getPI()}.
   * <ul>
   *   <li>Then return {@link PDActionJavaScript}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  @DisplayName("Test getPI(); then return PDActionJavaScript")
  void testGetPI_thenReturnPDActionJavaScript() {
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
   * Test {@link PDAnnotationAdditionalActions#getPI()}.
   * <ul>
   *   <li>Then return {@link PDActionLaunch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  @DisplayName("Test getPI(); then return PDActionLaunch")
  void testGetPI_thenReturnPDActionLaunch() throws IOException {
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
    assertNull(((PDActionLaunch) actualPI).getFile());
    assertNull(((PDActionLaunch) actualPI).getWinLaunchParams());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualPI).getOpenInNewWindow());
    assertEquals(PDActionLaunch.SUB_TYPE, actualPI.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPI()}.
   * <ul>
   *   <li>Then return {@link PDActionMovie}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  @DisplayName("Test getPI(); then return PDActionMovie")
  void testGetPI_thenReturnPDActionMovie() {
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
   * Test {@link PDAnnotationAdditionalActions#getPI()}.
   * <ul>
   *   <li>Then return {@link PDActionNamed}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  @DisplayName("Test getPI(); then return PDActionNamed")
  void testGetPI_thenReturnPDActionNamed() {
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
   * Test {@link PDAnnotationAdditionalActions#getPI()}.
   * <ul>
   *   <li>Then return {@link PDActionRemoteGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  @DisplayName("Test getPI(); then return PDActionRemoteGoTo")
  void testGetPI_thenReturnPDActionRemoteGoTo() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(new PDActionRemoteGoTo());

    // Act
    PDAction actualPI = pdAnnotationAdditionalActions.getPI();

    // Assert
    assertTrue(actualPI instanceof PDActionRemoteGoTo);
    assertNull(((PDActionRemoteGoTo) actualPI).getD());
    assertNull(((PDActionRemoteGoTo) actualPI).getFile());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualPI).getOpenInNewWindow());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualPI.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPI()}.
   * <ul>
   *   <li>Then return {@link PDActionResetForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  @DisplayName("Test getPI(); then return PDActionResetForm")
  void testGetPI_thenReturnPDActionResetForm() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(new PDActionResetForm());

    // Act
    PDAction actualPI = pdAnnotationAdditionalActions.getPI();

    // Assert
    assertTrue(actualPI instanceof PDActionResetForm);
    assertNull(((PDActionResetForm) actualPI).getFields());
    assertEquals(0, ((PDActionResetForm) actualPI).getFlags());
    assertEquals(PDActionResetForm.SUB_TYPE, actualPI.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPI()}.
   * <ul>
   *   <li>Then return {@link PDActionSound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  @DisplayName("Test getPI(); then return PDActionSound")
  void testGetPI_thenReturnPDActionSound() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(new PDActionSound());

    // Act
    PDAction actualPI = pdAnnotationAdditionalActions.getPI();

    // Assert
    assertTrue(actualPI instanceof PDActionSound);
    assertNull(((PDActionSound) actualPI).getSound());
    assertEquals(1.0f, ((PDActionSound) actualPI).getVolume());
    assertFalse(((PDActionSound) actualPI).getMix());
    assertFalse(((PDActionSound) actualPI).getRepeat());
    assertFalse(((PDActionSound) actualPI).getSynchronous());
    assertEquals(PDActionSound.SUB_TYPE, actualPI.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPI()}.
   * <ul>
   *   <li>Then return {@link PDActionSubmitForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  @DisplayName("Test getPI(); then return PDActionSubmitForm")
  void testGetPI_thenReturnPDActionSubmitForm() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(new PDActionSubmitForm());

    // Act
    PDAction actualPI = pdAnnotationAdditionalActions.getPI();

    // Assert
    assertTrue(actualPI instanceof PDActionSubmitForm);
    assertNull(((PDActionSubmitForm) actualPI).getFields());
    assertNull(((PDActionSubmitForm) actualPI).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualPI).getFlags());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualPI.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPI()}.
   * <ul>
   *   <li>Then return {@link PDActionThread}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  @DisplayName("Test getPI(); then return PDActionThread")
  void testGetPI_thenReturnPDActionThread() throws IOException {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions();
    pdAnnotationAdditionalActions.setPI(new PDActionThread());

    // Act
    PDAction actualPI = pdAnnotationAdditionalActions.getPI();

    // Assert
    assertTrue(actualPI instanceof PDActionThread);
    assertNull(((PDActionThread) actualPI).getB());
    assertNull(((PDActionThread) actualPI).getD());
    assertNull(((PDActionThread) actualPI).getFile());
    assertEquals(PDActionThread.SUB_TYPE, actualPI.getSubType());
  }

  /**
   * Test {@link PDAnnotationAdditionalActions#getPI()}.
   * <ul>
   *   <li>Then return {@link PDActionURI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#getPI()}
   */
  @Test
  @DisplayName("Test getPI(); then return PDActionURI")
  void testGetPI_thenReturnPDActionURI() {
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
   * Test {@link PDAnnotationAdditionalActions#setPI(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()} PI
   * {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#setPI(PDAction)}
   */
  @Test
  @DisplayName("Test setPI(PDAction); then PDAnnotationAdditionalActions() PI PDActionEmbeddedGoTo")
  void testSetPI_thenPDAnnotationAdditionalActionsPiPDActionEmbeddedGoTo() throws IOException {
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
   * Test {@link PDAnnotationAdditionalActions#setPI(PDAction)}.
   * <ul>
   *   <li>Then
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} PI is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationAdditionalActions#setPI(PDAction)}
   */
  @Test
  @DisplayName("Test setPI(PDAction); then PDAnnotationAdditionalActions(COSDictionary) with a is COSDictionary() PI is 'null'")
  void testSetPI_thenPDAnnotationAdditionalActionsWithAIsCOSDictionaryPiIsNull() {
    // Arrange
    PDAnnotationAdditionalActions pdAnnotationAdditionalActions = new PDAnnotationAdditionalActions(
        new COSDictionary());

    // Act
    pdAnnotationAdditionalActions.setPI(null);

    // Assert
    assertNull(pdAnnotationAdditionalActions.getPI());
    COSDictionary cOSObject = pdAnnotationAdditionalActions.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }
}

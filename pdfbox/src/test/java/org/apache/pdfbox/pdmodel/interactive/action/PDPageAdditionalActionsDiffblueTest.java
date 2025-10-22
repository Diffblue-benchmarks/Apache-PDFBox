package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDPageAdditionalActionsDiffblueTest {
  /**
   * Test {@link PDPageAdditionalActions#PDPageAdditionalActions(COSDictionary)}.
   * <p>
   * Method under test: {@link PDPageAdditionalActions#PDPageAdditionalActions(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDPageAdditionalActions(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPageAdditionalActions.<init>(COSDictionary)"})
  void testNewPDPageAdditionalActions() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDPageAdditionalActions(a)).getCOSObject());
  }

  /**
   * Test {@link PDPageAdditionalActions#PDPageAdditionalActions()}.
   * <p>
   * Method under test: {@link PDPageAdditionalActions#PDPageAdditionalActions()}
   */
  @Test
  @DisplayName("Test new PDPageAdditionalActions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPageAdditionalActions.<init>()"})
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

  /**
   * Test {@link PDPageAdditionalActions#getCOSObject()}.
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDictionary PDPageAdditionalActions.getCOSObject()"})
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
   * Test {@link PDPageAdditionalActions#getO()}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  @DisplayName("Test getO(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getO()"})
  void testGetO_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
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
   * Test {@link PDPageAdditionalActions#getO()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)} with a is {@link COSDictionary#COSDictionary()} SubType is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  @DisplayName("Test getO(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary() SubType is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getO()"})
  void testGetO_givenPDActionEmbeddedGoToWithAIsCOSDictionarySubTypeIsFoo() {
    // Arrange
    PDActionEmbeddedGoTo o = new PDActionEmbeddedGoTo(new COSDictionary());
    o.setSubType("foo");

    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(o);

    // Act and Assert
    assertNull(pdPageAdditionalActions.getO());
  }

  /**
   * Test {@link PDPageAdditionalActions#getO()}.
   * <ul>
   *   <li>Given {@link PDPageAdditionalActions#PDPageAdditionalActions()} O is {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)} with a is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  @DisplayName("Test getO(); given PDPageAdditionalActions() O is PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getO()"})
  void testGetO_givenPDPageAdditionalActionsOIsPDActionEmbeddedGoToWithAIsCOSDictionary() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdPageAdditionalActions.getO());
  }

  /**
   * Test {@link PDPageAdditionalActions#getO()}.
   * <ul>
   *   <li>Given {@link PDPageAdditionalActions#PDPageAdditionalActions()} O is {@link PDActionGoTo#PDActionGoTo()}.</li>
   *   <li>Then return {@link PDActionGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  @DisplayName("Test getO(); given PDPageAdditionalActions() O is PDActionGoTo(); then return PDActionGoTo")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getO()"})
  void testGetO_givenPDPageAdditionalActionsOIsPDActionGoTo_thenReturnPDActionGoTo() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionGoTo());

    // Act
    PDAction actualO = pdPageAdditionalActions.getO();

    // Assert
    assertTrue(actualO instanceof PDActionGoTo);
    assertNull(actualO.getNext());
    COSDictionary cOSObject = actualO.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualO).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualO.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Test {@link PDPageAdditionalActions#getO()}.
   * <ul>
   *   <li>Given {@link PDPageAdditionalActions#PDPageAdditionalActions()} O is {@link PDActionHide#PDActionHide()}.</li>
   *   <li>Then return {@link PDActionHide}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  @DisplayName("Test getO(); given PDPageAdditionalActions() O is PDActionHide(); then return PDActionHide")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getO()"})
  void testGetO_givenPDPageAdditionalActionsOIsPDActionHide_thenReturnPDActionHide() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionHide());

    // Act
    PDAction actualO = pdPageAdditionalActions.getO();

    // Assert
    assertTrue(actualO instanceof PDActionHide);
    assertNull(((PDActionHide) actualO).getT());
    assertTrue(((PDActionHide) actualO).getH());
    assertEquals(PDActionHide.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Test {@link PDPageAdditionalActions#getO()}.
   * <ul>
   *   <li>Given {@link PDPageAdditionalActions#PDPageAdditionalActions()} O is {@link PDActionLaunch#PDActionLaunch()}.</li>
   *   <li>Then return {@link PDActionLaunch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  @DisplayName("Test getO(); given PDPageAdditionalActions() O is PDActionLaunch(); then return PDActionLaunch")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getO()"})
  void testGetO_givenPDPageAdditionalActionsOIsPDActionLaunch_thenReturnPDActionLaunch() throws IOException {
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
    assertNull(((PDActionLaunch) actualO).getFile());
    assertNull(((PDActionLaunch) actualO).getWinLaunchParams());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualO).getOpenInNewWindow());
    assertEquals(PDActionLaunch.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Test {@link PDPageAdditionalActions#getO()}.
   * <ul>
   *   <li>Given {@link PDPageAdditionalActions#PDPageAdditionalActions()} O is {@link PDActionMovie#PDActionMovie()}.</li>
   *   <li>Then return {@link PDActionMovie}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  @DisplayName("Test getO(); given PDPageAdditionalActions() O is PDActionMovie(); then return PDActionMovie")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getO()"})
  void testGetO_givenPDPageAdditionalActionsOIsPDActionMovie_thenReturnPDActionMovie() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionMovie());

    // Act
    PDAction actualO = pdPageAdditionalActions.getO();

    // Assert
    assertTrue(actualO instanceof PDActionMovie);
    COSDictionary cOSObject = actualO.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDActionMovie.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Test {@link PDPageAdditionalActions#getO()}.
   * <ul>
   *   <li>Given {@link PDPageAdditionalActions#PDPageAdditionalActions()} O is {@link PDActionNamed#PDActionNamed()}.</li>
   *   <li>Then return {@link PDActionNamed}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  @DisplayName("Test getO(); given PDPageAdditionalActions() O is PDActionNamed(); then return PDActionNamed")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getO()"})
  void testGetO_givenPDPageAdditionalActionsOIsPDActionNamed_thenReturnPDActionNamed() {
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
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualO.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Test {@link PDPageAdditionalActions#getO()}.
   * <ul>
   *   <li>Given {@link PDPageAdditionalActions#PDPageAdditionalActions()} O is {@link PDActionSound#PDActionSound()}.</li>
   *   <li>Then return {@link PDActionSound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  @DisplayName("Test getO(); given PDPageAdditionalActions() O is PDActionSound(); then return PDActionSound")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getO()"})
  void testGetO_givenPDPageAdditionalActionsOIsPDActionSound_thenReturnPDActionSound() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionSound());

    // Act
    PDAction actualO = pdPageAdditionalActions.getO();

    // Assert
    assertTrue(actualO instanceof PDActionSound);
    assertNull(((PDActionSound) actualO).getSound());
    assertEquals(1.0f, ((PDActionSound) actualO).getVolume());
    assertFalse(((PDActionSound) actualO).getMix());
    assertFalse(((PDActionSound) actualO).getRepeat());
    assertFalse(((PDActionSound) actualO).getSynchronous());
    assertEquals(PDActionSound.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Test {@link PDPageAdditionalActions#getO()}.
   * <ul>
   *   <li>Given {@link PDPageAdditionalActions#PDPageAdditionalActions()} O is {@link PDActionThread#PDActionThread()}.</li>
   *   <li>Then return {@link PDActionThread}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  @DisplayName("Test getO(); given PDPageAdditionalActions() O is PDActionThread(); then return PDActionThread")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getO()"})
  void testGetO_givenPDPageAdditionalActionsOIsPDActionThread_thenReturnPDActionThread() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionThread());

    // Act
    PDAction actualO = pdPageAdditionalActions.getO();

    // Assert
    assertTrue(actualO instanceof PDActionThread);
    assertNull(((PDActionThread) actualO).getB());
    assertNull(((PDActionThread) actualO).getD());
    assertNull(((PDActionThread) actualO).getFile());
    assertEquals(PDActionThread.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Test {@link PDPageAdditionalActions#getO()}.
   * <ul>
   *   <li>Given {@link PDPageAdditionalActions#PDPageAdditionalActions()} O is {@link PDActionURI#PDActionURI()}.</li>
   *   <li>Then return {@link PDActionURI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  @DisplayName("Test getO(); given PDPageAdditionalActions() O is PDActionURI(); then return PDActionURI")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getO()"})
  void testGetO_givenPDPageAdditionalActionsOIsPDActionURI_thenReturnPDActionURI() {
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
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualO.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Test {@link PDPageAdditionalActions#getO()}.
   * <ul>
   *   <li>Given {@link PDPageAdditionalActions#PDPageAdditionalActions()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  @DisplayName("Test getO(); given PDPageAdditionalActions(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getO()"})
  void testGetO_givenPDPageAdditionalActions_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDPageAdditionalActions()).getO());
  }

  /**
   * Test {@link PDPageAdditionalActions#getO()}.
   * <ul>
   *   <li>Then return {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  @DisplayName("Test getO(); then return PDActionEmbeddedGoTo")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getO()"})
  void testGetO_thenReturnPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualO = pdPageAdditionalActions.getO();

    // Assert
    assertTrue(actualO instanceof PDActionEmbeddedGoTo);
    assertNull(((PDActionEmbeddedGoTo) actualO).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualO).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualO).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualO).getOpenInNewWindow());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Test {@link PDPageAdditionalActions#getO()}.
   * <ul>
   *   <li>Then return {@link PDActionImportData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  @DisplayName("Test getO(); then return PDActionImportData")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getO()"})
  void testGetO_thenReturnPDActionImportData() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionImportData());

    // Act
    PDAction actualO = pdPageAdditionalActions.getO();

    // Assert
    assertTrue(actualO instanceof PDActionImportData);
    assertNull(actualO.getNext());
    COSDictionary cOSObject = actualO.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualO).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualO.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Test {@link PDPageAdditionalActions#getO()}.
   * <ul>
   *   <li>Then return {@link PDActionJavaScript}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  @DisplayName("Test getO(); then return PDActionJavaScript")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getO()"})
  void testGetO_thenReturnPDActionJavaScript() {
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
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualO.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Test {@link PDPageAdditionalActions#getO()}.
   * <ul>
   *   <li>Then return {@link PDActionRemoteGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  @DisplayName("Test getO(); then return PDActionRemoteGoTo")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getO()"})
  void testGetO_thenReturnPDActionRemoteGoTo() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionRemoteGoTo());

    // Act
    PDAction actualO = pdPageAdditionalActions.getO();

    // Assert
    assertTrue(actualO instanceof PDActionRemoteGoTo);
    assertNull(((PDActionRemoteGoTo) actualO).getD());
    assertNull(((PDActionRemoteGoTo) actualO).getFile());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualO).getOpenInNewWindow());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Test {@link PDPageAdditionalActions#getO()}.
   * <ul>
   *   <li>Then return {@link PDActionResetForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  @DisplayName("Test getO(); then return PDActionResetForm")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getO()"})
  void testGetO_thenReturnPDActionResetForm() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionResetForm());

    // Act
    PDAction actualO = pdPageAdditionalActions.getO();

    // Assert
    assertTrue(actualO instanceof PDActionResetForm);
    assertNull(((PDActionResetForm) actualO).getFields());
    assertEquals(0, ((PDActionResetForm) actualO).getFlags());
    assertEquals(PDActionResetForm.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Test {@link PDPageAdditionalActions#getO()}.
   * <ul>
   *   <li>Then return {@link PDActionSubmitForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getO()}
   */
  @Test
  @DisplayName("Test getO(); then return PDActionSubmitForm")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getO()"})
  void testGetO_thenReturnPDActionSubmitForm() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setO(new PDActionSubmitForm());

    // Act
    PDAction actualO = pdPageAdditionalActions.getO();

    // Assert
    assertTrue(actualO instanceof PDActionSubmitForm);
    assertNull(((PDActionSubmitForm) actualO).getFields());
    assertNull(((PDActionSubmitForm) actualO).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualO).getFlags());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualO.getSubType());
  }

  /**
   * Test {@link PDPageAdditionalActions#setO(PDAction)}.
   * <ul>
   *   <li>Then {@link PDPageAdditionalActions#PDPageAdditionalActions()} O {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#setO(PDAction)}
   */
  @Test
  @DisplayName("Test setO(PDAction); then PDPageAdditionalActions() O PDActionEmbeddedGoTo")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPageAdditionalActions.setO(PDAction)"})
  void testSetO_thenPDPageAdditionalActionsOPDActionEmbeddedGoTo() throws IOException {
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
   * Test {@link PDPageAdditionalActions#setO(PDAction)}.
   * <ul>
   *   <li>Then {@link PDPageAdditionalActions#PDPageAdditionalActions(COSDictionary)} with a is {@link COSDictionary#COSDictionary()} COSObject size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#setO(PDAction)}
   */
  @Test
  @DisplayName("Test setO(PDAction); then PDPageAdditionalActions(COSDictionary) with a is COSDictionary() COSObject size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPageAdditionalActions.setO(PDAction)"})
  void testSetO_thenPDPageAdditionalActionsWithAIsCOSDictionaryCOSObjectSizeIsZero() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions(new COSDictionary());

    // Act
    pdPageAdditionalActions.setO(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdPageAdditionalActions.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDPageAdditionalActions#getC()}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getC()"})
  void testGetC_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
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
   * Test {@link PDPageAdditionalActions#getC()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)} with a is {@link COSDictionary#COSDictionary()} SubType is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary() SubType is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getC()"})
  void testGetC_givenPDActionEmbeddedGoToWithAIsCOSDictionarySubTypeIsFoo() {
    // Arrange
    PDActionEmbeddedGoTo c = new PDActionEmbeddedGoTo(new COSDictionary());
    c.setSubType("foo");

    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(c);

    // Act and Assert
    assertNull(pdPageAdditionalActions.getC());
  }

  /**
   * Test {@link PDPageAdditionalActions#getC()}.
   * <ul>
   *   <li>Given {@link PDPageAdditionalActions#PDPageAdditionalActions()} C is {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)} with a is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); given PDPageAdditionalActions() C is PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getC()"})
  void testGetC_givenPDPageAdditionalActionsCIsPDActionEmbeddedGoToWithAIsCOSDictionary() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(pdPageAdditionalActions.getC());
  }

  /**
   * Test {@link PDPageAdditionalActions#getC()}.
   * <ul>
   *   <li>Given {@link PDPageAdditionalActions#PDPageAdditionalActions()} C is {@link PDActionGoTo#PDActionGoTo()}.</li>
   *   <li>Then return {@link PDActionGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); given PDPageAdditionalActions() C is PDActionGoTo(); then return PDActionGoTo")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getC()"})
  void testGetC_givenPDPageAdditionalActionsCIsPDActionGoTo_thenReturnPDActionGoTo() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionGoTo());

    // Act
    PDAction actualC = pdPageAdditionalActions.getC();

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
   * Test {@link PDPageAdditionalActions#getC()}.
   * <ul>
   *   <li>Given {@link PDPageAdditionalActions#PDPageAdditionalActions()} C is {@link PDActionHide#PDActionHide()}.</li>
   *   <li>Then return {@link PDActionHide}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); given PDPageAdditionalActions() C is PDActionHide(); then return PDActionHide")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getC()"})
  void testGetC_givenPDPageAdditionalActionsCIsPDActionHide_thenReturnPDActionHide() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionHide());

    // Act
    PDAction actualC = pdPageAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionHide);
    assertNull(((PDActionHide) actualC).getT());
    assertTrue(((PDActionHide) actualC).getH());
    assertEquals(PDActionHide.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Test {@link PDPageAdditionalActions#getC()}.
   * <ul>
   *   <li>Given {@link PDPageAdditionalActions#PDPageAdditionalActions()} C is {@link PDActionLaunch#PDActionLaunch()}.</li>
   *   <li>Then return {@link PDActionLaunch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); given PDPageAdditionalActions() C is PDActionLaunch(); then return PDActionLaunch")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getC()"})
  void testGetC_givenPDPageAdditionalActionsCIsPDActionLaunch_thenReturnPDActionLaunch() throws IOException {
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
    assertNull(((PDActionLaunch) actualC).getFile());
    assertNull(((PDActionLaunch) actualC).getWinLaunchParams());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualC).getOpenInNewWindow());
    assertEquals(PDActionLaunch.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Test {@link PDPageAdditionalActions#getC()}.
   * <ul>
   *   <li>Given {@link PDPageAdditionalActions#PDPageAdditionalActions()} C is {@link PDActionMovie#PDActionMovie()}.</li>
   *   <li>Then return {@link PDActionMovie}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); given PDPageAdditionalActions() C is PDActionMovie(); then return PDActionMovie")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getC()"})
  void testGetC_givenPDPageAdditionalActionsCIsPDActionMovie_thenReturnPDActionMovie() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionMovie());

    // Act
    PDAction actualC = pdPageAdditionalActions.getC();

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
   * Test {@link PDPageAdditionalActions#getC()}.
   * <ul>
   *   <li>Given {@link PDPageAdditionalActions#PDPageAdditionalActions()} C is {@link PDActionNamed#PDActionNamed()}.</li>
   *   <li>Then return {@link PDActionNamed}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); given PDPageAdditionalActions() C is PDActionNamed(); then return PDActionNamed")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getC()"})
  void testGetC_givenPDPageAdditionalActionsCIsPDActionNamed_thenReturnPDActionNamed() {
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
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualC.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Test {@link PDPageAdditionalActions#getC()}.
   * <ul>
   *   <li>Given {@link PDPageAdditionalActions#PDPageAdditionalActions()} C is {@link PDActionSound#PDActionSound()}.</li>
   *   <li>Then return {@link PDActionSound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); given PDPageAdditionalActions() C is PDActionSound(); then return PDActionSound")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getC()"})
  void testGetC_givenPDPageAdditionalActionsCIsPDActionSound_thenReturnPDActionSound() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionSound());

    // Act
    PDAction actualC = pdPageAdditionalActions.getC();

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
   * Test {@link PDPageAdditionalActions#getC()}.
   * <ul>
   *   <li>Given {@link PDPageAdditionalActions#PDPageAdditionalActions()} C is {@link PDActionThread#PDActionThread()}.</li>
   *   <li>Then return {@link PDActionThread}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); given PDPageAdditionalActions() C is PDActionThread(); then return PDActionThread")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getC()"})
  void testGetC_givenPDPageAdditionalActionsCIsPDActionThread_thenReturnPDActionThread() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionThread());

    // Act
    PDAction actualC = pdPageAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionThread);
    assertNull(((PDActionThread) actualC).getB());
    assertNull(((PDActionThread) actualC).getD());
    assertNull(((PDActionThread) actualC).getFile());
    assertEquals(PDActionThread.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Test {@link PDPageAdditionalActions#getC()}.
   * <ul>
   *   <li>Given {@link PDPageAdditionalActions#PDPageAdditionalActions()} C is {@link PDActionURI#PDActionURI()}.</li>
   *   <li>Then return {@link PDActionURI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); given PDPageAdditionalActions() C is PDActionURI(); then return PDActionURI")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getC()"})
  void testGetC_givenPDPageAdditionalActionsCIsPDActionURI_thenReturnPDActionURI() {
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
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualC.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Test {@link PDPageAdditionalActions#getC()}.
   * <ul>
   *   <li>Given {@link PDPageAdditionalActions#PDPageAdditionalActions()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); given PDPageAdditionalActions(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getC()"})
  void testGetC_givenPDPageAdditionalActions_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDPageAdditionalActions()).getC());
  }

  /**
   * Test {@link PDPageAdditionalActions#getC()}.
   * <ul>
   *   <li>Then return {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); then return PDActionEmbeddedGoTo")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getC()"})
  void testGetC_thenReturnPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualC = pdPageAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionEmbeddedGoTo);
    assertNull(((PDActionEmbeddedGoTo) actualC).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualC).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualC).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualC).getOpenInNewWindow());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Test {@link PDPageAdditionalActions#getC()}.
   * <ul>
   *   <li>Then return {@link PDActionImportData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); then return PDActionImportData")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getC()"})
  void testGetC_thenReturnPDActionImportData() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionImportData());

    // Act
    PDAction actualC = pdPageAdditionalActions.getC();

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
   * Test {@link PDPageAdditionalActions#getC()}.
   * <ul>
   *   <li>Then return {@link PDActionJavaScript}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); then return PDActionJavaScript")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getC()"})
  void testGetC_thenReturnPDActionJavaScript() {
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
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualC.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Test {@link PDPageAdditionalActions#getC()}.
   * <ul>
   *   <li>Then return {@link PDActionRemoteGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); then return PDActionRemoteGoTo")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getC()"})
  void testGetC_thenReturnPDActionRemoteGoTo() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionRemoteGoTo());

    // Act
    PDAction actualC = pdPageAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionRemoteGoTo);
    assertNull(((PDActionRemoteGoTo) actualC).getD());
    assertNull(((PDActionRemoteGoTo) actualC).getFile());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualC).getOpenInNewWindow());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Test {@link PDPageAdditionalActions#getC()}.
   * <ul>
   *   <li>Then return {@link PDActionResetForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); then return PDActionResetForm")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getC()"})
  void testGetC_thenReturnPDActionResetForm() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionResetForm());

    // Act
    PDAction actualC = pdPageAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionResetForm);
    assertNull(((PDActionResetForm) actualC).getFields());
    assertEquals(0, ((PDActionResetForm) actualC).getFlags());
    assertEquals(PDActionResetForm.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Test {@link PDPageAdditionalActions#getC()}.
   * <ul>
   *   <li>Then return {@link PDActionSubmitForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#getC()}
   */
  @Test
  @DisplayName("Test getC(); then return PDActionSubmitForm")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDPageAdditionalActions.getC()"})
  void testGetC_thenReturnPDActionSubmitForm() throws IOException {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions();
    pdPageAdditionalActions.setC(new PDActionSubmitForm());

    // Act
    PDAction actualC = pdPageAdditionalActions.getC();

    // Assert
    assertTrue(actualC instanceof PDActionSubmitForm);
    assertNull(((PDActionSubmitForm) actualC).getFields());
    assertNull(((PDActionSubmitForm) actualC).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualC).getFlags());
    assertEquals(PDActionSubmitForm.SUB_TYPE, actualC.getSubType());
  }

  /**
   * Test {@link PDPageAdditionalActions#setC(PDAction)}.
   * <ul>
   *   <li>Then {@link PDPageAdditionalActions#PDPageAdditionalActions()} C {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#setC(PDAction)}
   */
  @Test
  @DisplayName("Test setC(PDAction); then PDPageAdditionalActions() C PDActionEmbeddedGoTo")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPageAdditionalActions.setC(PDAction)"})
  void testSetC_thenPDPageAdditionalActionsCPDActionEmbeddedGoTo() throws IOException {
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
   * Test {@link PDPageAdditionalActions#setC(PDAction)}.
   * <ul>
   *   <li>Then {@link PDPageAdditionalActions#PDPageAdditionalActions(COSDictionary)} with a is {@link COSDictionary#COSDictionary()} COSObject size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageAdditionalActions#setC(PDAction)}
   */
  @Test
  @DisplayName("Test setC(PDAction); then PDPageAdditionalActions(COSDictionary) with a is COSDictionary() COSObject size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPageAdditionalActions.setC(PDAction)"})
  void testSetC_thenPDPageAdditionalActionsWithAIsCOSDictionaryCOSObjectSizeIsZero() {
    // Arrange
    PDPageAdditionalActions pdPageAdditionalActions = new PDPageAdditionalActions(new COSDictionary());

    // Act
    pdPageAdditionalActions.setC(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdPageAdditionalActions.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }
}

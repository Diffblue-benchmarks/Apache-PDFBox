package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDActionDiffblueTest {
  /**
   * Test {@link PDAction#getCOSObject()}.
   * <p>
   * Method under test: {@link PDAction#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act and Assert
    assertSame(pdActionEmbeddedGoTo.action, pdActionEmbeddedGoTo.getCOSObject());
  }

  /**
   * Test {@link PDAction#getType()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#getType()}
   */
  @Test
  @DisplayName("Test getType(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary(); then return 'null'")
  void testGetType_givenPDActionEmbeddedGoToWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDActionEmbeddedGoTo(new COSDictionary())).getType());
  }

  /**
   * Test {@link PDAction#getType()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.</li>
   *   <li>Then return {@link PDAction#TYPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#getType()}
   */
  @Test
  @DisplayName("Test getType(); given PDActionEmbeddedGoTo(); then return TYPE")
  void testGetType_givenPDActionEmbeddedGoTo_thenReturnType() {
    // Arrange, Act and Assert
    assertEquals(PDAction.TYPE, (new PDActionEmbeddedGoTo()).getType());
  }

  /**
   * Test {@link PDAction#setType(String)}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.</li>
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} Type is
   * {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#setType(String)}
   */
  @Test
  @DisplayName("Test setType(String); given PDActionEmbeddedGoTo(); then PDActionEmbeddedGoTo() Type is 'Type'")
  void testSetType_givenPDActionEmbeddedGoTo_thenPDActionEmbeddedGoToTypeIsType() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setType("Type");

    // Assert
    assertEquals("Type", pdActionEmbeddedGoTo.getType());
  }

  /**
   * Test {@link PDAction#setType(String)}.
   * <ul>
   *   <li>When {@code TypeType}.</li>
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} Type is
   * {@code TypeType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#setType(String)}
   */
  @Test
  @DisplayName("Test setType(String); when 'TypeType'; then PDActionEmbeddedGoTo() Type is 'TypeType'")
  void testSetType_whenTypeType_thenPDActionEmbeddedGoToTypeIsTypeType() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setType("TypeType");

    // Assert
    assertEquals("TypeType", pdActionEmbeddedGoTo.getType());
  }

  /**
   * Test {@link PDAction#getSubType()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#getSubType()}
   */
  @Test
  @DisplayName("Test getSubType(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary(); then return 'null'")
  void testGetSubType_givenPDActionEmbeddedGoToWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDActionEmbeddedGoTo(new COSDictionary())).getSubType());
  }

  /**
   * Test {@link PDAction#getSubType()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.</li>
   *   <li>Then return {@link PDActionEmbeddedGoTo#SUB_TYPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#getSubType()}
   */
  @Test
  @DisplayName("Test getSubType(); given PDActionEmbeddedGoTo(); then return SUB_TYPE")
  void testGetSubType_givenPDActionEmbeddedGoTo_thenReturnSub_type() {
    // Arrange, Act and Assert
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, (new PDActionEmbeddedGoTo()).getSubType());
  }

  /**
   * Test {@link PDAction#setSubType(String)}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.</li>
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} SubType is
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#setSubType(String)}
   */
  @Test
  @DisplayName("Test setSubType(String); given PDActionEmbeddedGoTo(); then PDActionEmbeddedGoTo() SubType is 'foo'")
  void testSetSubType_givenPDActionEmbeddedGoTo_thenPDActionEmbeddedGoToSubTypeIsFoo() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setSubType("foo");

    // Assert
    assertEquals("foo", pdActionEmbeddedGoTo.getSubType());
  }

  /**
   * Test {@link PDAction#setSubType(String)}.
   * <ul>
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} SubType is
   * {@code org.apache.pdfbox.cos.COSDictionary}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#setSubType(String)}
   */
  @Test
  @DisplayName("Test setSubType(String); then PDActionEmbeddedGoTo() SubType is 'org.apache.pdfbox.cos.COSDictionary'")
  void testSetSubType_thenPDActionEmbeddedGoToSubTypeIsOrgApachePdfboxCosCOSDictionary() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setSubType("org.apache.pdfbox.cos.COSDictionary");

    // Assert
    assertEquals("org.apache.pdfbox.cos.COSDictionary", pdActionEmbeddedGoTo.getSubType());
  }

  /**
   * Test {@link PDAction#getNext()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)} with a is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); given ArrayList() add PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary()")
  void testGetNext_givenArrayListAddPDActionEmbeddedGoToWithAIsCOSDictionary() {
    // Arrange
    ArrayList<PDAction> next = new ArrayList<>();
    next.add(new PDActionEmbeddedGoTo(new COSDictionary()));

    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();
    pdActionEmbeddedGoTo.setNext(next);

    // Act
    List<PDAction> actualNext = pdActionEmbeddedGoTo.getNext();

    // Assert
    assertEquals(1, actualNext.size());
    assertNull(actualNext.get(0));
  }

  /**
   * Test {@link PDAction#getNext()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)} with a is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); given ArrayList() add PDActionEmbeddedGoTo(COSDictionary) with a is 'null'")
  void testGetNext_givenArrayListAddPDActionEmbeddedGoToWithAIsNull() {
    // Arrange
    ArrayList<PDAction> next = new ArrayList<>();
    next.add(new PDActionEmbeddedGoTo(null));

    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();
    pdActionEmbeddedGoTo.setNext(next);

    // Act
    List<PDAction> actualNext = pdActionEmbeddedGoTo.getNext();

    // Assert
    assertEquals(1, actualNext.size());
    assertNull(actualNext.get(0));
  }

  /**
   * Test {@link PDAction#getNext()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link PDActionGoTo#PDActionGoTo()}.</li>
   *   <li>Then first return {@link PDActionGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); given ArrayList() add PDActionGoTo(); then first return PDActionGoTo")
  void testGetNext_givenArrayListAddPDActionGoTo_thenFirstReturnPDActionGoTo() throws IOException {
    // Arrange
    ArrayList<PDAction> next = new ArrayList<>();
    next.add(new PDActionGoTo());

    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();
    pdActionEmbeddedGoTo.setNext(next);

    // Act
    List<PDAction> actualNext = pdActionEmbeddedGoTo.getNext();

    // Assert
    assertEquals(1, actualNext.size());
    PDAction getResult = actualNext.get(0);
    assertTrue(getResult instanceof PDActionGoTo);
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) getResult).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, getResult.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Test {@link PDAction#getNext()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link PDActionHide#PDActionHide()}.</li>
   *   <li>Then first return {@link PDActionHide}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); given ArrayList() add PDActionHide(); then first return PDActionHide")
  void testGetNext_givenArrayListAddPDActionHide_thenFirstReturnPDActionHide() {
    // Arrange
    ArrayList<PDAction> next = new ArrayList<>();
    next.add(new PDActionHide());

    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();
    pdActionEmbeddedGoTo.setNext(next);

    // Act
    List<PDAction> actualNext = pdActionEmbeddedGoTo.getNext();

    // Assert
    assertEquals(1, actualNext.size());
    PDAction getResult = actualNext.get(0);
    assertTrue(getResult instanceof PDActionHide);
    assertNull(((PDActionHide) getResult).getT());
    assertTrue(((PDActionHide) getResult).getH());
    assertEquals(PDActionHide.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Test {@link PDAction#getNext()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link PDActionLaunch#PDActionLaunch()}.</li>
   *   <li>Then first return {@link PDActionLaunch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); given ArrayList() add PDActionLaunch(); then first return PDActionLaunch")
  void testGetNext_givenArrayListAddPDActionLaunch_thenFirstReturnPDActionLaunch() throws IOException {
    // Arrange
    ArrayList<PDAction> next = new ArrayList<>();
    next.add(new PDActionLaunch());

    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();
    pdActionEmbeddedGoTo.setNext(next);

    // Act
    List<PDAction> actualNext = pdActionEmbeddedGoTo.getNext();

    // Assert
    assertEquals(1, actualNext.size());
    PDAction getResult = actualNext.get(0);
    assertTrue(getResult instanceof PDActionLaunch);
    assertNull(((PDActionLaunch) getResult).getD());
    assertNull(((PDActionLaunch) getResult).getF());
    assertNull(((PDActionLaunch) getResult).getO());
    assertNull(((PDActionLaunch) getResult).getP());
    assertNull(((PDActionLaunch) getResult).getFile());
    assertNull(((PDActionLaunch) getResult).getWinLaunchParams());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) getResult).getOpenInNewWindow());
    assertEquals(PDActionLaunch.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Test {@link PDAction#getNext()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link PDActionMovie#PDActionMovie()}.</li>
   *   <li>Then first return {@link PDActionMovie}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); given ArrayList() add PDActionMovie(); then first return PDActionMovie")
  void testGetNext_givenArrayListAddPDActionMovie_thenFirstReturnPDActionMovie() {
    // Arrange
    ArrayList<PDAction> next = new ArrayList<>();
    next.add(new PDActionMovie());

    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();
    pdActionEmbeddedGoTo.setNext(next);

    // Act
    List<PDAction> actualNext = pdActionEmbeddedGoTo.getNext();

    // Assert
    assertEquals(1, actualNext.size());
    PDAction getResult = actualNext.get(0);
    assertTrue(getResult instanceof PDActionMovie);
    COSDictionary cOSObject = getResult.getCOSObject();
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
    assertEquals(PDAction.TYPE, getResult.getType());
    assertEquals(PDActionMovie.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Test {@link PDAction#getNext()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link PDActionNamed#PDActionNamed()}.</li>
   *   <li>Then first return {@link PDActionNamed}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); given ArrayList() add PDActionNamed(); then first return PDActionNamed")
  void testGetNext_givenArrayListAddPDActionNamed_thenFirstReturnPDActionNamed() {
    // Arrange
    ArrayList<PDAction> next = new ArrayList<>();
    next.add(new PDActionNamed());

    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();
    pdActionEmbeddedGoTo.setNext(next);

    // Act
    List<PDAction> actualNext = pdActionEmbeddedGoTo.getNext();

    // Assert
    assertEquals(1, actualNext.size());
    PDAction getResult = actualNext.get(0);
    assertTrue(getResult instanceof PDActionNamed);
    assertNull(((PDActionNamed) getResult).getN());
    COSDictionary cOSObject = getResult.getCOSObject();
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
    assertEquals(PDAction.TYPE, getResult.getType());
    assertEquals(PDActionNamed.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Test {@link PDAction#getNext()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link PDActionResetForm#PDActionResetForm()}.</li>
   *   <li>Then first return {@link PDActionResetForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); given ArrayList() add PDActionResetForm(); then first return PDActionResetForm")
  void testGetNext_givenArrayListAddPDActionResetForm_thenFirstReturnPDActionResetForm() {
    // Arrange
    ArrayList<PDAction> next = new ArrayList<>();
    next.add(new PDActionResetForm());

    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();
    pdActionEmbeddedGoTo.setNext(next);

    // Act
    List<PDAction> actualNext = pdActionEmbeddedGoTo.getNext();

    // Assert
    assertEquals(1, actualNext.size());
    PDAction getResult = actualNext.get(0);
    assertTrue(getResult instanceof PDActionResetForm);
    assertNull(((PDActionResetForm) getResult).getFields());
    assertEquals(0, ((PDActionResetForm) getResult).getFlags());
    assertEquals(PDActionResetForm.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Test {@link PDAction#getNext()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link PDActionSound#PDActionSound()}.</li>
   *   <li>Then first return {@link PDActionSound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); given ArrayList() add PDActionSound(); then first return PDActionSound")
  void testGetNext_givenArrayListAddPDActionSound_thenFirstReturnPDActionSound() {
    // Arrange
    ArrayList<PDAction> next = new ArrayList<>();
    next.add(new PDActionSound());

    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();
    pdActionEmbeddedGoTo.setNext(next);

    // Act
    List<PDAction> actualNext = pdActionEmbeddedGoTo.getNext();

    // Assert
    assertEquals(1, actualNext.size());
    PDAction getResult = actualNext.get(0);
    assertTrue(getResult instanceof PDActionSound);
    assertNull(((PDActionSound) getResult).getSound());
    assertEquals(1.0f, ((PDActionSound) getResult).getVolume());
    assertFalse(((PDActionSound) getResult).getMix());
    assertFalse(((PDActionSound) getResult).getRepeat());
    assertFalse(((PDActionSound) getResult).getSynchronous());
    assertEquals(PDActionSound.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Test {@link PDAction#getNext()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link PDActionThread#PDActionThread()}.</li>
   *   <li>Then first return {@link PDActionThread}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); given ArrayList() add PDActionThread(); then first return PDActionThread")
  void testGetNext_givenArrayListAddPDActionThread_thenFirstReturnPDActionThread() throws IOException {
    // Arrange
    ArrayList<PDAction> next = new ArrayList<>();
    next.add(new PDActionThread());

    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();
    pdActionEmbeddedGoTo.setNext(next);

    // Act
    List<PDAction> actualNext = pdActionEmbeddedGoTo.getNext();

    // Assert
    assertEquals(1, actualNext.size());
    PDAction getResult = actualNext.get(0);
    assertTrue(getResult instanceof PDActionThread);
    assertNull(((PDActionThread) getResult).getB());
    assertNull(((PDActionThread) getResult).getD());
    assertNull(((PDActionThread) getResult).getFile());
    assertEquals(PDActionThread.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Test {@link PDAction#getNext()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link PDActionURI#PDActionURI()}.</li>
   *   <li>Then first return {@link PDActionURI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); given ArrayList() add PDActionURI(); then first return PDActionURI")
  void testGetNext_givenArrayListAddPDActionURI_thenFirstReturnPDActionURI() {
    // Arrange
    ArrayList<PDAction> next = new ArrayList<>();
    next.add(new PDActionURI());

    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();
    pdActionEmbeddedGoTo.setNext(next);

    // Act
    List<PDAction> actualNext = pdActionEmbeddedGoTo.getNext();

    // Assert
    assertEquals(1, actualNext.size());
    PDAction getResult = actualNext.get(0);
    assertTrue(getResult instanceof PDActionURI);
    assertNull(((PDActionURI) getResult).getURI());
    COSDictionary cOSObject = getResult.getCOSObject();
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
    assertEquals(PDAction.TYPE, getResult.getType());
    assertEquals(PDActionURI.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Test {@link PDAction#getNext()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} Next is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); given PDActionEmbeddedGoTo() Next is ArrayList(); then return Empty")
  void testGetNext_givenPDActionEmbeddedGoToNextIsArrayList_thenReturnEmpty() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();
    pdActionEmbeddedGoTo.setNext(new ArrayList<>());

    // Act and Assert
    assertTrue(pdActionEmbeddedGoTo.getNext().isEmpty());
  }

  /**
   * Test {@link PDAction#getNext()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()} SubType is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary() SubType is 'foo'")
  void testGetNext_givenPDActionEmbeddedGoToWithAIsCOSDictionarySubTypeIsFoo() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo(new COSDictionary());
    pdActionEmbeddedGoTo.setSubType("foo");

    ArrayList<PDAction> next = new ArrayList<>();
    next.add(pdActionEmbeddedGoTo);

    PDActionEmbeddedGoTo pdActionEmbeddedGoTo2 = new PDActionEmbeddedGoTo();
    pdActionEmbeddedGoTo2.setNext(next);

    // Act
    List<PDAction> actualNext = pdActionEmbeddedGoTo2.getNext();

    // Assert
    assertEquals(1, actualNext.size());
    assertNull(actualNext.get(0));
  }

  /**
   * Test {@link PDAction#getNext()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary(); then return 'null'")
  void testGetNext_givenPDActionEmbeddedGoToWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDActionEmbeddedGoTo(new COSDictionary())).getNext());
  }

  /**
   * Test {@link PDAction#getNext()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); given PDActionEmbeddedGoTo(); then return 'null'")
  void testGetNext_givenPDActionEmbeddedGoTo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDActionEmbeddedGoTo()).getNext());
  }

  /**
   * Test {@link PDAction#getNext()}.
   * <ul>
   *   <li>Then first return {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); then first return PDActionEmbeddedGoTo")
  void testGetNext_thenFirstReturnPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    ArrayList<PDAction> next = new ArrayList<>();
    next.add(new PDActionEmbeddedGoTo());

    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();
    pdActionEmbeddedGoTo.setNext(next);

    // Act
    List<PDAction> actualNext = pdActionEmbeddedGoTo.getNext();

    // Assert
    assertEquals(1, actualNext.size());
    PDAction getResult = actualNext.get(0);
    assertTrue(getResult instanceof PDActionEmbeddedGoTo);
    assertNull(((PDActionEmbeddedGoTo) getResult).getFile());
    assertNull(((PDActionEmbeddedGoTo) getResult).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) getResult).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) getResult).getOpenInNewWindow());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Test {@link PDAction#getNext()}.
   * <ul>
   *   <li>Then first return {@link PDActionImportData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); then first return PDActionImportData")
  void testGetNext_thenFirstReturnPDActionImportData() throws IOException {
    // Arrange
    ArrayList<PDAction> next = new ArrayList<>();
    next.add(new PDActionImportData());

    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();
    pdActionEmbeddedGoTo.setNext(next);

    // Act
    List<PDAction> actualNext = pdActionEmbeddedGoTo.getNext();

    // Assert
    assertEquals(1, actualNext.size());
    PDAction getResult = actualNext.get(0);
    assertTrue(getResult instanceof PDActionImportData);
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) getResult).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, getResult.getType());
    assertEquals(PDActionImportData.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Test {@link PDAction#getNext()}.
   * <ul>
   *   <li>Then first return {@link PDActionJavaScript}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); then first return PDActionJavaScript")
  void testGetNext_thenFirstReturnPDActionJavaScript() {
    // Arrange
    ArrayList<PDAction> next = new ArrayList<>();
    next.add(new PDActionJavaScript());

    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();
    pdActionEmbeddedGoTo.setNext(next);

    // Act
    List<PDAction> actualNext = pdActionEmbeddedGoTo.getNext();

    // Assert
    assertEquals(1, actualNext.size());
    PDAction getResult = actualNext.get(0);
    assertTrue(getResult instanceof PDActionJavaScript);
    assertNull(((PDActionJavaScript) getResult).getAction());
    COSDictionary cOSObject = getResult.getCOSObject();
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
    assertEquals(PDAction.TYPE, getResult.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Test {@link PDAction#getNext()}.
   * <ul>
   *   <li>Then first return {@link PDActionRemoteGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); then first return PDActionRemoteGoTo")
  void testGetNext_thenFirstReturnPDActionRemoteGoTo() throws IOException {
    // Arrange
    ArrayList<PDAction> next = new ArrayList<>();
    next.add(new PDActionRemoteGoTo());

    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();
    pdActionEmbeddedGoTo.setNext(next);

    // Act
    List<PDAction> actualNext = pdActionEmbeddedGoTo.getNext();

    // Assert
    assertEquals(1, actualNext.size());
    PDAction getResult = actualNext.get(0);
    assertTrue(getResult instanceof PDActionRemoteGoTo);
    assertNull(((PDActionRemoteGoTo) getResult).getD());
    assertNull(((PDActionRemoteGoTo) getResult).getFile());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) getResult).getOpenInNewWindow());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Test {@link PDAction#getNext()}.
   * <ul>
   *   <li>Then first return {@link PDActionSubmitForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); then first return PDActionSubmitForm")
  void testGetNext_thenFirstReturnPDActionSubmitForm() throws IOException {
    // Arrange
    ArrayList<PDAction> next = new ArrayList<>();
    next.add(new PDActionSubmitForm());

    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();
    pdActionEmbeddedGoTo.setNext(next);

    // Act
    List<PDAction> actualNext = pdActionEmbeddedGoTo.getNext();

    // Assert
    assertEquals(1, actualNext.size());
    PDAction getResult = actualNext.get(0);
    assertTrue(getResult instanceof PDActionSubmitForm);
    assertNull(((PDActionSubmitForm) getResult).getFields());
    assertNull(((PDActionSubmitForm) getResult).getFile());
    assertEquals(0, ((PDActionSubmitForm) getResult).getFlags());
    assertEquals(PDActionSubmitForm.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Test {@link PDAction#setNext(List)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} Next is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#setNext(List)}
   */
  @Test
  @DisplayName("Test setNext(List); given ArrayList(); then PDActionEmbeddedGoTo() Next is ArrayList()")
  void testSetNext_givenArrayList_thenPDActionEmbeddedGoToNextIsArrayList() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    ArrayList<PDAction> next = new ArrayList<>();
    next.addAll(new ArrayList<>());
    next.add(null);

    // Act
    pdActionEmbeddedGoTo.setNext(next);

    // Assert
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(next, pdActionEmbeddedGoTo.getNext());
  }

  /**
   * Test {@link PDAction#setNext(List)}.
   * <ul>
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} Next size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#setNext(List)}
   */
  @Test
  @DisplayName("Test setNext(List); then PDActionEmbeddedGoTo() Next size is one")
  void testSetNext_thenPDActionEmbeddedGoToNextSizeIsOne() throws IOException {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    ArrayList<PDAction> next = new ArrayList<>();
    next.add(new PDActionEmbeddedGoTo());

    // Act
    pdActionEmbeddedGoTo.setNext(next);

    // Assert
    List<PDAction> next2 = pdActionEmbeddedGoTo.getNext();
    assertEquals(1, next2.size());
    PDAction getResult = next2.get(0);
    assertTrue(getResult instanceof PDActionEmbeddedGoTo);
    assertNull(getResult.getNext());
    assertNull(((PDActionEmbeddedGoTo) getResult).getFile());
    assertNull(((PDActionEmbeddedGoTo) getResult).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) getResult).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) getResult).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, getResult.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Test {@link PDAction#setNext(List)}.
   * <ul>
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} Next size is
   * two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#setNext(List)}
   */
  @Test
  @DisplayName("Test setNext(List); then PDActionEmbeddedGoTo() Next size is two")
  void testSetNext_thenPDActionEmbeddedGoToNextSizeIsTwo() throws IOException {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    ArrayList<PDAction> next = new ArrayList<>();
    next.add(new PDActionEmbeddedGoTo());
    next.add(new PDActionEmbeddedGoTo());

    // Act
    pdActionEmbeddedGoTo.setNext(next);

    // Assert
    List<PDAction> next2 = pdActionEmbeddedGoTo.getNext();
    assertEquals(2, next2.size());
    PDAction getResult = next2.get(1);
    assertTrue(getResult instanceof PDActionEmbeddedGoTo);
    assertNull(getResult.getNext());
    assertNull(((PDActionEmbeddedGoTo) getResult).getFile());
    assertNull(((PDActionEmbeddedGoTo) getResult).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) getResult).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) getResult).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, getResult.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Test {@link PDAction#setNext(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} Next Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAction#setNext(List)}
   */
  @Test
  @DisplayName("Test setNext(List); when ArrayList(); then PDActionEmbeddedGoTo() Next Empty")
  void testSetNext_whenArrayList_thenPDActionEmbeddedGoToNextEmpty() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setNext(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdActionEmbeddedGoTo.getNext().isEmpty());
  }
}

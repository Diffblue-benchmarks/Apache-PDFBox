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
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class PDActionDiffblueTest {
  /**
   * Method under test: {@link PDAction#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act and Assert
    assertSame(pdActionEmbeddedGoTo.action, pdActionEmbeddedGoTo.getCOSObject());
  }

  /**
   * Method under test: {@link PDAction#getType()}
   */
  @Test
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals(PDAction.TYPE, (new PDActionEmbeddedGoTo()).getType());
    assertNull((new PDActionEmbeddedGoTo(new COSDictionary())).getType());
  }

  /**
   * Method under test: {@link PDAction#setType(String)}
   */
  @Test
  void testSetType() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setType("Type");

    // Assert
    assertEquals("Type", pdActionEmbeddedGoTo.getType());
  }

  /**
   * Method under test: {@link PDAction#setType(String)}
   */
  @Test
  void testSetType2() {
    // Arrange
    COSStream a = new COSStream();
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo(a);

    // Act
    pdActionEmbeddedGoTo.setType("org.apache.pdfbox.cos.COSDictionary");

    // Assert
    assertEquals("org.apache.pdfbox.cos.COSDictionary", pdActionEmbeddedGoTo.getType());
    assertSame(a, pdActionEmbeddedGoTo.getCOSObject());
  }

  /**
   * Method under test: {@link PDAction#getSubType()}
   */
  @Test
  void testGetSubType() {
    // Arrange, Act and Assert
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, (new PDActionEmbeddedGoTo()).getSubType());
    assertNull((new PDActionEmbeddedGoTo(new COSDictionary())).getSubType());
  }

  /**
   * Method under test: {@link PDAction#setSubType(String)}
   */
  @Test
  void testSetSubType() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setSubType("foo");

    // Assert
    assertEquals("foo", pdActionEmbeddedGoTo.getSubType());
  }

  /**
   * Method under test: {@link PDAction#setSubType(String)}
   */
  @Test
  void testSetSubType2() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setSubType("42");

    // Assert
    assertEquals("42", pdActionEmbeddedGoTo.getSubType());
  }

  /**
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  void testGetNext() {
    // Arrange, Act and Assert
    assertNull((new PDActionEmbeddedGoTo()).getNext());
  }

  /**
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  void testGetNext2() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();
    pdActionEmbeddedGoTo.setNext(new ArrayList<>());

    // Act and Assert
    assertTrue(pdActionEmbeddedGoTo.getNext().isEmpty());
  }

  /**
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  void testGetNext3() throws IOException {
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
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionEmbeddedGoTo) getResult).getFile());
    assertNull(((PDActionEmbeddedGoTo) getResult).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) getResult).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) getResult).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, getResult.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  void testGetNext4() {
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
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  void testGetNext5() throws IOException {
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
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  void testGetNext6() {
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
    assertTrue(((PDActionHide) getResult).getH());
    assertEquals(PDAction.TYPE, getResult.getType());
    assertEquals(PDActionHide.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  void testGetNext7() throws IOException {
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
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  void testGetNext8() {
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
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  void testGetNext9() {
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
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  void testGetNext10() {
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
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  void testGetNext11() throws IOException {
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
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionLaunch) getResult).getFile());
    assertNull(((PDActionLaunch) getResult).getWinLaunchParams());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) getResult).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, getResult.getType());
    assertEquals(PDActionLaunch.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  void testGetNext12() {
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
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  void testGetNext13() {
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
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  void testGetNext14() throws IOException {
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
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionRemoteGoTo) getResult).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) getResult).getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, getResult.getType());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  void testGetNext15() {
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
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((PDActionResetForm) getResult).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, getResult.getType());
    assertEquals(PDActionResetForm.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  void testGetNext16() {
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
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSound) getResult).getSound());
    assertEquals(1.0f, ((PDActionSound) getResult).getVolume());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDActionSound) getResult).getMix());
    assertFalse(((PDActionSound) getResult).getRepeat());
    assertFalse(((PDActionSound) getResult).getSynchronous());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, getResult.getType());
    assertEquals(PDActionSound.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  void testGetNext17() throws IOException {
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
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionSubmitForm) getResult).getFile());
    assertEquals(0, ((PDActionSubmitForm) getResult).getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, getResult.getType());
    assertEquals(PDActionSubmitForm.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  void testGetNext18() throws IOException {
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
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionThread) getResult).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, getResult.getType());
    assertEquals(PDActionThread.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Method under test: {@link PDAction#getNext()}
   */
  @Test
  void testGetNext19() {
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
   * Method under test: {@link PDAction#setNext(List)}
   */
  @Test
  void testSetNext() {
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

  /**
   * Method under test: {@link PDAction#setNext(List)}
   */
  @Test
  void testSetNext2() throws IOException {
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
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) getResult).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, getResult.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Method under test: {@link PDAction#setNext(List)}
   */
  @Test
  void testSetNext3() throws IOException {
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
    PDAction getResult = next2.get(0);
    assertTrue(getResult instanceof PDActionEmbeddedGoTo);
    PDAction getResult2 = next2.get(1);
    assertTrue(getResult2 instanceof PDActionEmbeddedGoTo);
    assertNull(getResult.getNext());
    assertNull(getResult2.getNext());
    assertNull(((PDActionEmbeddedGoTo) getResult).getFile());
    assertNull(((PDActionEmbeddedGoTo) getResult2).getFile());
    assertNull(((PDActionEmbeddedGoTo) getResult).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) getResult2).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) getResult).getDestination());
    assertNull(((PDActionEmbeddedGoTo) getResult2).getDestination());
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) getResult).getOpenInNewWindow());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) getResult2).getOpenInNewWindow());
    assertEquals(PDAction.TYPE, getResult.getType());
    assertEquals(PDAction.TYPE, getResult2.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, getResult.getSubType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, getResult2.getSubType());
  }

  /**
   * Method under test: {@link PDAction#setNext(List)}
   */
  @Test
  void testSetNext4() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    ArrayList<PDAction> next = new ArrayList<>();
    next.addAll(new ArrayList<>());
    next.add(null);

    // Act
    pdActionEmbeddedGoTo.setNext(next);

    // Assert
    List<PDAction> next2 = pdActionEmbeddedGoTo.getNext();
    assertEquals(1, next2.size());
    assertNull(next2.get(0));
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }
}

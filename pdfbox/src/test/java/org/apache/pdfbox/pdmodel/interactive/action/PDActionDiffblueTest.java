package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDActionDiffblueTest {
  /**
   * Test {@link PDAction#getCOSObject()}.
   *
   * <p>Method under test: {@link PDAction#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDAction.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    COSDictionary actualCOSObject = pdActionEmbeddedGoTo.getCOSObject();

    // Assert
    assertSame(pdActionEmbeddedGoTo.action, actualCOSObject);
  }

  /**
   * Test {@link PDAction#getType()}.
   *
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#getType()}
   */
  @Test
  @DisplayName(
      "Test getType(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAction.getType()"})
  void testGetType_givenPDActionEmbeddedGoToWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDActionEmbeddedGoTo(new COSDictionary()).getType());
  }

  /**
   * Test {@link PDAction#getType()}.
   *
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.
   *   <li>Then return {@link PDAction#TYPE}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#getType()}
   */
  @Test
  @DisplayName("Test getType(); given PDActionEmbeddedGoTo(); then return TYPE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAction.getType()"})
  void testGetType_givenPDActionEmbeddedGoTo_thenReturnType() {
    // Arrange, Act and Assert
    assertEquals(PDAction.TYPE, new PDActionEmbeddedGoTo().getType());
  }

  /**
   * Test {@link PDAction#setType(String)}.
   *
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.
   *   <li>When {@code 42}.
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} Type is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#setType(String)}
   */
  @Test
  @DisplayName(
      "Test setType(String); given PDActionEmbeddedGoTo(); when '42'; then PDActionEmbeddedGoTo() Type is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAction.setType(String)"})
  void testSetType_givenPDActionEmbeddedGoTo_when42_thenPDActionEmbeddedGoToTypeIs42() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setType("42");

    // Assert
    assertEquals("42", pdActionEmbeddedGoTo.getType());
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAction#setType(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} Type is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#setType(String)}
   */
  @Test
  @DisplayName("Test setType(String); when 'null'; then PDActionEmbeddedGoTo() Type is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAction.setType(String)"})
  void testSetType_whenNull_thenPDActionEmbeddedGoToTypeIsNull() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setType(null);

    // Assert
    assertNull(pdActionEmbeddedGoTo.getType());
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAction#setType(String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} Type is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#setType(String)}
   */
  @Test
  @DisplayName("Test setType(String); when 'Type'; then PDActionEmbeddedGoTo() Type is 'Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAction.setType(String)"})
  void testSetType_whenType_thenPDActionEmbeddedGoToTypeIsType() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setType("Type");

    // Assert
    assertEquals("Type", pdActionEmbeddedGoTo.getType());
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAction#getSubType()}.
   *
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#getSubType()}
   */
  @Test
  @DisplayName(
      "Test getSubType(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAction.getSubType()"})
  void testGetSubType_givenPDActionEmbeddedGoToWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDActionEmbeddedGoTo(new COSDictionary()).getSubType());
  }

  /**
   * Test {@link PDAction#getSubType()}.
   *
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.
   *   <li>Then return {@link PDActionEmbeddedGoTo#SUB_TYPE}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#getSubType()}
   */
  @Test
  @DisplayName("Test getSubType(); given PDActionEmbeddedGoTo(); then return SUB_TYPE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAction.getSubType()"})
  void testGetSubType_givenPDActionEmbeddedGoTo_thenReturnSub_type() {
    // Arrange, Act and Assert
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, new PDActionEmbeddedGoTo().getSubType());
  }

  /**
   * Test {@link PDAction#setSubType(String)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} SubType is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#setSubType(String)}
   */
  @Test
  @DisplayName("Test setSubType(String); when 'foo'; then PDActionEmbeddedGoTo() SubType is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAction.setSubType(String)"})
  void testSetSubType_whenFoo_thenPDActionEmbeddedGoToSubTypeIsFoo() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setSubType("foo");

    // Assert
    assertEquals("foo", pdActionEmbeddedGoTo.getSubType());
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAction#setSubType(String)}.
   *
   * <ul>
   *   <li>When {@code foofoo}.
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} SubType is {@code foofoo}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#setSubType(String)}
   */
  @Test
  @DisplayName(
      "Test setSubType(String); when 'foofoo'; then PDActionEmbeddedGoTo() SubType is 'foofoo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAction.setSubType(String)"})
  void testSetSubType_whenFoofoo_thenPDActionEmbeddedGoToSubTypeIsFoofoo() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setSubType("foofoo");

    // Assert
    assertEquals("foofoo", pdActionEmbeddedGoTo.getSubType());
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAction#setSubType(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} SubType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#setSubType(String)}
   */
  @Test
  @DisplayName(
      "Test setSubType(String); when 'null'; then PDActionEmbeddedGoTo() SubType is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAction.setSubType(String)"})
  void testSetSubType_whenNull_thenPDActionEmbeddedGoToSubTypeIsNull() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setSubType(null);

    // Assert
    assertNull(pdActionEmbeddedGoTo.getSubType());
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAction#getNext()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName(
      "Test getNext(); given ArrayList() add PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDAction.getNext()"})
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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)} with a is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName(
      "Test getNext(); given ArrayList() add PDActionEmbeddedGoTo(COSDictionary) with a is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDAction.getNext()"})
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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDActionGoTo#PDActionGoTo()}.
   *   <li>Then first return {@link PDActionGoTo}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName(
      "Test getNext(); given ArrayList() add PDActionGoTo(); then first return PDActionGoTo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDAction.getNext()"})
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
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) getResult).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, getResult.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Test {@link PDAction#getNext()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDActionHide#PDActionHide()}.
   *   <li>Then first return {@link PDActionHide}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName(
      "Test getNext(); given ArrayList() add PDActionHide(); then first return PDActionHide")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDAction.getNext()"})
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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDActionLaunch#PDActionLaunch()}.
   *   <li>Then first return {@link PDActionLaunch}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName(
      "Test getNext(); given ArrayList() add PDActionLaunch(); then first return PDActionLaunch")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDAction.getNext()"})
  void testGetNext_givenArrayListAddPDActionLaunch_thenFirstReturnPDActionLaunch()
      throws IOException {
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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDActionMovie#PDActionMovie()}.
   *   <li>Then first return {@link PDActionMovie}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName(
      "Test getNext(); given ArrayList() add PDActionMovie(); then first return PDActionMovie")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDAction.getNext()"})
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
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDActionMovie.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Test {@link PDAction#getNext()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDActionNamed#PDActionNamed()}.
   *   <li>Then first return {@link PDActionNamed}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName(
      "Test getNext(); given ArrayList() add PDActionNamed(); then first return PDActionNamed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDAction.getNext()"})
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
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, getResult.getType());
    assertEquals(PDActionNamed.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Test {@link PDAction#getNext()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDActionResetForm#PDActionResetForm()}.
   *   <li>Then first return {@link PDActionResetForm}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName(
      "Test getNext(); given ArrayList() add PDActionResetForm(); then first return PDActionResetForm")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDAction.getNext()"})
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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDActionSound#PDActionSound()}.
   *   <li>Then first return {@link PDActionSound}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName(
      "Test getNext(); given ArrayList() add PDActionSound(); then first return PDActionSound")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDAction.getNext()"})
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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDActionThread#PDActionThread()}.
   *   <li>Then first return {@link PDActionThread}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName(
      "Test getNext(); given ArrayList() add PDActionThread(); then first return PDActionThread")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDAction.getNext()"})
  void testGetNext_givenArrayListAddPDActionThread_thenFirstReturnPDActionThread()
      throws IOException {
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
   *
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} Next is {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName(
      "Test getNext(); given PDActionEmbeddedGoTo() Next is ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDAction.getNext()"})
  void testGetNext_givenPDActionEmbeddedGoToNextIsArrayList_thenReturnEmpty() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();
    pdActionEmbeddedGoTo.setNext(new ArrayList<>());

    // Act and Assert
    assertTrue(pdActionEmbeddedGoTo.getNext().isEmpty());
  }

  /**
   * Test {@link PDAction#getNext()}.
   *
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()} SubType is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName(
      "Test getNext(); given PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary() SubType is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDAction.getNext()"})
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
   *
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); given PDActionEmbeddedGoTo(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDAction.getNext()"})
  void testGetNext_givenPDActionEmbeddedGoTo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDActionEmbeddedGoTo().getNext());
  }

  /**
   * Test {@link PDAction#getNext()}.
   *
   * <ul>
   *   <li>Then first return {@link PDActionEmbeddedGoTo}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); then first return PDActionEmbeddedGoTo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDAction.getNext()"})
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
   *
   * <ul>
   *   <li>Then first return {@link PDActionImportData}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); then first return PDActionImportData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDAction.getNext()"})
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
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) getResult).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, getResult.getType());
    assertEquals(PDActionImportData.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Test {@link PDAction#getNext()}.
   *
   * <ul>
   *   <li>Then first return {@link PDActionJavaScript}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); then first return PDActionJavaScript")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDAction.getNext()"})
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
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, getResult.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, getResult.getSubType());
  }

  /**
   * Test {@link PDAction#getNext()}.
   *
   * <ul>
   *   <li>Then first return {@link PDActionRemoteGoTo}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); then first return PDActionRemoteGoTo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDAction.getNext()"})
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
   *
   * <ul>
   *   <li>Then first return {@link PDActionSubmitForm}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#getNext()}
   */
  @Test
  @DisplayName("Test getNext(); then first return PDActionSubmitForm")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDAction.getNext()"})
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
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} Next is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#setNext(List)}
   */
  @Test
  @DisplayName("Test setNext(List); given 'null'; then PDActionEmbeddedGoTo() Next is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAction.setNext(List)"})
  void testSetNext_givenNull_thenPDActionEmbeddedGoToNextIsArrayList() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    ArrayList<PDAction> next = new ArrayList<>();
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
   *
   * <ul>
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} Next size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#setNext(List)}
   */
  @Test
  @DisplayName("Test setNext(List); then PDActionEmbeddedGoTo() Next size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAction.setNext(List)"})
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
   *
   * <ul>
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} Next size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#setNext(List)}
   */
  @Test
  @DisplayName("Test setNext(List); then PDActionEmbeddedGoTo() Next size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAction.setNext(List)"})
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
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} Next Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDAction#setNext(List)}
   */
  @Test
  @DisplayName("Test setNext(List); when ArrayList(); then PDActionEmbeddedGoTo() Next Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAction.setNext(List)"})
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

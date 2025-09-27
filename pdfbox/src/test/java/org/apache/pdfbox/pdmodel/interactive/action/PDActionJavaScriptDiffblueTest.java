package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDActionJavaScriptDiffblueTest {
  /**
   * Test {@link PDActionJavaScript#PDActionJavaScript(COSDictionary)}.
   *
   * <p>Method under test: {@link PDActionJavaScript#PDActionJavaScript(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDActionJavaScript(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionJavaScript.<init>(COSDictionary)"})
  void testNewPDActionJavaScript() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, new PDActionJavaScript(a).getCOSObject());
  }

  /**
   * Test {@link PDActionJavaScript#PDActionJavaScript()}.
   *
   * <p>Method under test: {@link PDActionJavaScript#PDActionJavaScript()}
   */
  @Test
  @DisplayName("Test new PDActionJavaScript()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionJavaScript.<init>()"})
  void testNewPDActionJavaScript2() {
    // Arrange and Act
    PDActionJavaScript actualPdActionJavaScript = new PDActionJavaScript();

    // Assert
    assertNull(actualPdActionJavaScript.getAction());
    assertNull(actualPdActionJavaScript.getNext());
    COSDictionary cOSObject = actualPdActionJavaScript.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualPdActionJavaScript.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualPdActionJavaScript.getSubType());
  }

  /**
   * Test {@link PDActionJavaScript#PDActionJavaScript(String)}.
   *
   * <ul>
   *   <li>When {@code Js}.
   *   <li>Then return Action is {@code Js}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionJavaScript#PDActionJavaScript(String)}
   */
  @Test
  @DisplayName("Test new PDActionJavaScript(String); when 'Js'; then return Action is 'Js'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionJavaScript.<init>(String)"})
  void testNewPDActionJavaScript_whenJs_thenReturnActionIsJs() {
    // Arrange and Act
    PDActionJavaScript actualPdActionJavaScript = new PDActionJavaScript("Js");

    // Assert
    assertEquals("Js", actualPdActionJavaScript.getAction());
    assertNull(actualPdActionJavaScript.getNext());
    COSDictionary cOSObject = actualPdActionJavaScript.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPdActionJavaScript.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualPdActionJavaScript.getSubType());
  }

  /**
   * Test {@link PDActionJavaScript#PDActionJavaScript(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Action is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionJavaScript#PDActionJavaScript(String)}
   */
  @Test
  @DisplayName("Test new PDActionJavaScript(String); when 'null'; then return Action is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionJavaScript.<init>(String)"})
  void testNewPDActionJavaScript_whenNull_thenReturnActionIsNull() {
    // Arrange and Act
    PDActionJavaScript actualPdActionJavaScript = new PDActionJavaScript((String) null);

    // Assert
    assertNull(actualPdActionJavaScript.getAction());
    assertNull(actualPdActionJavaScript.getNext());
    COSDictionary cOSObject = actualPdActionJavaScript.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualPdActionJavaScript.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualPdActionJavaScript.getSubType());
  }

  /**
   * Test {@link PDActionJavaScript#setAction(String)}.
   *
   * <ul>
   *   <li>Given {@link PDActionJavaScript#PDActionJavaScript()}.
   *   <li>Then {@link PDActionJavaScript#PDActionJavaScript()} Action is {@code S Action}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionJavaScript#setAction(String)}
   */
  @Test
  @DisplayName(
      "Test setAction(String); given PDActionJavaScript(); then PDActionJavaScript() Action is 'S Action'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionJavaScript.setAction(String)"})
  void testSetAction_givenPDActionJavaScript_thenPDActionJavaScriptActionIsSAction() {
    // Arrange
    PDActionJavaScript pdActionJavaScript = new PDActionJavaScript();

    // Act
    pdActionJavaScript.setAction("S Action");

    // Assert
    assertEquals("S Action", pdActionJavaScript.getAction());
    COSDictionary cOSObject = pdActionJavaScript.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionJavaScript#setAction(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDActionJavaScript#PDActionJavaScript()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDActionJavaScript#setAction(String)}
   */
  @Test
  @DisplayName(
      "Test setAction(String); when 'null'; then PDActionJavaScript() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionJavaScript.setAction(String)"})
  void testSetAction_whenNull_thenPDActionJavaScriptCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionJavaScript pdActionJavaScript = new PDActionJavaScript();

    // Act
    pdActionJavaScript.setAction(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionJavaScript.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionJavaScript#getAction()}.
   *
   * <ul>
   *   <li>Given {@link PDActionJavaScript#PDActionJavaScript(String)} with js is empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDActionJavaScript#getAction()}
   */
  @Test
  @DisplayName(
      "Test getAction(); given PDActionJavaScript(String) with js is empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDActionJavaScript.getAction()"})
  void testGetAction_givenPDActionJavaScriptWithJsIsEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new PDActionJavaScript("").getAction());
  }

  /**
   * Test {@link PDActionJavaScript#getAction()}.
   *
   * <ul>
   *   <li>Given {@link PDActionJavaScript#PDActionJavaScript(String)} with {@code Js}.
   *   <li>Then return {@code Js}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionJavaScript#getAction()}
   */
  @Test
  @DisplayName("Test getAction(); given PDActionJavaScript(String) with 'Js'; then return 'Js'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDActionJavaScript.getAction()"})
  void testGetAction_givenPDActionJavaScriptWithJs_thenReturnJs() {
    // Arrange, Act and Assert
    assertEquals("Js", new PDActionJavaScript("Js").getAction());
  }

  /**
   * Test {@link PDActionJavaScript#getAction()}.
   *
   * <ul>
   *   <li>Given {@link PDActionJavaScript#PDActionJavaScript()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionJavaScript#getAction()}
   */
  @Test
  @DisplayName("Test getAction(); given PDActionJavaScript(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDActionJavaScript.getAction()"})
  void testGetAction_givenPDActionJavaScript_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDActionJavaScript().getAction());
  }
}

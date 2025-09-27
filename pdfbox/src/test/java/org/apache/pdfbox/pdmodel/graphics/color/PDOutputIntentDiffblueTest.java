package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDOutputIntentDiffblueTest {
  /**
   * Test {@link PDOutputIntent#PDOutputIntent(COSDictionary)}.
   *
   * <p>Method under test: {@link PDOutputIntent#PDOutputIntent(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDOutputIntent(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutputIntent.<init>(COSDictionary)"})
  void testNewPDOutputIntent() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, new PDOutputIntent(dictionary).getCOSObject());
  }

  /**
   * Test {@link PDOutputIntent#getCOSObject()}.
   *
   * <p>Method under test: {@link PDOutputIntent#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDOutputIntent.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, new PDOutputIntent(dictionary).getCOSObject());
  }

  /**
   * Test {@link PDOutputIntent#getDestOutputIntent()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutputIntent#getDestOutputIntent()}
   */
  @Test
  @DisplayName("Test getDestOutputIntent(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSStream PDOutputIntent.getDestOutputIntent()"})
  void testGetDestOutputIntent_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDOutputIntent(new COSDictionary()).getDestOutputIntent());
  }

  /**
   * Test {@link PDOutputIntent#getInfo()}.
   *
   * <ul>
   *   <li>Given {@link PDOutputIntent#PDOutputIntent(COSDictionary)} with dictionary is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutputIntent#getInfo()}
   */
  @Test
  @DisplayName(
      "Test getInfo(); given PDOutputIntent(COSDictionary) with dictionary is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDOutputIntent.getInfo()"})
  void testGetInfo_givenPDOutputIntentWithDictionaryIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDOutputIntent(new COSDictionary()).getInfo());
  }

  /**
   * Test {@link PDOutputIntent#setInfo(String)}.
   *
   * <ul>
   *   <li>Then {@link PDOutputIntent#PDOutputIntent(COSDictionary)} with dictionary is {@link
   *       COSDictionary#COSDictionary()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDOutputIntent#setInfo(String)}
   */
  @Test
  @DisplayName(
      "Test setInfo(String); then PDOutputIntent(COSDictionary) with dictionary is COSDictionary() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutputIntent.setInfo(String)"})
  void testSetInfo_thenPDOutputIntentWithDictionaryIsCOSDictionaryCOSObjectSizeIsZero() {
    // Arrange
    PDOutputIntent pdOutputIntent = new PDOutputIntent(new COSDictionary());

    // Act
    pdOutputIntent.setInfo(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdOutputIntent.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDOutputIntent#setInfo(String)}.
   *
   * <ul>
   *   <li>Then {@link PDOutputIntent#PDOutputIntent(COSDictionary)} with dictionary is {@link
   *       COSDictionary#COSDictionary()} Info is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutputIntent#setInfo(String)}
   */
  @Test
  @DisplayName(
      "Test setInfo(String); then PDOutputIntent(COSDictionary) with dictionary is COSDictionary() Info is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutputIntent.setInfo(String)"})
  void testSetInfo_thenPDOutputIntentWithDictionaryIsCOSDictionaryInfoIs42() {
    // Arrange
    PDOutputIntent pdOutputIntent = new PDOutputIntent(new COSDictionary());

    // Act
    pdOutputIntent.setInfo("42");

    // Assert
    assertEquals("42", pdOutputIntent.getInfo());
    COSDictionary cOSObject = pdOutputIntent.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDOutputIntent#getOutputCondition()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutputIntent#getOutputCondition()}
   */
  @Test
  @DisplayName("Test getOutputCondition(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDOutputIntent.getOutputCondition()"})
  void testGetOutputCondition_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDOutputIntent(new COSDictionary()).getOutputCondition());
  }

  /**
   * Test {@link PDOutputIntent#setOutputCondition(String)}.
   *
   * <p>Method under test: {@link PDOutputIntent#setOutputCondition(String)}
   */
  @Test
  @DisplayName("Test setOutputCondition(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutputIntent.setOutputCondition(String)"})
  void testSetOutputCondition() {
    // Arrange
    PDOutputIntent pdOutputIntent = new PDOutputIntent(new COSDictionary());

    // Act
    pdOutputIntent.setOutputCondition("42");

    // Assert
    assertEquals("42", pdOutputIntent.getOutputCondition());
    COSDictionary cOSObject = pdOutputIntent.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDOutputIntent#setOutputCondition(String)}.
   *
   * <p>Method under test: {@link PDOutputIntent#setOutputCondition(String)}
   */
  @Test
  @DisplayName("Test setOutputCondition(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutputIntent.setOutputCondition(String)"})
  void testSetOutputCondition2() {
    // Arrange
    PDOutputIntent pdOutputIntent = new PDOutputIntent(new COSDictionary());

    // Act
    pdOutputIntent.setOutputCondition(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdOutputIntent.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDOutputIntent#getOutputConditionIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutputIntent#getOutputConditionIdentifier()}
   */
  @Test
  @DisplayName("Test getOutputConditionIdentifier(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDOutputIntent.getOutputConditionIdentifier()"})
  void testGetOutputConditionIdentifier_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDOutputIntent(new COSDictionary()).getOutputConditionIdentifier());
  }

  /**
   * Test {@link PDOutputIntent#setOutputConditionIdentifier(String)}.
   *
   * <p>Method under test: {@link PDOutputIntent#setOutputConditionIdentifier(String)}
   */
  @Test
  @DisplayName("Test setOutputConditionIdentifier(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutputIntent.setOutputConditionIdentifier(String)"})
  void testSetOutputConditionIdentifier() {
    // Arrange
    PDOutputIntent pdOutputIntent = new PDOutputIntent(new COSDictionary());

    // Act
    pdOutputIntent.setOutputConditionIdentifier("42");

    // Assert
    assertEquals("42", pdOutputIntent.getOutputConditionIdentifier());
    COSDictionary cOSObject = pdOutputIntent.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDOutputIntent#setOutputConditionIdentifier(String)}.
   *
   * <p>Method under test: {@link PDOutputIntent#setOutputConditionIdentifier(String)}
   */
  @Test
  @DisplayName("Test setOutputConditionIdentifier(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutputIntent.setOutputConditionIdentifier(String)"})
  void testSetOutputConditionIdentifier2() {
    // Arrange
    PDOutputIntent pdOutputIntent = new PDOutputIntent(new COSDictionary());

    // Act
    pdOutputIntent.setOutputConditionIdentifier(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdOutputIntent.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDOutputIntent#getRegistryName()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutputIntent#getRegistryName()}
   */
  @Test
  @DisplayName("Test getRegistryName(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDOutputIntent.getRegistryName()"})
  void testGetRegistryName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDOutputIntent(new COSDictionary()).getRegistryName());
  }

  /**
   * Test {@link PDOutputIntent#setRegistryName(String)}.
   *
   * <p>Method under test: {@link PDOutputIntent#setRegistryName(String)}
   */
  @Test
  @DisplayName("Test setRegistryName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutputIntent.setRegistryName(String)"})
  void testSetRegistryName() {
    // Arrange
    PDOutputIntent pdOutputIntent = new PDOutputIntent(new COSDictionary());

    // Act
    pdOutputIntent.setRegistryName("42");

    // Assert
    assertEquals("42", pdOutputIntent.getRegistryName());
    COSDictionary cOSObject = pdOutputIntent.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDOutputIntent#setRegistryName(String)}.
   *
   * <p>Method under test: {@link PDOutputIntent#setRegistryName(String)}
   */
  @Test
  @DisplayName("Test setRegistryName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutputIntent.setRegistryName(String)"})
  void testSetRegistryName2() {
    // Arrange
    PDOutputIntent pdOutputIntent = new PDOutputIntent(new COSDictionary());

    // Act
    pdOutputIntent.setRegistryName(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdOutputIntent.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }
}

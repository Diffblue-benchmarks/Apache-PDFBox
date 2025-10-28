package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;

class PDOutputIntentDiffblueTest {
  /**
   * Method under test: {@link PDOutputIntent#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, (new PDOutputIntent(dictionary)).getCOSObject());
  }

  /**
   * Method under test: {@link PDOutputIntent#getDestOutputIntent()}
   */
  @Test
  void testGetDestOutputIntent() {
    // Arrange, Act and Assert
    assertNull((new PDOutputIntent(new COSDictionary())).getDestOutputIntent());
  }

  /**
   * Method under test: {@link PDOutputIntent#getInfo()}
   */
  @Test
  void testGetInfo() {
    // Arrange, Act and Assert
    assertNull((new PDOutputIntent(new COSDictionary())).getInfo());
  }

  /**
   * Method under test: {@link PDOutputIntent#setInfo(String)}
   */
  @Test
  void testSetInfo() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();
    PDOutputIntent pdOutputIntent = new PDOutputIntent(dictionary);

    // Act
    pdOutputIntent.setInfo("42");

    // Assert
    assertEquals("42", pdOutputIntent.getInfo());
    assertSame(dictionary, pdOutputIntent.getCOSObject());
  }

  /**
   * Method under test: {@link PDOutputIntent#getOutputCondition()}
   */
  @Test
  void testGetOutputCondition() {
    // Arrange, Act and Assert
    assertNull((new PDOutputIntent(new COSDictionary())).getOutputCondition());
  }

  /**
   * Method under test: {@link PDOutputIntent#setOutputCondition(String)}
   */
  @Test
  void testSetOutputCondition() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();
    PDOutputIntent pdOutputIntent = new PDOutputIntent(dictionary);

    // Act
    pdOutputIntent.setOutputCondition("42");

    // Assert
    assertEquals("42", pdOutputIntent.getOutputCondition());
    assertSame(dictionary, pdOutputIntent.getCOSObject());
  }

  /**
   * Method under test: {@link PDOutputIntent#getOutputConditionIdentifier()}
   */
  @Test
  void testGetOutputConditionIdentifier() {
    // Arrange, Act and Assert
    assertNull((new PDOutputIntent(new COSDictionary())).getOutputConditionIdentifier());
  }

  /**
   * Method under test:
   * {@link PDOutputIntent#setOutputConditionIdentifier(String)}
   */
  @Test
  void testSetOutputConditionIdentifier() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();
    PDOutputIntent pdOutputIntent = new PDOutputIntent(dictionary);

    // Act
    pdOutputIntent.setOutputConditionIdentifier("42");

    // Assert
    assertEquals("42", pdOutputIntent.getOutputConditionIdentifier());
    assertSame(dictionary, pdOutputIntent.getCOSObject());
  }

  /**
   * Method under test: {@link PDOutputIntent#getRegistryName()}
   */
  @Test
  void testGetRegistryName() {
    // Arrange, Act and Assert
    assertNull((new PDOutputIntent(new COSDictionary())).getRegistryName());
  }

  /**
   * Method under test: {@link PDOutputIntent#setRegistryName(String)}
   */
  @Test
  void testSetRegistryName() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();
    PDOutputIntent pdOutputIntent = new PDOutputIntent(dictionary);

    // Act
    pdOutputIntent.setRegistryName("42");

    // Assert
    assertEquals("42", pdOutputIntent.getRegistryName());
    assertSame(dictionary, pdOutputIntent.getCOSObject());
  }

  /**
   * Method under test: {@link PDOutputIntent#PDOutputIntent(COSDictionary)}
   */
  @Test
  void testNewPDOutputIntent() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, (new PDOutputIntent(dictionary)).getCOSObject());
  }
}

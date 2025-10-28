package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.Map;
import org.junit.jupiter.api.Test;

class CFFType1FontDiffblueTest {
  /**
   * Method under test: {@link CFFType1Font#hasGlyph(String)}
   */
  @Test
  void testHasGlyph() {
    // Arrange
    CFFType1Font cffType1Font = new CFFType1Font();
    cffType1Font.setCharset(new CFFCharsetType1());

    // Act and Assert
    assertFalse(cffType1Font.hasGlyph("Name"));
  }

  /**
   * Method under test: {@link CFFType1Font#hasGlyph(String)}
   */
  @Test
  void testHasGlyph2() {
    // Arrange
    CFFCharsetType1 charset = new CFFCharsetType1();
    charset.addSID(2, 0, "42");

    CFFType1Font cffType1Font = new CFFType1Font();
    cffType1Font.setCharset(charset);

    // Act and Assert
    assertTrue(cffType1Font.hasGlyph("Name"));
  }

  /**
   * Method under test: {@link CFFType1Font#nameToGID(String)}
   */
  @Test
  void testNameToGID() {
    // Arrange
    CFFType1Font cffType1Font = new CFFType1Font();
    cffType1Font.setCharset(new CFFCharsetType1());

    // Act and Assert
    assertEquals(0, cffType1Font.nameToGID("Name"));
  }

  /**
   * Method under test: {@link CFFType1Font#addToPrivateDict(String, Object)}
   */
  @Test
  void testAddToPrivateDict() {
    // Arrange
    CFFType1Font cffType1Font = new CFFType1Font();

    // Act
    cffType1Font.addToPrivateDict("Name", "Value");

    // Assert
    Map<String, Object> privateDict = cffType1Font.getPrivateDict();
    assertEquals(1, privateDict.size());
    assertEquals("Value", privateDict.get("Name"));
  }

  /**
   * Method under test: {@link CFFType1Font#addToPrivateDict(String, Object)}
   */
  @Test
  void testAddToPrivateDict2() {
    // Arrange
    CFFType1Font cffType1Font = new CFFType1Font();

    // Act
    cffType1Font.addToPrivateDict("Name", null);

    // Assert that nothing has changed
    assertTrue(cffType1Font.getPrivateDict().isEmpty());
  }

  /**
   * Method under test: {@link CFFType1Font#addToPrivateDict(String, Object)}
   */
  @Test
  void testAddToPrivateDict3() {
    // Arrange
    CFFType1Font cffType1Font = new CFFType1Font();
    cffType1Font.setData(mock(CFFParser.ByteSource.class));

    // Act
    cffType1Font.addToPrivateDict("Name", "Value");

    // Assert
    Map<String, Object> privateDict = cffType1Font.getPrivateDict();
    assertEquals(1, privateDict.size());
    assertEquals("Value", privateDict.get("Name"));
  }

  /**
   * Method under test: {@link CFFType1Font#getEncoding()}
   */
  @Test
  void testGetEncoding() {
    // Arrange, Act and Assert
    assertNull((new CFFType1Font()).getEncoding());
  }

  /**
   * Method under test: {@link CFFType1Font#getEncoding()}
   */
  @Test
  void testGetEncoding2() {
    // Arrange
    CFFType1Font cffType1Font = new CFFType1Font();
    cffType1Font.setData(mock(CFFParser.ByteSource.class));

    // Act and Assert
    assertNull(cffType1Font.getEncoding());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CFFType1Font#setEncoding(CFFEncoding)}
   *   <li>{@link CFFType1Font#getPrivateDict()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    CFFType1Font cffType1Font = new CFFType1Font();

    // Act
    cffType1Font.setEncoding(CFFExpertEncoding.getInstance());

    // Assert that nothing has changed
    assertTrue(cffType1Font.getPrivateDict().isEmpty());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link CFFType1Font}
   */
  @Test
  void testNewCFFType1Font() {
    // Arrange and Act
    CFFType1Font actualCffType1Font = new CFFType1Font();

    // Assert
    assertNull(actualCffType1Font.charStrings);
    assertNull(actualCffType1Font.globalSubrIndex);
    assertNull(actualCffType1Font.getName());
    assertNull(actualCffType1Font.getFontMatrix());
    assertNull(actualCffType1Font.getCharset());
    assertNull(actualCffType1Font.getEncoding());
    assertTrue(actualCffType1Font.getTopDict().isEmpty());
    assertTrue(actualCffType1Font.getPrivateDict().isEmpty());
  }
}

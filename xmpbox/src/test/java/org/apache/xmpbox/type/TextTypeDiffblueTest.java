package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class TextTypeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TextType#getStringValue()}
   *   <li>{@link TextType#getValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TextType textType = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Act
    String actualStringValue = textType.getStringValue();

    // Assert
    assertEquals("Value", actualStringValue);
    assertEquals("Value", textType.getValue());
  }

  /**
   * Method under test: {@link TextType#setValue(Object)}
   */
  @Test
  void testSetValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value"))
            .setValue(42));
  }

  /**
   * Method under test:
   * {@link TextType#TextType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewTextType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    TextType actualTextType = new TextType(metadata, "Namespace URI", "Prefix", "Property Name", "Value");

    // Assert
    assertEquals("Namespace URI", actualTextType.getNamespace());
    assertEquals("Prefix", actualTextType.getPrefix());
    assertEquals("Property Name", actualTextType.getPropertyName());
    assertEquals("Value", actualTextType.getStringValue());
    assertEquals("Value", actualTextType.getRawValue());
    assertEquals("Value", actualTextType.getValue());
    assertTrue(actualTextType.getAllAttributes().isEmpty());
    assertSame(metadata, actualTextType.getMetadata());
  }

  /**
   * Method under test:
   * {@link TextType#TextType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewTextType2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42));

  }
}

package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TextTypeDiffblueTest {
  /**
   * Test {@link TextType#TextType(XMPMetadata, String, String, String, Object)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextType#TextType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName("Test new TextType(XMPMetadata, String, String, String, Object); when forty-two; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TextType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewTextType_whenFortyTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42));

  }

  /**
   * Test {@link TextType#TextType(XMPMetadata, String, String, String, Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return Namespace is {@code Namespace URI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextType#TextType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName("Test new TextType(XMPMetadata, String, String, String, Object); when 'Value'; then return Namespace is 'Namespace URI'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TextType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewTextType_whenValue_thenReturnNamespaceIsNamespaceUri() {
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
   * Test {@link TextType#setValue(Object)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextType#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object); when forty-two; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TextType.setValue(Object)"})
  void testSetValue_whenFortyTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value"))
            .setValue(42));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TextType#getStringValue()}
   *   <li>{@link TextType#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TextType.getStringValue()", "Object TextType.getValue()"})
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
}

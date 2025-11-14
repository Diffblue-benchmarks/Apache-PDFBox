package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RenditionClassTypeDiffblueTest {
  /**
   * Test {@link RenditionClassType#RenditionClassType(XMPMetadata, String, String, String,
   * Object)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RenditionClassType#RenditionClassType(XMPMetadata, String, String,
   * String, Object)}
   */
  @Test
  @DisplayName(
      "Test new RenditionClassType(XMPMetadata, String, String, String, Object); when forty-two; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RenditionClassType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewRenditionClassType_whenFortyTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new RenditionClassType(
                XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42));
  }

  /**
   * Test {@link RenditionClassType#RenditionClassType(XMPMetadata, String, String, String,
   * Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return Namespace is {@code Namespace URI}.
   * </ul>
   *
   * <p>Method under test: {@link RenditionClassType#RenditionClassType(XMPMetadata, String, String,
   * String, Object)}
   */
  @Test
  @DisplayName(
      "Test new RenditionClassType(XMPMetadata, String, String, String, Object); when 'Value'; then return Namespace is 'Namespace URI'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RenditionClassType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewRenditionClassType_whenValue_thenReturnNamespaceIsNamespaceUri() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    RenditionClassType actualRenditionClassType =
        new RenditionClassType(metadata, "Namespace URI", "Prefix", "Property Name", "Value");

    // Assert
    assertEquals("Namespace URI", actualRenditionClassType.getNamespace());
    assertEquals("Prefix", actualRenditionClassType.getPrefix());
    assertEquals("Property Name", actualRenditionClassType.getPropertyName());
    assertEquals("Value", actualRenditionClassType.getStringValue());
    assertEquals("Value", actualRenditionClassType.getRawValue());
    assertEquals("Value", actualRenditionClassType.getValue());
    assertTrue(actualRenditionClassType.getAllAttributes().isEmpty());
    assertSame(metadata, actualRenditionClassType.getMetadata());
  }
}

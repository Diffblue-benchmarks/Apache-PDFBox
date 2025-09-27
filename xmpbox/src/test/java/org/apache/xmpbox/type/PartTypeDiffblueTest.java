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

class PartTypeDiffblueTest {
  /**
   * Test {@link PartType#PartType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PartType#PartType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName(
      "Test new PartType(XMPMetadata, String, String, String, Object); when forty-two; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PartType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewPartType_whenFortyTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new PartType(
                XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42));
  }

  /**
   * Test {@link PartType#PartType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return Namespace is {@code Namespace URI}.
   * </ul>
   *
   * <p>Method under test: {@link PartType#PartType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName(
      "Test new PartType(XMPMetadata, String, String, String, Object); when 'Value'; then return Namespace is 'Namespace URI'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PartType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewPartType_whenValue_thenReturnNamespaceIsNamespaceUri() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PartType actualPartType =
        new PartType(metadata, "Namespace URI", "Prefix", "Property Name", "Value");

    // Assert
    assertEquals("Namespace URI", actualPartType.getNamespace());
    assertEquals("Prefix", actualPartType.getPrefix());
    assertEquals("Property Name", actualPartType.getPropertyName());
    assertEquals("Value", actualPartType.getStringValue());
    assertEquals("Value", actualPartType.getRawValue());
    assertEquals("Value", actualPartType.getValue());
    assertTrue(actualPartType.getAllAttributes().isEmpty());
    assertSame(metadata, actualPartType.getMetadata());
  }
}

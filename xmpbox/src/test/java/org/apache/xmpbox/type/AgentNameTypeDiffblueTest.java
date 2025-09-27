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

class AgentNameTypeDiffblueTest {
  /**
   * Test {@link AgentNameType#AgentNameType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AgentNameType#AgentNameType(XMPMetadata, String, String, String,
   * Object)}
   */
  @Test
  @DisplayName(
      "Test new AgentNameType(XMPMetadata, String, String, String, Object); when forty-two; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AgentNameType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewAgentNameType_whenFortyTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new AgentNameType(
                XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42));
  }

  /**
   * Test {@link AgentNameType#AgentNameType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return Namespace is {@code Namespace URI}.
   * </ul>
   *
   * <p>Method under test: {@link AgentNameType#AgentNameType(XMPMetadata, String, String, String,
   * Object)}
   */
  @Test
  @DisplayName(
      "Test new AgentNameType(XMPMetadata, String, String, String, Object); when 'Value'; then return Namespace is 'Namespace URI'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AgentNameType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewAgentNameType_whenValue_thenReturnNamespaceIsNamespaceUri() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    AgentNameType actualAgentNameType =
        new AgentNameType(metadata, "Namespace URI", "Prefix", "Property Name", "Value");

    // Assert
    assertEquals("Namespace URI", actualAgentNameType.getNamespace());
    assertEquals("Prefix", actualAgentNameType.getPrefix());
    assertEquals("Property Name", actualAgentNameType.getPropertyName());
    assertEquals("Value", actualAgentNameType.getStringValue());
    assertEquals("Value", actualAgentNameType.getRawValue());
    assertEquals("Value", actualAgentNameType.getValue());
    assertTrue(actualAgentNameType.getAllAttributes().isEmpty());
    assertSame(metadata, actualAgentNameType.getMetadata());
  }
}

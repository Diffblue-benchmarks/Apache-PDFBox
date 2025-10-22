package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AgentNameTypeDiffblueTest {
  /**
   * Test {@link AgentNameType#AgentNameType(XMPMetadata, String, String, String, Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return Namespace is {@code Namespace URI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AgentNameType#AgentNameType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName("Test new AgentNameType(XMPMetadata, String, String, String, Object); when 'Value'; then return Namespace is 'Namespace URI'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AgentNameType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewAgentNameType_whenValue_thenReturnNamespaceIsNamespaceUri() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    AgentNameType actualAgentNameType = new AgentNameType(metadata, "Namespace URI", "Prefix", "Property Name",
        "Value");

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

package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractSimplePropertyDiffblueTest {
  /**
   * Test {@link AbstractSimpleProperty#getRawValue()}.
   *
   * <p>Method under test: {@link AbstractSimpleProperty#getRawValue()}
   */
  @Test
  @DisplayName("Test getRawValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object AbstractSimpleProperty.getRawValue()"})
  void testGetRawValue() {
    // Arrange
    AgentNameType agentNameType =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act and Assert
    assertEquals("Value", agentNameType.getRawValue());
  }

  /**
   * Test {@link AbstractSimpleProperty#toString()}.
   *
   * <p>Method under test: {@link AbstractSimpleProperty#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AbstractSimpleProperty.toString()"})
  void testToString() {
    // Arrange
    AgentNameType agentNameType =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act and Assert
    assertEquals("[AgentNameType:Value]", agentNameType.toString());
  }

  /**
   * Test {@link AbstractSimpleProperty#getNamespace()}.
   *
   * <p>Method under test: {@link AbstractSimpleProperty#getNamespace()}
   */
  @Test
  @DisplayName("Test getNamespace()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AbstractSimpleProperty.getNamespace()"})
  void testGetNamespace() {
    // Arrange
    AgentNameType agentNameType =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act and Assert
    assertEquals("Namespace URI", agentNameType.getNamespace());
  }

  /**
   * Test {@link AbstractSimpleProperty#getPrefix()}.
   *
   * <p>Method under test: {@link AbstractSimpleProperty#getPrefix()}
   */
  @Test
  @DisplayName("Test getPrefix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AbstractSimpleProperty.getPrefix()"})
  void testGetPrefix() {
    // Arrange
    AgentNameType agentNameType =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act and Assert
    assertEquals("Prefix", agentNameType.getPrefix());
  }
}

package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DefinedStructuredTypeDiffblueTest {
  /**
   * Test {@link DefinedStructuredType#DefinedStructuredType(XMPMetadata)}.
   *
   * <p>Method under test: {@link DefinedStructuredType#DefinedStructuredType(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new DefinedStructuredType(XMPMetadata)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefinedStructuredType.<init>(XMPMetadata)"})
  void testNewDefinedStructuredType() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new DefinedStructuredType(XMPMetadata.createXMPMetadata()));
  }

  /**
   * Test {@link DefinedStructuredType#DefinedStructuredType(XMPMetadata, String, String, String)}.
   *
   * <ul>
   *   <li>Then return PreferedPrefix is {@code Field Prefix}.
   * </ul>
   *
   * <p>Method under test: {@link DefinedStructuredType#DefinedStructuredType(XMPMetadata, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test new DefinedStructuredType(XMPMetadata, String, String, String); then return PreferedPrefix is 'Field Prefix'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefinedStructuredType.<init>(XMPMetadata, String, String, String)"})
  void testNewDefinedStructuredType_thenReturnPreferedPrefixIsFieldPrefix() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    DefinedStructuredType actualDefinedStructuredType =
        new DefinedStructuredType(metadata, "Namespace URI", "Field Prefix", "Property Name");

    // Assert
    assertEquals("Field Prefix", actualDefinedStructuredType.getPreferedPrefix());
    assertEquals("Field Prefix", actualDefinedStructuredType.getPrefix());
    assertEquals("Namespace URI", actualDefinedStructuredType.getNamespace());
    assertEquals("Property Name", actualDefinedStructuredType.getPropertyName());
    assertTrue(actualDefinedStructuredType.getAllProperties().isEmpty());
    assertTrue(actualDefinedStructuredType.getAllAttributes().isEmpty());
    assertTrue(actualDefinedStructuredType.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(actualDefinedStructuredType.getDefinedProperties().isEmpty());
    assertSame(metadata, actualDefinedStructuredType.getMetadata());
  }

  /**
   * Test {@link DefinedStructuredType#DefinedStructuredType(XMPMetadata, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Namespace URI}.
   *   <li>Then return PreferedPrefix is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefinedStructuredType#DefinedStructuredType(XMPMetadata, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test new DefinedStructuredType(XMPMetadata, String, String, String); when 'Namespace URI'; then return PreferedPrefix is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefinedStructuredType.<init>(XMPMetadata, String, String, String)"})
  void testNewDefinedStructuredType_whenNamespaceUri_thenReturnPreferedPrefixIsNull() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    DefinedStructuredType actualDefinedStructuredType =
        new DefinedStructuredType(metadata, "Namespace URI", null, "Property Name");

    // Assert
    assertEquals("Namespace URI", actualDefinedStructuredType.getNamespace());
    assertEquals("Property Name", actualDefinedStructuredType.getPropertyName());
    assertNull(actualDefinedStructuredType.getPreferedPrefix());
    assertNull(actualDefinedStructuredType.getPrefix());
    assertTrue(actualDefinedStructuredType.getAllProperties().isEmpty());
    assertTrue(actualDefinedStructuredType.getAllAttributes().isEmpty());
    assertTrue(actualDefinedStructuredType.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(actualDefinedStructuredType.getDefinedProperties().isEmpty());
    assertSame(metadata, actualDefinedStructuredType.getMetadata());
  }

  /**
   * Test {@link DefinedStructuredType#DefinedStructuredType(XMPMetadata, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefinedStructuredType#DefinedStructuredType(XMPMetadata, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test new DefinedStructuredType(XMPMetadata, String, String, String); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefinedStructuredType.<init>(XMPMetadata, String, String, String)"})
  void testNewDefinedStructuredType_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new DefinedStructuredType(
                XMPMetadata.createXMPMetadata(), null, "Field Prefix", "Property Name"));
  }

  /**
   * Test {@link DefinedStructuredType#addProperty(String, PropertyType)} with {@code name}, {@code
   * type}.
   *
   * <p>Method under test: {@link DefinedStructuredType#addProperty(String, PropertyType)}
   */
  @Test
  @DisplayName("Test addProperty(String, PropertyType) with 'name', 'type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefinedStructuredType.addProperty(String, PropertyType)"})
  void testAddPropertyWithNameType() {
    // Arrange
    DefinedStructuredType definedStructuredType =
        new DefinedStructuredType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Field Prefix", "Property Name");
    PropertyType type = mock(PropertyType.class);

    // Act
    definedStructuredType.addProperty("Name", type);

    // Assert
    Map<String, PropertyType> definedProperties = definedStructuredType.getDefinedProperties();
    assertEquals(1, definedProperties.size());
    assertSame(type, definedProperties.get("Name"));
  }
}

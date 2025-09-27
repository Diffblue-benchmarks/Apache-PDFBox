package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ArrayPropertyDiffblueTest {
  /**
   * Test {@link ArrayProperty#ArrayProperty(XMPMetadata, String, String, String, Cardinality)}.
   *
   * <p>Method under test: {@link ArrayProperty#ArrayProperty(XMPMetadata, String, String, String,
   * Cardinality)}
   */
  @Test
  @DisplayName("Test new ArrayProperty(XMPMetadata, String, String, String, Cardinality)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ArrayProperty.<init>(XMPMetadata, String, String, String, Cardinality)"})
  void testNewArrayProperty() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ArrayProperty actualArrayProperty =
        new ArrayProperty(metadata, "Namespace", "Prefix", "Property Name", Cardinality.Simple);

    // Assert
    assertEquals("Namespace", actualArrayProperty.getNamespace());
    assertEquals("Prefix", actualArrayProperty.getPrefix());
    assertEquals("Property Name", actualArrayProperty.getPropertyName());
    assertEquals(Cardinality.Simple, actualArrayProperty.getArrayType());
    assertTrue(actualArrayProperty.getAllProperties().isEmpty());
    assertTrue(actualArrayProperty.getAllAttributes().isEmpty());
    assertTrue(actualArrayProperty.getElementsAsString().isEmpty());
    assertTrue(actualArrayProperty.getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, actualArrayProperty.getMetadata());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ArrayProperty#getArrayType()}
   *   <li>{@link ArrayProperty#getNamespace()}
   *   <li>{@link ArrayProperty#getPrefix()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Cardinality ArrayProperty.getArrayType()",
    "String ArrayProperty.getNamespace()",
    "String ArrayProperty.getPrefix()"
  })
  void testGettersAndSetters() {
    // Arrange
    ArrayProperty arrayProperty =
        new ArrayProperty(
            XMPMetadata.createXMPMetadata(),
            "Namespace",
            "Prefix",
            "Property Name",
            Cardinality.Simple);

    // Act
    Cardinality actualArrayType = arrayProperty.getArrayType();
    String actualNamespace = arrayProperty.getNamespace();

    // Assert
    assertEquals("Namespace", actualNamespace);
    assertEquals("Prefix", arrayProperty.getPrefix());
    assertEquals(Cardinality.Simple, actualArrayType);
  }

  /**
   * Test {@link ArrayProperty#getElementsAsString()}.
   *
   * <p>Method under test: {@link ArrayProperty#getElementsAsString()}
   */
  @Test
  @DisplayName("Test getElementsAsString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List ArrayProperty.getElementsAsString()"})
  void testGetElementsAsString() {
    // Arrange
    ArrayProperty arrayProperty =
        new ArrayProperty(
            XMPMetadata.createXMPMetadata(),
            "Namespace",
            "Prefix",
            "Property Name",
            Cardinality.Simple);

    // Act and Assert
    assertTrue(arrayProperty.getElementsAsString().isEmpty());
  }
}

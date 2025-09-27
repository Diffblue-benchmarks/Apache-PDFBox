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

class ProperNameTypeDiffblueTest {
  /**
   * Test {@link ProperNameType#ProperNameType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ProperNameType#ProperNameType(XMPMetadata, String, String, String,
   * Object)}
   */
  @Test
  @DisplayName(
      "Test new ProperNameType(XMPMetadata, String, String, String, Object); when forty-two; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProperNameType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewProperNameType_whenFortyTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new ProperNameType(
                XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42));
  }

  /**
   * Test {@link ProperNameType#ProperNameType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return Namespace is {@code Namespace URI}.
   * </ul>
   *
   * <p>Method under test: {@link ProperNameType#ProperNameType(XMPMetadata, String, String, String,
   * Object)}
   */
  @Test
  @DisplayName(
      "Test new ProperNameType(XMPMetadata, String, String, String, Object); when 'Value'; then return Namespace is 'Namespace URI'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProperNameType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewProperNameType_whenValue_thenReturnNamespaceIsNamespaceUri() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ProperNameType actualProperNameType =
        new ProperNameType(metadata, "Namespace URI", "Prefix", "Property Name", "Value");

    // Assert
    assertEquals("Namespace URI", actualProperNameType.getNamespace());
    assertEquals("Prefix", actualProperNameType.getPrefix());
    assertEquals("Property Name", actualProperNameType.getPropertyName());
    assertEquals("Value", actualProperNameType.getStringValue());
    assertEquals("Value", actualProperNameType.getRawValue());
    assertEquals("Value", actualProperNameType.getValue());
    assertTrue(actualProperNameType.getAllAttributes().isEmpty());
    assertSame(metadata, actualProperNameType.getMetadata());
  }
}

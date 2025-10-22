package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IntegerTypeDiffblueTest {
  /**
   * Test {@link IntegerType#IntegerType(XMPMetadata, String, String, String, Object)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return RawValue is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegerType#IntegerType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName("Test new IntegerType(XMPMetadata, String, String, String, Object); when '42'; then return RawValue is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IntegerType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewIntegerType_when42_thenReturnRawValueIs42() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    IntegerType actualIntegerType = new IntegerType(metadata, "Namespace URI", "Prefix", "Property Name", "42");

    // Assert
    assertEquals("42", actualIntegerType.getStringValue());
    assertEquals("42", actualIntegerType.getRawValue());
    assertEquals("Namespace URI", actualIntegerType.getNamespace());
    assertEquals("Prefix", actualIntegerType.getPrefix());
    assertEquals("Property Name", actualIntegerType.getPropertyName());
    assertEquals(42, actualIntegerType.getValue().intValue());
    assertTrue(actualIntegerType.getAllAttributes().isEmpty());
    assertSame(metadata, actualIntegerType.getMetadata());
  }

  /**
   * Test {@link IntegerType#IntegerType(XMPMetadata, String, String, String, Object)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return RawValue intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegerType#IntegerType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName("Test new IntegerType(XMPMetadata, String, String, String, Object); when forty-two; then return RawValue intValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IntegerType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewIntegerType_whenFortyTwo_thenReturnRawValueIntValueIsFortyTwo() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    IntegerType actualIntegerType = new IntegerType(metadata, "Namespace URI", "Prefix", "Property Name", 42);

    // Assert
    assertEquals("42", actualIntegerType.getStringValue());
    assertEquals("Namespace URI", actualIntegerType.getNamespace());
    assertEquals("Prefix", actualIntegerType.getPrefix());
    assertEquals("Property Name", actualIntegerType.getPropertyName());
    assertEquals(42, actualIntegerType.getValue().intValue());
    assertEquals(42, ((Integer) actualIntegerType.getRawValue()).intValue());
    assertTrue(actualIntegerType.getAllAttributes().isEmpty());
    assertSame(metadata, actualIntegerType.getMetadata());
  }

  /**
   * Test {@link IntegerType#getValue()}.
   * <ul>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegerType#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); then return intValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer IntegerType.getValue()"})
  void testGetValue_thenReturnIntValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42,
        (new IntegerType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42)).getValue()
            .intValue());
  }

  /**
   * Test {@link IntegerType#getStringValue()}.
   * <ul>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegerType#getStringValue()}
   */
  @Test
  @DisplayName("Test getStringValue(); then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String IntegerType.getStringValue()"})
  void testGetStringValue_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42",
        (new IntegerType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42))
            .getStringValue());
  }
}

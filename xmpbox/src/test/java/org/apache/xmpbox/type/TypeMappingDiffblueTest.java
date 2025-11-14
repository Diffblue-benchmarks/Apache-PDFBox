package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.schema.TiffSchema;
import org.apache.xmpbox.schema.XmpSchemaException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TypeMappingDiffblueTest {
  @InjectMocks private TypeMapping typeMapping;

  @Mock private XMPMetadata xMPMetadata;

  /**
   * Test {@link TypeMapping#TypeMapping(XMPMetadata)}.
   *
   * <p>Method under test: {@link TypeMapping#TypeMapping(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new TypeMapping(XMPMetadata)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeMapping.<init>(XMPMetadata)"})
  void testNewTypeMapping() {
    // Arrange and Act
    TypeMapping actualTypeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());

    // Assert
    assertNull(actualTypeMapping.getSchemaFactory("Namespace"));
    assertNull(actualTypeMapping.getDefinedDescriptionByNamespace("Namespace"));
    assertNull(actualTypeMapping.getStructuredPropMapping(Types.Structured));
  }

  /**
   * Test {@link TypeMapping#getDefinedDescriptionByNamespace(String)}.
   *
   * <p>Method under test: {@link TypeMapping#getDefinedDescriptionByNamespace(String)}
   */
  @Test
  @DisplayName("Test getDefinedDescriptionByNamespace(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertiesDescription TypeMapping.getDefinedDescriptionByNamespace(String)"})
  void testGetDefinedDescriptionByNamespace() {
    // Arrange, Act and Assert
    assertNull(
        new TypeMapping(XMPMetadata.createXMPMetadata())
            .getDefinedDescriptionByNamespace("Namespace"));
  }

  /**
   * Test {@link TypeMapping#instanciateDefinedType(String, String)}.
   *
   * <ul>
   *   <li>Then return {@link DefinedStructuredType}.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#instanciateDefinedType(String, String)}
   */
  @Test
  @DisplayName("Test instanciateDefinedType(String, String); then return DefinedStructuredType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AbstractStructuredType TypeMapping.instanciateDefinedType(String, String)"})
  void testInstanciateDefinedType_thenReturnDefinedStructuredType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    AbstractStructuredType actualInstanciateDefinedTypeResult =
        new TypeMapping(metadata).instanciateDefinedType("Property Name", "Namespace");

    // Assert
    assertTrue(actualInstanciateDefinedTypeResult instanceof DefinedStructuredType);
    assertEquals("Namespace", actualInstanciateDefinedTypeResult.getNamespace());
    assertEquals("Property Name", actualInstanciateDefinedTypeResult.getPropertyName());
    assertNull(actualInstanciateDefinedTypeResult.getPreferedPrefix());
    assertNull(actualInstanciateDefinedTypeResult.getPrefix());
    assertTrue(actualInstanciateDefinedTypeResult.getAllProperties().isEmpty());
    assertTrue(actualInstanciateDefinedTypeResult.getAllAttributes().isEmpty());
    assertTrue(actualInstanciateDefinedTypeResult.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(
        ((DefinedStructuredType) actualInstanciateDefinedTypeResult)
            .getDefinedProperties()
            .isEmpty());
    assertSame(metadata, actualInstanciateDefinedTypeResult.getMetadata());
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName("Test instanciateSimpleProperty(String, String, String, Object, Types)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty() {
    // Arrange
    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());
    AgentNameType agentNameType =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            typeMapping.instanciateSimpleProperty(
                "Nsuri", "Prefix", "Name", agentNameType, Types.Text));
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName("Test instanciateSimpleProperty(String, String, String, Object, Types)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty2() {
    // Arrange
    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());
    AgentNameType agentNameType =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            typeMapping.instanciateSimpleProperty(
                "Nsuri", "Prefix", "Name", agentNameType, Types.Date));
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName("Test instanciateSimpleProperty(String, String, String, Object, Types)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty3() {
    // Arrange
    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());
    GregorianCalendar gregorianCalendar = new GregorianCalendar(5, 5, 5);

    // Act
    AbstractSimpleProperty actualInstanciateSimplePropertyResult =
        typeMapping.instanciateSimpleProperty(
            "Nsuri", "Prefix", "Name", gregorianCalendar, Types.Date);

    // Assert
    assertTrue(actualInstanciateSimplePropertyResult instanceof DateType);
    assertSame(gregorianCalendar, actualInstanciateSimplePropertyResult.getRawValue());
    assertSame(gregorianCalendar, actualInstanciateSimplePropertyResult.getValue());
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName("Test instanciateSimpleProperty(String, String, String, Object, Types)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty4() {
    // Arrange
    AgentNameType agentNameType =
        new AgentNameType(xMPMetadata, "Namespace URI", "Prefix", "Property Name", "Value");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            typeMapping.instanciateSimpleProperty(
                "Nsuri", "Prefix", "Name", agentNameType, Types.Integer));
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <ul>
   *   <li>Given {@link TypeMapping}.
   *   <li>When {@code 42}.
   *   <li>Then return RawValue is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName(
      "Test instanciateSimpleProperty(String, String, String, Object, Types); given TypeMapping; when '42'; then return RawValue is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty_givenTypeMapping_when42_thenReturnRawValueIs42() {
    // Arrange and Act
    AbstractSimpleProperty actualInstanciateSimplePropertyResult =
        typeMapping.instanciateSimpleProperty("Nsuri", "Prefix", "Name", "42", Types.Integer);

    // Assert
    assertTrue(actualInstanciateSimplePropertyResult instanceof IntegerType);
    assertEquals("42", actualInstanciateSimplePropertyResult.getStringValue());
    assertEquals("42", actualInstanciateSimplePropertyResult.getRawValue());
    assertEquals(42, ((Integer) actualInstanciateSimplePropertyResult.getValue()).intValue());
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <ul>
   *   <li>Given {@link TypeMapping}.
   *   <li>When {@code Types}.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName(
      "Test instanciateSimpleProperty(String, String, String, Object, Types); given TypeMapping; when 'org.apache.xmpbox.type.Types'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty_givenTypeMapping_whenOrgApacheXmpboxTypeTypes() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            typeMapping.instanciateSimpleProperty(
                "Nsuri", "Prefix", "Name", "org.apache.xmpbox.type.Types", Types.Date));
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName(
      "Test instanciateSimpleProperty(String, String, String, Object, Types); when '42'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty_when42_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TypeMapping(XMPMetadata.createXMPMetadata())
                .instanciateSimpleProperty("Nsuri", "Prefix", "Name", "42", Types.Date));
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <ul>
   *   <li>When {@code ^\d{4}-\d{2}-\d{2}T.*}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName(
      "Test instanciateSimpleProperty(String, String, String, Object, Types); when '^\\d{4}-\\d{2}-\\d{2}T.*'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty_whenD4D2D2T_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TypeMapping(XMPMetadata.createXMPMetadata())
                .instanciateSimpleProperty(
                    "Nsuri", "Prefix", "Name", "^\\d{4}-\\d{2}-\\d{2}T.*", Types.Date));
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <ul>
   *   <li>When {@code D:}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName(
      "Test instanciateSimpleProperty(String, String, String, Object, Types); when 'D:'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty_whenD_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TypeMapping(XMPMetadata.createXMPMetadata())
                .instanciateSimpleProperty("Nsuri", "Prefix", "Name", "D:", Types.Date));
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName(
      "Test instanciateSimpleProperty(String, String, String, Object, Types); when '-'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty_whenDash_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TypeMapping(XMPMetadata.createXMPMetadata())
                .instanciateSimpleProperty("Nsuri", "Prefix", "Name", "-", Types.Date));
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return RawValue is empty string.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName(
      "Test instanciateSimpleProperty(String, String, String, Object, Types); when empty string; then return RawValue is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty_whenEmptyString_thenReturnRawValueIsEmptyString() {
    // Arrange and Act
    AbstractSimpleProperty actualInstanciateSimplePropertyResult =
        new TypeMapping(XMPMetadata.createXMPMetadata())
            .instanciateSimpleProperty("Nsuri", "Prefix", "Name", "", Types.Date);

    // Assert
    assertTrue(actualInstanciateSimplePropertyResult instanceof DateType);
    assertEquals("", actualInstanciateSimplePropertyResult.getRawValue());
    assertNull(actualInstanciateSimplePropertyResult.getValue());
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return RawValue intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName(
      "Test instanciateSimpleProperty(String, String, String, Object, Types); when forty-two; then return RawValue intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty_whenFortyTwo_thenReturnRawValueIntValueIsFortyTwo() {
    // Arrange and Act
    AbstractSimpleProperty actualInstanciateSimplePropertyResult =
        typeMapping.instanciateSimpleProperty("Nsuri", "Prefix", "Name", 42, Types.Integer);

    // Assert
    assertTrue(actualInstanciateSimplePropertyResult instanceof IntegerType);
    assertEquals("42", actualInstanciateSimplePropertyResult.getStringValue());
    assertEquals(42, ((Integer) actualInstanciateSimplePropertyResult.getRawValue()).intValue());
    assertEquals(42, ((Integer) actualInstanciateSimplePropertyResult.getValue()).intValue());
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName(
      "Test instanciateSimpleProperty(String, String, String, Object, Types); when forty-two; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty_whenFortyTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TypeMapping(XMPMetadata.createXMPMetadata())
                .instanciateSimpleProperty("Nsuri", "Prefix", "Name", 42, Types.Date));
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName(
      "Test instanciateSimpleProperty(String, String, String, Object, Types); when forty-two; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty_whenFortyTwo_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TypeMapping(XMPMetadata.createXMPMetadata())
                .instanciateSimpleProperty("Nsuri", "Prefix", "Name", 42, Types.Boolean));
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <ul>
   *   <li>When {@link GregorianCalendar#GregorianCalendar(int, int, int)} with five and five and
   *       five.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName(
      "Test instanciateSimpleProperty(String, String, String, Object, Types); when GregorianCalendar(int, int, int) with five and five and five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty_whenGregorianCalendarWithFiveAndFiveAndFive() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            typeMapping.instanciateSimpleProperty(
                "Nsuri", "Prefix", "Name", new GregorianCalendar(5, 5, 5), Types.Integer));
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName(
      "Test instanciateSimpleProperty(String, String, String, Object, Types); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TypeMapping(XMPMetadata.createXMPMetadata())
                .instanciateSimpleProperty("Nsuri", "Prefix", "Name", null, Types.Date));
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <ul>
   *   <li>When {@code TiffSchema}.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName(
      "Test instanciateSimpleProperty(String, String, String, Object, Types); when 'org.apache.xmpbox.schema.TiffSchema'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty_whenOrgApacheXmpboxSchemaTiffSchema() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TypeMapping(XMPMetadata.createXMPMetadata())
                .instanciateSimpleProperty(
                    "Nsuri", "Prefix", "Name", "org.apache.xmpbox.schema.TiffSchema", Types.Date));
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <ul>
   *   <li>When {@code org.apache.xmpbox.schema.XMPageTextSchema}.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName(
      "Test instanciateSimpleProperty(String, String, String, Object, Types); when 'org.apache.xmpbox.schema.XMPageTextSchema'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty_whenOrgApacheXmpboxSchemaXMPageTextSchema() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TypeMapping(XMPMetadata.createXMPMetadata())
                .instanciateSimpleProperty(
                    "Nsuri",
                    "Prefix",
                    "Name",
                    "org.apache.xmpbox.schema.XMPageTextSchema",
                    Types.Date));
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <ul>
   *   <li>When {@code org.apache.xmpbox.type.PropertyType}.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName(
      "Test instanciateSimpleProperty(String, String, String, Object, Types); when 'org.apache.xmpbox.type.PropertyType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty_whenOrgApacheXmpboxTypePropertyType() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TypeMapping(XMPMetadata.createXMPMetadata())
                .instanciateSimpleProperty(
                    "Nsuri", "Prefix", "Name", "org.apache.xmpbox.type.PropertyType", Types.Date));
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <ul>
   *   <li>When {@code [-:T]}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName(
      "Test instanciateSimpleProperty(String, String, String, Object, Types); when '[-:T]'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty_whenT_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TypeMapping(XMPMetadata.createXMPMetadata())
                .instanciateSimpleProperty("Nsuri", "Prefix", "Name", "[-:T]", Types.Date));
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <ul>
   *   <li>When {@code Text}.
   *   <li>Then return {@link TextType}.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName(
      "Test instanciateSimpleProperty(String, String, String, Object, Types); when 'Text'; then return TextType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty_whenText_thenReturnTextType() {
    // Arrange and Act
    AbstractSimpleProperty actualInstanciateSimplePropertyResult =
        new TypeMapping(XMPMetadata.createXMPMetadata())
            .instanciateSimpleProperty("Nsuri", "Prefix", "Name", "Value", Types.Text);

    // Assert
    assertTrue(actualInstanciateSimplePropertyResult instanceof TextType);
    assertEquals("Value", actualInstanciateSimplePropertyResult.getStringValue());
    assertEquals("Value", actualInstanciateSimplePropertyResult.getRawValue());
    assertEquals("Value", actualInstanciateSimplePropertyResult.getValue());
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <ul>
   *   <li>When {@code Text}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName(
      "Test instanciateSimpleProperty(String, String, String, Object, Types); when 'Text'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty_whenText_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TypeMapping(XMPMetadata.createXMPMetadata())
                .instanciateSimpleProperty("Nsuri", "Prefix", "Name", 42, Types.Text));
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <ul>
   *   <li>When {@code TRUE}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName(
      "Test instanciateSimpleProperty(String, String, String, Object, Types); when 'TRUE'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty_whenTrue_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TypeMapping(XMPMetadata.createXMPMetadata())
                .instanciateSimpleProperty("Nsuri", "Prefix", "Name", "TRUE", Types.Date));
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName(
      "Test instanciateSimpleProperty(String, String, String, Object, Types); when 'Value'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty_whenValue_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TypeMapping(XMPMetadata.createXMPMetadata())
                .instanciateSimpleProperty("Nsuri", "Prefix", "Name", "Value", Types.Date));
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName(
      "Test instanciateSimpleProperty(String, String, String, Object, Types); when 'Value'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty_whenValue_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TypeMapping(XMPMetadata.createXMPMetadata())
                .instanciateSimpleProperty("Nsuri", "Prefix", "Name", "Value", Types.Boolean));
  }

  /**
   * Test {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#instanciateSimpleProperty(String, String, String,
   * Object, Types)}
   */
  @Test
  @DisplayName(
      "Test instanciateSimpleProperty(String, String, String, Object, Types); when 'Value'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AbstractSimpleProperty TypeMapping.instanciateSimpleProperty(String, String, String, Object, Types)"
  })
  void testInstanciateSimpleProperty_whenValue_thenThrowIllegalArgumentException3() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TypeMapping(XMPMetadata.createXMPMetadata())
                .instanciateSimpleProperty("Nsuri", "Prefix", "Name", "Value", Types.Integer));
  }

  /**
   * Test {@link TypeMapping#isStructuredTypeNamespace(String)}.
   *
   * <p>Method under test: {@link TypeMapping#isStructuredTypeNamespace(String)}
   */
  @Test
  @DisplayName("Test isStructuredTypeNamespace(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeMapping.isStructuredTypeNamespace(String)"})
  void testIsStructuredTypeNamespace() {
    // Arrange, Act and Assert
    assertFalse(
        new TypeMapping(XMPMetadata.createXMPMetadata()).isStructuredTypeNamespace("Namespace"));
  }

  /**
   * Test {@link TypeMapping#isDefinedTypeNamespace(String)}.
   *
   * <p>Method under test: {@link TypeMapping#isDefinedTypeNamespace(String)}
   */
  @Test
  @DisplayName("Test isDefinedTypeNamespace(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeMapping.isDefinedTypeNamespace(String)"})
  void testIsDefinedTypeNamespace() {
    // Arrange, Act and Assert
    assertFalse(
        new TypeMapping(XMPMetadata.createXMPMetadata()).isDefinedTypeNamespace("Namespace"));
  }

  /**
   * Test {@link TypeMapping#isDefinedType(String)}.
   *
   * <p>Method under test: {@link TypeMapping#isDefinedType(String)}
   */
  @Test
  @DisplayName("Test isDefinedType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeMapping.isDefinedType(String)"})
  void testIsDefinedType() {
    // Arrange, Act and Assert
    assertFalse(new TypeMapping(XMPMetadata.createXMPMetadata()).isDefinedType("Name"));
  }

  /**
   * Test {@link TypeMapping#getStructuredPropMapping(Types)}.
   *
   * <p>Method under test: {@link TypeMapping#getStructuredPropMapping(Types)}
   */
  @Test
  @DisplayName("Test getStructuredPropMapping(Types)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertiesDescription TypeMapping.getStructuredPropMapping(Types)"})
  void testGetStructuredPropMapping() {
    // Arrange, Act and Assert
    assertNull(
        new TypeMapping(XMPMetadata.createXMPMetadata())
            .getStructuredPropMapping(Types.Structured));
  }

  /**
   * Test {@link TypeMapping#getAssociatedSchemaObject(XMPMetadata, String, String)}.
   *
   * <p>Method under test: {@link TypeMapping#getAssociatedSchemaObject(XMPMetadata, String,
   * String)}
   */
  @Test
  @DisplayName("Test getAssociatedSchemaObject(XMPMetadata, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.xmpbox.schema.XMPSchema TypeMapping.getAssociatedSchemaObject(XMPMetadata, String, String)"
  })
  void testGetAssociatedSchemaObject() throws XmpSchemaException {
    // Arrange
    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());

    // Act and Assert
    assertNull(
        typeMapping.getAssociatedSchemaObject(
            XMPMetadata.createXMPMetadata(), "Namespace", "Prefix"));
  }

  /**
   * Test {@link TypeMapping#getSchemaFactory(String)}.
   *
   * <p>Method under test: {@link TypeMapping#getSchemaFactory(String)}
   */
  @Test
  @DisplayName("Test getSchemaFactory(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.xmpbox.schema.XMPSchemaFactory TypeMapping.getSchemaFactory(String)"
  })
  void testGetSchemaFactory() {
    // Arrange, Act and Assert
    assertNull(new TypeMapping(XMPMetadata.createXMPMetadata()).getSchemaFactory("Namespace"));
  }

  /**
   * Test {@link TypeMapping#isDefinedSchema(String)}.
   *
   * <p>Method under test: {@link TypeMapping#isDefinedSchema(String)}
   */
  @Test
  @DisplayName("Test isDefinedSchema(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeMapping.isDefinedSchema(String)"})
  void testIsDefinedSchema() {
    // Arrange, Act and Assert
    assertFalse(new TypeMapping(XMPMetadata.createXMPMetadata()).isDefinedSchema("Namespace"));
  }

  /**
   * Test {@link TypeMapping#isDefinedNamespace(String)}.
   *
   * <p>Method under test: {@link TypeMapping#isDefinedNamespace(String)}
   */
  @Test
  @DisplayName("Test isDefinedNamespace(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeMapping.isDefinedNamespace(String)"})
  void testIsDefinedNamespace() {
    // Arrange, Act and Assert
    assertFalse(new TypeMapping(XMPMetadata.createXMPMetadata()).isDefinedNamespace("Namespace"));
  }

  /**
   * Test {@link TypeMapping#getSpecifiedPropertyType(QName)}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#getSpecifiedPropertyType(QName)}
   */
  @Test
  @DisplayName("Test getSpecifiedPropertyType(QName); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.xmpbox.type.PropertyType TypeMapping.getSpecifiedPropertyType(QName)"
  })
  void testGetSpecifiedPropertyType_thenDoesNotThrow() throws BadFieldValueException {
    // Arrange
    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());
    typeMapping.addToDefinedStructuredTypes("Type Name", "", new PropertiesDescription());

    // Act
    assertDoesNotThrow(
        () -> typeMapping.getSpecifiedPropertyType(QName.valueOf("Q Name As String")));
  }

  /**
   * Test {@link TypeMapping#getSpecifiedPropertyType(QName)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#getSpecifiedPropertyType(QName)}
   */
  @Test
  @DisplayName("Test getSpecifiedPropertyType(QName); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.xmpbox.type.PropertyType TypeMapping.getSpecifiedPropertyType(QName)"
  })
  void testGetSpecifiedPropertyType_thenReturnNull() throws BadFieldValueException {
    // Arrange
    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());
    typeMapping.addNewNameSpace("", "Preferred");

    // Act and Assert
    assertNull(typeMapping.getSpecifiedPropertyType(QName.valueOf("Q Name As String")));
  }

  /**
   * Test {@link TypeMapping#getSpecifiedPropertyType(QName)}.
   *
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#getSpecifiedPropertyType(QName)}
   */
  @Test
  @DisplayName("Test getSpecifiedPropertyType(QName); then throw BadFieldValueException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.xmpbox.type.PropertyType TypeMapping.getSpecifiedPropertyType(QName)"
  })
  void testGetSpecifiedPropertyType_thenThrowBadFieldValueException()
      throws BadFieldValueException {
    // Arrange, Act and Assert
    assertThrows(
        BadFieldValueException.class,
        () ->
            new TypeMapping(XMPMetadata.createXMPMetadata())
                .getSpecifiedPropertyType(QName.valueOf("Q Name As String")));
  }

  /**
   * Test {@link TypeMapping#initializePropMapping(Class)}.
   *
   * <ul>
   *   <li>Then return PropertiesName size is twenty-five.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#initializePropMapping(Class)}
   */
  @Test
  @DisplayName("Test initializePropMapping(Class); then return PropertiesName size is twenty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertiesDescription TypeMapping.initializePropMapping(Class)"})
  void testInitializePropMapping_thenReturnPropertiesNameSizeIsTwentyFive() {
    // Arrange
    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());
    Class<TiffSchema> classSchem = TiffSchema.class;

    // Act and Assert
    List<String> propertiesName = typeMapping.initializePropMapping(classSchem).getPropertiesName();
    assertEquals(25, propertiesName.size());
    assertEquals("Artist", propertiesName.get(0));
    assertEquals("Compression", propertiesName.get(1));
    assertEquals("ImageDescription", propertiesName.get(23));
    assertEquals("ResolutionUnit", propertiesName.get(24));
    assertEquals("SamplesPerPixel", propertiesName.get(2));
    assertEquals("Software", propertiesName.get(22));
  }

  /**
   * Test {@link TypeMapping#initializePropMapping(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return PropertiesName Empty.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#initializePropMapping(Class)}
   */
  @Test
  @DisplayName(
      "Test initializePropMapping(Class); when 'java.lang.Object'; then return PropertiesName Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertiesDescription TypeMapping.initializePropMapping(Class)"})
  void testInitializePropMapping_whenJavaLangObject_thenReturnPropertiesNameEmpty() {
    // Arrange
    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());
    Class<Object> classSchem = Object.class;

    // Act and Assert
    assertTrue(typeMapping.initializePropMapping(classSchem).getPropertiesName().isEmpty());
  }

  /**
   * Test {@link TypeMapping#initializePropMapping(Class)}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return PropertiesName Empty.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#initializePropMapping(Class)}
   */
  @Test
  @DisplayName(
      "Test initializePropMapping(Class); when 'java.lang.String'; then return PropertiesName Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertiesDescription TypeMapping.initializePropMapping(Class)"})
  void testInitializePropMapping_whenJavaLangString_thenReturnPropertiesNameEmpty() {
    // Arrange
    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());
    Class<String> classSchem = String.class;

    // Act and Assert
    assertTrue(typeMapping.initializePropMapping(classSchem).getPropertiesName().isEmpty());
  }

  /**
   * Test {@link TypeMapping#createBoolean(String, String, String, boolean)}.
   *
   * <p>Method under test: {@link TypeMapping#createBoolean(String, String, String, boolean)}
   */
  @Test
  @DisplayName("Test createBoolean(String, String, String, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BooleanType TypeMapping.createBoolean(String, String, String, boolean)"})
  void testCreateBoolean() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    BooleanType actualCreateBooleanResult =
        new TypeMapping(metadata).createBoolean("Namespace URI", "Prefix", "Property Name", true);

    // Assert
    assertEquals("Namespace URI", actualCreateBooleanResult.getNamespace());
    assertEquals("Prefix", actualCreateBooleanResult.getPrefix());
    assertEquals("Property Name", actualCreateBooleanResult.getPropertyName());
    assertTrue(actualCreateBooleanResult.getAllAttributes().isEmpty());
    assertTrue(actualCreateBooleanResult.getValue());
    assertTrue((Boolean) actualCreateBooleanResult.getRawValue());
    assertEquals(BooleanType.TRUE, actualCreateBooleanResult.getStringValue());
    assertSame(metadata, actualCreateBooleanResult.getMetadata());
  }

  /**
   * Test {@link TypeMapping#createDate(String, String, String, Calendar)}.
   *
   * <ul>
   *   <li>Then RawValue return {@link GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link TypeMapping#createDate(String, String, String, Calendar)}
   */
  @Test
  @DisplayName(
      "Test createDate(String, String, String, Calendar); then RawValue return GregorianCalendar")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DateType TypeMapping.createDate(String, String, String, Calendar)"})
  void testCreateDate_thenRawValueReturnGregorianCalendar() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    TypeMapping typeMapping = new TypeMapping(metadata);
    GregorianCalendar value = new GregorianCalendar(1, 1, 1);

    // Act
    DateType actualCreateDateResult =
        typeMapping.createDate("Namespace URI", "Prefix", "Property Name", value);

    // Assert
    Object rawValue = actualCreateDateResult.getRawValue();
    assertTrue(rawValue instanceof GregorianCalendar);
    assertEquals("Namespace URI", actualCreateDateResult.getNamespace());
    assertEquals("Prefix", actualCreateDateResult.getPrefix());
    assertEquals("Property Name", actualCreateDateResult.getPropertyName());
    assertTrue(actualCreateDateResult.getAllAttributes().isEmpty());
    assertSame(value, rawValue);
    assertSame(value, actualCreateDateResult.getValue());
    assertSame(metadata, actualCreateDateResult.getMetadata());
  }

  /**
   * Test {@link TypeMapping#createInteger(String, String, String, int)}.
   *
   * <p>Method under test: {@link TypeMapping#createInteger(String, String, String, int)}
   */
  @Test
  @DisplayName("Test createInteger(String, String, String, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerType TypeMapping.createInteger(String, String, String, int)"})
  void testCreateInteger() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    IntegerType actualCreateIntegerResult =
        new TypeMapping(metadata).createInteger("Namespace URI", "Prefix", "Property Name", 42);

    // Assert
    assertEquals("42", actualCreateIntegerResult.getStringValue());
    assertEquals("Namespace URI", actualCreateIntegerResult.getNamespace());
    assertEquals("Prefix", actualCreateIntegerResult.getPrefix());
    assertEquals("Property Name", actualCreateIntegerResult.getPropertyName());
    assertEquals(42, actualCreateIntegerResult.getValue().intValue());
    assertEquals(42, ((Integer) actualCreateIntegerResult.getRawValue()).intValue());
    assertTrue(actualCreateIntegerResult.getAllAttributes().isEmpty());
    assertSame(metadata, actualCreateIntegerResult.getMetadata());
  }

  /**
   * Test {@link TypeMapping#createReal(String, String, String, float)}.
   *
   * <p>Method under test: {@link TypeMapping#createReal(String, String, String, float)}
   */
  @Test
  @DisplayName("Test createReal(String, String, String, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RealType TypeMapping.createReal(String, String, String, float)"})
  void testCreateReal() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    RealType actualCreateRealResult =
        new TypeMapping(metadata).createReal("Namespace URI", "Prefix", "Property Name", 10.0f);

    // Assert
    assertEquals("10.0", actualCreateRealResult.getStringValue());
    assertEquals("Namespace URI", actualCreateRealResult.getNamespace());
    assertEquals("Prefix", actualCreateRealResult.getPrefix());
    assertEquals("Property Name", actualCreateRealResult.getPropertyName());
    assertEquals(10.0f, actualCreateRealResult.getValue().floatValue());
    assertEquals(10.0f, ((Float) actualCreateRealResult.getRawValue()).floatValue());
    assertTrue(actualCreateRealResult.getAllAttributes().isEmpty());
    assertSame(metadata, actualCreateRealResult.getMetadata());
  }

  /**
   * Test {@link TypeMapping#createText(String, String, String, String)}.
   *
   * <p>Method under test: {@link TypeMapping#createText(String, String, String, String)}
   */
  @Test
  @DisplayName("Test createText(String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType TypeMapping.createText(String, String, String, String)"})
  void testCreateText() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    TextType actualCreateTextResult =
        new TypeMapping(metadata).createText("Namespace URI", "Prefix", "Property Name", "42");

    // Assert
    assertEquals("42", actualCreateTextResult.getStringValue());
    assertEquals("42", actualCreateTextResult.getRawValue());
    assertEquals("42", actualCreateTextResult.getValue());
    assertEquals("Namespace URI", actualCreateTextResult.getNamespace());
    assertEquals("Prefix", actualCreateTextResult.getPrefix());
    assertEquals("Property Name", actualCreateTextResult.getPropertyName());
    assertTrue(actualCreateTextResult.getAllAttributes().isEmpty());
    assertSame(metadata, actualCreateTextResult.getMetadata());
  }

  /**
   * Test {@link TypeMapping#createProperName(String, String, String, String)}.
   *
   * <p>Method under test: {@link TypeMapping#createProperName(String, String, String, String)}
   */
  @Test
  @DisplayName("Test createProperName(String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ProperNameType TypeMapping.createProperName(String, String, String, String)"})
  void testCreateProperName() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ProperNameType actualCreateProperNameResult =
        new TypeMapping(metadata)
            .createProperName("Namespace URI", "Prefix", "Property Name", "42");

    // Assert
    assertEquals("42", actualCreateProperNameResult.getStringValue());
    assertEquals("42", actualCreateProperNameResult.getRawValue());
    assertEquals("42", actualCreateProperNameResult.getValue());
    assertEquals("Namespace URI", actualCreateProperNameResult.getNamespace());
    assertEquals("Prefix", actualCreateProperNameResult.getPrefix());
    assertEquals("Property Name", actualCreateProperNameResult.getPropertyName());
    assertTrue(actualCreateProperNameResult.getAllAttributes().isEmpty());
    assertSame(metadata, actualCreateProperNameResult.getMetadata());
  }

  /**
   * Test {@link TypeMapping#createURI(String, String, String, String)}.
   *
   * <p>Method under test: {@link TypeMapping#createURI(String, String, String, String)}
   */
  @Test
  @DisplayName("Test createURI(String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"URIType TypeMapping.createURI(String, String, String, String)"})
  void testCreateURI() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    URIType actualCreateURIResult =
        new TypeMapping(metadata).createURI("Namespace URI", "Prefix", "Property Name", "42");

    // Assert
    assertEquals("42", actualCreateURIResult.getStringValue());
    assertEquals("42", actualCreateURIResult.getRawValue());
    assertEquals("42", actualCreateURIResult.getValue());
    assertEquals("Namespace URI", actualCreateURIResult.getNamespace());
    assertEquals("Prefix", actualCreateURIResult.getPrefix());
    assertEquals("Property Name", actualCreateURIResult.getPropertyName());
    assertTrue(actualCreateURIResult.getAllAttributes().isEmpty());
    assertSame(metadata, actualCreateURIResult.getMetadata());
  }

  /**
   * Test {@link TypeMapping#createURL(String, String, String, String)}.
   *
   * <p>Method under test: {@link TypeMapping#createURL(String, String, String, String)}
   */
  @Test
  @DisplayName("Test createURL(String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"URLType TypeMapping.createURL(String, String, String, String)"})
  void testCreateURL() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    URLType actualCreateURLResult =
        new TypeMapping(metadata)
            .createURL(
                "https://example.org/example",
                "https://example.org/example",
                "https://example.org/example",
                "https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", actualCreateURLResult.getPropertyName());
    assertEquals("https://example.org/example", actualCreateURLResult.getNamespace());
    assertEquals("https://example.org/example", actualCreateURLResult.getPrefix());
    assertEquals("https://example.org/example", actualCreateURLResult.getStringValue());
    assertEquals("https://example.org/example", actualCreateURLResult.getRawValue());
    assertEquals("https://example.org/example", actualCreateURLResult.getValue());
    assertTrue(actualCreateURLResult.getAllAttributes().isEmpty());
    assertSame(metadata, actualCreateURLResult.getMetadata());
  }

  /**
   * Test {@link TypeMapping#createRenditionClass(String, String, String, String)}.
   *
   * <p>Method under test: {@link TypeMapping#createRenditionClass(String, String, String, String)}
   */
  @Test
  @DisplayName("Test createRenditionClass(String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RenditionClassType TypeMapping.createRenditionClass(String, String, String, String)"
  })
  void testCreateRenditionClass() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    RenditionClassType actualCreateRenditionClassResult =
        new TypeMapping(metadata)
            .createRenditionClass("Namespace URI", "Prefix", "Property Name", "42");

    // Assert
    assertEquals("42", actualCreateRenditionClassResult.getStringValue());
    assertEquals("42", actualCreateRenditionClassResult.getRawValue());
    assertEquals("42", actualCreateRenditionClassResult.getValue());
    assertEquals("Namespace URI", actualCreateRenditionClassResult.getNamespace());
    assertEquals("Prefix", actualCreateRenditionClassResult.getPrefix());
    assertEquals("Property Name", actualCreateRenditionClassResult.getPropertyName());
    assertTrue(actualCreateRenditionClassResult.getAllAttributes().isEmpty());
    assertSame(metadata, actualCreateRenditionClassResult.getMetadata());
  }

  /**
   * Test {@link TypeMapping#createPart(String, String, String, String)}.
   *
   * <p>Method under test: {@link TypeMapping#createPart(String, String, String, String)}
   */
  @Test
  @DisplayName("Test createPart(String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PartType TypeMapping.createPart(String, String, String, String)"})
  void testCreatePart() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PartType actualCreatePartResult =
        new TypeMapping(metadata).createPart("Namespace URI", "Prefix", "Property Name", "42");

    // Assert
    assertEquals("42", actualCreatePartResult.getStringValue());
    assertEquals("42", actualCreatePartResult.getRawValue());
    assertEquals("42", actualCreatePartResult.getValue());
    assertEquals("Namespace URI", actualCreatePartResult.getNamespace());
    assertEquals("Prefix", actualCreatePartResult.getPrefix());
    assertEquals("Property Name", actualCreatePartResult.getPropertyName());
    assertTrue(actualCreatePartResult.getAllAttributes().isEmpty());
    assertSame(metadata, actualCreatePartResult.getMetadata());
  }

  /**
   * Test {@link TypeMapping#createMIMEType(String, String, String, String)}.
   *
   * <p>Method under test: {@link TypeMapping#createMIMEType(String, String, String, String)}
   */
  @Test
  @DisplayName("Test createMIMEType(String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MIMEType TypeMapping.createMIMEType(String, String, String, String)"})
  void testCreateMIMEType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    MIMEType actualCreateMIMETypeResult =
        new TypeMapping(metadata).createMIMEType("Namespace URI", "Prefix", "Property Name", "42");

    // Assert
    assertEquals("42", actualCreateMIMETypeResult.getStringValue());
    assertEquals("42", actualCreateMIMETypeResult.getRawValue());
    assertEquals("42", actualCreateMIMETypeResult.getValue());
    assertEquals("Namespace URI", actualCreateMIMETypeResult.getNamespace());
    assertEquals("Prefix", actualCreateMIMETypeResult.getPrefix());
    assertEquals("Property Name", actualCreateMIMETypeResult.getPropertyName());
    assertTrue(actualCreateMIMETypeResult.getAllAttributes().isEmpty());
    assertSame(metadata, actualCreateMIMETypeResult.getMetadata());
  }

  /**
   * Test {@link TypeMapping#createLocale(String, String, String, String)}.
   *
   * <p>Method under test: {@link TypeMapping#createLocale(String, String, String, String)}
   */
  @Test
  @DisplayName("Test createLocale(String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocaleType TypeMapping.createLocale(String, String, String, String)"})
  void testCreateLocale() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    LocaleType actualCreateLocaleResult =
        new TypeMapping(metadata).createLocale("en", "en", "en", "en");

    // Assert
    assertEquals("en", actualCreateLocaleResult.getPropertyName());
    assertEquals("en", actualCreateLocaleResult.getNamespace());
    assertEquals("en", actualCreateLocaleResult.getPrefix());
    assertEquals("en", actualCreateLocaleResult.getStringValue());
    assertEquals("en", actualCreateLocaleResult.getRawValue());
    assertEquals("en", actualCreateLocaleResult.getValue());
    assertTrue(actualCreateLocaleResult.getAllAttributes().isEmpty());
    assertSame(metadata, actualCreateLocaleResult.getMetadata());
  }

  /**
   * Test {@link TypeMapping#createGUID(String, String, String, String)}.
   *
   * <p>Method under test: {@link TypeMapping#createGUID(String, String, String, String)}
   */
  @Test
  @DisplayName("Test createGUID(String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GUIDType TypeMapping.createGUID(String, String, String, String)"})
  void testCreateGUID() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    GUIDType actualCreateGUIDResult =
        new TypeMapping(metadata).createGUID("Namespace URI", "Prefix", "Property Name", "42");

    // Assert
    assertEquals("42", actualCreateGUIDResult.getStringValue());
    assertEquals("42", actualCreateGUIDResult.getRawValue());
    assertEquals("42", actualCreateGUIDResult.getValue());
    assertEquals("Namespace URI", actualCreateGUIDResult.getNamespace());
    assertEquals("Prefix", actualCreateGUIDResult.getPrefix());
    assertEquals("Property Name", actualCreateGUIDResult.getPropertyName());
    assertTrue(actualCreateGUIDResult.getAllAttributes().isEmpty());
    assertSame(metadata, actualCreateGUIDResult.getMetadata());
  }

  /**
   * Test {@link TypeMapping#createChoice(String, String, String, String)}.
   *
   * <p>Method under test: {@link TypeMapping#createChoice(String, String, String, String)}
   */
  @Test
  @DisplayName("Test createChoice(String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChoiceType TypeMapping.createChoice(String, String, String, String)"})
  void testCreateChoice() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ChoiceType actualCreateChoiceResult =
        new TypeMapping(metadata).createChoice("Namespace URI", "Prefix", "Property Name", "42");

    // Assert
    assertEquals("42", actualCreateChoiceResult.getStringValue());
    assertEquals("42", actualCreateChoiceResult.getRawValue());
    assertEquals("42", actualCreateChoiceResult.getValue());
    assertEquals("Namespace URI", actualCreateChoiceResult.getNamespace());
    assertEquals("Prefix", actualCreateChoiceResult.getPrefix());
    assertEquals("Property Name", actualCreateChoiceResult.getPropertyName());
    assertTrue(actualCreateChoiceResult.getAllAttributes().isEmpty());
    assertSame(metadata, actualCreateChoiceResult.getMetadata());
  }

  /**
   * Test {@link TypeMapping#createAgentName(String, String, String, String)}.
   *
   * <p>Method under test: {@link TypeMapping#createAgentName(String, String, String, String)}
   */
  @Test
  @DisplayName("Test createAgentName(String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AgentNameType TypeMapping.createAgentName(String, String, String, String)"})
  void testCreateAgentName() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    AgentNameType actualCreateAgentNameResult =
        new TypeMapping(metadata).createAgentName("Namespace URI", "Prefix", "Property Name", "42");

    // Assert
    assertEquals("42", actualCreateAgentNameResult.getStringValue());
    assertEquals("42", actualCreateAgentNameResult.getRawValue());
    assertEquals("42", actualCreateAgentNameResult.getValue());
    assertEquals("Namespace URI", actualCreateAgentNameResult.getNamespace());
    assertEquals("Prefix", actualCreateAgentNameResult.getPrefix());
    assertEquals("Property Name", actualCreateAgentNameResult.getPropertyName());
    assertTrue(actualCreateAgentNameResult.getAllAttributes().isEmpty());
    assertSame(metadata, actualCreateAgentNameResult.getMetadata());
  }

  /**
   * Test {@link TypeMapping#createXPath(String, String, String, String)}.
   *
   * <p>Method under test: {@link TypeMapping#createXPath(String, String, String, String)}
   */
  @Test
  @DisplayName("Test createXPath(String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XPathType TypeMapping.createXPath(String, String, String, String)"})
  void testCreateXPath() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XPathType actualCreateXPathResult =
        new TypeMapping(metadata).createXPath("Namespace URI", "Prefix", "Property Name", "42");

    // Assert
    assertEquals("42", actualCreateXPathResult.getStringValue());
    assertEquals("42", actualCreateXPathResult.getRawValue());
    assertEquals("42", actualCreateXPathResult.getValue());
    assertEquals("Namespace URI", actualCreateXPathResult.getNamespace());
    assertEquals("Prefix", actualCreateXPathResult.getPrefix());
    assertEquals("Property Name", actualCreateXPathResult.getPropertyName());
    assertTrue(actualCreateXPathResult.getAllAttributes().isEmpty());
    assertSame(metadata, actualCreateXPathResult.getMetadata());
  }

  /**
   * Test {@link TypeMapping#createArrayProperty(String, String, String, Cardinality)}.
   *
   * <p>Method under test: {@link TypeMapping#createArrayProperty(String, String, String,
   * Cardinality)}
   */
  @Test
  @DisplayName("Test createArrayProperty(String, String, String, Cardinality)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ArrayProperty TypeMapping.createArrayProperty(String, String, String, Cardinality)"
  })
  void testCreateArrayProperty() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ArrayProperty actualCreateArrayPropertyResult =
        new TypeMapping(metadata)
            .createArrayProperty("Namespace", "Prefix", "Property Name", Cardinality.Simple);

    // Assert
    assertEquals("Namespace", actualCreateArrayPropertyResult.getNamespace());
    assertEquals("Prefix", actualCreateArrayPropertyResult.getPrefix());
    assertEquals("Property Name", actualCreateArrayPropertyResult.getPropertyName());
    assertEquals(Cardinality.Simple, actualCreateArrayPropertyResult.getArrayType());
    assertTrue(actualCreateArrayPropertyResult.getAllProperties().isEmpty());
    assertTrue(actualCreateArrayPropertyResult.getAllAttributes().isEmpty());
    assertTrue(actualCreateArrayPropertyResult.getElementsAsString().isEmpty());
    assertTrue(actualCreateArrayPropertyResult.getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, actualCreateArrayPropertyResult.getMetadata());
  }
}

package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.type.PropertiesDescription;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class XMPSchemaFactoryDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link XMPSchemaFactory#XMPSchemaFactory(String, Class, PropertiesDescription)}
   *   <li>{@link XMPSchemaFactory#getNamespace()}
   *   <li>{@link XMPSchemaFactory#getPropertyDefinition()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void XMPSchemaFactory.<init>(String, Class, PropertiesDescription)",
    "String XMPSchemaFactory.getNamespace()",
    "PropertiesDescription XMPSchemaFactory.getPropertyDefinition()"
  })
  void testGettersAndSetters() {
    // Arrange
    Class<XMPSchema> schemaClass = XMPSchema.class;
    PropertiesDescription propDef = new PropertiesDescription();

    // Act
    XMPSchemaFactory actualXmpSchemaFactory =
        new XMPSchemaFactory("Namespace", schemaClass, propDef);
    String actualNamespace = actualXmpSchemaFactory.getNamespace();
    PropertiesDescription actualPropertyDefinition = actualXmpSchemaFactory.getPropertyDefinition();

    // Assert
    assertEquals("Namespace", actualNamespace);
    assertTrue(actualPropertyDefinition.getPropertiesName().isEmpty());
    assertSame(propDef, actualPropertyDefinition);
  }

  /**
   * Test {@link XMPSchemaFactory#getPropertyType(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPSchemaFactory#getPropertyType(String)}
   */
  @Test
  @DisplayName("Test getPropertyType(String); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.xmpbox.type.PropertyType XMPSchemaFactory.getPropertyType(String)"
  })
  void testGetPropertyType_thenReturnNull() {
    // Arrange
    Class<XMPSchema> schemaClass = XMPSchema.class;
    XMPSchemaFactory xmpSchemaFactory =
        new XMPSchemaFactory("Namespace", schemaClass, new PropertiesDescription());

    // Act and Assert
    assertNull(xmpSchemaFactory.getPropertyType("Name"));
  }

  /**
   * Test {@link XMPSchemaFactory#createXMPSchema(XMPMetadata, String)}.
   *
   * <ul>
   *   <li>Then return AboutValue is empty string.
   * </ul>
   *
   * <p>Method under test: {@link XMPSchemaFactory#createXMPSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName("Test createXMPSchema(XMPMetadata, String); then return AboutValue is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPSchema XMPSchemaFactory.createXMPSchema(XMPMetadata, String)"})
  void testCreateXMPSchema_thenReturnAboutValueIsEmptyString() throws XmpSchemaException {
    // Arrange
    Class<XMPSchema> schemaClass = XMPSchema.class;
    XMPSchemaFactory xmpSchemaFactory =
        new XMPSchemaFactory("Namespace", schemaClass, new PropertiesDescription());
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPSchema actualCreateXMPSchemaResult = xmpSchemaFactory.createXMPSchema(metadata, "Prefix");

    // Assert
    assertEquals("", actualCreateXMPSchemaResult.getAboutValue());
    assertEquals("Namespace", actualCreateXMPSchemaResult.getNamespace());
    assertEquals("Prefix", actualCreateXMPSchemaResult.getPreferedPrefix());
    assertEquals("Prefix", actualCreateXMPSchemaResult.getPrefix());
    assertNull(actualCreateXMPSchemaResult.getPropertyName());
    assertNull(actualCreateXMPSchemaResult.getAboutAttribute());
    assertEquals(1, metadata.getAllSchemas().size());
    Map<String, String> allNamespacesWithPrefix =
        actualCreateXMPSchemaResult.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualCreateXMPSchemaResult.getAllProperties().isEmpty());
    assertTrue(actualCreateXMPSchemaResult.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("Namespace"));
    assertSame(metadata, actualCreateXMPSchemaResult.getMetadata());
  }

  /**
   * Test {@link XMPSchemaFactory#createXMPSchema(XMPMetadata, String)}.
   *
   * <ul>
   *   <li>Then throw {@link XmpSchemaException}.
   * </ul>
   *
   * <p>Method under test: {@link XMPSchemaFactory#createXMPSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName("Test createXMPSchema(XMPMetadata, String); then throw XmpSchemaException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPSchema XMPSchemaFactory.createXMPSchema(XMPMetadata, String)"})
  void testCreateXMPSchema_thenThrowXmpSchemaException() throws XmpSchemaException {
    // Arrange
    Class<XMPSchema> schemaClass = XMPSchema.class;
    XMPSchemaFactory xmpSchemaFactory =
        new XMPSchemaFactory(null, schemaClass, new PropertiesDescription());

    // Act and Assert
    assertThrows(
        XmpSchemaException.class,
        () -> xmpSchemaFactory.createXMPSchema(XMPMetadata.createXMPMetadata(), "Prefix"));
  }
}

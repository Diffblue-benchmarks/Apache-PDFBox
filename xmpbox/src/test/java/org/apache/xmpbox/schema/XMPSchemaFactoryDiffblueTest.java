package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link XMPSchemaFactory#XMPSchemaFactory(String, Class, PropertiesDescription)}
   *   <li>{@link XMPSchemaFactory#getNamespace()}
   *   <li>{@link XMPSchemaFactory#getPropertyDefinition()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XMPSchemaFactory.<init>(String, Class, PropertiesDescription)",
      "String XMPSchemaFactory.getNamespace()", "PropertiesDescription XMPSchemaFactory.getPropertyDefinition()"})
  void testGettersAndSetters() {
    // Arrange
    Class<XMPSchema> schemaClass = XMPSchema.class;
    PropertiesDescription propDef = new PropertiesDescription();

    // Act
    XMPSchemaFactory actualXmpSchemaFactory = new XMPSchemaFactory("Namespace", schemaClass, propDef);
    String actualNamespace = actualXmpSchemaFactory.getNamespace();
    PropertiesDescription actualPropertyDefinition = actualXmpSchemaFactory.getPropertyDefinition();

    // Assert
    assertEquals("Namespace", actualNamespace);
    assertTrue(actualPropertyDefinition.getPropertiesName().isEmpty());
    assertSame(propDef, actualPropertyDefinition);
  }

  /**
   * Test {@link XMPSchemaFactory#getPropertyType(String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchemaFactory#getPropertyType(String)}
   */
  @Test
  @DisplayName("Test getPropertyType(String); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.xmpbox.type.PropertyType XMPSchemaFactory.getPropertyType(String)"})
  void testGetPropertyType_thenReturnNull() {
    // Arrange
    Class<XMPSchema> schemaClass = XMPSchema.class;

    // Act and Assert
    assertNull((new XMPSchemaFactory("Namespace", schemaClass, new PropertiesDescription())).getPropertyType("Name"));
  }

  /**
   * Test {@link XMPSchemaFactory#createXMPSchema(XMPMetadata, String)}.
   * <ul>
   *   <li>Then return AboutValue is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchemaFactory#createXMPSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName("Test createXMPSchema(XMPMetadata, String); then return AboutValue is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"XMPSchema XMPSchemaFactory.createXMPSchema(XMPMetadata, String)"})
  void testCreateXMPSchema_thenReturnAboutValueIsEmptyString() throws XmpSchemaException {
    // Arrange
    Class<XMPSchema> schemaClass = XMPSchema.class;
    XMPSchemaFactory xmpSchemaFactory = new XMPSchemaFactory("Namespace", schemaClass, new PropertiesDescription());
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
    Map<String, String> allNamespacesWithPrefix = actualCreateXMPSchemaResult.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualCreateXMPSchemaResult.getAllProperties().isEmpty());
    assertTrue(actualCreateXMPSchemaResult.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("Namespace"));
    assertSame(metadata, actualCreateXMPSchemaResult.getMetadata());
  }
}

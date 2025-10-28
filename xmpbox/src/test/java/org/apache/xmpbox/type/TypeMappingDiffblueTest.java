package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.schema.TiffSchema;
import org.apache.xmpbox.schema.XMPSchema;
import org.apache.xmpbox.schema.XmpSchemaException;
import org.junit.jupiter.api.Test;

class TypeMappingDiffblueTest {
  /**
   * Method under test:
   * {@link TypeMapping#getDefinedDescriptionByNamespace(String)}
   */
  @Test
  void testGetDefinedDescriptionByNamespace() {
    // Arrange, Act and Assert
    assertNull((new TypeMapping(XMPMetadata.createXMPMetadata())).getDefinedDescriptionByNamespace("Namespace"));
  }

  /**
   * Method under test:
   * {@link TypeMapping#getDefinedDescriptionByNamespace(String)}
   */
  @Test
  void testGetDefinedDescriptionByNamespace2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));

    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);

    // Act and Assert
    assertNull(typeMapping.getDefinedDescriptionByNamespace("Namespace"));
  }

  /**
   * Method under test: {@link TypeMapping#instanciateDefinedType(String, String)}
   */
  @Test
  void testInstanciateDefinedType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    AbstractStructuredType actualInstanciateDefinedTypeResult = (new TypeMapping(metadata))
        .instanciateDefinedType("Property Name", "Namespace");

    // Assert
    assertTrue(actualInstanciateDefinedTypeResult instanceof DefinedStructuredType);
    assertEquals("Namespace", actualInstanciateDefinedTypeResult.getNamespace());
    assertEquals("Property Name", actualInstanciateDefinedTypeResult.getPropertyName());
    assertNull(actualInstanciateDefinedTypeResult.getPreferedPrefix());
    assertNull(actualInstanciateDefinedTypeResult.getPrefix());
    List<AbstractField> allProperties = actualInstanciateDefinedTypeResult.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualInstanciateDefinedTypeResult.getAllAttributes().isEmpty());
    assertTrue(actualInstanciateDefinedTypeResult.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((DefinedStructuredType) actualInstanciateDefinedTypeResult).getDefinedProperties().isEmpty());
    assertSame(allProperties, actualInstanciateDefinedTypeResult.getContainer().getAllProperties());
    assertSame(metadata, actualInstanciateDefinedTypeResult.getMetadata());
  }

  /**
   * Method under test: {@link TypeMapping#instanciateDefinedType(String, String)}
   */
  @Test
  void testInstanciateDefinedType2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TypeMapping typeMapping = new TypeMapping(metadata);
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);

    // Act
    AbstractStructuredType actualInstanciateDefinedTypeResult = typeMapping.instanciateDefinedType("Property Name",
        "Namespace");

    // Assert
    assertTrue(actualInstanciateDefinedTypeResult instanceof DefinedStructuredType);
    assertEquals("Namespace", actualInstanciateDefinedTypeResult.getNamespace());
    assertEquals("Property Name", actualInstanciateDefinedTypeResult.getPropertyName());
    assertNull(actualInstanciateDefinedTypeResult.getPreferedPrefix());
    assertNull(actualInstanciateDefinedTypeResult.getPrefix());
    List<AbstractField> allProperties = actualInstanciateDefinedTypeResult.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualInstanciateDefinedTypeResult.getAllAttributes().isEmpty());
    assertTrue(actualInstanciateDefinedTypeResult.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((DefinedStructuredType) actualInstanciateDefinedTypeResult).getDefinedProperties().isEmpty());
    assertSame(allProperties, actualInstanciateDefinedTypeResult.getContainer().getAllProperties());
    assertSame(metadata, actualInstanciateDefinedTypeResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}
   */
  @Test
  void testInstanciateSimpleProperty() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    AbstractSimpleProperty actualInstanciateSimplePropertyResult = (new TypeMapping(metadata))
        .instanciateSimpleProperty("Nsuri", "Prefix", "Name", "Value", Types.Text);

    // Assert
    assertTrue(actualInstanciateSimplePropertyResult instanceof TextType);
    assertEquals("Name", actualInstanciateSimplePropertyResult.getPropertyName());
    assertEquals("Nsuri", actualInstanciateSimplePropertyResult.getNamespace());
    assertEquals("Prefix", actualInstanciateSimplePropertyResult.getPrefix());
    assertEquals("Value", actualInstanciateSimplePropertyResult.getStringValue());
    assertEquals("Value", actualInstanciateSimplePropertyResult.getRawValue());
    assertEquals("Value", actualInstanciateSimplePropertyResult.getValue());
    assertTrue(actualInstanciateSimplePropertyResult.getAllAttributes().isEmpty());
    assertSame(metadata, actualInstanciateSimplePropertyResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}
   */
  @Test
  void testInstanciateSimpleProperty2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TypeMapping(XMPMetadata.createXMPMetadata()))
        .instanciateSimpleProperty("Nsuri", "Prefix", "Name", 42, Types.Text));
  }

  /**
   * Method under test:
   * {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}
   */
  @Test
  void testInstanciateSimpleProperty3() {
    // Arrange
    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> typeMapping.instanciateSimpleProperty("Nsuri", "Prefix", "Name",
            new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value"),
            Types.Text));
  }

  /**
   * Method under test:
   * {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}
   */
  @Test
  void testInstanciateSimpleProperty4() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TypeMapping(XMPMetadata.createXMPMetadata()))
        .instanciateSimpleProperty("Nsuri", "Prefix", "Name", "Value", Types.Date));
  }

  /**
   * Method under test:
   * {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}
   */
  @Test
  void testInstanciateSimpleProperty5() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TypeMapping(XMPMetadata.createXMPMetadata()))
        .instanciateSimpleProperty("Nsuri", "Prefix", "Name", 42, Types.Date));
  }

  /**
   * Method under test:
   * {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}
   */
  @Test
  void testInstanciateSimpleProperty6() {
    // Arrange
    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> typeMapping.instanciateSimpleProperty("Nsuri", "Prefix", "Name",
            new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value"),
            Types.Date));
  }

  /**
   * Method under test:
   * {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}
   */
  @Test
  void testInstanciateSimpleProperty7() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TypeMapping(XMPMetadata.createXMPMetadata()))
        .instanciateSimpleProperty("Nsuri", "Prefix", "Name", "Value", Types.Boolean));
  }

  /**
   * Method under test:
   * {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}
   */
  @Test
  void testInstanciateSimpleProperty8() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TypeMapping(XMPMetadata.createXMPMetadata()))
        .instanciateSimpleProperty("Nsuri", "Prefix", "Name", "42", Types.Date));
  }

  /**
   * Method under test:
   * {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}
   */
  @Test
  void testInstanciateSimpleProperty9() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TypeMapping(XMPMetadata.createXMPMetadata()))
        .instanciateSimpleProperty("Nsuri", "Prefix", "Name", "-", Types.Date));
  }

  /**
   * Method under test:
   * {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}
   */
  @Test
  void testInstanciateSimpleProperty10() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TypeMapping(XMPMetadata.createXMPMetadata()))
        .instanciateSimpleProperty("Nsuri", "Prefix", "Name", "^\\d{4}-\\d{2}-\\d{2}T.*", Types.Date));
  }

  /**
   * Method under test:
   * {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}
   */
  @Test
  void testInstanciateSimpleProperty11() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TypeMapping(XMPMetadata.createXMPMetadata()))
        .instanciateSimpleProperty("Nsuri", "Prefix", "Name", "D:", Types.Date));
  }

  /**
   * Method under test:
   * {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}
   */
  @Test
  void testInstanciateSimpleProperty12() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TypeMapping(XMPMetadata.createXMPMetadata()))
        .instanciateSimpleProperty("Nsuri", "Prefix", "Name", "[-:T]", Types.Date));
  }

  /**
   * Method under test:
   * {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}
   */
  @Test
  void testInstanciateSimpleProperty13() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TypeMapping(XMPMetadata.createXMPMetadata()))
        .instanciateSimpleProperty("Nsuri", "Prefix", "Name", null, Types.Date));
  }

  /**
   * Method under test:
   * {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}
   */
  @Test
  void testInstanciateSimpleProperty14() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    TypeMapping typeMapping = new TypeMapping(metadata);
    GregorianCalendar gregorianCalendar = new GregorianCalendar(5, 5, 5, 5, 5);

    // Act
    AbstractSimpleProperty actualInstanciateSimplePropertyResult = typeMapping.instanciateSimpleProperty("Nsuri",
        "Prefix", "Name", gregorianCalendar, Types.Date);

    // Assert
    assertTrue(actualInstanciateSimplePropertyResult instanceof DateType);
    assertEquals("Name", actualInstanciateSimplePropertyResult.getPropertyName());
    assertEquals("Nsuri", actualInstanciateSimplePropertyResult.getNamespace());
    assertEquals("Prefix", actualInstanciateSimplePropertyResult.getPrefix());
    assertTrue(actualInstanciateSimplePropertyResult.getAllAttributes().isEmpty());
    assertSame(gregorianCalendar, actualInstanciateSimplePropertyResult.getRawValue());
    assertSame(gregorianCalendar, actualInstanciateSimplePropertyResult.getValue());
    assertSame(metadata, actualInstanciateSimplePropertyResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}
   */
  @Test
  void testInstanciateSimpleProperty15() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    AbstractSimpleProperty actualInstanciateSimplePropertyResult = (new TypeMapping(metadata))
        .instanciateSimpleProperty("Nsuri", "Prefix", "Name", "", Types.Date);

    // Assert
    assertTrue(actualInstanciateSimplePropertyResult instanceof DateType);
    assertEquals("", actualInstanciateSimplePropertyResult.getRawValue());
    assertEquals("Name", actualInstanciateSimplePropertyResult.getPropertyName());
    assertEquals("Nsuri", actualInstanciateSimplePropertyResult.getNamespace());
    assertEquals("Prefix", actualInstanciateSimplePropertyResult.getPrefix());
    assertNull(actualInstanciateSimplePropertyResult.getValue());
    assertTrue(actualInstanciateSimplePropertyResult.getAllAttributes().isEmpty());
    assertSame(metadata, actualInstanciateSimplePropertyResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}
   */
  @Test
  void testInstanciateSimpleProperty16() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TypeMapping(XMPMetadata.createXMPMetadata()))
        .instanciateSimpleProperty("Nsuri", "Prefix", "Name", "org.apache.xmpbox.schema.TiffSchema", Types.Date));
  }

  /**
   * Method under test:
   * {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}
   */
  @Test
  void testInstanciateSimpleProperty17() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TypeMapping(XMPMetadata.createXMPMetadata()))
        .instanciateSimpleProperty("Nsuri", "Prefix", "Name", "org.apache.xmpbox.schema.XMPageTextSchema", Types.Date));
  }

  /**
   * Method under test:
   * {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}
   */
  @Test
  void testInstanciateSimpleProperty18() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TypeMapping(XMPMetadata.createXMPMetadata()))
        .instanciateSimpleProperty("Nsuri", "Prefix", "Name", 42, Types.Boolean));
  }

  /**
   * Method under test:
   * {@link TypeMapping#instanciateSimpleProperty(String, String, String, Object, Types)}
   */
  @Test
  void testInstanciateSimpleProperty19() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TypeMapping(XMPMetadata.createXMPMetadata()))
        .instanciateSimpleProperty("Nsuri", "Prefix", "Name", "org.apache.xmpbox.type.PropertyType", Types.Date));
  }

  /**
   * Method under test: {@link TypeMapping#isStructuredTypeNamespace(String)}
   */
  @Test
  void testIsStructuredTypeNamespace() {
    // Arrange, Act and Assert
    assertFalse((new TypeMapping(XMPMetadata.createXMPMetadata())).isStructuredTypeNamespace("Namespace"));
  }

  /**
   * Method under test: {@link TypeMapping#isStructuredTypeNamespace(String)}
   */
  @Test
  void testIsStructuredTypeNamespace2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));

    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);

    // Act and Assert
    assertFalse(typeMapping.isStructuredTypeNamespace("Namespace"));
  }

  /**
   * Method under test: {@link TypeMapping#isDefinedTypeNamespace(String)}
   */
  @Test
  void testIsDefinedTypeNamespace() {
    // Arrange, Act and Assert
    assertFalse((new TypeMapping(XMPMetadata.createXMPMetadata())).isDefinedTypeNamespace("Namespace"));
  }

  /**
   * Method under test: {@link TypeMapping#isDefinedTypeNamespace(String)}
   */
  @Test
  void testIsDefinedTypeNamespace2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));

    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);

    // Act and Assert
    assertFalse(typeMapping.isDefinedTypeNamespace("Namespace"));
  }

  /**
   * Method under test: {@link TypeMapping#isDefinedType(String)}
   */
  @Test
  void testIsDefinedType() {
    // Arrange, Act and Assert
    assertFalse((new TypeMapping(XMPMetadata.createXMPMetadata())).isDefinedType("Name"));
  }

  /**
   * Method under test: {@link TypeMapping#isDefinedType(String)}
   */
  @Test
  void testIsDefinedType2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));

    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);

    // Act and Assert
    assertFalse(typeMapping.isDefinedType("Name"));
  }

  /**
   * Method under test: {@link TypeMapping#getStructuredPropMapping(Types)}
   */
  @Test
  void testGetStructuredPropMapping() {
    // Arrange, Act and Assert
    assertNull((new TypeMapping(XMPMetadata.createXMPMetadata())).getStructuredPropMapping(Types.Structured));
  }

  /**
   * Method under test: {@link TypeMapping#getStructuredPropMapping(Types)}
   */
  @Test
  void testGetStructuredPropMapping2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));

    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);

    // Act and Assert
    assertNull(typeMapping.getStructuredPropMapping(Types.Structured));
  }

  /**
   * Method under test:
   * {@link TypeMapping#getAssociatedSchemaObject(XMPMetadata, String, String)}
   */
  @Test
  void testGetAssociatedSchemaObject() throws XmpSchemaException {
    // Arrange
    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act and Assert
    assertNull(typeMapping.getAssociatedSchemaObject(metadata, "Namespace", "Prefix"));
    assertTrue(metadata.getAllSchemas().isEmpty());
  }

  /**
   * Method under test:
   * {@link TypeMapping#getAssociatedSchemaObject(XMPMetadata, String, String)}
   */
  @Test
  void testGetAssociatedSchemaObject2() throws XmpSchemaException {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));

    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act and Assert
    assertNull(typeMapping.getAssociatedSchemaObject(metadata, "Namespace", "Prefix"));
    assertTrue(metadata.getAllSchemas().isEmpty());
  }

  /**
   * Method under test:
   * {@link TypeMapping#getAssociatedSchemaObject(XMPMetadata, String, String)}
   */
  @Test
  void testGetAssociatedSchemaObject3() throws XmpSchemaException {
    // Arrange
    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());
    typeMapping.addNewNameSpace("java.lang.Object", "java.lang.Object");
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPSchema actualAssociatedSchemaObject = typeMapping.getAssociatedSchemaObject(metadata, "java.lang.Object",
        "Prefix");

    // Assert
    assertEquals("", actualAssociatedSchemaObject.getAboutValue());
    Map<String, String> allNamespacesWithPrefix = actualAssociatedSchemaObject.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("Prefix", allNamespacesWithPrefix.get("java.lang.Object"));
    assertEquals("Prefix", actualAssociatedSchemaObject.getPreferedPrefix());
    assertEquals("Prefix", actualAssociatedSchemaObject.getPrefix());
    assertEquals("java.lang.Object", actualAssociatedSchemaObject.getNamespace());
    assertNull(actualAssociatedSchemaObject.getPropertyName());
    assertNull(actualAssociatedSchemaObject.getAboutAttribute());
    assertEquals(1, metadata.getAllSchemas().size());
    List<AbstractField> allProperties = actualAssociatedSchemaObject.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualAssociatedSchemaObject.getAllAttributes().isEmpty());
    assertSame(allProperties, actualAssociatedSchemaObject.getContainer().getAllProperties());
    assertSame(metadata, actualAssociatedSchemaObject.getMetadata());
  }

  /**
   * Method under test: {@link TypeMapping#getSchemaFactory(String)}
   */
  @Test
  void testGetSchemaFactory() {
    // Arrange, Act and Assert
    assertNull((new TypeMapping(XMPMetadata.createXMPMetadata())).getSchemaFactory("Namespace"));
  }

  /**
   * Method under test: {@link TypeMapping#getSchemaFactory(String)}
   */
  @Test
  void testGetSchemaFactory2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));

    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);

    // Act and Assert
    assertNull(typeMapping.getSchemaFactory("Namespace"));
  }

  /**
   * Method under test: {@link TypeMapping#isDefinedSchema(String)}
   */
  @Test
  void testIsDefinedSchema() {
    // Arrange, Act and Assert
    assertFalse((new TypeMapping(XMPMetadata.createXMPMetadata())).isDefinedSchema("Namespace"));
  }

  /**
   * Method under test: {@link TypeMapping#isDefinedSchema(String)}
   */
  @Test
  void testIsDefinedSchema2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));

    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);

    // Act and Assert
    assertFalse(typeMapping.isDefinedSchema("Namespace"));
  }

  /**
   * Method under test: {@link TypeMapping#isDefinedNamespace(String)}
   */
  @Test
  void testIsDefinedNamespace() {
    // Arrange, Act and Assert
    assertFalse((new TypeMapping(XMPMetadata.createXMPMetadata())).isDefinedNamespace("Namespace"));
  }

  /**
   * Method under test: {@link TypeMapping#isDefinedNamespace(String)}
   */
  @Test
  void testIsDefinedNamespace2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));

    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);

    // Act and Assert
    assertFalse(typeMapping.isDefinedNamespace("Namespace"));
  }

  /**
   * Method under test: {@link TypeMapping#getSpecifiedPropertyType(QName)}
   */
  @Test
  void testGetSpecifiedPropertyType() throws BadFieldValueException {
    // Arrange
    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> typeMapping.getSpecifiedPropertyType(QName.valueOf("foo")));
  }

  /**
   * Method under test: {@link TypeMapping#getSpecifiedPropertyType(QName)}
   */
  @Test
  void testGetSpecifiedPropertyType2() throws BadFieldValueException {
    // Arrange
    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());
    typeMapping.addNewNameSpace("", "Preferred");

    // Act and Assert
    assertNull(typeMapping.getSpecifiedPropertyType(QName.valueOf("foo")));
  }

  /**
   * Method under test: {@link TypeMapping#initializePropMapping(Class)}
   */
  @Test
  void testInitializePropMapping() {
    // Arrange
    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());
    Class<Object> classSchem = Object.class;

    // Act and Assert
    assertTrue(typeMapping.initializePropMapping(classSchem).getPropertiesName().isEmpty());
  }

  /**
   * Method under test: {@link TypeMapping#initializePropMapping(Class)}
   */
  @Test
  void testInitializePropMapping2() {
    // Arrange
    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());
    Class<String> classSchem = String.class;

    // Act and Assert
    assertTrue(typeMapping.initializePropMapping(classSchem).getPropertiesName().isEmpty());
  }

  /**
   * Method under test: {@link TypeMapping#initializePropMapping(Class)}
   */
  @Test
  void testInitializePropMapping3() {
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
   * Method under test: {@link TypeMapping#initializePropMapping(Class)}
   */
  @Test
  void testInitializePropMapping4() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));

    TypeMapping typeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);
    Class<Object> classSchem = Object.class;

    // Act and Assert
    assertTrue(typeMapping.initializePropMapping(classSchem).getPropertiesName().isEmpty());
  }

  /**
   * Method under test:
   * {@link TypeMapping#createBoolean(String, String, String, boolean)}
   */
  @Test
  void testCreateBoolean() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    BooleanType actualCreateBooleanResult = (new TypeMapping(metadata)).createBoolean("Namespace URI", "Prefix",
        "Property Name", true);

    // Assert
    assertEquals("Namespace URI", actualCreateBooleanResult.getNamespace());
    assertEquals("Prefix", actualCreateBooleanResult.getPrefix());
    assertEquals("Property Name", actualCreateBooleanResult.getPropertyName());
    assertTrue(actualCreateBooleanResult.getAllAttributes().isEmpty());
    assertTrue(actualCreateBooleanResult.getValue());
    assertEquals(BooleanType.TRUE, actualCreateBooleanResult.getStringValue());
    assertSame(metadata, actualCreateBooleanResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link TypeMapping#createBoolean(String, String, String, boolean)}
   */
  @Test
  void testCreateBoolean2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TypeMapping typeMapping = new TypeMapping(metadata);
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);

    // Act
    BooleanType actualCreateBooleanResult = typeMapping.createBoolean("Namespace URI", "Prefix", "Property Name", true);

    // Assert
    assertEquals("Namespace URI", actualCreateBooleanResult.getNamespace());
    assertEquals("Prefix", actualCreateBooleanResult.getPrefix());
    assertEquals("Property Name", actualCreateBooleanResult.getPropertyName());
    assertTrue(actualCreateBooleanResult.getAllAttributes().isEmpty());
    assertTrue(actualCreateBooleanResult.getValue());
    assertEquals(BooleanType.TRUE, actualCreateBooleanResult.getStringValue());
    assertSame(metadata, actualCreateBooleanResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link TypeMapping#createDate(String, String, String, Calendar)}
   */
  @Test
  void testCreateDate() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    TypeMapping typeMapping = new TypeMapping(metadata);
    GregorianCalendar value = new GregorianCalendar(1, 1, 1);

    // Act
    DateType actualCreateDateResult = typeMapping.createDate("Namespace URI", "Prefix", "Property Name", value);

    // Assert
    assertEquals("Namespace URI", actualCreateDateResult.getNamespace());
    assertEquals("Prefix", actualCreateDateResult.getPrefix());
    assertEquals("Property Name", actualCreateDateResult.getPropertyName());
    assertTrue(actualCreateDateResult.getAllAttributes().isEmpty());
    assertSame(value, actualCreateDateResult.getRawValue());
    assertSame(value, actualCreateDateResult.getValue());
    assertSame(metadata, actualCreateDateResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link TypeMapping#createDate(String, String, String, Calendar)}
   */
  @Test
  void testCreateDate2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TypeMapping typeMapping = new TypeMapping(metadata);
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);
    GregorianCalendar value = new GregorianCalendar(1, 1, 1);

    // Act
    DateType actualCreateDateResult = typeMapping.createDate("Namespace URI", "Prefix", "Property Name", value);

    // Assert
    assertEquals("Namespace URI", actualCreateDateResult.getNamespace());
    assertEquals("Prefix", actualCreateDateResult.getPrefix());
    assertEquals("Property Name", actualCreateDateResult.getPropertyName());
    assertTrue(actualCreateDateResult.getAllAttributes().isEmpty());
    assertSame(value, actualCreateDateResult.getRawValue());
    assertSame(value, actualCreateDateResult.getValue());
    assertSame(metadata, actualCreateDateResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link TypeMapping#createInteger(String, String, String, int)}
   */
  @Test
  void testCreateInteger() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    IntegerType actualCreateIntegerResult = (new TypeMapping(metadata)).createInteger("Namespace URI", "Prefix",
        "Property Name", 42);

    // Assert
    assertEquals("42", actualCreateIntegerResult.getStringValue());
    assertEquals("Namespace URI", actualCreateIntegerResult.getNamespace());
    assertEquals("Prefix", actualCreateIntegerResult.getPrefix());
    assertEquals("Property Name", actualCreateIntegerResult.getPropertyName());
    assertEquals(42, actualCreateIntegerResult.getValue().intValue());
    assertTrue(actualCreateIntegerResult.getAllAttributes().isEmpty());
    assertSame(metadata, actualCreateIntegerResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link TypeMapping#createInteger(String, String, String, int)}
   */
  @Test
  void testCreateInteger2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TypeMapping typeMapping = new TypeMapping(metadata);
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);

    // Act
    IntegerType actualCreateIntegerResult = typeMapping.createInteger("Namespace URI", "Prefix", "Property Name", 42);

    // Assert
    assertEquals("42", actualCreateIntegerResult.getStringValue());
    assertEquals("Namespace URI", actualCreateIntegerResult.getNamespace());
    assertEquals("Prefix", actualCreateIntegerResult.getPrefix());
    assertEquals("Property Name", actualCreateIntegerResult.getPropertyName());
    assertEquals(42, actualCreateIntegerResult.getValue().intValue());
    assertTrue(actualCreateIntegerResult.getAllAttributes().isEmpty());
    assertSame(metadata, actualCreateIntegerResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link TypeMapping#createReal(String, String, String, float)}
   */
  @Test
  void testCreateReal() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    RealType actualCreateRealResult = (new TypeMapping(metadata)).createReal("Namespace URI", "Prefix", "Property Name",
        10.0f);

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
   * Method under test:
   * {@link TypeMapping#createReal(String, String, String, float)}
   */
  @Test
  void testCreateReal2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TypeMapping typeMapping = new TypeMapping(metadata);
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);

    // Act
    RealType actualCreateRealResult = typeMapping.createReal("Namespace URI", "Prefix", "Property Name", 10.0f);

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
   * Method under test:
   * {@link TypeMapping#createText(String, String, String, String)}
   */
  @Test
  void testCreateText() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    TextType actualCreateTextResult = (new TypeMapping(metadata)).createText("Namespace URI", "Prefix", "Property Name",
        "42");

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
   * Method under test:
   * {@link TypeMapping#createText(String, String, String, String)}
   */
  @Test
  void testCreateText2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TypeMapping typeMapping = new TypeMapping(metadata);
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);

    // Act
    TextType actualCreateTextResult = typeMapping.createText("Namespace URI", "Prefix", "Property Name", "42");

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
   * Method under test:
   * {@link TypeMapping#createProperName(String, String, String, String)}
   */
  @Test
  void testCreateProperName() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ProperNameType actualCreateProperNameResult = (new TypeMapping(metadata)).createProperName("Namespace URI",
        "Prefix", "Property Name", "42");

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
   * Method under test:
   * {@link TypeMapping#createProperName(String, String, String, String)}
   */
  @Test
  void testCreateProperName2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TypeMapping typeMapping = new TypeMapping(metadata);
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);

    // Act
    ProperNameType actualCreateProperNameResult = typeMapping.createProperName("Namespace URI", "Prefix",
        "Property Name", "42");

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
   * Method under test:
   * {@link TypeMapping#createURI(String, String, String, String)}
   */
  @Test
  void testCreateURI() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    URIType actualCreateURIResult = (new TypeMapping(metadata)).createURI("Namespace URI", "Prefix", "Property Name",
        "42");

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
   * Method under test:
   * {@link TypeMapping#createURI(String, String, String, String)}
   */
  @Test
  void testCreateURI2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TypeMapping typeMapping = new TypeMapping(metadata);
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);

    // Act
    URIType actualCreateURIResult = typeMapping.createURI("Namespace URI", "Prefix", "Property Name", "42");

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
   * Method under test:
   * {@link TypeMapping#createURL(String, String, String, String)}
   */
  @Test
  void testCreateURL() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    URLType actualCreateURLResult = (new TypeMapping(metadata)).createURL("https://example.org/example",
        "https://example.org/example", "https://example.org/example", "https://example.org/example");

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
   * Method under test:
   * {@link TypeMapping#createURL(String, String, String, String)}
   */
  @Test
  void testCreateURL2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TypeMapping typeMapping = new TypeMapping(metadata);
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);

    // Act
    URLType actualCreateURLResult = typeMapping.createURL("https://example.org/example", "https://example.org/example",
        "https://example.org/example", "https://example.org/example");

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
   * Method under test:
   * {@link TypeMapping#createRenditionClass(String, String, String, String)}
   */
  @Test
  void testCreateRenditionClass() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    RenditionClassType actualCreateRenditionClassResult = (new TypeMapping(metadata))
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
   * Method under test:
   * {@link TypeMapping#createRenditionClass(String, String, String, String)}
   */
  @Test
  void testCreateRenditionClass2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TypeMapping typeMapping = new TypeMapping(metadata);
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);

    // Act
    RenditionClassType actualCreateRenditionClassResult = typeMapping.createRenditionClass("Namespace URI", "Prefix",
        "Property Name", "42");

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
   * Method under test:
   * {@link TypeMapping#createPart(String, String, String, String)}
   */
  @Test
  void testCreatePart() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PartType actualCreatePartResult = (new TypeMapping(metadata)).createPart("Namespace URI", "Prefix", "Property Name",
        "42");

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
   * Method under test:
   * {@link TypeMapping#createPart(String, String, String, String)}
   */
  @Test
  void testCreatePart2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TypeMapping typeMapping = new TypeMapping(metadata);
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);

    // Act
    PartType actualCreatePartResult = typeMapping.createPart("Namespace URI", "Prefix", "Property Name", "42");

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
   * Method under test:
   * {@link TypeMapping#createMIMEType(String, String, String, String)}
   */
  @Test
  void testCreateMIMEType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    MIMEType actualCreateMIMETypeResult = (new TypeMapping(metadata)).createMIMEType("Namespace URI", "Prefix",
        "Property Name", "42");

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
   * Method under test:
   * {@link TypeMapping#createMIMEType(String, String, String, String)}
   */
  @Test
  void testCreateMIMEType2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TypeMapping typeMapping = new TypeMapping(metadata);
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);

    // Act
    MIMEType actualCreateMIMETypeResult = typeMapping.createMIMEType("Namespace URI", "Prefix", "Property Name", "42");

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
   * Method under test:
   * {@link TypeMapping#createLocale(String, String, String, String)}
   */
  @Test
  void testCreateLocale() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    LocaleType actualCreateLocaleResult = (new TypeMapping(metadata)).createLocale("en", "en", "en", "en");

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
   * Method under test:
   * {@link TypeMapping#createLocale(String, String, String, String)}
   */
  @Test
  void testCreateLocale2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TypeMapping typeMapping = new TypeMapping(metadata);
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);

    // Act
    LocaleType actualCreateLocaleResult = typeMapping.createLocale("en", "en", "en", "en");

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
   * Method under test:
   * {@link TypeMapping#createGUID(String, String, String, String)}
   */
  @Test
  void testCreateGUID() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    GUIDType actualCreateGUIDResult = (new TypeMapping(metadata)).createGUID("Namespace URI", "Prefix", "Property Name",
        "42");

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
   * Method under test:
   * {@link TypeMapping#createGUID(String, String, String, String)}
   */
  @Test
  void testCreateGUID2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TypeMapping typeMapping = new TypeMapping(metadata);
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);

    // Act
    GUIDType actualCreateGUIDResult = typeMapping.createGUID("Namespace URI", "Prefix", "Property Name", "42");

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
   * Method under test:
   * {@link TypeMapping#createChoice(String, String, String, String)}
   */
  @Test
  void testCreateChoice() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ChoiceType actualCreateChoiceResult = (new TypeMapping(metadata)).createChoice("Namespace URI", "Prefix",
        "Property Name", "42");

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
   * Method under test:
   * {@link TypeMapping#createChoice(String, String, String, String)}
   */
  @Test
  void testCreateChoice2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TypeMapping typeMapping = new TypeMapping(metadata);
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);

    // Act
    ChoiceType actualCreateChoiceResult = typeMapping.createChoice("Namespace URI", "Prefix", "Property Name", "42");

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
   * Method under test:
   * {@link TypeMapping#createAgentName(String, String, String, String)}
   */
  @Test
  void testCreateAgentName() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    AgentNameType actualCreateAgentNameResult = (new TypeMapping(metadata)).createAgentName("Namespace URI", "Prefix",
        "Property Name", "42");

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
   * Method under test:
   * {@link TypeMapping#createAgentName(String, String, String, String)}
   */
  @Test
  void testCreateAgentName2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TypeMapping typeMapping = new TypeMapping(metadata);
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);

    // Act
    AgentNameType actualCreateAgentNameResult = typeMapping.createAgentName("Namespace URI", "Prefix", "Property Name",
        "42");

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
   * Method under test:
   * {@link TypeMapping#createXPath(String, String, String, String)}
   */
  @Test
  void testCreateXPath() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XPathType actualCreateXPathResult = (new TypeMapping(metadata)).createXPath("Namespace URI", "Prefix",
        "Property Name", "42");

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
   * Method under test:
   * {@link TypeMapping#createXPath(String, String, String, String)}
   */
  @Test
  void testCreateXPath2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TypeMapping typeMapping = new TypeMapping(metadata);
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);

    // Act
    XPathType actualCreateXPathResult = typeMapping.createXPath("Namespace URI", "Prefix", "Property Name", "42");

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
   * Method under test:
   * {@link TypeMapping#createArrayProperty(String, String, String, Cardinality)}
   */
  @Test
  void testCreateArrayProperty() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ArrayProperty actualCreateArrayPropertyResult = (new TypeMapping(metadata)).createArrayProperty("Namespace",
        "Prefix", "Property Name", Cardinality.Simple);

    // Assert
    assertEquals("Namespace", actualCreateArrayPropertyResult.getNamespace());
    assertEquals("Prefix", actualCreateArrayPropertyResult.getPrefix());
    assertEquals("Property Name", actualCreateArrayPropertyResult.getPropertyName());
    assertEquals(Cardinality.Simple, actualCreateArrayPropertyResult.getArrayType());
    List<AbstractField> allProperties = actualCreateArrayPropertyResult.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualCreateArrayPropertyResult.getAllAttributes().isEmpty());
    assertTrue(actualCreateArrayPropertyResult.getElementsAsString().isEmpty());
    assertTrue(actualCreateArrayPropertyResult.getAllNamespacesWithPrefix().isEmpty());
    assertSame(allProperties, actualCreateArrayPropertyResult.getContainer().getAllProperties());
    assertSame(metadata, actualCreateArrayPropertyResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link TypeMapping#createArrayProperty(String, String, String, Cardinality)}
   */
  @Test
  void testCreateArrayProperty2() {
    // Arrange
    PropertiesDescription pm = new PropertiesDescription();
    pm.addNewProperty("Name", mock(PropertyType.class));
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TypeMapping typeMapping = new TypeMapping(metadata);
    typeMapping.addToDefinedStructuredTypes("Type Name", "Ns", pm);

    // Act
    ArrayProperty actualCreateArrayPropertyResult = typeMapping.createArrayProperty("Namespace", "Prefix",
        "Property Name", Cardinality.Simple);

    // Assert
    assertEquals("Namespace", actualCreateArrayPropertyResult.getNamespace());
    assertEquals("Prefix", actualCreateArrayPropertyResult.getPrefix());
    assertEquals("Property Name", actualCreateArrayPropertyResult.getPropertyName());
    assertEquals(Cardinality.Simple, actualCreateArrayPropertyResult.getArrayType());
    List<AbstractField> allProperties = actualCreateArrayPropertyResult.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualCreateArrayPropertyResult.getAllAttributes().isEmpty());
    assertTrue(actualCreateArrayPropertyResult.getElementsAsString().isEmpty());
    assertTrue(actualCreateArrayPropertyResult.getAllNamespacesWithPrefix().isEmpty());
    assertSame(allProperties, actualCreateArrayPropertyResult.getContainer().getAllProperties());
    assertSame(metadata, actualCreateArrayPropertyResult.getMetadata());
  }

  /**
   * Method under test: {@link TypeMapping#TypeMapping(XMPMetadata)}
   */
  @Test
  void testNewTypeMapping() {
    // Arrange and Act
    TypeMapping actualTypeMapping = new TypeMapping(XMPMetadata.createXMPMetadata());

    // Assert
    assertNull(actualTypeMapping.getSchemaFactory("Namespace"));
    assertNull(actualTypeMapping.getDefinedDescriptionByNamespace("Namespace"));
    assertNull(actualTypeMapping.getStructuredPropMapping(Types.Structured));
  }
}

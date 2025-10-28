package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.type.AbstractField;
import org.apache.xmpbox.type.ArrayProperty;
import org.apache.xmpbox.type.Attribute;
import org.apache.xmpbox.type.BadFieldValueException;
import org.apache.xmpbox.type.Cardinality;
import org.apache.xmpbox.type.DateType;
import org.apache.xmpbox.type.MIMEType;
import org.apache.xmpbox.type.TextType;
import org.junit.jupiter.api.Test;

class DublinCoreSchemaDiffblueTest {
  /**
   * Method under test: {@link DublinCoreSchema#addContributor(String)}
   */
  @Test
  void testAddContributor() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);

    // Act
    dublinCoreSchema.addContributor("Proper Name");

    // Assert
    ArrayProperty contributorsProperty = dublinCoreSchema.getContributorsProperty();
    List<AbstractField> allProperties = contributorsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> contributors = dublinCoreSchema.getContributors();
    assertEquals(1, contributors.size());
    assertEquals("Proper Name", contributors.get(0));
    List<String> elementsAsString = contributorsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Proper Name", elementsAsString.get(0));
    assertEquals("Proper Name", ((TextType) getResult).getStringValue());
    assertEquals("Proper Name", ((TextType) getResult).getRawValue());
    assertEquals("Proper Name", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", contributorsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", contributorsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertNull(dublinCoreSchema.getCreatorsProperty());
    assertNull(dublinCoreSchema.getDatesProperty());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Bag, contributorsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(contributorsProperty.getAllAttributes().isEmpty());
    assertTrue(contributorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, contributorsProperty.getPropertyName());
    assertSame(contributorsProperty, allProperties2.get(0));
    assertSame(allProperties, contributorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, contributorsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addContributor(String)}
   */
  @Test
  void testAddContributor2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addContributor(DublinCoreSchema.CONTRIBUTOR);

    // Act
    dublinCoreSchema.addContributor("Proper Name");

    // Assert
    ArrayProperty contributorsProperty = dublinCoreSchema.getContributorsProperty();
    List<AbstractField> allProperties = contributorsProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> contributors = dublinCoreSchema.getContributors();
    assertEquals(2, contributors.size());
    assertEquals("Proper Name", contributors.get(1));
    assertEquals("Proper Name", ((TextType) getResult2).getStringValue());
    assertEquals("Proper Name", ((TextType) getResult2).getRawValue());
    assertEquals("Proper Name", ((TextType) getResult2).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", getResult2.getPrefix());
    assertEquals("dc", contributorsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult2.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", contributorsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    assertNull(dublinCoreSchema.getCreatorsProperty());
    assertNull(dublinCoreSchema.getDatesProperty());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Bag, contributorsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(contributorsProperty.getAllAttributes().isEmpty());
    assertTrue(contributorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(contributors, contributorsProperty.getElementsAsString());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, contributors.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, contributorsProperty.getPropertyName());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getValue());
    assertSame(contributorsProperty, allProperties2.get(0));
    assertSame(allProperties, contributorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, contributorsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addContributor(String)}
   */
  @Test
  void testAddContributor3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addCreator("li");
    dublinCoreSchema.addContributor(DublinCoreSchema.CONTRIBUTOR);

    // Act
    dublinCoreSchema.addContributor("Proper Name");

    // Assert
    ArrayProperty contributorsProperty = dublinCoreSchema.getContributorsProperty();
    List<AbstractField> allProperties = contributorsProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> contributors = dublinCoreSchema.getContributors();
    assertEquals(2, contributors.size());
    assertEquals("Proper Name", contributors.get(1));
    assertEquals("Proper Name", ((TextType) getResult2).getStringValue());
    assertEquals("Proper Name", ((TextType) getResult2).getRawValue());
    assertEquals("Proper Name", ((TextType) getResult2).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", getResult2.getPrefix());
    assertEquals("dc", contributorsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult2.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", contributorsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    assertNull(dublinCoreSchema.getDatesProperty());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Bag, contributorsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(contributorsProperty.getAllAttributes().isEmpty());
    assertTrue(contributorsProperty.getAllNamespacesWithPrefix().isEmpty());
    ArrayProperty creatorsProperty = dublinCoreSchema.getCreatorsProperty();
    assertTrue(creatorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(contributors, contributorsProperty.getElementsAsString());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, contributors.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, contributorsProperty.getPropertyName());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getValue());
    assertSame(contributorsProperty, allProperties2.get(1));
    assertSame(creatorsProperty, allProperties2.get(0));
    assertSame(allProperties, contributorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, contributorsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addContributor(String)}
   */
  @Test
  void testAddContributor4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);

    // Act
    dublinCoreSchema.addContributor("Proper Name");

    // Assert
    ArrayProperty contributorsProperty = dublinCoreSchema.getContributorsProperty();
    List<AbstractField> allProperties = contributorsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> contributors = dublinCoreSchema.getContributors();
    assertEquals(1, contributors.size());
    assertEquals("Proper Name", contributors.get(0));
    List<String> elementsAsString = contributorsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Proper Name", elementsAsString.get(0));
    assertEquals("Proper Name", ((TextType) getResult).getStringValue());
    assertEquals("Proper Name", ((TextType) getResult).getRawValue());
    assertEquals("Proper Name", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", contributorsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", contributorsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertNull(dublinCoreSchema.getDatesProperty());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Bag, contributorsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(contributorsProperty.getAllAttributes().isEmpty());
    assertTrue(contributorsProperty.getAllNamespacesWithPrefix().isEmpty());
    ArrayProperty creatorsProperty = dublinCoreSchema.getCreatorsProperty();
    assertTrue(creatorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, contributorsProperty.getPropertyName());
    assertSame(contributorsProperty, allProperties2.get(1));
    assertSame(creatorsProperty, allProperties2.get(0));
    assertSame(allProperties, contributorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, contributorsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addContributor(String)}
   */
  @Test
  void testAddContributor5() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addDate(new GregorianCalendar(1, 1, 1));
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);

    // Act
    dublinCoreSchema.addContributor("Proper Name");

    // Assert
    ArrayProperty contributorsProperty = dublinCoreSchema.getContributorsProperty();
    List<AbstractField> allProperties = contributorsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> contributors = dublinCoreSchema.getContributors();
    assertEquals(1, contributors.size());
    assertEquals("Proper Name", contributors.get(0));
    List<String> elementsAsString = contributorsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Proper Name", elementsAsString.get(0));
    assertEquals("Proper Name", ((TextType) getResult).getStringValue());
    assertEquals("Proper Name", ((TextType) getResult).getRawValue());
    assertEquals("Proper Name", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", contributorsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", contributorsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(3, allProperties2.size());
    assertEquals(Cardinality.Bag, contributorsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(contributorsProperty.getAllAttributes().isEmpty());
    assertTrue(contributorsProperty.getAllNamespacesWithPrefix().isEmpty());
    ArrayProperty creatorsProperty = dublinCoreSchema.getCreatorsProperty();
    assertTrue(creatorsProperty.getAllNamespacesWithPrefix().isEmpty());
    ArrayProperty datesProperty = dublinCoreSchema.getDatesProperty();
    assertTrue(datesProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, contributorsProperty.getPropertyName());
    assertSame(contributorsProperty, allProperties2.get(2));
    assertSame(creatorsProperty, allProperties2.get(1));
    assertSame(datesProperty, allProperties2.get(0));
    assertSame(allProperties, contributorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, contributorsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#removeContributor(String)}
   */
  @Test
  void testRemoveContributor() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());

    // Act
    dublinCoreSchema.removeContributor("Proper Name");

    // Assert that nothing has changed
    assertNull(dublinCoreSchema.getContributors());
    assertNull(dublinCoreSchema.getContributorsProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#removeContributor(String)}
   */
  @Test
  void testRemoveContributor2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.CONTRIBUTOR);

    // Act
    dublinCoreSchema.removeContributor("Proper Name");

    // Assert that nothing has changed
    ArrayProperty contributorsProperty = dublinCoreSchema.getContributorsProperty();
    List<AbstractField> allProperties = contributorsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> contributors = dublinCoreSchema.getContributors();
    assertEquals(1, contributors.size());
    List<String> elementsAsString = contributorsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, contributors.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, elementsAsString.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getValue());
  }

  /**
   * Method under test: {@link DublinCoreSchema#removeContributor(String)}
   */
  @Test
  void testRemoveContributor3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor("Proper Name");
    dublinCoreSchema.addContributor(DublinCoreSchema.CONTRIBUTOR);

    // Act
    dublinCoreSchema.removeContributor("Proper Name");

    // Assert
    ArrayProperty contributorsProperty = dublinCoreSchema.getContributorsProperty();
    List<AbstractField> allProperties = contributorsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> contributors = dublinCoreSchema.getContributors();
    assertEquals(1, contributors.size());
    List<String> elementsAsString = contributorsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, contributors.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, elementsAsString.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getValue());
  }

  /**
   * Method under test: {@link DublinCoreSchema#removeContributor(String)}
   */
  @Test
  void testRemoveContributor4() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator("Proper Name");
    dublinCoreSchema.addContributor(DublinCoreSchema.CONTRIBUTOR);

    // Act
    dublinCoreSchema.removeContributor("Proper Name");

    // Assert that nothing has changed
    ArrayProperty contributorsProperty = dublinCoreSchema.getContributorsProperty();
    List<AbstractField> allProperties = contributorsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> contributors = dublinCoreSchema.getContributors();
    assertEquals(1, contributors.size());
    List<String> elementsAsString = contributorsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, contributors.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, elementsAsString.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getValue());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setCoverage(String)}
   */
  @Test
  void testSetCoverage() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);

    // Act
    dublinCoreSchema.setCoverage("Text");

    // Assert
    assertEquals("Text", dublinCoreSchema.getCoverage());
    TextType coverageProperty = dublinCoreSchema.getCoverageProperty();
    assertEquals("Text", coverageProperty.getStringValue());
    assertEquals("Text", coverageProperty.getRawValue());
    assertEquals("Text", coverageProperty.getValue());
    assertEquals("dc", coverageProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", coverageProperty.getNamespace());
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(coverageProperty.getAllAttributes().isEmpty());
    assertEquals(DublinCoreSchema.COVERAGE, coverageProperty.getPropertyName());
    assertSame(coverageProperty, allProperties.get(0));
    assertSame(metadata, coverageProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setCoverage(String)}
   */
  @Test
  void testSetCoverage2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addContributor(DublinCoreSchema.COVERAGE);

    // Act
    dublinCoreSchema.setCoverage("Text");

    // Assert
    assertEquals("Text", dublinCoreSchema.getCoverage());
    TextType coverageProperty = dublinCoreSchema.getCoverageProperty();
    assertEquals("Text", coverageProperty.getStringValue());
    assertEquals("Text", coverageProperty.getRawValue());
    assertEquals("Text", coverageProperty.getValue());
    assertEquals("dc", coverageProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", coverageProperty.getNamespace());
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(coverageProperty.getAllAttributes().isEmpty());
    assertEquals(DublinCoreSchema.COVERAGE, coverageProperty.getPropertyName());
    assertSame(coverageProperty, allProperties.get(1));
    assertSame(metadata, coverageProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setCoverage(String)}
   */
  @Test
  void testSetCoverage3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.COVERAGE);

    // Act
    dublinCoreSchema.setCoverage("Text");

    // Assert
    assertEquals("Text", dublinCoreSchema.getCoverage());
    TextType coverageProperty = dublinCoreSchema.getCoverageProperty();
    assertEquals("Text", coverageProperty.getStringValue());
    assertEquals("Text", coverageProperty.getRawValue());
    assertEquals("Text", coverageProperty.getValue());
    assertEquals("dc", coverageProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", coverageProperty.getNamespace());
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(coverageProperty.getAllAttributes().isEmpty());
    assertEquals(DublinCoreSchema.COVERAGE, coverageProperty.getPropertyName());
    assertSame(coverageProperty, allProperties.get(2));
    assertSame(metadata, coverageProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setCoverage(String)}
   */
  @Test
  void testSetCoverage4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addBagValueAsSimple(DublinCoreSchema.COVERAGE, "42");

    // Act
    dublinCoreSchema.setCoverage("Text");

    // Assert
    assertEquals("Text", dublinCoreSchema.getCoverage());
    TextType coverageProperty = dublinCoreSchema.getCoverageProperty();
    assertEquals("Text", coverageProperty.getStringValue());
    assertEquals("Text", coverageProperty.getRawValue());
    assertEquals("Text", coverageProperty.getValue());
    assertEquals("dc", coverageProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", coverageProperty.getNamespace());
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(coverageProperty.getAllAttributes().isEmpty());
    assertEquals(DublinCoreSchema.COVERAGE, coverageProperty.getPropertyName());
    assertSame(coverageProperty, allProperties.get(0));
    assertSame(metadata, coverageProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setCoverageProperty(TextType)}
   */
  @Test
  void testSetCoverageProperty() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    dublinCoreSchema.setCoverageProperty(text);

    // Assert
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Method under test: {@link DublinCoreSchema#setCoverageProperty(TextType)}
   */
  @Test
  void testSetCoverageProperty2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor("Proper Name");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    dublinCoreSchema.setCoverageProperty(text);

    // Assert
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link DublinCoreSchema#setCoverageProperty(TextType)}
   */
  @Test
  void testSetCoverageProperty3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator("Property Name");
    dublinCoreSchema.addContributor("Proper Name");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    dublinCoreSchema.setCoverageProperty(text);

    // Assert
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test: {@link DublinCoreSchema#setCoverageProperty(TextType)}
   */
  @Test
  void testSetCoverageProperty4() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addBagValueAsSimple("Property Name", DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor("Proper Name");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    dublinCoreSchema.setCoverageProperty(text);

    // Assert
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link DublinCoreSchema#addCreator(String)}
   */
  @Test
  void testAddCreator() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);

    // Act
    dublinCoreSchema.addCreator("Proper Name");

    // Assert
    ArrayProperty creatorsProperty = dublinCoreSchema.getCreatorsProperty();
    List<AbstractField> allProperties = creatorsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> creators = dublinCoreSchema.getCreators();
    assertEquals(1, creators.size());
    assertEquals("Proper Name", creators.get(0));
    List<String> elementsAsString = creatorsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Proper Name", elementsAsString.get(0));
    assertEquals("Proper Name", ((TextType) getResult).getStringValue());
    assertEquals("Proper Name", ((TextType) getResult).getRawValue());
    assertEquals("Proper Name", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", creatorsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", creatorsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Seq, creatorsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(creatorsProperty.getAllAttributes().isEmpty());
    assertTrue(creatorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.CREATOR, creatorsProperty.getPropertyName());
    assertSame(creatorsProperty, allProperties2.get(0));
    assertSame(allProperties, creatorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, creatorsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addCreator(String)}
   */
  @Test
  void testAddCreator2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addContributor(DublinCoreSchema.CREATOR);

    // Act
    dublinCoreSchema.addCreator("Proper Name");

    // Assert
    ArrayProperty creatorsProperty = dublinCoreSchema.getCreatorsProperty();
    List<AbstractField> allProperties = creatorsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> creators = dublinCoreSchema.getCreators();
    assertEquals(1, creators.size());
    assertEquals("Proper Name", creators.get(0));
    List<String> elementsAsString = creatorsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Proper Name", elementsAsString.get(0));
    assertEquals("Proper Name", ((TextType) getResult).getStringValue());
    assertEquals("Proper Name", ((TextType) getResult).getRawValue());
    assertEquals("Proper Name", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", creatorsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", creatorsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Seq, creatorsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(creatorsProperty.getAllAttributes().isEmpty());
    assertTrue(creatorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.CREATOR, creatorsProperty.getPropertyName());
    assertSame(creatorsProperty, allProperties2.get(1));
    assertSame(allProperties, creatorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, creatorsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addCreator(String)}
   */
  @Test
  void testAddCreator3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.CREATOR);

    // Act
    dublinCoreSchema.addCreator("Proper Name");

    // Assert
    ArrayProperty creatorsProperty = dublinCoreSchema.getCreatorsProperty();
    List<AbstractField> allProperties = creatorsProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> creators = dublinCoreSchema.getCreators();
    assertEquals(2, creators.size());
    assertEquals("Proper Name", creators.get(1));
    assertEquals("Proper Name", ((TextType) getResult2).getStringValue());
    assertEquals("Proper Name", ((TextType) getResult2).getRawValue());
    assertEquals("Proper Name", ((TextType) getResult2).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", getResult2.getPrefix());
    assertEquals("dc", creatorsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult2.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", creatorsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Seq, creatorsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(creatorsProperty.getAllAttributes().isEmpty());
    assertTrue(creatorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(creators, creatorsProperty.getElementsAsString());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, creators.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getValue());
    assertEquals(DublinCoreSchema.CREATOR, creatorsProperty.getPropertyName());
    assertSame(creatorsProperty, allProperties2.get(0));
    assertSame(allProperties, creatorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, creatorsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addCreator(String)}
   */
  @Test
  void testAddCreator4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addDate(new GregorianCalendar(1, 1, 1));
    dublinCoreSchema.addContributor(DublinCoreSchema.CREATOR);

    // Act
    dublinCoreSchema.addCreator("Proper Name");

    // Assert
    ArrayProperty creatorsProperty = dublinCoreSchema.getCreatorsProperty();
    List<AbstractField> allProperties = creatorsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> creators = dublinCoreSchema.getCreators();
    assertEquals(1, creators.size());
    assertEquals("Proper Name", creators.get(0));
    List<String> elementsAsString = creatorsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Proper Name", elementsAsString.get(0));
    assertEquals("Proper Name", ((TextType) getResult).getStringValue());
    assertEquals("Proper Name", ((TextType) getResult).getRawValue());
    assertEquals("Proper Name", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", creatorsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", creatorsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(3, allProperties2.size());
    assertEquals(Cardinality.Seq, creatorsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(creatorsProperty.getAllAttributes().isEmpty());
    assertTrue(creatorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.CREATOR, creatorsProperty.getPropertyName());
    assertSame(creatorsProperty, allProperties2.get(2));
    assertSame(allProperties, creatorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, creatorsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addDate(Calendar)}
   */
  @Test
  void testAddDate() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    dublinCoreSchema.addDate(date);

    // Assert
    ArrayProperty datesProperty = dublinCoreSchema.getDatesProperty();
    List<AbstractField> allProperties = datesProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof DateType);
    assertEquals("RDF", getResult.getPrefix());
    assertEquals("dc", datesProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", datesProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertNull(getResult.getNamespace());
    List<Calendar> dates = dublinCoreSchema.getDates();
    assertEquals(1, dates.size());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(1, datesProperty.getElementsAsString().size());
    assertEquals(Cardinality.Seq, datesProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(datesProperty.getAllAttributes().isEmpty());
    assertTrue(datesProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.DATE, datesProperty.getPropertyName());
    assertSame(date, dates.get(0));
    assertSame(date, ((DateType) getResult).getRawValue());
    assertSame(date, ((DateType) getResult).getValue());
    assertSame(datesProperty, allProperties2.get(0));
    assertSame(allProperties, datesProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, datesProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addDate(Calendar)}
   */
  @Test
  void testAddDate2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addContributor(DublinCoreSchema.DATE);
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    dublinCoreSchema.addDate(date);

    // Assert
    ArrayProperty datesProperty = dublinCoreSchema.getDatesProperty();
    List<AbstractField> allProperties = datesProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof DateType);
    assertEquals("RDF", getResult.getPrefix());
    assertEquals("dc", datesProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", datesProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertNull(getResult.getNamespace());
    List<Calendar> dates = dublinCoreSchema.getDates();
    assertEquals(1, dates.size());
    assertEquals(1, datesProperty.getElementsAsString().size());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Seq, datesProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(datesProperty.getAllAttributes().isEmpty());
    assertTrue(datesProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.DATE, datesProperty.getPropertyName());
    assertSame(date, dates.get(0));
    assertSame(date, ((DateType) getResult).getRawValue());
    assertSame(date, ((DateType) getResult).getValue());
    assertSame(datesProperty, allProperties2.get(1));
    assertSame(allProperties, datesProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, datesProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addDate(Calendar)}
   */
  @Test
  void testAddDate3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addCreator("RDF");
    dublinCoreSchema.addContributor(DublinCoreSchema.DATE);
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    dublinCoreSchema.addDate(date);

    // Assert
    ArrayProperty datesProperty = dublinCoreSchema.getDatesProperty();
    List<AbstractField> allProperties = datesProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof DateType);
    assertEquals("RDF", getResult.getPrefix());
    assertEquals("dc", datesProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", datesProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertNull(getResult.getNamespace());
    List<Calendar> dates = dublinCoreSchema.getDates();
    assertEquals(1, dates.size());
    assertEquals(1, datesProperty.getElementsAsString().size());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(3, allProperties2.size());
    assertEquals(Cardinality.Seq, datesProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(datesProperty.getAllAttributes().isEmpty());
    assertTrue(datesProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.DATE, datesProperty.getPropertyName());
    assertSame(date, dates.get(0));
    assertSame(date, ((DateType) getResult).getRawValue());
    assertSame(date, ((DateType) getResult).getValue());
    assertSame(datesProperty, allProperties2.get(2));
    assertSame(allProperties, datesProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, datesProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addDate(Calendar)}
   */
  @Test
  void testAddDate4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    dublinCoreSchema.addDate(date);
    dublinCoreSchema.addContributor(DublinCoreSchema.DATE);
    GregorianCalendar date2 = new GregorianCalendar(1, 1, 1);

    // Act
    dublinCoreSchema.addDate(date2);

    // Assert
    List<Calendar> dates = dublinCoreSchema.getDates();
    assertEquals(2, dates.size());
    Calendar getResult = dates.get(0);
    assertTrue(getResult instanceof GregorianCalendar);
    ArrayProperty datesProperty = dublinCoreSchema.getDatesProperty();
    List<AbstractField> allProperties = datesProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult2 = allProperties.get(0);
    assertTrue(getResult2 instanceof DateType);
    AbstractField getResult3 = allProperties.get(1);
    assertTrue(getResult3 instanceof DateType);
    assertEquals("RDF", getResult2.getPrefix());
    assertEquals("RDF", getResult3.getPrefix());
    assertEquals("dc", datesProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", datesProperty.getNamespace());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("li", getResult3.getPropertyName());
    assertNull(getResult2.getNamespace());
    assertNull(getResult3.getNamespace());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(2, datesProperty.getElementsAsString().size());
    assertEquals(Cardinality.Seq, datesProperty.getArrayType());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(datesProperty.getAllAttributes().isEmpty());
    assertTrue(datesProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.DATE, datesProperty.getPropertyName());
    assertSame(date, getResult);
    assertSame(date2, dates.get(1));
    assertSame(date, ((DateType) getResult2).getRawValue());
    assertSame(date2, ((DateType) getResult3).getRawValue());
    assertSame(date, ((DateType) getResult2).getValue());
    assertSame(date2, ((DateType) getResult3).getValue());
    assertSame(datesProperty, allProperties2.get(0));
    assertSame(allProperties, datesProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, datesProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#removeDate(Calendar)}
   */
  @Test
  void testRemoveDate() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());

    // Act
    dublinCoreSchema.removeDate(new GregorianCalendar(1, 1, 1));

    // Assert that nothing has changed
    assertNull(dublinCoreSchema.getDates());
    assertNull(dublinCoreSchema.getDatesProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#removeDate(Calendar)}
   */
  @Test
  void testRemoveDate2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.DATE);

    // Act
    dublinCoreSchema.removeDate(new GregorianCalendar(1, 1, 1));

    // Assert that nothing has changed
    assertNull(dublinCoreSchema.getDates());
    assertNull(dublinCoreSchema.getDatesProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#removeDate(Calendar)}
   */
  @Test
  void testRemoveDate3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addDate(new GregorianCalendar(1, 1, 1));
    dublinCoreSchema.addContributor(DublinCoreSchema.DATE);

    // Act
    dublinCoreSchema.removeDate(new GregorianCalendar(1, 1, 1));

    // Assert
    assertTrue(dublinCoreSchema.getDates().isEmpty());
    ArrayProperty datesProperty = dublinCoreSchema.getDatesProperty();
    assertTrue(datesProperty.getAllProperties().isEmpty());
    assertTrue(datesProperty.getElementsAsString().isEmpty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#removeDate(Calendar)}
   */
  @Test
  void testRemoveDate4() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addBagValueAsSimple(DublinCoreSchema.DATE, "42");

    // Act
    dublinCoreSchema.removeDate(new GregorianCalendar(1, 1, 1));

    // Assert that nothing has changed
    ArrayProperty datesProperty = dublinCoreSchema.getDatesProperty();
    assertEquals(1, datesProperty.getAllProperties().size());
    assertEquals(1, datesProperty.getElementsAsString().size());
    assertTrue(dublinCoreSchema.getDates().isEmpty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#removeDate(Calendar)}
   */
  @Test
  void testRemoveDate5() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addDate(new GregorianCalendar(1, 1, 1));
    dublinCoreSchema.addDate(new GregorianCalendar(1, 1, 1));
    dublinCoreSchema.addContributor(DublinCoreSchema.DATE);

    // Act
    dublinCoreSchema.removeDate(new GregorianCalendar(1, 1, 1));

    // Assert
    assertTrue(dublinCoreSchema.getDates().isEmpty());
    ArrayProperty datesProperty = dublinCoreSchema.getDatesProperty();
    assertTrue(datesProperty.getAllProperties().isEmpty());
    assertTrue(datesProperty.getElementsAsString().isEmpty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#removeDate(Calendar)}
   */
  @Test
  void testRemoveDate6() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addDate(new GregorianCalendar(0, 1, 1));
    dublinCoreSchema.addContributor(DublinCoreSchema.DATE);

    // Act
    dublinCoreSchema.removeDate(new GregorianCalendar(1, 1, 1));

    // Assert that nothing has changed
    assertEquals(1, dublinCoreSchema.getDates().size());
    ArrayProperty datesProperty = dublinCoreSchema.getDatesProperty();
    assertEquals(1, datesProperty.getAllProperties().size());
    assertEquals(1, datesProperty.getElementsAsString().size());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addDescription(String, String)}
   */
  @Test
  void testAddDescription() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);

    // Act
    dublinCoreSchema.addDescription("Lang", "42");

    // Assert
    ArrayProperty descriptionProperty = dublinCoreSchema.getDescriptionProperty();
    List<AbstractField> allProperties = descriptionProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = descriptionProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> descriptionLanguages = dublinCoreSchema.getDescriptionLanguages();
    assertEquals(1, descriptionLanguages.size());
    assertEquals("Lang", descriptionLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", descriptionProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", descriptionProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Alt, descriptionProperty.getArrayType());
    assertTrue(descriptionProperty.getAllAttributes().isEmpty());
    assertTrue(descriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.DESCRIPTION, descriptionProperty.getPropertyName());
    assertSame(descriptionProperty, allProperties2.get(0));
    assertSame(allProperties, descriptionProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, descriptionProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addDescription(String, String)}
   */
  @Test
  void testAddDescription2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act
    dublinCoreSchema.addDescription("Lang", "42");

    // Assert
    ArrayProperty descriptionProperty = dublinCoreSchema.getDescriptionProperty();
    List<AbstractField> allProperties = descriptionProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = descriptionProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> descriptionLanguages = dublinCoreSchema.getDescriptionLanguages();
    assertEquals(1, descriptionLanguages.size());
    assertEquals("Lang", descriptionLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", descriptionProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", descriptionProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, descriptionProperty.getArrayType());
    assertTrue(descriptionProperty.getAllAttributes().isEmpty());
    assertTrue(descriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.DESCRIPTION, descriptionProperty.getPropertyName());
    assertSame(descriptionProperty, allProperties2.get(1));
    assertSame(allProperties, descriptionProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, descriptionProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addDescription(String, String)}
   */
  @Test
  void testAddDescription3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act
    dublinCoreSchema.addDescription("Lang", "42");

    // Assert
    ArrayProperty descriptionProperty = dublinCoreSchema.getDescriptionProperty();
    List<AbstractField> allProperties = descriptionProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = descriptionProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> descriptionLanguages = dublinCoreSchema.getDescriptionLanguages();
    assertEquals(1, descriptionLanguages.size());
    assertEquals("Lang", descriptionLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", descriptionProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", descriptionProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(3, allProperties2.size());
    assertEquals(Cardinality.Alt, descriptionProperty.getArrayType());
    assertTrue(descriptionProperty.getAllAttributes().isEmpty());
    assertTrue(descriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.DESCRIPTION, descriptionProperty.getPropertyName());
    assertSame(descriptionProperty, allProperties2.get(2));
    assertSame(allProperties, descriptionProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, descriptionProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addDescription(String, String)}
   */
  @Test
  void testAddDescription4() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addDescription(DublinCoreSchema.CONTRIBUTOR, DublinCoreSchema.DESCRIPTION);
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act
    dublinCoreSchema.addDescription("Lang", "42");

    // Assert
    ArrayProperty descriptionProperty = dublinCoreSchema.getDescriptionProperty();
    List<AbstractField> allProperties = descriptionProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = descriptionProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    List<String> descriptionLanguages = dublinCoreSchema.getDescriptionLanguages();
    assertEquals(2, descriptionLanguages.size());
    assertEquals("Lang", descriptionLanguages.get(1));
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("Lang", getResult3.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", getResult2.getPrefix());
    assertEquals("dc", descriptionProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult2.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", descriptionProperty.getNamespace());
    List<Attribute> allAttributes2 = getResult.getAllAttributes();
    assertEquals(1, allAttributes2.size());
    Attribute getResult4 = allAttributes2.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult4.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    assertEquals("lang", getResult4.getName());
    assertEquals("lang", getResult3.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, descriptionProperty.getArrayType());
    assertTrue(descriptionProperty.getAllAttributes().isEmpty());
    assertTrue(descriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, descriptionLanguages.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, getResult4.getValue());
    assertEquals(DublinCoreSchema.DESCRIPTION, elementsAsString.get(0));
    assertEquals(DublinCoreSchema.DESCRIPTION, descriptionProperty.getPropertyName());
    assertEquals(DublinCoreSchema.DESCRIPTION, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.DESCRIPTION, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.DESCRIPTION, ((TextType) getResult).getValue());
    assertSame(descriptionProperty, allProperties2.get(0));
    assertSame(allProperties, descriptionProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, descriptionProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addDescription(String, String)}
   */
  @Test
  void testAddDescription5() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addDescription("Lang", DublinCoreSchema.DESCRIPTION);
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act
    dublinCoreSchema.addDescription("Lang", "42");

    // Assert
    ArrayProperty descriptionProperty = dublinCoreSchema.getDescriptionProperty();
    List<AbstractField> allProperties = descriptionProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = descriptionProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> descriptionLanguages = dublinCoreSchema.getDescriptionLanguages();
    assertEquals(1, descriptionLanguages.size());
    assertEquals("Lang", descriptionLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", descriptionProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", descriptionProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, descriptionProperty.getArrayType());
    assertTrue(descriptionProperty.getAllAttributes().isEmpty());
    assertTrue(descriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.DESCRIPTION, descriptionProperty.getPropertyName());
    assertSame(descriptionProperty, allProperties2.get(0));
    assertSame(allProperties, descriptionProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, descriptionProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addDescription(String, String)}
   */
  @Test
  void testAddDescription6() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addDescription("x-default", DublinCoreSchema.DESCRIPTION);
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act
    dublinCoreSchema.addDescription("Lang", "42");

    // Assert
    ArrayProperty descriptionProperty = dublinCoreSchema.getDescriptionProperty();
    List<AbstractField> allProperties = descriptionProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = descriptionProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    List<String> descriptionLanguages = dublinCoreSchema.getDescriptionLanguages();
    assertEquals(2, descriptionLanguages.size());
    assertEquals("Lang", descriptionLanguages.get(1));
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("Lang", getResult3.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", getResult2.getPrefix());
    assertEquals("dc", descriptionProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult2.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", descriptionProperty.getNamespace());
    List<Attribute> allAttributes2 = getResult.getAllAttributes();
    assertEquals(1, allAttributes2.size());
    Attribute getResult4 = allAttributes2.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult4.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    assertEquals("lang", getResult4.getName());
    assertEquals("lang", getResult3.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("x-default", descriptionLanguages.get(0));
    assertEquals("x-default", getResult4.getValue());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, descriptionProperty.getArrayType());
    assertTrue(descriptionProperty.getAllAttributes().isEmpty());
    assertTrue(descriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.DESCRIPTION, elementsAsString.get(0));
    assertEquals(DublinCoreSchema.DESCRIPTION, descriptionProperty.getPropertyName());
    assertEquals(DublinCoreSchema.DESCRIPTION, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.DESCRIPTION, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.DESCRIPTION, ((TextType) getResult).getValue());
    assertSame(descriptionProperty, allProperties2.get(0));
    assertSame(allProperties, descriptionProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, descriptionProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setDescription(String)}
   */
  @Test
  void testSetDescription() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);

    // Act
    dublinCoreSchema.setDescription("42");

    // Assert
    ArrayProperty descriptionProperty = dublinCoreSchema.getDescriptionProperty();
    List<AbstractField> allProperties = descriptionProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = descriptionProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", dublinCoreSchema.getDescription());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", descriptionProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", descriptionProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<String> descriptionLanguages = dublinCoreSchema.getDescriptionLanguages();
    assertEquals(1, descriptionLanguages.size());
    assertEquals("x-default", descriptionLanguages.get(0));
    assertEquals("x-default", getResult2.getValue());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Alt, descriptionProperty.getArrayType());
    assertTrue(descriptionProperty.getAllAttributes().isEmpty());
    assertTrue(descriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.DESCRIPTION, descriptionProperty.getPropertyName());
    assertSame(descriptionProperty, allProperties2.get(0));
    assertSame(allProperties, descriptionProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, descriptionProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setDescription(String)}
   */
  @Test
  void testSetDescription2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act
    dublinCoreSchema.setDescription("42");

    // Assert
    ArrayProperty descriptionProperty = dublinCoreSchema.getDescriptionProperty();
    List<AbstractField> allProperties = descriptionProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = descriptionProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", dublinCoreSchema.getDescription());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", descriptionProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", descriptionProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<String> descriptionLanguages = dublinCoreSchema.getDescriptionLanguages();
    assertEquals(1, descriptionLanguages.size());
    assertEquals("x-default", descriptionLanguages.get(0));
    assertEquals("x-default", getResult2.getValue());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, descriptionProperty.getArrayType());
    assertTrue(descriptionProperty.getAllAttributes().isEmpty());
    assertTrue(descriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.DESCRIPTION, descriptionProperty.getPropertyName());
    assertSame(descriptionProperty, allProperties2.get(1));
    assertSame(allProperties, descriptionProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, descriptionProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setDescription(String)}
   */
  @Test
  void testSetDescription3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addCreator("x-default");
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act
    dublinCoreSchema.setDescription("42");

    // Assert
    ArrayProperty descriptionProperty = dublinCoreSchema.getDescriptionProperty();
    List<AbstractField> allProperties = descriptionProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = descriptionProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", dublinCoreSchema.getDescription());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", descriptionProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", descriptionProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<String> descriptionLanguages = dublinCoreSchema.getDescriptionLanguages();
    assertEquals(1, descriptionLanguages.size());
    assertEquals("x-default", descriptionLanguages.get(0));
    assertEquals("x-default", getResult2.getValue());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(3, allProperties2.size());
    assertEquals(Cardinality.Alt, descriptionProperty.getArrayType());
    assertTrue(descriptionProperty.getAllAttributes().isEmpty());
    assertTrue(descriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.DESCRIPTION, descriptionProperty.getPropertyName());
    assertSame(descriptionProperty, allProperties2.get(2));
    assertSame(allProperties, descriptionProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, descriptionProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setDescription(String)}
   */
  @Test
  void testSetDescription4() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addDescription("x-default", DublinCoreSchema.DESCRIPTION);
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act
    dublinCoreSchema.setDescription("42");

    // Assert
    ArrayProperty descriptionProperty = dublinCoreSchema.getDescriptionProperty();
    List<AbstractField> allProperties = descriptionProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = descriptionProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", dublinCoreSchema.getDescription());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", descriptionProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", descriptionProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<String> descriptionLanguages = dublinCoreSchema.getDescriptionLanguages();
    assertEquals(1, descriptionLanguages.size());
    assertEquals("x-default", descriptionLanguages.get(0));
    assertEquals("x-default", getResult2.getValue());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, descriptionProperty.getArrayType());
    assertTrue(descriptionProperty.getAllAttributes().isEmpty());
    assertTrue(descriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.DESCRIPTION, descriptionProperty.getPropertyName());
    assertSame(descriptionProperty, allProperties2.get(0));
    assertSame(allProperties, descriptionProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, descriptionProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setDescription(String)}
   */
  @Test
  void testSetDescription5() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addDescription(DublinCoreSchema.DESCRIPTION, "42");

    // Act
    dublinCoreSchema.setDescription("42");

    // Assert
    ArrayProperty descriptionProperty = dublinCoreSchema.getDescriptionProperty();
    List<AbstractField> allProperties = descriptionProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = descriptionProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", dublinCoreSchema.getDescription());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", getResult2.getPrefix());
    assertEquals("dc", descriptionProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult2.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", descriptionProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    List<Attribute> allAttributes2 = getResult2.getAllAttributes();
    assertEquals(1, allAttributes2.size());
    Attribute getResult4 = allAttributes2.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult4.getNamespace());
    assertEquals("lang", getResult3.getName());
    assertEquals("lang", getResult4.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    List<String> descriptionLanguages = dublinCoreSchema.getDescriptionLanguages();
    assertEquals(2, descriptionLanguages.size());
    assertEquals("x-default", descriptionLanguages.get(0));
    assertEquals("x-default", getResult3.getValue());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Alt, descriptionProperty.getArrayType());
    assertTrue(descriptionProperty.getAllAttributes().isEmpty());
    assertTrue(descriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.DESCRIPTION, descriptionLanguages.get(1));
    assertEquals(DublinCoreSchema.DESCRIPTION, descriptionProperty.getPropertyName());
    assertEquals(DublinCoreSchema.DESCRIPTION, getResult4.getValue());
    assertSame(descriptionProperty, allProperties2.get(0));
    assertSame(allProperties, descriptionProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, descriptionProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setFormat(String)}
   */
  @Test
  void testSetFormat() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);

    // Act
    dublinCoreSchema.setFormat("Mime Type");

    // Assert
    assertEquals("Mime Type", dublinCoreSchema.getFormat());
    TextType formatProperty = dublinCoreSchema.getFormatProperty();
    assertEquals("Mime Type", formatProperty.getStringValue());
    assertEquals("Mime Type", formatProperty.getRawValue());
    assertEquals("Mime Type", formatProperty.getValue());
    assertEquals("dc", formatProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", formatProperty.getNamespace());
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(formatProperty.getAllAttributes().isEmpty());
    assertEquals(DublinCoreSchema.FORMAT, formatProperty.getPropertyName());
    assertSame(formatProperty, allProperties.get(0));
    assertSame(metadata, formatProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setFormat(String)}
   */
  @Test
  void testSetFormat2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addContributor(DublinCoreSchema.FORMAT);

    // Act
    dublinCoreSchema.setFormat("Mime Type");

    // Assert
    assertEquals("Mime Type", dublinCoreSchema.getFormat());
    TextType formatProperty = dublinCoreSchema.getFormatProperty();
    assertEquals("Mime Type", formatProperty.getStringValue());
    assertEquals("Mime Type", formatProperty.getRawValue());
    assertEquals("Mime Type", formatProperty.getValue());
    assertEquals("dc", formatProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", formatProperty.getNamespace());
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(formatProperty.getAllAttributes().isEmpty());
    assertEquals(DublinCoreSchema.FORMAT, formatProperty.getPropertyName());
    assertSame(formatProperty, allProperties.get(1));
    assertSame(metadata, formatProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setFormat(String)}
   */
  @Test
  void testSetFormat3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.FORMAT);

    // Act
    dublinCoreSchema.setFormat("Mime Type");

    // Assert
    assertEquals("Mime Type", dublinCoreSchema.getFormat());
    TextType formatProperty = dublinCoreSchema.getFormatProperty();
    assertEquals("Mime Type", formatProperty.getStringValue());
    assertEquals("Mime Type", formatProperty.getRawValue());
    assertEquals("Mime Type", formatProperty.getValue());
    assertEquals("dc", formatProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", formatProperty.getNamespace());
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(formatProperty.getAllAttributes().isEmpty());
    assertEquals(DublinCoreSchema.FORMAT, formatProperty.getPropertyName());
    assertSame(formatProperty, allProperties.get(2));
    assertSame(metadata, formatProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setFormat(String)}
   */
  @Test
  void testSetFormat4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addBagValueAsSimple(DublinCoreSchema.FORMAT, "42");

    // Act
    dublinCoreSchema.setFormat("Mime Type");

    // Assert
    assertEquals("Mime Type", dublinCoreSchema.getFormat());
    TextType formatProperty = dublinCoreSchema.getFormatProperty();
    assertEquals("Mime Type", formatProperty.getStringValue());
    assertEquals("Mime Type", formatProperty.getRawValue());
    assertEquals("Mime Type", formatProperty.getValue());
    assertEquals("dc", formatProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", formatProperty.getNamespace());
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(formatProperty.getAllAttributes().isEmpty());
    assertEquals(DublinCoreSchema.FORMAT, formatProperty.getPropertyName());
    assertSame(formatProperty, allProperties.get(0));
    assertSame(metadata, formatProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setIdentifier(String)}
   */
  @Test
  void testSetIdentifier() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);

    // Act
    dublinCoreSchema.setIdentifier("Text");

    // Assert
    assertEquals("Text", dublinCoreSchema.getIdentifier());
    TextType identifierProperty = dublinCoreSchema.getIdentifierProperty();
    assertEquals("Text", identifierProperty.getStringValue());
    assertEquals("Text", identifierProperty.getRawValue());
    assertEquals("Text", identifierProperty.getValue());
    assertEquals("dc", identifierProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", identifierProperty.getNamespace());
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(identifierProperty.getAllAttributes().isEmpty());
    assertEquals(DublinCoreSchema.IDENTIFIER, identifierProperty.getPropertyName());
    assertSame(identifierProperty, allProperties.get(0));
    assertSame(metadata, identifierProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setIdentifier(String)}
   */
  @Test
  void testSetIdentifier2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addContributor(DublinCoreSchema.IDENTIFIER);

    // Act
    dublinCoreSchema.setIdentifier("Text");

    // Assert
    assertEquals("Text", dublinCoreSchema.getIdentifier());
    TextType identifierProperty = dublinCoreSchema.getIdentifierProperty();
    assertEquals("Text", identifierProperty.getStringValue());
    assertEquals("Text", identifierProperty.getRawValue());
    assertEquals("Text", identifierProperty.getValue());
    assertEquals("dc", identifierProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", identifierProperty.getNamespace());
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(identifierProperty.getAllAttributes().isEmpty());
    assertEquals(DublinCoreSchema.IDENTIFIER, identifierProperty.getPropertyName());
    assertSame(identifierProperty, allProperties.get(1));
    assertSame(metadata, identifierProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setIdentifier(String)}
   */
  @Test
  void testSetIdentifier3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.IDENTIFIER);

    // Act
    dublinCoreSchema.setIdentifier("Text");

    // Assert
    assertEquals("Text", dublinCoreSchema.getIdentifier());
    TextType identifierProperty = dublinCoreSchema.getIdentifierProperty();
    assertEquals("Text", identifierProperty.getStringValue());
    assertEquals("Text", identifierProperty.getRawValue());
    assertEquals("Text", identifierProperty.getValue());
    assertEquals("dc", identifierProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", identifierProperty.getNamespace());
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(identifierProperty.getAllAttributes().isEmpty());
    assertEquals(DublinCoreSchema.IDENTIFIER, identifierProperty.getPropertyName());
    assertSame(identifierProperty, allProperties.get(2));
    assertSame(metadata, identifierProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setIdentifier(String)}
   */
  @Test
  void testSetIdentifier4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addBagValueAsSimple(DublinCoreSchema.IDENTIFIER, "42");

    // Act
    dublinCoreSchema.setIdentifier("Text");

    // Assert
    assertEquals("Text", dublinCoreSchema.getIdentifier());
    TextType identifierProperty = dublinCoreSchema.getIdentifierProperty();
    assertEquals("Text", identifierProperty.getStringValue());
    assertEquals("Text", identifierProperty.getRawValue());
    assertEquals("Text", identifierProperty.getValue());
    assertEquals("dc", identifierProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", identifierProperty.getNamespace());
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(identifierProperty.getAllAttributes().isEmpty());
    assertEquals(DublinCoreSchema.IDENTIFIER, identifierProperty.getPropertyName());
    assertSame(identifierProperty, allProperties.get(0));
    assertSame(metadata, identifierProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setIdentifierProperty(TextType)}
   */
  @Test
  void testSetIdentifierProperty() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    dublinCoreSchema.setIdentifierProperty(text);

    // Assert
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Method under test: {@link DublinCoreSchema#setIdentifierProperty(TextType)}
   */
  @Test
  void testSetIdentifierProperty2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor("Proper Name");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    dublinCoreSchema.setIdentifierProperty(text);

    // Assert
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link DublinCoreSchema#setIdentifierProperty(TextType)}
   */
  @Test
  void testSetIdentifierProperty3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator("Property Name");
    dublinCoreSchema.addContributor("Proper Name");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    dublinCoreSchema.setIdentifierProperty(text);

    // Assert
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test: {@link DublinCoreSchema#setIdentifierProperty(TextType)}
   */
  @Test
  void testSetIdentifierProperty4() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addBagValueAsSimple("Property Name", DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor("Proper Name");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    dublinCoreSchema.setIdentifierProperty(text);

    // Assert
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link DublinCoreSchema#addLanguage(String)}
   */
  @Test
  void testAddLanguage() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);

    // Act
    dublinCoreSchema.addLanguage("en");

    // Assert
    ArrayProperty languagesProperty = dublinCoreSchema.getLanguagesProperty();
    List<AbstractField> allProperties = languagesProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", languagesProperty.getPrefix());
    List<String> languages = dublinCoreSchema.getLanguages();
    assertEquals(1, languages.size());
    assertEquals("en", languages.get(0));
    List<String> elementsAsString = languagesProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("en", elementsAsString.get(0));
    assertEquals("en", ((TextType) getResult).getStringValue());
    assertEquals("en", ((TextType) getResult).getRawValue());
    assertEquals("en", ((TextType) getResult).getValue());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", languagesProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Bag, languagesProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(languagesProperty.getAllAttributes().isEmpty());
    assertTrue(languagesProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.LANGUAGE, languagesProperty.getPropertyName());
    assertSame(languagesProperty, allProperties2.get(0));
    assertSame(allProperties, languagesProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, languagesProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addLanguage(String)}
   */
  @Test
  void testAddLanguage2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addContributor(DublinCoreSchema.LANGUAGE);

    // Act
    dublinCoreSchema.addLanguage("en");

    // Assert
    ArrayProperty languagesProperty = dublinCoreSchema.getLanguagesProperty();
    List<AbstractField> allProperties = languagesProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", languagesProperty.getPrefix());
    List<String> languages = dublinCoreSchema.getLanguages();
    assertEquals(1, languages.size());
    assertEquals("en", languages.get(0));
    List<String> elementsAsString = languagesProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("en", elementsAsString.get(0));
    assertEquals("en", ((TextType) getResult).getStringValue());
    assertEquals("en", ((TextType) getResult).getRawValue());
    assertEquals("en", ((TextType) getResult).getValue());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", languagesProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Bag, languagesProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(languagesProperty.getAllAttributes().isEmpty());
    assertTrue(languagesProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.LANGUAGE, languagesProperty.getPropertyName());
    assertSame(languagesProperty, allProperties2.get(1));
    assertSame(allProperties, languagesProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, languagesProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addLanguage(String)}
   */
  @Test
  void testAddLanguage3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.LANGUAGE);

    // Act
    dublinCoreSchema.addLanguage("en");

    // Assert
    ArrayProperty languagesProperty = dublinCoreSchema.getLanguagesProperty();
    List<AbstractField> allProperties = languagesProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", languagesProperty.getPrefix());
    List<String> languages = dublinCoreSchema.getLanguages();
    assertEquals(1, languages.size());
    assertEquals("en", languages.get(0));
    List<String> elementsAsString = languagesProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("en", elementsAsString.get(0));
    assertEquals("en", ((TextType) getResult).getStringValue());
    assertEquals("en", ((TextType) getResult).getRawValue());
    assertEquals("en", ((TextType) getResult).getValue());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", languagesProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(3, allProperties2.size());
    assertEquals(Cardinality.Bag, languagesProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(languagesProperty.getAllAttributes().isEmpty());
    assertTrue(languagesProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.LANGUAGE, languagesProperty.getPropertyName());
    assertSame(languagesProperty, allProperties2.get(2));
    assertSame(allProperties, languagesProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, languagesProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addLanguage(String)}
   */
  @Test
  void testAddLanguage4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addLanguage(DublinCoreSchema.LANGUAGE);
    dublinCoreSchema.addContributor(DublinCoreSchema.LANGUAGE);

    // Act
    dublinCoreSchema.addLanguage("en");

    // Assert
    ArrayProperty languagesProperty = dublinCoreSchema.getLanguagesProperty();
    List<AbstractField> allProperties = languagesProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", getResult2.getPrefix());
    assertEquals("dc", languagesProperty.getPrefix());
    List<String> languages = dublinCoreSchema.getLanguages();
    assertEquals(2, languages.size());
    assertEquals("en", languages.get(1));
    assertEquals("en", ((TextType) getResult2).getStringValue());
    assertEquals("en", ((TextType) getResult2).getRawValue());
    assertEquals("en", ((TextType) getResult2).getValue());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult2.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", languagesProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Bag, languagesProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(languagesProperty.getAllAttributes().isEmpty());
    assertTrue(languagesProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(languages, languagesProperty.getElementsAsString());
    assertEquals(DublinCoreSchema.LANGUAGE, languages.get(0));
    assertEquals(DublinCoreSchema.LANGUAGE, languagesProperty.getPropertyName());
    assertEquals(DublinCoreSchema.LANGUAGE, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.LANGUAGE, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.LANGUAGE, ((TextType) getResult).getValue());
    assertSame(languagesProperty, allProperties2.get(0));
    assertSame(allProperties, languagesProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, languagesProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#removeLanguage(String)}
   */
  @Test
  void testRemoveLanguage() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());

    // Act
    dublinCoreSchema.removeLanguage("en");

    // Assert that nothing has changed
    assertNull(dublinCoreSchema.getLanguages());
    assertNull(dublinCoreSchema.getLanguagesProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#removeLanguage(String)}
   */
  @Test
  void testRemoveLanguage2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.LANGUAGE);

    // Act
    dublinCoreSchema.removeLanguage("en");

    // Assert that nothing has changed
    assertNull(dublinCoreSchema.getLanguages());
    assertNull(dublinCoreSchema.getLanguagesProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#removeLanguage(String)}
   */
  @Test
  void testRemoveLanguage3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addLanguage(DublinCoreSchema.LANGUAGE);
    dublinCoreSchema.addContributor(DublinCoreSchema.LANGUAGE);

    // Act
    dublinCoreSchema.removeLanguage("en");

    // Assert that nothing has changed
    assertEquals(1, dublinCoreSchema.getLanguages().size());
    ArrayProperty languagesProperty = dublinCoreSchema.getLanguagesProperty();
    assertEquals(1, languagesProperty.getAllProperties().size());
    assertEquals(1, languagesProperty.getElementsAsString().size());
  }

  /**
   * Method under test: {@link DublinCoreSchema#removeLanguage(String)}
   */
  @Test
  void testRemoveLanguage4() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addLanguage("en");

    // Act
    dublinCoreSchema.removeLanguage("en");

    // Assert
    assertTrue(dublinCoreSchema.getLanguages().isEmpty());
    ArrayProperty languagesProperty = dublinCoreSchema.getLanguagesProperty();
    assertTrue(languagesProperty.getAllProperties().isEmpty());
    assertTrue(languagesProperty.getElementsAsString().isEmpty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addPublisher(String)}
   */
  @Test
  void testAddPublisher() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);

    // Act
    dublinCoreSchema.addPublisher("Proper Name");

    // Assert
    ArrayProperty publishersProperty = dublinCoreSchema.getPublishersProperty();
    List<AbstractField> allProperties = publishersProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> publishers = dublinCoreSchema.getPublishers();
    assertEquals(1, publishers.size());
    assertEquals("Proper Name", publishers.get(0));
    List<String> elementsAsString = publishersProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Proper Name", elementsAsString.get(0));
    assertEquals("Proper Name", ((TextType) getResult).getStringValue());
    assertEquals("Proper Name", ((TextType) getResult).getRawValue());
    assertEquals("Proper Name", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", publishersProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", publishersProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Bag, publishersProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(publishersProperty.getAllAttributes().isEmpty());
    assertTrue(publishersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.PUBLISHER, publishersProperty.getPropertyName());
    assertSame(publishersProperty, allProperties2.get(0));
    assertSame(allProperties, publishersProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, publishersProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addPublisher(String)}
   */
  @Test
  void testAddPublisher2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addContributor(DublinCoreSchema.PUBLISHER);

    // Act
    dublinCoreSchema.addPublisher("Proper Name");

    // Assert
    ArrayProperty publishersProperty = dublinCoreSchema.getPublishersProperty();
    List<AbstractField> allProperties = publishersProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> publishers = dublinCoreSchema.getPublishers();
    assertEquals(1, publishers.size());
    assertEquals("Proper Name", publishers.get(0));
    List<String> elementsAsString = publishersProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Proper Name", elementsAsString.get(0));
    assertEquals("Proper Name", ((TextType) getResult).getStringValue());
    assertEquals("Proper Name", ((TextType) getResult).getRawValue());
    assertEquals("Proper Name", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", publishersProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", publishersProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Bag, publishersProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(publishersProperty.getAllAttributes().isEmpty());
    assertTrue(publishersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.PUBLISHER, publishersProperty.getPropertyName());
    assertSame(publishersProperty, allProperties2.get(1));
    assertSame(allProperties, publishersProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, publishersProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addPublisher(String)}
   */
  @Test
  void testAddPublisher3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.PUBLISHER);

    // Act
    dublinCoreSchema.addPublisher("Proper Name");

    // Assert
    ArrayProperty publishersProperty = dublinCoreSchema.getPublishersProperty();
    List<AbstractField> allProperties = publishersProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> publishers = dublinCoreSchema.getPublishers();
    assertEquals(1, publishers.size());
    assertEquals("Proper Name", publishers.get(0));
    List<String> elementsAsString = publishersProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Proper Name", elementsAsString.get(0));
    assertEquals("Proper Name", ((TextType) getResult).getStringValue());
    assertEquals("Proper Name", ((TextType) getResult).getRawValue());
    assertEquals("Proper Name", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", publishersProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", publishersProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(3, allProperties2.size());
    assertEquals(Cardinality.Bag, publishersProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(publishersProperty.getAllAttributes().isEmpty());
    assertTrue(publishersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.PUBLISHER, publishersProperty.getPropertyName());
    assertSame(publishersProperty, allProperties2.get(2));
    assertSame(allProperties, publishersProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, publishersProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addPublisher(String)}
   */
  @Test
  void testAddPublisher4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addPublisher(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.PUBLISHER);

    // Act
    dublinCoreSchema.addPublisher("Proper Name");

    // Assert
    ArrayProperty publishersProperty = dublinCoreSchema.getPublishersProperty();
    List<AbstractField> allProperties = publishersProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> publishers = dublinCoreSchema.getPublishers();
    assertEquals(2, publishers.size());
    assertEquals("Proper Name", publishers.get(1));
    assertEquals("Proper Name", ((TextType) getResult2).getStringValue());
    assertEquals("Proper Name", ((TextType) getResult2).getRawValue());
    assertEquals("Proper Name", ((TextType) getResult2).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", getResult2.getPrefix());
    assertEquals("dc", publishersProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult2.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", publishersProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Bag, publishersProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(publishersProperty.getAllAttributes().isEmpty());
    assertTrue(publishersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(publishers, publishersProperty.getElementsAsString());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, publishers.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getValue());
    assertEquals(DublinCoreSchema.PUBLISHER, publishersProperty.getPropertyName());
    assertSame(publishersProperty, allProperties2.get(0));
    assertSame(allProperties, publishersProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, publishersProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addRelation(String)}
   */
  @Test
  void testAddRelation() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);

    // Act
    dublinCoreSchema.addRelation("Text");

    // Assert
    ArrayProperty relationsProperty = dublinCoreSchema.getRelationsProperty();
    List<AbstractField> allProperties = relationsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> relations = dublinCoreSchema.getRelations();
    assertEquals(1, relations.size());
    assertEquals("Text", relations.get(0));
    List<String> elementsAsString = relationsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Text", elementsAsString.get(0));
    assertEquals("Text", ((TextType) getResult).getStringValue());
    assertEquals("Text", ((TextType) getResult).getRawValue());
    assertEquals("Text", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", relationsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", relationsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Bag, relationsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(relationsProperty.getAllAttributes().isEmpty());
    assertTrue(relationsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.RELATION, relationsProperty.getPropertyName());
    assertSame(relationsProperty, allProperties2.get(0));
    assertSame(allProperties, relationsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, relationsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addRelation(String)}
   */
  @Test
  void testAddRelation2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addContributor(DublinCoreSchema.RELATION);

    // Act
    dublinCoreSchema.addRelation("Text");

    // Assert
    ArrayProperty relationsProperty = dublinCoreSchema.getRelationsProperty();
    List<AbstractField> allProperties = relationsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> relations = dublinCoreSchema.getRelations();
    assertEquals(1, relations.size());
    assertEquals("Text", relations.get(0));
    List<String> elementsAsString = relationsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Text", elementsAsString.get(0));
    assertEquals("Text", ((TextType) getResult).getStringValue());
    assertEquals("Text", ((TextType) getResult).getRawValue());
    assertEquals("Text", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", relationsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", relationsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Bag, relationsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(relationsProperty.getAllAttributes().isEmpty());
    assertTrue(relationsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.RELATION, relationsProperty.getPropertyName());
    assertSame(relationsProperty, allProperties2.get(1));
    assertSame(allProperties, relationsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, relationsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addRelation(String)}
   */
  @Test
  void testAddRelation3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.RELATION);

    // Act
    dublinCoreSchema.addRelation("Text");

    // Assert
    ArrayProperty relationsProperty = dublinCoreSchema.getRelationsProperty();
    List<AbstractField> allProperties = relationsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> relations = dublinCoreSchema.getRelations();
    assertEquals(1, relations.size());
    assertEquals("Text", relations.get(0));
    List<String> elementsAsString = relationsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Text", elementsAsString.get(0));
    assertEquals("Text", ((TextType) getResult).getStringValue());
    assertEquals("Text", ((TextType) getResult).getRawValue());
    assertEquals("Text", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", relationsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", relationsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(3, allProperties2.size());
    assertEquals(Cardinality.Bag, relationsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(relationsProperty.getAllAttributes().isEmpty());
    assertTrue(relationsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.RELATION, relationsProperty.getPropertyName());
    assertSame(relationsProperty, allProperties2.get(2));
    assertSame(allProperties, relationsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, relationsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addRelation(String)}
   */
  @Test
  void testAddRelation4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addRelation(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.RELATION);

    // Act
    dublinCoreSchema.addRelation("Text");

    // Assert
    ArrayProperty relationsProperty = dublinCoreSchema.getRelationsProperty();
    List<AbstractField> allProperties = relationsProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> relations = dublinCoreSchema.getRelations();
    assertEquals(2, relations.size());
    assertEquals("Text", relations.get(1));
    assertEquals("Text", ((TextType) getResult2).getStringValue());
    assertEquals("Text", ((TextType) getResult2).getRawValue());
    assertEquals("Text", ((TextType) getResult2).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", getResult2.getPrefix());
    assertEquals("dc", relationsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult2.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", relationsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Bag, relationsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(relationsProperty.getAllAttributes().isEmpty());
    assertTrue(relationsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(relations, relationsProperty.getElementsAsString());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, relations.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getValue());
    assertEquals(DublinCoreSchema.RELATION, relationsProperty.getPropertyName());
    assertSame(relationsProperty, allProperties2.get(0));
    assertSame(allProperties, relationsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, relationsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addRights(String, String)}
   */
  @Test
  void testAddRights() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);

    // Act
    dublinCoreSchema.addRights("Lang", "42");

    // Assert
    ArrayProperty rightsProperty = dublinCoreSchema.getRightsProperty();
    List<AbstractField> allProperties = rightsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = rightsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> rightsLanguages = dublinCoreSchema.getRightsLanguages();
    assertEquals(1, rightsLanguages.size());
    assertEquals("Lang", rightsLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", rightsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", rightsProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Alt, rightsProperty.getArrayType());
    assertTrue(rightsProperty.getAllAttributes().isEmpty());
    assertTrue(rightsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.RIGHTS, rightsProperty.getPropertyName());
    assertSame(rightsProperty, allProperties2.get(0));
    assertSame(allProperties, rightsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, rightsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addRights(String, String)}
   */
  @Test
  void testAddRights2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addContributor(DublinCoreSchema.RIGHTS);

    // Act
    dublinCoreSchema.addRights("Lang", "42");

    // Assert
    ArrayProperty rightsProperty = dublinCoreSchema.getRightsProperty();
    List<AbstractField> allProperties = rightsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = rightsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> rightsLanguages = dublinCoreSchema.getRightsLanguages();
    assertEquals(1, rightsLanguages.size());
    assertEquals("Lang", rightsLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", rightsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", rightsProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, rightsProperty.getArrayType());
    assertTrue(rightsProperty.getAllAttributes().isEmpty());
    assertTrue(rightsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.RIGHTS, rightsProperty.getPropertyName());
    assertSame(rightsProperty, allProperties2.get(1));
    assertSame(allProperties, rightsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, rightsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addRights(String, String)}
   */
  @Test
  void testAddRights3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.RIGHTS);

    // Act
    dublinCoreSchema.addRights("Lang", "42");

    // Assert
    ArrayProperty rightsProperty = dublinCoreSchema.getRightsProperty();
    List<AbstractField> allProperties = rightsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = rightsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> rightsLanguages = dublinCoreSchema.getRightsLanguages();
    assertEquals(1, rightsLanguages.size());
    assertEquals("Lang", rightsLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", rightsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", rightsProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(3, allProperties2.size());
    assertEquals(Cardinality.Alt, rightsProperty.getArrayType());
    assertTrue(rightsProperty.getAllAttributes().isEmpty());
    assertTrue(rightsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.RIGHTS, rightsProperty.getPropertyName());
    assertSame(rightsProperty, allProperties2.get(2));
    assertSame(allProperties, rightsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, rightsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addRights(String, String)}
   */
  @Test
  void testAddRights4() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addRights(DublinCoreSchema.CONTRIBUTOR, DublinCoreSchema.RIGHTS);
    dublinCoreSchema.addContributor(DublinCoreSchema.RIGHTS);

    // Act
    dublinCoreSchema.addRights("Lang", "42");

    // Assert
    ArrayProperty rightsProperty = dublinCoreSchema.getRightsProperty();
    List<AbstractField> allProperties = rightsProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = rightsProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    List<String> rightsLanguages = dublinCoreSchema.getRightsLanguages();
    assertEquals(2, rightsLanguages.size());
    assertEquals("Lang", rightsLanguages.get(1));
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("Lang", getResult3.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", getResult2.getPrefix());
    assertEquals("dc", rightsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult2.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", rightsProperty.getNamespace());
    List<Attribute> allAttributes2 = getResult.getAllAttributes();
    assertEquals(1, allAttributes2.size());
    Attribute getResult4 = allAttributes2.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult4.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    assertEquals("lang", getResult4.getName());
    assertEquals("lang", getResult3.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, rightsProperty.getArrayType());
    assertTrue(rightsProperty.getAllAttributes().isEmpty());
    assertTrue(rightsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, rightsLanguages.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, getResult4.getValue());
    assertEquals(DublinCoreSchema.RIGHTS, elementsAsString.get(0));
    assertEquals(DublinCoreSchema.RIGHTS, rightsProperty.getPropertyName());
    assertEquals(DublinCoreSchema.RIGHTS, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.RIGHTS, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.RIGHTS, ((TextType) getResult).getValue());
    assertSame(rightsProperty, allProperties2.get(0));
    assertSame(allProperties, rightsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, rightsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addRights(String, String)}
   */
  @Test
  void testAddRights5() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addRights("Lang", DublinCoreSchema.RIGHTS);
    dublinCoreSchema.addContributor(DublinCoreSchema.RIGHTS);

    // Act
    dublinCoreSchema.addRights("Lang", "42");

    // Assert
    ArrayProperty rightsProperty = dublinCoreSchema.getRightsProperty();
    List<AbstractField> allProperties = rightsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = rightsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> rightsLanguages = dublinCoreSchema.getRightsLanguages();
    assertEquals(1, rightsLanguages.size());
    assertEquals("Lang", rightsLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", rightsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", rightsProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, rightsProperty.getArrayType());
    assertTrue(rightsProperty.getAllAttributes().isEmpty());
    assertTrue(rightsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.RIGHTS, rightsProperty.getPropertyName());
    assertSame(rightsProperty, allProperties2.get(0));
    assertSame(allProperties, rightsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, rightsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addRights(String, String)}
   */
  @Test
  void testAddRights6() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addRights("x-default", DublinCoreSchema.RIGHTS);
    dublinCoreSchema.addContributor(DublinCoreSchema.RIGHTS);

    // Act
    dublinCoreSchema.addRights("Lang", "42");

    // Assert
    ArrayProperty rightsProperty = dublinCoreSchema.getRightsProperty();
    List<AbstractField> allProperties = rightsProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = rightsProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    List<String> rightsLanguages = dublinCoreSchema.getRightsLanguages();
    assertEquals(2, rightsLanguages.size());
    assertEquals("Lang", rightsLanguages.get(1));
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("Lang", getResult3.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", getResult2.getPrefix());
    assertEquals("dc", rightsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult2.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", rightsProperty.getNamespace());
    List<Attribute> allAttributes2 = getResult.getAllAttributes();
    assertEquals(1, allAttributes2.size());
    Attribute getResult4 = allAttributes2.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult4.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    assertEquals("lang", getResult4.getName());
    assertEquals("lang", getResult3.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("x-default", rightsLanguages.get(0));
    assertEquals("x-default", getResult4.getValue());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, rightsProperty.getArrayType());
    assertTrue(rightsProperty.getAllAttributes().isEmpty());
    assertTrue(rightsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.RIGHTS, elementsAsString.get(0));
    assertEquals(DublinCoreSchema.RIGHTS, rightsProperty.getPropertyName());
    assertEquals(DublinCoreSchema.RIGHTS, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.RIGHTS, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.RIGHTS, ((TextType) getResult).getValue());
    assertSame(rightsProperty, allProperties2.get(0));
    assertSame(allProperties, rightsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, rightsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setSource(String)}
   */
  @Test
  void testSetSource() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);

    // Act
    dublinCoreSchema.setSource("Text");

    // Assert
    assertEquals("Text", dublinCoreSchema.getSource());
    TextType sourceProperty = dublinCoreSchema.getSourceProperty();
    assertEquals("Text", sourceProperty.getStringValue());
    assertEquals("Text", sourceProperty.getRawValue());
    assertEquals("Text", sourceProperty.getValue());
    assertEquals("dc", sourceProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", sourceProperty.getNamespace());
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(sourceProperty.getAllAttributes().isEmpty());
    assertEquals(DublinCoreSchema.SOURCE, sourceProperty.getPropertyName());
    assertSame(sourceProperty, allProperties.get(0));
    assertSame(metadata, sourceProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setSource(String)}
   */
  @Test
  void testSetSource2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addContributor(DublinCoreSchema.SOURCE);

    // Act
    dublinCoreSchema.setSource("Text");

    // Assert
    assertEquals("Text", dublinCoreSchema.getSource());
    TextType sourceProperty = dublinCoreSchema.getSourceProperty();
    assertEquals("Text", sourceProperty.getStringValue());
    assertEquals("Text", sourceProperty.getRawValue());
    assertEquals("Text", sourceProperty.getValue());
    assertEquals("dc", sourceProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", sourceProperty.getNamespace());
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(sourceProperty.getAllAttributes().isEmpty());
    assertEquals(DublinCoreSchema.SOURCE, sourceProperty.getPropertyName());
    assertSame(sourceProperty, allProperties.get(1));
    assertSame(metadata, sourceProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setSource(String)}
   */
  @Test
  void testSetSource3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.SOURCE);

    // Act
    dublinCoreSchema.setSource("Text");

    // Assert
    assertEquals("Text", dublinCoreSchema.getSource());
    TextType sourceProperty = dublinCoreSchema.getSourceProperty();
    assertEquals("Text", sourceProperty.getStringValue());
    assertEquals("Text", sourceProperty.getRawValue());
    assertEquals("Text", sourceProperty.getValue());
    assertEquals("dc", sourceProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", sourceProperty.getNamespace());
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(sourceProperty.getAllAttributes().isEmpty());
    assertEquals(DublinCoreSchema.SOURCE, sourceProperty.getPropertyName());
    assertSame(sourceProperty, allProperties.get(2));
    assertSame(metadata, sourceProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setSource(String)}
   */
  @Test
  void testSetSource4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addBagValueAsSimple(DublinCoreSchema.SOURCE, "42");

    // Act
    dublinCoreSchema.setSource("Text");

    // Assert
    assertEquals("Text", dublinCoreSchema.getSource());
    TextType sourceProperty = dublinCoreSchema.getSourceProperty();
    assertEquals("Text", sourceProperty.getStringValue());
    assertEquals("Text", sourceProperty.getRawValue());
    assertEquals("Text", sourceProperty.getValue());
    assertEquals("dc", sourceProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", sourceProperty.getNamespace());
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(sourceProperty.getAllAttributes().isEmpty());
    assertEquals(DublinCoreSchema.SOURCE, sourceProperty.getPropertyName());
    assertSame(sourceProperty, allProperties.get(0));
    assertSame(metadata, sourceProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setSourceProperty(TextType)}
   */
  @Test
  void testSetSourceProperty() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    dublinCoreSchema.setSourceProperty(text);

    // Assert
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Method under test: {@link DublinCoreSchema#setSourceProperty(TextType)}
   */
  @Test
  void testSetSourceProperty2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor("Proper Name");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    dublinCoreSchema.setSourceProperty(text);

    // Assert
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link DublinCoreSchema#setSourceProperty(TextType)}
   */
  @Test
  void testSetSourceProperty3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator("Property Name");
    dublinCoreSchema.addContributor("Proper Name");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    dublinCoreSchema.setSourceProperty(text);

    // Assert
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test: {@link DublinCoreSchema#setSourceProperty(TextType)}
   */
  @Test
  void testSetSourceProperty4() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addBagValueAsSimple("Property Name", DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor("Proper Name");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    dublinCoreSchema.setSourceProperty(text);

    // Assert
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link DublinCoreSchema#setFormatProperty(MIMEType)}
   */
  @Test
  void testSetFormatProperty() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    MIMEType text = new MIMEType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    dublinCoreSchema.setFormatProperty(text);

    // Assert
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Method under test: {@link DublinCoreSchema#setFormatProperty(MIMEType)}
   */
  @Test
  void testSetFormatProperty2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor("Proper Name");
    MIMEType text = new MIMEType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    dublinCoreSchema.setFormatProperty(text);

    // Assert
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link DublinCoreSchema#setFormatProperty(MIMEType)}
   */
  @Test
  void testSetFormatProperty3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator("Property Name");
    dublinCoreSchema.addContributor("Proper Name");
    MIMEType text = new MIMEType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    dublinCoreSchema.setFormatProperty(text);

    // Assert
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test: {@link DublinCoreSchema#setFormatProperty(MIMEType)}
   */
  @Test
  void testSetFormatProperty4() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addBagValueAsSimple("Property Name", DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor("Proper Name");
    MIMEType text = new MIMEType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    dublinCoreSchema.setFormatProperty(text);

    // Assert
    List<AbstractField> allProperties = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link DublinCoreSchema#addSubject(String)}
   */
  @Test
  void testAddSubject() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);

    // Act
    dublinCoreSchema.addSubject("Text");

    // Assert
    ArrayProperty subjectsProperty = dublinCoreSchema.getSubjectsProperty();
    List<AbstractField> allProperties = subjectsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> subjects = dublinCoreSchema.getSubjects();
    assertEquals(1, subjects.size());
    assertEquals("Text", subjects.get(0));
    List<String> elementsAsString = subjectsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Text", elementsAsString.get(0));
    assertEquals("Text", ((TextType) getResult).getStringValue());
    assertEquals("Text", ((TextType) getResult).getRawValue());
    assertEquals("Text", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", subjectsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", subjectsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Bag, subjectsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(subjectsProperty.getAllAttributes().isEmpty());
    assertTrue(subjectsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.SUBJECT, subjectsProperty.getPropertyName());
    assertSame(subjectsProperty, allProperties2.get(0));
    assertSame(allProperties, subjectsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, subjectsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addSubject(String)}
   */
  @Test
  void testAddSubject2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addContributor(DublinCoreSchema.SUBJECT);

    // Act
    dublinCoreSchema.addSubject("Text");

    // Assert
    ArrayProperty subjectsProperty = dublinCoreSchema.getSubjectsProperty();
    List<AbstractField> allProperties = subjectsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> subjects = dublinCoreSchema.getSubjects();
    assertEquals(1, subjects.size());
    assertEquals("Text", subjects.get(0));
    List<String> elementsAsString = subjectsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Text", elementsAsString.get(0));
    assertEquals("Text", ((TextType) getResult).getStringValue());
    assertEquals("Text", ((TextType) getResult).getRawValue());
    assertEquals("Text", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", subjectsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", subjectsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Bag, subjectsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(subjectsProperty.getAllAttributes().isEmpty());
    assertTrue(subjectsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.SUBJECT, subjectsProperty.getPropertyName());
    assertSame(subjectsProperty, allProperties2.get(1));
    assertSame(allProperties, subjectsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, subjectsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addSubject(String)}
   */
  @Test
  void testAddSubject3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.SUBJECT);

    // Act
    dublinCoreSchema.addSubject("Text");

    // Assert
    ArrayProperty subjectsProperty = dublinCoreSchema.getSubjectsProperty();
    List<AbstractField> allProperties = subjectsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> subjects = dublinCoreSchema.getSubjects();
    assertEquals(1, subjects.size());
    assertEquals("Text", subjects.get(0));
    List<String> elementsAsString = subjectsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Text", elementsAsString.get(0));
    assertEquals("Text", ((TextType) getResult).getStringValue());
    assertEquals("Text", ((TextType) getResult).getRawValue());
    assertEquals("Text", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", subjectsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", subjectsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(3, allProperties2.size());
    assertEquals(Cardinality.Bag, subjectsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(subjectsProperty.getAllAttributes().isEmpty());
    assertTrue(subjectsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.SUBJECT, subjectsProperty.getPropertyName());
    assertSame(subjectsProperty, allProperties2.get(2));
    assertSame(allProperties, subjectsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, subjectsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addSubject(String)}
   */
  @Test
  void testAddSubject4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addSubject(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.SUBJECT);

    // Act
    dublinCoreSchema.addSubject("Text");

    // Assert
    ArrayProperty subjectsProperty = dublinCoreSchema.getSubjectsProperty();
    List<AbstractField> allProperties = subjectsProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> subjects = dublinCoreSchema.getSubjects();
    assertEquals(2, subjects.size());
    assertEquals("Text", subjects.get(1));
    assertEquals("Text", ((TextType) getResult2).getStringValue());
    assertEquals("Text", ((TextType) getResult2).getRawValue());
    assertEquals("Text", ((TextType) getResult2).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", getResult2.getPrefix());
    assertEquals("dc", subjectsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult2.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", subjectsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Bag, subjectsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(subjectsProperty.getAllAttributes().isEmpty());
    assertTrue(subjectsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(subjects, subjectsProperty.getElementsAsString());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, subjects.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getValue());
    assertEquals(DublinCoreSchema.SUBJECT, subjectsProperty.getPropertyName());
    assertSame(subjectsProperty, allProperties2.get(0));
    assertSame(allProperties, subjectsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, subjectsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setTitle(String)}
   */
  @Test
  void testSetTitle() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);

    // Act
    dublinCoreSchema.setTitle("42");

    // Assert
    ArrayProperty titleProperty = dublinCoreSchema.getTitleProperty();
    List<AbstractField> allProperties = titleProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = titleProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", dublinCoreSchema.getTitle());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", titleProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", titleProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<String> titleLanguages = dublinCoreSchema.getTitleLanguages();
    assertEquals(1, titleLanguages.size());
    assertEquals("x-default", titleLanguages.get(0));
    assertEquals("x-default", getResult2.getValue());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Alt, titleProperty.getArrayType());
    assertTrue(titleProperty.getAllAttributes().isEmpty());
    assertTrue(titleProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.TITLE, titleProperty.getPropertyName());
    assertSame(titleProperty, allProperties2.get(0));
    assertSame(allProperties, titleProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, titleProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setTitle(String)}
   */
  @Test
  void testSetTitle2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act
    dublinCoreSchema.setTitle("42");

    // Assert
    ArrayProperty titleProperty = dublinCoreSchema.getTitleProperty();
    List<AbstractField> allProperties = titleProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = titleProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", dublinCoreSchema.getTitle());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", titleProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", titleProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<String> titleLanguages = dublinCoreSchema.getTitleLanguages();
    assertEquals(1, titleLanguages.size());
    assertEquals("x-default", titleLanguages.get(0));
    assertEquals("x-default", getResult2.getValue());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, titleProperty.getArrayType());
    assertTrue(titleProperty.getAllAttributes().isEmpty());
    assertTrue(titleProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.TITLE, titleProperty.getPropertyName());
    assertSame(titleProperty, allProperties2.get(1));
    assertSame(allProperties, titleProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, titleProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setTitle(String)}
   */
  @Test
  void testSetTitle3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addCreator("x-default");
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act
    dublinCoreSchema.setTitle("42");

    // Assert
    ArrayProperty titleProperty = dublinCoreSchema.getTitleProperty();
    List<AbstractField> allProperties = titleProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = titleProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", dublinCoreSchema.getTitle());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", titleProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", titleProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<String> titleLanguages = dublinCoreSchema.getTitleLanguages();
    assertEquals(1, titleLanguages.size());
    assertEquals("x-default", titleLanguages.get(0));
    assertEquals("x-default", getResult2.getValue());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(3, allProperties2.size());
    assertEquals(Cardinality.Alt, titleProperty.getArrayType());
    assertTrue(titleProperty.getAllAttributes().isEmpty());
    assertTrue(titleProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.TITLE, titleProperty.getPropertyName());
    assertSame(titleProperty, allProperties2.get(2));
    assertSame(allProperties, titleProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, titleProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setTitle(String)}
   */
  @Test
  void testSetTitle4() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addTitle("x-default", DublinCoreSchema.TITLE);
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act
    dublinCoreSchema.setTitle("42");

    // Assert
    ArrayProperty titleProperty = dublinCoreSchema.getTitleProperty();
    List<AbstractField> allProperties = titleProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = titleProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", dublinCoreSchema.getTitle());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", titleProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", titleProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<String> titleLanguages = dublinCoreSchema.getTitleLanguages();
    assertEquals(1, titleLanguages.size());
    assertEquals("x-default", titleLanguages.get(0));
    assertEquals("x-default", getResult2.getValue());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, titleProperty.getArrayType());
    assertTrue(titleProperty.getAllAttributes().isEmpty());
    assertTrue(titleProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.TITLE, titleProperty.getPropertyName());
    assertSame(titleProperty, allProperties2.get(0));
    assertSame(allProperties, titleProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, titleProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setTitle(String)}
   */
  @Test
  void testSetTitle5() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addTitle(DublinCoreSchema.TITLE, "42");

    // Act
    dublinCoreSchema.setTitle("42");

    // Assert
    ArrayProperty titleProperty = dublinCoreSchema.getTitleProperty();
    List<AbstractField> allProperties = titleProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = titleProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", dublinCoreSchema.getTitle());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", getResult2.getPrefix());
    assertEquals("dc", titleProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult2.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", titleProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    List<Attribute> allAttributes2 = getResult2.getAllAttributes();
    assertEquals(1, allAttributes2.size());
    Attribute getResult4 = allAttributes2.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult4.getNamespace());
    assertEquals("lang", getResult3.getName());
    assertEquals("lang", getResult4.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    List<String> titleLanguages = dublinCoreSchema.getTitleLanguages();
    assertEquals(2, titleLanguages.size());
    assertEquals("x-default", titleLanguages.get(0));
    assertEquals("x-default", getResult3.getValue());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Alt, titleProperty.getArrayType());
    assertTrue(titleProperty.getAllAttributes().isEmpty());
    assertTrue(titleProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.TITLE, titleLanguages.get(1));
    assertEquals(DublinCoreSchema.TITLE, titleProperty.getPropertyName());
    assertEquals(DublinCoreSchema.TITLE, getResult4.getValue());
    assertSame(titleProperty, allProperties2.get(0));
    assertSame(allProperties, titleProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, titleProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setTitle(String, String)}
   */
  @Test
  void testSetTitle6() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);

    // Act
    dublinCoreSchema.setTitle("Lang", "42");

    // Assert
    ArrayProperty titleProperty = dublinCoreSchema.getTitleProperty();
    List<AbstractField> allProperties = titleProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = titleProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> titleLanguages = dublinCoreSchema.getTitleLanguages();
    assertEquals(1, titleLanguages.size());
    assertEquals("Lang", titleLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", titleProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", titleProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Alt, titleProperty.getArrayType());
    assertTrue(titleProperty.getAllAttributes().isEmpty());
    assertTrue(titleProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.TITLE, titleProperty.getPropertyName());
    assertSame(titleProperty, allProperties2.get(0));
    assertSame(allProperties, titleProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, titleProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setTitle(String, String)}
   */
  @Test
  void testSetTitle7() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act
    dublinCoreSchema.setTitle("Lang", "42");

    // Assert
    ArrayProperty titleProperty = dublinCoreSchema.getTitleProperty();
    List<AbstractField> allProperties = titleProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = titleProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> titleLanguages = dublinCoreSchema.getTitleLanguages();
    assertEquals(1, titleLanguages.size());
    assertEquals("Lang", titleLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", titleProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", titleProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, titleProperty.getArrayType());
    assertTrue(titleProperty.getAllAttributes().isEmpty());
    assertTrue(titleProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.TITLE, titleProperty.getPropertyName());
    assertSame(titleProperty, allProperties2.get(1));
    assertSame(allProperties, titleProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, titleProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setTitle(String, String)}
   */
  @Test
  void testSetTitle8() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act
    dublinCoreSchema.setTitle("Lang", "42");

    // Assert
    ArrayProperty titleProperty = dublinCoreSchema.getTitleProperty();
    List<AbstractField> allProperties = titleProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = titleProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> titleLanguages = dublinCoreSchema.getTitleLanguages();
    assertEquals(1, titleLanguages.size());
    assertEquals("Lang", titleLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", titleProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", titleProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(3, allProperties2.size());
    assertEquals(Cardinality.Alt, titleProperty.getArrayType());
    assertTrue(titleProperty.getAllAttributes().isEmpty());
    assertTrue(titleProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.TITLE, titleProperty.getPropertyName());
    assertSame(titleProperty, allProperties2.get(2));
    assertSame(allProperties, titleProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, titleProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setTitle(String, String)}
   */
  @Test
  void testSetTitle9() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addTitle(DublinCoreSchema.CONTRIBUTOR, DublinCoreSchema.TITLE);
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act
    dublinCoreSchema.setTitle("Lang", "42");

    // Assert
    ArrayProperty titleProperty = dublinCoreSchema.getTitleProperty();
    List<AbstractField> allProperties = titleProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = titleProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    List<String> titleLanguages = dublinCoreSchema.getTitleLanguages();
    assertEquals(2, titleLanguages.size());
    assertEquals("Lang", titleLanguages.get(1));
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("Lang", getResult3.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", getResult2.getPrefix());
    assertEquals("dc", titleProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult2.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", titleProperty.getNamespace());
    List<Attribute> allAttributes2 = getResult.getAllAttributes();
    assertEquals(1, allAttributes2.size());
    Attribute getResult4 = allAttributes2.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult4.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    assertEquals("lang", getResult4.getName());
    assertEquals("lang", getResult3.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, titleProperty.getArrayType());
    assertTrue(titleProperty.getAllAttributes().isEmpty());
    assertTrue(titleProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, titleLanguages.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, getResult4.getValue());
    assertEquals(DublinCoreSchema.TITLE, elementsAsString.get(0));
    assertEquals(DublinCoreSchema.TITLE, titleProperty.getPropertyName());
    assertEquals(DublinCoreSchema.TITLE, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.TITLE, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.TITLE, ((TextType) getResult).getValue());
    assertSame(titleProperty, allProperties2.get(0));
    assertSame(allProperties, titleProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, titleProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setTitle(String, String)}
   */
  @Test
  void testSetTitle10() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addTitle("Lang", DublinCoreSchema.TITLE);
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act
    dublinCoreSchema.setTitle("Lang", "42");

    // Assert
    ArrayProperty titleProperty = dublinCoreSchema.getTitleProperty();
    List<AbstractField> allProperties = titleProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = titleProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> titleLanguages = dublinCoreSchema.getTitleLanguages();
    assertEquals(1, titleLanguages.size());
    assertEquals("Lang", titleLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", titleProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", titleProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, titleProperty.getArrayType());
    assertTrue(titleProperty.getAllAttributes().isEmpty());
    assertTrue(titleProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.TITLE, titleProperty.getPropertyName());
    assertSame(titleProperty, allProperties2.get(0));
    assertSame(allProperties, titleProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, titleProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#setTitle(String, String)}
   */
  @Test
  void testSetTitle11() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addTitle("x-default", DublinCoreSchema.TITLE);
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act
    dublinCoreSchema.setTitle("Lang", "42");

    // Assert
    ArrayProperty titleProperty = dublinCoreSchema.getTitleProperty();
    List<AbstractField> allProperties = titleProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = titleProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    List<String> titleLanguages = dublinCoreSchema.getTitleLanguages();
    assertEquals(2, titleLanguages.size());
    assertEquals("Lang", titleLanguages.get(1));
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("Lang", getResult3.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", getResult2.getPrefix());
    assertEquals("dc", titleProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult2.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", titleProperty.getNamespace());
    List<Attribute> allAttributes2 = getResult.getAllAttributes();
    assertEquals(1, allAttributes2.size());
    Attribute getResult4 = allAttributes2.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult4.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    assertEquals("lang", getResult4.getName());
    assertEquals("lang", getResult3.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("x-default", titleLanguages.get(0));
    assertEquals("x-default", getResult4.getValue());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, titleProperty.getArrayType());
    assertTrue(titleProperty.getAllAttributes().isEmpty());
    assertTrue(titleProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.TITLE, elementsAsString.get(0));
    assertEquals(DublinCoreSchema.TITLE, titleProperty.getPropertyName());
    assertEquals(DublinCoreSchema.TITLE, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.TITLE, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.TITLE, ((TextType) getResult).getValue());
    assertSame(titleProperty, allProperties2.get(0));
    assertSame(allProperties, titleProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, titleProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addTitle(String, String)}
   */
  @Test
  void testAddTitle() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);

    // Act
    dublinCoreSchema.addTitle("Lang", "42");

    // Assert
    ArrayProperty titleProperty = dublinCoreSchema.getTitleProperty();
    List<AbstractField> allProperties = titleProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = titleProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> titleLanguages = dublinCoreSchema.getTitleLanguages();
    assertEquals(1, titleLanguages.size());
    assertEquals("Lang", titleLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", titleProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", titleProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Alt, titleProperty.getArrayType());
    assertTrue(titleProperty.getAllAttributes().isEmpty());
    assertTrue(titleProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.TITLE, titleProperty.getPropertyName());
    assertSame(titleProperty, allProperties2.get(0));
    assertSame(allProperties, titleProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, titleProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addTitle(String, String)}
   */
  @Test
  void testAddTitle2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act
    dublinCoreSchema.addTitle("Lang", "42");

    // Assert
    ArrayProperty titleProperty = dublinCoreSchema.getTitleProperty();
    List<AbstractField> allProperties = titleProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = titleProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> titleLanguages = dublinCoreSchema.getTitleLanguages();
    assertEquals(1, titleLanguages.size());
    assertEquals("Lang", titleLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", titleProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", titleProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, titleProperty.getArrayType());
    assertTrue(titleProperty.getAllAttributes().isEmpty());
    assertTrue(titleProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.TITLE, titleProperty.getPropertyName());
    assertSame(titleProperty, allProperties2.get(1));
    assertSame(allProperties, titleProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, titleProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addTitle(String, String)}
   */
  @Test
  void testAddTitle3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act
    dublinCoreSchema.addTitle("Lang", "42");

    // Assert
    ArrayProperty titleProperty = dublinCoreSchema.getTitleProperty();
    List<AbstractField> allProperties = titleProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = titleProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> titleLanguages = dublinCoreSchema.getTitleLanguages();
    assertEquals(1, titleLanguages.size());
    assertEquals("Lang", titleLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", titleProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", titleProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(3, allProperties2.size());
    assertEquals(Cardinality.Alt, titleProperty.getArrayType());
    assertTrue(titleProperty.getAllAttributes().isEmpty());
    assertTrue(titleProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.TITLE, titleProperty.getPropertyName());
    assertSame(titleProperty, allProperties2.get(2));
    assertSame(allProperties, titleProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, titleProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addTitle(String, String)}
   */
  @Test
  void testAddTitle4() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addTitle(DublinCoreSchema.CONTRIBUTOR, DublinCoreSchema.TITLE);
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act
    dublinCoreSchema.addTitle("Lang", "42");

    // Assert
    ArrayProperty titleProperty = dublinCoreSchema.getTitleProperty();
    List<AbstractField> allProperties = titleProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = titleProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    List<String> titleLanguages = dublinCoreSchema.getTitleLanguages();
    assertEquals(2, titleLanguages.size());
    assertEquals("Lang", titleLanguages.get(1));
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("Lang", getResult3.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", getResult2.getPrefix());
    assertEquals("dc", titleProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult2.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", titleProperty.getNamespace());
    List<Attribute> allAttributes2 = getResult.getAllAttributes();
    assertEquals(1, allAttributes2.size());
    Attribute getResult4 = allAttributes2.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult4.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    assertEquals("lang", getResult4.getName());
    assertEquals("lang", getResult3.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, titleProperty.getArrayType());
    assertTrue(titleProperty.getAllAttributes().isEmpty());
    assertTrue(titleProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, titleLanguages.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, getResult4.getValue());
    assertEquals(DublinCoreSchema.TITLE, elementsAsString.get(0));
    assertEquals(DublinCoreSchema.TITLE, titleProperty.getPropertyName());
    assertEquals(DublinCoreSchema.TITLE, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.TITLE, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.TITLE, ((TextType) getResult).getValue());
    assertSame(titleProperty, allProperties2.get(0));
    assertSame(allProperties, titleProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, titleProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addTitle(String, String)}
   */
  @Test
  void testAddTitle5() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addTitle("Lang", DublinCoreSchema.TITLE);
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act
    dublinCoreSchema.addTitle("Lang", "42");

    // Assert
    ArrayProperty titleProperty = dublinCoreSchema.getTitleProperty();
    List<AbstractField> allProperties = titleProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = titleProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> titleLanguages = dublinCoreSchema.getTitleLanguages();
    assertEquals(1, titleLanguages.size());
    assertEquals("Lang", titleLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", titleProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", titleProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, titleProperty.getArrayType());
    assertTrue(titleProperty.getAllAttributes().isEmpty());
    assertTrue(titleProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.TITLE, titleProperty.getPropertyName());
    assertSame(titleProperty, allProperties2.get(0));
    assertSame(allProperties, titleProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, titleProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addTitle(String, String)}
   */
  @Test
  void testAddTitle6() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addTitle("x-default", DublinCoreSchema.TITLE);
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act
    dublinCoreSchema.addTitle("Lang", "42");

    // Assert
    ArrayProperty titleProperty = dublinCoreSchema.getTitleProperty();
    List<AbstractField> allProperties = titleProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = titleProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    List<String> titleLanguages = dublinCoreSchema.getTitleLanguages();
    assertEquals(2, titleLanguages.size());
    assertEquals("Lang", titleLanguages.get(1));
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("Lang", getResult3.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", getResult2.getPrefix());
    assertEquals("dc", titleProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult2.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", titleProperty.getNamespace());
    List<Attribute> allAttributes2 = getResult.getAllAttributes();
    assertEquals(1, allAttributes2.size());
    Attribute getResult4 = allAttributes2.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult4.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    assertEquals("lang", getResult4.getName());
    assertEquals("lang", getResult3.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("x-default", titleLanguages.get(0));
    assertEquals("x-default", getResult4.getValue());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, titleProperty.getArrayType());
    assertTrue(titleProperty.getAllAttributes().isEmpty());
    assertTrue(titleProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.TITLE, elementsAsString.get(0));
    assertEquals(DublinCoreSchema.TITLE, titleProperty.getPropertyName());
    assertEquals(DublinCoreSchema.TITLE, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.TITLE, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.TITLE, ((TextType) getResult).getValue());
    assertSame(titleProperty, allProperties2.get(0));
    assertSame(allProperties, titleProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, titleProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addType(String)}
   */
  @Test
  void testAddType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);

    // Act
    dublinCoreSchema.addType("Type");

    // Assert
    ArrayProperty typesProperty = dublinCoreSchema.getTypesProperty();
    List<AbstractField> allProperties = typesProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> types = dublinCoreSchema.getTypes();
    assertEquals(1, types.size());
    assertEquals("Type", types.get(0));
    List<String> elementsAsString = typesProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Type", elementsAsString.get(0));
    assertEquals("Type", ((TextType) getResult).getStringValue());
    assertEquals("Type", ((TextType) getResult).getRawValue());
    assertEquals("Type", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", typesProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", typesProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Bag, typesProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(typesProperty.getAllAttributes().isEmpty());
    assertTrue(typesProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.TYPE, typesProperty.getPropertyName());
    assertSame(typesProperty, allProperties2.get(0));
    assertSame(allProperties, typesProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, typesProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addType(String)}
   */
  @Test
  void testAddType2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addContributor(DublinCoreSchema.TYPE);

    // Act
    dublinCoreSchema.addType("Type");

    // Assert
    ArrayProperty typesProperty = dublinCoreSchema.getTypesProperty();
    List<AbstractField> allProperties = typesProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> types = dublinCoreSchema.getTypes();
    assertEquals(1, types.size());
    assertEquals("Type", types.get(0));
    List<String> elementsAsString = typesProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Type", elementsAsString.get(0));
    assertEquals("Type", ((TextType) getResult).getStringValue());
    assertEquals("Type", ((TextType) getResult).getRawValue());
    assertEquals("Type", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", typesProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", typesProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Bag, typesProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(typesProperty.getAllAttributes().isEmpty());
    assertTrue(typesProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.TYPE, typesProperty.getPropertyName());
    assertSame(typesProperty, allProperties2.get(1));
    assertSame(allProperties, typesProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, typesProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addType(String)}
   */
  @Test
  void testAddType3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.TYPE);

    // Act
    dublinCoreSchema.addType("Type");

    // Assert
    ArrayProperty typesProperty = dublinCoreSchema.getTypesProperty();
    List<AbstractField> allProperties = typesProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> types = dublinCoreSchema.getTypes();
    assertEquals(1, types.size());
    assertEquals("Type", types.get(0));
    List<String> elementsAsString = typesProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Type", elementsAsString.get(0));
    assertEquals("Type", ((TextType) getResult).getStringValue());
    assertEquals("Type", ((TextType) getResult).getRawValue());
    assertEquals("Type", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", typesProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", typesProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(3, allProperties2.size());
    assertEquals(Cardinality.Bag, typesProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(typesProperty.getAllAttributes().isEmpty());
    assertTrue(typesProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.TYPE, typesProperty.getPropertyName());
    assertSame(typesProperty, allProperties2.get(2));
    assertSame(allProperties, typesProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, typesProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#addType(String)}
   */
  @Test
  void testAddType4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addType(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.TYPE);

    // Act
    dublinCoreSchema.addType("Type");

    // Assert
    ArrayProperty typesProperty = dublinCoreSchema.getTypesProperty();
    List<AbstractField> allProperties = typesProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> types = dublinCoreSchema.getTypes();
    assertEquals(2, types.size());
    assertEquals("Type", types.get(1));
    assertEquals("Type", ((TextType) getResult2).getStringValue());
    assertEquals("Type", ((TextType) getResult2).getRawValue());
    assertEquals("Type", ((TextType) getResult2).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", getResult2.getPrefix());
    assertEquals("dc", typesProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult2.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", typesProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Bag, typesProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(typesProperty.getAllAttributes().isEmpty());
    assertTrue(typesProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(types, typesProperty.getElementsAsString());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, types.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getValue());
    assertEquals(DublinCoreSchema.TYPE, typesProperty.getPropertyName());
    assertSame(typesProperty, allProperties2.get(0));
    assertSame(allProperties, typesProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, typesProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getContributorsProperty()}
   */
  @Test
  void testGetContributorsProperty() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getContributorsProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getContributorsProperty()}
   */
  @Test
  void testGetContributorsProperty2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addContributor(DublinCoreSchema.CONTRIBUTOR);

    // Act
    ArrayProperty actualContributorsProperty = dublinCoreSchema.getContributorsProperty();

    // Assert
    List<AbstractField> allProperties = actualContributorsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", actualContributorsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", actualContributorsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<String> elementsAsString = actualContributorsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals(Cardinality.Bag, actualContributorsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualContributorsProperty.getAllAttributes().isEmpty());
    assertTrue(actualContributorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, elementsAsString.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, actualContributorsProperty.getPropertyName());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getValue());
    assertSame(allProperties, actualContributorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualContributorsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getContributorsProperty()}
   */
  @Test
  void testGetContributorsProperty3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addCreator("Proper Name");
    dublinCoreSchema.addContributor(DublinCoreSchema.CONTRIBUTOR);

    // Act
    ArrayProperty actualContributorsProperty = dublinCoreSchema.getContributorsProperty();

    // Assert
    List<AbstractField> allProperties = actualContributorsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", actualContributorsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", actualContributorsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<String> elementsAsString = actualContributorsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals(Cardinality.Bag, actualContributorsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualContributorsProperty.getAllAttributes().isEmpty());
    assertTrue(actualContributorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, elementsAsString.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, actualContributorsProperty.getPropertyName());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getValue());
    assertSame(allProperties, actualContributorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualContributorsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getContributors()}
   */
  @Test
  void testGetContributors() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getContributors());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getContributors()}
   */
  @Test
  void testGetContributors2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.CONTRIBUTOR);

    // Act
    List<String> actualContributors = dublinCoreSchema.getContributors();

    // Assert
    assertEquals(1, actualContributors.size());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, actualContributors.get(0));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getContributors()}
   */
  @Test
  void testGetContributors3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator("Proper Name");
    dublinCoreSchema.addContributor(DublinCoreSchema.CONTRIBUTOR);

    // Act
    List<String> actualContributors = dublinCoreSchema.getContributors();

    // Assert
    assertEquals(1, actualContributors.size());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, actualContributors.get(0));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getCoverageProperty()}
   */
  @Test
  void testGetCoverageProperty() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getCoverageProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getCoverageProperty()}
   */
  @Test
  void testGetCoverageProperty2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.COVERAGE);

    // Act and Assert
    assertNull(dublinCoreSchema.getCoverageProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getCoverageProperty()}
   */
  @Test
  void testGetCoverageProperty3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.COVERAGE);

    // Act and Assert
    assertNull(dublinCoreSchema.getCoverageProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getCoverage()}
   */
  @Test
  void testGetCoverage() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getCoverage());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getCoverage()}
   */
  @Test
  void testGetCoverage2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.COVERAGE);

    // Act and Assert
    assertNull(dublinCoreSchema.getCoverage());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getCoverage()}
   */
  @Test
  void testGetCoverage3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.COVERAGE);

    // Act and Assert
    assertNull(dublinCoreSchema.getCoverage());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getCreatorsProperty()}
   */
  @Test
  void testGetCreatorsProperty() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getCreatorsProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getCreatorsProperty()}
   */
  @Test
  void testGetCreatorsProperty2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.CREATOR);

    // Act and Assert
    assertNull(dublinCoreSchema.getCreatorsProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getCreatorsProperty()}
   */
  @Test
  void testGetCreatorsProperty3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.CREATOR);

    // Act
    ArrayProperty actualCreatorsProperty = dublinCoreSchema.getCreatorsProperty();

    // Assert
    List<AbstractField> allProperties = actualCreatorsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", actualCreatorsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", actualCreatorsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<String> elementsAsString = actualCreatorsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals(Cardinality.Seq, actualCreatorsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualCreatorsProperty.getAllAttributes().isEmpty());
    assertTrue(actualCreatorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, elementsAsString.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getValue());
    assertEquals(DublinCoreSchema.CREATOR, actualCreatorsProperty.getPropertyName());
    assertSame(allProperties, actualCreatorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualCreatorsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getCreators()}
   */
  @Test
  void testGetCreators() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getCreators());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getCreators()}
   */
  @Test
  void testGetCreators2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.CREATOR);

    // Act and Assert
    assertNull(dublinCoreSchema.getCreators());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getCreators()}
   */
  @Test
  void testGetCreators3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.CREATOR);

    // Act
    List<String> actualCreators = dublinCoreSchema.getCreators();

    // Assert
    assertEquals(1, actualCreators.size());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, actualCreators.get(0));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getDatesProperty()}
   */
  @Test
  void testGetDatesProperty() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getDatesProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getDatesProperty()}
   */
  @Test
  void testGetDatesProperty2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.DATE);

    // Act and Assert
    assertNull(dublinCoreSchema.getDatesProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getDatesProperty()}
   */
  @Test
  void testGetDatesProperty3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.DATE);

    // Act and Assert
    assertNull(dublinCoreSchema.getDatesProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getDatesProperty()}
   */
  @Test
  void testGetDatesProperty4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    GregorianCalendar date = new GregorianCalendar(5, 5, 5);

    dublinCoreSchema.addDate(date);
    dublinCoreSchema.addContributor(DublinCoreSchema.DATE);

    // Act
    ArrayProperty actualDatesProperty = dublinCoreSchema.getDatesProperty();

    // Assert
    List<AbstractField> allProperties = actualDatesProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof DateType);
    assertEquals("RDF", getResult.getPrefix());
    assertEquals("dc", actualDatesProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", actualDatesProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertNull(getResult.getNamespace());
    assertEquals(1, actualDatesProperty.getElementsAsString().size());
    assertEquals(Cardinality.Seq, actualDatesProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualDatesProperty.getAllAttributes().isEmpty());
    assertTrue(actualDatesProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.DATE, actualDatesProperty.getPropertyName());
    assertSame(date, ((DateType) getResult).getRawValue());
    assertSame(date, ((DateType) getResult).getValue());
    assertSame(allProperties, actualDatesProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualDatesProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getDates()}
   */
  @Test
  void testGetDates() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getDates());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getDates()}
   */
  @Test
  void testGetDates2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.DATE);

    // Act and Assert
    assertNull(dublinCoreSchema.getDates());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getDates()}
   */
  @Test
  void testGetDates3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    dublinCoreSchema.addDate(date);
    dublinCoreSchema.addContributor(DublinCoreSchema.DATE);

    // Act
    List<Calendar> actualDates = dublinCoreSchema.getDates();

    // Assert
    assertEquals(1, actualDates.size());
    assertSame(date, actualDates.get(0));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getDates()}
   */
  @Test
  void testGetDates4() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addBagValueAsSimple(DublinCoreSchema.DATE, "42");

    // Act and Assert
    assertTrue(dublinCoreSchema.getDates().isEmpty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getDescriptionProperty()}
   */
  @Test
  void testGetDescriptionProperty() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getDescriptionProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getDescriptionProperty()}
   */
  @Test
  void testGetDescriptionProperty2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act and Assert
    assertNull(dublinCoreSchema.getDescriptionProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getDescriptionProperty()}
   */
  @Test
  void testGetDescriptionProperty3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act and Assert
    assertNull(dublinCoreSchema.getDescriptionProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getDescriptionProperty()}
   */
  @Test
  void testGetDescriptionProperty4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addDescription(DublinCoreSchema.CONTRIBUTOR, DublinCoreSchema.DESCRIPTION);
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act
    ArrayProperty actualDescriptionProperty = dublinCoreSchema.getDescriptionProperty();

    // Assert
    List<AbstractField> allProperties = actualDescriptionProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", actualDescriptionProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", actualDescriptionProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<String> elementsAsString = actualDescriptionProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals(Cardinality.Alt, actualDescriptionProperty.getArrayType());
    assertTrue(actualDescriptionProperty.getAllAttributes().isEmpty());
    assertTrue(actualDescriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, getResult2.getValue());
    assertEquals(DublinCoreSchema.DESCRIPTION, elementsAsString.get(0));
    assertEquals(DublinCoreSchema.DESCRIPTION, actualDescriptionProperty.getPropertyName());
    assertEquals(DublinCoreSchema.DESCRIPTION, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.DESCRIPTION, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.DESCRIPTION, ((TextType) getResult).getValue());
    assertSame(allProperties, actualDescriptionProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualDescriptionProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getDescriptionLanguages()}
   */
  @Test
  void testGetDescriptionLanguages() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getDescriptionLanguages());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getDescriptionLanguages()}
   */
  @Test
  void testGetDescriptionLanguages2() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act and Assert
    assertNull(dublinCoreSchema.getDescriptionLanguages());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getDescriptionLanguages()}
   */
  @Test
  void testGetDescriptionLanguages3() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addDescription(DublinCoreSchema.CONTRIBUTOR, DublinCoreSchema.DESCRIPTION);
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act
    List<String> actualDescriptionLanguages = dublinCoreSchema.getDescriptionLanguages();

    // Assert
    assertEquals(1, actualDescriptionLanguages.size());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, actualDescriptionLanguages.get(0));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getDescriptionLanguages()}
   */
  @Test
  void testGetDescriptionLanguages4() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addBagValueAsSimple(DublinCoreSchema.DESCRIPTION, "42");

    // Act
    List<String> actualDescriptionLanguages = dublinCoreSchema.getDescriptionLanguages();

    // Assert
    assertEquals(1, actualDescriptionLanguages.size());
    assertEquals("x-default", actualDescriptionLanguages.get(0));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getDescription()}
   */
  @Test
  void testGetDescription() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getDescription());
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getDescription("Lang"));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getDescription()}
   */
  @Test
  void testGetDescription2() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act and Assert
    assertNull(dublinCoreSchema.getDescription());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getDescription()}
   */
  @Test
  void testGetDescription3() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addDescription("x-default", DublinCoreSchema.DESCRIPTION);
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act and Assert
    assertEquals(DublinCoreSchema.DESCRIPTION, dublinCoreSchema.getDescription());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getDescription()}
   */
  @Test
  void testGetDescription4() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addDescription(DublinCoreSchema.DESCRIPTION, "42");

    // Act and Assert
    assertNull(dublinCoreSchema.getDescription());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getDescription()}
   */
  @Test
  void testGetDescription5() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addBagValueAsSimple(DublinCoreSchema.DESCRIPTION, "42");

    // Act and Assert
    assertNull(dublinCoreSchema.getDescription());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getDescription(String)}
   */
  @Test
  void testGetDescription6() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act and Assert
    assertNull(dublinCoreSchema.getDescription("Lang"));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getDescription(String)}
   */
  @Test
  void testGetDescription7() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addDescription(DublinCoreSchema.CONTRIBUTOR, DublinCoreSchema.DESCRIPTION);
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act and Assert
    assertNull(dublinCoreSchema.getDescription("Lang"));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getDescription(String)}
   */
  @Test
  void testGetDescription8() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addBagValueAsSimple(DublinCoreSchema.DESCRIPTION, "42");

    // Act and Assert
    assertNull(dublinCoreSchema.getDescription("Lang"));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getDescription(String)}
   */
  @Test
  void testGetDescription9() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addDescription("Lang", DublinCoreSchema.DESCRIPTION);
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act and Assert
    assertEquals(DublinCoreSchema.DESCRIPTION, dublinCoreSchema.getDescription("Lang"));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getFormatProperty()}
   */
  @Test
  void testGetFormatProperty() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getFormatProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getFormatProperty()}
   */
  @Test
  void testGetFormatProperty2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.FORMAT);

    // Act and Assert
    assertNull(dublinCoreSchema.getFormatProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getFormatProperty()}
   */
  @Test
  void testGetFormatProperty3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.FORMAT);

    // Act and Assert
    assertNull(dublinCoreSchema.getFormatProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getFormat()}
   */
  @Test
  void testGetFormat() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getFormat());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getFormat()}
   */
  @Test
  void testGetFormat2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.FORMAT);

    // Act and Assert
    assertNull(dublinCoreSchema.getFormat());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getFormat()}
   */
  @Test
  void testGetFormat3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.FORMAT);

    // Act and Assert
    assertNull(dublinCoreSchema.getFormat());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getIdentifierProperty()}
   */
  @Test
  void testGetIdentifierProperty() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getIdentifierProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getIdentifierProperty()}
   */
  @Test
  void testGetIdentifierProperty2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.IDENTIFIER);

    // Act and Assert
    assertNull(dublinCoreSchema.getIdentifierProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getIdentifierProperty()}
   */
  @Test
  void testGetIdentifierProperty3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.IDENTIFIER);

    // Act and Assert
    assertNull(dublinCoreSchema.getIdentifierProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getIdentifier()}
   */
  @Test
  void testGetIdentifier() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getIdentifier());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getIdentifier()}
   */
  @Test
  void testGetIdentifier2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.IDENTIFIER);

    // Act and Assert
    assertNull(dublinCoreSchema.getIdentifier());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getIdentifier()}
   */
  @Test
  void testGetIdentifier3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.IDENTIFIER);

    // Act and Assert
    assertNull(dublinCoreSchema.getIdentifier());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getLanguagesProperty()}
   */
  @Test
  void testGetLanguagesProperty() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getLanguagesProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getLanguagesProperty()}
   */
  @Test
  void testGetLanguagesProperty2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.LANGUAGE);

    // Act and Assert
    assertNull(dublinCoreSchema.getLanguagesProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getLanguagesProperty()}
   */
  @Test
  void testGetLanguagesProperty3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.LANGUAGE);

    // Act and Assert
    assertNull(dublinCoreSchema.getLanguagesProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getLanguagesProperty()}
   */
  @Test
  void testGetLanguagesProperty4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addLanguage(DublinCoreSchema.LANGUAGE);
    dublinCoreSchema.addContributor(DublinCoreSchema.LANGUAGE);

    // Act
    ArrayProperty actualLanguagesProperty = dublinCoreSchema.getLanguagesProperty();

    // Assert
    List<AbstractField> allProperties = actualLanguagesProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", actualLanguagesProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", actualLanguagesProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<String> elementsAsString = actualLanguagesProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals(Cardinality.Bag, actualLanguagesProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualLanguagesProperty.getAllAttributes().isEmpty());
    assertTrue(actualLanguagesProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.LANGUAGE, elementsAsString.get(0));
    assertEquals(DublinCoreSchema.LANGUAGE, actualLanguagesProperty.getPropertyName());
    assertEquals(DublinCoreSchema.LANGUAGE, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.LANGUAGE, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.LANGUAGE, ((TextType) getResult).getValue());
    assertSame(allProperties, actualLanguagesProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualLanguagesProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getLanguages()}
   */
  @Test
  void testGetLanguages() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getLanguages());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getLanguages()}
   */
  @Test
  void testGetLanguages2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.LANGUAGE);

    // Act and Assert
    assertNull(dublinCoreSchema.getLanguages());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getLanguages()}
   */
  @Test
  void testGetLanguages3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addLanguage(DublinCoreSchema.LANGUAGE);
    dublinCoreSchema.addContributor(DublinCoreSchema.LANGUAGE);

    // Act
    List<String> actualLanguages = dublinCoreSchema.getLanguages();

    // Assert
    assertEquals(1, actualLanguages.size());
    assertEquals(DublinCoreSchema.LANGUAGE, actualLanguages.get(0));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getPublishersProperty()}
   */
  @Test
  void testGetPublishersProperty() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getPublishersProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getPublishersProperty()}
   */
  @Test
  void testGetPublishersProperty2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.PUBLISHER);

    // Act and Assert
    assertNull(dublinCoreSchema.getPublishersProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getPublishersProperty()}
   */
  @Test
  void testGetPublishersProperty3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.PUBLISHER);

    // Act and Assert
    assertNull(dublinCoreSchema.getPublishersProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getPublishersProperty()}
   */
  @Test
  void testGetPublishersProperty4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addPublisher(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.PUBLISHER);

    // Act
    ArrayProperty actualPublishersProperty = dublinCoreSchema.getPublishersProperty();

    // Assert
    List<AbstractField> allProperties = actualPublishersProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", actualPublishersProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", actualPublishersProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<String> elementsAsString = actualPublishersProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals(Cardinality.Bag, actualPublishersProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualPublishersProperty.getAllAttributes().isEmpty());
    assertTrue(actualPublishersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, elementsAsString.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getValue());
    assertEquals(DublinCoreSchema.PUBLISHER, actualPublishersProperty.getPropertyName());
    assertSame(allProperties, actualPublishersProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualPublishersProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getPublishers()}
   */
  @Test
  void testGetPublishers() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getPublishers());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getPublishers()}
   */
  @Test
  void testGetPublishers2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.PUBLISHER);

    // Act and Assert
    assertNull(dublinCoreSchema.getPublishers());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getPublishers()}
   */
  @Test
  void testGetPublishers3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addPublisher(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.PUBLISHER);

    // Act
    List<String> actualPublishers = dublinCoreSchema.getPublishers();

    // Assert
    assertEquals(1, actualPublishers.size());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, actualPublishers.get(0));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getRelationsProperty()}
   */
  @Test
  void testGetRelationsProperty() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getRelationsProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getRelationsProperty()}
   */
  @Test
  void testGetRelationsProperty2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.RELATION);

    // Act and Assert
    assertNull(dublinCoreSchema.getRelationsProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getRelationsProperty()}
   */
  @Test
  void testGetRelationsProperty3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.RELATION);

    // Act and Assert
    assertNull(dublinCoreSchema.getRelationsProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getRelationsProperty()}
   */
  @Test
  void testGetRelationsProperty4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addRelation(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.RELATION);

    // Act
    ArrayProperty actualRelationsProperty = dublinCoreSchema.getRelationsProperty();

    // Assert
    List<AbstractField> allProperties = actualRelationsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", actualRelationsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", actualRelationsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<String> elementsAsString = actualRelationsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals(Cardinality.Bag, actualRelationsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualRelationsProperty.getAllAttributes().isEmpty());
    assertTrue(actualRelationsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, elementsAsString.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getValue());
    assertEquals(DublinCoreSchema.RELATION, actualRelationsProperty.getPropertyName());
    assertSame(allProperties, actualRelationsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualRelationsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getRelations()}
   */
  @Test
  void testGetRelations() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getRelations());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getRelations()}
   */
  @Test
  void testGetRelations2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.RELATION);

    // Act and Assert
    assertNull(dublinCoreSchema.getRelations());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getRelations()}
   */
  @Test
  void testGetRelations3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addRelation(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.RELATION);

    // Act
    List<String> actualRelations = dublinCoreSchema.getRelations();

    // Assert
    assertEquals(1, actualRelations.size());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, actualRelations.get(0));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getRightsProperty()}
   */
  @Test
  void testGetRightsProperty() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getRightsProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getRightsProperty()}
   */
  @Test
  void testGetRightsProperty2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.RIGHTS);

    // Act and Assert
    assertNull(dublinCoreSchema.getRightsProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getRightsProperty()}
   */
  @Test
  void testGetRightsProperty3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.RIGHTS);

    // Act and Assert
    assertNull(dublinCoreSchema.getRightsProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getRightsProperty()}
   */
  @Test
  void testGetRightsProperty4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addRights(DublinCoreSchema.CONTRIBUTOR, DublinCoreSchema.RIGHTS);
    dublinCoreSchema.addContributor(DublinCoreSchema.RIGHTS);

    // Act
    ArrayProperty actualRightsProperty = dublinCoreSchema.getRightsProperty();

    // Assert
    List<AbstractField> allProperties = actualRightsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", actualRightsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", actualRightsProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<String> elementsAsString = actualRightsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals(Cardinality.Alt, actualRightsProperty.getArrayType());
    assertTrue(actualRightsProperty.getAllAttributes().isEmpty());
    assertTrue(actualRightsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, getResult2.getValue());
    assertEquals(DublinCoreSchema.RIGHTS, elementsAsString.get(0));
    assertEquals(DublinCoreSchema.RIGHTS, actualRightsProperty.getPropertyName());
    assertEquals(DublinCoreSchema.RIGHTS, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.RIGHTS, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.RIGHTS, ((TextType) getResult).getValue());
    assertSame(allProperties, actualRightsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualRightsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getRightsLanguages()}
   */
  @Test
  void testGetRightsLanguages() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getRightsLanguages());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getRightsLanguages()}
   */
  @Test
  void testGetRightsLanguages2() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.RIGHTS);

    // Act and Assert
    assertNull(dublinCoreSchema.getRightsLanguages());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getRightsLanguages()}
   */
  @Test
  void testGetRightsLanguages3() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addRights(DublinCoreSchema.CONTRIBUTOR, DublinCoreSchema.RIGHTS);
    dublinCoreSchema.addContributor(DublinCoreSchema.RIGHTS);

    // Act
    List<String> actualRightsLanguages = dublinCoreSchema.getRightsLanguages();

    // Assert
    assertEquals(1, actualRightsLanguages.size());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, actualRightsLanguages.get(0));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getRightsLanguages()}
   */
  @Test
  void testGetRightsLanguages4() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addBagValueAsSimple(DublinCoreSchema.RIGHTS, "42");

    // Act
    List<String> actualRightsLanguages = dublinCoreSchema.getRightsLanguages();

    // Assert
    assertEquals(1, actualRightsLanguages.size());
    assertEquals("x-default", actualRightsLanguages.get(0));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getRights()}
   */
  @Test
  void testGetRights() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getRights());
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getRights("Lang"));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getRights()}
   */
  @Test
  void testGetRights2() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.RIGHTS);

    // Act and Assert
    assertNull(dublinCoreSchema.getRights());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getRights()}
   */
  @Test
  void testGetRights3() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addRights("x-default", DublinCoreSchema.RIGHTS);
    dublinCoreSchema.addContributor(DublinCoreSchema.RIGHTS);

    // Act and Assert
    assertEquals(DublinCoreSchema.RIGHTS, dublinCoreSchema.getRights());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getRights()}
   */
  @Test
  void testGetRights4() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addRights(DublinCoreSchema.RIGHTS, "42");

    // Act and Assert
    assertNull(dublinCoreSchema.getRights());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getRights()}
   */
  @Test
  void testGetRights5() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addBagValueAsSimple(DublinCoreSchema.RIGHTS, "42");

    // Act and Assert
    assertNull(dublinCoreSchema.getRights());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getRights(String)}
   */
  @Test
  void testGetRights6() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.RIGHTS);

    // Act and Assert
    assertNull(dublinCoreSchema.getRights("Lang"));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getRights(String)}
   */
  @Test
  void testGetRights7() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addRights(DublinCoreSchema.CONTRIBUTOR, DublinCoreSchema.RIGHTS);
    dublinCoreSchema.addContributor(DublinCoreSchema.RIGHTS);

    // Act and Assert
    assertNull(dublinCoreSchema.getRights("Lang"));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getRights(String)}
   */
  @Test
  void testGetRights8() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addBagValueAsSimple(DublinCoreSchema.RIGHTS, "42");

    // Act and Assert
    assertNull(dublinCoreSchema.getRights("Lang"));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getRights(String)}
   */
  @Test
  void testGetRights9() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addRights("Lang", DublinCoreSchema.RIGHTS);
    dublinCoreSchema.addContributor(DublinCoreSchema.RIGHTS);

    // Act and Assert
    assertEquals(DublinCoreSchema.RIGHTS, dublinCoreSchema.getRights("Lang"));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getSourceProperty()}
   */
  @Test
  void testGetSourceProperty() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getSourceProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getSourceProperty()}
   */
  @Test
  void testGetSourceProperty2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.SOURCE);

    // Act and Assert
    assertNull(dublinCoreSchema.getSourceProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getSourceProperty()}
   */
  @Test
  void testGetSourceProperty3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.SOURCE);

    // Act and Assert
    assertNull(dublinCoreSchema.getSourceProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getSource()}
   */
  @Test
  void testGetSource() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getSource());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getSource()}
   */
  @Test
  void testGetSource2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.SOURCE);

    // Act and Assert
    assertNull(dublinCoreSchema.getSource());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getSource()}
   */
  @Test
  void testGetSource3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.SOURCE);

    // Act and Assert
    assertNull(dublinCoreSchema.getSource());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getSubjectsProperty()}
   */
  @Test
  void testGetSubjectsProperty() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getSubjectsProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getSubjectsProperty()}
   */
  @Test
  void testGetSubjectsProperty2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.SUBJECT);

    // Act and Assert
    assertNull(dublinCoreSchema.getSubjectsProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getSubjectsProperty()}
   */
  @Test
  void testGetSubjectsProperty3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.SUBJECT);

    // Act and Assert
    assertNull(dublinCoreSchema.getSubjectsProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getSubjectsProperty()}
   */
  @Test
  void testGetSubjectsProperty4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addSubject(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.SUBJECT);

    // Act
    ArrayProperty actualSubjectsProperty = dublinCoreSchema.getSubjectsProperty();

    // Assert
    List<AbstractField> allProperties = actualSubjectsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", actualSubjectsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", actualSubjectsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<String> elementsAsString = actualSubjectsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals(Cardinality.Bag, actualSubjectsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualSubjectsProperty.getAllAttributes().isEmpty());
    assertTrue(actualSubjectsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, elementsAsString.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getValue());
    assertEquals(DublinCoreSchema.SUBJECT, actualSubjectsProperty.getPropertyName());
    assertSame(allProperties, actualSubjectsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualSubjectsProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getSubjects()}
   */
  @Test
  void testGetSubjects() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getSubjects());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getSubjects()}
   */
  @Test
  void testGetSubjects2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.SUBJECT);

    // Act and Assert
    assertNull(dublinCoreSchema.getSubjects());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getSubjects()}
   */
  @Test
  void testGetSubjects3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addSubject(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.SUBJECT);

    // Act
    List<String> actualSubjects = dublinCoreSchema.getSubjects();

    // Assert
    assertEquals(1, actualSubjects.size());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, actualSubjects.get(0));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getTitleProperty()}
   */
  @Test
  void testGetTitleProperty() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getTitleProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getTitleProperty()}
   */
  @Test
  void testGetTitleProperty2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act and Assert
    assertNull(dublinCoreSchema.getTitleProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getTitleProperty()}
   */
  @Test
  void testGetTitleProperty3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act and Assert
    assertNull(dublinCoreSchema.getTitleProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getTitleProperty()}
   */
  @Test
  void testGetTitleProperty4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addTitle(DublinCoreSchema.CONTRIBUTOR, DublinCoreSchema.TITLE);
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act
    ArrayProperty actualTitleProperty = dublinCoreSchema.getTitleProperty();

    // Assert
    List<AbstractField> allProperties = actualTitleProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", actualTitleProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", actualTitleProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<String> elementsAsString = actualTitleProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals(Cardinality.Alt, actualTitleProperty.getArrayType());
    assertTrue(actualTitleProperty.getAllAttributes().isEmpty());
    assertTrue(actualTitleProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, getResult2.getValue());
    assertEquals(DublinCoreSchema.TITLE, elementsAsString.get(0));
    assertEquals(DublinCoreSchema.TITLE, actualTitleProperty.getPropertyName());
    assertEquals(DublinCoreSchema.TITLE, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.TITLE, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.TITLE, ((TextType) getResult).getValue());
    assertSame(allProperties, actualTitleProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualTitleProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getTitleLanguages()}
   */
  @Test
  void testGetTitleLanguages() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getTitleLanguages());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getTitleLanguages()}
   */
  @Test
  void testGetTitleLanguages2() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act and Assert
    assertNull(dublinCoreSchema.getTitleLanguages());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getTitleLanguages()}
   */
  @Test
  void testGetTitleLanguages3() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addTitle(DublinCoreSchema.CONTRIBUTOR, DublinCoreSchema.TITLE);
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act
    List<String> actualTitleLanguages = dublinCoreSchema.getTitleLanguages();

    // Assert
    assertEquals(1, actualTitleLanguages.size());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, actualTitleLanguages.get(0));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getTitleLanguages()}
   */
  @Test
  void testGetTitleLanguages4() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addBagValueAsSimple(DublinCoreSchema.TITLE, "42");

    // Act
    List<String> actualTitleLanguages = dublinCoreSchema.getTitleLanguages();

    // Assert
    assertEquals(1, actualTitleLanguages.size());
    assertEquals("x-default", actualTitleLanguages.get(0));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getTitle()}
   */
  @Test
  void testGetTitle() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getTitle());
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getTitle("Lang"));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getTitle()}
   */
  @Test
  void testGetTitle2() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act and Assert
    assertNull(dublinCoreSchema.getTitle());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getTitle()}
   */
  @Test
  void testGetTitle3() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addTitle("x-default", DublinCoreSchema.TITLE);
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act and Assert
    assertEquals(DublinCoreSchema.TITLE, dublinCoreSchema.getTitle());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getTitle()}
   */
  @Test
  void testGetTitle4() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addTitle(DublinCoreSchema.TITLE, "42");

    // Act and Assert
    assertNull(dublinCoreSchema.getTitle());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getTitle()}
   */
  @Test
  void testGetTitle5() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addBagValueAsSimple(DublinCoreSchema.TITLE, "42");

    // Act and Assert
    assertNull(dublinCoreSchema.getTitle());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getTitle(String)}
   */
  @Test
  void testGetTitle6() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act and Assert
    assertNull(dublinCoreSchema.getTitle("Lang"));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getTitle(String)}
   */
  @Test
  void testGetTitle7() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addTitle(DublinCoreSchema.CONTRIBUTOR, DublinCoreSchema.TITLE);
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act and Assert
    assertNull(dublinCoreSchema.getTitle("Lang"));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getTitle(String)}
   */
  @Test
  void testGetTitle8() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addBagValueAsSimple(DublinCoreSchema.TITLE, "42");

    // Act and Assert
    assertNull(dublinCoreSchema.getTitle("Lang"));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getTitle(String)}
   */
  @Test
  void testGetTitle9() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addTitle("Lang", DublinCoreSchema.TITLE);
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act and Assert
    assertEquals(DublinCoreSchema.TITLE, dublinCoreSchema.getTitle("Lang"));
  }

  /**
   * Method under test: {@link DublinCoreSchema#getTypesProperty()}
   */
  @Test
  void testGetTypesProperty() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getTypesProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getTypesProperty()}
   */
  @Test
  void testGetTypesProperty2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.TYPE);

    // Act and Assert
    assertNull(dublinCoreSchema.getTypesProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getTypesProperty()}
   */
  @Test
  void testGetTypesProperty3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.TYPE);

    // Act and Assert
    assertNull(dublinCoreSchema.getTypesProperty());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getTypesProperty()}
   */
  @Test
  void testGetTypesProperty4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addType(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.TYPE);

    // Act
    ArrayProperty actualTypesProperty = dublinCoreSchema.getTypesProperty();

    // Assert
    List<AbstractField> allProperties = actualTypesProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", actualTypesProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", actualTypesProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<String> elementsAsString = actualTypesProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals(Cardinality.Bag, actualTypesProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualTypesProperty.getAllAttributes().isEmpty());
    assertTrue(actualTypesProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, elementsAsString.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getValue());
    assertEquals(DublinCoreSchema.TYPE, actualTypesProperty.getPropertyName());
    assertSame(allProperties, actualTypesProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualTypesProperty.getMetadata());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getTypes()}
   */
  @Test
  void testGetTypes() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getTypes());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getTypes()}
   */
  @Test
  void testGetTypes2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.TYPE);

    // Act and Assert
    assertNull(dublinCoreSchema.getTypes());
  }

  /**
   * Method under test: {@link DublinCoreSchema#getTypes()}
   */
  @Test
  void testGetTypes3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addType(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.TYPE);

    // Act
    List<String> actualTypes = dublinCoreSchema.getTypes();

    // Assert
    assertEquals(1, actualTypes.size());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, actualTypes.get(0));
  }

  /**
   * Method under test: {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)}
   */
  @Test
  void testNewDublinCoreSchema() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    DublinCoreSchema actualDublinCoreSchema = new DublinCoreSchema(metadata);

    // Assert
    assertEquals("", actualDublinCoreSchema.getAboutValue());
    Map<String, String> allNamespacesWithPrefix = actualDublinCoreSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("dc", allNamespacesWithPrefix.get("http://purl.org/dc/elements/1.1/"));
    assertEquals("dc", actualDublinCoreSchema.getPreferedPrefix());
    assertEquals("dc", actualDublinCoreSchema.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", actualDublinCoreSchema.getNamespace());
    assertNull(actualDublinCoreSchema.getCoverage());
    assertNull(actualDublinCoreSchema.getDescription());
    assertNull(actualDublinCoreSchema.getFormat());
    assertNull(actualDublinCoreSchema.getIdentifier());
    assertNull(actualDublinCoreSchema.getRights());
    assertNull(actualDublinCoreSchema.getSource());
    assertNull(actualDublinCoreSchema.getTitle());
    assertNull(actualDublinCoreSchema.getPropertyName());
    assertNull(actualDublinCoreSchema.getContributors());
    assertNull(actualDublinCoreSchema.getCreators());
    assertNull(actualDublinCoreSchema.getDescriptionLanguages());
    assertNull(actualDublinCoreSchema.getLanguages());
    assertNull(actualDublinCoreSchema.getPublishers());
    assertNull(actualDublinCoreSchema.getRelations());
    assertNull(actualDublinCoreSchema.getRightsLanguages());
    assertNull(actualDublinCoreSchema.getSubjects());
    assertNull(actualDublinCoreSchema.getTitleLanguages());
    assertNull(actualDublinCoreSchema.getTypes());
    assertNull(actualDublinCoreSchema.getDates());
    assertNull(actualDublinCoreSchema.getContributorsProperty());
    assertNull(actualDublinCoreSchema.getCreatorsProperty());
    assertNull(actualDublinCoreSchema.getDatesProperty());
    assertNull(actualDublinCoreSchema.getDescriptionProperty());
    assertNull(actualDublinCoreSchema.getLanguagesProperty());
    assertNull(actualDublinCoreSchema.getPublishersProperty());
    assertNull(actualDublinCoreSchema.getRelationsProperty());
    assertNull(actualDublinCoreSchema.getRightsProperty());
    assertNull(actualDublinCoreSchema.getSubjectsProperty());
    assertNull(actualDublinCoreSchema.getTitleProperty());
    assertNull(actualDublinCoreSchema.getTypesProperty());
    assertNull(actualDublinCoreSchema.getAboutAttribute());
    assertNull(actualDublinCoreSchema.getCoverageProperty());
    assertNull(actualDublinCoreSchema.getFormatProperty());
    assertNull(actualDublinCoreSchema.getIdentifierProperty());
    assertNull(actualDublinCoreSchema.getSourceProperty());
    List<AbstractField> allProperties = actualDublinCoreSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualDublinCoreSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualDublinCoreSchema.getContainer().getAllProperties());
    assertSame(metadata, actualDublinCoreSchema.getMetadata());
  }

  /**
   * Method under test:
   * {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata, String)}
   */
  @Test
  void testNewDublinCoreSchema2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    DublinCoreSchema actualDublinCoreSchema = new DublinCoreSchema(metadata, "Own Prefix");

    // Assert
    assertEquals("", actualDublinCoreSchema.getAboutValue());
    Map<String, String> allNamespacesWithPrefix = actualDublinCoreSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("Own Prefix", allNamespacesWithPrefix.get("http://purl.org/dc/elements/1.1/"));
    assertEquals("Own Prefix", actualDublinCoreSchema.getPrefix());
    assertEquals("dc", actualDublinCoreSchema.getPreferedPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", actualDublinCoreSchema.getNamespace());
    assertNull(actualDublinCoreSchema.getCoverage());
    assertNull(actualDublinCoreSchema.getDescription());
    assertNull(actualDublinCoreSchema.getFormat());
    assertNull(actualDublinCoreSchema.getIdentifier());
    assertNull(actualDublinCoreSchema.getRights());
    assertNull(actualDublinCoreSchema.getSource());
    assertNull(actualDublinCoreSchema.getTitle());
    assertNull(actualDublinCoreSchema.getPropertyName());
    assertNull(actualDublinCoreSchema.getContributors());
    assertNull(actualDublinCoreSchema.getCreators());
    assertNull(actualDublinCoreSchema.getDescriptionLanguages());
    assertNull(actualDublinCoreSchema.getLanguages());
    assertNull(actualDublinCoreSchema.getPublishers());
    assertNull(actualDublinCoreSchema.getRelations());
    assertNull(actualDublinCoreSchema.getRightsLanguages());
    assertNull(actualDublinCoreSchema.getSubjects());
    assertNull(actualDublinCoreSchema.getTitleLanguages());
    assertNull(actualDublinCoreSchema.getTypes());
    assertNull(actualDublinCoreSchema.getDates());
    assertNull(actualDublinCoreSchema.getContributorsProperty());
    assertNull(actualDublinCoreSchema.getCreatorsProperty());
    assertNull(actualDublinCoreSchema.getDatesProperty());
    assertNull(actualDublinCoreSchema.getDescriptionProperty());
    assertNull(actualDublinCoreSchema.getLanguagesProperty());
    assertNull(actualDublinCoreSchema.getPublishersProperty());
    assertNull(actualDublinCoreSchema.getRelationsProperty());
    assertNull(actualDublinCoreSchema.getRightsProperty());
    assertNull(actualDublinCoreSchema.getSubjectsProperty());
    assertNull(actualDublinCoreSchema.getTitleProperty());
    assertNull(actualDublinCoreSchema.getTypesProperty());
    assertNull(actualDublinCoreSchema.getAboutAttribute());
    assertNull(actualDublinCoreSchema.getCoverageProperty());
    assertNull(actualDublinCoreSchema.getFormatProperty());
    assertNull(actualDublinCoreSchema.getIdentifierProperty());
    assertNull(actualDublinCoreSchema.getSourceProperty());
    List<AbstractField> allProperties = actualDublinCoreSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualDublinCoreSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualDublinCoreSchema.getContainer().getAllProperties());
    assertSame(metadata, actualDublinCoreSchema.getMetadata());
  }

  /**
   * Method under test:
   * {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata, String)}
   */
  @Test
  void testNewDublinCoreSchema3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    DublinCoreSchema actualDublinCoreSchema = new DublinCoreSchema(metadata, null);

    // Assert
    assertEquals("", actualDublinCoreSchema.getAboutValue());
    Map<String, String> allNamespacesWithPrefix = actualDublinCoreSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("dc", allNamespacesWithPrefix.get("http://purl.org/dc/elements/1.1/"));
    assertEquals("dc", actualDublinCoreSchema.getPreferedPrefix());
    assertEquals("dc", actualDublinCoreSchema.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", actualDublinCoreSchema.getNamespace());
    assertNull(actualDublinCoreSchema.getCoverage());
    assertNull(actualDublinCoreSchema.getDescription());
    assertNull(actualDublinCoreSchema.getFormat());
    assertNull(actualDublinCoreSchema.getIdentifier());
    assertNull(actualDublinCoreSchema.getRights());
    assertNull(actualDublinCoreSchema.getSource());
    assertNull(actualDublinCoreSchema.getTitle());
    assertNull(actualDublinCoreSchema.getPropertyName());
    assertNull(actualDublinCoreSchema.getContributors());
    assertNull(actualDublinCoreSchema.getCreators());
    assertNull(actualDublinCoreSchema.getDescriptionLanguages());
    assertNull(actualDublinCoreSchema.getLanguages());
    assertNull(actualDublinCoreSchema.getPublishers());
    assertNull(actualDublinCoreSchema.getRelations());
    assertNull(actualDublinCoreSchema.getRightsLanguages());
    assertNull(actualDublinCoreSchema.getSubjects());
    assertNull(actualDublinCoreSchema.getTitleLanguages());
    assertNull(actualDublinCoreSchema.getTypes());
    assertNull(actualDublinCoreSchema.getDates());
    assertNull(actualDublinCoreSchema.getContributorsProperty());
    assertNull(actualDublinCoreSchema.getCreatorsProperty());
    assertNull(actualDublinCoreSchema.getDatesProperty());
    assertNull(actualDublinCoreSchema.getDescriptionProperty());
    assertNull(actualDublinCoreSchema.getLanguagesProperty());
    assertNull(actualDublinCoreSchema.getPublishersProperty());
    assertNull(actualDublinCoreSchema.getRelationsProperty());
    assertNull(actualDublinCoreSchema.getRightsProperty());
    assertNull(actualDublinCoreSchema.getSubjectsProperty());
    assertNull(actualDublinCoreSchema.getTitleProperty());
    assertNull(actualDublinCoreSchema.getTypesProperty());
    assertNull(actualDublinCoreSchema.getAboutAttribute());
    assertNull(actualDublinCoreSchema.getCoverageProperty());
    assertNull(actualDublinCoreSchema.getFormatProperty());
    assertNull(actualDublinCoreSchema.getIdentifierProperty());
    assertNull(actualDublinCoreSchema.getSourceProperty());
    List<AbstractField> allProperties = actualDublinCoreSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualDublinCoreSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualDublinCoreSchema.getContainer().getAllProperties());
    assertSame(metadata, actualDublinCoreSchema.getMetadata());
  }
}

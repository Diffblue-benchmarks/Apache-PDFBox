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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DublinCoreSchemaDiffblueTest {
  /**
   * Test {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new DublinCoreSchema(XMPMetadata)")
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
   * Test {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata, String)}.
   * <p>
   * Method under test:
   * {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName("Test new DublinCoreSchema(XMPMetadata, String)")
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
   * Test {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata, String)}.
   * <p>
   * Method under test:
   * {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName("Test new DublinCoreSchema(XMPMetadata, String)")
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

  /**
   * Test {@link DublinCoreSchema#addContributor(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addContributor(String)}
   */
  @Test
  @DisplayName("Test addContributor(String)")
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
    assertEquals("Proper Name", ((TextType) getResult).getStringValue());
    assertEquals("Proper Name", ((TextType) getResult).getRawValue());
    assertEquals("Proper Name", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", contributorsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", contributorsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Bag, contributorsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(contributorsProperty.getAllAttributes().isEmpty());
    assertTrue(contributorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(contributors, contributorsProperty.getElementsAsString());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, contributorsProperty.getPropertyName());
    assertSame(contributorsProperty, allProperties2.get(0));
    assertSame(allProperties, contributorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, contributorsProperty.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#addContributor(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addContributor(String)}
   */
  @Test
  @DisplayName("Test addContributor(String)")
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
    assertEquals(1, dublinCoreSchema.getAllProperties().size());
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
    assertSame(allProperties, contributorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, contributorsProperty.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#addContributor(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addContributor(String)}
   */
  @Test
  @DisplayName("Test addContributor(String)")
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
    assertEquals(2, dublinCoreSchema.getAllProperties().size());
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
    assertSame(allProperties, contributorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, contributorsProperty.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#addContributor(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addContributor(String)}
   */
  @Test
  @DisplayName("Test addContributor(String)")
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
    assertEquals("Proper Name", ((TextType) getResult).getStringValue());
    assertEquals("Proper Name", ((TextType) getResult).getRawValue());
    assertEquals("Proper Name", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("dc", contributorsProperty.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://purl.org/dc/elements/1.1/", contributorsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    List<AbstractField> allProperties2 = dublinCoreSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Bag, contributorsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(contributorsProperty.getAllAttributes().isEmpty());
    assertTrue(contributorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(contributors, contributorsProperty.getElementsAsString());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, contributorsProperty.getPropertyName());
    assertSame(contributorsProperty, allProperties2.get(1));
    assertSame(allProperties, contributorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, contributorsProperty.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#addContributor(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addContributor(String)}
   */
  @Test
  @DisplayName("Test addContributor(String)")
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
    assertEquals(contributors, contributorsProperty.getElementsAsString());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, contributorsProperty.getPropertyName());
    assertSame(contributorsProperty, allProperties2.get(2));
    assertSame(allProperties, contributorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, contributorsProperty.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#removeContributor(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#removeContributor(String)}
   */
  @Test
  @DisplayName("Test removeContributor(String)")
  void testRemoveContributor() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());

    // Act
    dublinCoreSchema.removeContributor("Proper Name");

    // Assert that nothing has changed
    assertNull(dublinCoreSchema.getContributors());
  }

  /**
   * Test {@link DublinCoreSchema#removeContributor(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#removeContributor(String)}
   */
  @Test
  @DisplayName("Test removeContributor(String)")
  void testRemoveContributor2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.CONTRIBUTOR);

    // Act
    dublinCoreSchema.removeContributor("Proper Name");

    // Assert that nothing has changed
    List<AbstractField> allProperties = dublinCoreSchema.getContributorsProperty().getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> contributors = dublinCoreSchema.getContributors();
    assertEquals(1, contributors.size());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, contributors.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getValue());
  }

  /**
   * Test {@link DublinCoreSchema#removeContributor(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#removeContributor(String)}
   */
  @Test
  @DisplayName("Test removeContributor(String)")
  void testRemoveContributor3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor("Proper Name");
    dublinCoreSchema.addContributor(DublinCoreSchema.CONTRIBUTOR);

    // Act
    dublinCoreSchema.removeContributor("Proper Name");

    // Assert
    List<AbstractField> allProperties = dublinCoreSchema.getContributorsProperty().getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> contributors = dublinCoreSchema.getContributors();
    assertEquals(1, contributors.size());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, contributors.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getValue());
  }

  /**
   * Test {@link DublinCoreSchema#removeContributor(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#removeContributor(String)}
   */
  @Test
  @DisplayName("Test removeContributor(String)")
  void testRemoveContributor4() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator("Proper Name");
    dublinCoreSchema.addContributor(DublinCoreSchema.CONTRIBUTOR);

    // Act
    dublinCoreSchema.removeContributor("Proper Name");

    // Assert that nothing has changed
    List<AbstractField> allProperties = dublinCoreSchema.getContributorsProperty().getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> contributors = dublinCoreSchema.getContributors();
    assertEquals(1, contributors.size());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, contributors.get(0));
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getStringValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getRawValue());
    assertEquals(DublinCoreSchema.CONTRIBUTOR, ((TextType) getResult).getValue());
  }

  /**
   * Test {@link DublinCoreSchema#setCoverage(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setCoverage(String)}
   */
  @Test
  @DisplayName("Test setCoverage(String)")
  void testSetCoverage() {
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
   * Test {@link DublinCoreSchema#setCoverage(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setCoverage(String)}
   */
  @Test
  @DisplayName("Test setCoverage(String)")
  void testSetCoverage2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.COVERAGE);

    // Act
    dublinCoreSchema.setCoverage("Text");

    // Assert
    assertEquals(3, dublinCoreSchema.getAllProperties().size());
  }

  /**
   * Test {@link DublinCoreSchema#setCoverage(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setCoverage(String)}
   */
  @Test
  @DisplayName("Test setCoverage(String)")
  void testSetCoverage3() {
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
   * Test {@link DublinCoreSchema#setCoverage(String)}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#setCoverage(String)}
   */
  @Test
  @DisplayName("Test setCoverage(String); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testSetCoverage_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
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
   * Test {@link DublinCoreSchema#setCoverageProperty(TextType)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setCoverageProperty(TextType)}
   */
  @Test
  @DisplayName("Test setCoverageProperty(TextType)")
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
   * Test {@link DublinCoreSchema#setCoverageProperty(TextType)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setCoverageProperty(TextType)}
   */
  @Test
  @DisplayName("Test setCoverageProperty(TextType)")
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
   * Test {@link DublinCoreSchema#setCoverageProperty(TextType)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setCoverageProperty(TextType)}
   */
  @Test
  @DisplayName("Test setCoverageProperty(TextType)")
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
   * Test {@link DublinCoreSchema#setCoverageProperty(TextType)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setCoverageProperty(TextType)}
   */
  @Test
  @DisplayName("Test setCoverageProperty(TextType)")
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
   * Test {@link DublinCoreSchema#addCreator(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addCreator(String)}
   */
  @Test
  @DisplayName("Test addCreator(String)")
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
    assertEquals(creators, creatorsProperty.getElementsAsString());
    assertEquals(DublinCoreSchema.CREATOR, creatorsProperty.getPropertyName());
    assertSame(creatorsProperty, allProperties2.get(0));
    assertSame(allProperties, creatorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, creatorsProperty.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#addCreator(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addCreator(String)}
   */
  @Test
  @DisplayName("Test addCreator(String)")
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
    assertEquals(creators, creatorsProperty.getElementsAsString());
    assertEquals(DublinCoreSchema.CREATOR, creatorsProperty.getPropertyName());
    assertSame(creatorsProperty, allProperties2.get(1));
    assertSame(allProperties, creatorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, creatorsProperty.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#addCreator(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addCreator(String)}
   */
  @Test
  @DisplayName("Test addCreator(String)")
  void testAddCreator3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.CREATOR);

    // Act
    dublinCoreSchema.addCreator("Proper Name");

    // Assert
    List<AbstractField> allProperties = dublinCoreSchema.getCreatorsProperty().getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<String> creators = dublinCoreSchema.getCreators();
    assertEquals(2, creators.size());
    assertEquals("Proper Name", creators.get(1));
    assertEquals("Proper Name", ((TextType) getResult).getStringValue());
    assertEquals("Proper Name", ((TextType) getResult).getRawValue());
    assertEquals("Proper Name", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals(2, dublinCoreSchema.getAllProperties().size());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#addCreator(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addCreator(String)}
   */
  @Test
  @DisplayName("Test addCreator(String)")
  void testAddCreator4() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addDate(new GregorianCalendar(1, 1, 1));
    dublinCoreSchema.addContributor(DublinCoreSchema.CREATOR);

    // Act
    dublinCoreSchema.addCreator("Proper Name");

    // Assert
    assertEquals(3, dublinCoreSchema.getAllProperties().size());
  }

  /**
   * Test {@link DublinCoreSchema#addDate(Calendar)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addDate(Calendar)}
   */
  @Test
  @DisplayName("Test addDate(Calendar)")
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
   * Test {@link DublinCoreSchema#addDate(Calendar)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addDate(Calendar)}
   */
  @Test
  @DisplayName("Test addDate(Calendar)")
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
   * Test {@link DublinCoreSchema#addDate(Calendar)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addDate(Calendar)}
   */
  @Test
  @DisplayName("Test addDate(Calendar)")
  void testAddDate3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator("RDF");
    dublinCoreSchema.addContributor(DublinCoreSchema.DATE);

    // Act
    dublinCoreSchema.addDate(new GregorianCalendar(1, 1, 1));

    // Assert
    assertEquals(3, dublinCoreSchema.getAllProperties().size());
  }

  /**
   * Test {@link DublinCoreSchema#addDate(Calendar)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addDate(Calendar)}
   */
  @Test
  @DisplayName("Test addDate(Calendar)")
  void testAddDate4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addDate(new GregorianCalendar(1, 1, 1));
    dublinCoreSchema.addContributor(DublinCoreSchema.DATE);
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    dublinCoreSchema.addDate(date);

    // Assert
    ArrayProperty datesProperty = dublinCoreSchema.getDatesProperty();
    List<AbstractField> allProperties = datesProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof DateType);
    assertEquals("RDF", getResult.getPrefix());
    assertEquals("li", getResult.getPropertyName());
    assertNull(getResult.getNamespace());
    List<Calendar> dates = dublinCoreSchema.getDates();
    assertEquals(2, dates.size());
    assertEquals(2, dublinCoreSchema.getAllProperties().size());
    assertEquals(2, datesProperty.getElementsAsString().size());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(date, dates.get(1));
    assertSame(date, ((DateType) getResult).getRawValue());
    assertSame(date, ((DateType) getResult).getValue());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#removeDate(Calendar)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#removeDate(Calendar)}
   */
  @Test
  @DisplayName("Test removeDate(Calendar)")
  void testRemoveDate() {
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
   * Test {@link DublinCoreSchema#removeDate(Calendar)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#removeDate(Calendar)}
   */
  @Test
  @DisplayName("Test removeDate(Calendar)")
  void testRemoveDate2() {
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
   * Test {@link DublinCoreSchema#removeDate(Calendar)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#removeDate(Calendar)}
   */
  @Test
  @DisplayName("Test removeDate(Calendar)")
  void testRemoveDate3() {
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
   * Test {@link DublinCoreSchema#removeDate(Calendar)}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#removeDate(Calendar)}
   */
  @Test
  @DisplayName("Test removeDate(Calendar); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testRemoveDate_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());

    // Act
    dublinCoreSchema.removeDate(new GregorianCalendar(1, 1, 1));

    // Assert that nothing has changed
    assertNull(dublinCoreSchema.getDates());
  }

  /**
   * Test {@link DublinCoreSchema#removeDate(Calendar)}.
   * <ul>
   *   <li>Then {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with metadata
   * is createXMPMetadata Dates is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#removeDate(Calendar)}
   */
  @Test
  @DisplayName("Test removeDate(Calendar); then DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata Dates is 'null'")
  void testRemoveDate_thenDublinCoreSchemaWithMetadataIsCreateXMPMetadataDatesIsNull() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.DATE);

    // Act
    dublinCoreSchema.removeDate(new GregorianCalendar(1, 1, 1));

    // Assert that nothing has changed
    assertNull(dublinCoreSchema.getDates());
  }

  /**
   * Test {@link DublinCoreSchema#removeDate(Calendar)}.
   * <ul>
   *   <li>Then {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with metadata
   * is createXMPMetadata Dates size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#removeDate(Calendar)}
   */
  @Test
  @DisplayName("Test removeDate(Calendar); then DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata Dates size is one")
  void testRemoveDate_thenDublinCoreSchemaWithMetadataIsCreateXMPMetadataDatesSizeIsOne() {
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
   * Test {@link DublinCoreSchema#addDescription(String, String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addDescription(String, String)}
   */
  @Test
  @DisplayName("Test addDescription(String, String)")
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
    assertEquals(1, descriptionProperty.getElementsAsString().size());
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
   * Test {@link DublinCoreSchema#addDescription(String, String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addDescription(String, String)}
   */
  @Test
  @DisplayName("Test addDescription(String, String)")
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
    assertEquals(1, descriptionProperty.getElementsAsString().size());
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
   * Test {@link DublinCoreSchema#addDescription(String, String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addDescription(String, String)}
   */
  @Test
  @DisplayName("Test addDescription(String, String)")
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
    assertEquals(1, descriptionProperty.getElementsAsString().size());
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
   * Test {@link DublinCoreSchema#addDescription(String, String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addDescription(String, String)}
   */
  @Test
  @DisplayName("Test addDescription(String, String)")
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
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = descriptionProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> descriptionLanguages = dublinCoreSchema.getDescriptionLanguages();
    assertEquals(2, descriptionLanguages.size());
    assertEquals("Lang", descriptionLanguages.get(1));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#addDescription(String, String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addDescription(String, String)}
   */
  @Test
  @DisplayName("Test addDescription(String, String)")
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
    assertEquals(1, descriptionProperty.getElementsAsString().size());
    assertEquals(2, dublinCoreSchema.getAllProperties().size());
    assertEquals(Cardinality.Alt, descriptionProperty.getArrayType());
    assertTrue(descriptionProperty.getAllAttributes().isEmpty());
    assertTrue(descriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.DESCRIPTION, descriptionProperty.getPropertyName());
    assertSame(allProperties, descriptionProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, descriptionProperty.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#addDescription(String, String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addDescription(String, String)}
   */
  @Test
  @DisplayName("Test addDescription(String, String)")
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
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = descriptionProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> descriptionLanguages = dublinCoreSchema.getDescriptionLanguages();
    assertEquals(2, descriptionLanguages.size());
    assertEquals("Lang", descriptionLanguages.get(1));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#setDescription(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setDescription(String)}
   */
  @Test
  @DisplayName("Test setDescription(String)")
  void testSetDescription() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());

    // Act
    dublinCoreSchema.setDescription("42");

    // Assert
    List<String> descriptionLanguages = dublinCoreSchema.getDescriptionLanguages();
    assertEquals(1, descriptionLanguages.size());
    assertEquals("x-default", descriptionLanguages.get(0));
    assertEquals(1, dublinCoreSchema.getAllProperties().size());
  }

  /**
   * Test {@link DublinCoreSchema#setDescription(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setDescription(String)}
   */
  @Test
  @DisplayName("Test setDescription(String)")
  void testSetDescription2() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act
    dublinCoreSchema.setDescription("42");

    // Assert
    List<String> descriptionLanguages = dublinCoreSchema.getDescriptionLanguages();
    assertEquals(1, descriptionLanguages.size());
    assertEquals("x-default", descriptionLanguages.get(0));
    assertEquals(2, dublinCoreSchema.getAllProperties().size());
  }

  /**
   * Test {@link DublinCoreSchema#setDescription(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setDescription(String)}
   */
  @Test
  @DisplayName("Test setDescription(String)")
  void testSetDescription3() {
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
    assertEquals(1, descriptionProperty.getElementsAsString().size());
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
   * Test {@link DublinCoreSchema#setDescription(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setDescription(String)}
   */
  @Test
  @DisplayName("Test setDescription(String)")
  void testSetDescription4() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
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
    assertEquals(1, dublinCoreSchema.getDescriptionLanguages().size());
    assertEquals(1, getResult.getAllAttributes().size());
    assertEquals(1, descriptionProperty.getElementsAsString().size());
  }

  /**
   * Test {@link DublinCoreSchema#setDescription(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setDescription(String)}
   */
  @Test
  @DisplayName("Test setDescription(String)")
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
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = descriptionProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<String> descriptionLanguages = dublinCoreSchema.getDescriptionLanguages();
    assertEquals(2, descriptionLanguages.size());
    assertEquals(DublinCoreSchema.DESCRIPTION, descriptionLanguages.get(1));
    assertEquals(DublinCoreSchema.DESCRIPTION, getResult2.getValue());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#setFormat(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setFormat(String)}
   */
  @Test
  @DisplayName("Test setFormat(String)")
  void testSetFormat() {
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
   * Test {@link DublinCoreSchema#setFormat(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setFormat(String)}
   */
  @Test
  @DisplayName("Test setFormat(String)")
  void testSetFormat2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.FORMAT);

    // Act
    dublinCoreSchema.setFormat("Mime Type");

    // Assert
    assertEquals(3, dublinCoreSchema.getAllProperties().size());
  }

  /**
   * Test {@link DublinCoreSchema#setFormat(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setFormat(String)}
   */
  @Test
  @DisplayName("Test setFormat(String)")
  void testSetFormat3() {
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
   * Test {@link DublinCoreSchema#setFormat(String)}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#setFormat(String)}
   */
  @Test
  @DisplayName("Test setFormat(String); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testSetFormat_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
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
   * Test {@link DublinCoreSchema#setIdentifier(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setIdentifier(String)}
   */
  @Test
  @DisplayName("Test setIdentifier(String)")
  void testSetIdentifier() {
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
   * Test {@link DublinCoreSchema#setIdentifier(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setIdentifier(String)}
   */
  @Test
  @DisplayName("Test setIdentifier(String)")
  void testSetIdentifier2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.IDENTIFIER);

    // Act
    dublinCoreSchema.setIdentifier("Text");

    // Assert
    assertEquals(3, dublinCoreSchema.getAllProperties().size());
  }

  /**
   * Test {@link DublinCoreSchema#setIdentifier(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setIdentifier(String)}
   */
  @Test
  @DisplayName("Test setIdentifier(String)")
  void testSetIdentifier3() {
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
   * Test {@link DublinCoreSchema#setIdentifier(String)}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#setIdentifier(String)}
   */
  @Test
  @DisplayName("Test setIdentifier(String); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testSetIdentifier_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
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
   * Test {@link DublinCoreSchema#setIdentifierProperty(TextType)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setIdentifierProperty(TextType)}
   */
  @Test
  @DisplayName("Test setIdentifierProperty(TextType)")
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
   * Test {@link DublinCoreSchema#setIdentifierProperty(TextType)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setIdentifierProperty(TextType)}
   */
  @Test
  @DisplayName("Test setIdentifierProperty(TextType)")
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
   * Test {@link DublinCoreSchema#setIdentifierProperty(TextType)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setIdentifierProperty(TextType)}
   */
  @Test
  @DisplayName("Test setIdentifierProperty(TextType)")
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
   * Test {@link DublinCoreSchema#setIdentifierProperty(TextType)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setIdentifierProperty(TextType)}
   */
  @Test
  @DisplayName("Test setIdentifierProperty(TextType)")
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
   * Test {@link DublinCoreSchema#addLanguage(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addLanguage(String)}
   */
  @Test
  @DisplayName("Test addLanguage(String)")
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
   * Test {@link DublinCoreSchema#addLanguage(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addLanguage(String)}
   */
  @Test
  @DisplayName("Test addLanguage(String)")
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
   * Test {@link DublinCoreSchema#addLanguage(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addLanguage(String)}
   */
  @Test
  @DisplayName("Test addLanguage(String)")
  void testAddLanguage3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.LANGUAGE);

    // Act
    dublinCoreSchema.addLanguage("en");

    // Assert
    assertEquals(3, dublinCoreSchema.getAllProperties().size());
  }

  /**
   * Test {@link DublinCoreSchema#addLanguage(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addLanguage(String)}
   */
  @Test
  @DisplayName("Test addLanguage(String)")
  void testAddLanguage4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addLanguage(DublinCoreSchema.LANGUAGE);
    dublinCoreSchema.addContributor(DublinCoreSchema.LANGUAGE);

    // Act
    dublinCoreSchema.addLanguage("en");

    // Assert
    List<AbstractField> allProperties = dublinCoreSchema.getLanguagesProperty().getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    assertEquals("dc", getResult.getPrefix());
    List<String> languages = dublinCoreSchema.getLanguages();
    assertEquals(2, languages.size());
    assertEquals("en", languages.get(1));
    assertEquals("en", ((TextType) getResult).getStringValue());
    assertEquals("en", ((TextType) getResult).getRawValue());
    assertEquals("en", ((TextType) getResult).getValue());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals(2, dublinCoreSchema.getAllProperties().size());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#removeLanguage(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#removeLanguage(String)}
   */
  @Test
  @DisplayName("Test removeLanguage(String)")
  void testRemoveLanguage() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.LANGUAGE);

    // Act
    dublinCoreSchema.removeLanguage("en");

    // Assert that nothing has changed
    assertNull(dublinCoreSchema.getLanguages());
  }

  /**
   * Test {@link DublinCoreSchema#removeLanguage(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#removeLanguage(String)}
   */
  @Test
  @DisplayName("Test removeLanguage(String)")
  void testRemoveLanguage2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addLanguage(DublinCoreSchema.LANGUAGE);
    dublinCoreSchema.addContributor(DublinCoreSchema.LANGUAGE);

    // Act
    dublinCoreSchema.removeLanguage("en");

    // Assert that nothing has changed
    assertEquals(1, dublinCoreSchema.getLanguagesProperty().getAllProperties().size());
  }

  /**
   * Test {@link DublinCoreSchema#removeLanguage(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#removeLanguage(String)}
   */
  @Test
  @DisplayName("Test removeLanguage(String)")
  void testRemoveLanguage3() {
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
   * Test {@link DublinCoreSchema#removeLanguage(String)}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#removeLanguage(String)}
   */
  @Test
  @DisplayName("Test removeLanguage(String); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testRemoveLanguage_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());

    // Act
    dublinCoreSchema.removeLanguage("en");

    // Assert that nothing has changed
    assertNull(dublinCoreSchema.getLanguages());
  }

  /**
   * Test {@link DublinCoreSchema#addPublisher(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addPublisher(String)}
   */
  @Test
  @DisplayName("Test addPublisher(String)")
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
    assertEquals(publishers, publishersProperty.getElementsAsString());
    assertEquals(DublinCoreSchema.PUBLISHER, publishersProperty.getPropertyName());
    assertSame(publishersProperty, allProperties2.get(0));
    assertSame(allProperties, publishersProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, publishersProperty.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#addPublisher(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addPublisher(String)}
   */
  @Test
  @DisplayName("Test addPublisher(String)")
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
    assertEquals(publishers, publishersProperty.getElementsAsString());
    assertEquals(DublinCoreSchema.PUBLISHER, publishersProperty.getPropertyName());
    assertSame(publishersProperty, allProperties2.get(1));
    assertSame(allProperties, publishersProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, publishersProperty.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#addPublisher(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addPublisher(String)}
   */
  @Test
  @DisplayName("Test addPublisher(String)")
  void testAddPublisher3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.PUBLISHER);

    // Act
    dublinCoreSchema.addPublisher("Proper Name");

    // Assert
    assertEquals(3, dublinCoreSchema.getAllProperties().size());
  }

  /**
   * Test {@link DublinCoreSchema#addPublisher(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addPublisher(String)}
   */
  @Test
  @DisplayName("Test addPublisher(String)")
  void testAddPublisher4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addPublisher(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.PUBLISHER);

    // Act
    dublinCoreSchema.addPublisher("Proper Name");

    // Assert
    List<AbstractField> allProperties = dublinCoreSchema.getPublishersProperty().getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<String> publishers = dublinCoreSchema.getPublishers();
    assertEquals(2, publishers.size());
    assertEquals("Proper Name", publishers.get(1));
    assertEquals("Proper Name", ((TextType) getResult).getStringValue());
    assertEquals("Proper Name", ((TextType) getResult).getRawValue());
    assertEquals("Proper Name", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals(2, dublinCoreSchema.getAllProperties().size());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#addRelation(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addRelation(String)}
   */
  @Test
  @DisplayName("Test addRelation(String)")
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
    assertEquals(relations, relationsProperty.getElementsAsString());
    assertEquals(DublinCoreSchema.RELATION, relationsProperty.getPropertyName());
    assertSame(relationsProperty, allProperties2.get(0));
    assertSame(allProperties, relationsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, relationsProperty.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#addRelation(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addRelation(String)}
   */
  @Test
  @DisplayName("Test addRelation(String)")
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
    assertEquals(relations, relationsProperty.getElementsAsString());
    assertEquals(DublinCoreSchema.RELATION, relationsProperty.getPropertyName());
    assertSame(relationsProperty, allProperties2.get(1));
    assertSame(allProperties, relationsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, relationsProperty.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#addRelation(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addRelation(String)}
   */
  @Test
  @DisplayName("Test addRelation(String)")
  void testAddRelation3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.RELATION);

    // Act
    dublinCoreSchema.addRelation("Text");

    // Assert
    assertEquals(3, dublinCoreSchema.getAllProperties().size());
  }

  /**
   * Test {@link DublinCoreSchema#addRelation(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addRelation(String)}
   */
  @Test
  @DisplayName("Test addRelation(String)")
  void testAddRelation4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addRelation(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.RELATION);

    // Act
    dublinCoreSchema.addRelation("Text");

    // Assert
    List<AbstractField> allProperties = dublinCoreSchema.getRelationsProperty().getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<String> relations = dublinCoreSchema.getRelations();
    assertEquals(2, relations.size());
    assertEquals("Text", relations.get(1));
    assertEquals("Text", ((TextType) getResult).getStringValue());
    assertEquals("Text", ((TextType) getResult).getRawValue());
    assertEquals("Text", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals(2, dublinCoreSchema.getAllProperties().size());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#addRights(String, String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addRights(String, String)}
   */
  @Test
  @DisplayName("Test addRights(String, String)")
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
    assertEquals(1, rightsProperty.getElementsAsString().size());
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
   * Test {@link DublinCoreSchema#addRights(String, String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addRights(String, String)}
   */
  @Test
  @DisplayName("Test addRights(String, String)")
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
    assertEquals(1, rightsProperty.getElementsAsString().size());
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
   * Test {@link DublinCoreSchema#addRights(String, String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addRights(String, String)}
   */
  @Test
  @DisplayName("Test addRights(String, String)")
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
    assertEquals(1, rightsProperty.getElementsAsString().size());
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
   * Test {@link DublinCoreSchema#addRights(String, String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addRights(String, String)}
   */
  @Test
  @DisplayName("Test addRights(String, String)")
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
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = rightsProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> rightsLanguages = dublinCoreSchema.getRightsLanguages();
    assertEquals(2, rightsLanguages.size());
    assertEquals("Lang", rightsLanguages.get(1));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#addRights(String, String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addRights(String, String)}
   */
  @Test
  @DisplayName("Test addRights(String, String)")
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
    assertEquals(1, rightsProperty.getElementsAsString().size());
    assertEquals(2, dublinCoreSchema.getAllProperties().size());
    assertEquals(Cardinality.Alt, rightsProperty.getArrayType());
    assertTrue(rightsProperty.getAllAttributes().isEmpty());
    assertTrue(rightsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.RIGHTS, rightsProperty.getPropertyName());
    assertSame(allProperties, rightsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, rightsProperty.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#addRights(String, String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addRights(String, String)}
   */
  @Test
  @DisplayName("Test addRights(String, String)")
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
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = rightsProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> rightsLanguages = dublinCoreSchema.getRightsLanguages();
    assertEquals(2, rightsLanguages.size());
    assertEquals("Lang", rightsLanguages.get(1));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#setSource(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setSource(String)}
   */
  @Test
  @DisplayName("Test setSource(String)")
  void testSetSource() {
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
   * Test {@link DublinCoreSchema#setSource(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setSource(String)}
   */
  @Test
  @DisplayName("Test setSource(String)")
  void testSetSource2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.SOURCE);

    // Act
    dublinCoreSchema.setSource("Text");

    // Assert
    assertEquals(3, dublinCoreSchema.getAllProperties().size());
  }

  /**
   * Test {@link DublinCoreSchema#setSource(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setSource(String)}
   */
  @Test
  @DisplayName("Test setSource(String)")
  void testSetSource3() {
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
   * Test {@link DublinCoreSchema#setSource(String)}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#setSource(String)}
   */
  @Test
  @DisplayName("Test setSource(String); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testSetSource_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
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
   * Test {@link DublinCoreSchema#setSourceProperty(TextType)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setSourceProperty(TextType)}
   */
  @Test
  @DisplayName("Test setSourceProperty(TextType)")
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
   * Test {@link DublinCoreSchema#setSourceProperty(TextType)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setSourceProperty(TextType)}
   */
  @Test
  @DisplayName("Test setSourceProperty(TextType)")
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
   * Test {@link DublinCoreSchema#setSourceProperty(TextType)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setSourceProperty(TextType)}
   */
  @Test
  @DisplayName("Test setSourceProperty(TextType)")
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
   * Test {@link DublinCoreSchema#setSourceProperty(TextType)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setSourceProperty(TextType)}
   */
  @Test
  @DisplayName("Test setSourceProperty(TextType)")
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
   * Test {@link DublinCoreSchema#setFormatProperty(MIMEType)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setFormatProperty(MIMEType)}
   */
  @Test
  @DisplayName("Test setFormatProperty(MIMEType)")
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
   * Test {@link DublinCoreSchema#setFormatProperty(MIMEType)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setFormatProperty(MIMEType)}
   */
  @Test
  @DisplayName("Test setFormatProperty(MIMEType)")
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
   * Test {@link DublinCoreSchema#setFormatProperty(MIMEType)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setFormatProperty(MIMEType)}
   */
  @Test
  @DisplayName("Test setFormatProperty(MIMEType)")
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
   * Test {@link DublinCoreSchema#setFormatProperty(MIMEType)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setFormatProperty(MIMEType)}
   */
  @Test
  @DisplayName("Test setFormatProperty(MIMEType)")
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
   * Test {@link DublinCoreSchema#addSubject(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addSubject(String)}
   */
  @Test
  @DisplayName("Test addSubject(String)")
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
    assertEquals(subjects, subjectsProperty.getElementsAsString());
    assertEquals(DublinCoreSchema.SUBJECT, subjectsProperty.getPropertyName());
    assertSame(subjectsProperty, allProperties2.get(0));
    assertSame(allProperties, subjectsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, subjectsProperty.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#addSubject(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addSubject(String)}
   */
  @Test
  @DisplayName("Test addSubject(String)")
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
    assertEquals(subjects, subjectsProperty.getElementsAsString());
    assertEquals(DublinCoreSchema.SUBJECT, subjectsProperty.getPropertyName());
    assertSame(subjectsProperty, allProperties2.get(1));
    assertSame(allProperties, subjectsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, subjectsProperty.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#addSubject(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addSubject(String)}
   */
  @Test
  @DisplayName("Test addSubject(String)")
  void testAddSubject3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.SUBJECT);

    // Act
    dublinCoreSchema.addSubject("Text");

    // Assert
    assertEquals(3, dublinCoreSchema.getAllProperties().size());
  }

  /**
   * Test {@link DublinCoreSchema#addSubject(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addSubject(String)}
   */
  @Test
  @DisplayName("Test addSubject(String)")
  void testAddSubject4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addSubject(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.SUBJECT);

    // Act
    dublinCoreSchema.addSubject("Text");

    // Assert
    List<AbstractField> allProperties = dublinCoreSchema.getSubjectsProperty().getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<String> subjects = dublinCoreSchema.getSubjects();
    assertEquals(2, subjects.size());
    assertEquals("Text", subjects.get(1));
    assertEquals("Text", ((TextType) getResult).getStringValue());
    assertEquals("Text", ((TextType) getResult).getRawValue());
    assertEquals("Text", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals(2, dublinCoreSchema.getAllProperties().size());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#setTitle(String, String)} with {@code lang},
   * {@code value}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setTitle(String, String)}
   */
  @Test
  @DisplayName("Test setTitle(String, String) with 'lang', 'value'")
  void testSetTitleWithLangValue() throws BadFieldValueException {
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
    assertEquals(1, titleProperty.getElementsAsString().size());
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
   * Test {@link DublinCoreSchema#setTitle(String, String)} with {@code lang},
   * {@code value}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setTitle(String, String)}
   */
  @Test
  @DisplayName("Test setTitle(String, String) with 'lang', 'value'")
  void testSetTitleWithLangValue2() throws BadFieldValueException {
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
    assertEquals(1, titleProperty.getElementsAsString().size());
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
   * Test {@link DublinCoreSchema#setTitle(String, String)} with {@code lang},
   * {@code value}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setTitle(String, String)}
   */
  @Test
  @DisplayName("Test setTitle(String, String) with 'lang', 'value'")
  void testSetTitleWithLangValue3() throws BadFieldValueException {
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
    assertEquals(1, titleProperty.getElementsAsString().size());
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
   * Test {@link DublinCoreSchema#setTitle(String, String)} with {@code lang},
   * {@code value}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setTitle(String, String)}
   */
  @Test
  @DisplayName("Test setTitle(String, String) with 'lang', 'value'")
  void testSetTitleWithLangValue4() throws BadFieldValueException {
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
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = titleProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> titleLanguages = dublinCoreSchema.getTitleLanguages();
    assertEquals(2, titleLanguages.size());
    assertEquals("Lang", titleLanguages.get(1));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#setTitle(String, String)} with {@code lang},
   * {@code value}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setTitle(String, String)}
   */
  @Test
  @DisplayName("Test setTitle(String, String) with 'lang', 'value'")
  void testSetTitleWithLangValue5() throws BadFieldValueException {
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
    assertEquals(1, titleProperty.getElementsAsString().size());
    assertEquals(2, dublinCoreSchema.getAllProperties().size());
    assertEquals(Cardinality.Alt, titleProperty.getArrayType());
    assertTrue(titleProperty.getAllAttributes().isEmpty());
    assertTrue(titleProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.TITLE, titleProperty.getPropertyName());
    assertSame(allProperties, titleProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, titleProperty.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#setTitle(String, String)} with {@code lang},
   * {@code value}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setTitle(String, String)}
   */
  @Test
  @DisplayName("Test setTitle(String, String) with 'lang', 'value'")
  void testSetTitleWithLangValue6() throws BadFieldValueException {
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
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = titleProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> titleLanguages = dublinCoreSchema.getTitleLanguages();
    assertEquals(2, titleLanguages.size());
    assertEquals("Lang", titleLanguages.get(1));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#setTitle(String)} with {@code value}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setTitle(String)}
   */
  @Test
  @DisplayName("Test setTitle(String) with 'value'")
  void testSetTitleWithValue() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());

    // Act
    dublinCoreSchema.setTitle("42");

    // Assert
    List<String> titleLanguages = dublinCoreSchema.getTitleLanguages();
    assertEquals(1, titleLanguages.size());
    assertEquals("x-default", titleLanguages.get(0));
    assertEquals(1, dublinCoreSchema.getAllProperties().size());
  }

  /**
   * Test {@link DublinCoreSchema#setTitle(String)} with {@code value}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setTitle(String)}
   */
  @Test
  @DisplayName("Test setTitle(String) with 'value'")
  void testSetTitleWithValue2() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act
    dublinCoreSchema.setTitle("42");

    // Assert
    List<String> titleLanguages = dublinCoreSchema.getTitleLanguages();
    assertEquals(1, titleLanguages.size());
    assertEquals("x-default", titleLanguages.get(0));
    assertEquals(2, dublinCoreSchema.getAllProperties().size());
  }

  /**
   * Test {@link DublinCoreSchema#setTitle(String)} with {@code value}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setTitle(String)}
   */
  @Test
  @DisplayName("Test setTitle(String) with 'value'")
  void testSetTitleWithValue3() {
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
    assertEquals(1, titleProperty.getElementsAsString().size());
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
   * Test {@link DublinCoreSchema#setTitle(String)} with {@code value}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setTitle(String)}
   */
  @Test
  @DisplayName("Test setTitle(String) with 'value'")
  void testSetTitleWithValue4() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
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
    assertEquals(1, dublinCoreSchema.getTitleLanguages().size());
    assertEquals(1, getResult.getAllAttributes().size());
    assertEquals(1, titleProperty.getElementsAsString().size());
  }

  /**
   * Test {@link DublinCoreSchema#setTitle(String)} with {@code value}.
   * <p>
   * Method under test: {@link DublinCoreSchema#setTitle(String)}
   */
  @Test
  @DisplayName("Test setTitle(String) with 'value'")
  void testSetTitleWithValue5() throws BadFieldValueException {
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
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = titleProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<String> titleLanguages = dublinCoreSchema.getTitleLanguages();
    assertEquals(2, titleLanguages.size());
    assertEquals(DublinCoreSchema.TITLE, titleLanguages.get(1));
    assertEquals(DublinCoreSchema.TITLE, getResult2.getValue());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#addTitle(String, String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addTitle(String, String)}
   */
  @Test
  @DisplayName("Test addTitle(String, String)")
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
    assertEquals(1, titleProperty.getElementsAsString().size());
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
   * Test {@link DublinCoreSchema#addTitle(String, String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addTitle(String, String)}
   */
  @Test
  @DisplayName("Test addTitle(String, String)")
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
    assertEquals(1, titleProperty.getElementsAsString().size());
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
   * Test {@link DublinCoreSchema#addTitle(String, String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addTitle(String, String)}
   */
  @Test
  @DisplayName("Test addTitle(String, String)")
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
    assertEquals(1, titleProperty.getElementsAsString().size());
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
   * Test {@link DublinCoreSchema#addTitle(String, String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addTitle(String, String)}
   */
  @Test
  @DisplayName("Test addTitle(String, String)")
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
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = titleProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> titleLanguages = dublinCoreSchema.getTitleLanguages();
    assertEquals(2, titleLanguages.size());
    assertEquals("Lang", titleLanguages.get(1));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#addTitle(String, String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addTitle(String, String)}
   */
  @Test
  @DisplayName("Test addTitle(String, String)")
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
    assertEquals(1, titleProperty.getElementsAsString().size());
    assertEquals(2, dublinCoreSchema.getAllProperties().size());
    assertEquals(Cardinality.Alt, titleProperty.getArrayType());
    assertTrue(titleProperty.getAllAttributes().isEmpty());
    assertTrue(titleProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.TITLE, titleProperty.getPropertyName());
    assertSame(allProperties, titleProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, titleProperty.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#addTitle(String, String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addTitle(String, String)}
   */
  @Test
  @DisplayName("Test addTitle(String, String)")
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
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = titleProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> titleLanguages = dublinCoreSchema.getTitleLanguages();
    assertEquals(2, titleLanguages.size());
    assertEquals("Lang", titleLanguages.get(1));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#addType(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addType(String)}
   */
  @Test
  @DisplayName("Test addType(String)")
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
    assertEquals(types, typesProperty.getElementsAsString());
    assertEquals(DublinCoreSchema.TYPE, typesProperty.getPropertyName());
    assertSame(typesProperty, allProperties2.get(0));
    assertSame(allProperties, typesProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, typesProperty.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#addType(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addType(String)}
   */
  @Test
  @DisplayName("Test addType(String)")
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
    assertEquals(types, typesProperty.getElementsAsString());
    assertEquals(DublinCoreSchema.TYPE, typesProperty.getPropertyName());
    assertSame(typesProperty, allProperties2.get(1));
    assertSame(allProperties, typesProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, typesProperty.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#addType(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addType(String)}
   */
  @Test
  @DisplayName("Test addType(String)")
  void testAddType3() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.TYPE);

    // Act
    dublinCoreSchema.addType("Type");

    // Assert
    assertEquals(3, dublinCoreSchema.getAllProperties().size());
  }

  /**
   * Test {@link DublinCoreSchema#addType(String)}.
   * <p>
   * Method under test: {@link DublinCoreSchema#addType(String)}
   */
  @Test
  @DisplayName("Test addType(String)")
  void testAddType4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(metadata);
    dublinCoreSchema.addType(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.TYPE);

    // Act
    dublinCoreSchema.addType("Type");

    // Assert
    List<AbstractField> allProperties = dublinCoreSchema.getTypesProperty().getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<String> types = dublinCoreSchema.getTypes();
    assertEquals(2, types.size());
    assertEquals("Type", types.get(1));
    assertEquals("Type", ((TextType) getResult).getStringValue());
    assertEquals("Type", ((TextType) getResult).getRawValue());
    assertEquals("Type", ((TextType) getResult).getValue());
    assertEquals("dc", getResult.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", getResult.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals(2, dublinCoreSchema.getAllProperties().size());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link DublinCoreSchema#getContributorsProperty()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getContributorsProperty()}
   */
  @Test
  @DisplayName("Test getContributorsProperty()")
  void testGetContributorsProperty() {
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
   * Test {@link DublinCoreSchema#getContributorsProperty()}.
   * <ul>
   *   <li>Then return AllProperties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getContributorsProperty()}
   */
  @Test
  @DisplayName("Test getContributorsProperty(); then return AllProperties size is one")
  void testGetContributorsProperty_thenReturnAllPropertiesSizeIsOne() {
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
   * Test {@link DublinCoreSchema#getContributorsProperty()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getContributorsProperty()}
   */
  @Test
  @DisplayName("Test getContributorsProperty(); then return 'null'")
  void testGetContributorsProperty_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getContributorsProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getContributors()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getContributors()}
   */
  @Test
  @DisplayName("Test getContributors()")
  void testGetContributors() {
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
   * Test {@link DublinCoreSchema#getContributors()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getContributors()}
   */
  @Test
  @DisplayName("Test getContributors(); then return 'null'")
  void testGetContributors_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getContributors());
  }

  /**
   * Test {@link DublinCoreSchema#getContributors()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getContributors()}
   */
  @Test
  @DisplayName("Test getContributors(); then return size is one")
  void testGetContributors_thenReturnSizeIsOne() {
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
   * Test {@link DublinCoreSchema#getCoverageProperty()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getCoverageProperty()}
   */
  @Test
  @DisplayName("Test getCoverageProperty()")
  void testGetCoverageProperty() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.COVERAGE);

    // Act and Assert
    assertNull(dublinCoreSchema.getCoverageProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getCoverageProperty()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getCoverageProperty()}
   */
  @Test
  @DisplayName("Test getCoverageProperty()")
  void testGetCoverageProperty2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.COVERAGE);

    // Act and Assert
    assertNull(dublinCoreSchema.getCoverageProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getCoverageProperty()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getCoverageProperty()}
   */
  @Test
  @DisplayName("Test getCoverageProperty(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetCoverageProperty_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getCoverageProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getCoverage()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getCoverage()}
   */
  @Test
  @DisplayName("Test getCoverage()")
  void testGetCoverage() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.COVERAGE);

    // Act and Assert
    assertNull(dublinCoreSchema.getCoverage());
  }

  /**
   * Test {@link DublinCoreSchema#getCoverage()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getCoverage()}
   */
  @Test
  @DisplayName("Test getCoverage()")
  void testGetCoverage2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.COVERAGE);

    // Act and Assert
    assertNull(dublinCoreSchema.getCoverage());
  }

  /**
   * Test {@link DublinCoreSchema#getCoverage()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getCoverage()}
   */
  @Test
  @DisplayName("Test getCoverage(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetCoverage_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getCoverage());
  }

  /**
   * Test {@link DublinCoreSchema#getCreatorsProperty()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getCreatorsProperty()}
   */
  @Test
  @DisplayName("Test getCreatorsProperty(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetCreatorsProperty_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getCreatorsProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getCreatorsProperty()}.
   * <ul>
   *   <li>Then return AllProperties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getCreatorsProperty()}
   */
  @Test
  @DisplayName("Test getCreatorsProperty(); then return AllProperties size is one")
  void testGetCreatorsProperty_thenReturnAllPropertiesSizeIsOne() {
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
   * Test {@link DublinCoreSchema#getCreatorsProperty()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getCreatorsProperty()}
   */
  @Test
  @DisplayName("Test getCreatorsProperty(); then return 'null'")
  void testGetCreatorsProperty_thenReturnNull() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.CREATOR);

    // Act and Assert
    assertNull(dublinCoreSchema.getCreatorsProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getCreators()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getCreators()}
   */
  @Test
  @DisplayName("Test getCreators(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetCreators_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getCreators());
  }

  /**
   * Test {@link DublinCoreSchema#getCreators()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getCreators()}
   */
  @Test
  @DisplayName("Test getCreators(); then return 'null'")
  void testGetCreators_thenReturnNull() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.CREATOR);

    // Act and Assert
    assertNull(dublinCoreSchema.getCreators());
  }

  /**
   * Test {@link DublinCoreSchema#getCreators()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getCreators()}
   */
  @Test
  @DisplayName("Test getCreators(); then return size is one")
  void testGetCreators_thenReturnSizeIsOne() {
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
   * Test {@link DublinCoreSchema#getDatesProperty()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getDatesProperty()}
   */
  @Test
  @DisplayName("Test getDatesProperty()")
  void testGetDatesProperty() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.DATE);

    // Act and Assert
    assertNull(dublinCoreSchema.getDatesProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getDatesProperty()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getDatesProperty()}
   */
  @Test
  @DisplayName("Test getDatesProperty(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetDatesProperty_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getDatesProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getDatesProperty()}.
   * <ul>
   *   <li>Then return AllProperties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getDatesProperty()}
   */
  @Test
  @DisplayName("Test getDatesProperty(); then return AllProperties size is one")
  void testGetDatesProperty_thenReturnAllPropertiesSizeIsOne() {
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
   * Test {@link DublinCoreSchema#getDatesProperty()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getDatesProperty()}
   */
  @Test
  @DisplayName("Test getDatesProperty(); then return 'null'")
  void testGetDatesProperty_thenReturnNull() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.DATE);

    // Act and Assert
    assertNull(dublinCoreSchema.getDatesProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getDates()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getDates()}
   */
  @Test
  @DisplayName("Test getDates(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  void testGetDates_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getDates());
  }

  /**
   * Test {@link DublinCoreSchema#getDates()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getDates()}
   */
  @Test
  @DisplayName("Test getDates(); then return Empty")
  void testGetDates_thenReturnEmpty() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addBagValueAsSimple(DublinCoreSchema.DATE, "42");

    // Act and Assert
    assertTrue(dublinCoreSchema.getDates().isEmpty());
  }

  /**
   * Test {@link DublinCoreSchema#getDates()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getDates()}
   */
  @Test
  @DisplayName("Test getDates(); then return 'null'")
  void testGetDates_thenReturnNull() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.DATE);

    // Act and Assert
    assertNull(dublinCoreSchema.getDates());
  }

  /**
   * Test {@link DublinCoreSchema#getDates()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getDates()}
   */
  @Test
  @DisplayName("Test getDates(); then return size is one")
  void testGetDates_thenReturnSizeIsOne() {
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
   * Test {@link DublinCoreSchema#getDescriptionProperty()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getDescriptionProperty()}
   */
  @Test
  @DisplayName("Test getDescriptionProperty()")
  void testGetDescriptionProperty() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act and Assert
    assertNull(dublinCoreSchema.getDescriptionProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getDescriptionProperty()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getDescriptionProperty()}
   */
  @Test
  @DisplayName("Test getDescriptionProperty(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetDescriptionProperty_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getDescriptionProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getDescriptionProperty()}.
   * <ul>
   *   <li>Then return AllProperties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getDescriptionProperty()}
   */
  @Test
  @DisplayName("Test getDescriptionProperty(); then return AllProperties size is one")
  void testGetDescriptionProperty_thenReturnAllPropertiesSizeIsOne() {
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
   * Test {@link DublinCoreSchema#getDescriptionProperty()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getDescriptionProperty()}
   */
  @Test
  @DisplayName("Test getDescriptionProperty(); then return 'null'")
  void testGetDescriptionProperty_thenReturnNull() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act and Assert
    assertNull(dublinCoreSchema.getDescriptionProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getDescriptionLanguages()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getDescriptionLanguages()}
   */
  @Test
  @DisplayName("Test getDescriptionLanguages(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetDescriptionLanguages_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata()
      throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getDescriptionLanguages());
  }

  /**
   * Test {@link DublinCoreSchema#getDescriptionLanguages()}.
   * <ul>
   *   <li>Then return first is {@link DublinCoreSchema#CONTRIBUTOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getDescriptionLanguages()}
   */
  @Test
  @DisplayName("Test getDescriptionLanguages(); then return first is CONTRIBUTOR")
  void testGetDescriptionLanguages_thenReturnFirstIsContributor() throws BadFieldValueException {
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
   * Test {@link DublinCoreSchema#getDescriptionLanguages()}.
   * <ul>
   *   <li>Then return first is {@code x-default}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getDescriptionLanguages()}
   */
  @Test
  @DisplayName("Test getDescriptionLanguages(); then return first is 'x-default'")
  void testGetDescriptionLanguages_thenReturnFirstIsXDefault() throws BadFieldValueException {
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
   * Test {@link DublinCoreSchema#getDescriptionLanguages()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getDescriptionLanguages()}
   */
  @Test
  @DisplayName("Test getDescriptionLanguages(); then return 'null'")
  void testGetDescriptionLanguages_thenReturnNull() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act and Assert
    assertNull(dublinCoreSchema.getDescriptionLanguages());
  }

  /**
   * Test {@link DublinCoreSchema#getDescription()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
  void testGetDescription() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act and Assert
    assertNull(dublinCoreSchema.getDescription());
  }

  /**
   * Test {@link DublinCoreSchema#getDescription()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
  void testGetDescription2() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addDescription(DublinCoreSchema.DESCRIPTION, "42");

    // Act and Assert
    assertNull(dublinCoreSchema.getDescription());
  }

  /**
   * Test {@link DublinCoreSchema#getDescription()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
  void testGetDescription3() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addBagValueAsSimple(DublinCoreSchema.DESCRIPTION, "42");

    // Act and Assert
    assertNull(dublinCoreSchema.getDescription());
  }

  /**
   * Test {@link DublinCoreSchema#getDescription(String)} with {@code String}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getDescription(String)}
   */
  @Test
  @DisplayName("Test getDescription(String) with 'String'")
  void testGetDescriptionWithString() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getDescription("Lang"));
  }

  /**
   * Test {@link DublinCoreSchema#getDescription(String)} with {@code String}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getDescription(String)}
   */
  @Test
  @DisplayName("Test getDescription(String) with 'String'")
  void testGetDescriptionWithString2() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act and Assert
    assertNull(dublinCoreSchema.getDescription("Lang"));
  }

  /**
   * Test {@link DublinCoreSchema#getDescription(String)} with {@code String}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getDescription(String)}
   */
  @Test
  @DisplayName("Test getDescription(String) with 'String'")
  void testGetDescriptionWithString3() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addDescription(DublinCoreSchema.CONTRIBUTOR, DublinCoreSchema.DESCRIPTION);
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act and Assert
    assertNull(dublinCoreSchema.getDescription("Lang"));
  }

  /**
   * Test {@link DublinCoreSchema#getDescription(String)} with {@code String}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getDescription(String)}
   */
  @Test
  @DisplayName("Test getDescription(String) with 'String'")
  void testGetDescriptionWithString4() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addBagValueAsSimple(DublinCoreSchema.DESCRIPTION, "42");

    // Act and Assert
    assertNull(dublinCoreSchema.getDescription("Lang"));
  }

  /**
   * Test {@link DublinCoreSchema#getDescription(String)} with {@code String}.
   * <ul>
   *   <li>Then return {@link DublinCoreSchema#DESCRIPTION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getDescription(String)}
   */
  @Test
  @DisplayName("Test getDescription(String) with 'String'; then return DESCRIPTION")
  void testGetDescriptionWithString_thenReturnDescription() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addDescription("Lang", DublinCoreSchema.DESCRIPTION);
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act and Assert
    assertEquals(DublinCoreSchema.DESCRIPTION, dublinCoreSchema.getDescription("Lang"));
  }

  /**
   * Test {@link DublinCoreSchema#getDescription()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetDescription_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getDescription());
  }

  /**
   * Test {@link DublinCoreSchema#getDescription()}.
   * <ul>
   *   <li>Then return {@link DublinCoreSchema#DESCRIPTION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription(); then return DESCRIPTION")
  void testGetDescription_thenReturnDescription() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addDescription("x-default", DublinCoreSchema.DESCRIPTION);
    dublinCoreSchema.addContributor(DublinCoreSchema.DESCRIPTION);

    // Act and Assert
    assertEquals(DublinCoreSchema.DESCRIPTION, dublinCoreSchema.getDescription());
  }

  /**
   * Test {@link DublinCoreSchema#getFormatProperty()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getFormatProperty()}
   */
  @Test
  @DisplayName("Test getFormatProperty()")
  void testGetFormatProperty() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.FORMAT);

    // Act and Assert
    assertNull(dublinCoreSchema.getFormatProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getFormatProperty()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getFormatProperty()}
   */
  @Test
  @DisplayName("Test getFormatProperty()")
  void testGetFormatProperty2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.FORMAT);

    // Act and Assert
    assertNull(dublinCoreSchema.getFormatProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getFormatProperty()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getFormatProperty()}
   */
  @Test
  @DisplayName("Test getFormatProperty(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetFormatProperty_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getFormatProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getFormat()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getFormat()}
   */
  @Test
  @DisplayName("Test getFormat()")
  void testGetFormat() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.FORMAT);

    // Act and Assert
    assertNull(dublinCoreSchema.getFormat());
  }

  /**
   * Test {@link DublinCoreSchema#getFormat()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getFormat()}
   */
  @Test
  @DisplayName("Test getFormat()")
  void testGetFormat2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.FORMAT);

    // Act and Assert
    assertNull(dublinCoreSchema.getFormat());
  }

  /**
   * Test {@link DublinCoreSchema#getFormat()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getFormat()}
   */
  @Test
  @DisplayName("Test getFormat(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetFormat_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getFormat());
  }

  /**
   * Test {@link DublinCoreSchema#getIdentifierProperty()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getIdentifierProperty()}
   */
  @Test
  @DisplayName("Test getIdentifierProperty()")
  void testGetIdentifierProperty() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.IDENTIFIER);

    // Act and Assert
    assertNull(dublinCoreSchema.getIdentifierProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getIdentifierProperty()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getIdentifierProperty()}
   */
  @Test
  @DisplayName("Test getIdentifierProperty()")
  void testGetIdentifierProperty2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.IDENTIFIER);

    // Act and Assert
    assertNull(dublinCoreSchema.getIdentifierProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getIdentifierProperty()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getIdentifierProperty()}
   */
  @Test
  @DisplayName("Test getIdentifierProperty(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetIdentifierProperty_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getIdentifierProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getIdentifier()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getIdentifier()}
   */
  @Test
  @DisplayName("Test getIdentifier()")
  void testGetIdentifier() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.IDENTIFIER);

    // Act and Assert
    assertNull(dublinCoreSchema.getIdentifier());
  }

  /**
   * Test {@link DublinCoreSchema#getIdentifier()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getIdentifier()}
   */
  @Test
  @DisplayName("Test getIdentifier()")
  void testGetIdentifier2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.IDENTIFIER);

    // Act and Assert
    assertNull(dublinCoreSchema.getIdentifier());
  }

  /**
   * Test {@link DublinCoreSchema#getIdentifier()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getIdentifier()}
   */
  @Test
  @DisplayName("Test getIdentifier(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetIdentifier_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getIdentifier());
  }

  /**
   * Test {@link DublinCoreSchema#getLanguagesProperty()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getLanguagesProperty()}
   */
  @Test
  @DisplayName("Test getLanguagesProperty()")
  void testGetLanguagesProperty() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.LANGUAGE);

    // Act and Assert
    assertNull(dublinCoreSchema.getLanguagesProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getLanguagesProperty()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getLanguagesProperty()}
   */
  @Test
  @DisplayName("Test getLanguagesProperty(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetLanguagesProperty_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getLanguagesProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getLanguagesProperty()}.
   * <ul>
   *   <li>Then return AllProperties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getLanguagesProperty()}
   */
  @Test
  @DisplayName("Test getLanguagesProperty(); then return AllProperties size is one")
  void testGetLanguagesProperty_thenReturnAllPropertiesSizeIsOne() {
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
   * Test {@link DublinCoreSchema#getLanguagesProperty()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getLanguagesProperty()}
   */
  @Test
  @DisplayName("Test getLanguagesProperty(); then return 'null'")
  void testGetLanguagesProperty_thenReturnNull() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.LANGUAGE);

    // Act and Assert
    assertNull(dublinCoreSchema.getLanguagesProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getLanguages()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getLanguages()}
   */
  @Test
  @DisplayName("Test getLanguages(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetLanguages_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getLanguages());
  }

  /**
   * Test {@link DublinCoreSchema#getLanguages()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getLanguages()}
   */
  @Test
  @DisplayName("Test getLanguages(); then return 'null'")
  void testGetLanguages_thenReturnNull() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.LANGUAGE);

    // Act and Assert
    assertNull(dublinCoreSchema.getLanguages());
  }

  /**
   * Test {@link DublinCoreSchema#getLanguages()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getLanguages()}
   */
  @Test
  @DisplayName("Test getLanguages(); then return size is one")
  void testGetLanguages_thenReturnSizeIsOne() {
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
   * Test {@link DublinCoreSchema#getPublishersProperty()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getPublishersProperty()}
   */
  @Test
  @DisplayName("Test getPublishersProperty()")
  void testGetPublishersProperty() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.PUBLISHER);

    // Act and Assert
    assertNull(dublinCoreSchema.getPublishersProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getPublishersProperty()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getPublishersProperty()}
   */
  @Test
  @DisplayName("Test getPublishersProperty(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetPublishersProperty_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getPublishersProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getPublishersProperty()}.
   * <ul>
   *   <li>Then return AllProperties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getPublishersProperty()}
   */
  @Test
  @DisplayName("Test getPublishersProperty(); then return AllProperties size is one")
  void testGetPublishersProperty_thenReturnAllPropertiesSizeIsOne() {
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
   * Test {@link DublinCoreSchema#getPublishersProperty()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getPublishersProperty()}
   */
  @Test
  @DisplayName("Test getPublishersProperty(); then return 'null'")
  void testGetPublishersProperty_thenReturnNull() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.PUBLISHER);

    // Act and Assert
    assertNull(dublinCoreSchema.getPublishersProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getPublishers()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getPublishers()}
   */
  @Test
  @DisplayName("Test getPublishers(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetPublishers_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getPublishers());
  }

  /**
   * Test {@link DublinCoreSchema#getPublishers()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getPublishers()}
   */
  @Test
  @DisplayName("Test getPublishers(); then return 'null'")
  void testGetPublishers_thenReturnNull() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.PUBLISHER);

    // Act and Assert
    assertNull(dublinCoreSchema.getPublishers());
  }

  /**
   * Test {@link DublinCoreSchema#getPublishers()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getPublishers()}
   */
  @Test
  @DisplayName("Test getPublishers(); then return size is one")
  void testGetPublishers_thenReturnSizeIsOne() {
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
   * Test {@link DublinCoreSchema#getRelationsProperty()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getRelationsProperty()}
   */
  @Test
  @DisplayName("Test getRelationsProperty()")
  void testGetRelationsProperty() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.RELATION);

    // Act and Assert
    assertNull(dublinCoreSchema.getRelationsProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getRelationsProperty()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getRelationsProperty()}
   */
  @Test
  @DisplayName("Test getRelationsProperty(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetRelationsProperty_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getRelationsProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getRelationsProperty()}.
   * <ul>
   *   <li>Then return AllProperties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getRelationsProperty()}
   */
  @Test
  @DisplayName("Test getRelationsProperty(); then return AllProperties size is one")
  void testGetRelationsProperty_thenReturnAllPropertiesSizeIsOne() {
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
   * Test {@link DublinCoreSchema#getRelationsProperty()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getRelationsProperty()}
   */
  @Test
  @DisplayName("Test getRelationsProperty(); then return 'null'")
  void testGetRelationsProperty_thenReturnNull() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.RELATION);

    // Act and Assert
    assertNull(dublinCoreSchema.getRelationsProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getRelations()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getRelations()}
   */
  @Test
  @DisplayName("Test getRelations(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetRelations_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getRelations());
  }

  /**
   * Test {@link DublinCoreSchema#getRelations()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getRelations()}
   */
  @Test
  @DisplayName("Test getRelations(); then return 'null'")
  void testGetRelations_thenReturnNull() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.RELATION);

    // Act and Assert
    assertNull(dublinCoreSchema.getRelations());
  }

  /**
   * Test {@link DublinCoreSchema#getRelations()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getRelations()}
   */
  @Test
  @DisplayName("Test getRelations(); then return size is one")
  void testGetRelations_thenReturnSizeIsOne() {
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
   * Test {@link DublinCoreSchema#getRightsProperty()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getRightsProperty()}
   */
  @Test
  @DisplayName("Test getRightsProperty()")
  void testGetRightsProperty() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.RIGHTS);

    // Act and Assert
    assertNull(dublinCoreSchema.getRightsProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getRightsProperty()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getRightsProperty()}
   */
  @Test
  @DisplayName("Test getRightsProperty(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetRightsProperty_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getRightsProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getRightsProperty()}.
   * <ul>
   *   <li>Then return AllProperties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getRightsProperty()}
   */
  @Test
  @DisplayName("Test getRightsProperty(); then return AllProperties size is one")
  void testGetRightsProperty_thenReturnAllPropertiesSizeIsOne() {
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
   * Test {@link DublinCoreSchema#getRightsProperty()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getRightsProperty()}
   */
  @Test
  @DisplayName("Test getRightsProperty(); then return 'null'")
  void testGetRightsProperty_thenReturnNull() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.RIGHTS);

    // Act and Assert
    assertNull(dublinCoreSchema.getRightsProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getRightsLanguages()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getRightsLanguages()}
   */
  @Test
  @DisplayName("Test getRightsLanguages(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetRightsLanguages_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getRightsLanguages());
  }

  /**
   * Test {@link DublinCoreSchema#getRightsLanguages()}.
   * <ul>
   *   <li>Then return first is {@link DublinCoreSchema#CONTRIBUTOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getRightsLanguages()}
   */
  @Test
  @DisplayName("Test getRightsLanguages(); then return first is CONTRIBUTOR")
  void testGetRightsLanguages_thenReturnFirstIsContributor() throws BadFieldValueException {
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
   * Test {@link DublinCoreSchema#getRightsLanguages()}.
   * <ul>
   *   <li>Then return first is {@code x-default}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getRightsLanguages()}
   */
  @Test
  @DisplayName("Test getRightsLanguages(); then return first is 'x-default'")
  void testGetRightsLanguages_thenReturnFirstIsXDefault() throws BadFieldValueException {
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
   * Test {@link DublinCoreSchema#getRightsLanguages()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getRightsLanguages()}
   */
  @Test
  @DisplayName("Test getRightsLanguages(); then return 'null'")
  void testGetRightsLanguages_thenReturnNull() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.RIGHTS);

    // Act and Assert
    assertNull(dublinCoreSchema.getRightsLanguages());
  }

  /**
   * Test {@link DublinCoreSchema#getRights()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getRights()}
   */
  @Test
  @DisplayName("Test getRights()")
  void testGetRights() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.RIGHTS);

    // Act and Assert
    assertNull(dublinCoreSchema.getRights());
  }

  /**
   * Test {@link DublinCoreSchema#getRights()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getRights()}
   */
  @Test
  @DisplayName("Test getRights()")
  void testGetRights2() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addRights(DublinCoreSchema.RIGHTS, "42");

    // Act and Assert
    assertNull(dublinCoreSchema.getRights());
  }

  /**
   * Test {@link DublinCoreSchema#getRights()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getRights()}
   */
  @Test
  @DisplayName("Test getRights()")
  void testGetRights3() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addBagValueAsSimple(DublinCoreSchema.RIGHTS, "42");

    // Act and Assert
    assertNull(dublinCoreSchema.getRights());
  }

  /**
   * Test {@link DublinCoreSchema#getRights(String)} with {@code String}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getRights(String)}
   */
  @Test
  @DisplayName("Test getRights(String) with 'String'")
  void testGetRightsWithString() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.RIGHTS);

    // Act and Assert
    assertNull(dublinCoreSchema.getRights("Lang"));
  }

  /**
   * Test {@link DublinCoreSchema#getRights(String)} with {@code String}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getRights(String)}
   */
  @Test
  @DisplayName("Test getRights(String) with 'String'")
  void testGetRightsWithString2() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addRights(DublinCoreSchema.CONTRIBUTOR, DublinCoreSchema.RIGHTS);
    dublinCoreSchema.addContributor(DublinCoreSchema.RIGHTS);

    // Act and Assert
    assertNull(dublinCoreSchema.getRights("Lang"));
  }

  /**
   * Test {@link DublinCoreSchema#getRights(String)} with {@code String}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getRights(String)}
   */
  @Test
  @DisplayName("Test getRights(String) with 'String'")
  void testGetRightsWithString3() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addBagValueAsSimple(DublinCoreSchema.RIGHTS, "42");

    // Act and Assert
    assertNull(dublinCoreSchema.getRights("Lang"));
  }

  /**
   * Test {@link DublinCoreSchema#getRights(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getRights(String)}
   */
  @Test
  @DisplayName("Test getRights(String) with 'String'; given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetRightsWithString_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getRights("Lang"));
  }

  /**
   * Test {@link DublinCoreSchema#getRights(String)} with {@code String}.
   * <ul>
   *   <li>Then return {@link DublinCoreSchema#RIGHTS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getRights(String)}
   */
  @Test
  @DisplayName("Test getRights(String) with 'String'; then return RIGHTS")
  void testGetRightsWithString_thenReturnRights() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addRights("Lang", DublinCoreSchema.RIGHTS);
    dublinCoreSchema.addContributor(DublinCoreSchema.RIGHTS);

    // Act and Assert
    assertEquals(DublinCoreSchema.RIGHTS, dublinCoreSchema.getRights("Lang"));
  }

  /**
   * Test {@link DublinCoreSchema#getRights()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getRights()}
   */
  @Test
  @DisplayName("Test getRights(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetRights_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getRights());
  }

  /**
   * Test {@link DublinCoreSchema#getRights()}.
   * <ul>
   *   <li>Then return {@link DublinCoreSchema#RIGHTS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getRights()}
   */
  @Test
  @DisplayName("Test getRights(); then return RIGHTS")
  void testGetRights_thenReturnRights() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addRights("x-default", DublinCoreSchema.RIGHTS);
    dublinCoreSchema.addContributor(DublinCoreSchema.RIGHTS);

    // Act and Assert
    assertEquals(DublinCoreSchema.RIGHTS, dublinCoreSchema.getRights());
  }

  /**
   * Test {@link DublinCoreSchema#getSourceProperty()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getSourceProperty()}
   */
  @Test
  @DisplayName("Test getSourceProperty()")
  void testGetSourceProperty() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.SOURCE);

    // Act and Assert
    assertNull(dublinCoreSchema.getSourceProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getSourceProperty()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getSourceProperty()}
   */
  @Test
  @DisplayName("Test getSourceProperty()")
  void testGetSourceProperty2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.SOURCE);

    // Act and Assert
    assertNull(dublinCoreSchema.getSourceProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getSourceProperty()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getSourceProperty()}
   */
  @Test
  @DisplayName("Test getSourceProperty(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetSourceProperty_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getSourceProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getSource()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getSource()}
   */
  @Test
  @DisplayName("Test getSource()")
  void testGetSource() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.SOURCE);

    // Act and Assert
    assertNull(dublinCoreSchema.getSource());
  }

  /**
   * Test {@link DublinCoreSchema#getSource()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getSource()}
   */
  @Test
  @DisplayName("Test getSource()")
  void testGetSource2() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.SOURCE);

    // Act and Assert
    assertNull(dublinCoreSchema.getSource());
  }

  /**
   * Test {@link DublinCoreSchema#getSource()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getSource()}
   */
  @Test
  @DisplayName("Test getSource(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetSource_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getSource());
  }

  /**
   * Test {@link DublinCoreSchema#getSubjectsProperty()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getSubjectsProperty()}
   */
  @Test
  @DisplayName("Test getSubjectsProperty()")
  void testGetSubjectsProperty() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.SUBJECT);

    // Act and Assert
    assertNull(dublinCoreSchema.getSubjectsProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getSubjectsProperty()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getSubjectsProperty()}
   */
  @Test
  @DisplayName("Test getSubjectsProperty(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetSubjectsProperty_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getSubjectsProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getSubjectsProperty()}.
   * <ul>
   *   <li>Then return AllProperties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getSubjectsProperty()}
   */
  @Test
  @DisplayName("Test getSubjectsProperty(); then return AllProperties size is one")
  void testGetSubjectsProperty_thenReturnAllPropertiesSizeIsOne() {
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
   * Test {@link DublinCoreSchema#getSubjectsProperty()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getSubjectsProperty()}
   */
  @Test
  @DisplayName("Test getSubjectsProperty(); then return 'null'")
  void testGetSubjectsProperty_thenReturnNull() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.SUBJECT);

    // Act and Assert
    assertNull(dublinCoreSchema.getSubjectsProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getSubjects()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getSubjects()}
   */
  @Test
  @DisplayName("Test getSubjects(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetSubjects_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getSubjects());
  }

  /**
   * Test {@link DublinCoreSchema#getSubjects()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getSubjects()}
   */
  @Test
  @DisplayName("Test getSubjects(); then return 'null'")
  void testGetSubjects_thenReturnNull() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.SUBJECT);

    // Act and Assert
    assertNull(dublinCoreSchema.getSubjects());
  }

  /**
   * Test {@link DublinCoreSchema#getSubjects()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getSubjects()}
   */
  @Test
  @DisplayName("Test getSubjects(); then return size is one")
  void testGetSubjects_thenReturnSizeIsOne() {
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
   * Test {@link DublinCoreSchema#getTitleProperty()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getTitleProperty()}
   */
  @Test
  @DisplayName("Test getTitleProperty()")
  void testGetTitleProperty() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act and Assert
    assertNull(dublinCoreSchema.getTitleProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getTitleProperty()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getTitleProperty()}
   */
  @Test
  @DisplayName("Test getTitleProperty(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetTitleProperty_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getTitleProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getTitleProperty()}.
   * <ul>
   *   <li>Then return AllProperties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getTitleProperty()}
   */
  @Test
  @DisplayName("Test getTitleProperty(); then return AllProperties size is one")
  void testGetTitleProperty_thenReturnAllPropertiesSizeIsOne() {
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
   * Test {@link DublinCoreSchema#getTitleProperty()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getTitleProperty()}
   */
  @Test
  @DisplayName("Test getTitleProperty(); then return 'null'")
  void testGetTitleProperty_thenReturnNull() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act and Assert
    assertNull(dublinCoreSchema.getTitleProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getTitleLanguages()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getTitleLanguages()}
   */
  @Test
  @DisplayName("Test getTitleLanguages(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetTitleLanguages_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getTitleLanguages());
  }

  /**
   * Test {@link DublinCoreSchema#getTitleLanguages()}.
   * <ul>
   *   <li>Then return first is {@link DublinCoreSchema#CONTRIBUTOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getTitleLanguages()}
   */
  @Test
  @DisplayName("Test getTitleLanguages(); then return first is CONTRIBUTOR")
  void testGetTitleLanguages_thenReturnFirstIsContributor() throws BadFieldValueException {
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
   * Test {@link DublinCoreSchema#getTitleLanguages()}.
   * <ul>
   *   <li>Then return first is {@code x-default}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getTitleLanguages()}
   */
  @Test
  @DisplayName("Test getTitleLanguages(); then return first is 'x-default'")
  void testGetTitleLanguages_thenReturnFirstIsXDefault() throws BadFieldValueException {
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
   * Test {@link DublinCoreSchema#getTitleLanguages()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getTitleLanguages()}
   */
  @Test
  @DisplayName("Test getTitleLanguages(); then return 'null'")
  void testGetTitleLanguages_thenReturnNull() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act and Assert
    assertNull(dublinCoreSchema.getTitleLanguages());
  }

  /**
   * Test {@link DublinCoreSchema#getTitle()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle()")
  void testGetTitle() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act and Assert
    assertNull(dublinCoreSchema.getTitle());
  }

  /**
   * Test {@link DublinCoreSchema#getTitle()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle()")
  void testGetTitle2() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addTitle(DublinCoreSchema.TITLE, "42");

    // Act and Assert
    assertNull(dublinCoreSchema.getTitle());
  }

  /**
   * Test {@link DublinCoreSchema#getTitle()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle()")
  void testGetTitle3() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addBagValueAsSimple(DublinCoreSchema.TITLE, "42");

    // Act and Assert
    assertNull(dublinCoreSchema.getTitle());
  }

  /**
   * Test {@link DublinCoreSchema#getTitle(String)} with {@code String}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getTitle(String)}
   */
  @Test
  @DisplayName("Test getTitle(String) with 'String'")
  void testGetTitleWithString() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act and Assert
    assertNull(dublinCoreSchema.getTitle("Lang"));
  }

  /**
   * Test {@link DublinCoreSchema#getTitle(String)} with {@code String}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getTitle(String)}
   */
  @Test
  @DisplayName("Test getTitle(String) with 'String'")
  void testGetTitleWithString2() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addTitle(DublinCoreSchema.CONTRIBUTOR, DublinCoreSchema.TITLE);
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act and Assert
    assertNull(dublinCoreSchema.getTitle("Lang"));
  }

  /**
   * Test {@link DublinCoreSchema#getTitle(String)} with {@code String}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getTitle(String)}
   */
  @Test
  @DisplayName("Test getTitle(String) with 'String'")
  void testGetTitleWithString3() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addBagValueAsSimple(DublinCoreSchema.TITLE, "42");

    // Act and Assert
    assertNull(dublinCoreSchema.getTitle("Lang"));
  }

  /**
   * Test {@link DublinCoreSchema#getTitle(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getTitle(String)}
   */
  @Test
  @DisplayName("Test getTitle(String) with 'String'; given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetTitleWithString_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getTitle("Lang"));
  }

  /**
   * Test {@link DublinCoreSchema#getTitle(String)} with {@code String}.
   * <ul>
   *   <li>Then return {@link DublinCoreSchema#TITLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getTitle(String)}
   */
  @Test
  @DisplayName("Test getTitle(String) with 'String'; then return TITLE")
  void testGetTitleWithString_thenReturnTitle() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addTitle("Lang", DublinCoreSchema.TITLE);
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act and Assert
    assertEquals(DublinCoreSchema.TITLE, dublinCoreSchema.getTitle("Lang"));
  }

  /**
   * Test {@link DublinCoreSchema#getTitle()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  void testGetTitle_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata_thenReturnNull()
      throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getTitle());
  }

  /**
   * Test {@link DublinCoreSchema#getTitle()}.
   * <ul>
   *   <li>Then return {@link DublinCoreSchema#TITLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); then return TITLE")
  void testGetTitle_thenReturnTitle() throws BadFieldValueException {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addTitle("x-default", DublinCoreSchema.TITLE);
    dublinCoreSchema.addContributor(DublinCoreSchema.TITLE);

    // Act and Assert
    assertEquals(DublinCoreSchema.TITLE, dublinCoreSchema.getTitle());
  }

  /**
   * Test {@link DublinCoreSchema#getTypesProperty()}.
   * <p>
   * Method under test: {@link DublinCoreSchema#getTypesProperty()}
   */
  @Test
  @DisplayName("Test getTypesProperty()")
  void testGetTypesProperty() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addCreator(DublinCoreSchema.CONTRIBUTOR);
    dublinCoreSchema.addContributor(DublinCoreSchema.TYPE);

    // Act and Assert
    assertNull(dublinCoreSchema.getTypesProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getTypesProperty()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getTypesProperty()}
   */
  @Test
  @DisplayName("Test getTypesProperty(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetTypesProperty_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getTypesProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getTypesProperty()}.
   * <ul>
   *   <li>Then return AllProperties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getTypesProperty()}
   */
  @Test
  @DisplayName("Test getTypesProperty(); then return AllProperties size is one")
  void testGetTypesProperty_thenReturnAllPropertiesSizeIsOne() {
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
   * Test {@link DublinCoreSchema#getTypesProperty()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getTypesProperty()}
   */
  @Test
  @DisplayName("Test getTypesProperty(); then return 'null'")
  void testGetTypesProperty_thenReturnNull() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.TYPE);

    // Act and Assert
    assertNull(dublinCoreSchema.getTypesProperty());
  }

  /**
   * Test {@link DublinCoreSchema#getTypes()}.
   * <ul>
   *   <li>Given {@link DublinCoreSchema#DublinCoreSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getTypes()}
   */
  @Test
  @DisplayName("Test getTypes(); given DublinCoreSchema(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  void testGetTypes_givenDublinCoreSchemaWithMetadataIsCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new DublinCoreSchema(XMPMetadata.createXMPMetadata())).getTypes());
  }

  /**
   * Test {@link DublinCoreSchema#getTypes()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getTypes()}
   */
  @Test
  @DisplayName("Test getTypes(); then return 'null'")
  void testGetTypes_thenReturnNull() {
    // Arrange
    DublinCoreSchema dublinCoreSchema = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    dublinCoreSchema.addContributor(DublinCoreSchema.TYPE);

    // Act and Assert
    assertNull(dublinCoreSchema.getTypes());
  }

  /**
   * Test {@link DublinCoreSchema#getTypes()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DublinCoreSchema#getTypes()}
   */
  @Test
  @DisplayName("Test getTypes(); then return size is one")
  void testGetTypes_thenReturnSizeIsOne() {
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
}

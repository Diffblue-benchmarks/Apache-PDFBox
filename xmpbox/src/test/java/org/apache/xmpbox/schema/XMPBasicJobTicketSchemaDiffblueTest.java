package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.type.AbstractField;
import org.apache.xmpbox.type.ArrayProperty;
import org.apache.xmpbox.type.BadFieldValueException;
import org.apache.xmpbox.type.Cardinality;
import org.apache.xmpbox.type.JobType;
import org.apache.xmpbox.type.TextType;
import org.apache.xmpbox.type.URLType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class XMPBasicJobTicketSchemaDiffblueTest {
  /**
   * Test {@link XMPBasicJobTicketSchema#XMPBasicJobTicketSchema(XMPMetadata)}.
   * <p>
   * Method under test:
   * {@link XMPBasicJobTicketSchema#XMPBasicJobTicketSchema(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new XMPBasicJobTicketSchema(XMPMetadata)")
  void testNewXMPBasicJobTicketSchema() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPBasicJobTicketSchema actualXmpBasicJobTicketSchema = new XMPBasicJobTicketSchema(metadata);

    // Assert
    assertEquals("", actualXmpBasicJobTicketSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/xap/1.0/bj/", actualXmpBasicJobTicketSchema.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualXmpBasicJobTicketSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("xmpBJ", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/bj/"));
    assertEquals("xmpBJ", actualXmpBasicJobTicketSchema.getPreferedPrefix());
    assertEquals("xmpBJ", actualXmpBasicJobTicketSchema.getPrefix());
    assertNull(actualXmpBasicJobTicketSchema.getPropertyName());
    assertNull(actualXmpBasicJobTicketSchema.getJobs());
    assertNull(actualXmpBasicJobTicketSchema.getAboutAttribute());
    List<AbstractField> allProperties = actualXmpBasicJobTicketSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualXmpBasicJobTicketSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualXmpBasicJobTicketSchema.getContainer().getAllProperties());
    assertSame(metadata, actualXmpBasicJobTicketSchema.getMetadata());
  }

  /**
   * Test
   * {@link XMPBasicJobTicketSchema#XMPBasicJobTicketSchema(XMPMetadata, String)}.
   * <p>
   * Method under test:
   * {@link XMPBasicJobTicketSchema#XMPBasicJobTicketSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName("Test new XMPBasicJobTicketSchema(XMPMetadata, String)")
  void testNewXMPBasicJobTicketSchema2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPBasicJobTicketSchema actualXmpBasicJobTicketSchema = new XMPBasicJobTicketSchema(metadata, "Own Prefix");

    // Assert
    assertEquals("", actualXmpBasicJobTicketSchema.getAboutValue());
    Map<String, String> allNamespacesWithPrefix = actualXmpBasicJobTicketSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("Own Prefix", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/bj/"));
    assertEquals("Own Prefix", actualXmpBasicJobTicketSchema.getPrefix());
    assertEquals("http://ns.adobe.com/xap/1.0/bj/", actualXmpBasicJobTicketSchema.getNamespace());
    assertEquals("xmpBJ", actualXmpBasicJobTicketSchema.getPreferedPrefix());
    assertNull(actualXmpBasicJobTicketSchema.getPropertyName());
    assertNull(actualXmpBasicJobTicketSchema.getJobs());
    assertNull(actualXmpBasicJobTicketSchema.getAboutAttribute());
    List<AbstractField> allProperties = actualXmpBasicJobTicketSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualXmpBasicJobTicketSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualXmpBasicJobTicketSchema.getContainer().getAllProperties());
    assertSame(metadata, actualXmpBasicJobTicketSchema.getMetadata());
  }

  /**
   * Test
   * {@link XMPBasicJobTicketSchema#XMPBasicJobTicketSchema(XMPMetadata, String)}.
   * <p>
   * Method under test:
   * {@link XMPBasicJobTicketSchema#XMPBasicJobTicketSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName("Test new XMPBasicJobTicketSchema(XMPMetadata, String)")
  void testNewXMPBasicJobTicketSchema3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPBasicJobTicketSchema actualXmpBasicJobTicketSchema = new XMPBasicJobTicketSchema(metadata, null);

    // Assert
    assertEquals("", actualXmpBasicJobTicketSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/xap/1.0/bj/", actualXmpBasicJobTicketSchema.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualXmpBasicJobTicketSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("xmpBJ", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/bj/"));
    assertEquals("xmpBJ", actualXmpBasicJobTicketSchema.getPreferedPrefix());
    assertEquals("xmpBJ", actualXmpBasicJobTicketSchema.getPrefix());
    assertNull(actualXmpBasicJobTicketSchema.getPropertyName());
    assertNull(actualXmpBasicJobTicketSchema.getJobs());
    assertNull(actualXmpBasicJobTicketSchema.getAboutAttribute());
    List<AbstractField> allProperties = actualXmpBasicJobTicketSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualXmpBasicJobTicketSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualXmpBasicJobTicketSchema.getContainer().getAllProperties());
    assertSame(metadata, actualXmpBasicJobTicketSchema.getMetadata());
  }

  /**
   * Test {@link XMPBasicJobTicketSchema#addJob(String, String, String)} with
   * {@code id}, {@code name}, {@code url}.
   * <p>
   * Method under test:
   * {@link XMPBasicJobTicketSchema#addJob(String, String, String)}
   */
  @Test
  @DisplayName("Test addJob(String, String, String) with 'id', 'name', 'url'")
  void testAddJobWithIdNameUrl() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPBasicJobTicketSchema xmpBasicJobTicketSchema = new XMPBasicJobTicketSchema(metadata);

    // Act
    xmpBasicJobTicketSchema.addJob("42", "Name", "https://example.org/example");

    // Assert
    List<AbstractField> allProperties = xmpBasicJobTicketSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    List<JobType> jobs = xmpBasicJobTicketSchema.getJobs();
    assertEquals(1, jobs.size());
    JobType getResult2 = jobs.get(0);
    List<AbstractField> allProperties2 = getResult2.getAllProperties();
    assertEquals(3, allProperties2.size());
    AbstractField getResult3 = allProperties2.get(0);
    assertTrue(getResult3 instanceof TextType);
    AbstractField getResult4 = allProperties2.get(1);
    assertTrue(getResult4 instanceof TextType);
    AbstractField getResult5 = allProperties2.get(2);
    assertTrue(getResult5 instanceof URLType);
    assertEquals("42", getResult2.getId());
    assertEquals("42", ((TextType) getResult3).getStringValue());
    assertEquals("42", ((TextType) getResult3).getRawValue());
    assertEquals("42", ((TextType) getResult3).getValue());
    assertEquals("Name", getResult2.getName());
    assertEquals("Name", ((TextType) getResult4).getStringValue());
    assertEquals("Name", ((TextType) getResult4).getRawValue());
    assertEquals("Name", ((TextType) getResult4).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/bj/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/sType/Job#", getResult2.getNamespace());
    assertEquals("https://example.org/example", getResult2.getUrl());
    assertEquals("https://example.org/example", ((URLType) getResult5).getStringValue());
    assertEquals("https://example.org/example", ((URLType) getResult5).getRawValue());
    assertEquals("https://example.org/example", ((URLType) getResult5).getValue());
    assertEquals("id", getResult3.getPropertyName());
    assertEquals("name", getResult4.getPropertyName());
    Map<String, String> allNamespacesWithPrefix = xmpBasicJobTicketSchema.getAllNamespacesWithPrefix();
    assertEquals(2, allNamespacesWithPrefix.size());
    assertEquals("stJob", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/sType/Job#"));
    Map<String, String> allNamespacesWithPrefix2 = getResult2.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix2.size());
    assertEquals("stJob", allNamespacesWithPrefix2.get("http://ns.adobe.com/xap/1.0/sType/Job#"));
    assertEquals("stJob", getResult3.getPrefix());
    assertEquals("stJob", getResult4.getPrefix());
    assertEquals("stJob", getResult5.getPrefix());
    assertEquals("stJob", getResult2.getPreferedPrefix());
    assertEquals("stJob", getResult2.getPrefix());
    assertEquals("url", getResult5.getPropertyName());
    assertEquals("xmpBJ", getResult.getPrefix());
    assertNull(getResult3.getNamespace());
    assertNull(getResult4.getNamespace());
    assertNull(getResult5.getNamespace());
    assertNull(getResult2.getPropertyName());
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(getResult5.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/bj/"));
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPBasicJobTicketSchema.JOB_REF, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
    assertSame(metadata, getResult5.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Test {@link XMPBasicJobTicketSchema#addJob(String, String, String)} with
   * {@code id}, {@code name}, {@code url}.
   * <p>
   * Method under test:
   * {@link XMPBasicJobTicketSchema#addJob(String, String, String)}
   */
  @Test
  @DisplayName("Test addJob(String, String, String) with 'id', 'name', 'url'")
  void testAddJobWithIdNameUrl2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicJobTicketSchema xmpBasicJobTicketSchema = new XMPBasicJobTicketSchema(metadata);
    xmpBasicJobTicketSchema.addJob("42", "id", "https://example.org/example");

    // Act
    xmpBasicJobTicketSchema.addJob("42", "Name", "https://example.org/example");

    // Assert
    List<AbstractField> allProperties = xmpBasicJobTicketSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    List<JobType> jobs = xmpBasicJobTicketSchema.getJobs();
    assertEquals(2, jobs.size());
    JobType getResult2 = jobs.get(0);
    List<AbstractField> allProperties2 = getResult2.getAllProperties();
    assertEquals(3, allProperties2.size());
    AbstractField getResult3 = allProperties2.get(0);
    assertTrue(getResult3 instanceof TextType);
    AbstractField getResult4 = allProperties2.get(1);
    assertTrue(getResult4 instanceof TextType);
    JobType getResult5 = jobs.get(1);
    List<AbstractField> allProperties3 = getResult5.getAllProperties();
    assertEquals(3, allProperties3.size());
    AbstractField getResult6 = allProperties3.get(0);
    assertTrue(getResult6 instanceof TextType);
    AbstractField getResult7 = allProperties3.get(1);
    assertTrue(getResult7 instanceof TextType);
    AbstractField getResult8 = allProperties2.get(2);
    assertTrue(getResult8 instanceof URLType);
    AbstractField getResult9 = allProperties3.get(2);
    assertTrue(getResult9 instanceof URLType);
    assertEquals("42", getResult2.getId());
    assertEquals("42", getResult5.getId());
    assertEquals("42", ((TextType) getResult3).getStringValue());
    assertEquals("42", ((TextType) getResult6).getStringValue());
    assertEquals("42", ((TextType) getResult3).getRawValue());
    assertEquals("42", ((TextType) getResult6).getRawValue());
    assertEquals("42", ((TextType) getResult3).getValue());
    assertEquals("42", ((TextType) getResult6).getValue());
    assertEquals("Name", getResult5.getName());
    assertEquals("Name", ((TextType) getResult7).getStringValue());
    assertEquals("Name", ((TextType) getResult7).getRawValue());
    assertEquals("Name", ((TextType) getResult7).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/bj/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/sType/Job#", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/sType/Job#", getResult5.getNamespace());
    assertEquals("https://example.org/example", getResult2.getUrl());
    assertEquals("https://example.org/example", getResult5.getUrl());
    assertEquals("https://example.org/example", ((URLType) getResult8).getStringValue());
    assertEquals("https://example.org/example", ((URLType) getResult9).getStringValue());
    assertEquals("https://example.org/example", ((URLType) getResult8).getRawValue());
    assertEquals("https://example.org/example", ((URLType) getResult9).getRawValue());
    assertEquals("https://example.org/example", ((URLType) getResult8).getValue());
    assertEquals("https://example.org/example", ((URLType) getResult9).getValue());
    assertEquals("id", getResult3.getPropertyName());
    assertEquals("id", getResult6.getPropertyName());
    assertEquals("id", getResult2.getName());
    assertEquals("id", ((TextType) getResult4).getStringValue());
    assertEquals("id", ((TextType) getResult4).getRawValue());
    assertEquals("id", ((TextType) getResult4).getValue());
    assertEquals("name", getResult4.getPropertyName());
    assertEquals("name", getResult7.getPropertyName());
    Map<String, String> allNamespacesWithPrefix = xmpBasicJobTicketSchema.getAllNamespacesWithPrefix();
    assertEquals(2, allNamespacesWithPrefix.size());
    assertEquals("stJob", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/sType/Job#"));
    Map<String, String> allNamespacesWithPrefix2 = getResult2.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix2.size());
    assertEquals("stJob", allNamespacesWithPrefix2.get("http://ns.adobe.com/xap/1.0/sType/Job#"));
    Map<String, String> allNamespacesWithPrefix3 = getResult5.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix3.size());
    assertEquals("stJob", allNamespacesWithPrefix3.get("http://ns.adobe.com/xap/1.0/sType/Job#"));
    assertEquals("stJob", getResult3.getPrefix());
    assertEquals("stJob", getResult4.getPrefix());
    assertEquals("stJob", getResult8.getPrefix());
    assertEquals("stJob", getResult6.getPrefix());
    assertEquals("stJob", getResult7.getPrefix());
    assertEquals("stJob", getResult9.getPrefix());
    assertEquals("stJob", getResult2.getPreferedPrefix());
    assertEquals("stJob", getResult5.getPreferedPrefix());
    assertEquals("stJob", getResult2.getPrefix());
    assertEquals("stJob", getResult5.getPrefix());
    assertEquals("url", getResult8.getPropertyName());
    assertEquals("url", getResult9.getPropertyName());
    assertEquals("xmpBJ", getResult.getPrefix());
    assertNull(getResult3.getNamespace());
    assertNull(getResult4.getNamespace());
    assertNull(getResult8.getNamespace());
    assertNull(getResult6.getNamespace());
    assertNull(getResult7.getNamespace());
    assertNull(getResult9.getNamespace());
    assertNull(getResult2.getPropertyName());
    assertNull(getResult5.getPropertyName());
    assertEquals(2, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(getResult8.getAllAttributes().isEmpty());
    assertTrue(getResult6.getAllAttributes().isEmpty());
    assertTrue(getResult7.getAllAttributes().isEmpty());
    assertTrue(getResult9.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult5.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/bj/"));
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPBasicJobTicketSchema.JOB_REF, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
    assertSame(metadata, getResult8.getMetadata());
    assertSame(metadata, getResult6.getMetadata());
    assertSame(metadata, getResult7.getMetadata());
    assertSame(metadata, getResult9.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult5.getMetadata());
  }

  /**
   * Test {@link XMPBasicJobTicketSchema#addJob(String, String, String, String)}
   * with {@code id}, {@code name}, {@code url}, {@code fieldPrefix}.
   * <p>
   * Method under test:
   * {@link XMPBasicJobTicketSchema#addJob(String, String, String, String)}
   */
  @Test
  @DisplayName("Test addJob(String, String, String, String) with 'id', 'name', 'url', 'fieldPrefix'")
  void testAddJobWithIdNameUrlFieldPrefix() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPBasicJobTicketSchema xmpBasicJobTicketSchema = new XMPBasicJobTicketSchema(metadata);

    // Act
    xmpBasicJobTicketSchema.addJob("42", "Name", "https://example.org/example", "Field Prefix");

    // Assert
    List<AbstractField> allProperties = xmpBasicJobTicketSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    List<JobType> jobs = xmpBasicJobTicketSchema.getJobs();
    assertEquals(1, jobs.size());
    JobType getResult2 = jobs.get(0);
    List<AbstractField> allProperties2 = getResult2.getAllProperties();
    assertEquals(3, allProperties2.size());
    AbstractField getResult3 = allProperties2.get(0);
    assertTrue(getResult3 instanceof TextType);
    AbstractField getResult4 = allProperties2.get(1);
    assertTrue(getResult4 instanceof TextType);
    AbstractField getResult5 = allProperties2.get(2);
    assertTrue(getResult5 instanceof URLType);
    assertEquals("42", getResult2.getId());
    assertEquals("42", ((TextType) getResult3).getStringValue());
    assertEquals("42", ((TextType) getResult3).getRawValue());
    assertEquals("42", ((TextType) getResult3).getValue());
    assertEquals("Name", getResult2.getName());
    assertEquals("Name", ((TextType) getResult4).getStringValue());
    assertEquals("Name", ((TextType) getResult4).getRawValue());
    assertEquals("Name", ((TextType) getResult4).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/bj/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/sType/Job#", getResult2.getNamespace());
    assertEquals("https://example.org/example", getResult2.getUrl());
    assertEquals("https://example.org/example", ((URLType) getResult5).getStringValue());
    assertEquals("https://example.org/example", ((URLType) getResult5).getRawValue());
    assertEquals("https://example.org/example", ((URLType) getResult5).getValue());
    assertEquals("id", getResult3.getPropertyName());
    assertEquals("name", getResult4.getPropertyName());
    Map<String, String> allNamespacesWithPrefix = xmpBasicJobTicketSchema.getAllNamespacesWithPrefix();
    assertEquals(2, allNamespacesWithPrefix.size());
    assertEquals("stJob", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/sType/Job#"));
    Map<String, String> allNamespacesWithPrefix2 = getResult2.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix2.size());
    assertEquals("stJob", allNamespacesWithPrefix2.get("http://ns.adobe.com/xap/1.0/sType/Job#"));
    assertEquals("stJob", getResult3.getPrefix());
    assertEquals("stJob", getResult4.getPrefix());
    assertEquals("stJob", getResult5.getPrefix());
    assertEquals("stJob", getResult2.getPreferedPrefix());
    assertEquals("stJob", getResult2.getPrefix());
    assertEquals("url", getResult5.getPropertyName());
    assertEquals("xmpBJ", getResult.getPrefix());
    assertNull(getResult3.getNamespace());
    assertNull(getResult4.getNamespace());
    assertNull(getResult5.getNamespace());
    assertNull(getResult2.getPropertyName());
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(getResult5.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/bj/"));
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPBasicJobTicketSchema.JOB_REF, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
    assertSame(metadata, getResult5.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Test {@link XMPBasicJobTicketSchema#addJob(String, String, String, String)}
   * with {@code id}, {@code name}, {@code url}, {@code fieldPrefix}.
   * <p>
   * Method under test:
   * {@link XMPBasicJobTicketSchema#addJob(String, String, String, String)}
   */
  @Test
  @DisplayName("Test addJob(String, String, String, String) with 'id', 'name', 'url', 'fieldPrefix'")
  void testAddJobWithIdNameUrlFieldPrefix2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicJobTicketSchema xmpBasicJobTicketSchema = new XMPBasicJobTicketSchema(metadata);
    xmpBasicJobTicketSchema.addJob("42", "id", "https://example.org/example");

    // Act
    xmpBasicJobTicketSchema.addJob("42", "Name", "https://example.org/example", "Field Prefix");

    // Assert
    List<AbstractField> allProperties = xmpBasicJobTicketSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    List<JobType> jobs = xmpBasicJobTicketSchema.getJobs();
    assertEquals(2, jobs.size());
    JobType getResult2 = jobs.get(0);
    List<AbstractField> allProperties2 = getResult2.getAllProperties();
    assertEquals(3, allProperties2.size());
    AbstractField getResult3 = allProperties2.get(0);
    assertTrue(getResult3 instanceof TextType);
    AbstractField getResult4 = allProperties2.get(1);
    assertTrue(getResult4 instanceof TextType);
    JobType getResult5 = jobs.get(1);
    List<AbstractField> allProperties3 = getResult5.getAllProperties();
    assertEquals(3, allProperties3.size());
    AbstractField getResult6 = allProperties3.get(0);
    assertTrue(getResult6 instanceof TextType);
    AbstractField getResult7 = allProperties3.get(1);
    assertTrue(getResult7 instanceof TextType);
    AbstractField getResult8 = allProperties2.get(2);
    assertTrue(getResult8 instanceof URLType);
    AbstractField getResult9 = allProperties3.get(2);
    assertTrue(getResult9 instanceof URLType);
    assertEquals("42", getResult2.getId());
    assertEquals("42", getResult5.getId());
    assertEquals("42", ((TextType) getResult3).getStringValue());
    assertEquals("42", ((TextType) getResult6).getStringValue());
    assertEquals("42", ((TextType) getResult3).getRawValue());
    assertEquals("42", ((TextType) getResult6).getRawValue());
    assertEquals("42", ((TextType) getResult3).getValue());
    assertEquals("42", ((TextType) getResult6).getValue());
    assertEquals("Name", getResult5.getName());
    assertEquals("Name", ((TextType) getResult7).getStringValue());
    assertEquals("Name", ((TextType) getResult7).getRawValue());
    assertEquals("Name", ((TextType) getResult7).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/bj/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/sType/Job#", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/sType/Job#", getResult5.getNamespace());
    assertEquals("https://example.org/example", getResult2.getUrl());
    assertEquals("https://example.org/example", getResult5.getUrl());
    assertEquals("https://example.org/example", ((URLType) getResult8).getStringValue());
    assertEquals("https://example.org/example", ((URLType) getResult9).getStringValue());
    assertEquals("https://example.org/example", ((URLType) getResult8).getRawValue());
    assertEquals("https://example.org/example", ((URLType) getResult9).getRawValue());
    assertEquals("https://example.org/example", ((URLType) getResult8).getValue());
    assertEquals("https://example.org/example", ((URLType) getResult9).getValue());
    assertEquals("id", getResult3.getPropertyName());
    assertEquals("id", getResult6.getPropertyName());
    assertEquals("id", getResult2.getName());
    assertEquals("id", ((TextType) getResult4).getStringValue());
    assertEquals("id", ((TextType) getResult4).getRawValue());
    assertEquals("id", ((TextType) getResult4).getValue());
    assertEquals("name", getResult4.getPropertyName());
    assertEquals("name", getResult7.getPropertyName());
    Map<String, String> allNamespacesWithPrefix = xmpBasicJobTicketSchema.getAllNamespacesWithPrefix();
    assertEquals(2, allNamespacesWithPrefix.size());
    assertEquals("stJob", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/sType/Job#"));
    Map<String, String> allNamespacesWithPrefix2 = getResult2.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix2.size());
    assertEquals("stJob", allNamespacesWithPrefix2.get("http://ns.adobe.com/xap/1.0/sType/Job#"));
    Map<String, String> allNamespacesWithPrefix3 = getResult5.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix3.size());
    assertEquals("stJob", allNamespacesWithPrefix3.get("http://ns.adobe.com/xap/1.0/sType/Job#"));
    assertEquals("stJob", getResult3.getPrefix());
    assertEquals("stJob", getResult4.getPrefix());
    assertEquals("stJob", getResult8.getPrefix());
    assertEquals("stJob", getResult6.getPrefix());
    assertEquals("stJob", getResult7.getPrefix());
    assertEquals("stJob", getResult9.getPrefix());
    assertEquals("stJob", getResult2.getPreferedPrefix());
    assertEquals("stJob", getResult5.getPreferedPrefix());
    assertEquals("stJob", getResult2.getPrefix());
    assertEquals("stJob", getResult5.getPrefix());
    assertEquals("url", getResult8.getPropertyName());
    assertEquals("url", getResult9.getPropertyName());
    assertEquals("xmpBJ", getResult.getPrefix());
    assertNull(getResult3.getNamespace());
    assertNull(getResult4.getNamespace());
    assertNull(getResult8.getNamespace());
    assertNull(getResult6.getNamespace());
    assertNull(getResult7.getNamespace());
    assertNull(getResult9.getNamespace());
    assertNull(getResult2.getPropertyName());
    assertNull(getResult5.getPropertyName());
    assertEquals(2, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(getResult8.getAllAttributes().isEmpty());
    assertTrue(getResult6.getAllAttributes().isEmpty());
    assertTrue(getResult7.getAllAttributes().isEmpty());
    assertTrue(getResult9.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult5.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/bj/"));
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPBasicJobTicketSchema.JOB_REF, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
    assertSame(metadata, getResult8.getMetadata());
    assertSame(metadata, getResult6.getMetadata());
    assertSame(metadata, getResult7.getMetadata());
    assertSame(metadata, getResult9.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult5.getMetadata());
  }

  /**
   * Test {@link XMPBasicJobTicketSchema#addJob(JobType)} with {@code job}.
   * <p>
   * Method under test: {@link XMPBasicJobTicketSchema#addJob(JobType)}
   */
  @Test
  @DisplayName("Test addJob(JobType) with 'job'")
  void testAddJobWithJob() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPBasicJobTicketSchema xmpBasicJobTicketSchema = new XMPBasicJobTicketSchema(metadata);

    // Act
    xmpBasicJobTicketSchema.addJob(new JobType(XMPMetadata.createXMPMetadata()));

    // Assert
    List<AbstractField> allProperties = xmpBasicJobTicketSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals("http://ns.adobe.com/xap/1.0/bj/", getResult.getNamespace());
    assertEquals("xmpBJ", getResult.getPrefix());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPBasicJobTicketSchema.JOB_REF, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPBasicJobTicketSchema#addJob(JobType)} with {@code job}.
   * <p>
   * Method under test: {@link XMPBasicJobTicketSchema#addJob(JobType)}
   */
  @Test
  @DisplayName("Test addJob(JobType) with 'job'")
  void testAddJobWithJob2() throws BadFieldValueException {
    // Arrange
    XMPBasicJobTicketSchema xmpBasicJobTicketSchema = new XMPBasicJobTicketSchema(XMPMetadata.createXMPMetadata());
    xmpBasicJobTicketSchema.addJob("42", XMPBasicJobTicketSchema.JOB_REF, "https://example.org/example");
    JobType job = new JobType(XMPMetadata.createXMPMetadata());

    // Act
    xmpBasicJobTicketSchema.addJob(job);

    // Assert
    List<AbstractField> allProperties = xmpBasicJobTicketSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    List<JobType> jobs = xmpBasicJobTicketSchema.getJobs();
    assertEquals(2, jobs.size());
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(2, allProperties2.size());
    Map<String, String> allNamespacesWithPrefix = xmpBasicJobTicketSchema.getAllNamespacesWithPrefix();
    assertEquals(2, allNamespacesWithPrefix.size());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/bj/"));
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/sType/Job#"));
    assertSame(job, allProperties2.get(1));
    assertSame(job, jobs.get(1));
  }

  /**
   * Test {@link XMPBasicJobTicketSchema#addJob(JobType)} with {@code job}.
   * <p>
   * Method under test: {@link XMPBasicJobTicketSchema#addJob(JobType)}
   */
  @Test
  @DisplayName("Test addJob(JobType) with 'job'")
  void testAddJobWithJob3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicJobTicketSchema xmpBasicJobTicketSchema = new XMPBasicJobTicketSchema(metadata);
    xmpBasicJobTicketSchema.addBagValueAsSimple(XMPBasicJobTicketSchema.JOB_REF, "42");
    JobType job = new JobType(XMPMetadata.createXMPMetadata());

    // Act
    xmpBasicJobTicketSchema.addJob(job);

    // Assert
    List<AbstractField> allProperties = xmpBasicJobTicketSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals("http://ns.adobe.com/xap/1.0/bj/", getResult.getNamespace());
    Map<String, String> allNamespacesWithPrefix = xmpBasicJobTicketSchema.getAllNamespacesWithPrefix();
    assertEquals(2, allNamespacesWithPrefix.size());
    assertEquals("stJob", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/sType/Job#"));
    assertEquals("xmpBJ", getResult.getPrefix());
    List<JobType> jobs = xmpBasicJobTicketSchema.getJobs();
    assertEquals(1, jobs.size());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/bj/"));
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(jobs, ((ArrayProperty) getResult).getAllProperties());
    assertEquals(XMPBasicJobTicketSchema.JOB_REF, getResult.getPropertyName());
    assertSame(job, jobs.get(0));
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPBasicJobTicketSchema#addJob(JobType)} with {@code job}.
   * <p>
   * Method under test: {@link XMPBasicJobTicketSchema#addJob(JobType)}
   */
  @Test
  @DisplayName("Test addJob(JobType) with 'job'")
  void testAddJobWithJob4() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicJobTicketSchema xmpBasicJobTicketSchema = new XMPBasicJobTicketSchema(metadata);
    xmpBasicJobTicketSchema.addBagValueAsSimple("42", "Bag Value");
    xmpBasicJobTicketSchema.addBagValueAsSimple(XMPBasicJobTicketSchema.JOB_REF, "42");
    JobType job = new JobType(XMPMetadata.createXMPMetadata());

    // Act
    xmpBasicJobTicketSchema.addJob(job);

    // Assert
    List<AbstractField> allProperties = xmpBasicJobTicketSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    assertEquals("42", getResult.getPropertyName());
    assertEquals("http://ns.adobe.com/xap/1.0/bj/", getResult.getNamespace());
    Map<String, String> allNamespacesWithPrefix = xmpBasicJobTicketSchema.getAllNamespacesWithPrefix();
    assertEquals(2, allNamespacesWithPrefix.size());
    assertEquals("stJob", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/sType/Job#"));
    assertEquals("xmpBJ", getResult.getPrefix());
    List<JobType> jobs = xmpBasicJobTicketSchema.getJobs();
    assertEquals(1, jobs.size());
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/bj/"));
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(jobs, ((ArrayProperty) getResult2).getAllProperties());
    assertSame(job, jobs.get(0));
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPBasicJobTicketSchema#addJob(JobType)} with {@code job}.
   * <p>
   * Method under test: {@link XMPBasicJobTicketSchema#addJob(JobType)}
   */
  @Test
  @DisplayName("Test addJob(JobType) with 'job'")
  void testAddJobWithJob5() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicJobTicketSchema xmpBasicJobTicketSchema = new XMPBasicJobTicketSchema(metadata);
    xmpBasicJobTicketSchema.addBagValueAsSimple("Simple Name", "42");

    // Act
    xmpBasicJobTicketSchema.addJob(new JobType(XMPMetadata.createXMPMetadata()));

    // Assert
    List<AbstractField> allProperties = xmpBasicJobTicketSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals("http://ns.adobe.com/xap/1.0/bj/", getResult.getNamespace());
    assertEquals("xmpBJ", getResult.getPrefix());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPBasicJobTicketSchema.JOB_REF, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPBasicJobTicketSchema#getJobs()}.
   * <p>
   * Method under test: {@link XMPBasicJobTicketSchema#getJobs()}
   */
  @Test
  @DisplayName("Test getJobs()")
  void testGetJobs() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicJobTicketSchema xmpBasicJobTicketSchema = new XMPBasicJobTicketSchema(metadata);
    xmpBasicJobTicketSchema.addBagValueAsSimple("Simple Name", XMPBasicJobTicketSchema.JOB_REF);
    xmpBasicJobTicketSchema.addJob("42", XMPBasicJobTicketSchema.JOB_REF, "https://example.org/example");

    // Act
    List<JobType> actualJobs = xmpBasicJobTicketSchema.getJobs();

    // Assert
    assertEquals(1, actualJobs.size());
    JobType getResult = actualJobs.get(0);
    List<AbstractField> allProperties = getResult.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult2 = allProperties.get(0);
    assertTrue(getResult2 instanceof TextType);
    AbstractField getResult3 = allProperties.get(1);
    assertTrue(getResult3 instanceof TextType);
    AbstractField getResult4 = allProperties.get(2);
    assertTrue(getResult4 instanceof URLType);
    assertEquals("42", getResult.getId());
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/sType/Job#", getResult.getNamespace());
    assertEquals("https://example.org/example", getResult.getUrl());
    assertEquals("https://example.org/example", ((URLType) getResult4).getStringValue());
    assertEquals("https://example.org/example", ((URLType) getResult4).getRawValue());
    assertEquals("https://example.org/example", ((URLType) getResult4).getValue());
    assertEquals("id", getResult2.getPropertyName());
    assertEquals("name", getResult3.getPropertyName());
    Map<String, String> allNamespacesWithPrefix = getResult.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("stJob", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/sType/Job#"));
    assertEquals("stJob", getResult2.getPrefix());
    assertEquals("stJob", getResult3.getPrefix());
    assertEquals("stJob", getResult4.getPrefix());
    assertEquals("stJob", getResult.getPreferedPrefix());
    assertEquals("stJob", getResult.getPrefix());
    assertEquals("url", getResult4.getPropertyName());
    assertNull(getResult2.getNamespace());
    assertNull(getResult3.getNamespace());
    assertNull(getResult4.getNamespace());
    assertNull(getResult.getPropertyName());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(XMPBasicJobTicketSchema.JOB_REF, getResult.getName());
    assertEquals(XMPBasicJobTicketSchema.JOB_REF, ((TextType) getResult3).getStringValue());
    assertEquals(XMPBasicJobTicketSchema.JOB_REF, ((TextType) getResult3).getRawValue());
    assertEquals(XMPBasicJobTicketSchema.JOB_REF, ((TextType) getResult3).getValue());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPBasicJobTicketSchema#getJobs()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPBasicJobTicketSchema#getJobs()}
   */
  @Test
  @DisplayName("Test getJobs(); then return 'null'")
  void testGetJobs_thenReturnNull() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new XMPBasicJobTicketSchema(XMPMetadata.createXMPMetadata())).getJobs());
  }

  /**
   * Test {@link XMPBasicJobTicketSchema#getJobs()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPBasicJobTicketSchema#getJobs()}
   */
  @Test
  @DisplayName("Test getJobs(); then return size is one")
  void testGetJobs_thenReturnSizeIsOne() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicJobTicketSchema xmpBasicJobTicketSchema = new XMPBasicJobTicketSchema(metadata);
    xmpBasicJobTicketSchema.addJob("42", XMPBasicJobTicketSchema.JOB_REF, "https://example.org/example");

    // Act
    List<JobType> actualJobs = xmpBasicJobTicketSchema.getJobs();

    // Assert
    assertEquals(1, actualJobs.size());
    JobType getResult = actualJobs.get(0);
    List<AbstractField> allProperties = getResult.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult2 = allProperties.get(0);
    assertTrue(getResult2 instanceof TextType);
    AbstractField getResult3 = allProperties.get(1);
    assertTrue(getResult3 instanceof TextType);
    AbstractField getResult4 = allProperties.get(2);
    assertTrue(getResult4 instanceof URLType);
    assertEquals("42", getResult.getId());
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/sType/Job#", getResult.getNamespace());
    assertEquals("https://example.org/example", getResult.getUrl());
    assertEquals("https://example.org/example", ((URLType) getResult4).getStringValue());
    assertEquals("https://example.org/example", ((URLType) getResult4).getRawValue());
    assertEquals("https://example.org/example", ((URLType) getResult4).getValue());
    assertEquals("id", getResult2.getPropertyName());
    assertEquals("name", getResult3.getPropertyName());
    Map<String, String> allNamespacesWithPrefix = getResult.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("stJob", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/sType/Job#"));
    assertEquals("stJob", getResult2.getPrefix());
    assertEquals("stJob", getResult3.getPrefix());
    assertEquals("stJob", getResult4.getPrefix());
    assertEquals("stJob", getResult.getPreferedPrefix());
    assertEquals("stJob", getResult.getPrefix());
    assertEquals("url", getResult4.getPropertyName());
    assertNull(getResult2.getNamespace());
    assertNull(getResult3.getNamespace());
    assertNull(getResult4.getNamespace());
    assertNull(getResult.getPropertyName());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(XMPBasicJobTicketSchema.JOB_REF, getResult.getName());
    assertEquals(XMPBasicJobTicketSchema.JOB_REF, ((TextType) getResult3).getStringValue());
    assertEquals(XMPBasicJobTicketSchema.JOB_REF, ((TextType) getResult3).getRawValue());
    assertEquals(XMPBasicJobTicketSchema.JOB_REF, ((TextType) getResult3).getValue());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPBasicJobTicketSchema#getJobs()}.
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPBasicJobTicketSchema#getJobs()}
   */
  @Test
  @DisplayName("Test getJobs(); then throw BadFieldValueException")
  void testGetJobs_thenThrowBadFieldValueException() throws BadFieldValueException {
    // Arrange
    XMPBasicJobTicketSchema xmpBasicJobTicketSchema = new XMPBasicJobTicketSchema(XMPMetadata.createXMPMetadata());
    xmpBasicJobTicketSchema.addBagValueAsSimple(XMPBasicJobTicketSchema.JOB_REF, "42");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> xmpBasicJobTicketSchema.getJobs());
  }
}

package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.type.AbstractField;
import org.apache.xmpbox.type.ArrayProperty;
import org.apache.xmpbox.type.BadFieldValueException;
import org.apache.xmpbox.type.Cardinality;
import org.apache.xmpbox.type.JobType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class XMPBasicJobTicketSchemaDiffblueTest {
  /**
   * Test {@link XMPBasicJobTicketSchema#XMPBasicJobTicketSchema(XMPMetadata)}.
   * <p>
   * Method under test: {@link XMPBasicJobTicketSchema#XMPBasicJobTicketSchema(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new XMPBasicJobTicketSchema(XMPMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XMPBasicJobTicketSchema.<init>(XMPMetadata)"})
  void testNewXMPBasicJobTicketSchema() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPBasicJobTicketSchema actualXmpBasicJobTicketSchema = new XMPBasicJobTicketSchema(metadata);

    // Assert
    assertEquals("", actualXmpBasicJobTicketSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/xap/1.0/bj/", actualXmpBasicJobTicketSchema.getNamespace());
    assertEquals("xmpBJ", actualXmpBasicJobTicketSchema.getPreferedPrefix());
    assertEquals("xmpBJ", actualXmpBasicJobTicketSchema.getPrefix());
    assertNull(actualXmpBasicJobTicketSchema.getPropertyName());
    assertNull(actualXmpBasicJobTicketSchema.getJobs());
    assertNull(actualXmpBasicJobTicketSchema.getAboutAttribute());
    Map<String, String> allNamespacesWithPrefix = actualXmpBasicJobTicketSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualXmpBasicJobTicketSchema.getAllProperties().isEmpty());
    assertTrue(actualXmpBasicJobTicketSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/bj/"));
    assertSame(metadata, actualXmpBasicJobTicketSchema.getMetadata());
  }

  /**
   * Test {@link XMPBasicJobTicketSchema#XMPBasicJobTicketSchema(XMPMetadata, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Prefix is {@code xmpBJ}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPBasicJobTicketSchema#XMPBasicJobTicketSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName("Test new XMPBasicJobTicketSchema(XMPMetadata, String); when 'null'; then return Prefix is 'xmpBJ'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XMPBasicJobTicketSchema.<init>(XMPMetadata, String)"})
  void testNewXMPBasicJobTicketSchema_whenNull_thenReturnPrefixIsXmpBJ() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPBasicJobTicketSchema actualXmpBasicJobTicketSchema = new XMPBasicJobTicketSchema(metadata, null);

    // Assert
    assertEquals("", actualXmpBasicJobTicketSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/xap/1.0/bj/", actualXmpBasicJobTicketSchema.getNamespace());
    assertEquals("xmpBJ", actualXmpBasicJobTicketSchema.getPreferedPrefix());
    assertEquals("xmpBJ", actualXmpBasicJobTicketSchema.getPrefix());
    assertNull(actualXmpBasicJobTicketSchema.getPropertyName());
    assertNull(actualXmpBasicJobTicketSchema.getJobs());
    assertNull(actualXmpBasicJobTicketSchema.getAboutAttribute());
    Map<String, String> allNamespacesWithPrefix = actualXmpBasicJobTicketSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualXmpBasicJobTicketSchema.getAllProperties().isEmpty());
    assertTrue(actualXmpBasicJobTicketSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/bj/"));
    assertSame(metadata, actualXmpBasicJobTicketSchema.getMetadata());
  }

  /**
   * Test {@link XMPBasicJobTicketSchema#XMPBasicJobTicketSchema(XMPMetadata, String)}.
   * <ul>
   *   <li>When {@code Own Prefix}.</li>
   *   <li>Then return Prefix is {@code Own Prefix}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPBasicJobTicketSchema#XMPBasicJobTicketSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName("Test new XMPBasicJobTicketSchema(XMPMetadata, String); when 'Own Prefix'; then return Prefix is 'Own Prefix'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XMPBasicJobTicketSchema.<init>(XMPMetadata, String)"})
  void testNewXMPBasicJobTicketSchema_whenOwnPrefix_thenReturnPrefixIsOwnPrefix() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPBasicJobTicketSchema actualXmpBasicJobTicketSchema = new XMPBasicJobTicketSchema(metadata, "Own Prefix");

    // Assert
    assertEquals("", actualXmpBasicJobTicketSchema.getAboutValue());
    assertEquals("Own Prefix", actualXmpBasicJobTicketSchema.getPrefix());
    assertEquals("http://ns.adobe.com/xap/1.0/bj/", actualXmpBasicJobTicketSchema.getNamespace());
    assertEquals("xmpBJ", actualXmpBasicJobTicketSchema.getPreferedPrefix());
    assertNull(actualXmpBasicJobTicketSchema.getPropertyName());
    assertNull(actualXmpBasicJobTicketSchema.getJobs());
    assertNull(actualXmpBasicJobTicketSchema.getAboutAttribute());
    Map<String, String> allNamespacesWithPrefix = actualXmpBasicJobTicketSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualXmpBasicJobTicketSchema.getAllProperties().isEmpty());
    assertTrue(actualXmpBasicJobTicketSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/bj/"));
    assertSame(metadata, actualXmpBasicJobTicketSchema.getMetadata());
  }

  /**
   * Test {@link XMPBasicJobTicketSchema#addJob(String, String, String)} with {@code id}, {@code name}, {@code url}.
   * <p>
   * Method under test: {@link XMPBasicJobTicketSchema#addJob(String, String, String)}
   */
  @Test
  @DisplayName("Test addJob(String, String, String) with 'id', 'name', 'url'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XMPBasicJobTicketSchema.addJob(String, String, String)"})
  void testAddJobWithIdNameUrl() throws BadFieldValueException {
    // Arrange
    XMPBasicJobTicketSchema xmpBasicJobTicketSchema = new XMPBasicJobTicketSchema(XMPMetadata.createXMPMetadata());

    // Act
    xmpBasicJobTicketSchema.addJob("42", "Name", "https://example.org/example");

    // Assert
    List<AbstractField> allProperties = xmpBasicJobTicketSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    Map<String, String> allNamespacesWithPrefix = xmpBasicJobTicketSchema.getAllNamespacesWithPrefix();
    assertEquals(2, allNamespacesWithPrefix.size());
    assertEquals("stJob", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/sType/Job#"));
    assertEquals(1, xmpBasicJobTicketSchema.getJobs().size());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/bj/"));
  }

  /**
   * Test {@link XMPBasicJobTicketSchema#addJob(String, String, String)} with {@code id}, {@code name}, {@code url}.
   * <p>
   * Method under test: {@link XMPBasicJobTicketSchema#addJob(String, String, String)}
   */
  @Test
  @DisplayName("Test addJob(String, String, String) with 'id', 'name', 'url'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XMPBasicJobTicketSchema.addJob(String, String, String)"})
  void testAddJobWithIdNameUrl2() throws BadFieldValueException {
    // Arrange
    XMPBasicJobTicketSchema xmpBasicJobTicketSchema = new XMPBasicJobTicketSchema(XMPMetadata.createXMPMetadata());
    xmpBasicJobTicketSchema.addJob("42", "id", "https://example.org/example");

    // Act
    xmpBasicJobTicketSchema.addJob("42", "Name", "https://example.org/example");

    // Assert
    List<AbstractField> allProperties = xmpBasicJobTicketSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    Map<String, String> allNamespacesWithPrefix = xmpBasicJobTicketSchema.getAllNamespacesWithPrefix();
    assertEquals(2, allNamespacesWithPrefix.size());
    assertEquals("stJob", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/sType/Job#"));
    assertEquals(2, xmpBasicJobTicketSchema.getJobs().size());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/bj/"));
  }

  /**
   * Test {@link XMPBasicJobTicketSchema#addJob(String, String, String, String)} with {@code id}, {@code name}, {@code url}, {@code fieldPrefix}.
   * <p>
   * Method under test: {@link XMPBasicJobTicketSchema#addJob(String, String, String, String)}
   */
  @Test
  @DisplayName("Test addJob(String, String, String, String) with 'id', 'name', 'url', 'fieldPrefix'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XMPBasicJobTicketSchema.addJob(String, String, String, String)"})
  void testAddJobWithIdNameUrlFieldPrefix() throws BadFieldValueException {
    // Arrange
    XMPBasicJobTicketSchema xmpBasicJobTicketSchema = new XMPBasicJobTicketSchema(XMPMetadata.createXMPMetadata());

    // Act
    xmpBasicJobTicketSchema.addJob("42", "Name", "https://example.org/example", "Field Prefix");

    // Assert
    List<AbstractField> allProperties = xmpBasicJobTicketSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    Map<String, String> allNamespacesWithPrefix = xmpBasicJobTicketSchema.getAllNamespacesWithPrefix();
    assertEquals(2, allNamespacesWithPrefix.size());
    assertEquals("stJob", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/sType/Job#"));
    assertEquals(1, xmpBasicJobTicketSchema.getJobs().size());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/bj/"));
  }

  /**
   * Test {@link XMPBasicJobTicketSchema#addJob(String, String, String, String)} with {@code id}, {@code name}, {@code url}, {@code fieldPrefix}.
   * <p>
   * Method under test: {@link XMPBasicJobTicketSchema#addJob(String, String, String, String)}
   */
  @Test
  @DisplayName("Test addJob(String, String, String, String) with 'id', 'name', 'url', 'fieldPrefix'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XMPBasicJobTicketSchema.addJob(String, String, String, String)"})
  void testAddJobWithIdNameUrlFieldPrefix2() throws BadFieldValueException {
    // Arrange
    XMPBasicJobTicketSchema xmpBasicJobTicketSchema = new XMPBasicJobTicketSchema(XMPMetadata.createXMPMetadata());
    xmpBasicJobTicketSchema.addJob("42", "id", "https://example.org/example");

    // Act
    xmpBasicJobTicketSchema.addJob("42", "Name", "https://example.org/example", "Field Prefix");

    // Assert
    List<AbstractField> allProperties = xmpBasicJobTicketSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    Map<String, String> allNamespacesWithPrefix = xmpBasicJobTicketSchema.getAllNamespacesWithPrefix();
    assertEquals(2, allNamespacesWithPrefix.size());
    assertEquals("stJob", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/sType/Job#"));
    assertEquals(2, xmpBasicJobTicketSchema.getJobs().size());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/bj/"));
  }

  /**
   * Test {@link XMPBasicJobTicketSchema#addJob(JobType)} with {@code job}.
   * <p>
   * Method under test: {@link XMPBasicJobTicketSchema#addJob(JobType)}
   */
  @Test
  @DisplayName("Test addJob(JobType) with 'job'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XMPBasicJobTicketSchema.addJob(JobType)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XMPBasicJobTicketSchema.addJob(JobType)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XMPBasicJobTicketSchema.addJob(JobType)"})
  void testAddJobWithJob3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicJobTicketSchema xmpBasicJobTicketSchema = new XMPBasicJobTicketSchema(metadata);
    xmpBasicJobTicketSchema.addBagValueAsSimple(XMPBasicJobTicketSchema.JOB_REF, "42");

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XMPBasicJobTicketSchema.addJob(JobType)"})
  void testAddJobWithJob4() throws BadFieldValueException {
    // Arrange
    XMPBasicJobTicketSchema xmpBasicJobTicketSchema = new XMPBasicJobTicketSchema(XMPMetadata.createXMPMetadata());
    xmpBasicJobTicketSchema.addBagValueAsSimple("42", "Bag Value");
    xmpBasicJobTicketSchema.addBagValueAsSimple(XMPBasicJobTicketSchema.JOB_REF, "42");
    JobType job = new JobType(XMPMetadata.createXMPMetadata());

    // Act
    xmpBasicJobTicketSchema.addJob(job);

    // Assert
    Map<String, String> allNamespacesWithPrefix = xmpBasicJobTicketSchema.getAllNamespacesWithPrefix();
    assertEquals(2, allNamespacesWithPrefix.size());
    assertEquals("stJob", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/sType/Job#"));
    List<JobType> jobs = xmpBasicJobTicketSchema.getJobs();
    assertEquals(1, jobs.size());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/bj/"));
    assertSame(job, jobs.get(0));
  }

  /**
   * Test {@link XMPBasicJobTicketSchema#addJob(JobType)} with {@code job}.
   * <p>
   * Method under test: {@link XMPBasicJobTicketSchema#addJob(JobType)}
   */
  @Test
  @DisplayName("Test addJob(JobType) with 'job'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XMPBasicJobTicketSchema.addJob(JobType)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List XMPBasicJobTicketSchema.getJobs()"})
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
    assertEquals("42", getResult.getId());
    assertEquals("http://ns.adobe.com/xap/1.0/sType/Job#", getResult.getNamespace());
    assertEquals("https://example.org/example", getResult.getUrl());
    assertEquals("stJob", getResult.getPreferedPrefix());
    assertEquals("stJob", getResult.getPrefix());
    assertNull(getResult.getPropertyName());
    Map<String, String> allNamespacesWithPrefix = getResult.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals(3, getResult.getAllProperties().size());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/sType/Job#"));
    assertEquals(XMPBasicJobTicketSchema.JOB_REF, getResult.getName());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List XMPBasicJobTicketSchema.getJobs()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List XMPBasicJobTicketSchema.getJobs()"})
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
    assertEquals("42", getResult.getId());
    assertEquals("http://ns.adobe.com/xap/1.0/sType/Job#", getResult.getNamespace());
    assertEquals("https://example.org/example", getResult.getUrl());
    assertEquals("stJob", getResult.getPreferedPrefix());
    assertEquals("stJob", getResult.getPrefix());
    assertNull(getResult.getPropertyName());
    Map<String, String> allNamespacesWithPrefix = getResult.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals(3, getResult.getAllProperties().size());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/sType/Job#"));
    assertEquals(XMPBasicJobTicketSchema.JOB_REF, getResult.getName());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List XMPBasicJobTicketSchema.getJobs()"})
  void testGetJobs_thenThrowBadFieldValueException() throws BadFieldValueException {
    // Arrange
    XMPBasicJobTicketSchema xmpBasicJobTicketSchema = new XMPBasicJobTicketSchema(XMPMetadata.createXMPMetadata());
    xmpBasicJobTicketSchema.addBagValueAsSimple(XMPBasicJobTicketSchema.JOB_REF, "42");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> xmpBasicJobTicketSchema.getJobs());
  }
}

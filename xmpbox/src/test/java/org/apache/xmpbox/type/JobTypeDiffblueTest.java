package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class JobTypeDiffblueTest {
  /**
   * Method under test: {@link JobType#setId(String)}
   */
  @Test
  void testSetId() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    JobType jobType = new JobType(metadata);

    // Act
    jobType.setId("42");

    // Assert
    List<AbstractField> allProperties = jobType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("42", jobType.getId());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("stJob", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(JobType.ID, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link JobType#setName(String)}
   */
  @Test
  void testSetName() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    JobType jobType = new JobType(metadata);

    // Act
    jobType.setName("Name");

    // Assert
    List<AbstractField> allProperties = jobType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("Name", jobType.getName());
    assertEquals("Name", ((TextType) getResult).getStringValue());
    assertEquals("Name", ((TextType) getResult).getRawValue());
    assertEquals("Name", ((TextType) getResult).getValue());
    assertEquals("stJob", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(JobType.NAME, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link JobType#setUrl(String)}
   */
  @Test
  void testSetUrl() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    JobType jobType = new JobType(metadata);

    // Act
    jobType.setUrl("https://example.org/example");

    // Assert
    List<AbstractField> allProperties = jobType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof URLType);
    assertEquals("https://example.org/example", jobType.getUrl());
    assertEquals("https://example.org/example", ((URLType) getResult).getStringValue());
    assertEquals("https://example.org/example", ((URLType) getResult).getRawValue());
    assertEquals("https://example.org/example", ((URLType) getResult).getValue());
    assertEquals("stJob", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(JobType.URL, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link JobType#getId()}
   */
  @Test
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new JobType(XMPMetadata.createXMPMetadata())).getId());
  }

  /**
   * Method under test: {@link JobType#getId()}
   */
  @Test
  void testGetId2() {
    // Arrange
    JobType jobType = new JobType(XMPMetadata.createXMPMetadata());
    jobType.addSimpleProperty(JobType.ID, "Value");

    // Act and Assert
    assertEquals("Value", jobType.getId());
  }

  /**
   * Method under test: {@link JobType#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertNull((new JobType(XMPMetadata.createXMPMetadata())).getName());
  }

  /**
   * Method under test: {@link JobType#getName()}
   */
  @Test
  void testGetName2() {
    // Arrange
    JobType jobType = new JobType(XMPMetadata.createXMPMetadata());
    jobType.addSimpleProperty(JobType.NAME, "Value");

    // Act and Assert
    assertEquals("Value", jobType.getName());
  }

  /**
   * Method under test: {@link JobType#getUrl()}
   */
  @Test
  void testGetUrl() {
    // Arrange, Act and Assert
    assertNull((new JobType(XMPMetadata.createXMPMetadata())).getUrl());
  }

  /**
   * Method under test: {@link JobType#getUrl()}
   */
  @Test
  void testGetUrl2() {
    // Arrange
    JobType jobType = new JobType(XMPMetadata.createXMPMetadata());
    jobType.addSimpleProperty(JobType.URL, "Value");

    // Act and Assert
    assertEquals("Value", jobType.getUrl());
  }

  /**
   * Method under test: {@link JobType#JobType(XMPMetadata)}
   */
  @Test
  void testNewJobType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    JobType actualJobType = new JobType(metadata);

    // Assert
    assertEquals("http://ns.adobe.com/xap/1.0/sType/Job#", actualJobType.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualJobType.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("stJob", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/sType/Job#"));
    assertEquals("stJob", actualJobType.getPreferedPrefix());
    assertEquals("stJob", actualJobType.getPrefix());
    assertNull(actualJobType.getPropertyName());
    assertNull(actualJobType.getId());
    assertNull(actualJobType.getName());
    assertNull(actualJobType.getUrl());
    List<AbstractField> allProperties = actualJobType.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualJobType.getAllAttributes().isEmpty());
    assertSame(allProperties, actualJobType.getContainer().getAllProperties());
    assertSame(metadata, actualJobType.getMetadata());
  }

  /**
   * Method under test: {@link JobType#JobType(XMPMetadata, String)}
   */
  @Test
  void testNewJobType2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    JobType actualJobType = new JobType(metadata, "Field Prefix");

    // Assert
    assertEquals("http://ns.adobe.com/xap/1.0/sType/Job#", actualJobType.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualJobType.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("stJob", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/sType/Job#"));
    assertEquals("stJob", actualJobType.getPreferedPrefix());
    assertEquals("stJob", actualJobType.getPrefix());
    assertNull(actualJobType.getPropertyName());
    assertNull(actualJobType.getId());
    assertNull(actualJobType.getName());
    assertNull(actualJobType.getUrl());
    List<AbstractField> allProperties = actualJobType.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualJobType.getAllAttributes().isEmpty());
    assertSame(allProperties, actualJobType.getContainer().getAllProperties());
    assertSame(metadata, actualJobType.getMetadata());
  }
}

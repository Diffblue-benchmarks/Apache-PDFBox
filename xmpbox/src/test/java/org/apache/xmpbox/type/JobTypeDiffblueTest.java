package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JobTypeDiffblueTest {
  /**
   * Test {@link JobType#JobType(XMPMetadata)}.
   * <p>
   * Method under test: {@link JobType#JobType(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new JobType(XMPMetadata)")
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
   * Test {@link JobType#JobType(XMPMetadata, String)}.
   * <p>
   * Method under test: {@link JobType#JobType(XMPMetadata, String)}
   */
  @Test
  @DisplayName("Test new JobType(XMPMetadata, String)")
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

  /**
   * Test {@link JobType#setId(String)}.
   * <ul>
   *   <li>Then {@link JobType#JobType(XMPMetadata)} with metadata is
   * createXMPMetadata AllProperties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#setId(String)}
   */
  @Test
  @DisplayName("Test setId(String); then JobType(XMPMetadata) with metadata is createXMPMetadata AllProperties size is one")
  void testSetId_thenJobTypeWithMetadataIsCreateXMPMetadataAllPropertiesSizeIsOne() {
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
   * Test {@link JobType#setName(String)}.
   * <ul>
   *   <li>Then {@link JobType#JobType(XMPMetadata)} with metadata is
   * createXMPMetadata AllProperties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String); then JobType(XMPMetadata) with metadata is createXMPMetadata AllProperties size is one")
  void testSetName_thenJobTypeWithMetadataIsCreateXMPMetadataAllPropertiesSizeIsOne() {
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
   * Test {@link JobType#setUrl(String)}.
   * <ul>
   *   <li>Then {@link JobType#JobType(XMPMetadata)} with metadata is
   * createXMPMetadata AllProperties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#setUrl(String)}
   */
  @Test
  @DisplayName("Test setUrl(String); then JobType(XMPMetadata) with metadata is createXMPMetadata AllProperties size is one")
  void testSetUrl_thenJobTypeWithMetadataIsCreateXMPMetadataAllPropertiesSizeIsOne() {
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
   * Test {@link JobType#getId()}.
   * <ul>
   *   <li>Given {@link JobType#JobType(XMPMetadata)} with metadata is
   * createXMPMetadata.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#getId()}
   */
  @Test
  @DisplayName("Test getId(); given JobType(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  void testGetId_givenJobTypeWithMetadataIsCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new JobType(XMPMetadata.createXMPMetadata())).getId());
  }

  /**
   * Test {@link JobType#getId()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#getId()}
   */
  @Test
  @DisplayName("Test getId(); then return 'Value'")
  void testGetId_thenReturnValue() {
    // Arrange
    JobType jobType = new JobType(XMPMetadata.createXMPMetadata());
    jobType.addSimpleProperty(JobType.ID, "Value");

    // Act and Assert
    assertEquals("Value", jobType.getId());
  }

  /**
   * Test {@link JobType#getName()}.
   * <ul>
   *   <li>Given {@link JobType#JobType(XMPMetadata)} with metadata is
   * createXMPMetadata.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#getName()}
   */
  @Test
  @DisplayName("Test getName(); given JobType(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  void testGetName_givenJobTypeWithMetadataIsCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new JobType(XMPMetadata.createXMPMetadata())).getName());
  }

  /**
   * Test {@link JobType#getName()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#getName()}
   */
  @Test
  @DisplayName("Test getName(); then return 'Value'")
  void testGetName_thenReturnValue() {
    // Arrange
    JobType jobType = new JobType(XMPMetadata.createXMPMetadata());
    jobType.addSimpleProperty(JobType.NAME, "Value");

    // Act and Assert
    assertEquals("Value", jobType.getName());
  }

  /**
   * Test {@link JobType#getUrl()}.
   * <ul>
   *   <li>Given {@link JobType#JobType(XMPMetadata)} with metadata is
   * createXMPMetadata.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#getUrl()}
   */
  @Test
  @DisplayName("Test getUrl(); given JobType(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  void testGetUrl_givenJobTypeWithMetadataIsCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new JobType(XMPMetadata.createXMPMetadata())).getUrl());
  }

  /**
   * Test {@link JobType#getUrl()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#getUrl()}
   */
  @Test
  @DisplayName("Test getUrl(); then return 'Value'")
  void testGetUrl_thenReturnValue() {
    // Arrange
    JobType jobType = new JobType(XMPMetadata.createXMPMetadata());
    jobType.addSimpleProperty(JobType.URL, "Value");

    // Act and Assert
    assertEquals("Value", jobType.getUrl());
  }
}

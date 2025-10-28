package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.List;
import org.junit.jupiter.api.Test;

class PropertiesDescriptionDiffblueTest {
  /**
   * Method under test: {@link PropertiesDescription#getPropertiesName()}
   */
  @Test
  void testGetPropertiesName() {
    // Arrange, Act and Assert
    assertTrue((new PropertiesDescription()).getPropertiesName().isEmpty());
  }

  /**
   * Method under test: {@link PropertiesDescription#getPropertiesName()}
   */
  @Test
  void testGetPropertiesName2() {
    // Arrange
    PropertiesDescription propertiesDescription = new PropertiesDescription();
    propertiesDescription.addNewProperty("Name", mock(PropertyType.class));

    // Act
    List<String> actualPropertiesName = propertiesDescription.getPropertiesName();

    // Assert
    assertEquals(1, actualPropertiesName.size());
    assertEquals("Name", actualPropertiesName.get(0));
  }

  /**
   * Method under test:
   * {@link PropertiesDescription#addNewProperty(String, PropertyType)}
   */
  @Test
  void testAddNewProperty() {
    // Arrange
    PropertiesDescription propertiesDescription = new PropertiesDescription();

    // Act
    propertiesDescription.addNewProperty("Name", mock(PropertyType.class));

    // Assert
    List<String> propertiesName = propertiesDescription.getPropertiesName();
    assertEquals(1, propertiesName.size());
    assertEquals("Name", propertiesName.get(0));
  }

  /**
   * Method under test: {@link PropertiesDescription#getPropertyType(String)}
   */
  @Test
  void testGetPropertyType() {
    // Arrange, Act and Assert
    assertNull((new PropertiesDescription()).getPropertyType("Name"));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PropertiesDescription}
   */
  @Test
  void testNewPropertiesDescription() {
    // Arrange, Act and Assert
    assertTrue((new PropertiesDescription()).getPropertiesName().isEmpty());
  }
}

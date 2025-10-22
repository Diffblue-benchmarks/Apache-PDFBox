package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PropertiesDescriptionDiffblueTest {
  /**
   * Test new {@link PropertiesDescription} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link PropertiesDescription}
   */
  @Test
  @DisplayName("Test new PropertiesDescription (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PropertiesDescription.<init>()"})
  void testNewPropertiesDescription() {
    // Arrange, Act and Assert
    assertTrue((new PropertiesDescription()).getPropertiesName().isEmpty());
  }

  /**
   * Test {@link PropertiesDescription#getPropertiesName()}.
   * <p>
   * Method under test: {@link PropertiesDescription#getPropertiesName()}
   */
  @Test
  @DisplayName("Test getPropertiesName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PropertiesDescription.getPropertiesName()"})
  void testGetPropertiesName() {
    // Arrange, Act and Assert
    assertTrue((new PropertiesDescription()).getPropertiesName().isEmpty());
  }

  /**
   * Test {@link PropertiesDescription#addNewProperty(String, PropertyType)}.
   * <p>
   * Method under test: {@link PropertiesDescription#addNewProperty(String, PropertyType)}
   */
  @Test
  @DisplayName("Test addNewProperty(String, PropertyType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PropertiesDescription.addNewProperty(String, PropertyType)"})
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
   * Test {@link PropertiesDescription#getPropertyType(String)}.
   * <p>
   * Method under test: {@link PropertiesDescription#getPropertyType(String)}
   */
  @Test
  @DisplayName("Test getPropertyType(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyType PropertiesDescription.getPropertyType(String)"})
  void testGetPropertyType() {
    // Arrange, Act and Assert
    assertNull((new PropertiesDescription()).getPropertyType("Name"));
  }
}

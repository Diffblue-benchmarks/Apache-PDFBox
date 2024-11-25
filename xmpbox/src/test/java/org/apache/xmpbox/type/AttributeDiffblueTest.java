package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AttributeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Attribute#Attribute(String, String, String)}
   *   <li>{@link Attribute#setName(String)}
   *   <li>{@link Attribute#setNsURI(String)}
   *   <li>{@link Attribute#setValue(String)}
   *   <li>{@link Attribute#toString()}
   *   <li>{@link Attribute#getName()}
   *   <li>{@link Attribute#getNamespace()}
   *   <li>{@link Attribute#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    Attribute actualAttribute = new Attribute("Ns URI", "Local Name", "42");
    actualAttribute.setName("Lname");
    actualAttribute.setNsURI("Ns URI");
    actualAttribute.setValue("42");
    String actualToStringResult = actualAttribute.toString();
    String actualName = actualAttribute.getName();
    String actualNamespace = actualAttribute.getNamespace();

    // Assert that nothing has changed
    assertEquals("42", actualAttribute.getValue());
    assertEquals("Lname", actualName);
    assertEquals("Ns URI", actualNamespace);
    assertEquals("[attr:{Ns URI}Lname=42]", actualToStringResult);
  }
}

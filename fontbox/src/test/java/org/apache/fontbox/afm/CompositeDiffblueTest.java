package org.apache.fontbox.afm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;

class CompositeDiffblueTest {
  /**
   * Method under test: {@link Composite#addPart(CompositePart)}
   */
  @Test
  void testAddPart() {
    // Arrange
    Composite composite = new Composite("Name");
    CompositePart part = new CompositePart("Name", 1, 1);

    // Act
    composite.addPart(part);

    // Assert
    List<CompositePart> parts = composite.getParts();
    assertEquals(1, parts.size());
    assertSame(part, parts.get(0));
  }

  /**
   * Method under test: {@link Composite#getParts()}
   */
  @Test
  void testGetParts() {
    // Arrange, Act and Assert
    assertTrue((new Composite("Name")).getParts().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Composite#Composite(String)}
   *   <li>{@link Composite#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Name", (new Composite("Name")).getName());
  }
}

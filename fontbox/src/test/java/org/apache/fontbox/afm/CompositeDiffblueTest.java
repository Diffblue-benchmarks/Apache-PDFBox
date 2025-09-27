package org.apache.fontbox.afm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CompositeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Composite#Composite(String)}
   *   <li>{@link Composite#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Composite.<init>(String)", "String Composite.getName()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Name", new Composite("Name").getName());
  }

  /**
   * Test {@link Composite#addPart(CompositePart)}.
   *
   * <p>Method under test: {@link Composite#addPart(CompositePart)}
   */
  @Test
  @DisplayName("Test addPart(CompositePart)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Composite.addPart(CompositePart)"})
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
   * Test {@link Composite#getParts()}.
   *
   * <p>Method under test: {@link Composite#getParts()}
   */
  @Test
  @DisplayName("Test getParts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Composite.getParts()"})
  void testGetParts() {
    // Arrange, Act and Assert
    assertTrue(new Composite("Name").getParts().isEmpty());
  }
}

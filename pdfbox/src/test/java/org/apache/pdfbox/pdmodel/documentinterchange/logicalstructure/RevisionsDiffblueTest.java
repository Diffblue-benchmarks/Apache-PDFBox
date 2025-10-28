package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class RevisionsDiffblueTest {
  /**
   * Method under test: {@link Revisions#getObject(int)}
   */
  @Test
  void testGetObject() {
    // Arrange
    Revisions<Object> revisions = new Revisions<>();
    revisions.addObject("Object", 2);
    revisions.addObject("Object", 10);

    // Act and Assert
    assertEquals("Object", revisions.getObject(1));
  }

  /**
   * Method under test: {@link Revisions#getRevisionNumber(int)}
   */
  @Test
  void testGetRevisionNumber() {
    // Arrange
    Revisions<Object> revisions = new Revisions<>();
    revisions.addObject("Object", 2);
    revisions.addObject("Object", 10);

    // Act and Assert
    assertEquals(10, revisions.getRevisionNumber(1));
  }

  /**
   * Method under test: {@link Revisions#addObject(Object, int)}
   */
  @Test
  void testAddObject() {
    // Arrange
    Revisions<Object> revisions = new Revisions<>();

    // Act
    revisions.addObject("Object", 10);

    // Assert
    assertEquals(1, revisions.size());
  }

  /**
   * Method under test: {@link Revisions#addObject(Object, int)}
   */
  @Test
  void testAddObject2() {
    // Arrange
    Revisions<Object> revisions = new Revisions<>();
    revisions.addObject("Object", 10);

    // Act
    revisions.addObject("Object", 10);

    // Assert
    assertEquals(2, revisions.size());
  }

  /**
   * Method under test: {@link Revisions#size()}
   */
  @Test
  void testSize() {
    // Arrange
    Revisions<Object> revisions = new Revisions<>();

    // Act and Assert
    assertEquals(0, revisions.size());
  }

  /**
   * Method under test: {@link Revisions#size()}
   */
  @Test
  void testSize2() {
    // Arrange
    Revisions<Object> revisions = new Revisions<>();
    revisions.addObject("Object", 10);

    // Act and Assert
    assertEquals(1, revisions.size());
  }

  /**
   * Method under test: {@link Revisions#toString()}
   */
  @Test
  void testToString() {
    // Arrange
    Revisions<Object> revisions = new Revisions<>();

    // Act and Assert
    assertEquals("{}", revisions.toString());
  }

  /**
   * Method under test: {@link Revisions#toString()}
   */
  @Test
  void testToString2() {
    // Arrange
    Revisions<Object> revisions = new Revisions<>();
    revisions.addObject("Object", 10);

    // Act and Assert
    assertEquals("{object=Object, revisionNumber=10}", revisions.toString());
  }

  /**
   * Method under test: default or parameterless constructor of {@link Revisions}
   */
  @Test
  void testNewRevisions() {
    // Arrange and Act
    Revisions<Object> actualRevisions = new Revisions<>();

    // Assert
    assertEquals(0, actualRevisions.size());
  }
}

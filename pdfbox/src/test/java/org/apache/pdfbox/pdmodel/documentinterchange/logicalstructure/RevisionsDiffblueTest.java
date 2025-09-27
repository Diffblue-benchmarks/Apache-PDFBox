package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RevisionsDiffblueTest {
  /**
   * Test new {@link Revisions} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Revisions}
   */
  @Test
  @DisplayName("Test new Revisions (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Revisions.<init>()"})
  void testNewRevisions() {
    // Arrange and Act
    Revisions<Object> actualRevisions = new Revisions<>();

    // Assert
    assertEquals(0, actualRevisions.size());
  }

  /**
   * Test {@link Revisions#getObject(int)}.
   *
   * <ul>
   *   <li>Given {@link Revisions} (default constructor) addObject {@code Object} and two.
   *   <li>Then return {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link Revisions#getObject(int)}
   */
  @Test
  @DisplayName(
      "Test getObject(int); given Revisions (default constructor) addObject 'Object' and two; then return 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Revisions.getObject(int)"})
  void testGetObject_givenRevisionsAddObjectObjectAndTwo_thenReturnObject() {
    // Arrange
    Revisions<Object> revisions = new Revisions<>();
    revisions.addObject("Object", 2);
    revisions.addObject("Object", 10);

    // Act and Assert
    assertEquals("Object", revisions.getObject(1));
  }

  /**
   * Test {@link Revisions#getRevisionNumber(int)}.
   *
   * <ul>
   *   <li>Given {@link Revisions} (default constructor) addObject {@code Object} and two.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link Revisions#getRevisionNumber(int)}
   */
  @Test
  @DisplayName(
      "Test getRevisionNumber(int); given Revisions (default constructor) addObject 'Object' and two; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Revisions.getRevisionNumber(int)"})
  void testGetRevisionNumber_givenRevisionsAddObjectObjectAndTwo_thenReturnTen() {
    // Arrange
    Revisions<Object> revisions = new Revisions<>();
    revisions.addObject("Object", 2);
    revisions.addObject("Object", 10);

    // Act and Assert
    assertEquals(10, revisions.getRevisionNumber(1));
  }

  /**
   * Test {@link Revisions#addObject(Object, int)}.
   *
   * <ul>
   *   <li>Given {@link Revisions} (default constructor) addObject {@code Object} and ten.
   *   <li>Then {@link Revisions} (default constructor) size is two.
   * </ul>
   *
   * <p>Method under test: {@link Revisions#addObject(Object, int)}
   */
  @Test
  @DisplayName(
      "Test addObject(Object, int); given Revisions (default constructor) addObject 'Object' and ten; then Revisions (default constructor) size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Revisions.addObject(Object, int)"})
  void testAddObject_givenRevisionsAddObjectObjectAndTen_thenRevisionsSizeIsTwo() {
    // Arrange
    Revisions<Object> revisions = new Revisions<>();
    revisions.addObject("Object", 10);

    // Act
    revisions.addObject("Object", 10);

    // Assert
    assertEquals(2, revisions.size());
  }

  /**
   * Test {@link Revisions#addObject(Object, int)}.
   *
   * <ul>
   *   <li>Given {@link Revisions} (default constructor).
   *   <li>Then {@link Revisions} (default constructor) size is one.
   * </ul>
   *
   * <p>Method under test: {@link Revisions#addObject(Object, int)}
   */
  @Test
  @DisplayName(
      "Test addObject(Object, int); given Revisions (default constructor); then Revisions (default constructor) size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Revisions.addObject(Object, int)"})
  void testAddObject_givenRevisions_thenRevisionsSizeIsOne() {
    // Arrange
    Revisions<Object> revisions = new Revisions<>();

    // Act
    revisions.addObject("Object", 10);

    // Assert
    assertEquals(1, revisions.size());
  }

  /**
   * Test {@link Revisions#size()}.
   *
   * <ul>
   *   <li>Given {@link Revisions} (default constructor) addObject {@code Object} and ten.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link Revisions#size()}
   */
  @Test
  @DisplayName(
      "Test size(); given Revisions (default constructor) addObject 'Object' and ten; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Revisions.size()"})
  void testSize_givenRevisionsAddObjectObjectAndTen_thenReturnOne() {
    // Arrange
    Revisions<Object> revisions = new Revisions<>();
    revisions.addObject("Object", 10);

    // Act and Assert
    assertEquals(1, revisions.size());
  }

  /**
   * Test {@link Revisions#size()}.
   *
   * <ul>
   *   <li>Given {@link Revisions} (default constructor).
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Revisions#size()}
   */
  @Test
  @DisplayName("Test size(); given Revisions (default constructor); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Revisions.size()"})
  void testSize_givenRevisions_thenReturnZero() {
    // Arrange
    Revisions<Object> revisions = new Revisions<>();

    // Act and Assert
    assertEquals(0, revisions.size());
  }

  /**
   * Test {@link Revisions#toString()}.
   *
   * <ul>
   *   <li>Given {@link Revisions} (default constructor).
   *   <li>Then return {@code {}}.
   * </ul>
   *
   * <p>Method under test: {@link Revisions#toString()}
   */
  @Test
  @DisplayName("Test toString(); given Revisions (default constructor); then return '{}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Revisions.toString()"})
  void testToString_givenRevisions_thenReturnLeftCurlyBracketRightCurlyBracket() {
    // Arrange
    Revisions<Object> revisions = new Revisions<>();

    // Act and Assert
    assertEquals("{}", revisions.toString());
  }

  /**
   * Test {@link Revisions#toString()}.
   *
   * <ul>
   *   <li>Then return {@code {object=Object, revisionNumber=10}}.
   * </ul>
   *
   * <p>Method under test: {@link Revisions#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '{object=Object, revisionNumber=10}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Revisions.toString()"})
  void testToString_thenReturnObjectObjectRevisionNumber10() {
    // Arrange
    Revisions<Object> revisions = new Revisions<>();
    revisions.addObject("Object", 10);

    // Act and Assert
    assertEquals("{object=Object, revisionNumber=10}", revisions.toString());
  }
}

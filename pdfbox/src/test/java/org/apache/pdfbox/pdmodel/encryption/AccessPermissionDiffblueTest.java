package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class AccessPermissionDiffblueTest {
  /**
   * Method under test: {@link AccessPermission#isOwnerPermission()}
   */
  @Test
  void testIsOwnerPermission() {
    // Arrange, Act and Assert
    assertTrue(AccessPermission.getOwnerAccessPermission().isOwnerPermission());
    assertFalse((new AccessPermission(11)).isOwnerPermission());
  }

  /**
   * Method under test: {@link AccessPermission#getPermissionBytesForPublicKey()}
   */
  @Test
  void testGetPermissionBytesForPublicKey() {
    // Arrange, Act and Assert
    assertEquals(3901, AccessPermission.getOwnerAccessPermission().getPermissionBytesForPublicKey());
  }

  /**
   * Method under test: {@link AccessPermission#canPrint()}
   */
  @Test
  void testCanPrint() {
    // Arrange, Act and Assert
    assertTrue(AccessPermission.getOwnerAccessPermission().canPrint());
    assertFalse((new AccessPermission(3)).canPrint());
  }

  /**
   * Method under test: {@link AccessPermission#canModify()}
   */
  @Test
  void testCanModify() {
    // Arrange, Act and Assert
    assertTrue(AccessPermission.getOwnerAccessPermission().canModify());
    assertFalse((new AccessPermission(4)).canModify());
  }

  /**
   * Method under test: {@link AccessPermission#canExtractContent()}
   */
  @Test
  void testCanExtractContent() {
    // Arrange, Act and Assert
    assertTrue(AccessPermission.getOwnerAccessPermission().canExtractContent());
    assertFalse((new AccessPermission(5)).canExtractContent());
  }

  /**
   * Method under test: {@link AccessPermission#canModifyAnnotations()}
   */
  @Test
  void testCanModifyAnnotations() {
    // Arrange, Act and Assert
    assertTrue(AccessPermission.getOwnerAccessPermission().canModifyAnnotations());
    assertFalse((new AccessPermission(6)).canModifyAnnotations());
  }

  /**
   * Method under test: {@link AccessPermission#canFillInForm()}
   */
  @Test
  void testCanFillInForm() {
    // Arrange, Act and Assert
    assertTrue(AccessPermission.getOwnerAccessPermission().canFillInForm());
    assertFalse((new AccessPermission(9)).canFillInForm());
  }

  /**
   * Method under test: {@link AccessPermission#canExtractForAccessibility()}
   */
  @Test
  void testCanExtractForAccessibility() {
    // Arrange, Act and Assert
    assertTrue(AccessPermission.getOwnerAccessPermission().canExtractForAccessibility());
    assertFalse((new AccessPermission(10)).canExtractForAccessibility());
  }

  /**
   * Method under test: {@link AccessPermission#canAssembleDocument()}
   */
  @Test
  void testCanAssembleDocument() {
    // Arrange, Act and Assert
    assertTrue(AccessPermission.getOwnerAccessPermission().canAssembleDocument());
    assertFalse((new AccessPermission(11)).canAssembleDocument());
  }

  /**
   * Method under test: {@link AccessPermission#canPrintFaithful()}
   */
  @Test
  void testCanPrintFaithful() {
    // Arrange, Act and Assert
    assertTrue(AccessPermission.getOwnerAccessPermission().canPrintFaithful());
    assertFalse((new AccessPermission(12)).canPrintFaithful());
  }

  /**
   * Method under test: {@link AccessPermission#hasAnyRevision3PermissionSet()}
   */
  @Test
  void testHasAnyRevision3PermissionSet() {
    // Arrange, Act and Assert
    assertTrue(AccessPermission.getOwnerAccessPermission().hasAnyRevision3PermissionSet());
    assertFalse((new AccessPermission(9)).hasAnyRevision3PermissionSet());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AccessPermission#AccessPermission()}
   *   <li>{@link AccessPermission#setReadOnly()}
   *   <li>{@link AccessPermission#getPermissionBytes()}
   *   <li>{@link AccessPermission#isReadOnly()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    AccessPermission actualAccessPermission = new AccessPermission();
    actualAccessPermission.setReadOnly();
    int actualPermissionBytes = actualAccessPermission.getPermissionBytes();

    // Assert that nothing has changed
    assertEquals(-4, actualPermissionBytes);
    assertTrue(actualAccessPermission.isReadOnly());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AccessPermission#AccessPermission(int)}
   *   <li>{@link AccessPermission#setReadOnly()}
   *   <li>{@link AccessPermission#getPermissionBytes()}
   *   <li>{@link AccessPermission#isReadOnly()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    AccessPermission actualAccessPermission = new AccessPermission(1);
    actualAccessPermission.setReadOnly();
    int actualPermissionBytes = actualAccessPermission.getPermissionBytes();

    // Assert that nothing has changed
    assertEquals(1, actualPermissionBytes);
    assertTrue(actualAccessPermission.isReadOnly());
  }
}

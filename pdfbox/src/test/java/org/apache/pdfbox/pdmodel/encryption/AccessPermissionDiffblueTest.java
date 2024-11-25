package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AccessPermissionDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return PermissionBytes is minus four.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccessPermission#AccessPermission()}
   *   <li>{@link AccessPermission#setReadOnly()}
   *   <li>{@link AccessPermission#getPermissionBytes()}
   *   <li>{@link AccessPermission#isReadOnly()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return PermissionBytes is minus four")
  void testGettersAndSetters_thenReturnPermissionBytesIsMinusFour() {
    // Arrange and Act
    AccessPermission actualAccessPermission = new AccessPermission();
    actualAccessPermission.setReadOnly();
    int actualPermissionBytes = actualAccessPermission.getPermissionBytes();

    // Assert that nothing has changed
    assertEquals(-4, actualPermissionBytes);
    assertTrue(actualAccessPermission.isReadOnly());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return PermissionBytes is one.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccessPermission#AccessPermission(int)}
   *   <li>{@link AccessPermission#setReadOnly()}
   *   <li>{@link AccessPermission#getPermissionBytes()}
   *   <li>{@link AccessPermission#isReadOnly()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one; then return PermissionBytes is one")
  void testGettersAndSetters_whenOne_thenReturnPermissionBytesIsOne() {
    // Arrange and Act
    AccessPermission actualAccessPermission = new AccessPermission(1);
    actualAccessPermission.setReadOnly();
    int actualPermissionBytes = actualAccessPermission.getPermissionBytes();

    // Assert that nothing has changed
    assertEquals(1, actualPermissionBytes);
    assertTrue(actualAccessPermission.isReadOnly());
  }

  /**
   * Test {@link AccessPermission#isOwnerPermission()}.
   * <ul>
   *   <li>Given OwnerAccessPermission.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccessPermission#isOwnerPermission()}
   */
  @Test
  @DisplayName("Test isOwnerPermission(); given OwnerAccessPermission; then return 'true'")
  void testIsOwnerPermission_givenOwnerAccessPermission_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AccessPermission.getOwnerAccessPermission().isOwnerPermission());
  }

  /**
   * Test {@link AccessPermission#isOwnerPermission()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccessPermission#isOwnerPermission()}
   */
  @Test
  @DisplayName("Test isOwnerPermission(); then return 'false'")
  void testIsOwnerPermission_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new AccessPermission(11)).isOwnerPermission());
  }

  /**
   * Test {@link AccessPermission#getPermissionBytesForPublicKey()}.
   * <p>
   * Method under test: {@link AccessPermission#getPermissionBytesForPublicKey()}
   */
  @Test
  @DisplayName("Test getPermissionBytesForPublicKey()")
  void testGetPermissionBytesForPublicKey() {
    // Arrange, Act and Assert
    assertEquals(3901, AccessPermission.getOwnerAccessPermission().getPermissionBytesForPublicKey());
  }

  /**
   * Test {@link AccessPermission#canPrint()}.
   * <ul>
   *   <li>Given {@link AccessPermission#AccessPermission(int)} with permissions is
   * three.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccessPermission#canPrint()}
   */
  @Test
  @DisplayName("Test canPrint(); given AccessPermission(int) with permissions is three; then return 'false'")
  void testCanPrint_givenAccessPermissionWithPermissionsIsThree_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new AccessPermission(3)).canPrint());
  }

  /**
   * Test {@link AccessPermission#canPrint()}.
   * <ul>
   *   <li>Given OwnerAccessPermission.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccessPermission#canPrint()}
   */
  @Test
  @DisplayName("Test canPrint(); given OwnerAccessPermission; then return 'true'")
  void testCanPrint_givenOwnerAccessPermission_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AccessPermission.getOwnerAccessPermission().canPrint());
  }

  /**
   * Test {@link AccessPermission#canModify()}.
   * <ul>
   *   <li>Given {@link AccessPermission#AccessPermission(int)} with permissions is
   * four.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccessPermission#canModify()}
   */
  @Test
  @DisplayName("Test canModify(); given AccessPermission(int) with permissions is four; then return 'false'")
  void testCanModify_givenAccessPermissionWithPermissionsIsFour_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new AccessPermission(4)).canModify());
  }

  /**
   * Test {@link AccessPermission#canModify()}.
   * <ul>
   *   <li>Given OwnerAccessPermission.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccessPermission#canModify()}
   */
  @Test
  @DisplayName("Test canModify(); given OwnerAccessPermission; then return 'true'")
  void testCanModify_givenOwnerAccessPermission_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AccessPermission.getOwnerAccessPermission().canModify());
  }

  /**
   * Test {@link AccessPermission#canExtractContent()}.
   * <ul>
   *   <li>Given {@link AccessPermission#AccessPermission(int)} with permissions is
   * five.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccessPermission#canExtractContent()}
   */
  @Test
  @DisplayName("Test canExtractContent(); given AccessPermission(int) with permissions is five; then return 'false'")
  void testCanExtractContent_givenAccessPermissionWithPermissionsIsFive_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new AccessPermission(5)).canExtractContent());
  }

  /**
   * Test {@link AccessPermission#canExtractContent()}.
   * <ul>
   *   <li>Given OwnerAccessPermission.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccessPermission#canExtractContent()}
   */
  @Test
  @DisplayName("Test canExtractContent(); given OwnerAccessPermission; then return 'true'")
  void testCanExtractContent_givenOwnerAccessPermission_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AccessPermission.getOwnerAccessPermission().canExtractContent());
  }

  /**
   * Test {@link AccessPermission#canModifyAnnotations()}.
   * <ul>
   *   <li>Given OwnerAccessPermission.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccessPermission#canModifyAnnotations()}
   */
  @Test
  @DisplayName("Test canModifyAnnotations(); given OwnerAccessPermission; then return 'true'")
  void testCanModifyAnnotations_givenOwnerAccessPermission_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AccessPermission.getOwnerAccessPermission().canModifyAnnotations());
  }

  /**
   * Test {@link AccessPermission#canModifyAnnotations()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccessPermission#canModifyAnnotations()}
   */
  @Test
  @DisplayName("Test canModifyAnnotations(); then return 'false'")
  void testCanModifyAnnotations_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new AccessPermission(6)).canModifyAnnotations());
  }

  /**
   * Test {@link AccessPermission#canFillInForm()}.
   * <ul>
   *   <li>Given {@link AccessPermission#AccessPermission(int)} with permissions is
   * nine.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccessPermission#canFillInForm()}
   */
  @Test
  @DisplayName("Test canFillInForm(); given AccessPermission(int) with permissions is nine; then return 'false'")
  void testCanFillInForm_givenAccessPermissionWithPermissionsIsNine_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new AccessPermission(9)).canFillInForm());
  }

  /**
   * Test {@link AccessPermission#canFillInForm()}.
   * <ul>
   *   <li>Given OwnerAccessPermission.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccessPermission#canFillInForm()}
   */
  @Test
  @DisplayName("Test canFillInForm(); given OwnerAccessPermission; then return 'true'")
  void testCanFillInForm_givenOwnerAccessPermission_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AccessPermission.getOwnerAccessPermission().canFillInForm());
  }

  /**
   * Test {@link AccessPermission#canExtractForAccessibility()}.
   * <ul>
   *   <li>Given OwnerAccessPermission.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccessPermission#canExtractForAccessibility()}
   */
  @Test
  @DisplayName("Test canExtractForAccessibility(); given OwnerAccessPermission; then return 'true'")
  void testCanExtractForAccessibility_givenOwnerAccessPermission_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AccessPermission.getOwnerAccessPermission().canExtractForAccessibility());
  }

  /**
   * Test {@link AccessPermission#canExtractForAccessibility()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccessPermission#canExtractForAccessibility()}
   */
  @Test
  @DisplayName("Test canExtractForAccessibility(); then return 'false'")
  void testCanExtractForAccessibility_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new AccessPermission(10)).canExtractForAccessibility());
  }

  /**
   * Test {@link AccessPermission#canAssembleDocument()}.
   * <ul>
   *   <li>Given OwnerAccessPermission.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccessPermission#canAssembleDocument()}
   */
  @Test
  @DisplayName("Test canAssembleDocument(); given OwnerAccessPermission; then return 'true'")
  void testCanAssembleDocument_givenOwnerAccessPermission_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AccessPermission.getOwnerAccessPermission().canAssembleDocument());
  }

  /**
   * Test {@link AccessPermission#canAssembleDocument()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccessPermission#canAssembleDocument()}
   */
  @Test
  @DisplayName("Test canAssembleDocument(); then return 'false'")
  void testCanAssembleDocument_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new AccessPermission(11)).canAssembleDocument());
  }

  /**
   * Test {@link AccessPermission#canPrintFaithful()}.
   * <ul>
   *   <li>Given OwnerAccessPermission.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccessPermission#canPrintFaithful()}
   */
  @Test
  @DisplayName("Test canPrintFaithful(); given OwnerAccessPermission; then return 'true'")
  void testCanPrintFaithful_givenOwnerAccessPermission_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AccessPermission.getOwnerAccessPermission().canPrintFaithful());
  }

  /**
   * Test {@link AccessPermission#canPrintFaithful()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccessPermission#canPrintFaithful()}
   */
  @Test
  @DisplayName("Test canPrintFaithful(); then return 'false'")
  void testCanPrintFaithful_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new AccessPermission(12)).canPrintFaithful());
  }

  /**
   * Test {@link AccessPermission#hasAnyRevision3PermissionSet()}.
   * <ul>
   *   <li>Given OwnerAccessPermission.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccessPermission#hasAnyRevision3PermissionSet()}
   */
  @Test
  @DisplayName("Test hasAnyRevision3PermissionSet(); given OwnerAccessPermission; then return 'true'")
  void testHasAnyRevision3PermissionSet_givenOwnerAccessPermission_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AccessPermission.getOwnerAccessPermission().hasAnyRevision3PermissionSet());
  }

  /**
   * Test {@link AccessPermission#hasAnyRevision3PermissionSet()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccessPermission#hasAnyRevision3PermissionSet()}
   */
  @Test
  @DisplayName("Test hasAnyRevision3PermissionSet(); then return 'false'")
  void testHasAnyRevision3PermissionSet_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new AccessPermission(9)).hasAnyRevision3PermissionSet());
  }
}

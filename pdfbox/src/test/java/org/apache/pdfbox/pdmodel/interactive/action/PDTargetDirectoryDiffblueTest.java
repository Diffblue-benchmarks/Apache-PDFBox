package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDNamedDestination;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDTargetDirectoryDiffblueTest {
  /**
   * Test {@link PDTargetDirectory#PDTargetDirectory(COSDictionary)}.
   *
   * <p>Method under test: {@link PDTargetDirectory#PDTargetDirectory(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDTargetDirectory(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTargetDirectory.<init>(COSDictionary)"})
  void testNewPDTargetDirectory() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, new PDTargetDirectory(dictionary).getCOSObject());
  }

  /**
   * Test {@link PDTargetDirectory#PDTargetDirectory()}.
   *
   * <p>Method under test: {@link PDTargetDirectory#PDTargetDirectory()}
   */
  @Test
  @DisplayName("Test new PDTargetDirectory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTargetDirectory.<init>()"})
  void testNewPDTargetDirectory2() {
    // Arrange and Act
    PDTargetDirectory actualPdTargetDirectory = new PDTargetDirectory();

    // Assert
    assertNull(actualPdTargetDirectory.getAnnotationName());
    assertNull(actualPdTargetDirectory.getFilename());
    assertNull(actualPdTargetDirectory.getRelationship());
    COSDictionary cOSObject = actualPdTargetDirectory.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(actualPdTargetDirectory.getTargetDirectory());
    assertNull(actualPdTargetDirectory.getNamedDestination());
    assertEquals(-1, actualPdTargetDirectory.getAnnotationIndex());
    assertEquals(-1, actualPdTargetDirectory.getPageNumber());
    assertEquals(0, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDTargetDirectory#getCOSObject()}.
   *
   * <p>Method under test: {@link PDTargetDirectory#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDTargetDirectory.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDTargetDirectory().getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(0, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualCOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDTargetDirectory#getRelationship()}.
   *
   * <ul>
   *   <li>Given {@link PDTargetDirectory#PDTargetDirectory()} Filename is {@code foo.txt}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#getRelationship()}
   */
  @Test
  @DisplayName(
      "Test getRelationship(); given PDTargetDirectory() Filename is 'foo.txt'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDTargetDirectory.getRelationship()"})
  void testGetRelationship_givenPDTargetDirectoryFilenameIsFooTxt_thenReturnNull() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();
    pdTargetDirectory.setFilename("foo.txt");

    // Act and Assert
    assertNull(pdTargetDirectory.getRelationship());
  }

  /**
   * Test {@link PDTargetDirectory#getRelationship()}.
   *
   * <ul>
   *   <li>Given {@link PDTargetDirectory#PDTargetDirectory()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#getRelationship()}
   */
  @Test
  @DisplayName("Test getRelationship(); given PDTargetDirectory(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDTargetDirectory.getRelationship()"})
  void testGetRelationship_givenPDTargetDirectory_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDTargetDirectory().getRelationship());
  }

  /**
   * Test {@link PDTargetDirectory#setRelationship(COSName)}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#setRelationship(COSName)}
   */
  @Test
  @DisplayName("Test setRelationship(COSName); when A; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTargetDirectory.setRelationship(COSName)"})
  void testSetRelationship_whenA_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new PDTargetDirectory().setRelationship(COSName.A));
  }

  /**
   * Test {@link PDTargetDirectory#getFilename()}.
   *
   * <ul>
   *   <li>Given {@link PDTargetDirectory#PDTargetDirectory()} Filename is {@code foo.txt}.
   *   <li>Then return {@code foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#getFilename()}
   */
  @Test
  @DisplayName(
      "Test getFilename(); given PDTargetDirectory() Filename is 'foo.txt'; then return 'foo.txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDTargetDirectory.getFilename()"})
  void testGetFilename_givenPDTargetDirectoryFilenameIsFooTxt_thenReturnFooTxt() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();
    pdTargetDirectory.setFilename("foo.txt");

    // Act and Assert
    assertEquals("foo.txt", pdTargetDirectory.getFilename());
  }

  /**
   * Test {@link PDTargetDirectory#getFilename()}.
   *
   * <ul>
   *   <li>Given {@link PDTargetDirectory#PDTargetDirectory()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#getFilename()}
   */
  @Test
  @DisplayName("Test getFilename(); given PDTargetDirectory(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDTargetDirectory.getFilename()"})
  void testGetFilename_givenPDTargetDirectory_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDTargetDirectory().getFilename());
  }

  /**
   * Test {@link PDTargetDirectory#getFilename()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#getFilename()}
   */
  @Test
  @DisplayName("Test getFilename(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDTargetDirectory.getFilename()"})
  void testGetFilename_thenReturnEmptyString() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();
    pdTargetDirectory.setFilename("");

    // Act and Assert
    assertEquals("", pdTargetDirectory.getFilename());
  }

  /**
   * Test {@link PDTargetDirectory#setFilename(String)}.
   *
   * <ul>
   *   <li>Given {@link PDTargetDirectory#PDTargetDirectory()}.
   *   <li>Then {@link PDTargetDirectory#PDTargetDirectory()} Filename is {@code foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#setFilename(String)}
   */
  @Test
  @DisplayName(
      "Test setFilename(String); given PDTargetDirectory(); then PDTargetDirectory() Filename is 'foo.txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTargetDirectory.setFilename(String)"})
  void testSetFilename_givenPDTargetDirectory_thenPDTargetDirectoryFilenameIsFooTxt() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();

    // Act
    pdTargetDirectory.setFilename("foo.txt");

    // Assert
    assertEquals("foo.txt", pdTargetDirectory.getFilename());
    COSDictionary cOSObject = pdTargetDirectory.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDTargetDirectory#setFilename(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDTargetDirectory#PDTargetDirectory()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#setFilename(String)}
   */
  @Test
  @DisplayName(
      "Test setFilename(String); when 'null'; then PDTargetDirectory() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTargetDirectory.setFilename(String)"})
  void testSetFilename_whenNull_thenPDTargetDirectoryCOSObjectSizeIsZero() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();

    // Act
    pdTargetDirectory.setFilename(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdTargetDirectory.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDTargetDirectory#getTargetDirectory()}.
   *
   * <ul>
   *   <li>Given {@link PDTargetDirectory#PDTargetDirectory()} Filename is {@code foo.txt}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#getTargetDirectory()}
   */
  @Test
  @DisplayName(
      "Test getTargetDirectory(); given PDTargetDirectory() Filename is 'foo.txt'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTargetDirectory PDTargetDirectory.getTargetDirectory()"})
  void testGetTargetDirectory_givenPDTargetDirectoryFilenameIsFooTxt_thenReturnNull() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();
    pdTargetDirectory.setFilename("foo.txt");

    // Act and Assert
    assertNull(pdTargetDirectory.getTargetDirectory());
  }

  /**
   * Test {@link PDTargetDirectory#getTargetDirectory()}.
   *
   * <ul>
   *   <li>Given {@link PDTargetDirectory#PDTargetDirectory()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#getTargetDirectory()}
   */
  @Test
  @DisplayName("Test getTargetDirectory(); given PDTargetDirectory(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTargetDirectory PDTargetDirectory.getTargetDirectory()"})
  void testGetTargetDirectory_givenPDTargetDirectory_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDTargetDirectory().getTargetDirectory());
  }

  /**
   * Test {@link PDTargetDirectory#getTargetDirectory()}.
   *
   * <ul>
   *   <li>Then return AnnotationName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#getTargetDirectory()}
   */
  @Test
  @DisplayName("Test getTargetDirectory(); then return AnnotationName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTargetDirectory PDTargetDirectory.getTargetDirectory()"})
  void testGetTargetDirectory_thenReturnAnnotationNameIsNull() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();
    pdTargetDirectory.setTargetDirectory(new PDTargetDirectory());

    // Act
    PDTargetDirectory actualTargetDirectory = pdTargetDirectory.getTargetDirectory();

    // Assert
    assertNull(actualTargetDirectory.getAnnotationName());
    assertNull(actualTargetDirectory.getFilename());
    assertNull(actualTargetDirectory.getRelationship());
    COSDictionary cOSObject = actualTargetDirectory.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(actualTargetDirectory.getNamedDestination());
    assertEquals(-1, actualTargetDirectory.getAnnotationIndex());
    assertEquals(-1, actualTargetDirectory.getPageNumber());
    assertEquals(0, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDTargetDirectory#setTargetDirectory(PDTargetDirectory)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#setTargetDirectory(PDTargetDirectory)}
   */
  @Test
  @DisplayName(
      "Test setTargetDirectory(PDTargetDirectory); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTargetDirectory.setTargetDirectory(PDTargetDirectory)"})
  void testSetTargetDirectory_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    pdTargetDirectory.setTargetDirectory(new PDTargetDirectory(dictionary));

    // Assert
    PDTargetDirectory targetDirectory = pdTargetDirectory.getTargetDirectory();
    assertNull(targetDirectory.getAnnotationName());
    assertNull(targetDirectory.getFilename());
    assertNull(targetDirectory.getRelationship());
    assertNull(targetDirectory.getTargetDirectory());
    assertNull(targetDirectory.getNamedDestination());
    assertEquals(-1, targetDirectory.getAnnotationIndex());
    assertEquals(-1, targetDirectory.getPageNumber());
    COSDictionary cOSObject = pdTargetDirectory.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(dictionary, targetDirectory.getCOSObject());
  }

  /**
   * Test {@link PDTargetDirectory#setTargetDirectory(PDTargetDirectory)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#setTargetDirectory(PDTargetDirectory)}
   */
  @Test
  @DisplayName(
      "Test setTargetDirectory(PDTargetDirectory); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTargetDirectory.setTargetDirectory(PDTargetDirectory)"})
  void testSetTargetDirectory_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setDirect(true);

    // Act
    pdTargetDirectory.setTargetDirectory(new PDTargetDirectory(dictionary));

    // Assert
    PDTargetDirectory targetDirectory = pdTargetDirectory.getTargetDirectory();
    assertNull(targetDirectory.getAnnotationName());
    assertNull(targetDirectory.getFilename());
    assertNull(targetDirectory.getRelationship());
    assertNull(targetDirectory.getTargetDirectory());
    assertNull(targetDirectory.getNamedDestination());
    assertEquals(-1, targetDirectory.getAnnotationIndex());
    assertEquals(-1, targetDirectory.getPageNumber());
    COSDictionary cOSObject = pdTargetDirectory.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(dictionary, targetDirectory.getCOSObject());
  }

  /**
   * Test {@link PDTargetDirectory#setTargetDirectory(PDTargetDirectory)}.
   *
   * <ul>
   *   <li>Then {@link PDTargetDirectory#PDTargetDirectory()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#setTargetDirectory(PDTargetDirectory)}
   */
  @Test
  @DisplayName(
      "Test setTargetDirectory(PDTargetDirectory); then PDTargetDirectory() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTargetDirectory.setTargetDirectory(PDTargetDirectory)"})
  void testSetTargetDirectory_thenPDTargetDirectoryCOSObjectSizeIsZero() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();
    PDTargetDirectory targetDirectory = new PDTargetDirectory();

    // Act
    pdTargetDirectory.setTargetDirectory(targetDirectory);

    // Assert that nothing has changed
    COSDictionary cOSObject = targetDirectory.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDTargetDirectory#setTargetDirectory(PDTargetDirectory)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDTargetDirectory#PDTargetDirectory()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#setTargetDirectory(PDTargetDirectory)}
   */
  @Test
  @DisplayName(
      "Test setTargetDirectory(PDTargetDirectory); when 'null'; then PDTargetDirectory() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTargetDirectory.setTargetDirectory(PDTargetDirectory)"})
  void testSetTargetDirectory_whenNull_thenPDTargetDirectoryCOSObjectSizeIsZero() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();

    // Act
    pdTargetDirectory.setTargetDirectory(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdTargetDirectory.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDTargetDirectory#getPageNumber()}.
   *
   * <ul>
   *   <li>Given {@link PDTargetDirectory#PDTargetDirectory()} Filename is {@code foo.txt}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#getPageNumber()}
   */
  @Test
  @DisplayName(
      "Test getPageNumber(); given PDTargetDirectory() Filename is 'foo.txt'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDTargetDirectory.getPageNumber()"})
  void testGetPageNumber_givenPDTargetDirectoryFilenameIsFooTxt_thenReturnMinusOne() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();
    pdTargetDirectory.setFilename("foo.txt");

    // Act and Assert
    assertEquals(-1, pdTargetDirectory.getPageNumber());
  }

  /**
   * Test {@link PDTargetDirectory#getPageNumber()}.
   *
   * <ul>
   *   <li>Given {@link PDTargetDirectory#PDTargetDirectory()} PageNumber is ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#getPageNumber()}
   */
  @Test
  @DisplayName("Test getPageNumber(); given PDTargetDirectory() PageNumber is ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDTargetDirectory.getPageNumber()"})
  void testGetPageNumber_givenPDTargetDirectoryPageNumberIsTen_thenReturnTen() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();
    pdTargetDirectory.setPageNumber(10);

    // Act and Assert
    assertEquals(10, pdTargetDirectory.getPageNumber());
  }

  /**
   * Test {@link PDTargetDirectory#getPageNumber()}.
   *
   * <ul>
   *   <li>Given {@link PDTargetDirectory#PDTargetDirectory()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#getPageNumber()}
   */
  @Test
  @DisplayName("Test getPageNumber(); given PDTargetDirectory(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDTargetDirectory.getPageNumber()"})
  void testGetPageNumber_givenPDTargetDirectory_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDTargetDirectory().getPageNumber());
  }

  /**
   * Test {@link PDTargetDirectory#setPageNumber(int)}.
   *
   * <ul>
   *   <li>Then {@link PDTargetDirectory#PDTargetDirectory()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#setPageNumber(int)}
   */
  @Test
  @DisplayName("Test setPageNumber(int); then PDTargetDirectory() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTargetDirectory.setPageNumber(int)"})
  void testSetPageNumber_thenPDTargetDirectoryCOSObjectValuesSizeIsOne() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();

    // Act
    pdTargetDirectory.setPageNumber(10);

    // Assert
    COSDictionary cOSObject = pdTargetDirectory.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(10, pdTargetDirectory.getPageNumber());
  }

  /**
   * Test {@link PDTargetDirectory#setPageNumber(int)}.
   *
   * <ul>
   *   <li>Then {@link PDTargetDirectory#PDTargetDirectory()} PageNumber is minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#setPageNumber(int)}
   */
  @Test
  @DisplayName("Test setPageNumber(int); then PDTargetDirectory() PageNumber is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTargetDirectory.setPageNumber(int)"})
  void testSetPageNumber_thenPDTargetDirectoryPageNumberIsMinusOne() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();

    // Act
    pdTargetDirectory.setPageNumber(-1);

    // Assert that nothing has changed
    assertEquals(-1, pdTargetDirectory.getPageNumber());
    COSDictionary cOSObject = pdTargetDirectory.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDTargetDirectory#getNamedDestination()}.
   *
   * <ul>
   *   <li>Given {@link PDTargetDirectory#PDTargetDirectory()} Filename is {@code foo.txt}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#getNamedDestination()}
   */
  @Test
  @DisplayName(
      "Test getNamedDestination(); given PDTargetDirectory() Filename is 'foo.txt'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDNamedDestination PDTargetDirectory.getNamedDestination()"})
  void testGetNamedDestination_givenPDTargetDirectoryFilenameIsFooTxt_thenReturnNull() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();
    pdTargetDirectory.setFilename("foo.txt");

    // Act and Assert
    assertNull(pdTargetDirectory.getNamedDestination());
  }

  /**
   * Test {@link PDTargetDirectory#getNamedDestination()}.
   *
   * <ul>
   *   <li>Given {@link PDTargetDirectory#PDTargetDirectory()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#getNamedDestination()}
   */
  @Test
  @DisplayName("Test getNamedDestination(); given PDTargetDirectory(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDNamedDestination PDTargetDirectory.getNamedDestination()"})
  void testGetNamedDestination_givenPDTargetDirectory_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDTargetDirectory().getNamedDestination());
  }

  /**
   * Test {@link PDTargetDirectory#getNamedDestination()}.
   *
   * <ul>
   *   <li>Then COSObject return {@link COSString}.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#getNamedDestination()}
   */
  @Test
  @DisplayName("Test getNamedDestination(); then COSObject return COSString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDNamedDestination PDTargetDirectory.getNamedDestination()"})
  void testGetNamedDestination_thenCOSObjectReturnCOSString() throws UnsupportedEncodingException {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();
    pdTargetDirectory.setNamedDestination(new PDNamedDestination("Dest"));

    // Act
    PDNamedDestination actualNamedDestination = pdTargetDirectory.getNamedDestination();

    // Assert
    COSBase cOSObject = actualNamedDestination.getCOSObject();
    assertTrue(cOSObject instanceof COSString);
    assertEquals("44657374", ((COSString) cOSObject).toHexString());
    assertEquals("Dest", ((COSString) cOSObject).getASCII());
    assertEquals("Dest", ((COSString) cOSObject).getString());
    assertEquals("Dest", actualNamedDestination.getNamedDestination());
    assertNull(cOSObject.getKey());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSString) cOSObject).getForceHexForm());
    assertArrayEquals("Dest".getBytes("UTF-8"), ((COSString) cOSObject).getBytes());
  }

  /**
   * Test {@link PDTargetDirectory#setNamedDestination(PDNamedDestination)}.
   *
   * <p>Method under test: {@link PDTargetDirectory#setNamedDestination(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test setNamedDestination(PDNamedDestination)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTargetDirectory.setNamedDestination(PDNamedDestination)"})
  void testSetNamedDestination() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();

    // Act
    pdTargetDirectory.setNamedDestination(new PDNamedDestination("Dest"));

    // Assert
    assertEquals("Dest", pdTargetDirectory.getNamedDestination().getNamedDestination());
    COSDictionary cOSObject = pdTargetDirectory.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDTargetDirectory#setNamedDestination(PDNamedDestination)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDTargetDirectory#PDTargetDirectory()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#setNamedDestination(PDNamedDestination)}
   */
  @Test
  @DisplayName(
      "Test setNamedDestination(PDNamedDestination); when 'null'; then PDTargetDirectory() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTargetDirectory.setNamedDestination(PDNamedDestination)"})
  void testSetNamedDestination_whenNull_thenPDTargetDirectoryCOSObjectSizeIsZero() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();

    // Act
    pdTargetDirectory.setNamedDestination(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdTargetDirectory.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDTargetDirectory#setNamedDestination(PDNamedDestination)}.
   *
   * <ul>
   *   <li>When {@link PDNamedDestination#PDNamedDestination()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#setNamedDestination(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test setNamedDestination(PDNamedDestination); when PDNamedDestination()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTargetDirectory.setNamedDestination(PDNamedDestination)"})
  void testSetNamedDestination_whenPDNamedDestination() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();

    // Act
    pdTargetDirectory.setNamedDestination(new PDNamedDestination());

    // Assert that nothing has changed
    COSDictionary cOSObject = pdTargetDirectory.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDTargetDirectory#getAnnotationIndex()}.
   *
   * <ul>
   *   <li>Given {@link PDTargetDirectory#PDTargetDirectory()} AnnotationIndex is one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#getAnnotationIndex()}
   */
  @Test
  @DisplayName(
      "Test getAnnotationIndex(); given PDTargetDirectory() AnnotationIndex is one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDTargetDirectory.getAnnotationIndex()"})
  void testGetAnnotationIndex_givenPDTargetDirectoryAnnotationIndexIsOne_thenReturnOne() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();
    pdTargetDirectory.setAnnotationIndex(1);

    // Act and Assert
    assertEquals(1, pdTargetDirectory.getAnnotationIndex());
  }

  /**
   * Test {@link PDTargetDirectory#getAnnotationIndex()}.
   *
   * <ul>
   *   <li>Given {@link PDTargetDirectory#PDTargetDirectory()} Filename is {@code foo.txt}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#getAnnotationIndex()}
   */
  @Test
  @DisplayName(
      "Test getAnnotationIndex(); given PDTargetDirectory() Filename is 'foo.txt'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDTargetDirectory.getAnnotationIndex()"})
  void testGetAnnotationIndex_givenPDTargetDirectoryFilenameIsFooTxt_thenReturnMinusOne() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();
    pdTargetDirectory.setFilename("foo.txt");

    // Act and Assert
    assertEquals(-1, pdTargetDirectory.getAnnotationIndex());
  }

  /**
   * Test {@link PDTargetDirectory#getAnnotationIndex()}.
   *
   * <ul>
   *   <li>Given {@link PDTargetDirectory#PDTargetDirectory()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#getAnnotationIndex()}
   */
  @Test
  @DisplayName("Test getAnnotationIndex(); given PDTargetDirectory(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDTargetDirectory.getAnnotationIndex()"})
  void testGetAnnotationIndex_givenPDTargetDirectory_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDTargetDirectory().getAnnotationIndex());
  }

  /**
   * Test {@link PDTargetDirectory#setAnnotationIndex(int)}.
   *
   * <ul>
   *   <li>Then {@link PDTargetDirectory#PDTargetDirectory()} AnnotationIndex is minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#setAnnotationIndex(int)}
   */
  @Test
  @DisplayName(
      "Test setAnnotationIndex(int); then PDTargetDirectory() AnnotationIndex is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTargetDirectory.setAnnotationIndex(int)"})
  void testSetAnnotationIndex_thenPDTargetDirectoryAnnotationIndexIsMinusOne() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();

    // Act
    pdTargetDirectory.setAnnotationIndex(-1);

    // Assert that nothing has changed
    assertEquals(-1, pdTargetDirectory.getAnnotationIndex());
    COSDictionary cOSObject = pdTargetDirectory.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDTargetDirectory#setAnnotationIndex(int)}.
   *
   * <ul>
   *   <li>Then {@link PDTargetDirectory#PDTargetDirectory()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#setAnnotationIndex(int)}
   */
  @Test
  @DisplayName(
      "Test setAnnotationIndex(int); then PDTargetDirectory() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTargetDirectory.setAnnotationIndex(int)"})
  void testSetAnnotationIndex_thenPDTargetDirectoryCOSObjectValuesSizeIsOne() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();

    // Act
    pdTargetDirectory.setAnnotationIndex(1);

    // Assert
    COSDictionary cOSObject = pdTargetDirectory.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdTargetDirectory.getAnnotationIndex());
  }

  /**
   * Test {@link PDTargetDirectory#getAnnotationName()}.
   *
   * <ul>
   *   <li>Given {@link PDTargetDirectory#PDTargetDirectory()} AnnotationName is {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#getAnnotationName()}
   */
  @Test
  @DisplayName(
      "Test getAnnotationName(); given PDTargetDirectory() AnnotationName is 'Name'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDTargetDirectory.getAnnotationName()"})
  void testGetAnnotationName_givenPDTargetDirectoryAnnotationNameIsName_thenReturnName() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();
    pdTargetDirectory.setAnnotationName("Name");

    // Act and Assert
    assertEquals("Name", pdTargetDirectory.getAnnotationName());
  }

  /**
   * Test {@link PDTargetDirectory#getAnnotationName()}.
   *
   * <ul>
   *   <li>Given {@link PDTargetDirectory#PDTargetDirectory()} Filename is {@code foo.txt}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#getAnnotationName()}
   */
  @Test
  @DisplayName(
      "Test getAnnotationName(); given PDTargetDirectory() Filename is 'foo.txt'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDTargetDirectory.getAnnotationName()"})
  void testGetAnnotationName_givenPDTargetDirectoryFilenameIsFooTxt_thenReturnNull() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();
    pdTargetDirectory.setFilename("foo.txt");

    // Act and Assert
    assertNull(pdTargetDirectory.getAnnotationName());
  }

  /**
   * Test {@link PDTargetDirectory#getAnnotationName()}.
   *
   * <ul>
   *   <li>Given {@link PDTargetDirectory#PDTargetDirectory()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#getAnnotationName()}
   */
  @Test
  @DisplayName("Test getAnnotationName(); given PDTargetDirectory(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDTargetDirectory.getAnnotationName()"})
  void testGetAnnotationName_givenPDTargetDirectory_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDTargetDirectory().getAnnotationName());
  }

  /**
   * Test {@link PDTargetDirectory#getAnnotationName()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#getAnnotationName()}
   */
  @Test
  @DisplayName("Test getAnnotationName(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDTargetDirectory.getAnnotationName()"})
  void testGetAnnotationName_thenReturnEmptyString() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();
    pdTargetDirectory.setAnnotationName("");

    // Act and Assert
    assertEquals("", pdTargetDirectory.getAnnotationName());
  }

  /**
   * Test {@link PDTargetDirectory#setAnnotationName(String)}.
   *
   * <ul>
   *   <li>Then {@link PDTargetDirectory#PDTargetDirectory()} AnnotationName is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#setAnnotationName(String)}
   */
  @Test
  @DisplayName("Test setAnnotationName(String); then PDTargetDirectory() AnnotationName is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTargetDirectory.setAnnotationName(String)"})
  void testSetAnnotationName_thenPDTargetDirectoryAnnotationNameIsName() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();

    // Act
    pdTargetDirectory.setAnnotationName("Name");

    // Assert
    assertEquals("Name", pdTargetDirectory.getAnnotationName());
    COSDictionary cOSObject = pdTargetDirectory.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDTargetDirectory#setAnnotationName(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDTargetDirectory#PDTargetDirectory()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDTargetDirectory#setAnnotationName(String)}
   */
  @Test
  @DisplayName(
      "Test setAnnotationName(String); when 'null'; then PDTargetDirectory() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTargetDirectory.setAnnotationName(String)"})
  void testSetAnnotationName_whenNull_thenPDTargetDirectoryCOSObjectSizeIsZero() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();

    // Act
    pdTargetDirectory.setAnnotationName(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdTargetDirectory.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }
}

package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDWindowsLaunchParamsDiffblueTest {
  /**
   * Test {@link PDWindowsLaunchParams#PDWindowsLaunchParams(COSDictionary)}.
   *
   * <p>Method under test: {@link PDWindowsLaunchParams#PDWindowsLaunchParams(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDWindowsLaunchParams(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDWindowsLaunchParams.<init>(COSDictionary)"})
  void testNewPDWindowsLaunchParams() {
    // Arrange
    COSDictionary p = new COSDictionary();

    // Act and Assert
    assertSame(p, new PDWindowsLaunchParams(p).getCOSObject());
  }

  /**
   * Test {@link PDWindowsLaunchParams#PDWindowsLaunchParams()}.
   *
   * <p>Method under test: {@link PDWindowsLaunchParams#PDWindowsLaunchParams()}
   */
  @Test
  @DisplayName("Test new PDWindowsLaunchParams()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDWindowsLaunchParams.<init>()"})
  void testNewPDWindowsLaunchParams2() {
    // Arrange and Act
    PDWindowsLaunchParams actualPdWindowsLaunchParams = new PDWindowsLaunchParams();

    // Assert
    assertNull(actualPdWindowsLaunchParams.getDirectory());
    assertNull(actualPdWindowsLaunchParams.getExecuteParam());
    assertNull(actualPdWindowsLaunchParams.getFilename());
    COSDictionary cOSObject = actualPdWindowsLaunchParams.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDWindowsLaunchParams.OPERATION_OPEN, actualPdWindowsLaunchParams.getOperation());
  }

  /**
   * Test {@link PDWindowsLaunchParams#getCOSObject()}.
   *
   * <p>Method under test: {@link PDWindowsLaunchParams#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDWindowsLaunchParams.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange
    PDWindowsLaunchParams pdWindowsLaunchParams = new PDWindowsLaunchParams();

    // Act
    COSDictionary actualCOSObject = pdWindowsLaunchParams.getCOSObject();

    // Assert
    assertSame(pdWindowsLaunchParams.params, actualCOSObject);
  }

  /**
   * Test {@link PDWindowsLaunchParams#getFilename()}.
   *
   * <ul>
   *   <li>Given {@link PDWindowsLaunchParams#PDWindowsLaunchParams()} Filename is {@code File}.
   *   <li>Then return {@code File}.
   * </ul>
   *
   * <p>Method under test: {@link PDWindowsLaunchParams#getFilename()}
   */
  @Test
  @DisplayName(
      "Test getFilename(); given PDWindowsLaunchParams() Filename is 'File'; then return 'File'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDWindowsLaunchParams.getFilename()"})
  void testGetFilename_givenPDWindowsLaunchParamsFilenameIsFile_thenReturnFile() {
    // Arrange
    PDWindowsLaunchParams pdWindowsLaunchParams = new PDWindowsLaunchParams();
    pdWindowsLaunchParams.setFilename("File");

    // Act and Assert
    assertEquals("File", pdWindowsLaunchParams.getFilename());
  }

  /**
   * Test {@link PDWindowsLaunchParams#getFilename()}.
   *
   * <ul>
   *   <li>Given {@link PDWindowsLaunchParams#PDWindowsLaunchParams()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDWindowsLaunchParams#getFilename()}
   */
  @Test
  @DisplayName("Test getFilename(); given PDWindowsLaunchParams(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDWindowsLaunchParams.getFilename()"})
  void testGetFilename_givenPDWindowsLaunchParams_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDWindowsLaunchParams().getFilename());
  }

  /**
   * Test {@link PDWindowsLaunchParams#getFilename()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDWindowsLaunchParams#getFilename()}
   */
  @Test
  @DisplayName("Test getFilename(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDWindowsLaunchParams.getFilename()"})
  void testGetFilename_thenReturnEmptyString() {
    // Arrange
    PDWindowsLaunchParams pdWindowsLaunchParams = new PDWindowsLaunchParams();
    pdWindowsLaunchParams.setFilename("");

    // Act and Assert
    assertEquals("", pdWindowsLaunchParams.getFilename());
  }

  /**
   * Test {@link PDWindowsLaunchParams#setFilename(String)}.
   *
   * <ul>
   *   <li>Then {@link PDWindowsLaunchParams#PDWindowsLaunchParams()} Filename is {@code File}.
   * </ul>
   *
   * <p>Method under test: {@link PDWindowsLaunchParams#setFilename(String)}
   */
  @Test
  @DisplayName("Test setFilename(String); then PDWindowsLaunchParams() Filename is 'File'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDWindowsLaunchParams.setFilename(String)"})
  void testSetFilename_thenPDWindowsLaunchParamsFilenameIsFile() {
    // Arrange
    PDWindowsLaunchParams pdWindowsLaunchParams = new PDWindowsLaunchParams();

    // Act
    pdWindowsLaunchParams.setFilename("File");

    // Assert
    assertEquals("File", pdWindowsLaunchParams.getFilename());
    COSDictionary cOSObject = pdWindowsLaunchParams.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDWindowsLaunchParams#setFilename(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDWindowsLaunchParams#PDWindowsLaunchParams()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDWindowsLaunchParams#setFilename(String)}
   */
  @Test
  @DisplayName(
      "Test setFilename(String); when 'null'; then PDWindowsLaunchParams() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDWindowsLaunchParams.setFilename(String)"})
  void testSetFilename_whenNull_thenPDWindowsLaunchParamsCOSObjectSizeIsZero() {
    // Arrange
    PDWindowsLaunchParams pdWindowsLaunchParams = new PDWindowsLaunchParams();

    // Act
    pdWindowsLaunchParams.setFilename(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdWindowsLaunchParams.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDWindowsLaunchParams#getDirectory()}.
   *
   * <ul>
   *   <li>Given {@link PDWindowsLaunchParams#PDWindowsLaunchParams()} Directory is {@code Dir}.
   *   <li>Then return {@code Dir}.
   * </ul>
   *
   * <p>Method under test: {@link PDWindowsLaunchParams#getDirectory()}
   */
  @Test
  @DisplayName(
      "Test getDirectory(); given PDWindowsLaunchParams() Directory is 'Dir'; then return 'Dir'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDWindowsLaunchParams.getDirectory()"})
  void testGetDirectory_givenPDWindowsLaunchParamsDirectoryIsDir_thenReturnDir() {
    // Arrange
    PDWindowsLaunchParams pdWindowsLaunchParams = new PDWindowsLaunchParams();
    pdWindowsLaunchParams.setDirectory("Dir");

    // Act and Assert
    assertEquals("Dir", pdWindowsLaunchParams.getDirectory());
  }

  /**
   * Test {@link PDWindowsLaunchParams#getDirectory()}.
   *
   * <ul>
   *   <li>Given {@link PDWindowsLaunchParams#PDWindowsLaunchParams()} Filename is {@code File}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDWindowsLaunchParams#getDirectory()}
   */
  @Test
  @DisplayName(
      "Test getDirectory(); given PDWindowsLaunchParams() Filename is 'File'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDWindowsLaunchParams.getDirectory()"})
  void testGetDirectory_givenPDWindowsLaunchParamsFilenameIsFile_thenReturnNull() {
    // Arrange
    PDWindowsLaunchParams pdWindowsLaunchParams = new PDWindowsLaunchParams();
    pdWindowsLaunchParams.setFilename("File");

    // Act and Assert
    assertNull(pdWindowsLaunchParams.getDirectory());
  }

  /**
   * Test {@link PDWindowsLaunchParams#getDirectory()}.
   *
   * <ul>
   *   <li>Given {@link PDWindowsLaunchParams#PDWindowsLaunchParams()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDWindowsLaunchParams#getDirectory()}
   */
  @Test
  @DisplayName("Test getDirectory(); given PDWindowsLaunchParams(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDWindowsLaunchParams.getDirectory()"})
  void testGetDirectory_givenPDWindowsLaunchParams_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDWindowsLaunchParams().getDirectory());
  }

  /**
   * Test {@link PDWindowsLaunchParams#getDirectory()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDWindowsLaunchParams#getDirectory()}
   */
  @Test
  @DisplayName("Test getDirectory(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDWindowsLaunchParams.getDirectory()"})
  void testGetDirectory_thenReturnEmptyString() {
    // Arrange
    PDWindowsLaunchParams pdWindowsLaunchParams = new PDWindowsLaunchParams();
    pdWindowsLaunchParams.setDirectory("");

    // Act and Assert
    assertEquals("", pdWindowsLaunchParams.getDirectory());
  }

  /**
   * Test {@link PDWindowsLaunchParams#setDirectory(String)}.
   *
   * <ul>
   *   <li>Then {@link PDWindowsLaunchParams#PDWindowsLaunchParams()} Directory is {@code Dir}.
   * </ul>
   *
   * <p>Method under test: {@link PDWindowsLaunchParams#setDirectory(String)}
   */
  @Test
  @DisplayName("Test setDirectory(String); then PDWindowsLaunchParams() Directory is 'Dir'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDWindowsLaunchParams.setDirectory(String)"})
  void testSetDirectory_thenPDWindowsLaunchParamsDirectoryIsDir() {
    // Arrange
    PDWindowsLaunchParams pdWindowsLaunchParams = new PDWindowsLaunchParams();

    // Act
    pdWindowsLaunchParams.setDirectory("Dir");

    // Assert
    assertEquals("Dir", pdWindowsLaunchParams.getDirectory());
    COSDictionary cOSObject = pdWindowsLaunchParams.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDWindowsLaunchParams#setDirectory(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDWindowsLaunchParams#PDWindowsLaunchParams()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDWindowsLaunchParams#setDirectory(String)}
   */
  @Test
  @DisplayName(
      "Test setDirectory(String); when 'null'; then PDWindowsLaunchParams() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDWindowsLaunchParams.setDirectory(String)"})
  void testSetDirectory_whenNull_thenPDWindowsLaunchParamsCOSObjectSizeIsZero() {
    // Arrange
    PDWindowsLaunchParams pdWindowsLaunchParams = new PDWindowsLaunchParams();

    // Act
    pdWindowsLaunchParams.setDirectory(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdWindowsLaunchParams.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDWindowsLaunchParams#getOperation()}.
   *
   * <ul>
   *   <li>Given {@link PDWindowsLaunchParams#PDWindowsLaunchParams()} Filename is {@link
   *       PDWindowsLaunchParams#OPERATION_OPEN}.
   * </ul>
   *
   * <p>Method under test: {@link PDWindowsLaunchParams#getOperation()}
   */
  @Test
  @DisplayName("Test getOperation(); given PDWindowsLaunchParams() Filename is OPERATION_OPEN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDWindowsLaunchParams.getOperation()"})
  void testGetOperation_givenPDWindowsLaunchParamsFilenameIsOperation_open() {
    // Arrange
    PDWindowsLaunchParams pdWindowsLaunchParams = new PDWindowsLaunchParams();
    pdWindowsLaunchParams.setFilename(PDWindowsLaunchParams.OPERATION_OPEN);

    // Act and Assert
    assertEquals(PDWindowsLaunchParams.OPERATION_OPEN, pdWindowsLaunchParams.getOperation());
  }

  /**
   * Test {@link PDWindowsLaunchParams#getOperation()}.
   *
   * <ul>
   *   <li>Given {@link PDWindowsLaunchParams#PDWindowsLaunchParams()}.
   *   <li>Then return {@link PDWindowsLaunchParams#OPERATION_OPEN}.
   * </ul>
   *
   * <p>Method under test: {@link PDWindowsLaunchParams#getOperation()}
   */
  @Test
  @DisplayName("Test getOperation(); given PDWindowsLaunchParams(); then return OPERATION_OPEN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDWindowsLaunchParams.getOperation()"})
  void testGetOperation_givenPDWindowsLaunchParams_thenReturnOperation_open() {
    // Arrange, Act and Assert
    assertEquals(PDWindowsLaunchParams.OPERATION_OPEN, new PDWindowsLaunchParams().getOperation());
  }

  /**
   * Test {@link PDWindowsLaunchParams#setOperation(String)}.
   *
   * <ul>
   *   <li>Then {@link PDWindowsLaunchParams#PDWindowsLaunchParams()} Directory is {@code Op}.
   * </ul>
   *
   * <p>Method under test: {@link PDWindowsLaunchParams#setOperation(String)}
   */
  @Test
  @DisplayName("Test setOperation(String); then PDWindowsLaunchParams() Directory is 'Op'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDWindowsLaunchParams.setOperation(String)"})
  void testSetOperation_thenPDWindowsLaunchParamsDirectoryIsOp() {
    // Arrange
    PDWindowsLaunchParams pdWindowsLaunchParams = new PDWindowsLaunchParams();

    // Act
    pdWindowsLaunchParams.setOperation("Op");

    // Assert
    assertEquals("Op", pdWindowsLaunchParams.getDirectory());
    COSDictionary cOSObject = pdWindowsLaunchParams.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDWindowsLaunchParams#setOperation(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDWindowsLaunchParams#PDWindowsLaunchParams()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDWindowsLaunchParams#setOperation(String)}
   */
  @Test
  @DisplayName(
      "Test setOperation(String); when 'null'; then PDWindowsLaunchParams() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDWindowsLaunchParams.setOperation(String)"})
  void testSetOperation_whenNull_thenPDWindowsLaunchParamsCOSObjectSizeIsZero() {
    // Arrange
    PDWindowsLaunchParams pdWindowsLaunchParams = new PDWindowsLaunchParams();

    // Act
    pdWindowsLaunchParams.setOperation(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdWindowsLaunchParams.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDWindowsLaunchParams#getExecuteParam()}.
   *
   * <ul>
   *   <li>Given {@link PDWindowsLaunchParams#PDWindowsLaunchParams()} Filename is {@code File}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDWindowsLaunchParams#getExecuteParam()}
   */
  @Test
  @DisplayName(
      "Test getExecuteParam(); given PDWindowsLaunchParams() Filename is 'File'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDWindowsLaunchParams.getExecuteParam()"})
  void testGetExecuteParam_givenPDWindowsLaunchParamsFilenameIsFile_thenReturnNull() {
    // Arrange
    PDWindowsLaunchParams pdWindowsLaunchParams = new PDWindowsLaunchParams();
    pdWindowsLaunchParams.setFilename("File");

    // Act and Assert
    assertNull(pdWindowsLaunchParams.getExecuteParam());
  }

  /**
   * Test {@link PDWindowsLaunchParams#getExecuteParam()}.
   *
   * <ul>
   *   <li>Given {@link PDWindowsLaunchParams#PDWindowsLaunchParams()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDWindowsLaunchParams#getExecuteParam()}
   */
  @Test
  @DisplayName("Test getExecuteParam(); given PDWindowsLaunchParams(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDWindowsLaunchParams.getExecuteParam()"})
  void testGetExecuteParam_givenPDWindowsLaunchParams_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDWindowsLaunchParams().getExecuteParam());
  }

  /**
   * Test {@link PDWindowsLaunchParams#getExecuteParam()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDWindowsLaunchParams#getExecuteParam()}
   */
  @Test
  @DisplayName("Test getExecuteParam(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDWindowsLaunchParams.getExecuteParam()"})
  void testGetExecuteParam_thenReturnEmptyString() {
    // Arrange
    PDWindowsLaunchParams pdWindowsLaunchParams = new PDWindowsLaunchParams();
    pdWindowsLaunchParams.setExecuteParam("");

    // Act and Assert
    assertEquals("", pdWindowsLaunchParams.getExecuteParam());
  }

  /**
   * Test {@link PDWindowsLaunchParams#getExecuteParam()}.
   *
   * <ul>
   *   <li>Then return {@code Param}.
   * </ul>
   *
   * <p>Method under test: {@link PDWindowsLaunchParams#getExecuteParam()}
   */
  @Test
  @DisplayName("Test getExecuteParam(); then return 'Param'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDWindowsLaunchParams.getExecuteParam()"})
  void testGetExecuteParam_thenReturnParam() {
    // Arrange
    PDWindowsLaunchParams pdWindowsLaunchParams = new PDWindowsLaunchParams();
    pdWindowsLaunchParams.setExecuteParam("Param");

    // Act and Assert
    assertEquals("Param", pdWindowsLaunchParams.getExecuteParam());
  }

  /**
   * Test {@link PDWindowsLaunchParams#setExecuteParam(String)}.
   *
   * <ul>
   *   <li>Then {@link PDWindowsLaunchParams#PDWindowsLaunchParams()} ExecuteParam is {@code Param}.
   * </ul>
   *
   * <p>Method under test: {@link PDWindowsLaunchParams#setExecuteParam(String)}
   */
  @Test
  @DisplayName("Test setExecuteParam(String); then PDWindowsLaunchParams() ExecuteParam is 'Param'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDWindowsLaunchParams.setExecuteParam(String)"})
  void testSetExecuteParam_thenPDWindowsLaunchParamsExecuteParamIsParam() {
    // Arrange
    PDWindowsLaunchParams pdWindowsLaunchParams = new PDWindowsLaunchParams();

    // Act
    pdWindowsLaunchParams.setExecuteParam("Param");

    // Assert
    assertEquals("Param", pdWindowsLaunchParams.getExecuteParam());
    COSDictionary cOSObject = pdWindowsLaunchParams.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDWindowsLaunchParams#setExecuteParam(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDWindowsLaunchParams#PDWindowsLaunchParams()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDWindowsLaunchParams#setExecuteParam(String)}
   */
  @Test
  @DisplayName(
      "Test setExecuteParam(String); when 'null'; then PDWindowsLaunchParams() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDWindowsLaunchParams.setExecuteParam(String)"})
  void testSetExecuteParam_whenNull_thenPDWindowsLaunchParamsCOSObjectSizeIsZero() {
    // Arrange
    PDWindowsLaunchParams pdWindowsLaunchParams = new PDWindowsLaunchParams();

    // Act
    pdWindowsLaunchParams.setExecuteParam(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdWindowsLaunchParams.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }
}

package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FDFPageDiffblueTest {
  /**
   * Method under test: {@link FDFPage#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new FDFPage()).getCOSObject();

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
   * Method under test: {@link FDFPage#getTemplates()}
   */
  @Test
  void testGetTemplates() {
    // Arrange, Act and Assert
    assertNull((new FDFPage()).getTemplates());
  }

  /**
   * Method under test: {@link FDFPage#getTemplates()}
   */
  @Test
  void testGetTemplates2() {
    // Arrange
    FDFPage fdfPage = new FDFPage();
    fdfPage.setTemplates(new ArrayList<>());

    // Act and Assert
    assertTrue(fdfPage.getTemplates().isEmpty());
  }

  /**
   * Method under test: {@link FDFPage#getTemplates()}
   */
  @Test
  void testGetTemplates3() {
    // Arrange
    ArrayList<FDFTemplate> templates = new ArrayList<>();
    templates.add(new FDFTemplate());

    FDFPage fdfPage = new FDFPage();
    fdfPage.setTemplates(templates);

    // Act
    List<FDFTemplate> actualTemplates = fdfPage.getTemplates();

    // Assert
    assertEquals(1, actualTemplates.size());
    FDFTemplate getResult = actualTemplates.get(0);
    assertNull(getResult.getFields());
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getTemplateReference());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link FDFPage#setTemplates(List)}
   */
  @Test
  void testSetTemplates() {
    // Arrange
    FDFPage fdfPage = new FDFPage();

    // Act
    fdfPage.setTemplates(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = fdfPage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(fdfPage.getTemplates().isEmpty());
  }

  /**
   * Method under test: {@link FDFPage#setTemplates(List)}
   */
  @Test
  void testSetTemplates2() {
    // Arrange
    FDFPage fdfPage = new FDFPage();

    ArrayList<FDFTemplate> templates = new ArrayList<>();
    templates.add(new FDFTemplate());

    // Act
    fdfPage.setTemplates(templates);

    // Assert
    List<FDFTemplate> templates2 = fdfPage.getTemplates();
    assertEquals(1, templates2.size());
    FDFTemplate getResult = templates2.get(0);
    assertNull(getResult.getFields());
    assertNull(getResult.getTemplateReference());
    COSDictionary cOSObject = fdfPage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFPage#setTemplates(List)}
   */
  @Test
  void testSetTemplates3() {
    // Arrange
    FDFPage fdfPage = new FDFPage();

    ArrayList<FDFTemplate> templates = new ArrayList<>();
    templates.add(new FDFTemplate());
    templates.add(new FDFTemplate());

    // Act
    fdfPage.setTemplates(templates);

    // Assert
    List<FDFTemplate> templates2 = fdfPage.getTemplates();
    assertEquals(2, templates2.size());
    FDFTemplate getResult = templates2.get(0);
    assertNull(getResult.getFields());
    FDFTemplate getResult2 = templates2.get(1);
    assertNull(getResult2.getFields());
    assertNull(getResult.getTemplateReference());
    assertNull(getResult2.getTemplateReference());
    COSDictionary cOSObject = fdfPage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFPage#setTemplates(List)}
   */
  @Test
  void testSetTemplates4() {
    // Arrange
    FDFPage fdfPage = new FDFPage();

    ArrayList<FDFTemplate> templates = new ArrayList<>();
    templates.add(null);

    // Act
    fdfPage.setTemplates(templates);

    // Assert
    List<FDFTemplate> templates2 = fdfPage.getTemplates();
    assertEquals(1, templates2.size());
    assertNull(templates2.get(0).getCOSObject());
    COSDictionary cOSObject = fdfPage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFPage#getPageInfo()}
   */
  @Test
  void testGetPageInfo() {
    // Arrange
    COSDictionary p = mock(COSDictionary.class);
    COSDictionary cosDictionary = new COSDictionary();
    when(p.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    // Act
    COSDictionary actualCOSObject = (new FDFPage(p)).getPageInfo().getCOSObject();

    // Assert
    verify(p).getCOSDictionary(isA(COSName.class));
    assertSame(cosDictionary, actualCOSObject);
  }

  /**
   * Method under test: {@link FDFPage#setPageInfo(FDFPageInfo)}
   */
  @Test
  void testSetPageInfo() {
    // Arrange
    FDFPage fdfPage = new FDFPage();

    // Act
    fdfPage.setPageInfo(new FDFPageInfo());

    // Assert
    COSDictionary cOSObject = fdfPage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFPage#setPageInfo(FDFPageInfo)}
   */
  @Test
  void testSetPageInfo2() {
    // Arrange
    FDFPage fdfPage = new FDFPage();

    // Act
    fdfPage.setPageInfo(null);

    // Assert
    assertNull(fdfPage.getPageInfo());
    COSDictionary cOSObject = fdfPage.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Method under test: {@link FDFPage#setPageInfo(FDFPageInfo)}
   */
  @Test
  void testSetPageInfo3() {
    // Arrange
    FDFPage fdfPage = new FDFPage();

    COSDictionary p = new COSDictionary();
    p.setDirect(true);

    // Act
    fdfPage.setPageInfo(new FDFPageInfo(p));

    // Assert
    COSDictionary cOSObject = fdfPage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(p, fdfPage.getPageInfo().getCOSObject());
  }

  /**
   * Method under test: {@link FDFPage#setPageInfo(FDFPageInfo)}
   */
  @Test
  void testSetPageInfo4() {
    // Arrange
    FDFPage fdfPage = new FDFPage();

    COSDictionary p = new COSDictionary();
    p.setKey(new COSObjectKey(1L, 1));

    // Act
    fdfPage.setPageInfo(new FDFPageInfo(p));

    // Assert
    COSDictionary cOSObject = fdfPage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(p, fdfPage.getPageInfo().getCOSObject());
  }

  /**
   * Method under test: {@link FDFPage#FDFPage(COSDictionary)}
   */
  @Test
  void testNewFDFPage() {
    // Arrange
    COSDictionary p = new COSDictionary();

    // Act and Assert
    assertSame(p, (new FDFPage(p)).getCOSObject());
  }

  /**
   * Method under test: {@link FDFPage#FDFPage()}
   */
  @Test
  void testNewFDFPage2() {
    // Arrange and Act
    FDFPage actualFdfPage = new FDFPage();

    // Assert
    assertNull(actualFdfPage.getTemplates());
    COSDictionary cOSObject = actualFdfPage.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfPage.getPageInfo());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}

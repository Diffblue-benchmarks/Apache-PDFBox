package org.apache.pdfbox.pdmodel.interactive.pagenavigation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDThreadBeadDiffblueTest {
  /**
   * Test {@link PDThreadBead#PDThreadBead(COSDictionary)}.
   * <p>
   * Method under test: {@link PDThreadBead#PDThreadBead(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDThreadBead(COSDictionary)")
  void testNewPDThreadBead() {
    // Arrange
    COSDictionary b = new COSDictionary();

    // Act
    PDThreadBead actualPdThreadBead = new PDThreadBead(b);

    // Assert
    assertNull(actualPdThreadBead.getNextBead().getCOSObject());
    assertNull(actualPdThreadBead.getPreviousBead().getCOSObject());
    assertSame(b, actualPdThreadBead.getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#PDThreadBead()}.
   * <p>
   * Method under test: {@link PDThreadBead#PDThreadBead()}
   */
  @Test
  @DisplayName("Test new PDThreadBead()")
  void testNewPDThreadBead2() {
    // Arrange and Act
    PDThreadBead actualPdThreadBead = new PDThreadBead();

    // Assert
    COSDictionary cOSObject = actualPdThreadBead.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdThreadBead.getPage());
    PDThreadBead nextBead = actualPdThreadBead.getNextBead();
    assertNull(nextBead.getPage());
    PDThreadBead nextBead2 = nextBead.getNextBead();
    assertNull(nextBead2.getPage());
    PDThreadBead nextBead3 = nextBead2.getNextBead();
    assertNull(nextBead3.getPage());
    PDThreadBead nextBead4 = nextBead3.getNextBead();
    assertNull(nextBead4.getPage());
    PDThreadBead nextBead5 = nextBead4.getNextBead();
    assertNull(nextBead5.getPage());
    PDThreadBead nextBead6 = nextBead5.getNextBead();
    assertNull(nextBead6.getPage());
    PDThreadBead nextBead7 = nextBead6.getNextBead();
    assertNull(nextBead7.getPage());
    PDThreadBead previousBead = actualPdThreadBead.getPreviousBead();
    PDThreadBead nextBead8 = previousBead.getNextBead();
    PDThreadBead nextBead9 = nextBead8.getNextBead();
    PDThreadBead nextBead10 = nextBead9.getNextBead();
    PDThreadBead nextBead11 = nextBead10.getNextBead();
    PDThreadBead nextBead12 = nextBead11.getNextBead();
    assertNull(nextBead12.getPage());
    PDThreadBead previousBead2 = nextBead.getPreviousBead();
    PDThreadBead nextBead13 = previousBead2.getNextBead();
    PDThreadBead nextBead14 = nextBead13.getNextBead();
    PDThreadBead nextBead15 = nextBead14.getNextBead();
    PDThreadBead nextBead16 = nextBead15.getNextBead();
    PDThreadBead nextBead17 = nextBead16.getNextBead();
    assertNull(nextBead17.getPage());
    assertNull(nextBead11.getPage());
    assertNull(nextBead16.getPage());
    PDThreadBead previousBead3 = nextBead2.getPreviousBead();
    PDThreadBead nextBead18 = previousBead3.getNextBead();
    PDThreadBead nextBead19 = nextBead18.getNextBead();
    PDThreadBead nextBead20 = nextBead19.getNextBead();
    PDThreadBead nextBead21 = nextBead20.getNextBead();
    assertNull(nextBead21.getPage());
    PDThreadBead previousBead4 = previousBead.getPreviousBead();
    PDThreadBead nextBead22 = previousBead4.getNextBead();
    PDThreadBead nextBead23 = nextBead22.getNextBead();
    PDThreadBead nextBead24 = nextBead23.getNextBead();
    PDThreadBead nextBead25 = nextBead24.getNextBead();
    assertNull(nextBead25.getPage());
    assertNull(nextBead10.getPage());
    assertNull(nextBead15.getPage());
    assertNull(nextBead20.getPage());
    PDThreadBead previousBead5 = nextBead3.getPreviousBead();
    PDThreadBead nextBead26 = previousBead5.getNextBead();
    PDThreadBead nextBead27 = nextBead26.getNextBead();
    PDThreadBead nextBead28 = nextBead27.getNextBead();
    assertNull(nextBead28.getPage());
    PDThreadBead previousBead6 = nextBead8.getPreviousBead();
    PDThreadBead nextBead29 = previousBead6.getNextBead();
    PDThreadBead nextBead30 = nextBead29.getNextBead();
    PDThreadBead nextBead31 = nextBead30.getNextBead();
    assertNull(nextBead31.getPage());
    assertNull(nextBead24.getPage());
    PDThreadBead previousBead7 = previousBead2.getPreviousBead();
    PDThreadBead nextBead32 = previousBead7.getNextBead();
    PDThreadBead nextBead33 = nextBead32.getNextBead();
    PDThreadBead nextBead34 = nextBead33.getNextBead();
    assertNull(nextBead34.getPage());
    PDThreadBead previousBead8 = previousBead3.getPreviousBead();
    PDThreadBead nextBead35 = previousBead8.getNextBead();
    PDThreadBead nextBead36 = nextBead35.getNextBead();
    PDThreadBead nextBead37 = nextBead36.getNextBead();
    assertNull(nextBead37.getPage());
    PDThreadBead previousBead9 = previousBead4.getPreviousBead();
    PDThreadBead nextBead38 = previousBead9.getNextBead();
    PDThreadBead nextBead39 = nextBead38.getNextBead();
    PDThreadBead nextBead40 = nextBead39.getNextBead();
    assertNull(nextBead40.getPage());
    assertNull(nextBead9.getPage());
    assertNull(nextBead14.getPage());
    assertNull(nextBead19.getPage());
    assertNull(nextBead27.getPage());
    PDThreadBead previousBead10 = nextBead4.getPreviousBead();
    PDThreadBead nextBead41 = previousBead10.getNextBead();
    PDThreadBead nextBead42 = nextBead41.getNextBead();
    assertNull(nextBead42.getPage());
    PDThreadBead previousBead11 = nextBead9.getPreviousBead();
    PDThreadBead nextBead43 = previousBead11.getNextBead();
    PDThreadBead nextBead44 = nextBead43.getNextBead();
    assertNull(nextBead44.getPage());
    PDThreadBead previousBead12 = nextBead14.getPreviousBead();
    PDThreadBead nextBead45 = previousBead12.getNextBead();
    PDThreadBead nextBead46 = nextBead45.getNextBead();
    assertNull(nextBead46.getPage());
    assertNull(nextBead30.getPage());
    PDThreadBead previousBead13 = nextBead13.getPreviousBead();
    PDThreadBead nextBead47 = previousBead13.getNextBead();
    PDThreadBead nextBead48 = nextBead47.getNextBead();
    assertNull(nextBead48.getPage());
    PDThreadBead previousBead14 = nextBead18.getPreviousBead();
    PDThreadBead nextBead49 = previousBead14.getNextBead();
    PDThreadBead nextBead50 = nextBead49.getNextBead();
    assertNull(nextBead50.getPage());
    PDThreadBead previousBead15 = nextBead22.getPreviousBead();
    PDThreadBead nextBead51 = previousBead15.getNextBead();
    PDThreadBead nextBead52 = nextBead51.getNextBead();
    assertNull(nextBead52.getPage());
    assertNull(nextBead23.getPage());
    assertNull(nextBead33.getPage());
    assertNull(nextBead36.getPage());
    PDThreadBead previousBead16 = previousBead5.getPreviousBead();
    PDThreadBead nextBead53 = previousBead16.getNextBead();
    PDThreadBead nextBead54 = nextBead53.getNextBead();
    assertNull(nextBead54.getPage());
    PDThreadBead previousBead17 = previousBead6.getPreviousBead();
    PDThreadBead nextBead55 = previousBead17.getNextBead();
    PDThreadBead nextBead56 = nextBead55.getNextBead();
    assertNull(nextBead56.getPage());
    assertNull(nextBead39.getPage());
    PDThreadBead previousBead18 = previousBead7.getPreviousBead();
    PDThreadBead nextBead57 = previousBead18.getNextBead();
    PDThreadBead nextBead58 = nextBead57.getNextBead();
    assertNull(nextBead58.getPage());
    PDThreadBead previousBead19 = previousBead8.getPreviousBead();
    PDThreadBead nextBead59 = previousBead19.getNextBead();
    PDThreadBead nextBead60 = nextBead59.getNextBead();
    assertNull(nextBead60.getPage());
    PDThreadBead previousBead20 = previousBead9.getPreviousBead();
    PDThreadBead nextBead61 = previousBead20.getNextBead();
    PDThreadBead nextBead62 = nextBead61.getNextBead();
    assertNull(nextBead62.getPage());
    assertNull(nextBead8.getPage());
    assertNull(nextBead13.getPage());
    assertNull(nextBead18.getPage());
    assertNull(nextBead26.getPage());
    assertNull(nextBead41.getPage());
    PDThreadBead previousBead21 = nextBead5.getPreviousBead();
    PDThreadBead nextBead63 = previousBead21.getNextBead();
    assertNull(nextBead63.getPage());
    PDThreadBead previousBead22 = nextBead10.getPreviousBead();
    PDThreadBead nextBead64 = previousBead22.getNextBead();
    assertNull(nextBead64.getPage());
    PDThreadBead previousBead23 = nextBead15.getPreviousBead();
    PDThreadBead nextBead65 = previousBead23.getNextBead();
    assertNull(nextBead65.getPage());
    assertNull(nextBead43.getPage());
    assertNull(nextBead45.getPage());
    PDThreadBead previousBead24 = nextBead19.getPreviousBead();
    PDThreadBead nextBead66 = previousBead24.getNextBead();
    assertNull(nextBead66.getPage());
    PDThreadBead previousBead25 = nextBead23.getPreviousBead();
    PDThreadBead nextBead67 = previousBead25.getNextBead();
    assertNull(nextBead67.getPage());
    assertNull(nextBead29.getPage());
    assertNull(nextBead47.getPage());
    assertNull(nextBead49.getPage());
    PDThreadBead previousBead26 = nextBead26.getPreviousBead();
    PDThreadBead nextBead68 = previousBead26.getNextBead();
    assertNull(nextBead68.getPage());
    PDThreadBead previousBead27 = nextBead29.getPreviousBead();
    PDThreadBead nextBead69 = previousBead27.getNextBead();
    assertNull(nextBead69.getPage());
    assertNull(nextBead51.getPage());
    PDThreadBead previousBead28 = nextBead32.getPreviousBead();
    PDThreadBead nextBead70 = previousBead28.getNextBead();
    assertNull(nextBead70.getPage());
    PDThreadBead previousBead29 = nextBead35.getPreviousBead();
    PDThreadBead nextBead71 = previousBead29.getNextBead();
    assertNull(nextBead71.getPage());
    PDThreadBead previousBead30 = nextBead38.getPreviousBead();
    PDThreadBead nextBead72 = previousBead30.getNextBead();
    assertNull(nextBead72.getPage());
    assertNull(nextBead22.getPage());
    assertNull(nextBead32.getPage());
    assertNull(nextBead35.getPage());
    assertNull(nextBead53.getPage());
    PDThreadBead previousBead31 = previousBead10.getPreviousBead();
    PDThreadBead nextBead73 = previousBead31.getNextBead();
    assertNull(nextBead73.getPage());
    PDThreadBead previousBead32 = previousBead11.getPreviousBead();
    PDThreadBead nextBead74 = previousBead32.getNextBead();
    assertNull(nextBead74.getPage());
    assertNull(nextBead55.getPage());
    PDThreadBead previousBead33 = previousBead13.getPreviousBead();
    PDThreadBead nextBead75 = previousBead33.getNextBead();
    assertNull(nextBead75.getPage());
    PDThreadBead previousBead34 = previousBead14.getPreviousBead();
    PDThreadBead nextBead76 = previousBead34.getNextBead();
    assertNull(nextBead76.getPage());
    PDThreadBead previousBead35 = previousBead15.getPreviousBead();
    PDThreadBead nextBead77 = previousBead35.getNextBead();
    assertNull(nextBead77.getPage());
    assertNull(nextBead38.getPage());
    assertNull(nextBead57.getPage());
    assertNull(nextBead59.getPage());
    PDThreadBead previousBead36 = previousBead16.getPreviousBead();
    PDThreadBead nextBead78 = previousBead36.getNextBead();
    assertNull(nextBead78.getPage());
    PDThreadBead previousBead37 = previousBead17.getPreviousBead();
    PDThreadBead nextBead79 = previousBead37.getNextBead();
    assertNull(nextBead79.getPage());
    assertNull(nextBead61.getPage());
    PDThreadBead previousBead38 = previousBead18.getPreviousBead();
    PDThreadBead nextBead80 = previousBead38.getNextBead();
    assertNull(nextBead80.getPage());
    PDThreadBead previousBead39 = previousBead19.getPreviousBead();
    PDThreadBead nextBead81 = previousBead39.getNextBead();
    assertNull(nextBead81.getPage());
    PDThreadBead previousBead40 = previousBead20.getPreviousBead();
    PDThreadBead nextBead82 = previousBead40.getNextBead();
    assertNull(nextBead82.getPage());
    assertNull(previousBead.getPage());
    assertNull(previousBead2.getPage());
    assertNull(previousBead3.getPage());
    assertNull(previousBead5.getPage());
    assertNull(previousBead10.getPage());
    assertNull(previousBead21.getPage());
    PDThreadBead previousBead41 = nextBead6.getPreviousBead();
    assertNull(previousBead41.getPage());
    PDThreadBead previousBead42 = nextBead11.getPreviousBead();
    assertNull(previousBead42.getPage());
    PDThreadBead previousBead43 = nextBead16.getPreviousBead();
    assertNull(previousBead43.getPage());
    assertNull(previousBead22.getPage());
    assertNull(previousBead23.getPage());
    PDThreadBead previousBead44 = nextBead20.getPreviousBead();
    assertNull(previousBead44.getPage());
    PDThreadBead previousBead45 = nextBead24.getPreviousBead();
    assertNull(previousBead45.getPage());
    assertNull(previousBead11.getPage());
    assertNull(previousBead12.getPage());
    assertNull(previousBead24.getPage());
    PDThreadBead previousBead46 = nextBead27.getPreviousBead();
    assertNull(previousBead46.getPage());
    PDThreadBead previousBead47 = nextBead30.getPreviousBead();
    assertNull(previousBead47.getPage());
    assertNull(previousBead25.getPage());
    PDThreadBead previousBead48 = nextBead33.getPreviousBead();
    assertNull(previousBead48.getPage());
    PDThreadBead previousBead49 = nextBead36.getPreviousBead();
    assertNull(previousBead49.getPage());
    PDThreadBead previousBead50 = nextBead39.getPreviousBead();
    assertNull(previousBead50.getPage());
    assertNull(previousBead6.getPage());
    assertNull(previousBead13.getPage());
    assertNull(previousBead14.getPage());
    assertNull(previousBead26.getPage());
    PDThreadBead previousBead51 = nextBead41.getPreviousBead();
    assertNull(previousBead51.getPage());
    PDThreadBead previousBead52 = nextBead43.getPreviousBead();
    assertNull(previousBead52.getPage());
    PDThreadBead previousBead53 = nextBead45.getPreviousBead();
    assertNull(previousBead53.getPage());
    assertNull(previousBead27.getPage());
    PDThreadBead previousBead54 = nextBead47.getPreviousBead();
    assertNull(previousBead54.getPage());
    PDThreadBead previousBead55 = nextBead49.getPreviousBead();
    assertNull(previousBead55.getPage());
    PDThreadBead previousBead56 = nextBead51.getPreviousBead();
    assertNull(previousBead56.getPage());
    assertNull(previousBead15.getPage());
    assertNull(previousBead28.getPage());
    assertNull(previousBead29.getPage());
    PDThreadBead previousBead57 = nextBead53.getPreviousBead();
    assertNull(previousBead57.getPage());
    PDThreadBead previousBead58 = nextBead55.getPreviousBead();
    assertNull(previousBead58.getPage());
    assertNull(previousBead30.getPage());
    PDThreadBead previousBead59 = nextBead57.getPreviousBead();
    assertNull(previousBead59.getPage());
    PDThreadBead previousBead60 = nextBead59.getPreviousBead();
    assertNull(previousBead60.getPage());
    PDThreadBead previousBead61 = nextBead61.getPreviousBead();
    assertNull(previousBead61.getPage());
    assertNull(previousBead4.getPage());
    assertNull(previousBead7.getPage());
    assertNull(previousBead8.getPage());
    assertNull(previousBead16.getPage());
    assertNull(previousBead31.getPage());
    PDThreadBead previousBead62 = previousBead21.getPreviousBead();
    assertNull(previousBead62.getPage());
    PDThreadBead previousBead63 = previousBead22.getPreviousBead();
    assertNull(previousBead63.getPage());
    PDThreadBead previousBead64 = previousBead23.getPreviousBead();
    assertNull(previousBead64.getPage());
    assertNull(previousBead32.getPage());
    PDThreadBead previousBead65 = previousBead12.getPreviousBead();
    assertNull(previousBead65.getPage());
    PDThreadBead previousBead66 = previousBead24.getPreviousBead();
    assertNull(previousBead66.getPage());
    PDThreadBead previousBead67 = previousBead25.getPreviousBead();
    assertNull(previousBead67.getPage());
    assertNull(previousBead17.getPage());
    assertNull(previousBead33.getPage());
    assertNull(previousBead34.getPage());
    PDThreadBead previousBead68 = previousBead26.getPreviousBead();
    assertNull(previousBead68.getPage());
    PDThreadBead previousBead69 = previousBead27.getPreviousBead();
    assertNull(previousBead69.getPage());
    assertNull(previousBead35.getPage());
    PDThreadBead previousBead70 = previousBead28.getPreviousBead();
    assertNull(previousBead70.getPage());
    PDThreadBead previousBead71 = previousBead29.getPreviousBead();
    assertNull(previousBead71.getPage());
    PDThreadBead previousBead72 = previousBead30.getPreviousBead();
    assertNull(previousBead72.getPage());
    assertNull(previousBead9.getPage());
    assertNull(previousBead18.getPage());
    assertNull(previousBead19.getPage());
    assertNull(previousBead36.getPage());
    PDThreadBead previousBead73 = previousBead31.getPreviousBead();
    assertNull(previousBead73.getPage());
    PDThreadBead previousBead74 = previousBead32.getPreviousBead();
    assertNull(previousBead74.getPage());
    assertNull(previousBead37.getPage());
    PDThreadBead previousBead75 = previousBead33.getPreviousBead();
    assertNull(previousBead75.getPage());
    PDThreadBead previousBead76 = previousBead34.getPreviousBead();
    assertNull(previousBead76.getPage());
    PDThreadBead previousBead77 = previousBead35.getPreviousBead();
    assertNull(previousBead77.getPage());
    assertNull(previousBead20.getPage());
    assertNull(previousBead38.getPage());
    assertNull(previousBead39.getPage());
    PDThreadBead previousBead78 = previousBead36.getPreviousBead();
    assertNull(previousBead78.getPage());
    PDThreadBead previousBead79 = previousBead37.getPreviousBead();
    assertNull(previousBead79.getPage());
    assertNull(previousBead40.getPage());
    PDThreadBead previousBead80 = previousBead38.getPreviousBead();
    assertNull(previousBead80.getPage());
    PDThreadBead previousBead81 = previousBead39.getPreviousBead();
    assertNull(previousBead81.getPage());
    PDThreadBead previousBead82 = previousBead40.getPreviousBead();
    assertNull(previousBead82.getPage());
    assertNull(actualPdThreadBead.getRectangle());
    assertNull(nextBead.getRectangle());
    assertNull(nextBead2.getRectangle());
    assertNull(nextBead3.getRectangle());
    assertNull(nextBead4.getRectangle());
    assertNull(nextBead5.getRectangle());
    assertNull(nextBead6.getRectangle());
    assertNull(nextBead7.getRectangle());
    assertNull(nextBead12.getRectangle());
    assertNull(nextBead17.getRectangle());
    assertNull(nextBead11.getRectangle());
    assertNull(nextBead16.getRectangle());
    assertNull(nextBead21.getRectangle());
    assertNull(nextBead25.getRectangle());
    assertNull(nextBead10.getRectangle());
    assertNull(nextBead15.getRectangle());
    assertNull(nextBead20.getRectangle());
    assertNull(nextBead28.getRectangle());
    assertNull(nextBead31.getRectangle());
    assertNull(nextBead24.getRectangle());
    assertNull(nextBead34.getRectangle());
    assertNull(nextBead37.getRectangle());
    assertNull(nextBead40.getRectangle());
    assertNull(nextBead9.getRectangle());
    assertNull(nextBead14.getRectangle());
    assertNull(nextBead19.getRectangle());
    assertNull(nextBead27.getRectangle());
    assertNull(nextBead42.getRectangle());
    assertNull(nextBead44.getRectangle());
    assertNull(nextBead46.getRectangle());
    assertNull(nextBead30.getRectangle());
    assertNull(nextBead48.getRectangle());
    assertNull(nextBead50.getRectangle());
    assertNull(nextBead52.getRectangle());
    assertNull(nextBead23.getRectangle());
    assertNull(nextBead33.getRectangle());
    assertNull(nextBead36.getRectangle());
    assertNull(nextBead54.getRectangle());
    assertNull(nextBead56.getRectangle());
    assertNull(nextBead39.getRectangle());
    assertNull(nextBead58.getRectangle());
    assertNull(nextBead60.getRectangle());
    assertNull(nextBead62.getRectangle());
    assertNull(nextBead8.getRectangle());
    assertNull(nextBead13.getRectangle());
    assertNull(nextBead18.getRectangle());
    assertNull(nextBead26.getRectangle());
    assertNull(nextBead41.getRectangle());
    assertNull(nextBead63.getRectangle());
    assertNull(nextBead64.getRectangle());
    assertNull(nextBead65.getRectangle());
    assertNull(nextBead43.getRectangle());
    assertNull(nextBead45.getRectangle());
    assertNull(nextBead66.getRectangle());
    assertNull(nextBead67.getRectangle());
    assertNull(nextBead29.getRectangle());
    assertNull(nextBead47.getRectangle());
    assertNull(nextBead49.getRectangle());
    assertNull(nextBead68.getRectangle());
    assertNull(nextBead69.getRectangle());
    assertNull(nextBead51.getRectangle());
    assertNull(nextBead70.getRectangle());
    assertNull(nextBead71.getRectangle());
    assertNull(nextBead72.getRectangle());
    assertNull(nextBead22.getRectangle());
    assertNull(nextBead32.getRectangle());
    assertNull(nextBead35.getRectangle());
    assertNull(nextBead53.getRectangle());
    assertNull(nextBead73.getRectangle());
    assertNull(nextBead74.getRectangle());
    assertNull(nextBead55.getRectangle());
    assertNull(nextBead75.getRectangle());
    assertNull(nextBead76.getRectangle());
    assertNull(nextBead77.getRectangle());
    assertNull(nextBead38.getRectangle());
    assertNull(nextBead57.getRectangle());
    assertNull(nextBead59.getRectangle());
    assertNull(nextBead78.getRectangle());
    assertNull(nextBead79.getRectangle());
    assertNull(nextBead61.getRectangle());
    assertNull(nextBead80.getRectangle());
    assertNull(nextBead81.getRectangle());
    assertNull(nextBead82.getRectangle());
    assertNull(previousBead.getRectangle());
    assertNull(previousBead2.getRectangle());
    assertNull(previousBead3.getRectangle());
    assertNull(previousBead5.getRectangle());
    assertNull(previousBead10.getRectangle());
    assertNull(previousBead21.getRectangle());
    assertNull(previousBead41.getRectangle());
    assertNull(previousBead42.getRectangle());
    assertNull(previousBead43.getRectangle());
    assertNull(previousBead22.getRectangle());
    assertNull(previousBead23.getRectangle());
    assertNull(previousBead44.getRectangle());
    assertNull(previousBead45.getRectangle());
    assertNull(previousBead11.getRectangle());
    assertNull(previousBead12.getRectangle());
    assertNull(previousBead24.getRectangle());
    assertNull(previousBead46.getRectangle());
    assertNull(previousBead47.getRectangle());
    assertNull(previousBead25.getRectangle());
    assertNull(previousBead48.getRectangle());
    assertNull(previousBead49.getRectangle());
    assertNull(previousBead50.getRectangle());
    assertNull(previousBead6.getRectangle());
    assertNull(previousBead13.getRectangle());
    assertNull(previousBead14.getRectangle());
    assertNull(previousBead26.getRectangle());
    assertNull(previousBead51.getRectangle());
    assertNull(previousBead52.getRectangle());
    assertNull(previousBead27.getRectangle());
    assertNull(previousBead54.getRectangle());
    assertNull(previousBead55.getRectangle());
    assertNull(previousBead56.getRectangle());
    assertNull(previousBead15.getRectangle());
    assertNull(previousBead28.getRectangle());
    assertNull(previousBead29.getRectangle());
    assertNull(previousBead57.getRectangle());
    assertNull(previousBead58.getRectangle());
    assertNull(previousBead30.getRectangle());
    assertNull(previousBead59.getRectangle());
    assertNull(previousBead60.getRectangle());
    assertNull(previousBead61.getRectangle());
    assertNull(previousBead4.getRectangle());
    assertNull(previousBead7.getRectangle());
    assertNull(previousBead8.getRectangle());
    assertNull(previousBead16.getRectangle());
    assertNull(previousBead31.getRectangle());
    assertNull(previousBead62.getRectangle());
    assertNull(previousBead63.getRectangle());
    assertNull(previousBead64.getRectangle());
    assertNull(previousBead32.getRectangle());
    assertNull(previousBead65.getRectangle());
    assertNull(previousBead66.getRectangle());
    assertNull(previousBead67.getRectangle());
    assertNull(previousBead17.getRectangle());
    assertNull(previousBead33.getRectangle());
    assertNull(previousBead34.getRectangle());
    assertNull(previousBead68.getRectangle());
    assertNull(previousBead69.getRectangle());
    assertNull(previousBead35.getRectangle());
    assertNull(previousBead70.getRectangle());
    assertNull(previousBead71.getRectangle());
    assertNull(previousBead72.getRectangle());
    assertNull(previousBead9.getRectangle());
    assertNull(previousBead18.getRectangle());
    assertNull(previousBead19.getRectangle());
    assertNull(previousBead36.getRectangle());
    assertNull(previousBead73.getRectangle());
    assertNull(previousBead74.getRectangle());
    assertNull(previousBead37.getRectangle());
    assertNull(previousBead75.getRectangle());
    assertNull(previousBead76.getRectangle());
    assertNull(previousBead77.getRectangle());
    assertNull(previousBead20.getRectangle());
    assertNull(previousBead38.getRectangle());
    assertNull(previousBead39.getRectangle());
    assertNull(previousBead78.getRectangle());
    assertNull(previousBead79.getRectangle());
    assertNull(previousBead40.getRectangle());
    assertNull(previousBead80.getRectangle());
    assertNull(previousBead81.getRectangle());
    assertNull(previousBead82.getRectangle());
    assertNull(actualPdThreadBead.getThread());
    assertNull(nextBead.getThread());
    assertNull(nextBead2.getThread());
    assertNull(nextBead3.getThread());
    assertNull(nextBead4.getThread());
    assertNull(nextBead5.getThread());
    assertNull(nextBead6.getThread());
    assertNull(nextBead7.getThread());
    assertNull(nextBead12.getThread());
    assertNull(nextBead17.getThread());
    assertNull(nextBead11.getThread());
    assertNull(nextBead16.getThread());
    assertNull(nextBead21.getThread());
    assertNull(nextBead25.getThread());
    assertNull(nextBead10.getThread());
    assertNull(nextBead15.getThread());
    assertNull(nextBead20.getThread());
    assertNull(nextBead28.getThread());
    assertNull(nextBead31.getThread());
    assertNull(nextBead24.getThread());
    assertNull(nextBead34.getThread());
    assertNull(nextBead37.getThread());
    assertNull(nextBead40.getThread());
    assertNull(nextBead9.getThread());
    assertNull(nextBead14.getThread());
    assertNull(nextBead19.getThread());
    assertNull(nextBead27.getThread());
    assertNull(nextBead42.getThread());
    assertNull(nextBead44.getThread());
    assertNull(nextBead46.getThread());
    assertNull(nextBead30.getThread());
    assertNull(nextBead48.getThread());
    assertNull(nextBead50.getThread());
    assertNull(nextBead52.getThread());
    assertNull(nextBead23.getThread());
    assertNull(nextBead33.getThread());
    assertNull(nextBead36.getThread());
    assertNull(nextBead54.getThread());
    assertNull(nextBead56.getThread());
    assertNull(nextBead39.getThread());
    assertNull(nextBead58.getThread());
    assertNull(nextBead60.getThread());
    assertNull(nextBead62.getThread());
    assertNull(nextBead8.getThread());
    assertNull(nextBead13.getThread());
    assertNull(nextBead18.getThread());
    assertNull(nextBead26.getThread());
    assertNull(nextBead41.getThread());
    assertNull(nextBead63.getThread());
    assertNull(nextBead64.getThread());
    assertNull(nextBead65.getThread());
    assertNull(nextBead43.getThread());
    assertNull(nextBead45.getThread());
    assertNull(nextBead66.getThread());
    assertNull(nextBead67.getThread());
    assertNull(nextBead29.getThread());
    assertNull(nextBead47.getThread());
    assertNull(nextBead49.getThread());
    assertNull(nextBead68.getThread());
    assertNull(nextBead69.getThread());
    assertNull(nextBead51.getThread());
    assertNull(nextBead70.getThread());
    assertNull(nextBead71.getThread());
    assertNull(nextBead72.getThread());
    assertNull(nextBead22.getThread());
    assertNull(nextBead32.getThread());
    assertNull(nextBead35.getThread());
    assertNull(nextBead53.getThread());
    assertNull(nextBead73.getThread());
    assertNull(nextBead74.getThread());
    assertNull(nextBead55.getThread());
    assertNull(nextBead75.getThread());
    assertNull(nextBead76.getThread());
    assertNull(nextBead77.getThread());
    assertNull(nextBead38.getThread());
    assertNull(nextBead57.getThread());
    assertNull(nextBead59.getThread());
    assertNull(nextBead78.getThread());
    assertNull(nextBead79.getThread());
    assertNull(nextBead61.getThread());
    assertNull(nextBead80.getThread());
    assertNull(nextBead81.getThread());
    assertNull(nextBead82.getThread());
    assertNull(previousBead.getThread());
    assertNull(previousBead2.getThread());
    assertNull(previousBead3.getThread());
    assertNull(previousBead5.getThread());
    assertNull(previousBead10.getThread());
    assertNull(previousBead21.getThread());
    assertNull(previousBead41.getThread());
    assertNull(previousBead42.getThread());
    assertNull(previousBead43.getThread());
    assertNull(previousBead22.getThread());
    assertNull(previousBead23.getThread());
    assertNull(previousBead44.getThread());
    assertNull(previousBead45.getThread());
    assertNull(previousBead11.getThread());
    assertNull(previousBead12.getThread());
    assertNull(previousBead24.getThread());
    assertNull(previousBead46.getThread());
    assertNull(previousBead47.getThread());
    assertNull(previousBead25.getThread());
    assertNull(previousBead48.getThread());
    assertNull(previousBead49.getThread());
    assertNull(previousBead50.getThread());
    assertNull(previousBead6.getThread());
    assertNull(previousBead13.getThread());
    assertNull(previousBead14.getThread());
    assertNull(previousBead26.getThread());
    assertNull(previousBead51.getThread());
    assertNull(previousBead52.getThread());
    assertNull(previousBead27.getThread());
    assertNull(previousBead54.getThread());
    assertNull(previousBead55.getThread());
    assertNull(previousBead56.getThread());
    assertNull(previousBead15.getThread());
    assertNull(previousBead28.getThread());
    assertNull(previousBead29.getThread());
    assertNull(previousBead57.getThread());
    assertNull(previousBead58.getThread());
    assertNull(previousBead30.getThread());
    assertNull(previousBead59.getThread());
    assertNull(previousBead60.getThread());
    assertNull(previousBead61.getThread());
    assertNull(previousBead4.getThread());
    assertNull(previousBead7.getThread());
    assertNull(previousBead8.getThread());
    assertNull(previousBead16.getThread());
    assertNull(previousBead31.getThread());
    assertNull(previousBead62.getThread());
    assertNull(previousBead63.getThread());
    assertNull(previousBead64.getThread());
    assertNull(previousBead32.getThread());
    assertNull(previousBead65.getThread());
    assertNull(previousBead66.getThread());
    assertNull(previousBead67.getThread());
    assertNull(previousBead17.getThread());
    assertNull(previousBead33.getThread());
    assertNull(previousBead34.getThread());
    assertNull(previousBead68.getThread());
    assertNull(previousBead69.getThread());
    assertNull(previousBead35.getThread());
    assertNull(previousBead70.getThread());
    assertNull(previousBead71.getThread());
    assertNull(previousBead72.getThread());
    assertNull(previousBead9.getThread());
    assertNull(previousBead18.getThread());
    assertNull(previousBead19.getThread());
    assertNull(previousBead36.getThread());
    assertNull(previousBead73.getThread());
    assertNull(previousBead74.getThread());
    assertNull(previousBead37.getThread());
    assertNull(previousBead75.getThread());
    assertNull(previousBead76.getThread());
    assertNull(previousBead77.getThread());
    assertNull(previousBead20.getThread());
    assertNull(previousBead38.getThread());
    assertNull(previousBead39.getThread());
    assertNull(previousBead78.getThread());
    assertNull(previousBead79.getThread());
    assertNull(previousBead40.getThread());
    assertNull(previousBead80.getThread());
    assertNull(previousBead81.getThread());
    assertNull(previousBead82.getThread());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertSame(cOSObject, nextBead.getCOSObject());
    assertSame(cOSObject, nextBead2.getCOSObject());
    assertSame(cOSObject, nextBead3.getCOSObject());
    assertSame(cOSObject, nextBead4.getCOSObject());
    assertSame(cOSObject, nextBead5.getCOSObject());
    assertSame(cOSObject, nextBead6.getCOSObject());
    assertSame(cOSObject, nextBead7.getCOSObject());
    assertSame(cOSObject, nextBead12.getCOSObject());
    assertSame(cOSObject, nextBead17.getCOSObject());
    assertSame(cOSObject, nextBead11.getCOSObject());
    assertSame(cOSObject, nextBead16.getCOSObject());
    assertSame(cOSObject, nextBead21.getCOSObject());
    assertSame(cOSObject, nextBead25.getCOSObject());
    assertSame(cOSObject, nextBead10.getCOSObject());
    assertSame(cOSObject, nextBead15.getCOSObject());
    assertSame(cOSObject, nextBead20.getCOSObject());
    assertSame(cOSObject, nextBead28.getCOSObject());
    assertSame(cOSObject, nextBead31.getCOSObject());
    assertSame(cOSObject, nextBead24.getCOSObject());
    assertSame(cOSObject, nextBead34.getCOSObject());
    assertSame(cOSObject, nextBead37.getCOSObject());
    assertSame(cOSObject, nextBead40.getCOSObject());
    assertSame(cOSObject, nextBead9.getCOSObject());
    assertSame(cOSObject, nextBead14.getCOSObject());
    assertSame(cOSObject, nextBead19.getCOSObject());
    assertSame(cOSObject, nextBead27.getCOSObject());
    assertSame(cOSObject, nextBead42.getCOSObject());
    assertSame(cOSObject, nextBead44.getCOSObject());
    assertSame(cOSObject, nextBead46.getCOSObject());
    assertSame(cOSObject, nextBead30.getCOSObject());
    assertSame(cOSObject, nextBead48.getCOSObject());
    assertSame(cOSObject, nextBead50.getCOSObject());
    assertSame(cOSObject, nextBead52.getCOSObject());
    assertSame(cOSObject, nextBead23.getCOSObject());
    assertSame(cOSObject, nextBead33.getCOSObject());
    assertSame(cOSObject, nextBead36.getCOSObject());
    assertSame(cOSObject, nextBead54.getCOSObject());
    assertSame(cOSObject, nextBead56.getCOSObject());
    assertSame(cOSObject, nextBead39.getCOSObject());
    assertSame(cOSObject, nextBead58.getCOSObject());
    assertSame(cOSObject, nextBead60.getCOSObject());
    assertSame(cOSObject, nextBead62.getCOSObject());
    assertSame(cOSObject, nextBead8.getCOSObject());
    assertSame(cOSObject, nextBead13.getCOSObject());
    assertSame(cOSObject, nextBead18.getCOSObject());
    assertSame(cOSObject, nextBead26.getCOSObject());
    assertSame(cOSObject, nextBead41.getCOSObject());
    assertSame(cOSObject, nextBead63.getCOSObject());
    assertSame(cOSObject, nextBead64.getCOSObject());
    assertSame(cOSObject, nextBead65.getCOSObject());
    assertSame(cOSObject, nextBead43.getCOSObject());
    assertSame(cOSObject, nextBead45.getCOSObject());
    assertSame(cOSObject, nextBead66.getCOSObject());
    assertSame(cOSObject, nextBead67.getCOSObject());
    assertSame(cOSObject, nextBead29.getCOSObject());
    assertSame(cOSObject, nextBead47.getCOSObject());
    assertSame(cOSObject, nextBead49.getCOSObject());
    assertSame(cOSObject, nextBead68.getCOSObject());
    assertSame(cOSObject, nextBead69.getCOSObject());
    assertSame(cOSObject, nextBead51.getCOSObject());
    assertSame(cOSObject, nextBead70.getCOSObject());
    assertSame(cOSObject, nextBead71.getCOSObject());
    assertSame(cOSObject, nextBead72.getCOSObject());
    assertSame(cOSObject, nextBead22.getCOSObject());
    assertSame(cOSObject, nextBead32.getCOSObject());
    assertSame(cOSObject, nextBead35.getCOSObject());
    assertSame(cOSObject, nextBead53.getCOSObject());
    assertSame(cOSObject, nextBead73.getCOSObject());
    assertSame(cOSObject, nextBead74.getCOSObject());
    assertSame(cOSObject, nextBead55.getCOSObject());
    assertSame(cOSObject, nextBead75.getCOSObject());
    assertSame(cOSObject, nextBead76.getCOSObject());
    assertSame(cOSObject, nextBead77.getCOSObject());
    assertSame(cOSObject, nextBead38.getCOSObject());
    assertSame(cOSObject, nextBead57.getCOSObject());
    assertSame(cOSObject, nextBead59.getCOSObject());
    assertSame(cOSObject, nextBead78.getCOSObject());
    assertSame(cOSObject, nextBead79.getCOSObject());
    assertSame(cOSObject, nextBead61.getCOSObject());
    assertSame(cOSObject, nextBead80.getCOSObject());
    assertSame(cOSObject, nextBead81.getCOSObject());
    assertSame(cOSObject, nextBead82.getCOSObject());
    assertSame(cOSObject, previousBead.getCOSObject());
    assertSame(cOSObject, previousBead2.getCOSObject());
    assertSame(cOSObject, previousBead3.getCOSObject());
    assertSame(cOSObject, previousBead5.getCOSObject());
    assertSame(cOSObject, previousBead10.getCOSObject());
    assertSame(cOSObject, previousBead21.getCOSObject());
    assertSame(cOSObject, previousBead41.getCOSObject());
    assertSame(cOSObject, previousBead42.getCOSObject());
    assertSame(cOSObject, previousBead43.getCOSObject());
    assertSame(cOSObject, previousBead22.getCOSObject());
    assertSame(cOSObject, previousBead23.getCOSObject());
    assertSame(cOSObject, previousBead44.getCOSObject());
    assertSame(cOSObject, previousBead45.getCOSObject());
    assertSame(cOSObject, previousBead11.getCOSObject());
    assertSame(cOSObject, previousBead12.getCOSObject());
    assertSame(cOSObject, previousBead24.getCOSObject());
    assertSame(cOSObject, previousBead46.getCOSObject());
    assertSame(cOSObject, previousBead47.getCOSObject());
    assertSame(cOSObject, previousBead25.getCOSObject());
    assertSame(cOSObject, previousBead48.getCOSObject());
    assertSame(cOSObject, previousBead49.getCOSObject());
    assertSame(cOSObject, previousBead50.getCOSObject());
    assertSame(cOSObject, previousBead6.getCOSObject());
    assertSame(cOSObject, previousBead13.getCOSObject());
    assertSame(cOSObject, previousBead14.getCOSObject());
    assertSame(cOSObject, previousBead26.getCOSObject());
    assertSame(cOSObject, previousBead51.getCOSObject());
    assertSame(cOSObject, previousBead52.getCOSObject());
    assertSame(cOSObject, previousBead53.getCOSObject());
    assertSame(cOSObject, previousBead27.getCOSObject());
    assertSame(cOSObject, previousBead54.getCOSObject());
    assertSame(cOSObject, previousBead55.getCOSObject());
    assertSame(cOSObject, previousBead56.getCOSObject());
    assertSame(cOSObject, previousBead15.getCOSObject());
    assertSame(cOSObject, previousBead28.getCOSObject());
    assertSame(cOSObject, previousBead29.getCOSObject());
    assertSame(cOSObject, previousBead57.getCOSObject());
    assertSame(cOSObject, previousBead58.getCOSObject());
    assertSame(cOSObject, previousBead30.getCOSObject());
    assertSame(cOSObject, previousBead59.getCOSObject());
    assertSame(cOSObject, previousBead60.getCOSObject());
    assertSame(cOSObject, previousBead61.getCOSObject());
    assertSame(cOSObject, previousBead4.getCOSObject());
    assertSame(cOSObject, previousBead7.getCOSObject());
    assertSame(cOSObject, previousBead8.getCOSObject());
    assertSame(cOSObject, previousBead16.getCOSObject());
    assertSame(cOSObject, previousBead31.getCOSObject());
    assertSame(cOSObject, previousBead62.getCOSObject());
    assertSame(cOSObject, previousBead63.getCOSObject());
    assertSame(cOSObject, previousBead64.getCOSObject());
    assertSame(cOSObject, previousBead32.getCOSObject());
    assertSame(cOSObject, previousBead65.getCOSObject());
    assertSame(cOSObject, previousBead66.getCOSObject());
    assertSame(cOSObject, previousBead67.getCOSObject());
    assertSame(cOSObject, previousBead17.getCOSObject());
    assertSame(cOSObject, previousBead33.getCOSObject());
    assertSame(cOSObject, previousBead34.getCOSObject());
    assertSame(cOSObject, previousBead68.getCOSObject());
    assertSame(cOSObject, previousBead69.getCOSObject());
    assertSame(cOSObject, previousBead35.getCOSObject());
    assertSame(cOSObject, previousBead70.getCOSObject());
    assertSame(cOSObject, previousBead71.getCOSObject());
    assertSame(cOSObject, previousBead72.getCOSObject());
    assertSame(cOSObject, previousBead9.getCOSObject());
    assertSame(cOSObject, previousBead18.getCOSObject());
    assertSame(cOSObject, previousBead19.getCOSObject());
    assertSame(cOSObject, previousBead36.getCOSObject());
    assertSame(cOSObject, previousBead73.getCOSObject());
    assertSame(cOSObject, previousBead74.getCOSObject());
    assertSame(cOSObject, previousBead37.getCOSObject());
    assertSame(cOSObject, previousBead75.getCOSObject());
    assertSame(cOSObject, previousBead76.getCOSObject());
    assertSame(cOSObject, previousBead77.getCOSObject());
    assertSame(cOSObject, previousBead20.getCOSObject());
    assertSame(cOSObject, previousBead38.getCOSObject());
    assertSame(cOSObject, previousBead39.getCOSObject());
    assertSame(cOSObject, previousBead78.getCOSObject());
    assertSame(cOSObject, previousBead79.getCOSObject());
    assertSame(cOSObject, previousBead40.getCOSObject());
    assertSame(cOSObject, previousBead80.getCOSObject());
    assertSame(cOSObject, previousBead81.getCOSObject());
    assertSame(cOSObject, previousBead82.getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#getCOSObject()}.
   * <p>
   * Method under test: {@link PDThreadBead#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDThreadBead()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(3, actualCOSObject.getValues().size());
    assertEquals(3, actualCOSObject.size());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
  }

  /**
   * Test {@link PDThreadBead#getThread()}.
   * <ul>
   *   <li>Given {@link PDThreadBead#PDThreadBead(COSDictionary)} with b is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getThread()}
   */
  @Test
  @DisplayName("Test getThread(); given PDThreadBead(COSDictionary) with b is COSDictionary(); then return 'null'")
  void testGetThread_givenPDThreadBeadWithBIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDThreadBead(new COSDictionary())).getThread());
  }

  /**
   * Test {@link PDThreadBead#getThread()}.
   * <ul>
   *   <li>Given {@link PDThreadBead#PDThreadBead()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getThread()}
   */
  @Test
  @DisplayName("Test getThread(); given PDThreadBead(); then return 'null'")
  void testGetThread_givenPDThreadBead_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDThreadBead()).getThread());
  }

  /**
   * Test {@link PDThreadBead#getThread()}.
   * <ul>
   *   <li>Then return COSObject UpdateState OriginDocumentState is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getThread()}
   */
  @Test
  @DisplayName("Test getThread(); then return COSObject UpdateState OriginDocumentState is 'null'")
  void testGetThread_thenReturnCOSObjectUpdateStateOriginDocumentStateIsNull() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();
    pdThreadBead.setThread(new PDThread());

    // Act
    PDThread actualThread = pdThreadBead.getThread();

    // Assert
    COSDictionary cOSObject = actualThread.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualThread.getThreadInfo());
    assertNull(actualThread.getFirstBead());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDThreadBead#setThread(PDThread)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#setThread(PDThread)}
   */
  @Test
  @DisplayName("Test setThread(PDThread); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetThread_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();

    COSDictionary t = new COSDictionary();
    t.setKey(new COSObjectKey(1L, 1));

    // Act
    pdThreadBead.setThread(new PDThread(t));

    // Assert
    assertSame(t, pdThreadBead.getThread().getCOSObject());
    PDThreadBead nextBead = pdThreadBead.getNextBead();
    assertSame(t, nextBead.getThread().getCOSObject());
    PDThreadBead nextBead2 = nextBead.getNextBead();
    assertSame(t, nextBead2.getThread().getCOSObject());
    PDThreadBead nextBead3 = nextBead2.getNextBead();
    assertSame(t, nextBead3.getThread().getCOSObject());
    PDThreadBead nextBead4 = nextBead3.getNextBead();
    assertSame(t, nextBead4.getThread().getCOSObject());
    PDThreadBead nextBead5 = nextBead4.getNextBead();
    assertSame(t, nextBead5.getThread().getCOSObject());
    assertSame(t, nextBead5.getNextBead().getThread().getCOSObject());
    PDThreadBead previousBead = pdThreadBead.getPreviousBead();
    PDThreadBead nextBead6 = previousBead.getNextBead();
    PDThreadBead nextBead7 = nextBead6.getNextBead();
    PDThreadBead nextBead8 = nextBead7.getNextBead();
    assertSame(t, nextBead8.getNextBead().getThread().getCOSObject());
    assertSame(t, nextBead8.getThread().getCOSObject());
    PDThreadBead previousBead2 = nextBead.getPreviousBead();
    PDThreadBead nextBead9 = previousBead2.getNextBead();
    PDThreadBead nextBead10 = nextBead9.getNextBead();
    assertSame(t, nextBead10.getNextBead().getThread().getCOSObject());
    PDThreadBead previousBead3 = previousBead.getPreviousBead();
    PDThreadBead nextBead11 = previousBead3.getNextBead();
    PDThreadBead nextBead12 = nextBead11.getNextBead();
    assertSame(t, nextBead12.getNextBead().getThread().getCOSObject());
    assertSame(t, nextBead7.getThread().getCOSObject());
    assertSame(t, nextBead10.getThread().getCOSObject());
    PDThreadBead previousBead4 = nextBead2.getPreviousBead();
    PDThreadBead nextBead13 = previousBead4.getNextBead();
    assertSame(t, nextBead13.getNextBead().getThread().getCOSObject());
    PDThreadBead previousBead5 = nextBead6.getPreviousBead();
    PDThreadBead nextBead14 = previousBead5.getNextBead();
    assertSame(t, nextBead14.getNextBead().getThread().getCOSObject());
    assertSame(t, nextBead12.getThread().getCOSObject());
    PDThreadBead previousBead6 = previousBead2.getPreviousBead();
    PDThreadBead nextBead15 = previousBead6.getNextBead();
    assertSame(t, nextBead15.getNextBead().getThread().getCOSObject());
    PDThreadBead previousBead7 = previousBead3.getPreviousBead();
    PDThreadBead nextBead16 = previousBead7.getNextBead();
    assertSame(t, nextBead16.getNextBead().getThread().getCOSObject());
    assertSame(t, nextBead6.getThread().getCOSObject());
    assertSame(t, nextBead9.getThread().getCOSObject());
    assertSame(t, nextBead13.getThread().getCOSObject());
    PDThreadBead previousBead8 = nextBead3.getPreviousBead();
    assertSame(t, previousBead8.getNextBead().getThread().getCOSObject());
    PDThreadBead previousBead9 = nextBead7.getPreviousBead();
    assertSame(t, previousBead9.getNextBead().getThread().getCOSObject());
    assertSame(t, nextBead14.getThread().getCOSObject());
    PDThreadBead previousBead10 = nextBead9.getPreviousBead();
    assertSame(t, previousBead10.getNextBead().getThread().getCOSObject());
    PDThreadBead previousBead11 = nextBead11.getPreviousBead();
    assertSame(t, previousBead11.getNextBead().getThread().getCOSObject());
    assertSame(t, nextBead11.getThread().getCOSObject());
    assertSame(t, nextBead15.getThread().getCOSObject());
    PDThreadBead previousBead12 = previousBead4.getPreviousBead();
    assertSame(t, previousBead12.getNextBead().getThread().getCOSObject());
    PDThreadBead previousBead13 = previousBead5.getPreviousBead();
    assertSame(t, previousBead13.getNextBead().getThread().getCOSObject());
    assertSame(t, nextBead16.getThread().getCOSObject());
    PDThreadBead previousBead14 = previousBead6.getPreviousBead();
    assertSame(t, previousBead14.getNextBead().getThread().getCOSObject());
    PDThreadBead previousBead15 = previousBead7.getPreviousBead();
    assertSame(t, previousBead15.getNextBead().getThread().getCOSObject());
    assertSame(t, previousBead.getThread().getCOSObject());
    assertSame(t, previousBead2.getThread().getCOSObject());
    assertSame(t, previousBead4.getThread().getCOSObject());
    assertSame(t, previousBead8.getThread().getCOSObject());
    assertSame(t, nextBead4.getPreviousBead().getThread().getCOSObject());
    assertSame(t, nextBead8.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead9.getThread().getCOSObject());
    assertSame(t, nextBead10.getPreviousBead().getThread().getCOSObject());
    assertSame(t, nextBead12.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead5.getThread().getCOSObject());
    assertSame(t, previousBead10.getThread().getCOSObject());
    assertSame(t, nextBead13.getPreviousBead().getThread().getCOSObject());
    assertSame(t, nextBead14.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead11.getThread().getCOSObject());
    assertSame(t, nextBead15.getPreviousBead().getThread().getCOSObject());
    assertSame(t, nextBead16.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead3.getThread().getCOSObject());
    assertSame(t, previousBead6.getThread().getCOSObject());
    assertSame(t, previousBead12.getThread().getCOSObject());
    assertSame(t, previousBead8.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead9.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead13.getThread().getCOSObject());
    assertSame(t, previousBead10.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead11.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead7.getThread().getCOSObject());
    assertSame(t, previousBead14.getThread().getCOSObject());
    assertSame(t, previousBead12.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead13.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead15.getThread().getCOSObject());
    assertSame(t, previousBead14.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead15.getPreviousBead().getThread().getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#setThread(PDThread)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#setThread(PDThread)}
   */
  @Test
  @DisplayName("Test setThread(PDThread); given 'true'; when COSDictionary() Direct is 'true'")
  void testSetThread_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();

    COSDictionary t = new COSDictionary();
    t.setDirect(true);

    // Act
    pdThreadBead.setThread(new PDThread(t));

    // Assert
    assertSame(t, pdThreadBead.getThread().getCOSObject());
    PDThreadBead nextBead = pdThreadBead.getNextBead();
    assertSame(t, nextBead.getThread().getCOSObject());
    PDThreadBead nextBead2 = nextBead.getNextBead();
    assertSame(t, nextBead2.getThread().getCOSObject());
    PDThreadBead nextBead3 = nextBead2.getNextBead();
    assertSame(t, nextBead3.getThread().getCOSObject());
    PDThreadBead nextBead4 = nextBead3.getNextBead();
    assertSame(t, nextBead4.getThread().getCOSObject());
    PDThreadBead nextBead5 = nextBead4.getNextBead();
    assertSame(t, nextBead5.getThread().getCOSObject());
    assertSame(t, nextBead5.getNextBead().getThread().getCOSObject());
    PDThreadBead previousBead = pdThreadBead.getPreviousBead();
    PDThreadBead nextBead6 = previousBead.getNextBead();
    PDThreadBead nextBead7 = nextBead6.getNextBead();
    PDThreadBead nextBead8 = nextBead7.getNextBead();
    assertSame(t, nextBead8.getNextBead().getThread().getCOSObject());
    assertSame(t, nextBead8.getThread().getCOSObject());
    PDThreadBead previousBead2 = nextBead.getPreviousBead();
    PDThreadBead nextBead9 = previousBead2.getNextBead();
    PDThreadBead nextBead10 = nextBead9.getNextBead();
    assertSame(t, nextBead10.getNextBead().getThread().getCOSObject());
    PDThreadBead previousBead3 = previousBead.getPreviousBead();
    PDThreadBead nextBead11 = previousBead3.getNextBead();
    PDThreadBead nextBead12 = nextBead11.getNextBead();
    assertSame(t, nextBead12.getNextBead().getThread().getCOSObject());
    assertSame(t, nextBead7.getThread().getCOSObject());
    assertSame(t, nextBead10.getThread().getCOSObject());
    PDThreadBead previousBead4 = nextBead2.getPreviousBead();
    PDThreadBead nextBead13 = previousBead4.getNextBead();
    assertSame(t, nextBead13.getNextBead().getThread().getCOSObject());
    PDThreadBead previousBead5 = nextBead6.getPreviousBead();
    PDThreadBead nextBead14 = previousBead5.getNextBead();
    assertSame(t, nextBead14.getNextBead().getThread().getCOSObject());
    assertSame(t, nextBead12.getThread().getCOSObject());
    PDThreadBead previousBead6 = previousBead2.getPreviousBead();
    PDThreadBead nextBead15 = previousBead6.getNextBead();
    assertSame(t, nextBead15.getNextBead().getThread().getCOSObject());
    PDThreadBead previousBead7 = previousBead3.getPreviousBead();
    PDThreadBead nextBead16 = previousBead7.getNextBead();
    assertSame(t, nextBead16.getNextBead().getThread().getCOSObject());
    assertSame(t, nextBead6.getThread().getCOSObject());
    assertSame(t, nextBead9.getThread().getCOSObject());
    assertSame(t, nextBead13.getThread().getCOSObject());
    PDThreadBead previousBead8 = nextBead3.getPreviousBead();
    assertSame(t, previousBead8.getNextBead().getThread().getCOSObject());
    PDThreadBead previousBead9 = nextBead7.getPreviousBead();
    assertSame(t, previousBead9.getNextBead().getThread().getCOSObject());
    assertSame(t, nextBead14.getThread().getCOSObject());
    PDThreadBead previousBead10 = nextBead9.getPreviousBead();
    assertSame(t, previousBead10.getNextBead().getThread().getCOSObject());
    PDThreadBead previousBead11 = nextBead11.getPreviousBead();
    assertSame(t, previousBead11.getNextBead().getThread().getCOSObject());
    assertSame(t, nextBead11.getThread().getCOSObject());
    assertSame(t, nextBead15.getThread().getCOSObject());
    PDThreadBead previousBead12 = previousBead4.getPreviousBead();
    assertSame(t, previousBead12.getNextBead().getThread().getCOSObject());
    PDThreadBead previousBead13 = previousBead5.getPreviousBead();
    assertSame(t, previousBead13.getNextBead().getThread().getCOSObject());
    assertSame(t, nextBead16.getThread().getCOSObject());
    PDThreadBead previousBead14 = previousBead6.getPreviousBead();
    assertSame(t, previousBead14.getNextBead().getThread().getCOSObject());
    PDThreadBead previousBead15 = previousBead7.getPreviousBead();
    assertSame(t, previousBead15.getNextBead().getThread().getCOSObject());
    assertSame(t, previousBead.getThread().getCOSObject());
    assertSame(t, previousBead2.getThread().getCOSObject());
    assertSame(t, previousBead4.getThread().getCOSObject());
    assertSame(t, previousBead8.getThread().getCOSObject());
    assertSame(t, nextBead4.getPreviousBead().getThread().getCOSObject());
    assertSame(t, nextBead8.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead9.getThread().getCOSObject());
    assertSame(t, nextBead10.getPreviousBead().getThread().getCOSObject());
    assertSame(t, nextBead12.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead5.getThread().getCOSObject());
    assertSame(t, previousBead10.getThread().getCOSObject());
    assertSame(t, nextBead13.getPreviousBead().getThread().getCOSObject());
    assertSame(t, nextBead14.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead11.getThread().getCOSObject());
    assertSame(t, nextBead15.getPreviousBead().getThread().getCOSObject());
    assertSame(t, nextBead16.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead3.getThread().getCOSObject());
    assertSame(t, previousBead6.getThread().getCOSObject());
    assertSame(t, previousBead12.getThread().getCOSObject());
    assertSame(t, previousBead8.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead9.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead13.getThread().getCOSObject());
    assertSame(t, previousBead10.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead11.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead7.getThread().getCOSObject());
    assertSame(t, previousBead14.getThread().getCOSObject());
    assertSame(t, previousBead12.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead13.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead15.getThread().getCOSObject());
    assertSame(t, previousBead14.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead15.getPreviousBead().getThread().getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#getNextBead()}.
   * <ul>
   *   <li>Given {@link PDThreadBead#PDThreadBead(COSDictionary)} with b is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return COSObject is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getNextBead()}
   */
  @Test
  @DisplayName("Test getNextBead(); given PDThreadBead(COSDictionary) with b is COSDictionary(); then return COSObject is 'null'")
  void testGetNextBead_givenPDThreadBeadWithBIsCOSDictionary_thenReturnCOSObjectIsNull() {
    // Arrange, Act and Assert
    assertNull((new PDThreadBead(new COSDictionary())).getNextBead().getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#getNextBead()}.
   * <ul>
   *   <li>Then return COSObject UpdateState OriginDocumentState is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getNextBead()}
   */
  @Test
  @DisplayName("Test getNextBead(); then return COSObject UpdateState OriginDocumentState is 'null'")
  void testGetNextBead_thenReturnCOSObjectUpdateStateOriginDocumentStateIsNull() {
    // Arrange and Act
    PDThreadBead actualNextBead = (new PDThreadBead()).getNextBead();

    // Assert
    COSDictionary cOSObject = actualNextBead.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualNextBead.getPage());
    PDThreadBead previousBead = actualNextBead.getPreviousBead();
    assertNull(previousBead.getPage());
    PDThreadBead previousBead2 = previousBead.getPreviousBead();
    assertNull(previousBead2.getPage());
    PDThreadBead previousBead3 = previousBead2.getPreviousBead();
    assertNull(previousBead3.getPage());
    PDThreadBead previousBead4 = previousBead3.getPreviousBead();
    assertNull(previousBead4.getPage());
    PDThreadBead previousBead5 = previousBead4.getPreviousBead();
    assertNull(previousBead5.getPage());
    PDThreadBead previousBead6 = previousBead5.getPreviousBead();
    assertNull(previousBead6.getPage());
    PDThreadBead previousBead7 = previousBead6.getPreviousBead();
    assertNull(previousBead7.getPage());
    PDThreadBead previousBead8 = previousBead7.getPreviousBead();
    assertNull(previousBead8.getPage());
    assertNull(actualNextBead.getRectangle());
    assertNull(previousBead.getRectangle());
    assertNull(previousBead2.getRectangle());
    assertNull(previousBead3.getRectangle());
    assertNull(previousBead4.getRectangle());
    assertNull(previousBead5.getRectangle());
    assertNull(previousBead6.getRectangle());
    assertNull(previousBead7.getRectangle());
    assertNull(previousBead8.getRectangle());
    assertNull(actualNextBead.getThread());
    assertNull(previousBead.getThread());
    assertNull(previousBead2.getThread());
    assertNull(previousBead3.getThread());
    assertNull(previousBead4.getThread());
    assertNull(previousBead5.getThread());
    assertNull(previousBead6.getThread());
    assertNull(previousBead7.getThread());
    assertNull(previousBead8.getThread());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertSame(cOSObject, previousBead.getCOSObject());
    assertSame(cOSObject, previousBead2.getCOSObject());
    assertSame(cOSObject, previousBead3.getCOSObject());
    assertSame(cOSObject, previousBead4.getCOSObject());
    assertSame(cOSObject, previousBead5.getCOSObject());
    assertSame(cOSObject, previousBead6.getCOSObject());
    assertSame(cOSObject, previousBead7.getCOSObject());
    assertSame(cOSObject, previousBead8.getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#setNextBead(PDThreadBead)}.
   * <ul>
   *   <li>Given {@link PDThreadBead#PDThreadBead()}.</li>
   *   <li>Then {@link PDThreadBead#PDThreadBead()} COSObject Values size is
   * three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#setNextBead(PDThreadBead)}
   */
  @Test
  @DisplayName("Test setNextBead(PDThreadBead); given PDThreadBead(); then PDThreadBead() COSObject Values size is three")
  void testSetNextBead_givenPDThreadBead_thenPDThreadBeadCOSObjectValuesSizeIsThree() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();
    PDThreadBead next = new PDThreadBead();

    // Act
    pdThreadBead.setNextBead(next);

    // Assert
    COSDictionary cOSObject = next.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(cOSObject, next.getNextBead().getCOSObject());
    PDThreadBead previousBead = next.getPreviousBead();
    assertSame(cOSObject, previousBead.getNextBead().getCOSObject());
    PDThreadBead previousBead2 = previousBead.getPreviousBead();
    assertSame(cOSObject, previousBead2.getNextBead().getCOSObject());
    PDThreadBead previousBead3 = previousBead2.getPreviousBead();
    assertSame(cOSObject, previousBead3.getNextBead().getCOSObject());
    PDThreadBead previousBead4 = previousBead3.getPreviousBead();
    assertSame(cOSObject, previousBead4.getNextBead().getCOSObject());
    assertSame(cOSObject, previousBead4.getPreviousBead().getNextBead().getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#setNextBead(PDThreadBead)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDThreadBead#PDThreadBead()} NextBead COSObject is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#setNextBead(PDThreadBead)}
   */
  @Test
  @DisplayName("Test setNextBead(PDThreadBead); when 'null'; then PDThreadBead() NextBead COSObject is 'null'")
  void testSetNextBead_whenNull_thenPDThreadBeadNextBeadCOSObjectIsNull() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();

    // Act
    pdThreadBead.setNextBead(null);

    // Assert
    assertNull(pdThreadBead.getNextBead().getCOSObject());
    PDThreadBead previousBead = pdThreadBead.getPreviousBead();
    assertNull(previousBead.getNextBead().getCOSObject());
    PDThreadBead previousBead2 = previousBead.getPreviousBead();
    assertNull(previousBead2.getNextBead().getCOSObject());
    PDThreadBead previousBead3 = previousBead2.getPreviousBead();
    assertNull(previousBead3.getNextBead().getCOSObject());
    PDThreadBead previousBead4 = previousBead3.getPreviousBead();
    assertNull(previousBead4.getNextBead().getCOSObject());
    PDThreadBead previousBead5 = previousBead4.getPreviousBead();
    assertNull(previousBead5.getNextBead().getCOSObject());
    PDThreadBead previousBead6 = previousBead5.getPreviousBead();
    assertNull(previousBead6.getNextBead().getCOSObject());
    PDThreadBead previousBead7 = previousBead6.getPreviousBead();
    assertNull(previousBead7.getNextBead().getCOSObject());
    assertNull(previousBead7.getPage());
    PDThreadBead previousBead8 = previousBead7.getPreviousBead();
    assertNull(previousBead8.getPage());
    assertNull(previousBead7.getRectangle());
    assertNull(previousBead8.getRectangle());
    assertNull(previousBead7.getThread());
    assertNull(previousBead8.getThread());
    COSDictionary cOSObject = pdThreadBead.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(cOSObject, previousBead7.getCOSObject());
    assertSame(cOSObject, previousBead8.getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#getPreviousBead()}.
   * <ul>
   *   <li>Then return COSObject is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getPreviousBead()}
   */
  @Test
  @DisplayName("Test getPreviousBead(); then return COSObject is 'null'")
  void testGetPreviousBead_thenReturnCOSObjectIsNull() {
    // Arrange, Act and Assert
    assertNull((new PDThreadBead(new COSDictionary())).getPreviousBead().getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#getPreviousBead()}.
   * <ul>
   *   <li>Then return COSObject UpdateState OriginDocumentState is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getPreviousBead()}
   */
  @Test
  @DisplayName("Test getPreviousBead(); then return COSObject UpdateState OriginDocumentState is 'null'")
  void testGetPreviousBead_thenReturnCOSObjectUpdateStateOriginDocumentStateIsNull() {
    // Arrange and Act
    PDThreadBead actualPreviousBead = (new PDThreadBead()).getPreviousBead();

    // Assert
    COSDictionary cOSObject = actualPreviousBead.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    PDThreadBead nextBead = actualPreviousBead.getNextBead();
    PDThreadBead nextBead2 = nextBead.getNextBead();
    PDThreadBead nextBead3 = nextBead2.getNextBead();
    PDThreadBead nextBead4 = nextBead3.getNextBead();
    PDThreadBead nextBead5 = nextBead4.getNextBead();
    PDThreadBead nextBead6 = nextBead5.getNextBead();
    PDThreadBead nextBead7 = nextBead6.getNextBead();
    PDThreadBead nextBead8 = nextBead7.getNextBead();
    assertNull(nextBead8.getPage());
    assertNull(nextBead7.getPage());
    assertNull(nextBead6.getPage());
    assertNull(nextBead5.getPage());
    assertNull(nextBead4.getPage());
    assertNull(nextBead3.getPage());
    assertNull(nextBead2.getPage());
    assertNull(nextBead.getPage());
    assertNull(actualPreviousBead.getPage());
    assertNull(nextBead8.getRectangle());
    assertNull(nextBead7.getRectangle());
    assertNull(nextBead6.getRectangle());
    assertNull(nextBead5.getRectangle());
    assertNull(nextBead4.getRectangle());
    assertNull(nextBead3.getRectangle());
    assertNull(nextBead2.getRectangle());
    assertNull(nextBead.getRectangle());
    assertNull(actualPreviousBead.getRectangle());
    assertNull(nextBead8.getThread());
    assertNull(nextBead7.getThread());
    assertNull(nextBead6.getThread());
    assertNull(nextBead5.getThread());
    assertNull(nextBead4.getThread());
    assertNull(nextBead3.getThread());
    assertNull(nextBead2.getThread());
    assertNull(nextBead.getThread());
    assertNull(actualPreviousBead.getThread());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertSame(cOSObject, nextBead8.getCOSObject());
    assertSame(cOSObject, nextBead7.getCOSObject());
    assertSame(cOSObject, nextBead6.getCOSObject());
    assertSame(cOSObject, nextBead5.getCOSObject());
    assertSame(cOSObject, nextBead4.getCOSObject());
    assertSame(cOSObject, nextBead3.getCOSObject());
    assertSame(cOSObject, nextBead2.getCOSObject());
    assertSame(cOSObject, nextBead.getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#setPreviousBead(PDThreadBead)}.
   * <ul>
   *   <li>Given {@link PDThreadBead#PDThreadBead()}.</li>
   *   <li>Then {@link PDThreadBead#PDThreadBead()} COSObject Values size is
   * three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#setPreviousBead(PDThreadBead)}
   */
  @Test
  @DisplayName("Test setPreviousBead(PDThreadBead); given PDThreadBead(); then PDThreadBead() COSObject Values size is three")
  void testSetPreviousBead_givenPDThreadBead_thenPDThreadBeadCOSObjectValuesSizeIsThree() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();
    PDThreadBead previous = new PDThreadBead();

    // Act
    pdThreadBead.setPreviousBead(previous);

    // Assert
    COSDictionary cOSObject = previous.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(cOSObject, previous.getPreviousBead().getCOSObject());
    PDThreadBead nextBead = previous.getNextBead();
    assertSame(cOSObject, nextBead.getPreviousBead().getCOSObject());
    PDThreadBead nextBead2 = nextBead.getNextBead();
    assertSame(cOSObject, nextBead2.getPreviousBead().getCOSObject());
    PDThreadBead nextBead3 = nextBead2.getNextBead();
    assertSame(cOSObject, nextBead3.getPreviousBead().getCOSObject());
    PDThreadBead nextBead4 = nextBead3.getNextBead();
    assertSame(cOSObject, nextBead4.getPreviousBead().getCOSObject());
    PDThreadBead nextBead5 = nextBead4.getNextBead();
    assertSame(cOSObject, nextBead5.getPreviousBead().getCOSObject());
    assertSame(cOSObject, nextBead5.getNextBead().getPreviousBead().getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#setPreviousBead(PDThreadBead)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDThreadBead#PDThreadBead()} PreviousBead COSObject is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#setPreviousBead(PDThreadBead)}
   */
  @Test
  @DisplayName("Test setPreviousBead(PDThreadBead); when 'null'; then PDThreadBead() PreviousBead COSObject is 'null'")
  void testSetPreviousBead_whenNull_thenPDThreadBeadPreviousBeadCOSObjectIsNull() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();

    // Act
    pdThreadBead.setPreviousBead(null);

    // Assert
    assertNull(pdThreadBead.getPreviousBead().getCOSObject());
    PDThreadBead nextBead = pdThreadBead.getNextBead();
    assertNull(nextBead.getPreviousBead().getCOSObject());
    PDThreadBead nextBead2 = nextBead.getNextBead();
    assertNull(nextBead2.getPreviousBead().getCOSObject());
    PDThreadBead nextBead3 = nextBead2.getNextBead();
    assertNull(nextBead3.getPreviousBead().getCOSObject());
    PDThreadBead nextBead4 = nextBead3.getNextBead();
    assertNull(nextBead4.getPreviousBead().getCOSObject());
    PDThreadBead nextBead5 = nextBead4.getNextBead();
    assertNull(nextBead5.getPreviousBead().getCOSObject());
    PDThreadBead nextBead6 = nextBead5.getNextBead();
    assertNull(nextBead6.getPreviousBead().getCOSObject());
    PDThreadBead nextBead7 = nextBead6.getNextBead();
    assertNull(nextBead7.getPreviousBead().getCOSObject());
    PDThreadBead nextBead8 = nextBead7.getNextBead();
    assertNull(nextBead8.getPage());
    assertNull(nextBead8.getRectangle());
    assertNull(nextBead8.getThread());
    COSDictionary cOSObject = pdThreadBead.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(cOSObject, nextBead8.getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#appendBead(PDThreadBead)}.
   * <p>
   * Method under test: {@link PDThreadBead#appendBead(PDThreadBead)}
   */
  @Test
  @DisplayName("Test appendBead(PDThreadBead)")
  void testAppendBead() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();
    PDThreadBead append = new PDThreadBead();

    // Act
    pdThreadBead.appendBead(append);

    // Assert
    PDThreadBead nextBead = append.getNextBead();
    COSDictionary cOSObject = nextBead.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    PDThreadBead nextBead2 = nextBead.getNextBead();
    PDThreadBead nextBead3 = nextBead2.getNextBead();
    assertSame(nextBead3.getCOSObject(), nextBead3.getCOSObject());
    PDThreadBead nextBead4 = nextBead3.getNextBead();
    PDThreadBead nextBead5 = nextBead4.getNextBead();
    assertSame(nextBead5.getCOSObject(), nextBead5.getCOSObject());
    PDThreadBead nextBead6 = nextBead5.getNextBead();
    COSDictionary cOSObject2 = nextBead6.getNextBead().getCOSObject();
    assertSame(cOSObject2, cOSObject2);
    PDThreadBead previousBead = nextBead.getPreviousBead();
    PDThreadBead nextBead7 = previousBead.getNextBead();
    PDThreadBead nextBead8 = nextBead7.getNextBead();
    PDThreadBead nextBead9 = nextBead8.getNextBead();
    PDThreadBead nextBead10 = nextBead9.getNextBead();
    assertSame(cOSObject2, nextBead10.getNextBead().getCOSObject());
    PDThreadBead previousBead2 = append.getPreviousBead();
    PDThreadBead nextBead11 = previousBead2.getNextBead();
    PDThreadBead nextBead12 = nextBead11.getNextBead();
    PDThreadBead nextBead13 = nextBead12.getNextBead();
    assertSame(cOSObject2, nextBead13.getNextBead().getCOSObject());
    PDThreadBead previousBead3 = nextBead2.getPreviousBead();
    PDThreadBead nextBead14 = previousBead3.getNextBead();
    PDThreadBead nextBead15 = nextBead14.getNextBead();
    PDThreadBead nextBead16 = nextBead15.getNextBead();
    assertSame(cOSObject2, nextBead16.getNextBead().getCOSObject());
    assertSame(cOSObject2, nextBead9.getCOSObject());
    PDThreadBead previousBead4 = nextBead3.getPreviousBead();
    PDThreadBead nextBead17 = previousBead4.getNextBead();
    PDThreadBead nextBead18 = nextBead17.getNextBead();
    assertSame(cOSObject2, nextBead18.getNextBead().getCOSObject());
    PDThreadBead previousBead5 = previousBead2.getPreviousBead();
    PDThreadBead nextBead19 = previousBead5.getNextBead();
    PDThreadBead nextBead20 = nextBead19.getNextBead();
    assertSame(cOSObject2, nextBead20.getNextBead().getCOSObject());
    PDThreadBead previousBead6 = previousBead3.getPreviousBead();
    PDThreadBead nextBead21 = previousBead6.getNextBead();
    PDThreadBead nextBead22 = nextBead21.getNextBead();
    assertSame(cOSObject2, nextBead22.getNextBead().getCOSObject());
    assertSame(cOSObject2, nextBead12.getCOSObject());
    assertSame(cOSObject2, nextBead15.getCOSObject());
    PDThreadBead previousBead7 = nextBead4.getPreviousBead();
    PDThreadBead nextBead23 = previousBead7.getNextBead();
    assertSame(cOSObject2, nextBead23.getNextBead().getCOSObject());
    PDThreadBead previousBead8 = nextBead11.getPreviousBead();
    PDThreadBead nextBead24 = previousBead8.getNextBead();
    assertSame(cOSObject2, nextBead24.getNextBead().getCOSObject());
    PDThreadBead previousBead9 = nextBead14.getPreviousBead();
    PDThreadBead nextBead25 = previousBead9.getNextBead();
    assertSame(cOSObject2, nextBead25.getNextBead().getCOSObject());
    PDThreadBead previousBead10 = previousBead.getPreviousBead();
    PDThreadBead nextBead26 = previousBead10.getNextBead();
    assertSame(cOSObject2, nextBead26.getNextBead().getCOSObject());
    PDThreadBead previousBead11 = previousBead4.getPreviousBead();
    PDThreadBead nextBead27 = previousBead11.getNextBead();
    assertSame(cOSObject2, nextBead27.getNextBead().getCOSObject());
    PDThreadBead previousBead12 = previousBead5.getPreviousBead();
    PDThreadBead nextBead28 = previousBead12.getNextBead();
    assertSame(cOSObject2, nextBead28.getNextBead().getCOSObject());
    PDThreadBead previousBead13 = previousBead6.getPreviousBead();
    PDThreadBead nextBead29 = previousBead13.getNextBead();
    assertSame(cOSObject2, nextBead29.getNextBead().getCOSObject());
    assertSame(cOSObject2, nextBead7.getCOSObject());
    assertSame(cOSObject2, nextBead17.getCOSObject());
    PDThreadBead previousBead14 = nextBead5.getPreviousBead();
    assertSame(cOSObject2, previousBead14.getNextBead().getCOSObject());
    PDThreadBead previousBead15 = nextBead9.getPreviousBead();
    assertSame(cOSObject2, previousBead15.getNextBead().getCOSObject());
    PDThreadBead previousBead16 = nextBead12.getPreviousBead();
    assertSame(cOSObject2, previousBead16.getNextBead().getCOSObject());
    PDThreadBead previousBead17 = nextBead15.getPreviousBead();
    assertSame(cOSObject2, previousBead17.getNextBead().getCOSObject());
    PDThreadBead previousBead18 = nextBead7.getPreviousBead();
    assertSame(cOSObject2, previousBead18.getNextBead().getCOSObject());
    PDThreadBead previousBead19 = nextBead17.getPreviousBead();
    assertSame(cOSObject2, previousBead19.getNextBead().getCOSObject());
    PDThreadBead previousBead20 = nextBead19.getPreviousBead();
    assertSame(cOSObject2, previousBead20.getNextBead().getCOSObject());
    PDThreadBead previousBead21 = nextBead21.getPreviousBead();
    assertSame(cOSObject2, previousBead21.getNextBead().getCOSObject());
    assertSame(cOSObject2, nextBead19.getCOSObject());
    assertSame(cOSObject2, nextBead21.getCOSObject());
    PDThreadBead previousBead22 = previousBead7.getPreviousBead();
    assertSame(cOSObject2, previousBead22.getNextBead().getCOSObject());
    PDThreadBead previousBead23 = previousBead8.getPreviousBead();
    assertSame(cOSObject2, previousBead23.getNextBead().getCOSObject());
    PDThreadBead previousBead24 = previousBead9.getPreviousBead();
    assertSame(cOSObject2, previousBead24.getNextBead().getCOSObject());
    PDThreadBead previousBead25 = previousBead10.getPreviousBead();
    assertSame(cOSObject2, previousBead25.getNextBead().getCOSObject());
    PDThreadBead previousBead26 = previousBead11.getPreviousBead();
    assertSame(cOSObject2, previousBead26.getNextBead().getCOSObject());
    PDThreadBead previousBead27 = previousBead12.getPreviousBead();
    assertSame(cOSObject2, previousBead27.getNextBead().getCOSObject());
    PDThreadBead previousBead28 = previousBead13.getPreviousBead();
    assertSame(cOSObject2, previousBead28.getNextBead().getCOSObject());
    assertSame(cOSObject2, previousBead2.getCOSObject());
    assertSame(cOSObject2, previousBead3.getCOSObject());
    assertSame(cOSObject2, previousBead7.getCOSObject());
    assertSame(cOSObject2, nextBead6.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, nextBead10.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, nextBead13.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, nextBead16.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, nextBead8.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, nextBead18.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, nextBead20.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, nextBead22.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, previousBead8.getCOSObject());
    assertSame(cOSObject2, previousBead9.getCOSObject());
    assertSame(cOSObject2, nextBead23.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, nextBead24.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, nextBead25.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, nextBead26.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, nextBead27.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, nextBead28.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, nextBead29.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, previousBead10.getCOSObject());
    assertSame(cOSObject2, previousBead11.getCOSObject());
    assertSame(cOSObject2, previousBead14.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, previousBead15.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, previousBead16.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, previousBead17.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, previousBead18.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, previousBead19.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, previousBead20.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, previousBead21.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, previousBead12.getCOSObject());
    assertSame(cOSObject2, previousBead13.getCOSObject());
    assertSame(cOSObject2, previousBead22.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, previousBead23.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, previousBead24.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, previousBead25.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, previousBead26.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, previousBead27.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, previousBead28.getPreviousBead().getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#getPage()}.
   * <ul>
   *   <li>Given {@link PDThreadBead#PDThreadBead()} Page is
   * {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getPage()}
   */
  @Test
  @DisplayName("Test getPage(); given PDThreadBead() Page is PDPage(); then return PDPage()")
  void testGetPage_givenPDThreadBeadPageIsPDPage_thenReturnPDPage() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();
    PDPage page = new PDPage();
    pdThreadBead.setPage(page);

    // Act and Assert
    assertEquals(page, pdThreadBead.getPage());
  }

  /**
   * Test {@link PDThreadBead#getPage()}.
   * <ul>
   *   <li>Given {@link PDThreadBead#PDThreadBead(COSDictionary)} with b is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getPage()}
   */
  @Test
  @DisplayName("Test getPage(); given PDThreadBead(COSDictionary) with b is COSDictionary(); then return 'null'")
  void testGetPage_givenPDThreadBeadWithBIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDThreadBead(new COSDictionary())).getPage());
  }

  /**
   * Test {@link PDThreadBead#getPage()}.
   * <ul>
   *   <li>Given {@link PDThreadBead#PDThreadBead()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getPage()}
   */
  @Test
  @DisplayName("Test getPage(); given PDThreadBead(); then return 'null'")
  void testGetPage_givenPDThreadBead_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDThreadBead()).getPage());
  }

  /**
   * Test {@link PDThreadBead#setPage(PDPage)}.
   * <ul>
   *   <li>Given {@link PDThreadBead#PDThreadBead()}.</li>
   *   <li>Then {@link PDThreadBead#PDThreadBead()} COSObject Values size is
   * four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#setPage(PDPage)}
   */
  @Test
  @DisplayName("Test setPage(PDPage); given PDThreadBead(); then PDThreadBead() COSObject Values size is four")
  void testSetPage_givenPDThreadBead_thenPDThreadBeadCOSObjectValuesSizeIsFour() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();
    PDPage page = new PDPage();

    // Act
    pdThreadBead.setPage(page);

    // Assert
    COSDictionary cOSObject = pdThreadBead.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(page, pdThreadBead.getPage());
    PDThreadBead nextBead = pdThreadBead.getNextBead();
    assertEquals(page, nextBead.getPage());
    PDThreadBead nextBead2 = nextBead.getNextBead();
    assertEquals(page, nextBead2.getPage());
    PDThreadBead nextBead3 = nextBead2.getNextBead();
    assertEquals(page, nextBead3.getPage());
    PDThreadBead nextBead4 = nextBead3.getNextBead();
    assertEquals(page, nextBead4.getPage());
    assertEquals(page, nextBead4.getNextBead().getPage());
    PDThreadBead previousBead = pdThreadBead.getPreviousBead();
    PDThreadBead nextBead5 = previousBead.getNextBead();
    PDThreadBead nextBead6 = nextBead5.getNextBead();
    assertEquals(page, nextBead6.getNextBead().getPage());
    assertEquals(page, nextBead6.getPage());
    PDThreadBead previousBead2 = nextBead.getPreviousBead();
    PDThreadBead nextBead7 = previousBead2.getNextBead();
    assertEquals(page, nextBead7.getNextBead().getPage());
    PDThreadBead previousBead3 = nextBead2.getPreviousBead();
    PDThreadBead nextBead8 = previousBead3.getNextBead();
    assertEquals(page, nextBead8.getNextBead().getPage());
    PDThreadBead previousBead4 = previousBead.getPreviousBead();
    PDThreadBead nextBead9 = previousBead4.getNextBead();
    assertEquals(page, nextBead9.getNextBead().getPage());
    assertEquals(page, nextBead5.getPage());
    assertEquals(page, nextBead7.getPage());
    assertEquals(page, nextBead8.getPage());
    PDThreadBead previousBead5 = nextBead3.getPreviousBead();
    assertEquals(page, previousBead5.getNextBead().getPage());
    PDThreadBead previousBead6 = nextBead5.getPreviousBead();
    assertEquals(page, previousBead6.getNextBead().getPage());
    assertEquals(page, nextBead9.getPage());
    PDThreadBead previousBead7 = previousBead2.getPreviousBead();
    assertEquals(page, previousBead7.getNextBead().getPage());
    PDThreadBead previousBead8 = previousBead3.getPreviousBead();
    assertEquals(page, previousBead8.getNextBead().getPage());
    PDThreadBead previousBead9 = previousBead4.getPreviousBead();
    assertEquals(page, previousBead9.getNextBead().getPage());
    assertEquals(page, previousBead.getPage());
    assertEquals(page, previousBead2.getPage());
    assertEquals(page, previousBead3.getPage());
    assertEquals(page, previousBead5.getPage());
    assertEquals(page, nextBead4.getPreviousBead().getPage());
    assertEquals(page, nextBead6.getPreviousBead().getPage());
    assertEquals(page, previousBead6.getPage());
    assertEquals(page, nextBead7.getPreviousBead().getPage());
    assertEquals(page, nextBead8.getPreviousBead().getPage());
    assertEquals(page, nextBead9.getPreviousBead().getPage());
    assertEquals(page, previousBead4.getPage());
    assertEquals(page, previousBead7.getPage());
    assertEquals(page, previousBead8.getPage());
    assertEquals(page, previousBead5.getPreviousBead().getPage());
    assertEquals(page, previousBead6.getPreviousBead().getPage());
    assertEquals(page, previousBead9.getPage());
    assertEquals(page, previousBead7.getPreviousBead().getPage());
    assertEquals(page, previousBead9.getPreviousBead().getPage());
  }

  /**
   * Test {@link PDThreadBead#setPage(PDPage)}.
   * <ul>
   *   <li>Given {@link PDThreadBead#PDThreadBead()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDThreadBead#PDThreadBead()} Page is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#setPage(PDPage)}
   */
  @Test
  @DisplayName("Test setPage(PDPage); given PDThreadBead(); when 'null'; then PDThreadBead() Page is 'null'")
  void testSetPage_givenPDThreadBead_whenNull_thenPDThreadBeadPageIsNull() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();

    // Act
    pdThreadBead.setPage(null);

    // Assert
    assertNull(pdThreadBead.getPage());
    PDThreadBead nextBead = pdThreadBead.getNextBead();
    assertNull(nextBead.getPage());
    PDThreadBead nextBead2 = nextBead.getNextBead();
    assertNull(nextBead2.getPage());
    PDThreadBead nextBead3 = nextBead2.getNextBead();
    assertNull(nextBead3.getPage());
    PDThreadBead nextBead4 = nextBead3.getNextBead();
    assertNull(nextBead4.getPage());
    assertNull(nextBead4.getNextBead().getPage());
    PDThreadBead previousBead = pdThreadBead.getPreviousBead();
    PDThreadBead nextBead5 = previousBead.getNextBead();
    PDThreadBead nextBead6 = nextBead5.getNextBead();
    assertNull(nextBead6.getNextBead().getPage());
    assertNull(nextBead6.getPage());
    PDThreadBead previousBead2 = nextBead.getPreviousBead();
    PDThreadBead nextBead7 = previousBead2.getNextBead();
    assertNull(nextBead7.getNextBead().getPage());
    PDThreadBead previousBead3 = nextBead2.getPreviousBead();
    PDThreadBead nextBead8 = previousBead3.getNextBead();
    assertNull(nextBead8.getNextBead().getPage());
    PDThreadBead previousBead4 = previousBead.getPreviousBead();
    PDThreadBead nextBead9 = previousBead4.getNextBead();
    assertNull(nextBead9.getNextBead().getPage());
    assertNull(nextBead5.getPage());
    assertNull(nextBead7.getPage());
    assertNull(nextBead8.getPage());
    PDThreadBead previousBead5 = nextBead3.getPreviousBead();
    assertNull(previousBead5.getNextBead().getPage());
    PDThreadBead previousBead6 = nextBead5.getPreviousBead();
    assertNull(previousBead6.getNextBead().getPage());
    assertNull(nextBead9.getPage());
    PDThreadBead previousBead7 = previousBead2.getPreviousBead();
    assertNull(previousBead7.getNextBead().getPage());
    PDThreadBead previousBead8 = previousBead3.getPreviousBead();
    assertNull(previousBead8.getNextBead().getPage());
    PDThreadBead previousBead9 = previousBead4.getPreviousBead();
    assertNull(previousBead9.getNextBead().getPage());
    assertNull(previousBead.getPage());
    assertNull(previousBead2.getPage());
    assertNull(previousBead3.getPage());
    assertNull(previousBead5.getPage());
    assertNull(nextBead4.getPreviousBead().getPage());
    assertNull(nextBead6.getPreviousBead().getPage());
    assertNull(previousBead6.getPage());
    assertNull(nextBead7.getPreviousBead().getPage());
    assertNull(nextBead8.getPreviousBead().getPage());
    assertNull(nextBead9.getPreviousBead().getPage());
    assertNull(previousBead4.getPage());
    assertNull(previousBead7.getPage());
    assertNull(previousBead8.getPage());
    assertNull(previousBead5.getPreviousBead().getPage());
    assertNull(previousBead6.getPreviousBead().getPage());
    assertNull(previousBead9.getPage());
    assertNull(previousBead7.getPreviousBead().getPage());
    assertNull(previousBead9.getPreviousBead().getPage());
    COSDictionary cOSObject = pdThreadBead.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDThreadBead#getRectangle()}.
   * <ul>
   *   <li>Given {@link PDThreadBead#PDThreadBead(COSDictionary)} with b is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle(); given PDThreadBead(COSDictionary) with b is COSDictionary(); then return 'null'")
  void testGetRectangle_givenPDThreadBeadWithBIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDThreadBead(new COSDictionary())).getRectangle());
  }

  /**
   * Test {@link PDThreadBead#getRectangle()}.
   * <ul>
   *   <li>Given {@link PDThreadBead#PDThreadBead()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle(); given PDThreadBead(); then return 'null'")
  void testGetRectangle_givenPDThreadBead_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDThreadBead()).getRectangle());
  }

  /**
   * Test {@link PDThreadBead#getRectangle()}.
   * <ul>
   *   <li>Then return COSArray toList third Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle(); then return COSArray toList third Key is 'null'")
  void testGetRectangle_thenReturnCOSArrayToListThirdKeyIsNull() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();
    pdThreadBead.setRectangle(PDRectangle.A0);

    // Act
    PDRectangle actualRectangle = pdThreadBead.getRectangle();

    // Assert
    List<? extends COSBase> toListResult = actualRectangle.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertEquals(0.0f, actualRectangle.getLowerLeftX());
    assertEquals(0.0f, actualRectangle.getLowerLeftY());
    assertEquals(2383.937f, actualRectangle.getUpperRightX());
    assertEquals(2383.937f, actualRectangle.getWidth());
    assertEquals(3370.3938f, actualRectangle.getHeight());
    assertEquals(3370.3938f, actualRectangle.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
  }

  /**
   * Test {@link PDThreadBead#getRectangle()}.
   * <ul>
   *   <li>Then return Height is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle(); then return Height is zero")
  void testGetRectangle_thenReturnHeightIsZero() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();
    pdThreadBead.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualRectangle = pdThreadBead.getRectangle();

    // Assert
    List<? extends COSBase> toListResult = actualRectangle.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(0.0f, actualRectangle.getHeight());
    assertEquals(0.0f, actualRectangle.getWidth());
    assertEquals(2.14748365E9f, actualRectangle.getLowerLeftX());
    assertEquals(2.14748365E9f, actualRectangle.getLowerLeftY());
    assertEquals(2.14748365E9f, actualRectangle.getUpperRightX());
    assertEquals(2.14748365E9f, actualRectangle.getUpperRightY());
    COSBase getResult3 = toListResult.get(0);
    assertEquals(getResult3, getResult);
    assertEquals(getResult3, getResult2);
  }

  /**
   * Test {@link PDThreadBead#setRectangle(PDRectangle)}.
   * <ul>
   *   <li>When {@link PDRectangle#A0}.</li>
   *   <li>Then {@link PDThreadBead#PDThreadBead()} Rectangle UpperRightX is
   * {@code 2383.937}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#setRectangle(PDRectangle)}
   */
  @Test
  @DisplayName("Test setRectangle(PDRectangle); when A0; then PDThreadBead() Rectangle UpperRightX is '2383.937'")
  void testSetRectangle_whenA0_thenPDThreadBeadRectangleUpperRightXIs2383937() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();

    // Act
    pdThreadBead.setRectangle(PDRectangle.A0);

    // Assert
    PDRectangle rectangle = pdThreadBead.getRectangle();
    assertEquals(2383.937f, rectangle.getUpperRightX());
    PDThreadBead nextBead = pdThreadBead.getNextBead();
    PDRectangle rectangle2 = nextBead.getRectangle();
    assertEquals(2383.937f, rectangle2.getUpperRightX());
    PDThreadBead nextBead2 = nextBead.getNextBead();
    PDRectangle rectangle3 = nextBead2.getRectangle();
    assertEquals(2383.937f, rectangle3.getUpperRightX());
    PDThreadBead nextBead3 = nextBead2.getNextBead();
    PDRectangle rectangle4 = nextBead3.getRectangle();
    assertEquals(2383.937f, rectangle4.getUpperRightX());
    PDThreadBead nextBead4 = nextBead3.getNextBead();
    PDRectangle rectangle5 = nextBead4.getRectangle();
    assertEquals(2383.937f, rectangle5.getUpperRightX());
    PDRectangle rectangle6 = nextBead4.getNextBead().getRectangle();
    assertEquals(2383.937f, rectangle6.getUpperRightX());
    PDThreadBead previousBead = pdThreadBead.getPreviousBead();
    PDThreadBead nextBead5 = previousBead.getNextBead();
    PDThreadBead nextBead6 = nextBead5.getNextBead();
    PDRectangle rectangle7 = nextBead6.getNextBead().getRectangle();
    assertEquals(2383.937f, rectangle7.getUpperRightX());
    PDThreadBead previousBead2 = nextBead.getPreviousBead();
    PDThreadBead nextBead7 = previousBead2.getNextBead();
    PDThreadBead nextBead8 = nextBead7.getNextBead();
    PDRectangle rectangle8 = nextBead8.getNextBead().getRectangle();
    assertEquals(2383.937f, rectangle8.getUpperRightX());
    PDRectangle rectangle9 = nextBead6.getRectangle();
    assertEquals(2383.937f, rectangle9.getUpperRightX());
    PDRectangle rectangle10 = nextBead8.getRectangle();
    assertEquals(2383.937f, rectangle10.getUpperRightX());
    PDThreadBead previousBead3 = nextBead2.getPreviousBead();
    PDThreadBead nextBead9 = previousBead3.getNextBead();
    PDRectangle rectangle11 = nextBead9.getNextBead().getRectangle();
    assertEquals(2383.937f, rectangle11.getUpperRightX());
    PDThreadBead previousBead4 = previousBead.getPreviousBead();
    PDThreadBead nextBead10 = previousBead4.getNextBead();
    PDRectangle rectangle12 = nextBead10.getNextBead().getRectangle();
    assertEquals(2383.937f, rectangle12.getUpperRightX());
    PDThreadBead previousBead5 = previousBead2.getPreviousBead();
    PDThreadBead nextBead11 = previousBead5.getNextBead();
    PDRectangle rectangle13 = nextBead11.getNextBead().getRectangle();
    assertEquals(2383.937f, rectangle13.getUpperRightX());
    PDRectangle rectangle14 = nextBead5.getRectangle();
    assertEquals(2383.937f, rectangle14.getUpperRightX());
    PDRectangle rectangle15 = nextBead7.getRectangle();
    assertEquals(2383.937f, rectangle15.getUpperRightX());
    PDRectangle rectangle16 = nextBead9.getRectangle();
    assertEquals(2383.937f, rectangle16.getUpperRightX());
    PDThreadBead previousBead6 = nextBead3.getPreviousBead();
    PDRectangle rectangle17 = previousBead6.getNextBead().getRectangle();
    assertEquals(2383.937f, rectangle17.getUpperRightX());
    PDThreadBead previousBead7 = nextBead5.getPreviousBead();
    PDRectangle rectangle18 = previousBead7.getNextBead().getRectangle();
    assertEquals(2383.937f, rectangle18.getUpperRightX());
    PDThreadBead previousBead8 = nextBead7.getPreviousBead();
    PDRectangle rectangle19 = previousBead8.getNextBead().getRectangle();
    assertEquals(2383.937f, rectangle19.getUpperRightX());
    PDRectangle rectangle20 = nextBead10.getRectangle();
    assertEquals(2383.937f, rectangle20.getUpperRightX());
    PDRectangle rectangle21 = nextBead11.getRectangle();
    assertEquals(2383.937f, rectangle21.getUpperRightX());
    PDThreadBead previousBead9 = previousBead3.getPreviousBead();
    PDRectangle rectangle22 = previousBead9.getNextBead().getRectangle();
    assertEquals(2383.937f, rectangle22.getUpperRightX());
    PDThreadBead previousBead10 = previousBead4.getPreviousBead();
    PDRectangle rectangle23 = previousBead10.getNextBead().getRectangle();
    assertEquals(2383.937f, rectangle23.getUpperRightX());
    PDThreadBead previousBead11 = previousBead5.getPreviousBead();
    PDRectangle rectangle24 = previousBead11.getNextBead().getRectangle();
    assertEquals(2383.937f, rectangle24.getUpperRightX());
    PDRectangle rectangle25 = previousBead.getRectangle();
    assertEquals(2383.937f, rectangle25.getUpperRightX());
    PDRectangle rectangle26 = previousBead2.getRectangle();
    assertEquals(2383.937f, rectangle26.getUpperRightX());
    PDRectangle rectangle27 = previousBead3.getRectangle();
    assertEquals(2383.937f, rectangle27.getUpperRightX());
    PDRectangle rectangle28 = previousBead6.getRectangle();
    assertEquals(2383.937f, rectangle28.getUpperRightX());
    PDRectangle rectangle29 = nextBead4.getPreviousBead().getRectangle();
    assertEquals(2383.937f, rectangle29.getUpperRightX());
    PDRectangle rectangle30 = nextBead6.getPreviousBead().getRectangle();
    assertEquals(2383.937f, rectangle30.getUpperRightX());
    PDRectangle rectangle31 = nextBead8.getPreviousBead().getRectangle();
    assertEquals(2383.937f, rectangle31.getUpperRightX());
    PDRectangle rectangle32 = previousBead7.getRectangle();
    assertEquals(2383.937f, rectangle32.getUpperRightX());
    PDRectangle rectangle33 = previousBead8.getRectangle();
    assertEquals(2383.937f, rectangle33.getUpperRightX());
    PDRectangle rectangle34 = nextBead9.getPreviousBead().getRectangle();
    assertEquals(2383.937f, rectangle34.getUpperRightX());
    PDRectangle rectangle35 = nextBead10.getPreviousBead().getRectangle();
    assertEquals(2383.937f, rectangle35.getUpperRightX());
    PDRectangle rectangle36 = nextBead11.getPreviousBead().getRectangle();
    assertEquals(2383.937f, rectangle36.getUpperRightX());
    PDRectangle rectangle37 = previousBead4.getRectangle();
    assertEquals(2383.937f, rectangle37.getUpperRightX());
    PDRectangle rectangle38 = previousBead5.getRectangle();
    assertEquals(2383.937f, rectangle38.getUpperRightX());
    PDRectangle rectangle39 = previousBead9.getRectangle();
    assertEquals(2383.937f, rectangle39.getUpperRightX());
    PDRectangle rectangle40 = previousBead6.getPreviousBead().getRectangle();
    assertEquals(2383.937f, rectangle40.getUpperRightX());
    PDRectangle rectangle41 = previousBead7.getPreviousBead().getRectangle();
    assertEquals(2383.937f, rectangle41.getUpperRightX());
    PDRectangle rectangle42 = previousBead8.getPreviousBead().getRectangle();
    assertEquals(2383.937f, rectangle42.getUpperRightX());
    PDRectangle rectangle43 = previousBead10.getRectangle();
    assertEquals(2383.937f, rectangle43.getUpperRightX());
    PDRectangle rectangle44 = previousBead11.getRectangle();
    assertEquals(2383.937f, rectangle44.getUpperRightX());
    PDRectangle rectangle45 = previousBead9.getPreviousBead().getRectangle();
    assertEquals(2383.937f, rectangle45.getUpperRightX());
    PDRectangle rectangle46 = previousBead10.getPreviousBead().getRectangle();
    assertEquals(2383.937f, rectangle46.getUpperRightX());
    PDRectangle rectangle47 = previousBead11.getPreviousBead().getRectangle();
    assertEquals(2383.937f, rectangle47.getUpperRightX());
    assertEquals(2383.937f, rectangle.getWidth());
    assertEquals(2383.937f, rectangle2.getWidth());
    assertEquals(2383.937f, rectangle3.getWidth());
    assertEquals(2383.937f, rectangle4.getWidth());
    assertEquals(2383.937f, rectangle5.getWidth());
    assertEquals(2383.937f, rectangle6.getWidth());
    assertEquals(2383.937f, rectangle7.getWidth());
    assertEquals(2383.937f, rectangle8.getWidth());
    assertEquals(2383.937f, rectangle9.getWidth());
    assertEquals(2383.937f, rectangle10.getWidth());
    assertEquals(2383.937f, rectangle11.getWidth());
    assertEquals(2383.937f, rectangle12.getWidth());
    assertEquals(2383.937f, rectangle13.getWidth());
    assertEquals(2383.937f, rectangle14.getWidth());
    assertEquals(2383.937f, rectangle15.getWidth());
    assertEquals(2383.937f, rectangle16.getWidth());
    assertEquals(2383.937f, rectangle17.getWidth());
    assertEquals(2383.937f, rectangle18.getWidth());
    assertEquals(2383.937f, rectangle19.getWidth());
    assertEquals(2383.937f, rectangle20.getWidth());
    assertEquals(2383.937f, rectangle21.getWidth());
    assertEquals(2383.937f, rectangle22.getWidth());
    assertEquals(2383.937f, rectangle23.getWidth());
    assertEquals(2383.937f, rectangle24.getWidth());
    assertEquals(2383.937f, rectangle25.getWidth());
    assertEquals(2383.937f, rectangle26.getWidth());
    assertEquals(2383.937f, rectangle27.getWidth());
    assertEquals(2383.937f, rectangle28.getWidth());
    assertEquals(2383.937f, rectangle29.getWidth());
    assertEquals(2383.937f, rectangle30.getWidth());
    assertEquals(2383.937f, rectangle31.getWidth());
    assertEquals(2383.937f, rectangle32.getWidth());
    assertEquals(2383.937f, rectangle33.getWidth());
    assertEquals(2383.937f, rectangle34.getWidth());
    assertEquals(2383.937f, rectangle35.getWidth());
    assertEquals(2383.937f, rectangle36.getWidth());
    assertEquals(2383.937f, rectangle37.getWidth());
    assertEquals(2383.937f, rectangle38.getWidth());
    assertEquals(2383.937f, rectangle39.getWidth());
    assertEquals(2383.937f, rectangle40.getWidth());
    assertEquals(2383.937f, rectangle41.getWidth());
    assertEquals(2383.937f, rectangle42.getWidth());
    assertEquals(2383.937f, rectangle43.getWidth());
    assertEquals(2383.937f, rectangle44.getWidth());
    assertEquals(2383.937f, rectangle45.getWidth());
    assertEquals(2383.937f, rectangle46.getWidth());
    assertEquals(2383.937f, rectangle47.getWidth());
    assertEquals(3370.3938f, rectangle.getHeight());
    assertEquals(3370.3938f, rectangle2.getHeight());
    assertEquals(3370.3938f, rectangle3.getHeight());
    assertEquals(3370.3938f, rectangle4.getHeight());
    assertEquals(3370.3938f, rectangle5.getHeight());
    assertEquals(3370.3938f, rectangle6.getHeight());
    assertEquals(3370.3938f, rectangle7.getHeight());
    assertEquals(3370.3938f, rectangle8.getHeight());
    assertEquals(3370.3938f, rectangle9.getHeight());
    assertEquals(3370.3938f, rectangle10.getHeight());
    assertEquals(3370.3938f, rectangle11.getHeight());
    assertEquals(3370.3938f, rectangle12.getHeight());
    assertEquals(3370.3938f, rectangle13.getHeight());
    assertEquals(3370.3938f, rectangle14.getHeight());
    assertEquals(3370.3938f, rectangle15.getHeight());
    assertEquals(3370.3938f, rectangle16.getHeight());
    assertEquals(3370.3938f, rectangle17.getHeight());
    assertEquals(3370.3938f, rectangle18.getHeight());
    assertEquals(3370.3938f, rectangle19.getHeight());
    assertEquals(3370.3938f, rectangle20.getHeight());
    assertEquals(3370.3938f, rectangle21.getHeight());
    assertEquals(3370.3938f, rectangle22.getHeight());
    assertEquals(3370.3938f, rectangle23.getHeight());
    assertEquals(3370.3938f, rectangle24.getHeight());
    assertEquals(3370.3938f, rectangle25.getHeight());
    assertEquals(3370.3938f, rectangle26.getHeight());
    assertEquals(3370.3938f, rectangle27.getHeight());
    assertEquals(3370.3938f, rectangle28.getHeight());
    assertEquals(3370.3938f, rectangle29.getHeight());
    assertEquals(3370.3938f, rectangle30.getHeight());
    assertEquals(3370.3938f, rectangle31.getHeight());
    assertEquals(3370.3938f, rectangle32.getHeight());
    assertEquals(3370.3938f, rectangle33.getHeight());
    assertEquals(3370.3938f, rectangle34.getHeight());
    assertEquals(3370.3938f, rectangle35.getHeight());
    assertEquals(3370.3938f, rectangle36.getHeight());
    assertEquals(3370.3938f, rectangle37.getHeight());
    assertEquals(3370.3938f, rectangle38.getHeight());
    assertEquals(3370.3938f, rectangle39.getHeight());
    assertEquals(3370.3938f, rectangle40.getHeight());
    assertEquals(3370.3938f, rectangle41.getHeight());
    assertEquals(3370.3938f, rectangle42.getHeight());
    assertEquals(3370.3938f, rectangle43.getHeight());
    assertEquals(3370.3938f, rectangle44.getHeight());
    assertEquals(3370.3938f, rectangle45.getHeight());
    assertEquals(3370.3938f, rectangle46.getHeight());
    assertEquals(3370.3938f, rectangle47.getHeight());
    assertEquals(3370.3938f, rectangle.getUpperRightY());
    assertEquals(3370.3938f, rectangle2.getUpperRightY());
    assertEquals(3370.3938f, rectangle3.getUpperRightY());
    assertEquals(3370.3938f, rectangle4.getUpperRightY());
    assertEquals(3370.3938f, rectangle5.getUpperRightY());
    assertEquals(3370.3938f, rectangle6.getUpperRightY());
    assertEquals(3370.3938f, rectangle7.getUpperRightY());
    assertEquals(3370.3938f, rectangle8.getUpperRightY());
    assertEquals(3370.3938f, rectangle9.getUpperRightY());
    assertEquals(3370.3938f, rectangle10.getUpperRightY());
    assertEquals(3370.3938f, rectangle11.getUpperRightY());
    assertEquals(3370.3938f, rectangle12.getUpperRightY());
    assertEquals(3370.3938f, rectangle13.getUpperRightY());
    assertEquals(3370.3938f, rectangle14.getUpperRightY());
    assertEquals(3370.3938f, rectangle15.getUpperRightY());
    assertEquals(3370.3938f, rectangle16.getUpperRightY());
    assertEquals(3370.3938f, rectangle17.getUpperRightY());
    assertEquals(3370.3938f, rectangle18.getUpperRightY());
    assertEquals(3370.3938f, rectangle19.getUpperRightY());
    assertEquals(3370.3938f, rectangle20.getUpperRightY());
    assertEquals(3370.3938f, rectangle21.getUpperRightY());
    assertEquals(3370.3938f, rectangle22.getUpperRightY());
    assertEquals(3370.3938f, rectangle23.getUpperRightY());
    assertEquals(3370.3938f, rectangle24.getUpperRightY());
    assertEquals(3370.3938f, rectangle25.getUpperRightY());
    assertEquals(3370.3938f, rectangle26.getUpperRightY());
    assertEquals(3370.3938f, rectangle27.getUpperRightY());
    assertEquals(3370.3938f, rectangle28.getUpperRightY());
    assertEquals(3370.3938f, rectangle29.getUpperRightY());
    assertEquals(3370.3938f, rectangle30.getUpperRightY());
    assertEquals(3370.3938f, rectangle31.getUpperRightY());
    assertEquals(3370.3938f, rectangle32.getUpperRightY());
    assertEquals(3370.3938f, rectangle33.getUpperRightY());
    assertEquals(3370.3938f, rectangle34.getUpperRightY());
    assertEquals(3370.3938f, rectangle35.getUpperRightY());
    assertEquals(3370.3938f, rectangle36.getUpperRightY());
    assertEquals(3370.3938f, rectangle37.getUpperRightY());
    assertEquals(3370.3938f, rectangle38.getUpperRightY());
    assertEquals(3370.3938f, rectangle39.getUpperRightY());
    assertEquals(3370.3938f, rectangle40.getUpperRightY());
    assertEquals(3370.3938f, rectangle41.getUpperRightY());
    assertEquals(3370.3938f, rectangle42.getUpperRightY());
    assertEquals(3370.3938f, rectangle43.getUpperRightY());
    assertEquals(3370.3938f, rectangle44.getUpperRightY());
    assertEquals(3370.3938f, rectangle45.getUpperRightY());
    assertEquals(3370.3938f, rectangle46.getUpperRightY());
    assertEquals(3370.3938f, rectangle47.getUpperRightY());
  }

  /**
   * Test {@link PDThreadBead#setRectangle(PDRectangle)}.
   * <ul>
   *   <li>When {@link PDRectangle#PDRectangle()}.</li>
   *   <li>Then {@link PDThreadBead#PDThreadBead()} Rectangle Height is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#setRectangle(PDRectangle)}
   */
  @Test
  @DisplayName("Test setRectangle(PDRectangle); when PDRectangle(); then PDThreadBead() Rectangle Height is zero")
  void testSetRectangle_whenPDRectangle_thenPDThreadBeadRectangleHeightIsZero() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();

    // Act
    pdThreadBead.setRectangle(new PDRectangle());

    // Assert
    PDRectangle rectangle = pdThreadBead.getRectangle();
    assertEquals(0.0f, rectangle.getHeight());
    PDThreadBead nextBead = pdThreadBead.getNextBead();
    PDRectangle rectangle2 = nextBead.getRectangle();
    assertEquals(0.0f, rectangle2.getHeight());
    PDThreadBead nextBead2 = nextBead.getNextBead();
    PDRectangle rectangle3 = nextBead2.getRectangle();
    assertEquals(0.0f, rectangle3.getHeight());
    PDThreadBead nextBead3 = nextBead2.getNextBead();
    PDRectangle rectangle4 = nextBead3.getRectangle();
    assertEquals(0.0f, rectangle4.getHeight());
    PDThreadBead nextBead4 = nextBead3.getNextBead();
    PDRectangle rectangle5 = nextBead4.getRectangle();
    assertEquals(0.0f, rectangle5.getHeight());
    PDRectangle rectangle6 = nextBead4.getNextBead().getRectangle();
    assertEquals(0.0f, rectangle6.getHeight());
    PDThreadBead previousBead = pdThreadBead.getPreviousBead();
    PDThreadBead nextBead5 = previousBead.getNextBead();
    PDThreadBead nextBead6 = nextBead5.getNextBead();
    PDRectangle rectangle7 = nextBead6.getNextBead().getRectangle();
    assertEquals(0.0f, rectangle7.getHeight());
    PDThreadBead previousBead2 = nextBead.getPreviousBead();
    PDThreadBead nextBead7 = previousBead2.getNextBead();
    PDThreadBead nextBead8 = nextBead7.getNextBead();
    PDRectangle rectangle8 = nextBead8.getNextBead().getRectangle();
    assertEquals(0.0f, rectangle8.getHeight());
    PDRectangle rectangle9 = nextBead6.getRectangle();
    assertEquals(0.0f, rectangle9.getHeight());
    PDRectangle rectangle10 = nextBead8.getRectangle();
    assertEquals(0.0f, rectangle10.getHeight());
    PDThreadBead previousBead3 = nextBead2.getPreviousBead();
    PDThreadBead nextBead9 = previousBead3.getNextBead();
    PDRectangle rectangle11 = nextBead9.getNextBead().getRectangle();
    assertEquals(0.0f, rectangle11.getHeight());
    PDThreadBead previousBead4 = previousBead.getPreviousBead();
    PDThreadBead nextBead10 = previousBead4.getNextBead();
    PDRectangle rectangle12 = nextBead10.getNextBead().getRectangle();
    assertEquals(0.0f, rectangle12.getHeight());
    PDThreadBead previousBead5 = previousBead2.getPreviousBead();
    PDThreadBead nextBead11 = previousBead5.getNextBead();
    PDRectangle rectangle13 = nextBead11.getNextBead().getRectangle();
    assertEquals(0.0f, rectangle13.getHeight());
    PDRectangle rectangle14 = nextBead5.getRectangle();
    assertEquals(0.0f, rectangle14.getHeight());
    PDRectangle rectangle15 = nextBead7.getRectangle();
    assertEquals(0.0f, rectangle15.getHeight());
    PDRectangle rectangle16 = nextBead9.getRectangle();
    assertEquals(0.0f, rectangle16.getHeight());
    PDThreadBead previousBead6 = nextBead3.getPreviousBead();
    PDRectangle rectangle17 = previousBead6.getNextBead().getRectangle();
    assertEquals(0.0f, rectangle17.getHeight());
    PDThreadBead previousBead7 = nextBead5.getPreviousBead();
    PDRectangle rectangle18 = previousBead7.getNextBead().getRectangle();
    assertEquals(0.0f, rectangle18.getHeight());
    PDThreadBead previousBead8 = nextBead7.getPreviousBead();
    PDRectangle rectangle19 = previousBead8.getNextBead().getRectangle();
    assertEquals(0.0f, rectangle19.getHeight());
    PDRectangle rectangle20 = nextBead10.getRectangle();
    assertEquals(0.0f, rectangle20.getHeight());
    PDRectangle rectangle21 = nextBead11.getRectangle();
    assertEquals(0.0f, rectangle21.getHeight());
    PDThreadBead previousBead9 = previousBead3.getPreviousBead();
    PDRectangle rectangle22 = previousBead9.getNextBead().getRectangle();
    assertEquals(0.0f, rectangle22.getHeight());
    PDThreadBead previousBead10 = previousBead4.getPreviousBead();
    PDRectangle rectangle23 = previousBead10.getNextBead().getRectangle();
    assertEquals(0.0f, rectangle23.getHeight());
    PDThreadBead previousBead11 = previousBead5.getPreviousBead();
    PDRectangle rectangle24 = previousBead11.getNextBead().getRectangle();
    assertEquals(0.0f, rectangle24.getHeight());
    PDRectangle rectangle25 = previousBead.getRectangle();
    assertEquals(0.0f, rectangle25.getHeight());
    PDRectangle rectangle26 = previousBead2.getRectangle();
    assertEquals(0.0f, rectangle26.getHeight());
    PDRectangle rectangle27 = previousBead3.getRectangle();
    assertEquals(0.0f, rectangle27.getHeight());
    PDRectangle rectangle28 = previousBead6.getRectangle();
    assertEquals(0.0f, rectangle28.getHeight());
    PDRectangle rectangle29 = nextBead4.getPreviousBead().getRectangle();
    assertEquals(0.0f, rectangle29.getHeight());
    PDRectangle rectangle30 = nextBead6.getPreviousBead().getRectangle();
    assertEquals(0.0f, rectangle30.getHeight());
    PDRectangle rectangle31 = nextBead8.getPreviousBead().getRectangle();
    assertEquals(0.0f, rectangle31.getHeight());
    PDRectangle rectangle32 = previousBead7.getRectangle();
    assertEquals(0.0f, rectangle32.getHeight());
    PDRectangle rectangle33 = previousBead8.getRectangle();
    assertEquals(0.0f, rectangle33.getHeight());
    PDRectangle rectangle34 = nextBead9.getPreviousBead().getRectangle();
    assertEquals(0.0f, rectangle34.getHeight());
    PDRectangle rectangle35 = nextBead10.getPreviousBead().getRectangle();
    assertEquals(0.0f, rectangle35.getHeight());
    PDRectangle rectangle36 = nextBead11.getPreviousBead().getRectangle();
    assertEquals(0.0f, rectangle36.getHeight());
    PDRectangle rectangle37 = previousBead4.getRectangle();
    assertEquals(0.0f, rectangle37.getHeight());
    PDRectangle rectangle38 = previousBead5.getRectangle();
    assertEquals(0.0f, rectangle38.getHeight());
    PDRectangle rectangle39 = previousBead9.getRectangle();
    assertEquals(0.0f, rectangle39.getHeight());
    PDRectangle rectangle40 = previousBead6.getPreviousBead().getRectangle();
    assertEquals(0.0f, rectangle40.getHeight());
    PDRectangle rectangle41 = previousBead7.getPreviousBead().getRectangle();
    assertEquals(0.0f, rectangle41.getHeight());
    PDRectangle rectangle42 = previousBead8.getPreviousBead().getRectangle();
    assertEquals(0.0f, rectangle42.getHeight());
    PDRectangle rectangle43 = previousBead10.getRectangle();
    assertEquals(0.0f, rectangle43.getHeight());
    PDRectangle rectangle44 = previousBead11.getRectangle();
    assertEquals(0.0f, rectangle44.getHeight());
    PDRectangle rectangle45 = previousBead9.getPreviousBead().getRectangle();
    assertEquals(0.0f, rectangle45.getHeight());
    PDRectangle rectangle46 = previousBead10.getPreviousBead().getRectangle();
    assertEquals(0.0f, rectangle46.getHeight());
    PDRectangle rectangle47 = previousBead11.getPreviousBead().getRectangle();
    assertEquals(0.0f, rectangle47.getHeight());
    assertEquals(0.0f, rectangle.getUpperRightX());
    assertEquals(0.0f, rectangle2.getUpperRightX());
    assertEquals(0.0f, rectangle3.getUpperRightX());
    assertEquals(0.0f, rectangle4.getUpperRightX());
    assertEquals(0.0f, rectangle5.getUpperRightX());
    assertEquals(0.0f, rectangle6.getUpperRightX());
    assertEquals(0.0f, rectangle7.getUpperRightX());
    assertEquals(0.0f, rectangle8.getUpperRightX());
    assertEquals(0.0f, rectangle9.getUpperRightX());
    assertEquals(0.0f, rectangle10.getUpperRightX());
    assertEquals(0.0f, rectangle11.getUpperRightX());
    assertEquals(0.0f, rectangle12.getUpperRightX());
    assertEquals(0.0f, rectangle13.getUpperRightX());
    assertEquals(0.0f, rectangle14.getUpperRightX());
    assertEquals(0.0f, rectangle15.getUpperRightX());
    assertEquals(0.0f, rectangle16.getUpperRightX());
    assertEquals(0.0f, rectangle17.getUpperRightX());
    assertEquals(0.0f, rectangle18.getUpperRightX());
    assertEquals(0.0f, rectangle19.getUpperRightX());
    assertEquals(0.0f, rectangle20.getUpperRightX());
    assertEquals(0.0f, rectangle21.getUpperRightX());
    assertEquals(0.0f, rectangle22.getUpperRightX());
    assertEquals(0.0f, rectangle23.getUpperRightX());
    assertEquals(0.0f, rectangle24.getUpperRightX());
    assertEquals(0.0f, rectangle25.getUpperRightX());
    assertEquals(0.0f, rectangle26.getUpperRightX());
    assertEquals(0.0f, rectangle27.getUpperRightX());
    assertEquals(0.0f, rectangle28.getUpperRightX());
    assertEquals(0.0f, rectangle29.getUpperRightX());
    assertEquals(0.0f, rectangle30.getUpperRightX());
    assertEquals(0.0f, rectangle31.getUpperRightX());
    assertEquals(0.0f, rectangle32.getUpperRightX());
    assertEquals(0.0f, rectangle33.getUpperRightX());
    assertEquals(0.0f, rectangle34.getUpperRightX());
    assertEquals(0.0f, rectangle35.getUpperRightX());
    assertEquals(0.0f, rectangle36.getUpperRightX());
    assertEquals(0.0f, rectangle37.getUpperRightX());
    assertEquals(0.0f, rectangle38.getUpperRightX());
    assertEquals(0.0f, rectangle39.getUpperRightX());
    assertEquals(0.0f, rectangle40.getUpperRightX());
    assertEquals(0.0f, rectangle41.getUpperRightX());
    assertEquals(0.0f, rectangle42.getUpperRightX());
    assertEquals(0.0f, rectangle43.getUpperRightX());
    assertEquals(0.0f, rectangle44.getUpperRightX());
    assertEquals(0.0f, rectangle45.getUpperRightX());
    assertEquals(0.0f, rectangle46.getUpperRightX());
    assertEquals(0.0f, rectangle47.getUpperRightX());
    assertEquals(0.0f, rectangle.getUpperRightY());
    assertEquals(0.0f, rectangle2.getUpperRightY());
    assertEquals(0.0f, rectangle3.getUpperRightY());
    assertEquals(0.0f, rectangle4.getUpperRightY());
    assertEquals(0.0f, rectangle5.getUpperRightY());
    assertEquals(0.0f, rectangle6.getUpperRightY());
    assertEquals(0.0f, rectangle7.getUpperRightY());
    assertEquals(0.0f, rectangle8.getUpperRightY());
    assertEquals(0.0f, rectangle9.getUpperRightY());
    assertEquals(0.0f, rectangle10.getUpperRightY());
    assertEquals(0.0f, rectangle11.getUpperRightY());
    assertEquals(0.0f, rectangle12.getUpperRightY());
    assertEquals(0.0f, rectangle13.getUpperRightY());
    assertEquals(0.0f, rectangle14.getUpperRightY());
    assertEquals(0.0f, rectangle15.getUpperRightY());
    assertEquals(0.0f, rectangle16.getUpperRightY());
    assertEquals(0.0f, rectangle17.getUpperRightY());
    assertEquals(0.0f, rectangle18.getUpperRightY());
    assertEquals(0.0f, rectangle19.getUpperRightY());
    assertEquals(0.0f, rectangle20.getUpperRightY());
    assertEquals(0.0f, rectangle21.getUpperRightY());
    assertEquals(0.0f, rectangle22.getUpperRightY());
    assertEquals(0.0f, rectangle23.getUpperRightY());
    assertEquals(0.0f, rectangle24.getUpperRightY());
    assertEquals(0.0f, rectangle25.getUpperRightY());
    assertEquals(0.0f, rectangle26.getUpperRightY());
    assertEquals(0.0f, rectangle27.getUpperRightY());
    assertEquals(0.0f, rectangle28.getUpperRightY());
    assertEquals(0.0f, rectangle29.getUpperRightY());
    assertEquals(0.0f, rectangle30.getUpperRightY());
    assertEquals(0.0f, rectangle31.getUpperRightY());
    assertEquals(0.0f, rectangle32.getUpperRightY());
    assertEquals(0.0f, rectangle33.getUpperRightY());
    assertEquals(0.0f, rectangle34.getUpperRightY());
    assertEquals(0.0f, rectangle35.getUpperRightY());
    assertEquals(0.0f, rectangle36.getUpperRightY());
    assertEquals(0.0f, rectangle37.getUpperRightY());
    assertEquals(0.0f, rectangle38.getUpperRightY());
    assertEquals(0.0f, rectangle39.getUpperRightY());
    assertEquals(0.0f, rectangle40.getUpperRightY());
    assertEquals(0.0f, rectangle41.getUpperRightY());
    assertEquals(0.0f, rectangle42.getUpperRightY());
    assertEquals(0.0f, rectangle43.getUpperRightY());
    assertEquals(0.0f, rectangle44.getUpperRightY());
    assertEquals(0.0f, rectangle45.getUpperRightY());
    assertEquals(0.0f, rectangle46.getUpperRightY());
    assertEquals(0.0f, rectangle47.getUpperRightY());
    assertEquals(0.0f, rectangle.getWidth());
    assertEquals(0.0f, rectangle2.getWidth());
    assertEquals(0.0f, rectangle3.getWidth());
    assertEquals(0.0f, rectangle4.getWidth());
    assertEquals(0.0f, rectangle5.getWidth());
    assertEquals(0.0f, rectangle6.getWidth());
    assertEquals(0.0f, rectangle7.getWidth());
    assertEquals(0.0f, rectangle8.getWidth());
    assertEquals(0.0f, rectangle9.getWidth());
    assertEquals(0.0f, rectangle10.getWidth());
    assertEquals(0.0f, rectangle11.getWidth());
    assertEquals(0.0f, rectangle12.getWidth());
    assertEquals(0.0f, rectangle13.getWidth());
    assertEquals(0.0f, rectangle14.getWidth());
    assertEquals(0.0f, rectangle15.getWidth());
    assertEquals(0.0f, rectangle16.getWidth());
    assertEquals(0.0f, rectangle17.getWidth());
    assertEquals(0.0f, rectangle18.getWidth());
    assertEquals(0.0f, rectangle19.getWidth());
    assertEquals(0.0f, rectangle20.getWidth());
    assertEquals(0.0f, rectangle21.getWidth());
    assertEquals(0.0f, rectangle22.getWidth());
    assertEquals(0.0f, rectangle23.getWidth());
    assertEquals(0.0f, rectangle24.getWidth());
    assertEquals(0.0f, rectangle25.getWidth());
    assertEquals(0.0f, rectangle26.getWidth());
    assertEquals(0.0f, rectangle27.getWidth());
    assertEquals(0.0f, rectangle28.getWidth());
    assertEquals(0.0f, rectangle29.getWidth());
    assertEquals(0.0f, rectangle30.getWidth());
    assertEquals(0.0f, rectangle31.getWidth());
    assertEquals(0.0f, rectangle32.getWidth());
    assertEquals(0.0f, rectangle33.getWidth());
    assertEquals(0.0f, rectangle34.getWidth());
    assertEquals(0.0f, rectangle35.getWidth());
    assertEquals(0.0f, rectangle36.getWidth());
    assertEquals(0.0f, rectangle37.getWidth());
    assertEquals(0.0f, rectangle38.getWidth());
    assertEquals(0.0f, rectangle39.getWidth());
    assertEquals(0.0f, rectangle40.getWidth());
    assertEquals(0.0f, rectangle41.getWidth());
    assertEquals(0.0f, rectangle42.getWidth());
    assertEquals(0.0f, rectangle43.getWidth());
    assertEquals(0.0f, rectangle44.getWidth());
    assertEquals(0.0f, rectangle45.getWidth());
    assertEquals(0.0f, rectangle46.getWidth());
    assertEquals(0.0f, rectangle47.getWidth());
  }
}

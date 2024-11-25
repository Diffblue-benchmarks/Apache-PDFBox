package org.apache.pdfbox.examples.pdmodel;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PrintBookmarksDiffblueTest {
  /**
   * Test {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}.
   * <ul>
   *   <li>Then calls {@link PDOutlineNode#addLast(PDOutlineItem)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}
   */
  @Test
  @DisplayName("Test printBookmark(PDDocument, PDOutlineNode, String); then calls addLast(PDOutlineItem)")
  void testPrintBookmark_thenCallsAddLast() throws IOException {
    // Arrange
    PrintBookmarks printBookmarks = new PrintBookmarks();
    PDDocument document = new PDDocument();
    PDOutlineNode bookmark = mock(PDOutlineNode.class);
    when(bookmark.getFirstChild()).thenReturn(new PDOutlineItem());
    doNothing().when(bookmark).addLast(Mockito.<PDOutlineItem>any());
    bookmark.addLast(new PDOutlineItem());

    // Act
    printBookmarks.printBookmark(document, bookmark, "Indentation");

    // Assert that nothing has changed
    verify(bookmark).addLast(isA(PDOutlineItem.class));
    verify(bookmark).getFirstChild();
  }
}

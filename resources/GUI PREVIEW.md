# GUI PREVIEW CLARIFICATION

***

## This image file provides a preview of what the G.U.I. will look like when you enter the program.

Each component is color-coded. It represents the different levels of nesting. It colors from red to purple. While I only used Red-Dark Green in this example, it definitely can and maybe will go further.

Below is the clarification for each. This goes from right to left, up to down, as if reading a book.

### COMPONENTS ARE:

* CollectionFrame : JFrame
    * CollectionPanel : JPanel
        * CollectionView : JTable
        * CollectionProgress : JProgressBar
    * ItemPanel : JPanel
        * ImagePanel : JPanel
        * DescriptionPanel : JPanel
            * TitleField : JTextField
            * DescriptionArea : JTextArea
            * CollectedButton : JButton
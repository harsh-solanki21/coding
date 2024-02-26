package LowLevelDesign.SOLID.SingleResponsibility.good;

public class BoardPresenter {

    Board board;

    public BoardPresenter(Board board) {
        this.board = board;
    }

    public void displayBoard() {
        StringBuilder formattedBoard = new StringBuilder();

        for (int i = 0; i < this.board.size * this.board.size; i++) {
            StringBuilder borderOrNewline = new StringBuilder();

            if ((i + 1) % board.size == 0) {
                borderOrNewline.append("\n");
            } else {
                borderOrNewline.append("|");
            }

            formattedBoard.append(board.spots.get(i));
            formattedBoard.append(borderOrNewline);
        }

        System.out.print(formattedBoard);
    }

}

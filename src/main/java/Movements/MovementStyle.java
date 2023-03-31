package Movements;

import Board.*;

public interface MovementStyle {
    public boolean canMove(Spot end , Board board);

}

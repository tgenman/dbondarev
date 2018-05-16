package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

/**
 * Move of rectangle.
 */
public class RectangleMove implements Runnable {
    private final Rectangle rect;
    private Direction horisontalDirection = Direction.RIGHT;
    private Direction verticalDirection = Direction.UP;

    /**
     * Constructor.
     * @param rect rectangle to move.
     */
    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        while (true) {
            this.doMove();
            this.doCheckDirection();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void doMove() {
        if (horisontalDirection == Direction.RIGHT)   this.rect.setX(this.rect.getX() + 1);
        if (horisontalDirection == Direction.LEFT)    this.rect.setX(this.rect.getX() - 1);
        if (verticalDirection == Direction.UP)        this.rect.setY(this.rect.getY() + 1);
        if (verticalDirection == Direction.DOWN)      this.rect.setY(this.rect.getY() - 1);
    }

    private void doCheckDirection() {
        if (this.rect.getX() == 300)                  horisontalDirection = Direction.LEFT;
        if (this.rect.getX() == 0)                    horisontalDirection = Direction.RIGHT;
        if (this.rect.getY() == 300)                  verticalDirection   = Direction.DOWN;
        if (this.rect.getY() == 0)                    verticalDirection   = Direction.UP;
    }

    /**
     * Direction of moving ball.
     */
    private enum Direction {
        LEFT, RIGHT, UP, DOWN;
    }
}


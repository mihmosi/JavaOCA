//package day0.JmProjects;
//
//public class TestRobot {
//    public static void main(String[] args) {
//
//    }
//
//    /**
//     * На игровом поле находится робот. Позиция робота на поле описывается двумя
//     * целочисленным координатами: X и Y. Ось X смотрит слева направо, ось Y - снизу вверх.
//     * (Помните, как рисовали графики функций в школе?)
//     * <p>
//     * В начальный момент робот находится в некоторой позиции на поле. Также известно,
//     * куда робот смотрит: вверх, вниз, направо или налево. Ваша задача — привести робота
//     * в заданную точку игрового поля.
//     * <p>
//     * Робот описывается классом Robot. Вы можете пользоваться следующими его методами
//     * (реализация вам неизвестна):
//     * В метод передано: toX == 3, toY == 0; начальное состояние робота такое:
//     * robot.getX() == 0, robot.getY() == 0, robot.getDirection() == Direction.UP
//     * <p>
//     * Чтобы привести робота в указанную точку (3, 0), метод должен вызвать у робота следующие методы:
//     */
//
//    public static void moveRobot(Robot robot, int toX, int toY) {
//        int currentX = robot.getX();
//        int currentY = robot.getX();
//        if (toX > robot.getX()) {
//            while (robot.getDirection() != Direction.RIGHT) {
//                robot.turnRight();
//            }
//            while (toX != currentX) {
//                robot.stepForward();
//                currentX++;
//            }
//        } else {
//            while (robot.getDirection() != Direction.LEFT) {
//                robot.turnRight();
//            }
//            while (toX != currentX) {
//                robot.stepForward();
//                currentX--;
//            }
//        }
//        if (toY > robot.getY()) {
//            while (robot.getDirection() != Direction.UP) {
//                robot.turnRight();
//            }
//            while (toY != currentY) {
//                robot.stepForward();
//                currentY++;
//            }
//        } else {
//            while (robot.getDirection() != Direction.DOWN) {
//                robot.turnRight();
//            }
//            while (toY != currentY) {
//                robot.stepForward();
//                currentY--;
//            }
//        }
//    }
//
//    public enum Direction {
//        UP,
//        DOWN,
//        LEFT,
//        RIGHT
//    }
//
//    public class Robot {
//
//        public Direction getDirection() {
//            // текущее направление взгляда
//        }
//
//        public int getX() {
//            // текущая координата X
//        }
//
//        public int getY() {
//            // текущая координата Y
//        }
//
//        public void turnLeft() {
//            // повернуться на 90 градусов против часовой стрелки
//        }
//
//        public void turnRight() {
//            // повернуться на 90 градусов по часовой стрелке
//        }
//
//        public void stepForward() {
//            // шаг в направлении взгляда
//            // за один шаг робот изменяет одну свою координату на единицу
//        }
//    }
//}

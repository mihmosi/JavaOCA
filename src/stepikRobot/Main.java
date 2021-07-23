package stepikRobot;

import java.util.Random;

public class Main implements RobotConnection, RobotConnectionManager {
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        RobotConnection robotconnection = robotConnectionManager.getConnection();
        try {
            robotConnectionManager.getConnection();
            robotconnection.moveRobotTo(toX, toY);
        } catch (RobotConnectionException e1) {
            try {
                robotconnection.close();
            } catch (RobotConnectionException e11) {
            }
        }
        try {
            robotConnectionManager.getConnection();
            robotconnection.moveRobotTo(toX, toY);
        } catch (RobotConnectionException e2) {
            try {
                robotconnection.close();
            } catch (RobotConnectionException e21) {
            }
        }
        try {
            robotConnectionManager.getConnection();
            robotconnection.moveRobotTo(toX, toY);
        } catch (RobotConnectionException e3) {
            throw new RobotConnectionException("e3");
        } finally {
            robotconnection.close();
            try {
            } catch (Exception er) {
            }
        }
    }

    public static void main(String[] args) {
        RobotConnectionManager rcm = new RobotConnectionManager() {
            @Override
            public RobotConnection getConnection() {
                return new RobotConnection() {
                    @Override
                    public void moveRobotTo(int x, int y) {
                        System.out.println(x + ":" + y);
                        if (new Random().nextInt(50) > 25) throw new RobotConnectionException("connection failed");
                    }

                    @Override
                    public void close() {
                    }
                };
            }
        };
        moveRobot(rcm, 51, 39);
    }

    @Override
    public void moveRobotTo(int x, int y) {
        System.out.println("");

    }

    @Override
    public void close() {

    }

    @Override
    public RobotConnection getConnection() {
        return null;
    }
}

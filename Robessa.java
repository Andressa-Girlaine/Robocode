package Robessa;

import robocode.*;
import robocode.util.Utils;
import java.awt.Color;
import java.util.Random;

public class Robessa extends AdvancedRobot {

    private Random random = new Random();
    private double campoLargura;
    private double campoAltura;

    public void run() {
        campoLargura = getBattleFieldWidth();
        campoAltura = getBattleFieldHeight();
       
        setColors(Color.blue, Color.red, Color.yellow);
        while (true) {

            double centroX = campoLargura / 2;
            double centroY = campoAltura / 2;
           

            double angulo = Math.toDegrees(Math.atan2(centroX - getX(), centroY - getY()));
           

            setTurnRight(Utils.normalRelativeAngleDegrees(angulo - getHeading()));
            execute();
           
            avancar(random.nextDouble() * 200 + 100);
        }
    }

    public void avancar(double distance) {
        setAhead(distance);
    }

    public void retroceder(double distance) {
        setBack(distance);
    }

    public void virarEsquerda(double degrees) {
        setTurnLeft(degrees);
    }

    public void virarDireita(double degrees) {
        setTurnRight(degrees);
    }

    public void onScannedRobot(ScannedRobotEvent e) {

        if (e.getDistance() < 200) {
            turnGunRight(getHeading() - getGunHeading() + e.getBearing());
            fire(3);
        }
    }
}

package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

import java.security.InvalidParameterException;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		if(speedLimit < 0 || speedLimit > 500 || controller.getReferenceSpeed()/2 > speedLimit )
		 	user.setAlarmState(true);
		else if (user.getAlarmState())
		 	user.setAlarmState(false);
		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);
	}

}

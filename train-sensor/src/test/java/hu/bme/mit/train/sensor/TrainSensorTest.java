package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.interfaces.TrainSensor;

//@RunWith(MockitoJUnitRunner.class)
public class TrainSensorTest {

    TrainSensor trainSensor;

    //@Mock
    TrainController trainController;
    //@Mock
    TrainUser trainUser;

    @Before
    public void before() {
      trainController = mock(TrainController.class);
      trainUser = mock(TrainUser.class);

      trainSensor = new TrainSensorImpl(trainController, trainUser);

      when(trainController.getReferenceSpeed()).thenReturn(150);
    }

    @Test
    public void tooLargeSpeedLimit() {
      trainSensor.overrideSpeedLimit(550);
      verify(trainUser, atLeastOnce()).setAlarmState(true);
    }

    @Test
    public void negativeSpeedLimit() {
      trainSensor.overrideSpeedLimit(-5);
      verify(trainUser, atLeastOnce()).setAlarmState(true);
    }

    @Test
    public void wrongAdaptiveSpeedLimit() {
      trainSensor.overrideSpeedLimit(50);
      verify(trainUser, atLeastOnce()).setAlarmState(true);
    }

    @Test
    public void goodSpeedLimit() {
      trainSensor.overrideSpeedLimit(130);
      verify(trainUser, never()).setAlarmState(true);
    }
}

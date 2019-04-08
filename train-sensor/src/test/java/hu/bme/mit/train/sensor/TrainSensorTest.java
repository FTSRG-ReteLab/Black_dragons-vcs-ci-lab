package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {


    @Before
    public void before() {
      TrainController trainController = mock(TrainController.class);
      TrainUser trainUser = mock(TrainUser.class);
    }

    @Test
    public void negativeSpeedLimit() {
      when(trainController.setSpeedLimit(-5)).verify(trainUser).setAlarmState("called")
    }
}

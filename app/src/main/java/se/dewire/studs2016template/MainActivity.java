package se.dewire.studs2016template;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private DewireContestConnection s = null;
    private StringBuilder sb;

    private static String GROUP_TAG = "De Fyra Vännerna och Simon";     //Change this to your group name

    private Sensor gyroscope;
    private SensorManager mSensorManager;

    int box = 0;
    int rot = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sb = new StringBuilder();

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        gyroscope = (Sensor)mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        s = new DewireContestConnection(GROUP_TAG) {
            @Override
            public void onConnectionOpened() {
                //Here you put code that will happen when the connection opens
                updateString(sb.toString());
            }

            @Override
            public void onConnectionClosed() {
                //Here you put code that will happen when the connection closes
                updateString(sb.toString());
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Register for sensor update
        mSensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_UI);
    }

    float[] inclineGravity = new float[3];
    float[] mRotation;
    float[] mGeomagnetic;
    float[] mGravity;
    float orientation[] = new float[3];
    float pitch;
    float roll;

    @Override
    public void onSensorChanged(SensorEvent event) {
        //If type is accelerometer only assign values to global property mGravity
        if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE)
        {
            mRotation = event.values;
            //Log.d("TEST", "" + mRotation[0])
            TextView tv = (TextView) findViewById(R.id.top);
            tv.setText(sb.toString());
            switch(box) {
                case 0:
                    if (mRotation[0] > rot) {
                        Log.d("TEST", "HÖGER");
                        mSensorManager.unregisterListener(this, gyroscope);
                        box = 4;
                    } else if (mRotation[0] < -rot) {
                        Log.d("TEST", "VÄNSTER");
                        mSensorManager.unregisterListener(this, gyroscope);
                        box = 1;
                    } else if (mRotation[1] > rot) {
                        Log.d("TEST", "FRAM");
                        mSensorManager.unregisterListener(this, gyroscope);
                        box = 2;
                    } else if (mRotation[1] < -rot) {
                        Log.d("TEST", "BAK");
                        mSensorManager.unregisterListener(this, gyroscope);
                        box = 3;
                    }
                    break;
                case 1:
                    if (mRotation[0] > rot) {
                        Log.d("TEST", "HÖGER");
                        mSensorManager.unregisterListener(this, gyroscope);
                        box = 8;
                    } else if (mRotation[0] < -rot) {
                        Log.d("TEST", "VÄNSTER");
                        mSensorManager.unregisterListener(this, gyroscope);
                        box = 5;
                    } else if (mRotation[1] > rot) {
                        Log.d("TEST", "FRAMÅT");
                        mSensorManager.unregisterListener(this, gyroscope);
                        box = 6;
                    } else if (mRotation[1] < -rot) {
                        Log.d("TEST", "BAKÅT");
                        mSensorManager.unregisterListener(this, gyroscope);
                        box = 7;
                    }
                    break;
                case 2:
                    if (mRotation[0] > rot) {
                        Log.d("TEST", "HÖGER");
                        mSensorManager.unregisterListener(this, gyroscope);
                        box = 12;
                    } else if (mRotation[0] < -rot) {
                        Log.d("TEST", "VÄNSTER");
                        mSensorManager.unregisterListener(this, gyroscope);
                        box = 9;
                    } else if (mRotation[1] > rot) {
                        Log.d("TEST", "FRAMÅT");
                        mSensorManager.unregisterListener(this, gyroscope);
                        box = 10;
                    } else if (mRotation[1] < -rot) {
                        Log.d("TEST", "BAKÅT");
                        mSensorManager.unregisterListener(this, gyroscope);
                        box = 11;
                    }
                    break;
                case 3:
                    if (mRotation[0] > rot) {
                        Log.d("TEST", "HÖGER");
                        mSensorManager.unregisterListener(this, gyroscope);
                        box = 16;
                    } else if (mRotation[0] < -rot) {
                        Log.d("TEST", "VÄNSTER");
                        mSensorManager.unregisterListener(this, gyroscope);
                        box = 13;
                    } else if (mRotation[1] > rot) {
                        Log.d("TEST", "FRAMÅT");
                        mSensorManager.unregisterListener(this, gyroscope);
                        box = 14;
                    } else if (mRotation[1] < -rot) {
                        Log.d("TEST", "BAKÅT");
                        mSensorManager.unregisterListener(this, gyroscope);
                        box = 15;
                    }
                    break;
                case 4:
                    if (mRotation[0] > rot) {
                        Log.d("TEST", "HÖGER");
                        mSensorManager.unregisterListener(this, gyroscope);
                        box = 20;
                    } else if (mRotation[0] < -rot) {
                        Log.d("TEST", "VÄNSTER");
                        mSensorManager.unregisterListener(this, gyroscope);
                        box = 17;
                    } else if (mRotation[1] > rot) {
                        Log.d("TEST", "FRAMÅT");
                        mSensorManager.unregisterListener(this, gyroscope);
                        box = 18;
                    } else if (mRotation[1] < -rot) {
                        Log.d("TEST", "BAKÅT");
                        mSensorManager.unregisterListener(this, gyroscope);
                        box = 19;
                    }
                    break;
                case 5:
                    if (mRotation[0] > rot) {
                        sb.append("b");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    } else if (mRotation[0] < -rot) {
                        sb.append("a");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    }
                    break;
                case 6:
                    if (mRotation[0] > rot) {
                        sb.append("d");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    } else if (mRotation[0] < -rot) {
                        sb.append("c");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    }
                    break;
                case 7:
                    if (mRotation[0] > rot) {
                        sb.append("f");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    } else if (mRotation[0] < -rot) {
                        sb.append("e");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    }
                    break;
                case 8:
                    if (mRotation[0] > rot) {
                        sb.append(" ");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    } else if (mRotation[0] < -rot) {
                        sb.append("g");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    }
                    break;
                case 9:
                    if (mRotation[0] > rot) {
                        sb.append("i");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;

                    } else if (mRotation[0] < -rot) {
                        sb.append("h");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;

                    }
                    break;
                case 10:
                    if (mRotation[0] > rot) {
                        sb.append("k");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    } else if (mRotation[0] < -rot) {
                        sb.append("j");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;

                    } else if (mRotation[1] > rot) {

                    } else if (mRotation[1] < -rot) {

                    }
                    break;
                case 11:
                    if (mRotation[0] > rot) {
                        sb.append("m");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    } else if (mRotation[0] < -rot) {
                        sb.append("l");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    } else if (mRotation[1] > rot) {

                    } else if (mRotation[1] < -rot) {

                    }
                    break;
                case 12:
                    if (mRotation[0] > rot) {

                    } else if (mRotation[0] < -rot) {
                        sb.append("n");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    } else if (mRotation[1] > rot) {

                    } else if (mRotation[1] < -rot) {

                    }
                    break;
                case 13:
                    if (mRotation[0] > rot) {
                        sb.append("p");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    } else if (mRotation[0] < -rot) {
                        sb.append("o");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    } else if (mRotation[1] > rot) {

                    } else if (mRotation[1] < -rot) {

                    }
                    break;
                case 14:
                    if (mRotation[0] > rot) {
                        sb.append("r");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    } else if (mRotation[0] < -rot) {
                        sb.append("q");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    } else if (mRotation[1] > rot) {

                    } else if (mRotation[1] < -rot) {

                    }
                    break;
                case 15:
                    if (mRotation[0] > rot) {
                        sb.append("t");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    } else if (mRotation[0] < -rot) {
                        sb.append("s");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    } else if (mRotation[1] > rot) {

                    } else if (mRotation[1] < -rot) {

                    }
                    break;
                case 16:
                    if (mRotation[0] > rot) {

                    } else if (mRotation[0] < -rot) {
                        sb.append("u");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    } else if (mRotation[1] > rot) {

                    } else if (mRotation[1] < -rot) {

                    }
                    break;
                case 17:
                    if (mRotation[0] > rot) {
                        sb.append("w");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    } else if (mRotation[0] < -rot) {
                        sb.append("v");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    } else if (mRotation[1] > rot) {

                    } else if (mRotation[1] < -rot) {

                    }
                    break;
                case 18:
                    if (mRotation[0] > rot) {
                        sb.append("y");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    } else if (mRotation[0] < -rot) {
                        sb.append("x");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;

                    } else if (mRotation[1] > rot) {

                    } else if (mRotation[1] < -rot) {

                    }
                    break;
                case 19:
                    if (mRotation[0] > rot) {
                        sb.append("å");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    } else if (mRotation[0] < -rot) {
                        sb.append("z");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    } else if (mRotation[1] > rot) {

                    } else if (mRotation[1] < -rot) {

                    }
                    break;
                case 20:
                    if (mRotation[0] > rot) {
                        sb.append("ö");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    } else if (mRotation[0] < -rot) {
                        sb.append("ä");
                        mSensorManager.unregisterListener(this, gyroscope);
                        updateString(sb.toString());
                        box = 0;
                    } else if (mRotation[1] > rot) {

                    } else if (mRotation[1] < -rot) {

                    }
                    break;
            }
            //Log.d("LANDO", "1: " + String.valueOf(mRotation[1]));
            //Log.d("LANDO", "2: " + String.valueOf(mRotation[2]));
            //Log.d("TEST", sb.toString());
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)){
            mSensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_UI);
            if (sb.toString().length() > 0) {
                Log.d("TEST", sb.toString());
            }
        } else if ((keyCode == KeyEvent.KEYCODE_VOLUME_UP)) {
            if (sb.toString().length() > 0) {
                sb.deleteCharAt(sb.toString().length() - 1);
                TextView tv = (TextView) findViewById(R.id.top);
                tv.setText(sb.toString());
                updateString(sb.toString());
            }
        }
        return true;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // TODO Auto-generated method stub

    }

    public boolean isTiltUpward()
    {
        if (mGravity != null && mGeomagnetic != null)
        {
            float R[] = new float[9];
            float I[] = new float[9];

            boolean success = SensorManager.getRotationMatrix(R, I, mGravity, mGeomagnetic);

            if (success)
            {
                float orientation[] = new float[3];
                SensorManager.getOrientation(R, orientation);

                /*
                * If the roll is positive, you're in reverse landscape (landscape right), and if the roll is negative you're in landscape (landscape left)
                *
                * Similarly, you can use the pitch to differentiate between portrait and reverse portrait.
                * If the pitch is positive, you're in reverse portrait, and if the pitch is negative you're in portrait.
                *
                * orientation -> azimut, pitch and roll
                *
                *
                */

                pitch = orientation[1];
                roll = orientation[2];

                inclineGravity = mGravity.clone();

                double norm_Of_g = Math.sqrt(inclineGravity[0] * inclineGravity[0] + inclineGravity[1] * inclineGravity[1] + inclineGravity[2] * inclineGravity[2]);

                // Normalize the accelerometer vector
                inclineGravity[0] = (float) (inclineGravity[0] / norm_Of_g);
                inclineGravity[1] = (float) (inclineGravity[1] / norm_Of_g);
                inclineGravity[2] = (float) (inclineGravity[2] / norm_Of_g);

                //Checks if device is flat on ground or not
                int inclination = (int) Math.round(Math.toDegrees(Math.acos(inclineGravity[2])));

                /*
                * Float obj1 = new Float("10.2");
                * Float obj2 = new Float("10.20");
                * int retval = obj1.compareTo(obj2);
                *
                * if(retval > 0) {
                * System.out.println("obj1 is greater than obj2");
                * }
                * else if(retval < 0) {
                * System.out.println("obj1 is less than obj2");
                * }
                * else {
                * System.out.println("obj1 is equal to obj2");
                * }
                */
                Float objPitch = new Float(pitch);
                Float objZero = new Float(0.0);
                Float objZeroPointTwo = new Float(0.2);
                Float objZeroPointTwoNegative = new Float(-0.2);

                int objPitchZeroResult = objPitch.compareTo(objZero);
                int objPitchZeroPointTwoResult = objZeroPointTwo.compareTo(objPitch);
                int objPitchZeroPointTwoNegativeResult = objPitch.compareTo(objZeroPointTwoNegative);

                if (roll < 0 && ((objPitchZeroResult > 0 && objPitchZeroPointTwoResult > 0) || (objPitchZeroResult < 0 && objPitchZeroPointTwoNegativeResult > 0)) && (inclination > 30 && inclination < 40))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }

        return false;
    }

    public boolean isTiltDownward()
    {
        if (mGravity != null && mGeomagnetic != null)
        {
            float R[] = new float[9];
            float I[] = new float[9];

            boolean success = SensorManager.getRotationMatrix(R, I, mGravity, mGeomagnetic);

            if (success)
            {
                float orientation[] = new float[3];
                SensorManager.getOrientation(R, orientation);

                pitch = orientation[1];
                roll = orientation[2];

                inclineGravity = mGravity.clone();

                double norm_Of_g = Math.sqrt(inclineGravity[0] * inclineGravity[0] + inclineGravity[1] * inclineGravity[1] + inclineGravity[2] * inclineGravity[2]);

                // Normalize the accelerometer vector
                inclineGravity[0] = (float) (inclineGravity[0] / norm_Of_g);
                inclineGravity[1] = (float) (inclineGravity[1] / norm_Of_g);
                inclineGravity[2] = (float) (inclineGravity[2] / norm_Of_g);

                //Checks if device is flat on groud or not
                int inclination = (int) Math.round(Math.toDegrees(Math.acos(inclineGravity[2])));

                Float objPitch = new Float(pitch);
                Float objZero = new Float(0.0);
                Float objZeroPointTwo = new Float(0.2);
                Float objZeroPointTwoNegative = new Float(-0.2);

                int objPitchZeroResult = objPitch.compareTo(objZero);
                int objPitchZeroPointTwoResult = objZeroPointTwo.compareTo(objPitch);
                int objPitchZeroPointTwoNegativeResult = objPitch.compareTo(objZeroPointTwoNegative);

                if (roll < 0 && ((objPitchZeroResult > 0 && objPitchZeroPointTwoResult > 0) || (objPitchZeroResult < 0 && objPitchZeroPointTwoNegativeResult > 0)) && (inclination > 140 && inclination < 170))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }

        return false;
    }

    public void updateString(String str){
        if(s!=null && s.isConnected()){
            s.sendMessage(str);
        }
    }


    public void killapp(){
        s.disconnect();
        this.finish();
    }
}

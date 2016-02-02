package com.example.wordquizgame;

/**
 * Created by chitchy on 2/2/2559.
 */
public class MyModel {

    private int timesAnInt;

    public interface OnMyModelChangeListener {
        void  onMyModelChangeListener(MyModel myModel);
    }
private OnMyModelChangeListener objOnMyModelChangeListener;

    public void setObjOnMyModelChangeListener(OnMyModelChangeListener objOnMyModelChangeListener) {
        this.objOnMyModelChangeListener = objOnMyModelChangeListener;
    }

    public int getTimesAnInt() {
        return timesAnInt;
    }

    public void setTimesAnInt(int timesAnInt) {
        this.timesAnInt = timesAnInt;

        if (this.objOnMyModelChangeListener != null){
            this.objOnMyModelChangeListener.onMyModelChangeListener(this);

        }
    }
}

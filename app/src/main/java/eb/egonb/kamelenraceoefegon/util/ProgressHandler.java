package eb.egonb.kamelenraceoefegon.util;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;

public class ProgressHandler extends Handler {

    private ProgressBar pbKameel1, pbKameel2, pbKameel3;

    public ProgressHandler(ProgressBar pbKameel1) {
        this.pbKameel1 = pbKameel1;
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);

        int value = msg.arg1;

        if(Build.VERSION.SDK_INT >= 25){
            pbKameel1.setProgress(value, true);
        } else{
            pbKameel1.setProgress(value);
        }
    }
}

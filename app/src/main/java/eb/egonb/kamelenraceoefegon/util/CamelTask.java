package eb.egonb.kamelenraceoefegon.util;

import android.os.AsyncTask;
import android.widget.ProgressBar;

import java.lang.ref.WeakReference;
import java.util.Random;

public class CamelTask extends AsyncTask<Void, Integer, Void> {

    private WeakReference<ProgressBar> pb;

    public CamelTask(ProgressBar pb) {
        this.pb = new WeakReference<>(pb);
    }

    @Override
    protected Void doInBackground(Void... voids) {

        Random rand = new Random();

        for(int i = 0; i <= 20; i++){
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            publishProgress(i);
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        pb.get().setProgress(values[0]);

    }
}

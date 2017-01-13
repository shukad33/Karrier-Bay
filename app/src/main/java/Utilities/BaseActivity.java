package Utilities;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;

import RetroGit.ApiClient;
import RetroGit.ApiInterface;

/**
 * Created by nirmal.ku on 11/7/2016.
 */
public class BaseActivity extends Activity {

    protected Typeface mTfRegular;
    protected Typeface mTfBold;
    protected Typeface mTfSemiBold;
    protected ApiInterface apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTfRegular = Typeface.createFromAsset(getAssets(), "OpenSans-Regular.ttf");
        mTfBold = Typeface.createFromAsset(getAssets(),"OpenSans-Bold.ttf");
        mTfSemiBold = Typeface.createFromAsset(getAssets(),"OpenSans-Semibold.ttf");

        apiService = ApiClient.getClient().create(ApiInterface.class);
    }
}

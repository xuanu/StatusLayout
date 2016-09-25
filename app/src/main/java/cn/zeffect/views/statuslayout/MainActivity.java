package cn.zeffect.views.statuslayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.zeffect.views.statelayout.StateLayout;

public class MainActivity extends AppCompatActivity {
    int postion = 0;
    StateLayout mState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mState = (StateLayout) findViewById(R.id.statelayout);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (postion) {
                    case 0:
                        mState.showEmptyView();
                        break;
                    case 1:
                        mState.showErrorView();
                        break;
                    case 2:
                        mState.showLoadingView();
                        break;
                    case 3:
                        mState.showNoNetView();
                        break;
                    case 4:
                        mState.showContentView();
                        break;
                }
                postion++;
                if (postion > 4) {
                    postion = 0;
                }
            }
        });
    }
}

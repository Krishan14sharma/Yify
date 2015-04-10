package mvp.dagger.yify.yify.ui.login;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import mvp.dagger.yify.yify.R;
import mvp.dagger.yify.yify.ui.common.BaseToolBarActivity;

public class LoginActivity extends BaseToolBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new LoginFragment())
                    .commit();
        }
    }


}

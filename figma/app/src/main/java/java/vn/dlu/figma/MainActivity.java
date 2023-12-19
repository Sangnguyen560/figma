package java.vn.dlu.figma;

import static androidx.core.content.ContextCompat.startActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_char);

        // Set click listeners for views with specific IDs in the current layout
        setClickListenerForViews(findViewById(android.R.id.content), R.id.kh_m_ph_, R.id.b__s_u_t_p,
                R.id.shopping_cart,R.id.notifications_active,R.id.dacnhantam,R.id.trang_ch_,R.id.cat);

    }

    private void setClickListenerForViews(View view, int... viewIds) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                setClickListenerForViews(viewGroup.getChildAt(i), viewIds);
            }
        } else {
            for (int viewId : viewIds) {
                View targetView = view.findViewById(viewId);
                if (targetView != null) {
                    targetView.setOnClickListener(this);
                }
            }
        }
    }

    private void handleCommonFunctionality(int viewId) {
        if (viewId == R.id.kh_m_ph_) {
            startNewActivity(ExplorCharActivity.class);
        } if (viewId == R.id.b__s_u_t_p) {
            startNewActivity(coletion.class);
        }if (viewId == R.id.shopping_cart) {
            startNewActivity(giohang.class);}
        if (viewId == R.id.notifications_active) {
            startNewActivity(notification.class);}
        if (viewId == R.id.dacnhantam) {
            startNewActivity(product.class);}
        if (viewId == R.id.cat) {
            startNewActivity(produc2.class);}
        else if (viewId == R.id.trang_ch_) {
            startNewActivity(MainActivity.class);}

    }



    private void startNewActivity(Class<?> destinationClass) {
        startActivity(new Intent(MainActivity.this, destinationClass));
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }

    @Override
    public void onClick(View view) {
        handleCommonFunctionality(view.getId());
    }
}


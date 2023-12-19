package java.vn.dlu.figma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

public class notification extends AppCompatActivity  implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

        // Set click listeners for views with specific IDs in the current layout
        setClickListenerForViews(findViewById(android.R.id.content), R.id.kh_m_ph_, R.id.b__s_u_t_p,
                R.id.shopping_cart, R.id.notifications_active, R.id.cl_like,R.id.trang_ch_);
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
        }
        if (viewId == R.id.b__s_u_t_p) {
            startNewActivity(coletion.class);
        }
        if (viewId == R.id.shopping_cart) {
            startNewActivity(giohang.class);
        }
        if (viewId == R.id.notifications_active) {
            startNewActivity(notification.class);
        } if (viewId == R.id.cl_like) {
            startNewActivity(coletion2.class);
        }else if (viewId == R.id.trang_ch_) {
            startNewActivity(MainActivity.class);
        }

    }


    private void startNewActivity(Class<?> destinationClass) {
        startActivity(new Intent(notification.this, destinationClass));
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }

    @Override
    public void onClick(View view) {
        handleCommonFunctionality(view.getId());
    }
}

package java.vn.dlu.figma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

public class product extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product);

        // Set click listeners for views with specific IDs in the current layout
        setClickListenerForViews(findViewById(android.R.id.content), R.id.kh_m_ph_, R.id.b__s_u_t_p,
                R.id.read,R.id.buy ,R.id.dacnhantam,R.id.back);
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
        if (viewId == R.id.buy) {
            startNewActivity(thanhtoan.class);}
        if (viewId == R.id.read) {
            startNewActivity(art.class);}
        else if (viewId == R.id.back) {
            startNewActivity(MainActivity.class);}

    }


    private void startNewActivity(Class<?> destinationClass) {
        startActivity(new Intent(product.this, destinationClass));
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }

    @Override
    public void onClick(View view) {
        handleCommonFunctionality(view.getId());
    }}
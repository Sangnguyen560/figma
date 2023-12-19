package java.vn.dlu.figma;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

public class signin extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        // Set click listeners for views with specific IDs in the current layout
        setClickListenerForViews(findViewById(android.R.id.content),R.id.txtChactikho,R.id.btnngNhp,R.id.imageArrowleft);
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
        if (viewId == R.id.btnngNhp) {
            startNewActivity(MainActivity.class);}
        if (viewId == R.id.txtChactikho) {
            startNewActivity(signup.class);}
        if (viewId == R.id.imageArrowleft) {
            startNewActivity(signup.class);}

    }


    private void startNewActivity(Class<?> destinationClass) {
        startActivity(new Intent(signin.this, destinationClass));
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }

    @Override
    public void onClick(View view) {
        handleCommonFunctionality(view.getId());
    }}

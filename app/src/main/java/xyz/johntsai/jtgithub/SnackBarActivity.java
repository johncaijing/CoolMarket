package xyz.johntsai.jtgithub;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.BindColor;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by JohnTsai on 16/2/1.
 */
public class SnackBarActivity extends AppCompatActivity{

    @Bind(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    @BindColor(R.color.colorPrimary)
    int actionTextColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle("Snackbar");
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setDisplayShowHomeEnabled(true);
    }

    @OnClick(R.id.showIndefinite) void showIndefinite(){
        showSnackbar(Snackbar.LENGTH_INDEFINITE,R.string.snackbar_action)
                .setAction("dismiss now", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                }).show();
    }

    @OnClick(R.id.showShort) void showShort(){
        showSnackbar(Snackbar.LENGTH_SHORT, R.string.snackbar_short).show();
    }

    @OnClick(R.id.showLong) void showLong(){
        showSnackbar(Snackbar.LENGTH_LONG,R.string.snackbar_long).show();
    }

    @OnClick(R.id.showAction) void showAction(){
        showSnackbar(Snackbar.LENGTH_LONG,R.string.snackbar_action)
               .setAction("finish Activity", new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       finish();
                   }
               }).show();
    }

    @OnClick(R.id.customColor)
    void customColor(){
        Snackbar snackbar = showSnackbar(Snackbar.LENGTH_LONG, R.string.snackbar_color)
                .setActionTextColor(actionTextColor)
                .setAction("ActionText", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
        //改变Snackbar文本的颜色
        View view = snackbar.getView();
        TextView textView = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private Snackbar showSnackbar(int time,int strId){
        return Snackbar.make(coordinatorLayout,getString(strId),time);
    }
}

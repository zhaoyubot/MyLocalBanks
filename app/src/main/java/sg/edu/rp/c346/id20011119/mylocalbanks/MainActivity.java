package sg.edu.rp.c346.id20011119.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS, tvOCBC, tvUOB;
    String wordClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        registerForContextMenu(tvDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        registerForContextMenu(tvOCBC);
        tvUOB = findViewById(R.id.textViewUOB);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1,1,"Contact the Bank");
        menu.add(0,2,2,"Toggle Favourite");

        if (v == tvDBS){
            wordClicked = "DBS";
        }
        else if (v == tvOCBC){
            wordClicked = "OCBC";
        }
        else if (v == tvUOB){
            wordClicked = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == 0){
            Toast.makeText(MainActivity.this, "Website Selected",Toast.LENGTH_LONG);
            if (wordClicked.equalsIgnoreCase("DBS")){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com/default.page"));
                startActivity(intent);

            }
            else if (wordClicked.equalsIgnoreCase("OCBC")){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com/personal-banking"));
                startActivity(intent);
            }
            else if(wordClicked.equalsIgnoreCase("UOB")){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uobgroup.com/uobgroup/index.page"));
                startActivity(intent);
            }
        }
        else if (item.getItemId() == 1){
            Toast.makeText(MainActivity.this, "Contact The Bank Selected", Toast.LENGTH_LONG);
            if (wordClicked.equalsIgnoreCase("DBS")){
                Intent intentReceive = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + "1800 111 1111 "));
                startActivity(intentReceive);

            }
            else if (wordClicked.equalsIgnoreCase("OCBC")){
                Intent intentReceive = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + "1800 363 3333"));
                startActivity(intentReceive);
            }
            else if(wordClicked.equalsIgnoreCase("UOB")){
                Intent intentReceive = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + "1800 222 2121"));
                startActivity(intentReceive);
            }
        }
        else if(item.getItemId() == 2){
            if (wordClicked.equalsIgnoreCase("DBS")) {
                if (tvDBS.getCurrentTextColor() == Color.BLACK) {
                    tvDBS.setTextColor(Color.CYAN);
                }
                else if (tvDBS.getCurrentTextColor() == Color.CYAN){
                    tvDBS.setTextColor(Color.BLACK);
                }
            }
            else if (wordClicked.equalsIgnoreCase("OCBC")){
                if (tvOCBC.getCurrentTextColor() == Color.BLACK) {
                    tvOCBC.setTextColor(Color.CYAN);
                }
                else if (tvOCBC.getCurrentTextColor() == Color.CYAN){
                    tvOCBC.setTextColor(Color.BLACK);
                }
            }
            else if(wordClicked.equalsIgnoreCase("UOB")){
                if (tvUOB.getCurrentTextColor() == Color.BLACK) {
                    tvUOB.setTextColor(Color.CYAN);
                }
                else if (tvUOB.getCurrentTextColor() == Color.CYAN){
                    tvUOB.setTextColor(Color.BLACK);
                }
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.englishSelection){
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
        }
        else if (item.getItemId() == R.id.chineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
        }
        return super.onOptionsItemSelected(item);
    }
}

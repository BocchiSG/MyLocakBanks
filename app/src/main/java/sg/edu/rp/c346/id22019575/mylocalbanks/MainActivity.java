package sg.edu.rp.c346.id22019575.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedText, tvTranslatedText2, tvTranslatedText3;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText = findViewById(R.id.textView);
        tvTranslatedText2 = findViewById(R.id.textView2);
        tvTranslatedText3 = findViewById(R.id.textView3);
        registerForContextMenu(tvTranslatedText);
        registerForContextMenu(tvTranslatedText2);
        registerForContextMenu(tvTranslatedText3);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvTranslatedText.setText("DBS");
            tvTranslatedText2.setText("OCBC");
            tvTranslatedText3.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvTranslatedText.setText("星展银行");
            tvTranslatedText2.setText("华侨银行");
            tvTranslatedText3.setText("大华银行");
            return true;
        } else {
            tvTranslatedText.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == tvTranslatedText) {
            wordClicked = "DBS";
        } else if (v == tvTranslatedText2) {
            wordClicked = "OCBC";
        } else if (v == tvTranslatedText3) {
            wordClicked = "UOB";
        }

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ 1111111));
                startActivity(intent);

                return true;  //menu item successfully handled
            }
            return super.onContextItemSelected(item); //pass menu item to the superclass implementation
        } else if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ 3633333));
                startActivity(intent);

                return true;  //menu item successfully handled
            }
            return super.onContextItemSelected(item); //pass menu item to the superclass implementation
        } else if (wordClicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+2222121));
                startActivity(intent);

                return true;  //menu item successfully handled
            }
            return super.onContextItemSelected(item); //pass menu item to the superclass implementation
        }
        return false;
    }


}

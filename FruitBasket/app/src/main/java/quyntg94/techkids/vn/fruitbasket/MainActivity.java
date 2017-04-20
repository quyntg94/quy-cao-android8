package quyntg94.techkids.vn.fruitbasket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView ivFruit1;
    ImageView ivFruit2;
    ImageView ivFruit3;
    ImageView ivFruit4;
    ImageView ivFruit5;

    TextView tvFruitName1;
    TextView tvFruitName2;
    TextView tvFruitName3;
    TextView tvFruitName4;
    TextView tvFruitName5;

    TextView tvFruitPrice1;
    TextView tvFruitPrice2;
    TextView tvFruitPrice3;
    TextView tvFruitPrice4;
    TextView tvFruitPrice5;

    TextView tvFruitNumber1;
    TextView tvFruitNumber2;
    TextView tvFruitNumber3;
    TextView tvFruitNumber4;
    TextView tvFruitNumber5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
        FruitDatabases fruitDatabases = FruitApplication.getInstance().getFruitDatabases();
        List<Fruit> fruitList = fruitDatabases.loadAllFruit();
        for (int i = 0; i < fruitList.size(); i++) {
            switch (i) {
                case 0:
                    ivFruit1.setImageResource(R.drawable.apple);
                    tvFruitName1.setText(fruitList.get(0).getName());
                    tvFruitPrice1.setText(String.valueOf(fruitList.get(0).getPrice()));
                    tvFruitNumber1.setText(String.valueOf(fruitList.get(0).getNumber()) + " quả");
                    break;
                case 1:
                    ivFruit2.setImageResource(R.drawable.orange);
                    tvFruitName2.setText(fruitList.get(1).getName());
                    tvFruitPrice2.setText(String.valueOf(fruitList.get(1).getPrice()) + " đồng");
                    tvFruitNumber2.setText(String.valueOf(fruitList.get(1).getNumber()) + " quả ");
                    break;
                case 2:
                    ivFruit3.setImageResource(R.drawable.mango);
                    tvFruitName3.setText(fruitList.get(2).getName());
                    tvFruitPrice3.setText(String.valueOf(fruitList.get(2).getPrice()) + " đồng");
                    tvFruitNumber3.setText(String.valueOf(fruitList.get(2).getNumber()) + " quả");
                    break;
                case 3:
                    ivFruit4.setImageResource(R.drawable.banana);
                    tvFruitName4.setText(fruitList.get(3).getName());
                    tvFruitPrice4.setText(String.valueOf(fruitList.get(3).getPrice())  + " đồng");
                    tvFruitNumber4.setText(String.valueOf(fruitList.get(3).getNumber()) + " quả");
                    break;
                case 4:
                    ivFruit5.setImageResource(R.drawable.strawberry);
                    tvFruitName5.setText(fruitList.get(4).getName());
                    tvFruitPrice5.setText(String.valueOf(fruitList.get(4).getPrice()) + " đồng");
                    tvFruitNumber5.setText(String.valueOf(fruitList.get(4).getNumber()) + " quả");
                    break;


            }

        }

    }

    private void setupUI() {
        ivFruit1 = (ImageView) findViewById(R.id.iv_fruit_image_1);
        ivFruit2 = (ImageView) findViewById(R.id.iv_fruit_image_2);
        ivFruit3 = (ImageView) findViewById(R.id.iv_fruit_image_3);
        ivFruit4 = (ImageView) findViewById(R.id.iv_fruit_image_4);
        ivFruit5 = (ImageView) findViewById(R.id.iv_fruit_image_5);

        tvFruitName1 = (TextView) findViewById(R.id.tv_fruit_name_1);
        tvFruitName2 = (TextView) findViewById(R.id.tv_fruit_name_2);
        tvFruitName3 = (TextView) findViewById(R.id.tv_fruit_name_3);
        tvFruitName4 = (TextView) findViewById(R.id.tv_fruit_name_4);
        tvFruitName5 = (TextView) findViewById(R.id.tv_fruit_name_5);

        tvFruitPrice1 = (TextView) findViewById(R.id.tv_fruit_price_1);
        tvFruitPrice2 = (TextView) findViewById(R.id.tv_fruit_price_2);
        tvFruitPrice3 = (TextView) findViewById(R.id.tv_fruit_price_3);
        tvFruitPrice4 = (TextView) findViewById(R.id.tv_fruit_price_4);
        tvFruitPrice5 = (TextView) findViewById(R.id.tv_fruit_price_5);

        tvFruitNumber1 = (TextView) findViewById(R.id.tv_fruit_number_1);
        tvFruitNumber2 = (TextView) findViewById(R.id.tv_fruit_number_2);
        tvFruitNumber3 = (TextView) findViewById(R.id.tv_fruit_number_3);
        tvFruitNumber4 = (TextView) findViewById(R.id.tv_fruit_number_4);
        tvFruitNumber5 = (TextView) findViewById(R.id.tv_fruit_number_5);


    }
}

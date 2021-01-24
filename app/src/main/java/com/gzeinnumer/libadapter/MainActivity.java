package com.gzeinnumer.libadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.gzeinnumer.libadapter.databinding.ActivityMainBinding;
import com.gzeinnumer.libadapter.databinding.ItemRvBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
    }

    private void initView2() {
        //        LibAda<ViewBinding> libAda = new LibAda<ItemRvBinding>();
//        LibAda libAda = new LibAda(ItemRvBinding.inflate(LayoutInflater.from(getApplicationContext()), binding.getRoot(), false));
    }

    private void initView() {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            list.add(String.valueOf(i));
        }

        ViewBinding viewBinding = ItemRvBinding.inflate(LayoutInflater.from(getApplicationContext()), binding.getRoot(), false);
        RVBuilder rvBuilder =
                new RVBuilder(getApplicationContext(), viewBinding)
                        .setItems(list)
                        .setCustomNoItem(R.layout.custom_empty_data)
                        .bind(new BindViewHolder() {
                            @Override
                            public void bind(AdapterCreator.ViewHolder holder, int position) {
                                holder.binding.tv.setText(String.valueOf(position));
                                holder.itemView.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        });
        AdapterCreator adapterCreator = rvBuilder.build();

        binding.rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.rv.hasFixedSize();
        binding.rv.setAdapter(adapterCreator);


    }
}
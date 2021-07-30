package com.unity3d.player;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;

public class MenuHidroponik extends Activity {
    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu_hidroponik);
        getActionBar().hide();

        ImageButton btnBeranda = findViewById(R.id.btnBeranda);

        btnBeranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MenuHidroponik.this, btnBeranda);
                popupMenu.getMenuInflater().inflate(R.menu.item_beranda, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int itemId = menuItem.getItemId();
                        if (itemId == R.id.act1) {
                            Intent intent = new Intent(MenuHidroponik.this, MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);
                            finish();
                            return true;
                        }else if (itemId == R.id.act2) {
                            Intent intent = new Intent(MenuHidroponik.this, MainMenu.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);
                            finish();
                            return true;
                        }
                        return false;
                    }
                });
                insertMenuItemIcons(getApplicationContext(), popupMenu);
                popupMenu.show();

            }
        });

        ImageButton btnKonfigurasiPinIOT;
        btnKonfigurasiPinIOT = findViewById(R.id.btnKonfigurasiPinIOT);
        btnKonfigurasiPinIOT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), KonfigurasiPin.class);
                startActivity(intent);
            }
        });

        myDialog = new Dialog(this);


    }
    public void showPopupTentangTanaman(View v){
        Button btnBack;
        myDialog.setContentView(R.layout.h_popup_tentang_tanaman);
        btnBack = myDialog.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        myDialog.dismiss();
                    }
                }, 100);
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        myDialog.show();
    }
    public void showPopUpImplementasiIOT(View v){
        Button btnBack;
        Button btnKameraAR;
        myDialog.setContentView(R.layout.h_popup_implementasi_iot);
        btnBack = myDialog.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        myDialog.dismiss();
                    }
                }, 100);
            }
        });
        btnKameraAR = myDialog.findViewById(R.id.btnKameraAR);
        btnKameraAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        myDialog.dismiss();
                    }
                }, 100);
                Intent intent = new Intent(getApplicationContext(), UnityPlayerActivity.class);
                startActivity(intent);
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        myDialog.show();
    }
    public void showPopUpArPerakitanAlat(View v){
        Button btnBack;
        Button btnKameraAR;
        myDialog.setContentView(R.layout.h_popup_ar_perakitan_alat);
        btnBack = myDialog.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        myDialog.dismiss();
                    }
                }, 100);
            }
        });
        btnKameraAR = myDialog.findViewById(R.id.btnKameraAR);
        btnKameraAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        myDialog.dismiss();
                    }
                }, 100);
                Intent intent = new Intent(getApplicationContext(), UnityPlayerActivity.class);
                startActivity(intent);
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        myDialog.show();
    }
    /**@Override
    public void onBackPressed(){
        Intent intent = new Intent(MenuHidroponik.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();
    }**/

    /**
     * Moves icons from the PopupMenu's MenuItems' icon fields into the menu title as a Spannable with the icon and title text.
     */
    public static void insertMenuItemIcons(Context context, PopupMenu popupMenu) {
        Menu menu = popupMenu.getMenu();
        if (hasIcon(menu)) {
            for (int i = 0; i < menu.size(); i++) {
                insertMenuItemIcon(context, menu.getItem(i));
            }
        }
    }

    /**
     * @return true if the menu has at least one MenuItem with an icon.
     */
    private static boolean hasIcon(Menu menu) {
        for (int i = 0; i < menu.size(); i++) {
            if (menu.getItem(i).getIcon() != null) return true;
        }
        return false;
    }

    /**
     * Converts the given MenuItem's title into a Spannable containing both its icon and title.
     */
    private static void insertMenuItemIcon(Context context, MenuItem menuItem) {
        Drawable icon = menuItem.getIcon();

        // If there's no icon, we insert a transparent one to keep the title aligned with the items
        // which do have icons.
        if (icon == null) icon = new ColorDrawable(Color.TRANSPARENT);

        int iconSize = context.getResources().getDimensionPixelSize(R.dimen.menu_item_icon_size);
        icon.setBounds(0, 0, iconSize, iconSize);
        ImageSpan imageSpan = new ImageSpan(icon);

        // Add a space placeholder for the icon, before the title.
        SpannableStringBuilder ssb = new SpannableStringBuilder("       " + menuItem.getTitle());

        // Replace the space placeholder with the icon.
        ssb.setSpan(imageSpan, 1, 2, 0);
        menuItem.setTitle(ssb);
        // Set the icon to null just in case, on some weird devices, they've customized Android to display
        // the icon in the menu... we don't want two icons to appear.
        menuItem.setIcon(null);
    }

}
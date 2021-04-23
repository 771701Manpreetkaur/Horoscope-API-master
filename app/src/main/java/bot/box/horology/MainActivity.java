package bot.box.horology;

import android.app.AlertDialog;
import android.app.Dialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import javax.xml.datatype.Duration;

import bot.box.horology.annotation.DURATION;
import bot.box.horology.annotation.SUNSIGN;
import bot.box.horology.api.Horoscope;
import bot.box.horology.delegate.Response;
import bot.box.horology.hanshake.HorologyController;
import bot.box.horology.pojo.Zodiac;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layoutAries, layoutTaurus, layoutGemini, layoutCancer, layoutLeo, layoutVirgo, layoutLibra,
            layoutScorpio, layoutSagittarius, layoutCapricorn, layoutAquarius, layoutPisces;

    ImageView exit ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
    }

    private void initializeViews() {
        exit = findViewById(R.id.exit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder al = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme);

                al.setTitle("Horoscope App");
                al.setMessage("exit  ؟");
                al.setIcon(R.drawable.logo);
                //Log.i(TAG, "exit: "+ token);

                al.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {



                        finish();

                    }
                });
                al.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                al.show();

            }

        });

        layoutAries = (LinearLayout) findViewById(R.id.layoutAries);
        layoutAries.setOnClickListener(onClickListener);
        layoutTaurus = (LinearLayout) findViewById(R.id.layoutTaurus);
        layoutTaurus.setOnClickListener(onClickListener);
        layoutGemini = (LinearLayout) findViewById(R.id.layoutGemini);
        layoutGemini.setOnClickListener(onClickListener);
        layoutCancer = (LinearLayout) findViewById(R.id.layoutCancer);
        layoutCancer.setOnClickListener(onClickListener);
        layoutLeo = (LinearLayout) findViewById(R.id.layoutLeo);
        layoutLeo.setOnClickListener(onClickListener);
        layoutVirgo = (LinearLayout) findViewById(R.id.layoutVirgo);
        layoutVirgo.setOnClickListener(onClickListener);
        layoutLibra = (LinearLayout) findViewById(R.id.layoutLibra);
        layoutLibra.setOnClickListener(onClickListener);
        layoutScorpio = (LinearLayout) findViewById(R.id.layoutScorpio);
        layoutScorpio.setOnClickListener(onClickListener);
        layoutSagittarius = (LinearLayout) findViewById(R.id.layoutSagittarius);
        layoutSagittarius.setOnClickListener(onClickListener);
        layoutCapricorn = (LinearLayout) findViewById(R.id.layoutCapricorn);
        layoutCapricorn.setOnClickListener(onClickListener);
        layoutAquarius = (LinearLayout) findViewById(R.id.layoutAquarius);
        layoutAquarius.setOnClickListener(onClickListener);
        layoutPisces = (LinearLayout) findViewById(R.id.layoutPisces);
        layoutPisces.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.layoutAries:
                    System.out.println("here is the aries 01");
                    Horoscope hAries = new Horoscope.Zodiac(MainActivity.this)
                            .showLoader(true).showLoader(true)
                            .requestSunSign(SUNSIGN.AQUARIUS).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cAries = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            System.out.println("here is the aries 02");
                            showHoroscopeDialog(zodiac, true, "",R.drawable.h_aries,SUNSIGN.AQUARIUS,"today");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            System.out.println("here is the aries 03");
                            showHoroscopeDialog(null, false, errormsg,R.drawable.h_aries,SUNSIGN.AQUARIUS,"today");
                        }
                    });
                    cAries.requestConstellations(hAries);
                    break;

                case R.id.layoutTaurus:
                    Horoscope hTaurus = new Horoscope.Zodiac(MainActivity.this).showLoader(true)
                            .requestSunSign(SUNSIGN.TAURUS).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cTaurus = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "",R.drawable.h_taurus,SUNSIGN.TAURUS,"today");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg,R.drawable.h_taurus,SUNSIGN.TAURUS,"today");
                        }
                    });
                    cTaurus.requestConstellations(hTaurus);
                    break;


                case R.id.layoutGemini:
                    Horoscope hGemini = new Horoscope.Zodiac(MainActivity.this).showLoader(true)
                            .requestSunSign(SUNSIGN.GEMINI).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cGemini = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "",R.drawable.h_gemini,SUNSIGN.GEMINI,"today");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg,R.drawable.h_gemini,SUNSIGN.GEMINI,"today");
                        }
                    });
                    cGemini.requestConstellations(hGemini);
                    break;


                case R.id.layoutCancer:
                    Horoscope hCancer = new Horoscope.Zodiac(MainActivity.this).showLoader(true)
                            .requestSunSign(SUNSIGN.CANCER).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cCancer = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "",R.drawable.h_cancer,SUNSIGN.CANCER,"today");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg,R.drawable.h_cancer,SUNSIGN.CANCER,"today");
                        }
                    });
                    cCancer.requestConstellations(hCancer);
                    break;


                case R.id.layoutLeo:
                    Horoscope hLeo = new Horoscope.Zodiac(MainActivity.this).showLoader(true)
                            .requestSunSign(SUNSIGN.LEO).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cLeo = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "",R.drawable.h_leo,SUNSIGN.LEO,"today");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg,R.drawable.h_leo,SUNSIGN.LEO,"today");
                        }
                    });
                    cLeo.requestConstellations(hLeo);
                    break;


                case R.id.layoutVirgo:
                    Horoscope hVirgo = new Horoscope.Zodiac(MainActivity.this).showLoader(true)
                            .requestSunSign(SUNSIGN.VIRGO).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cVirgo = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "",R.drawable.h_virgo,SUNSIGN.VIRGO,"today");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg,R.drawable.h_virgo,SUNSIGN.VIRGO,"today");
                        }
                    });
                    cVirgo.requestConstellations(hVirgo);
                    break;


                case R.id.layoutLibra:
                    Horoscope hLibra = new Horoscope.Zodiac(MainActivity.this).showLoader(true)
                            .requestSunSign(SUNSIGN.LIBRA).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cLibra = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "",R.drawable.h_libra,SUNSIGN.LIBRA,"today");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg,R.drawable.h_libra,SUNSIGN.LIBRA,"today");
                        }
                    });
                    cLibra.requestConstellations(hLibra);
                    break;


                case R.id.layoutScorpio:
                    Horoscope hScorpio = new Horoscope.Zodiac(MainActivity.this).showLoader(true)
                            .requestSunSign(SUNSIGN.SCORPIO).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cScorpio = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "",R.drawable.h_scorpio,SUNSIGN.SCORPIO,"today");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg,R.drawable.h_scorpio,SUNSIGN.SCORPIO,"today");
                        }
                    });
                    cScorpio.requestConstellations(hScorpio);
                    break;


                case R.id.layoutSagittarius:
                    Horoscope hSagittarius = new Horoscope.Zodiac(MainActivity.this).showLoader(true)
                            .requestSunSign(SUNSIGN.SAGITTARIUS).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cSagittarius = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "",R.drawable.h_sagittarius,SUNSIGN.SAGITTARIUS,"today");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg,R.drawable.h_sagittarius,SUNSIGN.SAGITTARIUS,"today");
                        }
                    });
                    cSagittarius.requestConstellations(hSagittarius);
                    break;


                case R.id.layoutCapricorn:
                    Horoscope hCapricorn = new Horoscope.Zodiac(MainActivity.this).showLoader(true)
                            .requestSunSign(SUNSIGN.CAPRICORN).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cCapricorn = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "",R.drawable.h_capricorn,SUNSIGN.CAPRICORN,"today");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg,R.drawable.h_capricorn,SUNSIGN.CAPRICORN,"today");
                        }
                    });
                    cCapricorn.requestConstellations(hCapricorn);
                    break;


                case R.id.layoutAquarius:
                    Horoscope hAquarius = new Horoscope.Zodiac(MainActivity.this).showLoader(true)
                            .requestSunSign(SUNSIGN.AQUARIUS).requestDuration(DURATION.TODAY).
                                    isDebuggable(true).fetchHoroscope();
                    HorologyController cAquarius = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "",R.drawable.h_aquarius,SUNSIGN.AQUARIUS,"today");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg,R.drawable.h_aquarius,SUNSIGN.AQUARIUS,"today");
                        }
                    });
                    cAquarius.requestConstellations(hAquarius);
                    break;


                case R.id.layoutPisces:
                    Horoscope hPisces = new Horoscope.Zodiac(MainActivity.this).showLoader(true)
                            .requestSunSign(SUNSIGN.PISCES).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cPisces = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "",R.drawable.h_pisces,SUNSIGN.PISCES,"today");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg,R.drawable.h_pisces,SUNSIGN.PISCES,"today");
                        }
                    });
                    cPisces.requestConstellations(hPisces);
                    break;

            }
        }
    };

    private void showHoroscopeDialog(final Zodiac z, boolean isSuccsess, String errormsg , final int icon ,
                                     final String kind , String when ) {

        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);

        dialog.setContentView(R.layout.item_product_recycle);
        dialog.setCancelable(true);

//        YoYo.with(Techniques.FadeIn)
//                .duration(1200)
//                .repeat(0)
//                .playOn(dialog.findViewById(R.id.linRes));

        dialog.show();

        Window window = dialog.getWindow();
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        final TextView title = (TextView) dialog.findViewById(R.id.title);
        final TextView date = (TextView) dialog.findViewById(R.id.date);
        final TextView body = (TextView) dialog.findViewById(R.id.body);
        ImageView imageView = dialog.findViewById(R.id.icon);
        ImageView home = dialog.findViewById(R.id.home);
        final Button today = dialog.findViewById(R.id.today);
        final Button preview = dialog.findViewById(R.id.previous);

        if (isSuccsess) {
            title.setText(z.getSunSign());
            date.setText(z.getDate());
            body.setText(z.getHoroscope());

        } else {
            body.setText(errormsg);
        }

        if (when.equals("today")) {

            today.setAlpha(1);
            preview.setAlpha(.3f);

        }

        else {

            preview.setAlpha(1);
            today.setAlpha(.3f);

        }


        today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Horoscope hPisces = new Horoscope.Zodiac(MainActivity.this).showLoader(true)
                        .requestSunSign(kind).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                HorologyController cPisces = new HorologyController(new Response() {
                    @Override
                    public void onResponseObtained(Zodiac zodiac) {

                        showHoroscopeDialog(zodiac, true, "",icon,kind,"today");

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                dialog.dismiss();

                            }
                        },500);

                    }

                    @Override
                    public void onErrorObtained(String errormsg) {


                        showHoroscopeDialog(null, false, errormsg,icon,kind,"today");

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                dialog.dismiss();

                            }
                        },500);

                    }
                });
                cPisces.requestConstellations(hPisces);


            }
        });


        preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Horoscope hPisces = new Horoscope.Zodiac(MainActivity.this).showLoader(true)
                        .requestSunSign(kind).requestDuration(DURATION.WEEK).isDebuggable(true).
                                fetchHoroscope();
                HorologyController cPisces = new HorologyController(new Response() {
                    @Override
                    public void onResponseObtained(Zodiac zodiac) {


                        showHoroscopeDialog(zodiac, true, "",icon,kind,"yesterday");
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                dialog.dismiss();

                            }
                        },500);

                    }

                    @Override
                    public void onErrorObtained(String errormsg) {

                        showHoroscopeDialog(null, false, errormsg,icon,kind,"yesterday");
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                dialog.dismiss();

                            }
                        },500);

                    }
                });
                cPisces.requestConstellations(hPisces);

            }
        });


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        imageView.setImageResource(icon);


        dialog.show();

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder al = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme);

        al.setTitle("Horoscope App");
        al.setMessage("exit  ؟");
        al.setIcon(R.drawable.logo);
        //Log.i(TAG, "exit: "+ token);

        al.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {



                finish();

            }
        });
        al.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        al.show();

    }

}


